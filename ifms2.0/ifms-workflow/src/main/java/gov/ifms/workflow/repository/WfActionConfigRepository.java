package gov.ifms.workflow.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.edp.entity.EDPTrnPouBrMapEntity;
import gov.ifms.workflow.dto.WfRlandPrDto;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.WfActionConfigEntity;

@Repository
public interface WfActionConfigRepository extends JpaRepository<WfActionConfigEntity,Long> ,
                  JpaSpecificationExecutor<WfActionConfigEntity> , GenericDao {


    @Trace
    @Query(value = "SELECT COUNT(tumwr.trnUsrWfRoleId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :wfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId = :lkPOUId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.activeStatus = :activeStatus")
    Long verifyUserWfRole(@Param("menuId") long menuId, @Param("wfRoleId") long wfRoleId, @Param("activeStatus") int activeStatus, @Param("lkPOUId") Long lkPOUId);


    @Trace
    @Query(value = "SELECT COUNT(tumwr.trnUsrWfRoleId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :wfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.userId.userId = :userId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId = :postId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.userId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus")
    Long verifyUserWfRole(@Param("userId") long userId, @Param("postId") long postId, @Param("officeId") long officeId,
                          @Param("menuId") long menuId, @Param("wfRoleId") long wfRoleId, @Param("activeStatus") int activeStatus);

    @Trace
    @Query(value = "select actionConfig from WfActionConfigEntity actionConfig where actionConfig.fromOfficeTypeId = :officeTypeId and actionConfig.fromWorkFlowRoleEntity.wfRoleId = :wfRoleId and actionConfig.fromLevel = :actionLevel and actionConfig.edpMsMenuEntity.menuId  = :menuId and actionConfig.msWorkflowActionEntity.validWfActionId = :validWfActionId and (actionConfig.isCo = :isCo or actionConfig.isCo = :defaultIsCo) and (actionConfig.fromIsFD = :isFd or actionConfig.fromIsFD = :defaultIsFd) and actionConfig.activeStatus = :activeStatus and actionConfig.isDisplayInPopup=:isDisplayInPopup")
    List<WfActionConfigEntity> findWorkflowRuleIdAndWfActions(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel,@Param("isCo") int isCo,@Param("defaultIsCo") int defaultIsCo,@Param("isFd") int isFd,@Param("defaultIsFd") int defaultIsFd, @Param("activeStatus") int activeStatus, @Param("isDisplayInPopup") int isDisplayInPopup);

    @Query(value = "select actionConfig from WfActionConfigEntity actionConfig where actionConfig.fromOfficeTypeId = :officeTypeId and actionConfig.fromWorkFlowRoleEntity.wfRoleId = :wfRoleId and actionConfig.fromLevel = :actionLevel and actionConfig.edpMsMenuEntity.menuId  = :menuId and actionConfig.msWorkflowActionEntity.validWfActionId = :validWfActionId and actionConfig.fromBranchTypeId = :branchTypeId and (actionConfig.isCo = :isCo or actionConfig.isCo = :defaultIsCo) and (actionConfig.fromIsFD = :isFd or actionConfig.fromIsFD = :defaultIsFd) and actionConfig.activeStatus= :activeStatus  and actionConfig.isDisplayInPopup=:isDisplayInPopup")
    List<WfActionConfigEntity> findWorkflowRuleIdAndWfActionsAndBrId(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel, @Param("branchTypeId") long branchTypeId, @Param("isCo") int isCo, @Param("defaultIsCo") int defaultIsCo,@Param("isFd") int isFd,@Param("defaultIsFd") int defaultIsFd, @Param("activeStatus") int activeStatus, @Param("isDisplayInPopup") int isDisplayInPopup);

    @Trace
    @Query(value = "select actionConfig from WfActionConfigEntity actionConfig where actionConfig.fromOfficeTypeId = :officeTypeId and actionConfig.fromWorkFlowRoleEntity.wfRoleId = :wfRoleId and actionConfig.fromLevel = :actionLevel and actionConfig.edpMsMenuEntity.menuId  = :menuId and actionConfig.msWorkflowActionEntity.validWfActionId = :validWfActionId and actionConfig.condition= :condition")
    List<WfActionConfigEntity> findWorkflowRuleIdAndWfActions(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel ,@Param("condition") String condition);


    @Query(value = "SELECT wf.initWfRoleId FROM WfActionConfigEntity wf WHERE wf.edpMsMenuEntity.menuId = :menuId AND wf.activeStatus = :activeStatus and  wf.fromOfficeTypeId =:officeTypeId AND (wf.fromIsFD = :isFd or wf.fromIsFD = :defaultIsFd) AND wf.initWfRoleId IS NOT NULL")
    Long findWfInitWfRoleId(@Param("menuId") long menuId, @Param("activeStatus") int activeStatus, @Param("officeTypeId") long officeTypeId,@Param("isFd") int isFd,@Param("defaultIsFd") int defaultIsFd);

    /**
     * Find by actionconfig id and active status.
     *
     * @param wfActConfId the wf act conf id
     * @param activeStatus the active status
     * @return the wf action config entity
     */
    WfActionConfigEntity findByActionconfigIdAndActiveStatus(long wfActConfId,int activeStatus);

    /**
     * Find user by next wf role.
     *
     * @param officeId the office id
     * @param menuId the menu id
     * @param nextWfRoleId the next wf role id
     * @param activeStatus the active status
     * @return the list
     */
    @Query(value = "SELECT pou.user_id, COALESCE ((SELECT LOOKUP_INFO_NAME from MASTER_V1.LU_LOOKUP_INFO where LOOKUP_INFO_ID=me.SALUTATION) || ' ', '') || me.EMPLOYEE_NAME || ' ' || me.SURNAME || ', ' || (select DESIGNATION_NAME from MASTER_V1.MS_DESIGNATION where DESIGNATION_ID=mp.DESIGNATION_ID) || ' (' ||  mu.USER_CODE || ')', po.post_id, po.office_id, um.lk_po_off_user_id, NULL, tumwr.wf_role_id, 0, mp.POST_NAME FROM master_v1.trn_usr_mnu_wf_role tumwr JOIN master_v1.lk_user_menu um ON tumwr.LK_USER_MENU_ID=um.LK_USER_MENU_ID JOIN master_v1.lk_po_off_user pou ON um.LK_PO_OFF_USER_ID=pou.LK_PO_OFF_USER_ID JOIN master_v1.lk_post_office po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID JOIN master_v1.ms_office o ON PO.OFFICE_ID=o.OFFICE_ID JOIN MASTER_V1.LK_EMP_USER eu ON eu.USER_ID=pou.USER_ID JOIN MASTER_V1.MS_EMPLOYEE me ON eu.EMP_ID=me.EMP_ID JOIN MASTER_V1.MS_POST mp ON po.POST_ID=mp.POST_ID JOIN MASTER_V1.MS_USER mu ON pou.USER_ID=mu.USER_ID WHERE tumwr.wf_role_id = :nextWfRoleId AND um.menu_id = :menuId AND po.office_id = :officeId AND mu.ACTIVE_STATUS= :activeStatus AND mp.ACTIVE_STATUS= :activeStatus AND me.ACTIVE_STATUS= :activeStatus AND eu.ACTIVE_STATUS= :activeStatus AND o.ACTIVE_STATUS= :activeStatus AND pou.ACTIVE_STATUS= :activeStatus AND po.ACTIVE_STATUS= :activeStatus AND po.IS_VACANT_POST=1 AND um.ACTIVE_STATUS= :activeStatus AND tumwr.ACTIVE_STATUS= :activeStatus",nativeQuery = true)
    Set<Object[]> findUserByNextWfRole(@Param("officeId") long officeId, @Param("menuId") long menuId, @Param("nextWfRoleId") long nextWfRoleId, @Param("activeStatus") int activeStatus);
    
    /**
     * Find user by next wf role and BT id.
     *
     * @param officeId the office id
     * @param menuId the menu id
     * @param nextWfRoleId the next wf role id
     * @param branchTypeId the branch type id
     * @param activeStatus the active status
     * @return the list
     */
    @Query(value = "SELECT pou.user_id, COALESCE ((SELECT LOOKUP_INFO_NAME from MASTER_V1.LU_LOOKUP_INFO where LOOKUP_INFO_ID=me.SALUTATION) || ' ', '') || me.EMPLOYEE_NAME || ' ' || me.SURNAME || ', ' || (select DESIGNATION_NAME from MASTER_V1.MS_DESIGNATION where DESIGNATION_ID=mp.DESIGNATION_ID) || ' (' ||  mu.USER_CODE || ')', po.post_id, po.office_id, um.lk_po_off_user_id, brmap.branch_id, tumwr.wf_role_id, 0, mp.POST_NAME FROM master_v1.trn_usr_mnu_wf_role tumwr JOIN master_v1.lk_user_menu um ON tumwr.LK_USER_MENU_ID=um.LK_USER_MENU_ID JOIN master_v1.lk_po_off_user pou ON um.LK_PO_OFF_USER_ID=pou.LK_PO_OFF_USER_ID JOIN master_v1.lk_post_office po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID JOIN master_v1.trn_pou_br_map brmap ON pou.LK_PO_OFF_USER_ID=brmap.LK_PO_OFF_USER_ID JOIN master_v1.ms_office o ON PO.OFFICE_ID=o.OFFICE_ID JOIN master_v1.ms_branch br ON brmap.BRANCH_ID=br.BRANCH_ID JOIN MASTER_V1.LK_EMP_USER eu ON eu.USER_ID=pou.USER_ID JOIN MASTER_V1.MS_EMPLOYEE me ON eu.EMP_ID=me.EMP_ID JOIN MASTER_V1.MS_POST mp ON po.POST_ID=mp.POST_ID JOIN MASTER_V1.MS_USER mu ON pou.USER_ID=mu.USER_ID WHERE tumwr.wf_role_id = :nextWfRoleId AND um.menu_id = :menuId AND po.office_id = :officeId AND br.branch_type_id = :branchTypeId AND mu.ACTIVE_STATUS= :activeStatus AND mp.ACTIVE_STATUS= :activeStatus AND me.ACTIVE_STATUS= :activeStatus AND eu.ACTIVE_STATUS= :activeStatus AND br.ACTIVE_STATUS= :activeStatus AND o.ACTIVE_STATUS= :activeStatus AND BRMAP.ACTIVE_STATUS= :activeStatus AND pou.ACTIVE_STATUS= :activeStatus AND po.ACTIVE_STATUS= :activeStatus AND po.IS_VACANT_POST=1 AND um.ACTIVE_STATUS= :activeStatus AND tumwr.ACTIVE_STATUS= :activeStatus", nativeQuery = true)
    Set<Object[]> findUserByNextWfRoleAndBTId(@Param("officeId") long officeId, @Param("menuId") long menuId, @Param("nextWfRoleId") long nextWfRoleId, @Param("branchTypeId") long branchTypeId,@Param("activeStatus") int activeStatus);

    /**
     * @param officeId
     * @param menuId
     * @param nextWfRoleId
     * @param activeStatus
     * @return
     */
    @Query(value = "SELECT new gov.ifms.workflow.dto.WfUserDto(tumwr.lkUserMenuId.poOffUserId.userId.userId,FUNCTION('wf_user_name',tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId),tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId, tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId,tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId,tumwr.workflowRoleId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :ministerWfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus")
    List<WfUserDto> findMisterUserByNextMinisterRole(@Param("officeId") long officeId ,@Param("menuId") long menuId,@Param("ministerWfRoleId") long nextWfRoleId, @Param("activeStatus") int activeStatus);

    @Query(value = "SELECT brpou from EDPTrnPouBrMapEntity brpou WHERE brpou.edpLkPoOffUserId.lkPoOffUserId = :pouId and activeStatus=:activeStatus")
    List<EDPTrnPouBrMapEntity> findAssignedByBranchId(@Param("pouId") long pouId, @Param("activeStatus") int activeStatus);

    @Query(value = "SELECT COUNT(brpou.trnPouBrMapId) FROM EDPTrnPouBrMapEntity brpou WHERE brpou.edpLkPoOffUserId.lkPoOffUserId=:lkPOUId and brpou.edpMsBranchEntity.branchId=:branchId and brpou.activeStatus = :activeStatus")
    Long verifyUserBranch(@Param("lkPOUId") Long lkPOUId, @Param("branchId") long branchId, @Param("activeStatus") int activeStatus);

    @Query(value = "SELECT brpou.edpMsBranchEntity.branchId FROM EDPTrnPouBrMapEntity brpou WHERE brpou.edpLkPoOffUserId.lkPoOffUserId=:lkPOUId and brpou.activeStatus = :activeStatus")
    List<Long> getUserBranches(@Param("lkPOUId") Long lkPOUId, @Param("activeStatus") int activeStatus);
    @Query(value = "select actionConfig from WfActionConfigEntity actionConfig where actionConfig.fromOfficeTypeId = :officeTypeId and actionConfig.fromLevel = :actionLevel and actionConfig.edpMsMenuEntity.menuId  = :menuId and actionConfig.fromWorkFlowRoleEntity.wfRoleId in (:workflowRoleIds) and actionConfig.msWorkflowActionEntity.validWfActionId = :validWfActionId and (actionConfig.isCo = :isCo or actionConfig.isCo = :defaultIsCo) and (actionConfig.fromIsFD = :isFd or actionConfig.fromIsFD = :defaultIsFd)")
    List<WfActionConfigEntity> directWfActions(@Param("officeTypeId") long officeTypeId,@Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel,@Param("isCo") int isCo,@Param("defaultIsCo") int defaultIsCo,@Param("isFd") int isFd,@Param("defaultIsFd") int defaultIsFd ,@Param("workflowRoleIds") List<Long> workflowRoleIds);

    
    /**
     * @param officeId
     * @param menuId
     * @param activeStatus
     * @return
     */
    @Query(value = "SELECT DISTINCT TO_STATUS FROM MASTER_V1.WF_ACTION_CONFIG wac WHERE wac.MENU_ID =:menuId AND wac.FROM_OFFICE_TYPE_ID =:officeId and wac.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
    List<String> findbyMenuandOffice(@Param("officeId") long officeId ,@Param("menuId") long menuId, @Param("activeStatus") int activeStatus);

    /**
     * 
     * @param menuId
     * @param activeStatus
     * @return
     */
    @Query(value = "SELECT DISTINCT TO_STATUS FROM MASTER_V1.WF_ACTION_CONFIG wac WHERE wac.MENU_ID =:menuId  and wac.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
    List<String> findStatusbyMenu(@Param("menuId") long menuId, @Param("activeStatus") int activeStatus);

    
    @Trace
    @Query(value = "select actionConfig from WfActionConfigEntity actionConfig where actionConfig.fromOfficeTypeId = :officeTypeId and actionConfig.fromWorkFlowRoleEntity.wfRoleId = :wfRoleId and actionConfig.edpMsMenuEntity.menuId  = :menuId and actionConfig.msWorkflowActionEntity.wfActionId = :wfActionId and actionConfig.msWorkflowActionEntity.validWfActionId = :validWfActionId and actionConfig.isDisplayInPopup=:isDisplayInPopup")
    WfActionConfigEntity findReturnWFActWfRuleId(@Param("menuId") long menuId, @Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId , @Param("wfActionId") long wfActionId, @Param("validWfActionId") int validWfActionId, @Param("isDisplayInPopup") int isDisplayInPopup);

    @Query(value = "SELECT tumwr.workflowRoleId FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId = :lkPOUId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.activeStatus = :activeStatus")
    List<Long> getUserWfRole(@Param("menuId") long menuId, @Param("lkPOUId") Long lkPOUId, @Param("activeStatus") int activeStatus);

    @Query(value = "SELECT new gov.ifms.workflow.dto.WfRlandPrDto(wf.initWfRoleId,wf.initWfRlPr) FROM WfActionConfigEntity wf WHERE wf.edpMsMenuEntity.menuId = :menuId AND wf.activeStatus = :activeStatus and  wf.fromOfficeTypeId =:officeTypeId AND (wf.fromIsFD = :isFd or wf.fromIsFD = :defaultIsFd) AND wf.initWfRoleId IS NOT NULL")
    List<WfRlandPrDto> findWfInitWfRolesAndPr(@Param("menuId") long menuId, @Param("officeTypeId") long officeTypeId, @Param("activeStatus") int activeStatus, @Param("isFd") int isFd,@Param("defaultIsFd") int defaultIsFd);
}
