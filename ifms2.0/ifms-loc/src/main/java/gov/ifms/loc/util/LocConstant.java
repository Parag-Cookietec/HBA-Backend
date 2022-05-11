package gov.ifms.loc.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Class LocConstant.
 */
public class LocConstant {

	/**
	 * Instantiates a new loc constant.
	 */
	public LocConstant() {
		super();
	}

	/**
	 * The Constant LOC_SCHEMA.
	 */
	public static final String LOC_SCHEMA = "LOC";

	/**
	 * The Constant MASTER_SCHEMA.
	 */
	public static final String MASTER_SCHEMA = "MASTER_V1";

	/**
	 * The Constant Long.
	 */
	public static final Long PURP_DEMAND_ID = 109L;

	/**
	 * The Constant Long.
	 */
	public static final String PURP_MAJORHEAD_CODE = "8000";

	/**
	 * The rec est history search param.
	 */
	private static Map<String, String> openReqHisSearchParam = new LinkedHashMap<>(3);

	/**
	 * The Constant SUBMIT.
	 */
	public static final String SUBMIT = "267";
	/**
	 * The Constant DOT.
	 */
	public static final String DOT = ".";

	/**
	 * The Constant PENDING.
	 */
	public static final String PENDING = "Pending";

	/**
	 * The Constant ENTRY_TYPE_LOOKUP.
	 */
	public static final Long ENTRY_TYPE_LOOKUP = 214L;

	/**
	 * The Constant HDR_ID.
	 */
	public static final String HDR_ID = "hdrId";

	/**
	 * The Constant IN_LC_HDR_ID.
	 */
	public static final String IN_LC_HDR_ID = "IN_LC_HDR_ID";

	/**
	 * The Constant IN_IS_EDITABLE.
	 */
	public static final String IN_IS_EDITABLE = "IN_IS_EDITABLE";

	/**
	 * The Constant IN_STATUS_ID.
	 */
	public static final String IN_STATUS_ID = "IN_STATUS_ID";

	/**
	 * The Constant IN_OFFICE_STATUS.
	 */
	public static final String IN_OFFICE_STATUS = "IN_OFFICE_STATUS";

	/**
	 * The Constant OTHERE_CIRCLE.
	 */
	public static final String OTHERE_CIRCLE = "Loc Circle";

	/**
	 * The Constant REQUEST_TYPE_ID.
	 */
	public static final Long REQUEST_TYPE_ID = 266L;

	/**
	 * The Constant CHEQUE_TYPE_ID.
	 */
	public static final Long CHEQUE_TYPE_ID = 331L;

	/**
	 * The Constant REQUEST_TYPE_ACTIVATE.
	 */
	public static final Long REQUEST_TYPE_ACTIVATE = 1260L;

	/**
	 * The Constant REQUEST_TYPE_INACTIVATE.
	 */
	public static final Long REQUEST_TYPE_INACTIVATE = 1261L;

	/**
	 * The Constant CHQ_IS_ACTIVE.
	 */
	public static final String CHQ_IS_ACTIVE = "Y";

	/**
	 * The Constant CHQ_IS_INACTIVE.
	 */
	public static final String CHQ_IS_INACTIVE = "N";

	/**
	 * The Constant VIEW_ACTION.
	 */
	public static final Integer VIEW_ACTION = 0;

	/**
	 * The Constant EDIT_ACTION.
	 */
	public static final Integer EDIT_ACTION = 1;

	/**
	 * The Constant LONG_ZERO.
	 */
	public static final Long LONG_ZERO = 0L;

	/**
	 * The Constant LONG_ONE.
	 */
	public static final Long LONG_ONE = 1L;

	/**
	 * The Constant AUTHORIZED.
	 */
	public static final String AUTHORIZED = "Authorized";

	/**
	 * The Constant DIVSION_SUB_TYPE.
	 */
	// Division Sub_type_id
	public static final Long DIVSION_SUB_TYPE = (long) 21;

	/**
	 * The Constant LU_APPROVED_LOOKUP_INFO_ID.
	 */
	public static final short LU_APPROVED_LOOKUP_INFO_ID = 327;

	/**
	 * The Constant TRN_SCREEN.
	 */
	public static final String TRN_SCREEN = "DIS";

	/**
	 * The Constant TRN_SCREEN.
	 */
	public static final String TRN_SCREEN_CLR = "CLR";

	/**
	 * The Constant LOC_CIRCLE_OTHERS.
	 */
	public static final Long LOC_CIRCLE_OTHERS = 330L;

	/**
	 * The Constant CHEQUE_TYPE_LIST_PARENT_ID.
	 */
	public static final Long LOC_PARENT_CHEQUE_TYPE = 216L;

	/**
	 * The Constant PUBLIC_ACCOUNT.
	 */

	public static final String PUBLIC_ACCOUNT = "Public Account";

