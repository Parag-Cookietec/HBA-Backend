package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;


/**
 * The Class PVUForgoAttachmentDto.
 * 
 * @version v 1.0
 * @created 2020/01/13 11:47:13
 *
 */
public class PVUForgoAttachmentDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The attachment id. */
	private long attachmentId;

	/** The event id. */
	private long eventId;

	/** The attach id. */
	private long attachId;

	/** The version id. */
	private int versionId;

	/** The file name. */
	private String fileName;

	/** The uploaded file path. */
	private String uploadedFilePath;

	/** The uploaded file name. */
	private String uploadedFileName;

	/** The file size. */
	private long fileSize;

	/** The uploaded by. */
	private long uploadedBy;

	/** The role id. */
	private long roleId;

	/**
	 * PVUForgoAttachmentDto Constructor.
	 */
	public PVUForgoAttachmentDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, attachmentId, eventId, attachId, versionId, fileName, uploadedFilePath,
				uploadedFileName, fileSize, uploadedBy, roleId);
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
		if (!(obj instanceof PVUForgoAttachmentDto)) {
			return false;
		}

		PVUForgoAttachmentDto other = (PVUForgoAttachmentDto) obj;

		return Objects.equals(attachmentId, other.attachmentId) && attachmentId == other.attachmentId
				&& eventId == other.eventId && attachId == other.attachId && versionId == other.versionId
				&& Objects.equals(fileName, other.fileName) && Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Objects.equals(uploadedFileName, other.uploadedFileName) && fileSize == other.fileSize
				&& uploadedBy == other.uploadedBy && roleId == other.roleId;
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUForgoAttachmentDto [attachmentId = " + attachmentId + ",attachmentId = " + attachmentId
				+ ",eventId = " + eventId + ",attachId = " + attachId + ",versionId = " + versionId + ",fileName = "
				+ fileName + ",uploadedFilePath = " + uploadedFilePath + ",uploadedFileName = " + uploadedFileName
				+ ",fileSize = " + fileSize + ",uploadedBy = " + uploadedBy + ",roleId = " + roleId + ",]";
	}

	/**
	 * getter setter.
	 *
	 * @return the attachment id
	 */

	/**
	 * @return the attachmentId
	 */
	public long getAttachmentId() {
		return attachmentId;
	}

	/**
	 * Sets the attachment id.
	 *
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * Gets the event id.
	 *
	 * @return the eventId
	 */
	public long getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the eventId to set
	 */
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the attach id.
	 *
	 * @return the attachId
	 */
	public long getAttachId() {
		return attachId;
	}

	/**
	 * Sets the attach id.
	 *
	 * @param attachId the attachId to set
	 */
	public void setAttachId(long attachId) {
		this.attachId = attachId;
	}

	/**
	 * Gets the version id.
	 *
	 * @return the versionId
	 */
	public int getVersionId() {
		return versionId;
	}

	/**
	 * Sets the version id.
	 *
	 * @param versionId the versionId to set
	 */
	public void setVersionId(int versionId) {
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
	 * Gets the file size.
	 *
	 * @return the fileSize
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * Sets the file size.
	 *
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * Gets the uploaded by.
	 *
	 * @return the uploadedBy
	 */
	public long getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * Sets the uploaded by.
	 *
	 * @param uploadedBy the uploadedBy to set
	 */
	public void setUploadedBy(long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the roleId
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the roleId to set
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

}
