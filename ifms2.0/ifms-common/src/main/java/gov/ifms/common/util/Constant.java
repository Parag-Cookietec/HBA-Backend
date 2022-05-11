package gov.ifms.common.util;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * The Class Constant.
 */
public class Constant {

	/** The Constant SINGLE_SPACE. */
	public static final String SINGLE_SPACE = " ";

	/** The Constant EMPLOYEE_RETIRED. */
	public static final String EMPLOYEE_RETIRED = "Employee is Retired.You can not give ROP";

	/**
	 * Instantiates a new constant.
	 */
	private Constant() {
		super();
	}

	/** The Constant BUDGET_SCHEMA. */
	public static final String BUDGET_MASTER_SCHEMA = "MASTER_V1";

	/** The Constant BUDGET_SCHEMA. */
	public static final String BUDGET_SCHEMA = "BUDGET";

	/** The Constant GRANT_SCHEMA. */
	public static final String GRANT_SCHEMA = "GRANT";

	/** The Constant EDP_SCHEMA. */
	public static final String EDP_MASTER_SCHEMA = "MASTER_V1";

	/** The Constant EDP_SCHEMA. */
	public static final String GRANT_MASTER_SCHEMA = "MASTER_V1";

	/** The Constant EDP_SCHEMA. */
	public static final String EDP_SCHEMA = "EDP";

	/** The Constant OAUTH_SCHEMA. */
	public static final String OAUTH_SCHEMA = "MASTER_V1";

	/** The Constant WORKFLOW_SCHEMA. */
	public static final String WORKFLOW_SCHEMA = "MASTER_V1";

	/** The Constant ACTIVE_STATUS. */
	public static final int ACTIVE_STATUS = 1;

	/** The Constant SCREEN_TYPE_PAY_FIXATION. */
	public static final int SCREEN_TYPE_PAY_FIXATION = 8;

	/** The Constant SCREEN_TYPE_PVU. */
	public static final int SCREEN_TYPE_PVU = 9;

	/** The Constant IN_ACTIVE_STATUS. */
	public static final int INACTIVE_STATUS = 0;

	/** The Constant LOOKUP_NAME_OBJECT_TYPE. */
	public static final String LOOKUP_NAME_OBJECT_TYPE = "Majorhead Subtype";

	/** The Constant LOOKUP_NAME_DISTRICT. */
	public static final String LOOKUP_NAME_DISTRICT = "District";

	/** The Constant LOOKUP_NAME_TALUKA. */
	public static final String LOOKUP_NAME_TALUKA = "Taluka";

	/** The Constant LOOKUP_NAME_OFFICE_TYPE. */
	public static final String LOOKUP_NAME_OFFICE_TYPE = "Office Type";

	/** The Constant DISTRICT_FOR_MCN. */
	public static final int DISTRICT_FOR_MCN = 1;

	/** The Constant DISTRICT_FOR_GRANT. */
	public static final int DISTRICT_FOR_GRANT = 2;

	/** The Constant UPLOAD_DIR. */

	public static final String UPLOAD_DIR = System.getProperty("java.io.tmpdir") + File.separator + "uploadingDir";

	/** The Constant DOUBLE_MAX_INTEGER. */
	public static final int DOUBLE_MAX_INTEGER = 10;

	/** The Constant DOUBLE_MAX_FRACTION. */
	public static final int DOUBLE_MAX_FRACTION = 2;

	/** The Constant FILE_PATH. */
	public static final String FILE_PATH = "filePath";

	/** The Constant DIR_PATH. */
	public static final String DIR_PATH = "dirPath";

	/** The Constant Model_Name_NI. */
	public static final String Model_Name_NI = "newItem";

	/** The Constant FILE_EXTENTIONS. */
	public static final String FILE_EXTENTIONS = "jpg,jpeg,png,docx,doc,pdf,xls,xlsx,JPG,JPEG,PNG,DOCX,DOC,PDF,XLS,XLSX";

	/** The Constant RESPONSE_ERROR_DUPLICATE_RECORD. */
	public static final int RESPONSE_ERROR_DUPLICATE_RECORD = 11500;

	/** The Constant DOT. */
	public static final String DOT = ".";

	/** The Constant COMMA. */
	public static final String COMMA = ",";

	/** The Constant COLON. */
	public static final String COLON = ":";

	/** The Constant IN_PAGE_INDEX. */
	public static final String IN_PAGE_INDEX = "IN_PAGE_INDEX";

	/** The Constant IN_PAGE_SIZE. */
	public static final String IN_PAGE_SIZE = "IN_PAGE_SIZE";

	/** The Constant IN_USER_LIST. */
	public static final String IN_USER_LIST = "IN_USER_LIST";

	/** The Constant IN_CURRENT_WFROLEID. */
	public static final String IN_CURRENT_WFROLEID = "IN_CURRENT_WFROLEID";

	/** The Constant PROC_RESULT. */
	public static final String PROC_RESULT = "getResult";

	/** The Constant CALL. */
	public static final String CALL = "call ";

	/** The Constant NIE_HEADER_ID. */
	public static final String NIE_HEADER_ID = "NIE_HEADER_ID";
	/** The Constant DEFAULT_LOCATION_CODE is used for getting District. */
	public static final String DEFAULT_LOCATION_CODE = "0";

	/** The Constant VALID_WF_ACTION_ID. */
	public static final int VALID_WF_ACTION_ID = 1;

	/** The Constant IS_PRIMARY_POST. */
	public static final int IS_PRIMARY_POST = 1;

	/** The Constant WF_ACTION_SEND_TO_PREVIOUS. */
	public static final String WF_ACTION_SEND_TO_PREVIOUS = "Send to Previous";

	/** The Constant WF_ACTION_REWORK. */
	public static final String WF_ACTION_REWORK = "Rework";

	/** The Constant COMMON_ATTACHMENT. */
	public static final String COMMON_ATTACHMENT = "Common Attachment";

	/** The Constant DEPARTMENT_LEVEL_ATTACHMENT_ID. */
	public static final long DEPARTMENT_LEVEL_ATTACHMENT_ID = 76;

	/** The Constant TO_LEVEL_ATTACHMENT_ID. */
	public static final long TO_LEVEL_ATTACHMENT_ID = 77;

	/**
	 * The Constant WORKFLOW_SCHEMA.
	 */
	public static final String PVU_SCHEMA = "PVU";

	/**
	 * The Constant WORKFLOW_SCHEMA.
	 */
	public static final String PVU_SCHEMA_MASTER = "MASTER_V1";

	/** The Constant WF_ACTION_SEND_BACK. */
	public static final String WF_ACTION_SEND_BACK = "Send Back";

	/** The Constant WF_ACTION_RETURN. */
	public static final String WF_ACTION_RETURN = "Return";

	/** The Constant UPDATE_OFFICE. */
	public static final String UPDATE_OFFICE = "Update Office";

	/** The Constant UPDATE_OFFICE_LIST. */
	public static final String UPDATE_OFFICE_LIST = "Update Office List";

	/** The Constant POST_CREATION. */
	public static final String POST_CREATION = "Create New Post";

	/** The Constant POST_CREATION_LIST. */
	public static final String POST_CREATION_LIST = "Create New Post-List";

	/** The Constant USER_POST_TRANSFER. */
	public static final String USER_POST_TRANSFER = "Post Transfer";

	/** The Constant USER_POST_TRANSFER_LIST. */
	public static final String USER_POST_TRANSFER_LIST = "Post Transfer- List";

	/** The Constant USER_RIGHT_MAPPING. */
	public static final String USER_RIGHT_MAPPING = "User Rights Mapping";

	/** The Constant RESET_PASWD. */
	public static final String RESET_PASWD = "Reset Password";

	/** The Constant OFFICE_SUMMARY. */
	public static final String OFFICE_SUMMARY = "Office Summary";

	/** The Constant UPDATE_DESIGNATION. */
	public static final String UPDATE_DESIGNATION = "Update Designation";

	/** The Constant ROLE_PERMISSION_CEV. */
	public static final String ROLE_PERMISSION_CEV = "Create,Edit,View";

	/** The Constant MENU_OFFICE. */
	public static final String MENU_OFFICE = "Office";

	/** The Constant MENU_EDP. */
	public static final String MENU_EDP = "EDP Functionality";

	/** The Constant MENU_DESIGNATION. */
	public static final String MENU_DESIGNATION = "Designation";

	/** The Constant MENU_POST. */
	public static final String MENU_POST = "Post Creation";

	/** The Constant EMP_CREATION. */
	public static final String EMP_CREATION = "Employee Creation";

