package gov.ifms.loc.workflow.util;

/**
 * The Class LocWorkFlowConstant.
 */
public class LocWorkFlowConstant {

    /**
     * Instantiates a new loc work flow constant.
     */
    private LocWorkFlowConstant() {
		super();
	}

	/** The Constant LU_NAME_ATTACHMENT_CATEGORY. */
	public static final String LU_NAME_ATTACHMENT_CATEGORY = "Attachment Category";

	/** The Constant LU_INFO_NAME_WORKFLOW. */
	public static final String LU_INFO_NAME_WORKFLOW = "Workflow";

	/** The Constant WF_ACTION_SAVE_DRAFT. */
	public static final long WF_ACTION_SAVE_DRAFT = 2;

	/** The Constant WF_ACTION_SAVE_DRAFT_STATUS. */
	public static final String WF_ACTION_SAVE_DRAFT_STATUS = "Draft";

	/** The Constant DEFAULT_IS_CO. */
	public static final int DEFAULT_IS_CO = -1;

	/** The Constant DEFAULT_IS_TO. */
	public static final int DEFAULT_IS_TO = -1;

	/** The Constant WF_ROLE_ID_MINISTER. */
	public static final long WF_ROLE_ID_MINISTER = 28;

	/** The Constant LU_APPROVED_LOOKUP_INFO_ID. */
	public static final long LU_APPROVED_LOOKUP_INFO_ID = 327;

	/** The Constant LU_ACTIVE_LOOKUP_INFO_ID. */
	public static final long LU_ACTIVE_LOOKUP_INFO_ID = 283;

	/** The Constant LU_YES_LOOKUP_INFO_ID. */
	public static final long LU_YES_LOOKUP_INFO_ID = 2;

	/** The Constant DEFAULT_WF_SUBMIT_ACTION_LEVEL. */
	public static final int DEFAULT_WF_SUBMIT_ACTION_LEVEL = -10;

	/** The Constant WF_ACTION_APPROVE. */
	public static final String WF_ACTION_APPROVE = "Approve";

	/** The Constant IS_CO_OFFICE_ZERO. */
	public static final int IS_CO_OFFICE_ZERO = 0;

	/** The Constant IS_FD_OFFICE_ZERO. */
	public static final int IS_FD_OFFICE_ZERO = 0;

	/** The Constant IS_CO_OFFICE_ONE. */
	public static final int IS_CO_OFFICE_ONE = 1;

	/** The Constant IS_FD_OFFICE_ONE. */
	public static final int IS_FD_OFFICE_ONE = 1;

	/** The Constant IS_TO_OFFICE_ZERO. */
	public static final int IS_TO_OFFICE_ZERO = 0;

	/** The Constant IS_TO_OFFICE_ONE. */
	public static final int IS_TO_OFFICE_ONE = 1;

	/** The Constant TRN_ID. */
	public static final String TRN_ID = "trnId";

	/** The Constant DEFAULT_IS_DISPLAY_IN_POPUP. */
	public static final int DEFAULT_IS_DISPLAY_IN_POPUP = 1;

	/** The Constant DIRECT_IS_DISPLAY_IN_POPUP. */
	public static final int DIRECT_IS_DISPLAY_IN_POPUP = 0;

	/** The Constant DEFAULT_WF_ACTION_LEVEL. */
	public static final int DEFAULT_WF_ACTION_LEVEL = 0;

	/** The Constant SP_LOC_WF_TRN_SUBMIT. */
	public static final String SP_LOC_WF_TRN_SUBMIT = "LOC_WF_TRN_SUBMIT";

	/** The Constant SP_LOC_WF_TRN_MV_LY_SUBMIT. */
	public static final String SP_LOC_WF_TRN_MV_LY_SUBMIT = "LOC_WF_TRN_MOVE_SUBMIT";	

	/** The Constant LU_LOOKUP_NAME_WF_REQ_STATUS. */
	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS = "Workflow Request Status";

	/** The Constant LU_LOOKUP_NAME_WF_REQ_STATUS_INIT. */
	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_INIT = "Initiated";

	/** The Constant LU_LOOKUP_NAME_WF_REQ_STATUS_IN_PROGRESS. */
	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_IN_PROGRESS = "In Progress";

	/** The Constant LU_LOOKUP_NAME_WF_REQ_STATUS_SUCCESSFUL. */
	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_SUCCESSFUL = "Successful";

	/** The Constant LU_LOOKUP_NAME_WF_REQ_STATUS_FAILED. */
	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_FAILED = "Failed";

	/** The Constant LU_LOOKUP_NAME_WF_REQ_STATUS_PARTIALLY_FAILED. */
	public static final String LU_LOOKUP_NAME_WF_REQ_STATUS_PARTIALLY_FAILED = "Partially Failed";

	/** The Constant WF_TRN_BULK_SUBMIT_V3. */
	public static final String WF_TRN_BULK_SUBMIT_V3 = "LOC_WF_TRN_SUBMIT_V3";	

	/** The Constant WF_REQ_INITIATED_MSG. */
	public static final String WF_REQ_INITIATED_MSG = "Your request is Initiated with Request No. %s";

	/** The Constant WF_REQ_INITIATED_RESULT. */
	public static final String WF_REQ_INITIATED_RESULT = "Please check status of workflow request by requesting the URL. - %s";

}
