package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUCommonAPIDTO.
 */
@NativeQueryResultEntity
public class PVUCommonAPIDTO {

	/** The event date. */
	@NativeQueryResultColumn(index = 0)
	private String eventDate;

	/** The employee name. */
	@NativeQueryResultColumn(index = 1)
	private String employeeName;

	/** The lookup info name. */
	@NativeQueryResultColumn(index = 2)
	private String lookupInfoName;

	/** The designation name. */
	@NativeQueryResultColumn(index = 3)
	private String designationName;

	/** The retirement date. */
	@NativeQueryResultColumn(index = 4)
	private String retirementDate;

	/** The office name. */
	@NativeQueryResultColumn(index = 5)
	private String officeName;

	/** The date nxt incr. */
	@NativeQueryResultColumn(index = 6)
	private String dateNxtIncr;

	/** The emp basic pay. */
	@NativeQueryResultColumn(index = 7)
	private String empBasicPay;

	/** The date joining. */
	@NativeQueryResultColumn(index = 8)
	private String dateJoining;

	/** The ccc exam name. */
	@NativeQueryResultColumn(index = 9)
	private String cccExamName;

	/** The ccc exam body. */
	@NativeQueryResultColumn(index = 10)
	private String cccExamBody;

	/** The ccc exam passing date. */
	@NativeQueryResultColumn(index = 11)
	private String cccExamPassingDate;

	/** The ccc exam status. */
	@NativeQueryResultColumn(index = 12)
	private String cccExamStatus;

	/** The dpt exam name. */
	@NativeQueryResultColumn(index = 13)
	private String dptExamName;

	/** The dpt exam body. */
	@NativeQueryResultColumn(index = 14)
	private String dptExamBody;

	/** The dpt exam passing date. */
	@NativeQueryResultColumn(index = 15)
	private String dptExamPassingDate;

	/** The dpt exam status. */
	@NativeQueryResultColumn(index = 16)
	private String dptExamStatus;

	/** The lang exam name. */
	@NativeQueryResultColumn(index = 17)
	private String langExamName;

	/** The lang exam body. */
	@NativeQueryResultColumn(index = 18)
	private String langExamBody;

	/** The lang exam passing date. */
	@NativeQueryResultColumn(index = 19)
	private String langExamPassingDate;

	/** The lang exam status. */
	@NativeQueryResultColumn(index = 20)
	private String langExamStatus;

	/**
	 * Gets the event date.
	 *
	 * @return the event date
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * Sets the event date.
	 *
	 * @param eventDate the new event date
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * Gets the employee name.
	 *
	 * @return the employee name
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * Sets the employee name.
	 *
	 * @param employeeName the new employee name
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * Gets the lookup info name.
	 *
	 * @return the lookup info name
	 */
	public String getLookupInfoName() {
		return lookupInfoName;
	}

	/**
	 * Sets the lookup info name.
	 *
	 * @param lookupInfoName the new lookup info name
	 */
	public void setLookupInfoName(String lookupInfoName) {
		this.lookupInfoName = lookupInfoName;
	}

	/**
	 * Gets the designation name.
	 *
	 * @return the designation name
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets the designation name.
	 *
	 * @param designationName the new designation name
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Gets the retirement date.
	 *
	 * @return the retirement date
	 */
	public String getRetirementDate() {
		return retirementDate;
	}

