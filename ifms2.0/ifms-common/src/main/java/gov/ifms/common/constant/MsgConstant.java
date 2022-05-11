package gov.ifms.common.constant;

import gov.ifms.common.util.MessageUtil;

/**
 * the MsgConstant for constant of properties file.
 */
public class MsgConstant {
	/**
	 * Instantiates a new msg constant.
	 */
	private MsgConstant() {
		super();
	}

	/** The Constant EDP_MSG_FETCH_LIST. */
	public static final String EDP_MSG_FETCH_LIST = MessageUtil.getMsg("EDP.FETCH.LIST");

	/** The Constant EDP_MSG_FETCH. */
	public static final String EDP_MSG_FETCH = MessageUtil.getMsg("EDP.FETCH");

	/** The Constant EDP_MSG_CREATE. */
	public static final String EDP_MSG_CREATE = MessageUtil.getMsg("EDP.CREATE");

	/** The Constant EDP_MSG_UPDATE. */
	public static final String EDP_MSG_UPDATE = MessageUtil.getMsg("EDP.UPDATE");

	/** The Constant EDP_MSG_DELETE. */
	public static final String EDP_MSG_DELETE = MessageUtil.getMsg("EDP.DELETE");

	/** The Constant BUDGET_MSG_FETCH_LIST. */
	public static final String BUDGET_MSG_FETCH_LIST = MessageUtil.getMsg("BUDGET.FETCH.LIST");

	/** The Constant BUDGET_MSG_FETCH. */
	public static final String BUDGET_MSG_FETCH = MessageUtil.getMsg("BUDGET.FETCH");

	/** The Constant BUDGET_MSG_FETCH. */
	public static final String BUDGET_MSG_FETCH_ERROR = MessageUtil.getMsg("BUDGET.FETCH.ERROR");

	/** The Constant BUDGET_MSG_CREATE. */
	public static final String BUDGET_MSG_CREATE = MessageUtil.getMsg("BUDGET.CREATE");

	/** The Constant BUDGET_MSG_SUBMIT. */
	public static final String BUDGET_MSG_SUBMIT = MessageUtil.getMsg("BUDGET.SUBMIT");

	/** The Constant BUDGET_MSG_UPDATE. */
	public static final String BUDGET_MSG_UPDATE = MessageUtil.getMsg("BUDGET.UPDATE");

	/** The Constant BUDGET_MSG_CREATE. */
	public static final String BUDGET_CEILING_MSG_SAVE = MessageUtil.getMsg("BUDGET.CEILING.SAVE");

	/** The Constant BUDGET_MSG_CREATE. */
	public static final String BUDGET_CEILING_MSG_SUBMIT = MessageUtil.getMsg("BUDGET.CEILING.SUBMIT");

	/** The Constant BUDGET_MSG_DELETE. */
	public static final String BUDGET_MSG_DELETE = MessageUtil.getMsg("BUDGET.DELETE");

	/** The Constant BUDGET_MSG_DOWNLOAD. */
	public static final String BUDGET_MSG_DOWNLOAD = MessageUtil.getMsg("BUDGET.DOWNLOAD");

	/** The Constant BUDGET_MSG_SAVE_FILE. */
	public static final String BUDGET_MSG_SAVE = MessageUtil.getMsg("BUDGET.SAVE");

	/** The Constant BUDGET_ERROR_SERVER. */
	public static final String BUDGET_ERROR_SERVER = MessageUtil.getMsg("BUDGET.ERROR.SERVER");

	/** The Constant BUDGET_MSG UPLOAD. */
	public static final String BUDGET_MSG_UPLOAD = MessageUtil.getMsg("BUDGET.UPLOAD");

	/** The Constant BUDGET_MSG_INVALID_FILES. */
	public static final String BUDGET_MSG_INVALID_FILES = MessageUtil.getMsg("BUDGET.INVALID_FILE");

	/** The Constant BUDGET_MSG_ALREADY_SUBMIT. */
	public static final String BUDGET_MSG_ALREADY_SUBMIT = MessageUtil.getMsg("BUDGET.ALREADY.UPDATE");

	/** The Constant BUDGET_MSG_ALREADY_CREATED. */
	public static final String BUDGET_MSG_ALREADY_CREATED = MessageUtil.getMsg("BUDGET.ALREADY.CREATE");
	
	/** The Constant WORKFLOW_MSG_FETCH_LIST. */
	public static final String WORKFLOW_MSG_FETCH_LIST = MessageUtil.getMsg("WORKFLOW.FETCH.LIST");
	
	/** The Constant WORKFLOW_MSG_FETCH. */
	public static final String WORKFLOW_MSG_FETCH = MessageUtil.getMsg("WORKFLOW.FETCH");
	
	/** The Constant WORKFLOW_MSG_CREATE. */
	public static final String WORKFLOW_MSG_CREATE = MessageUtil.getMsg("WORKFLOW.CREATE");
	
	/** The Constant WORKFLOW_MSG_UPDATE. */
	public static final String WORKFLOW_MSG_UPDATE = MessageUtil.getMsg("WORKFLOW.UPDATE");
	
	/** The Constant WORKFLOW_MSG_DELETE. */
	public static final String WORKFLOW_MSG_DELETE = MessageUtil.getMsg("WORKFLOW.DELETE");
	
	/** The Constant EDP_MSG_ALREADY_SUBMIT. */
	public static final String EDP_MSG_ALREADY_SUBMIT = MessageUtil.getMsg("EDP.ALREADY.UPDATE");
	
	/** The Constant RECORD_NOT_FOUND. */
	public static final String RECORD_NOT_FOUND = MessageUtil.getMsg("ERRORRESP.RECORD_NOT_FOUND");
	
	/** The Constant DUPLICATE_ROWS_FOUND. */
	public static final String DUPLICATE_ROWS_FOUND = MessageUtil.getMsg("ERRORRESP.DUPLICATE_ROWS_FOUND");
	
	/** The Constant REFERENCE_NOT_EXISTS. */
	public static final String REFERENCE_NOT_EXISTS = MessageUtil.getMsg("ERRORRESP.REFERENCE_NOT_EXISTS");
	
	/** The Constant INVALID_JSON_FORMAT. */
	public static final String INVALID_JSON_FORMAT = MessageUtil.getMsg("ERRORRESP.INVALID_JSON_FORMAT");
	
	/** The Constant ERROR_WHILE_FATCHING. */
	public static final String ERROR_WHILE_FATCHING = MessageUtil.getMsg("ERRORRESP.ERROR_WHILE_FATCHING");
	
	/** The Constant ERROR_WHILE_CREATE. */
	public static final String ERROR_WHILE_CREATE = MessageUtil.getMsg("ERRORRESP.ERROR_WHILE_CREATE");
	
	/** The Constant ERROR_WHILE_UPDATE. */
	public static final String ERROR_WHILE_UPDATE = MessageUtil.getMsg("ERRORRESP.ERROR_WHILE_UPDATE");
	
	/** The Constant ERROR_WHILE_UPDATE_ACTIVESTATUS. */
	public static final String ERROR_WHILE_UPDATE_ACTIVESTATUS = MessageUtil
			.getMsg("ERRORRESP.ERROR_WHILE_UPDATE_ACTIVESTATUS");
	
	/** The Constant UNKNOWN_ERROR_OCCURED. */
	public static final String UNKNOWN_ERROR_OCCURED = MessageUtil.getMsg("ERRORRESP.UNKNOWN_ERROR_OCCURED");
	
	/** The Constant JSON_PARSING_ERROR. */
	public static final String JSON_PARSING_ERROR = MessageUtil.getMsg("ERRORRESP.JSON_PARSING_ERROR");
	
	/** The Constant UNSUPPORTED_MEDIA_TYPE. */
	public static final String UNSUPPORTED_MEDIA_TYPE = MessageUtil.getMsg("ERRORRESP.UNSUPPORTED_MEDIA_TYPE");
	
	/** The Constant JSON_RESPONSE_ERROR. */
	public static final String JSON_RESPONSE_ERROR = MessageUtil.getMsg("ERRORRESP.JSON_RESPONSE_ERROR");
	
	/** The Constant WF_ACTIONS_NOT_ALLOWED. */
	public static final String WF_ACTIONS_NOT_ALLOWED = MessageUtil.getMsg("WORKFLOW.ACTION.NOTALLOWED");
	
	/** The Constant ERROR_WHILE_DELETE. */
	public static final String ERROR_WHILE_DELETE = MessageUtil.getMsg("ERRORRESP.ERROR_WHILE_DELETE");
	
	/** The Constant INVALID_URL_FOUND. */
	public static final String INVALID_URL_FOUND = MessageUtil.getMsg("ERRORRESP.INVALID_URL_FOUND");
	
	/** The Constant ERROR_WHILE_DOWNLOAD. */
	public static final String ERROR_WHILE_DOWNLOAD = MessageUtil.getMsg("ERRORRESP.ERROR_WHILE_DOWNLOAD");
	
	/** The Constant ERROR_WHILE_SAVEFILE. */
	public static final String ERROR_WHILE_SAVEFILE = MessageUtil.getMsg("ERRORRESP.ERROR_WHILE_SAVEFILE");
	
	/** The Constant FILE_NOT_FOUND. */
	public static final String FILE_NOT_FOUND = MessageUtil.getMsg("ERRORRESP.FILE_NOT_FOUND");
	
	/** The Constant VALIDATIONS_FAILED. */
	public static final String VALIDATIONS_FAILED = MessageUtil.getMsg("ERRORRESP.VALIDATIONS_FAILED");
	
	/** The Constant RECORD_ALREADY_EXISTS. */
	public static final String RECORD_ALREADY_EXISTS = MessageUtil.getMsg("ERRORRESP.RECORD_ALREADY_EXISTS");
	
	/** The Constant FILESIZE_EXCEEDS_LIMIT. */
	public static final String FILESIZE_EXCEEDS_LIMIT = MessageUtil.getMsg("ERRORRESP.FILE_SIZE_LIMIT");
	
	/** The Constant ATTACHMENT_NOT_FOUND. */
	public static final String ATTACHMENT_NOT_FOUND = MessageUtil.getMsg("ERRORRESP.ATTACHMENT_NOT_FOUND");
	
	/** The Constant NOT_FOUND_MENU_CODE. */
	public static final String NOT_FOUND_MENU_CODE = MessageUtil.getMsg("ERRORRESP.NOT_FOUND_MENU_CODE");
	
	/** The Constant IFMS_MSG_FETCH_LIST. */
	public static final String IFMS_MSG_FETCH_LIST = MessageUtil.getMsg("IFMS.FETCH.LIST");
	
	/** The Constant IFMS_MSG_FETCH. */
	public static final String IFMS_MSG_FETCH = MessageUtil.getMsg("IFMS.FETCH");
	
	/** The Constant IFMS_MSG_CREATE. */
	public static final String IFMS_MSG_CREATE = MessageUtil.getMsg("IFMS.CREATE");
	
	/** The Constant IFMS_MSG_CREATE. */
	public static final String IFMS_LOCK_CREATE = MessageUtil.getMsg("IFMS.LOCK");

	/** The Constant IFMS.FORWARD.SUCCESS. */
	public static final String IFMS_FORWARD_SUCCESS = MessageUtil.getMsg("IFMS.FORWARD.SUCCESS");
	
	public static final String IFMS_MSG_ACCEPT_DOC =MessageUtil.getMsg("IFMS.ACCEPT.DOC");
	
	/** The Constant IFMS_MSG_UPDATE. */
	public static final String IFMS_MSG_UPDATE = MessageUtil.getMsg("IFMS.UPDATE");
	
	/** The Constant IFMS_MSG_DELETE. */
	public static final String IFMS_MSG_DELETE = MessageUtil.getMsg("IFMS.DELETE");
	
	/** The Constant ATTACHMENT_MSG_FETCH. */
	public static final String ATTACHMENT_MSG_FETCH = MessageUtil.getMsg("ATTACHMENTMASTER.FETCH");
	
	/** The Constant ATTACHMENT_MSG_CREATE. */
	public static final String ATTACHMENT_MSG_CREATE = MessageUtil.getMsg("ATTACHMENT.CREATE");
	
	/** The Constant ATTACHMENT_MSG_UPLOAD. */
	public static final String ATTACHMENT_MSG_UPLOAD = MessageUtil.getMsg("ATTACHMENT.UPLOAD");
	
	/** The Constant ATTACHMENT_MSG_UPLOAD_ERROR. */
	public static final String ATTACHMENT_MSG_UPLOAD_ERROR = MessageUtil.getMsg("ATTACHMENT.UPLOAD.ERROR");
	
	/** The Constant ATTACHMENT_MSG_DOWNLOAD. */
	public static final String ATTACHMENT_MSG_DOWNLOAD = MessageUtil.getMsg("ATTACHMENT.DOWNLOAD");
	
