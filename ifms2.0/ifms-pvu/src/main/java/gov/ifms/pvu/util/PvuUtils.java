package gov.ifms.pvu.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;

/**
 * The type Pvu utils.
 */
public class PvuUtils {


	public static boolean isTest;

	private PvuUtils() {
	}

	private static Logger logger = LoggerFactory.getLogger(PvuUtils.class.getName());

	/**
	 * The constant END_DATE.
	 */
	public static final String END_DATE = "IN_END_DATE";

	/**
	 * The constant END_DATE.
	 */
	public static final LocalTime LOCAL_TIME_MIN = LocalTime.MIN;
	public static final LocalTime LOCAL_TIME_MAX = LocalTime.MAX;

	/**
	 * The constant START_DATE.
	 */
	public static final String START_DATE = "IN_START_DATE";
	private static final String DATE_FORMAT_MM_DD_YYYY = "MM/dd/yyyy";// 2020-02-04
//    private static final String DATE_FORMAT_MM_DD_YYYY = "MM/dd/yyyy";// 2020-02-04

	private static final String DATE_FORMAT_DD_MM_YYYY = "dd/MM/yyyy";// 2020-02-04
	private static final String DATE_FORMAT_YYYY_MM_DD = "yyyy/MM/dd";// 2020-02-04
	private static final String DATE_FORMAT_DD_MMM_YYYY = "dd/MMM/yyyy";// 2020-02-04
	private static final String CHANGE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";// 2020-02-04
	private static final String DATE_FORMAT_DD_MMM_YYYY_HH_MM_SS_A = "dd-MMM-yyyy hh:mm:ss a";// 2020-02-04
	private static final String DATE_FORMAT_DD_MMM_YYYY1 = "dd-MMM-yyyy";// 2020-02-04
	public static final String DATE_FORMAT_DD_MM_YYYY1 = "dd-MM-yyyy";// 2020-02-04
	/**
	 * Has length boolean.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	public static boolean hasLength(long value) {
		return value > 0;
	}

	public static boolean hasLength(Long value) {
		return (value != null);
	}

	/**
	 * Validate boolean.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	public static boolean validate(long value) {
		if (!hasLength(value)) {
			throw new IllegalArgumentException(PvuConstant.ID_MISSING);
		}
		return true;
	}

	/**
	 * Validate notional dates boolean.
	 *
	 * @param fromDate the from date
	 * @param toDate   the to date
	 * @return the boolean
	 */
	public static boolean validateNotionalDates(Date fromDate, Date toDate) {
		if (!Utils.isEmpty(fromDate) && !Utils.isEmpty(toDate)) {
			return !(fromDate.after(new Date()) || toDate.after(new Date()));
		}
		return true;
	}

	/**
	 * Validate duration boolean.
	 *
	 * @param fromDate the from date
	 * @param toDate   the to date
	 * @param days     the days
	 * @return the boolean
	 */
	public static boolean validateDuration(Date fromDate, Date toDate, int days) {
		if (!Utils.isEmpty(fromDate) && !Utils.isEmpty(toDate)) {
			long diff = toDate.getTime() - fromDate.getTime();
			long countDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
			return (countDays == days);
		}
		return true;
	}

	/**
	 * Is empty boolean.
	 *
	 * @param str the str
	 * @return the boolean
	 */
	public static boolean isEmpty(Object str) {
		return (str == null || "".equals(str));
	}

