package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUEmployeeWfHSTDto.
 */
@NativeQueryResultEntity
public class PVUEmployeeWfHSTDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn id. */
	@NativeQueryResultColumn(index = 0)
	public long trnId;
	
	/** The user name. */
	@NativeQueryResultColumn(index = 1)
	public String userName;
	
	/** The post name. */
	@NativeQueryResultColumn(index = 2)
	public String postName;
	
	/** The created date. */
	@NativeQueryResultColumn(index = 3)
	public Date createdDate;
	
	/** The wf name. */
	@NativeQueryResultColumn(index = 4)
	public String wfName;
	
	/** The wf status. */
	@NativeQueryResultColumn(index = 5)
	public String wfStatus;

	/** The wf trn status. */
	@NativeQueryResultColumn(index = 6)
	public String wfTrnStatus;
	
	/** The remark. */
	@NativeQueryResultColumn(index = 7)
	public String remark;

	/** The office name. */
	@NativeQueryResultColumn(index = 8)
	public String officeName;
	
	/** The designation name. */
	@NativeQueryResultColumn(index = 9)
	public String designationName;
	
	/** The wf role name. */
	@NativeQueryResultColumn(index = 10)
	public String wfRoleName;

	/**
	 * Gets the trn id.
	 *
	 * @return the trnId
	 */
	public long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the trnId to set
	 */
	public void setTrnId(long trnId) {
		this.trnId = trnId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the post name.
	 *
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the wf name.
	 *
	 * @return the wfName
	 */
	public String getWfName() {
		return wfName;
	}

	/**
	 * Sets the wf name.
	 *
	 * @param wfName the wfName to set
	 */
	public void setWfName(String wfName) {
		this.wfName = wfName;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Gets the wf trn status.
	 *
	 * @return the wfTrnStatus
	 */
	public String getWfTrnStatus() {
		return wfTrnStatus;
	}

	/**
	 * Sets the wf trn status.
	 *
	 * @param wfTrnStatus the wfTrnStatus to set
	 */
	public void setWfTrnStatus(String wfTrnStatus) {
		this.wfTrnStatus = wfTrnStatus;
	}

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the designation name.
	 *
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets the designation name.
	 *
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Gets the wf role name.
	 *
	 * @return the wfRoleName
	 */
	public String getWfRoleName() {
		return wfRoleName;
	}

	/**
	 * Sets the wf role name.
	 *
	 * @param wfRoleName the wfRoleName to set
	 */
	public void setWfRoleName(String wfRoleName) {
		this.wfRoleName = wfRoleName;
	}

	/**
	 * Instantiates a new PVU employee wf HST dto.
	 */
	public PVUEmployeeWfHSTDto() {
		super();
	}
	
}
