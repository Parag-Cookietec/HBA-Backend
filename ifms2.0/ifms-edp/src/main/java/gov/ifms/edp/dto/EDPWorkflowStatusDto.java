package gov.ifms.edp.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The EDPWorkflowStatusDto class.
 * 
 */
@NativeQueryResultEntity
public class EDPWorkflowStatusDto {

	/** The office id. */
	@NativeQueryResultColumn(index = 0)
	private Boolean wfInitStatus;

	/** The Employee Number. */
	@NativeQueryResultColumn(index = 1)
	private String trnNo;

	/** The Employee Number. */
	@NativeQueryResultColumn(index = 2)
	private String empNo;

	/** The Employee Name. */
	@NativeQueryResultColumn(index = 3)
	private String empName;

	/** The Post of Employee. */
	@NativeQueryResultColumn(index = 4)
	private String postName;

	/** The Office of Employee. */
	@NativeQueryResultColumn(index = 5)
	private String officeName;

	/** The District Name. */
	@NativeQueryResultColumn(index = 6)
	private String district;

	/** The DDO Number of Office. */
	@NativeQueryResultColumn(index = 7)
	private String ddoNo;

	/** The Cardex Number of Office. */
	@NativeQueryResultColumn(index = 8)
	private String cardexNo;

	/**
	 * Default Constructor
	 */
	public EDPWorkflowStatusDto() {
		super();
	}

	/**
	 * Get Workflow Init status.
	 * 
	 * @return wfInitStatus
	 */
	public Boolean getWfInitStatus() {
		return wfInitStatus;
	}

	/**
	 * Set Workflow Init status.
	 * 
	 * @param wfInitStatus
	 */
	public void setWfInitStatus(Boolean wfInitStatus) {
		this.wfInitStatus = wfInitStatus;
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the cardexNo
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}
}
