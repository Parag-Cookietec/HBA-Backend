package gov.ifms.common.constant;

/**
 * The Class CommonConstant.
 */
public class CommonConstant implements IEDPConstant, IPVUConstant {

	CommonConstant() {
	}

	/** The Constant AUTHORIZATION. */
	public static final String AUTHORIZATION = "Authorization";

	/** The Constant UTF_8. */
	public static final String UTF_8 = "UTF-8";

	public static final String CLASSPATH = "classpath:/";
	
	/** The Constant CLASSPATH_MESSAGES_LBL. */
	public static final String CLASSPATH_MESSAGES_LBL = CLASSPATH + "messages/lbl";

	/** The Constant CLASSPATH_CONFIG_COMMONCONFIG. */
	public static final String CLASSPATH_CONFIG_COMMONCONFIG = CLASSPATH +"config/commonconfig";
	
	public static final String CLASSPATH_CONFIG_EMAIL = CLASSPATH +"config/email";

	/** The Constant HEADER. */
	public static final String HEADER = "header";

	/** The Constant ACCESS_EVERYTHING. */
	public static final String ACCESS_EVERYTHING = "accessEverything";

	/** The Constant GLOBAL. */
	public static final String GLOBAL = "global";

	/** The Constant SCOPE_SEPARATOR. */
	public static final String SCOPE_SEPARATOR = ",";

	/** The Constant IFMS. */
	public static final String IFMS = "IFMS";
	
	/** The Constant WORKFLOW_ATTACH_CAT_ID. */
	public static final long WORKFLOW_ATTACH_CAT_ID = 502;

	/** The Constant COMMON_WF_API_V10. */
	public static final String COMMON_WF_API_V10 = "common-wf-api-v1.0";

	/** The Constant COMMON_WF_API_V20. */
	public static final String COMMON_WF_API_V20 = "common-wf-api-v2.0";

	/** The Constant COMMON_WF_API_V30. */
	public static final String COMMON_WF_API_V30 = "common-wf-api-v3.0";

	/** The Constant V10. */
	public static final String V10 = "v1.0";

	/** The Constant V20. */
	public static final String V20 = "v2.0";

	/** The Constant V20. */
	public static final String V30 = "v3.0";
	
	/** The Constant CLASSPATH_MESSAGES_LBL. */
	public static final String CLASSPATH_MESSAGES_RECEIPT = CLASSPATH + "messages/receipt";

	public static final String SP_NOTIFICATION_COMMON = "MASTER_V1.SP_NOTIFICATION_COMMON";

	public static final String SP_NOTI_LIST = "MASTER_V1.SP_NOTI_LIST";

	public static final String CLASSPATH_MESSAGES_ERA = CLASSPATH + "messages/msg-era";
	
	/** The Constant CLASSPATH_MESSAGES_PVU. */
	public static final String CLASSPATH_MESSAGES_PVU = CLASSPATH + "messages/pvu";
	
	/** The Constant JPG. */
	public static final String JPG = "jpg";
	
	/** The Constant JPEG. */
	public static final String JPEG = "jpeg";
	
	/** The Constant COMMON_DMO_API_V10. */
	public static final String COMMON_DMO_API_V10 = "common-dmo-api-v1.0";
}
