package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeHistoryDto.
 * 
 * @version v 1.0
 * @created 2019/11/29 17:29:29
 *
 */
public class PVUEmployeHistoryEditFormdataDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employement type. */
	private long employementType;
	private String employementTypeName;

	/** The dept name. */
	private String deptName;

	/** The office name. */
	private String officeName;

	/** The office add. */
	private String officeAdd;

	/** The emp designation hist. */
	private String empDesignationHist;

	/** The from date. */
	private String fromDate;

	/** The to date. */
	private String toDate;

	/** The last pay drawn. */
	private double lastPayDrawn;

	/** The emp service continuation. */
	private long empServiceContinuation;
	private String empServiceContinuationName;

	/** The employe histroy id. */
	private long employeHistroyId;

	/** The emp id. */
	private long empId;

	/** The order no date. */
	private String orderNoDate;
	
	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
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
	 * PVUEmployeHistoryDto Constructor.
	 */
	public PVUEmployeHistoryEditFormdataDto() {
		super();
	}

	/**
	 * Gets the employement type.
	 *
	 * @return the employementType
	 */
	public long getEmployementType() {
		return employementType;
	}

	/**
	 * Sets the employement type.
	 *
	 * @param employementType the employementType to set
	 */
	public void setEmployementType(long employementType) {
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
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
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
	public long getEmpServiceContinuation() {
		return empServiceContinuation;
	}

	/**
	 * Sets the emp service continuation.
	 *
	 * @param empServiceContinuation the empServiceContinuation to set
	 */
	public void setEmpServiceContinuation(long empServiceContinuation) {
		this.empServiceContinuation = empServiceContinuation;
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
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
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
	 * @return the employementTypeName
	 */
	public String getEmployementTypeName() {
		return employementTypeName;
	}

	/**
	 * @param employementTypeName the employementTypeName to set
	 */
	public void setEmployementTypeName(String employementTypeName) {
		this.employementTypeName = employementTypeName;
	}

	/**
	 * @return the empServiceContinuationName
	 */
	public String getEmpServiceContinuationName() {
		return empServiceContinuationName;
	}

	/**
	 * @param empServiceContinuationName the empServiceContinuationName to set
	 */
	public void setEmpServiceContinuationName(String empServiceContinuationName) {
		this.empServiceContinuationName = empServiceContinuationName;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeHistoryDto [employementType=" + employementType + ", deptName=" + deptName + ", officeName="
				+ officeName + ", officeAdd=" + officeAdd + ", empDesignationHist=" + empDesignationHist + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", lastPayDrawn=" + lastPayDrawn + ", empServiceContinuation="
				+ empServiceContinuation + ", employeHistroyId=" + employeHistroyId + ", empId=" + empId
				+ ", orderNoDate=" + orderNoDate + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(deptName, empDesignationHist, empId, empServiceContinuation, employeHistroyId,
				employementType, fromDate, lastPayDrawn, officeAdd, officeName, orderNoDate, toDate);
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
		PVUEmployeHistoryEditFormdataDto other = (PVUEmployeHistoryEditFormdataDto) obj;
		return Objects.equals(deptName, other.deptName) && Objects.equals(empDesignationHist, other.empDesignationHist)
				&& empId == other.empId && empServiceContinuation == other.empServiceContinuation
				&& employeHistroyId == other.employeHistroyId && employementType == other.employementType
				&& Objects.equals(fromDate, other.fromDate)
				&& Double.doubleToLongBits(lastPayDrawn) == Double.doubleToLongBits(other.lastPayDrawn)
				&& Objects.equals(officeAdd, other.officeAdd) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(orderNoDate, other.orderNoDate) && Objects.equals(toDate, other.toDate);
	}

}