	/**
	 * Gets date to string value.
	 *
	 * @param date the date
	 * @return the date to string value
	 */
	public static String getDateToStringValue(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(PvuConstant.DATE_FORMAT_YYYYMMDD);
			return date != null ? sdf.format(date) : null;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Convert local date to date date.
	 *
	 * @param localDate the local date
	 * @return the date
	 */
	public static Date convertLocalDateToDate(LocalDate localDate) {
		if (localDate != null) {
			// default time zone
			ZoneId defaultZoneId = ZoneId.systemDefault();

			// local date + atStartOfDay() + default time zone + toInstant() = Date
			return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		}
		return null;
	}

	/**
	 * Gets localDate to string.
	 *
	 * @param localDate the localDate
	 * @return the str in format MM/DD/YYYY
	 */
	public static String getStrOfLocalDateInMDY(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT_MM_DD_YYYY));
	}

	/**
	 * Gets localDate to string.
	 *
	 * @param localDate the localDate
	 * @return the str in format MM/DD/YYYY
	 */
	public static String getStrOfLocalDateInYMD(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT_YYYY_MM_DD));
	}

	/**
	 * Gets localDate to string.
	 *
	 * @param localDate the localDate
	 * @return the str in format MM/DD/YYYY
	 */
	public static String getStrOfLocalDateInDDMMMYYYY(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT_DD_MMM_YYYY));
	}

	public static String getStrOfLocalDateInDDMMYYYY(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT_DD_MM_YYYY));
	}

	/**
	 * Gets string the localDate value.
	 *
	 * @param localDate the localDate
	 * @return the str in format MM/DD/YYYY
	 */
	public static LocalDate getStrToLocalDate(String localDate) {
		if (localDate != null) {
			return LocalDate.parse(localDate, DateTimeFormatter.ofPattern(DATE_FORMAT_MM_DD_YYYY));
		}
		return null;
	}

	public static LocalDate getStrToLocalDateNew(String localDate) {
		return LocalDate.parse(localDate, DateTimeFormatter.ofPattern(DATE_FORMAT_DD_MM_YYYY));
	}

	/**
	 * Gets string the localDate value.
	 *
	 * @param date the date
	 * @return the str in format MM/DD/YYYY
	 */
	public static Date getStrToDate(String date) {
		return convertLocalDateToDate(LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT_MM_DD_YYYY)));
	}

	/**
	 * Gets string the localDate value.
	 *
	 * @param date the date
	 * @return the str in format MM/DD/YYYY
	 */
	public static LocalDate getDateFromStringYMD(String date) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT_YYYY_MM_DD));
	}

	/**
	 * Gets string the localDate value.
	 *
	 * @param localDate the localDate
	 * @return the str in format MM/DD/YYYY
	 */
	public static LocalDate convertLocalDate(Date localDate) {
		// Getting the default zone id
		ZoneId defaultZoneId = ZoneId.systemDefault();

		// Converting the date to Instant
		Instant instant = localDate.toInstant();

		// Converting the Date to LocalDate
		return instant.atZone(defaultZoneId).toLocalDate();
	}

	/**
	 * Validate days boolean.
	 *
	 * @param to           the to
	 * @param from         the from
	 * @param daysRequired the days required
	 * @return the boolean
	 */
	public static boolean validateDays(LocalDate from, LocalDate to, long daysRequired) {
		long days = calculateDays(from, to);
		return (days + 1) >= daysRequired;
	}

	/**
	 * Count days long.
	 *
	 * @param to   the to
	 * @param from the from
	 * @return the long
	 */
	public static long countDays(LocalDate to, LocalDate from) {
		return calculateDays(from, to) + 1;
	}

	/**
	 * Calculate days long.
	 *
	 * @param to   the to
	 * @param from the from
	 * @return the long
	 */
	public static long calculateDays(LocalDate from, LocalDate to) {
		return ChronoUnit.DAYS.between(from, to);
	}

	public static LocalDateTime startDay(LocalDate after) {
		return LocalDateTime.of(after, LOCAL_TIME_MIN);
	}

	/**
	 * Builds the page in map.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	public static Map<String, Object> buildPageInMap(PageDetails pageDetail, List<PVUSearchEnum> lstSearchEum) {
		IdDto idDto = new IdDto();
		idDto.setId(OAuthUtility.getCurrentUserUserId());
		List<IdDto> lst = new ArrayList<>();
		lst.add(idDto);

		StringBuilder stringBuilder = new StringBuilder();
		for (IdDto dto : lst) {
			stringBuilder.append((dto.getId().toString())).append(Constant.COMMA);
		}
		Map<String, String> collect = lstSearchEum.stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(stringBuilder, pageDetail, collect);
	}

	public static LocalDateTime endDay(LocalDate after) {
		return LocalDateTime.of(after, LOCAL_TIME_MAX);
	}

	public static String buildErrorMsg(Long payCommissionId) {
		String commission = null;
		if (payCommissionId.equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			commission = "5";
		} else if (payCommissionId.equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			commission = "6";
		} else if (payCommissionId.equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			commission = "7";
		} else if (payCommissionId.equals(PvuConstant.FOURTH_COMMISSION_ID)) {
			commission = "4";
		} else if (payCommissionId.equals(PvuConstant.THIRD_COMMISSION_ID)) {
			commission = "3";
		}
		if (commission != null) {
			return String.format(MsgConstant.PVU_EMPLOYEE_EVENT_DATE_COMMISSIONS, commission);
		} else {
			return null;
		}
	}

	public static boolean isFromToBeforeEquals(LocalDate from, LocalDate to) {
		return from.isBefore(to) || from.isEqual(to);
	}

	public static FieldError errorField(String objName, String field, String defaultMsg) {
		return new FieldError(objName, field, defaultMsg);
	}

	public static String buildCommissionName(Long payCommissionId) {
		String commission = null;
		if (payCommissionId.equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			commission = PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME;
		} else if (payCommissionId.equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			commission = PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME;
		} else if (payCommissionId.equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			commission = PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME;
		}
		return commission;
	}

	public static String buildRemarkType(Long wfRoleId) {
		String remarkType = "";
		if (wfRoleId == Constant.AUDITOR) {
			remarkType = Constant.AUDITOR_NAME;
		} else if (wfRoleId == Constant.APPROVER_CLASS_TWO) {
			remarkType = Constant.APPROVER_CLASS_TWO_NAME;
		} else if (wfRoleId == Constant.APPROVER_CLASS_ONE) {
			remarkType = Constant.APPROVER_CLASS_ONE_NAME;
		} else if (wfRoleId == Constant.PVU_VERIFIER) {
			remarkType = Constant.PVU_VERIFIER_NAME;
		}
		return remarkType;
	}

	public static String getDateToStringDMYFormatValue(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY);
			return date != null ? sdf.format(date) : "";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public static String getStrOfLocalDateInDMY(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT_DD_MM_YYYY));
	}

	public static String getDateToStringDMYFormatValue(String dateValue) {
		try {
			if(dateValue != null){
				DateFormat formatter = new SimpleDateFormat(CHANGE_FORMAT_YYYY_MM_DD);
				Date date = formatter.parse(dateValue);
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY);
				return date != null ? sdf.format(date) : "";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public static Date getStringToDate(String date) throws ParseException {
		return new SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY).parse(date);
	}

	public static String concatName(String... s) {
		String join = String.join(" ", s);
		String all = join.replace("0", "");
		return all.trim();
	}

	public static boolean compareToLocalDate(LocalDate currentDate, LocalDate oldDate) {
		return oldDate.isBefore(currentDate);
	}

	public static String getStrOfLocalDateTimeInDDMMYYYY(LocalDateTime localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT_DD_MM_YYYY));
	}

	public static boolean notNull(String value) {
		return (value != null);
	}

	public static boolean isBefter(Date eventDate, Date effectiveDate) {

		return eventDate.before(effectiveDate);
	}

	public static boolean isBefterOrEqual(Date eventDate, Date effectiveDate) {
		boolean b = false;
		b = (eventDate.before(effectiveDate) || eventDate.equals(effectiveDate));
		return b;
	}

	public static Date changeDateFormat(Date inputDate) throws ParseException {
		SimpleDateFormat sm = new SimpleDateFormat(PvuUtils.DATE_FORMAT_YYYY_MM_DD);
		String strDate = sm.format(inputDate);
		return sm.parse(strDate);
	}

	public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
		if (localDateTime != null) {
			return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		}
		return null;
	}
	
	public static LocalDate getDateFromStringYMDDiffFromat(String date) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(CHANGE_FORMAT_YYYY_MM_DD));
	}
	
	public static String getDateToStringDMYHMMSFormatValue(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DD_MMM_YYYY_HH_MM_SS_A);
			return date != null ? sdf.format(date) : "";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static String getDateToStringDMYFormatValueNew(String dateValue) {
		try {
			DateFormat formatter = new SimpleDateFormat(CHANGE_FORMAT_YYYY_MM_DD);
			Date date = formatter.parse(dateValue);
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DD_MMM_YYYY1);
			return date != null ? sdf.format(date) : "";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	/**
	 * Gets string the localDate value.
	 *
	 * @param date the date
	 * @return the str in format MM/DD/YYYY
	 */
	public static String getDateFromStringYYYYMMDD(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT_DD_MMM_YYYY));
	}

	public static Date getDateFromStringWithFormat(String dateInString,String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return dateInString != null ? sdf.parse(dateInString) : null;
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static boolean getChangeType(long changeType) {
		return changeType != 0;
	}


	public static String  ternaryOperator(String value){
		return  value == null ? "" : value.equals("0") ? "" : value;
	}

}
