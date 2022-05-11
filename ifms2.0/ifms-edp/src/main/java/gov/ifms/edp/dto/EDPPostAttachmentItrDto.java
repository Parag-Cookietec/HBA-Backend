package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPPostAttachmentItrDto.
 * 
 * @version 1.0
 * @created 2019/12/20 17:42:52
 *
 */
public class EDPPostAttachmentItrDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post attactment itr id. */
	private Long postAttactmentItrId;

	/** The post attactment id. */
	private Long postAttactmentId;

	/** The attachment id. */
	private Long attachmentId;

	/** The version id. */
	private Long versionId;

	/** The file name. */
	private String fileName;

	/** The uploaded file path. */
	private String uploadedFilePath;

	/** The uploaded file name. */
	private String uploadedFileName;

	/** The uploaded file size. */
	private String uploadedFileSize;

	/** The work flow role id. */
	private Long workFlowRoleId;

	/** The work flow id. */
	private Long workFlowId;

	/**
	 * EDPPostAttachmentItrDto Constructor.
	 */
	public EDPPostAttachmentItrDto() {
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
				uploadedFileName, uploadedFileSize, workFlowRoleId, workFlowId);
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
		if (!(obj instanceof EDPPostAttachmentItrDto)) {
			return false;
		}

		EDPPostAttachmentItrDto other = (EDPPostAttachmentItrDto) obj;

		return Objects.equals(postAttactmentItrId, other.postAttactmentItrId)
				&& Objects.equals(postAttactmentId, other.postAttactmentId)
				&& Objects.equals(attachmentId, other.attachmentId) && Objects.equals(versionId, other.versionId)
				&& Objects.equals(fileName, other.fileName) && Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFileSize, other.uploadedFileSize)
				&& Objects.equals(workFlowRoleId, other.workFlowRoleId) && Objects.equals(workFlowId, other.workFlowId);
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
	 * getter setter.
	 *
	 * @return the post attactment itr id
	 */

	/**
	 * @return the postAttactmentItrId
	 */
	public Long getPostAttactmentItrId() {
		return postAttactmentItrId;
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
	 * Sets the post attactment itr id.
	 *
	 * @param postAttactmentItrId the postAttactmentItrId to set
	 */
	public void setPostAttactmentItrId(Long postAttactmentItrId) {
		this.postAttactmentItrId = postAttactmentItrId;
	}

	/**
	 * Sets the post attactment id.
	 *
	 * @param postAttactmentId the postAttactmentId to set
	 */
	public void setPostAttactmentId(Long postAttactmentId) {
		this.postAttactmentId = postAttactmentId;
	}

	/**
	 * Gets the post attactment id.
	 *
	 * @return the postAttactmentId
	 */
	public Long getPostAttactmentId() {
		return postAttactmentId;
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
	 * Gets the work flow id.
	 *
	 * @return the workFlowId
	 */
	public Long getWorkFlowId() {
		return workFlowId;
	}

	/**
	 * Sets the work flow id.
	 *
	 * @param workFlowId the workFlowId to set
	 */
	public void setWorkFlowId(Long workFlowId) {
		this.workFlowId = workFlowId;
	}

}
