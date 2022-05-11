package gov.ifms.common.attachment.dto;

public class AttachmentDownloadDto {

	/** The document id. */
	private String documentDataKey;	
	
	/** The filename. */
	private String fileName;

	
	/**
	 * Instantiates a new attachment download dto.
	 *
	 * @param documentDataKey the document data key
	 * @param fileName the file name
	 */
	public AttachmentDownloadDto(String documentDataKey, String fileName) {
		super();
		this.documentDataKey = documentDataKey;
		this.fileName = fileName;
	}
	
	/**
	 * Instantiates a new attachment download dto.
	 */
	public AttachmentDownloadDto() {
		super();
	}
	
	/**
	 * Gets the document id.
	 *
	 * @return the document id
	 */
	public String getDocumentDataKey() {
		return documentDataKey;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the document id.
	 *
	 * @param documentId the new document id
	 */
	public void setDocumentDataKey(String documentDataKey) {
		this.documentDataKey = documentDataKey;
	}

	/**
	 * Sets the filename.
	 *
	 * @param filename the new filename
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
}
