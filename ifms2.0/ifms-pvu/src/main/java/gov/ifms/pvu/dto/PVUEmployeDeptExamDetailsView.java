package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeDeptExamDetailsDto.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:15:41
 *
 */
@NativeQueryResultEntity
public class PVUEmployeDeptExamDetailsView implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp dept exam detail id. */
	@NativeQueryResultColumn(index = 0)
	private String empDeptExamDetailId;

	/** The dept exam name. */
	@NativeQueryResultColumn(index = 1)
	private String departmentExamName;

	@NativeQueryResultColumn(index = 2)
	private String examBodyName;

	/** The date of passing. */
	@NativeQueryResultColumn(index = 3)
	private String dateOfPassing;

	@NativeQueryResultColumn(index = 4)
	private String examStatus;

	@NativeQueryResultColumn(index = 5)
	private String attempts;

	/** The remarks. */
	@NativeQueryResultColumn(index = 6)
	private String remarks;

	@NativeQueryResultColumn(index = 7)
	private String updateByUpdateDate;

	@NativeQueryResultColumn(index = 8)
	private String updateByUserCode;

	@NativeQueryResultColumn(index = 9)
	private String updateByUserName;

	@NativeQueryResultColumn(index = 10)
	private String updateByPostName;
	
	@NativeQueryResultColumn(index = 11)
	private String officeName;
	
	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	@NativeQueryResultColumn(index = 12)
	private String changeType ;

	/**
	 * @return the empDeptExamDetailId
	 */
	public String getEmpDeptExamDetailId() {
		return empDeptExamDetailId;
	}

	/**
	 * @param empDeptExamDetailId the empDeptExamDetailId to set
	 */
	public void setEmpDeptExamDetailId(String empDeptExamDetailId) {
		this.empDeptExamDetailId = empDeptExamDetailId;
	}

	/**
	 * @return the departmentExamName
	 */
	public String getDepartmentExamName() {
		return departmentExamName;
	}

	/**
	 * @param departmentExamName the departmentExamName to set
	 */
	public void setDepartmentExamName(String departmentExamName) {
		this.departmentExamName = PvuUtils.ternaryOperator(departmentExamName);
	}

	/**
	 * @return the examBodyName
	 */
	public String getExamBodyName() {
		return examBodyName;
	}

	/**
	 * @param examBodyName the examBodyName to set
	 */
	public void setExamBodyName(String examBodyName) {
		this.examBodyName = examBodyName;
	}

	/**
	 * @return the dateOfPassing
	 */
	public String getDateOfPassing() {
		return dateOfPassing;
	}

	/**
	 * @param dateOfPassing the dateOfPassing to set
	 */
	public void setDateOfPassing(String dateOfPassing) {

		this.dateOfPassing = PvuUtils.getDateToStringDMYFormatValue(dateOfPassing);
	}

	/**
	 * @return the examStatus
	 */
	public String getExamStatus() {
		return examStatus;
	}

	/**
	 * @param examStatus the examStatus to set
	 */
	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	/**
	 * @return the attempts
	 */
	public String getAttempts() {
		return attempts;
	}

	/**
	 * @param attempts the attempts to set
	 */
	public void setAttempts(String attempts) {
		this.attempts = attempts;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return PvuUtils.ternaryOperator(remarks);
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = PvuUtils.ternaryOperator(remarks);
	}

	/**
	 * @return the updateByUpdateDate
	 */
	public String getUpdateByUpdateDate() {
		return updateByUpdateDate;
	}

	/**
	 * @param updateByUpdateDate the updateByUpdateDate to set
	 */
	public void setUpdateByUpdateDate(String updateByUpdateDate) {
		this.updateByUpdateDate = updateByUpdateDate;
	}

	/**
	 * @return the updateByUserCode
	 */
	public String getUpdateByUserCode() {
		return updateByUserCode;
	}

	/**
	 * @param updateByUserCode the updateByUserCode to set
	 */
	public void setUpdateByUserCode(String updateByUserCode) {
		this.updateByUserCode = updateByUserCode;
	}

	/**
	 * @return the updateByUserName
	 */
	public String getUpdateByUserName() {
		return updateByUserName;
	}

	/**
	 * @param updateByUserName the updateByUserName to set
	 */
	public void setUpdateByUserName(String updateByUserName) {
		this.updateByUserName = updateByUserName;
	}

	/**
	 * @return the updateByPostName
	 */
	public String getUpdateByPostName() {
		return updateByPostName;
	}

	/**
	 * @param updateByPostName the updateByPostName to set
	 */
	public void setUpdateByPostName(String updateByPostName) {
		this.updateByPostName = updateByPostName;
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
	 * @return the changeType
	 */
	public String getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	
	
}
