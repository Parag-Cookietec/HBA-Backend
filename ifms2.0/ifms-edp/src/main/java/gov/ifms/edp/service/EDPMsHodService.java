package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsHodDto;
import gov.ifms.edp.entity.EDPMsHodEntity;

/**
 * The Interface EDPMsHodService.
 */
public interface EDPMsHodService {
	/**
	 * Retrieves an EDPMsHodEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsHodEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsHodEntity getMsHod(Long id);

	/**
	 * Saves a given EDPMsHodEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsHodEntity
	 */
	public EDPMsHodEntity saveOrUpdateMsHod(EDPMsHodEntity entity);

	/**
	 * Saves all given EDPMsHodEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteMsHod(long id, int isDelete);

	/**
	 * Fetch all the EDPMsHod items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsHodDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPMsHodDto> getMsHods(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Gets the hod by department id.
	 *
	 * @param departmentId the department id
	 * @return the hod by department id
	 * @throws CustomException the custom exception
	 */
	public List<ClueDto> getHodByDepartmentId(Long departmentId) throws CustomException;
}
