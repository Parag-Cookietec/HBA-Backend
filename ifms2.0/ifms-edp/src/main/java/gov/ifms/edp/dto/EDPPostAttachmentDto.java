package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * The Class EDPPostAttachmentDto.
 */
public class EDPPostAttachmentDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post Attachment id. */
	private long postAttachmentId;

	/** The post id. */
	@Min(1)
	private long postId;

	/** The attachment id. */
	@Min(1)
	private long attachmentId;

	/** The trn no. */
	private String transactionnumber;

	/** The version id. */
	private int versionId;

	/** The file name. */
	@NotNull
	@Size(max = 200)
	private String fileName = StringUtils.EMPTY;

	/** The uploaded file path. */
	@NotNull
	@Size(max = 500)
	private String uploadedFilePath = StringUtils.EMPTY;

	/** The uploaded file name. */
	@NotNull
	@Size(max = 200)
	private String uploadedFileName = StringUtils.EMPTY;

	/** The uploaded by. */
	private long uploadedBy;

	/** The uploaded by name. */
	private String uploadedByName;

	/** The attachment name. */
	private String attachmentName;

	/** The uploaded file size. */
	private double uploadedFileSize;

	/** The file. */
	@NotNull
	private transient MultipartFile file = null;

	/**
	 * Gets the post Attachment id.
	 *
	 * @return the postAttachmentId
	 */
	public long getPostAttachmentId() {
		return postAttachmentId;
	}

	/**
	 * Sets the post Attachment id.
	 *
	 * @param postAttachmentId the postAttachmentId to set
	 */
	public void setPostAttachmentId(long postAttachmentId) {
		this.postAttachmentId = postAttachmentId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
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
	 * Gets the transactionnumber.
	 *
	 * @return the transactionnumber
	 */
	public String getTransactionnumber() {
		return transactionnumber;
	}

	/**
	 * Sets the transactionnumber.
	 *
	 * @param transactionnumber the transactionnumber to set
	 */
	public void setTransactionnumber(String transactionnumber) {
		this.transactionnumber = transactionnumber;
	}

	/**
	 * Gets the uploaded by.
	 *
	 * @return the uploadedBy
	 */
	public long getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * Sets the uploaded by.
	 *
	 * @param uploadedBy the uploadedBy to set
	 */
	public void setUploadedBy(long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the uploaded file path.
	 *
	 * @return the uploaded file path
	 */
	public String getUploadedFilePath() {
		return uploadedFilePath;
	}

	/**
	 * Sets the uploaded file path.
	 *
	 * @param uploadedFilePath the new uploaded file path
	 */
	public void setUploadedFilePath(String uploadedFilePath) {
		this.uploadedFilePath = uploadedFilePath;
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
	 * Gets the file.
	 *
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * Sets the file.
	 *
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * Instantiates a new EDP post attachment dto.
	 */
	public EDPPostAttachmentDto() {
		super();
	}

	/**
	 * Gets the uploaded by name.
	 *
	 * @return the uploadedByName
	 */
	public String getUploadedByName() {
		return uploadedByName;
	}

	/**
	 * Sets the uploaded by name.
	 *
	 * @param uploadedByName the uploadedByName to set
	 */
	public void setUploadedByName(String uploadedByName) {
		this.uploadedByName = uploadedByName;
	}

	/**
	 * Gets the uploaded file size.
	 *
	 * @return the uploadedFileSize
	 */
	public double getUploadedFileSize() {
		return uploadedFileSize;
	}

	/**
	 * Sets the uploaded file size.
	 *
	 * @param uploadedFileSize the uploadedFileSize to set
	 */
	public void setUploadedFileSize(double uploadedFileSize) {
		this.uploadedFileSize = uploadedFileSize;
	}

	/**
	 * Gets the version id.
	 *
	 * @return the version id
	 */
	public int getVersionId() {
		return versionId;
	}

	/**
	 * Sets the version id.
	 *
	 * @param versionId the new version id
	 */
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	/**
	 * Gets the uploaded file name.
	 *
	 * @return the uploaded file name
	 */
	public String getUploadedFileName() {
		return uploadedFileName;
	}

	/**
	 * Sets the uploaded file name.
	 *
	 * @param uploadedFileName the new uploaded file name
	 */
	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, attachmentName, fileName, postAttachmentId, postId, transactionnumber,
				uploadedBy, uploadedFileName, uploadedFilePath, versionId);
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
		if (!(obj instanceof EDPPostAttachmentDto)) {
			return false;
		}
		EDPPostAttachmentDto other = (EDPPostAttachmentDto) obj;
		return attachmentId == other.attachmentId && Objects.equals(attachmentName, other.attachmentName)
				&& Objects.equals(fileName, other.fileName) && postAttachmentId == other.postAttachmentId
				&& postId == other.postId && Objects.equals(transactionnumber, other.transactionnumber)
				&& uploadedBy == other.uploadedBy && Objects.equals(uploadedFileName, other.uploadedFileName)
				&& Objects.equals(uploadedFilePath, other.uploadedFilePath) && versionId == other.versionId;
	}

}
