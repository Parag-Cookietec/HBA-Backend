package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;


/**
 * The Class PVUEmployeEOLeaveView.
 *
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 */
@NativeQueryResultEntity
public class PVURevisionOfPayView implements Serializable {

    private static final long serialVersionUID = 1L;

    @NativeQueryResultColumn(index = 0)
    private String transactionNumber;




    @NativeQueryResultColumn(index = 1)
    private long employeeId;

    @NativeQueryResultColumn(index = 2)
    private String employeeName;

    @NativeQueryResultColumn(index = 3)
    private String designationName;

    @NativeQueryResultColumn(index = 4)
    private String unknown;


    @NativeQueryResultColumn(index = 5)
    private String officeName;

    @NativeQueryResultColumn(index = 6)
    private String status;

    @NativeQueryResultColumn(index = 7)
    private String employeeNo;

    @NativeQueryResultColumn(index = 8)
    private long recordCount;

    @NativeQueryResultColumn(index = 9)
    private long eventId;

    @NativeQueryResultColumn(index = 10)
    private long createdDate;


    @NativeQueryResultColumn(index = 11)
    private long test;

    @NativeQueryResultColumn(index = 12)
    private String wfStatus;


    @NativeQueryResultColumn(index = 13)
    private Date nextIncrementDate;

    @NativeQueryResultColumn(index = 14)
    private Long payLevel;


    @NativeQueryResultColumn(index = 15)
    private Long cellId;

    @NativeQueryResultColumn(index = 16)
    private Long payBand;

    @NativeQueryResultColumn(index = 17)
    private Long payBandValue;

    @NativeQueryResultColumn(index = 18)
    private Long gradePay;

    @NativeQueryResultColumn(index = 19)
    private Long basicPay;


    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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

    public String getUnknown() {
        return unknown;
    }

    public void setUnknown(String unknown) {
        this.unknown = unknown;
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

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getTest() {
        return test;
    }

    public void setTest(long test) {
        this.test = test;
    }

    public String getWfStatus() {
        return wfStatus;
    }

    public void setWfStatus(String wfStatus) {
        this.wfStatus = wfStatus;
    }

    public Date getNextIncrementDate() {
        return nextIncrementDate;
    }

    public void setNextIncrementDate(Date nextIncrementDate) {
        this.nextIncrementDate = nextIncrementDate;
    }

    public Long getPayLevel() {
        return payLevel;
    }

    public void setPayLevel(Long payLevel) {
        this.payLevel = payLevel;
    }

    public Long getCellId() {
        return cellId;
    }

    public void setCellId(Long cellId) {
        this.cellId = cellId;
    }

    public Long getPayBand() {
        return payBand;
    }

    public void setPayBand(Long payBand) {
        this.payBand = payBand;
    }

    public Long getPayBandValue() {
        return payBandValue;
    }

    public void setPayBandValue(Long payBandValue) {
        this.payBandValue = payBandValue;
    }

    public Long getGradePay() {
        return gradePay;
    }

    public void setGradePay(Long gradePay) {
        this.gradePay = gradePay;
    }

    public Long getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(Long basicPay) {
        this.basicPay = basicPay;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVURevisionOfPayView that = (PVURevisionOfPayView) o;
        return employeeId == that.employeeId &&
                recordCount == that.recordCount &&
                eventId == that.eventId &&
                createdDate == that.createdDate &&
                test == that.test &&
                Objects.equals(transactionNumber, that.transactionNumber) &&
                Objects.equals(employeeName, that.employeeName) &&
                Objects.equals(designationName, that.designationName) &&
                Objects.equals(unknown, that.unknown) &&
                Objects.equals(officeName, that.officeName) &&
                Objects.equals(status, that.status) &&
                Objects.equals(employeeNo, that.employeeNo) &&
                Objects.equals(wfStatus, that.wfStatus) &&
                Objects.equals(nextIncrementDate, that.nextIncrementDate) &&
                Objects.equals(payLevel, that.payLevel) &&
                Objects.equals(cellId, that.cellId) &&
                Objects.equals(payBand, that.payBand) &&
                Objects.equals(payBandValue, that.payBandValue) &&
                Objects.equals(gradePay, that.gradePay) &&
                Objects.equals(basicPay, that.basicPay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionNumber, employeeId, employeeName, designationName, unknown, officeName, status, employeeNo, recordCount, eventId, createdDate, test, wfStatus, nextIncrementDate, payLevel, cellId, payBand, payBandValue, gradePay, basicPay);
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", PVURevisionOfPayView.class.getSimpleName() + "[", "]")
                .add("transactionNumber='" + transactionNumber + "'")
                .add("employeeId=" + employeeId)
                .add("employeeName='" + employeeName + "'")
                .add("designationName='" + designationName + "'")
                .add("unknown='" + unknown + "'")
                .add("officeName='" + officeName + "'")
                .add("status='" + status + "'")
                .add("employeeNo='" + employeeNo + "'")
                .add("recordCount=" + recordCount)
                .add("eventId=" + eventId)
                .add("createdDate=" + createdDate)
                .add("test=" + test)
                .add("wfStatus='" + wfStatus + "'")
                .add("nextIncrementDate=" + nextIncrementDate)
                .add("payLevel=" + payLevel)
                .add("cellId=" + cellId)
                .add("payBand=" + payBand)
                .add("payBandValue=" + payBandValue)
                .add("gradePay=" + gradePay)
                .add("basicPay=" + basicPay)
                .toString();
    }
}
