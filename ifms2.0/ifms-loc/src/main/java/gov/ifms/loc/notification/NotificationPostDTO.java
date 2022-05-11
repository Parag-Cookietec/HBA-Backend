package gov.ifms.loc.notification;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class NotificationPostDTO.
 *
 * @author IFMS 2.0
 */
public class NotificationPostDTO {

	/** The trn id. */
	@NotNull
	private Long trnId;

	/** The menu id. */
	@NotNull
	private Long menuId;

	/** The event category. */
	@NotNull
	private String eventCategory;

	/** The event name. */
	@NotNull
	private String eventName;

	/** The created by. */
	@NotNull
	private Long createdBy;

	/** The pou id. */
	private Long pouId;

	/** The branch id. */
	private Long branchId;

	/** The expired date. */
	private Date expiredDate;

	/** The office id. */
	private Long officeId;

	/** The assign to POU id. */
	private String assignToPOUId;

	/**
	 * Gets the assign to POU id.
	 *
	 * @return the assign to POU id
	 */
	public String getAssignToPOUId() {
		return assignToPOUId;
	}

	/**
	 * Sets the assign to POU id.
	 *
	 * @param assignToPOUId the new assign to POU id
	 */
	public void setAssignToPOUId(String assignToPOUId) {
		this.assignToPOUId = assignToPOUId;
	}
	
	/** The role id. */
	private Long roleId;

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the trn id.
	 *
	 * @return the trn id
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the new trn id
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the event category.
	 *
	 * @return the event category
	 */
	public String getEventCategory() {
		return eventCategory;
	}

	/**
	 * Sets the event category.
	 *
	 * @param eventCategory the new event category
	 */
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the event name
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets the event name.
	 *
	 * @param eventName the new event name
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the branch id.
	 *
	 * @return the branch id
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the new branch id
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * Gets the pou id.
	 *
	 * @return the pou id
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the new pou id
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	/**
	 * Gets the expired date.
	 *
	 * @return the expired date
	 */
	public Date getExpiredDate() {
		return expiredDate;
	}

	/**
	 * Sets the expired date.
	 *
	 * @param expiredDate the new expired date
	 */
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NotificationPostDTO that = (NotificationPostDTO) o;
		return Objects.equals(trnId, that.trnId) &&
				Objects.equals(menuId, that.menuId) &&
				Objects.equals(eventCategory, that.eventCategory) &&
				Objects.equals(eventName, that.eventName) &&
				Objects.equals(createdBy, that.createdBy) &&
				Objects.equals(pouId, that.pouId) &&
				Objects.equals(branchId, that.branchId) &&
				Objects.equals(expiredDate, that.expiredDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(trnId, menuId, eventCategory, eventName, createdBy, pouId, branchId, expiredDate);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", NotificationPostDTO.class.getSimpleName() + "[", "]")
				.add("trnId=" + trnId)
				.add("menuId=" + menuId)
				.add("eventCategory='" + eventCategory + "'")
				.add("eventName='" + eventName + "'")
				.add("createdBy=" + createdBy)
				.add("pouId=" + pouId)
				.add("branchId=" + branchId)
				.add("expiredDate=" + expiredDate)
				.toString();
	}
}
