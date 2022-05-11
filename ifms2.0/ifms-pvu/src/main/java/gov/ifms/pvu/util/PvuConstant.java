/*
 * 
 */
package gov.ifms.pvu.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;

/**
 * The Class PvuConstant.
 */
public class PvuConstant {

	private static final String IN_OFFICE_ID2_VALUE = "IN_OFFICE_ID";

	private static final String OFFICE_ID_KEY = "officeId";

	private static final String EMPLOYEE_NO_KEY = "employeeNo";

	private static final String EMPLOYEE_SENIOR_NO_KEY = "employeeSeniorNo";

	private static final String EMP_NO_KEY = "empNo";

	/**
	 * Instantiates a new pvu constant.
	 */
	private PvuConstant() {
	}

	/**
	 * The search list.
	 */
	private static Map<String, String> searchList = new LinkedHashMap<>();

	/** The new item hdr seach list. */
	private static Map<String, String> expEmpSearchList = new LinkedHashMap<>(6);

	/**
	 * Gets the search list.
	 *
	 * @return the search list
	 */
	public static Map<String, String> getSearchList() {
		return searchList;
	}

	public static Map<String, String> getExpEmpSearchList() {
		return expEmpSearchList;
	}

	/**
	 * The common emp list.
	 */
	private static Map<String, String> commonEmpList = new LinkedHashMap<>();

	/**
	 * Gets the common emp list.
	 *
	 * @return the common emp list
	 */
	public static Map<String, String> getCommonEmpList() {
		return commonEmpList;
	}

	/**
	 * The search joining employee map.
	 */
	private static Map<String, String> searchJoiningEmployeeMap = new LinkedHashMap<>();

	/**
	 * Gets the search joining employee map.
	 *
	 * @return the search joining employee map
	 */
	public static Map<String, String> getSearchJoiningEmployeeMap() {
		return searchJoiningEmployeeMap;
	}

	private static final String TYPE_SEARCH = "isSearch";

	private static final String TYPE_DESG = "IN_DESIGNATION_ID";

	static {
		searchList.put(TYPE_SEARCH, "IN_IS_SERACH");
		searchList.put(EMP_NO_KEY, "IN_EMP_NO");
		searchList.put("empName", "IN_EMP_NAME");
		searchList.put("caseNo", "IN_CASE_NO");
		searchList.put("fromDate", "IN_START_DATE");
		searchList.put("toDate", "IN_END_DATE");
		searchList.put("empType", "IN_EMP_TYPE");
		searchList.put("pPan", "IN_PPAN_NO");
		searchList.put("gpfNo", "IN_GPF_NO");
		searchList.put("cpfNo", "IN_CPF_NO");
		searchList.put("classId", "IN_CLASS_ID");
		searchList.put(OFFICE_ID_KEY, IN_OFFICE_ID2_VALUE);
		searchList.put("officeType", "OFFICE_TYPE");
		searchList.put("retirementDate", "IN_RETIREMENT_DATE");
		searchList.put("employeePayType", "IN_EMPLOYEE_PAY_TYPE");
		searchList.put("workFlowId", "IN_WORKFLOW_ID");
		searchList.put("empDesignation", TYPE_DESG);
	}

	static {
		commonEmpList.put(TYPE_SEARCH, "IN_IS_SERACH");
		commonEmpList.put("empName", "IN_EMPLOYEE_NAME");
		commonEmpList.put("empDesignation", TYPE_DESG);
		commonEmpList.put("pPan", "IN_PPAN_NO");
		commonEmpList.put("caseNo", "IN_CASE_NO");
		commonEmpList.put("pan", "IN_PAN_NO");
		commonEmpList.put("retirementDate", "IN_RETIREMENT_DATE");
		commonEmpList.put("empType", "IN_EMP_TYPE");
		commonEmpList.put(OFFICE_ID_KEY, IN_OFFICE_ID2_VALUE);
	}

	static {
		searchJoiningEmployeeMap.put(TYPE_SEARCH, "IN_IS_SEARCH");
		searchJoiningEmployeeMap.put("fromDate", "IN_FROM_DATE");
		searchJoiningEmployeeMap.put("toDate", "IN_TO_DATE");
		searchJoiningEmployeeMap.put("transactionNo", "IN_TRANSACTION_NO");
		searchJoiningEmployeeMap.put(EMPLOYEE_NO_KEY, "IN_EMPLOYEE_NO");
		searchJoiningEmployeeMap.put("employeeName", "IN_EMPLOYEE_NAME");
		searchJoiningEmployeeMap.put("designationId", TYPE_DESG);
		searchJoiningEmployeeMap.put("gpfNo", "IN_GPF_NO");
		searchJoiningEmployeeMap.put("cpfNo", "IN_CPF_NO");
		searchJoiningEmployeeMap.put("panNo", "IN_PAN_NO");
		searchJoiningEmployeeMap.put("fromDistrict", "IN_FROM_DISTRICT");
		searchJoiningEmployeeMap.put("fromCardexNo", "IN_FROM_CARDEX_NO");
		searchJoiningEmployeeMap.put("fromDdoNo", "IN_FROM_DDO_NO");
		searchJoiningEmployeeMap.put("currentOfficeId", "IN_CURRENT_OFFICE_ID");
	}

	static {
		expEmpSearchList.put("employeeNo", "IN_EMPLOYEE_NO");
		expEmpSearchList.put("empPayTypeId", "IN_EMPLOYEE_PAY_TYPE");
		expEmpSearchList.put("designationId", "IN_DESIGNATION_ID");
		expEmpSearchList.put("employeeName", "IN_EMPLOYEE_NAME");
		expEmpSearchList.put("caseNo", "IN_CASE_NO");
		expEmpSearchList.put("panNo", "IN_PAN_NO");
	}

	/**
	 * Builds the page in map with out filter.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	public static Map<String, Object> buildPageInMapPageIndexAndSize(PageDetails pageDetail) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		return map;
	}

	/**
	 * Builds the page in map common emp.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	public static Map<String, Object> buildPageInMapCommonEmp(PageDetails pageDetail) {
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		Map<String, Object> map = new LinkedHashMap<>();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams
					.forEach(search -> map.put(PvuConstant.getCommonEmpList().get(search.getKey()), search.getValue()));
		} else {
			PvuConstant.getCommonEmpList().forEach((k, v) -> map.put(PvuConstant.getCommonEmpList().get(k), 0));
		}
		return map;
	}

	/**
	 * Builds the page in map joining transfer.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	public static Map<String, Object> buildPageInMapJoiningTransfer(PageDetails pageDetail) {
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(PvuConstant.getSearchJoiningEmployeeMap().get(search.getKey()),
					search.getValue()));
		} else {
			PvuConstant.getSearchJoiningEmployeeMap()
					.forEach((k, v) -> map.put(PvuConstant.getSearchJoiningEmployeeMap().get(k), 0));
		}
		return map;
	}

	public enum TranNo {
		SUS, INC, EOL, PR, RV, DD, CS, PRFG, TK, CSPVU, SG, STP
	}

	/**
	 * The Constant PVU_EMPLOYEE_SEARCH_LOOKUP.
	 */
	public static final String PVU_EMPLOYEE_SEARCH_LOOKUP = "getEmpSearchDDL";

	/**
	 * The Constant URL_BASIC_PAY.
	 */
	public static final String URL_GET_SEVEN_PAY_BASIC_PAY = "/seven/basic/pay";

	/**
	 * The Constant URL_BASIC_PAY_PVU.
	 */
	public static final String URL_GET_SEVEN_PAY_BASIC_PAY_PVU = "/seven/basic/payPVU";

	/**
	 * The Constant URL_BASIC_PAY_PVU.
	 */
	public static final String URL_GET_SEVEN_PAY_HIGHER_BASIC_PAY_PVU = "/seven/higherbasic/payPVU";

	/**
	 * The Constant URL_BASIC_PAY.
	 */
	public static final String URL_GET_SIX_PAY_BASIC_PAY = "/six/basic/pay";

	/**
	 * The Constant NOON_TYPE.
	 */
	public static final String NOON_TYPE = "Noon_Type";

	/**
	 * The Constant URL_OFFICE_BY_ID.
	 */
	public static final String URL_OFFICE_BY_ID = "/office/type";

	/**
	 * The Constant COURSE_CATEGORY.
	 */
	public static final String COURSE_CATEGORY = "Course Category";

	/**
	 * The Constant CCC_EXAM.
	 */
	public static final String CCC_EXAM = "CCC Exam";

	/**
	 * The Constant COURSE_NAME.
	 */
	public static final String COURSE_NAME = "Course Name";

	/**
	 * The Constant SCHOOL_DEGREE.
	 */
	public static final String SCHOOL_DEGREE = "School_Degree";

	/**
	 * The Constant PVU_EMPLOYEE_DETAIL.
	 */
	public static final String PVU_EMPLOYEE_DETAIL = "PVU_EMPLOYEE_SEARCH_WF_LISTING";

	/**
	 * The Constant PVU_EMPLOYEE_EVENTS.
	 */
	public static final String PVU_EMPLOYEE_EVENTS = "PVU_EMPLOYEE_EVENTS1";

	/** The Constant EMP_JOIN_PAY_DTLS. */
	public static final String EMP_JOIN_PAY_DTLS = "EMP_JOIN_PAY_DTLS";

	/** The Constant EMP_JOIN_PAY_DTLS. */
	public static final String EMPLOYEE_JOINING_PAY_DETAIL = "EMPLOYEE_JOINING_PAY_DETAIL";

	/** The Constant EMP_5TH_PAY_EVNT. */
	public static final String EMP_5TH_PAY_EVNT = "EMP_5TH_PAY_EVNT";

	/** The Constant EMP_6TH_PAY_EVNT. */
	public static final String EMP_6TH_PAY_EVNT = "EMP_6TH_PAY_EVNT";

	/** The Constant EMP_7TH_PAY_EVNT. */
	public static final String EMP_7TH_PAY_EVNT = "EMP_7TH_PAY_EVNT";

	/** The Constant EMP_SUS_EOL_TRN_EVNT. */
	public static final String EMP_SUS_EOL_TRN_EVNT = "EMP_SUS_EOL_TRN_EVNT";

	public static final String EMP_SUS_EOL_EVENT_TAB = "EMP_SUS_EOL_EVENT_TAB";

	/** The Constant EMP_TRN_EVNT. */
	public static final String EMP_TRN_EVNT = "EMP_TRANSFER_EVENT_TAB";

	/**
	 * The Constant PVU_EMPLOYEE_CREATION_LOOKUP_SP.
	 */
	public static final String PVU_EMPLOYEE_CREATION_LOOKUP_SP = "getEmpCreationDDL";

	/**
	 * The Constant PVU_EMPLOYEE_EOL_SEARCH.
	 */
	public static final String PVU_EMPLOYEE_EOL_SEARCH = "PVU_EMPLOYEE_EOL_SEARCH_WF";

	/**
	 * The Constant PVU_EMPLOYEE_REVERSION_SEARCH.
	 */
	public static final String PVU_EMPLOYEE_REVERSION_SEARCH = "REVISION_EVENT_LIST_SEARCH";

	/**
	 * The Constant PVU_EMPLOYEE_REVERSION_SEARCH.
	 */
	public static final String PVU_EMPLOYEE_SHETTY_PAY_SEARCH = "SHETTY_PAY_EVENT_LIST_SEARCH";

	/**
	 * The Constant PVU_EMPLOYEE_STEPPING_UP_SEARCH.
	 */
	public static final String PVU_EMPLOYEE_STEPPING_UP_SEARCH = "STEPPING_UP_EVENT_LIST_SEARCH";

	/**
	 * The Constant PVU_COMMON_EMPLOYEE_DETAIL.
	 */
	public static final String PVU_COMMON_EMPLOYEE_DETAIL = "COMMON_EMPLOYEE_SEARCH";

	/**
	 * The Constant PVU_EMPLOYEE_EOL_LOOKUP_SP.
	 */
	public static final String PVU_EMPLOYEE_EOL_LOOKUP_SP = "PVU_EMPLOYEE_EOL_LOOKUP_SP";

	/**
	 * The Constant PVU_EMPLOYEE_REVERSION_LOOKUP_SP.
	 */
	public static final String PVU_EMPLOYEE_REVERSION_LOOKUP_SP = "PVU_EMPLOYEE_REVERSION_LOOKUP_SP";

	/**
	 * The Constant PVU_EMPLOYEE_FORGO_LOOKUP_SP.
	 */
	public static final String PVU_EMPLOYEE_FORGO_LOOKUP_SP = "PVU_EMPLOYEE_FORGO_LOOKUP_SP";

