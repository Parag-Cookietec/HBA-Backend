package gov.ifms.pvu.dto.enumration;

import static gov.ifms.pvu.util.PvuConstant.STATUS_ID;
import static gov.ifms.pvu.util.PvuConstant.TRANS_NO;

/**
 * The Enum PVUSearchEnum.
 */
public enum PVUSearchEnum {

	/** The pvu search field is search. */
	PVU_SEARCH_FIELD_IS_SEARCH("isSearch", "IN_IS_SEARCH"),
	PVU_SEARCH_FIELD_IS_DETAIL("isSearch", "IN_IS_DETAIL"),

	PVU_SEARCH_FIELD_PVU_OFFICE("pvuOfficeId","IN_PVU_OFFICE_ID"),
	/** The pvu search field emp no. */
	PVU_SEARCH_FIELD_EMP_NO("empNo", "IN_EMPLOYEE_NO"),
	
	

	/** The pvu search field emp name. */
	PVU_SEARCH_FIELD_EMP_NAME("empName", "IN_EMPLOYEE_NAME"),

	/** The pvu search field case no. */
	PVU_SEARCH_FIELD_CASE_NO("caseNo", "IN_CASE_NO"),

	/** The pvu search field start date. */
	PVU_SEARCH_FIELD_START_DATE("startDate", "IN_START_DATE"),

	/** The pvu search field end date. */
	PVU_SEARCH_FIELD_END_DATE("endDate", "IN_END_DATE"),

	/** The pvu search field emp type. */
	PVU_SEARCH_FIELD_EMP_TYPE("empType", "IN_EMP_TYPE"),

	/** The pvu search field emp type. */
	PVU_SEARCH_FIELD_EMP_PAY_TYPE("empPayType", "IN_EMP_PAY_TYPE"),
	PVU_SEARCH_FIELD_INC_TYPE_ID("incrementTypeId", "IN_INCREMENT_TYPE_ID"),
	PVU_SEARCH_FIELD_EMP_PAY_TYPE_ID("empPayTypeId", "IN_EMPLOYEE_PAY_TYPE_ID"),
	PVU_IN_CASE_STATUS("inCaseStatus", "IN_CASE_STATUS"),
	

	/** The pvu search field ppan no. */
	PVU_SEARCH_FIELD_PPAN_NO("pPan", "IN_PPAN_NO"),
	/** The pvu search field ppan no. */
	PVU_SEARCH_FIELD_PRAN_NO("pPran", "IN_PRAN_NO"),
	PVU_SEARCH_FIELD_EMP_STATUS("inEmpStatus", "IN_EMP_STATUS"),
	/** The pvu search field gpf no. */
	PVU_SEARCH_FIELD_GPF_NO("gpfNo", "IN_GPF_NO"),

	/** The pvu search field cpf no. */
	PVU_SEARCH_FIELD_CPF_NO("cpfNo", "IN_CPF_NO"),

	/** The pvu search field class id. */
	PVU_SEARCH_FIELD_CLASS_ID("classId", "IN_CLASS_ID"),

	/** The pvu search field office type. */
	PVU_SEARCH_FIELD_OFFICE_TYPE("officeType", "OFFICE_TYPE"),

	/** The pvu search field retirement date. */
	PVU_SEARCH_FIELD_RETIREMENT_DATE("retirementDate", "IN_RETIREMENT_DATE"),

	/** The pvu search field employee pay type. */
	PVU_SEARCH_FIELD_EMPLOYEE_PAY_TYPE("employeePayType", "IN_EMPLOYEE_PAY_TYPE"),

	/** The pvu search field office. */
	PVU_SEARCH_FIELD_OFFICE("officeId", "IN_OFFICE_ID"),
	PVU_IN_OFFICE_ID("officeId", "IN_PVU_OFFICE_ID"),
	/** The pvu search field workflow. */
	PVU_SEARCH_FIELD_WORKFLOW("workflowId", "IN_WORKFLOW_ID"),

	/** The pvu search field events id. */
	PVU_SEARCH_FIELD_EVENTS_ID("eventsId", "IN_EVENTS_ID"),

