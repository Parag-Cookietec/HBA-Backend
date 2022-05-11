package gov.ifms.common.entity;

import gov.ifms.common.util.Constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "TNF_NOTIFICATION", schema = Constant.EDP_SCHEMA)
public class NotificationTransactionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TNF_TRN_ID")
	private Long tnfTrnId;
	
	@Column(name = "TRN_ID")
	private Long trnId;
	
	@Column(name = "TRN_REF_NO")
	private String trnNo;
	
	@Column(name = "EVENT_CATEGORY")
	private String eventCategory;
	
	@Column(name = "EVENT_NAME")
	private String eventName;
	
	@Column(name = "MENU_ID")
	private Long menuId;
	
	@Column(name = "TO_EMAIL_IDS")
	private String toEmailIds;
	
	@Column(name = "CC_EMAIL_IDS")
	private String ccEmailIds;
	
	@Column(name = "BCC_EMAIL_IDS")
	private String bccEmailIds;
	
	@Column(name = "TO_MOBILES")
	private String toMobiles;
	
	@Column(name = "TO_SN_POU_IDS")
	private String toSnPOUIds;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "FILE_ATTACHMENT_ID")
	private String fileAttachmentId;
	
	@Column(name = "UPLOADED_FILE_PATH")
	private String uploadedFilePath;
	
	/** The assign to pou id. */
	@Column(name = "ASSIGN_TO_POU_ID")
	private Long assignToPouId;
	
	/** The assign by pou id. */
	@Column(name = "ASSIGN_BY_POU_ID")
	private Long assignByPouId;
	
	/** The active status. */
	@Column(name = "ACTIVE_STATUS")
	private int activeStatus = 1;
	
	@Column(name = "CREATED_BY", updatable = false)
	private Long createdBy;

	/** The created date. */
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	/** The created by post. */
	@Column(name = "CREATED_BY_POST", updatable = false)
	private Long createdByPost;
	
	/** The updated by. */
	@Column(name = "UPDATED_BY")
	private Long updatedBy;

	/** The updated date. */
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	/** The updated by post. */
	@Column(name = "UPDATED_BY_POST")
	private Long updatedByPost;

	public NotificationTransactionEntity() {
		super();
	}

	public Long getTnfTrnId() {
		return tnfTrnId;
	}

	public Long getTrnId() {
		return trnId;
	}

	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	public String getTrnNo() {
		return trnNo;
	}

	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getToEmailIds() {
		return toEmailIds;
	}

	public void setToEmailIds(String toEmailIds) {
		this.toEmailIds = toEmailIds;
	}

	public String getCcEmailIds() {
		return ccEmailIds;
	}

	public void setCcEmailIds(String ccEmailIds) {
		this.ccEmailIds = ccEmailIds;
	}

	public String getBccEmailIds() {
		return bccEmailIds;
	}

	public void setBccEmailIds(String bccEmailIds) {
		this.bccEmailIds = bccEmailIds;
	}

	public String getToMobiles() {
		return toMobiles;
	}

	public void setToMobiles(String toMobiles) {
		this.toMobiles = toMobiles;
	}

	public String getToSnPOUIds() {
		return toSnPOUIds;
	}

	public void setToSnPOUIds(String toSnPOUIds) {
		this.toSnPOUIds = toSnPOUIds;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileAttachmentId() {
		return fileAttachmentId;
	}

	public void setFileAttachmentId(String fileAttachmentId) {
		this.fileAttachmentId = fileAttachmentId;
	}

	public String getUploadedFilePath() {
		return uploadedFilePath;
	}

	public void setUploadedFilePath(String uploadedFilePath) {
		this.uploadedFilePath = uploadedFilePath;
	}

	public Long getAssignToPouId() {
		return assignToPouId;
	}

	public void setAssignToPouId(Long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	public Long getAssignByPouId() {
		return assignByPouId;
	}

	public void setAssignByPouId(Long assignByPouId) {
		this.assignByPouId = assignByPouId;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedByPost() {
		return createdByPost;
	}

	public void setCreatedByPost(Long createdByPost) {
		this.createdByPost = createdByPost;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getUpdatedByPost() {
		return updatedByPost;
	}

	public void setUpdatedByPost(Long updatedByPost) {
		this.updatedByPost = updatedByPost;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NotificationTransactionEntity that = (NotificationTransactionEntity) o;
		return activeStatus == that.activeStatus &&
				Objects.equals(tnfTrnId, that.tnfTrnId) &&
				Objects.equals(trnId, that.trnId) &&
				Objects.equals(trnNo, that.trnNo) &&
				Objects.equals(eventCategory, that.eventCategory) &&
				Objects.equals(eventName, that.eventName) &&
				Objects.equals(menuId, that.menuId) &&
				Objects.equals(toEmailIds, that.toEmailIds) &&
				Objects.equals(ccEmailIds, that.ccEmailIds) &&
				Objects.equals(bccEmailIds, that.bccEmailIds) &&
				Objects.equals(toMobiles, that.toMobiles) &&
				Objects.equals(toSnPOUIds, that.toSnPOUIds) &&
				Objects.equals(fileName, that.fileName) &&
				Objects.equals(fileAttachmentId, that.fileAttachmentId) &&
				Objects.equals(uploadedFilePath, that.uploadedFilePath) &&
				Objects.equals(assignToPouId, that.assignToPouId) &&
				Objects.equals(assignByPouId, that.assignByPouId) &&
				Objects.equals(createdBy, that.createdBy) &&
				Objects.equals(createdDate, that.createdDate) &&
				Objects.equals(createdByPost, that.createdByPost) &&
				Objects.equals(updatedBy, that.updatedBy) &&
				Objects.equals(updatedDate, that.updatedDate) &&
				Objects.equals(updatedByPost, that.updatedByPost);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tnfTrnId, trnId, trnNo, eventCategory, eventName, menuId, toEmailIds, ccEmailIds, bccEmailIds, toMobiles, toSnPOUIds, fileName, fileAttachmentId, uploadedFilePath, assignToPouId, assignByPouId, activeStatus, createdBy, createdDate, createdByPost, updatedBy, updatedDate, updatedByPost);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", NotificationTransactionEntity.class.getSimpleName() + "[", "]")
				.add("tnfTrnId=" + tnfTrnId)
				.add("trnId=" + trnId)
				.add("trnNo='" + trnNo + "'")
				.add("eventCategory='" + eventCategory + "'")
				.add("eventName='" + eventName + "'")
				.add("menuId=" + menuId)
				.add("toEmailIds='" + toEmailIds + "'")
				.add("ccEmailIds='" + ccEmailIds + "'")
				.add("bccEmailIds='" + bccEmailIds + "'")
				.add("toMobiles='" + toMobiles + "'")
				.add("toSnPOUIds='" + toSnPOUIds + "'")
				.add("fileName='" + fileName + "'")
				.add("fileAttachmentId='" + fileAttachmentId + "'")
				.add("uploadedFilePath='" + uploadedFilePath + "'")
				.add("assignToPouId=" + assignToPouId)
				.add("assignByPouId=" + assignByPouId)
				.add("activeStatus=" + activeStatus)
				.add("createdBy=" + createdBy)
				.add("createdDate=" + createdDate)
				.add("createdByPost=" + createdByPost)
				.add("updatedBy=" + updatedBy)
				.add("updatedDate=" + updatedDate)
				.add("updatedByPost=" + updatedByPost)
				.toString();
	}
}
