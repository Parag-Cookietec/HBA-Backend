package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISInwardCaseLookupView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String lookUpCode;
	
	@NativeQueryResultColumn(index = 1)
	private Long lookUpId;

	@NativeQueryResultColumn(index = 2)
	private String lookUpName;

	public String getLookUpCode() {
		return lookUpCode;
	}

	public void setLookUpCode(String lookUpCode) {
		this.lookUpCode = lookUpCode;
	}

	public Long getLookUpId() {
		return lookUpId;
	}

	public void setLookUpId(Long lookUpId) {
		this.lookUpId = lookUpId;
	}

	public String getLookUpName() {
		return lookUpName;
	}

	public void setLookUpName(String lookUpName) {
		this.lookUpName = lookUpName;
	}


	
	
	
}