	/** The pvu search field events id. */
	PVU_SEARCH_FIELD_EVENT_ID("eventId", "IN_EVENT_ID"),

	/** The pvu search field employee type. */
	PVU_SEARCH_FIELD_EMPLOYEE_TYPE("empType", "IN_EMP_TYPE"),

	/** The pvu search field trn no. */
	PVU_SEARCH_FIELD_TRN_NO(TRANS_NO, "IN_TRN_NO"),
	
	/** The pvu search field trn no. */
	PVU_SEARCH_FIELD_TRNS_NO(TRANS_NO, "in_trns_no"),

	
	
	/** The pvu search field post id. */
	PVU_SEARCH_FIELD_POST_ID("postId", "IN_POST_ID"),

	/** The pvu search field menu id. */
	PVU_SEARCH_FIELD_MENU_ID("menuId", "IN_MENU_ID"),

	/** The pvu search field designation. */
	PVU_SEARCH_FIELD_DESIGNATION("designationId", "IN_DESIGNATION_ID"),

	/** The pvu search field from date. */
	PVU_SEARCH_FIELD_FROM_DATE("fromDate", "IN_START_DATE"),

	/** The pvu search field to date. */
	PVU_SEARCH_FIELD_TO_DATE("toDate", "IN_END_DATE"),

	/** The pvu search field reason for sus. */
	PVU_SEARCH_FIELD_REASON_FOR_SUS("reasonForSus", "IN_SUSPNSN_RSN"),

	/** The pvu search field pay comm. */
	PVU_SEARCH_FIELD_PAY_COMM("payCommission", "IN_PAY_COMM"),
	PVU_SEARCH_FIELD_VIEW_PAGE("isViewPage", "IS_VIEW_PAGE"),
	/** The pvu search field status. */
	PVU_SEARCH_FIELD_STATUS(STATUS_ID, "IN_STATUS_ID"),

	/** The pvu search field status. */
	PVU_SEARCH_FIELD_EFFECTIVE_DATE("effectiveDate", "IN_EFFECTIVE_DATE"),
	PVU_SEARCH_FIELD_INCR_EFFECTIVE_DATE("incrEffectiveDate", "IN_INCR_EFFECTIVE_DATE"),

	/** The pvu search field status. */
	PVU_SEARCH_FIELD_SUBMITTED("submitted", "IS_SUBMITTED"),

	PVU_SEARCH_PAY_COMM_FOR("payCommFor", "IN_PAY_COMM_FOR"), PVU_SEARCH_PAY_INC_FOR("incrementFor", "IN_INC_FOR"),

	PVU_SEARCH_PAY_COMM_EFF("payEffectiveDate", "IN_PAY_COMM_EFF"),
	PVU_SEARCH_DATE_NXT_INCR("nextIncrDate", "IN_DATE_NXT_INCR"),

	PVU_SEARCH_FIELD_FROM("fromDate", "IN_FROM_DATE"), PVU_SEARCH_FIELD_TO("toDate", "IN_TO_DATE"),
	PVU_SEARCH_FIELD_TRAN_NO(TRANS_NO, "IN_TRANSACTION_NO"),
	PVU_SEARCH_FIELD_PAY_TYPE_ID("payTypeId", "IN_EMPLOYEE_PAY_TYPE_ID"),
	PVU_SEARCH_FIELD_WF_STATUS_ID("wfStatusId", "IN_WF_STATUS_ID"),
	PVU_SEARCH_FIELD_TRN_STATUS(STATUS_ID, "IN_TRN_STATUS_ID"),

	PVU_SEARCH_FIELD_INCREMENT_TYPE("incrType", "IN_INCR_TYPE"),
	PVU_SEARCH_FIELD_FINANCIAL_YEAR_ID("financialYearId", "IN_FY"),

	/** The pvu search field wf role id. */
	PVU_SEARCH_FIELD_WF_ROLE_ID("wfRoleIds", "IN_WF_ROLE_ID"),

	PVU_SEARCH_PAY_INCR_FOR("incrementFor", "IN_INCR_FOR"),
	PVU_SEARCH_PAY_INCR_TYPE("incrementType", "IN_INCR_TYPE"),

