package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The class PVUWFReqHistoryDto
 */
public class PVUWFReqHistoryDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long eventId;
	
	private Long menuId;
	
	private Long trnId;

	private Long officeId;
	
	private Long postId;
	
	private String[] wfRoleCode;

	private Integer[] wfRoles;

	public Integer[] getWfRoles() {
		return wfRoles;
	}

	public void setWfRoles(Integer[] wfRoles) {
		this.wfRoles = wfRoles;
	}

	public String[] getWfRoleCode() {
		return wfRoleCode;
	}

	public void setWfRoleCode(String[] wfRoleCode) {
		this.wfRoleCode = wfRoleCode;
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

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getTrnId() {
		return trnId;
	}

	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventId, menuId, trnId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUWFReqHistoryDto)) {
			return false;
		}
		PVUWFReqHistoryDto other = (PVUWFReqHistoryDto) obj;
		return Objects.equals(eventId, other.eventId) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(trnId, other.trnId);
	}

	@Override
	public String toString() {
		return String.format("PVUWFReqHistoryDto [eventId=%s, menuId=%s, trnId=%s, officeId=%s, postId=%s]", eventId,
				menuId, trnId, officeId, postId);
	}

}
