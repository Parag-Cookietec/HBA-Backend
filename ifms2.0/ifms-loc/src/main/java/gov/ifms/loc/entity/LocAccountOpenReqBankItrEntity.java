package gov.ifms.loc.entity;

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

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocAccountOpenReqBankSdEntity.
 * 
 * @version 1.0
 * @created 2021/01/01 16:35:39
 *
 */
@Entity
@Table(name = "TLOC_OPEN_REQ_BANK_ITR", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpenReqBankItrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The lc open req bank itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_OPEN_REQ_BANK_ITR_ID")
	private Long lcOpenReqBankItrId;

	/** The lc open req hdr id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LC_OPEN_REQ_HDR_ID", nullable = false, referencedColumnName = "LC_OPEN_REQ_HDR_ID")
	private LocAccountOpenReqHdrEntity lcOpenReqHdrId;

	/** The bank id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "BANK_ID", nullable = false, referencedColumnName = "BANK_IFSC_ID")
	private EDPMsBankIfscEntity bankId;

	/** The bank branch id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "BANK_BRANCH_ID", nullable = false, referencedColumnName = "BANK_IFSC_ID")
	private EDPMsBankIfscEntity bankBranchId;

	/** The bank code. */
	@Column(name = "BANK_CODE")
	private Long bankCode;

	/** The bank remarks. */
	@Column(name = "BANK_REMARKS")
	private String bankRemarks;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/** The wf id. */
	@Column(name = "WF_ID")
	private Long wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/**
	 * LocAccountOpenReqBankSdDto Constructor
	 */
	public LocAccountOpenReqBankItrEntity() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lcOpenReqBankItrId, lcOpenReqHdrId, bankId, bankBranchId, bankCode, bankRemarks, statusId,
				wfId, wfRoleId);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LocAccountOpenReqBankItrEntity)) {
			return false;
		}

		LocAccountOpenReqBankItrEntity other = (LocAccountOpenReqBankItrEntity) obj;

		return Objects.equals(lcOpenReqBankItrId, other.lcOpenReqBankItrId)
				&& Objects.equals(lcOpenReqHdrId, other.lcOpenReqHdrId) && Objects.equals(bankId, other.bankId)
				&& Objects.equals(bankBranchId, other.bankBranchId) && Objects.equals(bankCode, other.bankCode)
				&& Objects.equals(bankRemarks, other.bankRemarks) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(wfId, other.wfId) && Objects.equals(wfRoleId, other.wfRoleId);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "LocAccountOpenReqBankSdEntity [lcOpenReqBankSdId = " + lcOpenReqBankItrId + ",lcOpenReqHdrId = "
				+ lcOpenReqHdrId + ",bankId = " + bankId + ",bankBranchId = " + bankBranchId + ",bankCode = " + bankCode
				+ ",bankRemarks = " + bankRemarks + ",statusId = " + statusId + ",wfId = " + wfId + ",wfRoleId = "
				+ wfRoleId + ",]";
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the lcOpenReqBankSdId
	 */
	public Long getLcOpenReqBankItrId() {
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
	public EDPMsBankIfscEntity getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(EDPMsBankIfscEntity bankBranchId) {
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
