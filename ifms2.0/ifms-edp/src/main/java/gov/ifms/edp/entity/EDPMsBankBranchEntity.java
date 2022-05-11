package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsBankBranchEntity.
 */
@Entity
@Table(name = "MS_BANK_BRANCH", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsBankBranchEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bank branch id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BANK_BRANCH_ID")
	private Long bankBranchId;

	/** The branch name. */
	@Column(name = "BRANCH_NAME")
	private String branchName;

	/** The branch name guj. */
	@Column(name = "BRANCH_NAME_GUJ")
	private String branchNameGuj;

	/** The branch desc. */
	@Column(name = "BRANCH_DESC")
	private String branchDesc;

	/** The branch desc guj. */
	@Column(name = "BRANCH_DESC_GUJ")
	private String branchDescGuj;

	/** The branch code. */
	@Column(name = "BRANCH_CODE")
	private String branchCode;

	/** The branch code guj. */
	@Column(name = "BRANCH_CODE_GUJ")
	private String branchCodeGuj;

	/** The branch type id. */
	@Column(name = "BRANCH_TYPE_ID")
	private Long branchTypeId;

	/** The parent branch id. */
	@Column(name = "PARENT_BRANCH_ID")
	private Long parentBranchId;

	/** The bank id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANK_ID", referencedColumnName = "BANK_ID")
	private EDPMsBankEntity bankId;

	/** The district id. */
	@Column(name = "DISTRICT_ID")
	private Long districtId;

	/** The taluka id. */
	@Column(name = "TALUKA_ID")
	private Long talukaId;

	/** The ifsc code. */
	@Column(name = "IFSC_CODE")
	private String ifscCode;

	/** The micr code. */
	@Column(name = "MICR_CODE")
	private String micrCode;

	/** The branch address. */
	@Column(name = "BRANCH_ADDR")
	private String branchAddress;

	/** The branch email. */
	@Column(name = "BRANCH_EMAIL")
	private String branchEmail;

	/** The branch phone. */
	@Column(name = "BRANCH_PHONE")
	private String branchPhone;

	/** The is merged branch. */
	@Column(name = "IS_MERGED_BRANCH")
	private Integer isMergedBranch;

	/** The is enabled branch. */
	@Column(name = "IS_ENABLED_BRANCH")
	private Integer isEnabledBranch;

	/**
	 * Instantiates a new EDP ms bank branch entity.
	 */
	public EDPMsBankBranchEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms bank branch entity.
	 *
	 * @param bankBranchId the bank branch id
	 */
	public EDPMsBankBranchEntity(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(bankBranchId, branchName, branchNameGuj, branchDesc, branchDescGuj, branchCode,
				branchCodeGuj, branchTypeId, parentBranchId, bankId, districtId, talukaId, ifscCode, micrCode,
				branchAddress, branchEmail, branchPhone, isMergedBranch, isEnabledBranch);
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
		if (!(obj instanceof EDPMsBankBranchEntity)) {
			return false;
		}

		EDPMsBankBranchEntity other = (EDPMsBankBranchEntity) obj;

		return Objects.equals(bankBranchId, other.bankBranchId) && Objects.equals(branchName, other.branchName)
				&& Objects.equals(branchNameGuj, other.branchNameGuj) && Objects.equals(branchDesc, other.branchDesc)
				&& Objects.equals(branchDescGuj, other.branchDescGuj) && Objects.equals(branchCode, other.branchCode)
				&& Objects.equals(branchCodeGuj, other.branchCodeGuj)
				&& Objects.equals(branchTypeId, other.branchTypeId)
				&& Objects.equals(parentBranchId, other.parentBranchId) && Objects.equals(bankId, other.bankId)
				&& Objects.equals(districtId, other.districtId) && Objects.equals(talukaId, other.talukaId)
				&& Objects.equals(ifscCode, other.ifscCode) && Objects.equals(micrCode, other.micrCode)
				&& Objects.equals(branchAddress, other.branchAddress) && Objects.equals(branchEmail, other.branchEmail)
				&& Objects.equals(branchPhone, other.branchPhone)
				&& Objects.equals(isMergedBranch, other.isMergedBranch)
				&& Objects.equals(isEnabledBranch, other.isEnabledBranch);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPMsBankBranchEntity [bankBranchId=" + bankBranchId + ", branchName=" + branchName + ", branchNameGuj="
				+ branchNameGuj + ", branchDesc=" + branchDesc + ", branchDescGuj=" + branchDescGuj + ", branchCode="
				+ branchCode + ", branchCodeGuj=" + branchCodeGuj + ", branchTypeId=" + branchTypeId
				+ ", parentBranchId=" + parentBranchId + ", bankId=" + bankId + ", districtId=" + districtId
				+ ", talukaId=" + talukaId + ", ifscCode=" + ifscCode + ", micrCode=" + micrCode + ", branchAddress="
				+ branchAddress + ", branchEmail=" + branchEmail + ", branchPhone=" + branchPhone + ", isMergedBranch="
				+ isMergedBranch + ", isEnabledBranch=" + isEnabledBranch + "]";
	}
	
	/**
	 * @return the bankBranchId
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * Sets the bank branch id.
	 *
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * Gets the branch name.
	 *
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Gets the branch name guj.
	 *
	 * @return the branchNameGuj
	 */
	public String getBranchNameGuj() {
		return branchNameGuj;
	}

	/**
	 * Sets the branch name guj.
	 *
	 * @param branchNameGuj the branchNameGuj to set
	 */
	public void setBranchNameGuj(String branchNameGuj) {
		this.branchNameGuj = branchNameGuj;
	}

	/**
	 * Gets the branch desc.
	 *
	 * @return the branchDesc
	 */
	public String getBranchDesc() {
		return branchDesc;
	}

	/**
	 * Sets the branch desc.
	 *
	 * @param branchDesc the branchDesc to set
	 */
	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}

	/**
	 * Gets the branch desc guj.
	 *
	 * @return the branchDescGuj
	 */
	public String getBranchDescGuj() {
		return branchDescGuj;
	}

	/**
	 * Sets the branch desc guj.
	 *
	 * @param branchDescGuj the branchDescGuj to set
	 */
	public void setBranchDescGuj(String branchDescGuj) {
		this.branchDescGuj = branchDescGuj;
	}

	/**
	 * Gets the branch code.
	 *
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * Sets the branch code.
	 *
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * Gets the branch code guj.
	 *
	 * @return the branchCodeGuj
	 */
	public String getBranchCodeGuj() {
		return branchCodeGuj;
	}

	/**
	 * Sets the branch code guj.
	 *
	 * @param branchCodeGuj the branchCodeGuj to set
	 */
	public void setBranchCodeGuj(String branchCodeGuj) {
		this.branchCodeGuj = branchCodeGuj;
	}

	/**
	 * Gets the branch type id.
	 *
	 * @return the branchTypeId
	 */
	public Long getBranchTypeId() {
		return branchTypeId;
	}

	/**
	 * Sets the branch type id.
	 *
	 * @param branchTypeId the branchTypeId to set
	 */
	public void setBranchTypeId(Long branchTypeId) {
		this.branchTypeId = branchTypeId;
	}

	/**
	 * Gets the parent branch id.
	 *
	 * @return the parentBranchId
	 */
	public Long getParentBranchId() {
		return parentBranchId;
	}

	/**
	 * Sets the parent branch id.
	 *
	 * @param parentBranchId the parentBranchId to set
	 */
	public void setParentBranchId(Long parentBranchId) {
		this.parentBranchId = parentBranchId;
	}

	/**
	 * Gets the bank id.
	 *
	 * @return the bankId
	 */
	public EDPMsBankEntity getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the bankId to set
	 */
	public void setBankId(EDPMsBankEntity bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the taluka id.
	 *
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * Sets the taluka id.
	 *
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * Gets the ifsc code.
	 *
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * Sets the ifsc code.
	 *
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * Gets the micr code.
	 *
	 * @return the micrCode
	 */
	public String getMicrCode() {
		return micrCode;
	}

	/**
	 * Sets the micr code.
	 *
	 * @param micrCode the micrCode to set
	 */
	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	/**
	 * Gets the branch address.
	 *
	 * @return the branchAddress
	 */
	public String getBranchAddress() {
		return branchAddress;
	}

	/**
	 * Sets the branch address.
	 *
	 * @param branchAddress the branchAddress to set
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	/**
	 * Gets the branch email.
	 *
	 * @return the branchEmail
	 */
	public String getBranchEmail() {
		return branchEmail;
	}

	/**
	 * Sets the branch email.
	 *
	 * @param branchEmail the branchEmail to set
	 */
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

	/**
	 * Gets the branch phone.
	 *
	 * @return the branchPhone
	 */
	public String getBranchPhone() {
		return branchPhone;
	}

	/**
	 * Sets the branch phone.
	 *
	 * @param branchPhone the branchPhone to set
	 */
	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	/**
	 * Gets the checks if is merged branch.
	 *
	 * @return the isMergedBranch
	 */
	public Integer getIsMergedBranch() {
		return isMergedBranch;
	}

	/**
	 * Sets the checks if is merged branch.
	 *
	 * @param isMergedBranch the isMergedBranch to set
	 */
	public void setIsMergedBranch(Integer isMergedBranch) {
		this.isMergedBranch = isMergedBranch;
	}

	/**
	 * Gets the checks if is enabled branch.
	 *
	 * @return the isEnabledBranch
	 */
	public Integer getIsEnabledBranch() {
		return isEnabledBranch;
	}

	/**
	 * Sets the checks if is enabled branch.
	 *
	 * @param isEnabledBranch the isEnabledBranch to set
	 */
	public void setIsEnabledBranch(Integer isEnabledBranch) {
		this.isEnabledBranch = isEnabledBranch;
	}

}
