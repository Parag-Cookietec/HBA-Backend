package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISPvuEventStatusReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private Long authCases;
	
	@NativeQueryResultColumn(index = 1)
	private Long returnCases;
	
	@NativeQueryResultColumn(index = 2)
	private Long pendingCases;
	
	@NativeQueryResultColumn(index = 3)
	private Long totalCases;

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

	public Long getPendingCases() {
		return pendingCases;
	}

	public void setPendingCases(Long pendingCases) {
		this.pendingCases = pendingCases;
	}

	public Long getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(Long totalCases) {
		this.totalCases = totalCases;
	}

	
	
	
}
