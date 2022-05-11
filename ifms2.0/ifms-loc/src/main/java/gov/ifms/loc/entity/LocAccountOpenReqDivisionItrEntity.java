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
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocAccountOpenReqDivisionItrEntity.
 * 
 * @version 1.0
 * @created 2021/01/01 20:37:23
 *
 */
@Entity
@Table(name = "TLOC_OPEN_REQ_DIVI_ITR", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpenReqDivisionItrEntity extends BaseEntity implements Serializable {

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

	/** The division cd. */
	@Column(name = "DIVISION_CD")
	private String divisionCd;

	/** The division remarks. */
	@Column(name = "DIVISION_REMARKS")
	private String divisionRemarks;

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
	 * LocAccountOpenReqDivisionItrDto Constructor
	 */
	public LocAccountOpenReqDivisionItrEntity() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lcOpenReqBankItrId, lcOpenReqHdrId, divisionCd, divisionRemarks, statusId, wfId, wfRoleId);
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
		if (!(obj instanceof LocAccountOpenReqDivisionItrEntity)) {
			return false;
		}

		LocAccountOpenReqDivisionItrEntity other = (LocAccountOpenReqDivisionItrEntity) obj;

		return Objects.equals(lcOpenReqBankItrId, other.lcOpenReqBankItrId)
				&& Objects.equals(lcOpenReqHdrId, other.lcOpenReqHdrId) && Objects.equals(divisionCd, other.divisionCd)
				&& Objects.equals(divisionRemarks, other.divisionRemarks) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(wfId, other.wfId) && Objects.equals(wfRoleId, other.wfRoleId);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "LocAccountOpenReqDivisionItrEntity [lcOpenReqBankItrId = " + lcOpenReqBankItrId + ",lcOpenReqHdrId = "
				+ lcOpenReqHdrId + ",divisionCd = " + divisionCd + ",divisionRemarks = " + divisionRemarks
				+ ",statusId = " + statusId + ",wfId = " + wfId + ",wfRoleId = " + wfRoleId + ",]";
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the lcOpenReqBankItrId
	 */
	public Long getLcOpenReqBankItrId() {
		return lcOpenReqBankItrId;
	}

	/**
	 * @param lcOpenReqBankItrId the lcOpenReqBankItrId to set
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
	 * @return the divisionCd
	 */
	public String getDivisionCd() {
		return divisionCd;
	}

	/**
	 * @param divisionCd the divisionCd to set
	 */
	public void setDivisionCd(String divisionCd) {
		this.divisionCd = divisionCd;
	}

	/**
	 * @return the divisionRemarks
	 */
	public String getDivisionRemarks() {
		return divisionRemarks;
	}

	/**
	 * @param divisionRemarks the divisionRemarks to set
	 */
	public void setDivisionRemarks(String divisionRemarks) {
		this.divisionRemarks = divisionRemarks;
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
