package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;

/**
 * The Class LocAccountOpenReqBankSdDto.
 * 
 * @version 1.0
 * @created 2021/01/01 16:35:39
 *
 */
public class LocAccountOpenReqBankItrDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The lc open req bank itr id. */
	private Long lcOpenReqBankItrId;

	/** The lc open req hdr id. */
	private LocAccountOpenReqHdrEntity lcOpenReqHdrId;

	/** The bank id. */
	private EDPMsBankIfscEntity bankId;

	/** The bank branch id. */
	private Long bankBranchId;

	/** The bank code. */
	private Long bankCode;

	/** The bank remarks. */
	private String bankRemarks;

	/** The status id. */
	private Long statusId;

	/** The wf id. */
	private Long wfId;

	/** The wf role id. */
	private Long wfRoleId;

	/**
	 * LocAccountOpenReqBankSdDto Constructor
	 */
	public LocAccountOpenReqBankItrDto() {
		super();
	}

	/**
	 * @return the lcOpenReqBankSdId
	 */
	public Long getLcOpenReqBankItrSdId() {
		return lcOpenReqBankItrId;
	}

	/**
	 * @param lcOpenReqBankSdId the lcOpenReqBankSdId to set
	 */
	public void setLcOpenReqBankItrId(Long lcOpenReqBankItrId) {
		this.lcOpenReqBankItrId = lcOpenReqBankItrId;
	}

	/**
	 * @return the lcOpenReqHdrId
	 */
	public LocAccountOpenReqHdrEntity getLcOpenReqHdrId() {
		return lcOpenReqHdrId;
	}

	/**
	 * @param lcOpenReqHdrId the lcOpenReqHdrId to set
	 */
	public void setLcOpenReqHdrId(LocAccountOpenReqHdrEntity lcOpenReqHdrId) {
		this.lcOpenReqHdrId = lcOpenReqHdrId;
	}

	/**
	 * @return the bankId
	 */
	public EDPMsBankIfscEntity getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(EDPMsBankIfscEntity bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the bankBranchId
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * @return the bankCode
	 */
	public Long getBankCode() {
		return bankCode;
	}

	/**
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(Long bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @return the bankRemarks
	 */
	public String getBankRemarks() {
		return bankRemarks;
	}

	/**
	 * @param bankRemarks the bankRemarks to set
	 */
	public void setBankRemarks(String bankRemarks) {
		this.bankRemarks = bankRemarks;
	}

	/**
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

}
