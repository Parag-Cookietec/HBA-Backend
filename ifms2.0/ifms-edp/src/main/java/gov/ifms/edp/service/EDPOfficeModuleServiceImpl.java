package gov.ifms.edp.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPOfficeModuleConverter;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPOfficeModuleDto;
import gov.ifms.edp.entity.EDPOfficeModuleEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPOfficeModuleRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPOfficeModuleServiceImpl.
 */
@Service
public class EDPOfficeModuleServiceImpl implements EDPOfficeModuleService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPOfficeModuleAsMethodName repository. */
	@Autowired
	private EDPOfficeModuleRepository repository;

	/** The EDPOfficeModuleAsMethodName helper. */
	@Autowired
	private EDPOfficeModuleConverter converter;

	/**
	 * Retrieves an EDPOfficeModuleEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPOfficeModuleEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPOfficeModuleEntity getOfficeModule(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPOfficeModuleEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPOfficeModuleEntity
	 */
	@Override
	public EDPOfficeModuleEntity saveOrUpdateOfficeModule(EDPOfficeModuleEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPOfficeModuleEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteOfficeModule(long id, int isDelete) {
//		delete repo
	}

	/**
	 * Fetch all the EDPOfficeModule items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPOfficeModuleDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPOfficeModuleDto> getOfficeModules(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPOfficeModuleEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPOfficeModuleEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPOfficeModuleEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Update active status.
	 *
	 * @param officeId the office id
	 */
	private void updateActiveStatus(Long officeId) {
		repository.updateActiveStatusByOfficeId(officeId, EDPConstant.INACTIVE_STATUS,
				OAuthUtility.getCurrentUserUserId(), new Date());
	}

	/**
	 * Save office id and module id.
	 *
	 * @param dto the dto
	 */
	public void saveOfficeIdAndModuleId(EDPMsOfficeDto dto) {
		if (!CollectionUtils.isEmpty(dto.getModuleId())) {
			updateActiveStatus(dto.getOfficeId());
			List<EDPOfficeModuleEntity> edpOfficeModuleEntityList = dto.getModuleId().stream().map(entity->{
				EDPOfficeModuleEntity edpOfficeModuleEntity = new EDPOfficeModuleEntity();
				edpOfficeModuleEntity.setModuleId(entity);
				edpOfficeModuleEntity.setOfficeId(dto.getOfficeId());
				return edpOfficeModuleEntity;
			}).collect(Collectors.toList());
			repository.saveAll(edpOfficeModuleEntityList);
		}
	}
}