	/**
	 * The Constant PVU_EMPLOYEE_EOL_LOOKUP_SP.
	 */
	public static final String URL_PVU_PROMOTION = "pvu/promotion";

	/**
	 * The Constant URL_COMMON_RESPONSE_BY_ID.
	 */
	public static final String URL_COMMON_RESPONSE_BY_ID = "/common/response";

	/**
	 * The Constant PVU_EMPLOYEE_EOL_SEARCH.
	 */
	public static final String PVU_EMPLOYEE_SUSPENSION_SEARCH = "PVU_EMPLOYEE_SUSPENSION_LIST_WF";

	/**
	 * The Constant PVU_JOINING_EMPLOYEE_SP.
	 */
	public static final String PVU_JOINING_EMPLOYEE_SP = "TRANSFER_JOINING_LIST";

	/**
	 * The Constant PVU_EMPLOYEE_EOL_LOOKUP_SP.
	 */
	public static final String PVU_EMPLOYEE_SUSPENSION_LOOKUP_SP = "PVU_EMPLOYEE_SUSPENSION_LOOKUP_SP";

	/**
	 * The Constant PVU_PROMOTION_LOOKUPS_SP.
	 */
	public static final String PVU_PROMOTION_LOOKUPS_SP = "PVU_PROMOTION_LOOKUPS_SP";

	/**
	 * The Constant URL_PAY_MASTER.
	 */
	public static final String URL_PAY_MASTER = "/pay-masters";
	
	public static final String URL_PAY_MASTER_COMMISSION = "/pay-masters-commission";

	/**
	 * The Constant PVU_EMPLOYEE_FORGO_SEARCH.
	 */
	public static final String PVU_EMPLOYEE_FORGO_SEARCH = "COMMON_FIVE_EVENT_LIST_SEARCH123_AM";

	/**
	 * The Constant Id_MISSING.
	 */
	public static final String ID_MISSING = "Pay commission id is missing";

	/**
	 * The Constant PAY_BAND.
	 */
	public static final String PAY_BAND = "This should not be less than current Pay Band ";

	/**
	 * The Constant URL_PVU_COMMON_DETAIL.
	 */
	public static final String URL_PVU_COMMON_DETAIL = "/get-common-detail";

	public static final String TIKU_PAY_EMPLOYEE_CURRENT_DETAIL = "/getEmployeeCurrentDetail";
	/**
	 * The Constant URL_PVU_EMPLOYEFIXPAYDETAILS.
	 */
	public static final String URL_PVU_EMPLOYEFIXPAYDETAILS = "/pvu/fix-pay";

	/**
	 * The Constant PVU_COMMON_SP.
	 */
	public static final String PVU_COMMON_SP = "PVU_EMPLOYEE_CURR_EVNT_DTLS_DS2";

	/**
	 * The Constant URL_ALL_LOOKUP_INFO.
	 */
	public static final String URL_ALL_LOOKUP_INFO = "get-all-lookup";

	/**
	 * The Constant MASTER_URL.
	 */
	public static final String MASTER_URL = "/pvu";

	/**
	 * The Constant GET_MASTER_EVENT_BY_ID.
	 */
	public static final String GET_MASTER_EVENT_BY_ID = "get-master-event";

	/**
	 * The Constant GET_ALL_MASTER_EVENT.
	 */
	public static final String GET_ALL_MASTER_EVENT = "/events";

	/**
	 * The Constant GET_PAY_FIXATION_EVENT.
	 */
	public static final String GET_PAY_FIXATION_EVENT = "/payfixation-events";

	/**
	 * The Constant GET_PVU_EVENT.
	 */
	public static final String GET_PVU_EVENT = "/pvu-events";

	/**
	 * The Constant GET_ALL_PAY_COMMISSION.
	 */
	public static final String GET_ALL_PAY_COMMISSION = "/get-all-commissions";

	/**
	 * The Constant PVU_PAY_COMMISSION_LOOKUP_NAME.
	 */
	public static final String PVU_PAY_COMMISSION_LOOKUP_NAME = "Dept_Pay_Commission";

	/**
	 * The Constant PVU_SHETTY_PAY_LOOKUP_SP.
	 */
	public static final String PVU_SHETTY_PAY_LOOKUP_SP = "PVU_EMPLOYEE_SHETTY_PAY_LOOKUP_SP";

	/**
	 * The Constant URL_PVU_DEPARTMENTCATEGORY.
	 */
	public static final String URL_PVU_DEPARTMENTCATEGORY = "";

	/**
	 * The Constant PVU_EMPLOYEE_SELECTION_GRADE_LOOKUP_SP.
	 */
	public static final String PVU_EMPLOYEE_SELECTION_GRADE_LOOKUP_SP = "PVU_EMPLOYEE_SELECTION_GRADE_LOOKUP_SP";

	/**
	 * The Constant URL_PVU_DEEMED_DATE.
	 */
	public static final String URL_PVU_DEEMED_DATE = "pvu/deemed-date";

	/**
	 * The Constant PVU_EMPLOYEE_ROP_SEARCH.
	 */
	public static final String PVU_EMPLOYEE_ROP_SEARCH = "PVU_EMPLOYEE_ROP_SP_AM";

	/**
	 * The Constant EVENT_CODE_PROMOTION.
	 */
	public static final String EVENT_CODE_PROMOTION = "Promotion";

	/**
	 * The Constant URL_GET_ALL_DESIGNATION.
	 */
	public static final String URL_GET_ALL_DESIGNATION = "/designations";

	/**
	 * The Constant URL_GET_DESIGNATION.
	 */
	public static final String URL_GET_DESIGNATION = "/get-designations";

	/**
	 * The Constant URL_TRANSFER_BY_EMP.
	 */
	public static final String URL_TRANSFER_BY_EMP = "/find-by-transfer-emp-id";

	/**
	 * The Constant URL_JOINING_TRANSFER_LIST.
	 */
	public static final String URL_JOINING_TRANSFER_LIST = "/transfer-employee/201";

	/**
	 * The Constant PVU_EMPLOYEE_INCR_INCLUDE.
	 */
	public static final String PVU_EMPLOYEE_INCR_INCLUDE_EXCLUDE = "INR_INCLUDE_EXCLUDE_DS";

	/**
	 * The Constant PVU_EMPLOYEE_INCR_INC_EXC.
	 */
	public static final String PVU_EMPLOYEE_INCREMENT_LIST = "SP_INCREMENT_LIST";

	/**
	 * The Constant PVU_STEPPING_UP_CREATION_LOOKUPS_SP.
	 */
	public static final String PVU_STEPPING_UP_CREATION_LOOKUPS_SP = "PVU_EMPLOYEE_STEPPING_UP_LOOKUP_SP";

	/**
	 * The Constant PVU_STEPPING_UP_LIST_LOOKUPS_SP.
	 */
	public static final String PVU_STEPPING_UP_LIST_LOOKUPS_SP = "STEPPING_UP_EVENT_LIST_SEARCH";

	/**
	 * The Constant PVU_INCREMENT_LOOKUPS_SP.
	 */
	public static final String PVU_INCREMENT_CREATE_LOOKUPS_SP = "PVU_EMPLOYEE_INCREMENT_LOOKUP_SP";

	/**
	 * The Constant PVU_INCREMENT_LOOKUPS_SP.
	 */
	public static final String PVU_INCREMENT_LIST_LOOKUPS_SP = "PVU_EMP_INC_LP_LS_SP";

	/**
	 * The Constant URL_ALL_LOOKUP_INFO.
	 */
	public static final String URL_CREATION_LOOKUP_INFO = "create_lookup";

	/**
	 * The Constant URL_STATUS_LOOKUP_INFO.
	 */
	public static final String URL_STATUS_LOOKUP_INFO = "status_lookup";

	/**
	 * The Constant URL_INWARD_CASE_LOOKUP_INFO.
	 */
	public static final String URL_INWARD_CASE_LOOKUP_INFO = "inwardcase_lookup";

	/**
	 * The Constant URL_DDO_FORWARD_LOOKUP_INFO.
	 */
	public static final String URL_DDO_FORWARD_LOOKUP_INFO = "ddoforward_lookup";
	/** The Constant URL_PVU_COMMMON_SCREEN_LOOKUP. */
	public static final String URL_PVU_COMMMON_SCREEN_LOOKUP = "/getcommonscreen_lookup";

	/** The Constant URL_MIS_RPT_DEP_LOOKUP. */
	public static final String URL_MIS_RPT_DEP_LOOKUP = "/department_lookup";
	/** The Constant URL_MIS_RPT_DISTRICT_LOOKUP. */
	public static final String URL_MIS_RPT_DISTRICT_LOOKUP = "/district_lookup";

	/**
	 * Tiku Pay lookup
	 **/
	public static final String URL_TIKUPAY_LOOKUP_INFO = "tikupay_lookup";
	public static final String PVU_TIKUPAY_LOOKUP_SP = "PVU_TIKUPAY_LOOKUP_SP";

	/**
	 * The Constant URL_ALL_LOOKUP_INFO.
	 */
	public static final String URL_LIST_LOOKUP_INFO = "list_lookup";

	/**
	 * The Constant PVU_HIGHER_PAY_LOOKUPS_SP.
	 */
	public static final String PVU_EMPLOYEE_HP_SCALE_LOOKUP_SP = "PVU_EMPLOYEE_HP_SCALE_LOOKUP_SP";

	/**
	 * The Constant PVU_ACP_LOOKUPS_SP.
	 */
	public static final String PVU_EMP_ASS_CAR_PROG_LOOKUP_SP = "PVU_EMP_ASS_CAR_PROG_LOOKUP_SP";

	/**
	 * The Constant THIRD_COMMISSION_LOOKUP_NAME.
	 */
	public static final String THIRD_COMMISSION_LOOKUP_NAME = "3rd Pay Commission";

	/**
	 * The Constant FOURTH_COMMISSION_LOOKUP_NAME.
	 */
	public static final String FOURTH_COMMISSION_LOOKUP_NAME = "4th Pay Commission";

	/**
	 * The Constant FIFTH_COMMISSION_LOOKUP_NAME.
	 */
	public static final String FIFTH_COMMISSION_LOOKUP_NAME = "5th Pay Commission";

	/**
	 * The Constant SIXTH_COMMISSION_LOOKUP_NAME.
	 */
	public static final String SIXTH_COMMISSION_LOOKUP_NAME = "6th Pay Commission";

	/**
	 * The Constant SEVENTH_COMMISSION_LOOKUP_NAME.
	 */
	public static final String SEVENTH_COMMISSION_LOOKUP_NAME = "7th Pay Commission";

	/**
	 * The Constant INSERT_IN_EMPS_ITRS.
	 */
	public static final String INSERT_IN_EMPS_ITRS = "INSERT_IN_EMPS_ITRS";

	/**
	 * The Constant URL_GET_ALL_SUBOFFICE.
	 */
	public static final String URL_GET_ALL_SUBOFFICE = "/suboffice";

	/**
	 * The Constant PVU_EMP_FIX_PAY_VAL_LP_LS_SP.
	 */
	public static final String PVU_EMP_FIX_PAY_VAL_LP_LS_SP = "PVU_EMP_FIX_PAY_VAL_LP_LS_SP";

	/**
	 * The Constant FIVE_COMMISSION.
	 */
	public static final int FIVE_COMMISSION = 5;

	/**
	 * The Constant FOURTH_COMMISSION.
	 */
	public static final int FOURTH_COMMISSION = 4;

	/**
	 * The Constant URL_GET_ALL_DEPT_CAT.
	 */
	public static final String URL_GET_ALL_DEPT_CAT = "/dept";

	/**
	 * The Constant URL_TRANSFER_LIST.
	 */
	public static final String URL_TRANSFER_LIST = "/201";

	/**
	 * The Constant PVU_TRANSFER_JOINING_EMPLOYEES.
	 */
	public static final String PVU_TRANSFER_JOINING_EMPLOYEES = "PVU_EMPLOYEE_TRN_JOIN_SEARCH";

	/**
	 * The Constant PVU_TRANSFER_EMPLOYEES.
	 */
	public static final String PVU_TRANSFER_EMPLOYEES = "PVU_EMPLOYEE_TRN_SEARCH";

	/**
	 * The Constant URL_EMP_TRANSFER.
	 */
	public static final String URL_EMP_TRANSFER = "/transfer-employee/101";

	/**
	 * The Constant PVU_EMPLOYEE_TRANSFER_JOIN_LOOKUP_SP.
	 */
	public static final String PVU_EMPLOYEE_TRANSFER_JOIN_LOOKUP_SP = "PVU_EMPLOYEE_TRANSFER_JOIN_LOOKUP_SP";

