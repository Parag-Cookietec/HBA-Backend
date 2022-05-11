package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

/**
 * The Class EDPTrnUserMpAttDto.
 */
public class EDPTrnUserMpAttDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user rg mp attr id. */
	private long userRgMpAttrId;

	/** The user rg map id. */
	private long userRgMapId;

	/** The attachment id. */
	private long attachmentId;

	/** The version id. */
	private int versionId;

	/** The file name. */
	private String fileName;

	/** The upload file path. */
	private String uploadFilePath;

	/** The upload file name. */
	private String uploadFileName;

	/** The uploaded by. */
	private long uploadedBy;

	/** The role prm ID. */
	private long rolePrmID;

	/** The upload file size. */
	private double uploadFileSize;

	/** The status id. */
	private long statusId;

	/** The wf id. */
	private long wfId;

	/** The user code. */
	private long userCode;
	
	/** The file. */
	private transient MultipartFile file = null;
	
	/** The uploaded by name. */
	private String uploadedByName;
	
	/** The attachment name. */
	private String attachmentName;
	
	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getUploadedByName() {
		return uploadedByName;
	}

	public void setUploadedByName(String uploadedByName) {
		this.uploadedByName = uploadedByName;
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
	 * @param file the new file
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * Gets the user rg mp attr id.
	 *
	 * @return the userRgMpAttrId
	 */
	public long getUserRgMpAttrId() {
		return userRgMpAttrId;
	}

	/**
	 * Sets the user rg mp attr id.
	 *
	 * @param userRgMpAttrId the userRgMpAttrId to set
	 */
	public void setUserRgMpAttrId(long userRgMpAttrId) {
		this.userRgMpAttrId = userRgMpAttrId;
	}

	/**
	 * Gets the user rg map id.
	 *
	 * @return the userRgMapId
	 */
	public long getUserRgMapId() {
		return userRgMapId;
	}

	/**
	 * Sets the user rg map id.
	 *
	 * @param userRgMapId the userRgMapId to set
	 */
	public void setUserRgMapId(long userRgMapId) {
		this.userRgMapId = userRgMapId;
	}

	/**
	 * Gets the attachment id.
	 *
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
	 * Gets the upload file path.
	 *
	 * @return the uploadFilePath
	 */
	public String getUploadFilePath() {
		return uploadFilePath;
	}

	/**
	 * Sets the upload file path.
	 *
	 * @param uploadFilePath the uploadFilePath to set
	 */
	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	/**
	 * Gets the upload file name.
	 *
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * Sets the upload file name.
	 *
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
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
	 * Gets the role prm ID.
	 *
	 * @return the rolePrmID
	 */
	public long getRolePrmID() {
		return rolePrmID;
	}

	/**
	 * Sets the role prm ID.
	 *
	 * @param rolePrmID the rolePrmID to set
	 */
	public void setRolePrmID(long rolePrmID) {
		this.rolePrmID = rolePrmID;
	}

	/**
	 * Gets the upload file size.
	 *
	 * @return the uploadFileSize
	 */
	public double getUploadFileSize() {
		return uploadFileSize;
	}

	/**
	 * Sets the upload file size.
	 *
	 * @param uploadFileSize the uploadFileSize to set
	 */
	public void setUploadFileSize(double uploadFileSize) {
		this.uploadFileSize = uploadFileSize;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the user code.
	 *
	 * @return the userCode
	 */
	public long getUserCode() {
		return userCode;
	}

	/**
	 * Sets the user code.
	 *
	 * @param userCode the userCode to set
	 */
	public void setUserCode(long userCode) {
		this.userCode = userCode;
	}

	/**
	 * Instantiates a new EDP trn user mp att dto.
	 */
	public EDPTrnUserMpAttDto() {
		super();
	}

	

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(attachmentId, attachmentName, fileName, rolePrmID, statusId,
				uploadFileName, uploadFilePath, uploadFileSize, uploadedBy, uploadedByName, userCode, userRgMapId,
				userRgMpAttrId, versionId, wfId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPTrnUserMpAttDto)) {
			return false;
		}
		EDPTrnUserMpAttDto other = (EDPTrnUserMpAttDto) obj;
		return attachmentId == other.attachmentId && Objects.equals(attachmentName, other.attachmentName)
				&& Objects.equals(fileName, other.fileName) && rolePrmID == other.rolePrmID
				&& statusId == other.statusId && Objects.equals(uploadFileName, other.uploadFileName)
				&& Objects.equals(uploadFilePath, other.uploadFilePath)
				&& Double.doubleToLongBits(uploadFileSize) == Double.doubleToLongBits(other.uploadFileSize)
				&& uploadedBy == other.uploadedBy && Objects.equals(uploadedByName, other.uploadedByName)
				&& userCode == other.userCode && userRgMapId == other.userRgMapId
				&& userRgMpAttrId == other.userRgMpAttrId && versionId == other.versionId && wfId == other.wfId;
	}

	/**
	 * Gets the uploaded by.
	 *
	 * @return the uploaded by
	 */
	public long getUploadedBy() {
		return uploadedBy;
	}

}
