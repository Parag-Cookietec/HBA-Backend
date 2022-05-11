package gov.ifms.common.attachment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class AttachmentCommonDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NativeQueryResultColumn(index = 0)
    private Long attachmentId;

    @NotNull
    @NativeQueryResultColumn(index = 1)
    private Long trnId;

    @NotNull
    private Long menuId;

    private Long eventId;

    @NativeQueryResultColumn(index = 2)
    private Long attachmentTypeId;

    @NativeQueryResultColumn(index = 3)
    private String attachmentTypeName;

    @NativeQueryResultColumn(index = 4)
    private String fileName;

    @NativeQueryResultColumn(index = 6)
    private String uploadedFileName;

    private Long categoryId;

    @NotNull
    @NativeQueryResultColumn(index = 5)
    private String uploadDirectoryPath;

    @NotNull
    private String format;

    @NotNull
    @NativeQueryResultColumn(index = 7)
    private Integer fileSize;

    @NotNull
    private transient MultipartFile attachment;

    @NativeQueryResultColumn(index = 8 )
    private String documentId;

    @NativeQueryResultColumn(index = 10)
    private Long lkPOUId;

    private String userId;

    private double uploadedFileSize;

    @NativeQueryResultColumn(index = 9)
    private String userName;

    @NativeQueryResultColumn(index = 11)
    private Date uploadedDate;

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Long getTrnId() {
        return trnId;
    }

    public void setTrnId(Long trnId) {
        this.trnId = trnId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getAttachmentTypeId() {
        return attachmentTypeId;
    }

    public void setAttachmentTypeId(Long attachmentTypeId) {
        this.attachmentTypeId = attachmentTypeId;
    }

   

    /**
	 * @return the attachmentTypeName
	 */
	public String getAttachmentTypeName() {
		return attachmentTypeName;
	}

	/**
	 * @param attachmentTypeName the attachmentTypeName to set
	 */
	public void setAttachmentTypeName(String attachmentTypeName) {
		this.attachmentTypeName = attachmentTypeName;
	}

	public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadedFileName() {
        return uploadedFileName;
    }

    public void setUploadedFileName(String uploadedFileName) {
        this.uploadedFileName = uploadedFileName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getUploadDirectoryPath() {
        return uploadDirectoryPath;
    }

    public void setUploadDirectoryPath(String uploadDirectoryPath) {
        this.uploadDirectoryPath = uploadDirectoryPath;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Long getLkPOUId() {
        return lkPOUId;
    }

    public void setLkPOUId(Long lkPOUId) {
        this.lkPOUId = lkPOUId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getUploadedFileSize() {
        return uploadedFileSize;
    }

    public void setUploadedFileSize(double uploadedFileSize) {
        this.uploadedFileSize = uploadedFileSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }
}


