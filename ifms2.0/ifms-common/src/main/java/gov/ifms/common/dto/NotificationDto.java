package gov.ifms.common.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

public class NotificationDto implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull
    private Long trnId;

    @NotNull
    private Long listingMenuId;

    @NotNull
    private String eventCategory;

    @NotNull
    private String eventName;

    private String trnRefNo;

    private Long assignByOfficeId;

    private Long assignToOfficeId;


    private Long branchId;

    private Date expiredDate;

    private Long roleId;

    private Object userId;

    private Long assignToPOUId;

    private Long assignByPOUId;

    private Set<Long> toEmailSMSPOUIds;

    private Set<Long> ccEmailPOUIds;

    private Set<Long> bccEmailPOUIds;

    private Map<String,String> dynamicParam = new HashMap<>();

    private List<FileAttachmentDto> fileAttachmentDtos;

    private Long wfId;

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

    public Long getListingMenuId() {
        return listingMenuId;
    }

    public void setListingMenuId(Long listingMenuId) {
        this.listingMenuId = listingMenuId;
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

    public String getTrnRefNo() {
        return trnRefNo;
    }

    public void setTrnRefNo(String trnRefNo) {
        this.trnRefNo = trnRefNo;
    }



    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAssignToPOUId() {
        return assignToPOUId;
    }

    public void setAssignToPOUId(Long assignToPOUId) {
        this.assignToPOUId = assignToPOUId;
    }

    public Long getAssignByPOUId() {
        return assignByPOUId;
    }

    public void setAssignByPOUId(Long assignByPOUId) {
        this.assignByPOUId = assignByPOUId;
    }

    public Set<Long> getToEmailSMSPOUIds() {
        return toEmailSMSPOUIds;
    }

    public void setToEmailSMSPOUIds(Set<Long> toEmailSMSPOUIds) {
        this.toEmailSMSPOUIds = toEmailSMSPOUIds;
    }

    public Set<Long> getCcEmailPOUIds() {
        return ccEmailPOUIds;
    }

    public void setCcEmailPOUIds(Set<Long> ccEmailPOUIds) {
        this.ccEmailPOUIds = ccEmailPOUIds;
    }

    public Set<Long> getBccEmailPOUIds() {
        return bccEmailPOUIds;
    }

    public void setBccEmailPOUIds(Set<Long> bccEmailPOUIds) {
        this.bccEmailPOUIds = bccEmailPOUIds;
    }

    public Map<String, String> getDynamicParam() {
        return dynamicParam;
    }

    public void setDynamicParam(Map<String, String> dynamicParam) {
        this.dynamicParam = dynamicParam;
    }

    public List<FileAttachmentDto> getFileAttachmentDtos() {
        return fileAttachmentDtos;
    }

    public void setFileAttachmentDtos(List<FileAttachmentDto> fileAttachmentDtos) {
        this.fileAttachmentDtos = fileAttachmentDtos;
    }

    public Long getAssignByOfficeId() {
        return assignByOfficeId;
    }

    public void setAssignByOfficeId(Long assignByOfficeId) {
        this.assignByOfficeId = assignByOfficeId;
    }

    public Long getAssignToOfficeId() {
        return assignToOfficeId;
    }

    public void setAssignToOfficeId(Long assignToOfficeId) {
        this.assignToOfficeId = assignToOfficeId;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationDto that = (NotificationDto) o;
        return Objects.equals(trnId, that.trnId) && Objects.equals(listingMenuId, that.listingMenuId) && Objects.equals(eventCategory, that.eventCategory) && Objects.equals(eventName, that.eventName) && Objects.equals(trnRefNo, that.trnRefNo) && Objects.equals(assignByOfficeId, that.assignByOfficeId) && Objects.equals(assignToOfficeId, that.assignToOfficeId) && Objects.equals(branchId, that.branchId) && Objects.equals(expiredDate, that.expiredDate) && Objects.equals(roleId, that.roleId) && Objects.equals(userId, that.userId) && Objects.equals(assignToPOUId, that.assignToPOUId) && Objects.equals(assignByPOUId, that.assignByPOUId) && Objects.equals(toEmailSMSPOUIds, that.toEmailSMSPOUIds) && Objects.equals(ccEmailPOUIds, that.ccEmailPOUIds) && Objects.equals(bccEmailPOUIds, that.bccEmailPOUIds) && Objects.equals(dynamicParam, that.dynamicParam) && Objects.equals(fileAttachmentDtos, that.fileAttachmentDtos) && Objects.equals(wfId, that.wfId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trnId, listingMenuId, eventCategory, eventName, trnRefNo, assignByOfficeId, assignToOfficeId, branchId, expiredDate, roleId, userId, assignToPOUId, assignByPOUId, toEmailSMSPOUIds, ccEmailPOUIds, bccEmailPOUIds, dynamicParam, fileAttachmentDtos, wfId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NotificationDto.class.getSimpleName() + "[", "]")
                .add("trnId=" + trnId)
                .add("listingMenuId=" + listingMenuId)
                .add("eventCategory='" + eventCategory + "'")
                .add("eventName='" + eventName + "'")
                .add("trnRefNo='" + trnRefNo + "'")
                .add("assignByOfficeId=" + assignByOfficeId)
                .add("assignToOfficeId=" + assignToOfficeId)
                .add("branchId=" + branchId)
                .add("expiredDate=" + expiredDate)
                .add("roleId=" + roleId)
                .add("userId=" + userId)
                .add("assignToPOUId=" + assignToPOUId)
                .add("assignByPOUId=" + assignByPOUId)
                .add("toEmailSMSPOUIds=" + toEmailSMSPOUIds)
                .add("ccEmailPOUIds=" + ccEmailPOUIds)
                .add("bccEmailPOUIds=" + bccEmailPOUIds)
                .add("dynamicParam=" + dynamicParam)
                .add("fileAttachmentDtos=" + fileAttachmentDtos)
                .add("wfId=" + wfId)
                .toString();
    }
}

