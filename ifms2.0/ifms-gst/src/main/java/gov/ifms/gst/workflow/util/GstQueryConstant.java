package gov.ifms.gst.workflow.util;

import gov.ifms.common.util.Constant;
import gov.ifms.gst.util.GstDBConstants;
import gov.ifms.gst.workflow.dto.AssignedToTrnDto;
import gov.ifms.gst.workflow.dto.GstTrnIdRemAssToUserDto;
import gov.ifms.gst.workflow.dto.WfActConfUserRequestDto;
import gov.ifms.gst.workflow.dto.WfActionConfigTrnDto;
import gov.ifms.gst.workflow.dto.WfUserDetailsV3;
import gov.ifms.gst.workflow.dto.WfUserReqSDDto;
import gov.ifms.gst.workflow.entity.GstWfActionConfigEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class GstQueryConstant.
 */
public class GstQueryConstant {

	/**
	 * Instantiates a new GST query constant.
	 */
	private GstQueryConstant() {
		throw new IllegalStateException("Utility class");
	}

	/** The Constant TRN_ID. */
	public static final String TRN_ID = "trnId";

	/** The Constant ACTIVE_STATUS. */
	public static final String ACTIVE_STATUS = "activeStatus";

	/** The Constant UPDATE. */
	public static final String UPDATE = "update ";
	
	/** The Constant ASSIGN_TO_USER_ID. */
	public static final String ASSIGN_TO_USER_ID = "atUId";
	
	/** The Constant ASSIGN_TO_POST_ID. */
	public static final String ASSIGN_TO_POST_ID = "atPId";
	
	/** The Constant ASSIGN_TO_POU_ID. */
	public static final String ASSIGN_TO_POU_ID = "atPouId";
	
	/** The Constant ASSIGN_TO_OFFICE_ID. */
	public static final String ASSIGN_TO_OFFICE_ID = "atOId";
	
	/** The Constant ASSIGN_TO_BRANCH_ID. */
	public static final String ASSIGN_TO_BRANCH_ID = "atBId";
	
	/** The Constant ASSIGN_TO_GROUP_ID. */
	public static final String ASSIGN_TO_GROUP_ID = "atGId";
	
	/** The Constant JOIN_ON_MS_USER_WITH_USER_ID. */
	public static final String JOIN_ON_MS_USER_WITH_USER_ID = ".MS_USER US ON US.USER_ID = WF.ASSIGN_BY_USER_ID ";
	
	/** The Constant JOIN_ON_MS_POST_WITH_POST_ID. */
	public static final String JOIN_ON_MS_POST_WITH_POST_ID = ".MS_POST POST ON POST.POST_ID = WF.ASSIGN_BY_POST_ID ";
	
	/** The Constant JOIN_ON_MS_OFFICE_WITH_OFFICE_ID. */
	public static final String JOIN_ON_MS_OFFICE_WITH_OFFICE_ID = ".MS_OFFICE OFC ON OFC.OFFICE_ID = WF.ASSIGN_BY_OFFICE_ID ";
	
	/** The Constant JOIN_ON_MS_DESGN_WITH_DESGN_ID. */
	public static final String JOIN_ON_MS_DESGN_WITH_DESGN_ID = ".MS_DESIGNATION DESGN ON DESGN.DESIGNATION_ID = POST.DESIGNATION_ID ";
	
	/** The Constant JOIN_ON_WF_ROLE_WITH_WF_ROLE_ID. */
	public static final String JOIN_ON_WF_ROLE_WITH_WF_ROLE_ID = ".WF_WORKFLOW_ROLE WFROLE ON WFROLE.WF_ROLE_ID = WF.ASSIGN_BY_WF_ROLE_ID ";

	/** The Constant JOIN_ON_MS_POST_OFFICE_USER_ON_POU_ID. */
	public static final String JOIN_ON_MS_POST_OFFICE_USER_ON_POU_ID = " ttw JOIN MASTER_V1.LK_PO_OFF_USER pou ON ttw.ASSIGN_BY_POU_ID=pou.LK_PO_OFF_USER_ID ";
	
