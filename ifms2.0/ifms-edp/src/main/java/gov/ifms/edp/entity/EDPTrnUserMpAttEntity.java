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
 * The Class EDPTrnUserMpAttEntity.
 */
@Entity
@Table(name = "T_USR_RG_MP_ATT", schema = Constant.EDP_SCHEMA)
public class EDPTrnUserMpAttEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user rg mp attr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_USR_RG_MP_ATT_ID")
	private long userRgMpAttrId;

	/** The user rg map id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_USR_RG_MAP_ID", referencedColumnName = "T_USR_RG_MAP_ID", nullable = false)
	private EDPtusrRgMapEntity userRgMapId;

	/** The attachment id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ATTACHMENT_ID")
	private EDPMsAttachmentEntity attachmentId;

	/** The version id. */
	@Column(name = "VERSION_ID")
	private int versionId;

	/** The file name. */
	@Column(name = "FILE_NAME")
	private String fileName;

	/** The upload file path. */
	@Column(name = "UPLOADED_FILE_PATH")
	private String uploadFilePath;

	/** The upload file name. */
	@Column(name = "UPLOADED_FILE_NAME")
	private String uploadFileName;
	
	/** The uploaded by. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UPLOADED_BY", referencedColumnName = "USER_ID", nullable = false)
	private EDPMsUserEntity uploadedBy;

	/** The role prm ID. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_PRM_ID")
	private EDPMsRolePermissionsEntity rolePrmID;

	/** The upload file size. */
	@Column(name = "UPLOADED_FILE_SIZE")
	private double uploadFileSize;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private long statusId;

	/** The wf id. */
	@Column(name = "WF_ROLE_ID")
	private long wfId;

	/** The file. */
	private transient MultipartFile file;

	/**
	 * Instantiates a new EDP trn user mp att entity.
	 */
	public EDPTrnUserMpAttEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP trn user mp att entity.
	 *
	 * @param userRgMpAttrId the user rg mp attr id
	 */
	public EDPTrnUserMpAttEntity(long userRgMpAttrId) {
		super();
		this.userRgMpAttrId = userRgMpAttrId;
	}

	/**
	 * Gets the user rg mp attr id.
	 *
	 * @return the user rg mp attr id
	 */
	public long getUserRgMpAttrId() {
		return userRgMpAttrId;
	}

	/**
	 * Sets the user rg mp attr id.
	 *
	 * @param userRgMpAttrId the new user rg mp attr id
	 */
	public void setUserRgMpAttrId(long userRgMpAttrId) {
		this.userRgMpAttrId = userRgMpAttrId;
	}

	/**
	 * Gets the user rg map id.
	 *
	 * @return the user rg map id
	 */
	public EDPtusrRgMapEntity getUserRgMapId() {
		return userRgMapId;
	}

	/**
	 * Sets the user rg map id.
	 *
	 * @param userRgMapId the new user rg map id
	 */
	public void setUserRgMapId(EDPtusrRgMapEntity userRgMapId) {
		this.userRgMapId = userRgMapId;
	}

	/**
	 * Gets the version id.
	 *
	 * @return the version id
	 */
	public int getVersionId() {
		return versionId;
	}

	/**
	 * Sets the version id.
	 *
	 * @param versionId the new version id
	 */
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the upload file path.
	 *
	 * @return the upload file path
	 */
	public String getUploadFilePath() {
		return uploadFilePath;
	}

	/**
	 * Sets the upload file path.
	 *
	 * @param uploadFilePath the new upload file path
	 */
	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	/**
	 * Gets the upload file name.
	 *
	 * @return the upload file name
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * Sets the upload file name.
	 *
	 * @param uploadFileName the new upload file name
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
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
	 * Gets the uploaded by.
	 *
	 * @return the uploaded by
	 */
	public EDPMsUserEntity getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * Sets the uploaded by.
	 *
	 * @param uploadedBy the new uploaded by
	 */
	public void setUploadedBy(EDPMsUserEntity uploadedBy) {
		this.uploadedBy = uploadedBy;
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
	 * Gets the role prm ID.
	 *
	 * @return the rolePrmID
	 */
	public EDPMsRolePermissionsEntity getRolePrmID() {
		return rolePrmID;
	}

	/**
	 * Sets the role prm ID.
	 *
	 * @param rolePrmID the rolePrmID to set
	 */
	public void setRolePrmID(EDPMsRolePermissionsEntity rolePrmID) {
		this.rolePrmID = rolePrmID;
	}

	/**
	 * Gets the upload file size.
	 *
	 * @return the upload file size
	 */
	public double getUploadFileSize() {
		return uploadFileSize;
	}

	/**
	 * Sets the upload file size.
	 *
	 * @param uploadFileSize the new upload file size
	 */
	public void setUploadFileSize(double uploadFileSize) {
		this.uploadFileSize = uploadFileSize;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wf id
	 */
	public long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the new wf id
	 */
	public void setWfId(long wfId) {
		this.wfId = wfId;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, fileName, rolePrmID, statusId, uploadFileName, uploadFilePath, uploadFileSize,
				uploadedBy, userRgMapId, userRgMpAttrId, versionId, wfId);
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
		if (!(obj instanceof EDPTrnUserMpAttEntity)) {
			return false;
		}
		EDPTrnUserMpAttEntity other = (EDPTrnUserMpAttEntity) obj;
		return Objects.equals(attachmentId, other.attachmentId) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(rolePrmID, other.rolePrmID) && statusId == other.statusId
				&& Objects.equals(uploadFileName, other.uploadFileName)
				&& Objects.equals(uploadFilePath, other.uploadFilePath)
				&& Double.doubleToLongBits(uploadFileSize) == Double.doubleToLongBits(other.uploadFileSize)
				&& uploadedBy == other.uploadedBy && userRgMapId == other.userRgMapId
				&& userRgMpAttrId == other.userRgMpAttrId && versionId == other.versionId && wfId == other.wfId;
	}

}
