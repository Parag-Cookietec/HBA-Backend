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

import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPAddDesAttachmentItrEntity.
 */
@Entity
@Table(name = "TEDPADD_DSGN_ATT_ITR", schema = Constant.EDP_SCHEMA)
public class EDPAddDesAttachmentItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The designation attach itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDPADDSGN_ATTITR_ID")
	private long designationAttachItrId;

	/** The designation attach id. */
	@Column(name = "TEDP_ADD_DSGN_ATT_ID")
	private Long designationAttachId;

	/** The attachment id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ATTACHMENT_ID", nullable = false)
	private EDPMsAttachmentEntity attachmentId;

	/** The designation id. */
	@Column(name = "DESIGNATION_ID")
	private Long designationId;

	/** The role prm id. */
	@Column(name = "ROLE_PRM_ID")
	private Long rolePrmId;

	/** The workflow role id. */
	@Column(name = "WF_ROLE_ID")
	private Long workflowRoleId;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

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
	private double uploadedFileSize;

	/** The uploaded by. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UPLOADED_BY", referencedColumnName = "USER_ID", nullable = false)
	private EDPMsUserEntity uploadedBy;

	/** The file. */
	private transient MultipartFile file;

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, designationAttachId, designationAttachItrId, designationId, fileName,
				rolePrmId, statusId, uploadedBy, uploadedFileName, uploadedFilePath, uploadedFileSize, workflowRoleId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EDPAddDesAttachmentItrEntity)) {
			return false;
		}
		EDPAddDesAttachmentItrEntity other = (EDPAddDesAttachmentItrEntity) obj;
		return Objects.equals(attachmentId, other.attachmentId)
				&& Objects.equals(designationAttachId, other.designationAttachId)
				&& designationAttachItrId == other.designationAttachItrId
				&& Objects.equals(designationId, other.designationId) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(rolePrmId, other.rolePrmId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Double.doubleToLongBits(uploadedFileSize) == Double.doubleToLongBits(other.uploadedFileSize)
				&& Objects.equals(workflowRoleId, other.workflowRoleId);
	}

	/**
	 * Gets the designation attach itr id.
	 *
	 * @return the designationAttachItrId
	 */
	public long getDesignationAttachItrId() {
		return designationAttachItrId;
	}

	/**
	 * Sets the designation attach itr id.
	 *
	 * @param designationAttachItrId the designationAttachItrId to set
	 */
	public void setDesignationAttachItrId(long designationAttachItrId) {
		this.designationAttachItrId = designationAttachItrId;
	}

	/**
	 * Gets the designation attach id.
	 *
	 * @return the designationAttachId
	 */
	public Long getDesignationAttachId() {
		return designationAttachId;
	}

	/**
	 * Sets the designation attach id.
	 *
	 * @param designationAttachId the designationAttachId to set
	 */
	public void setDesignationAttachId(Long designationAttachId) {
		this.designationAttachId = designationAttachId;
	}

	/**
	 * Gets the attachment id.
	 *
	 * @return the attachmentId
	 */
	public EDPMsAttachmentEntity getAttachmentId() {
		return attachmentId;
	}

	/**
	 * Sets the attachment id.
	 *
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(EDPMsAttachmentEntity attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * Gets the role prm id.
	 *
	 * @return the rolePrmId
	 */
	public Long getRolePrmId() {
		return rolePrmId;
	}

	/**
	 * Sets the role prm id.
	 *
	 * @param rolePrmId the rolePrmId to set
	 */
	public void setRolePrmId(Long rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * Gets the workflow role id.
	 *
	 * @return the workflowRoleId
	 */
	public Long getWorkflowRoleId() {
		return workflowRoleId;
	}

	/**
	 * Sets the workflow role id.
	 *
	 * @param workflowRoleId the workflowRoleId to set
	 */
	public void setWorkflowRoleId(Long workflowRoleId) {
		this.workflowRoleId = workflowRoleId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
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
	public double getUploadedFileSize() {
		return uploadedFileSize;
	}

	/**
	 * Sets the uploaded file size.
	 *
	 * @param uploadedFileSize the uploadedFileSize to set
	 */
	public void setUploadedFileSize(double uploadedFileSize) {
		this.uploadedFileSize = uploadedFileSize;
	}

	/**
	 * Gets the uploaded by.
	 *
	 * @return the uploadedBy
	 */
	public EDPMsUserEntity getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * Sets the uploaded by.
	 *
	 * @param uploadedBy the uploadedBy to set
	 */
	public void setUploadedBy(EDPMsUserEntity uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * Sets the file.
	 *
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

}
