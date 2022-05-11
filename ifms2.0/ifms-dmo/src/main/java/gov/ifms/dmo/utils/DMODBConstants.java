package gov.ifms.dmo.utils;

import java.util.LinkedHashMap;
import java.util.Map;



public class DMODBConstants {
	
	/**
	 * The Constant FY.
	 */
	private static final String FY = "fy";

	/**
	 * The Constant TRAN_TYPE_ID.
	 */
	private static final String TRAN_TYPE_ID = "tranTypeId";

	/**
	 * The Constant ADVICE_NO.
	 */
	private static final String ADVISE_NO = "AdviseNo";

	/**
	 * The Constant IN_ADVISE_DATE.
	 */
	private static final String ADVISE_DATE = "AdviseDate";

	/**
	 * The Constant IN_ADVISE_BY.
	 */
	private static final String ADVISE_BY = "AdviseBy";

	/**
	 * The Constant IN_CM_DATE.
	 */
	private static final String CM_DATE = "cmdate";

	/**
	 * The Constant IN_CM_NO.
	 */
	private static final String CM_NO = "cmNO";
	
	/**
	 * The Constant IN_CM_MONTH.
	 */
	private static final String CM_MONTH = "cmMonth";

	/**
	 * The Constant IN_ACCOUNT_MONTH.
	 */
	private static final String ACCOUNT_MONTH = "accountMonth";
	
	/**
	 * The Constant IN_AMOUNT_TYPE_ID.
	 */
	private static final String ACCOUNT_TYPE_ID = "accountType";
	
	/**
	 * The Constant FY.
	 */
	private static final String IN_FY = "IN_FY";

	/**
	 * The Constant TRAN_TYPE_ID.
	 */
	private static final String IN_TRAN_TYPE_ID = "IN_TRN_TYPE_ID";

	/**
	 * The Constant ADVICE_NO.
	 */
	private static final String IN_ADVISE_NO = "IN_ADVISE_NO";

	/**
	 * The Constant IN_ADVISE_DATE.
	 */
	private static final String IN_ADVISE_DATE = "IN_ADVISE_DATE";

	/**
	 * The Constant IN_ADVISE_BY.
	 */
	private static final String IN_ADVISE_BY = "IN_ADVISE_BY";


	/**
	 * The Constant IN_CM_DATE.
	 */
	private static final String IN_CM_DATE = "IN_CM_DATE";

	/**
	 * The Constant IN_CM_NO.
	 */
	private static final String IN_CM_NO = "IN_CM_NO";
	
	/**
	 * The Constant IN_CM_MONTH.
	 */
	private static final String IN_CM_MONTH = "IN_CM_MONTH";

	/**
	 * The Constant IN_ACCOUNT_MONTH.
	 */
	private static final String IN_ACCOUNT_MONTH = "IN_ACCOUNT_MONTH";
	
	/**
	 * The Constant IN_AMOUNT_TYPE_ID.
	 */
	private static final String IN_AMOUNT_TYPE_ID = "IN_AMOUNT_TYPE_ID";
	
	/**
	 * The Constant IN_PAGE_INDEX.
	 */
	private static final String IN_PAGE_INDEX = "IN_PAGE_INDEX";
	
	/**
	 * The Constant IN_PAGE_SIZE.
	 */
	private static final String IN_PAGE_SIZE = "IN_PAGE_SIZE";
	
	/**
	 * The Constant IN_PAGE_INDEX.
	 */
	private static final String PAGE_INDEX = "PAGE_INDEX";
	
