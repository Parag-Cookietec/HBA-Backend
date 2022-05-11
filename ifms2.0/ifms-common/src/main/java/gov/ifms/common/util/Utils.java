package gov.ifms.common.util;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Utils {

	/**
	 * @param <T> type of object
	 * @param objects object
	 * @return boolean
	 */
	public static <T> boolean isEmpty(List<T> objects) {
		return objects == null || objects.size() <= 0;
	}


	/**
	 * @param <T> type of objects
	 * @param objects objects
	 * @return boolean
	 */
	public static <T> boolean isNonEmpty(T objects) {
		return objects != null && !"".equals(objects);
	}

	/**
	 * @param <T> type of objects
	 * @param objects objects
	 * @return boolean
	 */
	public static <T> boolean isEmpty(T objects) {
		return objects == null || "".equals(objects);
	}

	/**
	 * @param str str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() <= 0;
	}
	
	/**
	 * @param num number
	 * @return boolean
	 */
	public static boolean isEmpty(long num) {
		return num == 0;
	}
	
	private Utils() {
		
	}
	
	/**
	 * Multipart to file.
	 *
	 * @param multipart the multipart
	 * @param fileName the file name
	 * @return the file
	 * @throws IllegalStateException the illegal state exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
	    File convFile = new File(System.getProperty("java.io.tmpdir")+File.separator+fileName);
	    multipart.transferTo(convFile);
	    return convFile;
	}
	
	public static boolean isTrue(Long valid) {
		if (valid == null) return false; 
		return valid == 1;
	}

	public static String inFormatedDateString(String dateStr) throws ParseException {
		SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = oldFormat.parse(dateStr.substring(0, 10)); 
		SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		return newFormat.format(date);
	}

	public static boolean isAfter(String dateJoining, String effectiveDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(dateJoining);
        Date date2 = sdf.parse(effectiveDate);
        return date1.after(date2);
    }

	public static String inFormatedDateString(LocalDateTime eventDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return eventDate.format(formatter);
	}

	public static String getDateStr(Date date) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(date);  
	}
	public static String getDateString(Date date) {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		return format1.format(date);  
	}
	
	public static boolean isSame(LocalDateTime eventDateTime, String effectiveDateStr) {
		LocalDate effectiveDate = LocalDate.parse(effectiveDateStr);
		LocalDate eventDate = eventDateTime.toLocalDate();
        return eventDate.equals(effectiveDate);
	}
	
	public static boolean isOldTransaction(Long id) {
		if (!Utils.isEmpty(id)) {
			return id > Constant.LONG_ZERO_VALUE;
		}
		return Boolean.FALSE;
	}
	
	public static boolean seventhCommissionDateValidation(LocalDate incrementEffectiveDate) {
		return incrementEffectiveDate.getDayOfMonth() == 1
				&& (incrementEffectiveDate.getMonthValue() == 1 || incrementEffectiveDate.getMonthValue() == 7);
	}
	
	public static boolean sixthCommissionDateValidation(LocalDate incrementEffectiveDate) {
		return incrementEffectiveDate.getDayOfMonth() == 1 && incrementEffectiveDate.getMonthValue() == 7;
	}

	public static boolean compareDates(Date oldDate, Date requestedDate) {
		LocalDate oldDateLocalDate = oldDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate requestedDateLocalDate = requestedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		return oldDateLocalDate.getDayOfMonth() == requestedDateLocalDate.getDayOfMonth()
				&& oldDateLocalDate.getMonthValue() == requestedDateLocalDate.getMonthValue()
				&& oldDateLocalDate.getYear() == requestedDateLocalDate.getYear();
	}
	
	public static boolean isDifferentData(String oldData, String requestedData) {
		return (oldData == null && requestedData != null)
				|| (oldData != null && requestedData == null)
				|| (oldData != null && oldData.equals(requestedData));
	}

	public static int noOfyears(LocalDate startDate,LocalDate endDate) {
		Period age = Period.between(startDate, endDate);
		int years = age.getYears();
		return years;
	}
	public static Date convertToDate(LocalDate dateToConvert) {
		return java.util.Date.from(dateToConvert.atStartOfDay()
				.atZone(ZoneId.systemDefault())
				.toInstant());
	}
	public static LocalDate convertToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	/**
	 * Get current date time (format : dd/MM/yyyy HH:mm:ss am/pm )
	 * @return String
	 */
	public static String getCurrentDateTime() {
		LocalDateTime today=LocalDateTime.now();
		DateTimeFormatter formatTimeNow=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return today.format(formatTimeNow).concat(" ").concat(today.format(df));
	}

	public static boolean isBefore(String dateJoining, String effectiveDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse(dateJoining);
		Date date2 = sdf.parse(effectiveDate);
		return date1.after(date2);
	}
	
	public static LocalDate convertStringToLocalDate(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(value, formatter);
	}
}
