package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;

/**
 * The Class LocAccountOpenReqDivisionItrDto.
 * 
 * @version 1.0
 * @created 2021/01/01 20:37:23
 *
 */
public class LocAccountOpenReqDivisionItrDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The lc open req bank itr id. */
	private Long lcOpenReqBankItrId;

	/** The lc open req hdr id. */
	private LocAccountOpenReqHdrEntity lcOpenReqHdrId;

	/** The division cd. */
	private String divisionCd;

	/** The division remarks. */
	private String divisionRemarks;

	/** The status id. */
	private Long statusId;

	/** The wf id. */
	private Long wfId;

	/** The wf role id. */
	private Long wfRoleId;

	/**
	 * LocAccountOpenReqDivisionItrDto Constructor
	 */
	public LocAccountOpenReqDivisionItrDto() {
		super();
	}

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
