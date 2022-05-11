package gov.ifms.pvu.entity;

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
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;

/**
 * The Class PVUForgoAttachmentEntity.
 * 
 * @version v 1.0
 * @created 2020/01/13 11:47:13
 *
 */
@Entity
@Table(name = "T_PVU_PRFG_ATT", schema = Constant.PVU_SCHEMA)
public class PVUForgoAttachmentEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_PRFG_ATT_ID")
	private long attachmentId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_PRFG_EVNT_ID", nullable = true, referencedColumnName ="T_PVU_PRFG_EVNT_ID") 
	private PVUEmployeForgoEntity eventId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ATTACHMENT_ID", nullable = true, referencedColumnName = "ATTACHMENT_ID")
	private EDPMsAttachmentEntity attachId;

	@Column(name = "VERSION_ID")
	private int versionId;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "UPLOADED_FILE_PATH")
	private String uploadedFilePath;

	@Column(name = "UPLOADED_FILE_NAME")
	private String uploadedFileName;

	@Column(name = "UPLOADED_FILE_SIZE")
	private long fileSize;

	@Column(name = "UPLOADED_BY")
	private long uploadedBy;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ROLE_PRM_ID", nullable = true, referencedColumnName = "ROLE_PRM_ID")
	private EDPMsRolePermissionsEntity roleId;

	/**
	 * PVUForgoAttachmentEntity Constructor
	 */
	public PVUForgoAttachmentEntity() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, attachmentId, eventId, attachId, versionId, fileName, uploadedFilePath,
				uploadedFileName, fileSize, uploadedBy, roleId);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUForgoAttachmentEntity)) {
			return false;
		}

		PVUForgoAttachmentEntity other = (PVUForgoAttachmentEntity) obj;

		return Objects.equals(attachmentId, other.attachmentId) && attachmentId == other.attachmentId
				&& eventId == other.eventId && attachId == other.attachId && versionId == other.versionId
				&& Objects.equals(fileName, other.fileName) && Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Objects.equals(uploadedFileName, other.uploadedFileName) && fileSize == other.fileSize
				&& uploadedBy == other.uploadedBy && roleId == other.roleId;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "PVUForgoAttachmentEntity [attachmentId = " + attachmentId + ",attachmentId = " + attachmentId
				+ ",eventId = " + eventId + ",attachId = " + attachId + ",versionId = " + versionId + ",fileName = "
				+ fileName + ",uploadedFilePath = " + uploadedFilePath + ",uploadedFileName = " + uploadedFileName
				+ ",fileSize = " + fileSize + ",uploadedBy = " + uploadedBy + ",roleId = " + roleId + ",]";
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the attachmentId
	 */
	public long getAttachmentId() {
		return attachmentId;
	}

	/**
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}


	/**
	 * @return the eventId
	 */
	public PVUEmployeForgoEntity getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(PVUEmployeForgoEntity eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the attachId
	 */
	public EDPMsAttachmentEntity getAttachId() {
		return attachId;
	}

	/**
	 * @param attachId the attachId to set
	 */
	public void setAttachId(EDPMsAttachmentEntity attachId) {
		this.attachId = attachId;
	}

	/**
	 * @return the versionId
	 */
	public int getVersionId() {
		return versionId;
	}

	/**
	 * @param versionId the versionId to set
	 */
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the uploadedFilePath
	 */
	public String getUploadedFilePath() {
		return uploadedFilePath;
	}

	/**
	 * @param uploadedFilePath the uploadedFilePath to set
	 */
	public void setUploadedFilePath(String uploadedFilePath) {
		this.uploadedFilePath = uploadedFilePath;
	}

	/**
	 * @return the uploadedFileName
	 */
	public String getUploadedFileName() {
		return uploadedFileName;
	}

	/**
	 * @param uploadedFileName the uploadedFileName to set
	 */
	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}

	/**
	 * @return the fileSize
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the uploadedBy
	 */
	public long getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * @param uploadedBy the uploadedBy to set
	 */
	public void setUploadedBy(long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * @return the roleId
	 */
	public EDPMsRolePermissionsEntity getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(EDPMsRolePermissionsEntity roleId) {
		this.roleId = roleId;
	}

}
