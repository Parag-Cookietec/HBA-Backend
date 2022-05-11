package gov.ifms.loc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;


/**
 * The Class LocChequeCancelDtlDto.
 *
 * @version v 1.0
 * @created 2021/03/06 17:42:56
 */
public class LocChequeCancelDtlDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NotNull
	private Long id;

	/** The hdr id. */
	@NotNull
	private Long hdrId;

	/** The advice id. */
	@NotNull
	private Long adviceId;

	/** The head wise id. */
	@NotNull
	private Long headWiseId;

	/** The head cancel chq amt. */
	@NotNull
	private Double headCancelChqAmt;

	/** The status id. */
	@NotNull
	private Long statusId;

	/** The wf id. */
	@NotNull
	private Long wfId;

	/** The wf role id. */
	@NotNull
	private Long wfRoleId;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the advice id.
	 *
	 * @return the advice id
	 */
	public Long getAdviceId() {
		return adviceId;
	}

	/**
	 * Sets the advice id.
	 *
	 * @param adviceId the new advice id
	 */
	public void setAdviceId(Long adviceId) {
		this.adviceId = adviceId;
	}

	/**
	 * Gets the head wise id.
	 *
	 * @return the head wise id
	 */
	public Long getHeadWiseId() {
		return headWiseId;
	}

	/**
	 * Sets the head wise id.
	 *
	 * @param headWiseId the new head wise id
	 */
	public void setHeadWiseId(Long headWiseId) {
		this.headWiseId = headWiseId;
	}

	/**
	

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Gets the head cancel chq amt.
	 *
	 * @return the headCancelChqAmt
	 */
	public Double getHeadCancelChqAmt() {
		return headCancelChqAmt;
	}

	/**
	 * Sets the head cancel chq amt.
	 *
	 * @param headCancelChqAmt the headCancelChqAmt to set
	 */
	public void setHeadCancelChqAmt(Double headCancelChqAmt) {
		this.headCancelChqAmt = headCancelChqAmt;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wf id
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the new wf id
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wf role id
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the new wf role id
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

}
