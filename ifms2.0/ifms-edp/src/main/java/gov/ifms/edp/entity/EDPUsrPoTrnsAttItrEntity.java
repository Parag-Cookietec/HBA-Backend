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
 * The Class EDPUsrPoTrnsAttItrEntity.
 */
@Entity
@Table(name = "TEDP_UPT_ATT_ITR", schema = Constant.EDP_SCHEMA)
public class EDPUsrPoTrnsAttItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp usr po tran att itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_UPT_ATT_ITR_ID")
	private Long edpUsrPoTranAttItrId;

	/** The edp usr po tran att id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEDP_UPT_ATT_ID", referencedColumnName = "TEDP_UPT_ATT_ID")
	private EDPUsrPoTrnsAttEntity edpUsrPoTranAttId;

	/** The edp usr po trns headr id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEDP_UPT_HDR_ID", referencedColumnName = "TEDP_UPT_HDR_ID")
	private EDPUsrPoTrnsHeaderEntity edpUsrPoTrnsHeadrId;

	/** The attachment id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATTACHMENT_ID", referencedColumnName = "ATTACHMENT_ID")
	private EDPMsAttachmentEntity attachmentId;

	/** The file name. */
	@Column(name = "FILE_NAME")
	private String fileName;

	/** The uploaded file path. */
	@Column(name = "UPLOADED_FILE_PATH")
	private String uploadedFilePath;

	/** The uploaded file name. */
	@Column(name = "UPLOADED_FILE_NAME")
	private String uploadedFileName;

	/** The uploaded file size. */
	@Column(name = "UPLOADED_FILE_SIZE")
	private Long uploadedFileSize;

	/** The uploaded by. */
	@Column(name = "UPLOADED_BY")
	private Long uploadedBy;

	/** The role prm ID. */
	@Column(name = "ROLE_PRM_ID")
	private Long rolePrmID;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/**
	 * EDPUsrPoTrnsAttDto Constructor.
	 */
	public EDPUsrPoTrnsAttItrEntity() {
		super();
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
	 * Gets the edp usr po tran att id.
	 *
	 * @return the edpUsrPoTranAttId
	 */
	public EDPUsrPoTrnsAttEntity getEdpUsrPoTranAttId() {
		return edpUsrPoTranAttId;
	}

	/**
	 * Sets the edp usr po tran att id.
	 *
	 * @param edpUsrPoTranAttId the edpUsrPoTranAttId to set
	 */
	public void setEdpUsrPoTranAttId(EDPUsrPoTrnsAttEntity edpUsrPoTranAttId) {
		this.edpUsrPoTranAttId = edpUsrPoTranAttId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, edpUsrPoTranAttId, edpUsrPoTranAttItrId, edpUsrPoTrnsHeadrId, fileName,
				rolePrmID, statusId, uploadedBy, uploadedFileName, uploadedFilePath, uploadedFileSize, wfRoleId);
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
		if (!(obj instanceof EDPUsrPoTrnsAttItrEntity)) {
			return false;
		}
		EDPUsrPoTrnsAttItrEntity other = (EDPUsrPoTrnsAttItrEntity) obj;
		return Objects.equals(attachmentId, other.attachmentId)
				&& Objects.equals(edpUsrPoTranAttId, other.edpUsrPoTranAttId)
				&& Objects.equals(edpUsrPoTranAttItrId, other.edpUsrPoTranAttItrId)
				&& Objects.equals(edpUsrPoTrnsHeadrId, other.edpUsrPoTrnsHeadrId)
				&& Objects.equals(fileName, other.fileName) && Objects.equals(rolePrmID, other.rolePrmID)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Objects.equals(uploadedFileSize, other.uploadedFileSize) && Objects.equals(wfRoleId, other.wfRoleId);
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
	 * Gets the edp usr po trns headr id.
	 *
	 * @return the edpUsrPoTrnsHeadrId
	 */
	public EDPUsrPoTrnsHeaderEntity getEdpUsrPoTrnsHeadrId() {
		return edpUsrPoTrnsHeadrId;
	}

	/**
	 * Sets the edp usr po trns headr id.
	 *
	 * @param edpUsrPoTrnsHeadrId the edpUsrPoTrnsHeadrId to set
	 */
	public void setEdpUsrPoTrnsHeadrId(EDPUsrPoTrnsHeaderEntity edpUsrPoTrnsHeadrId) {
		this.edpUsrPoTrnsHeadrId = edpUsrPoTrnsHeadrId;
	}

}
