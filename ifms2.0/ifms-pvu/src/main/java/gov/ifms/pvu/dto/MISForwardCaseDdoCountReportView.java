package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.common.util.Utils;

/**
 */
@NativeQueryResultEntity
public class MISForwardCaseDdoCountReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private Long distId;
	
	@NativeQueryResultColumn(index = 1)
	private String distName;
	
	@NativeQueryResultColumn(index = 2)
	private Long officeId;
	
	@NativeQueryResultColumn(index = 3)
	private String officeName;

	
	@NativeQueryResultColumn(index = 4)
	private Long authCases;
	
	@NativeQueryResultColumn(index = 5)
	private Long returnCases;
	
	@NativeQueryResultColumn(index = 6)
	private Long inProgress;
	
	@NativeQueryResultColumn(index = 7)
	private Long rejectedCases;
	
	@NativeQueryResultColumn(index = 8)
	private Long totalCases;

	public Long getDistId() {
		return distId;
	}

	public void setDistId(Long distId) {
		this.distId = distId;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
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

	public Long getInProgress() {
		return inProgress;
	}

	public void setInProgress(Long inProgress) {
		this.inProgress = inProgress;
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
	
	
	
	
}
