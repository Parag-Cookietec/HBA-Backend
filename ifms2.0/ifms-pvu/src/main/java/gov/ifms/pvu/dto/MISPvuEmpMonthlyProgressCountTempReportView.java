package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISPvuEmpMonthlyProgressCountTempReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private Long userId;
	
	@NativeQueryResultColumn(index = 1)
	private String userName;
	
	@NativeQueryResultColumn(index = 2)
	private Long openingBal;
	
	@NativeQueryResultColumn(index = 3)
	private Long receivedCases;
	
	@NativeQueryResultColumn(index = 4)
	private Long authorisedCases;
	
	@NativeQueryResultColumn(index = 5)
	private Long returnCases;
	
	@NativeQueryResultColumn(index = 6)
	private Long rejectedCases;
	
	@NativeQueryResultColumn(index = 7)
	private Long totalCases;
	
	@NativeQueryResultColumn(index = 8)
	private Long closingBal;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getOpeningBal() {
		return openingBal;
	}

	public void setOpeningBal(Long openingBal) {
		this.openingBal = openingBal;
	}

	public Long getReceivedCases() {
		return receivedCases;
	}

	public void setReceivedCases(Long receivedCases) {
		this.receivedCases = receivedCases;
	}

	public Long getAuthorisedCases() {
		return authorisedCases;
	}

	public void setAuthorisedCases(Long authorisedCases) {
		this.authorisedCases = authorisedCases;
	}

	public Long getReturnCases() {
		return returnCases;
	}

	public void setReturnCases(Long returnCases) {
		this.returnCases = returnCases;
	}

	public Long getRejectedCases() {
		return rejectedCases;
	}

	public void setRejectedCases(Long rejectedCases) {
		this.rejectedCases = rejectedCases;
	}

	public Long getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(Long totalCases) {
		this.totalCases = totalCases;
	}

	public Long getClosingBal() {
		return closingBal;
	}

	public void setClosingBal(Long closingBal) {
		this.closingBal = closingBal;
	}

	
	
	
	
	
	
}
