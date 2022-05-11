package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

/**
 * The Class EDPUsrPoTrnsAttDto.
 * 
 * @version 1.0
 * @created 2020/01/02 14:43:21
 *
 */
public class EDPUsrPoTrnsAttDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The edp usr po tran att itr id. */
	private Long edpUsrPoTranAttItrId;

	/** The edp usr po tran att id. */
	private Long edpUsrPoTranAttId;

	/** The edp usr po trns headr id. */
	private Long edpUsrPoTrnsHeadrId;

	/** The attachment id. */
	private Long attachmentId;

	/** The attachment name. */
	private String attachmentName;

	/** The file name. */
	private String fileName;

	/** The uploaded file path. */
	private String uploadedFilePath;

	/** The uploaded file name. */
	private String uploadedFileName;

	/** The uploaded file size. */
	private double uploadedFileSize;

	/** The uploaded by. */
	private Long uploadedBy;

	/** The uploaded by name. */
	private String uploadedByName;

	/** The role prm ID. */
	private Long rolePrmID;

	/** The wf role id. */
	private Long wfRoleId;

	/** The status id. */
	private Long statusId;

	/** The file. */
	private transient MultipartFile file;

	/**
	 * EDPUsrPoTrnsAttDto Constructor.
	 */
	public EDPUsrPoTrnsAttDto() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, attachmentName, edpUsrPoTranAttId, edpUsrPoTranAttItrId, edpUsrPoTrnsHeadrId,
				fileName, rolePrmID, statusId, uploadedBy, uploadedByName, uploadedFileName, uploadedFilePath,
				uploadedFileSize, wfRoleId);
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
		if (!(obj instanceof EDPUsrPoTrnsAttDto)) {
			return false;
		}
		EDPUsrPoTrnsAttDto other = (EDPUsrPoTrnsAttDto) obj;
		return Objects.equals(attachmentId, other.attachmentId) && Objects.equals(attachmentName, other.attachmentName)
				&& Objects.equals(edpUsrPoTranAttId, other.edpUsrPoTranAttId)
				&& Objects.equals(edpUsrPoTranAttItrId, other.edpUsrPoTranAttItrId)
				&& Objects.equals(edpUsrPoTrnsHeadrId, other.edpUsrPoTrnsHeadrId)
				&& Objects.equals(fileName, other.fileName) && Objects.equals(rolePrmID, other.rolePrmID)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(uploadedByName, other.uploadedByName)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Objects.equals(uploadedFileSize, other.uploadedFileSize) && Objects.equals(wfRoleId, other.wfRoleId);
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

	/**
	 * Gets the edp usr po tran att itr id.
	 *
	 * @return the edpUsrPoTranAttItrId
	 */
	public Long getEdpUsrPoTranAttItrId() {
		return edpUsrPoTranAttItrId;
	}

	/**
	 * Sets the edp usr po tran att itr id.
	 *
	 * @param edpUsrPoTranAttItrId the edpUsrPoTranAttItrId to set
	 */
	public void setEdpUsrPoTranAttItrId(Long edpUsrPoTranAttItrId) {
		this.edpUsrPoTranAttItrId = edpUsrPoTranAttItrId;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the edp usr po trns headr id.
	 *
	 * @return the edpUsrPoTrnsHeadrId
	 */
	public Long getEdpUsrPoTrnsHeadrId() {
		return edpUsrPoTrnsHeadrId;
	}

	/**
	 * Sets the edp usr po trns headr id.
	 *
	 * @param edpUsrPoTrnsHeadrId the edpUsrPoTrnsHeadrId to set
	 */
	public void setEdpUsrPoTrnsHeadrId(Long edpUsrPoTrnsHeadrId) {
		this.edpUsrPoTrnsHeadrId = edpUsrPoTrnsHeadrId;
	}

}