	/** The Constant JOIN_ON_MS_POST_OFFICE_USER_ON_POST_OFFICE_ID. */
	public static final String JOIN_ON_MS_POST_OFFICE_USER_ON_POST_OFFICE_ID = " JOIN MASTER_V1.LK_POST_OFFICE po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID ";

	/**
	 * Gets the menu tbl info from menu id qr str.
	 *
	 * @return the menu tbl info from menu id qr str
	 */
	public static String getMenuTblInfoFromMenuIdQrStr() {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT MENU_TBL_INFO_ID, MENU_ID, TRN_WF_TBL_NAME, LK_WF_ATT_TBL_NAME, ");
		queryString.append("ACTIVE_STATUS, SCHEMA_NAME, TRN_WF_MV_TBL_NAME, TRN_WF_LY_TBL_NAME, ");
		queryString.append("TRN_RETURN_WF_TBL_NAME FROM MASTER_V1.LK_MENU_TBL_INFO WHERE MENU_ID = :menuId AND ACTIVE_STATUS = :activeStatus ");
		return queryString.toString();
	}

	/**
	 * Gets the menu tbl info from menu id qr map.
	 *
	 * @param menuId the menu id
	 * @return the menu tbl info from menu id qr map
	 */
	public static Map<String, Object> getMenuTblInfoFromMenuIdQrMap(long menuId) {
		Map<String, Object> params = new HashMap<>();
		params.put("menuId", menuId);
		params.put("activeStatus", Constant.ACTIVE_STATUS);
		return params;
	}

	/**
	 * Gets the menu tbl info from GST wf action config id qr str.
	 *
	 * @return the menu tbl info from GST wf action config id qr str
	 */
	public static String getMenuTblInfoFromGstWfActionConfigIdQrStr() {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT MENU_TBL_INFO_ID, MENU_ID, TRN_WF_TBL_NAME, LK_WF_ATT_TBL_NAME, ");
		queryString.append("ACTIVE_STATUS, SCHEMA_NAME, TRN_WF_MV_TBL_NAME, TRN_WF_LY_TBL_NAME, ");
		queryString.append("TRN_RETURN_WF_TBL_NAME FROM MASTER_V1.LK_MENU_TBL_INFO WHERE ACTIVE_STATUS = :activeStatus ");
		queryString.append("AND MENU_ID = (SELECT twac.MENU_ID from EPAO.TAPO_WF_ACTION_CONFIG twac where twac.ACTIONCONFIG_ID = :wfActionConfigId AND twac.ACTIVE_STATUS= :activeStatus )");
		return queryString.toString();
	}

	/**
	 * Gets the menu tbl info from GST wf action config id qr map.
	 *
	 * @param wfActionConfigId the wf action config id
	 * @return the menu tbl info from GST wf action config id qr map
	 */
	public static Map<String, Object> getMenuTblInfoFromGstWfActionConfigIdQrMap(long wfActionConfigId) {
		Map<String, Object> params = new HashMap<>();
		params.put("wfActionConfigId", wfActionConfigId);
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		return params;
	}

