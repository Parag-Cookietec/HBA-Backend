package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsFinancialYearDto.
 */
public class EDPMsFinancialYearDto extends BaseDto implements Serializable {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The financial year id. */
	private long financialYearId;
	
	/** The fy start. */
	private int fyStart; 
	
	/** The fy start month. */
	private String fyStartMonth;
	
	/** The fy end. */
	private int fyEnd;
	
	/** The fy end month. */
	private String fyEndMonth;
	
	/** The fy. */
	private String fy;
	
	/** The is current year. */
	private int isCurrentYear;
	
	/** The fy short. */
	private String fyShort;
	
	/** The fy guj. */
	private String fyGuj;
	
	/** The fy second. */
	private String fySecond;

	/**
	 * Instantiates a new EDP ms financial year dto.
	 */
	public EDPMsFinancialYearDto() {
		super();
	}

	/**
	 * Gets the financial year id.
	 *
	 * @return the financial year id
	 */
	public long getFinancialYearId() {
		return financialYearId;
	}

	/**
	 * Sets the financial year id.
	 *
	 * @param financialYearId the new financial year id
	 */
	public void setFinancialYearId(long financialYearId) {
		this.financialYearId = financialYearId;
	}

	/**
	 * Gets the fy start.
	 *
	 * @return the fy start
	 */
	public int getFyStart() {
		return fyStart;
	}

	/**
	 * Sets the fy start.
	 *
	 * @param fyStart the new fy start
	 */
	public void setFyStart(int fyStart) {
		this.fyStart = fyStart;
	}

	/**
	 * Gets the fy start month.
	 *
	 * @return the fy start month
	 */
	public String getFyStartMonth() {
		return fyStartMonth;
	}

	/**
	 * Sets the fy start month.
	 *
	 * @param fyStartMonth the new fy start month
	 */
	public void setFyStartMonth(String fyStartMonth) {
		this.fyStartMonth = fyStartMonth;
	}

	/**
	 * Gets the fy end.
	 *
	 * @return the fy end
	 */
	public int getFyEnd() {
		return fyEnd;
	}

	/**
	 * Sets the fy end.
	 *
	 * @param fyEnd the new fy end
	 */
	public void setFyEnd(int fyEnd) {
		this.fyEnd = fyEnd;
	}

	/**
	 * Gets the fy end month.
	 *
	 * @return the fy end month
	 */
	public String getFyEndMonth() {
		return fyEndMonth;
	}

	/**
	 * Sets the fy end month.
	 *
	 * @param fyEndMonth the new fy end month
	 */
	public void setFyEndMonth(String fyEndMonth) {
		this.fyEndMonth = fyEndMonth;
	}

	/**
	 * Gets the fy.
	 *
	 * @return the fy
	 */
	public String getFy() {
		return fy;
	}

	/**
	 * Sets the fy.
	 *
	 * @param fy the new fy
	 */
	public void setFy(String fy) {
		this.fy = fy;
	}

	/**
	 * Gets the checks if is current year.
	 *
	 * @return the checks if is current year
	 */
	public int getIsCurrentYear() {
		return isCurrentYear;
	}

	/**
	 * Sets the checks if is current year.
	 *
	 * @param isCurrentYear the new checks if is current year
	 */
	public void setIsCurrentYear(int isCurrentYear) {
		this.isCurrentYear = isCurrentYear;
	}

	/**
	 * Gets the fy short.
	 *
	 * @return the fy short
	 */
	public String getFyShort() {
		return fyShort;
	}

	/**
	 * Sets the fy short.
	 *
	 * @param fyShort the new fy short
	 */
	public void setFyShort(String fyShort) {
		this.fyShort = fyShort;
	}

	/**
	 * Gets the fy guj.
	 *
	 * @return the fy guj
	 */
	public String getFyGuj() {
		return fyGuj;
	}

	/**
	 * Sets the fy guj.
	 *
	 * @param fyGuj the new fy guj
	 */
	public void setFyGuj(String fyGuj) {
		this.fyGuj = fyGuj;
	}

	/**
	 * Gets the fy second.
	 *
	 * @return the fy second
	 */
	public String getFySecond() {
		return fySecond;
	}

	/**
	 * Sets the fy second.
	 *
	 * @param fySecond the new fy second
	 */
	public void setFySecond(String fySecond) {
		this.fySecond = fySecond;
	}

	/**
	 * Instantiates a new EDP ms financial year dto.
	 *
	 * @param financialYearId the financial year id
	 * @param fyStart the fy start
	 * @param fyEnd the fy end
	 * @param fy the fy
	 * @param isCurrentYear the is current year
	 */
	public EDPMsFinancialYearDto(long financialYearId, int fyStart, int fyEnd, String fy,int  isCurrentYear) {
        super();
        this.financialYearId = financialYearId;
        this.fyStart = fyStart;
        this.fyEnd = fyEnd;
        this.fy = fy;
        this.isCurrentYear = isCurrentYear;
    }

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(financialYearId, fy, fyEnd, fyEndMonth, fyGuj, fySecond, fyShort,
				fyStart, fyStartMonth, isCurrentYear);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPMsFinancialYearDto)) {
			return false;
		}
		EDPMsFinancialYearDto other = (EDPMsFinancialYearDto) obj;
		return financialYearId == other.financialYearId && Objects.equals(fy, other.fy) && fyEnd == other.fyEnd
				&& Objects.equals(fyEndMonth, other.fyEndMonth) && Objects.equals(fyGuj, other.fyGuj)
				&& Objects.equals(fySecond, other.fySecond) && Objects.equals(fyShort, other.fyShort)
				&& fyStart == other.fyStart && Objects.equals(fyStartMonth, other.fyStartMonth)
				&& isCurrentYear == other.isCurrentYear;
	}

}