	/**
	 * The Constant IN_PAGE_SIZE.
	 */
	public static final String SP_LOAN_REPAYMENT_REPORT = "SP_LOAN_REPAYMENT_REPORT";
	public static final String SP_LOAN_REPAYMENT_SCHEDULE_REPORT = "SP_LOAN_REPAYMENT_SCHEDULE_REPORT";
	public static final String SP_GOI_MINISTRY_WISE_LOAN_REPORT = "SP_GOI_MINISTRY_WISE_LOAN_REPORT";
	public static final String SP_GOI_CENTRAL_LOAN_REPORT = "SP_GOI_CENTRAL_LOAN_REPORT";
	public static final String SP_GOI_SCHEME_WISE_REPORT = "SP_GOI_SCHEME_WISE_REPORT";
	public static final String SP_MARKET_LOAN_RECEIPT_REPORT = "SP_MARKET_LOAN_RECEIPT_REPORT";
	public static final String SP_MARKET_LOAN_MONTHLY_REPORT = "SP_MARKET_LOAN_MONTHLY_REPORT";
	public static final String SP_MARKET_REPAID_YEARLY_REPORT = "SP_MARKET_REPAID_YEARLY_REPORT";
	public static final String SP_MARKET_REPAID_MONTHLY_REPORT = "SP_MARKET_REPAID_MONTHLY_REPORT";
	public static final String SP_MARKET_REPAID_DATE_WISE_REPORT = "SP_MARKET_REPAID_DATE_WISE_REPORT";
	public static final String SP_NSSF_LOAN_RECEIPT_REPORT = "SP_NSSF_LOAN_RECEIPT_REPORT";
	public static final String SP_NSSF_LOAN_MONTHLY_REPORT = "SP_NSSF_LOAN_MONTHLY_REPORT";
	public static final String SP_NSSF_TOTAL_OUTSTANDING_REPORT = "SP_NSSF_TOTAL_OUTSTANDING_REPORT";
	public static final String SP_NSSF_REPAID_YEARLY_REPORT = "SP_NSSF_REPAID_YEARLY_REPORT";
	public static final String SP_NSSF_REPAID_MONTHLY_REPORT = "SP_NSSF_REPAID_MONTHLY_REPORT";
	public static final String SP_NSSF_REPAID_DATE_WISE_REPORT = "SP_NSSF_REPAID_DATE_WISE_REPORT";
	public static final String PAGE_SIZE = "PAGE_SIZE";
	public static final String IN_FROM_DT = "IN_FROM_DT";
	public static final String IN_TO_DT = "IN_TO_DT";
	public static final String LOAN_ROI = "LOAN_ROI";
	public static final String LOAN_TENURE = "LOAN_TENURE";
	public static final String LOAN_AMOUNT = "LOAN_AMOUNT";
	public static final String SANCTION_NO = "SANCTION_NO";
	public static final String SP_NSSF_OUTSTANDING_YEARLY_REPORT = "SP_NSSF_OUTSTANDING_YEARLY_REPORT";
	public static final String SP_NSSF_OUTSTANDING_MONTHLY_REPORT = "SP_NSSF_OUTSTANDING_MONTHLY_REPORT";
	public static final String SP_NSSF_OUTSTANDING_DATE_WISE_REPORT = "SP_NSSF_OUTSTANDING_DATE_WISE_REPORT";
	public static final String SP_MARKET_OUTSTANDING_YEARLY_REPORT = "SP_MARKET_OUTSTANDING_YEARLY_REPORT";
	public static final String SP_MARKET_OUTSTANDING_MONTHLY_REPORT = "SP_MARKET_OUTSTANDING_MONTHLY_REPORT";
	public static final String SP_MARKET_OUTSTANDING_DATE_WISE_REPORT = "SP_MARKET_OUTSTANDING_DATE_WISE_REPORT";
	public static final String SP_GOI_OUTSTANDING_YEARLY_REPORT = "SP_GOI_OUTSTANDING_YEARLY_REPORT";
	

	/**
	 * The DP Sheet listing.
	 */
	private static Map<String, String> dmoDPSheetListing = new LinkedHashMap<>(10);
	
	/**
	 * Gets the loc open req listing.
	 *
	 * @return the loc open req listing
	 */
	public static Map<String, String> getDPSheetListing() {
		return dmoDPSheetListing;
	}

	
	static {
		dmoDPSheetListing.put(DMODBConstants.PAGE_INDEX, DMODBConstants.IN_PAGE_INDEX);
		dmoDPSheetListing.put(DMODBConstants.PAGE_SIZE, DMODBConstants.IN_PAGE_SIZE);
		dmoDPSheetListing.put(DMODBConstants.FY, DMODBConstants.IN_FY);
		dmoDPSheetListing.put(DMODBConstants.TRAN_TYPE_ID, DMODBConstants.IN_TRAN_TYPE_ID);
		dmoDPSheetListing.put(DMODBConstants.ADVISE_NO, DMODBConstants.IN_ADVISE_NO);
		dmoDPSheetListing.put(DMODBConstants.ADVISE_DATE, DMODBConstants.IN_ADVISE_DATE);
		dmoDPSheetListing.put(DMODBConstants.ADVISE_BY, DMODBConstants.IN_ADVISE_BY);
		dmoDPSheetListing.put(DMODBConstants.CM_DATE, DMODBConstants.IN_CM_DATE);
		dmoDPSheetListing.put(DMODBConstants.CM_NO, DMODBConstants.IN_CM_NO);
		dmoDPSheetListing.put(DMODBConstants.CM_MONTH, DMODBConstants.IN_CM_MONTH);
		dmoDPSheetListing.put(DMODBConstants.ACCOUNT_MONTH, DMODBConstants.IN_ACCOUNT_MONTH);
		dmoDPSheetListing.put(DMODBConstants.ACCOUNT_TYPE_ID, DMODBConstants.IN_AMOUNT_TYPE_ID);
	}
}
