package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.dto.UserDto;
import gov.ifms.edp.entity.EDPMsUserEntity;

/**
 * The Interface EDPMsUserRepository.
 */
@Repository
@Transactional
public interface EDPMsUserRepository extends JpaRepository<EDPMsUserEntity, Long>, JpaSpecificationExecutor<EDPMsUserEntity>, GenericDao {

	/**
	 * Find by user name containing ignore case and password.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findByUserNameContainingIgnoreCaseAndPassword(String userName, String password);

	/**
	 * Find by user name containing ignore case.
	 *
	 * @param userName the user name
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findByUserNameContainingIgnoreCase(String userName);

	/**
	 * Find code and id.
	 *
	 * @return the list
	 */
	@Query(value = "select bmde.userId,bmde.userName from EDPMsUserEntity bmde")
	public List<Object[]> findCodeAndId();

	/**
	 * Find by user code ignore case.
	 *
	 * @param userCode the user code
	 * @return the EDP ms user entity
	 */
	Optional<EDPMsUserEntity> findByUserCode(Long userCode);

	/**
	 * Find by user code ignore case and password.
	 *
	 * @param userCode the user code
	 * @param password the password
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findByUserCodeAndPassword(Long userCode, String password);

	/**
	 * Find by user code ignore case.
	 *
	 * @param userCode the user code
	 * @param activeStatus the active status
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findByUserCodeAndActiveStatus(Long userCode, int activeStatus);

	/**
	 * Find by user code ignore case and password.
	 *
	 * @param userCode the user code
	 * @param password the password
	 * @param activeStatus the active status
	 * @return the EDP ms user entity
	 */
	EDPMsUserEntity findByUserCodeAndPasswordAndActiveStatus(Long userCode, String password, int activeStatus);

	/**
	 * Update user password.
	 *
	 * @param password the password
	 * @param passwordchangedate the passwordchangedate
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @param updatedbypost the updatedbypost
	 * @param userId the user id
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPMsUserEntity set password= :password, updatedBy=:updatedBy , pwdChangedDate=:passwordchangedate ,updatedByPost=:updatedbypost, updatedDate=:updatedDate   where userId = :userId")
	public int updateUserPassword(@Param("password") String password, @Param("passwordchangedate") Date passwordchangedate,
								  @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate, @Param("updatedbypost") long updatedbypost,
								  @Param("userId") long userId);

	@Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.userId, e.userName) from EDPMsUserEntity e where e.userId = :id")
	IdNameDto getOnlyIdAndName(@Param("id") Long id);
	
	/**
	 * Update active status.
	 *
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @param updatedbypost the updatedbypost
	 * @param userId the user id
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPMsUserEntity set activeStatus= :activeStatus, updatedBy=:updatedBy , updatedByPost=:updatedbypost, updatedDate=:updatedDate where userId = :userId")
	public int updateActiveStatus(@Param("activeStatus") int activeStatus, @Param("updatedBy") Long updatedBy, 
			@Param("updatedDate") Date updatedDate, @Param("updatedbypost") Long updatedbypost,@Param("userId") Long userId);

	@Query(value = "SELECT new gov.ifms.edp.dto.UserDto(tumwr.lkUserMenuId.poOffUserId.userId.userId,tumwr.lkUserMenuId.poOffUserId.userId.userName,tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId, tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId,tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId,tumwr.workflowRoleId ,(select postName  from  EDPMsPostEntity where postId = tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId)) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :ministerWfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus")
	List<UserDto> findMisterUserByNextMinisterRole(@Param("officeId") long officeId , @Param("menuId") long menuId, @Param("ministerWfRoleId") long nextWfRoleId, @Param("activeStatus") int activeStatus);
	
	@Query(value = " SELECT LK_PO_OFF_USER_ID  FROM master_V1.MS_MINISTER_IN_CHARGE WHERE MS_MINI_IN_CHARGE_ID = :ministerId and  ACTIVE_STATUS =:activeStatus " , nativeQuery = true )
	Long getPOUIdBasedOnMinister(@Param("ministerId") long ministerId , @Param("activeStatus") int activeStatus);

}