	/** The Constant ATTACHMENT_ERROR_MENUID. */
	public static final String ATTACHMENT_ERROR_MENUID = MessageUtil.getMsg("ATTACHMENT.ERROR.MENUID");
	
	/** The Constant FOR MAIL SEND FROM ID. */
	public static final String SEND_EMAIL_FROM = MessageUtil.getMsg("EMAIL_FROM");
	
	/** The Constant EDP_MSG_ALREADY_DELETE. */
	public static final String EDP_MSG_ALREADY_DELETE = MessageUtil.getMsg("EDP.ALREADY.DELETE");
	
	/** The Constant EDP_APPROVED_RECORD. */
	public static final String EDP_APPROVED_RECORD = MessageUtil.getMsg("EDP.APPROVED.RECORD");
	
	/** The Constant EDP_FRESH_RECORD. */
	public static final String EDP_FRESH_RECORD = MessageUtil.getMsg("EDP.FRESH.RECORD");
	
	/** The Constant EDP_REQUEST_INITIATE. */
	public static final String EDP_REQUEST_INITIATE_NOT_SAME = MessageUtil
			.getMsg("EDP.REQUEST.INITIATE.RIGHTS.MAPPING.NOT.SAME");
	
	/** The Constant EDP_REQUEST_INITIATE. */
	public static final String EDP_REQUEST_INITIATE_SAME = MessageUtil
			.getMsg("EDP.REQUEST.INITIATE.RIGHTS.MAPPING.SAME");
	
	/** The Constant EMP_ALREADY_APPROVED. */
	public static final String EMP_ALREADY_APPROVED = MessageUtil.getMsg("PVU.ALREADY.APPROVED");
	
	/** The Constant TRANSFER_NOT_ALLOWED. */
	public static final String TRANSFER_NOT_ALLOWED = MessageUtil.getMsg("PVU.EVENT.TRANSFER.NOT.ALLOWED");
	
	/** The Constant IFMS_MSG_SUBMITTED. */
	public static final String IFMS_MSG_SUBMITTED = MessageUtil.getMsg("IFMS.SUBMITTED");
	
	/** The Constant CLASS_NOT_ALLOWED. */
	public static final String CLASS_NOT_ALLOWED = MessageUtil.getMsg("ERRORRESP.CLASS_NOT_ALLOWED");
	
	/** The Constant CLASS_NOT_ALLOWED. */
	public static final String LEVEL_NOT_ALLOWED = MessageUtil.getMsg("ERRORRESP.LEVEL_NOT_ALLOWED");
	
	/** The Constant CELL_NOT_ALLOWED. */
	public static final String CELL_NOT_ALLOWED = MessageUtil.getMsg("ERRORRESP.CELL_NOT_ALLOWED");
	
	/** The Constant CLASS_NOT_ALLOWED. */
	public static final String LEVEL_LOWER_NOT_ALLOWED = MessageUtil.getMsg("ERRORRESP.LEVEL_LOWER_NOT_ALLOWED");
	
	/** The Constant CELL_NOT_ALLOWED. */
	public static final String PAY_SCALE_LOWER_NOT_ALLOWED = MessageUtil
			.getMsg("ERRORRESP.PAY_SCALE_LOWER_NOT_ALLOWED");
	
	/** The Constant PAY_BAND_NOT_ALLOWED. */
	public static final String PAY_BAND_LOWER_NOT_ALLOWED = MessageUtil.getMsg("ERRORRESP.PAY_BAND_LOWER_NOT_ALLOWED");
	
	/** The Constant GRADE_PAY_NOT_ALLOWED. */
	public static final String GRADE_PAY_LOWER_NOT_ALLOWED = MessageUtil
			.getMsg("ERRORRESP.GRADE_PAY_LOWER_NOT_ALLOWED");
	
	/** The Constant PVU_PROMOTION_ALREADY_APPROVED. */
	public static final String PVU_CHANGEOFSCALE_ALREADY_APPROVED = MessageUtil
			.getMsg("PVU.PVU_CHANGEOFSCALE_ALREADY_APPROVED");
	
	/** The Constant TRN_ALREADY_APPROVED. */
	public static final String TRN_ALREADY_APPROVED = MessageUtil.getMsg("PVU.TRN.ALREADY.APPROVED");
	
	/** The Constant TRN_GENERATION_FAILED. */
	public static final String TRN_GENERATION_FAILED = MessageUtil.getMsg("ERROR.PVU.TRAN.FAILED");
	
	/** The Constant EVENT_IN_PROGRESS. */
	public static final String EVENT_IN_PROGRESS = MessageUtil.getMsg("PVU.EVENT.INPROGRESS");
	
	/** The Constant REQUIRED_MENDATORY_ATTACHMENT. */
	public static final String REQUIRED_MENDATORY_ATTACHMENT = MessageUtil.getMsg("EDP.REQUIRED.MENDATORY.ATTACHMENT");
	
	/** The Constant EDP_RESET_PASSWORD. */
	public static final String EDP_RESET_PASSWORD = MessageUtil.getMsg("EDP.RESET.PASSWORD");
	
	/** The Constant EDP_DESIGNATION_CREATE. */
	public static final String EDP_DESIGNATION_CREATE = MessageUtil.getMsg("EDP.DESIGNATION.CREATE");
	
	/** The Constant EDP_DESIGNATION_DELETE. */
	public static final String EDP_DESIGNATION_DELETE = MessageUtil.getMsg("EDP.DESIGNATION.DELETE");
	
	/** The Constant EDP_UPDDESIGNATION_CREATE. */
	public static final String EDP_UPDDESIGNATION_CREATE = MessageUtil.getMsg("EDP.UPDDESIGNATION.CREATE");
	
	/** The Constant EDP_UPDDESIGNATION_DELETE. */
	public static final String EDP_UPDDESIGNATION_DELETE = MessageUtil.getMsg("EDP.UPDDESIGNATION.DELETE");
	
	/** The Constant EDP_POST_CREATE. */
	public static final String EDP_POST_CREATE = MessageUtil.getMsg("EDP.POST.CREATE");
	
	/** The Constant EDP_POST_SAVE. */
	public static final String EDP_POST_SAVE = MessageUtil.getMsg("EDP.POST.SAVE");
	
	/** The Constant EDP_DESIGNATION_SAVE. */
	public static final String EDP_DESIGNATION_SAVE = MessageUtil.getMsg("EDP.DESIGNATION.SAVE");
	
	/** The Constant EDP_UPDDESIGNATION_SAVE. */
	public static final String EDP_UPDDESIGNATION_SAVE = MessageUtil.getMsg("EDP.UPDDESIGNATION.SAVE");
	
	/** The Constant ATTACHMENT_NOT_FOUND. */
	public static final String ATTACHMENT_DELETE = MessageUtil.getMsg("ATTACHMENT.DELETE");
	
	/** The Constant EDP_POST_DELETE. */
	public static final String EDP_POST_DELETE = MessageUtil.getMsg("EDP.POST.DELETE");
	
	/** The Constant EOL_ALREADY_APPROVED. */
	public static final String EOL_ALREADY_APPROVED = MessageUtil.getMsg("PVU.EOL.ALREADY.APPROVED");
	
	/** The Constant EOL_ALREADY_APPROVED. */
	public static final String SUS_ALREADY_APPROVED = MessageUtil.getMsg("PVU.SUS.ALREADY.APPROVED");
	
	/** The Constant TRN_WITHOUT_INCLUDE_FAILED. */
	public static final String TRN_WITHOUT_INCLUDE_FAILED = MessageUtil.getMsg("PVU.TRN.FAILD.WITHOUT.INCLUDE");
	
	/** The Constant OFFICE_CREATION_MSG. */
	public static final String OFFICE_CREATION_MSG = MessageUtil.getMsg("EDP.OFFICE.CREATION");
	
	/** The Constant OFFICE_UPDATION_MSG. */
	public static final String OFFICE_UPDATION_MSG = MessageUtil.getMsg("EDP.OFFICE.UPDATION");
	
	/** The Constant EDP_UN_APPROVED_RECORD. */
	public static final String EDP_UN_APPROVED_RECORD = MessageUtil.getMsg("EDP.UN.APPROVED.RECORD");
	
	/** The Constant ERROR_EMPLOYEE_JOINING_DATE. */
	public static final String ERROR_EMPLOYEE_JOINING_DATE = MessageUtil.getMsg("PVU.EMPLOYEE.JOINING.DATE");
	
	/** The Constant PVU_EMP_PANNO_ALREADY_EXIST. */
	public static final String PVU_EMP_PANNO_ALREADY_EXIST = MessageUtil.getMsg("PVU.EMP.PAN.ALREADY.APPROVED");
	
	/** The Constant FORGODELAY. */
	public static final String FORGODELAY = MessageUtil.getMsg("PVU.FORGODELAY");
	
	/** The Constant EDP_INVALID_ACTIVE_POST. */
	public static final String EDP_INVALID_ACTIVE_POST = MessageUtil.getMsg("EDP.UPDDESIGNATION.INVALID.ACTIVEPOST");
	
	/** The Constant PVU_EMP_PANNO_ALREADY_EXIST. */
	public static final String ERROR_EMPLOYEE_NOT_IN_OFFICE = MessageUtil.getMsg("PVU.EMP.NOT.THIS.OFFICE");
	
	/** The Constant PVU_PROMOTION_ALREADY_APPROVED. */
	public static final String PVU_PROMOTION_ALREADY_APPROVED = MessageUtil.getMsg("PVU.PROMOTION.ALREADY.APPROVED");
	
	/** The Constant BUDGET_LU_SAVE. */
	public static final String BUDGET_LU_SAVE = MessageUtil.getMsg("BUDGET.LU.SAVE");
	
	/** The Constant BUDGET_LU_SUBMITE. */
	public static final String BUDGET_LU_SUBMITE = MessageUtil.getMsg("BUDGET.LU.SUBMITE");
	
	/** The Constant BUDGET_LU_DELETE_REQUEST. */
	public static final String BUDGET_LU_DELETE = MessageUtil.getMsg("BUDGET.LU.DELETE");
	
	/** The Constant PAY_BAND_NOT_ALLOWED. */
	public static final String PAY_BAND_NOT_ALLOWED = MessageUtil.getMsg("ERRORRESP.PAY_BAND_NOT_ALLOWED");
	
	/** The Constant GRADE_PAY_NOT_ALLOWED. */
	public static final String GRADE_PAY_NOT_ALLOWED = MessageUtil.getMsg("ERRORRESP.GRADE_PAY_NOT_ALLOWED");
	
	/** The Constant GRADE_PAY_NOT_ALLOWED. */
	public static final String ERROR_EMPLOYEE_ONLY_REGULAR = MessageUtil.getMsg("ERRORRESP.ONLY.REGULAR");
	
	/** The Constant ERROR_CONTRACTUAL_AND_REAPPOINTED_NOT_ALLOWED. */
	public static final String ERROR_CONTRACTUAL_AND_REAPPOINTED_NOT_ALLOWED = MessageUtil
			.getMsg("ERRORRESP.CONTRACTUAL.RE_APPOINTED.NOT.ALLOWED");
	
	/** The Constant GRADE_PAY_NOT_ALLOWED. */
	public static final String ERROR_EMPLOYEE_ONLY_FIX = MessageUtil.getMsg("ERRORRESP.ONLY.FIX");
	
	/** The Constant ERRORRESP_FIX_PAY. */
	public static final String ERRORRESP_FIX_PAY = MessageUtil.getMsg("ERRORRESP.FIX.PAY");
	
	/** The Constant PVU_ROP_ALREADY_APPROVED. */
	public static final String PVU_ROP_ALREADY_APPROVED = MessageUtil.getMsg("PVU.ROP.ALREADY.APPROVED");
	
	/** The Constant PVU_ROP_FORWARD_DISTRIBUTOR. */
	public static final String PVU_ROP_FORWARD_DISTRIBUTOR = MessageUtil.getMsg("PVU.ROP.FORWARD.DISTRIBUTOR");
	
	/** The Constant PVU_ROP_FORWARD_AUDITOR. */
	public static final String PVU_ROP_FORWARD_AUDITOR = MessageUtil.getMsg("PVU.ROP.FORWARD.AUDITOR");
	
	/** The Constant PVU_EMPLOYEE_EVENT_DATE_COMMISSIONS. */
	public static final String PVU_EMPLOYEE_EVENT_DATE_COMMISSIONS = MessageUtil
			.getMsg("PVU.EMPLOYEE.EVENT.DATE.COMMISSIONS");
	
	/** The Constant PVU_EMP_COMMSION_CHECK_VALIDATION. */
	public static final String PVU_EMP_COMMSION_CHECK_VALIDATION = MessageUtil
			.getMsg("PVU.EVENT.COMMSION.CHECK.VALIDATION");
	
