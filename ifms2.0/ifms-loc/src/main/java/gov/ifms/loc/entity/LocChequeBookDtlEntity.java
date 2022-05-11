package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LOCChequeBookDtlEntity.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:08:08
 *
 */
@Entity
@Table(name = "TLOC_LC_CHEQUEBOOK_D", schema = LocConstant.LOC_SCHEMA)
public class LocChequeBookDtlEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_CHEQUEBOOK_D_ID")
	private Long id;
	/** The hdr id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LC_CHEQUEBOOK_ID", referencedColumnName = "LC_CHEQUEBOOK_ID")
	private LocChequeBookHdrEntity hdrId;

	/** The start series. */
	@Column(name = "STARTING_SERIES")
	private String startSeries;

	/** The end series. */
	@Column(name = "END_SERIES")
	private String endSeries;

	/** The issue date. */
	@Column(name = "ISSUE_DT")
	private Date issueDate;

	/** The is active. */
	@Column(name = "IS_ACTIVE")
	private String isActive;

	/** The active date. */
	@Column(name = "ACTIVE_DT")
	private Date activeDate;

	/** The inactive date. */
	@Column(name = "INACTIVE_DT")
	private Date inactiveDate;

	/** The wf id. */
	@Column(name = "WF_ID")
	private Long wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The flag. */
	@Column(name = "FLAG")
	private Long flag;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/**
	 * LOCChequeBookDtlEntity Constructor.
	 */
	public LocChequeBookDtlEntity() {
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
	 * Gets the hdr id.
	 *
	 * @return the hdrId
	 */
	public LocChequeBookHdrEntity getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the hdrId to set
	 */
	public void setHdrId(LocChequeBookHdrEntity hdrId) {
		this.hdrId = hdrId;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocChequeBookDtlEntity))
			return false;
		LocChequeBookDtlEntity entity = (LocChequeBookDtlEntity) o;
		return Objects.equals(getId(), entity.getId()) && Objects.equals(getHdrId(), entity.getHdrId())
				&& Objects.equals(getStartSeries(), entity.getStartSeries())
				&& Objects.equals(getEndSeries(), entity.getEndSeries())
				&& Objects.equals(getIssueDate(), entity.getIssueDate())
				&& Objects.equals(getIsActive(), entity.getIsActive())
				&& Objects.equals(getActiveDate(), entity.getActiveDate())
				&& Objects.equals(getInactiveDate(), entity.getInactiveDate())
				&& Objects.equals(getWfId(), entity.getWfId()) && Objects.equals(getWfRoleId(), entity.getWfRoleId())
				&& Objects.equals(getFlag(), entity.getFlag()) && Objects.equals(getStatusId(), entity.getStatusId());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getHdrId(), getStartSeries(), getEndSeries(), getIssueDate(), getIsActive(),
				getActiveDate(), getInactiveDate(), getWfId(), getWfRoleId(), getFlag(), getStatusId());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocChequeBookDtlEntity{" + "id=" + id + ", hdrId=" + hdrId + ", startSeries='" + startSeries + '\''
				+ ", endSeries='" + endSeries + '\'' + ", issueDate=" + issueDate + ", isActive='" + isActive + '\''
				+ ", activeDate=" + activeDate + ", inactiveDate=" + inactiveDate + ", wfId=" + wfId + ", wfRoleId="
				+ wfRoleId + ", flag=" + flag + ", statusId=" + statusId + '}';
	}
}
