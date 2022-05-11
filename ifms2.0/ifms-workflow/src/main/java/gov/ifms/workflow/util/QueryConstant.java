package gov.ifms.workflow.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import gov.ifms.common.util.Constant;
import gov.ifms.workflow.dto.AssignedToTrnDto;
import gov.ifms.workflow.dto.TrnIdRemAssToUserDto;
import gov.ifms.workflow.dto.TrnIdRemDto;
import gov.ifms.workflow.dto.WfActConfUserRequestDto;
import gov.ifms.workflow.dto.WfActionConfigSubmitTrnResDto;
import gov.ifms.workflow.dto.WfActionConfigTrnDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.dto.WfRequestReOffConDto;
import gov.ifms.workflow.dto.WfUserDetails;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.dto.WfUserReqSDDto;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.entity.WfActionConfigEntity;

public class QueryConstant {

	private QueryConstant() {
		throw new IllegalStateException("Utility class");
	}

	public static final String TRN_ID = "trnId";

	public static final String ACTIVE_STATUS = "activeStatus";

	public static final String UPDATE = "update ";
	public static final String ASSIGN_TO_USER_ID = "atUId";
	public static final String ASSIGN_TO_POST_ID = "atPId";
	public static final String ASSIGN_TO_POU_ID = "atPouId";
	public static final String ASSIGN_TO_OFFICE_ID = "atOId";
	public static final String ASSIGN_TO_BRANCH_ID = "atBId";
	public static final String ASSIGN_TO_GROUP_ID = "atGId";
	public static final String JOIN_ON_MS_USER_WITH_USER_ID = ".MS_USER US ON US.USER_ID = WF.ASSIGN_BY_USER_ID ";
	public static final String JOIN_ON_MS_POST_WITH_POST_ID = ".MS_POST POST ON POST.POST_ID = WF.ASSIGN_BY_POST_ID ";
	public static final String JOIN_ON_MS_OFFICE_WITH_OFFICE_ID = ".MS_OFFICE OFC ON OFC.OFFICE_ID = WF.ASSIGN_BY_OFFICE_ID ";
	public static final String JOIN_ON_MS_DESGN_WITH_DESGN_ID = ".MS_DESIGNATION DESGN ON DESGN.DESIGNATION_ID = POST.DESIGNATION_ID ";
	public static final String JOIN_ON_WF_ROLE_WITH_WF_ROLE_ID = ".WF_WORKFLOW_ROLE WFROLE ON WFROLE.WF_ROLE_ID = WF.ASSIGN_BY_WF_ROLE_ID ";

	/**
	 * @param schema
	 * @param tblName
	 * @return
	 */
	public static String getActTrnQrString(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("select ASSIGN_TO_WF_ROLE_ID,ASSIGN_TO_ACTION_LEVEL from ").append(schema).append(".")
				.append(tblName).append("  where TRN_ID = :trnId and ACTIVE_STATUS = :activeStatus ");
		return queryString.toString();
	}

	/**
	 * @param trnId
	 * @return
	 */
	public static Map<String, Object> getActTrnQrParamMap(long trnId) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, trnId);
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		return params;
	}

