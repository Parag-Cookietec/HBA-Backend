package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

import java.io.Serializable;


/**
 * The Class LocOpenReqBankViewDto.
 */
public class LocOpenReqBankViewDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The emp number.
     */
    @NativeQueryResultColumn(index = 0)
    private String empNumber;

    /**
     * The emp name.
     */
    @NativeQueryResultColumn(index = 1)
    private String empName;

    /**
     * The user role.
     */
    @NativeQueryResultColumn(index = 2)
    private String userRole;

    /**
     * The designation.
     */
    @NativeQueryResultColumn(index = 3)
    private String designation;

    /**
     * The bank id.
     */
    @NativeQueryResultColumn(index = 4)
    private Long bankId;

    /**
     * The bank branch id.
     */
    @NativeQueryResultColumn(index = 5)
    private Long bankBranchId;

    /**
     * The bank name.
     */
    @NativeQueryResultColumn(index = 6)
    private String bankName;

    /**
     * The ban branck name.
     */
    @NativeQueryResultColumn(index = 7)
    private String banBranckName;

    /**
     * The bank code.
     */
    @NativeQueryResultColumn(index = 8)
    private String bankCode;

    /**
     * The date time.
     */
    @NativeQueryResultColumn(index = 9)
    private String dateTime;

    /**
     * The bank remarks.
     */
    @NativeQueryResultColumn(index = 10)
    private String bankRemarks;

    /**
     * The record count.
     */
    @NativeQueryResultColumn(index = 11)
    private int recordCount;

    /**
     * Gets the emp number.
     *
     * @return the empNumber
     */
    public String getEmpNumber() {
        return empNumber;
    }

    /**
     * Sets the emp number.
     *
     * @param empNumber the empNumber to set
     */
    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    /**
     * Gets the emp name.
     *
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * Sets the emp name.
     *
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * Gets the user role.
     *
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets the user role.
     *
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * Gets the designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets the designation.
     *
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
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
     * Gets the bank branch id.
     *
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
     * Gets the date time.
     *
     * @return the dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date time.
     *
     * @param dateTime the dateTime to set
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Gets the bank remarks.
     *
     * @return the bankRemarks
     */
    public String getBankRemarks() {
        return bankRemarks;
    }

    /**
     * Sets the bank remarks.
     *
     * @param bankRemarks the bankRemarks to set
     */
    public void setBankRemarks(String bankRemarks) {
        this.bankRemarks = bankRemarks;
    }

    /**
     * Gets the record count.
     *
     * @return the recordCount
     */
    public int getRecordCount() {
        return recordCount;
    }

    /**
     * Sets the record count.
     *
     * @param recordCount the recordCount to set
     */
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
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
     * @return the banBranckName
     */
    public String getBanBranckName() {
        return banBranckName;
    }

    /**
     * @param banBranckName the banBranckName to set
     */
    public void setBanBranckName(String banBranckName) {
        this.banBranckName = banBranckName;
    }

}
