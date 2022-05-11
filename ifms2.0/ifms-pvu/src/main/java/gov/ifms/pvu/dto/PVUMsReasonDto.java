package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.edp.dto.BaseDto;

public class PVUMsReasonDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long reasonId;

	private String reasonName;

	private String reasonDesc;

	private String reasonType;

	/**
	 * PVUMsReasonDto Constructor
	 */
	public PVUMsReasonDto() {
		super();
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the reasonId
	 */
	public Long getReasonId() {
		return reasonId;
	}

	/**
	 * @param reasonId the reasonId to set
	 */
	public void setReasonId(Long reasonId) {
		this.reasonId = reasonId;
	}

	/**
	 * @return the reasonName
	 */
	public String getReasonName() {
		return reasonName;
	}

	/**
	 * @param reasonName the reasonName to set
	 */
	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

	/**
	 * @return the reasonDesc
	 */
	public String getReasonDesc() {
		return reasonDesc;
	}

	/**
	 * @param reasonDesc the reasonDesc to set
	 */
	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	/**
	 * @return the reasonType
	 */
	public String getReasonType() {
		return reasonType;
	}

	/**
	 * @param reasonType the reasonType to set
	 */
	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

}
