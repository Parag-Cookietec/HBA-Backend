package gov.ifms.common.attachment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


/**
 * The Class AttachmentDto.
 *
 * @version 1.0
 * @created 2019/12/07 10:20:29
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentMasterDto implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Long lkMenuAttTypId;

    @NotNull
    private Long menuId;

    private MsAttachmentDto attTypeId;

    private Long attCtegryId;

    private String fileName;

    @NotNull
    private Long transactionId;

    @NotNull
    private String format;

    @NotNull
    private Integer fileSize;

    @NotNull
    private String uploadDirectoryPath;

    @NotNull
    private transient List<MultipartFile> attachment;

    // upatedRecord = 1, newRecord = 2 , RecordDelete =3
    private long changeType;

    /**
     * @return the changeType
     */
    public long getChangeType() {
        return changeType;
    }

    /**
     * @param changeType the changeType to set
     */
    public void setChangeType(long changeType) {
        this.changeType = changeType;
    }

    /**
     * DOIAttachmentMasterDto Constructor
     */
    public AttachmentMasterDto() {
        super();
    }


    public AttachmentMasterDto(Long lkMenuAttTypId, Long menuId, Long attCtegryId, String format,
                               Integer fileSize, String uploadDirectoryPath, List<MultipartFile> attachment) {
        super();
        this.lkMenuAttTypId = lkMenuAttTypId;
        this.menuId = menuId;
        this.attCtegryId = attCtegryId;
        this.format = format;
        this.fileSize = fileSize;
        this.uploadDirectoryPath = uploadDirectoryPath;
        this.attachment = attachment;
    }

    public AttachmentMasterDto(Long menuId, Long attCtegryId, String format,
                               Integer fileSize, String uploadDirectoryPath, Long transactionId, String fileName, List<MultipartFile> attachment) {
        super();
        this.menuId = menuId;
        this.attCtegryId = attCtegryId;
        this.format = format;
        this.fileSize = fileSize;
        this.uploadDirectoryPath = uploadDirectoryPath;
        this.transactionId = transactionId;
        this.fileName = fileName;
        this.attachment = attachment;
    }


    public Long getLkMenuAttTypId() {
        return lkMenuAttTypId;
    }

    public void setLkMenuAttTypId(Long lkMenuAttTypId) {
        this.lkMenuAttTypId = lkMenuAttTypId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public MsAttachmentDto getAttTypeId() {
        return attTypeId;
    }

    public void setAttTypeId(MsAttachmentDto attTypeId) {
        this.attTypeId = attTypeId;
    }

    public Long getAttCtegryId() {
        return attCtegryId;
    }

    public void setAttCtegryId(Long attCtegryId) {
        this.attCtegryId = attCtegryId;
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

    public String getUploadDirectoryPath() {
        return uploadDirectoryPath;
    }

    public void setUploadDirectoryPath(String uploadDirectoryPath) {
        this.uploadDirectoryPath = uploadDirectoryPath;
    }

    public List<MultipartFile> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<MultipartFile> attachment) {
        this.attachment = attachment;
    }


    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttachmentMasterDto that = (AttachmentMasterDto) o;
        return Objects.equals(getLkMenuAttTypId(), that.getLkMenuAttTypId()) &&
                Objects.equals(getMenuId(), that.getMenuId()) &&
                Objects.equals(getAttTypeId(), that.getAttTypeId()) &&
                Objects.equals(getAttCtegryId(), that.getAttCtegryId()) &&
                Objects.equals(getFileName(), that.getFileName()) &&
                Objects.equals(getTransactionId(), that.getTransactionId()) &&
                Objects.equals(getFormat(), that.getFormat()) &&
                Objects.equals(getFileSize(), that.getFileSize()) &&
                Objects.equals(getUploadDirectoryPath(), that.getUploadDirectoryPath()) &&
                Objects.equals(getAttachment(), that.getAttachment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLkMenuAttTypId(), getMenuId(), getAttTypeId(), getAttCtegryId(), fileName, getTransactionId(), getFormat(), getFileSize(), getUploadDirectoryPath(), getAttachment());
    }

    @Override
    public String toString() {
        return "AttachmentMasterDto{" + "lkMenuAttTypId=" + lkMenuAttTypId +
                ", menuId=" + menuId +
                ", attTypeId=" + attTypeId +
                ", attCtegryId=" + attCtegryId +
                ", fileName='" + fileName + '\'' +
                ", transactionId=" + transactionId +
                ", format='" + format + '\'' +
                ", fileSize=" + fileSize +
                ", uploadDirectoryPath='" + uploadDirectoryPath + '\'' +
                ", attachment=" + attachment +
                '}';
    }
}
