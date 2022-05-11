package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsBankIfscDto.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:17:24
 *
 */
public class EDPMsBankIfscDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Id. */
	private Long id;

	/** The bank name. */
	private String bankName;

	/** The bank name guj. */
	private String bankNameGuj;

	/** The Ifsc code. */
	private String ifscCode;

	/** The bank address. */
	private String bankAddress;

	

	/**
	 * EDPMsBankIfscDto Constructor.
	 */
	public EDPMsBankIfscDto() {
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
		EDPMsBankIfscDto other = (EDPMsBankIfscDto) obj;
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
		return "EDPMsBankIfscDto [id=" + id + ", bankName=" + bankName + ", bankNameGuj=" + bankNameGuj + ", ifscCode="
				+ ifscCode + ", bankAddress=" + bankAddress + "]";
	}

}