	/** The Constant EMP_CREATION_LIST. */
	public static final String EMP_CREATION_LIST = "Employee Creation List";

	/** The Constant PAY_FIX_AND_PAY_VER. */
	public static final String PAY_FIX_AND_PAY_VER = "Pay Fixation and Pay Verification";

	/** The Constant PAY_FIX. */
	public static final String PAY_FIX = "Pay Fixation";

	/** The Constant LOOKUP_TRUE_VALUE. */
	public static final Integer LOOKUP_TRUE_VALUE = 1;

	/** The Constant LOOKUP_YES. */
	public static final String LOOKUP_YES = "YES";

	/** The Constant EDP_MODULE. */
	public static final String EDP_MODULE = "EDP";

	/** The Constant TO_LEVEL. */
	public static final String TO_LEVEL = "TO/PAO";

	/** The Constant EDP_LEVEL. */
	public static final String EDP_LEVEL = "EDP";

	/** The Constant IS_VERIFIED. */
	public static final long IS_VERIFIED = 2L;

	/** The Constant FILE_NAME_SEPARATOR. */
	public static final String FILE_NAME_SEPARATOR = "_";

	/** The Constant QUERY_PARAMETER_MARKER. */
	public static final String QUERY_PARAMETER_MARKER = "'";

	/** The Constant SQL_INNER_JOIN. */
	public static final String SQL_INNER_JOIN = "INNER JOIN  ";

	/** The Constant SQL_FROM. */
	public static final String SQL_FROM = " FROM ";

	/** The Constant BACK_SLASH. */
	public static final String BACK_SLASH = "/";

	/** The Constant DOCUMENT_TITLE. */
	public static final String DOCUMENT_TITLE = "DocumentTitle";

	/** File Content Type. */
	public static final String FILE_CONTENT_TYPE = "application/octet-stream";

	/** The Constant SAVE_AS_DRAFT. */
	public static final String SAVE_AS_DRAFT = "Saved as Draft";

	/** The Constant SUBMIT. */
	public static final String SUBMIT = "Submit";

	/** The Constant POST_MENU_CODE. */
	public static final String POST_MENU_CODE = "NPC";

	/** The Constant BLANK. */
	public static final String BLANK = StringUtils.EMPTY;

	/** The Constant SP_ROLE_USER_MAPPING_LIST. */
	public static final String SP_ROLE_USER_MAPPING_LIST = "SP_ROLE_USER_MAPPING_LIST_WF";

	/** The Constant ROLE_MAPPING_ATTACH. */
	public static final long ROLE_MAPPING_ATTACH = 13L;

	/** The search user role mapping. */
	private static Map<String, String> searchUserRoleMapping = new LinkedHashMap<>();

	/** The Constant IN_TRN_FROM_DATE. */
	public static final String IN_TRN_FROM_DATE = "IN_TRN_FROM_DATE";

	/** The Constant IN_TRN_NO. */
	public static final String IN_TRN_NO = "IN_TRN_NO";

	/** The Constant IN_TRN_TO_DATE. */
	public static final String IN_TRN_TO_DATE = "IN_TRN_TO_DATE";

	/** The Constant IN_EMPLOYEE_NAME. */
	public static final String IN_EMPLOYEE_NAME = "IN_EMPLOYEE_NAME";

	/** The Constant IN_EMPLOYEE_NO. */
	public static final String IN_EMPLOYEE_NO = "IN_EMPLOYEE_NO";

	/** The Constant IN_DISTRICT_ID. */
	public static final String IN_DISTRICT_ID = "IN_DISTRICT_ID";

	/** The Constant IN_DDO_NO. */
	public static final String IN_DDO_NO = "IN_DDO_NO";

	/** The Constant IN_CARDEX_NO. */
	public static final String IN_CARDEX_NO = "IN_CARDEX_NO";

	/** The Constant IN_STATUS_ID. */
	public static final String IN_STATUS_ID = "IN_STATUS_ID";

	/** The Constant IN_STATUS. */
	public static final String IN_STATUS = "IN_STATUS";

	/** The Constant IN_POST_ID. */
	public static final String IN_POST_ID = "IN_POST_ID";

	/** The Constant IN_OFF_ID. */
	public static final String IN_OFF_ID = "offId";

	/** The Constant IN_UPDATED_BY. */
	public static final String IN_UPDATED_BY = "IN_UPDATED_BY";

	/** The Constant IN_UPDATED_BY_POST. */
	public static final String IN_UPDATED_BY_POST = "IN_UPDATED_BY_POST";

	/** The Constant IN_UPDATED_DATE. */
	public static final String IN_UPDATED_DATE = "IN_UPDATED_DATE";

	/** The Constant IN_MENU_ID. */
	public static final String IN_MENU_ID = "menuId";

	/** The Constant IN_USR_RGMAP_ID. */
	public static final String IN_USR_RGMAP_ID = "userRoleMappingId";

	/** The Constant FILE_EXTENSION_CSV. */
	public static final String FILE_EXTENSION_CSV = "text/csv";

	/** The Constant FILE_EXTENSION_TXT. */
	public static final String FILE_EXTENSION_TXT = "text/plain";

	/** The Constant FILE_EXTENSION_PNG. */
	public static final String FILE_EXTENSION_PNG = "image/png";

	/** The Constant FILE_EXTENSION_JPEG. */
	public static final String FILE_EXTENSION_JPEG = "image/jpeg";

	/** The Constant FILE_EXTENSION_PDF. */
	public static final String FILE_EXTENSION_PDF = "application/pdf";

	/** The Constant FILE_EXTENSION_DOC. */
	public static final String FILE_EXTENSION_DOC = "application/msword";

	/** The Constant FILE_EXTENSION_DOCX. */
	public static final String FILE_EXTENSION_DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

	/** The Constant FILE_EXTENSION_XLS. */
	public static final String FILE_EXTENSION_XLS = "application/vnd.ms-excel";

	/** The Constant FILE_EXTENSION_XLXS. */
	public static final String FILE_EXTENSION_XLXS = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	/** The Constant FILE_EXTENSION_OCTET_STREAM. */
	public static final String FILE_EXTENSION_OCTET_STREAM = "application/octet-stream";

	/** The Constant EMP_DETAILS_NOT_EXIST. */
	public static final String EMP_DETAILS_NOT_EXIST = "Employee details not available";

	/** The Constant EMPLOYEE_WAS_ON_EOL_EFFECTIVE_DATE_MUST_BE_AFTER. */
	public static final String EMPLOYEE_WAS_ON_EOL_EFFECTIVE_DATE_MUST_BE_AFTER = "Employee was on eol. Effective date must be after ";

	/** The Constant EMPLOYEE_WAS_SUSPENDED_EFFECTIVE_DATE_MUST_BE_AFTER. */
	public static final String EMPLOYEE_WAS_SUSPENDED_EFFECTIVE_DATE_MUST_BE_AFTER = "Employee was suspended. Effective date must be after ";

	/** The Constant EVENT_EFFECTIVE_DATE_MUST_BE_GREATER_THAN_DATE_OF_JOINING. */
	public static final String EVENT_EFFECTIVE_DATE_MUST_BE_GREATER_THAN_DATE_OF_JOINING = "Event effective date must be greater than date of joining";

	/** The Constant ROP_CAN_NOT_BE_PERFORMED_ON_SUSPENDED_EMPLOYEE. */
	public static final String ROP_CAN_NOT_BE_PERFORMED_ON_SUSPENDED_EMPLOYEE = "ROP can't be performed on suspended employee";

	/** The Constant ONLY_REGULAR_EMPLOYEE_ELIGABLE_FOR_ROP. */
	public static final String ONLY_REGULAR_EMPLOYEE_ELIGABLE_FOR_ROP = "Only regular employee eligable for ROP";

	/** The Constant EMPLOYEE_NOT_EXIST_IN_6TH_PAY_COMMISSION. */
	public static final String EMPLOYEE_NOT_EXIST_IN_6TH_PAY_COMMISSION = "Employee not exist in 6th pay commission";

	/** The Constant EMPLOYEE_NOT_EXIST_IN_5TH_PAY_COMMISSION. */
	public static final String EMPLOYEE_NOT_EXIST_IN_5TH_PAY_COMMISSION = "Employee not exist in 5th pay commission";

	/** The Constant ROP_ALREADY_GIVEN_PROVIDE_EFFECTIVE_DATE_AS. */
	public static final String ROP_ALREADY_GIVEN_PROVIDE_EFFECTIVE_DATE_AS = "ROP already given, provide effective date as ";

	/** The Constant LONG_ZERO_VALUE. */
	public static final Long LONG_ZERO_VALUE = 0L;

