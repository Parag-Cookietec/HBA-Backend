package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Date;
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
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocChequeBookHdrEntity.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:03:50
 *
 */
@Entity
@Table(name = "TLOC_LC_CHEQUEBOOK_HDR", schema = LocConstant.LOC_SCHEMA)
public class LocChequeBookHdrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_CHEQUEBOOK_ID")
	private Long id;

	/** The ref no. */
	@Column(name = "REFERENCE_NO")
	private String refNo;

	/** The ref date. */
	@Column(name = "REFERENCE_DT")
	private Date refDate;

	/** The cheque type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CHEQUE_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity chequeTypeId;

	/** The div id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DIVISION_ID", referencedColumnName = "DIVISION_ID")
	private LocMsDivisonEntity divId;

	/** The bank branch id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "BANK_BRANCH_ID", referencedColumnName = "BANK_IFSC_ID")
	private EDPMsBankIfscEntity bankBranchId;

	/** The bank acc no. */
	@Column(name = "BANK_ACCOUNT_NO")
	private String bankAccNo;

	/** The req type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "REQUEST_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity reqTypeId;

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
	 * LocChequeBookHdrEntity Constructor.
	 */
	public LocChequeBookHdrEntity() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the id
	 */

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the ref no.
	 *
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * Sets the ref no.
	 *
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Gets the ref date.
	 *
	 * @return the refDate
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the refDate to set
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	/**
	 * @return the chequeTypeId
	 */
	public EDPLuLookUpInfoEntity getChequeTypeId() {
		return chequeTypeId;
	}

	/**
	 * @param chequeTypeId the chequeTypeId to set
	 */
	public void setChequeTypeId(EDPLuLookUpInfoEntity chequeTypeId) {
		this.chequeTypeId = chequeTypeId;
	}

	/**
	 * @return the reqTypeId
	 */
	public EDPLuLookUpInfoEntity getReqTypeId() {
		return reqTypeId;
	}

	/**
	 * @param reqTypeId the reqTypeId to set
	 */
	public void setReqTypeId(EDPLuLookUpInfoEntity reqTypeId) {
		this.reqTypeId = reqTypeId;
	}

	/**
	 * Gets the div id.
	 *
	 * @return the divId
	 */
	public LocMsDivisonEntity getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the divId to set
	 */
	public void setDivId(LocMsDivisonEntity divId) {
		this.divId = divId;
	}

	/**
	 * Gets the bank branch id.
	 *
	 * @return the bankBranchId
	 */
	public EDPMsBankIfscEntity getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * Sets the bank branch id.
	 *
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(EDPMsBankIfscEntity bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * Gets the bank acc no.
	 *
	 * @return the bankAccNo
	 */
	public String getBankAccNo() {
		return bankAccNo;
	}

	/**
	 * Sets the bank acc no.
	 *
	 * @param bankAccNo the bankAccNo to set
	 */
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankAccNo, bankBranchId, chequeTypeId, divId, id, refDate, refNo, reqTypeId, statusId, wfId,
				wfRoleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LocChequeBookHdrEntity)) {
			return false;
		}
		LocChequeBookHdrEntity other = (LocChequeBookHdrEntity) obj;
		return Objects.equals(bankAccNo, other.bankAccNo) && Objects.equals(bankBranchId, other.bankBranchId)
				&& Objects.equals(chequeTypeId, other.chequeTypeId) && Objects.equals(divId, other.divId)
				&& Objects.equals(id, other.id) && Objects.equals(refDate, other.refDate)
				&& Objects.equals(refNo, other.refNo) && Objects.equals(reqTypeId, other.reqTypeId)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(wfId, other.wfId)
				&& Objects.equals(wfRoleId, other.wfRoleId);
	}

	@Override
	public String toString() {
		return "LocChequeBookHdrEntity [id=" + id + ", refNo=" + refNo + ", refDate=" + refDate + ", chequeTypeId="
				+ chequeTypeId + ", divId=" + divId + ", bankBranchId=" + bankBranchId + ", bankAccNo=" + bankAccNo
				+ ", reqTypeId=" + reqTypeId + ", statusId=" + statusId + ", wfId=" + wfId + ", wfRoleId=" + wfRoleId
				+ "]";
	}

}
