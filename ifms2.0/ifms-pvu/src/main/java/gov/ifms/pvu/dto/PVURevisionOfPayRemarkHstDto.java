package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;

@NativeQueryResultEntity
public class PVURevisionOfPayRemarkHstDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NativeQueryResultColumn(index = 0)
    private String remarks;

    @NativeQueryResultColumn(index = 1)
    private  String reason;

    @NativeQueryResultColumn(index = 2)
    private String roleName;

    @NativeQueryResultColumn(index = 3)
    private Long ropEventId;

    @NativeQueryResultColumn(index = 4)
    private Long eventRemarkId;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRopEventId() {
        return ropEventId;
    }

    public void setRopEventId(Long ropEventId) {
        this.ropEventId = ropEventId;
    }

    public Long getEventRemarkId() {
        return eventRemarkId;
    }

    public void setEventRemarkId(Long eventRemarkId) {
        this.eventRemarkId = eventRemarkId;
    }


    @Override
    public String toString() {
        return "PVURevisionOfPayRemarkHstDto{" +
                "remarks='" + remarks + '\'' +
                ", reason='" + reason + '\'' +
                ", roleName='" + roleName + '\'' +
                ", ropEventId=" + ropEventId +
                ", eventRemarkId=" + eventRemarkId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVURevisionOfPayRemarkHstDto that = (PVURevisionOfPayRemarkHstDto) o;
        return Objects.equals(remarks, that.remarks) &&
                Objects.equals(reason, that.reason) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(ropEventId, that.ropEventId) &&
                Objects.equals(eventRemarkId, that.eventRemarkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remarks, reason, roleName, ropEventId, eventRemarkId);
    }
}
