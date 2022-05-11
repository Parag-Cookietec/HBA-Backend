package gov.ifms.loc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocChequeCancelDtlSdDto.
 *
 * @version v 1.0
 * @created 2021/03/06 17:39:31
 */
public class LocChequeCancelDtlSdDto extends BaseDto implements Serializable {

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

	/** The wf id. */
	@NotNull
	private Long wfId;

	/** The wf role id. */
	@NotNull
	private Long wfRoleId;

	/** The status id. */
	@NotNull
	private Long statusId;

	/**
	 * LocChequeCancelDtlSdDto Constructor.
	 */
	public LocChequeCancelDtlSdDto() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * Gets the advice id.
	 *
	 * @return the adviceId
	 */
	public Long getAdviceId() {
		return adviceId;
	}

	/**
	 * Sets the advice id.
	 *
	 * @param adviceId the adviceId to set
	 */
	public void setAdviceId(Long adviceId) {
		this.adviceId = adviceId;
	}

	/**
	 * Gets the head wise id.
	 *
	 * @return the headWiseId
	 */
	public Long getHeadWiseId() {
		return headWiseId;
	}

	/**
	 * Sets the head wise id.
	 *
	 * @param headWiseId the headWiseId to set
	 */
	public void setHeadWiseId(Long headWiseId) {
		this.headWiseId = headWiseId;
	}

	

	/**
	 * @return the headCancelChqAmt
	 */
	public Double getHeadCancelChqAmt() {
		return headCancelChqAmt;
	}

	/**
	 * @param headCancelChqAmt the headCancelChqAmt to set
	 */
	public void setHeadCancelChqAmt(Double headCancelChqAmt) {
		this.headCancelChqAmt = headCancelChqAmt;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

}