	/**
	 * The Constant FUND_TYPE_PARENT_LOOK_UP_ID.
	 */
	public static final Long FUND_TYPE_PARENT_LOOK_UP_ID = 298l;

	/**
	 * The Constant CHARGED_VOTED_PARENT_LOOK_UP_ID.
	 */
	public static final Long CHARGED_VOTED_PARENT_LOOK_UP_ID = 68l;

	/**
	 * The Constant BUDGET_TYPE_PARENT_LOOK_UP_ID.
	 */
	public static final Long BUDGET_TYPE_PARENT_LOOK_UP_ID = 146l;

	/**
	 * The Constant ESTIMATE_TYPE_PARENT_LOOK_UP_ID.
	 */
	public static final Long ESTIMATE_TYPE_PARENT_LOOK_UP_ID = 97l;

	/**
	 * The Constant LOC_CHQ_TYPE_EMPLOYEE.
	 */
	public static final Long LOC_CHQ_TYPE_EMPLOYEE = 1740L;

	/**
	 * The Constant LOC_DESIGNATION_ID.
	 */
	public static final Long LOC_DESIGNATION_ID = 58L;

	/** The Constant VALID_WF_ACTION_ID. */
	public static final int VALID_WF_ACTION_ID = 1;

	/**
	 * Gets the open req his search param.
	 *
	 * @return the openReqHisSearchParam
	 */
	public static Map<String, String> getOpenReqHisSearchParam() {
		return openReqHisSearchParam;
	}

	static {
		openReqHisSearchParam.put(LocConstant.HDR_ID, LocConstant.IN_LC_HDR_ID);
	}

	/**
	 * The Constant MENUID_OPEN_REQUEST.
	 */
	public static final String MENUID_OPEN_REQUEST = "367";

	/**
	 * The Constant MENUID_ADVICE_PRE.
	 */
	public static final String MENUID_ADVICE_PRE = "371";

	/**
	 * The Constant MENUID_ADVICE_PRE_LIST.
	 */
	public static final String MENUID_ADVICE_PRE_LIST = "372";

	/**
	 * The Constant DIVISION_CHECK.
	 */
	public static final String DIVISION_CHECK = "DIVISONCHECK";

	/**
	 * The Constant P_LOC_TRN_NO_GEN.
	 */
	public static final String P_LOC_TRN_NO_GEN = "P_LOC_TRN_NO_GEN";

	/**
	 * The Constant CC_LABEL.
	 */
	public static final String CC_LABEL = "CC";

	/**
	 * The Constant IN_CARDEX_NO.
	 */
	public static final String IN_CARDEX_NO = "IN_CARDEX_NO";

	/** The Constant MENUID_ACCOUNT_CLOSING. */
	public static final String MENUID_ACCOUNT_CLOSING = "661";

	/** The Constant MENUID_ACCOUNT_CLOSING_LIST. */
	public static final String MENUID_ACCOUNT_CLOSING_LIST = "662";

	/** The Constant MENUID_ACCOUNT_OPEN_LIST. */
	public static final String MENUID_ACCOUNT_OPEN_LIST = "368";

	/** The Constant MENUID_ACCOUNT_OPEN. */
	public static final String MENUID_ACCOUNT_OPEN = "367";

	/** The Constant MENUID_CHQ_ACT_INACT. */
	public static final String MENUID_CHQ_ACT_INACT = "369";

	/** The Constant MENUID_CHQ_ACT_INACT_LIST. */
	public static final String MENUID_CHQ_ACT_INACT_LIST = "370";

	/** The Constant MENUID_DISTRIBUTION. */
	public static final String MENUID_DISTRIBUTION = "659";

	/** The Constant MENUID_DISTRIBUTION_LIST. */
	public static final String MENUID_DISTRIBUTION_LIST = "659";

	/** The Constant MENUID_CHQ_CANCEL. */
	public static final String MENUID_CHQ_CANCEL = "666";

	/** The Constant MENUID_CHQ_CANCEL_LIST. */
	public static final String MENUID_CHQ_CANCEL_LIST = "667";

	/** The Constant MENUID_INWARD_ADVICE_LIST. */
	public static final String MENUID_INWARD_ADVICE_LIST = "373";

	/** The Constant MENUID_CARDEX_VERIFICATION_LIST. */
	public static final String MENUID_CARDEX_VERIFICATION_LIST = "375";

	/** The Constant MENUID_ADVICE_VERFYLIST. */
	public static final String MENUID_ADVICE_VERFYLIST = "376";

	/** The Constant MENUID_ADVICE_AUTHO_LIST. */
	public static final String MENUID_ADVICE_AUTHO_LIST = "377";

	/** The Constant MENUID_CHEQUE_TO_CHEQUE. */
	public static final String MENUID_CHEQUE_TO_CHEQUE = "664";

