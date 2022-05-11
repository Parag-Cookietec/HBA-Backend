package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChqBookActInActDto.
 */
@NativeQueryResultEntity
public class LocChqBookActInActDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The issue date. */
	@NativeQueryResultColumn(index = 0)
	private Date issueDate;

	/** The start series. */
	@NativeQueryResultColumn(index = 1)
	private String startSeries;

	/** The end series. */
	@NativeQueryResultColumn(index = 2)
	private String endSeries;

	/** The active date. */
	@NativeQueryResultColumn(index = 3)
	private Date activeDate;

	/** The in active date. */
	@NativeQueryResultColumn(index = 4)
	private Date inActiveDate;



	/**
	 * @return the issueDate
	 */
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @return the startSeries
	 */
	public String getStartSeries() {
		return startSeries;
	}

	/**
	 * @param startSeries the startSeries to set
	 */
	public void setStartSeries(String startSeries) {
		this.startSeries = startSeries;
	}

	/**
	 * @return the endSeries
	 */
	public String getEndSeries() {
		return endSeries;
	}

	/**
	 * @param endSeries the endSeries to set
	 */
	public void setEndSeries(String endSeries) {
		this.endSeries = endSeries;
	}

	/**
	 * @return the activeDate
	 */
	public Date getActiveDate() {
		return activeDate;
	}

	/**
	 * @param activeDate the activeDate to set
	 */
	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	/**
	 * @return the inActiveDate
	 */
	public Date getInActiveDate() {
		return inActiveDate;
	}

	/**
	 * @param inActiveDate the inActiveDate to set
	 */
	public void setInActiveDate(Date inActiveDate) {
		this.inActiveDate = inActiveDate;
	}

}
