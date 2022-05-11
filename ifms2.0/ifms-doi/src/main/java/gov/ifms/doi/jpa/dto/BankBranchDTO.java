package gov.ifms.doi.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankBranchDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("value")
	private Long bankBranchId;

	private String branchName;
	
	private String branchNameGuj;

	private String branchDesc;

	private String branchDescGuj;

	private String branchCode;

	private String branchCodeGuj;

	private Long branchTypeId;

	private Long parentBranchId;

	private Long bankId;

	private Long districtId;

	private Long talukaId;

	private String ifscCode;

	private String micrCode;

	@JsonProperty("viewValue")
	private String branchAddr;

	private String branchEmail;

	private String branchPhone;

	private Long isMErgedBranch;

	private Long isEnabledBranch;

	/**
	 * @return the bankBranchId
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the branchNameGuj
	 */
	public String getBranchNameGuj() {
		return branchNameGuj;
	}

	/**
	 * @param branchNameGuj the branchNameGuj to set
	 */
	public void setBranchNameGuj(String branchNameGuj) {
		this.branchNameGuj = branchNameGuj;
	}

	/**
	 * @return the branchDesc
	 */
	public String getBranchDesc() {
		return branchDesc;
	}

	/**
	 * @param branchDesc the branchDesc to set
	 */
	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}

	/**
	 * @return the branchDescGuj
	 */
	public String getBranchDescGuj() {
		return branchDescGuj;
	}

	/**
	 * @param branchDescGuj the branchDescGuj to set
	 */
	public void setBranchDescGuj(String branchDescGuj) {
		this.branchDescGuj = branchDescGuj;
	}

	/**
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the branchCodeGuj
	 */
	public String getBranchCodeGuj() {
		return branchCodeGuj;
	}

	/**
	 * @param branchCodeGuj the branchCodeGuj to set
	 */
	public void setBranchCodeGuj(String branchCodeGuj) {
		this.branchCodeGuj = branchCodeGuj;
	}

	/**
	 * @return the branchTypeId
	 */
	public Long getBranchTypeId() {
		return branchTypeId;
	}

	/**
	 * @param branchTypeId the branchTypeId to set
	 */
	public void setBranchTypeId(Long branchTypeId) {
		this.branchTypeId = branchTypeId;
	}

	/**
	 * @return the parentBranchId
	 */
	public Long getParentBranchId() {
		return parentBranchId;
	}

	/**
	 * @param parentBranchId the parentBranchId to set
	 */
	public void setParentBranchId(Long parentBranchId) {
		this.parentBranchId = parentBranchId;
	}

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
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return the micrCode
	 */
	public String getMicrCode() {
		return micrCode;
	}

	/**
	 * @param micrCode the micrCode to set
	 */
	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	/**
	 * @return the branchAddr
	 */
	public String getBranchAddr() {
		return branchAddr;
	}

	/**
	 * @param branchAddr the branchAddr to set
	 */
	public void setBranchAddr(String branchAddr) {
		this.branchAddr = branchAddr;
	}

	/**
	 * @return the branchEmail
	 */
	public String getBranchEmail() {
		return branchEmail;
	}

	/**
	 * @param branchEmail the branchEmail to set
	 */
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

	/**
	 * @return the branchPhone
	 */
	public String getBranchPhone() {
		return branchPhone;
	}

	/**
	 * @param branchPhone the branchPhone to set
	 */
	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	/**
	 * @return the isMErgedBranch
	 */
	public Long getIsMErgedBranch() {
		return isMErgedBranch;
	}

	/**
	 * @param isMErgedBranch the isMErgedBranch to set
	 */
	public void setIsMErgedBranch(Long isMErgedBranch) {
		this.isMErgedBranch = isMErgedBranch;
	}

	/**
	 * @return the isEnabledBranch
	 */
	public Long getIsEnabledBranch() {
		return isEnabledBranch;
	}

	/**
	 * @param isEnabledBranch the isEnabledBranch to set
	 */
	public void setIsEnabledBranch(Long isEnabledBranch) {
		this.isEnabledBranch = isEnabledBranch;
	}

}
