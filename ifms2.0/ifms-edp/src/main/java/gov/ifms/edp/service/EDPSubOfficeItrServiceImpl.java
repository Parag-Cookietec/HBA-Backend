package gov.ifms.edp.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPSubOfficeItrConverter;
import gov.ifms.edp.dto.EDPMsSubOfficeDto;
import gov.ifms.edp.entity.EDPSubOfficeItrEntity;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPSubOfficeItrRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPSubOfficeItrServiceImpl.
 */
@Service
public class EDPSubOfficeItrServiceImpl implements EDPSubOfficeItrService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPsubOfficeItrAsMethodName repository. */
	@Autowired
	private EDPSubOfficeItrRepository repository;

	/** The EDPsubOfficeItrAsMethodName helper. */
	@Autowired
	private EDPSubOfficeItrConverter converter;
	
	@Autowired
	private EDPMsOfficeService officeService;
	
	/**
	 * Retrieves an EDPsubOfficeItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPsubOfficeItrEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPSubOfficeItrEntity getsubOfficeItr(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPsubOfficeItrEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPsubOfficeItrEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPSubOfficeItrEntity saveOrUpdatesubOfficeItr(EDPSubOfficeItrEntity entity) throws CustomException {
		try {
			return repository.save(entity);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Deletes the EDPsubOfficeItrEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws CustomException 
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deletesubOfficeItr(long id, int isDelete) throws CustomException {
		try {
			this.repository.updateActiveStatusBySubOfficeId(id, isDelete, OAuthUtility.getCurrentUserUserId(),
					new Date());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Fetch all the EDPsubOfficeItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPsubOfficeItrDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPMsSubOfficeDto> getsubOfficeItrs(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			pageDetail.setSortByColumn("updatedDate");
			pageDetail.setSortOrder("DESC");
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPSubOfficeItrEntity> spec = new SpecificationImpl<>();
			Optional<SearchParam> officeId = pageDetail.getJsonArr().stream()
					.filter(parm -> parm.getKey().equals(EDPConstant.OFFICE_ID_OFFICE_ID)).findFirst();
			if(officeId.isPresent()) {
				EDPUpdateOfficeTrnEntity trnEntity=officeService.getLastOfficeTrn(Long.parseLong(officeId.get().getValue()), Constant.ACTIVE_STATUS);
				if(null!=trnEntity) {
					SearchParam sp=new SearchParam();
					sp.setKey("officeTrnEntity.updOffcTrnId");
					sp.setValue(trnEntity.getUpdOffcTrnId().toString());
					pageDetail.getJsonArr().add(sp);
				}
			}
			
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPSubOfficeItrEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPSubOfficeItrEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTOs(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
