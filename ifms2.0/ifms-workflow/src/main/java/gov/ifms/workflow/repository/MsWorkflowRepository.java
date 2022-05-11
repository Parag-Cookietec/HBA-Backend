package gov.ifms.workflow.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.MsWorkflowEntity;
/**
 * The Class MsWorkflowRepository.
 * 
 * @version 1.0
 * @created 2019/08/29 16:52:45
 */
public interface MsWorkflowRepository extends JpaRepository<MsWorkflowEntity,Long> , 
                  JpaSpecificationExecutor<MsWorkflowEntity> {

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
	@Query(value = "select wfrule from MsWorkflowEntity wfrule where officeTypeId.lookUpInfoId = :officeTypeId and msWorkflowRoleEntity.wfRoleId = :wfRoleId and wfrule.actionLevel = :actionLevel and menuId = :menuId and msWorkflowActionEntity.validWfActionId = :validWfActionId")
	List<MsWorkflowEntity> findWorkflowRuleIdAndWfActions(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel);

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
	//@Query(value = "SELECT new gov.ifms.workflow.dto.WfUserDto(tumwr.lkUserMenuId.poOffUserId.userId.userId,tumwr.lkUserMenuId.poOffUserId.userId.userName,tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId, tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId,tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :nextWfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.isVacant=1")
	@Query(value = "SELECT pou.user_id, mu.USER_CODE || ' - ' || me.EMPLOYEE_NAME || ' ' || DECODE (TRIM(me.MIDDLE_GUARDIAN_NAME),'','',TRIM(me.MIDDLE_GUARDIAN_NAME) || ' ') || DECODE (TRIM(me.SURNAME),'','',TRIM(me.SURNAME) || ' ') || '(' ||mp.POST_NAME || ')', po.post_id, po.office_id, um.lk_po_off_user_id, NULL, tumwr.wf_role_id, 0, mp.POST_NAME FROM master_v1.trn_usr_mnu_wf_role tumwr JOIN master_v1.lk_user_menu um ON tumwr.LK_USER_MENU_ID=um.LK_USER_MENU_ID JOIN master_v1.lk_po_off_user pou ON um.LK_PO_OFF_USER_ID=pou.LK_PO_OFF_USER_ID JOIN master_v1.lk_post_office po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID JOIN master_v1.ms_office o ON PO.OFFICE_ID=o.OFFICE_ID JOIN MASTER_V1.LK_EMP_USER eu ON eu.USER_ID=pou.USER_ID JOIN MASTER_V1.MS_EMPLOYEE me ON eu.EMP_ID=me.EMP_ID JOIN MASTER_V1.MS_POST mp ON po.POST_ID=mp.POST_ID JOIN MASTER_V1.MS_USER mu ON pou.USER_ID=mu.USER_ID WHERE tumwr.wf_role_id = :nextWfRoleId AND um.menu_id = :menuId AND po.office_id = :officeId AND mu.ACTIVE_STATUS= :activeStatus AND mp.ACTIVE_STATUS= :activeStatus AND me.ACTIVE_STATUS= :activeStatus AND eu.ACTIVE_STATUS= :activeStatus AND o.ACTIVE_STATUS= :activeStatus AND pou.ACTIVE_STATUS= :activeStatus AND po.ACTIVE_STATUS= :activeStatus AND po.IS_VACANT_POST=1 AND um.ACTIVE_STATUS= :activeStatus AND tumwr.ACTIVE_STATUS= :activeStatus",nativeQuery = true)
	Set<Object[]> findUserByNextWfRole(@Param("officeId") long officeId, @Param("menuId") long menuId, @Param("nextWfRoleId") long nextWfRoleId, @Param("activeStatus") int activeStatus);

	/**
	 * Find WfInitWfRoleId
	 *
	 * @param menuId
	 * @param activeStatus
	 * @param officeTypeId
	 * @return the long
	 */
	@Query(value = "SELECT wf.wfInitWfRoleId FROM MsWorkflowEntity wf WHERE wf.menuId = :menuId AND wf.activeStatus = :activeStatus and officeTypeId.lookUpInfoId =:officeTypeId AND wf.wfInitWfRoleId IS NOT NULL")
	Long findWfInitWfRoleId(@Param("menuId") long menuId, @Param("activeStatus") int activeStatus, @Param("officeTypeId") long officeTypeId);

	/**
	 * Find distinct by menu id.
	 *
	 * @param menuId the menu id
	 * @return the list
	 */
	List<MsWorkflowEntity> findDistinctByMenuId(long menuId);

	List<MsWorkflowEntity> findDistinctByMenuIdIn(List<Long> menuIds);

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

	@Query(value = "select WF_ROLE_CODE from MASTER_V1.WF_WORKFLOW_ROLE where WF_ROLE_ID = :wfRoleId",nativeQuery = true)
	String findWfRoleCodeById(@Param("wfRoleId") long wfRoleId);

}
