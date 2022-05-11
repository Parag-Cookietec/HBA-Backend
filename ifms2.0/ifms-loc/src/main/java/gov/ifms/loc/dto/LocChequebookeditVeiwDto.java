package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChequebookeditVeiwDto.
 */
@NativeQueryResultEntity
public class LocChequebookeditVeiwDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6191708379236866096L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 1)
	private Long hdrId;

	/** The created by. */
	@NativeQueryResultColumn(index = 2)
	private Long createdBy;

	/** The created by post. */
	@NativeQueryResultColumn(index = 3)
	private Long createdByPost;

	/** The created date. */
	@NativeQueryResultColumn(index = 4)
	private Date createdDate;

	/** The end series. */
	@NativeQueryResultColumn(index = 5)
	private String endSeries;

	/** The start series. */
	@NativeQueryResultColumn(index = 6)
	private String startSeries;

	/** The is active. */
	@NativeQueryResultColumn(index = 7)
	private String isActive;

	/** The active date. */
	@NativeQueryResultColumn(index = 8)
	private Date activeDate;

	/** The issue date. */
	@NativeQueryResultColumn(index = 9)
	private Date issueDate;

	/** The status id. */
	@NativeQueryResultColumn(index = 10)
	private Long statusId;

	/** The in active date. */
	@NativeQueryResultColumn(index = 11)
	private Date inActiveDate;

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
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created by post.
	 *
	 * @return the created by post
	 */
	public Long getCreatedByPost() {
		return createdByPost;
	}

	/**
	 * Sets the created by post.
	 *
	 * @param createdByPost the new created by post
	 */
	public void setCreatedByPost(Long createdByPost) {
		this.createdByPost = createdByPost;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the end series.
	 *
	 * @return the end series
	 */
	public String getEndSeries() {
		return endSeries;
	}

	/**
	 * Sets the end series.
	 *
	 * @param endSeries the new end series
	 */
	public void setEndSeries(String endSeries) {
		this.endSeries = endSeries;
	}

	/**
	 * Gets the start series.
	 *
	 * @return the start series
	 */
	public String getStartSeries() {
		return startSeries;
	}

	/**
	 * Sets the start series.
	 *
	 * @param startSeries the new start series
	 */
	public void setStartSeries(String startSeries) {
		this.startSeries = startSeries;
	}

	/**
	 * Gets the checks if is active.
	 *
	 * @return the checks if is active
	 */
	public String getIsActive() {
		return isActive;
	}

	/**
	 * Sets the checks if is active.
	 *
	 * @param isActive the new checks if is active
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the active date.
	 *
	 * @return the active date
	 */
	public Date getActiveDate() {
		return activeDate;
	}

	/**
	 * Sets the active date.
	 *
	 * @param activeDate the new active date
	 */
	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	/**
	 * Gets the issue date.
	 *
	 * @return the issue date
	 */
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * Sets the issue date.
	 *
	 * @param issueDate the new issue date
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
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
	 * Gets the in active date.
	 *
	 * @return the in active date
	 */
	public Date getInActiveDate() {
		return inActiveDate;
	}

	/**
	 * Sets the in active date.
	 *
	 * @param inActiveDate the new in active date
	 */
	public void setInActiveDate(Date inActiveDate) {
		this.inActiveDate = inActiveDate;
	}
}
