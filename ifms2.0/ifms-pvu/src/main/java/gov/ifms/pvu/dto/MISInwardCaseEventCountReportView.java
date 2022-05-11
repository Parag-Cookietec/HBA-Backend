package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISInwardCaseEventCountReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String lookUpInfoName;
	
	@NativeQueryResultColumn(index = 1)
	private Long inwardCases;

	@NativeQueryResultColumn(index = 2)
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
