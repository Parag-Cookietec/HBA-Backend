package gov.ifms.common.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import javax.persistence.Column;
import java.util.Date;
import java.util.Objects;

@NativeQueryResultEntity
public class SystemNotificationDto {

    @NativeQueryResultColumn(index = 0)
    private Long tnfSnId;

    @NativeQueryResultColumn(index = 1)
    private Long trnId;

    @NativeQueryResultColumn(index = 2)
    private String trnNo;

    @NativeQueryResultColumn(index = 3)
    private Long menuId;

    @NativeQueryResultColumn(index = 4)
    private String eventCategory;

    @NativeQueryResultColumn(index = 5)
    private String eventName;

    @NativeQueryResultColumn(index = 6)
    private String status;

    @NativeQueryResultColumn(index = 7)
    private String snMsg;

    @NativeQueryResultColumn(index = 8)
    private Date expireDate;

    @NativeQueryResultColumn(index = 9)
    private int activeStatus;

    @NativeQueryResultColumn(index = 10)
    private Long assignToPouId;

    @NativeQueryResultColumn(index = 11)
    private Long assignByPouId;

    @NativeQueryResultColumn(index = 12)
    private Long createdBy;

    @NativeQueryResultColumn(index = 13)
    private Date createdDate;

    @NativeQueryResultColumn(index = 14)
    private Long createdByPost;

    @NativeQueryResultColumn(index = 15)
    private Long updatedBy;

    @NativeQueryResultColumn(index = 16)
    private Date updatedDate;

    @NativeQueryResultColumn(index = 17)
    private Long updatedByPost;

    @NativeQueryResultColumn(index = 18)
    private Long officeId;

    public SystemNotificationDto() {
        super();
    }

    public Long getTnfSnId() {
        return tnfSnId;
    }

    public void setTnfSnId(Long tnfSnId) {
        this.tnfSnId = tnfSnId;
    }

    public Long getTrnId() {
        return trnId;
    }

    public void setTrnId(Long trnId) {
        this.trnId = trnId;
    }

    public String getTrnNo() {
        return trnNo;
    }

    public void setTrnNo(String trnNo) {
        this.trnNo = trnNo;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSnMsg() {
        return snMsg;
    }

    public void setSnMsg(String snMsg) {
        this.snMsg = snMsg;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Long getAssignToPouId() {
        return assignToPouId;
    }

    public void setAssignToPouId(Long assignToPouId) {
        this.assignToPouId = assignToPouId;
    }

    public Long getAssignByPouId() {
        return assignByPouId;
    }

    public void setAssignByPouId(Long assignByPouId) {
        this.assignByPouId = assignByPouId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedByPost() {
        return createdByPost;
    }

    public void setCreatedByPost(Long createdByPost) {
        this.createdByPost = createdByPost;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getUpdatedByPost() {
        return updatedByPost;
    }

    public void setUpdatedByPost(Long updatedByPost) {
        this.updatedByPost = updatedByPost;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemNotificationDto that = (SystemNotificationDto) o;
        return activeStatus == that.activeStatus && Objects.equals(tnfSnId, that.tnfSnId) && Objects.equals(trnId, that.trnId) && Objects.equals(trnNo, that.trnNo) && Objects.equals(menuId, that.menuId) && Objects.equals(eventCategory, that.eventCategory) && Objects.equals(eventName, that.eventName) && Objects.equals(status, that.status) && Objects.equals(snMsg, that.snMsg) && Objects.equals(expireDate, that.expireDate) && Objects.equals(assignToPouId, that.assignToPouId) && Objects.equals(assignByPouId, that.assignByPouId) && Objects.equals(createdBy, that.createdBy) && Objects.equals(createdDate, that.createdDate) && Objects.equals(createdByPost, that.createdByPost) && Objects.equals(updatedBy, that.updatedBy) && Objects.equals(updatedDate, that.updatedDate) && Objects.equals(updatedByPost, that.updatedByPost) && Objects.equals(officeId, that.officeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tnfSnId, trnId, trnNo, menuId, eventCategory, eventName, status, snMsg, expireDate, activeStatus, assignToPouId, assignByPouId, createdBy, createdDate, createdByPost, updatedBy, updatedDate, updatedByPost, officeId);
    }
}
