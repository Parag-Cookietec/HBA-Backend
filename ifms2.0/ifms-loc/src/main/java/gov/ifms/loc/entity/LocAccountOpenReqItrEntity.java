package gov.ifms.loc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocAccountOpenReqItrEntity.
 * 
 * @version 1.0
 * @created 2020/12/23 12:47:40
 *
 */
@Entity
@Table(name = "TLOC_LC_OPEN_REQ_ITR", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpenReqItrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The lc open request id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_OPEN_REQUEST_ID")
	private Long lcOpenRequestId;

	/** The lc open req hdr id. */
	@Column(name = "LC_OPEN_REQ_HDR_ID")
	private Long lcOpenReqHdrId;

	/** The division name. */
	@Column(name = "DIVISION_NAME")
	private String divisionName;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/** The wf id. */
	@Column(name = "WF_ID")
	private Long wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The circle id. */
	@Column(name = "CIRCLE_ID")
	private Long circleId;

	/** The circle code. */
	@Column(name = "CIRCLE_CODE")
	private Long circleCode;

	/**
	 * LocAccountOpenReqItrDto Constructor
	 */
	public LocAccountOpenReqItrEntity() {
		super();
	}

	/**
	 * @return the lcOpenRequestId
	 */
	public Long getLcOpenRequestId() {
		return lcOpenRequestId;
	}

	/**
	 * @param lcOpenRequestId the lcOpenRequestId to set
	 */
	public void setLcOpenRequestId(Long lcOpenRequestId) {
		this.lcOpenRequestId = lcOpenRequestId;
	}

	/**
	 * @return the lcOpenReqHdrId
	 */
	public Long getLcOpenReqHdrId() {
		return lcOpenReqHdrId;
	}

	/**
	 * @param lcOpenReqHdrId the lcOpenReqHdrId to set
	 */
	public void setLcOpenReqHdrId(Long lcOpenReqHdrId) {
		this.lcOpenReqHdrId = lcOpenReqHdrId;
	}

	/**
	 * @return the divisionName
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * @param divisionName the divisionName to set
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
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

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the circleId
	 */
	public Long getCircleId() {
		return circleId;
	}

	/**
	 * @param circleId the circleId to set
	 */
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	/**
	 * @return the circleCode
	 */
	public Long getCircleCode() {
		return circleCode;
	}

	/**
	 * @param circleCode the circleCode to set
	 */
	public void setCircleCode(Long circleCode) {
		this.circleCode = circleCode;
	}

}
