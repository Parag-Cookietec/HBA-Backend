package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeCCCExamDetailDto.
 * 
 * @version v 1.0
 * @created 2021/01/27 23:30:53
 *
 */
@NativeQueryResultEntity
public class PVUEmployeCCCExamDetailView implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp CCC exam detail id. */
	@NativeQueryResultColumn(index = 0)
	private String empCCCExamDetailId;

	@NativeQueryResultColumn(index = 1)
	private String cccExamName;

	@NativeQueryResultColumn(index = 2)
	private String examBodyName;

	@NativeQueryResultColumn(index = 3)
	private String dateOfExam;

	@NativeQueryResultColumn(index = 4)
	private String dateOfPassing;

	@NativeQueryResultColumn(index = 5)
	private String examStatusName;

	@NativeQueryResultColumn(index = 6)
	private String certificateNumber;

	@NativeQueryResultColumn(index = 7)
	private String remarks;

	@NativeQueryResultColumn(index = 8)
	private String updateByUpdateDate;

	@NativeQueryResultColumn(index = 9)
	private String updateByUserCode;

	@NativeQueryResultColumn(index = 10)
	private String updateByUserName;

	@NativeQueryResultColumn(index = 11)
	private String updateByPostName;
	
	@NativeQueryResultColumn(index = 12)
	private String officeName;

	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	@NativeQueryResultColumn(index = 13)
	private String changeType;

	/**
	 * @return the empCCCExamDetailId
	 */
	public String getEmpCCCExamDetailId() {
		return empCCCExamDetailId;
	}

	/**
	 * @param empCCCExamDetailId the empCCCExamDetailId to set
	 */
	public void setEmpCCCExamDetailId(String empCCCExamDetailId) {
		this.empCCCExamDetailId = empCCCExamDetailId;
	}

	/**
	 * @return the cccExamName
	 */
	public String getCccExamName() {
		return cccExamName;
	}

	/**
	 * @param cccExamName the cccExamName to set
	 */
	public void setCccExamName(String cccExamName) {
		this.cccExamName = cccExamName;
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

	public String getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(String dateOfExam) {
		this.dateOfExam = PvuUtils.getDateToStringDMYFormatValue(dateOfExam);
	}

	public String getDateOfPassing() {
		return dateOfPassing;
	}

	public void setDateOfPassing(String dateOfPassing) {
		this.dateOfPassing = PvuUtils.getDateToStringDMYFormatValue(dateOfPassing);
	}

	/**
	 * @return the examStatusName
	 */
	public String getExamStatusName() {
		return examStatusName;
	}

	/**
	 * @param examStatusName the examStatusName to set
	 */
	public void setExamStatusName(String examStatusName) {
		this.examStatusName = examStatusName;
	}

	/**
	 * @return the certificateNumber
	 */
	public String getCertificateNumber() {
		return certificateNumber;
	}

	/**
	 * @param certificateNumber the certificateNumber to set
	 */
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
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