	/** The Constant BUDGET_NC_PO_SAVE. */
	public static final String BUDGET_NC_SAVE = MessageUtil.getMsg("BUDGET.NC.SAVE");
	
	/** The Constant BUDGET_NC_PO_UPDATE. */
	public static final String BUDGET_NC_UPDATE = MessageUtil.getMsg("BUDGET.NC.UPDATE");
	
	/** The Constant BUDGET_NC_PO_DELETE. */
	public static final String BUDGET_NC_DELETE = MessageUtil.getMsg("BUDGET.NC.DELETE");
	
	/** The Constant BUDGET_FU_AD_VALIDATION. */
	public static final String BUDGET_FU_AD_VALIDATION = MessageUtil.getMsg("BUDGET.FU.AD.VALIDATION");
	
	/** The Constant BUDGET_FU_HOD_VALIDATION. */
	public static final String BUDGET_FU_HOD_VALIDATION = MessageUtil.getMsg("BUDGET.FU.HOD.VALIDATION");
	
	/** The Constant BUDGET_FU_AD_EXCESS_CEILING_VALIDATION. */
	public static final String BUDGET_FU_AD_EXCESS_CEILING_VALIDATION = MessageUtil
			.getMsg("BUDGET.FU.AD.EXCESS.CEILING.VALIDATION");
	
	/** The Constant EDP_MSG_FETCH_LIST. */
	public static final String GRANT_DIVISION_LIST = MessageUtil.getMsg("GRANT.FETCH.LIST");
	
	/** The Constant EDP_MSG_FETCH. */
	public static final String GRANT_MSG_FETCH = MessageUtil.getMsg("GRANT.FETCH");
	
	/** The Constant REF_GENERATION_FAILED. */
	public static final String REF_GENERATION_FAILED = MessageUtil.getMsg("ERROR.GRANT.REF.FAILED");
	
	/** The Constant GRANT_MSG_SAVE. */
	public static final String GRANT_MSG_SAVE = MessageUtil.getMsg("GRANT.SAVE");
	
	/** The Constant GRANT_MSG_SUBMIT. */
	public static final String GRANT_MSG_SUBMIT = MessageUtil.getMsg("GRANT.SUBMIT");
	
	/** The Constant GRANT_MSG_DELETE. */
	public static final String GRANT_MSG_DELETE = MessageUtil.getMsg("GRANT.DELETE");
	
	/** The Constant GRANT_MSG_SUBHEAD_SAVE. */
	public static final String GRANT_MSG_SUBHEAD_SAVE = MessageUtil.getMsg("GRANT.SUBHEAD_SAVE");
	
	/** The Constant GRANT_MSG_COPY. */
	public static final String GRANT_MSG_COPY = MessageUtil.getMsg("GRANT.COPY");
	
	/** The Constant EDP_REQUEST_INITIATE. */
	public static final String BUDGET_SCE_HEADER_ALREADY_EXIST = MessageUtil.getMsg("BUDGET.SCE.HEADER.ALREADY.EXIST");
	
	/** The Constant BUDGET_SCE_HEADER_ALREADY_EXIST_BY_USER. */
	public static final String BUDGET_SCE_HEADER_ALREADY_EXIST_BY_USER = MessageUtil
			.getMsg("BUDGET.SCE.HEADER.ALREADY.EXIST.BY.USER");
	
	/** The Constant BUDGET_SCE_HEADER_ALREADY_IN_PROCESS_FOR_CON. */
	public static final String BUDGET_SCE_HEADER_ALREADY_IN_PROCESS_FOR_CON = MessageUtil
			.getMsg("BUDGET.SCE.HEADER.ALREADY.IN_PROCESS");
	
	/** The Constant BUD_LOCK_UNLK_VALIDATION. */
	public static final String BUD_LOCK_UNLK_VALIDATION = MessageUtil.getMsg("BUDGET.SCE.HEADER.LOUN.VALIDATION");
	
	/** The Constant WF_ACTIONS_NOT_ALLOWED. */
	public static final String WF_FAILED = MessageUtil.getMsg("WORKFLOW.WF_FAILED");
	
	/** The Constant TRN_ALREADY_REJECTED. */
	public static final String TRN_ALREADY_REJECTED = MessageUtil.getMsg("PVU.TRN.ALREADY.REJECTED");
	
	/** The Constant WORKFLOW_ACTION_CONFIG_BRANCH_NOTNULL. */
	public static final String WORKFLOW_ACTION_CONFIG_BRANCH_NOTNULL = MessageUtil
			.getMsg("WORKFLOW.ACTION.CONFIG.BRANCH.NOTNULL");
	
	/** The Constant MENU_ID_EMPTY. */
	public static final String MENU_ID_EMPTY = MessageUtil.getMsg("MENU_ID_EMPTY");
	
	/** The Constant WORKFLOW_ACTION_CONFIG_NOTVALID. */
	public static final String WORKFLOW_ACTION_CONFIG_NOTVALID = MessageUtil.getMsg("WORKFLOW.ACTION.CONFIG.NOTVALID");
	
	/** The Constant STEPPING_UP_DATE_VALIDATION. */
	public static final String STEPPING_UP_DATE_VALIDATION = MessageUtil.getMsg("ERRORRESP.DATE.EVNTEFF");
	
	/** The Constant STEPPING_UP_EFFDATE_COMISSION_VALIDATION. */
	public static final String STEPPING_UP_EFFDATE_COMISSION_VALIDATION = MessageUtil
			.getMsg("ERRORRESP.EFFDATE.COMISSION");
	
	/** The Constant STEPPING_UP_EFFDATE_SIXCOMISSION_VALIDATION. */
	public static final String STEPPING_UP_EFFDATE_SIXCOMISSION_VALIDATION = MessageUtil
			.getMsg("ERRORRESP.EFFDATE.SIXCOMISSION");
	
	/** The Constant STEPPING_UP_EFFDATE_GREATERTHAN_JOINING_VALIDATION. */
	public static final String STEPPING_UP_EFFDATE_GREATERTHAN_JOINING_VALIDATION = MessageUtil
			.getMsg("ERRORRESP.EFFDATE.EMPJOINIG");
	
	/** The Constant STEPPING_UP_SAME_EMP_SEARCH_VALIDATION. */
	public static final String STEPPING_UP_SAME_EMP_SEARCH_VALIDATION = MessageUtil
			.getMsg("ERRORRESP.SAMESEARCH.EMPLOYEE");
	
	/** The Constant STEPPING_UP_DIFF_PAY_COMMISSION_VALIDATION. */
	public static final String STEPPING_UP_DIFF_PAY_COMMISSION_VALIDATION = MessageUtil
			.getMsg("ERRORRESP.DIFFPAYCOMMISSIN.EMPLOYEE");
	
	/** The Constant STEPPING_UP_END. */
	// Tiku-Pay
	/** The Constant TIKU_PAY_EMPLOYEE_DEPARTMENT_NOT_VALID. */
	public static final String TIKU_PAY_EMPLOYEE_DEPARTMENT_NOT_VALID = MessageUtil
			.getMsg("TIKUPAY.EMPLOYEE.DEPARTMENT.NOT.VALID");
	
	/** The Constant TIKU_PAY_LOGED_IN_EMPLOYEE_DEPARTMENT_NOT_VALID. */
	public static final String TIKU_PAY_LOGED_IN_EMPLOYEE_DEPARTMENT_NOT_VALID = MessageUtil
			.getMsg("TIKUPAY.LOGGED_IN_EMPLOYEE.DEPARTMENT.NOT.VALID");
	
	/** The Constant TIKU_PAY_EFFDATE_GREATERTHAN_JOINING_VALIDATION. */
	public static final String TIKU_PAY_EFFDATE_GREATERTHAN_JOINING_VALIDATION = MessageUtil
			.getMsg("TIKUPAY.ERRORRESP.EFFDATE.EMPJOINIG");
	
	/** The Constant TIKU_PAY_TYPE. */
	public static final String TIKU_PAY_TYPE = MessageUtil.getMsg("TIKUPAY.ERRORRESP.TIKUPAY.TYPE");
	
	/** The Constant TIKU_PAY_EFFDATE_DATE. */
	public static final String TIKU_PAY_EFFDATE_DATE = MessageUtil.getMsg("TIKUPAY.ERRORRESP.EFFDATE.DATE");
	
	/** The Constant TIKU_PAY_ONE. */
	public static final String TIKU_PAY_ONE = MessageUtil.getMsg("TIKUPAY.ERRORRESP.TIKUPAY.ONE");
	
	/** The Constant TIKU_PAY_TWO. */
	public static final String TIKU_PAY_TWO = MessageUtil.getMsg("TIKUPAY.ERRORRESP.TIKUPAY.TWO");
	
	/** The Constant TIKU_PAY_THREE. */
	public static final String TIKU_PAY_THREE = MessageUtil.getMsg("TIKUPAY.ERRORRESP.TIKUPAY.THREE");
	
	/** The Constant TIKU_PAY_LESS_THEN_YEAR. */
	public static final String TIKU_PAY_LESS_THEN_YEAR = MessageUtil.getMsg("TIKU.PAY.LESS.THEN.YEAR");
	
	/** The Constant TIKU_PAY_GPSC_EXAM_REQUIRE. */
	public static final String TIKU_PAY_GPSC_EXAM_REQUIRE = MessageUtil.getMsg("TIKUPAY.ERRORRESP.GPSC.EXAM");
	
	/** The Constant TIKU_PAY_GPSC_EXAM_DATE. */
	public static final String TIKU_PAY_GPSC_EXAM_DATE = MessageUtil.getMsg("TIKUPAY.ERRORRESP.GPSC.EXAM.DATE");
	
	/** The Constant TIKU_PAY_ADOC_FROM_DATE. */
	public static final String TIKU_PAY_ADOC_FROM_DATE = MessageUtil.getMsg("TIKUPAY.ERRORRESP.ADOC.FROM.DATE");
	
	/** The Constant TIKU_PAY_ADOC_TO_DATE. */
	public static final String TIKU_PAY_ADOC_TO_DATE = MessageUtil.getMsg("TIKUPAY.ERRORRESP.ADOC.TO.DATE");
	
	/** The Constant PVU_FORWARD_TO_NEXT_LEVEL. */
	public static final String PVU_FORWARD_TO_NEXT_LEVEL = MessageUtil.getMsg("PVU.FORWARD.TO.NEXT.LEVEL");
	
	/** The Constant TIKU_PAY_ALREADY_GIVEN. */
	public static final String TIKU_PAY_ALREADY_GIVEN = MessageUtil.getMsg("TIKU.PAY.ALREADY.GIVEN");
	
	/** The Constant TIKU_PAY_ONE_ALREADY_GIVEN. */
	public static final String TIKU_PAY_ONE_ALREADY_GIVEN = MessageUtil.getMsg("TIKU.PAY.ONE.ALREADY.GIVEN");
	
	/** The Constant TIKU_PAY_TWO_ALREADY_GIVEN. */
	public static final String TIKU_PAY_TWO_ALREADY_GIVEN = MessageUtil.getMsg("TIKU.PAY.TWO.ALREADY.GIVEN");
	
	/** The Constant TIKU_PAY_THREE_ALREADY_GIVEN. */
	public static final String TIKU_PAY_THREE_ALREADY_GIVEN = MessageUtil.getMsg("TIKU.PAY.THREE.ALREADY.GIVEN");
	
	/** The Constant TIKU_PAY_ALREADY_GOT_HIGHER. */
	public static final String TIKU_PAY_ALREADY_GOT_HIGHER = MessageUtil.getMsg("TIKU.PAY.ALREADY.GOT.HIGHER");
	
	/** The Constant TIKU_PAY_CCC_REQUIRED. */
	public static final String TIKU_PAY_CCC_REQUIRED = MessageUtil.getMsg("TIKU.PAY.CCC.REQUIRED");
	
	/** The Constant TIKU_PAY_FIRST_SELECT. */
	public static final String TIKU_PAY_FIRST_SELECT = MessageUtil.getMsg("TIKU.PAY.FIRST.SELECT");
	
	/** The Constant TIKU_PAY_TWO_SELECT. */
	public static final String TIKU_PAY_TWO_SELECT = MessageUtil.getMsg("TIKU.PAY.TWO.SELECT");
	
	/** The Constant TRANSACTION_OUT_OF_SYNCH. */
	public static final String TRANSACTION_OUT_OF_SYNCH = MessageUtil.getMsg("PVU.TRANS.UNSYNCH");
	
	/** The Constant BUDGET_REC_EST_HEADER_ALREADY_CREATED. */
	public static final String BUDGET_REC_EST_HEADER_ALREADY_CREATED = MessageUtil
			.getMsg("BUDGET.REC.EST.HEADER.ALREADY.EXIST");
	
