package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPDepartmentViewDto;
import gov.ifms.edp.dto.EDPMsDepartmentDto;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;

/**
 * The Interface EDPMsDepartmentService.
 */
public interface EDPMsDepartmentService {

	/**
	 * Returns all instances of the EDPMsDepartmentEntity type.
	 * 
	 * @return all EDPMsDepartmentEntity
	 */
	List<EDPMsDepartmentEntity> getMsDepartments();

	/**
	 * Retrieves an EDPMsDepartmentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsDepartmentEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsDepartmentEntity getMsDepartment(long id);

	/**
	 * Saves a given EDPMsDepartmentEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsDepartmentEntity
	 */
	EDPMsDepartmentEntity saveOrUpdateMsDepartment(EDPMsDepartmentEntity entity);

	/**
	 * Saves all given EDPMsDepartmentEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsDepartmentEntity> saveMsDepartments(List<EDPMsDepartmentEntity> entities);

	/**
	 * Deletes the EDPMsDepartmentEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsDepartment(long id);

	/**
	 * Fetch all the EDPMsDepartment items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsDepartmentDto>
	 */
	PagebleDTO<EDPMsDepartmentDto> edpMsDepartmentAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * Gets the department by Post id.
	 *
	 * @param PostId the Post id
	 * @return the department by Post id
	 * @throws CustomException 
	 */
	List<EDPDepartmentViewDto> getDepartmentByPostId(Long postId) throws CustomException;
	
	/**
	 * Find by office type id.
	 *
	 * @param officeTypeId the office type id
	 * @return the list
	 */
	List<EDPMsDepartmentEntity> findByOfficeTypeId(Long officeTypeId);
	
	/**
	 * Gets the all code and id.
	 *
	 * @return the all code and id
	 */
	List<ClueDto> getAllCodeAndId();
}
