package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocMsBankEntity.
 */
@Entity
@Table(name = "MS_BANK", schema = LocConstant.MASTER_SCHEMA)
public class LocMsBankEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bankId. */
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



	/**
	 * 
	 */
	public LocMsBankEntity() {
		super();

	}

	/**
	 * @param id
	 */
	public LocMsBankEntity(Long bankId) {
		super();
		this.bankId = bankId;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getbankId() {
		return bankId;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setbankId(Long bankId) {
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

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LocMsBankEntity)) return false;
		LocMsBankEntity that = (LocMsBankEntity) o;
		return Objects.equals(getBankId(), that.getBankId()) && Objects.equals(getBankName(), that.getBankName()) && Objects.equals(getBankNameGuj(), that.getBankNameGuj());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBankId(), getBankName(), getBankNameGuj());
	}

	@Override
	public String toString() {
		return "LocMsBankEntity{" +
				"bankId=" + bankId +
				", bankName='" + bankName + '\'' +
				", bankNameGuj='" + bankNameGuj + '\'' +
				'}';
	}
}