	/** The Constant BUDGET_LU_SAVE. */
	public static final String BUDGET_REC_EST_HEADER_SAVE = MessageUtil.getMsg("BUDGET.REC.EST.SAVE");
	
	/** The Constant BUDGET_LU_SUBMITE. */
	public static final String BUDGET_REC_EST_HEADER_SUBMITE = MessageUtil.getMsg("BUDGET.REC.EST.SUBMITE");
	
	/** The Constant ERROR_DURING_SP_CALL. */
	public static final String ERROR_DURING_SP_CALL = MessageUtil.getMsg("ERRORRESP.SP.ERROR");
	
	/** The Constant ERROR_INVALID_OFFICE_TYPE. */
	public static final String ERROR_INVALID_OFFICE_TYPE = MessageUtil.getMsg("ERROR.INVALID.OFFICETYPE");
	
	/** The Constant BUDGET_REC_EST_HEADER_CON_SAVE. */
	public static final String BUDGET_REC_EST_HEADER_CON_SAVE = MessageUtil.getMsg("BUDGET.REC.EST.CON.SAVE");
	
	/** The Constant BUDGET_REC_EST_HEADER_CON_SUBMITE. */
	public static final String BUDGET_REC_EST_HEADER_CON_SUBMITE = MessageUtil.getMsg("BUDGET.REC.EST.CON.SUBMITE");
	
	/** The Constant ERROR_INVALID_EMPLOYEE_NO. */
	public static final String ERROR_INVALID_EMPLOYEE_NO = MessageUtil.getMsg("EDP.ERROR.INVALID.EMPLOYEENO");
	
	/** The Constant PVU_ROP_FORWARD_DISTRIBUTOR. */
	public static final String PVU_EVENT_FORWARD_DISTRIBUTOR = MessageUtil.getMsg("PVU.EVENT.FORWARD.DISTRIBUTOR");
	
	/** The Constant PVU_ROP_FORWARD_DISTRIBUTOR. */
	public static final String PVU_EVENT_FORWARD_AUDITOR = MessageUtil.getMsg("PVU.EVENT.FORWARD.AUDITOR");
	
	/** The Constant EDP_REQUEST_INITIATE_POST_TRANSFER_EMPLOYEE. */
	public static final String EDP_REQUEST_INITIATE_POST_TRANSFER_EMPLOYEE = MessageUtil
			.getMsg("EDP.REQUEST.INITIATE.POST.TRANSFER.EMPLOYEE");
	
	/** The Constant ERROR_INVALID_USER_NO. */
	public static final String ERROR_INVALID_USER_NO = MessageUtil.getMsg("EDP.ERROR.INVALID.USERNO");
	
	/** The Constant EDP_POST_TRANSFER_CHANGE_POST. */
	public static final String EDP_POST_TRANSFER_CHANGE_POST = MessageUtil.getMsg("EDP.POST.TRANSFER.CHANGE.POST");
	
	/** The Constant ERROR_USER_CAN_NOT_TRANSFER_OWN_POST. */
	public static final String ERROR_USER_CAN_NOT_TRANSFER_OWN_POST = MessageUtil
			.getMsg("EDP.ERROR.USER.CAN.NOT.TRANSFER.OWN.POST");
	
	/** The Constant EDP_POST_TRANSFER_SAVE_REQUEST. */
	public static final String EDP_POST_TRANSFER_SAVE_REQUEST = MessageUtil.getMsg("EDP.POST.TRANSFER.SAVE");
	
	/** The Constant EDP_POST_TRANSFER_SUBMIT_REQUEST. */
	public static final String EDP_POST_TRANSFER_SUBMIT_REQUEST = MessageUtil.getMsg("EDP.POST.TRANSFER.SUBMIT");
	
	/** The Constant EDP_POST_TRANSFER_DELETE_REQUST. */
	public static final String EDP_POST_TRANSFER_DELETE_REQUST = MessageUtil.getMsg("EDP.POST.TRANSFER.DELETE");
	
	/** The Constant EDP_ERROR_EMP_NOT_MAPPED. */
	public static final String ERROR_EDP_EMP_OFFICE_NOT_MAPPED = MessageUtil.getMsg("EDP.ERROR.EMP.NOT.MAPPED");
	
	/** The Constant ERROR_MINISTER_IN_CHARGE_NOT_FOUND. */
	public static final String ERROR_MINISTER_IN_CHARGE_NOT_FOUND = MessageUtil
			.getMsg("ERROR.MINISTER.INCHARGE.NOT.FOUND");
	
	/** The Constant ACP_ERRORRESP_FIVE_YEARS. */
	// ACP ERROR MESSAGES
	public static final String ACP_ERRORRESP_FIVE_YEARS = MessageUtil.getMsg("ACP.ERRORRESP.FIVE_YEARS");
	
	/** The Constant ACP_ERRORRESP_TEN_YEARS. */
	public static final String ACP_ERRORRESP_TEN_YEARS = MessageUtil.getMsg("ACP.ERRORRESP.TEN_YEARS");
	
	/** The Constant ACP_ERRORRESP_ONLY_CIVIL_JUDGE. */
	public static final String ACP_ERRORRESP_ONLY_CIVIL_JUDGE = MessageUtil.getMsg("ACP.ERRORRESP.ONLY_CIVIL_JUDGE");
	
	/** The Constant ACP_ERRORRESP_ONLY_REGULAR_EMPLOYEE. */
	public static final String ACP_ERRORRESP_ONLY_REGULAR_EMPLOYEE = MessageUtil
			.getMsg("ACP.ERRORRESP.ONLY_REGULAR_EMPLOYEE");
	
	/** The Constant ACP_ERRORRESP_SEVENTH_COMMISSION_NOT_ALLOWED. */
	public static final String ACP_ERRORRESP_SEVENTH_COMMISSION_NOT_ALLOWED = MessageUtil
			.getMsg("ACP.ERRORRESP.SEVENTH_COMMISSION_NOT_ALLOWED");
	
	/** The Constant ACP_ERRORRESP_DATE_NULL_NOT_ALLOWED. */
	public static final String ACP_ERRORRESP_DATE_NULL_NOT_ALLOWED = MessageUtil
			.getMsg("ACP.ERRORRESP.DATE_NULL_NOT_ALLOWED");
	
	/** The Constant ACP_EMPLOYEE_NO. */
	public static final String ACP_EMPLOYEE_NO = MessageUtil.getMsg("ACP.EMPLOYEE.NO");
	
	/** The Constant IFMS_MS_OUTWARDED. */
	public static final String IFMS_MSG_OUTWARDED = MessageUtil.getMsg("IFMS.OUTWARDED");
	
	/** The Constant IFMS_MSG_SUBMITTED. */
	public static final String IFMS_MSG_PVU_COMMON_RESPONSE = MessageUtil.getMsg("IFMS.COMMON.SUCCESSFULLY");
	
	/** The Constant PLEASE_ADD_CHECKLIST. */
	public static final String PLEASE_ADD_CHECKLIST = MessageUtil.getMsg("ERRORRESP.PLEASE_ADD_CHECKLIST");
	
	/** The Constant PLEASE_ADD_FORMC1. */
	public static final String PLEASE_ADD_FORMC1 = MessageUtil.getMsg("ERRORRESP.PLEASE_ADD_FORMC1");
	
	/** The Constant BUDGET_ERROR_REC_EST_CON_IS_ALREADY_PROCEESSED. */
	public static final String BUDGET_ERROR_REC_EST_CON_IS_ALREADY_PROCEESSED = MessageUtil
			.getMsg("BUDGET.ERROR.REC.EST.CON.IS.ALREADY.PROCEESSED");
	
	/** The Constant PLEASE_ADD_CSS_DETAILS. */
	public static final String PLEASE_ADD_CSS_DETAILS = MessageUtil.getMsg("ERRORRESP.PLEASE_ADD_CSS_DETAILS");
	
	/** The Constant BUDGET_ERROR_NEW_ITEM_EST_ALREADY_CREATED. */
	public static final String BUDGET_ERROR_NEW_ITEM_EST_ALREADY_CREATED = MessageUtil
			.getMsg("ERRORRESP.NEW.ITEM.EST.ALREADY.CREATED");
	
	/** The Constant BUDGET_ERROR_NEW_ITEM_EST_ALREADY_CREATED. */
	public static final String ERROR_NEW_ITEM_GIA_OBJ_BK_REQUIRED = MessageUtil
			.getMsg("BUDGET.NEW.ITEM.GIA.OBJ.BK.REQUIRED");
	
	/** The Constant BUDGET_ERROR_NEW_ITEM_EST_ALREADY_CREATED. */
	public static final String ERROR_NEW_ITEM_GIA_OBJ_URB_REQUIRED = MessageUtil
			.getMsg("BUDGET.NEW.ITEM.GIA.OBJ.URB.REQUIRED");
	
	/** The Constant BUDGET_ERROR_NEW_ITEM_EST_ALREADY_CREATED. */
	public static final String ERROR_NEW_ITEM_GIA_OBJ_TA_GA_REQUIRED = MessageUtil
			.getMsg("BUDGET.NEW.ITEM.GIA.OBJ.TA.GA.REQUIRED");
	
	/** The Constant BUDGET_ERROR_NEW_ITEM_EST_ALREADY_CREATED. */
	public static final String ERROR_NEW_ITEM_GIA_FORM_C_REQUIRED = MessageUtil
			.getMsg("BUDGET.NEW.ITEM.GIA.FORMC.REQUIRED");
	
	/** The Constant ERROR_BUDGET_TIMELIMITE_NOT_CREATED. */
	public static final String ERROR_BUDGET_TIMELIMITE_NOT_CREATED = MessageUtil
			.getMsg("BUDGET.TIME.LIMITE.NOT.CREATED");
	
	/** The Constant ERROR_BUDGET_TIMELIMITE_NOT_CREATED. */
	public static final String ERROR_BUDGET_TIMELIMITE_EXPIRED = MessageUtil.getMsg("BUDGET.TIME.LIMITE.EXPIRED");
	
	/** The Constant SHP_EEFFDATE_MSG. */
	public static final String SHP_EEFFDATE_MSG = MessageUtil.getMsg("SHP.EEFFDATE.MSG");
	
	/** The Constant COMMON_EOL_MSG. */
	public static final String COMMON_EOL_MSG = MessageUtil.getMsg("COMMON.EOL.MSG");
	
	/** The Constant COMMON_SUSPENSION_MSG. */
	public static final String COMMON_SUSPENSION_MSG = MessageUtil.getMsg("COMMON.SUSPENSION.MSG");
	
	/** The Constant ERROR_BUDGET_PREVIOUS_WORK_NOT_EXISTS. */
	public static final String ERROR_BUDGET_PREVIOUS_WORK_NOT_EXISTS = MessageUtil
			.getMsg("BUDGET.PREVIOUS.WORK.NOT.EXISTS");
	
	/** The Constant ERROR_EDP_EMP_NOT_FOUND. */
	public static final String ERROR_EDP_EMP_NOT_FOUND = MessageUtil.getMsg("EDP.ERROR.EMP.NOT.FOUND");
	
	/** The Constant BUDGET_OBJECTHEAD_DELETE. */
	public static final String BUDGET_OBJECTHEAD_DELETE = MessageUtil.getMsg("BUDGET.OBJECTHEAD.DELETE");
	
	/** The Constant BUDGET_REC_EST_HEADER_ALREADY_EXIST. */
	public static final String BUDGET_REC_EST_HEADER_ALREADY_EXIST = MessageUtil
			.getMsg("BUDGET.REC.EST.HEADER.ALREADY.EXIST.BY.USER");
	
	/** The Constant ERROR_COMMON_ATTACHMENT_CATEGORY. */
	public static final String ERROR_COMMON_ATTACHMENT_CATEGORY = MessageUtil
			.getMsg("ERROR_COMMON_ATTACHMENT_CATEGORY");
	
	/** The Constant ERROR_BUDGET_CEILLING_REVENUE_IS_EXCEED. */
	public static final String ERROR_BUDGET_CEILLING_REVENUE_IS_EXCEED = MessageUtil
			.getMsg("BUDGET.CEILLING.REVENUE.IS.EXCEED");
	
	/** The Constant ERROR_BUDGET_CEILLING_CAPITAL_IS_EXCEED. */
	public static final String ERROR_BUDGET_CEILLING_CAPITAL_IS_EXCEED = MessageUtil
			.getMsg("BUDGET.CEILLING.CAPITAL.IS.EXCEED");
	
	/** The Constant ERROR_BUDGET_CEILLING_AMOUNT_HOD_NOT_MAP. */
	public static final String ERROR_BUDGET_CEILLING_AMOUNT_HOD_NOT_MAP = MessageUtil
			.getMsg("BUDGET.CEILLING.AMOUNT.HOD.NOT.MAP");
	
