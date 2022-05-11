package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;


/**
 * The Class LocAgReqDtlDto.
 */
@NativeQueryResultEntity
public class LocAgReqDtlDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ag id. */
	@NativeQueryResultColumn(index = 0)
	private Long agId;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 1)
	private Long hdrId;

	/** The dtl id. */
	@NativeQueryResultColumn(index = 2)
	private Long dtlId;

	/** The authorization no. */
	@NativeQueryResultColumn(index = 3)
	private String authorizationNo;

	/** The authorization dt. */
	@NativeQueryResultColumn(index = 4)
	private Date authorizationDt;

	/** The major head id. */
	@NativeQueryResultColumn(index = 5)
	private Long majorHeadId;

	/** The major head name. */
	@NativeQueryResultColumn(index = 6)
	private String majorHeadName;

	/** The sub major head id. */
	@NativeQueryResultColumn(index = 7)
	private Long subMajorHeadId;

	/** The sub major head name. */
	@NativeQueryResultColumn(index = 8)
	private String subMajorHeadName;

	/** The minor head id. */
	@NativeQueryResultColumn(index = 9)
	private Long minorHeadId;

	/** The minor head name. */
	@NativeQueryResultColumn(index = 10)
	private String minorHeadName;

	/** The sub head id. */
	@NativeQueryResultColumn(index = 11)
	private Long subHeadId;

	/** The sub head name. */
	@NativeQueryResultColumn(index = 12)
	private String subHeadName;

	/** The detail head id. */
	@NativeQueryResultColumn(index = 13)
	private Long detailHeadId;

	/** The detail head name. */
	@NativeQueryResultColumn(index = 14)
	private String detailHeadName;

	/** The ag remarks. */
	@NativeQueryResultColumn(index = 15)
	private String agRemarks;

	/** The created by. */
	@NativeQueryResultColumn(index = 16)
	private Long createdBy;

	/** The created by post. */
	@NativeQueryResultColumn(index = 17)
	private Long createdByPost;

	/** The status id. */
	@NativeQueryResultColumn(index = 18)
	private Long statusId;

	/** The wf id. */
	@NativeQueryResultColumn(index = 19)
	private Long wfId;

	/** The wf role id. */
	@NativeQueryResultColumn(index = 20)
	private Long wfRoleId;
	
	/** The major head code. */
	@NativeQueryResultColumn(index = 21)
	private String majorHeadCode;
	
	/** The sub major head code. */
	@NativeQueryResultColumn(index = 22)
	private String subMajorHeadCode;
	
	/** The minor head code. */
	@NativeQueryResultColumn(index = 23)
	private String minorHeadCode;
	
	/** The sub head code. */
	@NativeQueryResultColumn(index = 24)
	private String subHeadCode;
	
	/** The detail head code. */
	@NativeQueryResultColumn(index = 25)
	private String detailHeadCode;
	

	/**
	 * Gets the ag id.
	 *
	 * @return the agId
	 */
	public Long getAgId() {
		return agId;
	}

	/**
	 * Sets the ag id.
	 *
	 * @param agId the agId to set
	 */
	public void setAgId(Long agId) {
		this.agId = agId;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdrId
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the hdrId to set
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the dtl id.
	 *
	 * @return the dtlId
	 */
	public Long getDtlId() {
		return dtlId;
	}

	/**
	 * Sets the dtl id.
	 *
	 * @param dtlId the dtlId to set
	 */
	public void setDtlId(Long dtlId) {
		this.dtlId = dtlId;
	}

	/**
	 * Gets the authorization no.
	 *
	 * @return the authorizationNo
	 */
	public String getAuthorizationNo() {
		return authorizationNo;
	}

	/**
	 * Sets the authorization no.
	 *
	 * @param authorizationNo the authorizationNo to set
	 */
	public void setAuthorizationNo(String authorizationNo) {
		this.authorizationNo = authorizationNo;
	}

	/**
	 * Gets the authorization dt.
	 *
	 * @return the authorizationDt
	 */
	public Date getAuthorizationDt() {
		return authorizationDt;
	}

	/**
	 * Sets the authorization dt.
	 *
	 * @param authorizationDt the authorizationDt to set
	 */
	public void setAuthorizationDt(Date authorizationDt) {
		this.authorizationDt = authorizationDt;
	}

	/**
	 * Gets the major head id.
	 *
	 * @return the majorHeadId
	 */
	public Long getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * Sets the major head id.
	 *
	 * @param majorHeadId the majorHeadId to set
	 */
	public void setMajorHeadId(Long majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * Gets the major head name.
	 *
	 * @return the majorHeadName
	 */
	public String getMajorHeadName() {
		return majorHeadName;
	}

	/**
	 * Sets the major head name.
	 *
	 * @param majorHeadName the majorHeadName to set
	 */
	public void setMajorHeadName(String majorHeadName) {
		this.majorHeadName = majorHeadName;
	}

	/**
	 * Gets the sub major head id.
	 *
	 * @return the subMajorHeadId
	 */
	public Long getSubMajorHeadId() {
		return subMajorHeadId;
	}

	/**
	 * Sets the sub major head id.
	 *
	 * @param subMajorHeadId the subMajorHeadId to set
	 */
	public void setSubMajorHeadId(Long subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	/**
	 * Gets the sub major head name.
	 *
	 * @return the subMajorHeadName
	 */
	public String getSubMajorHeadName() {
		return subMajorHeadName;
	}

	/**
	 * Sets the sub major head name.
	 *
	 * @param subMajorHeadName the subMajorHeadName to set
	 */
	public void setSubMajorHeadName(String subMajorHeadName) {
		this.subMajorHeadName = subMajorHeadName;
	}

	/**
	 * Gets the minor head id.
	 *
	 * @return the minorHeadId
	 */
	public Long getMinorHeadId() {
		return minorHeadId;
	}

	/**
	 * Sets the minor head id.
	 *
	 * @param minorHeadId the minorHeadId to set
	 */
	public void setMinorHeadId(Long minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	/**
	 * Gets the minor head name.
	 *
	 * @return the minorHeadName
	 */
	public String getMinorHeadName() {
		return minorHeadName;
	}

	/**
	 * Sets the minor head name.
	 *
	 * @param minorHeadName the minorHeadName to set
	 */
	public void setMinorHeadName(String minorHeadName) {
		this.minorHeadName = minorHeadName;
	}

	/**
	 * Gets the sub head id.
	 *
	 * @return the subHeadId
	 */
	public Long getSubHeadId() {
		return subHeadId;
	}

	/**
	 * Sets the sub head id.
	 *
	 * @param subHeadId the subHeadId to set
	 */
	public void setSubHeadId(Long subHeadId) {
		this.subHeadId = subHeadId;
	}

	/**
	 * Gets the sub head name.
	 *
	 * @return the subHeadName
	 */
	public String getSubHeadName() {
		return subHeadName;
	}

	/**
	 * Sets the sub head name.
	 *
	 * @param subHeadName the subHeadName to set
	 */
	public void setSubHeadName(String subHeadName) {
		this.subHeadName = subHeadName;
	}

	/**
	 * Gets the detail head id.
	 *
	 * @return the detailHeadId
	 */
	public Long getDetailHeadId() {
		return detailHeadId;
	}

	/**
	 * Sets the detail head id.
	 *
	 * @param detailHeadId the detailHeadId to set
	 */
	public void setDetailHeadId(Long detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	/**
	 * Gets the detail head name.
	 *
	 * @return the detailHeadName
	 */
	public String getDetailHeadName() {
		return detailHeadName;
	}

	/**
	 * Sets the detail head name.
	 *
	 * @param detailHeadName the detailHeadName to set
	 */
	public void setDetailHeadName(String detailHeadName) {
		this.detailHeadName = detailHeadName;
	}

	/**
	 * Gets the ag remarks.
	 *
	 * @return the agRemarks
	 */
	public String getAgRemarks() {
		return agRemarks;
	}

	/**
	 * Sets the ag remarks.
	 *
	 * @param agRemarks the agRemarks to set
	 */
	public void setAgRemarks(String agRemarks) {
		this.agRemarks = agRemarks;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created by post.
	 *
	 * @return the createdByPost
	 */
	public Long getCreatedByPost() {
		return createdByPost;
	}

	/**
	 * Sets the created by post.
	 *
	 * @param createdByPost the createdByPost to set
	 */
	public void setCreatedByPost(Long createdByPost) {
		this.createdByPost = createdByPost;
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
	 * Gets the major head code.
	 *
	 * @return the major head code
	 */
	public String getMajorHeadCode() {
		return majorHeadCode;
	}

	/**
	 * Sets the major head code.
	 *
	 * @param majorHeadCode the new major head code
	 */
	public void setMajorHeadCode(String majorHeadCode) {
		this.majorHeadCode = majorHeadCode;
	}

	/**
	 * Gets the sub major head code.
	 *
	 * @return the sub major head code
	 */
	public String getSubMajorHeadCode() {
		return subMajorHeadCode;
	}

	/**
	 * Sets the sub major head code.
	 *
	 * @param subMajorHeadCode the new sub major head code
	 */
	public void setSubMajorHeadCode(String subMajorHeadCode) {
		this.subMajorHeadCode = subMajorHeadCode;
	}

	/**
	 * Gets the minor head code.
	 *
	 * @return the minor head code
	 */
	public String getMinorHeadCode() {
		return minorHeadCode;
	}

	/**
	 * Sets the minor head code.
	 *
	 * @param minorHeadCode the new minor head code
	 */
	public void setMinorHeadCode(String minorHeadCode) {
		this.minorHeadCode = minorHeadCode;
	}

	/**
	 * Gets the sub head code.
	 *
	 * @return the sub head code
	 */
	public String getSubHeadCode() {
		return subHeadCode;
	}

	/**
	 * Sets the sub head code.
	 *
	 * @param subHeadCode the new sub head code
	 */
	public void setSubHeadCode(String subHeadCode) {
		this.subHeadCode = subHeadCode;
	}

	/**
	 * Gets the detail head code.
	 *
	 * @return the detail head code
	 */
	public String getDetailHeadCode() {
		return detailHeadCode;
	}

	/**
	 * Sets the detail head code.
	 *
	 * @param detailHeadCode the new detail head code
	 */
	public void setDetailHeadCode(String detailHeadCode) {
		this.detailHeadCode = detailHeadCode;
	}

}
