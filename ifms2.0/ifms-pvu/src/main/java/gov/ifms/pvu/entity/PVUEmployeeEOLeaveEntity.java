package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;

/**
 * The Class PVUEmployeeEOLeaveEntity.
 */
@Entity
@Table(name = "T_PVU_EOL_CREAT", schema = Constant.PVU_SCHEMA)
public class PVUEmployeeEOLeaveEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp eol id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_EOL_CREAT_ID ")
	private long empEolId;

	/** The emp id. */
	@ManyToOne
	@JoinColumn(name = "EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The post id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "POST_ID", referencedColumnName = "POST_ID")
	private EDPMsPostEntity postId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The trans no. */
	@Column(name = "TRN_NO")
	private String transNo;

	/** The initiation date. */
	@Column(name = "INIT_DATE")
	private Date initiationDate;

	/** The start date. */
	@Column(name = "LEAVE_START_DATE")
	private LocalDate startDate;

	/** The end date. */
	@Column(name = "LEAVE_END_DATE")
	private LocalDate endDate;

	/** The order no date. */
	@Column(name = "ORD_NO_DATE")
	private String orderNoDate;

	/** The no of days. */
	@Column(name = "NO_OF_DAYS")
	private int noOfDays;

	/** The remarks. */
	@Column(name = "REMARK")
	private String remarks;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The init date. */
	@Column(name = "REF_DATE")
	private LocalDateTime refDate;

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}
	
	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public EDPMsPostEntity getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(EDPMsPostEntity postId) {
		this.postId = postId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	public Date getInitiationDate() {
		return initiationDate;
	}

	public void setInitiationDate(Date initiationDate) {
		this.initiationDate = initiationDate;
	}

	/**
	 * Gets the emp eol id.
	 *
	 * @return the emp eol id
	 */
	public long getEmpEolId() {
		return empEolId;
	}

	/**
	 * Sets the emp eol id.
	 *
	 * @param empEolId the new emp eol id
	 */
	public void setEmpEolId(long empEolId) {
		this.empEolId = empEolId;
	}

	/**
	 * Gets the trans no.
	 *
	 * @return the trans no
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * Sets the trans no.
	 *
	 * @param transNo the new trans no
	 */
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the order no date.
	 *
	 * @return the order no date
	 */
	public String getOrderNoDate() {
		return orderNoDate;
	}

	/**
	 * Sets the order no date.
	 *
	 * @param orderNoDate the new order no date
	 */
	public void setOrderNoDate(String orderNoDate) {
		this.orderNoDate = orderNoDate;
	}

	/**
	 * Gets the no of days.
	 *
	 * @return the no of days
	 */
	public int getNoOfDays() {
		return noOfDays;
	}

	/**
	 * Sets the no of days.
	 *
	 * @param noOfDays the new no of days
	 */
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the new remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(PVUEmployeEntity empId) {
		this.empId = empId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empEolId, empId, endDate, initiationDate, noOfDays, officeId, orderNoDate, postId, remarks,
				startDate, statusId, transNo);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUEmployeeEOLeaveEntity)) {
			return false;
		}
		PVUEmployeeEOLeaveEntity other = (PVUEmployeeEOLeaveEntity) obj;
		return empEolId == other.empEolId && Objects.equals(empId, other.empId)
				&& Objects.equals(endDate, other.endDate)
				&& Objects.equals(refDate, other.refDate)
				&& Objects.equals(initiationDate, other.initiationDate)
				&& noOfDays == other.noOfDays && Objects.equals(officeId, other.officeId)
				&& Objects.equals(orderNoDate, other.orderNoDate) && Objects.equals(postId, other.postId)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(transNo, other.transNo);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeeEOLeaveEntity [empEolId=" + empEolId + ", empId=" + empId + ", postId=" + postId
				+ ", officeId=" + officeId +
				", refDate=" + refDate +
				", transNo=" + transNo + ", initiationDate=" + initiationDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", orderNoDate=" + orderNoDate + ", noOfDays="
				+ noOfDays + ", remarks=" + remarks + ", statusId=" + statusId + "]";
	}

}
