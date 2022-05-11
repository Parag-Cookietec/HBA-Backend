package gov.ifms.loc.dto;

import java.io.Serializable;

/**
 * The Class LocChqDtlDto.
 */
public class LocChqDtlDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dept id. */
	private Long deptId;

	/** The office name id. */
	private Long officeNameId;

	/** The cardex no. */
	private Long cardexNo;

	/** The ddo no. */
	private Long ddoNo;

	/** The div id. */
	private Long divId;

	/** The bank acc no. */
	private String bankAccNo;

	/** The bank id. */
	private Long bankId;

	/** The req type id. */
	private Long reqTypeId;

	/** The cheque type id. */
	private Long chequeTypeId;

	/**
	 * Gets the dept id.
	 *
	 * @return the deptId
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * Sets the dept id.
	 *
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	/**
	 * Gets the office name id.
	 *
	 * @return the officeNameId
	 */
	public Long getOfficeNameId() {
		return officeNameId;
	}

	/**
	 * Sets the office name id.
	 *
	 * @param officeNameId the officeNameId to set
	 */
	public void setOfficeNameId(Long officeNameId) {
		this.officeNameId = officeNameId;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public Long getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(Long ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the divCode
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * @param divId the divId to set
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * @return the bankAccNo
	 */
	public String getBankAccNo() {
		return bankAccNo;
	}

	/**
	 * @param bankAccNo the bankAccNo to set
	 */
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	/**
	 * @return the bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the reqTypeId
	 */
	public Long getReqTypeId() {
		return reqTypeId;
	}

	/**
	 * @param reqTypeId the reqTypeId to set
	 */
	public void setReqTypeId(Long reqTypeId) {
		this.reqTypeId = reqTypeId;
	}

	/**
	 * @return the chequeTypeId
	 */
	public Long getChequeTypeId() {
		return chequeTypeId;
	}

	/**
	 * @param chequeTypeId the chequeTypeId to set
	 */
	public void setChequeTypeId(Long chequeTypeId) {
		this.chequeTypeId = chequeTypeId;
	}

}
