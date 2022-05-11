/**
 * 
 */
package gov.ifms.doi.legalentry.dto;

import java.io.File;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Rudra
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DOIJPALegalEntryAttachmentsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7881437868529595271L;

	private Long legalAttachmentID;
	
	private String attachmentType;
	private String attachmentFilename;
	private File file;
	private String attachmentUploadedBy;
	
	public Long getLegalAttachmentID() {
		return legalAttachmentID;
	}
	public void setLegalAttachmentID(Long legalAttachmentID) {
		this.legalAttachmentID = legalAttachmentID;
	}
	public String getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	public String getAttachmentFilename() {
		return attachmentFilename;
	}
	public void setAttachmentFilename(String attachmentFilename) {
		this.attachmentFilename = attachmentFilename;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getAttachmentUploadedBy() {
		return attachmentUploadedBy;
	}
	public void setAttachmentUploadedBy(String attachmentUploadedBy) {
		this.attachmentUploadedBy = attachmentUploadedBy;
	}
}
