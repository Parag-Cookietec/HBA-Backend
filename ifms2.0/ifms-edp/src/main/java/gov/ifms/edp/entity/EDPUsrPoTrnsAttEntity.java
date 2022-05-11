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
 * The Class EDPUsrPoTrnsAttEntity.
 * 
 * @version 1.0
 * @created 2020/01/02 14:43:21
 *
 */
@Entity
@Table(name = "TEDP_UPT_ATT", schema = Constant.EDP_SCHEMA)
public class EDPUsrPoTrnsAttEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp usr po tran att id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_UPT_ATT_ID")
	private Long edpUsrPoTranAttId;

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
	private double uploadedFileSize;

	/** The uploaded by. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UPLOADED_BY", referencedColumnName = "USER_ID", nullable = false)
	private EDPMsUserEntity uploadedBy;

	/** The role prm ID. */
	@Column(name = "ROLE_PRM_ID")
	private Long rolePrmID;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/** The file. */
	private transient MultipartFile file;

	/**
	 * EDPUsrPoTrnsAttDto Constructor.
	 */
	public EDPUsrPoTrnsAttEntity() {
		super();
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, edpUsrPoTranAttId, edpUsrPoTrnsHeadrId, fileName, rolePrmID, statusId,
				uploadedBy, uploadedFileName, uploadedFilePath, uploadedFileSize);
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
		if (!(obj instanceof EDPUsrPoTrnsAttEntity)) {
			return false;
		}
		EDPUsrPoTrnsAttEntity other = (EDPUsrPoTrnsAttEntity) obj;
		return Objects.equals(attachmentId, other.attachmentId)
				&& Objects.equals(edpUsrPoTranAttId, other.edpUsrPoTranAttId)
				&& Objects.equals(edpUsrPoTrnsHeadrId, other.edpUsrPoTrnsHeadrId)
				&& Objects.equals(fileName, other.fileName) && Objects.equals(rolePrmID, other.rolePrmID)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Double.doubleToLongBits(uploadedFileSize) == Double.doubleToLongBits(other.uploadedFileSize);
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
