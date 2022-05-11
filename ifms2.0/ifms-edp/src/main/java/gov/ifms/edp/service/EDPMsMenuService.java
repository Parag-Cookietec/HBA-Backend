package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.dto.EDPMsRolePermissionsDto;
import gov.ifms.edp.entity.EDPMsMenuEntity;

/**
 * The Interface EDPMsMenuService.
 */
public interface EDPMsMenuService {

	/**
	 * Returns all instances of the EDPMsMenuEntity type.
	 * 
	 * @return all EDPMsMenuEntity
	 */
	List<EDPMsMenuEntity> getMsMenus();

	/**
	 * Retrieves an EDPMsMenuEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsMenuEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsMenuEntity getMsMenu(Long id);

	/**
	 * Saves a given EDPMsMenuEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsMenuEntity
	 */
	EDPMsMenuEntity saveOrUpdateMsMenu(EDPMsMenuEntity entity);

	/**
	 * Saves all given EDPMsMenuEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsMenuEntity> saveMsMenus(List<EDPMsMenuEntity> entities);

	/**
	 * Deletes the EDPMsMenuEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsMenu(Long id);

	/**
	 * Fetch all the EDPMsMenu items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsMenuDto>
	 */
	PagebleDTO<EDPMsMenuDto> edpMsMenuAsMethodNameSearch(PageDetails pageDetail);
	
    /**
     * Gets the ms menu by sub module id.
     *
     * @param subModuleId the sub module id
     * @return the ms menu by sub module id
     */
    List<EDPMsMenuEntity> getMsMenuBySubModuleId(Long subModuleId);
    
    /**
     * Gets the permission by menu and post id.
     *
     * @param postId the post id
     * @return the permission by menu and post id
     * @throws CustomException the custom exception
     */
    List<EDPMsRolePermissionsDto> getPermissionByMenuAndPostId(Long postId) throws CustomException;
    
    /**
     * Gets the ms menu by module id.
     *
     * @param subModuleId the sub module id
     * @return the ms menu by module id
     */
    List<EDPMsMenuEntity> getMsMenuByModuleId(Long subModuleId);
}