	/** The Constant LONG_ONE_VALUE. */
	public static final Long LONG_ONE_VALUE = 1L;

	/** The Constant LONG_ONE_VALUE. */
	public static final Long LONG_TWO_VALUE = 2L;

	/** The Constant SHORT_ONE_VALUE. */
	public static final Short SHORT_TWO_VALUE = 2;

	/** The Constant DASH. */
	public static final String DASH = "-";

	/**
	 * Gets the search user role mapping.
	 *
	 * @return the search user role mapping
	 */
	public static Map<String, String> getSearchUserRoleMapping() {
		return searchUserRoleMapping;
	}

	/**
	 * Sets the search user role mapping.
	 *
	 * @param searchUserRoleMapping the search user role mapping
	 */
	public static void setSearchUserRoleMapping(Map<String, String> searchUserRoleMapping) {
		Constant.searchUserRoleMapping = searchUserRoleMapping;
	}

	/**
	 * The Class Regex.
	 */
	public static class Regex {

		/**
		 * Instantiates a new regex.
		 */
		private Regex() {

		}

		/**
		 * this is min three char length with all CAPITAL and before first char space
		 * not allowed as well end char not allowed space.
		 */
		public static final String VALIDATION_NAME_CAP_MAX_50_DIGIT = "^.{1,50}[A-Z]$";

		/** The Constant VALIDATION_NAME_CAP_MIN_0_MAX_50_DIGIT. */
		public static final String VALIDATION_NAME_CAP_MIN_0_MAX_50_DIGIT = "^.{0,50}[A-Z]$";

		/** The Constant VALIDATION_MOBILE_NO_10_DIGIT. */
		public static final String VALIDATION_MOBILE_NO_10_DIGIT = "^[6-9]\\d{9}$";

		/** The Constant VALIDATION_PASSPORT_NUMBER. */
		public static final String VALIDATION_PASSPORT_NUMBER = "^[A-Z]\\d{7}$";

		/** The Constant VALIDATION_PAN_NUMBER. */
		public static final String VALIDATION_PAN_NUMBER = "[A-Z]{5}\\d{4}[A-Z]{1}";

		/** The Constant VALIDATION_AADHAR_NUMBER. */
		public static final String VALIDATION_AADHAR_NUMBER = "\\d{4}\\d{4}\\d{4}$";

		/** The Constant MASKING_EMAIL_ID. */
		public static final String MASKING_EMAIL_ID = "(?<=.{3}).(?=.*@)";

		/** The Constant MASKING_MOBILE_NO. */
		public static final String MASKING_MOBILE_NO = "\\d(?=(?:\\D*\\d){4})";

		/** The Constant MASKING_CONSTANT_REPLACE. */
		public static final String MASKING_CONSTANT_REPLACE = "#";

		/** The Constant MASKING_HTML_TEXT. */
		public static final String MASKING_HTML_TEXT = "\\<.*?\\>";

		/** The Constant VALIDATE_SINGLESPACE. */
		public static final String VALIDATE_SINGLESPACE = "\\S+";

		/** The Constant VALIDATE_CAMELCASE. */
		public static final String VALIDATE_CAMELCASE = "^[A-Z][a-zA-Z0-9]*$";

		/** The Constant GOG_EMAIL_ID_REGEX. */
		public static final String GOG_EMAIL_ID_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\."
				+ "[a-zA-Z0-9_+&*-]+)*@gujarat.gov.in";
		/** The Constant VALIDATE_SPECIAL_CHARACTERS. */
		public static final String VALIDATE_SPECIAL_CHARACTERS = "[a-zA-Z0-9]+";

	}

	static {
		searchUserRoleMapping.put("trnNo", IN_TRN_NO);
		searchUserRoleMapping.put("trnFromDate", IN_TRN_FROM_DATE);
		searchUserRoleMapping.put("trnToDate", IN_TRN_TO_DATE);
		searchUserRoleMapping.put("employeeNo", IN_EMPLOYEE_NO);
		searchUserRoleMapping.put("employeeName", IN_EMPLOYEE_NAME);
		searchUserRoleMapping.put("districtId", IN_DISTRICT_ID);
		searchUserRoleMapping.put("ddoNo", IN_DDO_NO);
		searchUserRoleMapping.put("cardexNo", IN_CARDEX_NO);
		searchUserRoleMapping.put("statusId", IN_STATUS_ID);
		searchUserRoleMapping.put("postId", IN_POST_ID);
	}

	/** The Constant IN_ACTIVE_STATUS. */
	public static final int IN_ACTIVE_STATUS = 0;

	/** The Constant IN_EMP_ID. */
	public static final String IN_EMP_ID = "IN_EMP_ID";

	/** The Constant IN_WORKFLOW_ID. */
	public static final String IN_WORKFLOW_ID = "IN_WORKFLOW_ID";

	/** The Constant IN_WF_ROLE_ID. */
	public static final String IN_WF_ROLE_ID = "IN_WF_ROLE_ID";

	/** The Constant IN_WORKFLOW_ROLE_ID. */
	public static final String IN_WORKFLOW_ROLE_ID = "IN_WORKFLOW_ROLE_ID";

	/** The Constant INNER_JOIN. */
	public static final String INNER_JOIN = " INNER JOIN ";

	/** The Constant STATUS_ID. */
	public static final String STATUS_ID = "Status_id";

	/** The Constant RECOMMENDATION_FOR. */
	public static final String RECOMMENDATION_FOR = "Recommendation For";

	/** The Constant APPROVED. */
	public static final String APPROVED = "Approved";

	/** The Constant AUTHORIZE. */
	public static final String AUTHORIZE = "Authorize";

	/** The Constant RETURN. */
	public static final String RETURN = "Return";

	/** The Constant RETURN_BY_APPROVER_CLASS_II. */
	public static final String RETURN_BY_APPROVER_CLASS_II = "Returned  by PVU Approver Class II";

	/** The Constant AUTHORIZE_BY_CLASS_II. */
	public static final String AUTHORIZE_BY_CLASS_II = "Authorised by Class II";

	/** The Constant FORWARD_TO_PVU. */
	public static final String FORWARD_TO_PVU = "Forwarded to PVU";

	/** The Constant APPROVED. */
	public static final String IN_EVENT_NAME = "IN_EVENT_NAME";

	/** The Constant TRN_SCREEN. */
	public static final String TRN_SCREEN = "TRN_SCREEN";

	/** The Constant INC. */
	public static final String INC = "INC";

	/** The Constant ROP. */
	public static final String ROP = "ROP";

	/** The Constant SUS. */
	public static final String SUS = "SUS";

	/** The Constant EOL. */
	public static final String EOL = "EOL";

	/** The Constant LOOKUP_NO. */
	public static final String LOOKUP_NO = "NO";

	/** The Constant ACP. */
	public static final String ACP = "ACP";

	/** The Constant HP. */
	public static final String HP = "HIGH";

	/** The Constant CS_PVU. */
	public static final String CS_PVU = "CS_PVU";

	/** The Constant SG. */
	public static final String SG = "SG";

	/** The Constant SG_PVU. */
	public static final String SG_PVU = "SG_PVU";

	/** The Constant STP. */
	public static final String STP = "STP";

	/** The Constant PRFG. */
	public static final String PRFG = "PRFG";

	/** The Constant TK. */
	public static final String TK = "TK";

	/** The Constant ST. */
	public static final String ST = "ST";

	/** The Constant POST_BY_MENU_OFF_ID. */
	public static final String POST_BY_MENU_OFF_ID = "postByMenuOffId";

	/** The Constant WF_BY_MENU_OFF_ID. */
	public static final String WF_BY_MENU_OFF_ID = "wfByMenuOffId";

	/** The Constant SPRING_LOGGING_ENABLED. */
	public static final String SPRING_LOGGING_ENABLED = "spring.logging.enabled";

	/** The Constant EXITING. */
	public static final String EXITING = "Exiting {}";

	/** The Constant EXECUTION_GOV_IFMS_COMMON_LOGGING_ANNOTATION_TRACE. */
	public static final String EXECUTION_GOV_IFMS_COMMON_LOGGING_ANNOTATION_TRACE = "execution(@gov.ifms.common.logging.annotation.Trace * *(..))";

	/** The Constant DELIMITER. */
	public static final String DELIMITER = ",";

	/** The Constant ENTERING2. */
	public static final String ENTERING2 = "Entering {} ({}={})";

	/** The Constant ENTERING. */
	public static final String ENTERING = "Entering {} ()";

	/** The Constant REJECTED. */
	public static final String REJECTED = "Rejected";

