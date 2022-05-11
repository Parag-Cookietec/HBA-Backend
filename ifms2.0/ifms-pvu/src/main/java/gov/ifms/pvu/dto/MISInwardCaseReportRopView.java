package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISInwardCaseReportRopView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String lookUpInfoName;
	
	@NativeQueryResultColumn(index = 1)
	private Long inwardCases;

	public String getLookUpInfoName() {
		return lookUpInfoName;
	}

	public void setLookUpInfoName(String lookUpInfoName) {
		this.lookUpInfoName = lookUpInfoName;
	}

	public Long getInwardCases() {
		return inwardCases;
	}

	public void setInwardCases(Long inwardCases) {
		this.inwardCases = inwardCases;
	}




	
	
	
	
}
