package gov.ifms.common.attachment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MasterAttachmentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long menuId;

    private Long eventId;

    private Long attachmentId;

    private String userId;

    private Long lkPOUId;

    private String categoryName;

    private Long trnId;

    public Long getTrnId() {
        return trnId;
    }

    public void setTrnId(Long trnId) {
        this.trnId = trnId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getLkPOUId() {
        return lkPOUId;
    }

    public void setLkPOUId(Long lkPOUId) {
        this.lkPOUId = lkPOUId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    transient List<AttachmentCommonDto> attachmentCommonDtoList;

    public List<AttachmentCommonDto> getAttachmentCommonDtoList() {
        return attachmentCommonDtoList;
    }

    public void setAttachmentCommonDtoList(List<AttachmentCommonDto> attachmentCommonDtoList) {
        this.attachmentCommonDtoList = attachmentCommonDtoList;
    }
}
