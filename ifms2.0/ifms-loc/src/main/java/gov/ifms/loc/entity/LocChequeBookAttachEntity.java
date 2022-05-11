package gov.ifms.loc.entity;

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

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocChqDtlAttachEntity.
 * 
 * @version v 1.0
 * @created 2021/01/12 15:21:32
 *
 */
@Entity
@Table(name = "TLOC_LC_CHEQUEBOOK_ATTACH", schema = LocConstant.LOC_SCHEMA)
public class LocChequeBookAttachEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_ATTACH_ID")
	private Long id;

	/** The trn id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TRN_ID", referencedColumnName = "LC_CHEQUEBOOK_ID")
	private LocChequeBookHdrEntity trnId;

	/** The attachment id. */
	@Column(name = "ATTACHMENT_ID")
	private Long attachmentId;

	/** The file name. */
	@Column(name = "FILE_NAME")
	private String fileName;

	/** The up file path. */
	@Column(name = "UPLOADED_FILE_PATH")
	private String upFilePath;

	/** The up file name. */
	@Column(name = "UPLOADED_FILE_NAME")
	private String upFileName;

	/** The up file size. */
	@Column(name = "UPLOADED_FILE_SIZE")
	private Long upFileSize;

	/** The uploaded by. */
	@Column(name = "UPLOADED_BY")
	private Long uploadedBy;

	/** The doc id. */
	@Column(name = "DOCUMENT_ID")
	private String docId;

	/** The category. */
	@Column(name = "CATEGORY")
	private Long category;

	/** The wf id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "WF_ID", referencedColumnName = "WF_ID")
	private LocChequeBookWfEntity wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The action id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ACTION_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity actionId;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/**
	 * LocChqDtlAttachEntity Constructor.
	 */
	public LocChequeBookAttachEntity() {
		super();
	}

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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the upFilePath
	 */
	public String getUpFilePath() {
		return upFilePath;
	}

	/**
	 * @param upFilePath the upFilePath to set
	 */
	public void setUpFilePath(String upFilePath) {
		this.upFilePath = upFilePath;
	}

	/**
	 * @return the upFileName
	 */
	public String getUpFileName() {
		return upFileName;
	}

	/**
	 * @param upFileName the upFileName to set
	 */
	public void setUpFileName(String upFileName) {
		this.upFileName = upFileName;
	}

	/**
	 * @return the upFileSize
	 */
	public Long getUpFileSize() {
		return upFileSize;
	}

	/**
	 * @param upFileSize the upFileSize to set
	 */
	public void setUpFileSize(Long upFileSize) {
		this.upFileSize = upFileSize;
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
	 * @return the docId
	 */
	public String getDocId() {
		return docId;
	}

	/**
	 * @param docId the docId to set
	 */
	public void setDocId(String docId) {
		this.docId = docId;
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
	 * @return the trnId
	 */
	public LocChequeBookHdrEntity getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(LocChequeBookHdrEntity trnId) {
		this.trnId = trnId;
	}

	/**
	 * @return the wfId
	 */
	public LocChequeBookWfEntity getWfId() {
		return wfId;
	}

	/**
	 * @param wfId the wfId to set
	 */
	public void setWfId(LocChequeBookWfEntity wfId) {
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
	public EDPLuLookUpInfoEntity getActionId() {
		return actionId;
	}

	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(EDPLuLookUpInfoEntity actionId) {
		this.actionId = actionId;
	}

	/**
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(actionId, attachmentId, category, docId, fileName, id, statusId, trnId, upFileName,
				upFilePath, upFileSize, uploadedBy, wfId, wfRoleId);
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
		if (!(obj instanceof LocChequeBookAttachEntity)) {
			return false;
		}
		LocChequeBookAttachEntity other = (LocChequeBookAttachEntity) obj;
		return Objects.equals(actionId, other.actionId) && Objects.equals(attachmentId, other.attachmentId)
				&& Objects.equals(category, other.category) && Objects.equals(docId, other.docId)
				&& Objects.equals(fileName, other.fileName) && Objects.equals(id, other.id)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(upFileName, other.upFileName) && Objects.equals(upFilePath, other.upFilePath)
				&& Objects.equals(upFileSize, other.upFileSize) && Objects.equals(uploadedBy, other.uploadedBy)
				&& Objects.equals(wfId, other.wfId) && Objects.equals(wfRoleId, other.wfRoleId);
	}

}
