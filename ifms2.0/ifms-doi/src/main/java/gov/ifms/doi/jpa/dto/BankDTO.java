package gov.ifms.doi.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("value")
	private Long bankId;

	@JsonProperty("viewValue")
	private String bankName;

	private String bankNameGuj;

	private String bankCode;

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
