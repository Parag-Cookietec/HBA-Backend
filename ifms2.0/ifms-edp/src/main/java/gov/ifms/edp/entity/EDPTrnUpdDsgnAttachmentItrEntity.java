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
 * The Class EDPTrnUpdDsgnAttachmentItrEntity.
 */
@Entity
@Table(name = "TEDPUPD_DSGN_ATT_ITR", schema = Constant.EDP_SCHEMA)
public class EDPTrnUpdDsgnAttachmentItrEntity  extends BaseEntity implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The tedp upd dsgn att itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDPUPDSGN_ATTITR_ID")
	private long tedpUpdDsgnAttItrId;

	/** The tedp upd dsgn att id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TEDP_UPD_DSGN_ATT_ID", referencedColumnName = "TEDP_UPD_DSGN_ATT_ID")
	private EDPTrnUpdDsgnAttachmentEntity tedpUpdDsgnAttId; 
	
	/** The tedp upd dsgn id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TEDP_UPD_DSGN_ID", referencedColumnName = "TEDP_UPD_DSGN_ID")
	private EDPTrnUpdDsgnEntity tedpUpdDsgnId;

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

	/**
	 * Gets the tedp upd dsgn att itr id.
	 *
	 * @return the tedpUpdDsgnAttItrId
	 */
	public long getTedpUpdDsgnAttItrId() {
		return tedpUpdDsgnAttItrId;
	}

	/**
	 * Sets the tedp upd dsgn att itr id.
	 *
	 * @param tedpUpdDsgnAttItrId the tedpUpdDsgnAttItrId to set
	 */
	public void setTedpUpdDsgnAttItrId(long tedpUpdDsgnAttItrId) {
		this.tedpUpdDsgnAttItrId = tedpUpdDsgnAttItrId;
	}

	

	/**
	 * Gets the tedp upd dsgn att id.
	 *
	 * @return the tedpUpdDsgnAttId
	 */
	public EDPTrnUpdDsgnAttachmentEntity getTedpUpdDsgnAttId() {
		return tedpUpdDsgnAttId;
	}

	/**
	 * Sets the tedp upd dsgn att id.
	 *
	 * @param tedpUpdDsgnAttId the tedpUpdDsgnAttId to set
	 */
	public void setTedpUpdDsgnAttId(EDPTrnUpdDsgnAttachmentEntity tedpUpdDsgnAttId) {
		this.tedpUpdDsgnAttId = tedpUpdDsgnAttId;
	}

	/**
	 * Gets the tedp upd dsgn id.
	 *
	 * @return the tedpUpdDsgnId
	 */
	public EDPTrnUpdDsgnEntity getTedpUpdDsgnId() {
		return tedpUpdDsgnId;
	}

	/**
	 * Sets the tedp upd dsgn id.
	 *
	 * @param tedpUpdDsgnId the tedpUpdDsgnId to set
	 */
	public void setTedpUpdDsgnId(EDPTrnUpdDsgnEntity tedpUpdDsgnId) {
		this.tedpUpdDsgnId = tedpUpdDsgnId;
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
		return Objects.hash(attachmentId, fileName, rolePrmId, statusId, tedpUpdDsgnAttId, tedpUpdDsgnAttItrId,
				tedpUpdDsgnId, uploadedBy, uploadedFileName, uploadedFilePath, uploadedFileSize, wfROleId);
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
		if (!(obj instanceof EDPTrnUpdDsgnAttachmentItrEntity)) {
			return false;
		}
		EDPTrnUpdDsgnAttachmentItrEntity other = (EDPTrnUpdDsgnAttachmentItrEntity) obj;
		return Objects.equals(attachmentId, other.attachmentId) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(rolePrmId, other.rolePrmId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(tedpUpdDsgnAttId, other.tedpUpdDsgnAttId)
				&& tedpUpdDsgnAttItrId == other.tedpUpdDsgnAttItrId
				&& Objects.equals(tedpUpdDsgnId, other.tedpUpdDsgnId) && Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Double.doubleToLongBits(uploadedFileSize) == Double.doubleToLongBits(other.uploadedFileSize)
				&& Objects.equals(wfROleId, other.wfROleId);
	}
	
	
}
