package gov.ifms.loc.dto;

import java.io.Serializable;

/**
 * The Class LocAccountCloseReqParamDto.
 */
public class LocAccountCloseReqParamDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The department id.
	 */

	private Long departmentId;

	/**
	 * The district id.
	 */
	private Long districtId;

	/**
	 * The cardexNo.
	 */

	private Long cardexNo;

	/**
	 * The office id.
	 */
	private Long officeId;

	/**
	 * The ddoNo.
	 */

	private Long ddoNo;

	/**
	 * LocAccountCloseReqParamDto Constructor.
	 */
	public LocAccountCloseReqParamDto() {
		super();
	}

	/**
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public Long getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(Long ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the department id.
	 *
	 * @return the department id
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the new department id
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
