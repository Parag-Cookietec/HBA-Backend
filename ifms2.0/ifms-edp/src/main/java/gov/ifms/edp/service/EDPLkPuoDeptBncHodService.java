package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPLkPuoDeptBncHodDto;
import gov.ifms.edp.entity.EDPLkPuoDeptBncHodEntity;

/**
 * The Interface EDPLkPuoDeptBncHodService.
 */
public interface EDPLkPuoDeptBncHodService {
	
	/**
	 * Retrieves an EDPLkPuoDeptBncHodEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLkPuoDeptBncHodEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPLkPuoDeptBncHodEntity getLkPuoDeptBncHod(Long id);

	/**
	 * Saves a given EDPLkPuoDeptBncHodEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLkPuoDeptBncHodEntity
	 */
	public EDPLkPuoDeptBncHodEntity saveOrUpdateLkPuoDeptBncHod(EDPLkPuoDeptBncHodEntity entity);

	/**
	 * Saves all given EDPLkPuoDeptBncHodEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteLkPuoDeptBncHod(long id, int isDelete);

	/**
	 * Fetch all the EDPLkPuoDeptBncHod items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPuoDeptBncHodDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPLkPuoDeptBncHodDto> getLkPuoDeptBncHods(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Gets the hod by department id.
	 *
	 * @param departmentId the department id
	 * @return the hod by department id
	 * @throws CustomException the custom exception
	 */
	public List<ClueDto> getHodByDepartmentId(Long departmentId) throws CustomException;
}