	/** The Constant APPROVAL_IN_PROGESS. */
	public static final String APPROVAL_IN_PROGESS = "Approval in Progess";

	/** The Constant REJECTED. */
	public static final String HEADER_TAB = "headerTab";

	/** The Constant REJECTED. */
	public static final String ANN1_TAB = "ann1Tab";

	/** The Constant REJECTED. */
	public static final String REQ_EMP = "empReq";

	/** The Constant REJECTED. */
	public static final String RJ_WRK_CHRG = "wrkChrg";

	/** The Constant REJECTED. */
	public static final String LEAVE_ENCASH = "leaveEncash";

	/** The Constant REJECTED. */
	public static final String OUT_SOURCE = "outSource";

	/** The Constant ATTACHMENT_SUPPORTING_DOCUMENT. */
	public static final String ATTACHMENT_SUPPORTING_DOCUMENT = "Supporting Document";

	/** The Constant EST_DETAILS_ID. */
	public static final String EST_DETAILS_ID = "estDetailId";

	/** The Constant BLANK_STRING. */
	public static final String BLANK_STRING = "    ";

	/** The Constant SAVE_AS_DRAFT_STATUS_ID. */
	public static final Long SAVE_AS_DRAFT_STATUS_ID = 205L;

	/** The Constant IN_CREATED_BY. */
	public static final String IN_CREATED_BY = "IN_CREATED_BY";

	/** The Constant IN_CREATED_BY_POST. */
	public static final String IN_CREATED_BY_POST = "IN_CREATED_BY_POST";

	/** The Constant IN_POU_ID. */
	public static final String IN_POU_ID = "IN_POU_ID";

	/** The Constant IN_OFFICE_ID. */
	public static final String IN_OFFICE_ID = "IN_OFFICE_ID";

	/** The Constant CONDITION_CHECK. */
	public static final String CONDITION_CHECK = "ConditionCheck";

	/** The Constant ROP_2009. */
	public static final long ROP_2009 = 412;

	/** The Constant ROP_2016. */
	public static final long ROP_2016 = 413;

	/** The Constant ROP_2009_EVENT. */
	public static final String ROP_2009_EVENT = "ROP-2009";

	/** The Constant ROP_2016_EVENT. */
	public static final String ROP_2016_EVENT = "ROP-2016";

	/** The Constant RUGULAR_EMPLOYEE. */
	public static final long RUGULAR_EMPLOYEE = 156;

	/** The Constant ROP_REASON_TYPE. */
	public static final String ROP_REASON_TYPE = "ROP";

	/** The Constant EVENT_REASON_TYPE. */
	public static final String EVENT_REASON_TYPE = "EVENT";

	/** The Constant OTHER_REASON. */
	public static final long OTHER_REASON = 116;

	/** The Constant AUDITOR. */
	public static final long AUDITOR = 14;

	/** The Constant APPROVER_CLASS_TWO. */
	public static final long APPROVER_CLASS_TWO = 15;

	/** The Constant AUDITOR_NAME. */
	public static final String AUDITOR_NAME = "Auditor";

	/** The Constant APPROVER_CLASS_TWO_NAME. */
	public static final String APPROVER_CLASS_TWO_NAME = "Approver Class II";

	/** The Constant RETURN_VAL. */
	public static final long RETURN_VAL = 420;

	/** The Constant IN_PAY_COMM. */
	public static final String IN_PAY_COMM = "IN_PAY_COMM";

	/** The Constant IN_EVENT_DATE. */
	public static final String IN_EVENT_DATE = "IN_EVNT_DATE";

	/** The Constant COMMON_ATTACHMENT. */
	public static final String OTHER_ATTACHMENT = "Other";

	/** The Constant COMMON_ATTACHMENT. */
	public static final String SUPPORTNG_ATTACHMENT = "Supporting Document";

	/** The Constant COMMON_ATTACHMENT. */
	public static final String SANCTION_ATTACHMENT = "Sanction Order";

	/** The Constant TRN. */
	public static final String TRN = "TRN";

	/** The Constant SP_GRANT_CSS_SC_LIST. */
	/* public static final String SP_GRANT_CSS_SC_LIST = "SP_GRANT_CSS_SC_LIST"; */
	public static final String SP_GRANT_CSS_SC_LIST = "SP_GRANT_CSS_WF_INT_SC_LIST";

	/** The Constant SP_GRANT_CSS_SUBMIT. */
	public static final String SP_GRANT_CSS_SUBMIT = "GRANT_CSS_SUBMIT_DATA";

	/** The Constant SP_GRANT_AMOUNT_CSS_WF_TEST. */
	public static final String SP_GRANT_AMOUNT_CSS_WF = "SP_GRANT_AMOUNT_CSS_WF";

	/** The Constant SP_GET_CSS_SUMMARY. */
	public static final String SP_GET_CSS_SUMMARY = "SP_GET_CSS_SUMMARY";
	/** The Constant PVU_OFFICE_ID. */
	public static final long PVU_OFFICE_ID = 38;

	/** The Constant RE_APPOINTED. */
	public static final String RE_APPOINTED = "Re-Appointed";
	
	
	
	

	/** The Constant IN_TRN_ID. */
	public static final String IN_TRN_ID = "IN_TRN_ID";

	/** The Constant FORWARD_TARGET_LOCATION. */
	public static final String FORWARD_TARGET_LOCATION = "Forwarded to Target Location PF Approver";

	/** The Constant PULLBACK_BY_PF_APPROVER. */
	public static final String PULLBACK_BY_PF_APPROVER = "Pulled Back by (Source Location) PF Approver";

	/** The Constant REJECTED_BY_SRC_LOC. */
	public static final String REJECTED_BY_SRC_LOC = "Rejected by (Source Location) PF Approver";

	/** The Constant DDO_APPROVED. */
	public static final String DDO_APPROVED = "DDO Approved";

	/** The Constant REJECTED_BY_TAR_LOC. */
	public static final String REJECTED_BY_TAR_LOC = "Rejected by  (Target Location) PF Approver";

	/** The Constant PULLED_BACK. */
	public static final String PULLED_BACK = "Pulled Back";

	/** The Constant PENDING_FOR_JOINING_DATE. */
	public static final String PENDING_FOR_JOINING_DATE = "Pending for Joining Date";

	/** The Constant TRANSFER_STATUS_ID. */
	public static final String TRANSFER_STATUS_ID = "Transfer_Status_id";

	/** The Constant APPROVER_CLASS_ONE. */
	public static final long APPROVER_CLASS_ONE = 16L;

	/** The Constant IN_SCE_HEADERID. */
	public static final String IN_SCE_HEADERID = " IN_SCE_HEADERID";

	/** The Constant IN_USER_ID. */
	public static final String IN_USER_ID = " IN_USER_ID";

	/** The Constant IN_EVENT_CODE. */
	public static final String IN_EVENT_CODE = "IN_EVENT_CODE";

	/** The Constant ObjectFromEstablishmsnet. */
	public static final Map<String, String> ObjectFromEstablishmsnet = new HashMap<>();
	static {
		ObjectFromEstablishmsnet.put("0101", "0101");
		ObjectFromEstablishmsnet.put("0102", "0102");
		ObjectFromEstablishmsnet.put("0103", "0103");
		ObjectFromEstablishmsnet.put("0105", "0105");
		ObjectFromEstablishmsnet.put("0106", "0106");
		ObjectFromEstablishmsnet.put("0107", "0107");
		ObjectFromEstablishmsnet.put("0108", "0108");
		ObjectFromEstablishmsnet.put("0109", "0109");
		ObjectFromEstablishmsnet.put("0110", "0110");
		ObjectFromEstablishmsnet.put("0111", "0111");
		ObjectFromEstablishmsnet.put("0112", "0112");
		ObjectFromEstablishmsnet.put("0113", "0113");
		ObjectFromEstablishmsnet.put("0117", "0117");
		ObjectFromEstablishmsnet.put("0118", "0118");
		ObjectFromEstablishmsnet.put("0119", "0119");
		ObjectFromEstablishmsnet.put("0120", "0120");
	}

	/** The Constant SECURE_ALGO. */
	public static final String SECURE_ALGO = "PBEWithMD5AndDES";
	/** The Constant SPRING_ENCRYPT_KEY. */
	public static final String SPRING_ENCRYPT_KEY = "spring.encrypt.key";

	/** The Constant UTF8. */
	public static final Charset UTF8 = StandardCharsets.UTF_8;

	/** The Constant SP_INS_TRN_ATTACH. */
	public static final String SP_INS_TRN_ATTACH = "SP_INS_TRN_ATTACH";