	/** The Constant BUDGET_NEW_SUB_HEAD_ALREADY_EXIST. */
	public static final String BUDGET_NEW_SUB_HEAD_ALREADY_EXIST = MessageUtil
			.getMsg("BUDGET.NEW.SUB.HEAD.ALREADY.EXIST");
	
	/** The Constant BUDGET_VALIDATE_NEW_SUB_HEAD. */
	public static final String BUDGET_VALIDATE_NEW_SUB_HEAD = MessageUtil.getMsg("BUDGET.VALIDATE.NEW.SUB.HEAD");
	
	/** The Constant ERROR_BUDGET_EST_SALARY_PENDING. */
	public static final String ERROR_BUDGET_EST_SALARY_PENDING = MessageUtil.getMsg("BUDGET.EST.SALARY.DETAIL.PENDING");
	
	/** The Constant REPORT_ELECTRONICALLY_TEXT. */
	public static final String REPORT_ELECTRONICALLY_TEXT = MessageUtil.getMsg("EDP.REPORT.ELECTRONICALLY.PRINT");
	
	/** The Constant EDP_REQUEST_INITIATE_DESIGNATION. */
	public static final String EDP_REQUEST_INITIATE_DESIGNATION = MessageUtil
			.getMsg("EDP.REQUEST.INITIATE.DESIGNATION");
	
	/** The Constant EDP_REQUEST_INITIATE_UPDATE_OFFICE_MSG. */
	public static final String EDP_REQUEST_INITIATE_UPDATE_OFFICE_MSG = MessageUtil
			.getMsg("EDP.REQUEST.INITIATE.UPDATE.OFFICE.MSG");
	
	/** The Constant EDP_DDO_NO_ALREADY_EXISTS_CNO. */
	public static final String EDP_DDO_NO_ALREADY_EXISTS_CNO = MessageUtil.getMsg("EDP.DDO.NO.ALREADY.EXISTS.MSG");
	
	/** The Constant EDP_TO_OFFICE_ALREADY_EXISTS_CNO. */
	public static final String EDP_TO_OFFICE_ALREADY_EXISTS_CNO = MessageUtil
			.getMsg("EDP.TO.OFFICE.ALREADY.EXISTS.MSG");
	/** The Constant PLEASE_UPLOAD_ATTACHMENT. */
	public static final String PLEASE_UPLOAD_ATTACHMENT = MessageUtil.getMsg("ERRORRESP.PLEASE.UPLOAD.ATTACHMENT");
	
	/** The Constant EDP_REQUEST_INITIATE_UPDATE_DESIGNATION. */
	public static final String EDP_REQUEST_INITIATE_UPDATE_DESIGNATION = MessageUtil
			.getMsg("EDP.REQUEST.INITIATE.UPDATE.DESIGNATION");
	
	/** The Constant OAUTH_LOGIN_FROM_INACTIVE_CANCLE_OFFICE. */
	public static final String OAUTH_LOGIN_FROM_INACTIVE_CANCLE_OFFICE = MessageUtil
			.getMsg("OAUTH.LOGIN.ERROR.MESSAGE");
	
	/** The Constant ERRORRESP_REV_RECT_AD_CON_ALREADY_CO_BY_FD. */
	public static final String ERRORRESP_REV_RECT_AD_CON_ALREADY_CO_BY_FD = MessageUtil
			.getMsg("ERRORRESP.REV.RECT.AD.CON.ALREADY.CO.BY.FD");
	
	/** The Constant PLEASE_UPLOAD_ATTACHMENT. */
	public static final String ERROR_BUD_INVALID_AG_UP_TEM_HDR = MessageUtil.getMsg("BUDGET.INVALID.AG.UP.TEM.HDR");
	
	/** The Constant PLEASE_UPLOAD_ATTACHMENT. */
	public static final String ERROR_BUD_INVALID_AG_UP_REC = MessageUtil.getMsg("BUDGET.INVALID.AG.UP.REC");
	
	/** The Constant PLEASE_UPLOAD_ATTACHMENT. */
	public static final String ERROR_BUD_INVALID_AG_DATA = MessageUtil.getMsg("BUDGET.INVALID.AG.DATA");
	
	/** The Constant BUDGET_NEW_SUB_HEAD_IN_PROGRESS. */
	public static final String BUDGET_NEW_SUB_HEAD_IN_PROGRESS = MessageUtil.getMsg("BUDGET.NEW.SUB.HEAD.IN.PROGRESS");
	
	/** The Constant BUDGET_NEW_SUB_HEAD_IN_PROGRESS. */
	public static final String BUDGET_NEW_ITEM_DDO_VALIDATION = MessageUtil.getMsg("BUDGET.NEW.ITEM.DDO.VALIDATION");
	
	/** The Constant BUDGET_REC_EST_ALREADY_CREATED. */
	public static final String BUDGET_REC_EST_ALREADY_CREATED = MessageUtil.getMsg("BUDGET.REC.EST.ALREADY.CREATED");
	
	/** The Constant BUDGET_FREEZE_UNFREEZE_HEADER_NOT_CREATED. */
	public static final String BUDGET_FREEZE_UNFREEZE_HEADER_NOT_CREATED = MessageUtil
			.getMsg("BUDGET.FREEZE.UNFREEZE.HEADER.NOT.CREATED");
	
	/** The Constant BUDGET_FREEZE_UNFREEZE_HEADER_NOT_CREATED_STANDING_CHARGE. */
	public static final String BUDGET_FREEZE_UNFREEZE_HEADER_NOT_CREATED_STANDING_CHARGE = MessageUtil
			.getMsg("BUDGET.FREEZE.UNFREEZE.HEADER.NOT.CREATED.STANDING.CHARGE");
	
	/** The Constant BUDGET_SUPPL_DEMAND_BUDGET_HEAD_ALREADY_ADDED. */
	public static final String BUDGET_SUPPL_DEMAND_BUDGET_HEAD_ALREADY_ADDED = MessageUtil
			.getMsg("BUDGET.SUPPL.DEMAND.BUDGET.HEAD.ALREADY.ADDED");
	
	/** The Constant BUDGET_SUPPL_DEMAND_TRN_ALREADY_INITIATED. */
	public static final String BUDGET_SUPPL_DEMAND_TRN_ALREADY_INITIATED = MessageUtil
			.getMsg("BUDGET.SUPPL.DEMAND.TRN.ALREADY.INITIATED");
	
	/** The Constant BUDGET_SUPPL_DEMAND_DATA_EMPTY. */
	public static final String BUDGET_SUPPL_DEMAND_DATA_EMPTY = MessageUtil.getMsg("BUDGET.SUPPL.DEMAND.DATA.EMPTY");
	
	/** The Constant ERROR_WHILE_GET_FD_GROUP. */
	public static final String ERROR_WHILE_GET_FD_GROUP = MessageUtil.getMsg("ERROR.WHILE.GET.FD.GROUP");
	
	/** The Constant BUDGET_PUBLICATION_DOC_HDR_ALREADY_EXISTS. */
	public static final String BUDGET_PUBLICATION_DOC_HDR_ALREADY_EXISTS = MessageUtil
			.getMsg("BUDGET.PUBLICATION.DOC.HDR.ALREADY.EXISTS");
	
	/** The Constant PAO_TOKEN_RANGE_ALREADY_CREATED. */
	public static final String PAO_TOKEN_RANGE_TYPE_UNKNOWN = MessageUtil.getMsg("PAO.TOKEN.RANGE.TYPE.UNKNOWN");
	
	/** The Constant PAO_TOKEN_RANGE_CNTR_ALLOC. */
	public static final String PAO_TOKEN_RANGE_CNTR_ALLOC = MessageUtil.getMsg("PAO.TOKEN.RANGE.CNTR.ALLOCATED");
	
	/** The Constant PAO_DUP_CNTR_NAME. */
	public static final String PAO_DUP_CNTR_NAME = MessageUtil.getMsg("PAO.DUP.COUNTER.NAME");
	
	/** The Constant PAO_RANGE_CNTR_COLLIDE. */
	public static final String PAO_RANGE_CNTR_COLLIDE = MessageUtil.getMsg("PAO.RANGE.COUNTER.COLLIDE");
	
	/** The Constant PAO_TOKEN_UNAVAILABLE. */
	public static final String PAO_TOKEN_UNAVAILABLE = MessageUtil.getMsg("PAO.TOKEN.UNAVAILABLE");
	
	/** The Constant BUDGET_ERROR_REC_EST_CON_AD_IS_ALREADY_PROCEESSED. */
	public static final String BUDGET_ERROR_REC_EST_CON_AD_IS_ALREADY_PROCEESSED = MessageUtil
			.getMsg("ERROR.REC.EST.CON.AD.IS.ALREADY.PROCEESSED");
	
	/** The Constant EDP_BRANCH_REQUEST_ALREADY_EXISTS. */
	public static final String EDP_BRANCH_REQUEST_ALREADY_EXISTS = MessageUtil
			.getMsg("EDP.BRANCH.REQUEST.ALREADY.EXISTS");
	
	/** The Constant INIT_WF_RL_IS_NOT_CONFIGURED. */
	public static final String INIT_WF_RL_IS_NOT_CONFIGURED = MessageUtil
			.getMsg("WORKFLOW.ACTION.INIT.WF.RL.NOT.CONFIGURED");
	
	/** The Constant WF_RL_IS_NOT_ASSIGNED. */
	public static final String WF_RL_IS_NOT_ASSIGNED = MessageUtil.getMsg("WORKFLOW.ACTION.WF.RL.IS.NOT.ASSIGNED");
	
	/** The Constant EDP_BRANCH_CR_SAVE_AS_DRFT. */
	public static final String EDP_BRANCH_CR_SAVE_AS_DRFT = MessageUtil.getMsg("EDP.BRANCH.CR.SAVE");
	
	/** The Constant EDP_BRANCH_CR_SUBMIT. */
	public static final String EDP_BRANCH_CR_SUBMIT = MessageUtil.getMsg("EDP.BRANCH.CR.SUBMIT");
	
	/** The Constant EDP_BRANCH_CR_DELET. */
	public static final String EDP_BRANCH_CR_DELET = MessageUtil.getMsg("EDP.BRANCH.CR.DELET");
	
	/** The Constant EDP_BRANCH_BUDGET_ALREADY_EXISTS. */
	public static final String EDP_BRANCH_BUDGET_ALREADY_EXISTS = MessageUtil
			.getMsg("EDP.BRANCH.BUDGET.ALREADY.EXISTS");
	
	/** The Constant BUDGET_MSG_DELETE. */
	public static final String BUDGET_MSG_CANCEL = MessageUtil.getMsg("BUDGET.CANCEL");
	
	/** The Constant BUDGET_RETURN_OFFICE. */
	public static final String BUDGET_RETURN_OFFICE = MessageUtil.getMsg("BUDGET.RETURN.OFFICE");
	
	/** The Constant EDP_BRANCH_ALREADY_EXISTS. */
	public static final String EDP_BRANCH_ALREADY_EXISTS = MessageUtil.getMsg("EDP.BRANCH.ALREADY.EXISTS");
	
	/** The Constant EDP_REQUEST_INITIATE_BRANCH_MAPPING. */
	public static final String EDP_REQUEST_INITIATE_BRANCH_MAPPING = MessageUtil
			.getMsg("EDP.REQUEST.INITIATE.BRANCH.MAPPING");
	
	/** The Constant EDP_MSG_BRANCH_MAP_CREATE. */
	public static final String EDP_MSG_BRANCH_MAP_CREATE = MessageUtil.getMsg("EDP.MSG.BRANCH.MAP.CREATE");
	
	/** The Constant EDP_MSG_BRANCH_MAP_SUBMIT. */
	public static final String EDP_MSG_BRANCH_MAP_SUBMIT = MessageUtil.getMsg("EDP.MSG.BRANCH.MAP.SUBMIT");
	
	/** The Constant EDP_MSG_BRANCH_TRANSFER_CREATE. */
	public static final String EDP_MSG_BRANCH_TRANSFER_CREATE = MessageUtil.getMsg("EDP.MSG.BRANCH.TRANSFER.CREATE");
	
	/** The Constant EDP_MSG_BRANCH_TRANSFER_SUBMIT. */
	public static final String EDP_MSG_BRANCH_TRANSFER_SUBMIT = MessageUtil.getMsg("EDP.MSG.BRANCH.TRANSFER.SUBMIT");
	
	/** The Constant EDP_MSG_BRANCH_TRANSFER_SUBMIT. */
	public static final String CLOSING_BALANCE_FETCH = MessageUtil.getMsg("GPR.INS.CLOSING.BALANCE.FETCH");
	
	/** The Constant INVALID_MONTHS. */
	public static final String INVALID_MONTHS = MessageUtil.getMsg("GPR.INS.INVALID.MONTH");
	
	/** The Constant EDP_USER_BRANCH_ACCESS. */
	public static final String EDP_USER_BRANCH_ACCESS = MessageUtil.getMsg("EDP.USER.BRANCH.ACCESS");
	