	/** The pvu search field wf status. */
	PVU_SEARCH_FIELD_WF_STATUS("wfStatus", "IN_WF_STATUS"),
	PVU_SEARCH_DISTRICT("districtId", "IN_DISTRICT_ID"),
	PVU_SEARCH_DEPARTMENT("departmentId", "IN_DEPARTMENT_ID"),
	PVU_SEARCH_CARDEX("cardexNo", "IN_CARDEX_NO"),
	PVU_SEARCH_DDO("ddoCode", "IN_DDO_NO"),
	PVU_SEARCH_PAN("panNo", "IN_PAN_NO"),
	PVU_SEARCH_ORDER_NO("transferOrderNo", "IN_ORDER_NO"),
	PVU_SEARCH_ORDER_DATE("transferOrderDate", "IN_ORDER_DATE"),
	PVU_SEARCH_FIELD_NPS_NO("npsNo", "IN_NPS_NO"),
	PVU_SEARCH_LOCATION("locationId", "IN_LOCATION_ID"),
	PVU_SEARCH_EMPLOYEE_TYPE("employeeTypeId", "IN_EMPLOYEE_TYPE"),
	PVU_SEARCH_FIELD_EMP_TYPE_ID("empTypeId", "IN_EMPLOYEE_TYPE_ID"),
	PVU_SEARCH_FIELD_EVENT_CODE("eventCode", "IN_EVENT_CODE"),
	PVU_SEARCH_FIELD_REF_NO(TRANS_NO, "IN_REF_NO"),
	PVU_SEARCH_FIELD_ENUM_INDEX("enumIndex", "IN_ENUM_INDEX"),
	PVU_SEARCH_FIELD_DDO_CODE("ddoCode", "IN_DDO_CODE"),
	PVU_SEARCH_FIELD_DEPEARTMENT("departmetId", "IN_DEPARTMENT_ID"),
	PVU_SEARCH_FIELD_TRN_ID("trnId", "IN_TRN_ID"),


	/** The pvu search field wf status. */
	PVU_SEARCH_FIELD_IN_EVENT_ID("inEventId", "IN_PVU_IN_EVNT_ID"),
	PVU_SEARCH_ROP_TYPE("ropType" , "IN_ROP_TYPE"),
	SEARCH_FIELD_IN_POU_ID("lkPoOffUserId", "IN_POU_ID"),
	SEARCH_FIELD_IN_TRN_STATUS("trnStatus","IN_TRN_STATUS"),
	PVU_SEARCH_FIELD_FORWARD_FROM_DATE("forwardFromDate", "IN_FORWARD_FROM_DATE"),
	PVU_SEARCH_FIELD_FORWARD_TO_DATE("forwardToDate", "IN_FORWARD_TO_DATE"),
	PVU_SEARCH_FIELD_EVENT_NAME("eventName", "IN_EVENT_NAME"),
	PVU_SEARCH_FIELD_INWARD_FROM_DATE("inwardFromDate", "IN_INWARD_FROM_DATE"),
	PVU_SEARCH_FIELD_INWARD_TO_DATE("inwardToDate", "IN_INWARD_TO_DATE"),
	PVU_SEARCH_FIELD_OUTWARD_FROM_DATE("outwardFromDate", "IN_OUTWARD_FROM_DATE"),
	PVU_SEARCH_FIELD_OUTWARD_TO_DATE("outwardToDate", "IN_OUTWARD_TO_DATE"),
	PVU_SEARCH_FIELD_OUTWARD_NO("outwardNo", "IN_OUTWARD_NO"),
	PVU_SEARCH_FIELD_APPROVER_NAME_POU_ID("approvarNamePouId", "IN_APPROVER_NAME_POU_ID"),
	PVU_SEARCH_FIELD_STATUS_ID(STATUS_ID, "IN_STATUS"),