	/** The Constant MAX_FILE_UPLOAD_LIMIT. */
	public static final int MAX_FILE_UPLOAD_LIMIT = 10;

	/** The Constant excludeObjectIncaseOfCapital. */
	public static final Map<String, String> excludeObjectIncaseOfCapital = new HashMap<>();
	static {
		excludeObjectIncaseOfCapital.put("2700", "2700");
		excludeObjectIncaseOfCapital.put("3100", "3100");
		excludeObjectIncaseOfCapital.put("3200", "3200");
		excludeObjectIncaseOfCapital.put("3300", "3300");
		excludeObjectIncaseOfCapital.put("3500", "3500");
	}

	/** The Constant excludeObjectIncaseOfRevenue. */
	public static final Map<String, String> excludeObjectIncaseOfRevenue = new HashMap<>();
	static {
		excludeObjectIncaseOfRevenue.put("5300", "5300");
		excludeObjectIncaseOfRevenue.put("5400", "5400");

	}

	/** The Constant BUD_SCE_CR_AC_ID. */
	public static final String BUD_SCE_CR_AC_ID = "sceAcId";

	/** The Constant BUD_SCE_CR_DTLSD_ID. */
	public static final String BUD_SCE_CR_DTLSD_ID = "sceDtlSdId";

	/** The Constant BUD_SCE_CR_ACGIA_ID. */
	public static final String BUD_SCE_CR_ACGIA_ID = "sceAcGiaId";

	/** The Constant BUD_SCE_CR_DTLGIASD_ID. */
	public static final String BUD_SCE_CR_DTLGIASD_ID = "sceDtlGiaSdId";

	/** The Constant IN_FY_ID. */
	public static final String IN_FY_ID = "fyId";

	/** The Constant IN_OFC_ID. */
	public static final String IN_OFC_ID = "IN_OFC_ID";

	/** The Constant IN_BUD_EST_TYPE_ID. */
	public static final String IN_BUD_EST_TYPE_ID = "budEstTypeId";

	/** The Constant BUD_EST_TYPE. */
	public static final String BUD_EST_TYPE = "Standing Charges Estimates - Form B & G-i-A";

	/** The Constant BUD_SCE_GIA_TAB. */
	public static final String BUD_SCE_GIA_TAB = "Jilla / Taluka / Gram";

	/** The Constant YES. */
	public static final String YES = "YES";

	/** The Constant NO. */
	public static final String NO = "NO";

	/** The Constant OBJECT_ID. */
	public static final String OBJECT_ID = "objectId";

	/** The Constant APPROVER_CLASS_ONE_NAME. */
	public static final String APPROVER_CLASS_ONE_NAME = "Approver Class I";

	/** The Constant USER_ID. */
	public static final String USER_ID = "userId";

	/** The Constant IN_TBUD_HDR_ID. */
	public static final String IN_TBUD_HDR_ID = "IN_TBUD_HDR_ID";

	/** The Constant IN_MAJORHEAD_CODE. */
	public static final String IN_MAJORHEAD_CODE = "IN_MAJORHEAD_CODE";

	/** The Constant IN_ESTIMATION_FROM. */
	public static final String IN_ESTIMATION_FROM = "IN_ESTIMATION_FROM";

	/** The Constant IN_RE_HDR_ID. */
	public static final String IN_RE_HDR_ID = "IN_RE_HDR_ID";

	/** The Constant LOOKUP_STATUS_ID. */
	public static final String LOOKUP_STATUS_ID = "Status_id";

	/** The Constant LOOKUP_ADMINISTRATIVE_DEPARTMENT. */
	public static final String LOOKUP_ADMINISTRATIVE_DEPARTMENT_OFFICE_TYPE = "Administrative Department";

	/** The Constant LOOKUP_HOD_OFFICE_TYPE. */
	public static final String LOOKUP_HOD_OFFICE_TYPE = "Head of Department (HOD)";

	/** The Constant LOOKUP_NAME_OFFICE_TYPE2. */
	public static final String LOOKUP_NAME_OFFICE_TYPE2 = "Office_type";

	/** The Constant IN_DEPT_ID. */
	public static final String IN_DEPT_ID = "IN_DEPT_ID";

	/** The Constant IN_FY_ID. */
	public static final String IN_FY_ID_RE = "IN_FY_ID";

	/** The Constant IN_MAJOR_HEAD_ID. */
	public static final String IN_MAJOR_HEAD_ID = "IN_MAJOR_HEAD_ID";

	/** The Constant LONG_ONE_VALUE. */
	public static final int INT_ONE_VALUE = 1;

	/** The Constant LONG_ONE_VALUE. */
	public static final int INT_TWO_VALUE = 2;

	/** The Constant IN_MAJORHEAD_ID. */
	public static final String IN_MAJORHEAD_ID = "IN_MAJORHEAD_ID";

	/** The Constant IN_FINANCIAL_YEAR_ID. */
	public static final String IN_FINANCIAL_YEAR_ID = "IN_FINANCIAL_YEAR_ID";

	/** The Constant IN_DEPARTMENT_ID. */
	public static final String IN_DEPARTMENT_ID = "IN_DEPARTMENT_ID";

	/** The Constant IN_ACTION_ID. */
	public static final String IN_ACTION_ID = "IN_ACTION_ID";

	/** The Constant IN_UNKHNOWN. */
	public static final String IN_UNKHNOWN = "?";

	/** The Constant IN_RE_CON_HDR_ID. */
	public static final String IN_RE_CON_HDR_ID = "IN_RE_CON_HDR_ID";

	/** The Constant IN_RE_CON_STATUS_ID. */
	public static final String IN_RE_CON_STATUS_ID = "IN_RE_CON_STATUS_ID";

	/** The Constant IN_TBUD_RE_CON_HDR_ID. */
	public static final String IN_TBUD_RE_CON_HDR_ID = "IN_TBUD_RE_CON_HDR_ID";

	/** The Constant IN_TBUD_RE_AD_CON_HDR_ID. */
	public static final String IN_TBUD_RE_AD_CON_HDR_ID = "IN_TBUD_RE_AD_CON_HDR_ID";

	/** The Constant IN_HDR_ID. */
	public static final String IN_HDR_ID = "IN_HDR_ID";

	/** The Constant LOOK_UP_CLASS_TYPE. */
	public static final String LOOK_UP_CLASS_TYPE = "Class_Type";

	/** The Constant LOOKUP_INFO_ID. */
	public static final String LOOKUP_INFO_ID = "lookUpInfoId";

	/** The Constant LOOK_UP_CONDITIONCHECK. */
	public static final String LOOK_UP_CONDITIONCHECK = "ConditionCheck";

	/** The Constant LOOK_UP_QUALITY_CERTIFICATE. */
	public static final String LOOK_UP_QUALITY_CERTIFICATE = "Quality_Certificate";

	/** The Constant LOOKUP_FALSE_VALUE. */
	public static final Long LOOKUP_FALSE_VALUE = 1l;

	/** The Constant LOOKUP_INFO_NC_NEW_POST_IS_APPROVED_ID. */
	public static final Long LOOKUP_INFO_NC_NEW_POST_IS_APPROVED_ID = 469l;

	/** The Constant LOOKUP_INFO_NC_NEW_POST_RULES_RECRUITMENT_ID. */
	public static final Long LOOKUP_INFO_NC_NEW_POST_RULES_RECRUITMENT_ID = 468l;

	/** The Constant IN_NC_HDR_ID. */
	public static final String IN_NC_HDR_ID = "IN_NC_HDR_ID";

	/** The Constant DOUBLE_MAX_INTEGER_RATIO. */
	public static final int DOUBLE_MAX_INTEGER_RATIO = 3;

	/** The Constant IN_FY_ID. */
	public static final String FY_ID = "fyId";

	/** The Constant WF_APPROVE_ACTION. */
	public static final long WF_APPROVE_ACTION = 8l;

	/** The Constant WF_APPROVE_ACTION. */
	public static final long WF_RECOMMEND_ACTION = 25l;

	/** The Constant WF_ROLE_ID_MINISTER. */
	public static final long WF_ROLE_ID_MINISTER = 28l;

	/** The Constant WF_ROLE_ID_SECRETARY. */
	public static final long WF_ROLE_ID_SECRETARY = 31l;

	/** The Constant WF_ROLE_ID_ADD_SECRETARY. */
	public static final long WF_ROLE_ID_ADD_SECRETARY = 32l;

	/** The Constant LU_APPROVED_LOOKUP_INFO_ID. */
	public static final long LU_APPROVED_LOOKUP_INFO_ID = 327;