	/** The Constant BUDGET_OUT_COME_MACRO_HDR_NOT_CREATED. */
	public static final String BUDGET_OUT_COME_MACRO_HDR_NOT_CREATED = MessageUtil
			.getMsg("BUDGET.OUT.COME.MACRO.HDR.NOT.CREATED");
	
	/** The Constant BUDGET_OUT_COME_MACRO_HDR_FOUND. */
	public static final String BUDGET_OUT_COME_MACRO_HDR_FOUND = MessageUtil
			.getMsg("BUDGET.OUT.COME.MACRO.HDR.ALREADY.CREATED");
	
	/** The Constant COMMON_PAYCOMM_INVALID. */
	public static final String COMMON_PAYCOMM_INVALID = MessageUtil.getMsg("COMMON.PAYCOMM.INVALID");
	
	/** The Constant COMMON_PAYCOMM_CHANGEPAYCOMM. */
	public static final String COMMON_PAYCOMM_CHANGEPAYCOMM = MessageUtil.getMsg("COMMON.PAYCOMM.CHANGEPAYCOMM");
	
	/** The Constant COMMON_PAYCOMM_DOJ. */
	public static final String COMMON_PAYCOMM_DOJ = MessageUtil.getMsg("COMMON.PAYCOMM.DOJ");
	
	/** The Constant PAO_LAST_TOKEN_NOT_IN_RANGE. */
	public static final String PAO_LAST_TOKEN_NOT_IN_RANGE = MessageUtil.getMsg("PAO.LAST.TOKEN.NOT.IN.RANGE");
	
	/** The Constant PVU_VALID_EMP. */
	public static final String PVU_VALID_EMP = MessageUtil.getMsg("PVU.VALID.EMP");
	
	/** The Constant BUDGET_OUT_COME_SELECTED_SCHEME_CREATED. */
	public static final String BUDGET_OUT_COME_SELECTED_SCHEME_CREATED = MessageUtil
			.getMsg("BUDGET.OUT.SELECTED.SCHEME.CREATED");
	
	/** The Constant SMS_OTP_TEMPLATE. */
	public static final String SMS_OTP_TEMPLATE = MessageUtil.getMsg("SMS_OTP_TEMPLATE");
	
	/** The Constant BUDGET_CEILLING_AMOUNT_NOT_MAP. */
	public static final String BUDGET_CEILLING_AMOUNT_NOT_MAP = MessageUtil.getMsg("BUDGET.CEILLING.AMOUNT.NOT.MAP");
	
	/** The Constant BUDGET_GENERATE_PRINT. */
	public static final String BUDGET_GENERATE_PRINT = MessageUtil.getMsg("BUDGET.GENERATE.PRINT");
	
	/** The Constant BUDGET_ERROR_OCCURRED_WHILE_GENERATE_PRINT. */
	public static final String BUDGET_ERROR_OCCURRED_WHILE_GENERATE_PRINT = MessageUtil
			.getMsg("BUDGET.ERROR.OCCURRED.WHILE.GENERATE.PRINT");
	
	/** The Constant ERROR_BILL_TYPE_UNKNOWN. */
	public static final String ERROR_PAO_OBJ_DESC_DUP = MessageUtil.getMsg("PAO.OBJ.DESC.DUP");
	
	/** The Constant ERROR_AUD_MAP_UNKNOWN. */
	public static final String ERROR_PAO_AUD_MAP_DUP = MessageUtil.getMsg("PAO.AUD.MAP.DUP");
	
	/** The Constant ERROR_BILL_TYPE_UNKNOWN. */
	public static final String ERROR_BILL_TYPE_UNKNOWN = MessageUtil.getMsg("BILL.TYPE.UNKNOWN");
	
	/** The Constant ERROR_PAO_OBJ_UPDATE_NOT_ALLOWED. */
	public static final String ERROR_PAO_OBJ_UPDATE_NOT_ALLOWED = MessageUtil.getMsg("PAO.OBJ.UPDATE.NOT.ALLOWED");
	
	/** The Constant ERROR_PAO_CARDEX_NO_NOT_EXIST. */
	public static final String ERROR_PAO_CARDEX_NO_NOT_EXIST = MessageUtil.getMsg("ERROR_PAO_CARDEX_NO_NOT_EXIST");
	
	/** The Constant PAO_TOKEN_RANGE_CNTR_NOT_ALLOC. */
	public static final String PAO_TOKEN_RANGE_CNTR_NOT_ALLOC = MessageUtil.getMsg("PAO.TOKEN.RANGE.CNTR.NOTALLOCATED");
	
	/** The Constant ERROR_PAO_RANGE_TOKEN_USED. */
	public static final String ERROR_PAO_RANGE_TOKEN_USED = MessageUtil.getMsg("PAO.RANGE.TOKEN.USED");
	
	/** The Constant IFMS_MSG_AUDITORNAME_MAPPED. */
	public static final String IFMS_MSG_AUDITOR_MAPPED = MessageUtil.getMsg("IFMS.AUDITOR.MAPPED");
	
	/** The Constant IFMS_MSG_AUDITORNAME_UNMAPPED. */
	public static final String IFMS_MSG_AUDITOR_UNMAPPED = MessageUtil.getMsg("IFMS.AUDITOR.UNMAPPED");
	
	/** The Constant ERROR_REE_GIA_OBJ_BK_REQUIRED. */
	public static final String ERROR_REE_GIA_OBJ_BK_REQUIRED = MessageUtil.getMsg("BUDGET.REE.GIA.OBJ.BK.REQUIRED");
	
	/** The Constant ERROR_REE_GIA_JTG_REQUIRED. */
	public static final String ERROR_REE_GIA_JTG_REQUIRED = MessageUtil.getMsg("BUDGET.REE.GIA.JTG.REQUIRED");
	
	/** The Constant ERROR_REE_GIA_URB_REQUIRED. */
	public static final String ERROR_REE_GIA_URB_REQUIRED = MessageUtil.getMsg("BUDGET.REE.GIA.URB.REQUIRED");
	
	/** The Constant EMD_MAJOR_HEAD_NOT_FOUND. */
	public static final String EMD_MAJOR_HEAD_NOT_FOUND = MessageUtil.getMsg("EMD.MAJOR.HEAD.NOT.FOUND");
	
	/** The Constant EMD_CODE_ALREADY_EXISTS. */
	public static final String EMD_CODE_ALREADY_EXISTS = MessageUtil.getMsg("EMD.CODE.ALREADY.EXISTS");
	
	/** The Constant EMD_HEADER_ALREADY_EXISTS. */
	public static final String EMD_HEADER_ALREADY_EXISTS = MessageUtil.getMsg("EMD.HEADER.ALREADY.EXISTS");
	
	/** The Constant DRAFT_SAVE_FAILED. */
	public static final String DRAFT_SAVE_FAILED = MessageUtil.getMsg("GPR.INS.DRAFT_SAVE_FAILED");
	
	/** The Constant ERROR_ERA_RBD_ENTRY_ALREADY_EXISTS. */
	public static final String ERROR_ERA_RBD_ENTRY_ALREADY_EXISTS = MessageUtil.getMsg("ERA.RBD.ENTRY.ALREADY.EXISTS");
	
	/** The Constant ERROR_ERA_RBD_ENTRY_NOT_INITIATED. */
	public static final String ERROR_ERA_RBD_ENTRY_NOT_INITIATED = MessageUtil.getMsg("ERA.RBD.ENTRY.NOT.INITIATED");
	
	/** The Constant ERROR_ERA_PAY_REC_JOT_ALREADY_EXISTS. */
	public static final String ERROR_ERA_PAY_REC_JOT_ALREADY_EXISTS = MessageUtil
			.getMsg("ERA.PAY.REC.JOT.ALREADY.EXISTS");
	
	/** The Constant ERROR_PAO_OBJECTION_EXIST. */
	public static final String ERROR_PAO_OBJECTION_EXIST = MessageUtil.getMsg("IFMS.OBJECTION.EXIST");
	
	/** The Constant INVALID_BRANCH_CODE_ENTERD_BY_USER. */
	public static final String INVALID_BRANCH_CODE_ENTERD_BY_USER = MessageUtil
			.getMsg("INVALID.BRANCH.CODE.ENTERED.BY.USER");
	
	/** The Constant ERROR_ERA_IFSC_CODE_DOES_NOT_MATCH. */
	public static final String ERROR_ERA_IFSC_CODE_DOES_NOT_MATCH = MessageUtil.getMsg("ERA.IFSC.CODE.DOES.NOT.MATCH");
	
	/** The Constant ERROR_ERA_INVALID_IFSC_CODE. */
	public static final String ERROR_ERA_INVALID_IFSC_CODE = MessageUtil.getMsg("ERA.INVALID.IFSC.CODE");
	
	/** The Constant ERROR_ERA_INVALID_MAJORHEAD_CODE. */
	public static final String ERROR_ERA_INVALID_MAJORHEAD_CODE = MessageUtil.getMsg("ERA.INVALID.MAJORHEAD.CODE");
	
	/** The Constant ERROR_ERA_MJRHD_CODE_DOES_NOT_MATCH. */
	public static final String ERROR_ERA_MJRHD_CODE_DOES_NOT_MATCH = MessageUtil
			.getMsg("ERA.MJRHD.CODE.DOES.NOT.MATCH");
	
	/** The Constant ERROR_ERA_RBD_ENTRY_NOT_INITIATED. */
	public static final String ERROR_ERA_AMOUNT_EXCEED_FROM_RBD = MessageUtil
			.getMsg("ERROR.ERA.AMOUNT.EXCEED.FROM.RBD");
	
	/** The Constant ERROR_PAO_VITO_CODE_REQ. */
	public static final String ERROR_PAO_VITO_CODE_INVALID = MessageUtil.getMsg("PAO.VITO.CODE.INVALID");
	
	/** The Constant CI_MSG_FETCH. */
	public static final String CI_MSG_FETCH = MessageUtil.getMsg("CI.MSG.FETCH");
	
	/** The Constant CI_MSG_CREATE. */
	public static final String CI_MSG_CREATE = MessageUtil.getMsg("CI.CREATE");
	
	/** The Constant CI_MSG_DRAFT. */
	public static final String CI_MSG_DRAFT = MessageUtil.getMsg("CI.DREFT");
	
	/** The Constant CI_MSG_SUBMIT. */
	public static final String CI_MSG_SUBMIT = MessageUtil.getMsg("CI.SUBMIT");
	
	/** The Constant CI_MSG_DELETE. */
	public static final String CI_MSG_DELETE = MessageUtil.getMsg("CI.MSG.DELETE");
	
	/** The Constant CTSACCMAP_BANK_FETCH. */
	public static final String CTSACCMAP_BANK_FETCH = MessageUtil.getMsg("CTSACCMAP.BANK.FETCH");
	
	/** The Constant ERROR_CI_CTS_NOT_MAPPED. */
	public static final String ERROR_CI_CTS_NOT_MAPPED = MessageUtil.getMsg("CI.ERROR.CTS.NOT.MAPPED");
	
	/** The Constant ERROR_CI_CTS_ALREADY_MAPPED. */
	public static final String ERROR_CI_CTS_ALREADY_MAPPED = MessageUtil.getMsg("CI.ERROR.CTS.ALREADY.MAPPED");
	
	/** The Constant ERROR_CI_CHEQUE_BOOK_VALIDATION. */
	public static final String ERROR_CI_CHEQUE_BOOK_VALIDATION = MessageUtil.getMsg("CI.CHEQUE.BOOK.VALIDATION");
	
	/** The Constant ERROR_CI_MINIMUM_STOCK_VALIATION. */
	public static final String ERROR_CI_MINIMUM_STOCK_VALIATION = MessageUtil.getMsg("CI.MIN.BOOK.VALIDATION");
	
	/** The Constant ERROR_ERA_AUDIT_MAP_ALRADY_CREATED. */
	public static final String ERROR_ERA_AUDIT_MAP_ALRADY_CREATED = MessageUtil
			.getMsg("ERROR.ERA.AUDIT.MAP.ALRADY.CREATED");
	
	/** The Constant ERROR_REG_INDENT_EXISTS. */
	public static final String ERROR_REG_INDENT_EXISTS = MessageUtil.getMsg("CI.REGULAR.INDENT.EXISTS");
	
	/** The Constant ERROR_TPP_AMT_MUST_NOT_BE_SAME. */
	public static final String ERROR_TPP_AMT_MUST_NOT_BE_SAME = MessageUtil.getMsg("TPP.AMT.MUST.NOT.BE.SAME");
	
