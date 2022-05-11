package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

/**
 * The Class EDPAddDesAttachmentDto.
 */
public class EDPAddDesAttachmentDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The designation attach id. */
	private Long designationAttachId;

	/** The designation id. */
	private Long designationId;

	/** The attachment id. */
	private Long attachmentId;

	/** The attachment name. */
	private String attachmentName;

	/** The role prm id. */
	private Long rolePrmId;

	/** The workflow role id. */
	private Long workflowRoleId;

	/** The status id. */
	private Long statusId;

	/** The file name. */
	private String fileName;

	/** The uploaded file path. */
	private String uploadedFilePath;

	/** The uploaded file name. */
	private String uploadedFileName;

	/** The uploaded file size. */
	private double uploadedFileSize;

	/** The uploaded by id. */
	private Long uploadedById;

	/** The uploaded by name. */
	private String uploadedByName;

	/** The file. */
	private transient MultipartFile file;

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
	public Long getStatusId() {
		return statusId;
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
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
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
	 * Gets the attachment name.
	 *
	 * @return the attachmentName
	 */
	public String getAttachmentName() {
		return attachmentName;
	}

	/**
	 * Sets the attachment name.
	 *
	 * @param attachmentName the attachmentName to set
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	/**
	 * Gets the uploaded by id.
	 *
	 * @return the uploadedById
	 */
	public Long getUploadedById() {
		return uploadedById;
	}

	/**
	 * Sets the uploaded by id.
	 *
	 * @param uploadedById the uploadedById to set
	 */
	public void setUploadedById(Long uploadedById) {
		this.uploadedById = uploadedById;
	}

	/**
	 * Gets the uploaded by name.
	 *
	 * @return the uploadedByName
	 */
	public String getUploadedByName() {
		return uploadedByName;
	}

	/**
	 * Sets the uploaded by name.
	 *
	 * @param uploadedByName the uploadedByName to set
	 */
	public void setUploadedByName(String uploadedByName) {
		this.uploadedByName = uploadedByName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, designationAttachId, designationId, fileName, rolePrmId, statusId,
				uploadedFileName, uploadedFilePath, uploadedFileSize, workflowRoleId);
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
		if (!(obj instanceof EDPAddDesAttachmentDto)) {
			return false;
		}
		EDPAddDesAttachmentDto other = (EDPAddDesAttachmentDto) obj;
		return Objects.equals(attachmentId, other.attachmentId) && designationAttachId == other.designationAttachId
				&& Objects.equals(designationId, other.designationId) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(rolePrmId, other.rolePrmId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Double.doubleToLongBits(uploadedFileSize) == Double.doubleToLongBits(other.uploadedFileSize)
				&& Objects.equals(workflowRoleId, other.workflowRoleId);
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

}
