package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

/**
 * The Class EDPTrnUpdDsgnAttachmentDto.
 */
public class EDPTrnUpdDsgnAttachmentDto extends BaseDto implements Serializable  {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tedp upd dsgn att id. */
	private Long tedpUpdDsgnAttId;

	/** The trn upd dsgn entity. */
	private Long trnUpdDsgnEntity;

	/** The attachment id. */
	private Long attachmentId;
	
	/** The attachment name. */
	private String attachmentName;

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
	
	/** The uploaded by name. */
	private String uploadedByName;

	/** The role prm id. */
	private Long rolePrmId;
	
	/** The wf R ole id. */
	private Long wfROleId;
	
	/** The status id. */
	private Short statusId;
	
	/** The file. */
	@NotNull
	private transient MultipartFile file = null;

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
		if (!(obj instanceof EDPTrnUpdDsgnAttachmentDto)) {
			return false;
		}
		EDPTrnUpdDsgnAttachmentDto other = (EDPTrnUpdDsgnAttachmentDto) obj;
		return Objects.equals(attachmentId, other.attachmentId) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(rolePrmId, other.rolePrmId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(tedpUpdDsgnAttId, other.tedpUpdDsgnAttId)
				&& Objects.equals(trnUpdDsgnEntity, other.trnUpdDsgnEntity)
				&& Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Double.doubleToLongBits(uploadedFileSize) == Double.doubleToLongBits(other.uploadedFileSize)
				&& Objects.equals(wfROleId, other.wfROleId);
	}
		
}
