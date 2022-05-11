package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChqBookList.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocChqBookList implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The issue date. */
	@NativeQueryResultColumn(index = 0)
	private Date issueDate;

	/** The start series. */
	@NativeQueryResultColumn(index = 1)
	private Long startSeries;

	/** The end series. */
	@NativeQueryResultColumn(index = 2)
	private Long endSeries;

	/** The div code. */
	@NativeQueryResultColumn(index = 3)
	private String divCode;

	/** The active date. */
	private Date activeDate;

	/** The inactive date. */
	private Date inActiveDate;

	private List<LocChqBookActInActDto> locInActiveList;

	/** The active list. */
	private List<LocChqBookActInActDto> locActiveList;

	/** The chq inv inactive list. */
	private List<LocChqBookActInActDto> chqInvInActiveList;

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
	public Long getStartSeries() {
		return startSeries;
	}

	/**
	 * @param startSeries the startSeries to set
	 */
	public void setStartSeries(Long startSeries) {
		this.startSeries = startSeries;
	}

	/**
	 * @return the endSeries
	 */
	public Long getEndSeries() {
		return endSeries;
	}

	/**
	 * @param endSeries the endSeries to set
	 */
	public void setEndSeries(Long endSeries) {
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

	

	/**
	 * @return the locInActiveList
	 */
	public List<LocChqBookActInActDto> getLocInActiveList() {
		return locInActiveList;
	}

	/**
	 * @param locInActiveList the locInActiveList to set
	 */
	public void setLocInActiveList(List<LocChqBookActInActDto> locInActiveList) {
		this.locInActiveList = locInActiveList;
	}

	/**
	 * @return the locActiveList
	 */
	public List<LocChqBookActInActDto> getLocActiveList() {
		return locActiveList;
	}

	/**
	 * @param locActiveList the locActiveList to set
	 */
	public void setLocActiveList(List<LocChqBookActInActDto> locActiveList) {
		this.locActiveList = locActiveList;
	}

	/**
	 * @return the chqInvInActiveList
	 */
	public List<LocChqBookActInActDto> getChqInvInActiveList() {
		return chqInvInActiveList;
	}

	/**
	 * @param chqInvInActiveList the chqInvInActiveList to set
	 */
	public void setChqInvInActiveList(List<LocChqBookActInActDto> chqInvInActiveList) {
		this.chqInvInActiveList = chqInvInActiveList;
	}

	/**
	 * @return the divCode
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * @param divCode the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

}
