package gov.ifms.edp.dto;

import java.io.Serializable;

/**
 * The Class EDPOfficeTransferDetails.
 * 
 * @version 1.0
 * @created 2020/09/30 11:20:00
 *
 */
public class EDPOfficeTransferDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The officeId. */
	private Long officeId;

	/** The cardexNo. */
	private String cardexNo;

	/** The ddoNo. */
	private String ddoNo;

	/** The officeName. */
	private String officeName;

	/** The districtId. */
	private Long districtId;

	/**
	 * Instantiates a new EDPOfficeTransferDetails dto.
	 */
	public EDPOfficeTransferDetails() {
		super();
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the cardexNo
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
}