	/**
	 * The Constant DATE_FORMAT_YYYYMMDD.
	 */
	public static final String URL_GET_BY_EMP_TRANSFER_ID = "/transfer-employee/301";

	/**
	 * The Constant DATE_FORMATE_YYYYMMDD.
	 */
	public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";

	/**
	 * The Constant GENERATE_EMPLOYEE_NUMBER.
	 */
	public static final String GENERATE_EMPLOYEE_NUMBER = "PVU_GET_UNQ_EMPLOYEE_NUMBER";

	/**
	 * The Constant EVENT_CODE_HP.
	 */
	public static final String EVENT_CODE_HP = "Higher_Pay_Scale";

	/**
	 * The Constant EVENT_CODE_ACP.
	 */
	public static final String EVENT_CODE_ACP = "Assured_Career_Progression";
	public static final String PVU_ACP_DETAIL_REQUEST = "PVUACPDetailRequest";
	public static final String EMPTY_STRING = " ";
	public static final String ACP_DATE_FORMAT = "yyyy-MM-dd";
	public static final String EVENT_ACP_NAME = "Assured Career Progression";

	/**
	 * The Constant EVENT_CODE_SELECTION_GRAD.
	 */
	public static final String EVENT_CODE_SELECTION_GRAD = "Selection_Grade";

	/**
	 * The Constant EVENT_CODE_CAREER_ADVANCE.
	 */
	public static final String EVENT_CODE_CAREER_ADVANCE = "Career_Advancement_Scheme";

	/**
	 * The Constant PVU_EMP_ROP_LIST.
	 */
	public static final String PVU_EMP_ROP_LIST = "PVU_EMPLOYEE_ROP_SEARCH_WF";

	/**
	 * The Constant PVU_EMP_ROP_LIST.
	 */
	public static final String PVU_EMP_ROP_PVU_OFFICE_LIST = "PVU_EMPLOYEE_ROP_SEARCH_WF_PVU";

	/**
	 * The Constant PVU_EMP_ROP_LP_LS_SP.
	 */
	public static final String PVU_EMP_ROP_LP_LS_SP = "PVU_EMP_ROP_LP_LS_SP";

	/**
	 * The Constant EVENT_CODE_FORGO.
	 */
	public static final String EVENT_CODE_FORGO = "Promotion_Forgo";

	/**
	 * The Constant EVENT_CODE_TIKU.
	 */
	public static final String EVENT_CODE_TIKU = "Tiku_Pay";

	/**
	 * The Constant EVENT_CODE_REVERSION.
	 */
	public static final String EVENT_CODE_REVERSION = "Reversion";

	/**
	 * The Constant EVENT_CODE_SHETTY_PAY.
	 */
	public static final String EVENT_CODE_SHETTY_PAY = "Shetty_Pay";

	/**
	 * The Constant PVU_EMPLOYEE_INCR_EDIT_LIST.
	 */
	public static final String PVU_EMPLOYEE_INCR_EDIT_LIST = "PVU_EMP_INC_EDIT_LIST";

	/**
	 * The Constant URL_PVU_SENIOR_SCALE.
	 */
	public static final String URL_PVU_SENIOR_SCALE = "pvu/senior-scale";

	/**
	 * The Constant CHANGE_OF_SCALE_PVU.
	 */
	public static final String EVENT_CODE_CHANGE_OF_SCALE = "Change_of_Scale";

	/**
	 * The Constant CHANGE_OF_SCALE_PVU.
	 */
	public static final String EVENT_CODE_CHANGE_OF_SCALE_PVU = "Change_of_Scale_PVU";

	/**
	 * The Constant CONSTANT_EXEMPTED.
	 */
	public static final String CONSTANT_EXEMPTED = "Exempted";

	/**
	 * The Constant CONSTANT_PASS.
	 */
	public static final String CONSTANT_PASS = "Pass";

	/**
	 * The Constant EVENT_CODE_STEPPIN_UP.
	 */
	public static final String EVENT_CODE_STEPPIN_UP = "Stepping_Up";

	/**
	 * The Constant PVU_EMPLOYEE_SEARCH_LOOKUP.
	 */
	public static final String PVU_EMP_CAS_LOOKUP_SP = "PVU_EMP_CAS_LOOKUP_SP";

	/**
	 * The Constant EVENT_CODE_DEEMED_DATE.
	 */
	public static final String EVENT_CODE_DEEMED_DATE = "Deemed_Date";

	/**
	 * The Constant PVU_COMMON_PVU_SP.
	 */
	public static final String PVU_COMMON_PVU_SP = "COMMON_FIVE_EVENT_LIST_SEARCH12";

	/**
	 * The Constant URL_COMMON_DETAILS_PVU.
	 */
	public static final String URL_COMMON_DETAILS_PVU = "/common-details-pvu";

	/**
	 * The Constant PVU_COMMON_PF_SP.
	 */
	public static final String PVU_COMMON_PF_SP = "COMMON_FIVE_EVENT_LIST_SEARCH";

	/**
	 * The Constant URL_COMMON_DETAILS_PF.
	 */
	public static final String URL_COMMON_DETAILS_PF = "/common-details-pf";

	/**
	 * The Constant GET_PR_EVNT_BY_EMP_ID.
	 */
	public static final String GET_PR_EVNT_BY_EMP_ID = "GET_PR_EVNT_BY_EMP_ID";

	/**
	 * The Constant URL_GET_ALL_PROMOTION.
	 */
	public static final String URL_GET_ALL_PROMOTION = "URL_GET_ALL_PROMOTION";

	/**
	 * The Constant PVU_EMP_CA_CURR_EVNT_DTLS.
	 */
	public static final String PVU_EMP_CA_CURR_EVNT_DTLS = "PVU_EMP_CA_CURR_EVNT_DTLS";

	/**
	 * The Constant URL_PVU_ASSURED_CAREER_PROGRESSION
	 */
	public static final String URL_PVU_ASSURED_CAREER_PROGRESSION = "pvu/assured-career-progression";

	/**
	 * The Constant INSERT_IN_INCREMENT_ITRS
	 */
	public static final String INSERT_IN_INCREMENT_ITRS = "INSERT_IN_INCREMENT_ITRS";

	/**
	 * The Constant FILE_UPLOAD
	 */
	public static final String FILE_UPLOAD = "/upload";

	/**
	 * The Constant INSERT_IN_EOL_ITRS.
	 */
	public static final String INSERT_IN_EOL_ITRS = "INSERT_IN_EOL_CRT_ITRS";

	/**
	 * The Constant URL_ITR_SUSPESION_INSERT
	 */
	public static final String URL_ITR_SUSPESION_INSERT = "/insertEmployeeSuspensionItr/201";

	/**
	 * The Constant INSERT_IN_EMP_SUSPENSION_ITRS.
	 */
	public static final String INSERT_IN_EMP_SUSPENSION_ITRS = "INSERT_IN_SUS_CRT_ITRS";

	/**
	 * The Constant INSERT_IN_COMMON_ITRS.
	 */
	public static final String INSERT_IN_COMMON_ITRS = "COMMON_INSERT_EVENT_ITRS";

	/**
	 * The Constant EVENT_NAME_CHANGE_OF_SCALE.
	 */
	public static final String EVENT_NAME_CHANGE_OF_SCALE = "ChangeOfScale";

	/**
	 * The Constant EVENT_NAME_REVERSION.
	 */
	public static final String EVENT_NAME_REVERSION = "Reversion";

	/**
	 * The Constant EVENT_NAME_DEEMED.
	 */
	public static final String EVENT_NAME_DEEMED = "DeemedDate";

	/**
	 * The Constant INSERT_IN_EMPS_ITRS.
	 */
	public static final String INSERT_COMMON_ITRS = "COMMON_INSERT_EVENT_ITRS";

	/**
	 * The Constant INSERT_IN_EMPS_ITRS.
	 */
	public static final String INSERT_ROP_ITRS = "INSERT_IN_ROP_EVNT_ITRS";

	public static final String INSERT_ROP_REMARKS_ITRS = "INSERT_IN_ROP_EVNT_REMARKS_ITR";

	/**
	 * The Constant FORGO.
	 */
	public static final String FORGO = "PromotionForgo";

	/**
	 * The Constant URL_ITR_INSERT
	 */
	public static final String URL_ITR_INSERT = "/itr-insert";

	/**
	 * The Constant TRANSACTION_NO_GENERATION.
	 */
	public static final String TRANSACTION_NO_GENERATION = "TRANSACTION_NO_GENERATION";

	/**
	 * The Constant PVU_APPROVE_INCREMENT.
	 */
	public static final String PVU_APPROVE_INCREMENT = "PVU_APPROVE_INCREMENT";

	/**
	 * The Constant PVU_APPROVE_REVERSION.
	 */
	public static final String PVU_APPROVE_REVERSION = "PVU_APPROVE_REVERSION";

	public static final String EVENT_CODE_EOL = "EOL";
	public static final String EVENT_CODE_SUSPENSION = "Suspension";

	/**
	 * The Constant GET_ALL_UPLOADED_FILES
	 */
	public static final String GET_ALL_UPLOADED_FILES = "/get-attachment";

	/**
	 * The Constant DELETE_ATTACHMENT
	 */
	public static final String DELETE_ATTACHMENT = "/delete-attachment";

	public static final String UPDATE_EMP_SUSPENDED = "IS_SUS_UPDATE_FLAG";

	/**
	 * The Constant PVU_EMPLOYEE_REVERSION_LOOKUP_SP.
	 */
	public static final String PVU_EVENT_SEARCH_LOOKUP_SP = "PVU_EVENT_SEARCH_LOOKUP_SP";

	/**
	 * The Constant PVU_EMPLOYEE_REVERSION_LOOKUP_SP.
	 */
	public static final String CHECK_EMPLOYEE_ELIGIBLE = "check-employee-eligible";

	/**
	 * The Constant CHECK_ELIGIBLE_DAYS.
	 */
	public static final long CHECK_ELIGIBLE_DAYS = 180;

	public static final String EMP_ID = "empId";

	public static final String EMP_NO = EMP_NO_KEY;

	public static final String PVU_ROP_CREATE_LOOKUP_SP = "PVU_ROP_SEARCH_LOOKUP_SP";

	public static final String PVU_ROP_POST_DETAIL_SP = "PVU_EMPLOYEE_ROP_PAY_CAL";

	public static final String INSERT_ROP_INWARD_INS = "INSERT_IN_ROP_INW_INS";

	public static final String PVU_EMP_ROP_INWARD_LK_SP = "PVU_EMP_ROP_INWARD_LK_SP";

	public static final String PVU_EMP_RP_INWARD_LIST_WF = "PVU_EMP_RP_INWARD_LIST_WF";

	public static final String INWARD_NO_GENERATION = "INWARD_NO_GENERATION";

	public static final String PVU_EMP_ROP_VIEW_DATA = "PVU_EMP_ROP_VIEW_DATA";

	/**
	 * The Constant URL_GET_DEEMED_DATE_ELIGIBLE.
	 */
	public static final String URL_GET_DEEMED_DATE_ELIGIBLE = "/eligible/deemed/date";

	/**
	 * The Constant URL_GET_PAY_COMMISION.
	 */
	public static final String URL_GET_PAY_COMMISION = "/paycommision";

	/**
	 * The Constant EFFECTIVE_DATE.
	 */
	public static final String EFFECTIVE_DATE = "effectiveDate";

	/**
	 * The Constant EFFECTIVE_DATE.
	 */
	public static final String DATE_OF_NEXT_INC = "dateOfNextInc";

	/**
	 * The Constant EMPLOYEE_ID.
	 */
	public static final String EMPLOYEE_ID = "employeeId";

	/**
	 * The Constant EMPLOYEE_NO.
	 */
	public static final String EMPLOYEE_NO = EMPLOYEE_NO_KEY;

	public static final String EMPLOYEE_SENIOR_NO = EMPLOYEE_SENIOR_NO_KEY;

	/**
	 * The Constant OLD_PAY_LEVEL_ID.
	 */
	public static final String OLD_PAY_LEVEL_ID = "oldPayLevelId";

	/**
	 * The Constant OLD_CELL_VALUE.
	 */
	public static final String OLD_CELL_VALUE = "oldCellValue";

	/**
	 * The Constant PAY_LEVEL_ID.
	 */
	public static final String PAY_LEVEL_ID = "payLevelId";

	/**
	 * The Constant BASIC_PAY.
	 */
	public static final String BASIC_PAY = "basicPay";

