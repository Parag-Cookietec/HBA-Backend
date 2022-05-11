package gov.ifms.pvu.dto;

import java.io.Serializable;

/**
 * The Class RopEmployeeRequest.
 */
public class RopEmployeeRequest implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp no. */
	private Long empNo;
	
	/** The effective date. */
	private String effectiveDate;
	
	/** The rop type. */
	private Long ropType;
	
	/** The pay commission. */
	private Long payCommission;

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the effective date.
	 *
	 * @return the effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Sets the effective date.
	 *
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Gets the rop type.
	 *
	 * @return the ropType
	 */
	public Long getRopType() {
		return ropType;
	}

	/**
	 * Sets the rop type.
	 *
	 * @param ropType the ropType to set
	 */
	public void setRopType(Long ropType) {
		this.ropType = ropType;
	}

	/**
	 * Gets the pay commission.
	 *
	 * @return the payCommission
	 */
	public Long getPayCommission() {
		return payCommission;
	}

	/**
	 * Sets the pay commission.
	 *
	 * @param payCommission the payCommission to set
	 */
	public void setPayCommission(Long payCommission) {
		this.payCommission = payCommission;
	}
	
}
