package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class PVUEmployeEventsDto.
 */

public class PVUEmployeEventsDto extends BaseDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The emp event id.
     */
    private long empEventId;

    /**
     * The emp id.
     */
    private long empId;

    /**
     * The trn no.
     */
    private String trnNo;

    /**
     * The event name.
     */
    private String eventName;

    /**
     * The event date.
     */
    private LocalDateTime eventDate;

    /**
     * The emp pay band.
     */
    private Integer empPayBand;

    /**
     * The emp pay lvl grd pay.
     */
    private Integer empPaylevel;

    /**
     * The emp basic pay.
     */
    private Long empBasicPay;

    /**
     * The emp next incr date.
     */
    private LocalDateTime empNextIncrDate;

    /**
     * The emp designation.
     */
    private Long empDesignation;

    /**
     * The emp option.
     */
    private Long empOption;

    /**
     * The emp auto approve.
     */
    private LocalDateTime empAutoApprove;

    /**
     * The pay commission.
     */
    private Long payCommission;

    /**
     * The cell id.
     */
    private Long cellId;

    /**
     * The pay band value.
     */
    private Long payBandValue;

    /**
     * The pay scale.
     */
    private Long payScale;

    /**
     * The emp grd pay.
     */
    private Long empGrdPay;

    /**
     * The office id.
     */
    private Long officeId;

    /**
     * The eventId.
     */
    private Long eventId;

    /**
     * The sourceId.
     */
    private Long sourceId;

    /**
     * The eventType.
     */
    private byte eventType;

    /**
     * The remarks.
     */
    private String remarks;

    /**
     * The personalPay.
     */
    private Long personalPay = 0L;

    /**
     * The employeeTypeId.
     */
    private Long employeeTypeId;


    public Long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public Long getEmployeeClassId() {
        return employeeClassId;
    }

    public void setEmployeeClassId(Long employeeClassId) {
        this.employeeClassId = employeeClassId;
    }

    /**
     * The personalPay.
     */
    private Long employeeClassId;

    /**
     * PVUEmployeEventsDto Constructor.
     */
    public PVUEmployeEventsDto() {
        super();
    }


    /**
     * Gets the emp event id.
     *
     * @return the emp event id
     */
    public long getEmpEventId() {
        return empEventId;
    }

    /**
     * Sets the emp event id.
     *
     * @param empEventId the new emp event id
     */
    public void setEmpEventId(long empEventId) {
        this.empEventId = empEventId;
    }

    /**
     * Gets the emp id.
     *
     * @return the emp id
     */
    public long getEmpId() {
        return empId;
    }

    /**
     * Sets the emp id.
     *
     * @param empId the new emp id
     */
    public void setEmpId(long empId) {
        this.empId = empId;
    }

    /**
     * Gets the trn no.
     *
     * @return the trn no
     */
    public String getTrnNo() {
        return trnNo;
    }

    /**
     * Sets the trn no.
     *
     * @param trnNo the new trn no
     */
    public void setTrnNo(String trnNo) {
        this.trnNo = trnNo;
    }

    /**
     * Gets the event name.
     *
     * @return the event name
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the event name.
     *
     * @param eventName the new event name
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Gets the event date.
     *
     * @return the event date
     */
    public LocalDateTime getEventDate() {
        return eventDate;
    }

    /**
     * Sets the event date.
     *
     * @param eventDate the new event date
     */
    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Gets the emp pay band.
     *
     * @return the emp pay band
     */
    public Integer getEmpPayBand() {
        return empPayBand;
    }

    /**
     * Sets the emp pay band.
     *
     * @param empPayBand the new emp pay band
     */
    public void setEmpPayBand(Integer empPayBand) {
        this.empPayBand = empPayBand;
    }

    /**
     * Gets the emp paylevel.
     *
     * @return the emp paylevel
     */
    public Integer getEmpPaylevel() {
        return empPaylevel;
    }

    /**
     * Sets the emp paylevel.
     *
     * @param empPaylevel the new emp paylevel
     */
    public void setEmpPaylevel(Integer empPaylevel) {
        this.empPaylevel = empPaylevel;
    }

    /**
     * Gets the emp basic pay.
     *
     * @return the emp basic pay
     */
    public Long getEmpBasicPay() {
        return empBasicPay;
    }

    /**
     * Sets the emp basic pay.
     *
     * @param empBasicPay the new emp basic pay
     */
    public void setEmpBasicPay(Long empBasicPay) {
        this.empBasicPay = empBasicPay;
    }

    /**
     * Gets the emp next incr date.
     *
     * @return the emp next incr date
     */
    public LocalDateTime getEmpNextIncrDate() {
        return empNextIncrDate;
    }

    /**
     * Sets the emp next incr date.
     *
     * @param empNextIncrDate the new emp next incr date
     */
    public void setEmpNextIncrDate(LocalDateTime empNextIncrDate) {
        this.empNextIncrDate = empNextIncrDate;
    }

    /**
     * Gets the emp designation.
     *
     * @return the emp designation
     */
    public Long getEmpDesignation() {
        return empDesignation;
    }

    /**
     * Sets the emp designation.
     *
     * @param empDesignation the new emp designation
     */
    public void setEmpDesignation(Long empDesignation) {
        this.empDesignation = empDesignation;
    }

    /**
     * Gets the emp option.
     *
     * @return the emp option
     */
    public Long getEmpOption() {
        return empOption;
    }

    /**
     * Sets the emp option.
     *
     * @param empOption the new emp option
     */
    public void setEmpOption(Long empOption) {
        this.empOption = empOption;
    }

    /**
     * Gets the emp auto approve.
     *
     * @return the emp auto approve
     */
    public LocalDateTime getEmpAutoApprove() {
        return empAutoApprove;
    }

    /**
     * Sets the emp auto approve.
     *
     * @param empAutoApprove the new emp auto approve
     */
    public void setEmpAutoApprove(LocalDateTime empAutoApprove) {
        this.empAutoApprove = empAutoApprove;
    }

    /**
     * Gets the pay commission.
     *
     * @return the pay commission
     */
    public Long getPayCommission() {
        return payCommission;
    }

    /**
     * Sets the pay commission.
     *
     * @param payCommission the new pay commission
     */
    public void setPayCommission(Long payCommission) {
        this.payCommission = payCommission;
    }

    /**
     * Gets the cell id.
     *
     * @return the cell id
     */
    public Long getCellId() {
        return cellId;
    }

    /**
     * Sets the cell id.
     *
     * @param cellId the new cell id
     */
    public void setCellId(Long cellId) {
        this.cellId = cellId;
    }

    /**
     * Gets the pay band value.
     *
     * @return the pay band value
     */
    public Long getPayBandValue() {
        return payBandValue;
    }

    /**
     * Sets the pay band value.
     *
     * @param payBandValue the new pay band value
     */
    public void setPayBandValue(Long payBandValue) {
        this.payBandValue = payBandValue;
    }

    /**
     * Gets the pay scale.
     *
     * @return the pay scale
     */
    public Long getPayScale() {
        return payScale;
    }

    /**
     * Sets the pay scale.
     *
     * @param payScale the new pay scale
     */
    public void setPayScale(Long payScale) {
        this.payScale = payScale;
    }

    /**
     * Gets the emp grd pay.
     *
     * @return the emp grd pay
     */
    public Long getEmpGrdPay() {
        return empGrdPay;
    }

    /**
     * Sets the emp grd pay.
     *
     * @param empGrdPay the new emp grd pay
     */
    public void setEmpGrdPay(Long empGrdPay) {
        this.empGrdPay = empGrdPay;
    }

    /**
     * Gets the office id.
     *
     * @return the office id
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * Sets the office id.
     *
     * @param officeId the new office id
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }


    /**
     * Getter for property 'eventId'.
     *
     * @return Value for property 'eventId'.
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * Setter for property 'eventId'.
     *
     * @param eventId Value to set for property 'eventId'.
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * Getter for property 'sourceId'.
     *
     * @return Value for property 'sourceId'.
     */
    public Long getSourceId() {
        return sourceId;
    }

    /**
     * Setter for property 'sourceId'.
     *
     * @param sourceId Value to set for property 'sourceId'.
     */
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * Getter for property 'eventType'.
     *
     * @return Value for property 'eventType'.
     */
    public byte getEventType() {
        return eventType;
    }

    /**
     * Setter for property 'eventType'.
     *
     * @param eventType Value to set for property 'eventType'.
     */
    public void setEventType(byte eventType) {
        this.eventType = eventType;
    }

    /**
     * Getter for property 'remarks'.
     *
     * @return Value for property 'remarks'.
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Setter for property 'remarks'.
     *
     * @param remarks Value to set for property 'remarks'.
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    /**
     * Getter for property 'personalPay'.
     *
     * @return Value for property 'personalPay'.
     */
    public long getPersonalPay() {
        return personalPay;
    }

    /**
     * Setter for property 'personalPay'.
     *
     * @param personalPay Value to set for property 'personalPay'.
     */
    public void setPersonalPay(long personalPay) {
        this.personalPay = personalPay;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", PVUEmployeEventsDto.class.getSimpleName() + "[", "]")
                .add("empEventId=" + empEventId)
                .add("empId=" + empId)
                .add("trnNo='" + trnNo + "'")
                .add("eventName='" + eventName + "'")
                .add("eventDate=" + eventDate)
                .add("empPayBand=" + empPayBand)
                .add("empPaylevel=" + empPaylevel)
                .add("empBasicPay=" + empBasicPay)
                .add("empNextIncrDate=" + empNextIncrDate)
                .add("empDesignation=" + empDesignation)
                .add("empOption=" + empOption)
                .add("empAutoApprove=" + empAutoApprove)
                .add("payCommission=" + payCommission)
                .add("cellId=" + cellId)
                .add("payBandValue=" + payBandValue)
                .add("payScale=" + payScale)
                .add("empGrdPay=" + empGrdPay)
                .add("officeId=" + officeId)
                .add("eventId=" + eventId)
                .add("sourceId=" + sourceId)
                .add("employeeClassId=" + employeeClassId)
                .add("eventType=" + eventType)
                .add("personalPay=" + personalPay)
                .add("remarks='" + remarks + "'")
                .toString();
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PVUEmployeEventsDto)) return false;
        PVUEmployeEventsDto that = (PVUEmployeEventsDto) obj;
        return empEventId == that.empEventId &&
                empId == that.empId &&
                eventType == that.eventType &&
                Objects.equals(trnNo, that.trnNo) &&
                Objects.equals(eventName, that.eventName) &&
                Objects.equals(eventDate, that.eventDate) &&
                Objects.equals(empPayBand, that.empPayBand) &&
                Objects.equals(empPaylevel, that.empPaylevel) &&
                Objects.equals(empBasicPay, that.empBasicPay) &&
                Objects.equals(empNextIncrDate, that.empNextIncrDate) &&
                Objects.equals(empDesignation, that.empDesignation) &&
                Objects.equals(empOption, that.empOption) &&
                Objects.equals(empAutoApprove, that.empAutoApprove) &&
                Objects.equals(payCommission, that.payCommission) &&
                Objects.equals(cellId, that.cellId) &&
                Objects.equals(payBandValue, that.payBandValue) &&
                Objects.equals(payScale, that.payScale) &&
                Objects.equals(empGrdPay, that.empGrdPay) &&
                Objects.equals(officeId, that.officeId) &&
                Objects.equals(personalPay, that.personalPay) &&
                Objects.equals(employeeClassId, that.employeeClassId) &&
                Objects.equals(employeeTypeId, that.employeeTypeId) &&
                Objects.equals(eventId, that.eventId) &&
                Objects.equals(sourceId, that.sourceId) &&
                Objects.equals(remarks, that.remarks);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(empEventId, empId, trnNo, eventName,
                eventDate, empPayBand, empPaylevel, empBasicPay,
                empNextIncrDate, empDesignation, empOption, empAutoApprove,
                payCommission, cellId, payBandValue, payScale,
                employeeClassId,
                employeeTypeId,
                empGrdPay,
                officeId, eventId, sourceId, eventType, remarks, personalPay);
    }
}
