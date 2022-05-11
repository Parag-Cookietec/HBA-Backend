package gov.ifms.pvu.common;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;

/**
 * The Class BasePVUAttachmentEntity.
 */
@MappedSuperclass
public abstract class BasePVUAttachmentEntity extends BaseEntity {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public abstract Long getId();

    /** The attachment type id. */
    @Column(name = "ATTACHMENT_ID")
    private Long attachmentTypeId;

    /** The version id. */
    @Column(name = "VERSION_ID")
    private Integer versionId;

    /** The file name. */
    @Column(name = "FILE_NAME")
    private String fileName;

    /** The upload file path. */
    @Column(name = "UPLOADED_FILE_PATH")
    private String uploadFilePath;

    /** The upload file name. */
    @Column(name = "UPLOADED_FILE_NAME")
    private String uploadFileName;

    /** The upload file size. */
    @Column(name = "UPLOADED_FILE_SIZE")
    private double uploadFileSize;

    /** The role prm id. */
    @Column(name = "ROLE_PRM_ID")
    private Long rolePrmId;

    /** The document id. */
    @Column(name = "DOCUMENT_ID")
    private String documentId;

    /** The status. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
    private EDPLuLookUpInfoEntity status;

    /** The uploaded by. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UPLOADED_BY", referencedColumnName = "USER_ID", nullable = false)
    private EDPMsUserEntity uploadedBy;

    
	/** The edp lk po off user id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POU_ID", referencedColumnName = "LK_PO_OFF_USER_ID")
	private EDPLkPoOffUserEntity edpLkPoOffUserId;
    
    /**
     * Gets the attachment type id.
     *
     * @return the attachment type id
     */
    public Long getAttachmentTypeId() {
        return attachmentTypeId;
    }

    /**
     * Sets the attachment type id.
     *
     * @param attachmentTypeId the new attachment type id
     */
    public void setAttachmentTypeId(Long attachmentTypeId) {
        this.attachmentTypeId = attachmentTypeId;
    }

    /**
     * Gets the version id.
     *
     * @return the version id
     */
    public Integer getVersionId() {
        return versionId;
    }

    /**
     * Sets the version id.
     *
     * @param versionId the new version id
     */
    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
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
     * Gets the upload file path.
     *
     * @return the upload file path
     */
    public String getUploadFilePath() {
        return uploadFilePath;
    }

    /**
     * Sets the upload file path.
     *
     * @param uploadFilePath the new upload file path
     */
    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }

    /**
     * Gets the upload file name.
     *
     * @return the upload file name
     */
    public String getUploadFileName() {
        return uploadFileName;
    }

    /**
     * Sets the upload file name.
     *
     * @param uploadFileName the new upload file name
     */
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    /**
     * Gets the upload file size.
     *
     * @return the upload file size
     */
    public double getUploadFileSize() {
        return uploadFileSize;
    }

    /**
     * Sets the upload file size.
     *
     * @param uploadFileSize the new upload file size
     */
    public void setUploadFileSize(double uploadFileSize) {
        this.uploadFileSize = uploadFileSize;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public EDPLuLookUpInfoEntity getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(EDPLuLookUpInfoEntity status) {
        this.status = status;
    }

    /**
     * Gets the role prm id.
     *
     * @return the role prm id
     */
    public Long getRolePrmId() {
        return rolePrmId;
    }

    /**
     * Sets the role prm id.
     *
     * @param rolePrmId the new role prm id
     */
    public void setRolePrmId(Long rolePrmId) {
        this.rolePrmId = rolePrmId;
    }

    /**
     * Gets the uploaded by.
     *
     * @return the uploaded by
     */
    public EDPMsUserEntity getUploadedBy() {
        return uploadedBy;
    }

    /**
     * Sets the uploaded by.
     *
     * @param uploadedBy the new uploaded by
     */
    public void setUploadedBy(EDPMsUserEntity uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    /**
     * Gets the document id.
     *
     * @return the document id
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the document id.
     *
     * @param documentId the new document id
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    
    /**
	 * Gets the edp lk po off user id.
	 *
	 * @return the edp lk po off user id
	 */
	public EDPLkPoOffUserEntity getEdpLkPoOffUserId() {
		return edpLkPoOffUserId;
	}

	/**
	 * Sets the edp lk po off user id.
	 *
	 * @param edpLkPoOffUserId the new edp lk po off user id
	 */
	public void setEdpLkPoOffUserId(EDPLkPoOffUserEntity edpLkPoOffUserId) {
		this.edpLkPoOffUserId = edpLkPoOffUserId;
	}
}
