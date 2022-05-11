package gov.ifms.edp.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPOfficeDto.
 */
@NativeQueryResultEntity
public class EDPOfficeDto {

	/** The office id. */
	@NativeQueryResultColumn(index = 0)
	private Long officeId;

	/** The office name. */
	@NativeQueryResultColumn(index = 1)
	private String officeName;

	/** The cardex no. */
	@NativeQueryResultColumn(index = 2)
	private String cardexNo;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 3)
	private String ddoNo;

	/** The status. */
	@NativeQueryResultColumn(index = 4)
	private String status;

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