	PVU_SEARCH_FIELD_IS_IN_REGULAR("isRegularRequired", "IS_REGULAR"),
	PVU_SEARCH_FIELD_REQUIRED_EXAM("requiredExam", "REQUIRED_EXAM"),
	PVU_SEARCH_FIELD_AUTHORIZATION_FROM_DATE("authorizationFromDate", "IN_AUTHORIZATION_FROM_DATE"),
	PVU_SEARCH_FIELD_AUTHORIZATION_TO_DATE("authorizationToDate", "IN_AUTHORIZATION_TO_DATE"),
	PVU_SEARCH_FIELD_INWARD_NO("inwardNo", "IN_INW_NO"),
	PVU_SEARCH_FIELD_PAN_NO("panNo","IN_PAN_NO"),
	PVU_SEARCH_PRINT_STATUS("printStatus","IN_PRINT_STATUS"),
	PVU_SEARCH_FIELD_IN_TIKU_PAY_TYPE("tikuPay_type", "IN_TIKU_PAY_TYPE"),
	PVU_SEARCH_FIELD_TIKUPAY_TYPE("tikuPayType", "IN_TIKU_PAY_TYPE"),
	
	PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS("officeAddress", "IN_OFFICE_ADDRESS"),
	PVU_SEARCH_FIELD_IN_OFFICE_NAME("officeName", "IN_OFFICE_NAME"),
	PVU_SEARCH_FIELD_IN_USER_NAME("userName", "IN_USER_NAME"),
	
	PVU_MIS_REPORT_NAME("reportName", "reportName"),
	PVU_MIS_REPORT_EVENTNAME("Event Name", "Event Name"),
	PVU_MIS_REPORT_SELECTEDEVENT("Selected Event", "Selected Event"),
	PVU_MIS_REPORT_EMPNO("Employee Number", "Employee Number"),
	PVU_MIS_REPORT_PANNO("PAN No.", "PAN No."),
	PVU_MIS_REPORT_CASENO("Case No.", "Case No."),
	PVU_MIS_REPORT_REFNO("Reference No.", "Reference No."),
	PVU_MIS_REPORT_FROMDATE("From Date", "From Date"),
	PVU_MIS_REPORT_TODATE("To Date", "To Date"),
	PVU_MIS_REPORT_CASESTATUS("Case Status", "Case Status"),
	PVU_MIS_REPORT_EVENTTYPE("Event Type", "Event Type"),
	PVU_MIS_REPORT_STATUS("Status", "Status"),
	PVU_MIS_REPORT_PAYCOMMISION("Pay Commission", "Pay Commission"),
	PVU_MIS_REPORT_PARENT_DEP("Parent Administrative Department", "Parent Administrative Department"),
	PVU_MIS_REPORT_DISTRICT("District", "District"),
	PVU_MIS_REPORT_CARDEXNO("Cardex No.", "Cardex No."),
	PVU_MIS_REPORT_DDONO("DDO No.", "DDO No."),
	PVU_MIS_REPORT_SELECTEDCASE("Selected Case", "Selected Case"),
	PVU_MIS_REPORT_DEPNAME("Department Name", "Department Name"),
	PVU_MIS_REPORT_SELECTEVENT("Select Event", "Select Event"),

	PVU_SEARCH_IN_MONTH("month","IN_MONTH"),
	PVU_SEARCH_IN_YEAR("year","IN_YEAR"),
	PVU_SEARCH_IN_EMPLOYEE("employee","IN_EMPLOYEE"),
	PVU_SEARCH_IN_USER_ID("userId","IN_USER_ID"),
	PVU_SEARCH_ENUM_INDEX("eunmIndex","IN_ENUM_INDEX"),
	PVU_SEARCH_ENUM_INDEX_1("eunmIndex1","IN_ENUM_INDEX_1"),
	PVU_SEARCH_ENUM_INDEX_2("eunmIndex2","IN_ENUM_INDEX_2"),
	PVU_SEARCH_ENUM_INDEX_3("eunmIndex3","IN_ENUM_INDEX_3"),
	PVU_MIS_REPORT_SELECTEDEMP("Selected Employee", "Selected Employee"),

	PVU_SEARCH_FIELD_MIS_TO_EMP("To Employee", "To Employee"),

	PVU_SEARCH_FIELD_MIS_ROLE_LEVEL("roleLevel", "IN_ROLE_LEVEL"),
	PVU_SEARCH_FIELD_MIS_LEVEL("Level", "Level"),

