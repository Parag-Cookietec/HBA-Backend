package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.util.Objects;

/**
 * The Class PVUEventsRemarkDto.
 */

public class PVUEventsRemarkDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long trnNo;

    private Long eventId;

    private Long wfRoleId;

    private Long employeeId;

    private String remarks;

    private String remarkType;

    private Long reasonId;

    public PVUEventsRemarkDto(Long id) {
        this.id = id;
    }

    public PVUEventsRemarkDto() {
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrnNo() {
        return trnNo;
    }

    public void setTrnNo(Long trnNo) {
        this.trnNo = trnNo;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getWfRoleId() {
        return wfRoleId;
    }

    public void setWfRoleId(Long wfRoleId) {
        this.wfRoleId = wfRoleId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getRemarkType() {
        return remarkType;
    }

    public void setRemarkType(String remarkType) {
        this.remarkType = remarkType;
    }

    public Long getReasonId() {
        return reasonId;
    }

    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVUEventsRemarkDto that = (PVUEventsRemarkDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(trnNo, that.trnNo) &&
                Objects.equals(eventId, that.eventId) &&
                Objects.equals(wfRoleId, that.wfRoleId) &&
                Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(remarkType, that.remarkType) &&
                Objects.equals(reasonId, that.reasonId);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, trnNo, eventId, wfRoleId, employeeId, remarks, remarkType, reasonId);
    }

    /**
     * toString method.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUEventsRemarkDto{" +
                "id=" + id +
                ", trnNo=" + trnNo +
                ", eventId=" + eventId +
                ", wfRoleId=" + wfRoleId +
                ", employeeId=" + employeeId +
                ", remarks='" + remarks + '\'' +
                ", remarkType='" + remarkType + '\'' +
                ", reason='" + reasonId + '\'' +
                '}';
    }
}
