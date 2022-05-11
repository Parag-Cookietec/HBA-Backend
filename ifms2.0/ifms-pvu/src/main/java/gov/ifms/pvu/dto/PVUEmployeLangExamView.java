package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeLangExamDto.
 * 
 * @version v 1.0
 * @created 2019/11/27 23:55:09
 *
 */
@NativeQueryResultEntity
public class PVUEmployeLangExamView implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp lang exam id. */
	@NativeQueryResultColumn(index = 0)
	private String empLangExamId;

	@NativeQueryResultColumn(index = 1)
	private String languageName;

	/** The exam body. */
	@NativeQueryResultColumn(index = 2)
	private String examBody;

	@NativeQueryResultColumn(index = 3)
	private String examTypeName;

	/** The date of passing. */
	@NativeQueryResultColumn(index = 4)
	private String dateOfPassing;

	@NativeQueryResultColumn(index = 5)
	private String seatNumber;

	@NativeQueryResultColumn(index = 6)
	private String examStatusName;

	/** The remarks. */
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
	 * @return the empLangExamId
	 */
	public String getEmpLangExamId() {
		return empLangExamId;
	}

	/**
	 * @param empLangExamId the empLangExamId to set
	 */
	public void setEmpLangExamId(String empLangExamId) {
		this.empLangExamId = empLangExamId;
	}

	/**
	 * @return the languageName
	 */
	public String getLanguageName() {
		return languageName;
	}

	/**
	 * @param languageName the languageName to set
	 */
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	/**
	 * @return the examBody
	 */
	public String getExamBody() {
		return examBody;
	}

	/**
	 * @param examBody the examBody to set
	 */
	public void setExamBody(String examBody) {
		this.examBody = examBody;
	}

	/**
	 * @return the examTypeName
	 */
	public String getExamTypeName() {
		return examTypeName;
	}

	/**
	 * @param examTypeName the examTypeName to set
	 */
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
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
	 * @return the seatNumber
	 */
	public String getSeatNumber() {
		return seatNumber;
	}

	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = PvuUtils.ternaryOperator(seatNumber);
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