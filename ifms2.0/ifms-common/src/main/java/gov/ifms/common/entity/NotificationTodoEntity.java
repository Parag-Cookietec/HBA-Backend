package gov.ifms.common.entity;

import gov.ifms.common.util.Constant;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "TNF_TODO", schema = Constant.EDP_SCHEMA)
public class NotificationTodoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TNF_TODO_ID")
	private Long tnfTodoId;

	@Column(name = "LISTING_MENU_ID")
	private Long listingMenuId;

	@Column(name = "EVENT_CATEGORY")
	private String eventCategory;

	@Column(name = "EVENT_NAME")
	private String eventName;

	@Column(name = "TRN_REF_NO")
	private String trnNo;

	@Column(name = "TRN_ID")
	private Long trnId;

	@Column(name = "BRANCH_ID")
	private Long branchId;

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


	@Column(name = "WF_ROLE")
	private Long wfRole;


	@Column(name = "OFFICE_ID")
	private Long officeId;

	@Column(name = "ASSIGN_DATE")
	private Date assignDate;


	public void setTnfTodoId(Long tnfTodoId) {
		this.tnfTodoId = tnfTodoId;
	}

	public Long getWfRole() {
		return wfRole;
	}

	public void setWfRole(Long wfRole) {
		this.wfRole = wfRole;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	public NotificationTodoEntity() {
		super();
	}



	public Long getTnfTodoId() {
		return tnfTodoId;
	}

	public Long getListingMenuId() {
		return listingMenuId;
	}

	public void setListingMenuId(Long listingMenuId) {
		this.listingMenuId = listingMenuId;
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

	public String getTrnNo() {
		return trnNo;
	}

	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	public Long getTrnId() {
		return trnId;
	}

	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NotificationTodoEntity that = (NotificationTodoEntity) o;
		return activeStatus == that.activeStatus &&
				Objects.equals(tnfTodoId, that.tnfTodoId) &&
				Objects.equals(listingMenuId, that.listingMenuId) &&
				Objects.equals(eventCategory, that.eventCategory) &&
				Objects.equals(eventName, that.eventName) &&
				Objects.equals(trnNo, that.trnNo) &&
				Objects.equals(trnId, that.trnId) &&
				Objects.equals(branchId, that.branchId) &&
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
		return Objects.hash(tnfTodoId, listingMenuId, eventCategory, eventName, trnNo, trnId, branchId, activeStatus, assignToPouId, assignByPouId, createdBy, createdDate, createdByPost, updatedBy, updatedDate, updatedByPost);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", NotificationTodoEntity.class.getSimpleName() + "[", "]")
				.add("tnfTodoId=" + tnfTodoId)
				.add("listingMenuId=" + listingMenuId)
				.add("eventCategory='" + eventCategory + "'")
				.add("eventName='" + eventName + "'")
				.add("trnNo='" + trnNo + "'")
				.add("trnId=" + trnId)
				.add("branchId=" + branchId)
				.add("activeStatus=" + activeStatus)
				.add("assignToPouId=" + assignToPouId)
				.add("assignByPouId=" + assignByPouId)
				.add("createdBy=" + createdBy)
				.add("createdDate=" + createdDate)
				.add("createdByPost=" + createdByPost)
				.add("updatedBy=" + updatedBy)
				.add("updatedDate=" + updatedDate)
				.add("updatedByPost=" + updatedByPost)
				.toString();
	}
}