	/** The Constant LU_ACTIVE_LOOKUP_INFO_ID. */
	public static final long LU_ACTIVE_LOOKUP_INFO_ID = 283;

	/** The Constant BUDGET_PROPOSAL_TYPE_OTHER. */
	public static final Long BUDGET_PROPOSAL_TYPE_OTHER = 617L;

	/** The Constant BUDGET_PROPOSAL_TYPE_NEW_LOOKUP_ID. */
	public static final Long BUDGET_PROPOSAL_TYPE_NEW_LOOKUP_ID = 613L;

	/** The Constant BUDGET_PROPOSAL_TYPE_CONTINUOUS_LOOKUP_ID. */
	public static final Long BUDGET_PROPOSAL_TYPE_CONTINUOUS_LOOKUP_ID = 614L;

	/** The Constant BUDGET_MAJOR_TYPE_CAT_SPECIFIC_LOOKUP_ID. */
	public static final Long BUDGET_MAJOR_TYPE_CAT_SPECIFIC_LOOKUP_ID = 615L;

	/** The Constant BUDGET_MAJOR_TYPE_CAT_REGULAR_LOOKUP_ID. */
	public static final Long BUDGET_MAJOR_TYPE_CAT_REGULAR_LOOKUP_ID = 616L;

	/** The Constant LU_MS_OFFICE_TYPE_AD. */
	public static final Long LU_MS_OFFICE_TYPE_AD = 52L;

	/** The Constant DEMAND_CODE. */
	public static final String DEMAND_CODE = "demandCode";

	/** The Constant MAJORHEAD_CODE. */
	public static final String MAJORHEAD_CODE = "majorheadCode";

	/** The Constant SUBMAJORHEAD_CODE. */
	public static final String SUBMAJORHEAD_CODE = "submajorheadCode";

	/** The Constant MINOREHEAD_CODE. */
	public static final String MINOREHEAD_CODE = "minorheadCode";

	/** The Constant SUBHEAD_CODE. */
	public static final String SUBHEAD_CODE = "subheadCode";

	/** The Constant DETAILHEAD_CODE. */
	public static final String DETAILHEAD_CODE = "detailheadCode";

	/** The Constant VERIFIER_NAME. */
	public static final String VERIFIER_NAME = "PVU Verifier";

	/** The Constant AUTHORIZE_CLASS_I. */
	public static final String AUTHORIZE_CLASS_I = "Approver Class I";

	/** The Constant RETURN_BY_APPROVER_CLASS_I. */
	public static final String RETURN_BY_APPROVER_CLASS_I = "Returned  by PVU Approver Class I";

	/** The Constant AUTHORIZE_BY_CLASS_I. */
	public static final String AUTHORIZE_BY_CLASS_I = "Authorised by Class I";

	/** The Constant VERIFIER. */
	public static final Long VERIFIER = 27L;

	/** The Constant OUTWARD_FLAG_ONE. */
	public static final int OUTWARD_FLAG_ONE = 1;

	/** The Constant OUTWARD_FLAG_ZERO. */
	public static final int OUTWARD_FLAG_ZERO = 0;

	/** The Constant APPROVAL_IN_PROGRESS. */
	public static final String APPROVAL_IN_PROGRESS = "Approval in Progress";

	/** The Constant PVU_VERIFIER. */
	public static final long PVU_VERIFIER = 27L;

	/** The Constant PVU_VERIFIER_NAME. */
	public static final String PVU_VERIFIER_NAME = "PVU Verifier";

	/** The Constant BUD_SCE_CON_HDR_ID. */
	public static final String BUD_SCE_CON_HDR_ID = "sceConHdrId";

	/** The Constant IN_EVNT_CODE. */
	public static final String IN_EVNT_CODE = "IN_EVNT_CODE";

	/** The Constant CAS. */
	public static final String CAS = "CAS";

	/** The Constant DATE_FORMAT_DD_MMMM_YYYY. */
	public static final String DATE_FORMAT_DD_MMMM_YYYY = "dd, MMMM, yyyy";

	/** The Constant EDP_FD_OFFICE_CARDEX_NO. */
	public static final Long EDP_FD_OFFICE_CARDEX_NO = 5L;

	/** The Constant LU_YES_LOOKUP_INFO_ID. */
	public static final long LU_YES_LOOKUP_INFO_ID = 2;

	/** The Constant IN_IS_NEW. */
	public static final String IN_IS_NEW = "IN_IS_NEW";

	/** The Constant BUDGET_NW_CON_DEFAULT. */
	public static final String BUDGET_NW_CON_DEFAULT = "_DEFAULT";

	/** The Constant BUDGET_NW_CON_IS_PARENT_CO. */
	public static final String BUDGET_NW_CON_IS_PARENT_CO = "IS_PARENT_CO";

	/** The Constant BUDGET_NW_CON_MIN_RECOMMENDED. */
	public static final String BUDGET_NW_CON_MIN_RECOMMENDED = "MIN_RECOMMENDED";

	/** The Constant BUDGET_NW_CON_FDGROUP_RECOMMENDED. */
	public static final String BUDGET_NW_CON_FDGROUP_RECOMMENDED = "FDGROUP_RECOMMENDED";

	/** The Constant BUDGET_FDGROUP_RECOMMENDED_LOCK_UNLOCK. */
	public static final String BUDGET_FDGROUP_RECOMMENDED_LOCK_UNLOCK = "FDGROUP_RECOMMENDED_LOCK_UNLOCK";

	/** The Constant BUDGET_NW_CON_OTHERS. */
	public static final String BUDGET_NW_CON_OTHERS = "OTHERS";

	/** The Constant BUDGET_NW_CON_SPECIFIC. */
	public static final String BUDGET_NW_CON_SPECIFIC = "SPECIFIC";

	/** The Constant BUDGET_NW_CON_AUTHORISED. */
	public static final String BUDGET_NW_CON_AUTHORISED = "AUTHORISED";

	/** The Constant BUDGET_NW_CON_NOT_AUTHORISED. */
	public static final String BUDGET_NW_CON_NOT_AUTHORISED = "NOT_AUTHORISED";

	/** The Constant PVU_TRANSFER_PENDING_FOR_JOINING. */
	public static final String PVU_TRANSFER_PENDING_FOR_JOINING = "Pending for Joining";

	/** The Constant BUDGET_NW_CON_MIN_NOT_RECOMMENDED. */
	public static final String BUDGET_NW_CON_MIN_NOT_RECOMMENDED = "MIN_NOT_RECOMMENDED";

	/** The Constant BUDGET_RRE_CON_APPROVE_ACTION_ALLOWED. */
	public static final String BUDGET_RRE_CON_APPROVE_ACTION_ALLOWED = "APPROVE_ACTION_ALLOWED";

	/** The Constant BUDGET_CHECK_UN_FREEZE_CAPREV. */
	public static final String BUDGET_CHECK_UN_FREEZE_CAPREV = "CHECK_UN_FREEZE_CAPREV";

	/** The Constant ZERO_STR. */
	public static final String ZERO_STR = "0";
	/** The Constant MENU_OFFICE_TYPE_ID. */
	public static final String MENU_OFFICE_TYPE_ID = "menuOfficeTypeId";

	/** The Constant IN_USER_ROLE_MAPPING_ID. */
	public static final String IN_USER_ROLE_MAPPING_ID = "IN_USER_ROLE_MAPPING_ID";

	/** The Constant IN_IS_REMOVED. */
	public static final String IN_IS_REMOVED = "IN_IS_REMOVED";

	/** The Constant PERM_ID. */
	public static final String PERM_ID = "PERM_ID";

	/** The Constant MENU_ID. */
	public static final String MENU_ID = "IN_MENU_ID";

	/** The Constant IN_ROLE_IDS. */
	public static final String IN_ROLE_IDS = "IN_ROLE_IDS";

	/** The Constant TRN_SCREEN. */
	public static final String IN_USER_CODE = "in_user_code";

	/** The Constant LU_ATTACHMENT_CATEGORY_LOOKUP_ID. */
	public static final long LU_ATTACHMENT_CATEGORY_LOOKUP_ID = 120;

	/** The Constant NO_LOOKUP_INFO_ID. */
	public static final long NO_LOOKUP_INFO_ID = 1l;

	/** The Constant REVENUE_LOOKUP_ID. */
	public static final long REVENUE_LOOKUP_ID = 5l;

	/** The Constant CAPITAL_LOOKUP_ID. */
	public static final long CAPITAL_LOOKUP_ID = 6l;

	/** The Constant CANCELLED_LOOKUP_NAME. */
	public static final String CANCELLED_LOOKUP_NAME = "Cancelled";

