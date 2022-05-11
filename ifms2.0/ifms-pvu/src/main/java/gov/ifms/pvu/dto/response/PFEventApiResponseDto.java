package gov.ifms.pvu.dto.response;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PFEventApiResponseDto {

    @NativeQueryResultColumn(index = 0)
    private String employeeId;

    @NativeQueryResultColumn(index = 1)
    private String trnNo;

    @NativeQueryResultColumn(index = 2)
    private String employeeNo;

    @NativeQueryResultColumn(index = 3)
    private String employeeName;

    @NativeQueryResultColumn(index = 4)
    private String designationName;

    @NativeQueryResultColumn(index = 5)
    private String empType;

    @NativeQueryResultColumn(index = 6)
    private String officeName;

    @NativeQueryResultColumn(index = 7)
    private String status;

    @NativeQueryResultColumn(index = 8)
    private String eventName;

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

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTrnNo() {
        return trnNo;
    }

    public void setTrnNo(String trnNo) {
        this.trnNo = trnNo;
    }
}