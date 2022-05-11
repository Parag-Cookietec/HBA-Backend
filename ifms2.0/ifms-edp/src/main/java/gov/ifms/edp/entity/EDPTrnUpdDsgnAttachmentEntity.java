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
 * The Class EDPTrnUpdDsgnAttachmentEntity.
 */
@Entity
@Table(name = "TEDP_UPD_DSGN_ATT", schema = Constant.EDP_SCHEMA)
public class EDPTrnUpdDsgnAttachmentEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The tedp upd dsgn att id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_UPD_DSGN_ATT_ID")
	private Long tedpUpdDsgnAttId;

	/** The trn upd dsgn entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TEDP_UPD_DSGN_ID", referencedColumnName = "TEDP_UPD_DSGN_ID")
	private EDPTrnUpdDsgnEntity trnUpdDsgnEntity;

	/** The attachment id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ATTACHMENT_ID", nullable = false)
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
	@Column(name="UPLOADED_FILE_SIZE")
	private double uploadedFileSize;

	/** The uploaded by. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UPLOADED_BY", referencedColumnName = "USER_ID", nullable = false)
	private EDPMsUserEntity uploadedBy;

	/** The role prm id. */
	@Column(name="ROLE_PRM_ID")
	private Long rolePrmId;
	
	/** The wf R ole id. */
	@Column(name="WF_ROLE_ID")
	private Long wfROleId;
	
	/** The status id. */
	@Column(name="STATUS_ID")
	private Short statusId;
	
	/** The file. */
	private transient MultipartFile file;

	
	
	/**
	 * Instantiates a new EDP trn upd dsgn attachment entity.
	 */
	public EDPTrnUpdDsgnAttachmentEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP trn upd dsgn attachment entity.
	 *
	 * @param tedpUpdDsgnAttId the tedp upd dsgn att id
	 */
	public EDPTrnUpdDsgnAttachmentEntity(Long tedpUpdDsgnAttId) {
		super();
		this.tedpUpdDsgnAttId = tedpUpdDsgnAttId;
	}

	/**
	 * Gets the tedp upd dsgn att id.
	 *
	 * @return the tedpUpdDsgnAttId
	 */
	public Long getTedpUpdDsgnAttId() {
		return tedpUpdDsgnAttId;
	}

	/**
	 * Sets the tedp upd dsgn att id.
	 *
	 * @param tedpUpdDsgnAttId the tedpUpdDsgnAttId to set
	 */
	public void setTedpUpdDsgnAttId(Long tedpUpdDsgnAttId) {
		this.tedpUpdDsgnAttId = tedpUpdDsgnAttId;
	}

	/**
	 * Gets the trn upd dsgn entity.
	 *
	 * @return the trnUpdDsgnEntity
	 */
	public EDPTrnUpdDsgnEntity getTrnUpdDsgnEntity() {
		return trnUpdDsgnEntity;
	}

	/**
	 * Sets the trn upd dsgn entity.
	 *
	 * @param trnUpdDsgnEntity the trnUpdDsgnEntity to set
	 */
	public void setTrnUpdDsgnEntity(EDPTrnUpdDsgnEntity trnUpdDsgnEntity) {
		this.trnUpdDsgnEntity = trnUpdDsgnEntity;
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
	 * Gets the role prm id.
	 *
	 * @return the rolePrmId
	 */
	public Long getRolePrmId() {
		return rolePrmId;
	}

	/**
	 * Sets the role prm id.
	 *
	 * @param rolePrmId the rolePrmId to set
	 */
	public void setRolePrmId(Long rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * Gets the wf R ole id.
	 *
	 * @return the wfROleId
	 */
	public Long getWfROleId() {
		return wfROleId;
	}

	/**
	 * Sets the wf R ole id.
	 *
	 * @param wfROleId the wfROleId to set
	 */
	public void setWfROleId(Long wfROleId) {
		this.wfROleId = wfROleId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Short getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Short statusId) {
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, fileName, rolePrmId, statusId, tedpUpdDsgnAttId, trnUpdDsgnEntity, uploadedBy,
				uploadedFileName, uploadedFilePath, uploadedFileSize, wfROleId);
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
		if (!(obj instanceof EDPTrnUpdDsgnAttachmentEntity)) {
			return false;
		}
		EDPTrnUpdDsgnAttachmentEntity other = (EDPTrnUpdDsgnAttachmentEntity) obj;
		return Objects.equals(attachmentId, other.attachmentId) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(rolePrmId, other.rolePrmId) && Objects.equals(statusId, other.statusId)
				&& tedpUpdDsgnAttId == other.tedpUpdDsgnAttId
				&& Objects.equals(trnUpdDsgnEntity, other.trnUpdDsgnEntity)
				&& Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Double.doubleToLongBits(uploadedFileSize) == Double.doubleToLongBits(other.uploadedFileSize)
				&& Objects.equals(wfROleId, other.wfROleId);
	}
}
