package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPEmpByOffIdDto;
import gov.ifms.edp.dto.EDPGetPostByMenuOffIdViewDto;
import gov.ifms.edp.dto.EDPGetWfRoleByMenuIdViewDto;
import gov.ifms.edp.dto.EDPLkModuleOfficeDto;
import gov.ifms.edp.dto.EDPMenuUserRightsAndRolesViewDto;
import gov.ifms.edp.dto.EDPRightsMappingDto;
import gov.ifms.edp.dto.EdpURMHeaderView;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;

/**
 * The Interface EDPUserRoleMappingService.
 */
public interface EDPUserRoleMappingService {
	/**
	 * Retrieves an EDPUserRoleMappingEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPUserRoleMappingEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPUserRoleMappingEntity getUserRoleMapping(Long id);

	
	/**
	 * Save user role mapping.
	 *
	 * @param dto the dto
	 * @return the EDP rights mapping dto
	 * @throws CustomException the custom exception
	 */
	public EDPMenuUserRightsAndRolesViewDto saveUserRoleMapping(EDPRightsMappingDto dto) throws CustomException;

	/**
	 * Saves all given EDPUserRoleMappingEntity entities.
	 *
	 * @param pageDetail the page detail
	 * @return the saved entities
	 * @throws CustomException the custom exception
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	/**
	 * Fetch all the EDPUserRoleMapping items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPUserRoleMappingDto>
	 */
	public PagebleDTO<EdpURMHeaderView> getUserRoleMappings(PageDetails pageDetail) throws CustomException;
	

	/**
	 * Gets the emp by office id.
	 *
	 * @param officeId the office id
	 * @return the emp by office id
	 * @throws CustomException the custom exception
	 */
	public List<EDPEmpByOffIdDto> getEmpByOfficeId(long officeId) throws CustomException;

	/**
	 * Update rg map by emp id and po off id.
	 *
	 * @param oldUserId the old user id
	 * @param oldPoOffUserId the old po off user id
	 * @param newUserId the new user id
	 * @param newPoOffUserId the new po off user id
	 * @throws CustomException the custom exception
	 */
	void updateRgMapByEmpIdAndPoOffId(long oldUserId, long oldPoOffUserId, long newUserId, long newPoOffUserId) throws CustomException;

	/**
	 * Gets the wf by menu id.
	 *
	 * @param menuId the menu id
	 * @return the wf by menu id
	 * @throws CustomException the custom exception
	 */
	List<EDPGetWfRoleByMenuIdViewDto> getWfByMenuId(Long menuId) throws CustomException;
	
	/**
	 * Gets the district by state id.
	 *
	 * @return the district wise office details
	 */
	List<ClueDto> getDistrictByStateId();

	/**
	 * Gets the sub modules or menu.
	 *
	 * @param modOffTypeId the mod off type id
	 * @return the sub modules or menu
	 * @throws CustomException the custom exception
	 */
	ClueDto getSubModulesOrMenu(Long modOffTypeId) throws CustomException;

	/**
	 * Gets the menus for submodule.
	 *
	 * @param modOffTypeId the mod off type id
	 * @param subModuleId the sub module id
	 * @return the menus for submodule
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getMenusForSubmodule(Long modOffTypeId, Long subModuleId) throws CustomException;
	
	/**
	 * Gets the approve user rights.
	 *
	 * @param lkpostOffUserId the lkpost off user id
	 * @return the approve user rights
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getApproveUserRights(Long lkpostOffUserId) throws CustomException;
	
	/**
	 * Gets the saved user rights.
	 *
	 * @param userRoleMappingId the user role mapping id
	 * @return the saved user rights
	 * @throws CustomException the custom exception
	 */
	EDPMenuUserRightsAndRolesViewDto getSavedUserRights(Long userRoleMappingId) throws CustomException;


	/**
	 * De active old transction listby rg map id.
	 *
	 * @param rgMapId the rg map id
	 * @throws CustomException the custom exception
	 */
	void deActiveOldTransctionListbyRgMapId(Long rgMapId) throws CustomException;


	/**
	 * Delete user role mappings.
	 *
	 * @param rgMapId the rg map id
	 * @throws CustomException the custom exception
	 */
	void deleteUserRoleMappings(Long rgMapId) throws CustomException;


	/**
	 * Gets the post by menu off id.
	 *
	 * @param menuId the menu id
	 * @param officeId the office id
	 * @param wfRoleIds the wf role ids
	 * @return the post by menu off id
	 * @throws CustomException the custom exception
	 */
	List<EDPGetPostByMenuOffIdViewDto> getPostByMenuOffId(Long menuId, Long officeId, String wfRoleIds)
			throws CustomException;


	/**
	 * Gets the modules for office type.
	 *
	 * @param officeId the office id
	 * @return the modules for office type
	 * @throws CustomException the custom exception
	 */
	List<EDPLkModuleOfficeDto> getModulesForOfficeType(Long officeId) throws CustomException;

	/**
	 * Gets the menu office details.
	 *
	 * @param menuId the menu id
	 * @param officeId the office id
	 * @param moduleId the module id
	 * @param subModuleId the sub module id
	 * @return the menu office details
	 */
	ClueDto getMenuOfficeDetails(Long menuId, Long officeId, Long moduleId, Long subModuleId);


	/**
	 * Checks if is workflow required.
	 *
	 * @param officeId the office id
	 * @param userId the user id
	 * @return the boolean
	 */
	public Boolean isWorkflowRequired();
	
	/**
	 * Gets the listing filter data.
	 *
	 * @return the listing filter data
	 */
	ClueDto getListingFilterData();


}
