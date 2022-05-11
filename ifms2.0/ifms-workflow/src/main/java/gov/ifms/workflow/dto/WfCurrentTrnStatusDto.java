package gov.ifms.workflow.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@NativeQueryResultEntity
public class WfCurrentTrnStatusDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @NativeQueryResultColumn(index = 0)
    private Long wfId;
    @NativeQueryResultColumn(index = 1)
    private Long trnId;
    @NativeQueryResultColumn(index = 2)
    private Long actionConfigId;
    @NativeQueryResultColumn(index = 3)
    private Long wfactionId;

    @NativeQueryResultColumn(index = 4)
    private Long assignToWfRoleId;

    @NativeQueryResultColumn(index = 5)
    private Long assignToUserId;

    @NativeQueryResultColumn(index = 6)
    private Long assignToPostId;

    @NativeQueryResultColumn(index = 7)
    private Long assignToPOUId;

    @NativeQueryResultColumn(index = 8)
    private Long assignToOfficeId;

    @NativeQueryResultColumn(index = 9)
    private Long assignToBranchId;

    @NativeQueryResultColumn(index = 10)
    private Long assignToGroupId;

    @NativeQueryResultColumn(index = 11)
    private String wfStatus;

    @NativeQueryResultColumn(index = 12)
    private String trnStatus;


    @NativeQueryResultColumn(index = 13)
    private Long assignByWfRoleId;

    @NativeQueryResultColumn(index = 14)
    private Long assignByUserId;

    @NativeQueryResultColumn(index = 15)
    private Long assignByPostId;

    @NativeQueryResultColumn(index = 16)
    private Long assignByPOUId;

    @NativeQueryResultColumn(index = 17)
    private Long assignByOfficeId;

    @NativeQueryResultColumn(index = 18)
    private Long assignByBranchId;

    @NativeQueryResultColumn(index = 19)
    private Long assignByGroupId;

    @NativeQueryResultColumn(index = 20)
    private String remarks;


    @NativeQueryResultColumn(index = 21)
    private Long createdBy;


    @NativeQueryResultColumn(index = 22)
    private Date createdDate;


    public Long getWfId() {
        return wfId;
    }

    public void setWfId(Long wfId) {
        this.wfId = wfId;
    }

    public Long getTrnId() {
        return trnId;
    }

    public void setTrnId(Long trnId) {
        this.trnId = trnId;
    }

    public Long getActionConfigId() {
        return actionConfigId;
    }

    public void setActionConfigId(Long actionConfigId) {
        this.actionConfigId = actionConfigId;
    }

    public Long getWfactionId() {
        return wfactionId;
    }

    public void setWfactionId(Long wfactionId) {
        this.wfactionId = wfactionId;
    }

    public Long getAssignToWfRoleId() {
        return assignToWfRoleId;
    }

    public void setAssignToWfRoleId(Long assignToWfRoleId) {
        this.assignToWfRoleId = assignToWfRoleId;
    }

    public Long getAssignToUserId() {
        return assignToUserId;
    }

    public void setAssignToUserId(Long assignToUserId) {
        this.assignToUserId = assignToUserId;
    }

    public Long getAssignToPostId() {
        return assignToPostId;
    }

    public void setAssignToPostId(Long assignToPostId) {
        this.assignToPostId = assignToPostId;
    }

    public Long getAssignToPOUId() {
        return assignToPOUId;
    }

    public void setAssignToPOUId(Long assignToPOUId) {
        this.assignToPOUId = assignToPOUId;
    }

    public Long getAssignToOfficeId() {
        return assignToOfficeId;
    }

    public void setAssignToOfficeId(Long assignToOfficeId) {
        this.assignToOfficeId = assignToOfficeId;
    }

    public Long getAssignToBranchId() {
        return assignToBranchId;
    }

    public void setAssignToBranchId(Long assignToBranchId) {
        this.assignToBranchId = assignToBranchId;
    }

    public Long getAssignToGroupId() {
        return assignToGroupId;
    }

    public void setAssignToGroupId(Long assignToGroupId) {
        this.assignToGroupId = assignToGroupId;
    }

    public String getWfStatus() {
        return wfStatus;
    }

    public void setWfStatus(String wfStatus) {
        this.wfStatus = wfStatus;
    }

    public String getTrnStatus() {
        return trnStatus;
    }

    public void setTrnStatus(String trnStatus) {
        this.trnStatus = trnStatus;
    }

    public Long getAssignByWfRoleId() {
        return assignByWfRoleId;
    }

    public void setAssignByWfRoleId(Long assignByWfRoleId) {
        this.assignByWfRoleId = assignByWfRoleId;
    }

    public Long getAssignByUserId() {
        return assignByUserId;
    }

    public void setAssignByUserId(Long assignByUserId) {
        this.assignByUserId = assignByUserId;
    }

    public Long getAssignByPostId() {
        return assignByPostId;
    }

    public void setAssignByPostId(Long assignByPostId) {
        this.assignByPostId = assignByPostId;
    }

    public Long getAssignByPOUId() {
        return assignByPOUId;
    }

    public void setAssignByPOUId(Long assignByPOUId) {
        this.assignByPOUId = assignByPOUId;
    }

    public Long getAssignByOfficeId() {
        return assignByOfficeId;
    }

    public void setAssignByOfficeId(Long assignByOfficeId) {
        this.assignByOfficeId = assignByOfficeId;
    }

    public Long getAssignByBranchId() {
        return assignByBranchId;
    }

    public void setAssignByBranchId(Long assignByBranchId) {
        this.assignByBranchId = assignByBranchId;
    }

    public Long getAssignByGroupId() {
        return assignByGroupId;
    }

    public void setAssignByGroupId(Long assignByGroupId) {
        this.assignByGroupId = assignByGroupId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WfCurrentTrnStatusDto that = (WfCurrentTrnStatusDto) o;
        return Objects.equals(wfId, that.wfId) &&
                Objects.equals(trnId, that.trnId) &&
                Objects.equals(actionConfigId, that.actionConfigId) &&
                Objects.equals(wfactionId, that.wfactionId) &&
                Objects.equals(assignToWfRoleId, that.assignToWfRoleId) &&
                Objects.equals(assignToUserId, that.assignToUserId) &&
                Objects.equals(assignToPostId, that.assignToPostId) &&
                Objects.equals(assignToPOUId, that.assignToPOUId) &&
                Objects.equals(assignToOfficeId, that.assignToOfficeId) &&
                Objects.equals(assignToBranchId, that.assignToBranchId) &&
                Objects.equals(assignToGroupId, that.assignToGroupId) &&
                Objects.equals(wfStatus, that.wfStatus) &&
                Objects.equals(trnStatus, that.trnStatus) &&
                Objects.equals(assignByWfRoleId, that.assignByWfRoleId) &&
                Objects.equals(assignByUserId, that.assignByUserId) &&
                Objects.equals(assignByPostId, that.assignByPostId) &&
                Objects.equals(assignByPOUId, that.assignByPOUId) &&
                Objects.equals(assignByOfficeId, that.assignByOfficeId) &&
                Objects.equals(assignByBranchId, that.assignByBranchId) &&
                Objects.equals(assignByGroupId, that.assignByGroupId) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wfId, trnId, actionConfigId, wfactionId, assignToWfRoleId, assignToUserId, assignToPostId, assignToPOUId, assignToOfficeId, assignToBranchId, assignToGroupId, wfStatus, trnStatus, assignByWfRoleId, assignByUserId, assignByPostId, assignByPOUId, assignByOfficeId, assignByBranchId, assignByGroupId, remarks, createdBy, createdDate);
    }
}

