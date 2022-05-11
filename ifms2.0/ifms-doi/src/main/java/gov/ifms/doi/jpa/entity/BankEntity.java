package gov.ifms.doi.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

@Entity
@Table(name = "MS_BANK", schema = DoiJPAConstants.MASTER_V1_SCHEMA)
public class BankEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BANK_ID", updatable = false)
	private Long bankId;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "BANK_NAME_GUJ")
	private String bankNameGuj;

	@Column(name = "BANK_CODE")
	private String bankCode;

	@Column(name = "BANK_CODE_GUJ")
	private String bankCodeGuj;

	/**
	 * @return the bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the bankNameGuj
	 */
	public String getBankNameGuj() {
		return bankNameGuj;
	}

	/**
	 * @param bankNameGuj the bankNameGuj to set
	 */
	public void setBankNameGuj(String bankNameGuj) {
		this.bankNameGuj = bankNameGuj;
	}

	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @return the bankCodeGuj
	 */
	public String getBankCodeGuj() {
		return bankCodeGuj;
	}

	/**
	 * @param bankCodeGuj the bankCodeGuj to set
	 */
	public void setBankCodeGuj(String bankCodeGuj) {
		this.bankCodeGuj = bankCodeGuj;
	}

}
