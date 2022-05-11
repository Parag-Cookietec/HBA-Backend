package gov.ifms.common.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author IFMS 2.0
 *
 */
public class NotificationPostDTO {

	@NotNull
	private Long trnId;

	@NotNull
	private Long menuId;

	@NotNull
	private String eventCategory;

	@NotNull
	private String eventName;

	@NotNull
	private Long createdBy;

	private Long pouId;

	private Long branchId;

	private Date expiredDate;

	private Long officeId;

	private String assignToPOUId;

	public String getAssignToPOUId() {
		return assignToPOUId;
	}

	public void setAssignToPOUId(String assignToPOUId) {
		this.assignToPOUId = assignToPOUId;
	}
	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public Long getTrnId() {
		return trnId;
	}

	public void setTrnId(Long trnId) {
		this.trnId = trnId;
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Long getPouId() {
		return pouId;
	}

	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

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
