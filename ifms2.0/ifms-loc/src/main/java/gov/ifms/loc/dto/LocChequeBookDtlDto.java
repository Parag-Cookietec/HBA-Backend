package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LOCChequeBookDtlDto.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:08:08
 *
 */
public class LocChequeBookDtlDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NotNull
	private Long id;

	/** The hdr id. */
	@NotNull
	private Long hdrId;

	/** The start series. */
	@NotNull
	private String startSeries;

	/** The end series. */
	@NotNull
	private String endSeries;

	/** The issue date. */
	@NotNull
	private Date issueDate;

	/** The is active. */
	@NotNull
	private String isActive;

	/** The active date. */
	private Date activeDate;

	/** The inactive date. */
	private Date inactiveDate;

	/** The cheque book id. */
	private Long chequeBookId;

	/** The wf id. */
	private Long wfId;

	/** The wf role id. */
	private Long wfRoleId;

	/** The status id. */
	private Long statusId;

	/**
	 * LOCChequeBookDtlDto Constructor.
	 */
	public LocChequeBookDtlDto() {
		super();
	}

	/**
	 * Gets the id.
	 *
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
	 * Gets the start series.
	 *
	 * @return the startSeries
	 */
	public String getStartSeries() {
		return startSeries;
	}

	/**
	 * Sets the start series.
	 *
	 * @param startSeries the startSeries to set
	 */
	public void setStartSeries(String startSeries) {
		this.startSeries = startSeries;
	}

	/**
	 * Gets the end series.
	 *
	 * @return the endSeries
	 */
	public String getEndSeries() {
		return endSeries;
	}

	/**
	 * Sets the end series.
	 *
	 * @param endSeries the endSeries to set
	 */
	public void setEndSeries(String endSeries) {
		this.endSeries = endSeries;
	}

	/**
	 * Gets the issue date.
	 *
	 * @return the issueDate
	 */
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * Sets the issue date.
	 *
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * Gets the checks if is active.
	 *
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}

	/**
	 * Sets the checks if is active.
	 *
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the active date.
	 *
	 * @return the activeDate
	 */
	public Date getActiveDate() {
		return activeDate;
	}

	/**
	 * Sets the active date.
	 *
	 * @param activeDate the activeDate to set
	 */
	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	/**
	 * Gets the inactive date.
	 *
	 * @return the inactiveDate
	 */
	public Date getInactiveDate() {
		return inactiveDate;
	}

	/**
	 * Sets the inactive date.
	 *
	 * @param inactiveDate the inactiveDate to set
	 */
	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	/**
	 * Gets the cheque book id.
	 *
	 * @return the chequeBookId
	 */
	public Long getChequeBookId() {
		return chequeBookId;
	}

	/**
	 * Sets the cheque book id.
	 *
	 * @param chequeBookId the chequeBookId to set
	 */
	public void setChequeBookId(Long chequeBookId) {
		this.chequeBookId = chequeBookId;
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
}
