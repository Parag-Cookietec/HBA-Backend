package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAdviceChqTypeList.
 */
@NativeQueryResultEntity
public class LocAdviceChqTypeList {

	/** The vendor name. */
	@NativeQueryResultColumn(index = 0)
	private String vendorName;

	/** The cheque type. */
	@NativeQueryResultColumn(index = 1)
	private String chequeType;

	/** The acc no. */
	@NativeQueryResultColumn(index = 2)
	private String accNo;

	/** The ifsc code. */
	@NativeQueryResultColumn(index = 3)
	private String ifscCode;

	/** The branch name. */
	@NativeQueryResultColumn(index = 4)
	private String branchName;

	/** The pan no. */
	@NativeQueryResultColumn(index = 5)
	private String panNo;

	/** The income tax rate. */
	@NativeQueryResultColumn(index = 6)
	private String incomeTaxRate;

	/** The mobile no. */
	@NativeQueryResultColumn(index = 7)
	private String mobileNo;

	/**
	 * Gets the vendor name.
	 *
	 * @return the vendor name
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * Sets the vendor name.
	 *
	 * @param vendorName the new vendor name
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * Gets the cheque type.
	 *
	 * @return the cheque type
	 */
	public String getChequeType() {
		return chequeType;
	}

	/**
	 * Sets the cheque type.
	 *
	 * @param chequeType the new cheque type
	 */
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
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

	/**
	 * Gets the pan no.
	 *
	 * @return the pan no
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * Sets the pan no.
	 *
	 * @param panNo the new pan no
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	/**
	 * Gets the income tax rate.
	 *
	 * @return the income tax rate
	 */
	public String getIncomeTaxRate() {
		return incomeTaxRate;
	}

	/**
	 * Sets the income tax rate.
	 *
	 * @param incomeTaxRate the new income tax rate
	 */
	public void setIncomeTaxRate(String incomeTaxRate) {
		this.incomeTaxRate = incomeTaxRate;
	}

	/**
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Sets the mobile no.
	 *
	 * @param mobileNo the new mobile no
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}
