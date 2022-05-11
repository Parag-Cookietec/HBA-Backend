package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBankBranchEntity;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;

/**
 * The Class PVUEmpBankDetailEntity.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:22:19
 *
 */
@Entity
@Table(name = "T_EMP_BANK_DTLS", schema = Constant.PVU_SCHEMA)
public class PVUEmpBankDetailEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_BANK_DTLS_ID")
	private Long id;

	/** The pvu employe entity. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/** The account type. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ACCOUNT_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity accountType;

	/** The ifsc code. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IFSC_CODE", referencedColumnName = "BANK_BRANCH_ID")
	private EDPMsBankBranchEntity ifscCode;

	/** The bank name. */
	@Column(name = "BANK_NAME")
	private String bankName;

	/** The bank address. */
	@Column(name = "BANK_BRN_ADDR")
	private String bankAddress;

	/** The account no. */
	@Column(name = "ACCOUNT_NO")
	private String accountNo;

	/**
	 * PVUEmpBankDetailEntity Constructor.
	 */
	public PVUEmpBankDetailEntity() {
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
	 * Gets the pvu employe entity.
	 *
	 * @return the pvu employe entity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the new pvu employe entity
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	/**
	 * Gets the account type.
	 *
	 * @return the account type
	 */
	public EDPLuLookUpInfoEntity getAccountType() {
		return accountType;
	}

	/**
	 * Sets the account type.
	 *
	 * @param accountType the new account type
	 */
	public void setAccountType(EDPLuLookUpInfoEntity accountType) {
		this.accountType = accountType;
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

	public EDPMsBankBranchEntity getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(EDPMsBankBranchEntity ifscCode) {
		this.ifscCode = ifscCode;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(accountNo, accountType, bankAddress, bankName, id, ifscCode, pvuEmployeEntity);
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
		PVUEmpBankDetailEntity other = (PVUEmpBankDetailEntity) obj;
		return Objects.equals(accountNo, other.accountNo) && Objects.equals(accountType, other.accountType)
				&& Objects.equals(bankAddress, other.bankAddress) && Objects.equals(bankName, other.bankName)
				&& Objects.equals(id, other.id) && Objects.equals(ifscCode, other.ifscCode)
				&& Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmpBankDetailEntity [id=" + id + ", pvuEmployeEntity=" + pvuEmployeEntity + ", accountType="
				+ accountType + ", ifscCode=" + ifscCode + ", bankName=" + bankName + ", bankAddress=" + bankAddress
				+ ", accountNo=" + accountNo + "]";
	}

}
