package gov.ifms.loc.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsBranchEntity.
 */
@Entity
@Table(name = "MS_BRANCH", schema = Constant.EDP_MASTER_SCHEMA)
public class LocMsBankBranchEntity extends BaseEntity implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;


    /**
     * The branch id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_BRANCH_ID")
    private Long branchId;

    /**
     * The branch name.
     */
    @Column(name = "BRANCH_NAME")
    private String branchName;

    /**
     * The branch name guj.
     */
    @Column(name = "BRANCH_NAME_GUJ")
    private String branchNameGuj;

    /**
     * The branch desc.
     */
    @Column(name = "BRANCH_DESC")
    private String branchDesc;

    /**
     * The branch desc guj.
     */
    @Column(name = "BRANCH_DESC_GUJ")
    private String branchDescGuj;

    /**
     * The branch code.
     */
    @Column(name = "BRANCH_CODE")
    private String branchCode;

    /**
     * The branch code guj.
     */
    @Column(name = "BRANCH_CODE_GUJ")
    private String branchCodeGuj;


    /**
     * The branch type id.
     */

    @Column(name = "BRANCH_TYPE_ID")
    private Long branchTypeId;

    /**
     * The parent branch id.
     */
    @Column(name = "PARENT_BRANCH_ID")
    private Long parentBranchId;

    /**
     * The loc msBank location entity.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID", referencedColumnName = "BANK_ID")
    private LocMsBankEntity bankentity;


    /**
     * The  district id.
     */
    @Column(name = "DISTRICT_ID")
    private Long districtId;

    /**
     * The  taluka id.
     */
    @Column(name = "TALUKA_ID")
    private Long talukaId;

    /**
     * The ifscCode.
     */
    @Column(name = "IFSC_CODE")
    private String ifscCode;

    /**
     * The micrCode.
     */
    @Column(name = "MICR_CODE")
    private String micrCode;

    /**
     * The branch Address.
     */
    @Column(name = "BRANCH_ADDR")
    private String branchAddress;

    /**
     * The branch email.
     */
    @Column(name = "BRANCH_EMAIL")
    private String branchEMail;

    /**
     * The branch phone.
     */
    @Column(name = "BRANCH_PHONE")
    private String branchPhone;

    /**
     * The is merged branch.
     */
    @Column(name = "IS_MERGED_BRANCH")
    private Long isMergedBranch;

    /**
     * The is enabled branch.
     */
    @Column(name = "IS_ENABLED_BRANCH")
    private Long isEnabledBranch;

    /**
     * Gets the branch id.
     *
     * @return the branch id
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * Sets the branch id.
     *
     * @param branchId the new branch id
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * Gets the branch name.
     *
     * @return the branch name
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * Sets the branch name.
     *
     * @param branchName the new branch name
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * Gets the branch name guj.
     *
     * @return the branch name guj
     */
    public String getBranchNameGuj() {
        return branchNameGuj;
    }

    /**
     * Sets the branch name guj.
     *
     * @param branchNameGuj the new branch name guj
     */
    public void setBranchNameGuj(String branchNameGuj) {
        this.branchNameGuj = branchNameGuj;
    }

    /**
     * Gets the branch desc.
     *
     * @return the branch desc
     */
    public String getBranchDesc() {
        return branchDesc;
    }

    /**
     * Sets the branch desc.
     *
     * @param branchDesc the new branch desc
     */
    public void setBranchDesc(String branchDesc) {
        this.branchDesc = branchDesc;
    }

    /**
     * Gets the branch desc guj.
     *
     * @return the branch desc guj
     */
    public String getBranchDescGuj() {
        return branchDescGuj;
    }

    /**
     * Sets the branch desc guj.
     *
     * @param branchDescGuj the new branch desc guj
     */
    public void setBranchDescGuj(String branchDescGuj) {
        this.branchDescGuj = branchDescGuj;
    }

    /**
     * Gets the branch code.
     *
     * @return the branch code
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * Sets the branch code.
     *
     * @param branchCode the new branch code
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    /**
     * Gets the branch code guj.
     *
     * @return the branch code guj
     */
    public String getBranchCodeGuj() {
        return branchCodeGuj;
    }

    /**
     * Sets the branch code guj.
     *
     * @param branchCodeGuj the new branch code guj
     */
    public void setBranchCodeGuj(String branchCodeGuj) {
        this.branchCodeGuj = branchCodeGuj;
    }

    /**
     * Gets the branch type id.
     *
     * @return the branch type id
     */
    public Long getBranchTypeId() {
        return branchTypeId;
    }

    /**
     * Sets the branch type id.
     *
     * @param branchTypeId the new branch type id
     */
    public void setBranchTypeId(Long branchTypeId) {
        this.branchTypeId = branchTypeId;
    }

    /**
     * Gets the parent branch id.
     *
     * @return the parent branch id
     */
    public Long getParentBranchId() {
        return parentBranchId;
    }

    /**
     * Sets the parent branch id.
     *
     * @param parentBranchId the new parent branch id
     */
    public void setParentBranchId(Long parentBranchId) {
        this.parentBranchId = parentBranchId;
    }

    /**
     * Gets the bankentity.
     *
     * @return the bankentity
     */
    public LocMsBankEntity getBankentity() {
        return bankentity;
    }

    /**
     * Sets the bankentity.
     *
     * @param bankentity the new bankentity
     */
    public void setBankentity(LocMsBankEntity bankentity) {
        this.bankentity = bankentity;
    }

    /**
     * Gets the district id.
     *
     * @return the district id
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * Sets the district id.
     *
     * @param districtId the new district id
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * Gets the taluka id.
     *
     * @return the taluka id
     */
    public Long getTalukaId() {
        return talukaId;
    }

    /**
     * Sets the taluka id.
     *
     * @param talukaId the new taluka id
     */
    public void setTalukaId(Long talukaId) {
        this.talukaId = talukaId;
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
     * Gets the micr code.
     *
     * @return the micr code
     */
    public String getMicrCode() {
        return micrCode;
    }

    /**
     * Sets the micr code.
     *
     * @param micrCode the new micr code
     */
    public void setMicrCode(String micrCode) {
        this.micrCode = micrCode;
    }

    /**
     * Gets the branch address.
     *
     * @return the branch address
     */
    public String getBranchAddress() {
        return branchAddress;
    }

    /**
     * Sets the branch address.
     *
     * @param branchAddress the new branch address
     */
    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    /**
     * Gets the branch E mail.
     *
     * @return the branch E mail
     */
    public String getBranchEMail() {
        return branchEMail;
    }

    /**
     * Sets the branch E mail.
     *
     * @param branchEMail the new branch E mail
     */
    public void setBranchEMail(String branchEMail) {
        this.branchEMail = branchEMail;
    }

    /**
     * Gets the branch phone.
     *
     * @return the branch phone
     */
    public String getBranchPhone() {
        return branchPhone;
    }

    /**
     * Sets the branch phone.
     *
     * @param branchPhone the new branch phone
     */
    public void setBranchPhone(String branchPhone) {
        this.branchPhone = branchPhone;
    }

    /**
     * Gets the checks if is merged branch.
     *
     * @return the checks if is merged branch
     */
    public Long getIsMergedBranch() {
        return isMergedBranch;
    }

    /**
     * Sets the checks if is merged branch.
     *
     * @param isMergedBranch the new checks if is merged branch
     */
    public void setIsMergedBranch(Long isMergedBranch) {
        this.isMergedBranch = isMergedBranch;
    }

    /**
     * Gets the checks if is enabled branch.
     *
     * @return the checks if is enabled branch
     */
    public Long getIsEnabledBranch() {
        return isEnabledBranch;
    }

    /**
     * Sets the checks if is enabled branch.
     *
     * @param isEnabledBranch the new checks if is enabled branch
     */
    public void setIsEnabledBranch(Long isEnabledBranch) {
        this.isEnabledBranch = isEnabledBranch;
    }


    /**
     * Instantiates a new LOC ms branch entity.
     */
    public LocMsBankBranchEntity() {
        super();
    }

    /**
     * Instantiates a new LOC ms branch entity.
     *
     * @param branchId the branch id
     */
    public LocMsBankBranchEntity(Long branchId) {
        super();
        this.branchId = branchId;
    }

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocMsBankBranchEntity)) return false;
        LocMsBankBranchEntity that = (LocMsBankBranchEntity) o;
        return Objects.equals(getBranchId(), that.getBranchId()) && Objects.equals(getBranchName(), that.getBranchName()) && Objects.equals(getBranchNameGuj(), that.getBranchNameGuj()) && Objects.equals(getBranchDesc(), that.getBranchDesc()) && Objects.equals(getBranchDescGuj(), that.getBranchDescGuj()) && Objects.equals(getBranchCode(), that.getBranchCode()) && Objects.equals(getBranchCodeGuj(), that.getBranchCodeGuj()) && Objects.equals(getBranchTypeId(), that.getBranchTypeId()) && Objects.equals(getParentBranchId(), that.getParentBranchId()) && Objects.equals(getBankentity(), that.getBankentity()) && Objects.equals(getDistrictId(), that.getDistrictId()) && Objects.equals(getTalukaId(), that.getTalukaId()) && Objects.equals(getIfscCode(), that.getIfscCode()) && Objects.equals(getMicrCode(), that.getMicrCode()) && Objects.equals(getBranchAddress(), that.getBranchAddress()) && Objects.equals(getBranchEMail(), that.getBranchEMail()) && Objects.equals(getBranchPhone(), that.getBranchPhone()) && Objects.equals(getIsMergedBranch(), that.getIsMergedBranch()) && Objects.equals(getIsEnabledBranch(), that.getIsEnabledBranch());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBranchId(), getBranchName(), getBranchNameGuj(), getBranchDesc(), getBranchDescGuj(), getBranchCode(), getBranchCodeGuj(), getBranchTypeId(), getParentBranchId(), getBankentity(), getDistrictId(), getTalukaId(), getIfscCode(), getMicrCode(), getBranchAddress(), getBranchEMail(), getBranchPhone(), getIsMergedBranch(), getIsEnabledBranch());
    }
}