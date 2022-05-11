package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUEmployeeTypeListingSPDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String  refNo;
	
	@NativeQueryResultColumn(index = 1)
	private String  refDate;
	
	@NativeQueryResultColumn(index = 2)
	private Long empNo;
	
	@NativeQueryResultColumn(index = 3)
	private String  empName;
	
	@NativeQueryResultColumn(index = 4)
	private String currentPayTypeName;
	
	@NativeQueryResultColumn(index = 5)
	private String updatedPayTypeName;

	@NativeQueryResultColumn(index = 6)
	private String desigName;
		
	@NativeQueryResultColumn(index = 7)
	private String officeName;
	
	@NativeQueryResultColumn(index = 8)
	private Long statusId;
	
	@NativeQueryResultColumn(index = 9)
	private String status;

	@NativeQueryResultColumn(index = 10)
	private Long sdId;

	/**
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * @return the refDate
	 */
	public String getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	/**
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
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
	 * @return the currentPayTypeName
	 */
	public String getCurrentPayTypeName() {
		return currentPayTypeName;
	}

	/**
	 * @param currentPayTypeName the currentPayTypeName to set
	 */
	public void setCurrentPayTypeName(String currentPayTypeName) {
		this.currentPayTypeName = currentPayTypeName;
	}

	/**
	 * @return the updatedPayTypeName
	 */
	public String getUpdatedPayTypeName() {
		return updatedPayTypeName;
	}

	/**
	 * @param updatedPayTypeName the updatedPayTypeName to set
	 */
	public void setUpdatedPayTypeName(String updatedPayTypeName) {
		this.updatedPayTypeName = updatedPayTypeName;
	}

	/**
	 * @return the desigName
	 */
	public String getDesigName() {
		return desigName;
	}

	/**
	 * @param desigName the desigName to set
	 */
	public void setDesigName(String desigName) {
		this.desigName = desigName;
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
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the sdId
	 */
	public Long getSdId() {
		return sdId;
	}

	/**
	 * @param sdId the sdId to set
	 */
	public void setSdId(Long sdId) {
		this.sdId = sdId;
	}

}
