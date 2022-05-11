package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

public class PVUEmpEventsResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private Long eventId;
	private Long menuLinkId;

	@Override
	public int hashCode() {
		return Objects.hash(eventId, menuLinkId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmpEventsResponse)) {
			return false;
		}
		PVUEmpEventsResponse other = (PVUEmpEventsResponse) obj;
		return Objects.equals(eventId, other.eventId) && Objects.equals(menuLinkId, other.menuLinkId);
	}

	/**
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the menuLinkId
	 */
	public Long getMenuLinkId() {
		return menuLinkId;
	}

	/**
	 * @param menuLinkId the menuLinkId to set
	 */
	public void setMenuLinkId(Long menuLinkId) {
		this.menuLinkId = menuLinkId;
	}

}