	/**
	 * The Constant PERSONAL_PAY.
	 */
	public static final String PERSONAL_PAY = "personalPay";

	/**
	 * The Constant CELL_ID.
	 */
	public static final String CELL_ID = "cellId";

	/**
	 * The Constant OPTIONAL_AVAIL.
	 */
	public static final String OPTIONAL_AVAIL = "optionalAvail";

	/**
	 * The Constant OLD_PAY_LEVEL_ID.
	 */
	public static final String OLD_PAY_BAND_VALUE = "oldPayBandValue";

	/**
	 * The Constant OLD_BASIC.
	 */
	public static final String OLD_BASIC = "oldBasic";

	/**
	 * The Constant SELECTED_PAY_BAND_ID.
	 */
	public static final String SELECTED_PAY_BAND_ID = "selectedPayBandId";

	/**
	 * The Constant ID.
	 */
	public static final String ID = "id";

	/**
	 * The Constant NAME.
	 */
	public static final String NAME = "name";

	/**
	 * The Constant DEPT_EXAMS.
	 */
	public static final String DEPT_EXAMS = "deptExams";

	/**
	 * The Constant CCC_EXAMS.
	 */
	public static final String CCC_EXAMS = "cccExams";

	/**
	 * The Constant LANG_EXAMS.
	 */
	public static final String LANG_EXAMS = "langExams";

	/**
	 * The Constant EMPLOYEE.
	 */
	public static final String EMPLOYEE = "employee";

	/**
	 * The Constant PAY_BAND_VALUE.
	 */
	public static final String PAY_BAND_VALUE = "payBandValue";

	/**
	 * The Constant EXAMS.
	 */
	public static final String EXAMS = "exams";

	public static final String EMPLOYEE_CREATION = "Employee Creation";

	/**
	 * The Constant PROMOTION_EVENT_ID.
	 */
	public static final Long PROMOTION_EVENT_ID = 12L;

	/**
	 * The Constant PROMOTION_EVENT_ID.
	 */
	public static final Long CHANGE_OF_SCALE_EVENT_ID = 14L;

	public static final Long CHANGE_OF_SCALE_PVU_EVENT_ID = 22L;

	/**
	 * The Constant REVERSION_EVENT_ID.
	 */
	public static final Long REVERSION_EVENT_ID = 15L;

	/**
	 * The Constant REVERSION_EVENT_ID.
	 */
	public static final Long SELECTION_GRADE_EVENT_ID = 11L;

	/**
	 * The Constant MANUAL.
	 */
	public static final byte MANUAL = 0;

	/**
	 * The Constant AUTO.
	 */
	public static final byte AUTO = 1;

	/**
	 * The Constant STR_ONE.
	 */
	public static final String STR_ONE = "1";

	/**
	 * The Constant FIFTH_COMMISSION_ID.
	 */
	public static final Long THIRD_COMMISSION_ID = 148L;

	/**
	 * The Constant FIFTH_COMMISSION_ID.
	 */
	public static final Long FOURTH_COMMISSION_ID = 149L;

	/**
	 * The Constant FIFTH_COMMISSION_ID.
	 */
	public static final Long FIFTH_COMMISSION_ID = 150L;

	/**
	 * The Constant SIXTH_COMMISSION_ID.
	 */
	public static final Long SIXTH_COMMISSION_ID = 151L;

	/**
	 * The Constant SEVENTH_COMMISSION_ID.
	 */
	public static final Long SEVENTH_COMMISSION_ID = 152L;

	/**
	 * The Constant URL_PVU_COMMON_DETAIL_WITH_REGULAR.
	 */
	public static final String URL_PVU_COMMON_DETAIL_WITH_REGULAR = "/regular/get-common-detail";

	public static final String PVU_COMMON_EMPLOYEE_SP = "PVU_EMPLOYEE_CURR_EVNT_DTLS_DS2";

	public static final String URL_PVU_COMMON_DETAILS = "/get-common-details";

	/**
	 * The Constant REGULAR_PAY_TYPE_ID.
	 */
	public static final long REGULAR_PAY_TYPE_ID = 156L;

	/**
	 * The Constant FIX_PAY_TYPE_ID.
	 */
	public static final long FIX_PAY_TYPE_ID = 157L;

	public static final String TK_HEAD_DEPT_ID = "DP52";

	/**
	 * The Constant URL_BASIC_PAY.
	 */
	public static final String URL_GET_SEVEN_PAY_BASIC_CELL = "/seven/basic/cell";

	public static final long AUDITOR_ROLE_ID = 14;

	public static final long APPROVER_CLASS_II_ROLE_ID = 15;

	public static final long PRINT_ENDORSEMENT_ROLE_ID = 17;

	/**
	 * The Constant PVU_COMMON_EMPLOYEE_DETAIL.
	 */
	public static final String ROP_EMPLOYEE_SEARCH = "ROP_EMPLOYEE_SEARCH";

	public static final String ROP_EMPLOYEE_DETAIL = "PVU_EMPLOYEE_ROP_CURR_EVNT_DTLS";

	/**
	 * The Constant PVU_EMP_RP_PRINT_ENDORSEMENT_LIST_WF.
	 */
	public static final String PVU_EMP_RP_PRINT_ENDORSEMENT_LIST_WF = "PVU_EMP_RP_PRINT_ENDORSEMENT_LIST_WF";
	public static final String PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF = "PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF";

	public static final String ROP_EVENT_ID = "ropEventId";

	public static final String PVU_AUTHORIZED_ROP = "PVU_AUTHORIZED_ROP";

	public static final String NEWLINE = "<newline>";

	public static final String ROP_6TH_PAY_TEMPLATE = "templates/printEndorsement/Pay_Endorsement_6th.txt";

	public static final String ROP_7TH_PAY_TEMPLATE = "templates/printEndorsement/Pay_Endorsement_7th.txt";

	/**
	 * The Constant PVU_APPROVE_PROMOTION.
	 */
	public static final String PVU_APPROVE_PROMOTION = "PVU_APPROVE_PROMOTION";

	public static final String PVU_APPROVE_DEEMED_DATE = "PVU_APPROVE_DEEMED_DATE";

	/**
	 * The Constant PVU_APPROVE_CHANGE_OF_SCALE.
	 */
	public static final String PVU_APPROVE_CHANGE_OF_SCALE = "PVU_APPROVE_CHANGE_OF_SCALE";

	/**
	 * The Constant EMP_SUSPENSION_VALIDATION_CHECK.
	 */
	public static final String EMP_SUSPENSION_VALIDATION_CHECK = "PVU_EMPLOYEE_SUSPENSION_CHECK";

	public static final Long SUSPENSION_EVENT_ID = 8L;

	public static final String IN_DPT_ID = "IN_DPT_ID";

	public static final String IN_PAY_COMM = "IN_PAY_COMM";

	public static final String PVU_DEPT_CAT_PAY_COMM = "PVU_DEPT_CAT_PAY_COMM";

	/**
	 * The Constant SENIOR_SCALE_PF_EVENT_ID.K
	 */
	public static final Long SENIOR_SCALE_PF_EVENT_ID = 13L;

	/**
	 * The Constant SENIOR_SCALE_PF_EVENT_ID.
	 */
	public static final Long SENIOR_SCALE_PVU_EVENT_ID = 21L;

	/**
	 * The Constant PROMOTION_FORGO_CHECK.
	 */
	public static final String PVU_APPROVE_SENIOR_SCALE = "PVU_APPROVE_SENIOR_SCALE";

	/**
	 * The Constant P_PVU_ROP_AUTO_INCR.
	 */
	public static final String P_PVU_ROP_AUTO_INCR = "P_PVU_ROP_AUTO_INCR";

	/**
	 * The Constant DATE_FORMATE_DDMMYYYY.
	 */
	public static final String DATE_FORMATE_DDMMYYYY = "dd/MM/yyyy";

	/**
	 * The Constant SAVE_AS_DRAFT_ID.
	 */
	public static final Long SAVE_AS_DRAFT_ID = 205L;

	/**
	 * The Constant PVU_ROP_PRINT_CALCULATION.
	 */
	public static final String PVU_ROP_PRINT_CALCULATION = "PVU_ROP_PRINT_CALCULATION";

	/**
	 * The Constant LANG_EXAMS_MSG.
	 */
	public static final String LANG_EXAMS_MSG = "Employee Must have Hindi and Gujarati language exams!";

	/**
	 * The Constant PROMOTION_VALIDATION.
	 */
	public static final String PROMOTION_VALIDATION = "validation";

	/**
	 * The Constant PVU_ROP_PRINT_CALCULATION_LIST.
	 */
	public static final String PVU_ROP_PRINT_CALCULATION_LIST = "PVU_ROP_PRINT_CALCULATION_LIST";

	/**
	 * The Constant PROMOTION_EVENT_ID.
	 */
	public static final Long DEEMED_DATE_EVENT_ID = 18L;

	public static final String IN_EFFECTIVE_DATE = "IN_EFFECTIVE_DATE";

	public static final String IN_ROP_TYPE = "IN_ROP_TYPE";

	public static final String ACTIVE_STATUS_VAR = "activeStatus";

	public static final String IN_PVU_RP_EVNT_ID = "IN_PVU_RP_EVNT_ID";

	public static final String PVU_SS_EVENT_CODE = "Senior_Scale";

	public static final String PVU_SS_PVU_EVENT_CODE = "Senior_Scale_PVU";

	public static final String EVENT_NAME_SENIOR_SCALE = "Senior Scale";

	/**
	 * The Constant SAVE_AS_DRAFT_ID.
	 */
	public static final Long SUBMIT = 267L;

	/**
	 * The Constant PHOTO.
	 */
	public static final String PHOTO = "PHOTO";

	/**
	 * The Constant GEN.
	 */
	public static final String GEN = "GEN";

	/**
	 * The Constant NPS.
	 */
	public static final String NPS = "NPS";

	/**
	 * The Constant DEPT_CATEGORY_NAME.
	 */
	public static final String DEPT_CATEGORY_NAME = "departmentCategoryName";

	public static final String SCALE_VALUE = "scaleValue";

	/**
	 * The Constant URL_PVU_REGULAR_COMMON_DETAIL.
	 */
	public static final String URL_PVU_REGULAR_COMMON_DETAIL = "/get-regular-common-detail";

	/**
	 * The Constant URL_GET_HIGHER_PAY_ELIGIBLE.
	 */
	public static final String URL_GET_HIGHER_PAY_ELIGIBLE = "/eligible/higher/pay";

	/**
	 * The Constant INSERT_IN_EMPS_ITRS.
	 */
	public static final String INSERT_IN_CSPVU_ITRS = "INSERT_IN_CSPVU_ITRS";

	// Tiku_Pay
	public static final String TKP_PVU_EVENT_LS_SRCH_WF = "TKP_PVU_EVENT_LS_SRCH_WF";
	public static final String PVU_EMP_TK_CURR_DTLS_SP = "PVU_EMP_TK_CURR_DTLS";
	public static final String INSERT_IN_TP_EVNT_ITRS = "INSERT_IN_TP_EVNT_ITRS";
	public static final String PVU_TIKU_PAY_EVENT_CODE = "Tiku_Pay";
	public static final String PVU_TIKU_PAY_EVENT = "Tiku Pay";
	public static final Long TIKU_PAY_EVENT_ID = 4L;
	public static final Long TIKU_PAY_ONE = 305L;
	public static final Long TIKU_PAY_TWO = 306L;
	public static final Long TIKU_PAY_THREE = 307L;
	public static final Long TIKU_PAY_ONE_YEAR = 6L;
	public static final Long TIKU_PAY_TWO_YEAR = 7L;
	public static final Long TIKU_PAY_THREE_YEAR = 6L;
	public static final Long YEAR_DAYS = 365L;
	public static final Long EXAM_PASS = 138L;
	public static final Long EXAM_EXEMPT = 139L;
	public static final Long CCC_PLUS_PRECTICAL = 143L;
	public static final Long CCC_PLUS_THEORY = 142L;
	public static final String TIKUPAY_VALID_DATE = "1991-09-04";
	public static final String TIKU_PAY_I = "I";
	public static final String TIKU_PAY_II = "II";
	public static final String TIKU_PAY_III = "III";
	public static final String TIKU_PAY_SIX = "6";
	public static final String TIKU_PAY_THIRTEEN = "13";
	public static final String TIKU_PAY_NINETEEN = "19";
	public static final String TIKU_PAY_FIRST = "1st Tiku Pay Scale";
	public static final String TIKU_PAY_SECOND = "2nd Tiku Pay Scale";
	public static final String TIKU_PAY_THIRD = "3rd Tiku Pay Scale";
	public static final String TIKU_PAYTYPE = "tikuPayType";
	public static final String TIKU_PAYYEAR = "tikuPayYear";
	public static final String TIKU_PAYSCALE = "tikuPayScale";
	public static final String SALUTATION = "salutation";
	public static final String MALE = "Male";
	public static final String FMALE_TYPE_MRS = "Mrs.";
	public static final String FMALE_TYPE_MISS = "Miss";
	public static final String FMALE_TYPE_MS = "Ms.";
	public static final String TIKUPAY_DD_MM_YYY = "dd/MM/yyyy";

