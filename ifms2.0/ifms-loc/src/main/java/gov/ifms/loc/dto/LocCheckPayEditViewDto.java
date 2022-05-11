package gov.ifms.loc.dto;

import java.io.Serializable;

public class LocCheckPayEditViewDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The hdr id. */
	private Long id;

	/** The action status. */
	private Integer actionStatus;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the actionStatus
	 */
	public Integer getActionStatus() {
		return actionStatus;
	}

	/**
	 * @param actionStatus the actionStatus to set
	 */
	public void setActionStatus(Integer actionStatus) {
		this.actionStatus = actionStatus;
	}

}
