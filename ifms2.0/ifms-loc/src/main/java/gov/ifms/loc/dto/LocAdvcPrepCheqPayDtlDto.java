package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;

/**
 * The Class LocAdvcPrepCheqPayDtlDto.
 */
public class LocAdvcPrepCheqPayDtlDto extends BaseDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The dtl id.
	 */

	private Long dtlId;

	/**
	 * The advice hdr id.
	 */
	private LocAdvicePrepHdrEntity adviceHdrId;

	/**
	 * The party name.
	 */
	private String partyName;

	/**
	 * The bank acc no.
	 */
	private String bankAccNo;

	/**
	 * The ifsc code.
	 */
	private Long ifscCode;

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
	 * Gets the dtl id.
	 *
	 * @return the dtl id
	 */
	public Long getDtlId() {
		return dtlId;
	}

	/**
	 * Sets the dtl id.
	 *
	 * @param dtlId the new dtl id
	 */
	public void setDtlId(Long dtlId) {
		this.dtlId = dtlId;
	}

	/**
	 * Gets the advice hdr id.
	 *
	 * @return the advice hdr id
	 */
	public LocAdvicePrepHdrEntity getAdviceHdrId() {
		return adviceHdrId;
	}

	/**
	 * Sets the advice hdr id.
	 *
	 * @param adviceHdrId the new advice hdr id
	 */
	public void setAdviceHdrId(LocAdvicePrepHdrEntity adviceHdrId) {
		this.adviceHdrId = adviceHdrId;
	}

	/**
	 * Gets the party name.
	 *
	 * @return the party name
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * Sets the party name.
	 *
	 * @param partyName the new party name
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * Gets the bank acc no.
	 *
	 * @return the bank acc no
	 */
	public String getBankAccNo() {
		return bankAccNo;
	}

	/**
	 * Sets the bank acc no.
	 *
	 * @param bankAccNo the new bank acc no
	 */
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	/**
	 * Gets the ifsc code.
	 *
	 * @return the ifsc code
	 */
	public Long getIfscCode() {
		return ifscCode;
	}

	/**
	 * Sets the ifsc code.
	 *
	 * @param ifscCode the new ifsc code
	 */
	public void setIfscCode(Long ifscCode) {
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

}
