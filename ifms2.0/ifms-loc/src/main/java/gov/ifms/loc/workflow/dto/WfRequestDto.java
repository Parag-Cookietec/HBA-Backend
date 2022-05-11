package gov.ifms.loc.workflow.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class WfRequestDto
 */
public class WfRequestDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@NotNull
	private transient Object userId;

	/** The post id. */
	@NotNull
	private Long postId;

	/** The office id. */
	@NotNull
	private Long officeId;
	
	/** The wf role ids. */
	@NotNull
	private List<Long> wfRoleIds;

	/** The trn id. */
	@NotNull
	private Long trnId;
	
	/** The menu id. */
	@NotNull
	private Long menuId;
	
	/** The wf action id. */
	private Long wfActionId;
	
	/** The next wf role id. */
	private Long nextWfRoleId;
	
	/** The event id. */
	private Long eventId;
	
	/** The lk POU id. */
	private Long lkPOUId;

	/** The condition. */
	private String condition;

	
	/** The branch id. */
	private Long branchId;
	/**
	 * Gets the condition.
	 *
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Sets the condition.
	 *
	 * @param condition the new condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}



	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the new event id
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the userId
	 */
	public Object getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Object userId) {
		this.userId = userId;
	}

	/**
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the wfRoleIds
	 */
	public List<Long> getWfRoleIds() {
		return wfRoleIds;
	}

	/**
	 * @param wfRoleIds the wfRoleIds to set
	 */
	public void setWfRoleIds(List<Long> wfRoleIds) {
		this.wfRoleIds = wfRoleIds;
	}

	/**
	 * @return the trnId
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the wfActionId
	 */
	public Long getWfActionId() {
		return wfActionId;
	}

	/**
	 * @param wfActionId the wfActionId to set
	 */
	public void setWfActionId(Long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * @return the nextWfRoleId
	 */
	public Long getNextWfRoleId() {
		return nextWfRoleId;
	}

	/**
	 * @param nextWfRoleId the nextWfRoleId to set
	 */
	public void setNextWfRoleId(Long nextWfRoleId) {
		this.nextWfRoleId = nextWfRoleId;
	}
	
	/**
	 * @return the lkPOUId
	 */
	public Long getLkPOUId() {
		return lkPOUId;
	}

	/**
	 * @param lkPOUId the lkPOUId to set
	 */
	public void setLkPOUId(Long lkPOUId) {
		this.lkPOUId = lkPOUId;
	}

	/**
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}



	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branchId, eventId, lkPOUId, menuId, nextWfRoleId, officeId, postId, trnId, userId,
				wfActionId, wfRoleIds);
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WfRequestDto)) {
			return false;
		}
		WfRequestDto other = (WfRequestDto) obj;
		return Objects.equals(branchId, other.branchId) && Objects.equals(eventId, other.eventId)
				&& Objects.equals(lkPOUId, other.lkPOUId) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(nextWfRoleId, other.nextWfRoleId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(postId, other.postId) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(userId, other.userId) && Objects.equals(wfActionId, other.wfActionId)
				&& Objects.equals(wfRoleIds, other.wfRoleIds);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"WfRequestDto [userId=%s, postId=%s, officeId=%s, wfRoleIds=%s, trnId=%s, menuId=%s, wfActionId=%s, nextWfRoleId=%s, eventId=%s, lkPOUId=%s, branchId=%s]",
				userId, postId, officeId, wfRoleIds, trnId, menuId, wfActionId, nextWfRoleId, eventId, lkPOUId,
				branchId);
	}


}
