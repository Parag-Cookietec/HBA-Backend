package gov.ifms.common.attachment.dto;

import java.util.Objects;

/**
 * The Class FileUploadResponseDto.
 */
public class FileUploadResponseDto {

	/** The upload file id. */
	private Long uploadFileId;
	
	/** The filename. */
	private String filename;
	
	/** The document id. */
	private String documentId;
	
	/** The upload dir path. */
	private String uploadDirPath;
	
	/** The upload by. */
	private String uploadBy;
	
	/**
	 * Gets the filename.
	 *
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Sets the filename.
	 *
	 * @param filename the new filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
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
	 * Gets the upload dir path.
	 *
	 * @return the upload dir path
	 */
	public String getUploadDirPath() {
		return uploadDirPath;
	}
	
	/**
	 * Sets the upload dir path.
	 *
	 * @param uploadDirPath the new upload dir path
	 */
	public void setUploadDirPath(String uploadDirPath) {
		this.uploadDirPath = uploadDirPath;
	}
	/**
	 * @return the uploadFileId
	 */
	public Long getUploadFileId() {
		return uploadFileId;
	}
	/**
	 * @param uploadFileId the uploadFileId to set
	 */
	public void setUploadFileId(Long uploadFileId) {
		this.uploadFileId = uploadFileId;
	}
	
	
	/**
	 * @return the uploadBy
	 */
	public String getUploadBy() {
		return uploadBy;
	}
	/**
	 * @param uploadBy the uploadBy to set
	 */
	public void setUploadBy(String uploadBy) {
		this.uploadBy = uploadBy;
	}
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(documentId, filename, uploadBy, uploadDirPath, uploadFileId);
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
		if (!(obj instanceof FileUploadResponseDto)) {
			return false;
		}
		FileUploadResponseDto other = (FileUploadResponseDto) obj;
		return Objects.equals(documentId, other.documentId) && Objects.equals(filename, other.filename)
				&& Objects.equals(uploadBy, other.uploadBy) && Objects.equals(uploadDirPath, other.uploadDirPath)
				&& Objects.equals(uploadFileId, other.uploadFileId);
	}
	
	
}
