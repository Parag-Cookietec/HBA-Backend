package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * The Class EDPOfficeAttachmentDto.
 * 
 * @version 1.0
 * @created 2019/08/29 17:22:45
 *
 */
public class EDPOfficeAttachmentDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ofc attactment id. */
	private long ofcAttactmentId;

	/** The office id. */
	@Min(1)
	private long officeId;

	/** The attachment id. */
	@Min(1)
	private long attachmentId;

	/** The version id. */
	private int versionId;

	/** The file name. */
	@NotNull
	@Size(max = 200)
	private String fileName = StringUtils.EMPTY;

	/** The path upload file. */
	@NotNull
	@Size(max = 500)
	private String pathUploadFile;

	/** The uploaded file name. */
	@NotNull
	@Size(max = 200)
	private String uploadedFileName;

	/** The uploaded by. */
	private long uploadedBy;

	/** The uploaded by name. */
	private String uploadedByName;

	/** The role perm id. */
	private long rolePermId;

	/** The attachment name. */
	private String attachmentName;

	/** The uploaded file size. */
	private double uploadedFileSize;

	/** The file. */
	@NotNull
	private transient MultipartFile file = null;
	
	/** The is common. */
	private boolean isCommon;

	/** The officeTrnId */
	private Long officeTrnId;

	/**
	 * Gets the ofc attactment id.
	 *
	 * @return the ofcAttactmentId
	 */
	public long getOfcAttactmentId() {
		return ofcAttactmentId;
	}

	/**
	 * Sets the ofc attactment id.
	 *
	 * @param ofcAttactmentId the ofcAttactmentId to set
	 */
	public void setOfcAttactmentId(long ofcAttactmentId) {
		this.ofcAttactmentId = ofcAttactmentId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
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
	 * Gets the path upload file.
	 *
	 * @return the pathUploadFile
	 */
	public String getPathUploadFile() {
		return pathUploadFile;
	}

	/**
	 * Sets the path upload file.
	 *
	 * @param pathUploadFile the pathUploadFile to set
	 */
	public void setPathUploadFile(String pathUploadFile) {
		this.pathUploadFile = pathUploadFile;
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
	 * Gets the role perm id.
	 *
	 * @return the rolePermId
	 */
	public long getRolePermId() {
		return rolePermId;
	}

	/**
	 * Sets the role perm id.
	 *
	 * @param rolePermId the rolePermId to set
	 */
	public void setRolePermId(long rolePermId) {
		this.rolePermId = rolePermId;
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
	 * Checks if is common.
	 *
	 * @return the isCommon
	 */
	public boolean isCommon() {
		return isCommon;
	}

	/**
	 * Sets the common.
	 *
	 * @param isCommon the isCommon to set
	 */
	public void setCommon(boolean isCommon) {
		this.isCommon = isCommon;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, attachmentName, fileName, ofcAttactmentId, officeId, pathUploadFile,
				rolePermId, uploadedBy, uploadedByName, uploadedFileName, uploadedFileSize, versionId);
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
		if (!(obj instanceof EDPOfficeAttachmentDto)) {
			return false;
		}
		EDPOfficeAttachmentDto other = (EDPOfficeAttachmentDto) obj;
		return attachmentId == other.attachmentId && Objects.equals(attachmentName, other.attachmentName)
				&& Objects.equals(fileName, other.fileName) && ofcAttactmentId == other.ofcAttactmentId
				&& officeId == other.officeId && Objects.equals(pathUploadFile, other.pathUploadFile)
				&& rolePermId == other.rolePermId && uploadedBy == other.uploadedBy
				&& Objects.equals(uploadedByName, other.uploadedByName)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Double.doubleToLongBits(uploadedFileSize) == Double.doubleToLongBits(other.uploadedFileSize)
				&& versionId == other.versionId;
	}

	/**
	 * @return the officeTrnId
	 */
	public Long getOfficeTrnId() {
		return officeTrnId;
	}

	/**
	 * @param officeTrnId the officeTrnId to set
	 */
	public void setOfficeTrnId(Long officeTrnId) {
		this.officeTrnId = officeTrnId;
	}

}
