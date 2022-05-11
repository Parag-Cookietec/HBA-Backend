package gov.ifms.edp.entity;

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

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsAttachmentEntity.
 */
@Entity
@Table(name = "MS_ATTACHMENTS", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsAttachmentEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The attachment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATTACHMENT_ID")
	private long attachmentId;

	/** The attachment name. */
	@Column(name = "ATTACHMENT_NAME")
	private String attachmentName;

	/** The attachmentr name guj. */
	@Column(name = "ATTACHMENT_NAME_GUJ")
	private String attachmentrNameGuj;

	/** The attachment code. */
	@Column(name = "ATTACHMENT_CODE")
	private String attachmentCode;

	/** The attachment code guj. */
	@Column(name = "ATTACHMENT_CODE_GUJ")
	private String attachmentCodeGuj;

	/** The attachment desc. */
	@Column(name = "ATTACHMENT_DESC")
	private String attachmentDesc;

	/** The attachment desc guj. */
	@Column(name = "ATTACHMENT_DESC_GUJ")
	private String attachmentDescGuj;

	/** The attahcment type. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATTACHMENT_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity attahcmentType;
	
	/** The file name. */
	@Column(name = "FILE_NAME")
	private String fileName;

	/** The file path. */
	@Column(name = "FILE_PATH")
	private String filePath;

	/** The file size. */
	@Column(name = "FILE_SIZE")
	private String fileSize;

	/** The is mandatory. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_MANDATORY", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isMandatory;
	
	/** The attach category. */
	@Column(name="ATTACH_CATEGORY")
	private Short attachCategory;

	/**
	 * Gets the attachment id.
	 *
	 * @return the attachmentId
	 */
	public long getAttachmentId() {
		return attachmentId;
	}

	/**
	 * Sets the attachment id.
	 *
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
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
	 * Gets the attachmentr name guj.
	 *
	 * @return the attachmentrNameGuj
	 */
	public String getAttachmentrNameGuj() {
		return attachmentrNameGuj;
	}

	/**
	 * Sets the attachmentr name guj.
	 *
	 * @param attachmentrNameGuj the attachmentrNameGuj to set
	 */
	public void setAttachmentrNameGuj(String attachmentrNameGuj) {
		this.attachmentrNameGuj = attachmentrNameGuj;
	}

	/**
	 * Gets the attachment code.
	 *
	 * @return the attachmentCode
	 */
	public String getAttachmentCode() {
		return attachmentCode;
	}

	/**
	 * Sets the attachment code.
	 *
	 * @param attachmentCode the attachmentCode to set
	 */
	public void setAttachmentCode(String attachmentCode) {
		this.attachmentCode = attachmentCode;
	}

	/**
	 * Gets the attachment code guj.
	 *
	 * @return the attachmentCodeGuj
	 */
	public String getAttachmentCodeGuj() {
		return attachmentCodeGuj;
	}

	/**
	 * Sets the attachment code guj.
	 *
	 * @param attachmentCodeGuj the attachmentCodeGuj to set
	 */
	public void setAttachmentCodeGuj(String attachmentCodeGuj) {
		this.attachmentCodeGuj = attachmentCodeGuj;
	}

	/**
	 * Gets the attachment desc.
	 *
	 * @return the attachmentDesc
	 */
	public String getAttachmentDesc() {
		return attachmentDesc;
	}

	/**
	 * Sets the attachment desc.
	 *
	 * @param attachmentDesc the attachmentDesc to set
	 */
	public void setAttachmentDesc(String attachmentDesc) {
		this.attachmentDesc = attachmentDesc;
	}

	/**
	 * Gets the attachment desc guj.
	 *
	 * @return the attachmentDescGuj
	 */
	public String getAttachmentDescGuj() {
		return attachmentDescGuj;
	}

	/**
	 * Sets the attachment desc guj.
	 *
	 * @param attachmentDescGuj the attachmentDescGuj to set
	 */
	public void setAttachmentDescGuj(String attachmentDescGuj) {
		this.attachmentDescGuj = attachmentDescGuj;
	}

	/**
	 * Gets the attahcment type.
	 *
	 * @return the attahcmentType
	 */
	public EDPLuLookUpInfoEntity getAttahcmentType() {
		return attahcmentType;
	}

	/**
	 * Sets the attahcment type.
	 *
	 * @param attahcmentType the attahcmentType to set
	 */
	public void setAttahcmentType(EDPLuLookUpInfoEntity attahcmentType) {
		this.attahcmentType = attahcmentType;
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
	 * Gets the file path.
	 *
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * Sets the file path.
	 *
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Gets the file size.
	 *
	 * @return the fileSize
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * Sets the file size.
	 *
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * Instantiates a new EDP ms attachment entity.
	 */
	public EDPMsAttachmentEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms attachment entity.
	 *
	 * @param attachmentId the attachment id
	 */
	public EDPMsAttachmentEntity(long attachmentId) {
		super();
		this.attachmentId = attachmentId;
	}

	/**
	 * Gets the checks if is mandatory.
	 *
	 * @return the isMandatory
	 */
	public EDPLuLookUpInfoEntity getIsMandatory() {
		return isMandatory;
	}

	/**
	 * Sets the checks if is mandatory.
	 *
	 * @param isMandatory the isMandatory to set
	 */
	public void setIsMandatory(EDPLuLookUpInfoEntity isMandatory) {
		this.isMandatory = isMandatory;
	}
	
	

	/**
	 * Gets the attach category.
	 *
	 * @return the attachCategory
	 */
	public Short getAttachCategory() {
		return attachCategory;
	}

	/**
	 * Sets the attach category.
	 *
	 * @param attachCategory the attachCategory to set
	 */
	public void setAttachCategory(Short attachCategory) {
		this.attachCategory = attachCategory;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentCode, attachmentCodeGuj, attachmentDesc, attachmentDescGuj, attachmentId,
				attachmentName, attachmentrNameGuj, attahcmentType, fileName, filePath, fileSize);
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
		if (!(obj instanceof EDPMsAttachmentEntity)) {
			return false;
		}
		EDPMsAttachmentEntity other = (EDPMsAttachmentEntity) obj;
		return Objects.equals(attachmentCode, other.attachmentCode)
				&& Objects.equals(attachmentCodeGuj, other.attachmentCodeGuj)
				&& Objects.equals(attachmentDesc, other.attachmentDesc)
				&& Objects.equals(attachmentDescGuj, other.attachmentDescGuj) && attachmentId == other.attachmentId
				&& Objects.equals(attachmentName, other.attachmentName)
				&& Objects.equals(attachmentrNameGuj, other.attachmentrNameGuj)
				&& attahcmentType == other.attahcmentType && Objects.equals(fileName, other.fileName)
				&& Objects.equals(filePath, other.filePath) && Objects.equals(fileSize, other.fileSize);
	}

}
