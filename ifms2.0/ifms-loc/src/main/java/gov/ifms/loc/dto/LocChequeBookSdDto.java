package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LOCChequeBookDtlDto.
 *
 * @version v 1.0
 * @created 2021/01/16 14:08:08
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocChequeBookSdDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@NotNull
	private Long id;

	/**
	 * The hdr id.
	 */
	@NotNull
	private Long hdrId;

	/**
	 * The start series.
	 */
	@NotNull
	private String startSeries;

	/**
	 * The end series.
	 */
	@NotNull
	private String endSeries;

	/**
	 * The issue date.
	 */
	@NotNull
	private Date issueDate;

	/**
	 * The is active.
	 */
	@NotNull
	private String isActive;

	/**
	 * The active date.
	 */
	private Date activeDate;

	/**
	 * The inactive date.
	 */
	private Date inActiveDate;

	/**
	 * The wf id.
	 */
	private Long wfId;

	/**
	 * The wf role id.
	 */
	private Long wfRoleId;

	/** The flag. */
	private Long flag = 0L;

	/** The status id. */
	private Long statusId;
	/**
	 * The chq inv in active list.
	 */
	private List<LocChequeBookSdDto> chqInvInActiveList;

	/**
	 * The loc in active list.
	 */
	private List<LocChequeBookSdDto> locInActiveList;

	/**
	 * The loc active list.
	 */
	private List<LocChequeBookSdDto> locActiveList;

	/**
	 * The view list.
	 */
	private List<LocChequeBookSdDto> viewList;

	/**
	 * LOCChequeBookDtlDto Constructor.
	 */
	public LocChequeBookSdDto() {
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

	/**
	 * Gets the flag.
	 *
	 * @return the flag
	 */
	public Long getFlag() {
		return flag;
	}

	/**
	 * Sets the flag.
	 *
	 * @param flag the new flag
	 */
	public void setFlag(Long flag) {
		this.flag = flag;
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
	 * Gets the chq inv in active list.
	 *
	 * @return the chq inv in active list
	 */
	public List<LocChequeBookSdDto> getChqInvInActiveList() {
		return chqInvInActiveList;
	}

	/**
	 * Sets the chq inv in active list.
	 *
	 * @param chqInvInActiveList the new chq inv in active list
	 */
	public void setChqInvInActiveList(List<LocChequeBookSdDto> chqInvInActiveList) {
		this.chqInvInActiveList = chqInvInActiveList;
	}

	/**
	 * Gets the loc in active list.
	 *
	 * @return the loc in active list
	 */
	public List<LocChequeBookSdDto> getLocInActiveList() {
		return locInActiveList;
	}

	/**
	 * Sets the loc in active list.
	 *
	 * @param locInActiveList the new loc in active list
	 */
	public void setLocInActiveList(List<LocChequeBookSdDto> locInActiveList) {
		this.locInActiveList = locInActiveList;
	}

	/**
	 * Gets the loc active list.
	 *
	 * @return the loc active list
	 */
	public List<LocChequeBookSdDto> getLocActiveList() {
		return locActiveList;
	}

	/**
	 * Sets the loc active list.
	 *
	 * @param locActiveList the new loc active list
	 */
	public void setLocActiveList(List<LocChequeBookSdDto> locActiveList) {
		this.locActiveList = locActiveList;
	}

	/**
	 * Gets the view list.
	 *
	 * @return the view list
	 */
	public List<LocChequeBookSdDto> getViewList() {
		return viewList;
	}

	/**
	 * Sets the view list.
	 *
	 * @param viewList the new view list
	 */
	public void setViewList(List<LocChequeBookSdDto> viewList) {
		this.viewList = viewList;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocChequeBookSdDto))
			return false;
		if (!super.equals(o))
			return false;
		LocChequeBookSdDto that = (LocChequeBookSdDto) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getHdrId(), that.getHdrId())
				&& Objects.equals(getStartSeries(), that.getStartSeries())
				&& Objects.equals(getEndSeries(), that.getEndSeries())
				&& Objects.equals(getIssueDate(), that.getIssueDate())
				&& Objects.equals(getIsActive(), that.getIsActive())
				&& Objects.equals(getActiveDate(), that.getActiveDate())
				&& Objects.equals(getInActiveDate(), that.getInActiveDate())
				&& Objects.equals(getWfId(), that.getWfId()) && Objects.equals(getWfRoleId(), that.getWfRoleId())
				&& Objects.equals(getFlag(), that.getFlag()) && Objects.equals(getStatusId(), that.getStatusId())
				&& Objects.equals(getChqInvInActiveList(), that.getChqInvInActiveList())
				&& Objects.equals(getLocInActiveList(), that.getLocInActiveList())
				&& Objects.equals(getLocActiveList(), that.getLocActiveList())
				&& Objects.equals(getViewList(), that.getViewList());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getHdrId(), getStartSeries(), getEndSeries(), getIssueDate(),
				getIsActive(), getActiveDate(), getInActiveDate(), getWfId(), getWfRoleId(), getFlag(), getStatusId(),
				getChqInvInActiveList(), getLocInActiveList(), getLocActiveList(), getViewList());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocChequeBookSdDto{" + "id=" + id + ", hdrId=" + hdrId + ", startSeries='" + startSeries + '\''
				+ ", endSeries='" + endSeries + '\'' + ", issueDate=" + issueDate + ", isActive='" + isActive + '\''
				+ ", activeDate=" + activeDate + ", inActiveDate=" + inActiveDate + ", wfId=" + wfId + ", wfRoleId="
				+ wfRoleId + ", flag=" + flag + ", statusId=" + statusId + ", chqInvInActiveList=" + chqInvInActiveList
				+ ", locInActiveList=" + locInActiveList + ", locActiveList=" + locActiveList + ", viewList=" + viewList
				+ '}';
	}
}
