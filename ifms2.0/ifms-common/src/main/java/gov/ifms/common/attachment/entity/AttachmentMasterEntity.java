package gov.ifms.common.attachment.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.*;

import gov.ifms.common.util.Constant;

/**
 * The Class AttachmentMasterEntity.
 *
 * @version v 1.0
 * @created 2019/12/07 11:21:42
 *
 */
@Entity
@Table(name = "LK_MENU_ATT_TYP" , schema = Constant.WORKFLOW_SCHEMA )
public class AttachmentMasterEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_MENU_ATT_TYP_ID")
	private Long lkMenuAttTypId;

	@Column(name = "MENU_ID")
	private Long menuId;

	/** The attahcment type id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATT_TYPE_ID", referencedColumnName = "ATTACHMENT_ID")
	private MsAttachmentEntity attTypeId;

	@Column(name = "ATT_CTEGRY_ID")
	private Long attCtegryId;

	@Column(name = "FORMAT")
	private String format;

	@Column(name = "FILE_SIZE")
	private Integer fileSize;

	@Column(name = "UPLOAD_DIR_PATH")
	private String uploadDirectoryPath;

	@Column(name = "ACTIVE_STATUS")
	private int activeStatus = 1;


	/**
	 * DOIAttachmentMasterEntity Constructor
	 */
	public AttachmentMasterEntity() {
		super();
	}


	public AttachmentMasterEntity(Long lkMenuAttTypId, Long menuId, Long attCtegryId, String format,
								  Integer fileSize, String uploadDirectoryPath) {
		super();
		this.lkMenuAttTypId = lkMenuAttTypId;
		this.menuId = menuId;
		this.attCtegryId = attCtegryId;
		this.format = format;
		this.fileSize = fileSize;
		this.uploadDirectoryPath = uploadDirectoryPath;
	}

	public Long getLkMenuAttTypId() {
		return lkMenuAttTypId;
	}

	public void setLkMenuAttTypId(Long lkMenuAttTypId) {
		this.lkMenuAttTypId = lkMenuAttTypId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public MsAttachmentEntity getAttTypeId() {
		return attTypeId;
	}

	public void setAttTypeId(MsAttachmentEntity attTypeId) {
		this.attTypeId = attTypeId;
	}

	public Long getAttCtegryId() {
		return attCtegryId;
	}

	public void setAttCtegryId(Long attCtegryId) {
		this.attCtegryId = attCtegryId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getUploadDirectoryPath() {
		return uploadDirectoryPath;
	}

	public void setUploadDirectoryPath(String uploadDirectoryPath) {
		this.uploadDirectoryPath = uploadDirectoryPath;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AttachmentMasterEntity that = (AttachmentMasterEntity) o;
		return activeStatus == that.activeStatus &&
				Objects.equals(lkMenuAttTypId, that.lkMenuAttTypId) &&
				Objects.equals(menuId, that.menuId) &&
				Objects.equals(attTypeId, that.attTypeId) &&
				Objects.equals(attCtegryId, that.attCtegryId) &&
				Objects.equals(format, that.format) &&
				Objects.equals(fileSize, that.fileSize) &&
				Objects.equals(uploadDirectoryPath, that.uploadDirectoryPath);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lkMenuAttTypId, menuId, attTypeId, attCtegryId, format, fileSize, uploadDirectoryPath, activeStatus);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", AttachmentMasterEntity.class.getSimpleName() + "[", "]")
				.add("lkMenuAttTypId=" + lkMenuAttTypId)
				.add("menuId=" + menuId)
				.add("attTypeId=" + attTypeId)
				.add("attCtegryId=" + attCtegryId)
				.add("format='" + format + "'")
				.add("fileSize=" + fileSize)
				.add("uploadDirectoryPath='" + uploadDirectoryPath + "'")
				.add("activeStatus=" + activeStatus)
				.toString();
	}
}
