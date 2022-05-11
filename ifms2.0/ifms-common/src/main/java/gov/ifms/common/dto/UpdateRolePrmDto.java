package gov.ifms.common.dto;

import java.io.Serializable;

/**
 * The Class StatusDto.
 */
public class UpdateRolePrmDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The active status. */

	/** The prm id. */
	private int userPrmId;

	/** The rdmap id. */
	private int rgMapId;

	

	public int getUserPrmId() {
		return userPrmId;
	}

	public void setUserPrmId(int userPrmId) {
		this.userPrmId = userPrmId;
	}

	public int getRgMapId() {
		return rgMapId;
	}

	public void setRgMapId(int rgMapId) {
		this.rgMapId = rgMapId;
	}

}
