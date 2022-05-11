package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class EDPMsAttachmentDto.
 * 
 * @version 1.0
 * @created 2019/08/21 16:11:26
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EDPMsAttachmentDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The attachment id. */
	private long attachmentId;

	/** The attachment name. */
	@Size(max = 200)
	private String attachmentName;

	/** The attachmentr name guj. */
	@Size(max = 200)
	private String attachmentrNameGuj;

	/** The attachment code. */
	@Size(max = 10)
	private String attachmentCode;

	/** The attachment code guj. */
	@Size(max = 10)
	private String attachmentCodeGuj;

	/** The attachment desc. */
	@Size(max = 1000)
	private String attachmentDesc;

	/** The attachment desc guj. */
	@Size(max = 1000)
	private String attachmentDescGuj;

	/** The attahcment type. */
	@Min(1)
	private long attahcmentType;

	/** The file name. */
	@Size(max = 500)
	private String fileName;

	/** The file path. */
	@Size(max = 500)
	private String filePath;

	/** The file size. */
	@Size(max = 200)
	private String fileSize;
	
	/** The is mandatory. */
	private Long isMandatory;
	
	/** The is mandatory flag. */
	private boolean isMandatoryFlag;

	/**
	 * Instantiates a new EDP ms attachment dto.
	 */
	public EDPMsAttachmentDto() {
		super();
	}

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
	public long getAttahcmentType() {
		return attahcmentType;
	}

	/**
	 * Sets the attahcment type.
	 *
	 * @param attahcmentType the attahcmentType to set
	 */
	public void setAttahcmentType(long attahcmentType) {
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
	 * Gets the checks if is mandatory.
	 *
	 * @return the isMandatory
	 */
	public Long getIsMandatory() {
		return isMandatory;
	}

	/**
	 * Sets the checks if is mandatory.
	 *
	 * @param isMandatory the isMandatory to set
	 */
	public void setIsMandatory(Long isMandatory) {
		this.isMandatory = isMandatory;
	}
	
	/**
	 * Checks if is mandatory flag.
	 *
	 * @return the isMandatoryFlag
	 */
	public boolean isMandatoryFlag() {
		return isMandatoryFlag;
	}

	/**
	 * Sets the mandatory flag.
	 *
	 * @param isMandatoryFlag the isMandatoryFlag to set
	 */
	public void setMandatoryFlag(boolean isMandatoryFlag) {
		this.isMandatoryFlag = isMandatoryFlag;
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
		if (!(obj instanceof EDPMsAttachmentDto)) {
			return false;
		}
		EDPMsAttachmentDto other = (EDPMsAttachmentDto) obj;
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