	/** The Constant REJECTED_LOOKUP_NAME. */
	public static final String REJECTED_LOOKUP_NAME = "Rejected";

	/** The Constant REJECTED_LOOKUP_NAME. */
	public static final String PENDING_LOOKUP_NAME = "Pending";

	/** The Constant REJECTED_LOOKUP_ID. */
	public static final long REJECTED_LOOKUP_ID = 348l;

	/** The Constant IN_WF_ID. */
	public static final String IN_WF_ID = "IN_WF_ID";

	/** The Constant SP_GRANT_CNTF_SC_LIST. */
	public static final String SP_GRANT_CNTF_SC_LIST = "SP_GRANT_CNTF_WF_INT_SC_LIST";
	/** The Constant STATUS_LOOKUP_ID. */
	public static final long STATUS_LOOKUP_ID = 62l;

	/** The Constant IN_EST_HDR_ID. */
	public static final String IN_EST_HDR_ID = "IN_EST_HDR_ID";

	/** The Constant EDP_WF_COMMAN_HEADER_SP_NAME. */
	public static final String EDP_WF_COMMAN_HEADER_SP_NAME = "call EDP.SP_GET_HEADER_DETAILS_COMMON(?,?,?)";

	/** The Constant ARIAL_FONT. */
	public static final String ARIAL_FONT = "Arial";

	/** The Constant OFFICE_DETAIL_SUMMARY. */
	public static final String OFFICE_DETAIL_SUMMARY = "Detail Office Summary";

	/** The Constant VEHICLE_CONDITION_CHECK. */
	public static final String VEHICLE_CONDITION_CHECK = "Not_App_Condition_Type";

	/** The Constant BUDGET_NW_FA_CON_AUTHORIZED. */
	public static final String BUDGET_NW_FA_CON_AUTHORIZED = "FA_CON_AUTHORIZED";

	/** The Constant BUDGET_NW_FA_CON_NOT_AUTHORIZED. */
	public static final String BUDGET_NW_FA_CON_NOT_AUTHORIZED = "FA_CON_NOT_AUTHORIZED";

	/** The Constant PRINTED. */
	public static final String PRINTED = "printed";

	/** The Constant IN_DESIGNATION_NAME. */
	public static final String IN_DESIGNATION_NAME = "IN_DESIGNATION_NAME";

	/** The Constant GRANT_REAPPROPRIATION_SUBMIT_DATA. */
	public static final String GRANT_REAPPROPRIATION_SUBMIT_DATA = "GRANT_REAPPROPRIATION_SUBMIT_DATA";

	/** The Constant SP_GRANT_AMOUNT_REAPPROPRIATION. */
	public static final String SP_GRANT_AMOUNT_REAPPROPRIATION = "SP_GRANT_AMOUNT_REAPPROPRIATION";

	/** The Constant SP_BUD_FD_GROUP. */
	public static final String SP_BUD_FD_GROUP = "SP_BUD_FD_GROUP";

	/** The Constant SP_REAPP_AMT_NEW_LV. */
	public static final String SP_REAPP_AMT_NEW_LV = "SP_REAPP_AMT_NEW_LV";

	/** The Constant IN_REQ_HDR_ID. */
	public static final String IN_REQ_HDR_ID = "IN_REQ_HDR_ID";

	/** The Constant IN_WF_STATUS. */
	public static final String IN_WF_STATUS = "IN_WF_STATUS";

	/** The Constant IN_DEMAND_ID. */
	public static final String IN_DEMAND_ID = "IN_DEMAND_ID";

	/** The Constant IN_REVENUE_CAPITAL. */
	public static final String IN_REVENUE_CAPITAL = "IN_REVENUE_CAPITAL";

	/** The Constant IN_FINANCIAL_YEAR. */
	public static final String IN_FINANCIAL_YEAR = "IN_FINANCIAL_YEAR";

	/** The Constant IN_FUND_TYPE. */
	public static final String IN_FUND_TYPE = "IN_FUND_TYPE";

	/** The Constant IN_REF_NO. */
	public static final String IN_REF_NO = "IN_REF_NO";

	/** The Constant IN_ORDER_NO. */
	public static final String IN_ORDER_NO = "IN_ORDER_NO";

	/** The Constant IN_MODIFIED_BY. */
	public static final String IN_MODIFIED_BY = "IN_MODIFIED_BY";

	/** The Constant IN_STATUS_CD. */
	public static final String IN_STATUS_CD = "IN_STATUS_CD";

	/** The Constant IN_CO_NAME. */
	public static final String IN_CO_NAME = "IN_CO_NAME";

	/** The Constant OUT_DEPARTMENT_ID. */
	public static final String OUT_DEPARTMENT_ID = "OUT_DEPARTMENT_ID";

	/** The Constant SP_GRANT_REQUEST_CONSOLIDATION_AMT_RELEASE. */
	public static final String SP_GRANT_REQUEST_CONSOLIDATION_AMT_RELEASE = "SP_GRANT_REQUEST_CONSOLIDATION_AMT_RELEASE";

	/** The Constant CON_REQUEST_GRANT_SUBMIT_DATA. */
	public static final String CON_REQUEST_GRANT_SUBMIT_DATA = "CON_REQUEST_GRANT_SUBMIT_DATA";

	/** The Constant IN_LK_POU_ID. */
	public static final String IN_LK_POU_ID = "IN_LK_POU_ID";

	/** The Constant IN_USER. */
	public static final String IN_USER = "IN_USER_ID";

	/** The Constant CONTRACT_SCHEMA. */
	public static final String CONTRACT_SCHEMA = "CONTRACT";

	/** The Constant CONTRACT_CON_STATE_UTC_GRANT_DEPT. */
	public static final String CONTRACT_CON_STATE_UTC_GRANT_DEPT = "GRANTED_BY_DEPARTMENT";

	/** The Constant CONTRACT_CON_STATE_UTC_DEFAULT. */
	public static final String CONTRACT_CON_STATE_UTC_DEFAULT = "DEFAULT_PARENT_OFFICE";

	/** The Constant SUBMIT_STATUS_ID. */
	public static final Long SUBMIT_STATUS_ID = 267L;

	/** The Constant APPROVED_STATUS_ID. */
	public static final Long APPROVED_STATUS_ID = 327L;

	/** The Constant TBL_MASTER_FINANCIAL_YEAR. */
	public static final String TBL_MASTER_FINANCIAL_YEAR = "MS_FINANCIAL_YEAR";

	/** The Constant WHERE. */
	public static final String WHERE = " WHERE";

	public static final long STATE_GUJ_ID = 7l;

	public static final String ASSIGN_BY_POU_ID = "ASSIGN_BY_POU_ID";

	public static final String ASSIGN_TO_POU_ID = "ASSIGN_TO_POU_ID";

	public static final String TO_SN_POU_IDS = "TO_SN_POU_IDS";

	public static final String BCC_EMAIL_IDS = "BCC_EMAIL_IDS";

	public static final String TO_MOBILES = "TO_MOBILES";

	public static final String FILE_ATTACHMENT_ID = "FILE_ATTACHMENT_ID";

	public static final String FILE_NAME = "FILE_NAME";

	public static final String TRN_NO = "TRN_NO";

	public static final String TO_EMAIL_IDS = "TO_EMAIL_IDS";

	public static final String CC_EMAIL_IDS = "CC_EMAIL_IDS";

	public static final String UN_READ = "UNREAD";

	/** The Constant PAO_SCHEMA. */
	public static final String PAO_SCHEMA = "BILL";

	/** The Constant SUBMITTED_TO. */
	public static final String SUBMITTED_TO = "Submitted to TO";

	/** The Constant NO_MESSAGE_FOUND. */
	public static final String NO_MESSAGE_FOUND = "No Message Found";

	/** The Constant SMS_PARAM_MO_NO. */
	public static final String SMS_PARAM_MO_NO = "mobileno";

	/** The Constant SMS_PARAM_SENDER_ID. */
	public static final String SMS_PARAM_SENDER_ID = "senderid";

	/** The Constant SMS_PARAM_CONTENT. */
	public static final String SMS_PARAM_CONTENT = "content";

	/** The Constant SMS_PARAM_SMSSERVICETYPE. */
	public static final String SMS_PARAM_SMSSERVICETYPE = "smsservicetype";

	/** The Constant SMS_PARAM_USERNAME. */
	public static final String SMS_PARAM_USERNAME = "username";

	/** The Constant SMS_PARAM_PASSWORD. */
	public static final String SMS_PARAM_PASSWORD = "password";

	/** The Constant SMS_PARAM_KEY. */
	public static final String SMS_PARAM_KEY = "key";

