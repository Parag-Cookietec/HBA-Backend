package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeSevenPayDetailDto.
 * 
 * @version v 1.0
 * @created 2019/11/26 14:21:09
 *
 */
//@ValidateDateRange(start = "eventOrderDate", end = "new LocalDate.now()")
public class PVUEmployeSevenPayDetailDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sevenpay id. */
	private long sevenPayId;

	/** The pay level. */

	private long payLevel;
	private String payLevelName;

	/** The cell id. */

	private long cellId;
	private long cellValue;

	/** The basic pay. */

	private Long basicPay;

	/** The date of benefit effective. */

	private Date dateOfBenefitEffective;

	/** The date of next increment. */

	private Date dateOfNextIncrement;

	/** The emp id. */
	private long empId;

	/**
	 * PVUEmploye7PayDetailDto Constructor.
	 */
	public PVUEmployeSevenPayDetailDto() {
		super();
	}

	/**
	 * Gets the seven pay id.
	 *
	 * @return the sevenPayId
	 */
	public long getSevenPayId() {
		return sevenPayId;
	}

	/**
	 * Sets the seven pay id.
	 *
	 * @param sevenPayId the sevenPayId to set
	 */
	public void setSevenPayId(long sevenPayId) {
		this.sevenPayId = sevenPayId;
	}

	/**
	 * Gets the pay level.
	 *
	 * @return the payLevel
	 */
	public long getPayLevel() {
		return payLevel;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevel the payLevel to set
	 */
	public void setPayLevel(long payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public long getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(long cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basicPay
	 */
	public Long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the date of benefit effective.
	 *
	 * @return the dateOfBenefitEffective
	 */
	public Date getDateOfBenefitEffective() {
		return dateOfBenefitEffective;
	}

	/**
	 * Sets the date of benefit effective.
	 *
	 * @param dateOfBenefitEffective the dateOfBenefitEffective to set
	 */
	public void setDateOfBenefitEffective(Date dateOfBenefitEffective) {
		this.dateOfBenefitEffective = dateOfBenefitEffective;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the dateOfNextIncrement
	 */
	public Date getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(Date dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * @return the payLevelName
	 */
	public String getPayLevelName() {
		return payLevelName;
	}

	/**
	 * @param payLevelName the payLevelName to set
	 */
	public void setPayLevelName(String payLevelName) {
		this.payLevelName = payLevelName;
	}

	/**
	 * @return the cellValue
	 */
	public long getCellValue() {
		return cellValue;
	}

	/**
	 * @param cellValue the cellValue to set
	 */
	public void setCellValue(long cellValue) {
		this.cellValue = cellValue;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(basicPay, cellId, dateOfBenefitEffective, dateOfNextIncrement, empId, payLevel, sevenPayId);
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
		PVUEmployeSevenPayDetailDto other = (PVUEmployeSevenPayDetailDto) obj;
		return Double.doubleToLongBits(basicPay) == Double.doubleToLongBits(other.basicPay) && cellId == other.cellId
				&& Objects.equals(dateOfBenefitEffective, other.dateOfBenefitEffective)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement) && empId == other.empId
				&& payLevel == other.payLevel && sevenPayId == other.sevenPayId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeSevenPayDetailDto [sevenPayId=" + sevenPayId + ", payLevel=" + payLevel + ", cellId=" + cellId
				+ ", basicPay=" + basicPay + ", dateOfBenefitEffective=" + dateOfBenefitEffective
				+ ", dateOfNextIncrement=" + dateOfNextIncrement + ", empId=" + empId + "]";
	}

}
