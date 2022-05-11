package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAccountCloseViewDto.
 */
@NativeQueryResultEntity
public class LocAccountCloseViewDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp no. */
	@NativeQueryResultColumn(index = 0)
	private Long empNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 1)
	private String empName;

	/** The wf role name. */
	@NativeQueryResultColumn(index = 2)
	private String wfRoleName;

	/** The designatin name. */
	@NativeQueryResultColumn(index = 3)
	private String designatinName;

	/** The closing date. */
	@NativeQueryResultColumn(index = 4)
	private Date closingDate;

	/** The updated date. */
	@NativeQueryResultColumn(index = 5)
	private Date updatedDate;

	/** The closure remark. */
	@NativeQueryResultColumn(index = 6)
	private String closureRemark;

	/** The total rec. */
	@NativeQueryResultColumn(index = 7)
	private Long totalRec;

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
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
	 * Gets the designatin name.
	 *
	 * @return the designatinName
	 */
	public String getDesignatinName() {
		return designatinName;
	}

	/**
	 * Sets the designatin name.
	 *
	 * @param designatinName the designatinName to set
	 */
	public void setDesignatinName(String designatinName) {
		this.designatinName = designatinName;
	}

	/**
	 * Gets the closing date.
	 *
	 * @return the closingDate
	 */
	public Date getClosingDate() {
		return closingDate;
	}

	/**
	 * Sets the closing date.
	 *
	 * @param closingDate the closingDate to set
	 */
	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Gets the closure remark.
	 *
	 * @return the closureRemark
	 */
	public String getClosureRemark() {
		return closureRemark;
	}

	/**
	 * Sets the closure remark.
	 *
	 * @param closureRemark the closureRemark to set
	 */
	public void setClosureRemark(String closureRemark) {
		this.closureRemark = closureRemark;
	}

	/**
	 * Gets the total rec.
	 *
	 * @return the totalRec
	 */
	public Long getTotalRec() {
		return totalRec;
	}

	/**
	 * Sets the total rec.
	 *
	 * @param totalRec the totalRec to set
	 */
	public void setTotalRec(Long totalRec) {
		this.totalRec = totalRec;
	}

}
