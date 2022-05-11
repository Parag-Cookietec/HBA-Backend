package gov.ifms.edp.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.FieldDto;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPEmployeePostSearchView;
import gov.ifms.edp.dto.EDPMsUserDto;
import gov.ifms.edp.dto.EDPMsUserPasswordResetDisplayDto;
import gov.ifms.edp.dto.EDPUserRightsDto;
import gov.ifms.edp.dto.MinisterUserReqDto;
import gov.ifms.edp.dto.UserDto;
import gov.ifms.edp.entity.EDPMsUserEntity;

/**
 * The Interface EDPMsUserService.
 */
public interface EDPMsUserService {

	/**
	 * Returns all instances of the EDPMsUserEntity type.
	 * 
	 * @return all EDPMsUserEntity
	 */
	List<EDPMsUserEntity> getMsUsers();

	/**
	 * Retrieves an EDPMsUserEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsUserEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsUserEntity getMsUser(Long id);

	/**
	 * Saves a given EDPMsUserEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsUserEntity
	 */
	EDPMsUserEntity saveOrUpdateMsUser(EDPMsUserEntity entity);

	/**
	 * Saves all given EDPMsUserEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsUserEntity> saveMsUsers(List<EDPMsUserEntity> entities);

	/**
	 * Deletes the EDPMsUserEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsUser(Long id);

	/**
	 * Fetch all the EDPMsUser items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsUserDto>
	 */
	PagebleDTO<EDPMsUserDto> edpMsUserAsMethodNameSearch(PageDetails pageDetail);
	
	/**
	 * Gets the dependent uer id by user id.
	 *
	 * @param userId the user id
	 * @return the dependent uer id by user id
	 */
	List<IdDto> getDependentUerIdByUserId(Long userId);

	/**
	 * Get By UserName and password.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findUserByNameAndPassword(String userName,String password);
	
	/**
	 * Get By UserName.
	 *
	 * @param userName the user name
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findUserByName(String userName);


	/**
	 * Gets the ms user by post id.
	 *
	 * @param id the id
	 * @return the ms user by post id
	 */
	List<EDPMsUserEntity> getMsUserByPostId(Long id);
	
	/**
	 * Gets the all code and id.
	 *
	 * @return the all code and id
	 */
	public List<ClueDto> getAllCodeAndId();
	
	/**
	 * Find user by user code.
	 *
	 * @param userCode the user code
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findUserByUserCode(Long userCode);
	
	
	/**
	 * Find user by user code and password.
	 *
	 * @param userCode the user code
	 * @param password the password
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findUserByUserCodeAndPassword(String userCode,String password);
	
	
	
	/**
	 * Find employee for reset password.
	 *
	 * @param userCode the user code
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPMsUserPasswordResetDisplayDto> findUserforResetpwd(Long userCode) throws CustomException;
	
	
	/**
	 * Reset password.
	 *
	 * @param fieldDto the field dto
	 * @param resetPwdFlag the reset pwd flag
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	public boolean resetPassword(FieldDto fieldDto, Boolean resetPwdFlag) throws CustomException;

	
	/**
	 * Find all usersfor globle password.
	 *
	 * @param id the id
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPMsUserPasswordResetDisplayDto> findAllUsersforGloblePassword(Long id) throws CustomException;

	/**
	 * Gets the edp employee post by emp no.
	 *
	 * @param empNo the emp no
	 * @param officeId the office id
	 * @return the edp employee post by emp no
	 * @throws CustomException the custom exception
	 */
	List<EDPEmployeePostSearchView> getEdpEmployeePostByEmpNo(Long empNo,Long officeId) throws CustomException;

	/**
	 * Gets the user rights.
	 *
	 * @param lkPouId the lk pou id
	 * @return the user rights
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getUserRights(Long lkPouId) throws CustomException;
	
	/**
	 * Gets the Saved User rights.
	 *
	 * @param id the id
	 * @param isRequestForApproved the is request for approved
	 * @return the user rights
	 * @throws CustomException the custom exception
	 */
	
	List<EDPUserRightsDto> getSavedUserRights(Long id, Boolean isRequestForApproved) throws CustomException;
	
	
	
	/**
	 * Find by user code ignore case.
	 *
	 * @param userCode the user code
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findByUserCode(Long userCode);
	
	/**
	 * Gets the user photo by user id.
	 *
	 * @param userId the user id
	 * @return the user photo by user id
	 * @throws CustomException the custom exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	ClueDto  getUserPhotoByUserId(Long userId) throws CustomException, IOException;

	/**
	 * Gets the work flows for menu.
	 *
	 * @param id the id
	 * @param menuId the menu id
	 * @param isRequestForApproved the is request for approved
	 * @return the work flows for menu
	 * @throws CustomException the custom exception
	 */
	Map<String, Object> getWorkFlowsForMenu(Long id, Long menuId, Boolean isRequestForApproved) throws CustomException;

	/**
	 * Gets the minister wf user.
	 *
	 * @param dto the dto
	 * @return the minister wf user
	 * @throws CustomException the custom exception
	 */
	List<UserDto> getMinisterWfUser(MinisterUserReqDto dto) throws CustomException;


	/**
	 * Check has existing rights mapping request.
	 *
	 * @param postOfficeUserId the post office user id
	 * @throws CustomException the custom exception
	 */
	void checkHasExistingRightsMappingRequest(Long postOfficeUserId) throws CustomException;
}
