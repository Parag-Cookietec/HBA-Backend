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
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LOCLocChequeCancelAttEntity.
 *
 * @version v 1.0
 * @created 2021/03/05 17:59:59
 */
@Entity
@Table(name = "TLOC_CHEQUE_CANCEL_ATT", schema = LocConstant.LOC_SCHEMA)
public class LocChequeCancelAttEntity extends BaseEntity implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** The Id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_ATTACH_ID")
	private Long Id;

	/** The trn id. */
	@Column(name = "TRN_ID")
	private Long trnId;

	/** The attachement id. */
	@Column(name = "ATTACHMENT_ID")
	private Long attachementId;

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
	@Column(name = "UPLOADED_FILE_SIZE")
	private Double uploadedFileSize;

	/** The uploaded by. */
	@Column(name = "UPLOADED_BY")
	private Long uploadedBy;

	/** The document id. */
	@Column(name = "DOCUMENT_ID")
	private String documentId;

	/** The category. */
	@Column(name = "CATEGORY")
	private Long category;

	/** The wf id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "WF_ID", nullable = false, referencedColumnName = "WF_ID")
	private LocChequeCancelWfEntity wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The action id. */
	@Column(name = "ACTION_ID")
	private Long actionId;

	/**
	 * LocChequeCancelAttEntity Constructor
	 */
	public LocChequeCancelAttEntity() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Id, trnId, attachementId, fileName, uploadedFilePath, uploadedFileName, uploadedFileSize,
				uploadedBy, documentId, category, category, wfId, wfRoleId, actionId);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LocChequeCancelAttEntity)) {
			return false;
		}

		LocChequeCancelAttEntity other = (LocChequeCancelAttEntity) obj;

		return Objects.equals(Id, other.Id) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(attachementId, other.attachementId) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath)
				&& Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFileSize, other.uploadedFileSize)
				&& Objects.equals(uploadedBy, other.uploadedBy) && Objects.equals(documentId, other.documentId)
				&& Objects.equals(category, other.category) && Objects.equals(wfId, other.wfId)
				&& Objects.equals(wfRoleId, other.wfRoleId) && Objects.equals(actionId, other.actionId);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "LocChequeCancelAttEntity [Id = " + Id + ",trnId = " + trnId + ",attachementId = " + attachementId
				+ ",fileName = " + fileName + ",uploadedFilePath = " + uploadedFilePath + ",uploadedFileName = "
				+ uploadedFileName + ",uploadedFileSize = " + uploadedFileSize + ",uploadedBy = " + uploadedBy
				+ ",documentId = " + documentId + ",category = " + category + ",category = " + category + ",wfId = "
				+ wfId + ",wfRoleId = " + wfRoleId + ",actionId = " + actionId + ",]";
	}

	/**
	 * getter setter
	 */

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

	public LocChequeCancelWfEntity getWfId() {
		return wfId;
	}

	public void setWfId(LocChequeCancelWfEntity wfId) {
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
