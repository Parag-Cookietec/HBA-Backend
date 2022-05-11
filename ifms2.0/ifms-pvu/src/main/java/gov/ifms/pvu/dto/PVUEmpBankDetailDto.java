package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmpBankDetailDto.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:22:19
 *
 */
public class PVUEmpBankDetailDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The emp id. */
	private Long empId;

	/** The account type. */
	private Long accountType;
	private String accountTypeName;

	/** The ifsc code. */
	private Long ifscCode;
	private String ifscCodeName;

	/** The bank name. */
	private String bankName;

	/** The bank address. */
	private String bankAddress;

	/** The account no. */
	private String accountNo;

	/**
	 * PVUEmpBankDetailDto Constructor.
	 */
	public PVUEmpBankDetailDto() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the account type.
	 *
	 * @return the account type
	 */
	public Long getAccountType() {
		return accountType;
	}

	/**
	 * Sets the account type.
	 *
	 * @param accountType the new account type
	 */
	public void setAccountType(Long accountType) {
		this.accountType = accountType;
	}

	/**
	 * Gets the ifsc code.
	 *
	 * @return the ifsc code
	 */
	public Long getIfscCode() {
		return ifscCode;
	}

	/**
	 * Sets the ifsc code.
	 *
	 * @param ifscCode the new ifsc code
	 */
	public void setIfscCode(Long ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * Gets the bank name.
	 *
	 * @return the bank name
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Sets the bank name.
	 *
	 * @param bankName the new bank name
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Gets the bank address.
	 *
	 * @return the bank address
	 */
	public String getBankAddress() {
		return bankAddress;
	}

	/**
	 * Sets the bank address.
	 *
	 * @param bankAddress the new bank address
	 */
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	/**
	 * Gets the account no.
	 *
	 * @return the account no
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * Sets the account no.
	 *
	 * @param accountNo the new account no
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the accountTypeName
	 */
	public String getAccountTypeName() {
		return accountTypeName;
	}

	/**
	 * @param accountTypeName the accountTypeName to set
	 */
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	/**
	 * @return the ifscCodeName
	 */
	public String getIfscCodeName() {
		return ifscCodeName;
	}

	/**
	 * @param ifscCodeName the ifscCodeName to set
	 */
	public void setIfscCodeName(String ifscCodeName) {
		this.ifscCodeName = ifscCodeName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(accountNo, accountType, bankAddress, bankName, empId, id, ifscCode);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmpBankDetailDto other = (PVUEmpBankDetailDto) obj;
		return Objects.equals(accountNo, other.accountNo) && Objects.equals(accountType, other.accountType)
				&& Objects.equals(bankAddress, other.bankAddress) && Objects.equals(bankName, other.bankName)
				&& Objects.equals(empId, other.empId) && Objects.equals(id, other.id)
				&& Objects.equals(ifscCode, other.ifscCode);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmpBankDetailDto [id=" + id + ", empId=" + empId + ", accountType=" + accountType + ", ifscCode="
				+ ifscCode + ", bankName=" + bankName + ", bankAddress=" + bankAddress + ", accountNo=" + accountNo
				+ "]";
	}

}
