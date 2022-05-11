package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISDurationPendingEnumTwoReport implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	

	@NativeQueryResultColumn(index = 0)
	private Long empNumber;
	
	@NativeQueryResultColumn(index = 1)
	private String empName;

//	@NativeQueryResultColumn(index = 2)
//	private Date createdDate;

	@NativeQueryResultColumn(index = 2)
	private Long pendingCases;

	
	public Long getPendingCases() {
		return pendingCases;
	}

	public void setPendingCases(Long pendingCases) {
		this.pendingCases = pendingCases;
	}

	public Long getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(Long empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

//	public Date getCreatedDate() {
//		return createdDate;
//	}

//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}

	

	
	
	
	
	
	


	
	
	
	
}
