package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUCareerAdvanceAttachmentsDto.
 * 
 * @version v 1.0
 * @created 2020/01/17 11:30:23
 *
 */
public class PVUCommonAttachmentsDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private long id;


	/** Files Attachments */
	private List<AttachmentMasterDto> fileAttachment;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the fileAttachment
	 */
	public List<AttachmentMasterDto> getFileAttachment() {
		return fileAttachment;
	}

	/**
	 * @param fileAttachment the fileAttachment to set
	 */
	public void setFileAttachment(List<AttachmentMasterDto> fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	@Override
	public int hashCode() {
		return Objects.hash( fileAttachment, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUCommonAttachmentsDto)) {
			return false;
		}
		PVUCommonAttachmentsDto other = (PVUCommonAttachmentsDto) obj;
		return  Objects.equals(fileAttachment, other.fileAttachment) && id == other.id;
	}

	@Override
	public String toString() {
		return "PVUCommonAttachmentsDto [id=" + id + ", fileAttachment=" + fileAttachment
				+ "]";
	}

}
