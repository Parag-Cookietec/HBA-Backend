package gov.ifms.loc.workflow.repository;


import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.loc.workflow.dto.WfRlandPrDto;
import gov.ifms.loc.workflow.dto.WfUserDto;
import gov.ifms.loc.workflow.entity.LocWfActionConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Interface LocWfActionConfigRepository.
 */
@Repository
public interface LocWfActionConfigRepository extends JpaRepository<LocWfActionConfigEntity,Long> ,
                  JpaSpecificationExecutor<LocWfActionConfigEntity> , GenericDao {

    /**
     * @param menuId
     * @param wfRoleId
     * @param activeStatus
     * @param lkPOUId
     * @return
     */
    @Trace
    @Query(value = "SELECT COUNT(tumwr.trnUsrWfRoleId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :wfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId = :lkPOUId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.activeStatus = :activeStatus")
    Long verifyUserWfRole(@Param("menuId") long menuId, @Param("wfRoleId") long wfRoleId, @Param("activeStatus") int activeStatus, @Param("lkPOUId") Long lkPOUId);

    /**
     * @param userId
     * @param postId
     * @param officeId
     * @param menuId
     * @param wfRoleId
     * @param activeStatus
     * @return
     */
    @Trace
    @Query(value = "SELECT COUNT(tumwr.trnUsrWfRoleId) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :wfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.userId.userId = :userId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId = :postId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.userId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus")
    Long verifyUserWfRole(@Param("userId") long userId, @Param("postId") long postId, @Param("officeId") long officeId,
                          @Param("menuId") long menuId, @Param("wfRoleId") long wfRoleId, @Param("activeStatus") int activeStatus);

    /**
     * @param officeTypeId
     * @param wfRoleId
     * @param menuId
     * @param validWfActionId
     * @param actionLevel
     * @param isCo
     * @param defaultIsCo
     * @param isFd
     * @param defaultIsFd
     * @param activeStatus
     * @param isDisplayInPopup
     * @return
     */
    @Trace
    @Query(value = "SELECT actionConfig FROM LocWfActionConfigEntity actionConfig JOIN MsWorkflowActionEntity wfAction ON actionConfig.wfActionId=wfAction.wfActionId WHERE actionConfig.fromOfficeTypeId = :officeTypeId AND actionConfig.fromWfRoleId = :wfRoleId AND actionConfig.fromLevel = :actionLevel AND  actionConfig.edpMsMenuEntity.menuId = :menuId AND wfAction.validWfActionId = :validWfActionId AND (actionConfig.isCo = :isCo OR actionConfig.isCo = :defaultIsCo) AND (actionConfig.fromIsFD = :isFd OR actionConfig.fromIsFD = :defaultIsFd) AND actionConfig.activeStatus = :activeStatus AND actionConfig.isDisplayInPopup =:isDisplayInPopup")
    List<LocWfActionConfigEntity> findWorkflowRuleIdAndWfActions(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel,@Param("isCo") int isCo,@Param("defaultIsCo") int defaultIsCo,@Param("isFd") int isFd,@Param("defaultIsFd") int defaultIsFd, @Param("activeStatus") int activeStatus, @Param("isDisplayInPopup") int isDisplayInPopup);

    /**
     * @param officeTypeId
     * @param wfRoleId
     * @param menuId
     * @param validWfActionId
     * @param actionLevel
     * @param branchTypeId
     * @param isCo
     * @param defaultIsCo
     * @param isFd
     * @param defaultIsFd
     * @param activeStatus
     * @param isDisplayInPopup
     * @return
     */
    @Query(value = "SELECT actionConfig FROM LocWfActionConfigEntity actionConfig JOIN MsWorkflowActionEntity wfAction ON actionConfig.wfActionId=wfAction.wfActionId WHERE actionConfig.fromOfficeTypeId = :officeTypeId AND actionConfig.fromWfRoleId = :wfRoleId AND actionConfig.fromLevel = :actionLevel AND  actionConfig.edpMsMenuEntity.menuId = :menuId AND wfAction.validWfActionId = :validWfActionId AND actionConfig.fromBranchTypeId = :branchTypeId AND (actionConfig.isCo = :isCo OR actionConfig.isCo = :defaultIsCo) AND (actionConfig.fromIsFD = :isFd OR actionConfig.fromIsFD = :defaultIsFd) AND actionConfig.activeStatus = :activeStatus AND actionConfig.isDisplayInPopup =:isDisplayInPopup")
    List<LocWfActionConfigEntity> findWorkflowRuleIdAndWfActionsAndBrId(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel, @Param("branchTypeId") long branchTypeId, @Param("isCo") int isCo, @Param("defaultIsCo") int defaultIsCo,@Param("isFd") int isFd,@Param("defaultIsFd") int defaultIsFd, @Param("activeStatus") int activeStatus, @Param("isDisplayInPopup") int isDisplayInPopup);

    /**
     * @param officeTypeId
     * @param wfRoleId
     * @param menuId
     * @param validWfActionId
     * @param actionLevel
     * @param condition
     * @return
     */
    @Trace
    @Query(value = "SELECT actionConfig FROM LocWfActionConfigEntity actionConfig JOIN MsWorkflowActionEntity wfAction ON actionConfig.wfActionId=wfAction.wfActionId WHERE actionConfig.fromOfficeTypeId = :officeTypeId AND actionConfig.fromWfRoleId = :wfRoleId AND actionConfig.fromLevel = :actionLevel AND actionConfig.edpMsMenuEntity.menuId = :menuId AND wfAction.validWfActionId = :validWfActionId AND actionConfig.condition = :condition")
    List<LocWfActionConfigEntity> findWorkflowRuleIdAndWfActions(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel ,@Param("condition") String condition);

    /**
     * @param menuId
     * @param activeStatus
     * @param officeTypeId
     * @param isFd
     * @param defaultIsFd
     * @return
     */
    @Query(value = "SELECT wf.initWfRoleId FROM LocWfActionConfigEntity wf WHERE wf.edpMsMenuEntity.menuId = :menuId AND wf.activeStatus = :activeStatus and  wf.fromOfficeTypeId =:officeTypeId AND (wf.fromIsFD = :isFd or wf.fromIsFD = :defaultIsFd) AND wf.initWfRoleId IS NOT NULL")
    Long findWfInitWfRoleId(@Param("menuId") long menuId, @Param("activeStatus") int activeStatus, @Param("officeTypeId") long officeTypeId,@Param("isFd") int isFd,@Param("defaultIsFd") int defaultIsFd);

    /**
     * @param wfActConfId
     * @param activeStatus
     * @return
     */
    LocWfActionConfigEntity findByActionConfigIdAndActiveStatus(long wfActConfId,int activeStatus);

    /**
     * @param officeId
     * @param menuId
     * @param nextWfRoleId
     * @param activeStatus
     * @return
     */

    @Query(value = "SELECT new gov.ifms.loc.workflow.dto.WfUserDto(tumwr.lkUserMenuId.poOffUserId.userId.userId,FUNCTION('wf_user_name',tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId) ,tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId, tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId,tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId,tumwr.workflowRoleId ,(select post.postName from EDPMsPostEntity post where post.postId = tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId) ) FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.workflowRoleId = :nextWfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.activeStatus = :activeStatus")
    List<WfUserDto> findUserByNextWfRole(@Param("officeId") long officeId, @Param("menuId") long menuId, @Param("nextWfRoleId") long nextWfRoleId, @Param("activeStatus") int activeStatus);
  
    /**
     * @param officeId
     * @param menuId
     * @param nextWfRoleId
     * @param branchTypeId
     * @param activeStatus
     * @return
     */

    @Query(value = "SELECT NEW gov.ifms.loc.workflow.dto.WfUserDto(tumwr.lkUserMenuId.poOffUserId.userId.userId, FUNCTION('wf_user_name',tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId) , tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId, tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId, tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId, brmap.edpMsBranchEntity.branchId, tumwr.workflowRoleId , (select postName  from  EDPMsPostEntity where postId = tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId)  ) FROM EDPTrnUsrMnuWfRole tumwr, EDPTrnPouBrMapEntity brmap WHERE tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId = brmap.edpLkPoOffUserId.lkPoOffUserId and tumwr.workflowRoleId = :nextWfRoleId AND tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus AND brmap.edpMsBranchEntity.branchTypeId.lookUpInfoId= :branchTypeId")
    List<WfUserDto> findUserByNextWfRoleAndBTId(@Param("officeId") long officeId, @Param("menuId") long menuId, @Param("nextWfRoleId") long nextWfRoleId, @Param("branchTypeId") long branchTypeId,@Param("activeStatus") int activeStatus);

    /**
     * @param lkPOUId
     * @param branchId
     * @param activeStatus
     * @return
     */
    @Query(value = "SELECT COUNT(brpou.trnPouBrMapId) FROM EDPTrnPouBrMapEntity brpou WHERE brpou.edpLkPoOffUserId.lkPoOffUserId=:lkPOUId and brpou.edpMsBranchEntity.branchId=:branchId and brpou.activeStatus = :activeStatus")
    Long verifyUserBranch(@Param("lkPOUId") Long lkPOUId, @Param("branchId") long branchId, @Param("activeStatus") int activeStatus);

    /**
     * @param lkPOUId
     * @param activeStatus
     * @return
     */
    @Query(value = "SELECT brpou.edpMsBranchEntity.branchId FROM EDPTrnPouBrMapEntity brpou WHERE brpou.edpLkPoOffUserId.lkPoOffUserId=:lkPOUId and brpou.activeStatus = :activeStatus")
    List<Long> getUserBranches(@Param("lkPOUId") Long lkPOUId, @Param("activeStatus") int activeStatus);

    /**
     * @param menuId
     * @param lkPOUId
     * @param activeStatus
     * @return
     */
    @Query(value = "SELECT tumwr.workflowRoleId FROM EDPTrnUsrMnuWfRole tumwr WHERE tumwr.lkUserMenuId.menuID = :menuId AND tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId = :lkPOUId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.activeStatus = :activeStatus")
    List<Long> getUserWfRole(@Param("menuId") long menuId, @Param("lkPOUId") Long lkPOUId, @Param("activeStatus") int activeStatus);

    /**
     * Find wf init wf roles and pr.
     *
     * @param menuId the menu id
     * @param officeTypeId the office type id
     * @param activeStatus the active status
     * @param isFd the is fd
     * @param defaultIsFd the default is fd
     * @return the list
     */
    @Query(value = "SELECT new gov.ifms.loc.workflow.dto.WfRlandPrDto(wf.initWfRoleId,wf.initWfRlPr) FROM LocWfActionConfigEntity wf WHERE wf.edpMsMenuEntity.menuId = :menuId AND wf.activeStatus = :activeStatus and  wf.fromOfficeTypeId =:officeTypeId AND (wf.fromIsFD = :isFd or wf.fromIsFD = :defaultIsFd) AND wf.initWfRoleId IS NOT NULL")
    List<WfRlandPrDto> findWfInitWfRolesAndPr(@Param("menuId") long menuId, @Param("officeTypeId") long officeTypeId, @Param("activeStatus") int activeStatus, @Param("isFd") int isFd, @Param("defaultIsFd") int defaultIsFd);

    /**
     * Find workflow rule id and wf actions with sub type null.
     *
     * @param officeTypeId the office type id
     * @param wfRoleId the wf role id
     * @param menuId the menu id
     * @param validWfActionId the valid wf action id
     * @param actionLevel the action level
     * @param isCo the is co
     * @param defaultIsCo the default is co
     * @param isTo the is to
     * @param defaultIsTo the default is to
     * @param activeStatus the active status
     * @param isDisplayInPopup the is display in popup
     * @return the list
     */
    @Trace
    @Query(value = "SELECT actionConfig FROM LocWfActionConfigEntity actionConfig JOIN MsWorkflowActionEntity wfAction ON actionConfig.wfActionId=wfAction.wfActionId WHERE actionConfig.fromOfficeTypeId = :officeTypeId AND actionConfig.fromWfRoleId = :wfRoleId AND actionConfig.fromLevel = :actionLevel AND  actionConfig.edpMsMenuEntity.menuId = :menuId AND wfAction.validWfActionId = :validWfActionId AND (actionConfig.isCo = :isCo OR actionConfig.isCo = :defaultIsCo) AND (actionConfig.isTo = :isTo OR actionConfig.isTo = :defaultIsTo) AND actionConfig.activeStatus = :activeStatus AND actionConfig.isDisplayInPopup =:isDisplayInPopup AND actionConfig.fromOfficeSubTypeId IS NULL")
    List<LocWfActionConfigEntity> findWorkflowRuleIdAndWfActionsWithSubTypeNull(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel,@Param("isCo") int isCo,@Param("defaultIsCo") int defaultIsCo,@Param("isTo") int isTo, @Param("defaultIsTo") int defaultIsTo, @Param("activeStatus") int activeStatus, @Param("isDisplayInPopup") int isDisplayInPopup);

    /**
     * Find workflow rule id and wf actions with sub type.
     *
     * @param officeTypeId the office type id
     * @param wfRoleId the wf role id
     * @param menuId the menu id
     * @param validWfActionId the valid wf action id
     * @param actionLevel the action level
     * @param isCo the is co
     * @param defaultIsCo the default is co
     * @param isTo the is to
     * @param defaultIsTo the default is to
     * @param activeStatus the active status
     * @param isDisplayInPopup the is display in popup
     * @param fromOfficeSubTypeId the from office sub type id
     * @return the list
     */
    @Trace
    @Query(value = "SELECT actionConfig FROM LocWfActionConfigEntity actionConfig JOIN MsWorkflowActionEntity wfAction ON actionConfig.wfActionId=wfAction.wfActionId WHERE actionConfig.fromOfficeTypeId = :officeTypeId AND actionConfig.fromWfRoleId = :wfRoleId AND actionConfig.fromLevel = :actionLevel AND  actionConfig.edpMsMenuEntity.menuId = :menuId AND wfAction.validWfActionId = :validWfActionId AND (actionConfig.isCo = :isCo OR actionConfig.isCo = :defaultIsCo) AND (actionConfig.isTo = :isTo OR actionConfig.isTo = :defaultIsTo) AND actionConfig.activeStatus = :activeStatus AND actionConfig.isDisplayInPopup =:isDisplayInPopup AND actionConfig.fromOfficeSubTypeId = :fromOfficeSubTypeId")
    List<LocWfActionConfigEntity> findWorkflowRuleIdAndWfActionsWithSubType(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel,@Param("isCo") int isCo,@Param("defaultIsCo") int defaultIsCo,@Param("isTo") int isTo, @Param("defaultIsTo") int defaultIsTo, @Param("activeStatus") int activeStatus, @Param("isDisplayInPopup") int isDisplayInPopup,@Param("fromOfficeSubTypeId") long fromOfficeSubTypeId);

    /**
     * Find wf init wf roles and pr with sub type null.
     *
     * @param menuId the menu id
     * @param officeTypeId the office type id
     * @param activeStatus the active status
     * @param isTo the is to
     * @param defaultIsTo the default is to
     * @return the list
     */
    @Query(value = "SELECT new gov.ifms.loc.workflow.dto.WfRlandPrDto(wf.initWfRoleId,wf.initWfRlPr) FROM LocWfActionConfigEntity wf WHERE wf.edpMsMenuEntity.menuId = :menuId AND wf.activeStatus = :activeStatus and  wf.fromOfficeTypeId =:officeTypeId AND wf.fromOfficeSubTypeId IS NULL AND (wf.isTo = :isTo or wf.isTo = :defaultIsTo) AND wf.initWfRoleId IS NOT NULL")
    List<WfRlandPrDto> findWfInitWfRolesAndPrWithSubTypeNull(@Param("menuId") long menuId, @Param("officeTypeId") long officeTypeId, @Param("activeStatus") int activeStatus, @Param("isTo") int isTo, @Param("defaultIsTo") int defaultIsTo);

    /**
     * Find wf init wf roles and pr with sub type.
     *
     * @param menuId the menu id
     * @param officeTypeId the office type id
     * @param fromOfficeSubTypeId the from office sub type id
     * @param activeStatus the active status
     * @param isTo the is to
     * @param defaultIsTo the default is to
     * @return the list
     */
    @Query(value = "SELECT new gov.ifms.loc.workflow.dto.WfRlandPrDto(wf.initWfRoleId,wf.initWfRlPr) FROM LocWfActionConfigEntity wf WHERE wf.edpMsMenuEntity.menuId = :menuId AND wf.activeStatus = :activeStatus and  wf.fromOfficeTypeId =:officeTypeId AND wf.fromOfficeSubTypeId = :fromOfficeSubTypeId AND (wf.isTo = :isTo or wf.isTo = :defaultIsTo) AND wf.initWfRoleId IS NOT NULL")
    List<WfRlandPrDto> findWfInitWfRolesAndPrWithSubType(@Param("menuId") long menuId, @Param("officeTypeId") long officeTypeId, @Param("fromOfficeSubTypeId") long fromOfficeSubTypeId, @Param("activeStatus") int activeStatus, @Param("isTo") int isTo, @Param("defaultIsTo") int defaultIsTo);

    /**
     * Find workflow rule id and wf actions and br id with sub type null.
     *
     * @param officeTypeId the office type id
     * @param wfRoleId the wf role id
     * @param menuId the menu id
     * @param validWfActionId the valid wf action id
     * @param actionLevel the action level
     * @param branchTypeId the branch type id
     * @param activeStatus the active status
     * @param isDisplayInPopup the is display in popup
     * @return the list
     */
    @Query(value = "SELECT actionConfig FROM LocWfActionConfigEntity actionConfig JOIN MsWorkflowActionEntity wfAction ON actionConfig.wfActionId=wfAction.wfActionId WHERE actionConfig.fromOfficeTypeId = :officeTypeId AND actionConfig.fromWfRoleId = :wfRoleId AND actionConfig.fromLevel = :actionLevel AND  actionConfig.edpMsMenuEntity.menuId = :menuId AND wfAction.validWfActionId = :validWfActionId AND actionConfig.fromBranchTypeId = :branchTypeId AND actionConfig.activeStatus = :activeStatus AND actionConfig.isDisplayInPopup =:isDisplayInPopup AND actionConfig.fromOfficeSubTypeId IS NULL")
    List<LocWfActionConfigEntity> findWorkflowRuleIdAndWfActionsAndBrIdWithSubTypeNull(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel, @Param("branchTypeId") long branchTypeId, @Param("activeStatus") int activeStatus, @Param("isDisplayInPopup") int isDisplayInPopup);

    /**
     * Find workflow rule id and wf actions and br id with sub type.
     *
     * @param officeTypeId the office type id
     * @param wfRoleId the wf role id
     * @param menuId the menu id
     * @param validWfActionId the valid wf action id
     * @param actionLevel the action level
     * @param branchTypeId the branch type id
     * @param activeStatus the active status
     * @param isDisplayInPopup the is display in popup
     * @param fromOfficeSubTypeId the from office sub type id
     * @return the list
     */
    @Query(value = "SELECT actionConfig FROM LocWfActionConfigEntity actionConfig JOIN MsWorkflowActionEntity wfAction ON actionConfig.wfActionId=wfAction.wfActionId WHERE actionConfig.fromOfficeTypeId = :officeTypeId AND actionConfig.fromWfRoleId = :wfRoleId AND actionConfig.fromLevel = :actionLevel AND  actionConfig.edpMsMenuEntity.menuId = :menuId AND wfAction.validWfActionId = :validWfActionId AND (actionConfig.fromBranchTypeId = :branchTypeId OR actionConfig.fromBranchTypeId IS NULL) AND actionConfig.activeStatus = :activeStatus AND actionConfig.isDisplayInPopup =:isDisplayInPopup AND (actionConfig.fromOfficeSubTypeId = :fromOfficeSubTypeId OR actionConfig.fromOfficeSubTypeId IS NULL)")
    List<LocWfActionConfigEntity> findWorkflowRuleIdAndWfActionsAndBrIdWithSubType(@Param("officeTypeId") long officeTypeId, @Param("wfRoleId") long wfRoleId, @Param("menuId") long menuId, @Param("validWfActionId") int validWfActionId, @Param("actionLevel") int actionLevel, @Param("branchTypeId") Long branchTypeId, @Param("activeStatus") int activeStatus, @Param("isDisplayInPopup") int isDisplayInPopup, @Param("fromOfficeSubTypeId") Long fromOfficeSubTypeId);

    /**
     * Find user by next wf role and branch id.
     *
     * @param officeId the office id
     * @param menuId the menu id
     * @param nextWfRoleId the next wf role id
     * @param branchId the branch id
     * @param activeStatus the active status
     * @return the list
     */
    @Query(value = "SELECT DISTINCT NEW gov.ifms.loc.workflow.dto.WfUserDto(tumwr.lkUserMenuId.poOffUserId.userId.userId, tumwr.lkUserMenuId.poOffUserId.userId.userName , tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId, tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId, tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId, brmap.edpMsBranchEntity.branchId, tumwr.workflowRoleId , (select postName  from  EDPMsPostEntity where postId = tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.postEntity.postId)  ) FROM EDPTrnUsrMnuWfRole tumwr, EDPTrnPouBrMapEntity brmap WHERE tumwr.lkUserMenuId.poOffUserId.lkPoOffUserId = brmap.edpLkPoOffUserId.lkPoOffUserId and tumwr.workflowRoleId = :nextWfRoleId AND (tumwr.lkUserMenuId.menuID = :menuId OR tumwr.lkUserMenuId.menuID IN (SELECT menu.menuId FROM EDPMsMenuEntity menu WHERE menu.linkMenuId =:menuId)) AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.officeId = :officeId AND tumwr.activeStatus = :activeStatus AND tumwr.lkUserMenuId.activeStatus = :activeStatus AND tumwr.lkUserMenuId.poOffUserId.lkPostOfficeId.officeEntity.activeStatus = :activeStatus AND brmap.edpMsBranchEntity.branchId= :branchId")
    List<WfUserDto> findUserByNextWfRoleAndBranchId(@Param("officeId") long officeId, @Param("menuId") long menuId, @Param("nextWfRoleId") long nextWfRoleId, @Param("branchId") long branchId,@Param("activeStatus") int activeStatus);

	/**
	 * @param wfActionId
	 * @param activeStatus 
	 * @return
	 */
    @Query(value = "SELECT WF_ACTION_NAME FROM MASTER_V1.WF_MS_WORKFLOW_ACTIONS wmwa WHERE WF_ACTION_ID = :wfActionId AND ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String getWfAction(@Param("wfActionId")Long wfActionId,@Param("activeStatus") int activeStatus);

}
