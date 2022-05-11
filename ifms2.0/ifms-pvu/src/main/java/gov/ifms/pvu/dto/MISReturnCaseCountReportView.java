package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.common.util.Utils;

/**
 */
@NativeQueryResultEntity
public class MISReturnCaseCountReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String lookUpInfoId;
	
	@NativeQueryResultColumn(index = 1)
	private String lookUpInfoName;

	@NativeQueryResultColumn(index = 2)
	private String lookUpInfo;

	public String getLookUpInfoId() {
		return lookUpInfoId;
	}

	public void setLookUpInfoId(String lookUpInfoId) {
		this.lookUpInfoId = lookUpInfoId;
	}

	public String getLookUpInfoName() {
		return lookUpInfoName;
	}

	public void setLookUpInfoName(String lookUpInfoName) {
		this.lookUpInfoName = lookUpInfoName;
	}

	public String getLookUpInfo() {
		return lookUpInfo;
	}

	public void setLookUpInfo(String lookUpInfo) {
		this.lookUpInfo = lookUpInfo;
	}



	
	
	
	
}
