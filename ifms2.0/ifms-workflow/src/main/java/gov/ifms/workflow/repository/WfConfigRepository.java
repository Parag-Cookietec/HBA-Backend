package gov.ifms.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.WfConfigEntity;
/**
 * The Class MsWorkflowRepository.
 * 
 * @version 1.0
 * @created 2019/08/29 16:52:45
 */
public interface WfConfigRepository extends JpaRepository<WfConfigEntity,Long> , 
                  JpaSpecificationExecutor<WfConfigEntity> {

	/**
	 * Find WorkflowRuleId And WfActions
	 *
	 * @param officeTypeId
	 * @param wfRoleId
	 * @param menuId
	 * @param validWfActionId
	 * @param actionLevel
	 * @return the list
	 */
	@Query(value = "select wfrule from WfConfigEntity wfrule where officeTypeId.lookUpInfoId = :officeTypeId and msWorkflowRoleEntity.wfRoleId = :wfRoleId and wfrule.actionLevel = :actionLevel and menuId = :menuId and msWorkflowActionEntity.validWfActionId = :validWfActionId")
	List<WfConfigEntity> findWorkflowRuleIdAndWfActions(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel);

	/**
	 * verifyUserWfRole
	 *
	 * @param userId
	 * @param postId
	 * @param officeId
	 * @param menuId
	 * @param wfRoleId
	 * @param activeStatus
	 * @return the long
	 */
	@Trace
	@Query(value = "SELECT COUNT(tumwr.trnUsrWfRoleId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :wfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.userId.userId = :userId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId = :postId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.userId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus")
	Long verifyUserWfRole(@Param("userId") long userId, @Param("postId") long postId, @Param("officeId") long officeId,
			@Param("menuId") long menuId, @Param("wfRoleId") long wfRoleId, @Param("activeStatus") int activeStatus);

	/**
	 * verifyUserWfRole
	 *
	 * @param menuId
	 * @param wfRoleId
	 * @param activeStatus
	 * @param lkPOUId
	 * @return the long
	 */
	@Trace
	@Query(value = "SELECT COUNT(tumwr.trnUsrWfRoleId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :wfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId = :lkPOUId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.activeStatus = :activeStatus")
	Long verifyUserWfRole(@Param("menuId") long menuId, @Param("wfRoleId") long wfRoleId, @Param("activeStatus") int activeStatus, @Param("lkPOUId") Long lkPOUId);

	/**
	 * Find UserByNextWfRole
	 *
	 * @param officeId
	 * @param menuId
	 * @param nextWfRoleId
	 * @param activeStatus
	 * @return the list
	 */
	@Query(value = "SELECT new gov.ifms.workflow.dto.WfUserDto(tumwr.lkUserMenuId.poOffUserId.userId.userId,tumwr.lkUserMenuId.poOffUserId.userId.userName,tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId, tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId,tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :nextWfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus")
	List<WfUserDto> findUserByNextWfRole(@Param("officeId") long officeId, @Param("menuId") long menuId, @Param("nextWfRoleId") long nextWfRoleId, @Param("activeStatus") int activeStatus);

	/**
	 * Find WfInitWfRoleId
	 *
	 * @param menuId
	 * @param activeStatus
	 * @param officeTypeId
	 * @return the long
	 */
	@Query(value = "SELECT wf.wfInitWfRoleId FROM WfConfigEntity wf WHERE wf.menuId = :menuId AND wf.activeStatus = :activeStatus and officeTypeId.lookUpInfoId =:officeTypeId AND wf.wfInitWfRoleId IS NOT NULL")
	Long findWfInitWfRoleId(@Param("menuId") long menuId, @Param("activeStatus") int activeStatus, @Param("officeTypeId") long officeTypeId);

	/**
	 * Find distinct by menu id.
	 *
	 * @param menuId the menu id
	 * @return the list
	 */
	List<WfConfigEntity> findDistinctByMenuId(long menuId);

	/**
	 * find User By NextWfRoleUser Exclude
	 *
	 * @param officeId
	 * @param menuId
	 * @param nextWfRoleId
	 * @param activeStatus
	 * @param userId
	 * @return the list
	 */
	@Query(value = "SELECT new gov.ifms.workflow.dto.WfUserDto(tumwr.lkUserMenuId.poOffUserId.userId.userId,tumwr.lkUserMenuId.poOffUserId.userId.userName,tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId, tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :nextWfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus and tumwr.lkUserMenuId.poOffUserId.userId.userId NOT IN (:userId)")
	List<WfUserDto> findUserByNextWfRoleUserExclude(@Param("officeId") long officeId, @Param("menuId") long menuId, @Param("nextWfRoleId") long nextWfRoleId, @Param("activeStatus") int activeStatus ,@Param("userId") List<Long> userId);

}
