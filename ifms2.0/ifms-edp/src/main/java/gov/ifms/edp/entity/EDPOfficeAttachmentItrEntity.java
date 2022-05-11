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
 * The Class EDPOfficeAttachmentItrEntity.
 */
@Entity
@Table(name = "T_EDP_OFF_ATTACH_ITR", schema = Constant.EDP_SCHEMA)
public class EDPOfficeAttachmentItrEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ofc attactment itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EDP_OFF_ATT_ITR_ID")
	private long ofcAttactmentItrId;

	/** The ofc attactment id. */
	@Column(name = "T_EDP_OFF_ATTACH_ID")
	private long ofcAttactmentId;

	/** The office id. */
	@Column(name = "OFFICE_ID")
	private long officeId;

	/** The attachment id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ATTACHMENT_ID", nullable = false)
	private EDPMsAttachmentEntity attachmentId;

	/** The version id. */
	@Column(name = "VERSION_ID")
	private int versionId;

	/** The file name. */
	@Column(name = "FILE_NAME")
	private String fileName;

	/** The path upload file. */
	@Column(name = "UPLOADED_FILE_PATH")
	private String pathUploadFile;

	/** The uploaded file name. */
	@Column(name = "UPLOADED_FILE_NAME")
	private String uploadedFileName;

	/** The uploaded by. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UPLOADED_BY", referencedColumnName = "USER_ID", nullable = false)
	private EDPMsUserEntity uploadedBy;

	/** The role perm id. */
	@Column(name = "ROLE_PRM_ID")
	private Long rolePermId;

	/** The file. */
	private transient MultipartFile file;

	/** The uploaded file size. */
	@Column(name = "UPLOADED_FILE_SIZE")
	private Double uploadedFileSize;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_EDP_UPD_OFF_TRN_ID", referencedColumnName = "T_EDP_UPD_OFF_TRN_ID")
	private EDPUpdateOfficeTrnEntity officeTrnEntity;

	/**
	 * Gets the ofc attactment itr id.
	 *
	 * @return the ofcAttactmentItrId
	 */
	public long getOfcAttactmentItrId() {
		return ofcAttactmentItrId;
	}

	/**
	 * Sets the ofc attactment itr id.
	 *
	 * @param ofcAttactmentItrId the ofcAttactmentItrId to set
	 */
	public void setOfcAttactmentItrId(long ofcAttactmentItrId) {
		this.ofcAttactmentItrId = ofcAttactmentItrId;
	}

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
	 * Gets the role perm id.
	 *
	 * @return the rolePermId
	 */
	public Long getRolePermId() {
		return rolePermId;
	}

	/**
	 * Sets the role perm id.
	 *
	 * @param rolePermId the rolePermId to set
	 */
	public void setRolePermId(Long rolePermId) {
		this.rolePermId = rolePermId;
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
	 * Gets the uploaded file size.
	 *
	 * @return the uploadedFileSize
	 */
	public Double getUploadedFileSize() {
		return uploadedFileSize;
	}

	/**
	 * Sets the uploaded file size.
	 *
	 * @param uploadedFileSize the uploadedFileSize to set
	 */
	public void setUploadedFileSize(Double uploadedFileSize) {
		this.uploadedFileSize = uploadedFileSize;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, fileName, ofcAttactmentId, ofcAttactmentItrId, officeId, pathUploadFile,
				rolePermId, uploadedBy, uploadedFileName, uploadedFileSize, versionId);
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
		if (!(obj instanceof EDPOfficeAttachmentItrEntity)) {
			return false;
		}
		EDPOfficeAttachmentItrEntity other = (EDPOfficeAttachmentItrEntity) obj;
		return Objects.equals(attachmentId, other.attachmentId) && Objects.equals(fileName, other.fileName)
				&& ofcAttactmentId == other.ofcAttactmentId && ofcAttactmentItrId == other.ofcAttactmentItrId
				&& officeId == other.officeId && Objects.equals(pathUploadFile, other.pathUploadFile)
				&& Objects.equals(rolePermId, other.rolePermId) && Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFileSize, other.uploadedFileSize) && versionId == other.versionId;
	}

	/**
	 * @return the officeTrnEntity
	 */
	public EDPUpdateOfficeTrnEntity getOfficeTrnEntity() {
		return officeTrnEntity;
	}

	/**
	 * @param officeTrnEntity the officeTrnEntity to set
	 */
	public void setOfficeTrnEntity(EDPUpdateOfficeTrnEntity officeTrnEntity) {
		this.officeTrnEntity = officeTrnEntity;
	}

}