	PVU_SEARCH_FIELD_MIS_SELECT_LEVEL("selectLevel", "IN_SELECT_LEVEL"),
	PVU_SEARCH_FIELD_MIS_TO_EMPLOYEE("toEmployee", "IN_TO_EMPLOYEE"),
	PVU_MIS_REPORT_TOTAL_ELEMENT("totalElement", "totalElement"),
	
	PVU_SEARCH_FIELD_SEA_OFFICE_ID("seaOfficeId", "IN_SEA_OFFICE_ID"),
	
	PVU_SEARCH_FIELD_OUTWARD_F_DATE("outWardFromDate", "IN_OUTWARD_FROM_DATE"),
	PVU_SEARCH_FIELD_OUTWARD_T_DATE("outWardToDate", "IN_OUTWARD_TO_DATE"),
	PVU_SEARCH_FIELD_OUTWARD_NUMBER("outWardNo", "IN_OUTWARD_NO"),
	PVU_SEARCH_FIELD_IN_STATUS("status", "IN_STATUS"),
	PVU_SEARCH_FIELD_INW_NO("inwardNo", "IN_INWARD_NO"),
	PVU_SEARCH_FIELD_IN_APPROVER_POU_ID("approverNamePOUId", "IN_APPROVER_NAME_POU_ID"),

	PVU_SEARCH_FIELD_IN_DEPTID("deptCatId", "IN_DEPT_ID"),
	PVU_SEARCH_FIELD_PAYBANDID("payBandId", "IN_PAYBANDID"),
	PVU_SEARCH_FIELD_IN_GRADEPAYID("gradPayId", "IN_GRADEPAYID"),
	PVU_SEARCH_FIELD_IN_REG_REV_TYPE("regOrRevType", "IN_REG_REV_TYPE"),
	PVU_SEARCH_FIELD_IN_EMP_ID("empId", "IN_EMP_ID"),
	PVU_SEARCH_FIELD_In_CGP_NO("cgpNo","In_CGP_NO"),
	PVU_SEARCH_FIELD_In_CGP_NO_TYPE("cgpNoType","In_CGP_NO_TYPE"),
	PVU_SEARCH_FIELD_TRN_LEVEL("trnLevel", "IN_TRN_LEVEL"),
	PVU_SEARCH_FIELD_In_REF_DATE("referenceDate", "In_ref_date"),
	
	// fix to regular pay conversion
	PVU_SEARCH_FIELD_IN_REF_NO("trNo", "IN_REF_NO"),
	PVU_SEARCH_FIELD_IN_EMP_NO("empNo", "IN_EMP_NO"),
	PVU_SEARCH_FIELD_IN_EMP_NAME("empName", "IN_EMP_NAME"),
	PVU_SEARCH_FIELD_IN_DESG_ID("desigId", "IN_DESG_ID"),
	PVU_SEARCH_FIELD_IN_OFFICE_NAME_P("offName", "IN_OFFICE_NAME"),
	PVU_SEARCH_FIELD_IN_STATUS_ID_P("statusId", "IN_STATUS_ID"),
	PVU_SEARCH_FIELD_IN_MENU_ID("menuId", "IN_MENU_ID"),
	PVU_SEARCH_FIELD_IN_LK_POU_ID("lkpouId", "IN_LK_POU_ID"),
	PVU_SEARCH_FIELD_IN_IS_SEARCH("isSearch", "IN_IS_SEARCH"),
	PVU_SEARCH_FIELD_IN_CREATED_FROM_DATE("createdFromDate", "IN_CREATED_FROM_DATE"),
	PVU_SEARCH_FIELD_IN_CREATED_TO_DATE("createdToDate", "IN_CREATED_TO_DATE");

	/** The key. */
	private String key;

	/** The value. */
	private String value;

	/**
	 * Instantiates a new PVU search enum.
	 *
	 * @param key   the key
	 * @param value the value
	 */
	PVUSearchEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}


	@Override
	public String toString() {
		return "PVUSearchEnum{" +
				"key='" + key + '\'' +
				", value='" + value + '\'' +
				'}';
	}

}
