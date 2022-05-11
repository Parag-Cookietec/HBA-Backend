package gov.ifms.loc.entity;

import java.io.Serializable;

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
 * The Class LocAccountOpenReqDtlEntity.
 *
 * @version 1.0
 * @created 2020/12/23 11:53:12
 */
@Entity
@Table(name = "TLOC_LC_OPEN_REQ_DTL", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpenReqDtlEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The lc open request id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_OPEN_REQUEST_ID")
	private Long lcOpenRequestId;

	/**
	 * The lc open req hdr id.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LC_OPEN_REQ_HDR_ID", nullable = false, referencedColumnName = "LC_OPEN_REQ_HDR_ID")
	private LocAccountOpenReqHdrEntity lcOpenReqHdrId;

	/**
	 * The division name.
	 */
	@Column(name = "DIVISION_NAME")
	private String divisionName;

	/**
	 * The status id.
	 */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/**
	 * The wf id.
	 */
	@Column(name = "WF_ID")
	private Long wfId;

	/**
	 * The wf role id.
	 */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/**
	 * The remarks.
	 */
	@Column(name = "REMARKS")
	private String remarks;

	/**
	 * The circle id.
	 */
	@Column(name = "CIRCLE_ID")
	private Long circleId;

	/**
	 * The circle code.
	 */
	@Column(name = "CIRCLE_CODE")
	private Long circleCode;

	/** The circle name. */
	@Column(name = "CIRCLE_NAME")
	private String circleName;

	/**
	 * LocAccountOpenReqDtlDto Constructor.
	 */
	public LocAccountOpenReqDtlEntity() {
		super();
	}

	/**
	 * Gets the lc open request id.
	 *
	 * @return the lcOpenRequestId
	 */
	public Long getLcOpenRequestId() {
		return lcOpenRequestId;
	}

	/**
	 * Sets the lc open request id.
	 *
	 * @param lcOpenRequestId the lcOpenRequestId to set
	 */
	public void setLcOpenRequestId(Long lcOpenRequestId) {
		this.lcOpenRequestId = lcOpenRequestId;
	}

	/**
	 * Gets the lc open req hdr id.
	 *
	 * @return the lcOpenReqHdrId
	 */
	public LocAccountOpenReqHdrEntity getLcOpenReqHdrId() {
		return lcOpenReqHdrId;
	}

	/**
	 * Sets the lc open req hdr id.
	 *
	 * @param lcOpenReqHdrId the lcOpenReqHdrId to set
	 */
	public void setLcOpenReqHdrId(LocAccountOpenReqHdrEntity lcOpenReqHdrId) {
		this.lcOpenReqHdrId = lcOpenReqHdrId;
	}

	/**
	 * Gets the division name.
	 *
	 * @return the divisionName
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * Sets the division name.
	 *
	 * @param divisionName the divisionName to set
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
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

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the circle id.
	 *
	 * @return the circleId
	 */
	public Long getCircleId() {
		return circleId;
	}

	/**
	 * Sets the circle id.
	 *
	 * @param circleId the circleId to set
	 */
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	/**
	 * Gets the circle code.
	 *
	 * @return the circleCode
	 */
	public Long getCircleCode() {
		return circleCode;
	}

	/**
	 * Sets the circle code.
	 *
	 * @param circleCode the circleCode to set
	 */
	public void setCircleCode(Long circleCode) {
		this.circleCode = circleCode;
	}

	/**
	 * Gets the circle name.
	 *
	 * @return the circle name
	 */
	public String getCircleName() {

		return circleName;
	}

	/**
	 * Sets the circle name.
	 *
	 * @param circleName the new circle name
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
}
