package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPPostAttachmentItrEntity.
 * 
 * @version 1.0
 * @created 2019/12/20 17:42:52
 *
 */
@Entity
@Table(name = "T_EDP_PO_ATT_ITR", schema = Constant.EDP_SCHEMA)
public class EDPPostAttachmentItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post attactment itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EDP_PO_ATT_ITR_ID")
	private Long postAttactmentItrId;

	/** The post attactment id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_EDP_PO_ATT_ID", referencedColumnName = "T_EDP_PO_ATT_ID")
	private EDPPostAttachmentEntity postAttactmentId;

	/** The attachment id. */
	@Column(name = "ATTACHMENT_ID")
	private Long attachmentId;

	/** The version id. */
	@Column(name = "VERSION_ID")
	private Long versionId;

	/** The file name. */
	@Column(name = "FILE_NAME")
	private String fileName;

	/** The uploaded file path. */
	@Column(name = "UPLOADED_FILE_PATH")
	private String uploadedFilePath;

	/** The uploaded file name. */
	@Column(name = "UPLOADED_FILE_NAME")
	private String uploadedFileName;

	/** The uploaded file size. */
	@Column(name = "UPLOADED_FILE_SIZE")
	private String uploadedFileSize;

	/** The work flow role id. */
	@Column(name = "WF_ROLE_ID")
	private Long workFlowRoleId;
	
	
	/** The post id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "POST_ID", referencedColumnName = "POST_ID")
	private EDPMsPostEntity postId;

	/**
	 * EDPPostAttachmentItrDto Constructor.
	 */
	public EDPPostAttachmentItrEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(postAttactmentItrId, postAttactmentId, attachmentId, versionId, fileName, uploadedFilePath,
				uploadedFileName, uploadedFileSize, workFlowRoleId);
	}

	/**
	 * equals method.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPPostAttachmentItrEntity)) {
			return false;
		}

		EDPPostAttachmentItrEntity other = (EDPPostAttachmentItrEntity) obj;

		return Objects.equals(postAttactmentItrId, other.postAttactmentItrId)
				&& Objects.equals(postAttactmentId, other.postAttactmentId)
				&& Objects.equals(attachmentId, other.attachmentId) && Objects.equals(versionId, other.versionId)
				&& Objects.equals(fileName, other.fileName) && Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFileSize, other.uploadedFileSize)
				&& Objects.equals(workFlowRoleId, other.workFlowRoleId) ;
	}

	/**
	 * @return the postAttactmentItrId
	 */
	public Long getPostAttactmentItrId() {
		return postAttactmentItrId;
	}

	/**
	 * Sets the post attactment itr id.
	 *
	 * @param postAttactmentItrId the postAttactmentItrId to set
	 */
	public void setPostAttactmentItrId(Long postAttactmentItrId) {
		this.postAttactmentItrId = postAttactmentItrId;
	}

	/**
	 * Gets the post attactment id.
	 *
	 * @return the postAttactmentId
	 */
	public EDPPostAttachmentEntity getPostAttactmentId() {
		return postAttactmentId;
	}

	/**
	 * Sets the post attactment id.
	 *
	 * @param postAttactmentId the postAttactmentId to set
	 */
	public void setPostAttactmentId(EDPPostAttachmentEntity postAttactmentId) {
		this.postAttactmentId = postAttactmentId;
	}

	/**
	 * Gets the attachment id.
	 *
	 * @return the attachmentId
	 */
	public Long getAttachmentId() {
		return attachmentId;
	}

	/**
	 * Sets the attachment id.
	 *
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * Gets the version id.
	 *
	 * @return the versionId
	 */
	public Long getVersionId() {
		return versionId;
	}

	/**
	 * Sets the version id.
	 *
	 * @param versionId the versionId to set
	 */
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 *
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the uploaded file path.
	 *
	 * @return the uploadedFilePath
	 */
	public String getUploadedFilePath() {
		return uploadedFilePath;
	}

	/**
	 * Sets the uploaded file path.
	 *
	 * @param uploadedFilePath the uploadedFilePath to set
	 */
	public void setUploadedFilePath(String uploadedFilePath) {
		this.uploadedFilePath = uploadedFilePath;
	}

	/**
	 * Gets the uploaded file name.
	 *
	 * @return the uploadedFileName
	 */
	public String getUploadedFileName() {
		return uploadedFileName;
	}

	/**
	 * Sets the uploaded file name.
	 *
	 * @param uploadedFileName the uploadedFileName to set
	 */
	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}

	/**
	 * Gets the uploaded file size.
	 *
	 * @return the uploadedFileSize
	 */
	public String getUploadedFileSize() {
		return uploadedFileSize;
	}

	/**
	 * Sets the uploaded file size.
	 *
	 * @param uploadedFileSize the uploadedFileSize to set
	 */
	public void setUploadedFileSize(String uploadedFileSize) {
		this.uploadedFileSize = uploadedFileSize;
	}

	/**
	 * Gets the work flow role id.
	 *
	 * @return the workFlowRoleId
	 */
	public Long getWorkFlowRoleId() {
		return workFlowRoleId;
	}

	/**
	 * Sets the work flow role id.
	 *
	 * @param workFlowRoleId the workFlowRoleId to set
	 */
	public void setWorkFlowRoleId(Long workFlowRoleId) {
		this.workFlowRoleId = workFlowRoleId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public EDPMsPostEntity getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(EDPMsPostEntity postId) {
		this.postId = postId;
	}
	
	

}
