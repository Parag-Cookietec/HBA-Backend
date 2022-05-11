/*
 * 
 */
package gov.ifms.edp.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Class EDPConstant.
 */
public class EDPConstant {

	/** The Constant DD_MM_YYYY. */
	public static final String DD_MM_YYYY = "dd/mm/yyyy";

	/**
	 * Instantiates a new EDP constant.
	 */
	private EDPConstant() {
	}

	/** The search list. */
	private static Map<String, String> searchList = new LinkedHashMap<>(15);

	/** The search summary DDO list. */
	private static Map<String, String> searchSummaryDDOList = new LinkedHashMap<>(10);

	/** The search summary EDP list. */
	private static Map<String, String> searchSummaryEDPList = new LinkedHashMap<>(5);

	/** The search post list. */
	private static Map<String, String> searchPostList = new LinkedHashMap<>(10);

	/** The search upd dsg list. */
	private static Map<String, String> searchUpdDsgList = new LinkedHashMap<>(10);

	/** The search add dsg list. */
	private static Map<String, String> searchAddDsgList = new LinkedHashMap<>(10);

	/** The search user post mapping list. */
	private static Map<String, String> searchUserPostMappingList = new LinkedHashMap<>(10);

	/** The search user role mapping list. */
	private static Map<String, String> searchUserRoleMappingList = new LinkedHashMap<>(10);

	/** The search update office list. */
	private static Map<String, String> searchUpdateOfficeList = new LinkedHashMap<>(15);

	/** The search update designation list. */
	private static Map<String, String> searchUpdateDesignationList = new LinkedHashMap<>(17);

	/** The search branch cre EDP list. */
	private static final Map<String, String> searchBranchCreEDPList = new LinkedHashMap<>(5);

	/** The search branch map EDP list. */
	private static Map<String, String> searchBranchMapEDPList = new LinkedHashMap<>(7);

	/** The Constant ACTIVE_STATUS. */
	public static final int ACTIVE_STATUS_TRUE = 1;

	/** The Constant FIND_DESIGNATION. */
	public static final String FIND_DESIGNATION_OF_DDO = "Designation";

	/** The Constant FIND_OFFICE_TYPE. */
	public static final String FIND_OFFICE_TYPE = "Office_type";
	/** The Constant FIND_LEVEL. */
	public static final String FIND_LEVEL = "LEVEL";
	/** The Constant FIND_PVU. */
	public static final String FIND_PVU = "PVU";

	/** The Constant FIND_REQUESTTO. */
	public static final String FIND_REQUESTTO = "Request_To";

	/** The Constant DDO_NO_KEY. */
	public static final String DDO_NO_KEY = "ddoNo";

	/** The Constant CARDEX_NO_KEY. */
	public static final String CARDEX_NO_KEY = "cardexNo";

	/** The Constant STATUS_KEY. */
	public static final String STATUS_KEY = "statusId";

	/** The Constant STATUS_VALUE. */
	public static final String STATUS_VALUE = "IN_STATUS_ID";

	/** The Constant CARDEX_NO_VALUE. */
	public static final String CARDEX_NO_VALUE = "IN_CARDEX_NO";

	/** The Constant DDO_NO_VALUE. */
	public static final String DDO_NO_VALUE = "IN_DDO_NO";

	/** The Constant DESIGNATION_KEY. */
	public static final String DESIGNATION_KEY = "designationId";

	/** The Constant DESIGNATION_VALUE. */
	public static final String DESIGNATION_VALUE = "IN_DESIGNATION_ID";

	/** The Constant DESIGNATION_NM_KEY. */
	public static final String DESIGNATION_NM_KEY = "designationName";

	/** The Constant DESIGNATION_NM_VALUE. */
	public static final String DESIGNATION_NM_VALUE = "IN_DESIGNATION_NAME";

	/** The Constant DISTRICT_KEY. */
	public static final String DISTRICT_KEY = "districtId";

	/** The Constant DISTRICT_VALUE. */
	public static final String DISTRICT_VALUE = "IN_DISTRICT_ID";

	/** The Constant ARG_DDOTYPEID. */
	public static final String ARG_DDOTYPEID = "ddoType";

	/** The Constant TRN_NO_KEY. */
	public static final String TRN_NO_KEY = "trnNo";

	/** The Constant FROM_DATE_KEY. */
	public static final String FROM_DATE_KEY = "fromDate";

	/** The Constant TO_DATE_KEY. */
	public static final String TO_DATE_KEY = "toDate";

	/** The Constant TRN_NO_VALUE. */
	public static final String TRN_NO_VALUE = "IN_TRN_NO";

	/** The Constant FROM_DATE_VALUE. */
	public static final String FROM_DATE_VALUE = "IN_TRN_FROM_DATE";

	/** The Constant EMPLOYEE_NO_KEY. */
	public static final String EMPLOYEE_NO_KEY = "employeeNo";

	/** The Constant EMPLOYEE_NO_VALUE. */
	public static final String EMPLOYEE_NO_VALUE = "IN_EMPLOYEE_NO";

	/** The Constant EMPLOYEE_NAME_KEY. */
	public static final String EMPLOYEE_NAME_KEY = "employeeName";

	/** The Constant EMPLOYEE_NAME_VALUE. */
	public static final String EMPLOYEE_NAME_VALUE = "IN_EMPLOYEE_NAME";

	/** The Constant ARG_NONDDOTYPE. */
	public static final String ARG_NONDDOTYPE = "Non DDO Type";

	/** The Constant ARG_STATUSID. */
	public static final String ARG_STATUSID = "Status_id";

	/** The Constant TO_DATE_VALUE. */
	public static final String TO_DATE_VALUE = "IN_TRN_TO_DATE";

	/** The Constant IS_SEARCH_KEY. */
	public static final String IS_SEARCH_KEY = "isSearch";

	/** The Constant IS_SEARCH_VALUE. */
	public static final String IS_SEARCH_VALUE = "ISDEFAULTSEARCH";

	/** The Constant REFERENCE_NO_KEY. */
	public static final String REFERENCE_NO_KEY = "referenceNo";

	/** The Constant REFERENCE_NO_VALUE. */
	public static final String REFERENCE_NO_VALUE = "IN_REQUEST_NO";

	/** The Constant OFFICE_NAME_KEY. */
	public static final String OFFICE_NAME_KEY = "officeName";

	/** The Constant OFFICE_NAME_VALUE. */
	public static final String OFFICE_NAME_VALUE = "IN_OFFICE_NAME";

	/** The Constant DEPARTMENT_ID_KEY. */
	public static final String DEPARTMENT_ID_KEY = "departmentId";

	/** The Constant DEPARTMENT_ID_VALUE. */
	public static final String DEPARTMENT_ID_VALUE = "IN_DEPARTMENT_ID";

	/** The Constant OFFICE_TYPE_ID_KEY. */
	public static final String OFFICE_TYPE_ID_KEY = "officeTypeId";

	/** The Constant OFFICE_TYPE_ID_VALUE. */
	public static final String OFFICE_TYPE_ID_VALUE = "IN_OFFICE_TYPE_ID";

	/** The Constant HOD_ID_KEY. */
	public static final String HOD_ID_KEY = "hodId";

	/** The Constant HOD_ID_VALUE. */
	public static final String HOD_ID_VALUE = "IN_HOD_ID";

	/** The Constant IN_IS_CO_KEY. */
	public static final String IN_IS_CO_KEY = "isCntOffice";

	/** The Constant IN_IS_CO_VALUE. */
	public static final String IN_IS_CO_VALUE = "IN_IS_CO";

	/** The Constant CURRENT_WF_ID_KEY. */
	public static final String CURRENT_WF_ID_KEY = "currentWfId";

	/** The Constant CURRENT_WF_ID_VALUE. */
	public static final String CURRENT_WF_ID_VALUE = "IN_CURRENT_WFROLEID";

	/** The Constant DISTRICT_CODE_KEY. */
	public static final String DISTRICT_CODE_KEY = "districtCode";

	/** The Constant DISTRICT_CODE_VALUE. */
	public static final String DISTRICT_CODE_VALUE = "IN_DISTRICT_CODE";

	/** The Constant DDO_TYPE_ID_KEY. */
	public static final String DDO_TYPE_ID_KEY = "ddoTypeId";

	/** The Constant DDO_TYPE_ID_VALUE. */
	public static final String DDO_TYPE_ID_VALUE = "IN_DDO_TYPE_ID";

	/** The Constant IS_UPDATE_KEY. */
	public static final String IS_UPDATE_KEY = "isUpdate";

	/** The Constant IS_UPDATE_VALUE. */
	public static final String IS_UPDATE_VALUE = "IN_IS_UPDATE";

	/** The Constant VALUE_ZERO. */
	public static final int VALUE_ZERO = 0;

	/** The Constant VALUE_ONE. */
	public static final int VALUE_ONE = 1;

	/** The Constant LONG_VALUE_ONE. */
	public static final Long LONG_VALUE_ONE = 1L;

	/** The Constant VALUE_TWO. */
	public static final int VALUE_TWO = 2;

	/** The Constant VALUE_THREE. */
	public static final int VALUE_THREE = 3;

	/** The Constant VALUE_FOUR. */
	public static final int VALUE_FOUR = 4;

	/** The Constant VALUE_FIVE. */
	public static final int VALUE_FIVE = 5;

	/** The Constant VALUE_SIX. */
	public static final int VALUE_SIX = 6;

	/** The Constant LONG_DEFALUT_VALUE. */
	public static final String LONG_DEFALUT_VALUE = "0";

