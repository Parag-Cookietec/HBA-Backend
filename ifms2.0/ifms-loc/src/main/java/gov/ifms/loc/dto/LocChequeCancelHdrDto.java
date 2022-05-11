package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;

/**
 * The Class LocChequeCancelHdrDto.
 *
 * @version v 1.0
 * @created 2021/03/05 17:12:26
 */
public class LocChequeCancelHdrDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	private Long hdrId;

	/**
	 * The ref no.
	 */
	private String refNo;

	/**
	 * The ref date.
	 */
	private Date refDate;

	/**
	 * The status code.
	 */
	private String statusCode;

	/**
	 * The status desc.
	 */
	private String statusDesc;

	/**
	 * The status date.
	 */
	private Date statusDate;

	/**
	 * The approval date.
	 */
	private Date approvalDate;

	/**
	 * The cheque no.
	 */
	private String chequeNo;

	/**
	 * The cheque date.
	 */
	private Date chequeDate;

	/**
	 * The Cheque amt.
	 */
	private Double ChequeAmt;

	/**
	 * The in favour.
	 */
	private String inFavour;

	/**
	 * The reason.
	 */
	private String reason;

	/**
	 * The division id.
	 */
	private Long divId;

	/**
	 * The bank ID.
	 */
	private Long bankID;

	/**
	 * The lc adviceid.
	 */
	private Long lcAdviceid;

	/**
	 * The wf id.
	 */
	private Long wfId;

	/**
	 * The wf role id.
	 */
	private Long wfRoleId;

	/**
	 * The status id.
	 */
	private Long statusId;

	/** The cheque cancel sd dto. */
	private List<LocChequeCancelDtlSdDto> chequeCancelSdDto;

	/** The wf user req dto. */
	private WfUserReqSDDto wfUserReqDto;

	/** The cheque dtl list. */
	private List<LocChequeCancelEditViewDtlDto> chequeDtlList;

	/**
	 * LocChequeCancelHdrDto Constructor.
	 */
	public LocChequeCancelHdrDto() {
		super();
	}

	public Long getHdrId() {
		return hdrId;
	}

	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the ref no.
	 *
	 * @return the ref no
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * Sets the ref no.
	 *
	 * @param refNo the new ref no
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Gets the ref date.
	 *
	 * @return the ref date
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the new ref date
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the new status code
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the status desc.
	 *
	 * @return the status desc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * Sets the status desc.
	 *
	 * @param statusDesc the new status desc
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/**
	 * Gets the status date.
	 *
	 * @return the status date
	 */
	public Date getStatusDate() {
		return statusDate;
	}

	/**
	 * Sets the status date.
	 *
	 * @param statusDate the new status date
	 */
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	/**
	 * Gets the approval date.
	 *
	 * @return the approval date
	 */
	public Date getApprovalDate() {
		return approvalDate;
	}

	/**
	 * Sets the approval date.
	 *
	 * @param approvalDate the new approval date
	 */
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
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
	 * Gets the cheque date.
	 *
	 * @return the cheque date
	 */
	public Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * Sets the cheque date.
	 *
	 * @param chequeDate the new cheque date
	 */
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * Gets the cheque amt.
	 *
	 * @return the cheque amt
	 */
	public Double getChequeAmt() {
		return ChequeAmt;
	}

	/**
	 * Sets the cheque amt.
	 *
	 * @param chequeAmt the new cheque amt
	 */
	public void setChequeAmt(Double chequeAmt) {
		ChequeAmt = chequeAmt;
	}

	/**
	 * Gets the in favour.
	 *
	 * @return the in favour
	 */
	public String getInFavour() {
		return inFavour;
	}

	/**
	 * Sets the in favour.
	 *
	 * @param inFavour the new in favour
	 */
	public void setInFavour(String inFavour) {
		this.inFavour = inFavour;
	}

	/**
	 * Gets the reason.
	 *
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Sets the reason.
	 *
	 * @param reason the new reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * Gets the div id.
	 *
	 * @return the div id
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the new div id
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Gets the bank ID.
	 *
	 * @return the bank ID
	 */
	public Long getBankID() {
		return bankID;
	}

	/**
	 * Sets the bank ID.
	 *
	 * @param bankID the new bank ID
	 */
	public void setBankID(Long bankID) {
		this.bankID = bankID;
	}

	/**
	 * Gets the lc adviceid.
	 *
	 * @return the lc adviceid
	 */
	public Long getLcAdviceid() {
		return lcAdviceid;
	}

	/**
	 * Sets the lc adviceid.
	 *
	 * @param lcAdviceid the new lc adviceid
	 */
	public void setLcAdviceid(Long lcAdviceid) {
		this.lcAdviceid = lcAdviceid;
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
	 * Gets the cheque cancel sd dto.
	 *
	 * @return the cheque cancel sd dto
	 */
	public List<LocChequeCancelDtlSdDto> getChequeCancelSdDto() {
		return chequeCancelSdDto;
	}

	/**
	 * Sets the cheque cancel sd dto.
	 *
	 * @param chequeCancelSdDto the new cheque cancel sd dto
	 */
	public void setChequeCancelSdDto(List<LocChequeCancelDtlSdDto> chequeCancelSdDto) {
		this.chequeCancelSdDto = chequeCancelSdDto;
	}

	/**
	 * Gets the wf user req dto.
	 *
	 * @return the wf user req dto
	 */
	public WfUserReqSDDto getWfUserReqDto() {
		return wfUserReqDto;
	}

	/**
	 * Sets the wf user req dto.
	 *
	 * @param wfUserReqDto the new wf user req dto
	 */
	public void setWfUserReqDto(WfUserReqSDDto wfUserReqDto) {
		this.wfUserReqDto = wfUserReqDto;
	}

	/**
	 * Gets the cheque dtl list.
	 *
	 * @return the chequeDtlList
	 */
	public List<LocChequeCancelEditViewDtlDto> getChequeDtlList() {
		return chequeDtlList;
	}

	/**
	 * Sets the cheque dtl list.
	 *
	 * @param chequeDtlList the chequeDtlList to set
	 */
	public void setChequeDtlList(List<LocChequeCancelEditViewDtlDto> chequeDtlList) {
		this.chequeDtlList = chequeDtlList;
	}

}
