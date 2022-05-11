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
import gov.ifms.edp.converter.EDPLkPuoDeptBncHodConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPLkPuoDeptBncHodDto;
import gov.ifms.edp.entity.EDPLkPuoDeptBncHodEntity;
import gov.ifms.edp.repository.EDPLkPuoDeptBncHodRepository;

/**
 * The Class EDPLkPuoDeptBncHodServiceImpl.
 */
@Service
public class EDPLkPuoDeptBncHodServiceImpl implements EDPLkPuoDeptBncHodService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPLkPuoDeptBncHodAsMethodName repository. */
	@Autowired
	private EDPLkPuoDeptBncHodRepository repository;

	/** The EDPLkPuoDeptBncHodAsMethodName helper. */
	@Autowired
	private EDPLkPuoDeptBncHodConverter converter;

	/**
	 * Retrieves an EDPLkPuoDeptBncHodEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLkPuoDeptBncHodEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPLkPuoDeptBncHodEntity getLkPuoDeptBncHod(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPLkPuoDeptBncHodEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLkPuoDeptBncHodEntity
	 */
	@Override
	public EDPLkPuoDeptBncHodEntity saveOrUpdateLkPuoDeptBncHod(EDPLkPuoDeptBncHodEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPLkPuoDeptBncHodEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteLkPuoDeptBncHod(long id, int isDelete) {
		/** Delete Function */
	}

	/**
	 * Fetch all the EDPLkPuoDeptBncHod items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPuoDeptBncHodDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPLkPuoDeptBncHodDto> getLkPuoDeptBncHods(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPLkPuoDeptBncHodEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPLkPuoDeptBncHodEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPLkPuoDeptBncHodEntity> page = repository.findAll(dataSpec, pageable);

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
		List<EDPLkPuoDeptBncHodEntity> entityList = repository.findByDepartmentIdDepartmentId(departmentId);
		return getHodsClueDto(entityList);
	}

	/**
	 * Gets the hods clue dto.
	 *
	 * @param entityList the entity list
	 * @return the hods clue dto
	 */
	public List<ClueDto> getHodsClueDto(List<EDPLkPuoDeptBncHodEntity> entityList) {
		return entityList.stream().map(this::getHodsClueDto).collect(Collectors.toList());
	}

	/**
	 * Gets the hods clue dto.
	 *
	 * @param entity the entity
	 * @return the hods clue dto
	 */
	public ClueDto getHodsClueDto(EDPLkPuoDeptBncHodEntity entity) {
		ClueDto clueDto = new ClueDto();
		clueDto.setId(entity.getHodNameId().getEmpId());
		clueDto.setName(entity.getHodNameId().getEmployeeName());
		return clueDto;
	}

}