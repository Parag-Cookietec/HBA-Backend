package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;


/**
 * The Class PVUEmployeHistoryEntity.
 *
 * @version v 1.0
 * @created 2019/11/29 17:29:29
 *
 */
@Entity
@Table(name = "T_EMP_PRV_HIST", schema = Constant.PVU_SCHEMA)
public class PVUEmployeHistoryEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employe histroy id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_PRV_HIST_ID")
	private long employeHistroyId;

	/** The employement type. */
	@OneToOne
	@JoinColumn(name = "EMPLOYMENT_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity employementType;

	/** The dept name. */
	@Column(name = "DEPT_NAME")
	private String deptName;

	/** The office name. */
	@Column(name = "OFF_NAME ")
	private String officeName;

	/** The office add. */
	@Column(name = "OFF_ADD")
	private String officeAdd;

	/** The emp designation hist. */
	@Column(name = "EMP_DSGN")
	private String empDesignationHist;

	/** The from date. */
	@Column(name = "FROM_DATE")
	private Date fromDate;

	/** The to date. */
	@Column(name = "TO_DATE")
	private Date toDate;

	/** The last pay drawn. */
	@Column(name = "LAST_PAY_DRWN")
	private double lastPayDrawn;

	/** The emp service continuation. */
	@OneToOne
	@JoinColumn(name = "IS_SERV_CONT", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empServiceContinuation;

	/** The order no date. */
	@Column(name = "ORDER_NO_DATE")
	private String orderNoDate;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Integer statusId;

	/** The pvu employe entity. */
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;
	
	@Column(name = "CHANGE_TYPE")
	private long changeType;
	
	
	/**
	 * @return the changeType
	 */
	public long getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(long changeType) {
		this.changeType = changeType;
	}

	/**
	 * Gets the pvu employe entity.
	 *
	 * @return the pvuEmployeEntity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the pvuEmployeEntity to set
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	/**
	 * Gets the employe histroy id.
	 *
	 * @return the employeHistroyId
	 */
	public long getEmployeHistroyId() {
		return employeHistroyId;
	}

	/**
	 * Sets the employe histroy id.
	 *
	 * @param employeHistroyId the employeHistroyId to set
	 */
	public void setEmployeHistroyId(long employeHistroyId) {
		this.employeHistroyId = employeHistroyId;
	}

	/**
	 * Gets the employement type.
	 *
	 * @return the employementType
	 */
	public EDPLuLookUpInfoEntity getEmployementType() {
		return employementType;
	}

	/**
	 * Sets the employement type.
	 *
	 * @param employementType the employementType to set
	 */
	public void setEmployementType(EDPLuLookUpInfoEntity employementType) {
		this.employementType = employementType;
	}

	/**
	 * Gets the dept name.
	 *
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * Sets the dept name.
	 *
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the office add.
	 *
	 * @return the officeAdd
	 */
	public String getOfficeAdd() {
		return officeAdd;
	}

	/**
	 * Sets the office add.
	 *
	 * @param officeAdd the officeAdd to set
	 */
	public void setOfficeAdd(String officeAdd) {
		this.officeAdd = officeAdd;
	}

	/**
	 * Gets the emp designation hist.
	 *
	 * @return the empDesignationHist
	 */
	public String getEmpDesignationHist() {
		return empDesignationHist;
	}

	/**
	 * Sets the emp designation hist.
	 *
	 * @param empDesignationHist the empDesignationHist to set
	 */
	public void setEmpDesignationHist(String empDesignationHist) {
		this.empDesignationHist = empDesignationHist;
	}

	/**
	 * Gets the from date.
	 *
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * Sets the from date.
	 *
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Gets the to date.
	 *
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * Sets the to date.
	 *
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * Gets the last pay drawn.
	 *
	 * @return the lastPayDrawn
	 */
	public double getLastPayDrawn() {
		return lastPayDrawn;
	}

	/**
	 * Sets the last pay drawn.
	 *
	 * @param lastPayDrawn the lastPayDrawn to set
	 */
	public void setLastPayDrawn(double lastPayDrawn) {
		this.lastPayDrawn = lastPayDrawn;
	}

	/**
	 * Gets the emp service continuation.
	 *
	 * @return the empServiceContinuation
	 */
	public EDPLuLookUpInfoEntity getEmpServiceContinuation() {
		return empServiceContinuation;
	}

	/**
	 * Sets the emp service continuation.
	 *
	 * @param empServiceContinuation the empServiceContinuation to set
	 */
	public void setEmpServiceContinuation(EDPLuLookUpInfoEntity empServiceContinuation) {
		this.empServiceContinuation = empServiceContinuation;
	}

	/**
	 * Gets the order no date.
	 *
	 * @return the orderNoDate
	 */
	public String getOrderNoDate() {
		return orderNoDate;
	}

	/**
	 * Sets the order no date.
	 *
	 * @param orderNoDate the orderNoDate to set
	 */
	public void setOrderNoDate(String orderNoDate) {
		this.orderNoDate = orderNoDate;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeHistoryEntity [employeHistroyId=" + employeHistroyId + ", employementType=" + employementType
				+ ", deptName=" + deptName + ", officeName=" + officeName + ", officeAdd=" + officeAdd
				+ ", empDesignationHist=" + empDesignationHist + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", lastPayDrawn=" + lastPayDrawn + ", empServiceContinuation=" + empServiceContinuation
				+ ", orderNoDate=" + orderNoDate + ", statusId=" + statusId + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(deptName, empDesignationHist, empServiceContinuation, employeHistroyId, employementType,
				fromDate, lastPayDrawn, officeAdd, officeName, orderNoDate, statusId, toDate);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeHistoryEntity other = (PVUEmployeHistoryEntity) obj;
		return Objects.equals(deptName, other.deptName) && Objects.equals(empDesignationHist, other.empDesignationHist)
				&& Objects.equals(empServiceContinuation, other.empServiceContinuation)
				&& employeHistroyId == other.employeHistroyId && Objects.equals(employementType, other.employementType)
				&& Objects.equals(fromDate, other.fromDate)
				&& Double.doubleToLongBits(lastPayDrawn) == Double.doubleToLongBits(other.lastPayDrawn)
				&& Objects.equals(officeAdd, other.officeAdd) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(orderNoDate, other.orderNoDate) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(toDate, other.toDate);
	}

}
