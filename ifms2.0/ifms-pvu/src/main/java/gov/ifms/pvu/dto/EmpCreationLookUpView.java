package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class EmpCreationLookUpView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String lookUpName;
	
	@NativeQueryResultColumn(index = 1)
	private Long lookUpInfoId;

	@NativeQueryResultColumn(index = 2)
	private String lookUpInfoName;

	public String getLookUpName() {
		return lookUpName;
	}

	public void setLookUpName(String lookUpName) {
		this.lookUpName = lookUpName;
	}

	public Long getLookUpInfoId() {
		return lookUpInfoId;
	}

	public void setLookUpInfoId(Long lookUpInfoId) {
		this.lookUpInfoId = lookUpInfoId;
	}

	public String getLookUpInfoName() {
		return lookUpInfoName;
	}

	public void setLookUpInfoName(String lookUpInfoName) {
		this.lookUpInfoName = lookUpInfoName;
	}



	
	
	
	
}
