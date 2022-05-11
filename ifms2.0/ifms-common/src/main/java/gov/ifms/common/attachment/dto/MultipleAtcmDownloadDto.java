package gov.ifms.common.attachment.dto;

public class MultipleAtcmDownloadDto {
	
	/** The document id. */
	private String documentDataKey[];	
	
	/** The filename. */
	private String fileName[];

	public String[] getDocumentDataKey() {
		return documentDataKey;
	}

	public void setDocumentDataKey(String[] documentDataKey) {
		this.documentDataKey = documentDataKey;
	}

	public String[] getFileName() {
		return fileName;
	}

	public void setFileName(String[] fileName) {
		this.fileName = fileName;
	}

}
