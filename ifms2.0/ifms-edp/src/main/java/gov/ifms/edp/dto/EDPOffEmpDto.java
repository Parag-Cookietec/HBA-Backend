package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class EDPOffEmpDto.
 */
public class EDPOffEmpDto implements Comparable<EDPOffEmpDto>, Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  the emp Id. */
	@NativeQueryResultColumn(index = 0)
	private long empId;
	
	/**  the emp number. */
	@NativeQueryResultColumn(index = 1)
	private String empNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 2)
	private String empName;

	
	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public long getEmpId() {
		return empId;
	}


	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the emp no
	 */
	public String getEmpNo() {
		return empNo;
	}


	/**
	 * Sets the emp no.
	 *
	 * @param empNo the new emp no
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	/**
	 * Gets the emp name.
	 *
	 * @return the emp name
	 */
	public String getEmpName() {
		return empName;
	}


	/**
	 * Sets the emp name.
	 *
	 * @param empName the new emp name
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empId, empName, empNo);
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
		EDPOffEmpDto other = (EDPOffEmpDto) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(empName, other.empName)
				&& Objects.equals(empNo, other.empNo);
	}


	/**
	 * Compare to.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(EDPOffEmpDto o) {
		String compareEmpId = o.getEmpNo();
		return (null != compareEmpId && null != this.empNo) ? (this.empNo.compareTo(compareEmpId)) : 0;
	}

}
