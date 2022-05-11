package gov.ifms.edp.service;

import java.util.List;
import java.util.stream.Collectors;

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
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPMsHodConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsHodDto;
import gov.ifms.edp.entity.EDPMsHodEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPMsHodRepository;

/**
 * The Class EDPMsHodServiceImpl.
 */
@Service
public class EDPMsHodServiceImpl implements EDPMsHodService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPMsHodAsMethodName repository. */
	@Autowired
	private EDPMsHodRepository repository;

	/** The EDPMsHodAsMethodName helper. */
	@Autowired
	private EDPMsHodConverter converter;
	
	/** The edp ms office service impl. */
	@Autowired
	private EDPMsOfficeServiceImpl edpMsOfficeServiceImpl;

	/**
	 * Retrieves an EDPMsHodEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsHodEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsHodEntity getMsHod(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsHodEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsHodEntity
	 */
	@Override
	public EDPMsHodEntity saveOrUpdateMsHod(EDPMsHodEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPMsHodEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteMsHod(long id, int isDelete) {
		repository.deleteMsHod(id, isDelete, OAuthUtility.getCurrentUserUserId(), new java.util.Date());
	}

	/**
	 * Fetch all the EDPMsHod items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsHodDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPMsHodDto> getMsHods(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPMsHodEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPMsHodEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPMsHodEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the hod by department id.
	 *
	 * @param departmentId the department id
	 * @return the hod by department id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<ClueDto> getHodByDepartmentId(Long departmentId) throws CustomException {
		if(departmentId!= null)
			/* Change Accoding New DB Change */
			return edpMsOfficeServiceImpl.getByDepartmentsWithHod(departmentId);
		else
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
	}

	/**
	 * Gets the hods clue dto.
	 *
	 * @param entityList the entity list
	 * @return the hods clue dto
	 */
	public List<ClueDto> getHodsClueDto(List<EDPMsHodEntity>  entityList) {
		return entityList.stream().map(this::getHodsClueDto).collect(Collectors.toList());
	}

	/**
	 * Gets the hods clue dto.
	 *
	 * @param entity the entity
	 * @return the hods clue dto
	 */
	public ClueDto getHodsClueDto(EDPMsHodEntity entity) {
		ClueDto clueDto = new ClueDto();
		clueDto.setId(entity.getHodId());
		clueDto.setName(entity.getHodName());
		return clueDto;
	}

}
