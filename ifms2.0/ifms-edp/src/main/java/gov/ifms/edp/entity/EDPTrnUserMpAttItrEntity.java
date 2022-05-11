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

import gov.ifms.common.util.Constant;

/**
 * The Class EDPTrnUserMpAttItrEntity.
 */
@Entity
@Table(name = "T_USR_RG_MP_ATT_ITR", schema = Constant.EDP_SCHEMA)
public class EDPTrnUserMpAttItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user rg mp at itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_USR_RGMP_AT_ITR_ID")
	private long userRgMpAtItrId;

	/** The usr rg mpattr id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_USR_RG_MP_ATT_ID", referencedColumnName = "T_USR_RG_MP_ATT_ID")
	private EDPTrnUserMpAttEntity usrRgMpattrId;

	/** The attachment id. */
	@Column(name = "ATTACHMENT_ID")
	private long attachmentId;

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
	@Column(name = "UPLOADED_BY")
	private long uploadedBy;

	/** The role prm ID. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_PRM_ID")
	private EDPMsRolePermissionsEntity rolePrmID;

	/** The upload file size. */
	@Column(name = "UPLOADED_FILE_SIZE")
	private float uploadFileSize;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private long statusId;

	/** The wf id. */
	@Column(name = "WF_ROLE_ID")
	private long wfId;

	/**
	 * Instantiates a new EDP trn user mp att itr entity.
	 */
	public EDPTrnUserMpAttItrEntity() {
		super();
	}

	/**
	 * Gets the user rg mp at itr id.
	 *
	 * @return the user rg mp at itr id
	 */
	public long getUserRgMpAtItrId() {
		return userRgMpAtItrId;
	}

	/**
	 * Sets the user rg mp at itr id.
	 *
	 * @param userRgMpAtItrId the new user rg mp at itr id
	 */
	public void setUserRgMpAtItrId(long userRgMpAtItrId) {
		this.userRgMpAtItrId = userRgMpAtItrId;
	}

	/**
	 * Gets the usr rg mpattr id.
	 *
	 * @return the usr rg mpattr id
	 */
	public EDPTrnUserMpAttEntity getUsrRgMpattrId() {
		return usrRgMpattrId;
	}

	/**
	 * Sets the usr rg mpattr id.
	 *
	 * @param usrRgMpattrId the new usr rg mpattr id
	 */
	public void setUsrRgMpattrId(EDPTrnUserMpAttEntity usrRgMpattrId) {
		this.usrRgMpattrId = usrRgMpattrId;
	}

	/**
	 * Sets the attachment id.
	 *
	 * @param attachmentId the new attachment id
	 */
	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
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
	 * Gets the uploaded by.
	 *
	 * @return the uploaded by
	 */
	public long getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * Sets the uploaded by.
	 *
	 * @param uploadedBy the new uploaded by
	 */
	public void setUploadedBy(long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * Gets the attachment id.
	 *
	 * @return the attachment id
	 */
	public long getAttachmentId() {
		return attachmentId;
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
	public float getUploadFileSize() {
		return uploadFileSize;
	}

	/**
	 * Sets the upload file size.
	 *
	 * @param uploadFileSize the new upload file size
	 */
	public void setUploadFileSize(float uploadFileSize) {
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, fileName, rolePrmID, statusId, uploadFileName, uploadFilePath, uploadFileSize,
				uploadedBy, userRgMpAtItrId, usrRgMpattrId, versionId, wfId);
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPTrnUserMpAttItrEntity)) {
			return false;
		}
		EDPTrnUserMpAttItrEntity other = (EDPTrnUserMpAttItrEntity) obj;
		return attachmentId == other.attachmentId && Objects.equals(fileName, other.fileName)
				&& Objects.equals(rolePrmID, other.rolePrmID) && statusId == other.statusId
				&& Objects.equals(uploadFileName, other.uploadFileName)
				&& Objects.equals(uploadFilePath, other.uploadFilePath)
				&& Float.floatToIntBits(uploadFileSize) == Float.floatToIntBits(other.uploadFileSize)
				&& uploadedBy == other.uploadedBy && userRgMpAtItrId == other.userRgMpAtItrId
				&& Objects.equals(usrRgMpattrId, other.usrRgMpattrId) && versionId == other.versionId
				&& wfId == other.wfId;
	}
}
