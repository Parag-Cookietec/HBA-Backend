package gov.ifms.gst.util;

import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.gst.workflow.dto.WfUserReqSDDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * The Class EDPUtility.
 */
public class GSTUtility {



	/**
	 * Instantiates a new EDP utility.
	 */
	private GSTUtility() {
	}

	public static Double roundUpDoubleValue(Double input) {
		return new BigDecimal(input).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	public static LocalDate convertStringToLocalDate(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
		return LocalDate.parse(value, formatter);
	}

	public static Date convertStringToDate(String value) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static WfUserReqSDDto getWfUserReqSDDto(long menuId, long trnId) {
		WfUserReqSDDto dto = new WfUserReqSDDto();
		dto.setMenuId(menuId);
		dto.setTrnId(trnId);
		dto.setUserId(OAuthUtility.getCurrentUserUserId());
		dto.setPostId(OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		dto.setOfficeId(OAuthUtility.getCurrentUserLoginPostFromOauthToken().getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeId());
		dto.setPouId(OAuthUtility.getCurrentUserLkPOUId());
		return dto;
	}

}
