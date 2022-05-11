package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocDistGrantDto.
 */
@NativeQueryResultEntity
public class LocDistGrantDto implements Serializable {
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The div id. */
	@NativeQueryResultColumn(index = 0)
	private Long divId;

	/** The div name. */
	@NativeQueryResultColumn(index = 1)
	private String divName;

	/** The div code. */
	@NativeQueryResultColumn(index = 2)
	private String divCode;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 3)
	private Long hdrId;

	/** The lc no. */
	@NativeQueryResultColumn(index = 4)
	private String lcNo;

	/** The entry type. */
	@NativeQueryResultColumn(index = 5)
	private String entryType;

	/** The balance lc amt. */
	@NativeQueryResultColumn(index = 6)
	private Double balanceLcAmt;

	/** The lc issue date. */
	@NativeQueryResultColumn(index = 7)
	private Date lcIssueDate;

	/** The g status. */
	@NativeQueryResultColumn(index = 8)
	private String gStatus;

	/**
	 * Gets the div id.
	 *
	 * @return the div id
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the new div id
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Gets the div name.
	 *
	 * @return the div name
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * Sets the div name.
	 *
	 * @param divName the new div name
	 */
	public void setDivName(String divName) {
		this.divName = divName;
	}

	/**
	 * Gets the div code.
	 *
	 * @return the div code
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the new div code
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
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
	 * Gets the lc no.
	 *
	 * @return the lc no
	 */
	public String getLcNo() {
		return lcNo;
	}

	/**
	 * Sets the lc no.
	 *
	 * @param lcNo the new lc no
	 */
	public void setLcNo(String lcNo) {
		this.lcNo = lcNo;
	}

	/**
	 * Gets the entry type.
	 *
	 * @return the entry type
	 */
	public String getEntryType() {
		return entryType;
	}

	/**
	 * Sets the entry type.
	 *
	 * @param entryType the new entry type
	 */
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	/**
	 * Gets the balance lc amt.
	 *
	 * @return the balance lc amt
	 */
	public Double getBalanceLcAmt() {
		return balanceLcAmt;
	}

	/**
	 * Sets the balance lc amt.
	 *
	 * @param balanceLcAmt the new balance lc amt
	 */
	public void setBalanceLcAmt(Double balanceLcAmt) {
		this.balanceLcAmt = balanceLcAmt;
	}

	/**
	 * Gets the lc issue date.
	 *
	 * @return the lc issue date
	 */
	public Date getLcIssueDate() {
		return lcIssueDate;
	}

	/**
	 * Sets the lc issue date.
	 *
	 * @param lcIssueDate the new lc issue date
	 */
	public void setLcIssueDate(Date lcIssueDate) {
		this.lcIssueDate = lcIssueDate;
	}

	/**
	 * Gets the g status.
	 *
	 * @return the g status
	 */
	public String getgStatus() {
		return gStatus;
	}

	/**
	 * Sets the g status.
	 *
	 * @param gStatus the new g status
	 */
	public void setgStatus(String gStatus) {
		this.gStatus = gStatus;
	}

}