	/**
	 * Gets the user for initiator wf qr param map.
	 *
	 * @param dto the dto
	 * @param wfActConf the wf act conf
	 * @return the user for initiator wf qr param map
	 */
	public static Map<String, Object> getUserForInitiatorWfQrParamMap(WfActConfUserRequestDto dto,
																	  GstWfActionConfigEntity wfActConf) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, dto.getTrnId());
		if (wfActConf.getToBranchTypeId() != null) {
			params.put("wfActionToBranchTypeId", wfActConf.getToBranchTypeId());
		}

		return params;
	}

	/**
	 * Gets the user for initiator wf qr string.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @param wfActConf the wf act conf
	 * @return the user for initiator wf qr string
	 */
	public static String getUserForInitiatorWfQrString(String schema, String tblName, GstWfActionConfigEntity wfActConf) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT ");
		queryString.append(" pou.USER_ID,MASTER_V1.GET_WF_USER_NAME(pou.LK_PO_OFF_USER_ID),po.POST_ID,po.OFFICE_ID,ttw.ASSIGN_BY_POU_ID,ttw.ASSIGN_BY_BRANCH_ID,ttw.ASSIGN_BY_WF_ROLE_ID, ");
		queryString.append(" 0 as levels ");
		queryString.append(" , (SELECT POST_NAME FROM MASTER_V1.MS_POST where POST_ID = po.POST_ID ) as postName ");
		queryString.append(" FROM ").append(schema).append(".").append(tblName)
				.append(JOIN_ON_MS_POST_OFFICE_USER_ON_POU_ID);
		queryString.append(JOIN_ON_MS_POST_OFFICE_USER_ON_POST_OFFICE_ID);
		queryString.append(" WHERE ttw.WF_ID = (SELECT min(ttw2.WF_ID) FROM ");
		queryString.append(schema).append(".").append(tblName).append(" ttw2 WHERE ttw2.TRN_ID=:trnId");
		if (wfActConf.getToBranchTypeId() != null) {
			queryString.append(
					" AND ttw2.ASSIGN_BY_BRANCH_ID IN (SELECT mb.BRANCH_ID FROM MASTER_V1.MS_BRANCH mb WHERE mb.BRANCH_TYPE_ID=:wfActionToBranchTypeId)");
		}
		queryString.append(" )");
		return queryString.toString();
	}

	/**
	 * Gets the actual wf role id with assign by.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @return the actual wf role id with assign by
	 */
	public static String getActualWfRoleIdWithAssignBy(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(
				"select trn.ASSIGN_TO_WF_ROLE_ID,trn.LEVEL,trn.WF_ID,ASSIGN_TO_OFFICE_ID,ASSIGN_TO_BRANCH_ID,ASSIGN_TO_GROUP_ID,trn.ASSIGN_TO_POU_ID from ")
				.append(schema).append(".").append(tblName)
				.append(" trn where trn.TRN_ID = :trnId and trn.ACTIVE_STATUS = :activeStatus");
		return queryString.toString();
	}

	/**
	 * Gets the act trn qr param map.
	 *
	 * @param trnId the trn id
	 * @return the act trn qr param map
	 */
	public static Map<String, Object> getActTrnQrParamMap(long trnId) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, trnId);
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		return params;
	}

	/**
	 * Gets the user for prev wf qr string.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @return the user for prev wf qr string
	 */
	public static String getUserForPrevWfQrString(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT pou.USER_ID,MASTER_V1.GET_WF_USER_NAME(pou.LK_PO_OFF_USER_ID),po.POST_ID,po.OFFICE_ID,ttw.ASSIGN_BY_POU_ID,ttw.ASSIGN_BY_BRANCH_ID,ttw.ASSIGN_BY_WF_ROLE_ID, ");
		queryString.append(" (SELECT tnw2.\"LEVEL\" FROM ").append(schema).append(".").append(tblName).append(
				" tnw2 WHERE tnw2.TRN_ID=ttw.TRN_ID AND tnw2.ASSIGN_TO_POU_ID=ttw.ASSIGN_BY_POU_ID AND tnw2.ASSIGN_TO_WF_ROLE_ID=ttw.ASSIGN_BY_WF_ROLE_ID AND tnw2.ASSIGN_TO_POU_ID<>tnw2.ASSIGN_BY_POU_ID AND tnw2.ASSIGN_TO_WF_ROLE_ID<>tnw2.ASSIGN_BY_WF_ROLE_ID ORDER BY WF_ID DESC LIMIT 1) ");
		queryString
				.append(" , (SELECT POST_NAME FROM MASTER_V1.MS_POST where POST_ID = po.POST_ID ) as postName FROM ");
		queryString.append(schema).append(".").append(tblName)
				.append(JOIN_ON_MS_POST_OFFICE_USER_ON_POU_ID);
		queryString.append(JOIN_ON_MS_POST_OFFICE_USER_ON_POST_OFFICE_ID);
		queryString.append(" WHERE ttw.WF_ID = (SELECT max(ttw2.WF_ID) FROM ");

		queryString.append(schema).append(".").append(tblName).append(
				" ttw2 WHERE ttw2.TRN_ID=:trnId AND ttw2.ASSIGN_TO_POU_ID=:assignToPouId AND ttw2.ASSIGN_TO_WF_ROLE_ID=:assignToWfRoleId AND ttw2.SEND_BACK_FLAG=:sendBackFlag)");
		return queryString.toString();
	}
	
		/**
	 * Gets the user for prev wf qr param map.
	 *
	 * @param dto the dto
	 * @param wfActConf the wf act conf
	 * @return the user for prev wf qr param map
	 */
	public static Map<String, Object> getUserForPrevWfQrParamMap(WfActConfUserRequestDto dto,
			GstWfActionConfigEntity wfActConf) {
		Map<String, Object> params = new HashMap<>();
		params.put("assignToPouId", dto.getPouId());
		params.put("assignToWfRoleId", wfActConf.getFromWfRoleId());
		params.put(TRN_ID, dto.getTrnId());
		params.put("sendBackFlag", SendBack.DEFUALT.getValue());
		return params;
	}

	/**
	 * Gets the user for rework wf qr string.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @param wfActConf the wf act conf
	 * @return the user for rework wf qr string
	 */
	public static String getUserForReworkWfQrString(String schema, String tblName, GstWfActionConfigEntity wfActConf) {
		StringBuilder queryString = new StringBuilder();
		//queryString.append(	"SELECT pou.USER_ID,(SELECT mu.USER_NAME FROM MASTER_V1.MS_USER mu WHERE mu.USER_ID=pou.USER_ID),po.POST_ID,po.OFFICE_ID,ttw.ASSIGN_BY_POU_ID,ttw.ASSIGN_BY_BRANCH_ID,ttw.ASSIGN_BY_WF_ROLE_ID, ");
		queryString.append("SELECT pou.USER_ID,MASTER_V1.GET_WF_USER_NAME(pou.LK_PO_OFF_USER_ID),po.POST_ID,po.OFFICE_ID,ttw.ASSIGN_BY_POU_ID,ttw.ASSIGN_BY_BRANCH_ID,ttw.ASSIGN_BY_WF_ROLE_ID, ");
		
		queryString.append(" 0 as levels ");
		queryString
				.append(" , (SELECT POST_NAME FROM MASTER_V1.MS_POST where POST_ID = po.POST_ID ) as postName FROM ");
		queryString.append(schema).append(".").append(tblName)
				.append(JOIN_ON_MS_POST_OFFICE_USER_ON_POU_ID);
		queryString.append(JOIN_ON_MS_POST_OFFICE_USER_ON_POST_OFFICE_ID);
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

	/**
	 * Gets the user for rework wf qr param map.
	 *
	 * @param dto the dto
	 * @param wfActConf the wf act conf
	 * @return the user for rework wf qr param map
	 */
	public static Map<String, Object> getUserForReworkWfQrParamMap(WfActConfUserRequestDto dto,
			GstWfActionConfigEntity wfActConf) {
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

	/**
	 * Update act sts for wf trn qr string.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @return the string
	 */
	public static String updateActStsForWfTrnQrString(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(UPDATE).append(schema).append(".").append(tblName)
				.append("  set ACTIVE_STATUS=:activeStatus where TRN_ID = :trnId ");
		return queryString.toString();
	}

	/**
	 * Update act sts for wf trn qr param map.
	 *
	 * @param trnId the trn id
	 * @return the map
	 */
	public static Map<String, Object> updateActStsForWfTrnQrParamMap(long trnId) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, trnId);
		params.put(ACTIVE_STATUS, Constant.INACTIVE_STATUS);
		return params;
	}

	/**
	 * Gets the wf trn submit sp query string.
	 *
	 * @return the wf trn submit sp query string
	 */
	public static String getWfTrnSubmitSpQueryString() {
		StringBuilder sb = new StringBuilder();
		sb.append(GstDBConstants.GST_SCHEMA.concat(Constant.DOT.concat(GstWorkFlowConstant.SP_GST_WF_TRN_SUBMIT)));
		return sb.toString();
	}

	/**
	 * Gets the wf trn submit sp query map.
	 *
	 * @param wfTrn the wf trn
	 * @param wfActConf the wf act conf
	 * @param assignToUserId the assign to user id
	 * @param assignByUserId the assign by user id
	 * @return the wf trn submit sp query map
	 */
	public static Map<String, Object> getWfTrnSubmitSpQueryMap(WfActionConfigTrnDto wfTrn,
			GstWfActionConfigEntity wfActConf, Long assignToUserId, Long assignByUserId) {
		Map<String, Object> params = new HashMap<>();
		params.put(WfTrnSubmitSp.IN_TRN_ID.name(), wfTrn.getTrnId());
		params.put(WfTrnSubmitSp.IN_ACTIONCONFIG_ID.name(), wfTrn.getActionConfigId());
		params.put(WfTrnSubmitSp.IN_WF_ACTION_ID.name(), wfActConf.getWfActionId());
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

	/**
	 * Gets the ins trn details qr string qr string.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @return the ins trn details qr string qr string
	 */
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

	/**
	 * Gets the ins trn details qr string qr param map.
	 *
	 * @param wfId the wf id
	 * @return the ins trn details qr string qr param map
	 */
	public static Map<String, Object> getInsTrnDetailsQrStringQrParamMap(long wfId) {
		Map<String, Object> params = new HashMap<>();
		params.put("wfId", wfId);
		return params;
	}

	/**
	 * Update trn attach qr str.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @return the string
	 */
	public static String updateTrnAttachQrStr(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(UPDATE).append(schema).append(".").append(tblName).append(
				"  set WF_ID=:wfId,WF_ROLE_ID=:wfRoleId where TRN_ID = :trnId and WF_ID IS NULL and WF_ROLE_ID IS NULL and ACTIVE_STATUS=:activeStatus and CATEGORY=(select lli.LOOKUP_INFO_ID from MASTER_V1.LU_LOOKUP_INFO lli  where LLI.LOOKUP_INFO_NAME =:lookUpInfoName AND lli.PARENT_LOOKUP_ID=(select ll.LOOKUP_ID from MASTER_V1.LU_LOOKUP ll where ll.LOOKUP_NAME =:lookUpName))");
		return queryString.toString();
	}

	/**
	 * Update trn attach qr param map.
	 *
	 * @param wfId the wf id
	 * @param wfRoleId the wf role id
	 * @param trnId the trn id
	 * @return the map
	 */
	public static Map<String, Object> updateTrnAttachQrParamMap(long wfId, long wfRoleId, long trnId) {
		Map<String, Object> params = new HashMap<>();
		params.put("wfId", wfId);
		params.put("wfRoleId", wfRoleId);
		params.put(TRN_ID, trnId);
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		params.put("lookUpName", GstWorkFlowConstant.LU_NAME_ATTACHMENT_CATEGORY);
		params.put("lookUpInfoName", GstWorkFlowConstant.LU_INFO_NAME_WORKFLOW);
		return params;
	}

	/**
	 * Gets the wf trn mv ly sp query map.
	 *
	 * @param submitDto the submit dto
	 * @param wfId the wf id
	 * @param assignToUserId the assign to user id
	 * @param assigneByUserId the assigne by user id
	 * @param schema the schema
	 * @param mvTblName the mv tbl name
	 * @param lyTblName the ly tbl name
	 * @return the wf trn mv ly sp query map
	 */
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

	/**
	 * Update assign to trn qr string.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @return the string
	 */
	public static String updateAssignToTrnQrString(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(UPDATE).append(schema).append(".").append(tblName).append(
				"  set ASSIGN_TO_USER_ID=:atUId,ASSIGN_TO_POST_ID=:atPId,ASSIGN_TO_POU_ID=:atPouId,ASSIGN_TO_OFFICE_ID=:atOId,ASSIGN_TO_BRANCH_ID=:atBId,ASSIGN_TO_GROUP_ID=:atGId,UPDATED_BY=:ub,UPDATED_DATE=:ubd,UPDATED_BY_POST=:ubp,ACTIVE_STATUS=:activeStatus where TRN_ID = :trnId and WF_ID= :wfId");
		return queryString.toString();
	}

	/**
	 * Update assign to trn qr param map.
	 *
	 * @param dto the dto
	 * @param assignedToDto the assigned to dto
	 * @return the map
	 */
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

	/**
	 * Ins trn save qr str.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @return the string
	 */
	public static String insTrnSaveQrStr(String schema, String tblName) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("insert into ").append(schema).append(".").append(tblName).append(
				" (TRN_ID, ACTIONCONFIG_ID, WF_ACTION_ID, ASSIGN_TO_WF_ROLE_ID, ASSIGN_TO_USER_ID, ASSIGN_TO_POST_ID, ASSIGN_TO_POU_ID, ASSIGN_TO_OFFICE_ID, ASSIGN_TO_BRANCH_ID, ASSIGN_TO_GROUP_ID, WF_STATUS, TRN_STATUS, ASSIGN_BY_WF_ROLE_ID, ASSIGN_BY_USER_ID, ASSIGN_BY_POST_ID, ASSIGN_BY_POU_ID, ASSIGN_BY_OFFICE_ID, ASSIGN_BY_BRANCH_ID, ASSIGN_BY_GROUP_ID, REMARKS, CREATED_BY, CREATED_DATE, CREATED_BY_POST, UPDATED_BY, UPDATED_DATE, UPDATED_BY_POST, ACTIVE_STATUS)")
				.append(" VALUES(:trnId, :actionConfigId, :wfActionId, :atWfRlId, :atUId, :atPId, :atPouId, :atOId, :atBId, :atGId, :wfStatus, :trnStatus, :abWfRlId, :abUId, :abPId, :abPouId, :abOId, :abBId, :abGId, :remarks, :cb, :cbd, :cbp, :ub, :ubd, :ubp, :activeStatus)");
		return queryString.toString();
	}

	/**
	 * Ins trn save qr param map.
	 *
	 * @param dto the dto
	 * @param assignedToDto the assigned to dto
	 * @return the map
	 */
	public static Map<String, Object> insTrnSaveQrParamMap(WfUserReqSDDto dto, AssignedToTrnDto assignedToDto) {
		Map<String, Object> params = new HashMap<>();
		params.put(TRN_ID, dto.getTrnId());
		params.put("actionConfigId", null);
		params.put("wfActionId", GstWorkFlowConstant.WF_ACTION_SAVE_DRAFT);
		params.put("atWfRlId", assignedToDto.getAssignToWfRoleId());
		params.put(ASSIGN_TO_USER_ID, dto.getUserId());
		params.put(ASSIGN_TO_POST_ID, dto.getPostId());
		params.put(ASSIGN_TO_POU_ID, dto.getPouId());
		params.put(ASSIGN_TO_OFFICE_ID, dto.getOfficeId());
		params.put(ASSIGN_TO_BRANCH_ID, dto.getBranchId());
		params.put(ASSIGN_TO_GROUP_ID, null);
		params.put("wfStatus", GstWorkFlowConstant.WF_ACTION_SAVE_DRAFT_STATUS);
		params.put("trnStatus", GstWorkFlowConstant.WF_ACTION_SAVE_DRAFT_STATUS);
		params.put("abWfRlId", assignedToDto.getAssignToWfRoleId());
		params.put("abUId", dto.getUserId());
		params.put("abPId", dto.getPostId());
		params.put("abPouId", dto.getPouId());
		params.put("abOId", dto.getOfficeId());
		params.put("abBId", dto.getBranchId());
		params.put("abGId", null);
		params.put("remarks", GstWorkFlowConstant.WF_ACTION_SAVE_DRAFT_STATUS);
		params.put("cb", dto.getUserId());
		params.put("cbd", new Date());
		params.put("cbp", dto.getPostId());
		params.put("ub", dto.getUserId());
		params.put("ubd", new Date());
		params.put("ubp", dto.getPostId());
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		return params;
	}

	/**
	 * Gets the wf act code and name qr str.
	 *
	 * @return the wf act code and name qr str
	 */
	public static String getWfActCodeAndNameQrStr() {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT wmwa.WF_ACTION_CODE,wmwa.WF_ACTION_NAME from MASTER_V1.WF_MS_WORKFLOW_ACTIONS wmwa ");
		queryString.append("where wmwa.WF_ACTION_ID=:wfActionId ");
		queryString.append("AND wmwa.ACTIVE_STATUS = :activeStatus ");
		return queryString.toString();
	}

	/**
	 * Gets the wf act code and name qr map.
	 *
	 * @param wfActionId the wf action id
	 * @return the wf act code and name qr map
	 */
	public static Map<String, Object> getWfActCodeAndNameQrMap(long wfActionId) {
		Map<String, Object> params = new HashMap<>();
		params.put("wfActionId", wfActionId);
		params.put(ACTIVE_STATUS, Constant.ACTIVE_STATUS);
		return params;
	}
	
	
	/**
	 * Gets the ins trn details qr string.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @return the ins trn details qr string
	 */
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
				.append(" trn RIGHT JOIN DPFF.TPEN_WF_REQUEST_DET wrd ON trn.WF_ID=wrd.WF_ID JOIN DPFF.TPEN_WF_REQUEST wr ON wr.WF_REQUEST_ID=wrd.WF_REQUEST_ID WHERE wr.WF_REQUEST_NO=:wfReqNo ");
		return queryString.toString();
	}

	/**
	 * Gets the ins trn details qr param map.
	 *
	 * @param wfReqNo the wf req no
	 * @return the ins trn details qr param map
	 */
	public static Map<String, Object> getInsTrnDetailsQrParamMap(String wfReqNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("wfReqNo", wfReqNo);
		return params;
	}

	/**
	 * Gets the intiator details.
	 *
	 * @param schema the schema
	 * @param tblName the tbl name
	 * @return the intiator details
	 */
	public static String getIntiatorDetails(String schema, String tblName) {
		String tblId = tblName + "_ID";
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT ");
		queryString.append(
				" pou.USER_ID,(SELECT USER_NAME FROM MASTER_V1.MS_USER WHERE USER_ID=pou.USER_ID), po.POST_ID, po.OFFICE_ID, pou.LK_PO_OFF_USER_ID ");
		queryString.append(" FROM ").append(schema).append(".").append(tblName)
				.append(" trn JOIN MASTER_V1.LK_PO_OFF_USER pou ON trn.ASSIGN_BY_POU_ID = pou.LK_PO_OFF_USER_ID ");
		queryString.append(JOIN_ON_MS_POST_OFFICE_USER_ON_POST_OFFICE_ID);
		queryString.append(" WHERE trn.").append(tblId).append(" = (SELECT MAX(t.").append(tblId).append(")  FROM ");
		queryString.append(schema).append(".").append(tblName)
				.append(" t WHERE t.TRN_ID = :trnId AND t.MENU_ID = :menuId)");
		return queryString.toString();
	}	
	

	/**
	 * Update GST wf req status qr str.
	 *
	 * @return the string
	 */
	public static String updatePensionWfReqStatusQrStr() {
		StringBuilder queryString = new StringBuilder();
		queryString.append("UPDATE DPFF.DPFF_WF_REQUEST wfReq SET wfReq.STATUS_ID =:statusId, wfReq.UPDATED_BY =:updatedBy, wfReq.UPDATED_BY_POST =:updatedByPost, wfReq.UPDATED_DATE =:updatedDate WHERE wfReq.WF_REQUEST_ID =:wfRequestId");
		return queryString.toString();
	}

	/**
	 * Update GST wf req status qr param map.
	 *
	 * @param statusId the status id
	 * @param userId the user id
	 * @param postId the post id
	 * @param wfRequestId the wf request id
	 * @return the map
	 */
	public static Map<String, Object> updatePensionWfReqStatusQrParamMap(long statusId,long userId,long postId,long wfRequestId) {
		Map<String, Object> params = new HashMap<>();
		params.put("statusId", statusId);
		params.put("updatedBy", userId);
		params.put("updatedByPost", postId);
		params.put("updatedDate", new Date());
		params.put("wfRequestId", wfRequestId);
		return params;
	}


	/**
	 * Gets the wf trn bulk op V 3 SP map single.
	 *
	 * @param trnId the trn id
	 * @param assignTo the assign to
	 * @param assignByPouId the assign by pou id
	 * @param wfActConf the wf act conf
	 * @param wfRequestId the wf request id
	 * @param remarks the remarks
	 * @param branchId the branch id
	 * @return the wf trn bulk op V 3 SP map single
	 */
	public static Map<String, Object> getWfTrnBulkOpV3SPMapSingle(long trnId, WfUserDetailsV3 assignTo,
																  long assignByPouId, GstWfActionConfigEntity wfActConf, long wfRequestId, String remarks, Long branchId) {
		Map<String, Object> params = new HashMap<>();
		params.put(WfTrnSubmitSp.IN_TRN_ID.name(), trnId);
		params.put(WfTrnSubmitSp.IN_ACTIONCONFIG_ID.name(), wfActConf.getActionConfigId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POU_ID.name(), assignTo.getPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_OFFICE_ID.name(), assignTo.getOfficeId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_BRANCH_ID.name(), assignTo.getBranchId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POU_ID.name(), assignByPouId);
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_BRANCH_ID.name(), branchId);
		params.put(WfTrnSubmitSp.IN_REMARKS.name(), remarks);
		params.put(WfTrnSubmitSp.IN_WF_REQ_ID.name(), wfRequestId);
		return params;
	}

	/**
	 * Gets the wf trn bulk op V 3 SP map single.
	 *
	 * @param trn the trn
	 * @param assignByPouId the assign by pou id
	 * @param wfActConf the wf act conf
	 * @param wfRequestId the wf request id
	 * @param branchId the branch id
	 * @return the wf trn bulk op V 3 SP map single
	 */
	public static Map<String, Object> getWfTrnBulkOpV3SPMapSingle(GstTrnIdRemAssToUserDto trn,
			WfUserDetailsV3 assignByLoginUser, GstWfActionConfigEntity wfActConf, long wfRequestId) {
		Map<String, Object> params = new HashMap<>();
		params.put(WfTrnSubmitSp.IN_TRN_ID.name(), trn.getTrnId());
		params.put(WfTrnSubmitSp.IN_ACTIONCONFIG_ID.name(), wfActConf.getActionConfigId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POU_ID.name(), trn.getPouId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_OFFICE_ID.name(), trn.getOfficeId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POU_ID.name(), assignByLoginUser.getPouId());
		params.put(WfTrnSubmitSp.IN_REMARKS.name(), trn.getRemarks());
		params.put(WfTrnSubmitSp.IN_WF_REQ_ID.name(), wfRequestId);
		params.put(WfTrnSubmitSp.IN_WF_ACTION_ID.name(), wfActConf.getWfActionId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_WF_ROLE_ID.name(), trn.getWfRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_USER_ID.name(), trn.getUserId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_POST_ID.name(), trn.getPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_BRANCH_ID.name(), 0);
		params.put(WfTrnSubmitSp.IN_ASSIGN_TO_GROUP_ID.name(), 0);
		params.put(WfTrnSubmitSp.IN_WF_STATUS.name(), wfActConf.getToWfStatus());
		params.put(WfTrnSubmitSp.IN_TRN_STATUS.name(), wfActConf.getToStatus());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_WF_ROLE_ID.name(), assignByLoginUser.getWfRoleId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_USER_ID.name(), assignByLoginUser.getUserId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_POST_ID.name(), assignByLoginUser.getPostId());
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_OFFICE_ID.name(), assignByLoginUser.getOfficeId());
		if (null != assignByLoginUser.getBranchId()) {
			params.put(WfTrnSubmitSp.IN_ASSIGN_BY_BRANCH_ID.name(), assignByLoginUser.getBranchId());
		} else {
			params.put(WfTrnSubmitSp.IN_ASSIGN_BY_BRANCH_ID.name(), 0);
		}
		params.put(WfTrnSubmitSp.IN_ASSIGN_BY_GROUP_ID.name(), 0);
		params.put(WfTrnSubmitSp.IN_SEND_BACK_FLAG.name(), wfActConf.getSendBackFlag());
		params.put(WfTrnSubmitSp.IN_LEVEL.name(), trn.getLevel());
		return params;
	}

	/**
	 * Gets the menu tbl info from menu id qr str.
	 *
	 * @return the menu tbl info from menu id qr str
	 */
	public static String getBankRateMasterWfStatusFromTrnIdQrStr() {
		StringBuilder queryString = new StringBuilder();
		queryString.append("select TRN_STATUS from EPAO.MPAO_BANK_RATE_MASTER_WF ");
		queryString.append("where TRN_ID = :trnId AND ACTIVE_STATUS= :activeStatus ORDER BY TRN_ID DESC LIMIT 1 ");
		return queryString.toString();
	}

	public static Map<String, Object> getBankRateMasterWfStatusFromTrnIdQrMap(long trnId) {
		Map<String, Object> params = new HashMap<>();
		params.put("trnId", trnId);
		params.put("activeStatus", Constant.ACTIVE_STATUS);
		return params;
	}
	
}
