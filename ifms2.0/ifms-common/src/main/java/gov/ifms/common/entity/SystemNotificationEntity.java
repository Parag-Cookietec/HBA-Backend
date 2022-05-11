package gov.ifms.common.entity;

import gov.ifms.common.util.Constant;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "TNF_SN", schema = Constant.EDP_SCHEMA)
public class SystemNotificationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TNF_SN_ID")
	private Long tnfSnId;
	
	@Column(name = "TRN_ID")
	private Long trnId;
	
	@Column(name = "TRN_REF_NO")
	private String trnNo;
	
	@Column(name = "MENU_ID")
	private Long menuId;
	
	@Column(name = "EVENT_CATEGORY")
	private String eventCategory;
	
	@Column(name = "EVENT_NAME")
	private String eventName;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "SN_MSG")
	private String snMsg;
	
	@Column(name = "EXPIRE_DATE")
	private Date expireDate;
	
	/** The active status. */
	@Column(name = "ACTIVE_STATUS")
	private int activeStatus = 1;
	
	/** The assign to pou id. */
	@Column(name = "ASSIGN_TO_POU_ID")
	private Long assignToPouId;
	
	/** The assign by pou id. */
	@Column(name = "ASSIGN_BY_POU_ID")
	private Long assignByPouId;
	
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

	@Column(name="OFFICE_ID")
	private Long officeId;


	public SystemNotificationEntity() {
		super();
	}


	public Long getTnfSnId() {
		return tnfSnId;
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

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSnMsg() {
		return snMsg;
	}

	public void setSnMsg(String snMsg) {
		this.snMsg = snMsg;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
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

	public void setTnfSnId(Long tnfSnId) {
		this.tnfSnId = tnfSnId;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SystemNotificationEntity that = (SystemNotificationEntity) o;
		return activeStatus == that.activeStatus &&
				Objects.equals(tnfSnId, that.tnfSnId) &&
				Objects.equals(trnId, that.trnId) &&
				Objects.equals(trnNo, that.trnNo) &&
				Objects.equals(menuId, that.menuId) &&
				Objects.equals(eventCategory, that.eventCategory) &&
				Objects.equals(eventName, that.eventName) &&
				Objects.equals(status, that.status) &&
				Objects.equals(snMsg, that.snMsg) &&
				Objects.equals(expireDate, that.expireDate) &&
				Objects.equals(assignToPouId, that.assignToPouId) &&
				Objects.equals(assignByPouId, that.assignByPouId) &&
				Objects.equals(createdBy, that.createdBy) &&
				Objects.equals(createdDate, that.createdDate) &&
				Objects.equals(createdByPost, that.createdByPost) &&
				Objects.equals(updatedBy, that.updatedBy) &&
				Objects.equals(updatedDate, that.updatedDate) &&
				Objects.equals(updatedByPost, that.updatedByPost) &&
				Objects.equals(officeId, that.officeId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tnfSnId, trnId, trnNo, menuId, eventCategory, eventName, status, snMsg, expireDate, activeStatus, assignToPouId, assignByPouId, createdBy, createdDate, createdByPost, updatedBy, updatedDate, updatedByPost, officeId);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", SystemNotificationEntity.class.getSimpleName() + "[", "]")
				.add("tnfSnId=" + tnfSnId)
				.add("trnId=" + trnId)
				.add("trnNo='" + trnNo + "'")
				.add("menuId=" + menuId)
				.add("eventCategory='" + eventCategory + "'")
				.add("eventName='" + eventName + "'")
				.add("status='" + status + "'")
				.add("snMsg='" + snMsg + "'")
				.add("expireDate=" + expireDate)
				.add("activeStatus=" + activeStatus)
				.add("assignToPouId=" + assignToPouId)
				.add("assignByPouId=" + assignByPouId)
				.add("createdBy=" + createdBy)
				.add("createdDate=" + createdDate)
				.add("createdByPost=" + createdByPost)
				.add("updatedBy=" + updatedBy)
				.add("updatedDate=" + updatedDate)
				.add("updatedByPost=" + updatedByPost)
				.add("officeId=" + officeId)
				.toString();
	}
}
