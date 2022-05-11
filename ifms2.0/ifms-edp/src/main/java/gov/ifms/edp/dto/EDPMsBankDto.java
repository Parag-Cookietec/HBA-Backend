package gov.ifms.edp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * The Class EDPMsBankDto.
 */
public class EDPMsBankDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bank id. */
	@NotNull
	private Long bankId;

	/** The bank name. */
	@NotNull
	private String bankName;

	/** The bank name guj. */
	private String bankNameGuj;

	/** The bank code. */
	private String bankCode;

	/** The bank code guj. */
	private String bankCodeGuj;

	/**
	 * CommonMsBankDto Constructor.
	 */
	public EDPMsBankDto() {
		super();
	}

	/**
	 * Gets the bank id.
	 *
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