	/**
	 * The Constant LISTING.
	 */
	public static final String DDO_WF_LISTING = "/ddo-wf-listing";

	/**
	 * The Constant DDO_WF_LISTING_SP.
	 */
	public static final String DDO_WF_LISTING_SP = "SS_PVU_EVENT_LS_SRCH_WF";

	/**
	 * The Constant PVU_COMMON_CSPVU_DDO_SP.
	 */
	public static final String PVU_COMMON_CSPVU_DDO_SP = "CS_PVU_EVENT_LS_SRCH_WF";

	/**
	 * The Constant URL_COMMON_DETAILS_CSPVU_DDO.
	 */
	public static final String URL_COMMON_DETAILS_CSPVU_DDO = "/common-details-cspvu-ddo";

	/**
	 * The Constant INSERT_SS_ITRS.
	 */
	public static final String INSERT_SS_ITRS = "INSERT_IN_SS_PVU_ITRS";

	public static final String INSERT_IN_TRN_ITRS = "INSERT_IN_TRN_ITRS";

	/**
	 * The Constant CCC_EXAMS_WORD.
	 */
	public static final String CCC_EXAMS_WORD = "CCC Exams";

	/**
	 * The Constant LANG_EXAMS_WORD.
	 */
	public static final String LANG_EXAMS_WORD = "Lang Exams";

	/**
	 * Added for ACP Event START
	 */
	public static final String ACP_EMPLOYEE_DETAIL = "PVU_EMPLOYEE_CURR_EVNT_DTLS_DS2";
	public static final String IN_OFFICE_ID = IN_OFFICE_ID2_VALUE;
	public static final String IN_EVENT_ID = "IN_EVENT_ID";
	public static final String ACP_PVU_EVENT_LIST_SRCH_WF = "PVU_ACP_LIST_WF";
	public static final Long ACP_PAY_PVU_EVENT_ID = 9L;
	public static final Long SENIOR_CIVIL_JUDGE = 857L;
	public static final Long CIVIL_JUDGE = 772L;
	public static final Long DISTRICT_JUDGE = 798L;
	public static final Long ACP_TYPE_ONE = 323L;
	public static final Long ACP_TYPE_TWO = 324L;
	public static final int FIVE_YEARS = 5;
	public static final int TEN_YEARS = 10;

	/**
	 * The Constant INSERT_IN_ACP_ITRS.
	 */
	public static final String INSERT_IN_ACP_EVNT_ITRS = "INSERT_IN_ACP_EVNT_ITRS";

	/**
	 * Added CHECK_EMPLOYEE_ELIGIBLE_SP
	 */
	public static final String CHECK_EMPLOYEE_ELIGIBLE_SP = "check-emp-eligible-sp";

	public static final String INSERT_IN_SG_EVNT_ITRS = "INSERT_IN_SG_EVNT_ITRS";

	/**
	 * The Constant DDO_WF_LISTING_SP.
	 */
	public static final String PVU_HIGHER_PAY_SCALE_LIST_WF = "PVU_HIGHER_PAY_SCALE_LIST_WF";

	public static final Long HIGHER_PAY_EVENT_ID = 2L;
	public static final String PVU_HIGHER_PAY_EVENT_CODE = "Higher_Pay_Scale";
	public static final String PVU_HIGHER_PAY_GRADE_I = "328";
	public static final String PVU_HIGHER_PAY_GRADE_II = "329";
	public static final String PVU_HIGHER_PAY_GRADE_III = "330";

	/**
	 * The Constant PVU_EMP_ST_CURR_EVNT_DTLS.
	 */
	public static final String PVU_EMP_ST_CURR_EVNT_DTLS = "PVU_EMP_ST_CURR_EVNT_DTLS";

	/**
	 * The Constant DDO_WF_LISTING_SP.
	 */
	public static final String SG_PVU_EVENT_LS_SRCH_WF = "SG_PVU_EVENT_LS_SRCH_WF";

	/**
	 * Added COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU
	 */
	public static final String COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU = "COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU";

	/**
	 * The Constant SHP_PVU_EVENT_LS_SRCH_WF.
	 */
	public static final String SHP_PVU_EVENT_LS_SRCH_WF = "SHP_PVU_EVENT_LS_SRCH_WF";

	public static final String EVENT_CODE_TRANSFER = "Transfer";

	public static final Long TRANSFER_EVENT_ID = 7L;

	public static final String INSERT_IN_SP_EVNT_ITRS = "INSERT_IN_SP_EVNT_ITRS";

	/**
	 * The Constant INSERT_IN_HPS_ITRS.
	 */
	public static final String INSERT_IN_HPS_EVNT_ITRS = "INSERT_IN_HPS_EVNT_ITRS";

	/**
	 * The Constant URL_GENERATE_INWARD_NUMBER.
	 */
	public static final String URL_GENERATE_INWARD_NUMBER = "receive-inward";

	/**
	 * The Constant URL_POST_INWARD_SUBMIT.
	 */
	public static final String URL_POST_INWARD_SUBMIT = "submit-inward";

	/**
	 * The Constant PVU_EMPLOYEE_CAS_CURR_EVNT_DTLS.
	 */
	public static final String PVU_EMPLOYEE_CAS_CURR_EVNT_DTLS = "PVU_EMPLOYEE_CAS_CURR_EVNT_DTLS";

	public static final String SP_HEAD_DEPT_CODE = "DP68";

	/**
	 * The Constant ST_PVU_EVENT_LS_SRCH_WF
	 */
	public static final String STEPPINGUP_PVU_EVENT_LS_SRCH_WF = "ST_PVU_EVENT_LS_SRCH_WF";

	/**
	 * The Constant ST_PVU_EVENT_LS_SRCH_WF
	 */
	public static final Long EVENT_ID_STEPPIN_UP = 10L;

	/**
	 * The Constant ST_PVU_EVENT_LS_SRCH_WF
	 */
	public static final String EVENT_STATUS_STEPPING_UP = "STEPPING_UP";

	/**
	 * The Constant INSERT_IN_ST_ITRS
	 */
	public static final String INSERT_IN_ST_ITRS = "INSERT_IN_ST_ITRS";

	/**
	 * The Constant IFSC_CODE.
	 */
	public static final String IFSC_CODE = "ifscCode";

	/**
	 * The Constant FOURTH_COMMISSION.
	 */
	public static final int THIRD_COMMISSION = 3;

	/**
	 * Added PVU_COMMON_INWARD_LIST_WF
	 */
	public static final String PVU_COMMON_INWARD_LIST_WF = "PVU_COMMON_INWARD_LIST_WF";
	/**
	 * Added PVU_COMMON_OUTWARD_LIST_WF
	 */
	public static final String PVU_COMMON_OUTWARD_LIST_WF = "PVU_COMMON_OUTWARD_LIST_WF";

	/**
	 * Added INWARD_NO_GENERATION_PVU
	 */
	public static final String INWARD_NO_GENERATION_PVU = "INWARD_NO_GENERATION_PVU";

	/**
	 * Added ST_INWARD_NO_GENERATION_PVU
	 */
	public static final String ST_INWARD_NO_GENERATION_PVU = "INWARD_NO_GENERATION_PVU";

	/**
	 * Added PVU_COMMON_INWARD_INSERT
	 */
	public static final String PVU_COMMON_INWARD_INSERT = "PVU_COMMON_INWARD_INSERT";

	public static final String PVU_APPROVE_TRANSFER = "PVU_APPROVE_TRN";

	/**
	 * Added PVU_COMMON_INWARD_INSERT
	 */
	public static final String INSERT_IN_CAS_ITRS = "INSERT_IN_CAS_ITRS";

	/**
	 * Added PVU_COMMON_INWARD_INSERT
	 */
	public static final String CAS_PVU_EVENT_LS_SRCH_WF = "CAS_PVU_EVENT_LS_SRCH_WF";

	/**
	 * Added URL_PVU_REASONS
	 */
	public static final String URL_PVU_REASONS = "reasons";

	public static final String URL_CURRENT_DETAILS = "current-details";

	public static final String URL_PVU_RESPONSE = "pvu-response";

	public static final String INSERT_PVU_EVNT_RMKS_ITR = "INSERT_PVU_EVNT_RMKS_ITR";

	public static final String INSERT_PVU_EVNT_RMKS_ITR_P = "INSERT_PVU_EVNT_RMKS_ITR";

	public static final String URL_PVU_LOOKUP_AUD_VER = "aud-ver-app/look-up";
	public static final String SHP_EVENT_ID = "shettyPayID";
	public static final String PVU_EVENT_ID = "eventID";
	public static final String URL_PVU_GET_REMARKS_RESPONSE = "remarks";

	public static final String IN_CAS_TYPE = "IN_CAS_TYPE";
	public static final String EVENT_NAME_SHETTY_PAY = "Shetty Pay";
	public static final String CURRENT_DETAILS = "currentDetails";
	public static final String POST_DETAILS = "postDetails";

	/**
	 * The Constant URL_GENERATE_INWARD_NUMBER.
	 */
	public static final String URL_GENERATE_OUTWARD_NUMBER = "receive-outward";
	/**
	 * The Constant OUTWARD_NO_GENERATION_PVU.
	 */
	public static final String OUTWARD_NO_GENERATION_PVU = "OUTWARD_NO_GENERATION_PVU";

	public static final String EVENT_CODE_PVU_CHANGE_OF_SCALE = "Change of Scale - PVU";

	public static final String EVENT_NAME_PVU_CHANGE_OF_SCALE = "Change of Scale";
	/**
	 * The Constant URL_POST_RETURN_REMARKS.
	 */
	public static final String URL_POST_RETURN_REMARKS = "return-remarks";

	/**
	 * The Constant URL_POST_UPDATE_REMARKS.
	 */
	public static final String URL_POST_UPDATE_REMARKS = "update-remarks";

	/**
	 * The Constant URL_POST_OUTWARD_SUBMIT.
	 */
	public static final String URL_POST_OUTWARD_SUBMIT = "submit-outward";
	public static final long PREM_FIFTH_COMMISSION_ID = 150L;
	public static final long PREM_SIXTH_COMMISSION_ID = 151L;

	public static final String CS_PVU_EVENT_ID = "pvuEventId";
	public static final String MAST_EXAMS = "masterExams";

	public static final String P_PVU_AUTO_INCR = "P_PVU_AUTO_INCR";

	public static final String P_PVU_AUTO_INCR123 = "P_PVU_AUTO_INCR123";

	public static final String PVU_COMMON_AUTHORIZED_SP = "PVU_COMMON_AUTHORIZED_SP";

	public static final Long SHETTY_PAY_PVU_EVENT_ID = 16L;
	public static final Long CARRER_ADVANCEMENT_EVENT_ID = 20L;

	public static final String URL_UPDATE_REMARKS = "update-remarks";

	/**
	 * The Constant INSERT_SS_REMARKS_ITRS.
	 */
	public static final String URL_GET_RETURN_REMARKS = "return-remarks";

	public static final String EVENT_ID = "eventId";
	public static final String ACP_PAY_ID = "acpPayId";

	public static final String TRN_ID = "trnId";

	public static final String MENU_ID = "menuId";

	/**
	 * The Constant URL_PVU_EVENT_EMPLOYEE_SEARCH.
	 */
	public static final String URL_PVU_EVENT_EMPLOYEE_SEARCH = "/employeesearch/901";

	/**
	 * Added URL_EVENT_GET_PVU_OFFICE
	 */
	public static final String URL_EVENT_GET_PVU_OFFICE = "/getpvuoffice/201";

	/**
	 * The Constant URL_POST_DISTRIBUTOR_SUBMIT.
	 */
	public static final String URL_POST_DISTRIBUTOR_SUBMIT = "submit-distributor";

	/**
	 * The Constant OFFICE_ID.
	 */
	public static final String OFFICE_ID = OFFICE_ID_KEY;

	/**
	 * The Constant EVENT_CODE_SELECTION_GRAD.
	 */
	public static final String EVENT_CODE_SELECTION_NAME = "Selection Grade";