	/**
	 * Sets the retirement date.
	 *
	 * @param retirementDate the new retirement date
	 */
	public void setRetirementDate(String retirementDate) {
		this.retirementDate = retirementDate;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the date nxt incr.
	 *
	 * @return the date nxt incr
	 */
	public String getDateNxtIncr() {
		return dateNxtIncr;
	}

	/**
	 * Sets the date nxt incr.
	 *
	 * @param dateNxtIncr the new date nxt incr
	 */
	public void setDateNxtIncr(String dateNxtIncr) {
		this.dateNxtIncr = dateNxtIncr;
	}

	/**
	 * Gets the emp basic pay.
	 *
	 * @return the emp basic pay
	 */
	public String getEmpBasicPay() {
		return empBasicPay;
	}

	/**
	 * Sets the emp basic pay.
	 *
	 * @param empBasicPay the new emp basic pay
	 */
	public void setEmpBasicPay(String empBasicPay) {
		this.empBasicPay = empBasicPay;
	}

	/**
	 * Gets the date joining.
	 *
	 * @return the date joining
	 */
	public String getDateJoining() {
		return dateJoining;
	}

	/**
	 * Sets the date joining.
	 *
	 * @param dateJoining the new date joining
	 */
	public void setDateJoining(String dateJoining) {
		this.dateJoining = dateJoining;
	}

	/**
	 * Gets the ccc exam name.
	 *
	 * @return the ccc exam name
	 */
	public String getCccExamName() {
		return cccExamName;
	}

	/**
	 * Sets the ccc exam name.
	 *
	 * @param cccExamName the new ccc exam name
	 */
	public void setCccExamName(String cccExamName) {
		this.cccExamName = cccExamName;
	}

	/**
	 * Gets the ccc exam body.
	 *
	 * @return the ccc exam body
	 */
	public String getCccExamBody() {
		return cccExamBody;
	}

	/**
	 * Sets the ccc exam body.
	 *
	 * @param cccExamBody the new ccc exam body
	 */
	public void setCccExamBody(String cccExamBody) {
		this.cccExamBody = cccExamBody;
	}

	/**
	 * Gets the ccc exam passing date.
	 *
	 * @return the ccc exam passing date
	 */
	public String getCccExamPassingDate() {
		return cccExamPassingDate;
	}

	/**
	 * Sets the ccc exam passing date.
	 *
	 * @param cccExamPassingDate the new ccc exam passing date
	 */
	public void setCccExamPassingDate(String cccExamPassingDate) {
		this.cccExamPassingDate = cccExamPassingDate;
	}

	/**
	 * Gets the ccc exam status.
	 *
	 * @return the ccc exam status
	 */
	public String getCccExamStatus() {
		return cccExamStatus;
	}

	/**
	 * Sets the ccc exam status.
	 *
	 * @param cccExamStatus the new ccc exam status
	 */
	public void setCccExamStatus(String cccExamStatus) {
		this.cccExamStatus = cccExamStatus;
	}

	/**
	 * Gets the dpt exam name.
	 *
	 * @return the dpt exam name
	 */
	public String getDptExamName() {
		return dptExamName;
	}

	/**
	 * Sets the dpt exam name.
	 *
	 * @param dptExamName the new dpt exam name
	 */
	public void setDptExamName(String dptExamName) {
		this.dptExamName = dptExamName;
	}

	/**
	 * Gets the dpt exam body.
	 *
	 * @return the dpt exam body
	 */
	public String getDptExamBody() {
		return dptExamBody;
	}

	/**
	 * Sets the dpt exam body.
	 *
	 * @param dptExamBody the new dpt exam body
	 */
	public void setDptExamBody(String dptExamBody) {
		this.dptExamBody = dptExamBody;
	}

	/**
	 * Gets the dpt exam passing date.
	 *
	 * @return the dpt exam passing date
	 */
	public String getDptExamPassingDate() {
		return dptExamPassingDate;
	}

	/**
	 * Sets the dpt exam passing date.
	 *
	 * @param dptExamPassingDate the new dpt exam passing date
	 */
	public void setDptExamPassingDate(String dptExamPassingDate) {
		this.dptExamPassingDate = dptExamPassingDate;
	}

	/**
	 * Gets the dpt exam status.
	 *
	 * @return the dpt exam status
	 */
	public String getDptExamStatus() {
		return dptExamStatus;
	}

	/**
	 * Sets the dpt exam status.
	 *
	 * @param dptExamStatus the new dpt exam status
	 */
	public void setDptExamStatus(String dptExamStatus) {
		this.dptExamStatus = dptExamStatus;
	}

	/**
	 * Gets the lang exam name.
	 *
	 * @return the lang exam name
	 */
	public String getLangExamName() {
		return langExamName;
	}

	/**
	 * Sets the lang exam name.
	 *
	 * @param langExamName the new lang exam name
	 */
	public void setLangExamName(String langExamName) {
		this.langExamName = langExamName;
	}

	/**
	 * Gets the lang exam body.
	 *
	 * @return the lang exam body
	 */
	public String getLangExamBody() {
		return langExamBody;
	}

	/**
	 * Sets the lang exam body.
	 *
	 * @param langExamBody the new lang exam body
	 */
	public void setLangExamBody(String langExamBody) {
		this.langExamBody = langExamBody;
	}

	/**
	 * Gets the lang exam passing date.
	 *
	 * @return the lang exam passing date
	 */
	public String getLangExamPassingDate() {
		return langExamPassingDate;
	}

	/**
	 * Sets the lang exam passing date.
	 *
	 * @param langExamPassingDate the new lang exam passing date
	 */
	public void setLangExamPassingDate(String langExamPassingDate) {
		this.langExamPassingDate = langExamPassingDate;
	}

	/**
	 * Gets the lang exam status.
	 *
	 * @return the lang exam status
	 */
	public String getLangExamStatus() {
		return langExamStatus;
	}

	/**
	 * Sets the lang exam status.
	 *
	 * @param langExamStatus the new lang exam status
	 */
	public void setLangExamStatus(String langExamStatus) {
		this.langExamStatus = langExamStatus;
	}
}
