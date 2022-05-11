package gov.ifms.edp.dto;

import java.util.Objects;

/**
 * The Class SearchParam.
 */
public class EDPReportSearchParamDto {

    /** The key. */
    private String key;
   
    /** The value. */
    private String value;
    
    /** The print value. */
    private String printValue;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the printValue
	 */
	public String getPrintValue() {
		return printValue;
	}

	/**
	 * @param printValue the printValue to set
	 */
	public void setPrintValue(String printValue) {
		this.printValue = printValue;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(key, printValue, value);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPReportSearchParamDto)) {
			return false;
		}
		EDPReportSearchParamDto other = (EDPReportSearchParamDto) obj;
		return Objects.equals(key, other.key) && Objects.equals(printValue, other.printValue)
				&& Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "EDPReportSearchParamDto [key=" + key + ", value=" + value + ", printValue=" + printValue + "]";
	}

}
