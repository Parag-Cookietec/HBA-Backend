package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocAdvcPrepCheqPaySdDto.
 */
public class LocAdvcPrepCheqPaySdDto extends BaseDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The sd id.
	 */
	private Long sdId;

	/**
	 * The advice hdr id.
	 */
	private Long adviceHdrId;

	/**
	 * The party name.
	 */
	private String vendorName;

	/**
	 * The bank acc no.
	 */
	private String accNo;

	/**
	 * The ifsc code.
	 */

	private String ifscCode;

	/**
	 * The epay amnt.
	 */

	private Double epayAmnt;

	/**
	 * The status id.
	 */

	private Long statusId;

	/**
	 * The wf id.
	 */

	private Long wfId;

	/**
	 * The wf role id.
	 */

	private Long wfRoleId;

	/**
	 * The cheque no.
	 */

	private String chequeNo;

	/**
	 * The cheque dt.
	 */
	private Date chequeDt;

	/**
	 * The cheque amnt.
	 */

	private Double chequeAmnt;

	/**
	 * Gets the sd id.
	 *
	 * @return the sd id
	 */
	public Long getSdId() {
		return sdId;
	}

	/**
	 * Sets the sd id.
	 *
	 * @param sdId the new sd id
	 */
	public void setSdId(Long sdId) {
		this.sdId = sdId;
	}

	/**
	 * Gets the advice hdr id.
	 *
	 * @return the advice hdr id
	 */
	public Long getAdviceHdrId() {
		return adviceHdrId;
	}

	/**
	 * Sets the advice hdr id.
	 *
	 * @param adviceHdrId the new advice hdr id
	 */
	public void setAdviceHdrId(Long adviceHdrId) {
		this.adviceHdrId = adviceHdrId;
	}

	/**
	 * Gets the ifsc code.
	 *
	 * @return the ifsc code
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * Sets the ifsc code.
	 *
	 * @param ifscCode the new ifsc code
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * Gets the epay amnt.
	 *
	 * @return the epay amnt
	 */
	public Double getEpayAmnt() {
		return epayAmnt;
	}

	/**
	 * Sets the epay amnt.
	 *
	 * @param epayAmnt the new epay amnt
	 */
	public void setEpayAmnt(Double epayAmnt) {
		this.epayAmnt = epayAmnt;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wf id
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the new wf id
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wf role id
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the new wf role id
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the cheque no.
	 *
	 * @return the cheque no
	 */
	public String getChequeNo() {
		return chequeNo;
	}

	/**
	 * Sets the cheque no.
	 *
	 * @param chequeNo the new cheque no
	 */
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * Gets the cheque dt.
	 *
	 * @return the cheque dt
	 */
	public Date getChequeDt() {
		return chequeDt;
	}

	/**
	 * Sets the cheque dt.
	 *
	 * @param chequeDt the new cheque dt
	 */
	public void setChequeDt(Date chequeDt) {
		this.chequeDt = chequeDt;
	}

	/**
	 * Gets the cheque amnt.
	 *
	 * @return the cheque amnt
	 */
	public Double getChequeAmnt() {
		return chequeAmnt;
	}

	/**
	 * Sets the cheque amnt.
	 *
	 * @param chequeAmnt the new cheque amnt
	 */
	public void setChequeAmnt(Double chequeAmnt) {
		this.chequeAmnt = chequeAmnt;
	}

	/**
	 * Gets the vendor name.
	 *
	 * @return the vendor name
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * Sets the vendor name.
	 *
	 * @param vendorName the new vendor name
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * Gets the acc no.
	 *
	 * @return the acc no
	 */
	public String getAccNo() {
		return accNo;
	}

	/**
	 * Sets the acc no.
	 *
	 * @param accNo the new acc no
	 */
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
}
