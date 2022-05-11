package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISEmployeeMonthlyProgressCountReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String empId;
	
	@NativeQueryResultColumn(index = 1)
	private String empName;

	@NativeQueryResultColumn(index = 2)
	private String openingBalance;
	
	@NativeQueryResultColumn(index = 3)
	private String receivedCases;
	
	@NativeQueryResultColumn(index = 4)
	private String authorizedCases;

	@NativeQueryResultColumn(index = 5)
	private String returnedCases;
	
	@NativeQueryResultColumn(index = 6)
	private String rejectedCases;

	@NativeQueryResultColumn(index = 7)
	private String totalCases;

	@NativeQueryResultColumn(index = 8)
	private String closingBalance;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}

	public String getReceivedCases() {
		return receivedCases;
	}

	public void setReceivedCases(String receivedCases) {
		this.receivedCases = receivedCases;
	}

	public String getAuthorizedCases() {
		return authorizedCases;
	}

	public void setAuthorizedCases(String authorizedCases) {
		this.authorizedCases = authorizedCases;
	}

	public String getReturnedCases() {
		return returnedCases;
	}

	public void setReturnedCases(String returnedCases) {
		this.returnedCases = returnedCases;
	}

	public String getRejectedCases() {
		return rejectedCases;
	}

	public void setRejectedCases(String rejectedCases) {
		this.rejectedCases = rejectedCases;
	}

	public String getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}

	public String getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(String closingBalance) {
		this.closingBalance = closingBalance;
	}







	
	
	
}
