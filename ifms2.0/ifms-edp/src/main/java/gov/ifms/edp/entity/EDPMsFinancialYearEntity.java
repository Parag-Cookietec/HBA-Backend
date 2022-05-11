package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;


/**
 * The Class EDPMsFinancialYearEntity.
 */
@Entity
@Table(name = "MS_FINANCIAL_YEAR", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsFinancialYearEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The financial year id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FINANCIAL_YEAR_ID")
	private long financialYearId;
	
	/** The fy start. */
	@Column(name = "FY_START")
	private int fyStart; 
	
	/** The fy start month. */
	@Column(name = "FY_START_MONTH")
	private String fyStartMonth;
	
	/** The fy end. */
	@Column(name = "FY_END")
	private int fyEnd;
	
	/** The fy end month. */
	@Column(name = "FY_END_MONTH")
	private String fyEndMonth;
	
	/** The fy. */
	@Column(name = "FY")
	private String fy;
	
	/** The is current year. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_CURRENT_YEAR", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isCurrentYear;

	/** The fy short. */
	@Column(name = "FY_SHORT")
	private String fyShort;
	
	/** The fy guj. */
	@Column(name = "FY_GUJ")
	private String fyGuj;
	
	/** The fy second. */
	@Column(name = "FY_SECOND")
	private String fySecond;
	
	/**
	 * Instantiates a new EDP ms financial year entity.
	 */
	public EDPMsFinancialYearEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms financial year entity.
	 *
	 * @param financialYearId the financial year id
	 */
	public EDPMsFinancialYearEntity(long financialYearId) {
		super();
		this.financialYearId = financialYearId;
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
	public EDPLuLookUpInfoEntity getIsCurrentYear() {
		return isCurrentYear;
	}

	/**
	 * Sets the checks if is current year.
	 *
	 * @param isCurrentYear the new checks if is current year
	 */
	public void setIsCurrentYear(EDPLuLookUpInfoEntity isCurrentYear) {
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(financialYearId, fy, fyEnd, fyEndMonth, fyGuj, fySecond, fyShort, fyStart, fyStartMonth,
				isCurrentYear);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPMsFinancialYearEntity other = (EDPMsFinancialYearEntity) obj;
		return financialYearId == other.financialYearId && Objects.equals(fy, other.fy) && fyEnd == other.fyEnd
				&& Objects.equals(fyEndMonth, other.fyEndMonth) && Objects.equals(fyGuj, other.fyGuj)
				&& Objects.equals(fySecond, other.fySecond) && Objects.equals(fyShort, other.fyShort)
				&& fyStart == other.fyStart && Objects.equals(fyStartMonth, other.fyStartMonth)
				&& Objects.equals(isCurrentYear, other.isCurrentYear);
	}

}