package gov.ifms.common.cache.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class EDPMsFinancialYearDto.
 */
@NativeQueryResultEntity
public class MsFyCacheDto implements Serializable {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The financial year id. */
	@NativeQueryResultColumn(index = 0)
	private long financialYearId;

	/** The fy start. */
	@NativeQueryResultColumn(index = 1)
	private int fyStart;

	/** The fy start month. */
	@NativeQueryResultColumn(index = 2)
	private String fyStartMonth;

	/** The fy end. */
	@NativeQueryResultColumn(index = 3)
	private int fyEnd;

	/** The fy end month. */
	@NativeQueryResultColumn(index = 4)
	private String fyEndMonth;

	/** The fy. */
	@NativeQueryResultColumn(index = 5)
	private String fy;

	/** The is current year. */
	@NativeQueryResultColumn(index = 6)
	private long isCurrentYear;

	public MsFyCacheDto(long financialYearId, int fyStart, String fyStartMonth, int fyEnd, String fyEndMonth, String fy, long isCurrentYear) {
		this.financialYearId = financialYearId;
		this.fyStart = fyStart;
		this.fyStartMonth = fyStartMonth;
		this.fyEnd = fyEnd;
		this.fyEndMonth = fyEndMonth;
		this.fy = fy;
		this.isCurrentYear = isCurrentYear;
	}

	public MsFyCacheDto(long financialYearId, String fy) {
		this.financialYearId = financialYearId;
		this.fy = fy;
	}

	/**
	 * Gets the financial year id.
	 *
	 * @return the financialYearId
	 */
	public long getFinancialYearId() {
		return financialYearId;
	}


	/**
	 * Sets the financial year id.
	 *
	 * @param financialYearId the financialYearId to set
	 */
	public void setFinancialYearId(long financialYearId) {
		this.financialYearId = financialYearId;
	}


	/**
	 * Gets the fy start.
	 *
	 * @return the fyStart
	 */
	public int getFyStart() {
		return fyStart;
	}


	/**
	 * Sets the fy start.
	 *
	 * @param fyStart the fyStart to set
	 */
	public void setFyStart(int fyStart) {
		this.fyStart = fyStart;
	}


	/**
	 * Gets the fy start month.
	 *
	 * @return the fyStartMonth
	 */
	public String getFyStartMonth() {
		return fyStartMonth;
	}


	/**
	 * Sets the fy start month.
	 *
	 * @param fyStartMonth the fyStartMonth to set
	 */
	public void setFyStartMonth(String fyStartMonth) {
		this.fyStartMonth = fyStartMonth;
	}


	/**
	 * Gets the fy end.
	 *
	 * @return the fyEnd
	 */
	public int getFyEnd() {
		return fyEnd;
	}


	/**
	 * Sets the fy end.
	 *
	 * @param fyEnd the fyEnd to set
	 */
	public void setFyEnd(int fyEnd) {
		this.fyEnd = fyEnd;
	}


	/**
	 * Gets the fy end month.
	 *
	 * @return the fyEndMonth
	 */
	public String getFyEndMonth() {
		return fyEndMonth;
	}


	/**
	 * Sets the fy end month.
	 *
	 * @param fyEndMonth the fyEndMonth to set
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
	 * @param fy the fy to set
	 */
	public void setFy(String fy) {
		this.fy = fy;
	}

	/**
	 * Gets the checks if is current year.
	 *
	 * @return the checks if is current year
	 */
	public long getIsCurrentYear() {
		return isCurrentYear;
	}


	/**
	 * Sets the checks if is current year.
	 *
	 * @param isCurrentYear the new checks if is current year
	 */
	public void setIsCurrentYear(long isCurrentYear) {
		this.isCurrentYear = isCurrentYear;
	}

	/**
	 * Instantiates a new EDP ms financial year dto.
	 */
	public MsFyCacheDto() {
		super();
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
		result = prime * result
				+ Objects.hash(financialYearId, fy, fyEnd, fyEndMonth, fyStart, fyStartMonth, isCurrentYear);
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
		if (!(obj instanceof MsFyCacheDto)) {
			return false;
		}
		MsFyCacheDto other = (MsFyCacheDto) obj;
		return financialYearId == other.financialYearId && Objects.equals(fy, other.fy) && fyEnd == other.fyEnd
				&& Objects.equals(fyEndMonth, other.fyEndMonth) && fyStart == other.fyStart
				&& Objects.equals(fyStartMonth, other.fyStartMonth) && isCurrentYear == other.isCurrentYear;
	}
	public MsFyCacheDto(long financialYearId, int fyStart, int fyEnd, String fy, long  isCurrentYear) {
        super();
        this.financialYearId = financialYearId;
        this.fyStart = fyStart;
        this.fyEnd = fyEnd;
        this.fy = fy;
        this.isCurrentYear = isCurrentYear;
    }

	@Override
	public String toString() {
		return new StringJoiner(", ", MsFyCacheDto.class.getSimpleName() + "[", "]")
				.add("financialYearId=" + financialYearId)
				.add("fyStart=" + fyStart)
				.add("fyStartMonth='" + fyStartMonth + "'")
				.add("fyEnd=" + fyEnd)
				.add("fyEndMonth='" + fyEndMonth + "'")
				.add("fy='" + fy + "'")
				.add("isCurrentYear=" + isCurrentYear)
				.toString();
	}
}
