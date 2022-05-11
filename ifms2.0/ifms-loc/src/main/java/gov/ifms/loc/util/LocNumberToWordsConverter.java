package gov.ifms.loc.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocNumberToWordsConverter {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(LocNumberToWordsConverter.class);
	private static final HashMap<Integer, String> words = new HashMap<>();
	private static final String[] digits = { "", "Hundred", "Thousand", "Lakh", "Crore" };

	static {
		words.put(0, "");
		words.put(1, "One");
		words.put(2, "Two");
		words.put(3, "Three");
		words.put(4, "Four");
		words.put(5, "Five");
		words.put(6, "Six");
		words.put(7, "Seven");
		words.put(8, "Eight");
		words.put(9, "Nine");
		words.put(10, "Ten");
		words.put(11, "Eleven");
		words.put(12, "Twelve");
		words.put(13, "Thirteen");
		words.put(14, "Fourteen");
		words.put(15, "Fifteen");
		words.put(16, "Sixteen");
		words.put(17, "Seventeen");
		words.put(18, "Eighteen");
		words.put(19, "Nineteen");
		words.put(20, "Twenty");
		words.put(30, "Thirty");
		words.put(40, "Forty");
		words.put(50, "Fifty");
		words.put(60, "Sixty");
		words.put(70, "Seventy");
		words.put(80, "Eighty");
		words.put(90, "Ninety");
	}

	private LocNumberToWordsConverter() {
	}

	public static String convert(final double num) {
		String word = null;
		try {

			BigDecimal bd = BigDecimal.valueOf(round(num));
			int decimal = (int) (bd.remainder(BigDecimal.ONE).doubleValue() * 100);

			word = "Rupees " + getRupees(bd) + getPaise(decimal) + " only ";

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			word = "";
		}

		return word;
	}

	private static String getRupees(BigDecimal bd) {

		ArrayList<String> str = new ArrayList<>();
		long number = bd.longValue();
		long no = number;

		int digitsLength = String.valueOf(no).length();
		int i = 0;
		while (i < digitsLength) {
			int divider = (i == 2) ? 10 : 100;
			number = no % divider;
			no = no / divider;
			i += divider == 10 ? 1 : 2;
			if (number > 0) {
				int counter = str.size();
				String plural = (counter > 0 && number > 9) ? "s" : "";
				String tmp = (number < 21) ? words.get(Integer.valueOf((int) number)) + " " + digits[counter] + plural
						: words.get(Integer.valueOf((int) number / 10 * 10)) + " "
								+ words.get(Integer.valueOf((int) (number % 10))) + " " + digits[counter] + plural;
				str.add(tmp);
			} else {
				str.add("");
			}
		}

		Collections.reverse(str);

		return String.join(" ", str).trim();
	}

	private static String getPaise(int decimal) {
		String paise = "";
		if (decimal != 0) {

			if (decimal >= 0 && decimal <= 19) {
				paise = words.get(Integer.valueOf((decimal)));
			} else {
				paise = (decimal) > 0
						? words.get(Integer.valueOf((decimal - decimal % 10))) + " "
								+ words.get(Integer.valueOf((decimal % 10)))
						: "";

				paise = paise.trim();
			}

			paise = " and " + paise + " Paise";
		}

		return paise;
	}
	
	public static String roundByFixDecimal(double value) {
		String s = roundBy2Decimal(value);
		s = s.replaceAll("(.+)(...\\...)", "$1,$2");
		while (s.matches("\\d{3,},.+")) {
			s = s.replaceAll("(\\d+)(\\d{2},.+)", "$1,$2");
		}
		return value < 0 ? ("-" + s) : s;
	}

	/**
	 * Round by 2 decimal.
	 *
	 * @param value the value
	 * @return the string
	 */
	public static String roundBy2Decimal(double value) {
		return String.format(Locale.UK, "%1.2f", value);
	}

	/**
	 * Round.
	 *
	 * @param value the value
	 * @return the double
	 */
	public static Double round(double value) {
		return Double.valueOf(roundBy2Decimal(value));
	}

}
