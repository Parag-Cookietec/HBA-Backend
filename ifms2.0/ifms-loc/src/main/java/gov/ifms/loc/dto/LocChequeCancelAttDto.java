package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LOCLocChequeCancelAttDto.
 * 
 * @version v 1.0
 * @created 2021/03/05 17:59:59
 *
 */
public class LocChequeCancelAttDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Id. */
	private Long Id;

	/** The trn id. */
	private Long trnId;

	/** The attachement id. */
	private Long attachementId;

	/** The file name. */
	private String fileName;

	/** The uploaded file path. */
	private String uploadedFilePath;

	/** The uploaded file name. */
	private String uploadedFileName;

	/** The uploaded file size. */
	private Double uploadedFileSize;

	/** The uploaded by. */
	private Long uploadedBy;

	/** The document id. */
	private String documentId;

	/** The category. */
	private Long category;

	/** The wf id. */
	private Long wfId;

	/** The wf role id. */
	private Long wfRoleId;

	/** The action id. */
	private Long actionId;

	/**
	 * LocChequeCancelAttDto Constructor.
	 */
	public LocChequeCancelAttDto() {
		super();
	}

	/**
	 * @return the Id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @param Id the Id to set
	 */
	public void setId(Long Id) {
		this.Id = Id;
	}

	/**
	 * @return the trnId
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	/**
	 * @return the attachementId
	 */
	public Long getAttachementId() {
		return attachementId;
	}

	/**
	 * @param attachementId the attachementId to set
	 */
	public void setAttachementId(Long attachementId) {
		this.attachementId = attachementId;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the uploadedFilePath
	 */
	public String getUploadedFilePath() {
		return uploadedFilePath;
	}

	/**
	 * @param uploadedFilePath the uploadedFilePath to set
	 */
	public void setUploadedFilePath(String uploadedFilePath) {
		this.uploadedFilePath = uploadedFilePath;
	}

	/**
	 * @return the uploadedFileName
	 */
	public String getUploadedFileName() {
		return uploadedFileName;
	}

	/**
	 * @param uploadedFileName the uploadedFileName to set
	 */
	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}

	/**
	 * @return the uploadedFileSize
	 */
	public Double getUploadedFileSize() {
		return uploadedFileSize;
	}

	/**
	 * @param uploadedFileSize the uploadedFileSize to set
	 */
	public void setUploadedFileSize(Double uploadedFileSize) {
		this.uploadedFileSize = uploadedFileSize;
	}

	/**
	 * @return the uploadedBy
	 */
	public Long getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * @param uploadedBy the uploadedBy to set
	 */
	public void setUploadedBy(Long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * @return the documentId
	 */
	public String getDocumentId() {
		return documentId;
	}

	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	/**
	 * @return the category
	 */
	public Long getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Long category) {
		this.category = category;
	}

	/**
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @return the actionId
	 */
	public Long getActionId() {
		return actionId;
	}

	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

}
