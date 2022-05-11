package gov.ifms.doi.hba.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class EmployeeDetailsDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    @NativeQueryResultColumn(index = 0)
    private String hbaMcaAccNum;
    @NativeQueryResultColumn(index = 1)
    private String employeeNum;
    @NativeQueryResultColumn(index = 2)
    private String firstName;
    @NativeQueryResultColumn(index = 3)
    private String middleName;
    @NativeQueryResultColumn(index = 4)
    private String lastName;
    @NativeQueryResultColumn(index = 5)
    private double loanAmt;
    @NativeQueryResultColumn(index = 6)
    private String officeName;
    @NativeQueryResultColumn(index = 7)
    private Integer designationId;
    @NativeQueryResultColumn(index = 8)
    private String officeAdd;

    public String getHbaMcaAccNum() {
        return hbaMcaAccNum;
    }

    public void setHbaMcaAccNum(String hbaMcaAccNum) {
        this.hbaMcaAccNum = hbaMcaAccNum;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(double loanAmt) {
        this.loanAmt = loanAmt;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Integer getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    public String getOfficeAdd() {
        return officeAdd;
    }

    public void setOfficeAdd(String officeAdd) {
        this.officeAdd = officeAdd;
    }
}
