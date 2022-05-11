package gov.ifms.doi.hba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TdoiHbaProposalListingDTO {

    private long hbaProposalId;
    private Date proposalDate;
    private String loanAccountNo;
    private String employeeNo;
    private String employeeName;
    private String officeAddress;
    private String houseAddress;
    private short termInsYrs;
    private double sumInsured;
    private Date createdDate;
    private long createdBy;
    private long updatedBy;
    private Date updatedDate;
    private String status;

    public long getHbaProposalId() {
        return hbaProposalId;
    }

    public void setHbaProposalId(long hbaProposalId) {
        this.hbaProposalId = hbaProposalId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLoanAccountNo() {
        return loanAccountNo;
    }

    public void setLoanAccountNo(String loanAccountNo) {
        this.loanAccountNo = loanAccountNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public short getTermInsYrs() {
        return termInsYrs;
    }

    public void setTermInsYrs(short termInsYrs) {
        this.termInsYrs = termInsYrs;
    }

    public double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(Date proposalDate) {
        this.proposalDate = proposalDate;
    }
}