	/** The Constant ERROR_TPP_START_DATE_MUST_NOT_BE_SAME_AS_ENTERED_DATE. */
	public static final String ERROR_TPP_START_DATE_MUST_NOT_BE_SAME_AS_ENTERED_DATE = MessageUtil
			.getMsg("TPP.START.DATE.MUST.NOT.BE.SAME.AS.ENTERED.DATE");
	
	/** The Constant ERROR_TPP_START_DATE_MUST_BE_GREATERTHAN_ENTERED_DATE. */
	public static final String ERROR_TPP_START_DATE_MUST_BE_GREATERTHAN_ENTERED_DATE = MessageUtil
			.getMsg("TPP.START.DATE.MUST.NOT.BE.GREATERTHAN.ENTERED.DATE");
	
	/** The Constant ERROR_TPP_START_DATE_MUST_NOT_BE_GREATERTHAN_TO_DATE. */
	public static final String ERROR_TPP_START_DATE_MUST_NOT_BE_GREATERTHAN_TO_DATE = MessageUtil
			.getMsg("TPP.START.DATE.MUST.NOT.BE.GREATERTHAN.TO.DATE");

	/** The Constant ERROR_TPP_WF_MENU_NOT_ACCESS_MULTIPLE_ROLES. */
	public static final String ERROR_TPP_WF_MENU_NOT_ACCESS_MULTIPLE_ROLES = MessageUtil
			.getMsg("TPP.WF.MENU.NOT.ACCESS.MULTIPLE.ROLES");
	
	/** The Constant ERROR_TPP_PPO_NUMBER_DOES_NOT_EXIST. */
	public static final String ERROR_TPP_PPO_NUMBER_DOES_NOT_EXIST = MessageUtil
			.getMsg("TPP.PPO.NUMBER.DOES.NOT.EXIST");
	
	/** The Constant ERROR_TPP_PPO_NUMBER_IS_IN_PENDING_STATUS. */
	public static final String ERROR_TPP_PPO_NUMBER_IS_IN_PENDING_STATUS = MessageUtil
			.getMsg("TPP.PPO.NUMBER.IS.IN.PENDING.STATUS");
	
	/** The Constant ERROR_TPP_PPO_NUMBER_IS_RECEIVED_IN_THE_TREASURY_OFFICE. */
	public static final String ERROR_TPP_PPO_NUMBER_IS_RECEIVED_IN_THE_TREASURY_OFFICE = MessageUtil
			.getMsg("TPP.PPO.NUMBER.IS.RECEIVED.IN.THE.TREASURY.OFFICE");
	
	/** The Constant LIST_FETCH_FROM_SEARCH. */
	public static final String LIST_FETCH_FROM_SEARCH = MessageUtil.getMsg("LIST.FETCH.FROM.SEARCH");
	
	/** The Constant DATA_SAVED. */
	public static final String DATA_SAVED = MessageUtil.getMsg("DATA_SAVED");
	
	/** The Constant COMMON_ERROR_PROCESSING_TEMPLATE. */
	public static final String COMMON_ERROR_PROCESSING_TEMPLATE = MessageUtil
			.getMsg("COMMON.ERROR.PROCESSING.TEMPLATE");
	
	/** The Constant EMD_CHLN_ENTRY_DATE_FREZE. */
	public static final String EMD_CHLN_ENTRY_DATE_FREZE = MessageUtil.getMsg("EMD.CHLN.ENTRY.DATE.FREZE");
	
	/** The Constant BUDGET_STM_ALREADY_MAPPED. */
	public static final String BUDGET_STM_ALREADY_MAPPED = MessageUtil.getMsg("BUDGET.STM.ALREADY.MAPPED");
	
	/** The Constant IFMS_MSG_CREATE. */
	public static final String ERA_AUD_MAP_SUCCESSFULLY = MessageUtil.getMsg("ERA.AUD.MAPPED");
	
	/** The Constant PREVIOUS_QUARTER_RECORD_NOT_APPROVED. */
	public static final String PREVIOUS_QUARTER_RECORD_NOT_APPROVED = MessageUtil
			.getMsg("GRP.INS.PREVIOUS.QUARTER.RECORD.NOT.APPROVED");
	
	/** The Constant MULTIPLE_FY_YEAR_IS_ACTIVE. */
	public static final String MULTIPLE_FY_YEAR_IS_ACTIVE = MessageUtil
			.getMsg("GRP.INS.MULTIPLE.FY.YEAR.YEAR.FOUND.ACTIVE");
	
	/** The Constant PAO_MSG_VITO_CODE_GENERATED. */
	public static final String PAO_MSG_VITO_CODE_GENERATED = MessageUtil.getMsg("PAO.MSG.VITO.CODE.GENERATED");
	
	/** The Constant PAO_MSG_VITO_REPORT_GEN. */
	public static final String PAO_MSG_VITO_REPORT_GEN = MessageUtil.getMsg("PAO.MSG.VITO.REPORT.GENERATED");
	
	/** The Constant PAO_MSG_VITO_REPORT_GEN. */
	public static final String PAO_MSG_EPAYMENT_CODE_GENERATED = MessageUtil.getMsg("PAO.MSG.EPAYMENT.CODE.GENERATED");
	
	/** The Constant ERROR_PAO_EPAYMENTCODE_EXIST. */
	public static final String ERROR_PAO_EPAYMENTCODE_EXIST = MessageUtil.getMsg("PAO.MSG.EPAYMENT.CODE.EXIST");
	
	/** The Constant ERROR_PAO_CHEQUE_NUMBER_ASSIGNED. */
	public static final String ERROR_PAO_CHEQUE_NUMBER_ASSIGNED = MessageUtil.getMsg("PAO.CHEQUE.NUMBER.ASSIGNED");
	
	/** The Constant PAO_CHEQUE_DETAILS_NOT_FOUND. */
	public static final String PAO_CHEQUE_DETAILS_NOT_FOUND = MessageUtil.getMsg("PAO.CHEQUE.DETAILS.NOT.FOUND");
	
	/** The Constant ERROR_PAO_EDIT_NOT_ALLOWED_REGISTER_RECORD. */
	public static final String ERROR_PAO_EDIT_NOT_ALLOWED_REGISTER_RECORD = MessageUtil
			.getMsg("PAO.EDIT.NOT.ALLOWED.REGISTER.RECORD");
	
	/** The Constant PAO_BILL_DISPATCH. */
	public static final String PAO_BILL_DISPATCH = MessageUtil.getMsg("PAO.BILL.DISPATCH");
	
	/** The Constant ERROR_PAO_CHEQUE_NUMBER_INVALID. */
	public static final String ERROR_PAO_CHEQUE_NUMBER_INVALID = MessageUtil.getMsg("PAO_CHEQUE_NUMBER_INVALID");
	
	/** The Constant ERROR_REG_INDENT_EXISTS_WITHOUT_REF. */
	public static final String ERROR_REG_INDENT_EXISTS_WITHOUT_REF = MessageUtil
			.getMsg("CI.REGULAR.INDENT.EXISTS.WITHOUT.REF");
	
	/** The Constant CI_DATA_RESET. */
	public static final String CI_DATA_RESET = MessageUtil.getMsg("CI.DATA.RESET");
	
	/** The Constant INVALID_CHEQUE_NO_ENTERD_BY_USER. */
	public static final String INVALID_CHEQUE_NO_ENTERD_BY_USER = MessageUtil
			.getMsg("ERA.INVALID.CHEQUE.NO.ENTERED.BY.USER");
	
	/** The Constant DATA_FETCHED. */
	public static final String DATA_FETCHED = MessageUtil.getMsg("TPP.DATA.FETCHED");
	
	/** The Constant DATA_REJECTED. */
	public static final String DATA_REJECTED = MessageUtil.getMsg("TPP.DATA.REJECTED");
	
	/** The Constant DATA_UPDATED. */
	public static final String DATA_UPDATED = MessageUtil.getMsg("TPP.DATA.UPDATED");
	
	/** The Constant ERROR_TPP_MONTHLY_ENTERED_AMOUNT_MUST_BE_LESSTHAN_OR_EQUALS_TO_ARREAR_AMOUNT. */
	public static final String ERROR_TPP_MONTHLY_ENTERED_AMOUNT_MUST_BE_LESSTHAN_OR_EQUALS_TO_ARREAR_AMOUNT = MessageUtil
			.getMsg("ERROR.TPP.MONTHLY.ENTERED.AMOUNT.MUST.BE.LESSTHAN.OR.EQUALS.TO.ARREAR.AMOUNT");
	
	/** The Constant ERROR_PAO_DDO_NO_NOT_EXIST. */
	public static final String ERROR_PAO_DDO_NO_NOT_EXIST = MessageUtil.getMsg("PAO_DDO_NO_NOT_EXIST");

	/** The Constant TPP_PPO_NUMBER_SHOULD_NOT_BE_NULL. */
	public static final String TPP_PPO_NUMBER_SHOULD_NOT_BE_NULL = MessageUtil
			.getMsg("TPP.PPO.NUMBER.SHOULD.NOT.BE.NULL");
	
	/** The Constant ERROR_TPP_MORE_THAN_ONE_ACTIVE_ENTRY_FOUND. */
	public static final String ERROR_TPP_MORE_THAN_ONE_ACTIVE_ENTRY_FOUND = MessageUtil
			.getMsg("TPP.MORE.THAN.ONE.ACTIVE.ENTRY.FOUND");

	/** The Constant ERA_STO_CHALLAN_SAVE. */
	public static final String ERA_STO_CHALLAN_SAVE = MessageUtil.getMsg("ERA.STO.CHALLAN.SAVE");
	
	/** The Constant ERA_STO_CHALLAN_DELETE. */
	public static final String ERA_STO_CHALLAN_DELETE = MessageUtil.getMsg("ERA.STO.CHALLAN.DELETE");

	/** The Constant PAO.INVALID.EDPCODE. */
	public static final String INVALID_EDP_CODE = MessageUtil.getMsg("PAO.INVALID.EDPCODE");
	
	/** The Constant ERROR_PAO_ONE_TC_RANGE_PER_OFFICE_ID. */
	public static final String ERROR_PAO_ONE_TC_RANGE_PER_OFFICE_ID = MessageUtil
			.getMsg("PAO.ONE.TCRANGE.PER.OFFICEID");
	

	public static final String ERROR_PAO_POST_AUDIT = MessageUtil.getMsg("PAO.POSTAUDIT");

	/** The Constant ERROR_PAO_TE_GRANT_DETAILS. */
	public static final String ERROR_PAO_TE_GRANT_DETAILS = MessageUtil.getMsg("PAO.TE.GRANTDETAILS");

	

	public static final String ERROR_PAO_LIASON_OFFICE = MessageUtil.getMsg("PAO.LIASON.OFFICE");
	
	public static final String ERROR_PAO_VITO_REPORT_EXIST = MessageUtil.getMsg("PAO.VITO.REPORT.EXIST");


	public static final String ERROR_PAO_TE_LIST_DELETE = MessageUtil.getMsg("PAO.TE.LIST.DELETE");
	
	/** The Constant EMPLOYEE_MSG_FOR_REGULAR. */
	public static final String EMPLOYEE_MSG_FOR_REGULAR = MessageUtil.getMsg("employee.msg.for.regular");
	
	/**  The Constant ERRORRESP_FTR_EMP_ALREADY_INIT. */
	public static final String ERRORRESP_FTR_EMP_ALREADY_INIT = MessageUtil.getMsg("ERRORRESP.FTR.EMP.ALREADY.INIT");
	
	/** The Constant PVU_ERRORRESP_EFFDATE_EMPJOINIG. */
	public static final String PVU_ERRORRESP_EFFDATE_EMPJOINIG = MessageUtil.getMsg("PVU.ERRORRESP.EFFDATE.EMPJOINIG");
	
	/** The Constant EDP_MSG_FETCH_LIST. */
	public static final String ERROR_MSG_NOT_ALLOWED_BACKDATED_EVENTS = MessageUtil
			.getMsg("error.msg.not.allowed.backdated.events");
	
	/** The Constant ERROR_MSG_EFF_DATE_NOT_NULL. */
	public static final String ERROR_MSG_EFF_DATE_NOT_NULL = MessageUtil.getMsg("error.msg.eff.date.not.null");
	
	/** The Constant ERROR_MSG_ALLOW_REGULAR_HPS. */
	public static final String ERROR_MSG_ALLOW_REGULAR_HPS = MessageUtil.getMsg("error.msg.allow.only.regular.hps");
	
	/** The Constant ERROR_MSG_EXAM_MANDATORY. */
	public static final String ERROR_MSG_EXAM_MANDATORY = MessageUtil.getMsg("error.msg.ccc.exam.madatory");

	public static final String TOKEN_NO_MANDATORY = MessageUtil.getMsg("TOKEN.NO.MANDATORY");

	public static final String PAO_TE_SEARCHRESULT = MessageUtil.getMsg("PAO.TE.SEARCHLIST");
	//@my changes	
	public static final String PAO_LO_SEARCHRESULT = MessageUtil.getMsg("PAO.LO.SEARCHLIST");
	

