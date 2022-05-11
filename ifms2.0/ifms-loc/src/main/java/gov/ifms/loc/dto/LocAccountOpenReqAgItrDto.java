package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.entity.LocMsDetailHeadEntity;
import gov.ifms.loc.entity.LocMsMajorHeadEntity;
import gov.ifms.loc.entity.LocMsMinorHeadEntity;
import gov.ifms.loc.entity.LocMsSubHeadEntity;
import gov.ifms.loc.entity.LocMsSubMajorHeadEntity;

/**
 * The Class LocAccountOpenReqAgDtlDto.
 * 
 * @version 1.0
 * @created 2021/01/01 21:17:12
 *
 */
public class LocAccountOpenReqAgItrDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The lc open req ag id. */
	private Long lcOpenReqAgId;

	/** The lc open req hdr id. */
	private LocAccountOpenReqHdrEntity lcOpenReqHdrId;

	/** The ag authorization no. */
	private String agAuthorizationNo;

	/** The ag authorization dt. */
	private Date agAuthorizationDt;

	/** The major head id. */
	private LocMsMajorHeadEntity majorHeadId;

	/** The submajorhead id. */
	private LocMsSubMajorHeadEntity submajorheadId;

	/** The subhead id. */
	private LocMsSubHeadEntity subheadId;

	/** The detailhead id. */
	private LocMsDetailHeadEntity detailheadId;

	/** The minorhead id. */
	private LocMsMinorHeadEntity minorheadId;

	/** The ag remarks. */
	private String agRemarks;

	/** The status id. */
	private Long statusId;

	/** The wf id. */
	private Long wfId;

	/** The wf role id. */
	private Long wfRoleId;

	/**
	 * LocAccountOpenReqAgDtlDto Constructor
	 */
	public LocAccountOpenReqAgItrDto() {
		super();
	}

	/**
	 * getter setter
	 */

	public Long getLcOpenReqAgId() {
		return lcOpenReqAgId;
	}

	/**
	 * Sets the lc open req ag id.
	 *
	 * @param lcOpenReqAgId the new lc open req ag id
	 */
	public void setLcOpenReqAgId(Long lcOpenReqAgId) {
		this.lcOpenReqAgId = lcOpenReqAgId;
	}

	/**
	 * Gets the lc open req hdr id.
	 *
	 * @return the lc open req hdr id
	 */
	public LocAccountOpenReqHdrEntity getLcOpenReqHdrId() {
		return lcOpenReqHdrId;
	}

	/**
	 * Sets the lc open req hdr id.
	 *
	 * @param lcOpenReqHdrId the new lc open req hdr id
	 */
	public void setLcOpenReqHdrId(LocAccountOpenReqHdrEntity lcOpenReqHdrId) {
		this.lcOpenReqHdrId = lcOpenReqHdrId;
	}

	/**
	 * Gets the ag authorization no.
	 *
	 * @return the ag authorization no
	 */
	public String getAgAuthorizationNo() {
		return agAuthorizationNo;
	}

	/**
	 * Sets the ag authorization no.
	 *
	 * @param agAuthorizationNo the new ag authorization no
	 */
	public void setAgAuthorizationNo(String agAuthorizationNo) {
		this.agAuthorizationNo = agAuthorizationNo;
	}

	/**
	 * Gets the ag authorization dt.
	 *
	 * @return the ag authorization dt
	 */
	public Date getAgAuthorizationDt() {
		return agAuthorizationDt;
	}

	/**
	 * Sets the ag authorization dt.
	 *
	 * @param agAuthorizationDt the new ag authorization dt
	 */
	public void setAgAuthorizationDt(Date agAuthorizationDt) {
		this.agAuthorizationDt = agAuthorizationDt;
	}

	/**
	 * Gets the major head id.
	 *
	 * @return the major head id
	 */
	public LocMsMajorHeadEntity getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * Sets the major head id.
	 *
	 * @param majorHeadId the new major head id
	 */
	public void setMajorHeadId(LocMsMajorHeadEntity majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * Gets the submajorhead id.
	 *
	 * @return the submajorhead id
	 */
	public LocMsSubMajorHeadEntity getSubmajorheadId() {
		return submajorheadId;
	}

	/**
	 * Sets the submajorhead id.
	 *
	 * @param submajorheadId the new submajorhead id
	 */
	public void setSubmajorheadId(LocMsSubMajorHeadEntity submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	/**
	 * Gets the subhead id.
	 *
	 * @return the subhead id
	 */
	public LocMsSubHeadEntity getSubheadId() {
		return subheadId;
	}

	/**
	 * Sets the subhead id.
	 *
	 * @param subheadId the new subhead id
	 */
	public void setSubheadId(LocMsSubHeadEntity subheadId) {
		this.subheadId = subheadId;
	}

	/**
	 * Gets the detailhead id.
	 *
	 * @return the detailhead id
	 */
	public LocMsDetailHeadEntity getDetailheadId() {
		return detailheadId;
	}

	/**
	 * Sets the detailhead id.
	 *
	 * @param detailheadId the new detailhead id
	 */
	public void setDetailheadId(LocMsDetailHeadEntity detailheadId) {
		this.detailheadId = detailheadId;
	}

	/**
	 * Gets the minorhead id.
	 *
	 * @return the minorhead id
	 */
	public LocMsMinorHeadEntity getMinorheadId() {
		return minorheadId;
	}

	/**
	 * Sets the minorhead id.
	 *
	 * @param minorheadId the new minorhead id
	 */
	public void setMinorheadId(LocMsMinorHeadEntity minorheadId) {
		this.minorheadId = minorheadId;
	}

	/**
	 * Gets the ag remarks.
	 *
	 * @return the ag remarks
	 */
	public String getAgRemarks() {
		return agRemarks;
	}

	/**
	 * Sets the ag remarks.
	 *
	 * @param agRemarks the new ag remarks
	 */
	public void setAgRemarks(String agRemarks) {
		this.agRemarks = agRemarks;
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

}
