package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISEmpWiseWorkdoneReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private Long totalRowCount;

	@NativeQueryResultColumn(index = 1)
	private String empName;

	@NativeQueryResultColumn(index = 2)
	private Long authCases;

	@NativeQueryResultColumn(index = 3)
	private Long returnCases;

	@NativeQueryResultColumn(index = 4)
	private Long totalCases;

	@NativeQueryResultColumn(index = 5)
	private Long employeeNo;
	public Long getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(Long totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getAuthCases() {
		return authCases;
	}

	public void setAuthCases(Long authCases) {
		this.authCases = authCases;
	}

	public Long getReturnCases() {
		return returnCases;
	}

	public void setReturnCases(Long returnCases) {
		this.returnCases = returnCases;
	}

	public Long getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(Long totalCases) {
		this.totalCases = totalCases;
	}

	public Long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}
}
