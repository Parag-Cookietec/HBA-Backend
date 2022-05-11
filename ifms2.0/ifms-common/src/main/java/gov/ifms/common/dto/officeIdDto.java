package gov.ifms.common.dto;

import java.io.Serializable;

/**
 * The Class StatusDto.
 */
public class officeIdDto extends IdDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The officeId. */
	private Long officeId;

	/**
	 * Gets the office Id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	
	/**
	 * Sets the active status.
	 *
	 * @param activeStatus the activeStatus to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

}
