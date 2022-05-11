package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsBankIfscEntity.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:17:24
 *
 */
@Entity
@Table(name = "MS_BANK_IFSC", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsBankIfscEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BANK_IFSC_ID")
	private Long id;

	/** The bank name. */
	@Column(name = "BANK_NAME")
	private String bankName;

	/** The bank name guj. */
	@Column(name = "BANK_NAME_GUJ")
	private String bankNameGuj;

	/** The ifsc code. */
	@Column(name = "BANK_IFSC_CODE")
	private String ifscCode;

	/** The bank address. */
	@Column(name = "BANK_ADDRESS")
	private String bankAddress;

	/**
	 * EDPMsBankIfscEntity Constructor.
	 */
	public EDPMsBankIfscEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms bank ifsc entity.
	 *
	 * @param ifscCodeId the ifsc code id
	 */
	public EDPMsBankIfscEntity(Long ifscCodeId) {
		this.id = ifscCodeId;
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
	 * Gets the bank name guj.
	 *
	 * @return the bank name guj
	 */
	public String getBankNameGuj() {
		return bankNameGuj;
	}

	/**
	 * Sets the bank name guj.
	 *
	 * @param bankNameGuj the new bank name guj
	 */
	public void setBankNameGuj(String bankNameGuj) {
		this.bankNameGuj = bankNameGuj;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(bankAddress, bankName, bankNameGuj, id, ifscCode);
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
		EDPMsBankIfscEntity other = (EDPMsBankIfscEntity) obj;
		return Objects.equals(bankAddress, other.bankAddress) && Objects.equals(bankName, other.bankName)
				&& Objects.equals(bankNameGuj, other.bankNameGuj) && Objects.equals(id, other.id)
				&& Objects.equals(ifscCode, other.ifscCode);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPMsBankIfscEntity [id=" + id + ", bankName=" + bankName + ", bankNameGuj=" + bankNameGuj
				+ ", ifscCode=" + ifscCode + ", bankAddress=" + bankAddress + "]";
	}

}
