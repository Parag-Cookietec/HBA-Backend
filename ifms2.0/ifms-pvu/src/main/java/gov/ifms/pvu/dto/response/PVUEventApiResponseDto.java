package gov.ifms.pvu.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUEventApiResponseDto {

    @NativeQueryResultColumn(index = 0)
    private String id;

    @NativeQueryResultColumn(index = 1)
    private String trnNo;

    @NativeQueryResultColumn(index = 2)
    private String eventName;

    @NativeQueryResultColumn(index = 3)
    private String employeeNo;

    @NativeQueryResultColumn(index = 4)
    private String employeeName;

    @NativeQueryResultColumn(index = 5)
    private String designationName;

    @NativeQueryResultColumn(index = 6)
    private String employeeClass;

    @NativeQueryResultColumn(index = 7)
    private String empType;

    @NativeQueryResultColumn(index = 8)
    private String panNo;

    @NativeQueryResultColumn(index = 9)
    private String officeName;

    @NativeQueryResultColumn(index = 10)
    private String status;

    @NativeQueryResultColumn(index = 11)
    private String retirementDate;

    @JsonIgnore
    @NativeQueryResultColumn(index = 12)
    private Long count;

    @NativeQueryResultColumn(index = 13)
    private String eventCode;

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrnNo() {
        return trnNo;
    }

    public void setTrnNo(String trnNo) {
        this.trnNo = trnNo;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getEmployeeClass() {
        return employeeClass;
    }

    public void setEmployeeClass(String employeeClass) {
        this.employeeClass = employeeClass;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRetirementDate() {
        return retirementDate;
    }

    public void setRetirementDate(String retirementDate) {
        this.retirementDate = retirementDate;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
