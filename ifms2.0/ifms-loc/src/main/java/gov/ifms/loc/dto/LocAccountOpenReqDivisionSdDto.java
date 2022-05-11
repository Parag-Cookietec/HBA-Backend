package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocAccountOpenReqDivisionSdDto.
 *
 * @version 1.0
 * @created 2021/01/01 20:46:45
 */
public class LocAccountOpenReqDivisionSdDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The lc open req divi sd id.
	 */
	private Long lcOpenReqDiviSdId;

	/**
	 * The lc open req hdr id.
	 */
	private Long lcOpenReqHdrId;

	/**
	 * The division cd.
	 */
	private String divisionCd;

	/**
	 * The division remarks.
	 */
	private String divisionRemarks;

	/**
	 * The status id.
	 */
	private Long statusId;

	/**
	 * The wf id.
	 */
	private Long wfId;

	/**
	 * The wf role id.
	 */
	private Long wfRoleId;

	/**
	 * The is editable.
	 */
	private int isEditable;

	/**
	 * LocAccountOpenReqDivisionSdDto Constructor
	 */
	public LocAccountOpenReqDivisionSdDto() {
		super();
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the lcOpenReqBankSdId
	 */
	public Long getLcOpenReqDiviSdId() {
		return lcOpenReqDiviSdId;
	}

	/**
	 * @param lcOpenReqBankSdId the lcOpenReqBankSdId to set
	 */
	public void setLcOpenReqDiviSdId(Long lcOpenReqDiviSdId) {
		this.lcOpenReqDiviSdId = lcOpenReqDiviSdId;
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

	/**
	 * @return the isEditable
	 */
	public int getIsEditable() {
		return isEditable;
	}

	/**
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}

}
