package gov.ifms.pvu.edp;

import java.util.List;

import gov.ifms.common.exception.CustomException;
/**
 * The Class EDPMsHeadDepartmentController.
 * 
 * @version v 1.0
 * @created 2020/01/15 15:35:39
 *
 */
public interface EDPMsHeadDepartmentService {
	/**
	 * Retrieves an EDPMsHeadDepartmentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsHeadDepartmentEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsHeadDepartmentEntity getMsHeadDepartment(Long id);

	/**
	 * Saves a given EDPMsHeadDepartmentEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsHeadDepartmentEntity
	 */
	public EDPMsHeadDepartmentEntity saveOrUpdateMsHeadDepartment(EDPMsHeadDepartmentEntity entity);


	
	/**
	 * Fetch all the EDPMsHeadDepartment items with pagination.
	 *
	 * @param id the page detail
	 * @return List<EDPMsHeadDepartmentDto>
	 */
	public List<EDPMsHeadDepartmentDto> getMsHeadDepartments(long id) throws CustomException;

}
