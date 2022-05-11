package gov.ifms.pvu.common;

import java.util.Collections;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.edp.dto.BaseDto;

/**
 * The Class BasePVUAttachmentDto.
 */

public class BasePVUAttachmentDto extends BaseDto {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new base PVU attachment dto.
	 */
	public BasePVUAttachmentDto() {//NOSONAR
	}

	public BasePVUAttachmentDto(Long id) {//NOSONAR
		this.id = id;
	}

	/** The transaction id. */
	@NotNull
	private Long transactionId;

	/** The id. */
	private Long id;

	/** The attachment type id. */
	private Long attachmentTypeId;

	/** The version id. */
	private Integer versionId;

	/** The file name. */
	private String fileName;

	/** The upload file path. */
	private String uploadFilePath;

	/** The upload file name. */
	private String uploadFileName;

	/** The upload file size. */
	private double uploadFileSize;

	/** The role prm id. */
	private Long rolePrmId;

	/** The status id. */
	private Long statusId;

	/** The uploaded by. */
	private String uploadedBy;

	/** The menu id. */
	private Long menuId;

	/** The format. */
	@NotNull
	private String format;

	/** The file size. */
	@NotNull
	private Integer fileSize;

	/** The upload directory path. */
	@NotNull
	private String uploadDirectoryPath;

	/** The attachment. */
	@NotNull
	private MultipartFile attachment; //NOSONAR

	/** The document id. */
	private String documentId;

	/** The is delete. */
	private boolean isDelete;
	
	/** The pou id. */
	private Long pouId;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 */
	public Long getTransactionId() {
		return transactionId;
	}

	/**
	 * Sets the transaction id.
	 *
	 * @param transactionId the new transaction id
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Gets the attachment.
	 *
	 * @return the attachment
	 */
	public MultipartFile getAttachment() {
		return attachment;
	}

	/**
	 * Sets the attachment.
	 *
	 * @param attachment the new attachment
	 */
	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}

	/**
	 * Gets the attachment type id.
	 *
	 * @return the attachment type id
	 */
	public Long getAttachmentTypeId() {
		return attachmentTypeId;
	}

	/**
	 * Sets the attachment type id.
	 *
	 * @param attachmentTypeId the new attachment type id
	 */
	public void setAttachmentTypeId(Long attachmentTypeId) {
		this.attachmentTypeId = attachmentTypeId;
	}

	/**
	 * Gets the version id.
	 *
	 * @return the version id
	 */
	public Integer getVersionId() {
		return versionId;
	}

	/**
	 * Sets the version id.
	 *
	 * @param versionId the new version id
	 */
	public void setVersionId(Integer versionId) {
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
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the role prm id.
	 *
	 * @return the role prm id
	 */
	public Long getRolePrmId() {
		return rolePrmId;
	}

	/**
	 * Sets the role prm id.
	 *
	 * @param rolePrmId the new role prm id
	 */
	public void setRolePrmId(Long rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * Gets the uploaded by.
	 *
	 * @return the uploaded by
	 */
	public String getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * Sets the uploaded by.
	 *
	 * @param uploadedBy the new uploaded by
	 */
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * Gets the document id.
	 *
	 * @return the document id
	 */
	public String getDocumentId() {
		return documentId;
	}

	/**
	 * Sets the document id.
	 *
	 * @param documentId the new document id
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the format.
	 *
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Sets the format.
	 *
	 * @param format the new format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Gets the file size.
	 *
	 * @return the file size
	 */
	public Integer getFileSize() {
		return fileSize;
	}

	/**
	 * Sets the file size.
	 *
	 * @param fileSize the new file size
	 */
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * Gets the upload directory path.
	 *
	 * @return the upload directory path
	 */
	public String getUploadDirectoryPath() {
		return uploadDirectoryPath;
	}

	/**
	 * Sets the upload directory path.
	 *
	 * @param uploadDirectoryPath the new upload directory path
	 */
	public void setUploadDirectoryPath(String uploadDirectoryPath) {
		this.uploadDirectoryPath = uploadDirectoryPath;
	}

	/**
	 * Sets the delete.
	 *
	 * @param isDelete the new delete
	 */
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	
	/**
	 * Checks if is delete.
	 *
	 * @return true, if is delete
	 */
	public boolean isDelete() {
		return isDelete;
	}
	
	/**
	 * Gets the pou id.
	 *
	 * @return the pou id
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the new pou id
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}
	/**
	 * Creates the attachment.
	 *
	 * @param dto the dto
	 * @return the attachment master dto
	 */
	public static AttachmentMasterDto createAttachment(BasePVUAttachmentDto dto) {
		return new AttachmentMasterDto(dto.getMenuId(), dto.getAttachmentTypeId(), dto.getFormat(), dto.getFileSize(),
				dto.getUploadDirectoryPath(), dto.getTransactionId(), dto.getFileName(),
				Collections.singletonList(dto.getAttachment()));
	}

	@Override
	public String toString() {
		return "BasePVUAttachmentDto{" +
				"transactionId=" + transactionId +
				", id=" + id +
				", attachmentTypeId=" + attachmentTypeId +
				", versionId=" + versionId +
				", fileName='" + fileName + '\'' +
				", uploadFilePath='" + uploadFilePath + '\'' +
				", uploadFileName='" + uploadFileName + '\'' +
				", uploadFileSize=" + uploadFileSize +
				", rolePrmId=" + rolePrmId +
				", statusId=" + statusId +
				", uploadedBy='" + uploadedBy + '\'' +
				", menuId=" + menuId +
				", format='" + format + '\'' +
				", fileSize=" + fileSize +
				", uploadDirectoryPath='" + uploadDirectoryPath + '\'' +
				", attachment=" + attachment +
				", documentId='" + documentId + '\'' +
				", isDelete=" + isDelete +
				", pouId=" + pouId +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		BasePVUAttachmentDto that = (BasePVUAttachmentDto) o;
		return Double.compare(that.uploadFileSize, uploadFileSize) == 0 &&
				isDelete == that.isDelete &&
				Objects.equals(transactionId, that.transactionId) &&
				Objects.equals(id, that.id) &&
				Objects.equals(attachmentTypeId, that.attachmentTypeId) &&
				Objects.equals(versionId, that.versionId) &&
				Objects.equals(fileName, that.fileName) &&
				Objects.equals(uploadFilePath, that.uploadFilePath) &&
				Objects.equals(uploadFileName, that.uploadFileName) &&
				Objects.equals(rolePrmId, that.rolePrmId) &&
				Objects.equals(statusId, that.statusId) &&
				Objects.equals(uploadedBy, that.uploadedBy) &&
				Objects.equals(menuId, that.menuId) &&
				Objects.equals(format, that.format) &&
				Objects.equals(fileSize, that.fileSize) &&
				Objects.equals(uploadDirectoryPath, that.uploadDirectoryPath) &&
				Objects.equals(attachment, that.attachment) &&
				Objects.equals(documentId, that.documentId) &&
				Objects.equals(pouId, that.pouId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), transactionId, id, attachmentTypeId, versionId, fileName, uploadFilePath, uploadFileName, uploadFileSize, rolePrmId, statusId, uploadedBy, menuId, format, fileSize, uploadDirectoryPath, attachment, documentId, isDelete, pouId);
	}
}
