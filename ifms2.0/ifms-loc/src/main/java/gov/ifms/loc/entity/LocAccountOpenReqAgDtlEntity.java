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
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocAccountOpenReqAgDtlEntity.
 * 
 * @version 1.0
 * @created 2021/01/01 21:17:12
 *
 */
@Entity
@Table(name = "TLOC_OPEN_REQ_AG_DTL", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpenReqAgDtlEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The lc open req ag id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_OPEN_REQ_AG_ID")
	private Long lcOpenReqAgId;

	/** The lc open req hdr id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LC_OPEN_REQ_HDR_ID", nullable = false, referencedColumnName = "LC_OPEN_REQ_HDR_ID")
	private LocAccountOpenReqHdrEntity lcOpenReqHdrId;

	/** The ag authorization no. */
	@Column(name = "AG_AUTHORIZATION_NO")
	private String agAuthorizationNo;

	/** The ag authorization dt. */
	@Column(name = "AG_AUTHORIZATION_DT")
	private Date agAuthorizationDt;

	/** The major head id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MAJORHEAD_ID", nullable = false, referencedColumnName = "MAJORHEAD_ID")
	private LocMsMajorHeadEntity majorHeadId;

	/** The submajorhead id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SUBMAJORHEAD_ID", nullable = false, referencedColumnName = "SUBMAJORHEAD_ID")
	private LocMsSubMajorHeadEntity submajorheadId;

	/** The subhead id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SUBHEAD_ID", nullable = false, referencedColumnName = "SUBHEAD_ID")
	private LocMsSubHeadEntity subheadId;

	/** The detailhead id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DETAILHEAD_ID", nullable = false, referencedColumnName = "DETAILHEAD_ID")
	private LocMsDetailHeadEntity detailheadId;

	/** The minorhead id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MINORHEAD_ID", nullable = false, referencedColumnName = "MINORHEAD_ID")
	private LocMsMinorHeadEntity minorheadId;

	/** The ag remarks. */
	@Column(name = "AG_REMARKS")
	private String agRemarks;

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
	 * LocAccountOpenReqAgDtlDto Constructor
	 */
	public LocAccountOpenReqAgDtlEntity() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lcOpenReqAgId, lcOpenReqHdrId, agAuthorizationNo, agAuthorizationDt, majorHeadId,
				submajorheadId, subheadId, detailheadId, minorheadId, agRemarks, statusId, wfId, wfRoleId);
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
		if (!(obj instanceof LocAccountOpenReqAgDtlEntity)) {
			return false;
		}

		LocAccountOpenReqAgDtlEntity other = (LocAccountOpenReqAgDtlEntity) obj;

		return Objects.equals(lcOpenReqAgId, other.lcOpenReqAgId)
				&& Objects.equals(lcOpenReqHdrId, other.lcOpenReqHdrId)
				&& Objects.equals(agAuthorizationNo, other.agAuthorizationNo)
				&& Objects.equals(agAuthorizationDt, other.agAuthorizationDt)
				&& Objects.equals(majorHeadId, other.majorHeadId)
				&& Objects.equals(submajorheadId, other.submajorheadId) && Objects.equals(subheadId, other.subheadId)
				&& Objects.equals(detailheadId, other.detailheadId) && Objects.equals(minorheadId, other.minorheadId)
				&& Objects.equals(agRemarks, other.agRemarks) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(wfId, other.wfId) && Objects.equals(wfRoleId, other.wfRoleId);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "LocAccountOpenReqAgDtlEntity [lcOpenReqAgId = " + lcOpenReqAgId + ",lcOpenReqHdrId = " + lcOpenReqHdrId
				+ ",agAuthorizationNo = " + agAuthorizationNo + ",agAuthorizationDt = " + agAuthorizationDt
				+ ",majorHeadId = " + majorHeadId + ",submajorheadId = " + submajorheadId + ",subheadId = " + subheadId
				+ ",detailheadId = " + detailheadId + ",minorheadId = " + minorheadId + ",agRemarks = " + agRemarks
				+ ",statusId = " + statusId + ",wfId = " + wfId + ",wfRoleId = " + wfRoleId + ",]";
	}

	/**
	 * @return the lcOpenReqAgId
	 */
	public Long getLcOpenReqAgId() {
		return lcOpenReqAgId;
	}

	/**
	 * @param lcOpenReqAgId the lcOpenReqAgId to set
	 */
	public void setLcOpenReqAgId(Long lcOpenReqAgId) {
		this.lcOpenReqAgId = lcOpenReqAgId;
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
	 * @return the agAuthorizationNo
	 */
	public String getAgAuthorizationNo() {
		return agAuthorizationNo;
	}

	/**
	 * @param agAuthorizationNo the agAuthorizationNo to set
	 */
	public void setAgAuthorizationNo(String agAuthorizationNo) {
		this.agAuthorizationNo = agAuthorizationNo;
	}

	/**
	 * @return the agAuthorizationDt
	 */
	public Date getAgAuthorizationDt() {
		return agAuthorizationDt;
	}

	/**
	 * @param agAuthorizationDt the agAuthorizationDt to set
	 */
	public void setAgAuthorizationDt(Date agAuthorizationDt) {
		this.agAuthorizationDt = agAuthorizationDt;
	}

	/**
	 * @return the majorHeadId
	 */
	public LocMsMajorHeadEntity getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * @param majorHeadId the majorHeadId to set
	 */
	public void setMajorHeadId(LocMsMajorHeadEntity majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * @return the submajorheadId
	 */
	public LocMsSubMajorHeadEntity getSubmajorheadId() {
		return submajorheadId;
	}

	/**
	 * @param submajorheadId the submajorheadId to set
	 */
	public void setSubmajorheadId(LocMsSubMajorHeadEntity submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	/**
	 * @return the subheadId
	 */
	public LocMsSubHeadEntity getSubheadId() {
		return subheadId;
	}

	/**
	 * @param subheadId the subheadId to set
	 */
	public void setSubheadId(LocMsSubHeadEntity subheadId) {
		this.subheadId = subheadId;
	}

	/**
	 * @return the detailheadId
	 */
	public LocMsDetailHeadEntity getDetailheadId() {
		return detailheadId;
	}

	/**
	 * @param detailheadId the detailheadId to set
	 */
	public void setDetailheadId(LocMsDetailHeadEntity detailheadId) {
		this.detailheadId = detailheadId;
	}

	/**
	 * @return the minorheadId
	 */
	public LocMsMinorHeadEntity getMinorheadId() {
		return minorheadId;
	}

	/**
	 * @param minorheadId the minorheadId to set
	 */
	public void setMinorheadId(LocMsMinorHeadEntity minorheadId) {
		this.minorheadId = minorheadId;
	}

	/**
	 * @return the agRemarks
	 */
	public String getAgRemarks() {
		return agRemarks;
	}

	/**
	 * @param agRemarks the agRemarks to set
	 */
	public void setAgRemarks(String agRemarks) {
		this.agRemarks = agRemarks;
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
