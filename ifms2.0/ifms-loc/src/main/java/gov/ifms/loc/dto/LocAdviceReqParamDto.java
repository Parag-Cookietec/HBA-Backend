package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

public class LocAdviceReqParamDto implements Serializable {

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

	private String ddoNo;

	/**
	 * The hdrId.
	 */

	private Long hdrId;

	/**
	 * The tokenNo.
	 */

	private Integer tokenNo;
	
	/**
	 * The tokenDt.
	 */

	private Date tokenDt;
	
	

	public LocAdviceReqParamDto() {
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

	public String getDdoNo() {
		return ddoNo;
	}

	public void setDdoNo(String ddoNo) {
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

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the tokenNo.
	 *
	 * @return the tokenNo
	 */
	public Integer getTokenNo() {
		return tokenNo;
	}

	/**
	 * Sets the tokenNo.
	 *
	 * @param tokenNo the new tokenNo
	 */
	public void setTokenNo(Integer tokenNo) {
		this.tokenNo = tokenNo;
	}

	
	/**
	 * Gets the tokenDt.
	 *
	 * @return the tokenDt
	 */
	public Date getTokenDt() {
		return tokenDt;
	}

	/**
	 * Sets the tokenDt.
	 *
	 * @param tokenDt the new tokenDt
	 */

	public void setTokenDt(Date tokenDt) {
		this.tokenDt = tokenDt;
	}
	
	


}