	/** The Constant MENUID_CHEQUE_TO_CHEQUE_LIST. */
	public static final String MENUID_CHEQUE_TO_CHEQUE_LIST = "665";

	/** The Constant ADVICE_PDF_FILE_NAME. */
	public static final String ADVICE_PDF_FILE_NAME = "lcAdviceStatement_";

	/** The Constant EMPTY_STRING. */
	public static final String EMPTY_STRING = "";

	/** The Constant EPAY_TYPE. */
	public static final String EPAY_TYPE = "943";

	/** The Constant CHQ_TYPE. */
	public static final String CHQ_TYPE = "944";

	/** The Constant FORMB_PDF_FILE_NAME. */
	public static final String FORMB_PDF_FILE_NAME = "FormB_";

	/** The Constant AUTH_LETTER_PDF_FILE_NAME. */
	public static final String AUTH_LETTER_PDF_FILE_NAME = "authLetter_";
	/** The Constant WORK_FLOW. */
	public static final String WORK_FLOW = "WORK_FLOW";

	/** The Constant LC_NUMBER. */
	public static final String LC_NUMBER = null;

	/** The Constant DIV_CODE. */
	public static final String DIV_CODE = null;

	/** The Constant CIRCLE_CODE. */
	public static final int CIRCLE_CODE = 0;

	/** The Constant TRESURY_OFFICE. */
	public static final int TRESURY_OFFICE = 0;

	/** The Constant LC_DATE. */
	public static final String LC_DATE = null;

	/** The Constant LC_AMOUNT. */
	public static final int LC_AMOUNT = 0;

	/** The Constant LC_TYPE. */
	public static final int LC_TYPE = 0;

	/** The Constant WORK_FLOW. */
	public static final Long APPROVED_ACTION = 8l;
	/** The Constant APPROVED_BY_DAT. */
	public static final String APPROVED_BY_DAT = "Authorized by DAT";

	/** The Constant FORMA_PDF_FILE_NAME. */
	public static final String FORMA_PDF_FILE_NAME = "FormA_";

	/** The Constant AUTH_LETTER_PDF_FILE_NAME. */
	public static final String ADVICE_LETTER_PDF_FILE_NAME = "adviceAuthLetter_";

	/** The Constant LOC_AUTHORIZED_ID. */
	public static final Long LOC_AUTHORIZED_ID = 1531L;

	/** The Constant CHQ_TYPE_LABLE. */
	public static final String CHQ_TYPE_LABLE = "IN_CHEQUE_TYPE";

	/** The Constant BANK_ACC_LABLE. */
	public static final String BANK_ACC_LABLE = "IN_BANK_ACCOUNT_NO";

	/** The Constant DIV_ID_LABLE. */
	public static final String DIV_ID_LABLE = "IN_DIVISION_ID";

	/** The Constant SP_LOC_CHQINV_ISSUED_CHQ_SERIES. */
	public static final String SP_LOC_CHQINV_ISSUED_CHQ_SERIES = "SP_LOC_CHQINV_ISSUED_CHQ_SERIES";

	/** The Constant ADVICE_NO. */
	public static final String ADVICE_NO = "Advice Number :";

	/** The Constant ADVICE_DATE. */
	public static final String ADVICE_DATE = "Advice Date :";

	/** The Constant ADVICE_AMOUNT. */
	public static final String ADVICE_AMOUNT = "Advice Amount :";

	/** The Constant PAYMENT_TYPE. */
	public static final String PAYMENT_TYPE = "Payment Type :";

	/** The Constant DIVISION_CODE. */
	public static final String DIVISION_CODE = "Division Code :";

	/** The Constant TO_OFFICE. */
	public static final String TO_OFFICE = "Treasury / Sub Treasury Office :";

	/** The Constant CIRCLE_CODE_LABLE. */
	public static final String CIRCLE_CODE_LABLE = "Circle Code :";

	/** The Constant DISTRICT_LABLE. */
	public static final String DISTRICT_LABLE = "District :";

	/** The Constant LC_TYPE_LABLE. */
	public static final String LC_TYPE_LABLE = "LC Type :";

	/** The Constant LC_AMOUNT_LABLE. */
	public static final String LC_AMOUNT_LABLE = "LC Amount (in Lacs) :";

	/** The Constant LC_DATE_LABLE. */
	public static final String LC_DATE_LABLE = "LC Issue Date :";

	/** The Constant LC_NUMBER_LABLE. */
	public static final String LC_NUMBER_LABLE = "LC Number :";
	/** The Constant CLOSE_ID. */
	public static final Long CLOSE_ID = 1819L;

	/** The Constant CANCELLED_STATUS. */
	public static final String CANCELLED_STATUS = "Cancelled";
	/** The Constant DOUBLE_ZERO. */
	public static final Double DOUBLE_ZERO = 0.0;

}
