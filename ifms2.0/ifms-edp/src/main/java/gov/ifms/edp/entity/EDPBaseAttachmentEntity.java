package gov.ifms.edp.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract  class EDPBaseAttachmentEntity extends BaseEntity {

	 /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    public abstract Long getId();
 
    @Column(name = "ATTACHMENT_ID")
    private Long attachmentTypeId;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "UPLOADED_FILE_PATH")
    private String uploadFilePath;

    @Column(name = "UPLOADED_FILE_NAME")
    private String uploadFileName;

    @Column(name = "UPLOADED_FILE_SIZE")
    private double uploadFileSize;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
    private EDPLuLookUpInfoEntity status;

    /** The uploaded by. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UPLOADED_BY", referencedColumnName = "USER_ID", nullable = false)
    private EDPMsUserEntity uploadedBy;
    
    @Column(name = "ACTION_ID")
    private Long actionId;

    public Long getAttachmentTypeId() {
        return attachmentTypeId;
    }

    public void setAttachmentTypeId(Long attachmentTypeId) {
        this.attachmentTypeId = attachmentTypeId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public double getUploadFileSize() {
        return uploadFileSize;
    }

    public void setUploadFileSize(double uploadFileSize) {
        this.uploadFileSize = uploadFileSize;
    }

    public EDPLuLookUpInfoEntity getStatus() {
        return status;
    }

    public void setStatus(EDPLuLookUpInfoEntity status) {
        this.status = status;
    }

    public EDPMsUserEntity getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(EDPMsUserEntity uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

	/**
	 * @return the actionId
	 */
	public Long getActionId() {
		return actionId;
	}

	/**
	 * Sets the action id.
	 *
	 * @param actionId the actionId to set
	 */
	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}
}