	public static final String PAO_LIASON_SEARCHRESULT = MessageUtil.getMsg("PAO.LIASON.SEARCHLIST");
	
	public static final String ERROR_PAO_TE_GET = MessageUtil.getMsg("PAO_TE_GET");

	public static final String ERROR_PAO_ADVICE_NO_MANDATORY = MessageUtil.getMsg("ERROR.PAO.ADVICE.NO.MANDATORY");

	/** The Constant PVU_EMPLOYEE_ERROR_TO_OFFICE_PROB. */
	public static final String PVU_EMPLOYEE_ERROR_TO_OFFICE_PROB = MessageUtil
			.getMsg("PVU_EMPLOYEE_ERROR_TO_OFFICE_PROB");
	
	/** The Constant ERA_PHYSICAL_BILL_NOT_FOUND. */
	public static final String ERA_PHYSICAL_BILL_NOT_FOUND = MessageUtil.getMsg("ERA.PHYSICAL.BILL.NOT.FOUND");

	/** The Constant PVU_EMPLOYEE_ERROR_TO_OFFICE_ADHOC. */
	public static final String PVU_EMPLOYEE_ERROR_TO_OFFICE_ADHOC = MessageUtil
			.getMsg("PVU_EMPLOYEE_ERROR_TO_OFFICE_ADHOC");
	
	/** The Constant ERA_ONLINE_BILL_NOT_FOUND. */
	public static final String ERA_ONLINE_BILL_NOT_FOUND = MessageUtil.getMsg("ERA.ONLINE.BILL.NOT.FOUND");

	/** The Constant PVU_EMPLOYEE_ERROR_ALREADY_EXSIST. */
	public static final String PVU_EMPLOYEE_ERROR_ALREADY_EXSIST = MessageUtil
			.getMsg("PVU_EMPLOYEE_ERROR_ALREADY_EXSIST");
	
	/** The Constant PVU_EMPLOYEE_SAVED_SUCCESS. */
	public static final String PVU_EMPLOYEE_SAVED_SUCCESS = MessageUtil.getMsg("PVU_EMPLOYEE_SAVED_SUCCESS");
	
	/** The Constant PVU_EMPLOYEE_SAVED_DELETED. */
	public static final String PVU_EMPLOYEE_SAVED_DELETED = MessageUtil.getMsg("PVU_EMPLOYEE_SAVED_DELETED");
	
	/** The Constant PVU_EMPLOYEE_DRAFT_SUCCESS. */
	public static final String PVU_EMPLOYEE_DRAFT_SUCCESS = MessageUtil.getMsg("PVU_EMPLOYEE_DRAFT_SUCCESS");
	
	/** The Constant ERROR_WHILE_SAVING. */
	public static final String ERROR_WHILE_SAVING = MessageUtil.getMsg("ERROR.WHILE.SAVING");
	
	/** The Constant ERROR_AMOUNT_MUST_BE_LESS_THAN_ARREARS_AMOUNT. */
	public static final String ERROR_AMOUNT_MUST_BE_LESS_THAN_ARREARS_AMOUNT = MessageUtil
			.getMsg("AMOUNT.MUST.BE.LESS.THAN.ARREARS.AMOUNT");

	//public static final String VALIDATIONS_DONE = MessageUtil.getMsg("VALIDATIONS.DONE");

	public static final String PAO_MULTIPLE_ADVICE_RANGE_ALLOC = MessageUtil.getMsg("PAO.MULTIPLE.ADVICE.RANGE.ALLOC");
	
	public static final String DOP_DATA_ENTRY_NOT_PROPER = MessageUtil.getMsg("TBP.DOP_DATA_ENTRY_NOT_PROPER");

	public static final String PAO_ADVICE_RANGE_NOT_ALLOC = MessageUtil.getMsg("PAO.ADVICE.RANGE.NOT.ALLOC");

	public static final String PAO_ADVICE_TIME_BARRED = MessageUtil.getMsg("PAO.ADVICE.TIME.BARRED");

	
	/** The Constant VALIDATIONS_DONE. */
	public static final String VALIDATIONS_DONE = MessageUtil.getMsg("VALIDATIONS.DONE");
	
	/** The Constant ERA_TOKEN_NO_NOT_FOUND. */
	public static final String ERA_TOKEN_NO_NOT_FOUND = MessageUtil.getMsg("ERA_TOKEN_NO_NOT_FOUND");
	
	/** The Constant ERROR_TPP_GURDIANE_NAME_IS_MANDATORY. */
	public static final String ERROR_TPP_GURDIANE_NAME_IS_MANDATORY = MessageUtil
			.getMsg("ERROR.TPP.GURDIANE.NAME.IS.MANDATORY");
	
	/** The Constant ERROR_TPP_PENSIONER_HAS_NO_FAMILY_MEMBER. */
	public static final String ERROR_TPP_PENSIONER_HAS_NO_FAMILY_MEMBER = MessageUtil
			.getMsg("ERROR.TPP.PENSIONER.HAS.NO.FAMILY.MEMBER");
	
	/** The Constant ERROR_TPP_RELATIVE_ACCOUNT_NO_IS_MANDATORY. */
	public static final String ERROR_TPP_RELATIVE_ACCOUNT_NO_IS_MANDATORY = MessageUtil
			.getMsg("ERROR.TPP.RELATIVE.ACCOUNT.NO.IS.MANDATORY");

	/** The Constant ERROR_TPP_RELATIVE_DATE_OF_BIRTH_IS_MANDATORY. */
	public static final String ERROR_TPP_RELATIVE_DATE_OF_BIRTH_IS_MANDATORY = MessageUtil
			.getMsg("ERROR.TPP.RELATIVE.DATE.OF.BIRTH.IS.MANDATORY");
	
	/** The Constant ERA_ADVICE_NO_EXIST. */
	public static final String ERA_ADVICE_NO_EXIST = MessageUtil.getMsg("ERA.ADVICE.NO.EXIST");

	/** The Constant ERA_CHEQUE_NO_EXIST. */
	public static final String ERA_CHEQUE_NO_EXIST = MessageUtil.getMsg("ERA.CHEQUE.NO.EXIST");
	
	/** The Constant ERA_VCR_ALREADY_EXIST. */
	public static final String ERA_VCR_ALREADY_EXIST = MessageUtil.getMsg("ERA.VCR.ALREADY.EXIST");
	
	/** The Constant ERA_EDP_CODE_NOT_VALID. */
	public static final String ERA_EDP_CODE_NOT_VALID = MessageUtil.getMsg("ERA.EDP.CODE.NOT.VALID");
	
	/** DMO MODULE **/
	
	/** The Constant DMO_MSG_FETCH_LIST. */
	public static final String DMO_MSG_FETCH_LIST = MessageUtil.getMsg("DMO.FETCH.LIST");

	/** The Constant DMO_MSG_FETCH. */
	public static final String DMO_MSG_FETCH = MessageUtil.getMsg("DMO.FETCH");
	

	/** The Constant NSFF LOAN RECEIVED CREATE. */
	public static final String NSFF_LOAN_RECEIVED_MSG_CREATE = MessageUtil.getMsg("NSFFLOAN.CREATE");

	/** The Constant NSFF LOAN RECEIVED GET. */
	public static final String NSFF_LOAN_RECEIVED_MSG = MessageUtil.getMsg("NSFFLOAN.GET");
	
	/** The Constant DP SHEET GET Message. */
	public static final String DP_SHEET_GET_MSG = MessageUtil.getMsg("DPSHEET.GET");

	/** The Constant DP SHEET LIST Message. */
	public static final String DP_SHEET_MSG_FETCH_LIST = MessageUtil.getMsg("DPSHEET.LIST");
	
	/** The Constant NSFF LOAN RECEIVED UPDATE. */
	public static final String NSFF_LOAN_RECEIVED_MSG_UPDATE = MessageUtil.getMsg("NSFFLOAN.UPDATE");
	
	/** The Constant DP SHEET  CREATE. */
	public static final String DPSHEET_CREATE_MSG = MessageUtil.getMsg("DPSHEET.CREATE");
	
	/** The Constant MARKET LOAN RECEIVED CREATE. */
	public static final String MARKET_LOAN_RECEIVED_MSG_CREATE = MessageUtil.getMsg("MARKETLOAN.CREATE");

	/** The Constant MARKET LOAN RECEIVED GET. */
	public static final String MARKET_LOAN_RECEIVED_MSG = MessageUtil.getMsg("MARKETLOAN.GET");
	

	/** The Constant Scheme CREATE. */
	public static final String SCHEME_CREATE_MSG = MessageUtil.getMsg("SCHEME.CREATE");

	// Constant to add data in DB Party Master
	public static final String DB_PARTY_MASTER_ADD = MessageUtil.getMsg("Add data in Party Master");

	/** The DOI Fetched Msg. */
	public static final String DOI_FETCH = MessageUtil.getMsg("DOI.FETCH");

	/** The Constant GRF_CRF LOAN ACCOUNT RECEIVED CREATE. */
	public static final String GRFCRF_INTIMATION_RECEIVED_MSG_CREATE = MessageUtil.getMsg("GRFCRF.INTIMATION.CREATE");
	public static final String GRFCRF_INTIMN_SEARCH = MessageUtil.getMsg("GRFCRF.INTIMATION.SEARCH");
	public static final String GRFCRF_INTIMN_NOT_SEARCH = MessageUtil.getMsg("GRFCRF.INTIMATION.NOT.SEARCH");
	public static final String GRFCRF_FETCH_DROP_DOWN_LIST = MessageUtil.getMsg("GRFCRF.FETCH.DROP.DOWN.LIST");
	public static final String GRFCRF_NOT_FETCH_DROP_DOWN_LIST = MessageUtil.getMsg("GRFCRF.NOT.FETCH.DROP.DOWN.LIST");
	public static final String GRFCRF_INTIMATION_TYPE_OF_TRXN = MessageUtil.getMsg("GRFCRF.MANDATORY.TYPE.OF.TXN");
	public static final String GRFCRF_VALIDATION_FAILED = MessageUtil.getMsg("GRFCRF.VALIDATION.FAILED");
	/** The Constant GOI LOAN RECEIVED CREATE. */
	public static final String GOI_LOAN_RECEIVED_MSG_CREATE = MessageUtil.getMsg("GOILOAN.CREATE");
	/** The Constant GOI LOAN RECEIVED GET. */
	public static final String GOI_LOAN_RECEIVED_MSG = MessageUtil.getMsg("GOILOAN.GET");
	/** The Constant Institute LOAN RECEIVED CREATE. */
	public static final String INSTITUTE_LOAN_RECEIVED_MSG_CREATE = MessageUtil.getMsg("INSTITUTELOAN.CREATE");
	/** The Constant Institute LOAN RECEIVED UPDATE. */
	public static final String INSTITUTE_LOAN_RECEIVED_MSG_UPDATE = MessageUtil.getMsg("INSTITUTELOAN.UPDATE");

	/** The Constant Institute LOAN RECEIVED DELETE. */
	public static final String INSTITUTE_LOAN_RECEIVED_MSG_DELETE = MessageUtil.getMsg("INSTITUTELOAN.DELETE");

	/** The Constant Institute LOAN RECEIVED GET. */
	public static final String INSTITUTE_LOAN_RECEIVED_MSG = MessageUtil.getMsg("INSTITUTELOAN.GET");
	public static final String REMOVE_LOAN_MSG_DELETE = MessageUtil.getMsg("LOAN.DELETE");

	/** The Constant Institute LOAN RECEIVED GET. */
	public static final String GET_REMOVE_LOAN_MSG = MessageUtil.getMsg("REMOVELOAN.GET");
	public static final String DMO_GRFCRF_REPORT_CREATE = MessageUtil.getMsg("GRFCRF.REPORT.CREATE");
	public static final String DMO_MAIN_TXN_FETCH_LIST = MessageUtil.getMsg("DMO.TXN_FETCH.LIST");
	public static final String DP_SHEET_UPDATE_MSG = MessageUtil.getMsg("DPSHEET.UPDATE");
	/** Bank rate should not be more than 100 */
	public static final String RATE_MUST_BE_LESS_THAN_100 = MessageUtil.getMsg("ERRORRESP.RATE_MUST_BE_LESS_THAN_100");

	/** Bank master date should not be past date */
	public static final String DATE_MUST_NOT_BE_PAST_DATE = MessageUtil.getMsg("ERRORRESP.DATE_MUST_NOT_BE_PAST_DATE");

	/** Bank master record can not not be created. Already approved record exist. */
	public static final String CANNOT_CREATE_ALREADY_RECORD_AVAILABLE = MessageUtil.getMsg("ERRORRESP.CANNOT_CREATE_ALREADY_RECORD_AVAILABLE");

}