	/** The Constant DOCUMENT_KEY. */
	public static final String DOCUMENT_KEY = "DOCUMENT_KEY";

	/** The Constant EDP_MODULE. */
	public static final String PAO_MODULE = "PAO";

	/** The Constant EDP_SCHEMA. */
	public static final String PAO_MASTER_SCHEMA = "MASTER_V1";

	/** The Constant SQL_JOIN. */
	public static final String SQL_JOIN = "JOIN  ";

	/** The Constant LEFT_JOIN. */
	public static final String LEFT_JOIN = " LEFT JOIN ";

	/** The Constant PROC_RESULT_TWO. */
	public static final String PROC_RESULT_TWO = "getResult2";

	/** The Constant CANCELLED_LOOKUP_ID. */
	public static final long CANCELLED_LOOKUP_ID = 872l;

	/** The Constant BILL_PAO_WF_COMMON_HEADER_SP_NAME. */
	public static final String BILL_PAO_WF_COMMON_HEADER_SP_NAME = "call BILL.SP_PAO_GET_HEADER_DETAILS_COMMON(?,?,?,?,?,?)";

	/** The Constant Indent Type. */
	public static final String CI_INDENT_TYPE = "RGL";

	/** The Constant APPROVED_STATUS_ID. */
	public static final int VALID_OTP_FOR_USER = 1;

	/** The Constant APPROVED_STATUS_ID. */
	public static final int INVALID_OTP_FOR_USER = 0;

	/** The Constant ERA_SCHEMA. */
	public static final String ERA_SCHEMA = "ERA";

	/** The Constant SAME_PSCALE_PROMOTION_NAME. */
	public static final String SAME_PSCALE_PROMOTION_NAME = "Promotion in Same Pay Scale";

	/** The Constant PROCESSED. */
	public static final String PROCESSED = "Processed";

	/** The Constant LOOKUP_NAME_TALUKA. */
	public static final String LOOKUP_NAME_INCREMENT_STATUS = "Increment_Status_Id";

	/** The Constant RECEIPT_SCHEMA. */
	public static final String RECEIPT_SCHEMA = "RECEIPT";

	/** The Constant STAMP_SCHEMA . */
	public static final String STAMP_SCHEMA = "STAMP";

	/** The Constant TPP_SCHEMA. */
	public static final String TPP_SCHEMA = "TPP";

	/** The Constant CHEQUE_INVENTORY_SCHEMA. */
	public static final String CHEQUE_INVENTORY_SCHEMA = "CHQINV";

	/** The Constant IN_INDENT_ISSUE_SERIES_ID. */
	public static final String IN_INDENT_ISSUE_SERIES_ID = "IN_INDENT_ISSUE_SERIES_ID";

	/** The Constant IN_IS_ISSUE_REVERT. */
	public static final String IN_IS_ISSUE_REVERT = "IN_IS_ISSUE_REVERT";

	/** The Constant IN_IS_ISSUE_CANCEL. */
	public static final String IN_IS_ISSUE_CANCEL = "IN_IS_ISSUE_CANCEL";

	/** The Constant IN_INDENT_SD_ID. */
	public static final String IN_TO_DATE = "IN_TO_DATE";

	/** The Constant IN_INDENT_SD_ID. */
	public static final String IN_INDENT_SD_ID = "IN_INDENT_SD_ID";

	/** The Constant IN_INDENT_ID. */
	public static final String IN_INDENT_ID = "IN_INDENT_ID";

	/** The Constant IN_REG_INDENT_ID. */
	public static final String IN_REG_INDENT_ID = "IN_REG_INDENT_ID";

	/** The Constant IN_FROM_DATE. */
	public static final String IN_FROM_DATE = "IN_FROM_DATE";

	/** The Constant Indent Type. */
	public static final String CI_INDENT_TYPE_YRL = "YRL";

	/** The Constant ERA_MASTER_SCHEMA. */
	public static final String ERA_MASTER_SCHEMA = "MASTER_V1";

	/** The Constant IFSC_REGEX. */
	public static final String IFSC_REGEX = "[A-Z]{4}[0][\\d]{6}$";

	/** The Constant GRANT_SCHEMA. */
	public static final String GRPINS_SCHEMA = "GRPINS";

	/** The Constant MAJORHEAD_CODE_REGEX. */
	public static final String MAJORHEAD_CODE_REGEX = "[\\d]{4}$";

	/** The Constant PDPLA_SCHEMA. */
	public static final String PDPLA_SCHEMA = "PDPLA";

	/** The Constant DPFF_SCHEMA. */
	public static final String DPFF_SCHEMA = "DPFF";

	public static final Long PPO_OFFICE_SUB_TYPE = 400L;

	public static final int VALID_SIZE = 1;

	/** The Constant CHEQUE_NUMBER_REGEX. */
	public static final String CHEQUE_NUMBER_REGEX = "[\\d]{6}$";

	/** The Constant EDP_OFFICET_TYPE_HOD. */
	public static final Long EDP_OFFICET_TYPE_HOD = 54L;
	
	/** The Constant EDP_OFFICET_TYPE_DDO. */
	public static final Long EDP_OFFICET_TYPE_DDO = 71L;
	
	/** The Constant PVU IN_IS_SERACH. */
	public static final String IN_IS_SEARCH = "IN_IS_SEARCH";
	
	/** The Constant PVU IN_EMP_PAY_TYPE. */
	public static final String IN_EMP_PAY_TYPE = "IN_EMP_PAY_TYPE";
	
	/** The Constant PVU IN_EMP_TYPE. */
	public static final String IN_EMP_TYPE = "IN_EMP_TYPE";
	
	/** The Constant PVU IN_DESIGNATION_ID. */
	public static final String IN_DESIGNATION_ID = "IN_DESIGNATION_ID";
	
	/** The Constant PVU IN_PAN_NO. */
	public static final String IN_PAN_NO = "IN_PAN_NO";
	
	/** The Constant PVU IN_RETIREMENT_DATE. */
	public static final String IN_RETIREMENT_DATE = "IN_RETIREMENT_DATE";

	/** The Constant PVU IN_REF_FROM_DATE. */
	public static final String IN_REF_FROM_DATE = "IN_REF_FROM_DATE";
	
	/** The Constant PVU IN_PVU_ADHC_PROB_REGLR_SD_ID. */
	public static final String IN_PVU_ADHC_PROB_REGLR_SD_ID = "IN_PVU_ADHC_PROB_REGLR_SD_ID";
	
	/** The Constant PVU IN_REF_TO_DATE. */
	public static final String IN_REF_TO_DATE = "IN_REF_TO_DATE";

	public static final String IN_CREATED_BY_USER = "IN_CREATED_BY_USER";
	
	public static final String EVENT_EFFECTIVE_DATE_MUST_BE_GREATER_THAN_DATE_OF_REGULAR_CON_DATE = "Employee was not of regular pay type during this period";
	
	/** The Constant DMO_SCHEMA. */
	public static final String DMO_SCHEMA = "DMO";
	
	public static final String PDPLA_BILL_SCHEMA= "BILL";

	public static final String BILL_SCHEMA = "BILL_SCHEMA";
	
	public static final String SLACH = "/";


	public static final String IN_FROM_DT = "IN_FROM_DT";
	public static final String IN_TO_DT = "IN_TO_DT";
	public static final String LOAN_ROI = "LOAN_ROI";
	public static final String LOAN_TENURE = "LOAN_TENURE";
	public static final String LOAN_AMOUNT = "LOAN_AMOUNT";
	public static final String SANCTION_NO = "SANCTION_NO";
	public static final String GETRESULT = "GETRESULT";
	public static final String SEARCH_TYPE = "SEARCH_TYPE";
	public static final String SEARCH_TEXT = "SEARCH_TEXT";
	public static final String REPORT_TYPE = "REPORT_TYPE";
	public static final String YEAR_MONTH = "YEAR_MONTH";
	public static final String REPORT_DATE = "REPORT_DATE";
	public static final String IN_REPORT_TYPE = "IN_REPORT_TYPE";
	public static final String BANK_NAME = "BANK_NAME";
	public static final String IN_BRANCH = "IN_BRANCH";
	
	/** The Constant IN_FROM_MONTH. */
	public static final String IN_FROM_MONTH = "IN_FROM_MONTH";

	/** The Constant IN_FROM_YEAR. */
	public static final String IN_FROM_YEAR = "IN_FROM_YEAR";

	/** The Constant SCROLL_NO. */
	public static final String SCROLL_NO = "SCROLL_NO";
	
	/** The Constant AS_OF_DATE. */
	public static final String AS_OF_DATE = "AS_OF_DATE";
}