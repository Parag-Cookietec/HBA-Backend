package gov.ifms.loc.util;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

import net.glxn.qrgen.javase.QRCode;

/**
 * The Class LocUtility.
 */
public class LocUtility {

	/**
	 * Instantiates a new loc utility.
	 */
	private LocUtility() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Generate base 64 QR code image.
	 *
	 * @param barcodeText the barcode text
	 * @return the string
	 */

	public static String generateBase64QRCodeImage(String barcodeText) {
		ByteArrayOutputStream stream = QRCode.from(barcodeText).withSize(240, 240).stream();
		return Base64.getEncoder().encodeToString(stream.toByteArray());
	}
	
	/**
	 * Gets the formatted date.
	 *
	 * @param date the date
	 * @return the formatted date
	 */
	public static String getFormattedDate(Date date) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMMMM-yyyy");
		return date != null ? dateFormatter.format(date) : null;
	}
	
	/**
	 * From Date Validation.
	 *
	 * @param from Date
	 * @return the boolean
	 */
	public static boolean validateFromDate(Date fromDate) {
		if (Objects.nonNull(fromDate)) {
			int compareVal = fromDate.compareTo(new Date());
			if (compareVal > 0) {
				return false;
			} else {
				return true;
			}
		}
		return false;

	}
	
	/**
	 * To Date Validation.
	 *
	 * @param fromDate,toDate 
	 * @return the boolean
	 */
	public static boolean validateToDate(Date fromDate,Date toDate) {
		if (Objects.nonNull(fromDate) && Objects.nonNull(toDate)) {
			int currentDtCompareVal = toDate.compareTo(new Date());
			int fromDtCompareVal = toDate.compareTo(fromDate);
			if (currentDtCompareVal > 0 || fromDtCompareVal<0) {
				return false;
			} else {
				return true;
			}
		}
		return false;

	}
	
	/**
	 * Amount Validation.
	 *
	 * @param amount 
	 * @return the boolean
	 */
	public static boolean validateAmount(Double amount) {
		if (Objects.nonNull(amount) && amount < 0) {
			return false;
		} else {
			return true;
		}
	}
	
}