//    /**
//     * @param schema
//     * @param tblName
//     * @return
//     */

	public static String getUserForBackActQrString(String schema, String tblName) {
		String tblId = tblName + "_ID";
		StringBuilder queryString = new StringBuilder();
		queryString.append(
				"SELECT pou.USER_ID,MASTER_V1.GET_WF_USER_NAME_PVU(pou.LK_PO_OFF_USER_ID), po.POST_ID, po.OFFICE_ID, pou.LK_PO_OFF_USER_ID FROM ");
		queryString.append(schema).append(".").append(tblName).append(
				" trn JOIN MASTER_V1.LK_PO_OFF_USER pou ON trn.ASSIGN_BY_POU_ID = pou.LK_PO_OFF_USER_ID JOIN MASTER_V1.LK_POST_OFFICE po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID ");
		queryString.append(" WHERE trn.").append(tblId).append(" = (SELECT MAX(t.").append(tblId).append(")  FROM ");
		queryString.append(schema).append(".").append(tblName).append(
				" t WHERE t.TRN_ID = :trnId AND t.MENU_ID = :menuId AND t.ASSIGN_BY_WF_ROLE_ID = :nextWfRoleId )");
		return queryString.toString();
	}

	/**
	 * @param dto
	 * @return
	 */
	public static Map<String, Object> getUserForBackActQrParamMap(WfRequestDto dto) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, dto.getTrnId());
		params.put("menuId", dto.getMenuId());
		params.put("nextWfRoleId", dto.getNextWfRoleId());
		return params;
	}

	/**
	 * @param menuTblInfoEntity
	 * @return
	 */
	public static String getPFWFHistoryQuery(LkMenuTblInfoEntity menuTblInfoEntity) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT WF.").append(menuTblInfoEntity.getTrnWfTblName()).append("_Id as c0");
		sb.append(" ,US.USER_NAME as c1 , POST.POST_NAME as c2 ,WF.CREATED_DATE  as c3,  ")
				.append(" WMW.WORKFLOW_NAME as c4 ,   WF.WF_STATUS as c5 ,WF.TRN_STATUS  as c6 , WF.REMARKS as c7, ");
		sb.append(" OFC.OFFICE_NAME as c8, DESGN.DESIGNATION_NAME as c9, WFROLE.WF_ROLE_NAME as c10 FROM ")
				.append(menuTblInfoEntity.getSchemaName()).append(".").append(menuTblInfoEntity.getTrnWfTblName())
				.append(" WF ").append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(JOIN_ON_MS_USER_WITH_USER_ID).append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(JOIN_ON_MS_POST_WITH_POST_ID).append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".WF_MS_WORKFLOW wmw ON WMW.WORKFLOW_ID = WF.CURRENT_WORKFLOW_ID ").append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_MS_OFFICE_WITH_OFFICE_ID).append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_MS_DESGN_WITH_DESGN_ID).append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_WF_ROLE_WITH_WF_ROLE_ID)
				.append(" WHERE WF.TRN_ID =:trnId ORDER BY WF.CREATED_DATE DESC");
		return sb.toString();
	}

	/**
	 * @param menuTblInfoEntity
	 * @param appendQuery
	 * @return
	 */
	public static String getPVUWFHistoryQuery(LkMenuTblInfoEntity menuTblInfoEntity, String appendQuery) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT WF.").append(menuTblInfoEntity.getTrnWfTblName()).append("_Id as c0");
		sb.append(" ,US.USER_NAME as c1 , POST.POST_NAME as c2 ,WF.CREATED_DATE  as c3,  ")
				.append(" WMW.WORKFLOW_NAME as c4 , WF.WF_STATUS as c5 ,WF.TRN_STATUS  as c6 , WF.REMARKS as c7, ");
		sb.append(" OFC.OFFICE_NAME as c8, DESGN.DESIGNATION_NAME as c9, WFROLE.WF_ROLE_NAME as c10 FROM ")
				.append(menuTblInfoEntity.getSchemaName()).append(".").append(menuTblInfoEntity.getTrnWfTblName())
				.append("  WF   ").append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(JOIN_ON_MS_USER_WITH_USER_ID).append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(JOIN_ON_MS_POST_WITH_POST_ID).append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".WF_MS_WORKFLOW wmw ON WMW.WORKFLOW_ID = WF.CURRENT_WORKFLOW_ID ").append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_MS_OFFICE_WITH_OFFICE_ID).append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_MS_DESGN_WITH_DESGN_ID).append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_WF_ROLE_WITH_WF_ROLE_ID)
				.append(" WHERE WF.TRN_ID =:trnId ").append(appendQuery).append(" ORDER BY WF.CREATED_DATE DESC");
		return sb.toString();
	}

	/**
	 * @return
	 */
	public static String getCurrentUserPOUId() {
		StringBuilder sb = new StringBuilder("SELECT pou.LK_PO_OFF_USER_ID  , pou.LK_POST_OFFICE_ID  FROM ");
		sb.append(Constant.PVU_SCHEMA_MASTER).append(".LK_PO_OFF_USER pou INNER JOIN ");
		sb.append(Constant.PVU_SCHEMA_MASTER).append(".LK_POST_OFFICE ofc ON ");
		sb.append(
				" ofc.LK_POST_OFFICE_ID  = pou.LK_POST_OFFICE_ID  AND ofc.POST_ID = :postId AND ofc.OFFICE_ID =:officeId  ");
		sb.append(" AND pou.ACTIVE_STATUS = 1 AND ofc.ACTIVE_STATUS = 1 AND pou.USER_ID  =:userId");
		return sb.toString();
	}

	/**
	 * @return
	 */
	public static String getAuthorizedUserName() {
		StringBuilder sb = new StringBuilder("SELECT us.USER_NAME, us.USER_ID FROM ");
		sb.append(Constant.PVU_SCHEMA).append(".T_PVU_RP_WF wf INNER JOIN ");
		sb.append(Constant.PVU_SCHEMA_MASTER).append(".MS_USER us ON ");
		sb.append(" us.USER_ID  = wf.ASSIGN_BY_USER_ID ");
		sb.append("WHERE wf.TRN_ID = :id AND wf.TRN_STATUS = 'Authorised by Class II' ");
		return sb.toString();
	}

	public static String getActualWfRoleId(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("select ASSIGN_TO_WF_ROLE_ID,LEVEL from ").append(schema).append(".").append(tblName)
				.append("  where TRN_ID = :trnId and ACTIVE_STATUS = :activeStatus ");
		return queryString.toString();
	}

	public static String getActualWfRoleIdWithAssignBy(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(
				"select trn.ASSIGN_TO_WF_ROLE_ID,trn.LEVEL,trn.WF_ID,ASSIGN_TO_OFFICE_ID,ASSIGN_TO_BRANCH_ID,ASSIGN_TO_GROUP_ID,trn.ASSIGN_TO_POU_ID from ")
				.append(schema).append(".").append(tblName)
				.append(" trn where trn.TRN_ID = :trnId and trn.ACTIVE_STATUS = :activeStatus");
		return queryString.toString();
	}

	public static String getCommonWFHistoryQuery(LkMenuTblInfoEntity menuTblInfoEntity) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT WF.TRN_Id as c0");
		sb.append(
				" ,US.USER_NAME || ' ('|| DEPT.DEPARTMENT_NAME || ')' as c1 , POST.POST_NAME as c2 ,WF.CREATED_DATE  as c3,  ")
				.append(" WFROLE.WF_ROLE_NAME as c4 ,   WF.WF_STATUS as c5 ,WF.TRN_STATUS  as c6 , WF.REMARKS as c7, ");
		sb.append(
				" OFC.OFFICE_NAME as c8, DESGN.DESIGNATION_NAME as c9, WFROLE.WF_ROLE_NAME || ' - ' || ACT.WF_ACTION_NAME AS c10 , WFROLE.WF_ROLE_ID as c11 ,WF.WF_ID AS c12 ")
				.append(" FROM   ").append(menuTblInfoEntity.getSchemaName()).append(".")
				.append(menuTblInfoEntity.getTrnWfTblName()).append("  WF   ").append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_MS_USER_WITH_USER_ID).append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_MS_POST_WITH_POST_ID).append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_MS_OFFICE_WITH_OFFICE_ID).append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_DEPARTMENT DEPT ON OFC.DEPARTMENT_ID = DEPT.DEPARTMENT_ID ").append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_MS_DESGN_WITH_DESGN_ID).append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(JOIN_ON_WF_ROLE_WITH_WF_ROLE_ID).append(Constant.INNER_JOIN)
				.append(Constant.EDP_MASTER_SCHEMA)
				.append(".WF_MS_WORKFLOW_ACTIONS act ON wf.WF_ACTION_ID  = ACT.WF_ACTION_ID ")
				.append(" WHERE  WF.TRN_ID =:trnId  and wf.TRN_STATUS != 'Draft'  ORDER BY WF.CREATED_DATE DESC");
		return sb.toString();
	}

	public static String getWfAttachment(LkMenuTblInfoEntity menuTblInfoEntity) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT tta.TRN_ATTACH_ID AS c0, tta.TRN_ID AS C1 , tta.ATTACHMENT_ID AS c2 ,");
		sb.append(" mt.ATTACHMENT_NAME AS c3 , ");
		sb.append(" tta.FILE_NAME AS c4, tta.UPLOADED_FILE_PATH AS c5 ,");
		sb.append(" tta.UPLOADED_FILE_NAME AS c6 ,tta.UPLOADED_FILE_SIZE AS c7,");
		sb.append(" tta.DOCUMENT_ID AS c8 ,us.USER_NAME AS c9 ,tta.CREATED_BY_POST AS c10,");
		sb.append(" tta.CREATED_DATE  AS c11  FROM ").append(menuTblInfoEntity.getSchemaName()).append(".")
				.append(menuTblInfoEntity.getAttachTblName());
		sb.append(" tta INNER JOIN ").append(Constant.EDP_MASTER_SCHEMA)
				.append(".MS_ATTACHMENTS mt ON mt.ATTACHMENT_ID  =tta.ATTACHMENT_ID ");
		sb.append(" INNER JOIN ").append(Constant.EDP_MASTER_SCHEMA)
				.append(".LK_PO_OFF_USER pou ON POU.LK_PO_OFF_USER_ID  = tta.UPDATED_BY_POST ");
		sb.append(" INNER JOIN ").append(Constant.EDP_MASTER_SCHEMA)
				.append(".MS_USER us ON us.USER_ID  = pou.USER_ID ");
		sb.append(" WHERE tta.TRN_ID  = :trnId AND   tta.ACTIVE_STATUS  = 1 ");
		sb.append(" AND tta.CATEGORY = :category AND tta.WF_ROLE_ID =:wfRoleId and tta.WF_ID =:wfId");
		return sb.toString();
	}

	public static String getWfTrnSubmitSpQueryString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Constant.WORKFLOW_SCHEMA.concat(Constant.DOT.concat(WorkFlowConstant.SP_WF_TRN_SUBMIT)));
		return sb.toString();
	}

	public static Map<String, Object> getWfTrnSubmitSpQueryMap(WfActionConfigTrnDto wfTrn,
			WfActionConfigEntity wfActConf, Long assignToUserId, Long assignByUserId) {
		Map<String, Object> params = new HashMap<>();
		params.put(WfTrnSubmitSp.IN_TRN_ID.name(), wfTrn.getTrnId());
		params.put(WfTrnSubmitSp.IN_ACTIONCONFIG_ID.name(), wfTrn.getActionConfigId());
		params.put(WfTrnSubmitSp.IN_WF_ACTION_ID.name(), wfActConf.getMsWorkflowActionEntity().getWfActionId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_WF_ROLE_ID.name(), wfTrn.getAssignedTo().getWfRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_USER_ID.name(), assignToUserId);
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POST_ID.name(), wfTrn.getAssignedTo().getPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POU_ID.name(), wfTrn.getAssignedTo().getPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_OFFICE_ID.name(), wfTrn.getAssignedTo().getOfficeId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_GROUP_ID.name(), wfTrn.getAssignedTo().getGroupId());
		params.put(WfTrnSubmitSp.IN_WF_STATUS.name(), wfActConf.getToWfStatus());
		params.put(WfTrnSubmitSp.IN_TRN_STATUS.name(), wfActConf.getToStatus());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_WF_ROLE_ID.name(), wfTrn.getAssignedBy().getWfRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_USER_ID.name(), assignByUserId);
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POST_ID.name(), wfTrn.getAssignedBy().getPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POU_ID.name(), wfTrn.getAssignedBy().getPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_OFFICE_ID.name(), wfTrn.getAssignedBy().getOfficeId());
		if (wfActConf.getLocationType().getLookUpInfoId() != LocationType.CHILD_OFFICE.getValue()) {
			if (wfActConf.getToBranchTypeId() != null) {
				params.put(WfTrnSubmitSp.IN_ASSIGN_TO_BRANCH_ID.name(), wfTrn.getAssignedTo().getBranchId());
			} else {
				params.put(WfTrnSubmitSp.IN_ASSIGN_TO_BRANCH_ID.name(), null);
			}
			if (wfActConf.getFromBranchTypeId() != null) {
				params.put(WfTrnSubmitSp.IN_ASSIGN_BY_BRANCH_ID.name(), wfTrn.getAssignedBy().getBranchId());
			} else {
				params.put(WfTrnSubmitSp.IN_ASSIGN_BY_BRANCH_ID.name(), null);
			}
		} else {
			params.put(WfTrnSubmitSp.IN_ASSIGN_TO_BRANCH_ID.name(), wfTrn.getAssignedTo().getBranchId());
			params.put(WfTrnSubmitSp.IN_ASSIGN_BY_BRANCH_ID.name(), wfTrn.getAssignedBy().getBranchId());
		}
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_GROUP_ID.name(), wfTrn.getAssignedBy().getGroupId());
		params.put(WfTrnSubmitSp.IN_REMARKS.name(), wfTrn.getRemarks());
		params.put(WfTrnSubmitSp.IN_SEND_BACK_FLAG.name(), wfActConf.getSendBackFlag());
		if (wfActConf.getSendBackFlag() == SendBack.PRIVIOUS.getValue()) {
			params.put(WfTrnSubmitSp.IN_LEVEL.name(), wfTrn.getAssignedTo().getLevel());
		} else {
			params.put(WfTrnSubmitSp.IN_LEVEL.name(), wfActConf.getToLevel());
		}
		return params;
	}

	public static Map<String, Object> getWfTrnMvLySpQueryMap(WfActionConfigTrnDto submitDto, Long wfId,
			Long assignToUserId, Long assigneByUserId, String schema, String mvTblName, String lyTblName) {
		Map<String, Object> params = new HashMap<>();
		params.put(WfTrnMvLySp.IN_TRN_ID.name(), submitDto.getTrnId());
		params.put(WfTrnMvLySp.IN_ASSIGN_TO_USER_ID.name(), assignToUserId);
		params.put(WfTrnMvLySp.IN_ASSIGN_TO_POST_ID.name(), submitDto.getAssignedTo().getPostId());
		params.put(WfTrnMvLySp.IN_ASSIGN_TO_POU_ID.name(), submitDto.getAssignedTo().getPouId());
		params.put(WfTrnMvLySp.IN_ASSIGN_TO_OFFICE_ID.name(), submitDto.getAssignedTo().getOfficeId());
		params.put(WfTrnMvLySp.IN_ASSIGN_BY_USER_ID.name(), assigneByUserId);
		params.put(WfTrnMvLySp.IN_ASSIGN_BY_POST_ID.name(), submitDto.getAssignedBy().getPostId());
		params.put(WfTrnMvLySp.IN_ASSIGN_BY_POU_ID.name(), submitDto.getAssignedBy().getPouId());
		params.put(WfTrnMvLySp.IN_WF_ID.name(), wfId);
		params.put(WfTrnMvLySp.IN_SCHEMA.name(), schema);
		params.put(WfTrnMvLySp.IN_MV_TBL_NAME.name(), mvTblName);
		params.put(WfTrnMvLySp.IN_LY_TBL_NAME.name(), lyTblName);
		return params;
	}

	public static String updateActStsForWfTrnQrString(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(UPDATE).append(schema).append(".").append(tblName)
				.append("  set ACTIVE_STATUS=:activeStatus where TRN_ID = :trnId ");
		return queryString.toString();
	}

	public static Map<String, Object> updateActStsForWfTrnQrParamMap(long trnId) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, trnId);
		params.put(ACTIVE_STATUS, Constant.INACTIVE_STATUS);
		return params;
	}

	public static String getCurrentTrnStatus(LkMenuTblInfoEntity menuTblInfoEntity) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" SELECT WF_ID as c0, TRN_ID as c1, ACTIONCONFIG_ID as c2, WF_ACTION_ID as c3, ").append(
				"ASSIGN_TO_WF_ROLE_ID as c4, ASSIGN_TO_USER_ID as c5, ASSIGN_TO_POST_ID as c6, ASSIGN_TO_POU_ID as c7, ")
				.append("ASSIGN_TO_OFFICE_ID as c8, ASSIGN_TO_BRANCH_ID as c9, ASSIGN_TO_GROUP_ID as c10, WF_STATUS as c11, ")
				.append("TRN_STATUS as c12 , ASSIGN_BY_WF_ROLE_ID as c13, ASSIGN_BY_USER_ID as c14, ASSIGN_BY_POST_ID as c15, ")
				.append("ASSIGN_BY_POU_ID as c16, ASSIGN_BY_OFFICE_ID as c17, ASSIGN_BY_BRANCH_ID as c18, ASSIGN_BY_GROUP_ID as c19, ")
				.append("REMARKS as c20, CREATED_BY as c21, CREATED_DATE as c22 ").append("from ")
				.append(menuTblInfoEntity.getSchemaName()).append(".").append(menuTblInfoEntity.getTrnWfTblName())
				.append(" wftab where wftab.active_status= 1 and wftab.TRN_ID=:trnId");
		return stringBuilder.toString();
	}

	public static String updateTrnAttachQrStr(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(UPDATE).append(schema).append(".").append(tblName).append(
				"  set WF_ID=:wfId,WF_ROLE_ID=:wfRoleId where TRN_ID = :trnId and WF_ID IS NULL and WF_ROLE_ID IS NULL and ACTIVE_STATUS=:activeStatus and CATEGORY=(select lli.LOOKUP_INFO_ID from MASTER_V1.LU_LOOKUP_INFO lli  where LLI.LOOKUP_INFO_NAME =:lookUpInfoName AND lli.PARENT_LOOKUP_ID=(select ll.LOOKUP_ID from MASTER_V1.LU_LOOKUP ll where ll.LOOKUP_NAME =:lookUpName))");
		return queryString.toString();
	}

	public static Map<String, Object> updateTrnAttachQrParamMap(long wfId, long wfRoleId, long trnId) {
		Map<String, Object> params = new HashMap<>();
		params.put("wfId", wfId);
		params.put("wfRoleId", wfRoleId);
		params.put(TRN_ID, trnId);
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		params.put("lookUpName", WorkFlowConstant.LU_NAME_ATTACHMENT_CATEGORY);
		params.put("lookUpInfoName", WorkFlowConstant.LU_INFO_NAME_WORKFLOW);
		return params;
	}

	public static String getUserForPrevWfQrString(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT pou.USER_ID,MASTER_V1.GET_WF_USER_NAME(pou.LK_PO_OFF_USER_ID),po.POST_ID,po.OFFICE_ID,ttw.ASSIGN_BY_POU_ID,ttw.ASSIGN_BY_BRANCH_ID,ttw.ASSIGN_BY_WF_ROLE_ID, ");
		queryString.append(" (SELECT tnw2.\"LEVEL\" FROM ").append(schema).append(".").append(tblName).append(
				" tnw2 WHERE tnw2.TRN_ID=ttw.TRN_ID AND tnw2.ASSIGN_TO_POU_ID=ttw.ASSIGN_BY_POU_ID AND tnw2.ASSIGN_TO_WF_ROLE_ID=ttw.ASSIGN_BY_WF_ROLE_ID AND tnw2.ASSIGN_TO_POU_ID<>tnw2.ASSIGN_BY_POU_ID AND tnw2.ASSIGN_TO_WF_ROLE_ID<>tnw2.ASSIGN_BY_WF_ROLE_ID ORDER BY WF_ID DESC LIMIT 1) ");
		queryString
				.append(" , (SELECT POST_NAME FROM MASTER_V1.MS_POST where POST_ID = po.POST_ID ) as postName FROM ");
		queryString.append(schema).append(".").append(tblName)
				.append(" ttw JOIN MASTER_V1.LK_PO_OFF_USER pou ON ttw.ASSIGN_BY_POU_ID=pou.LK_PO_OFF_USER_ID ");
		queryString.append(" JOIN MASTER_V1.LK_POST_OFFICE po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID ");
		queryString.append(" WHERE ttw.WF_ID = (SELECT max(ttw2.WF_ID) FROM ");

		queryString.append(schema).append(".").append(tblName).append(
				" ttw2 WHERE ttw2.TRN_ID=:trnId AND ttw2.ASSIGN_TO_POU_ID=:assignToPouId AND ttw2.ASSIGN_TO_WF_ROLE_ID=:assignToWfRoleId AND ttw2.SEND_BACK_FLAG=:sendBackFlag)");
		return queryString.toString();
	}
	
	
	


	public static String getUserForReworkWfQrString(String schema, String tblName, WfActionConfigEntity wfActConf) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(
				"SELECT pou.USER_ID,(SELECT mu.USER_NAME FROM MASTER_V1.MS_USER mu WHERE mu.USER_ID=pou.USER_ID),po.POST_ID,po.OFFICE_ID,ttw.ASSIGN_BY_POU_ID,ttw.ASSIGN_BY_BRANCH_ID,ttw.ASSIGN_BY_WF_ROLE_ID, ");
		queryString.append(" 0 as levels ");
		queryString
				.append(" , (SELECT POST_NAME FROM MASTER_V1.MS_POST where POST_ID = po.POST_ID ) as postName FROM ");
		queryString.append(schema).append(".").append(tblName)
				.append(" ttw JOIN MASTER_V1.LK_PO_OFF_USER pou ON ttw.ASSIGN_BY_POU_ID=pou.LK_PO_OFF_USER_ID ");
		queryString.append(" JOIN MASTER_V1.LK_POST_OFFICE po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID ");
		queryString.append(" WHERE ttw.WF_ID = (SELECT max(ttw2.WF_ID) FROM ");
		queryString.append(schema).append(".").append(tblName)
				.append(" ttw2 WHERE ttw2.TRN_ID=:trnId AND ttw2.ASSIGN_BY_WF_ROLE_ID = :assignByWfRoleId");
		if (wfActConf.getToBranchTypeId() != null) {
			queryString.append(
					" AND ttw2.ASSIGN_BY_BRANCH_ID IN (SELECT mb.BRANCH_ID FROM MASTER_V1.MS_BRANCH mb WHERE mb.BRANCH_TYPE_ID=:wfActionToBranchTypeId)");
		}
		queryString.append(" AND ttw2.ASSIGN_BY_OFFICE_ID = :assignByOfficeId AND ttw2.SEND_BACK_FLAG=:sendBackFlag)");
		return queryString.toString();
	}

	public static Map<String, Object> getUserForReworkWfQrParamMap(WfActConfUserRequestDto dto,
			WfActionConfigEntity wfActConf) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, dto.getTrnId());
		params.put("assignByWfRoleId", wfActConf.getToWorkFlowRoleId());
		if (wfActConf.getToBranchTypeId() != null) {
			params.put("wfActionToBranchTypeId", wfActConf.getToBranchTypeId());
		}
		params.put("assignByOfficeId", dto.getOfficeId());
		params.put("sendBackFlag", SendBack.DEFUALT.getValue());
		return params;
	}

	public static Map<String, Object> getUserForPrevWfQrParamMap(WfActConfUserRequestDto dto,
			WfActionConfigEntity wfActConf) {
		Map<String, Object> params = new HashMap<>();
		params.put("assignToPouId", dto.getPouId());
		params.put("assignToWfRoleId", wfActConf.getFromWorkFlowRoleEntity().getWfRoleId());
		params.put(TRN_ID, dto.getTrnId());
		params.put("sendBackFlag", SendBack.DEFUALT.getValue());
		return params;
	}

	public static String insTrnSaveQrStr(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("insert into ").append(schema).append(".").append(tblName).append(
				" (TRN_ID, ACTIONCONFIG_ID, WF_ACTION_ID, ASSIGN_TO_WF_ROLE_ID, ASSIGN_TO_USER_ID, ASSIGN_TO_POST_ID, ASSIGN_TO_POU_ID, ASSIGN_TO_OFFICE_ID, ASSIGN_TO_BRANCH_ID, ASSIGN_TO_GROUP_ID, WF_STATUS, TRN_STATUS, ASSIGN_BY_WF_ROLE_ID, ASSIGN_BY_USER_ID, ASSIGN_BY_POST_ID, ASSIGN_BY_POU_ID, ASSIGN_BY_OFFICE_ID, ASSIGN_BY_BRANCH_ID, ASSIGN_BY_GROUP_ID, REMARKS, CREATED_BY, CREATED_DATE, CREATED_BY_POST, UPDATED_BY, UPDATED_DATE, UPDATED_BY_POST, ACTIVE_STATUS)")
				.append(" VALUES(:trnId, :actionConfigId, :wfActionId, :atWfRlId, :atUId, :atPId, :atPouId, :atOId, :atBId, :atGId, :wfStatus, :trnStatus, :abWfRlId, :abUId, :abPId, :abPouId, :abOId, :abBId, :abGId, :remarks, :cb, :cbd, :cbp, :ub, :ubd, :ubp, :activeStatus)");
		return queryString.toString();
	}

	public static Map<String, Object> insTrnSaveQrParamMap(WfUserReqSDDto dto, AssignedToTrnDto assignedToDto) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, dto.getTrnId());
		params.put("actionConfigId", null);
		params.put("wfActionId", WorkFlowConstant.WF_ACTION_SAVE_DRAFT);
		params.put("atWfRlId", assignedToDto.getAssignToWfRoleId());
		params.put(ASSIGN_TO_USER_ID, dto.getUserId());
		params.put(ASSIGN_TO_POST_ID, dto.getPostId());
		params.put(ASSIGN_TO_POU_ID, dto.getPouId());
		params.put(ASSIGN_TO_OFFICE_ID, dto.getOfficeId());
		params.put(ASSIGN_TO_BRANCH_ID, dto.getBranchId());
		params.put(ASSIGN_TO_GROUP_ID, null);
		params.put("wfStatus", WorkFlowConstant.WF_ACTION_SAVE_DRAFT_STATUS);
		params.put("trnStatus", WorkFlowConstant.WF_ACTION_SAVE_DRAFT_STATUS);
		params.put("abWfRlId", assignedToDto.getAssignToWfRoleId());
		params.put("abUId", dto.getUserId());
		params.put("abPId", dto.getPostId());
		params.put("abPouId", dto.getPouId());
		params.put("abOId", dto.getOfficeId());
		params.put("abBId", dto.getBranchId());
		params.put("abGId", null);
		params.put("remarks", WorkFlowConstant.WF_ACTION_SAVE_DRAFT_STATUS);
		params.put("cb", dto.getUserId());
		params.put("cbd", new Date());
		params.put("cbp", dto.getPostId());
		params.put("ub", dto.getUserId());
		params.put("ubd", new Date());
		params.put("ubp", dto.getPostId());
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		return params;
	}

	public static String updateAssignToTrnQrString(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(UPDATE).append(schema).append(".").append(tblName).append(
				"  set ASSIGN_TO_USER_ID=:atUId,ASSIGN_TO_POST_ID=:atPId,ASSIGN_TO_POU_ID=:atPouId,ASSIGN_TO_OFFICE_ID=:atOId,ASSIGN_TO_BRANCH_ID=:atBId,ASSIGN_TO_GROUP_ID=:atGId,UPDATED_BY=:ub,UPDATED_DATE=:ubd,UPDATED_BY_POST=:ubp,ACTIVE_STATUS=:activeStatus where TRN_ID = :trnId and WF_ID= :wfId");
		return queryString.toString();
	}

	public static Map<String, Object> updateAssignToTrnQrParamMap(WfUserReqSDDto dto, AssignedToTrnDto assignedToDto) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, dto.getTrnId());
		params.put("wfId", assignedToDto.getWfId());
		params.put(ASSIGN_TO_USER_ID, dto.getUserId());
		params.put(ASSIGN_TO_POST_ID, dto.getPostId());
		params.put(ASSIGN_TO_POU_ID, dto.getPouId());
		params.put(ASSIGN_TO_OFFICE_ID, dto.getOfficeId());
		params.put(ASSIGN_TO_BRANCH_ID, assignedToDto.getAssignToBranchId());
		params.put(ASSIGN_TO_GROUP_ID, null);
		params.put("ub", dto.getUserId());
		params.put("ubd", new Date());
		params.put("ubp", dto.getPostId());
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		return params;
	}

	public static String getChildOfficeQrStr(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(
				"SELECT ttw.ASSIGN_BY_OFFICE_ID,(select MO.OFFICE_NAME from MASTER_V1.MS_OFFICE mo where mo.OFFICE_ID=ttw.ASSIGN_BY_OFFICE_ID) FROM ");
		queryString.append(schema).append(".").append(tblName).append(" ttw where ttw.WF_ID= ");
		queryString.append(" (select MIN(tnw.WF_ID) from ");
		queryString.append(schema).append(".").append(tblName)
				.append(" tnw where TNW.TRN_ID=:trnId AND TNW.ASSIGN_TO_OFFICE_ID=:officeId) ");
		return queryString.toString();
	}

	public static Map<String, Object> getChildOfficeQrStr(WfUserReqSDDto dto) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, dto.getTrnId());
		params.put("officeId", dto.getOfficeId());
		return params;
	}

	public static String getInsTrnDetailsQrStringQrString(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT trn.WF_ID,trn.TRN_ID, trn.ACTIONCONFIG_ID,trn.WF_ACTION_ID, ");
		queryString.append(
				" trn.ASSIGN_TO_WF_ROLE_ID,trn.ASSIGN_TO_USER_ID,trn.ASSIGN_TO_POST_ID,trn.ASSIGN_TO_POU_ID,trn.ASSIGN_TO_OFFICE_ID,trn.ASSIGN_TO_BRANCH_ID,trn.ASSIGN_TO_GROUP_ID, ");
		queryString.append(" trn.WF_STATUS,trn.TRN_STATUS, ");
		queryString.append(
				" trn.ASSIGN_BY_WF_ROLE_ID,trn.ASSIGN_BY_USER_ID,trn.ASSIGN_BY_POST_ID,trn.ASSIGN_BY_POU_ID,trn.ASSIGN_BY_OFFICE_ID,trn.ASSIGN_BY_BRANCH_ID,trn.ASSIGN_BY_GROUP_ID, ");
		queryString.append(" trn.REMARKS, trn.LEVEL FROM ").append(schema).append(".").append(tblName)
				.append(" trn WHERE trn.WF_ID=:wfId ");
		return queryString.toString();
	}

	public static Map<String, Object> getInsTrnDetailsQrStringQrParamMap(long wfId) {
		Map<String, Object> params = new HashMap<>();
		params.put("wfId", wfId);
		return params;
	}

	public static Map<String, Object> insTrnSubmitParamMap(WfUserReqSDDto dto,
			WfActionConfigEntity wfActionConfigEntity) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, dto.getTrnId());
		params.put("actionConfigId", wfActionConfigEntity.getActionconfigId());
		params.put("wfActionId", wfActionConfigEntity.getMsWorkflowActionEntity().getWfActionId());
		params.put("atWfRlId", wfActionConfigEntity.getToWorkFlowRoleId());
		params.put(ASSIGN_TO_USER_ID, dto.getUserId());
		params.put(ASSIGN_TO_POST_ID, dto.getPostId());
		params.put(ASSIGN_TO_POU_ID, dto.getPouId());
		params.put(ASSIGN_TO_OFFICE_ID, dto.getOfficeId());
		params.put(ASSIGN_TO_BRANCH_ID, dto.getBranchId());
		params.put(ASSIGN_TO_GROUP_ID, null);
		params.put("wfStatus", wfActionConfigEntity.getToWfStatus());
		params.put("trnStatus", wfActionConfigEntity.getToStatus());
		params.put("abWfRlId", wfActionConfigEntity.getToWorkFlowRoleId());
		params.put("abUId", dto.getUserId());
		params.put("abPId", dto.getPostId());
		params.put("abPouId", dto.getPouId());
		params.put("abOId", dto.getOfficeId());
		params.put("abBId", dto.getBranchId());
		params.put("abGId", null);
		params.put("remarks", WorkFlowConstant.WF_ACTION_APPROVE);
		params.put("cb", dto.getUserId());
		params.put("cbd", new Date());
		params.put("cbp", dto.getPostId());
		params.put("ub", dto.getUserId());
		params.put("ubd", new Date());
		params.put("ubp", dto.getPostId());
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		params.put("level", wfActionConfigEntity.getToLevel());
		return params;
	}

	public static String insTrnDirectSubmitQrStr(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("insert into ").append(schema).append(".").append(tblName).append(
				" (TRN_ID, ACTIONCONFIG_ID, WF_ACTION_ID, ASSIGN_TO_WF_ROLE_ID, ASSIGN_TO_USER_ID, ASSIGN_TO_POST_ID, ASSIGN_TO_POU_ID, ASSIGN_TO_OFFICE_ID, ASSIGN_TO_BRANCH_ID, ASSIGN_TO_GROUP_ID, WF_STATUS, TRN_STATUS, ASSIGN_BY_WF_ROLE_ID, ASSIGN_BY_USER_ID, ASSIGN_BY_POST_ID, ASSIGN_BY_POU_ID, ASSIGN_BY_OFFICE_ID, ASSIGN_BY_BRANCH_ID, ASSIGN_BY_GROUP_ID, REMARKS, CREATED_BY, CREATED_DATE, CREATED_BY_POST, UPDATED_BY, UPDATED_DATE, UPDATED_BY_POST, ACTIVE_STATUS,LEVEL)")
				.append(" VALUES(:trnId, :actionConfigId, :wfActionId, :atWfRlId, :atUId, :atPId, :atPouId, :atOId, :atBId, :atGId, :wfStatus, :trnStatus, :abWfRlId, :abUId, :abPId, :abPouId, :abOId, :abBId, :abGId, :remarks, :cb, :cbd, :cbp, :ub, :ubd, :ubp, :activeStatus,:level)");
		return queryString.toString();
	}

	public static Map<String, Object> getRetToOffWfTrnSubmitSpQueryMap(WfRequestReOffConDto dto,
			WfActionConfigEntity wfActConf, WfActionConfigSubmitTrnResDto assignedByTrnDet, WfUserDto loginUserDet,
			AssignedToTrnDto assignedByDto) {
		Map<String, Object> params = new HashMap<>();
		params.put(WfTrnSubmitSp.IN_TRN_ID.name(), dto.getHdrId());
		params.put(WfTrnSubmitSp.IN_ACTIONCONFIG_ID.name(), wfActConf.getActionconfigId());
		params.put(WfTrnSubmitSp.IN_WF_ACTION_ID.name(), wfActConf.getMsWorkflowActionEntity().getWfActionId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_WF_ROLE_ID.name(), wfActConf.getToWorkFlowRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_USER_ID.name(), assignedByTrnDet.getAssignByUserId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POST_ID.name(), assignedByTrnDet.getAssignByPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POU_ID.name(), assignedByTrnDet.getAssignByPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_OFFICE_ID.name(), assignedByTrnDet.getAssignByOfficeId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_BRANCH_ID.name(), assignedByTrnDet.getAssignByBranchId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_GROUP_ID.name(),
				assignedByTrnDet.getAssignByGroupId() == 0 ? null : assignedByTrnDet.getAssignByGroupId());
		params.put(WfTrnSubmitSp.IN_WF_STATUS.name(), wfActConf.getToWfStatus());
		params.put(WfTrnSubmitSp.IN_TRN_STATUS.name(), wfActConf.getToStatus());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_WF_ROLE_ID.name(), assignedByDto.getAssignToWfRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_USER_ID.name(), loginUserDet.getUserId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POST_ID.name(), loginUserDet.getPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POU_ID.name(), loginUserDet.getPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_OFFICE_ID.name(), loginUserDet.getOfficeId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_BRANCH_ID.name(), assignedByDto.getAssignToBranchId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_GROUP_ID.name(),
				assignedByDto.getAssignToGroupId() == 0 ? null : assignedByDto.getAssignToGroupId());
		params.put(WfTrnSubmitSp.IN_REMARKS.name(), dto.getRemarks());
		params.put(WfTrnSubmitSp.IN_SEND_BACK_FLAG.name(), wfActConf.getSendBackFlag());
		params.put(WfTrnSubmitSp.IN_LEVEL.name(), wfActConf.getToLevel());
		return params;
	}

	public static String getUserForReturnToOfficeQrStr(LkMenuTblInfoEntity tblOfTbl) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT trw.WF_ID,trw.TRN_ID,trw.ACTIONCONFIG_ID,trw.WF_ACTION_ID, ");
		queryString.append(" trw.ASSIGN_TO_WF_ROLE_ID,trw.ASSIGN_TO_USER_ID,trw.ASSIGN_TO_POST_ID, ");
		queryString.append(" trw.ASSIGN_TO_POU_ID,trw.ASSIGN_TO_OFFICE_ID,trw.ASSIGN_TO_BRANCH_ID, ");
		queryString.append(" trw.ASSIGN_TO_GROUP_ID,trw.WF_STATUS,trw.TRN_STATUS, ");
		queryString.append(" trw.ASSIGN_BY_WF_ROLE_ID,trw.ASSIGN_BY_USER_ID,trw.ASSIGN_BY_POST_ID, ");
		queryString.append(" trw.ASSIGN_BY_POU_ID,trw.ASSIGN_BY_OFFICE_ID,trw.ASSIGN_BY_BRANCH_ID, ");
		queryString.append(" trw.ASSIGN_BY_GROUP_ID,trw.REMARKS FROM ");
		queryString.append(tblOfTbl.getSchemaName()).append(".").append(tblOfTbl.getReturnWfTblName()).append(" trw ");
		queryString.append(" WHERE trw.TRN_ID = :trnId AND trw.ACTIVE_STATUS= :activeStatus ");
		queryString.append(" AND trw.ASSIGN_TO_WF_ROLE_ID = :aToWfRlId AND trw.ASSIGN_TO_OFFICE_ID = :aToOffId ");
		queryString.append(" AND trw.ASSIGN_BY_WF_ROLE_ID = :aByWfRlId ");
		return queryString.toString();
	}

	public static Map<String, Object> getUserForReturnToOfficeQrParamMap(WfRequestReOffConDto dto, long assignedToWfRl,
			long assignedByWfRl, long loginOfficeId) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, dto.getHdrId());
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		params.put("aToWfRlId", assignedToWfRl);
		params.put("aToOffId", loginOfficeId);
		params.put("aByWfRlId", assignedByWfRl);
		return params;
	}

	/**
	 * @return
	 */
	public static String getUserDetailsFromPouIdQrStr() {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT lpou.USER_ID,NULL,lpo.POST_ID,lpo.OFFICE_ID ,lpou.LK_PO_OFF_USER_ID,NULL,NULL,0 ");
		queryString.append(
				" FROM MASTER_V1.LK_PO_OFF_USER lpou JOIN MASTER_V1.LK_POST_OFFICE lpo ON lpou.LK_POST_OFFICE_ID = lpo.LK_POST_OFFICE_ID ");
		queryString.append(" WHERE lpou.LK_PO_OFF_USER_ID = :pouId ");
		return queryString.toString();
	}

	/**
	 * @param pouId
	 * @return
	 */
	public static Map<String, Object> getUserDetailsFromPouIdQrMap(long pouId) {
		Map<String, Object> params = new HashMap<>();
		params.put("pouId", pouId);
		return params;
	}

	public static String getWfTrnBulkOpV3SPQuery() {
		StringBuilder queryString = new StringBuilder();
		queryString.append("{CALL ")
				.append(Constant.WORKFLOW_SCHEMA.concat(Constant.DOT.concat(WorkFlowConstant.WF_TRN_BULK_SUBMIT_V3)))
				.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

		return queryString.toString();
	}

	public static Map<String, Object> getWfTrnBulkOpV3SPMapSingle(TrnIdRemDto trn, WfUserDetails assignTo,
			WfUserDetails assignBy, WfActionConfigEntity wfActConf, long wfRequestId) {
		Map<String, Object> params = new HashMap<>();
		params.put(WfTrnSubmitSp.IN_TRN_ID.name(), trn.getTrnId());
		params.put(WfTrnSubmitSp.IN_ACTIONCONFIG_ID.name(), wfActConf.getActionconfigId());
		params.put(WfTrnSubmitSp.IN_WF_ACTION_ID.name(), wfActConf.getMsWorkflowActionEntity().getWfActionId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_WF_ROLE_ID.name(), assignTo.getWfRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_USER_ID.name(), assignTo.getUserId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POST_ID.name(), assignTo.getPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POU_ID.name(), assignTo.getPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_OFFICE_ID.name(), assignTo.getOfficeId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_BRANCH_ID.name(), assignTo.getBranchId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_GROUP_ID.name(), assignTo.getGroupId());
		params.put(WfTrnSubmitSp.IN_WF_STATUS.name(), wfActConf.getToWfStatus());
		params.put(WfTrnSubmitSp.IN_TRN_STATUS.name(), wfActConf.getToStatus());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_WF_ROLE_ID.name(), assignBy.getWfRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_USER_ID.name(), assignBy.getUserId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POST_ID.name(), assignBy.getPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POU_ID.name(), assignBy.getPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_OFFICE_ID.name(), assignBy.getOfficeId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_BRANCH_ID.name(), assignBy.getBranchId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_GROUP_ID.name(), assignBy.getGroupId());
		params.put(WfTrnSubmitSp.IN_REMARKS.name(), trn.getRemarks());
		params.put(WfTrnSubmitSp.IN_SEND_BACK_FLAG.name(), wfActConf.getSendBackFlag());
		params.put(WfTrnSubmitSp.IN_LEVEL.name(),
				assignTo.getLevel() != null ? assignTo.getLevel() : wfActConf.getToLevel());
		params.put(WfTrnSubmitSp.IN_WF_REQ_ID.name(), wfRequestId);
		return params;
	}

	public static Map<String, Object> getWfTrnBulkOpV3SPMapSingle(TrnIdRemAssToUserDto trn, WfUserDetails assignTo,
			WfUserDetails assignBy, WfActionConfigEntity wfActConf, long wfRequestId) {
		Map<String, Object> params = new HashMap<>();
		params.put(WfTrnSubmitSp.IN_TRN_ID.name(), trn.getTrnId());
		params.put(WfTrnSubmitSp.IN_ACTIONCONFIG_ID.name(), wfActConf.getActionconfigId());
		params.put(WfTrnSubmitSp.IN_WF_ACTION_ID.name(), wfActConf.getMsWorkflowActionEntity().getWfActionId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_WF_ROLE_ID.name(), assignTo.getWfRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_USER_ID.name(), assignTo.getUserId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POST_ID.name(), assignTo.getPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POU_ID.name(), assignTo.getPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_OFFICE_ID.name(), assignTo.getOfficeId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_BRANCH_ID.name(), assignTo.getBranchId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_GROUP_ID.name(), assignTo.getGroupId());
		params.put(WfTrnSubmitSp.IN_WF_STATUS.name(), wfActConf.getToWfStatus());
		params.put(WfTrnSubmitSp.IN_TRN_STATUS.name(), wfActConf.getToStatus());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_WF_ROLE_ID.name(), assignBy.getWfRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_USER_ID.name(), assignBy.getUserId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POST_ID.name(), assignBy.getPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POU_ID.name(), assignBy.getPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_OFFICE_ID.name(), assignBy.getOfficeId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_BRANCH_ID.name(), assignBy.getBranchId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_GROUP_ID.name(), assignBy.getGroupId());
		params.put(WfTrnSubmitSp.IN_REMARKS.name(), trn.getRemarks());
		params.put(WfTrnSubmitSp.IN_SEND_BACK_FLAG.name(), wfActConf.getSendBackFlag());
		params.put(WfTrnSubmitSp.IN_LEVEL.name(),
				assignTo.getLevel() != null ? assignTo.getLevel() : wfActConf.getToLevel());
		params.put(WfTrnSubmitSp.IN_WF_REQ_ID.name(), wfRequestId);
		return params;
	}

	public static String getInsTrnDetailsQrString(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT trn.WF_ID,wrd.TRN_ID, trn.ACTIONCONFIG_ID,trn.WF_ACTION_ID, ");
		queryString.append(
				" trn.ASSIGN_TO_WF_ROLE_ID,trn.ASSIGN_TO_USER_ID,trn.ASSIGN_TO_POST_ID,trn.ASSIGN_TO_POU_ID,trn.ASSIGN_TO_OFFICE_ID,trn.ASSIGN_TO_BRANCH_ID,trn.ASSIGN_TO_GROUP_ID, ");
		queryString.append(" trn.WF_STATUS,trn.TRN_STATUS, ");
		queryString.append(
				" trn.ASSIGN_BY_WF_ROLE_ID,trn.ASSIGN_BY_USER_ID,trn.ASSIGN_BY_POST_ID,trn.ASSIGN_BY_POU_ID,trn.ASSIGN_BY_OFFICE_ID,trn.ASSIGN_BY_BRANCH_ID,trn.ASSIGN_BY_GROUP_ID, ");
		queryString.append(" trn.REMARKS,wrd.WF_REQUEST_DET_ID,wrd.SQL_ERR_CODE,wrd.SQL_ERR_STATE,wrd.ERR_MSG FROM ")
				.append(schema).append(".").append(tblName)
				.append(" trn RIGHT JOIN MASTER_V1.WF_REQUEST_DET wrd ON trn.WF_ID=wrd.WF_ID JOIN MASTER_V1.WF_REQUEST wr ON wr.WF_REQUEST_ID=wrd.WF_REQUEST_ID WHERE wr.WF_REQUEST_NO=:wfReqNo ");
		return queryString.toString();
	}

	public static Map<String, Object> getInsTrnDetailsQrParamMap(String wfReqNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("wfReqNo", wfReqNo);
		return params;
	}

	public static String getIntiatorDetails(String schema, String tblName) {
		String tblId = tblName + "_ID";
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT ");
		queryString.append(
				" pou.USER_ID,(SELECT USER_NAME FROM MASTER_V1.MS_USER WHERE USER_ID=pou.USER_ID), po.POST_ID, po.OFFICE_ID, pou.LK_PO_OFF_USER_ID ");
		queryString.append(" FROM ").append(schema).append(".").append(tblName)
				.append(" trn JOIN MASTER_V1.LK_PO_OFF_USER pou ON trn.ASSIGN_BY_POU_ID = pou.LK_PO_OFF_USER_ID ");
		queryString.append(" JOIN MASTER_V1.LK_POST_OFFICE po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID ");
		queryString.append(" WHERE trn.").append(tblId).append(" = (SELECT MAX(t.").append(tblId).append(")  FROM ");
		queryString.append(schema).append(".").append(tblName)
				.append(" t WHERE t.TRN_ID = :trnId AND t.MENU_ID = :menuId)");
		return queryString.toString();
	}

	/**
	 *
	 * @param dto
	 * @param wfActConf
	 * @return
	 */
	public static Map<String, Object> getUserForInitiatorWfQrParamMap(WfActConfUserRequestDto dto,
			WfActionConfigEntity wfActConf) {
		Map<String, Object> params = new HashMap<>();
		params.put("trnId", dto.getTrnId());
		if (wfActConf.getToBranchTypeId() != null) {
			params.put("wfActionToBranchTypeId", wfActConf.getToBranchTypeId());
		}

		return params;
	}

	/**
	 *
	 * @param schema
	 * @param tblName
	 * @param wfActConf
	 * @return
	 */
	public static String getUserForInitiatorWfQrString(String schema, String tblName, WfActionConfigEntity wfActConf) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT ");
		queryString.append(
				" pou.USER_ID,(SELECT mu.USER_NAME FROM MASTER_V1.MS_USER mu WHERE mu.USER_ID=pou.USER_ID),po.POST_ID,po.OFFICE_ID,ttw.ASSIGN_BY_POU_ID,ttw.ASSIGN_BY_BRANCH_ID,ttw.ASSIGN_BY_WF_ROLE_ID, ");
		queryString.append(" 0 as levels ");
		queryString.append(" , (SELECT POST_NAME FROM MASTER_V1.MS_POST where POST_ID = po.POST_ID ) as postName ");
		queryString.append(" FROM ").append(schema).append(".").append(tblName)
				.append(" ttw JOIN MASTER_V1.LK_PO_OFF_USER pou ON ttw.ASSIGN_BY_POU_ID=pou.LK_PO_OFF_USER_ID ");
		queryString.append(" JOIN MASTER_V1.LK_POST_OFFICE po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID ");
		queryString.append(" WHERE ttw.WF_ID = (SELECT min(ttw2.WF_ID) FROM ");
		queryString.append(schema).append(".").append(tblName).append(" ttw2 WHERE ttw2.TRN_ID=:trnId");
		if (wfActConf.getToBranchTypeId() != null) {
			queryString.append(
					" AND ttw2.ASSIGN_BY_BRANCH_ID IN (SELECT mb.BRANCH_ID FROM MASTER_V1.MS_BRANCH mb WHERE mb.BRANCH_TYPE_ID=:wfActionToBranchTypeId)");
		}
		queryString.append(" )");
		return queryString.toString();
	}
}
