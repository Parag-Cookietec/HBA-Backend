package gov.ifms.loc.dto;

import gov.ifms.edp.dto.BaseDto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class LocChqDtlAttachDto.
 *
 * @version v 1.0
 * @created 2021/01/12 15:21:32
 */
public class LocChequeBookAttachDto extends BaseDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    @NotNull
    private Long id;

    /**
     * The trn id.
     */
    @NotNull
    private Long trnId;

    /**
     * The attachment id.
     */
    private Long attachmentId;

    /**
     * The file name.
     */
    private String fileName;

    /**
     * The up file path.
     */
    private String upFilePath;

    /**
     * The up file name.
     */
    private String upFileName;

    /**
     * The up file size.
     */
    private Long upFileSize;

    /**
     * The uploaded by.
     */
    private Long uploadedBy;

    /**
     * The doc id.
     */
    private String docId;

    /**
     * The category.
     */
    private Long category;

    /**
     * The wf id.
     */
    private Long wfId;

    /**
     * The wf role id.
     */
    private Long wfRoleId;

    /**
     * The action id.
     */
    private Long actionId;

    /**
     * The status id.
     */
    private Long statusId;

    /**
     * LocChqDtlAttachDto Constructor.
     */
    public LocChequeBookAttachDto() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocChequeBookAttachDto)) return false;
        if (!super.equals(o)) return false;
        LocChequeBookAttachDto that = (LocChequeBookAttachDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTrnId(), that.getTrnId()) && Objects.equals(getAttachmentId(), that.getAttachmentId()) && Objects.equals(getFileName(), that.getFileName()) && Objects.equals(getUpFilePath(), that.getUpFilePath()) && Objects.equals(getUpFileName(), that.getUpFileName()) && Objects.equals(getUpFileSize(), that.getUpFileSize()) && Objects.equals(getUploadedBy(), that.getUploadedBy()) && Objects.equals(getDocId(), that.getDocId()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getWfId(), that.getWfId()) && Objects.equals(getWfRoleId(), that.getWfRoleId()) && Objects.equals(getActionId(), that.getActionId()) && Objects.equals(getStatusId(), that.getStatusId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getTrnId(), getAttachmentId(), getFileName(), getUpFilePath(), getUpFileName(), getUpFileSize(), getUploadedBy(), getDocId(), getCategory(), getWfId(), getWfRoleId(), getActionId(), getStatusId());
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the trn id.
     *
     * @return the trn id
     */
    public Long getTrnId() {
        return trnId;
    }

    /**
     * Sets the trn id.
     *
     * @param trnId the new trn id
     */
    public void setTrnId(Long trnId) {
        this.trnId = trnId;
    }

    /**
     * Gets the attachment id.
     *
     * @return the attachment id
     */
    public Long getAttachmentId() {
        return attachmentId;
    }

    /**
     * Sets the attachment id.
     *
     * @param attachmentId the new attachment id
     */
    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * Gets the file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name.
     *
     * @param fileName the new file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the up file path.
     *
     * @return the up file path
     */
    public String getUpFilePath() {
        return upFilePath;
    }

    /**
     * Sets the up file path.
     *
     * @param upFilePath the new up file path
     */
    public void setUpFilePath(String upFilePath) {
        this.upFilePath = upFilePath;
    }

    /**
     * Gets the up file name.
     *
     * @return the up file name
     */
    public String getUpFileName() {
        return upFileName;
    }

    /**
     * Sets the up file name.
     *
     * @param upFileName the new up file name
     */
    public void setUpFileName(String upFileName) {
        this.upFileName = upFileName;
    }

    /**
     * Gets the up file size.
     *
     * @return the up file size
     */
    public Long getUpFileSize() {
        return upFileSize;
    }

    /**
     * Sets the up file size.
     *
     * @param upFileSize the new up file size
     */
    public void setUpFileSize(Long upFileSize) {
        this.upFileSize = upFileSize;
    }

    /**
     * Gets the uploaded by.
     *
     * @return the uploaded by
     */
    public Long getUploadedBy() {
        return uploadedBy;
    }

    /**
     * Sets the uploaded by.
     *
     * @param uploadedBy the new uploaded by
     */
    public void setUploadedBy(Long uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    /**
     * Gets the doc id.
     *
     * @return the doc id
     */
    public String getDocId() {
        return docId;
    }

    /**
     * Sets the doc id.
     *
     * @param docId the new doc id
     */
    public void setDocId(String docId) {
        this.docId = docId;
    }

    /**
     * Gets the category.
     *
     * @return the category
     */
    public Long getCategory() {
        return category;
    }

    /**
     * Sets the category.
     *
     * @param category the new category
     */
    public void setCategory(Long category) {
        this.category = category;
    }

    /**
     * Gets the wf id.
     *
     * @return the wf id
     */
    public Long getWfId() {
        return wfId;
    }

    /**
     * Sets the wf id.
     *
     * @param wfId the new wf id
     */
    public void setWfId(Long wfId) {
        this.wfId = wfId;
    }

    /**
     * Gets the wf role id.
     *
     * @return the wf role id
     */
    public Long getWfRoleId() {
        return wfRoleId;
    }

    /**
     * Sets the wf role id.
     *
     * @param wfRoleId the new wf role id
     */
    public void setWfRoleId(Long wfRoleId) {
        this.wfRoleId = wfRoleId;
    }

    /**
     * Gets the action id.
     *
     * @return the action id
     */
    public Long getActionId() {
        return actionId;
    }

    /**
     * Sets the action id.
     *
     * @param actionId the new action id
     */
    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    /**
     * Gets the status id.
     *
     * @return the status id
     */
    public Long getStatusId() {
        return statusId;
    }

    /**
     * Sets the status id.
     *
     * @param statusId the new status id
     */
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

}
