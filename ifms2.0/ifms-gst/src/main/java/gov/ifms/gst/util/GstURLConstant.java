package gov.ifms.gst.util;

/**
 * The Class BudgetURLConstant.
 */
public class GstURLConstant {

	/**
	 * Instantiates a new URL constant.
	 */
	private GstURLConstant() {
		super();
	}

	public static final String URL_BANKRATE_MASTER_BASEURL = "gst/bankratemaster";
	public static final String URL_FILE_ACCOUNTING_BASEURL = "gst/fileaccounting";
	public static final String URL_FILE_SUMMERY_BASEURL = "gst/filesummery";
	public static final String URL_BLOCK_STATUS_BASEURL = "gst/blockstatus";
	public static final String URL_CPIN_STATUS_BASEURL = "gst/cpinstatus";
	public static final String URL_CIN_FILE_DATA_BASEURL = "gst/cinfiledata";
	public static final String URL_BLOCK_CPIN_BASEURL = "gst/blockcpin";
	public static final String URL_CPIN_FILE_DATA_BASEURL = "eod/cpinfiledata";
	public static final String URL_ACCOUNT_HDR_BASEURL = "gst/accounthdr";
	public static final String URL_EXCEPTION_BASEURL = "gst/exceptionfile";
	public static final String URL_FILEHDR_BASEURL = "gst/filehdr";
	public static final String URL_DEBIT_BASEURL = "gst/debitentry";
	public static final String URL_CREDIT_BASEURL = "gst/creditentry";
	public static final String URL_FILEPROCESSED_BASEURL = "gst/fileprocess";
	public static final String URL_LOAD_AO_BASEURL = "gst/loadbalancerao";
	public static final String URL_LOAD_HA_BASEURL = "gst/loadbalancerha";
	public static final String URL_BASEURL = "gst/nongst";
	public static final String URL_ERROR_BASEURL = "gst/nonerror";
	public static final String URL_NONHEADS_BASEURL = "gst/nonheads";
	public static final String URL_NONMISMATCH_BASEURL = "gst/nonmismatch";
	public static final String URL_PANELDTL_BASEURL = "gst/paneldtl";
	public static final String URL_PANEL_ENTRY_BASEURL = "gst/panelentry";
	public static final String URL_RBIHDR_BASEURL = "gst/rbihdr";
	public static final String URL_RBIACCBAL_BASEURL = "gst/rbiaccstmtbal";
	public static final String URL_RBIACCHDR_BASEURL = "gst/rbiaccstmthdr";
	public static final String URL_RBIACCTRAN_BASEURL = "gst/rbiaccstmttranxn";
	public static final String URL_RBIFILE_HDR_BASEURL = "gst/rbifilehdr";
	public static final String URL_RBIFILE_TRAN_BASEURL = "gst/rbifiletranxn";
	public static final String URL_MOECONF_BASEURL = "gst/rbimoeconfcaseacknwlge";
	public static final String URL_MOEREJCT_BASEURL = "gst/rbimoerejctcaseacknwlge";
	public static final String URL_MOEHDR_BASEURL = "gst/rbimoereshdr";
	public static final String URL_RBIFILETRAN_BASEURL = "gst/rbifiletranxn";
	public static final String URL_MOE_RESLVD_BASEURL = "gst/rbimoereslvdcase";
	public static final String URL_RECONFILEDATA_BASEURL = "gst/reconfiledata";
	public static final String URL_SCROLLDISTRIBUTE_BASEURL = "gst/scrolldistribute";
	public static final String URL_CHALLAN_DISTRUBUTION_BASEURL = "gst/challandistrubution";
	public static final String URL_GENERATEHDR_BASEURL = "gst/generatehdr";
	public static final String URL_GENERATEMOE_BASEURL = "gst/generatemoe";
	public static final String URL_GST_REPORT_BASEURL = "gst/report";
	public static final String URL_GST_REPORT_DTL = "/detail";
	/**
	 * Common URLs
	 */
	public static final String URL_COMMON_BASEURL = "gst";
	
	
	/**
	 * Penal interest URLs
	 */
	public static final String URL_PENAL_INTEREST_BASEURL = "gst/penalinterest";
	

	/**
	 * The Constant URL_PENAL_INTEREST_GET_BANK_WISE_INTEREST.
	 */
	public static final String URL_PENAL_INTEREST_GET_BANK_WISE_INTEREST = "/bankwiseinterest";
 
	/**
	 * LU lookup URLs
	 */
	public static final String URL_LOOKUP_TYPE_BASEURL = "gst/lookup";

	/**
	 * The Constant URL_PENAL_INTEREST_LU_LOOKUP_RETRIEVE.
	 */
	public static final String URL_PENAL_INTEREST_LU_LOOKUP_RETRIEVE = "/getlistfromlookup";
	
	/**
	 * The Constant URL_PENAL_INTEREST_SAVE.
	 */
	public static final String URL_PENAL_INTEREST_SAVE = "/save";
	
	/**
	 * The Constant URL_PENAL_INTEREST_LISTING.
	 */
	public static final String URL_PENAL_INTEREST_LISTING = "/listing";
	public static final String URL_MANUAL_ENTRY_BASEURL = "gst/manualentry";

	public static final String URL_CHALLAN_ACCT_BASEURL = "gst/challanacct";

	public static final String URL_MANUAL_ENTRY_TYPE_LIST = "typeList";

	public static final String URL_MAJOR_HEAD_LIST = "majorheadlist";

	public static final String URL_SUB_MAJOR_HEAD_LIST = "submajorheadlist";

	public static final String URL_MINOR_HEAD_LIST = "minorheadlist";

	public static final String URL_SUB_HEAD_LIST = "subheadlist";

	public static final String URL_DETAILS_HEAD_LIST = "detailsheadlist";

	public static final String URL_OBJECT_HEAD_LIST = "objectheadlist";

	public static final String URL_POST_SUBMIT = "/901";

	public static final String URL_RECONCILE_DETAILS = "reconciledetails";


	/**
	 * The Constant URL_ACTION_CONFIG_WORKFLOW.
	 */
	public static final String URL_GST_ACTION_CONFIG_WORKFLOW = "/gst/wf";

	/**
	 * The Constant URL_WORKFLOW_NEXT_ACTIONS.
	 */
	public static final String URL_WORKFLOW_NEXT_ACTIONS = "/wfnextactions/201";

	/**
	 * The Constant URL_WF_USER_BY_ACTION_CONFIG.
	 */
	public static final String URL_WF_USER_BY_ACTION_CONFIG = "/user/action/config/201";

	/**
	 * The Constant URL_WF_TRN_SUBMIT.
	 */
	public static final String URL_WF_TRN_SUBMIT = "/trn/submit/101";

	/**
	 * The Constant URL_WF_TRN_SAVE.
	 */
	public static final String URL_WF_TRN_SAVE = "/trn/save/101";
	
	
	
	

	/**
	 * The Constant URL_GST.
	 */
	public static final String URL_GST = "/loc";
	

	/** The Constant V30. */
	public static final String V30 = "v3.0";

	/** The Constant V20. */
	public static final String V20 = "v2.0";

}
