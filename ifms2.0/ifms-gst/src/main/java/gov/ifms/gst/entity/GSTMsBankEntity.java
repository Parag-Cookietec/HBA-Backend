package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class GSTMsBankEntity.
 */
@Entity
@Table(name = "MS_BANK", schema = GSTConstant.MASTER_SCHEMA)
public class GSTMsBankEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bank id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BANK_ID")
	private Long bankId;

	/** The bank name. */
	@Column(name = "BANK_NAME")
	private String bankName;

	/** The bank name guj. */
	@Column(name = "BANK_NAME_GUJ")
	private String bankNameGuj;

	/** The bank code. */
	@Column(name = "BANK_CODE")
	private String bankCode;

	/** The bank code guj. */
	@Column(name = "BANK_CODE_GUJ")
	private String bankCodeGuj;

	/**
	 * Instantiates a new GST ms bank entity.
	 */
	public GSTMsBankEntity() {
		super();
	}

	/**
	 * Instantiates a new GST ms bank entity.
	 *
	 * @param bankId the bank id
	 */
	public GSTMsBankEntity(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(bankId, bankName, bankNameGuj, bankCode, bankCodeGuj);
	}

	/**
	 * equals method.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GSTMsBankEntity)) {
			return false;
		}

		GSTMsBankEntity other = (GSTMsBankEntity) obj;

		return Objects.equals(bankId, other.bankId) && Objects.equals(bankName, other.bankName)
				&& Objects.equals(bankNameGuj, other.bankNameGuj) && Objects.equals(bankCode, other.bankCode)
				&& Objects.equals(bankCodeGuj, other.bankCodeGuj);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "GSTMsBankEntity [bankId=" + bankId + ", bankName=" + bankName + ", bankNameGuj=" + bankNameGuj
				+ ", bankCode=" + bankCode + ", bankCodeGuj=" + bankCodeGuj + "]";
	}
	
	/**
	 * @return the bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the bank name.
	 *
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Sets the bank name.
	 *
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Gets the bank name guj.
	 *
	 * @return the bankNameGuj
	 */
	public String getBankNameGuj() {
		return bankNameGuj;
	}

	/**
	 * Sets the bank name guj.
	 *
	 * @param bankNameGuj the bankNameGuj to set
	 */
	public void setBankNameGuj(String bankNameGuj) {
		this.bankNameGuj = bankNameGuj;
	}

	/**
	 * Gets the bank code.
	 *
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * Sets the bank code.
	 *
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * Gets the bank code guj.
	 *
	 * @return the bankCodeGuj
	 */
	public String getBankCodeGuj() {
		return bankCodeGuj;
	}

	/**
	 * Sets the bank code guj.
	 *
	 * @param bankCodeGuj the bankCodeGuj to set
	 */
	public void setBankCodeGuj(String bankCodeGuj) {
		this.bankCodeGuj = bankCodeGuj;
	}

}
