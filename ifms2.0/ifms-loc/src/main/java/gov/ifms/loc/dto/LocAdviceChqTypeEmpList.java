package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAdviceChqTypeEmpList.
 */
@NativeQueryResultEntity
public class LocAdviceChqTypeEmpList {

	/** The emp no. */
	@NativeQueryResultColumn(index = 0)
	private Long empNo;

	/** The gpf no. */
	@NativeQueryResultColumn(index = 1)
	private String gpfNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 2)
	private String empName;

	/** The designation name. */
	@NativeQueryResultColumn(index = 3)
	private String designationName;

	/** The emp type. */
	@NativeQueryResultColumn(index = 4)
	private String empType;

	/** The acc no. */
	@NativeQueryResultColumn(index = 5)
	private String accNo;

	/** The ifsc code. */
	@NativeQueryResultColumn(index = 6)
	private String ifscCode;

	/** The branch name. */
	@NativeQueryResultColumn(index = 7)
	private String branchName;

	/**
	 * Gets the emp no.
	 *
	 * @return the emp no
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the new emp no
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the gpf no.
	 *
	 * @return the gpf no
	 */
	public String getGpfNo() {
		return gpfNo;
	}

	/**
	 * Sets the gpf no.
	 *
	 * @param gpfNo the new gpf no
	 */
	public void setGpfNo(String gpfNo) {
		this.gpfNo = gpfNo;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the emp name
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the new emp name
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
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
	 * Gets the emp type.
	 *
	 * @return the emp type
	 */
	public String getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the new emp type
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/**
	 * Gets the acc no.
	 *
	 * @return the acc no
	 */
	public String getAccNo() {
		return accNo;
	}

	/**
	 * Sets the acc no.
	 *
	 * @param accNo the new acc no
	 */
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	/**
	 * Gets the ifsc code.
	 *
	 * @return the ifsc code
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * Sets the ifsc code.
	 *
	 * @param ifscCode the new ifsc code
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * Gets the branch name.
	 *
	 * @return the branch name
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the new branch name
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
}
