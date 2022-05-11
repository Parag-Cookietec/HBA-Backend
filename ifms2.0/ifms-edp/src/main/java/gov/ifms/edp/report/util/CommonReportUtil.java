package gov.ifms.edp.report.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.util.EDPReportConstant;

/**
 * The Class CommonReportUtil.
 */
public class CommonReportUtil {

	/**
	 * Instantiates a new common report util.
	 */
	private CommonReportUtil() {
		super();
	}

	/**
	 * Convert object to string.
	 *
	 * @param obj the obj
	 * @return the string
	 */
	public static String convertObjectToString(Object obj) {
		try {
			if (obj == null || String.valueOf(obj).isEmpty())
				return "";
			else {
				return String.valueOf(obj);
			}
		} catch (Exception ex) {
			return "";
		}
	}
	
	/**
	 * Gets the report file name.
	 *
	 * @param reportName the report name
	 * @param fileType the file type
	 * @return the report file name
	 */
	public static String getReportFileName(String reportName,String fileType) {
		LocalDateTime today=LocalDateTime.now();
		DateTimeFormatter formatTimeNow=DateTimeFormatter.ofPattern(CommonReportConstant.DD_MM_YYYY_WITH_DASH); 
		reportName = reportName.replace(Constant.SINGLE_SPACE, CommonReportConstant.UNDERSCORE);
		return reportName + CommonReportConstant.UNDERSCORE +  today.format(formatTimeNow) + fileType ;
	}
	
	/**
	 * Convert byte to base 64 string.
	 *
	 * @param bs the bs
	 * @return the string
	 */
	public static String convertByteToBase64String(byte[] bs) {
		return Base64.getEncoder().encodeToString(bs);
	}
	
	/**
	 * Gets the user name for common report.
	 *
	 * @return the user name for common report
	 */
	public static String getUserNameForCommonReport() {
		return OAuthUtility.getCurrentUserUserName() + EDPReportConstant.REPORT_STRING_COMA_WITH_END_SPACE 
				+ OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostName() + EDPReportConstant.REPORT_STRING_COMA_WITH_END_SPACE  
				+ OAuthUtility.getCurrentUserLoginPostFromOauthToken().getOauthTokenPostDTO().getEdpMsDesignationDto().getDesignationName();
	}
}
