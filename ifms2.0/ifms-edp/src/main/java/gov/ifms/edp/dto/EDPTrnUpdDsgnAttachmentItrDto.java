package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPTrnUpdDsgnAttachmentItrDto.
 */
public class EDPTrnUpdDsgnAttachmentItrDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The tedp upd dsgn att itr id. */
	private Long tedpUpdDsgnAttItrId;

	/** The tedp upd dsgn id. */
	private Long tedpUpdDsgnId; 
	
	/** The trn upd dsgn entity. */
	private Long trnUpdDsgnEntity;

	/** The attachment id. */
	private Long attachmentId;

	/** The file name. */
	private String fileName;

	/** The uploaded file path. */
	private String uploadedFilePath;

	/** The uploaded file name. */
	private String uploadedFileName;
	
	/** The uploaded file size. */
	private double uploadedFileSize;

	/** The uploaded by. */
	private Long uploadedBy;

	/** The role prm id. */
	private Long rolePrmId;
	
	/** The wf R ole id. */
	private Long wfROleId;
	
	/** The status id. */
	private Short statusId;

	/**
	 * Gets the tedp upd dsgn att itr id.
	 *
	 * @return the tedpUpdDsgnAttItrId
	 */
	public Long getTedpUpdDsgnAttItrId() {
		return tedpUpdDsgnAttItrId;
	}

	/**
	 * Sets the tedp upd dsgn att itr id.
	 *
	 * @param tedpUpdDsgnAttItrId the tedpUpdDsgnAttItrId to set
	 */
	public void setTedpUpdDsgnAttItrId(Long tedpUpdDsgnAttItrId) {
		this.tedpUpdDsgnAttItrId = tedpUpdDsgnAttItrId;
	}

	/**
	 * Gets the tedp upd dsgn id.
	 *
	 * @return the tedpUpdDsgnId
	 */
	public Long getTedpUpdDsgnId() {
		return tedpUpdDsgnId;
	}

	/**
	 * Sets the tedp upd dsgn id.
	 *
	 * @param tedpUpdDsgnId the tedpUpdDsgnId to set
	 */
	public void setTedpUpdDsgnId(Long tedpUpdDsgnId) {
		this.tedpUpdDsgnId = tedpUpdDsgnId;
	}

	/**
	 * Gets the trn upd dsgn entity.
	 *
	 * @return the trnUpdDsgnEntity
	 */
	public Long getTrnUpdDsgnEntity() {
		return trnUpdDsgnEntity;
	}

	/**
	 * Sets the trn upd dsgn entity.
	 *
	 * @param trnUpdDsgnEntity the trnUpdDsgnEntity to set
	 */
	public void setTrnUpdDsgnEntity(Long trnUpdDsgnEntity) {
		this.trnUpdDsgnEntity = trnUpdDsgnEntity;
	}

	/**
	 * Gets the attachment id.
	 *
	 * @return the attachmentId
	 */
	public Long getAttachmentId() {
		return attachmentId;
	}

	/**
	 * Sets the attachment id.
	 *
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(Long attachmentId) {
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
		return Objects.hash(attachmentId, fileName, rolePrmId, statusId, tedpUpdDsgnAttItrId, tedpUpdDsgnId,
				trnUpdDsgnEntity, uploadedBy, uploadedFileName, uploadedFilePath, uploadedFileSize, wfROleId);
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
		if (!(obj instanceof EDPTrnUpdDsgnAttachmentItrDto)) {
			return false;
		}
		EDPTrnUpdDsgnAttachmentItrDto other = (EDPTrnUpdDsgnAttachmentItrDto) obj;
		return Objects.equals(attachmentId, other.attachmentId) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(rolePrmId, other.rolePrmId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(tedpUpdDsgnAttItrId, other.tedpUpdDsgnAttItrId)
				&& Objects.equals(tedpUpdDsgnId, other.tedpUpdDsgnId)
				&& Objects.equals(trnUpdDsgnEntity, other.trnUpdDsgnEntity)
				&& Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Double.doubleToLongBits(uploadedFileSize) == Double.doubleToLongBits(other.uploadedFileSize)
				&& Objects.equals(wfROleId, other.wfROleId);
	}
	
}
