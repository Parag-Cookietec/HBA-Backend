package gov.ifms.dmo.utils;

/**
 * The Class DMOURLConstant.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
public class DMOURLConstant {

	/**
	 * Instantiates a new URL constant.
	 */
	private DMOURLConstant() {
		super();
	}

	/**
	 * The Constant URL_POST. (Save As Draft)
	 */
	public static final String URL_POST = "/101";

	/**
	 * The Constant URL_POST_LIST.
	 */
	public static final String URL_POST_LIST = "/1001";

	/**
	 * The Constant URL_POST (Submit).
	 */
	public static final String URL_POST_SUBMIT = "/901";

	/**
	 * The Constant URL_GET_ALL.
	 */
	public static final String URL_GET_ALL = "/201";
	public static final String URL_GET_ALL_LIST = "/209";
	public static final String URL_GET_ALL_REF = "/getAllRef";
	public static final String URL_GET_BY_REF = "/getByRef";
	public static final String URL_GET_BY_INSTITUTE = "/getByInstitute";
	public static final String URL_UPDATE_BY_REF = "/updateByRef";
	public static final String URL_UPDATE_BY_MEMO = "/updateByMemo";
	public static final String URL_UPDATE_BY_CHEQUE = "/updateByCheque";
	public static final String URL_UPDATE_LETTER = "/updateLetter";
	public static final String URL_GET_ALL_MEMO_DELETE = "/getAllMemoForDelete";
	public static final String URL_GET_ALL_MEMO = "/getAllMemo";
	public static final String URL_GET_BY_MEMO = "/getByMemo";
	public static final String URL_GET_ALL_CHEQUE = "/getAllCheque";
	public static final String URL_GET_BY_CHEQUE = "/getByCheque";
	public static final String URL_GET_ALL_MEMO_REPAY = "/getAllMemoRepay";

	/**
	 * The Constant URL_GET_BY_ID.
	 */
	public static final String URL_GET_BY_ID = "/301";
	public static final String URL_MATCH_WITH_PAYABLE = "/match";

	/**
	 * The Constant URL_PUT_BY_ID.
	 */
	public static final String URL_PUT_BY_ID = "/401";

	/**
	 * The Constant URL_GET_ALL.
	 */
	public static final String URL_SEARCH_DATE = "/202";

	/*** DMO MODULE ***/

	/** The Constant URL_DMO_DPSheeetEntry. */
	public static final String DPSHEETENTRY_BASE_URL = "dmo/DPSheetEntry";

	/**
	 * The Constant URL_POST. (Save As Draft)
	 */
	public static final String DPSHEET_POST_URL = "/101";

	/**
	 * The Constant URL_POST_LIST.
	 */
	public static final String DPSHEET_POST_LIST = "/1001";

	/**
	 * The Constant URL_POST (Submit).
	 */
	public static final String DPSHEET_POST_SUBMIT = "/901";

	/**
	 * The Constant URL_GET_ALL.
	 */
	public static final String DPSHEET_GET_ALL = "/201";

	/**
	 * The Constant URL_GET_BY_ID.
	 */
	public static final String DPSHEET_GET_BY_ID = "/301";

	/**
	 * The Constant URL_DELETE_BY_ID.
	 */
	public static final String DPSHEET_DELETE_BY_ID = "/101";

	/**
	 * The Constant URL_MAIN_TRANSACTION.
	 */
	public static final String MAIN_TRANSACTION_BASE_URL = "dmo/transactions";

	/**
	 * The Constant URL_GET_BY_ID.
	 */
	public static final String URL_ALL_ACTIVE_TRANSACTION = "/302";

	/**
	 * The Constant NSSF Loan Module.
	 */
	public static final String NSSF_LOAN_RECEIVED_BASE_URL = "dmo/nssfloanreceived";

	public static final String DMO_DP_SHEET_BASE_URL = "dmo/dpentrysheet";
	
	/**
	 * The Constant URL_DMO_MASTER_FINANCIAL_YEAR.
	 */
	public static final String URL_DMO_MASTER_FINANCIAL_YEAR = "/dmo/msfinancialyear";

	/**
	 * The Constant NSSF Loan Repayments Module.
	 */
	public static final String NSSF_LOAN_REPAYMENT_BASE_URL = "dmo/nssfloanrepayment";

	public static final String MARKET_LOAN_RECEIVED_BASE_URL = "dmo/marketloan";

	/**
	 * The Constant URL_GET_ALL.
	 */
	public static final String URL_GET_ALL_REPAYMENTS = "/202";
	public static final String URL_DELETE_GOI = "/deleteGoi";
	public static final String URL_SEARCH_GOI = "/search";
	public static final String URL_SEARCH_REPAY_GOI = "/searchRepay";

	/**
	 * The Constant GOI Loan Module.
	 */
	public static final String GOI_LOAN_RECEIVED_BASE_URL = "dmo/goiloanreceived";

	/**
	 * The Constant Institutional Loan Module.
	 */
	public static final String INSTITUTIONAL_LOAN_BASE_URL = "dmo/institutionalloan";

	/**
	 * The Constant Institutional Loan Module.
	 */
	public static final String INSTITUTIONAL_LOAN_MEMO_BASE_URL = "dmo/institutionalloanmemo";

	/**
	 * The Constant GOI Dp sheet.
	 */
	public static final String GOI_LOAN_DP_SHEET_BASE_URL = "/goi";

	/**
	 * The Constant GOI Dp sheet.
	 */
	public static final String INSTITUTIONAL_DELETE_BASE_URL = "/deleteInstitution";
	/**
	 * The Constant NSSF Dp sheet.
	 */
	public static final String NSSF_LOAN_DP_SHEET_BASE_URL = "/nssf";
	/**
	 * The Constant Market Dp sheet.
	 */
	public static final String MARKET_LOAN_DP_SHEET_BASE_URL = "/marketloan";
	/**
	 * The Constant INSTITUTIONAL Dp sheet.
	 */
	public static final String INSTITUTIONAL_LOAN_DP_SHEET_BASE_URL = "/institutionalloan";
	/**
	 * The Constant INSTITUTIONAL Dp sheet.
	 */
	public static final String INSTITUTIONAL_LOAN_APPROVED_BASE_URL = "/approved";

	/**
	 * The Constant INSTITUTIONAL Dp sheet.
	 */
	public static final String REMOVE_LOAN_BASE_URL = "/removeloan";
	public static final String DMO_REMOVE_LOAN_BASE_URL = "dmo/removeloan";
	public static final String DELETE_REMOVE_LOAN_BASE_URL = "/delete";
	public static final String SEARCH_REMOVE_LOAN_BASE_URL = "/search";
	public static final String GET_SANCTION_NO_BASE_URL = "/sanction";
	public static final String GET_LOAN_DESC_BASE_URL = "/loanDesc";
	public static final String GET_INSTITUTE_BASE_URL = "/institute";
	public static final String GET_TENCHE_BASE_URL = "/tenche";

	/**
	 * The Constant GOI Loan Repayments Module.
	 */
	public static final String GOI_LOAN_REPAYMENT_BASE_URL = "dmo/goiloanrepayment";

	/**
	 * The Constant GOI Loan Repayments Module.
	 */
	public static final String MARKET_LOAN_REPAYMENT_BASE_URL = "dmo/marketloanrepayment";
	/**
	 * DMO GRF CRF Module
	 */
	/**
	 * The Constant Masters Module.
	 */

	public static final String DMO_ADVICE_AGENCY_BASE_URL = "dmo/adviceagency";

	public static final String DMO_DEPARMENT_MINISTRY_BASE_URL = "dmo/deparmentministry";

	public static final String DMO_LOAN_PURPOSE_BASE_URL = "dmo/loanpurpose";

	public static final String DMO_LOAN_ESTIMATE_BASE_URL = "dmo/loanestimate";
	public static final String DMO_DP_SCHEDULER_BASE_URL = "dmo/dpScheduler";

	public static final String DMO_WMA_TYPE_BASE_URL = "dmo/wmatype";

	public static final String DMO_GUARANTOR_ORGANZATIONS_BASE_URL = "dmo/guarantororg";

	public static final String DMO_INSTITUE_MASTER_BASE_URL = "dmo/instituemaster";

	public static final String DMO_SECUIRTY_MASTER_BASE_URL = "dmo/secuirtyemaster";
	public static final String GRF_CRF_BASE_URL = "dmo/grfcrf";
	public static final String GRFCRF_INTIMATION_POST_URL = "/100";
	public static final String GRFCRF_INTIMN_NO_SEARCH_URL = "/101";
	public static final String GRFCRF_INTIMATION_TRXN_TYPES_URL = "/102";
	public static final String GRFCRF_SECURITY_NAMES_GET_URL = "/202";
	public static final String GRFCRF_ACCRUED_INTEREST_POST_URL = "/201";
	public static final String GRFCRF_ADVICE_INVESTMENT_POST_URL = "/203";
	public static final String GRFCRF_SEC_DTL_POST_URL = "/204";
	public static final String DMO_GUARANTEE_ENTRY_BASE_URL = "dmo/guarantee/entry";
	public static final String DMO_GUARANTEE_ENTRY_POST_URL = "/301";
	public static final String DMO_GET_ALL_DEPT_MST_POST_URL = "/302";
	public static final String DMO_GET_ALL_HOD_BY_DEPT_POST_URL = "/303";
	public static final String DMO_GET_ALL_INSTITUTE_POST_URL = "/304";
	public static final String DMO_GET_ALL_DESIGNATION_POST_URL = "/305";
	public static final String DMO_GET_ALL_PURPOSE_POST_URL = "/306";
	public static final String DMO_GET_ALL_TREASURY_POST_URL = "/307";
	public static final String DMO_GET_ALL_FINANCIAL_POST_URL = "/308";
	public static final String URL_DMO_GRFCRF_REPORT = "/dmo/grfcrfreport";
	public static final String DMO_GRFCRF_INVEST_SALE_REPORT = "/investsalereport";
	public static final String DMO_GRFCRF_STATEMENT_REPORT = "/statementreport";
	public static final String DMO_GRFCRF_TOTAL_INVEST_REPORT = "/totalinvestreport";
	public static final String DMO_GRFCRF_YEAR_WISE_MATURITY_INVEST_REPORT = "/yrwisematurityinvestreport";

	public static final String URL_DMO_NSSF_REPORT = "dmoNssfReport";
	public static final String URL_DMO_NSSF_RECEIPT_REPORT = "/nssfReceipt";
	public static final String URL_DMO_NSSF_MONTHLY_RECEIPT_REPORT = "/nssfMonthlyReceipt";
	public static final String URL_DMO_NSSF_OUTSTANDING_REPORT = "/nssfOutstanding";
	public static final String URL_DMO_NSSF_REPAID_YEARLY_REPORT = "/nssfRepaidYearly";
	public static final String URL_DMO_NSSF_REPAID_MONTHLY_REPORT = "/nssfRepaidMonthly";
	public static final String URL_DMO_NSSF_REPAID_DATE_WISE_REPORT = "/nssfRepaidDateWise";
	public static final String URL_DMO_NSSF_REPORT_DTL = "/nssfDetails";
	public static final String URL_DMO_MARKET_REPORT_DTL = "/marketDetails";
	public static final String URL_DMO_REPORT = "dmoReport";

	public static final String URL_DMO_MARKET_REPORT = "dmoMarketReport";
	public static final String URL_DMO_MARKET_RECEIPT_REPORT = "/marketReceipt";
	public static final String URL_DMO_MARKET_MONTHLY_RECEIPT_REPORT = "/marketMonthlyReceipt";
	public static final String URL_DMO_MARKET_REPAID_YEARLY_REPORT = "/marketRepaidYearly";
	public static final String URL_DMO_MARKET_REPAID_MONTHLY_REPORT = "/marketRepaidMonthly";
	public static final String URL_DMO_MARKET_REPAID_DATE_WISE_REPORT = "/marketRepaidDateWise";
	
	public static final String URL_DMO_GOI_REPORT = "dmoGoiReport";
	public static final String URL_DMO_GOI_MINISTRY_REPORT = "/goiMinistry";
	public static final String URL_DMO_GOI_CENTRAL_REPORT = "/goiCentral";
	public static final String URL_DMO_GOI_SCHEME_WISE_CENTRAL_REPORT = "/goiSchemeWiseCentral";
	public static final String URL_DMO_GOI_SCHEME_WISE_CENTRAL_OUTSTANDING_YEARLY_REPORT = "/goiSchemeWiseCentralOutstandingYearly";

	public static final String URL_DMO_LOAN_REPAY_REPORT = "dmoLoanRepayReport";
	public static final String URL_DMO_LOAN_REPAY_SECH_REPORT = "/loanRepaySech";
	public static final String URL_DMO_LOAN_REPAY_DETAIL_REPORT = "/loanRepayDetail";
	
	public static final String DMO_TILL_DT_PROG_PRI_CONTRI_URL = "/progpricontri/301";
	public static final String DMO_DPSHEET_BASE_URL = "dmo/dpsheet";
	/** The Constant URL_DMO_GET_FINANCIAL_YEAR_BETWEEN_ID. */
	public static final String URL_DMO_GET_FINANCIAL_YEAR_BETWEEN_ID = "/getbetweenid/201";
	/**
	 * GET DP SHEET URL
	 */
	public static final String URL_GET_DPSHEET_DETAILS = "/3001";
	public static final String URL_GET_LATEST_DPSHEET = "/3002";
	public static final String URL_DEL_DPSHEET_DTL = "/1003";
	public static final String URL_POST_DPSHEET_SUBMIT = "/1001";
	public static final String URL_POST_SAVE_AS_DRAFT = "/1002";
	public static final String URL_POST_FY = "/fy/201";
	/**
	 * T14BILL
	 */
	public static final String URL_POST_DPSHEET_T14BILL_INVEST_SUBMIT = "/t14billinvest/1001";
	public static final String URL_POST_DPSHEET_T14BILL_MATURE_SUBMIT = "/t14billmature/1001";
	public static final String URL_POST_DPSHEET_T14BILL_REDISC_SUBMIT = "/t14billredisc/1001";
	/**
	 * T91BILL
	 */
	public static final String URL_POST_DPSHEET_T91BILL_INVEST_SUBMIT = "/t91billinvest/1001";
	public static final String URL_POST_DPSHEET_T91BILL_MATURE_SUBMIT = "/t91billmature/1001";
	public static final String URL_POST_DPSHEET_T91BILL_REDISC_SUBMIT = "/t91billredisc/1001";
	/**
	 * WMA
	 */
	public static final String URL_POST_DPSHEET_WMA_ADV_SUBMIT = "/wmaadv/1001";
	public static final String URL_POST_DPSHEET_WMA_INTRST_SUBMIT = "/wmaintrst/1001";
	public static final String URL_POST_DPSHEET_WMA_PRINCIPAL_SUBMIT = "/wmaprincipal/1001";
	public static final String URL_ALL_ACTIVE_TRANSACTION_TYPES = "/303";
	/**
	 * 
	 */
	public static final String DMO_DPSHEET_LIST_BASE_URL = "dmo/dpsheetlist";
	public static final String URL_POST_DPSHEET_SEARCH = "/3003";

}