	public static final String CHANGE_DNI = "changeDNI";
	public static final String EVENT_NAME_CAREER_ADVANCE = "Career Advancement Scheme";
	public static final String URL_PVU_GENERATE_PRINT_ORDER = "generate-print-order";
	public static final String URL_PVU_GENERATE_PRINT_ORDERS = "generate-print-orders";
	public static final String URL_EXAM_DETAILS = "get-employee-exams";

	/**
	 * The Constant NOT_FOUND_BASIC_PAY_FOR_PAY_LEVEL_AND_CELL.
	 */
	public static final String NOT_FOUND_BASIC_PAY_FOR_PAY_LEVEL_AND_CELL = "Not Found Basic Pay For PayLevel %s and Cell Id %s ";

	public static final String COMP_YEAR = "compYear";
	public static final String RES_NO = "resNo";
	public static final String REST_DATED = "resDtaed";
	public static final String HP_TYPE = "hpType";

	public static final String COM_DATE = "2007/07/02";
	public static final int EMP_GENDER_FEMALE_ID = 87;

	/**
	 * The Constant STATUS_ID used in PvuSearchEnum.java
	 */
	public static final String STATUS_ID = "statusId";
	/**
	 * The Constant TRANS_NO used in PvuSearchEnum.java
	 */
	public static final String TRANS_NO = "transNo";

	public static final Long CAS_TYPE_SENIOR_SCALE = 312L;
	public static final Long CAS_TYPE_SELECTION_GRADE = 313L;
	public static final Long CAS_TYPE_SELECTION_GRADE_3YRS = 314L;
	public static final String SSP_FIVE_PRINT = "/templates/view/ssp_five.vm";
	public static final String SSP_SIX_PRINT = "/templates/view/ssp_six.vm";
	public static final String SSP_SEVEN_PRINT = "/templates/view/ssp_seven.vm";

	public static final String GS_PVU_EVENT_ID = "pvuEventId";

	public static final String VALIDATION_MSG = "Please select valid employee.";

	public static final String C_VALUE = "cellValue";
	public static final String N_P_LELEV = "newPaylevelId";
	public static final String O_P_VALUE = "oldPaylevelId";

	public static final String SG_FIVE_PRINT = "templates/sgrade/selectionGrade5th.vm";
	public static final String SG_SIX_PRINT = "templates/sgrade/selectionGrade6th.vm";
	public static final String SG_SEVEN_PRINT = "templates/sgrade/selectionGrade7th.vm";

	public static final String CLASS_LOADER = "classpath.resource.loader.class";
	public static final String SG_PDF_NAME = "selection_grade.pdf";

	public static final String PRINT_ATTACHMENT = "attachment; filename=";

	public static final String GOG = "GOG";
	public static final String GOG_FINACE = "GOG Finance";
	public static final String SP_EXISTS = "Shetty Pay event already exists for employee: ";
	public static final String AUTHORIZED = "Authorized";
	public static final String RETURNED = "Return";
	public static final String PVU_EVENT_WF_STATUS = "pvu-event-wf-status";

	/**
	 * Added PVU_CASE_INQUIRY_RPT
	 */
	public static final String PVU_CASE_INQUIRY_RPT = "PVU_CASE_INQUIRY_RPT";

	/** Added PVU_CASE_INQUIRY_RPT_NAME */

	public static final String PVU_CASE_INQUIRY_RPT_NAME = "Case Inquiry Report";

	/** Added PVU_INWARD_CASE_ROP_RPT */
	public static final String PVU_INWARD_CASE_ROP_RPT = "PVU_INWARD_CASE_ROP_RPT";

	/** Added PVU_EMPLOYEE_CREATION_RPT */
	public static final String PVU_EMPLOYEE_CREATION_RPT = "PVU_EMPLOYEE_CREATION_RPT";
	/** Added PVU_DDO_FORWARD_CASES_RPT */
	public static final String PVU_DDO_FORWARD_CASES_RPT = "PVU_DDO_FORWARD_CASES_RPT";
	/** Added PVU_INWARD_CASE_EVENT_RPT */
	public static final String PVU_INWARD_CASE_EVENT_RPT = "PVU_INWARD_CASE_EVENT_RPT";
	/** Added PVU_FORWARD_CASES_DDO_WISE_RPT */
	public static final String PVU_FORWARD_CASES_DDO_WISE_RPT = "PVU_FORWARD_CASES_DDO_WISE_RPT";
	/** Added PVU_RETURN_CASE_EVENT_RPT */
	public static final String PVU_RETURN_CASE_EVENT_RPT = "PVU_RETURN_CASE_EVENT_RPT";

	/** Added PVU_DISTRICT_WISE_VERIFICATION_RPT */
	public static final String PVU_DISTRICT_WISE_VERIFICATION_RPT = "PVU_DISTRICT_WISE_VERIFICATION_RPT";

	/** Added PVU_DDO_EVENT_STATUS_RPT */
	public static final String PVU_DDO_EVENT_STATUS_RPT = "PVU_DDO_EVENT_STATUS_RPT";
	/** Added PVU_DISTRICT_WISE_PENDING_STATUS_RPT */
	public static final String PVU_DISTRICT_WISE_PENDING_STATUS_RPT = "PVU_DISTRICT_WISE_PENDING_STATUS_RPT";
	/** Added PVU_DEPARTMENT_WISE_PENDING_STATUS_RPT */
	public static final String PVU_DEPARTMENT_WISE_PENDING_STATUS_RPT = "PVU_Dept_Wise_Pending_Status_RPT";
	/** Added PVU_TRN_REMARKS_LIST_RPT */
	public static final String PVU_TRN_REMARKS_LIST_RPT = "PVU_TRN_REMARKS_LIST_RPT";

	/**
	 * The Constant PVU_EVENTS_NAME_LOOKUP_SP.
	 */
	public static final String PVU_EVENTS_NAME_LOOKUP_SP = "PVU_EVENTS_NAME_LOOKUP_SP";
	/**
	 * The Constant PVU_EMP_CREATION_LOOKUP_SP.
	 */
	public static final String PVU_EMP_CREATION_LOOKUP_SP = "PVU_EMP_CREATION_LOOKUP_SP";
	/**
	 * The Constant PVU_INWARD_CASE_ROP_RPT_LOOKUP_SP.
	 */
	public static final String PVU_INWARD_CASE_ROP_RPT_LOOKUP_SP = "PVU_INWARD_CASE_ROP_RPT_LOOKUP_SP";
	/**
	 * The Constant PVU_DDO_FORWARD_LOOKUP_SP.
	 */
	public static final String PVU_DDO_FORWARD_LOOKUP_SP = "PVU_DDO_FORWARD_LOOKUP_SP";

	/**
	 * The Constant URL_DDO_FORWARD_LOOKUP_INFO.
	 */
	public static final String URL_PVU_OUTWARD_LOOKUP_INFO = "pvuOutward_lookup";

	/**
	 * The Constant PVU_DDO_FORWARD_LOOKUP_SP.
	 */
	public static final String PVU_OUTWARD_EVENT_LOOKUP_SP = "PVU_OUTWARD_CASE_EVENT_LOOKUP_SP";

	public static final String PVU_EMP_WISE_LOOKUP_SP_RPT = "PVU_EMP_WISE_LOOKUP_SP_RPT";
	public static final String PVU_EVENT_STATUS_RPT = "PVU_EVENT_STATUS_RPT";

	public static final String PVU_OUTWARD_CASE_EVENT_RPT = "PVU_OUTWARD_CASE_EVENT_RPT";
	public static final String PVU_EVENT_MULTI_LOOKUP_SP = "PVU_EVENT_MULTI_LOOKUP_SP";
	public static final String PVU_DEPARTMENT_LOOKUP_SP_RPT = "PVU_DEPARTMENT_LOOKUP_SP_RPT";
	public static final String PVU_DISTRICT_LOOKUP_SP_RPT = "PVU_DISTRICT_LOOKUP_SP_RPT";

	public static final String PVU_MIS_GEN_DATETIME = "Generated Date and Time : ";

	public static final String PVU_MIS_GEN_BY = "Generated By : ";
	public static final String PVU_MIS_SRNO = "Sr. No.";
	public static final String PVU_MIS_INWARDDATE = "Inward Date";
	public static final String PVU_MIS_EMPNO = "Employee Number";
	public static final String PVU_MIS_EMPNAME = "Employee Name";
	public static final String PVU_MIS_CASENO = "Case No";
	public static final String PVU_MIS_BIRTHDATE = "Birth Date";
	public static final String PVU_MIS_DISTRICTNAME = "District Name";
	public static final String PVU_MIS_AUTHORIZED = "Authorised";
	public static final String PVU_MIS_RETURNED = "Returned";
	public static final String PVU_MIS_INPROGRESS = "In Progress";
	public static final String PVU_MIS_TOTAL = "Total";

	public static final String PVU_MIS_RETIREMENTDATE = "Retirement Date";
	public static final String PVU_MIS_DEATHDATE = "Death Date";
	public static final String PVU_MIS_STATUS = "Status";
	public static final String PVU_MIS_LYINGWITH = "Lying With";
	public static final String PVU_MIS_OUTWARDDATE = "Outward Date";
	public static final String PVU_MIS_AUTHDATE = "Authorised Date";
	public static final String PVU_MIS_RETDATE = "Return Date";
	public static final String PVU_MIS_GPFPPAN = "GPF/PPAN No";
	public static final String PVU_MIS_PAN = "PAN No";
	public static final String PVU_MIS_DDO_OFFICENAME = "DDO Office Name";
	public static final String PVU_MIS_ENDORSEMENT = "Endorsment";
	public static final String PVU_MIS_EVENTTYPE = "Event Type";
	public static final String PVU_MIS_OUTWARD_BY = "Outward By";
	public static final String PVU_MIS_DESIGNATION = "Designation";
	public static final String PVU_MIS_CLASS = "Class";

	public static final String PVU_MIS_JOININGDATE = "Joining Date";
	public static final String PVU_MIS_OFFICENAME = "Office Name";

	public static final String PVU_MIS_OFFICE_NAME = "Office Name";
	public static final String PVU_MIS_OFFICE_ADDRESS = "Office Address";
	public static final String PVU_MIS_REPORT_NAME = "Report Name";
	public static final String PVU_MIS_FILTER = "Filter";
	public static final String PVU_MIS_COLOUMN_HEADER = "Coloumn Header";
	public static final String PVU_MIS_EMPTY_ROW1 = "blank1_NoBorder";
	public static final String PVU_MIS_EMPTY_ROW2 = "blank2_NoBorder";
	public static final String PVU_MIS_USERNAME_DATETIME = "userName_NoBorder";
	public static final String PVU_MIS_DATETIME = "userName_NoBorder_DateTime";
	public static final String PVU_MIS_HEADER = "header";

	public static final String PVU_MIS_EMPCREATION_RPTNAME = "Employee Creation Report";
	public static final String PVU_MIS_INWARDCASE_RPTNAME = "Inward Case for ROP Report";
	public static final String PVU_MIS_DDO_RPTNAME = "DDO Forward Case Report";
	public static final String PVU_MIS_CASEINQ_RPTNAME = "Case Inquiry Report";
	public static final String PVU_MIS_INWARDCASE_EVENT_RPTNAME = "Inward Case Event Report";
	public static final String PVU_MIS_OUTWARDCASE_EVENT_RPTNAME = "Outward Case Event Report";
	public static final String PVU_MIS_RETURN_CASE_EVENT_RPTNAME = "Return Case Event Report";

	public static final String PVU_EMP_WISE_MONTHLY_PROGRESS_STATUS_RPT = "PVU_EMP_WISE_MONTHLY_PROGRESS_RPT";

	public static final String ARIAL_FONT = "Arial";

	public static final String FIELD_PAY_LEVEL_ID = "payLevelId";
	public static final String CELL_ID_MIN = "1";
	public static final String CELL_ID_MAX = "40";
	public static final String EVENT_CODE_INCREMENT = "Increment";
	public static final String PRINT_DATE_FORMAT = "dd-MMM-yyyy";
	public static final String ROLLBACK_REPRINT_CMN = "rollback-reprint";

	// Gujarat Civil
	public static final String G_CIVIL = "Gujarat Civil Services (Pay) Rules, 2002";
	// Bombay Civil Services
	public static final String B_CIVIL = "Bombay Civil Services Rules, 1959";

	public static final String G_CIVIL_SUB = "Pay Fixation under Gujarat Civil Services (pay) rules, 2002";
	public static final String B_CIVIL_SUB = "Pay Fixation under Bombay Civil Services Rules, 1959";

