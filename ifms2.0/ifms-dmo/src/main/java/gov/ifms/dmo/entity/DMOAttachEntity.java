package gov.ifms.dmo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_ATTACH", schema = Constant.DMO_SCHEMA)
public class DMOAttachEntity extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_ATTACH_ID")
	private Long id;
	
	@Column(name = "TRN_ID")
	private Long trnId;
	
	@Column(name = "ATTACHMENT_ID")
	private Long attachmentId; 
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "UPLOADED_FILE_PATH")
	private String uploadedFilePath;
	
	@Column(name = "UPLOADED_FILE_NAME")
	private String uploadedFileName;
	
	@Column(name = "UPLOADED_FILE_SIZE")
	private Double uploadedFileSize;
	
	@Column(name = "UPLOADED_BY")
	private Long uploadedBy;
	
	@Column(name = "DOCUMENT_ID")
	private String documentId;
	
	@Column(name = "CATEGORY")
	private Long category;
	
	@Column(name = "WF_ID")
	private Long wfId; //TODO
	
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;  //TODO

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the attachmentId
	 */
	public Long getAttachmentId() {
		return attachmentId;
	}

	/**
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
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
	
	

}
