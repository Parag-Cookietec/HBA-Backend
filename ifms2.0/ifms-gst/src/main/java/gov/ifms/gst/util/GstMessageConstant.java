package gov.ifms.gst.util;

import gov.ifms.common.util.MessageUtil;

/**
 * The Class LocMessageConstant.
 */
public class GstMessageConstant {

	/**
	 * Instantiates a new msg constant.
	 */
	private GstMessageConstant() {
		super();
	}


	/**
	 * The Constant GST_MSG_FETCH.
	 */
	public static final String GST_MSG_FETCH = MessageUtil.getMsg("GST.FETCH");
	/**
	 * The Constant GST_MSG_CREATE.
	 */
	public static final String GST_MSG_CREATE = MessageUtil.getMsg("GST.CREATE");

	/**
	 * The Constant GST_MSG_UPDATE.
	 */
	public static final String GST_MSG_UPDATE = MessageUtil.getMsg("GST.UPDATE");

	/**
	 * The Constant GST_MSG_DELETE.
	 */
	public static final String GST_MSG_DELETE = MessageUtil.getMsg("GST.DELETE");
	
	/**
	 * The Constant GST_MSG_DELETE.
	 */
	public static final String GST_MSG_FETCH_LIST = MessageUtil.getMsg("GST.FETCH_LIST");


}