	public static final String G_PRA_CIVIL = "In Pursuance Of the rule 15(read with rule 39) of the Gujarat Civil Services (Pay) Rules, 2002 and other orders issued from time to time in this behalf";
	public static final String B_PRA_CIVIL = "In Pursuance Of the rule 54 of the Bombay Civil Services Rules, 1959 other orders issued from time to time in this behalf";

	// Gujarat PRAGRAF OPTION AVAILED
	public static final String G_PRA_CIVIL_OPTION = "In Pursuance Of the rule 11(1) of the Gujarat Civil Services (Pay) Rules, 2002 and other orders issued from time to time in this behalf, as per the option Availed ";
	public static final String B_PRA_CIVIL_OPTION = "In Pursuance Of the rule 41 (a) (1) of the Bombay Civil Services Rules, 1959 and other orders issued from time to time in this behalf, as per the option Availed ";

	public static final String EVENT_EFFICTED_DATE_5_PAY = "2002/11/14";
	public static final String PVU_ID_MUST_BE_NOT_NULL = "id must be not null !";

	/** Added PVU_DEP_WISE_VERIFICATION_RPT */
	public static final String PVU_DEPT_WISE_VERIFICATION_RPT = "PVU_DEPT_WISE_VERIFICATION_RPT";

	public static final String PVU_EVENTWISE_PENDING_STATUS_RPT = "PVU_EVENTWISE_PENDING_STATUS_RPT";

	public static final String PVU_DURATION_WISE_PENDING_CASES_RPT = "PVU_DURATION_WISE_PENDING_CASES_RPT";

	public static final String PVU_MIS_CONS_FILTER = "filter";
	public static final String PVU_MIS_FOOTER = "footer";
	public static final String PVU_MIS_DATE_TIME = "DATE_TIME";
	public static final String PVU_MIS_EX_XLS = ".xlsx";
	public static final String PVU_MIS_ATT_FILENAME = "attachment; filename=";
	public static final String TAG_NAME = "<Authorized by Name>";

	public static final String PVU_EMP_WISE_WORKDONE_EVENT_RPT = "PVU_EMP_WISE_WORKDONE_EVENT_RPT";

	public static final String URL_MIS_EMP_WISE_WORKDONE_LOOKUP = "/getEmpWiseWorkdoneLookup";
	public static final String PVU_EMP_WISE_WORKDONE_LOOKUP_SP = "PVU_EMP_WISE_WORKDONE_LOOKUP_SP";

	public static final String PVU_EMPLOYEE_WISE_ALLOCATION_RPT = "PVU_EMPLOYEE_WISE_ALLOCATION_RPT";
	public static final String PVU_WORKFLOW_ROLE_LOOKUP_SP = "PVU_WORKFLOW_ROLE_LOOKUP_SP";
	public static final String PVU_MASTERUSER_LOOKUP_SP = "PVU_MASTERUSER_LOOKUP_SP";

	public static final String PVU_MIS_AUTH_CASE = "Authorised Cases";
	public static final String PVU_MIS_RET_CASE = "Returned Cases";
	public static final String PVU_MIS_PENDING_CASES = "Pending Cases";
	public static final String PVU_MIS_TOTAL_CASES = "Total Cases";
	public static final String PVU_MIS_NO_OF_INWARDED_CASES = "No. Of Cases Inwarded";

	public static final String PVU_MIS_REJECTED = "Rejected";

	public static final String PVU_MIS_PARENT_DEP = "Name of Parent Administrative Department";
	public static final String PVU_MIS_NO_OF_CASES_RETURNED = "No. of Cases Returned";
	public static final String PVU_MIS_EVENT_NAME = "Event Name";
	public static final String PVU_MIS_DEPNAME = "Department Name";
	public static final String PVU_MIS_OPENING_BAL = "Opening Balance";
	public static final String PVU_MIS_RECEIVED_CASES = "Received Cases";
	public static final String PVU_MIS_CLOSING_BAL = "Closing Balance";
	public static final String PVU_MIS_DUR_7DAYS = "Duration Less Than 7(In Days)";
	public static final String PVU_MIS_DUR_BET_7 = "Duration Between 7 To 15 (In Days)";
	public static final String PVU_MIS_DUR_BET_15 = "Duration Between 15 To 30 (In Days)";
	public static final String PVU_MIS_DUR_MORE_THAN_7 = "Duration More Than 30(In Days)";
	public static final String PVU_MIS_DUR_CASE_PEN = "Case Pending";
	public static final String PVU_MIS_DUR_REG_LVL = "Register Level";
	public static final String PVU_MIS_DUR_VERI_LVL = "Verification Level";
	public static final String PVU_MIS_DUR_APPR_LVL = "Approver Level";
	public static final int PVU_MIS_MAX_VALUE = 1000000000;
	public static final String PVU_MIS_COMMA = ",";
	public static final String PVU_MIS_COLON = " : ";

	public static final String URL_POST_VALIDATEPAYCOMM = "/validate-paycomm";
	/**
	 * 
	 * The Constant EVENT_NAME_STEPPINGUP.
	 */
	public static final String EVENT_NAME_STEPPINGUP = "Stepping Up";

	public static final Long EMP_CREATION_EVENT_ID = 1L;
	public static final Long ROP_6PAY_EVENT_ID = 19L;
	public static final Long ROP_7PAY_EVENT_ID = 23L;
	public static final String URL_SHP_PVU_REGULAR_COMMON_DETAIL = "/sp/get-regular-common-detail";

	public static final String ENTRY_6_TH_PAY_COMM = "GET_ENTRYPAY_6THPAYCOMM";

	/**
	 * The Constant ROP_DDO_REJECTION_CASE.
	 */
	public static final String ROP_DDO_REJECTION_CASE = "ROP_DDO_REJECTION_CASE";

	public static final String MSG_PAY_BAND = "Pay band value(Entry pay) isn't available for selected grade pay";

	public static final String PVU_EMP_CHECK_REVISION_NO = "PVU_EMP_CHECK_REVISION_NO";
	public static final String PVU_EMP_REVISED_EVENT_TAB = "PVU_EMP_REVISED_EVENT_TAB";
	public static final String PVU_EMP_ROP_TRN_NO = "PVU/ROP";

	public static final Long LINK_MENU_ID_9_NUM_SCREEN = 46L;
	public static final Long LINK_MENU_ID_8_NUM_SCREEN = 45L;
	public static final Long LINK_MENU_ID_ROP_SCREEN = 47L;
	public static final Long LINK_MENU_ID_SUSP_SCREEN = 57L;
	public static final String PVU_EMP_REQ_PARAM_TRNNO = "trnNo";
	public static final String PVU_EMP_REQ_PARAM_EVNTCD = "eventCode";
	public static final String PVU_EMP_INC_LIST_LOOKUPS_SP = "PVU_EMPLOYEE_INCREMENT_LIST_LOOKUP_SP";
	public static final String PVU_EMP_INC_GET_LIST_LOOKUP_SP = "PVU_EMPLOYEE_INCREMENT_GET_LIST_LOOKUP_SP";
	public static final String PVU_GET_REGLR_INCRMNT_LIST = "SP_PVU_GET_REGLR_INCRMNT_LIST";
	public static final String PVU_SEARCH_FIELD_VIEW_PAGE = "IS_VIEW_PAGE";

	public static final String EVENT_CODE_NOTIONAL_INCREMENT = "Event_Increment";
	public static final String EVENT_NAME_DEEMED_DATE = "Deemed Date";
	public static final String REGULAR_INCREMENT_NAME = "Regular Increment";
	public static final String NOTIONAL_INCREMENT_NAME = "Notional Increment";
	public static final String AUTO_INCREMENT_NAME = "Auto Increment";
	// Current Pay Commision
	public static final String PVU_MIS_PAYLEVEL = "Current Pay Level";
	public static final String PVU_MIS_CELLID = "Current Cell Value";
	public static final String PVU_BASIC_PAY = "Current Basic Pay";
	public static final String PVU_MIS_PAY_BAND = "Current Pay Band";
	public static final String PVU_MIS_PAY_BAND_VALUE = "Current Pay Band Value";
	public static final String PVU_MIS_GRADE_PAY = "Current Grade Pay";
	public static final String PVU_MIS_PAY_SCALE = "Current Pay Scale";

	// Revised Pay Commision REVISED
	public static final String PVU_MIS_PAYLEVEL_REVISED = "Revised Pay Level";
	public static final String PVU_MIS_CELLID_REVISED = "Revised Cell Value";
	public static final String PVU_BASIC_PAY_REVISED = "Revised Basic Pay";
	public static final String PVU_MIS_PAY_BAND_REVISED = "Revised Pay Band";
	public static final String PVU_MIS_PAY_BAND_VALUE_REVISED = "Revised Pay Band Value";
	public static final String PVU_MIS_GRADE_PAY_REVISED = "Revised Grade Pay";
	public static final String PVU_MIS_PAY_SCALE_REVISED = "Revised Pay Scale";

	public static final String PVU_EMPLOYEE_INCRMNT_LIST = "SP_NEW_PVU_INCREMENT_WF_LISTING";
	public static final String SP_PVU_GET_INCR_SUMMARY_LIST = "SP_PVU_GET_INCR_SUMMARY_LIST";
	public static final String SP_PVU_EMP_INC_CONF_PROC_5PAY = "SP_PVU_EMP_INC_CONF_PROC_5PAY";
	public static final String SP_PVU_EMP_INC_CONF_PROC_6PAY = "SP_PVU_EMP_INC_CONF_PROC_6PAY";
	public static final String SP_PVU_EMP_INC_CONF_PROC_7PAY = "SP_PVU_EMP_INC_CONF_PROC_7PAY";
	public static final String PVU_INCREMENT_REASON_FOR_EXCLUDE = "Reason For Ineligibility";
	public static final String PVU_DIFF_AMT = "Difference Amount";
	public static final String PVU_INCREMENT_TYPE = "Increment Type";
	public static final String PVU_SUS_FROM_DATE = "Sus From Date";
	public static final String PVU_SUS_TO_DATE = "Sus To Date";
	public static final String PVU_EOL_FROM_DATE = "EOL From Date";
	public static final String PVU_EOL_TO_DATE = "EOL To Date";
	public static final String PVU_REMARKS = "Remarks";
	public static final String PVU_EFFECTIVE_DATE = "Effective Date";
	public static final String PVU_DATE_NEXT_INCR = "Date Of Next Increment";

	/**
	 * The Constant SAVE_AS_DRAFT_ID.
	 */
	public static final Long PROCESSED_STATUS_ID = 1418L;
	public static final String INSERT_IN_INCREMENT_MAINEMP = "INSERT_IN_INCREMENT_MAINEMP";
	public static final String REPROCESSED_STATUS = "Reprocess";

	/**
	 * The Constant CONSTANT_PASS.
	 */
	public static final Long CONSTANT_PASS_ID = 138L;
	public static final String TYPE_EMP = "IS_EMP_TB_UPDATED";
	public static final String TYPE_EMP_ADDR = "IS_EMP_ADDR_TB_UPDATED";
	public static final String TYPE_EMP_NOMI = "IS_EMP_NOMI_TB_UPDATED";
	public static final String TYPE_EMP_QUALI = "IS_EMP_QUALI_TB_UPDATED";
	public static final String TYPE_EMP_PRV_HIST = "IS_EMP_PRV_HIST_TB_UPDATED";
	public static final String TYPE_EMP_DPT_DTL = "IS_EMP_DPT_DTL_TB_UPDATED";
	public static final String TYPE_EMP_LANG = "IS_EMP_LANG_EXAM_TB_UPDATED";
	public static final String TYPE_EMP_CCCEXM = "IS_EMP_CCCEXM_DTL_TB_UPDATED";
	public static final String TYPE_DPTEXM_DTL = "IS_EMP_DPTEXM_DTL_TB_UPDATED";
	public static final String IN_ROLE_ID = "IN_WF_ROLE_ID";
	/**
	 * The Constant INSERT_IN_EMPS_ITRS.
	 */
	public static final String INSERT_IN_APPROVED_EMPS_ITRS = "INSERT_IN_APPROVED_EMPS_ITRS";
	public static final String SP_PVU_GET_SUCS_FAIL_INCRMNT_LIST = "SP_PVU_GET_SUCS_FAIL_INCRMNT_LIST";

