package gov.ifms.loc.dto;

import java.io.Serializable;

public class LocChequeToChequeEditViewDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The hdr id. */
	private Long hdrId;

	/** The action status. */
	private Integer actionStatus;

	/** The hdr id. */
	private Long headWiseId;

	public Long getHdrId() {
		return hdrId;
	}

	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	public Integer getActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(Integer actionStatus) {
		this.actionStatus = actionStatus;
	}

	public Long getHeadWiseId() {
		return headWiseId;
	}

	public void setHeadWiseId(Long headWiseId) {
		this.headWiseId = headWiseId;
	}

	
	

}