	/** The Constant IN_OFFICE_ID_VALUE. */
	public static final String IN_OFFICE_ID_VALUE = "IN_OFFICE_ID";

	/** The Constant IN_OFFICE_ID_KEY. */
	public static final String IN_OFFICE_ID_KEY = "officeId";

	/** The Constant OFFICE_STATUS_VALUE. */
	public static final String OFFICE_STATUS_VALUE = "IN_OFFICE_STATUS";

	/** The Constant OFFICE_STATUS_KEY. */
	private static final String OFFICE_STATUS_KEY = "officeStatus";

	/** The Constant IN_BRANCH_NAME_VALUE. */
	private static final String IN_BRANCH_NAME_VALUE = "IN_BRANCH_NAME";

	/** The Constant IN_BRANCH_NAME_KEY. */
	private static final String IN_BRANCH_NAME_KEY = "branchName";

	/** The Constant IN_BRANCH_TYPE_ID_VALUE. */
	private static final String IN_BRANCH_TYPE_ID_VALUE = "IN_BRANCH_TYPE_ID";

	/** The Constant IN_BRANCH_TYPE_ID_KEY. */
	private static final String IN_BRANCH_TYPE_ID_KEY = "branchTypeId";

	static {
		searchList.put(EDPConstant.IS_SEARCH_KEY, EDPConstant.IS_SEARCH_VALUE);
		searchList.put(EDPConstant.REFERENCE_NO_KEY, EDPConstant.REFERENCE_NO_VALUE);
		searchList.put(EDPConstant.DESIGNATION_KEY, EDPConstant.DESIGNATION_VALUE);
		searchList.put(EDPConstant.STATUS_KEY, EDPConstant.STATUS_VALUE);
		searchList.put(EDPConstant.OFFICE_NAME_KEY, EDPConstant.OFFICE_NAME_VALUE);
		searchList.put(EDPConstant.CARDEX_NO_KEY, EDPConstant.CARDEX_NO_VALUE);
		searchList.put(EDPConstant.FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchList.put(EDPConstant.TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchList.put(EDPConstant.OFFICE_TYPE_ID_KEY, EDPConstant.OFFICE_TYPE_ID_VALUE);
		searchList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchList.put(EDPConstant.DDO_NO_KEY, EDPConstant.DDO_NO_VALUE);
		searchList.put(EDPConstant.DEPARTMENT_ID_KEY, EDPConstant.DEPARTMENT_ID_VALUE);
		searchList.put(EDPConstant.HOD_ID_KEY, EDPConstant.HOD_ID_VALUE);
		searchList.put(EDPConstant.IN_IS_CO_KEY, EDPConstant.IN_IS_CO_VALUE);
		searchList.put(EDPConstant.IS_UPDATE_KEY, EDPConstant.IS_UPDATE_VALUE);
		searchList.put(EDPConstant.IN_WF_STATUS, EDPConstant.IN_WF_STATUS_VALUE);
		searchList.put(EDPConstant.DDO_TYPE_ID_KEY, EDPConstant.DDO_TYPE_ID_VALUE);

		searchUpdateOfficeList.put(EDPConstant.IS_SEARCH_KEY, EDPConstant.IS_SEARCH_VALUE);
		searchUpdateOfficeList.put(EDPConstant.REFERENCE_NO_KEY, EDPConstant.REFERENCE_NO_VALUE);
		searchUpdateOfficeList.put(EDPConstant.DESIGNATION_KEY, EDPConstant.DESIGNATION_VALUE);
		searchUpdateOfficeList.put(EDPConstant.STATUS_KEY, EDPConstant.STATUS_VALUE);
		searchUpdateOfficeList.put(EDPConstant.OFFICE_NAME_KEY, EDPConstant.OFFICE_NAME_VALUE);
		searchUpdateOfficeList.put(EDPConstant.CARDEX_NO_KEY, EDPConstant.CARDEX_NO_VALUE);
		searchUpdateOfficeList.put(EDPConstant.FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchUpdateOfficeList.put(EDPConstant.TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchUpdateOfficeList.put(EDPConstant.OFFICE_TYPE_ID_KEY, EDPConstant.OFFICE_TYPE_ID_VALUE);
		searchUpdateOfficeList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchUpdateOfficeList.put(EDPConstant.DDO_NO_KEY, EDPConstant.DDO_NO_VALUE);
		searchUpdateOfficeList.put(EDPConstant.DEPARTMENT_ID_KEY, EDPConstant.DEPARTMENT_ID_VALUE);
		searchUpdateOfficeList.put(EDPConstant.HOD_ID_KEY, EDPConstant.HOD_ID_VALUE);
		searchUpdateOfficeList.put(EDPConstant.IN_IS_CO_KEY, EDPConstant.IN_IS_CO_VALUE);
		searchUpdateOfficeList.put(EDPConstant.IS_UPDATE_KEY, EDPConstant.IS_UPDATE_VALUE);
		searchUpdateOfficeList.put(EDPConstant.IN_POU_ID, EDPConstant.IN_POU_ID_VALUE);
		searchUpdateOfficeList.put(EDPConstant.IN_WF_ROLES, EDPConstant.IN_WF_ROLES_VALUE);
		searchUpdateOfficeList.put(EDPConstant.IN_WF_STATUS, EDPConstant.IN_WF_STATUS_VALUE);
		searchUpdateOfficeList.put(EDPConstant.IN_OFFICE_ID, EDPConstant.IN_OFFICE_ID_VALUE);
		searchUpdateOfficeList.put(EDPConstant.DDO_TYPE_ID_KEY, EDPConstant.IN_DDO_TYPE_ID);

		searchSummaryDDOList.put(EDPConstant.DISTRICT_CODE_KEY, EDPConstant.DISTRICT_CODE_VALUE);
		searchSummaryDDOList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchSummaryDDOList.put(EDPConstant.OFFICE_NAME_KEY, EDPConstant.OFFICE_NAME_VALUE);
		searchSummaryDDOList.put(EDPConstant.DESIGNATION_KEY, EDPConstant.DESIGNATION_VALUE);
		searchSummaryDDOList.put(EDPConstant.DDO_NO_KEY, EDPConstant.DDO_NO_VALUE);
		searchSummaryDDOList.put(EDPConstant.CARDEX_NO_KEY, EDPConstant.CARDEX_NO_VALUE);
		searchSummaryDDOList.put(EDPConstant.STATUS_KEY, EDPConstant.STATUS_VALUE);
		searchSummaryDDOList.put(EDPConstant.OFFICE_STATUS_KEY, EDPConstant.OFFICE_STATUS_VALUE);
		searchSummaryDDOList.put(EDPConstant.DDO_TYPE_ID_KEY, EDPConstant.DDO_TYPE_ID_VALUE);
		searchSummaryDDOList.put(EDPConstant.DEPARTMENT_ID_KEY, EDPConstant.DEPARTMENT_ID_VALUE);
		searchSummaryDDOList.put(EDPConstant.HOD_ID_KEY, EDPConstant.HOD_ID_VALUE);
		searchSummaryEDPList.put(EDPConstant.DISTRICT_CODE_KEY, EDPConstant.DISTRICT_CODE_VALUE);
		searchSummaryEDPList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchSummaryDDOList.put(EDPConstant.IN_OFFICE_ID_KEY, EDPConstant.IN_OFFICE_ID_VALUE);
		searchSummaryDDOList.put(EDPConstant.OFFICE_TYPE_ID_KEY, EDPConstant.OFFICE_TYPE_ID_VALUE);
		searchSummaryDDOList.put(EDPConstant.IN_IS_CO_KEY, EDPConstant.IN_IS_CO_VALUE);

		searchPostList.put(EDPConstant.TRN_NO_KEY, EDPConstant.TRN_NO_VALUE);
		searchPostList.put(EDPConstant.FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchPostList.put(EDPConstant.TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchPostList.put(EDPConstant.DESIGNATION_KEY, EDPConstant.DESIGNATION_VALUE);
		searchPostList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchPostList.put(EDPConstant.DDO_NO_KEY, EDPConstant.DDO_NO_VALUE);
		searchPostList.put(EDPConstant.CARDEX_NO_KEY, EDPConstant.CARDEX_NO_VALUE);
		searchPostList.put(EDPConstant.STATUS_KEY, EDPConstant.STATUS_VALUE);
		searchPostList.put(EDPConstant.IN_POU_ID_KEY, EDPConstant.IN_POU_ID_VALUE);
		searchPostList.put(EDPConstant.IN_OFFICE_ID_KEY, EDPConstant.IN_OFFICE_ID_VALUE);
		searchPostList.put(EDPConstant.CURRENT_WF_ID_KEY, EDPConstant.IN_WF_ROLE_VALUE);
		searchPostList.put(EDPConstant.WF_STATUS_KEY, EDPConstant.WF_STATUS_VALUE);
		searchPostList.put(EDPConstant.IS_SEARCH_KEY, EDPConstant.IN_ISDEFAULTSEARCH_VAL);

		searchUpdDsgList.put(EDPConstant.TRN_NO_KEY, EDPConstant.TRN_NO_VALUE);
		searchUpdDsgList.put(EDPConstant.FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchUpdDsgList.put(EDPConstant.TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchUpdDsgList.put(EDPConstant.DESIGNATION_KEY, EDPConstant.DESIGNATION_VALUE);
		searchUpdDsgList.put(EDPConstant.EMPLOYEE_NAME_KEY, EDPConstant.EMPLOYEE_NAME_VALUE);
		searchUpdDsgList.put(EDPConstant.EMPLOYEE_NO_KEY, EDPConstant.EMPLOYEE_NO_VALUE);
		searchUpdDsgList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchUpdDsgList.put(EDPConstant.DDO_NO_KEY, EDPConstant.DDO_NO_VALUE);
		searchUpdDsgList.put(EDPConstant.CARDEX_NO_KEY, EDPConstant.CARDEX_NO_VALUE);
		searchUpdDsgList.put(EDPConstant.STATUS_KEY, EDPConstant.STATUS_VALUE);

		searchAddDsgList.put(EDPConstant.IS_SEARCH_KEY, EDPConstant.IN_ISDEFAULTSEARCH_VAL);
		searchAddDsgList.put(EDPConstant.TRN_NO_KEY, EDPConstant.TRN_NO_VALUE);
		searchAddDsgList.put(EDPConstant.FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchAddDsgList.put(EDPConstant.TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchAddDsgList.put(EDPConstant.DESIGNATION_NM_KEY, EDPConstant.DESIGNATION_NM_VALUE);
		searchAddDsgList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchAddDsgList.put(EDPConstant.DDO_NO_KEY, EDPConstant.DDO_NO_VALUE);
		searchAddDsgList.put(EDPConstant.CARDEX_NO_KEY, EDPConstant.CARDEX_NO_VALUE);
		searchAddDsgList.put(EDPConstant.STATUS_KEY, EDPConstant.STATUS_VALUE);
		searchAddDsgList.put(EDPConstant.IN_POU_ID, EDPConstant.IN_POU_ID_VALUE);
		searchAddDsgList.put(EDPConstant.IN_WF_ROLES, EDPConstant.IN_WF_ROLES_VALUE);
		searchAddDsgList.put(EDPConstant.IN_WF_STATUS, EDPConstant.IN_WF_STATUS_VALUE);
		searchAddDsgList.put(EDPConstant.IN_OFFICE_ID, EDPConstant.IN_OFFICE_ID_VALUE);
		searchUserPostMappingList.put(EDPConstant.TRN_NO_KEY, EDPConstant.TRN_NO_VALUE);
		searchUserPostMappingList.put(EDPConstant.FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchUserPostMappingList.put(EDPConstant.TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchUserPostMappingList.put(EDPConstant.EMPLOYEE_NAME_KEY, EDPConstant.EMPLOYEE_NAME_VALUE);
		searchUserPostMappingList.put(EDPConstant.EMPLOYEE_NO_KEY, EDPConstant.EMPLOYEE_NO_VALUE);
		searchUserPostMappingList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchUserPostMappingList.put(EDPConstant.DDO_NO_KEY, EDPConstant.DDO_NO_VALUE);
		searchUserPostMappingList.put(EDPConstant.CARDEX_NO_KEY, EDPConstant.CARDEX_NO_VALUE);
		searchUserPostMappingList.put(EDPConstant.IN_STATUS_KEY, EDPConstant.STATUS_VALUE);
		searchUserPostMappingList.put(EDPConstant.WF_STATUS_KEY, EDPConstant.WF_STATUS_VALUE);
		searchUserPostMappingList.put(EDPConstant.IN_ISDEFAULTSEARCH_KEY, EDPConstant.IN_ISDEFAULTSEARCH_VALUE);

		searchUserRoleMappingList.put(EDPConstant.TRN_NO_KEY, EDPConstant.TRN_NO_VALUE);
		searchUserRoleMappingList.put(EDPConstant.TRN_FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchUserRoleMappingList.put(EDPConstant.TRN_TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchUserRoleMappingList.put(EDPConstant.EMPLOYEE_NO_KEY, EDPConstant.EMPLOYEE_NO_VALUE);
		searchUserRoleMappingList.put(EDPConstant.EMPLOYEE_NAME_KEY, EDPConstant.EMPLOYEE_NAME_VALUE);
		searchUserRoleMappingList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchUserRoleMappingList.put(EDPConstant.DDO_NO_KEY, EDPConstant.DDO_NO_VALUE);
		searchUserRoleMappingList.put(EDPConstant.CARDEX_NO_KEY, EDPConstant.CARDEX_NO_VALUE);
		searchUserRoleMappingList.put(EDPConstant.STATUS_KEY, EDPConstant.STATUS_VALUE);
		searchUserRoleMappingList.put(EDPConstant.WF_STATUS_KEY, EDPConstant.WF_STATUS_VALUE);
		searchUserRoleMappingList.put(EDPConstant.IN_ISDEFAULTSEARCH_KEY, EDPConstant.IN_ISDEFAULTSEARCH_VALUE);

		searchUpdateDesignationList.put(EDPConstant.TRN_NO_KEY, EDPConstant.TRN_NO_VALUE);
		searchUpdateDesignationList.put(EDPConstant.FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchUpdateDesignationList.put(EDPConstant.TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchUpdateDesignationList.put(EDPConstant.DESIGNATION_KEY, EDPConstant.DESIGNATION_VALUE);
		searchUpdateDesignationList.put(EDPConstant.EMPLOYEE_NO_KEY, EDPConstant.EMPLOYEE_NO_VALUE);
		searchUpdateDesignationList.put(EDPConstant.EMPLOYEE_NAME_KEY, EDPConstant.EMPLOYEE_NAME_VALUE);
		searchUpdateDesignationList.put(EDPConstant.DISTRICT_KEY, EDPConstant.DISTRICT_VALUE);
		searchUpdateDesignationList.put(EDPConstant.DDO_NO_KEY, EDPConstant.DDO_NO_VALUE);
		searchUpdateDesignationList.put(EDPConstant.CARDEX_NO_KEY, EDPConstant.CARDEX_NO_VALUE);
		searchUpdateDesignationList.put(EDPConstant.STATUS_KEY, EDPConstant.STATUS_VALUE);
		searchUpdateDesignationList.put(EDPConstant.IN_ISDEFAULTSEARCH_KEY, EDPConstant.IN_ISDEFAULTSEARCH_VALUE);
		searchUpdateDesignationList.put(EDPConstant.WF_STATUS_KEY, EDPConstant.WF_STATUS_VALUE);

		searchBranchCreEDPList.put(EDPConstant.IN_TRANSACTION_NO_KEY, EDPConstant.TRN_NO_VALUE);
		searchBranchCreEDPList.put(EDPConstant.FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchBranchCreEDPList.put(EDPConstant.TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchBranchCreEDPList.put(EDPConstant.IN_BRANCH_NAME_KEY, EDPConstant.IN_BRANCH_NAME_VALUE);
		searchBranchCreEDPList.put(EDPConstant.IN_BRANCH_TYPE_ID_KEY, EDPConstant.IN_BRANCH_TYPE_ID_VALUE);

		searchBranchMapEDPList.put(EDPConstant.IN_TRANSACTION_NO_KEY, EDPConstant.TRN_NO_VALUE);
		searchBranchMapEDPList.put(EDPConstant.FROM_DATE_KEY, EDPConstant.FROM_DATE_VALUE);
		searchBranchMapEDPList.put(EDPConstant.TO_DATE_KEY, EDPConstant.TO_DATE_VALUE);
		searchBranchMapEDPList.put(EDPConstant.STATUS_KEY, EDPConstant.STATUS_VALUE);
		searchBranchMapEDPList.put(EDPConstant.REQUEST_TYPE_KEY, EDPConstant.REQUEST_TYPE_VALUE);
		searchBranchMapEDPList.put(EDPConstant.EMPLOYEE_NAME_KEY, EDPConstant.EMPLOYEE_NAME_VALUE);
		searchBranchMapEDPList.put(EDPConstant.EMPLOYEE_NO_KEY, EDPConstant.EMPLOYEE_NO_VALUE);

	}

	/**
	 * Gets the search list.
	 *
	 * @param entitySeq the entity seq
	 * @return the search list
	 */
	public static Map<String, String> getSearchList(int entitySeq) {

		if (entitySeq == VALUE_ZERO)
			return searchList;
		else if (entitySeq == VALUE_ONE)
			return searchSummaryDDOList;
		else if (entitySeq == VALUE_TWO)
			return searchSummaryEDPList;
		else if (entitySeq == VALUE_FOUR)
			return searchUpdDsgList;
		else if (entitySeq == VALUE_FIVE)
			return searchAddDsgList;
		else if (entitySeq == VALUE_SIX)
			return searchUserPostMappingList;
		else if (entitySeq == VALUE_SEVEN)
			return searchUserRoleMappingList;
		else if (entitySeq == 8)
			return searchUpdateOfficeList;
		else if (entitySeq == VALUE_NINE)
			return searchUpdateDesignationList;
		else if (entitySeq == VALUE_TEN)
			return searchBranchMapEDPList;
		else
			return searchPostList;
	}

	/** The Constant SP_EDP_SEARCH_OFFICE_WF. */
	public static final String SP_EDP_SEARCH_OFFICE_WF = "SP_EDP_NEW_OFFICE_CREATION_LIST_WF";// SP_EDP_NEW_UPDATE_OFFICE_LIST_KP_1

	/** The Constant SP_EDP_SEARCH_POST_WF. */
	public static final String SP_EDP_SEARCH_POST_WF = "POST_CREATION_SEARCH_LIST_DATE";

	/** The Constant SP_EDP_SUMMARY_DDO_WF. */
	public static final String SP_EDP_SUMMARY_DDO_WF = "SP_EDP_SUMMARY_DDO_WF_NEW_KP";

	/** The Constant SP_EDP_SUMMARY_EDP_WF. */
	public static final String SP_EDP_SUMMARY_EDP_WF = "SP_EDP_SUMMARY_EDP_WF_NEW_KP";

	/** The Constant ATTACHMENT_TYPE. */
	public static final String ATTACHMENT_TYPE = "Attachment_Type";

	/** The Constant ARG_OFFICE_ID. */
	public static final String ARG_OFFICE_ID = "officeId";

	/** The Constant ARG_OFFICE_ID. */
	public static final String ARG_OFFICE_TRN_ID = "officeTrnId";

	/** The Constant ARG_ATTTYPE. */
	public static final String ARG_ATTTYPE = "attachmentType";

	/** The Constant ARG_DDOTYPE. */
	public static final String ARG_DDOTYPE = "DDO_Type";

	/** The Constant DOT_SPILLTER. */
	public static final String DOT_SPILLTER = "\\.";

	/** The Constant DEFAULT_PASWD. */
	public static final String DEFAULT_PASWD = "Ifms@123";

	/** The Constant EMPTY_STRING. */
	public static final String EMPTY_STRING = "";

	/** The Constant SLASH. */
	public static final String SLASH = "/";

	/** The Constant BYTE_TO_MB. */
	public static final long BYTE_TO_MB = 1048576L;

	/** The Constant BYTE_TO_KB. */
	public static final long BYTE_TO_KB = 1024L;

	/** The Constant DEF_CONTENT_TYPE. */
	public static final String DEF_CONTENT_TYPE = "application/octet-stream";

	/** The Constant TRANSACTION_NO_FORMATE. */
	public static final String TRANSACTION_NO_FORMATE = "%05d";

	/** The Constant ARG_ACTIVESTATUS. */
	public static final String ARG_ACTIVESTATUS = "activeStatus";

	/** The Constant INACTIVE_STATUS. */
	public static final int INACTIVE_STATUS = 0;

	/** The Constant IN_PARENT_LOOKUP_ID_VALUE. */
	public static final long IN_PARENT_LOOKUP_ID_VALUE = 35;

	/** The Constant IN_PARENT_LOOKUP_ID_KEY. */
	public static final String IN_PARENT_LOOKUP_ID_KEY = "IN_PARENT_LOOKUP_ID";

	/** The Constant USER_EMAIL. */
	public static final String USER_EMAIL = "userEmail";

	/** The Constant USER_MOBILE. */
	public static final String USER_MOBILE = "userMobile";

	/** The Constant USER_ID. */
	public static final String USER_ID = "userId";

	/** The Constant EMP_NO. */
	public static final String EMP_NO = "empNo";

	/** The Constant LIST_OF_BILLS. */
	public static final String LIST_OF_BILLS = "Lists of Bill";

	/** The Constant SP_EDP_SEARCH_UPD_DSG. */
	public static final String SP_EDP_SEARCH_UPD_DSG = "SP_UPDATE_DESIGN_SEARCH_LIST_WF";

	/** The Constant SP_EDP_SEARCH_ADD_DSG. */
	public static final String SP_EDP_SEARCH_ADD_DSG = "SP_ADD_DESIGN_SEARCH_LIST_WF_NEW";

	/** The Constant SP_EDP_USER_POST_TRANSFRER. */
	public static final String SP_EDP_USER_POST_TRANSFRER = "EDP_USER_POST_MAPPING_LIST_WF_NEW";

	/** The Constant POST_MAPPING_ATTACHMENT. */
	public static final String POST_MAPPING_ATTACHMENT = "Post Mapping Attachment";

	/** The Constant EMAIL_MASK. */
	public static final String EMAIL_MASK = "emailMask";

	/** The Constant MOBILE_MASK. */
	public static final String MOBILE_MASK = "mobileMask";

	/** The Constant TOKEN_HASH. */
	public static final String TOKEN_HASH = "tokenHash";

	/** The Constant ARG_POST_TYPE_PRIMARY. */
	public static final Long ARG_POST_TYPE_PRIMARY = 2l;

	/** The Constant ARG_POST_TYPE_PRIMARY_NAME. */
	public static final String ARG_POST_TYPE_PRIMARY_NAME = "YES";

	/** The Constant ARG_POST_TYPE_SECONDARY. */
	public static final Long ARG_POST_TYPE_SECONDARY = 1l;

	/** The Constant ARG_POST_VACANT_YES. */
	public static final Long ARG_POST_VACANT_YES = 2l;

	/** The Constant ARG_POST_VACANT_NO. */
	public static final Long ARG_POST_VACANT_NO = 1l;

	/** The Constant PRIMARY_POST. */
	public static final String PRIMARY_POST = "Primary";

	/** The Constant SECONDARY_POST. */
	public static final String SECONDARY_POST = "Secondary";

	/** The Constant TEMPLATE. */
	public static final String TEMPLATE = "mail/passwordChangeEmail";

	/** The Constant USER. */
	public static final String USER = "user";

	/** The Constant USER_CODE. */
	public static final String USER_CODE = "userCode";

	/** The Constant OFFICE_ID. */
	public static final String OFFICE_ID = "officeId";

	/** The Constant OFFICE_ID. */
	public static final String POST_ID = "postId";

	/** The Constant ARG_FROM_POU_ID. */
	public static final String ARG_FROM_POU_ID = "pouFromId";

	/** The Constant ARG_TO_POU_ID. */
	public static final String ARG_TO_POU_ID = "pouToId";

	/** The Constant HEADER_ID. */
	public static final String HEADER_ID = "headerId";

	/** The Constant ARG_TRNNO. */
	public static final String ARG_TRNNO = "trnNo";

	/** The Constant IS_ACTIVE_KEY. */
	public static final String IS_ACTIVE_KEY = "isactive";

	/** The Constant ARG_FROM. */
	public static final String ARG_FROM = "From";

	/** The Constant ARG_TO. */
	public static final String ARG_TO = "To";

	/** The Constant FRIST_SEQUENCE_NUMBER. */
	public static final String FRIST_SEQUENCE_NUMBER = "00001";

	/** The Constant SLASH_SPILLTER. */
	public static final String SLASH_SPILLTER = "\\/";

	/** The Constant DATE_FORMATE. */
	public static final String DATE_FORMATE = "dd-MM-yyyy hh:mm:ss";

	/** The Constant NAME_SHOULD_BE_IN_CAMEL_CASE. */
	public static final String NAME_SHOULD_BE_IN_CAMEL_CASE = "First Letter Of Each Word Should Be Capital";

	/** The Constant NAME_SHOULD_BE_NOT_ALLOWED_SPECIAL_CHAR. */
	public static final String NAME_SHOULD_BE_NOT_ALLOWED_SPECIAL_CHAR = "Special Char Not Allowed";

	/** The Constant EACH_WORD_SHOULD_BE_SINGLE_SPACE_SEPARATED. */
	public static final String EACH_WORD_SHOULD_BE_SINGLE_SPACE_SEPARATED = "Multi Space Not Allowed ";

	/** The Constant DESIGNATION_NAME_NOT_VALID. */
	public static final String DESIGNATION_NAME_NOT_VALID = "Designation Name Is Not Valid";

	/** The Constant DESIGNATION_NAME_NOT_ALLOWED. */
	public static final String DESIGNATION_NAME_NOT_ALLOWED = "Please Enter Designation Name";

	/** The Constant ROLE_MAPPING_DRAFT. */
	public static final long ROLE_MAPPING_DRAFT = 205;

	/** The Constant ROLE_MAPPING_PENDING. */
	public static final long ROLE_MAPPING_PENDING = 204;

	/** The Constant ROLE_MAPPING_SUBMIT. */
	public static final long ROLE_MAPPING_SUBMIT = 267;

	/** The Constant ROLE_MAPPING_TRAN_NUMBER_STRING. */
	public static final String ROLE_MAPPING_TRAN_NUMBER_STRING = "/EDP/URM/";

	/** The Constant LK_STATUS_VAL_PENDING. */
	public static final String LK_STATUS_VAL_PENDING = "Pending";

	/** The Constant LK_STATUS_VAL_SAVAS_DRAFT. */
	public static final String LK_STATUS_VAL_SAVAS_DRAFT = "Saved as Draft";

	/** The Constant LK_STATUS_VAL_SUBMIT. */
	public static final String LK_STATUS_VAL_SUBMIT = "Submit";

	/** The Constant LK_STATUS_VAL_APPROVED. */
	public static final String LK_STATUS_VAL_APPROVED = "Approved";

	/** The Constant LK_STATUS_VAL_CANCELLED. */
	public static final String LK_STATUS_VAL_CANCELLED = "Cancelled";

	/** The Constant ORDER_ASC. */
	public static final int ORDER_ASC = 1;

	/** The Constant ORDER_DESC. */
	public static final int ORDER_DESC = 2;

	/** The Constant DESIGNATION_NAME. */
	public static final String DESIGNATION_NAME = "designationName";

	/** The Constant DISTRICT_NAME. */
	public static final String DISTRICT_NAME = "districtName";

	/** The Constant IS_REMOVED. */
	public static final String IS_REMOVED = "isRemoved";

	/** The Constant STATUS. */
	public static final String STATUS = "status";

	/** The Constant LK_STATUS_VAL_ACTIVE. */
	public static final String LK_STATUS_VAL_ACTIVE = "Active";

	/** The Constant LOOKUP_NAME_YES. */
	public static final String LOOKUP_NAME_YES = "YES";

	/** The Constant ATTACHMENT_FILENAME_USER_PHOTO. */
	public static final String ATTACHMENT_FILENAME_USER_PHOTO = "attachment; filename=\"";

	/** The Constant STRING_DOUBLE_QUOTES. */
	public static final String STRING_DOUBLE_QUOTES = "\"";

	/** The Constant SUBOFFICE_NO_FORMATE. */
	public static final String SUBOFFICE_NO_FORMATE = "%02d";

	/** The Constant DEPARTMENT_NAME. */
	public static final String DEPARTMENT_NAME = "departmentName";

	/** The Constant LOOKUP_INFO_ID. */
	public static final String LOOKUP_INFO_ID = "lookUpInfoId";

	/** The Constant TALUKA_NAME. */
	public static final String TALUKA_NAME = "talukaName";

	/** The Constant OFFICE_NAME. */
	public static final String OFFICE_NAME = "officeName";

	/** The Constant TO_USERID. */
	public static final String TO_USERID = "toUserId";

	/** The Constant FROM_USERID. */
	public static final String FROM_USERID = "fromUserId";

	/** The Constant POSTOFFICE_ID. */
	public static final String POSTOFFICE_ID = "postOfficeId";

	/** The Constant ARGS_0. */
	public static final String ARGS_0 = "{0}";

	/** The Constant ARGS_1. */
	public static final String ARGS_1 = "{1}";

	/** The Constant DEFAULT_ERROR. */
	public static final int DEFAULT_ERROR = 0;

	/** The Constant ARGS_POST_OFC_USERID. */
	public static final String ARGS_POST_OFC_USERID = "postOfficeUserId";

	/** The Constant ARGS_MENU_ID. */
	public static final String ARGS_MENU_ID = "menuId";

	/** The Constant NOT_MAP_USER. */
	public static final String NOT_MAP_USER = "User Not Mapped";

	/** The Constant approved status. */
	public static final Short STATUS_APPROVED_ID = 327;

	/** The Constant SP_EDP_SUMMARY_DDO_WF. */
	public static final String SP_EDP_SUMMARY_DDO_DETAIL = "SP_EDP_OFFICE_DETAIL_SUMMARY";

	/** The Constant MAX_UPLOAD_FILE_SIZE. */
	public static final Integer MAX_UPLOAD_FILE_SIZE = 10;

	/** The Constant OFFICE_STATUS_ID. */
	public static final Long OFFICE_STATUS_ID = 283l;

	/** The Constant OFFICE_ID. */
	public static final String OFFICE_ID_OFFICE_ID = "officeId.officeId";

	/** The Constant LOOKUP_INFO_YES. */
	public static final Long LOOKUP_INFO_YES = 2l;

	/** The Constant TRN_NO. */
	public static final String TRN_NO = "trn_no";

	/** The Constant IS_UPDATE_KEY. */
	public static final String FLAG_KEY = "flag";
	/** The Constant approved status. */
	public static final Long STATUS_SUBMIT_ID = 267l;

	/** The Constant STATUS_APPROVE_ID. */
	public static final Long STATUS_APPROVE_ID = 327l;

	/** The Constant STATUS_CANCELLED_ID. */
	public static final Long STATUS_CANCELLED_ID = 872l;

	/** The Constant OFFICE_MENU_CODE. */
	public static final String OFFICE_MENU_CODE = "CNO";

	/** The Constant ROLE_PERMISSION_CREATE. */
	public static final String ROLE_PERMISSION_CREATE = "Create";

	/** The Constant ROLE_PERMISSION_EDIT. */
	public static final String ROLE_PERMISSION_EDIT = "Edit";

	/** The Constant ROLE_PERMISSION_VIEW. */
	public static final String ROLE_PERMISSION_VIEW = "View";

	/** The Constant ROLE_PERMISSION_CREATE. */
	public static final Long WF_ROLE_PERMISSION_CREATOR = 1l;

	/** The Constant ROLE_PERMISSION_EDIT. */
	public static final Long WF_ROLE_PERMISSION_VERIFIER = 2l;

	/** The Constant ROLE_PERMISSION_VIEW. */
	public static final Long WF_ROLE_PERMISSION_APPROVER = 3l;

	/** The Constant PVU_OFF_GANDHINAGAR. */
	public static final String PVU_OFF_GANDHINAGAR = "Pay Verification Unit, Gandhinagar";

	/** The Constant LK_USR_MENU_ID. */
	public static final String LK_USR_MENU_ID = "lkUsrMenuId";

	/** The Constant RG_MAP_ID. */
	public static final String RG_MAP_ID = "rgMapId";

	/** The Constant EDP_WF_RIGHTS. */
	public static final String EDP_WF_RIGHTS = "edpWfRights";

	/** The Constant HOD_ID. */
	public static final long HOD_ID = 54;

	/** The Constant STATE_ID_GUJ. */
	public static final Long STATE_ID_GUJ = 7l;

	/** The Constant DISPLAY_SUB_OFFICE. */
	public static final String DISPLAY_SUB_OFFICE = "isDisplaySubOffice";

	/** The Constant ARG_LIKE_OPER. */
	public static final String ARG_LIKE_OPER = " - %";

	/** The Constant EDP_TRN_USR_ROLE_PRM_ID. */
	public static final String EDP_TRN_USR_ROLE_PRM_ID = "trnUsrRolePrmId";

	/** The Constant EDP_TRN_USR_WF_ROLE_ID. */
	public static final String EDP_TRN_USR_WF_ROLE_ID = "trnUsrWfRoleId";

	/** The Constant REPORT_POST_HISTORY. */
	public static final String REPORT_POST_HISTORY = "REPORT_POST_HISTORY_1_KP";

	/** The Constant REPORT_OFFICE_HISTORY. */
	public static final String REPORT_OFFICE_HISTORY = "REPORT_OFFICE_CREATION_SUMMARY_KP";

	/** The Constant STATE_NAME. */
	public static final String STATE_NAME = "stateName";

	/** The Constant OFFICE_TYPE_AD. */
	public static final String OFFICE_TYPE_AD = "Administrative Department";

	/** The Constant DDO_TYPE_ID. */
	public static final Long DDO_TYPE_ID = 71l;

	/** The Constant FL_TO. */
	public static final String FL_TO = "TO";

	/** The Constant FL_STO. */
	public static final String FL_STO = "STO";

	/** The Constant FL_PVU. */
	public static final String FL_PVU = "PVU";

	/** The Constant FL_DPPF. */
	public static final String FL_DPPF = "DPPF";

	/** The Constant FL_FD. */
	public static final String FL_FD = "FD";

	/** The Constant FL_LOCAL_FUND. */
	public static final String FL_LOCAL_FUND = "LOCAL FUND";

	/** The Constant DAT_OFFICE. */
	public static final String DAT_OFFICE = "DAT";

	/** The Constant SP_GET_EMP_POST_OFFICE_DETAILS. */
	public static final String SP_GET_EMP_POST_OFFICE_DETAILS = "SP_GET_EMP_POST_OFFICE_DETAILS";

	/** The Constant IN_USER_CODE. */
	public static final String IN_USER_CODE = "IN_USER_CODE";

	/** The Constant LOOKUP_YES. */
	public static final String LOOKUP_YES = "YES";

	/** The Constant LOOKUP_POST_TRANSFER. */
	public static final Long LOOKUP_POST_TRANSFER_REQUEST_TYPE_ID = 610l;

	/** The Constant LOOKUP_INFO_NO. */
	public static final Long LOOKUP_INFO_NO = 1l;

	/** The Constant LOOKUP_INFO_NO. */
	public static final Short LOOKUP_INFO_NO_SHORT = 1;

	/** The Constant LOOKUP_INFO_NO. */
	public static final Short LOOKUP_INFO_YES_SHORT = 2;

	/** The Constant POST_TRANSFER_MENU_ID. */
	public static final Long POST_TRANSFER_MENU_ID = 35l;

	/** The Constant SP_GET_OFFICE_VACANT_POST_DTLS. */
	public static final String SP_GET_OFFICE_VACANT_POST_DTLS = "SP_GET_OFFICE_VACANT_POST_DTLS";

	/** The Constant IN_STATUS. */
	public static final String IN_STATUS = "IN_STATUS";

	/** The Constant IN_IS_VACANT_POST. */
	public static final String IN_IS_VACANT_POST = "IN_IS_VACANT_POST";

	/** The Constant SP_GET_USER_POST_MAPPING_DETAILS. */
	public static final String SP_GET_USER_POST_MAPPING_DETAILS = "SP_GET_USER_POST_MAPPING_DETAILS";

	/** The Constant SP_UPT_TRN_DATA_INSERT. */
	public static final String SP_UPT_TRN_DATA_INSERT = "SP_UPT_TRN_DATA_INSERT";

	/** The Constant SP_UPT_TRN_DATA_VIEW. */
	public static final String SP_UPT_TRN_DATA_VIEW = "SP_UPT_TRN_DATA_VIEW";

	/** The Constant IN_HDR_ID. */
	public static final String IN_HDR_ID = "IN_HDR_ID";

	/** The Constant IN_FROM_USER_ID. */
	public static final String IN_FROM_USER_ID = "IN_FROM_USER_ID";

	/** The Constant IN_TO_USER_ID. */
	public static final String IN_TO_USER_ID = "IN_TO_USER_ID";

	/** The Constant IN_CREATED_BY. */
	public static final String IN_CREATED_BY = "IN_CREATED_BY";

	/** The Constant IN_CREATED_BY_POST. */
	public static final String IN_CREATED_BY_POST = "IN_CREATED_BY_POST";

	/** The Constant IN_UPDATED_BY_POST. */
	public static final String IN_UPDATED_BY_POST = "IN_UPDATED_BY_POST";

	/** The Constant IN_LK_POST_OFFICE_ID. */
	public static final String IN_LK_POST_OFFICE_ID = "IN_LK_POST_OFFICE_ID";

	/** The Constant SP_DISTRICT_WISE_OFFICE_DTL. */
	public static final String SP_DISTRICT_WISE_OFFICE_DTL = "SP_DISTRICT_WISE_OFFICE_DTL";

	/** The Constant SP_EDP_SUMMARY_EDP_WF. */
	public static final String SP_GET_USER_MENU_ROLEPRM_WF = "SP_GET_USER_MENU_ROLEPRM_WF";

	/** The Constant IN_LK_POU_ID. */
	public static final String IN_LK_POU_ID = "IN_LK_POU_ID";

	/** The Constant SP_GET_EMP_POST_BY_EMP_AND_OFFICE. */
	public static final String SP_GET_EMP_POST_BY_EMP_AND_OFFICE = "SP_GET_EMP_POST_BY_EMP_AND_OFFICE";

	/** The Constant EMP_NO_VALUE. */
	public static final String EMP_NO_VALUE = "IN_EMP_NO";

	/** The Constant SUB_MODULE_IDS. */
	public static final String SUB_MODULE_ID = "subModuleId";

	/** The Constant MOD_OFF_TYPE_ID. */
	public static final String MOD_OFF_TYPE_ID = "modOffTypeId";

	/** The Constant TREASURY_OFFICE. */
	public static final String TREASURY_OFFICE = "Treasury Office";

	/** The Constant PAO. */
	public static final String PAO = "Pay and Accounts Office";

	/** The Constant SP_GET_WF_ROLE_BY_RGMAPID. */
	public static final String SP_GET_WF_ROLE_BY_RGMAPID = "SP_GET_WF_ROLE_BY_RGMAPID";

	/** The Constant RIGHTS_MAPPING_TRN_SCREEN_NAME. */
	public static final String RIGHTS_MAPPING_TRN_SCREEN_NAME = "URM";

	/** The Constant SP_GET_EDP_TRN_NO_GEN. */
	public static final String SP_GET_EDP_TRN_NO_GEN = "GET_EDP_TRN_NO_GEN";

	/** The Constant SP_EDP_RM_GET_TRN_BY_RGMAP. */
	public static final String SP_EDP_RM_GET_TRN_BY_RGMAP = "SP_EDP_RM_GET_TRN_BY_RGMAP";

	/** The Constant SP_EDP_RM_GET_DTL_ROLE_PRM. */
	public static final String SP_EDP_RM_GET_DTL_ROLE_PRM = "SP_EDP_RM_GET_DTL_ROLE_PRM";

	/** The Constant SP_EDP_RG_GET_WF_REQUEST. */
	public static final String SP_EDP_RG_GET_WF_REQUEST = "SP_EDP_RG_GET_WF_REQUEST";

	/** The Constant SP_LOGIN_USER_MENU_ROLEPRM_WF. */
	public static final String SP_LOGIN_USER_MENU_ROLEPRM_WF = "SP_LOGIN_USER_MENU_ROLEPRM_WF_NEW";

	/** The Constant IN_T_USR_RG_MAP_ID. */
	public static final String IN_T_USR_RG_MAP_ID = "IN_T_USR_RG_MAP_ID";

	/** The Constant SP_GET_EMPPOST_FOR_MENU_OFFICE_WFROLES. */
	public static final String SP_GET_PERM_FOR_OFFICE_AND_MENU = "SP_GET_PERM_FOR_OFFICE_AND_MENU";

	/** The Constant SP_GET_WFROLES_FOR_OFFICE_AND_MENU. */
	public static final String SP_GET_WFROLES_FOR_OFFICE_AND_MENU = "SP_GET_WFROLES_FOR_OFFICE_AND_MENU";

	/** The Constant POST_TRANSFER_TRN_SCREEN_NAME. */
	public static final String POST_TRANSFER_TRN_SCREEN_NAME = "PT";

	/** The Constant IN_WF_ROLE_VALUE. */
	public static final String IN_WF_ROLE_VALUE = "IN_WFROLES";

	/** The Constant IN_POU_ID_VALUE. */
	public static final String IN_POU_ID_VALUE = "IN_POU_ID";

	/** The Constant IN_ISDEFAULTSEARCH_KEY. */
	public static final String IN_ISDEFAULTSEARCH_KEY = "isDefaultSearch";

	/** The Constant IN_ISDEFAULTSEARCH_VALUE. */
	public static final String IN_ISDEFAULTSEARCH_VALUE = "ISDEFAULTSEARCH";

	/** The Constant OFFICE_SUB_TYPE. */
	public static final String OFFICE_SUB_TYPE = "Office_Sub_Type";

	/** The Constant MENU_ID. */
	public static final String MENU_ID = "menuId";

	/** The Constant EMPLOYEE_NO_STRING. */
	public static final String EMPLOYEE_NO_STRING = "Employee";

	/** The Constant VACANT_POST_STRING. */
	public static final String VACANT_POST_STRING = "Vacant Post";

	/** The Constant REF_NO. */
	public static final String REF_NO = "Reference Number";

	/** The Constant REF_DATE. */
	public static final String REF_DATE = "Reference Date";

	/** The Constant DISTRICT. */
	public static final String DISTRICT = "District";

	/** The Constant DDO_NO. */
	public static final String DDO_NO = "DDO No.";

	/** The Constant CARDEX_NO. */
	public static final String CARDEX_NO = "Cardex No.";

	/** The Constant OFFICE_NAME_STRING. */
	public static final String OFFICE_NAME_STRING = "Office Name";

	/** The Constant FROM_EMP_NO. */
	public static final String FROM_EMP_NO = "From Employee Number";

	/** The Constant FROM_EMP_NAME. */
	public static final String FROM_EMP_NAME = "From Employee Name";

	/** The Constant POST_TRANSFER_FROM. */
	public static final String POST_TRANSFER_FROM = "Post Transfer From";

	/** The Constant POST_TRANSFER_TO. */
	public static final String POST_TRANSFER_TO = "Post Transfer To";

	/** The Constant TO_EMP_NO. */
	public static final String TO_EMP_NO = "To Employee Number";

	/** The Constant TO_EMP_NAME. */
	public static final String TO_EMP_NAME = "To Employee Name";

	/** The Constant APPROVER_ROLE. */
	public static final String APPROVER_ROLE = "APPROVER";

	/** The Constant TOPAO_APPROVER_ROLE. */
	public static final String TOPAO_APPROVER_ROLE = "TO/PAO APPROVER";

	/** The Constant TO_PAO_ALIAS. */
	public static final String TO_PAO_ALIAS = "TO_PAO_ALIAS";

	/** The Constant DAT_ALIAS. */
	public static final String DAT_ALIAS = "DAT_ALIAS";

	/** The Constant TOPAO_INIT. */
	public static final String TOPAO_INIT = "INITIATED_BY_TO_PAO_OFFICE";

	/** The Constant DAT_INIT. */
	public static final String DAT_INIT = "INITIATED_BY_TO_DAT_OFFICE";

	/** The Constant DEFAULT_INIT. */
	public static final String DEFAULT_INIT = "DEFAULT_INITIATED_BY_NORMAL_OFFICE";

	/** The Constant LK_STATUS_VAL_REJECTED. */
	public static final String LK_STATUS_VAL_REJECTED = "Rejected";

	/** The Constant SP_GET_OFFICE_VACANT_POST_DTLS. */
	public static final String SP_CHECK_UPT_REQUEST_EXISTS = "CHECK_UPT_REQUEST_EXISTS";

	/** The Constant WF_STATUS_KEY. */
	public static final String WF_STATUS_KEY = "wfStatusId";

	/** The Constant WF_STATUS_VALUE. */
	public static final String WF_STATUS_VALUE = "IN_WF_STATUS";

	/** The Constant IN_STATUS_KEY. */
	public static final String IN_STATUS_KEY = "statusId";

	/** The Constant VALUE_SEVEN. */
	public static final int VALUE_SEVEN = 7;

	/** The Constant TRN_FROM_DATE_KEY. */
	public static final String TRN_FROM_DATE_KEY = "trnFromDate";

	/** The Constant TO_DATE_KEY. */
	public static final String TRN_TO_DATE_KEY = "trnToDate";

	/** The Constant UNIQUE_OFFICE_ID. */
	public static final String UNIQUE_OFFICE_ID = "UNIQUE_OFFICE_ID";

	/** The Constant TRN_ID. */
	public static final String TRN_ID = "trnId";

	/** The Constant OFFICE_TYPE. */
	public static final String OFFICE_TYPE = "Office Type";

	/** The Constant CONTROLLING_OFFICE. */
	public static final String CONTROLLING_OFFICE = "Controlling Office";

	/** The Constant BILLS_TYPE. */
	public static final String BILLS_TYPE = "Bills Type";

	/** The Constant OFFICE_LEVEL. */
	public static final String OFFICE_LEVEL = "Office Level";

	/** The Constant BILLS_SUBMITTED_TO. */
	public static final String BILLS_SUBMITTED_TO = "Bills Submitted To";

	/** The Constant SP_GET_HEADER_DETAILS_COMMON. */
	public static final String SP_GET_HEADER_DETAILS_COMMON = "SP_GET_HEADER_DETAILS_COMMON";

	/** The Constant POST_TRANSFER_MENU_ID. */
	public static final Long CREATE_OFFICE_MENU_ID = 20l;

	/** The Constant ADD_NEW_DESIGNATION_MENU_ID. */
	public static final Long ADD_NEW_DESIGNATION_MENU_ID = 26l;

	/** The Constant ADD_NEW_DESIGNATION_MENU_ID. */
	public static final Long DAT_OFFICE_ID = 38l;

	/** The Constant POST_NAME. */
	public static final String POST_NAME = "postName";

	/** The Constant POST_CREATION_MENU_ID. */
	public static final Long POST_CREATION_MENU_ID = 39l;

	/** The Constant TO_LOOKUP_ID. */
	public static final Long TO_LOOKUP_ID = 405l;

	/** The Constant PAO_LOOKUP_ID. */
	public static final Long PAO_LOOKUP_ID = 400l;

	/** The Constant POST_RIGHTS_MAPPING_MENU_ID. */
	public static final Long POST_RIGHTS_MAPPING_MENU_ID = 31l;

	/** The Constant FWD_DAT. */
	public static final String FWD_DAT = "IS_FWD_DAT";

	/** The Constant FWD_DEFAULT. */
	public static final String FWD_DEFAULT = "DEFAULT_IS_FWD_TO_PAO";

	/** The Constant IN_POU_ID. */
	public static final String IN_POU_ID = "pouId";

	/** The Constant IN_WF_ROLES. */
	public static final String IN_WF_ROLES = "wfRoles";

	/** The Constant IN_WF_ROLES_VALUE. */
	public static final String IN_WF_ROLES_VALUE = "IN_WFROLES";

	/** The Constant IN_WF_STATUS. */
	public static final String IN_WF_STATUS = "wfStatus";

	/** The Constant IN_WF_STATUS_VALUE. */
	public static final String IN_WF_STATUS_VALUE = "IN_WF_STATUS";

	/** The Constant IN_OFFICE_ID. */
	public static final String IN_OFFICE_ID = "officeId";

	/** The Constant T_EDP_DESIGNATION_WF. */
	public static final String T_EDP_DESIGNATION_WF = "T_EDP_DESIGNATION_WF";

	/** The Constant LK_STATUS_VAL_DRAFT. */
	public static final String LK_STATUS_VAL_DRAFT = "Draft";

	/** The Constant SP_CHECK_RGMAP_REQUEST_EXISTS. */
	public static final String SP_CHECK_RGMAP_REQUEST_EXISTS = "CHECK_RGMAP_REQUEST_EXISTS";

	/** The Constant DETAIL_OFFICE_SUMM_MENU_ID. */
	public static final Long DETAIL_OFFICE_SUMM_MENU_ID = 75l;

	/** The Constant SP_POST_CREATION_SEARCH_LIST_WF_NEW. */
	public static final String SP_POST_CREATION_SEARCH_LIST_WF = "SP_POST_CREATION_SEARCH_LIST_WF_NEW";

	/** The Constant IN_POU_ID_KEY. */
	public static final String IN_POU_ID_KEY = "inPouId";

	/** The Constant IN_ISDEFAULTSEARCH_VAl. */
	public static final String IN_ISDEFAULTSEARCH_VAL = "IS_DEFAULT_SEARCH";

	/** The Constant SP_EDP_SEARCH_OFFICE_WF. */
	public static final String SP_EDP_UPDATE_OFFICE_WF = "SP_EDP_UPDATE_OFFICE_CREATION_LIST_WF";

	/** The Constant UPDATE_DESIGNATION_MENU_ID. */
	public static final Long UPDATE_DESIGNATION_MENU_ID = 28l;

	/** The Constant UPDATE_DESIGNATION_MENU_ID. */
	public static final Long OFFICE_STATUS_DRAFT_ID = 205l;

	/** The Constant IN_DDO_TYPE_ID. */
	public static final String IN_DDO_TYPE_ID = "IN_DDO_TYPE_ID";

	/** The Constant LOOKUP_ID_VALUE. */
	public static final Long DAT_LOOKUP_VALUE = 898L;

	/** The Constant GNR_PAO_CODE. */
	public static final String GNR_PAO_DIST_CODE = "71";

	/** The Constant AHMD_PAO_CODE. */
	public static final String AHMD_PAO_DIST_CODE = "70";

	/** The Constant GNR_PAO_OFFICE_CODE. */
	public static final String GNR_PAO_OFFICE_CODE = "10054";

	/** The Constant AHMD_PAO_OFFICE_CODE. */
	public static final String AHMD_PAO_OFFICE_CODE = "10053";

	/** The Constant STAR. */
	public static final String STAR = "*";

	/** The Constant IN_OFFICE_NAME_KEY. */
	public static final String IN_OFFICE_NAME_KEY = "officeName";

	/** The Constant IN_OFFICE_NAME_VALUE. */
	public static final String IN_OFFICE_NAME_VALUE = "IN_OFFICE_NAME";

	/** The Constant IN_TRANSACTION_NO_KEY. */
	public static final String IN_TRANSACTION_NO_KEY = "trnNo";

	/** The Constant IIN_TRANSACTION_NO_VALUE. */
	public static final String IN_TRANSACTION_NO_VALUE = "IN_TRANSACTION_NO";

	/** The Constant IN_HOD_ID_VALUE. */
	public static final String IN_HOD_ID_VALUE = "IN_HOD";

	/** The Constant VALUE_NINE. */
	public static final int VALUE_NINE = 9;

	/** The Constant LOOKUP_INFO_ACTIVE. */
	public static final Long LOOKUP_INFO_ACTIVE = 283l;

	/** The Constant LOOKUP_INFO_ADMINI_DEPT. */
	public static final Long LOOKUP_INFO_ADMINI_DEPT = 52l;

	/** The Constant RIGHTS_MAPPING_REPORT_MENU_NAME. */
	public static final String RIGHTS_MAPPING_REPORT_MENU_NAME = "Rights Mapping Summary Report";

	/** The Constant RIGHTS_MAPPING_REPORT_MENU_NAME. */
	public static final String EDP_CNO_ATTCH_TBL_NAME = "T_EDP_OFF_ATTACH";

	/** The Constant SP_EDP_GET_OFFICE_DTL_BY_DISTRICT. */
	public static final String SP_EDP_GET_OFFICE_DTL_BY_DISTRICT = "SP_EDP_GET_OFFICE_DTL_BY_DISTRICT";

	/** The Constant SP_EDP_CHECK_UPD_OFFICE_REQUEST_EXISTS. */
	public static final String SP_EDP_CHECK_UPD_OFFICE_REQUEST_EXISTS = "CHECK_UPD_OFFICE_REQUEST_EXISTS";

	/** The Constant CHECK_DESIGNATION_REQUEST_EXISTS. */
	public static final String CHECK_DESIGNATION_REQUEST_EXISTS = "CHECK_DESIGNATION_REQUEST_EXISTS";

	/** The Constant SP_REPORT_OFFICE_GET_BILL. */
	public static final String SP_REPORT_OFFICE_GET_BILL = "REPORT_OFFICE_GET_BILLS";

	/** The Constant STATUS_REJECTED_ID. */
	public static final Long STATUS_REJECTED_ID = 348l;

	/** The Constant SP_SET_OFFICE_STATUS_CANCEL_REJECTED. */
	public static final String SP_SET_OFFICE_STATUS_CANCEL_REJECTED = "SP_SET_OFFICE_STATUS_CANCEL_REJECTED";

	/** The Constant CHECK_UPD_DESIGNATION_REQUEST_EXISTS. */
	public static final String CHECK_UPD_DESIGNATION_REQUEST_EXISTS = "CHECK_UPD_DESIGNATION_REQUEST_EXISTS";

	/** The Constant LOOKUP_INFO_CANCEL_ID. */
	public static final Long LOOKUP_INFO_CANCEL_ID = 281l;

	/** The Constant LOOKUP_INFO_INACTIVE_ID. */
	public static final Long LOOKUP_INFO_INACTIVE_ID = 282l;

	/** The Constant LOOKUP_INFO_CANCEL_VALUE. */
	public static final String LOOKUP_INFO_CANCEL_VALUE = "Cancel";

	/** The Constant LOOKUP_INFO_INACTIVE_VALUE. */
	public static final String LOOKUP_INFO_INACTIVE_VALUE = "Inactive";

	/** The Constant ACTION_APPROVE. */
	public static final String ACTION_APPROVE = "Approve";

	/** The Constant EDP_TREASURY_TYPE. */
	public static final Long EDP_TREASURY_TYPE = 63l;

	/** The Constant EDP_SUB_TREASURY_TYPE. */
	public static final Long EDP_SUB_TREASURY_TYPE = 64l;

	/** The Constant LOOKUP_BRANCH_TYPE_ID. */
	public static final Long LOOKUP_BRANCH_TYPE_ID = 4l;

	/** The Constant LOOKUP_INFO_BUDGET_BRANCH_ID. */
	public static final Long LOOKUP_INFO_BUDGET_BRANCH_ID = 507l;

	/** The Constant LOOKUP_TRUE. */
	public static final Short LOOKUP_TRUE = 2;

	/** The Constant LOOKUP_TRUE_LONG. */
	public static final Short LOOKUP_TRUE_LONG = 2;

	/** The Constant EDP_BRANCH_REQUEST_TYPE. */
	public static final Long EDP_BRANCH_REQUEST_TYPE = 141l;

	/** The Constant SP_GET_EMP_AND_POST_BY_OFFICE. */
	public static final String SP_GET_EMP_AND_POST_BY_OFFICE = "SP_GET_EMP_AND_POST_BY_OFFICE";

	/** The Constant SP_GET_EMP_POST_AND_DSGN_BY_OFFICE. */
	public static final String SP_GET_EMP_POST_AND_DSGN_BY_OFFICE = "SP_GET_EMP_POST_AND_DSGN_BY_OFFICE";

	/** The Constant SP_EDP_BRANCH_CR_LISTING. */
	public static final String SP_EDP_BRANCH_CR_LISTING = "SP_EDP_BRANCH_CREATION_LISTING ";

	/** The Constant SP_GET_EMP_MAPPED_BRANCH. */
	public static final String SP_GET_EMP_MAPPED_BRANCH = "SP_GET_EMP_MAPPED_BRANCH";

	/** The Constant LOOKUP_BRANCH_CREATION_REQUEST_TYPE. */
	public static final Long LOOKUP_BRANCH_CREATION_REQUEST_TYPE = 1096l;

	/** The Constant BRANCH_MAPPING_MENU_CODE. */
	public static final String BRANCH_MAPPING_MENU_CODE = "BMT";

	/** The Constant VALUE_TEN. */
	public static final int VALUE_TEN = 10;

	/** The Constant REQUEST_TYPE_VALUE. */
	public static final String REQUEST_TYPE_VALUE = "IN_REQUEST_TYPE";

	/** The Constant REQUEST_TYPE_KEY. */
	public static final String REQUEST_TYPE_KEY = "requestType";

	/** The Constant SP_EDP_BRANCH_MAPPING_LISTING. */
	public static final String SP_EDP_BRANCH_MAPPING_LISTING = "SP_EDP_BRANCH_MAPPING_LISTING";

	/** The Constant SP_GET_BR_MAP_DTL_BY_HDR. */
	public static final String SP_GET_BR_MAP_DTL_BY_HDR = "SP_GET_BR_MAP_DTL_BY_HDR";

	/** The Constant BRANCH_TRANSFER_REQ_TYPE_ID. */
	public static final Long BRANCH_TRANSFER_REQ_TYPE_ID = 612L;
	/** The Constant PAO_TYPE_LOOKUP_ID. */
	public static final Long PAO_TYPE_LOOKUP_ID = 65L;

	/** The Constant LOOKUP_NAME_PAYMENT_TYPE */
	public static final String LOOKUP_NAME_PAYMENT_TYPE = "Payment_Type";

	/** The Constant LOOKUP_NAME_BILL_CATEGORY. */
	public static final String LOOKUP_NAME_BILL_CATEGORY = "Bill_Category";

	/** The Constant LOOKUP_NAME_BILL_TYPE. */
	public static final String LOOKUP_NAME_BILL_TYPE = "Bill_Type";

	/** The Constant CHECK_BRMAP_REQUEST_EXISTS. */
	public static final String CHECK_BRMAP_REQUEST_EXISTS = "CHECK_BRMAP_REQUEST_EXISTS";

	/** The Constant FILE_NET_UPLOAD_DIRECTORY_PATH. */
	public static final String FILE_NET_UPLOAD_DIRECTORY_PATH = "IFMS_DOC";

	/** The Constant DOTE. */
	public static final String DOTE = ".";

	/**
	 * Gets the search branch cre EDP list.
	 *
	 * @return the search branch cre EDP list
	 */
	public static Map<String, String> getSearchBranchCreEDPList() {
		return searchBranchCreEDPList;
	}

	/** The Constant IN_FROM_LK_POU_ID. */
	public static final String IN_FROM_LK_POU_ID = "IN_FROM_LK_POU_ID";

	/** The Constant IN_TO_LK_POU_ID. */
	public static final String IN_TO_LK_POU_ID = "IN_TO_LK_POU_ID";

	/** The Constant SP_GET_BRANCH_USER_MENU_ROLEPRM_WF. */
	public static final String SP_GET_BRANCH_USER_MENU_ROLEPRM_WF = "SP_GET_BRANCH_USER_MENU_ROLEPRM_WF";

	/** The Constant DISTRICT_AHMEDABAD_PAO_ID. */
	public static final Long DISTRICT_AHMEDABAD_PAO_ID = 627l;

	/** The Constant DISTRICT_AHMEDABAD_ID. */
	public static final Long DISTRICT_AHMEDABAD_ID = 1l;

	/** The Constant DISTRICT_GANDHINAGAR_PAO_ID. */
	public static final Long DISTRICT_GANDHINAGAR_PAO_ID = 625l;

	/** The Constant DISTRICT_GANDHINAGAR_ID. */
	public static final Long DISTRICT_GANDHINAGAR_ID = 25l;

	/** The Constant DISTRICT_GANDHINAGAR_ID. */
	public static final Long TREASURY_OFFICE_SUB_TYPE = 405l;

	/** The Constant LOOKUP_NAME_BILL_TYPE. */
	public static final String LOOKUP_NAME_CONDITION_CHECK = "ConditionCheck";

	/** The Constant LOOKUP_NAME_BILL_TYPE. */
	public static final String LOOKUP_NAME_VITO_STATUS = "VITO STATUS";

	public static final String LOOKUP_NAME_BILL_STATUS = "BILL STATUS";

	// Bulk Employee Creation
	public static final String SP_NEW_USER_CREATION = "NEW_USER_CREATION";
	public static final String SP_NEW_BULK_USER_CREATION = "NEW_BULK_USER_CREATION";
	public static final String SP_NEW_ADD_MENU_TO_USER_BUDGET_GOG = "NEW_ADD_MENU_TO_USER_BUDGET_GOG";

	public static final String BULK_EMP_CREATION = "BEC";
	public static final String BEC_SERIAL_NO = "SR.NO";
	public static final String BEC_DISTRICT_NAME = "District name";
	public static final String BEC_DDO_NO = "DDO NO.";

	public static final String BEC_CARDEX_NO = "CARDEX NO.";

	/** The Constant LOOKUP_NAME_CHQ_TYPE. */
	public static final String LOOKUP_NAME_CHQ_TYPE = "Cheque_Type";

	public static final String BEC_OFFICE_NAME = "OFFICE NAME";

	public static final String BEC_ROLE = "Role";

	public static final String BEC_SALUTATION = "Salutation (Mr./MS/MRS/Dr)";

	public static final String BEC_FIRST_NAME = "First Name";

	public static final String BEC_MIDDLE_NAME = "Middle Name";

	public static final String BEC_LAST_NAME = "Last Name";

	public static final String BEC_DESIGNATION = "Designation";

	public static final String BEC_DOB = "Date of Birth";

	public static final String BEC_PAN = "PAN";
	public static final String BEC_CONTACT_NO = "Contact NO";
	public static final String BEC_PAY_FIXATION_CASE_NO = "Pay fixation Case Number (If Available)";
	public static final String BEC_EMPLOYEE_NO = "Employee No";
	public static final String BEC_ISSUES = "Issues";

	public static final String IN_USER_DESC = "IN_USER_DESC";

	public static final String BEC_IN_OFFICE_ID = "IN_OFFICE_ID";

	public static final String IN_DESIGNATION_ID = "IN_DESIGNATION_ID";

	public static final String IN_IS_PRIMARY_POST = "IN_IS_PRIMARY_POST";

	/** The Constant EDP_PAO_TYPE. */
	public static final Long EDP_PAO_TYPE = 65l;

	/** The Constant EDP_PENSION_AND_PAY_TYPE. */
	public static final Long EDP_PENSION_AND_PAY_TYPE = 66l;

	/** The Constant EDP_SUB_TYPE_TO. */
	public static final Long EDP_OFF_SUB_TYPE_TO = 405l;

	/** The Constant EDP_SUB_TYPE_STO. */
	public static final Long EDP_OFF_SUB_TYPE_STO = 404l;

	/** The Constant EDP_SUB_TYPE_PAO. */
	public static final Long EDP_OFF_SUB_TYPE_PAO = 400l;

	/** The Constant EDP_SUB_TYPE_PENSION_PAY. */
	public static final Long EDP_OFF_SUB_TYPE_PENSION_PAY = 402l;

	/** The Constant LOOKUP_FALSE. */
	public static final Short LOOKUP_FALSE = 1;

	public static final String IN_MENU_ID = "IN_MENU_ID";

	public static final String IN_ROLE_PERM_ID = "IN_ROLE_PERM_ID";

	public static final String IN_WF_ROLE_ID = "IN_WF_ROLE_ID";

	/** The Constant SUB_TREASURY_OFFICE_SUB_TYPE. */
	public static final Long SUB_TREASURY_OFFICE_SUB_TYPE = 404l;

	/** The Constant OFFICE_SUB_TYPE_CIRCLE_OFFICE. */
	public static final String OFFICE_SUB_TYPE_CIRCLE_OFFICE = "Circle Office";

	/** The Constant OFFICE_TYPE_ID_LU_NAME. */
	public static final String OFFICE_TYPE_ID_LU_NAME = "Office_type";

	/** The Constant OFFICE_TYPE_ID_LU_NAME. */
	public static final String OFFICE_TYPE_ID_HOD_LU_INFO_NAME = "Head of Department (HOD)";

	public static final Long STATUS_PARENT_LOOKUP_ID = 62l;
	
	public static final Long STATUS_APPROVED_ID_LONG = 327l;

}
