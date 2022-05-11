package gov.ifms.pvu.util;

import gov.ifms.common.util.MessageUtil;

public class PvuMsgConstant {
	
	/**
	 * Instantiates a new msg constant.
	 */
	private PvuMsgConstant() {
		super();
	}

	/** The Constant EDP_MSG_FETCH_LIST. */
	public static final String ERROR_MSG_NOT_ALLOWED_BACKDATED_EVENTS = MessageUtil.getMsg("error.msg.not.allowed.backdated.events");
	
	/** The Constant ERROR_MSG_EFF_DATE_NOT_NULL. */
	public static final String ERROR_MSG_EFF_DATE_NOT_NULL = MessageUtil.getMsg("error.msg.eff.date.not.null");
	
	/** The Constant ERROR_MSG_ALLOW_REGULAR_HPS. */
	public static final String ERROR_MSG_ALLOW_REGULAR_HPS = MessageUtil.getMsg("error.msg.allow.only.regular.hps");
	
	/** The Constant ERROR_MSG_EXAM_MANDATORY. */
	public static final String ERROR_MSG_EXAM_MANDATORY = MessageUtil.getMsg("error.msg.ccc.exam.madatory");
		
	/** The Constant ERROR_MSG_EXAM_MANDATORY_TIKU_PAY. */
	public static final String ERROR_MSG_EXAM_MANDATORY_TIKU_PAY = MessageUtil.getMsg("error.msg.ccc.exam.madatory.tiku.pay");
	
	/** The Constant ERROR_MSG_SELECT_FIX_PAY_EMP. */
	public static final String ERROR_MSG_SELECT_FIX_PAY_EMP = MessageUtil.getMsg("error.msg.select.fix.pay.emp");
}
