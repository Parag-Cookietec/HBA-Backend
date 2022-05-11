package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPUsrPoTrnsAttItrDto.
 */
public class EDPUsrPoTrnsAttItrDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp usr po tran att id. */
	private Long edpUsrPoTranAttId;

	/** The edp usr po trns header id. */
	private Long edpUsrPoTrnsHeaderId;

	/** The attachment id. */
	private Long attachmentId;

	/** The file name. */
	private String fileName;

	/** The uploaded file path. */
	private String uploadedFilePath;

	/** The uploaded file name. */
	private String uploadedFileName;

	/** The uploaded file size. */
	private Long uploadedFileSize;

	/** The uploaded by. */
	private Long uploadedBy;

	/** The role prm ID. */
	private Long rolePrmID;

	/** The wf role id. */
	private Long wfRoleId;

	/** The status id. */
	private Long statusId;

	/**
	 * EDPUsrPoTrnsAttDto Constructor.
	 */
	public EDPUsrPoTrnsAttItrDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpUsrPoTranAttId, edpUsrPoTrnsHeaderId, attachmentId, fileName, uploadedFilePath,
				uploadedFileName, uploadedFileSize, uploadedBy, rolePrmID, wfRoleId, statusId);
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
		if (!(obj instanceof EDPUsrPoTrnsAttItrDto)) {
			return false;
		}

		EDPUsrPoTrnsAttItrDto other = (EDPUsrPoTrnsAttItrDto) obj;

		return Objects.equals(edpUsrPoTranAttId, other.edpUsrPoTranAttId)
				&& Objects.equals(edpUsrPoTrnsHeaderId, other.edpUsrPoTrnsHeaderId)
				&& Objects.equals(attachmentId, other.attachmentId) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFileSize, other.uploadedFileSize)
				&& Objects.equals(uploadedBy, other.uploadedBy) && Objects.equals(rolePrmID, other.rolePrmID)
				&& Objects.equals(wfRoleId, other.wfRoleId) && Objects.equals(statusId, other.statusId);
	}

	/**
	 * getter setter.
	 *
	 * @return the edp usr po tran att id
	 */

	/**
	 * @return the edpUsrPoTranAttId
	 */
	public Long getEdpUsrPoTranAttId() {
		return edpUsrPoTranAttId;
	}

	/**
	 * Sets the edp usr po tran att id.
	 *
	 * @param edpUsrPoTranAttId the edpUsrPoTranAttId to set
	 */
	public void setEdpUsrPoTranAttId(Long edpUsrPoTranAttId) {
		this.edpUsrPoTranAttId = edpUsrPoTranAttId;
	}

	/**
	 * Gets the edp usr po trns header id.
	 *
	 * @return the edpUsrPoTrnsHeaderId
	 */
	public Long getEdpUsrPoTrnsHeaderId() {
		return edpUsrPoTrnsHeaderId;
	}

	/**
	 * Sets the edp usr po trns header id.
	 *
	 * @param edpUsrPoTrnsHeaderId the edpUsrPoTrnsHeaderId to set
	 */
	public void setEdpUsrPoTrnsHeaderId(Long edpUsrPoTrnsHeaderId) {
		this.edpUsrPoTrnsHeaderId = edpUsrPoTrnsHeaderId;
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
	 * Gets the uploaded file size.
	 *
	 * @return the uploadedFileSize
	 */
	public Long getUploadedFileSize() {
		return uploadedFileSize;
	}

	/**
	 * Sets the uploaded file size.
	 *
	 * @param uploadedFileSize the uploadedFileSize to set
	 */
	public void setUploadedFileSize(Long uploadedFileSize) {
		this.uploadedFileSize = uploadedFileSize;
	}

	/**
	 * Gets the uploaded by.
	 *
	 * @return the uploadedBy
	 */
	public Long getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * Sets the uploaded by.
	 *
	 * @param uploadedBy the uploadedBy to set
	 */
	public void setUploadedBy(Long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * Gets the role prm ID.
	 *
	 * @return the rolePrmID
	 */
	public Long getRolePrmID() {
		return rolePrmID;
	}

	/**
	 * Sets the role prm ID.
	 *
	 * @param rolePrmID the rolePrmID to set
	 */
	public void setRolePrmID(Long rolePrmID) {
		this.rolePrmID = rolePrmID;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
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
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
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

}