	public static final String IN_TRN_ID = "IN_TRN_ID";
	public static final String IN_USER_ID = "IN_USER_ID";
	public static final String IN_POST_ID = "IN_POST_ID";
	public static final String IN_CGP_NO_TYPE = "IN_CGP_NO_TYPE";
	public static final String IN_CGP_NO = "IN_CGP_NO";
	public static final String IN_DESIGNATION_ID = "IN_DESIGNATION_ID";
	public static final String IN_CLASS_ID = "IN_CLASS_ID";
	public static final String IN_EMPLOYEE_NO = "IN_EMPLOYEE_NO";
	public static final String IN_DDO_NO = "IN_DDO_NO";
	public static final String IN_CARDEX_NO = "IN_CARDEX_NO";
	public static final String IN_OFFICE = "IN_OFFICE_ID";
	public static final String IN_DISTRICT_ID = "IN_DISTRICT_ID";
	public static final String IN_INCR_FOR = "IN_INCR_FOR";
	public static final String IN_FY = "IN_FY";
	public static final String IN_EMP_PAY_TYPE = "IN_EMP_PAY_TYPE";
	public static final String IN_EMP_TYPE = "IN_EMP_TYPE";
	public static final String IN_CGP_NO1 = "In_CGP_NO";
	public static final String IN_CGP_NO_TYPE1 = "In_CGP_NO_TYPE";
	public static final String IN_DATE_NXT_INCR = "IN_DATE_NXT_INCR";
	public static final String IN_INCR_EFFECTIVE_DATE = "IN_INCR_EFFECTIVE_DATE";
	public static final String IN_TRN_LEVEL = "IN_TRN_LEVEL";
	public static final String IN_EMP_NO = "empNo";
	public static final String EMP_NAME = "empName";
	public static final String GPF = "GPF";
	public static final String CLASS_NAME = "className";
	public static final String DESIGNATION_NAME = "designationName";
	public static final String DATE_OF_JOINING = "dateOfJoining";
	public static final String CUR_SCALE_VALUE = "curScaleValue";
	public static final String CUR_BASIC_PAY = "curBasicPay";
	public static final String REV_SCALE_VALUE = "REVScaleValue";
	public static final String REV_BASIC_PAY = "REVBasicPay";
	public static final String CUR_PAY_BAND_RANGE = "curPayBandRange";
	public static final String CUR_PAY_BAND_VALUE = "curPayBandValue";
	public static final String CUR_GRADE_PAYE_VALUE = "curGradePayValue";
	public static final String REV_PAY_BAND_RANGE = "REVPayBandRange";
	public static final String REV_PAY_BAND_VALUE = "REVPayBandValue";
	public static final String REV_GRADE_PAYE_VALUE = "REVGradePayValue";
	public static final String CUR_PAY_LEVEL_VALUE = "curPayLevelValue";
	public static final String CUR_CELL_ID_VALUE = "curCellIdValue";
	public static final String REV_PAY_LEVEL_VALUE = "REVPayLevelValue";
	public static final String REV_CELL_ID_VALUE = "REVCellIdValue";
	public static final String REVEFFDATE = "REVEFFDATE";
	public static final String REVDATENEXINC = "REVDATENEXINC";
	public static final String DIFFAMT = "DIFFAMT";
	public static final String INCREMENTTYPE = "INCREMENTTYPE";
	public static final String SUSSTARTDATE = "SUSSTARTDATE";
	public static final String SUSENDDATE = "SUSENDDATE";
	public static final String EOLSTARTDATE = "EOLSTARTDATE";
	public static final String EOLENDDATE = "EOLENDDATE";
	public static final String REMARKS = "REMARKS";
	public static final String RESULT_SET_2 = "#result-set-2";
	public static final String RESULT_SET_1 = "#result-set-1";
	public static final String RESULT_SET_3 = "#result-set-3";
	public static final String IN_VALID_SHEET = "IN Valid Sheet";
	public static final String DD_MMMM_YY = "dd-MMMM-yy";
	public static final String ERROR = "error";
	public static final Long EXEMPTED_ID_LU_INFO = 139L;
	public static final Long ISELIGIBLE = 1L;
	public static final String LU_EMP_PAY_TYPE = "Employee_PayType";
	public static final String LU_SALUTATION = "Salutation Type";
	public static final String EXP_EMP_CREATION_REMARKS = "Employee is created from PVU Express Employee Screen";
	public static final String EMP_CODE_GEN_QUERY = "SELECT NEXT value FOR PVU.PVU_EMP_NO_GEN_SEQ FROM SYSIBM.SYSDUMMY1";
	public static final int EXP_EMP_SRC_TYPE = 1;
	public static final String EMP_MATHCHED_BY_PAN = "%s already exists in office %s, %s, %s";
	public static final String EXP_EMP_PAN_NOT_VALID = "Please Enter valid 10 digit PAN Number";

	public static final String URL_PVU_FIX_PAY_EMP_COMMON_DETAIL = "/get-fixpay-emp-common-detail";

	public static final String EXP_EMP_CASE_NO_NOT_VALID = "Entered Case No. does not exist";
	public static final String EXP_EMP_PAY_TYPE_NOT_VALID = "Employee Pay Type is not Valid!";
	public static final String EXP_EMP_SUB_PAY_TYPE_MSG = "Express Employee Submitted with Pay Type Id - {0}";
	public static final Long EMP_PAY_TYPE_REGULAR = 156l;
	public static final Long EMP_PAY_TYPE_PROBATION = 161l;
	public static final Long EMP_PAY_TYPE_FIX = 157l;

	public static final String FixPAY = "fixPay";

	public static final HashMap<String, String> SPECIAL_DEP_CATE_MAP = new HashMap<String, String>();
	static {
		SPECIAL_DEP_CATE_MAP.put("5", "Govt. Teaching Staff");
	}

	public static final String PVU_FIX_REG_PROC = "SP_FIX_TO_REG_PAY_CONV_LIST";

	public static final String SP_PVU_EXPRESS_EMPLOYEE_SEARCH_LISTING = "PVU_EXPRESS_EMPLOYEE_SEARCH_LISTING";
	public static final String EXP_EMP_NOT_EXISTS = "Employee does not exists!";

	public static final String EOL = "51";
	public static final Long CONTRACT = 158l;
	public static final Long RE_APPOINTED = 159l;
	public static final String SUSPENSION = "57";
	public static final String URL_GET_PAYSCALE_FOR_FIXTOREG = "/getpayscale";
	public static final String URL_GET_PAYBAND_FOR_FIXTOREG = "/getpayband";
	public static final String URL_GET_GRADEPAY_FOR_FIXTOREG = "/getGradepay";

	public static final String FIX_TO_REG_PAY_TRN_NO = "FTR";
	public static final String URL_GET_PAYLEVEL_FOR_FIXTOREG = "/getpaylevel";
	public static final String URL_GET_CELLVALUE_FOR_FIXTOREG = "/getcellvalue";
	public static final String URL_CHK_EMP_INI_FOR_FTR = "/checkEmp/201";
	public static final String URL_GET_FIXTOREG_LIST = "/getf2rlist/201";

	public static final String EXP_EMP_CASE_NO_EXISTS = "Case Number exists in %s, %s, %s";
	public static final String EXP_EMP_PAN_NO_NOT_VALID = "Entered Pan No. does not exist";
	public static final String EMP_MATHCHED_BY_CASE = "Case Number already exists for %s";
	public static final String EXP_EMP_MOBILE_NO_INVALID = "Mobile number can not start with 0,1,2,3,4,5 ";
	
	public static final String IN_HDR_ID = "HDR_ID";
	
	public static final String IN_PAY_COMM_ID = "IN_PAY_COMM_ID";
	
	public static final String IN_EMP_ID = "IN_EMP_ID";

	public static final String IN_LK_POU_ID = "IN_LK_POU_ID";
	
	public static final String SP_FIX_TO_REG_SUBMIT = "SP_FIX_TO_REG_SUBMIT";


	public static final String 	IS_SUBMITTIED="isSubmitted";

	/** The Constant FIXPAY_TO_REGULAR_EVENT_ID.*/
	public static final Long FIXPAY_TO_REGULAR_EVENT_ID = 28L;

	/** The Constant ADHOC_TO_REGULAR_EVENT_ID.*/
	public static final Long ADHOC_TO_REGULAR_EVENT_ID = 29L;

	/** The Constant PROBATIONARY_TO_REGULAR_EVENT_ID.*/
	public static final Long PROBATIONARY_TO_REGULAR_EVENT_ID = 30L;

	public static final Long ADHOC_BONDED_LOOKUP_ID = 160L;

	
	/**
	 * The Constant PVU_EMPLOYEE_DETAIL.
	 */
	public static final String SP_OPTION_AVAIL_DETAILS_5PAY = "SP_POST_INC_OPTION_AVAIL_DETAILS_5PAY";

	public static final String P_IN_CURRENT_PAY_SCALE = "IN_CURRENT_PAY_SCALE";
	public static final String P_IN_POST_BASIC_PAY = "IN_POST_BASIC_PAY";
	public static final String P_IN_POST_PAY_SCALE = "IN_POST_PAY_SCALE";

	public static final String EMP_ID_STRING = "employeeId";

	/**
	 * The Constant PVU_EMPLOYEE_DETAIL.
	 */
	public static final String SP_OPTION_AVAIL_DETAILS_6PAY = "SP_POST_INC_OPTION_AVAIL_DETAILS_6PAY";

	public static final String P_IN_C_PAY_BAND = "IN_C_PAY_BAND";
	public static final String P_IN_C_GRADE_PAY_ID = "IN_C_GRADE_PAY_ID";
	public static final String P_IN_P_PAY_BAND = "IN_P_PAY_BAND";
	public static final String P_IN_P_GRADE_PAY_ID = "IN_P_GRADE_PAY_ID";
	public static final String P_IN_P_PAY_BAND_VALUE = "IN_P_PAY_BAND_VALUE";
	public static final String P_IN_DEPT_CAT_ID = "IN_DEPT_CAT_ID";
	public static final String P_OUT_OA_BASIC_PAY_VALUE = "OUT_OA_BASIC_PAY_VALUE";
	public static final String P_OUT_OA_PAY_BAND_VALUE = "OUT_OA_PAY_BAND_VALUE";


	public static final String EDIT_KEY="edit";
	public static final String ACTION_KEY="action";

	public static final String URL_GET_STATUS = "/getStatus/201";

	public static final String VIEW_KEY="view";


	/** The Constant FIX_PAY_COMMISSION_ID. */
	public static final Long FIX_PAY_COMMISSION_ID = 341l;

	/**
	 * The Constant SP_OPTION_AVAIL_DETAILS_7PAY.
	 */
	public static final String SP_OPTION_AVAIL_DETAILS_7PAY = "SP_POST_INC_OPTION_AVAIL_DETAILS_7PAY";

	public static final String P_IN_CUR_PAY_LEVEL_VALUE = "IN_CUR_PAY_LEVEL_VALUE";
	public static final String P_IN_CUR_CELL_ID = "IN_CUR_CELL_ID";
	public static final String P_IN_POST_PAY_LEVEL_VALUE = "IN_POST_PAY_LEVEL_VALUE";
	public static final String P_OUT_CELL_ID = "OUT_CELL_ID";
	public static final String P_OUT_BASIC_PAY = "OUT_BASIC_PAY";
	public static final String P_OUT_PAY_CELL_ID = "OUT_PAY_CELL_ID";

	public static final String PVU_DEPT_CAT_PAY_COMM_REV = "PVU_DEPT_CAT_PAY_COMM_REV";

	public static final String PVU_SP_ADHC_PROB_REGLR_EMP_SEARCH = "SP_ADHC_PROB_REGLR_EMP_SEARCH";

	public static final String PVU_SP_ADHC_PROB_REGLR_EMP_LIST = "SP_ADHC_PROB_REGLR_EMP_LIST";

	public static final Long APPROVED_ID = 327L;

	public static final String PVU_DEPT_CAT_PAY_COMM_6TH = "PVU_DEPT_CAT_PAY_COMM_REV_6TH";

	public static final String PVU_DEPT_CAT_PAY_COMM_7TH = "PVU_DEPT_CAT_PAY_COMM_REV_7TH";

	public static final String PROBATIONAL_TO_REGULAR = "Probational_to_Regular";

	public static final Long PROBATIONAL_ADHOC_TO_REGULAR_MENU_ID = 882L;

	public static final String ADHOC_TO_REGULAR = "Adhoc_to_Regular";

	public static final String FIXPAY_TO_REGULAR = "Fixpay_to_Regular";

	public static final String FIXPAY_TO_REGULAR_EVENT_NAME = "Fixpay to Regular";

	public static final Long FIXPAY_TO_REGULAR_MENU_ID = 878l;

	public static final String PROBATIONARY_TO_REGULAR = "Probationary_to_Regular";

	public static final String SAVED_AS_DRAFT =  "Saved as Draft";

}
