package gov.ifms.loc.util;

import gov.ifms.common.util.MessageUtil;

/**
 * The Class LocMessageConstant.
 */
public class LocMessageConstant {

	/**
	 * Instantiates a new msg constant.
	 */
	private LocMessageConstant() {
		super();
	}

	/**
	 * The Constant LOC_MSG_FETCH.
	 */
	public static final String LOC_MSG_FETCH = MessageUtil.getMsg("LOC.FETCH");

	/**
	 * The Constant BUDGET_MSG_CREATE.
	 */
	public static final String LOC_MSG_CREATE = MessageUtil.getMsg("LOC.CREATE");

	/**
	 * The Constant LOC_MSG_UPDATE.
	 */
	public static final String LOC_MSG_UPDATE = MessageUtil.getMsg("LOC.UPDATE");

	/**
	 * The Constant LOC_MSG_DELETE.
	 */
	public static final String LOC_MSG_DELETE = MessageUtil.getMsg("LOC.DELETE");

	/** The Constant LOC_UNDER_TRANSACTION. */
	public static final String LOC_UNDER_TRANSACTION = MessageUtil.getMsg("LOC.UNDER_TRANSACTION");

	/** The Constant LOC_CHEQUEBOOK_UNDER_TRANSACTION. */
	public static final String LOC_CHEQUEBOOK_UNDER_TRANSACTION = MessageUtil.getMsg("LOC.CHEQUE_SERIES_USED");

	/** The Constant LOC_MISSING_CHEQUEBOOK_AUTH. */
	public static final String LOC_MISSING_CHEQUEBOOK_AUTH = MessageUtil.getMsg("LOC.CHQ_AUTH_ERROR");

	/** The Constant LOC_MISSING_CHEQUEBOOK_CHQ_PROCESSED. */
	public static final String LOC_MISSING_CHEQUEBOOK_CHQ_PROCESSED = MessageUtil
			.getMsg("LOC.CHQ_MISSING_ALREADY_EXIST");

	/** The Constant LOC. */
	public static final String LOC_CHQ_CNCL_ALREADY_EXIST = MessageUtil.getMsg("LOC.CHQ_CNCL_ALREADY_EXIST");

	/** The Constant LOC_ADVICE_REQUEST_BEING_PROCESSED. */
	public static final String LOC_ADVICE_REQUEST_BEING_PROCESSED = MessageUtil
			.getMsg("LOC.ADVICE_REQUEST_ALREADY_EXISTS");

	/** The Constant LOC_ADVICE_FROM_DT. */
	public static final String LOC_ADVICE_FROM_DT = MessageUtil.getMsg("LOC.FROM.DATE.VALIDATON");
	/** The Constant LOC_ADVICE_TO_DT. */
	public static final String LOC_ADVICE_TO_DT = MessageUtil.getMsg("LOC.TO.DATE.VALIDATON");

	/** The Constant LOC_ADVICE_AMOUNT. */
	public static final String LOC_ADVICE_AMOUNT = MessageUtil.getMsg("LOC.AMOUNT.VALIDATON");

	/** The Constant LOC_DATE_VALIDATION. */
	public static final String LOC_CURRENT_DT_VALIDATION = MessageUtil.getMsg("LOC.DATE.VALIDATON");
	/** The Constant LOC_CHQ_CANCL_AMNT. */
	public static final String LOC_CHQ_CANCL_AMNT = MessageUtil.getMsg("LOC.CHQ_CANCL_AMNT_VALIDATION");

	/** The Constant LOC_CHQ_AMNT_VALIDATION. */
	public static final String LOC_CHQ_2_CHQ_VALIDATION = MessageUtil.getMsg("LOC.LOC_CHQ_2_CHQ_VALIDATION");

	/** The Constant LOC_CHEQUEBOOK_ONGOING_LOWER_CHEQUE_SERIES. */
	public static final String LOC_CHEQUEBOOK_ONGOING_LOWER_CHEQUE_SERIES = MessageUtil
			.getMsg("LOC.CHEQUEBOOK_ONGOING_LOWER_CHEQUE_SERIES");

	/** The Constant LOC_CHEQUE_INACTIVATION_IN_PROGRESS. */
	public static final String LOC_CHEQUE_INACTIVATION_IN_PROGRESS = MessageUtil
			.getMsg("LOC.CHEQUE_INACTIVATION_IN_PROGRESS");
}
