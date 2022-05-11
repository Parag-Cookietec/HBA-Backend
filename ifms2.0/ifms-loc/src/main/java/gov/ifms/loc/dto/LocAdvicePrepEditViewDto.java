package gov.ifms.loc.dto;

import java.io.Serializable;

/**
 * The Class LocChqBookEditViewDto.
 */
public class LocAdvicePrepEditViewDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The hdr id. */
	private Long hdrId;

	/** The action status. */
	private Integer actionStatus;

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdrId
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the hdrId to set
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the action status.
	 *
	 * @return the actionStatus
	 */
	public Integer getActionStatus() {
		return actionStatus;
	}

	/**
	 * Sets the action status.
	 *
	 * @param actionStatus the actionStatus to set
	 */
	public void setActionStatus(Integer actionStatus) {
		this.actionStatus = actionStatus;
	}

}
