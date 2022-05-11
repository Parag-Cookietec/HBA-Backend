package gov.ifms.edp.report.dto;

import java.io.Serializable;

/**
 * The Class CommonReportSearchParamDto.
 */
public class CommonReportSearchParamDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1l;
	
	/** The key. */
	private String key;
	
	/** The value. */
	private transient Object value;
	
	/** The print value. */
	private String printValue;

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Gets the prints the value.
	 *
	 * @return the prints the value
	 */
	public String getPrintValue() {
		return printValue;
	}

	/**
	 * Sets the prints the value.
	 *
	 * @param printValue the new prints the value
	 */
	public void setPrintValue(String printValue) {
		this.printValue = printValue;
	}
	
}
