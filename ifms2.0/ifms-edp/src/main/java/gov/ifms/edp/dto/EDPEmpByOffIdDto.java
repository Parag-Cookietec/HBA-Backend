package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class EDPEmpByOffIdDto implements Comparable<EDPEmpByOffIdDto>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** the emp Id */
	@NativeQueryResultColumn(index = 0)
	private long empId;
	/** the emp number */
	@NativeQueryResultColumn(index = 1)
	private long empNo;

	@NativeQueryResultColumn(index = 2)
	private String empName;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}

	@Override
	public int compareTo(EDPEmpByOffIdDto obj) {
		long compareEmpId = obj.getEmpNo();
		return (int) (this.empNo  - compareEmpId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, empName, empNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPEmpByOffIdDto other = (EDPEmpByOffIdDto) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(empName, other.empName)
				&& Objects.equals(empNo, other.empNo);
	}
	
}
