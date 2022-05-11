package gov.ifms.common.dto;

import java.io.Serializable;

/**
 * The Class StatusDto.
 */
public class StatusDto extends IdDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The active status. */
	private int activeStatus;

	/**
	 * Gets the active status.
	 *
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * Sets the active status.
	 *
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

}
