package gov.ifms.workflow.util;

public class WorkFlowConstant {

	private WorkFlowConstant() {
		super();
	}

	public static final String SP_INS_TRN_BUD_WF = "SP_INS_TRN_BUD_WF";
	public static final String DEFAULT_WF_ROLE = "CREATOR";
	public static final int DEFAULT_WF_ACTION_LEVEL = 0;
	public static final long DEFAULT_ASSIGN_TO_WF_RL = 0;
	public static final String SP_INS_TRN_EDP_WF = "SP_INS_TRN_EDP_WF";
	public static final String SP_INS_TRN_PVU_WF = "SP_INS_TRN_PVU_WF";
	public static final String SP_INS_TRN_PVU_WF_MULTIPLE = "SP_INS_TRN_PVU_WF_MULTIPLE";
	public static final String SP_WF_TRN_SUBMIT = "WF_TRN_SUBMIT";
	public static final String SP_WF_TRN_MV_LY_SUBMIT = "WF_TRN_MOVE_SUBMIT";
	public static final String STRING = "string";
	public static final String WF_ACTION_RETURN_CODE = "1013";

	public static final String PF_CREATOR_WF_CODE = "\'1000\'";
	public static final String PF_VERIFIER_WF_CODE = "\'1001\'";
	public static final String PF_APPROVER_WF_CODE = "\'1002\'";

	public static final String PF_CREATOR_WF = "1000";
	public static final String PF_VERIFIER_WF = "1001";
	public static final String PF_APPROVER_WF = "1002";

	public static final String PVU_INWARD = "\'1003\'";
	public static final String PVU_DISTRIBUTE = "\'1004\'";

	public static final String PVU_PRINT_ENDORSEMENT_WF_CODE = "\'1008\'";
	public static final String PVU_PRINT_ENDORSEMENT_WF = "1008";

	public static final String PVU_OUTWARD = "\'1009\'";

	public static final String PVU_AUDITOR_WF_CODE = "\'1005\'";
	public static final String PVU_AUDITOR_WF = "1005";
	public static final String PVU_VERIFIER_WF_CODE = "\'1019\'";
	public static final String PVU_VERIFIER_WF = "1018";

	public static final String PVU_APRROVER_CLASS_II_WF_CODE = "\'1006\'";
	public static final String PVU_APRROVER_CLASS_II_WF = "1006";

	public static final String PVU_APRROVER_CLASS_I_WF_CODE = "\'1007\'";
	public static final String PVU_APRROVER_CLASS_I_WF = "1007";

	public static final String PVU_APPROVED_CLASS_FINAL_STATUS = "\'Authorised by Class II\',\'Returned  by PVU Approver Class II\',\'Authorised by Class I\',\'Returned  by PVU Approver Class I\'";

	public static final int SAME_USER_SELECT = 2;

	public static final String LU_NAME_ATTACHMENT_CATEGORY = "Attachment Category";

	public static final String LU_INFO_NAME_WORKFLOW = "Workflow";

	public static final long WF_ACTION_SAVE_DRAFT = 2;

	public static final String WF_ACTION_SAVE_DRAFT_STATUS = "Draft";

	public static final int DEFAULT_IS_CO = -1;

	public static final int DEFAULT_IS_FD = -1;

	public static final long WF_ROLE_ID_MINISTER = 28;

	public static final long LU_APPROVED_LOOKUP_INFO_ID = 327;

	public static final long LU_ACTIVE_LOOKUP_INFO_ID = 283;

	public static final long LU_YES_LOOKUP_INFO_ID = 2;

	public static final int DEFAULT_WF_SUBMIT_ACTION_LEVEL = -10;

	public static final String WF_ACTION_APPROVE = "Approve";

	public static final int IS_CO_OFFICE_ZERO = 0;

	public static final int IS_FD_OFFICE_ZERO = 0;

	public static final int IS_CO_OFFICE_ONE = 1;

	public static final int IS_FD_OFFICE_ONE = 1;

	public static final String TRN_ID = "trnId";

	public static final int DEFAULT_IS_DISPLAY_IN_POPUP = 1;

	public static final int DIRECT_IS_DISPLAY_IN_POPUP = 0;

	public static final long WF_ROLE_ID_DEPARTMENT_GRANT_APPROVER = 48l;

	public static final long WF_ROLE_ID_CO_APPROVER = 51l;

	public static final String WF_TRN_BULK_SUBMIT_V3 = "WF_TRN_SUBMIT_V3";

	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS = "Workflow Request Status";

	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_INIT = "Initiated";

	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_IN_PROGRESS = "In Progress";

	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_SUCCESSFUL = "Successful";

	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_FAILED = "Failed";

	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_PARTIALLY_FAILED = "Partially Failed";

    public static final String ST_ACTIVE_STATUS ="activeStatus";
}
