/**
 * 
 */
package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocDistributionListDto.
 */
public class LocDistributionListDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ag id. */
	@NativeQueryResultColumn(index = 0)
	private String divisionCd;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 1)
	private String divisionName;

	/** The dtl id. */
	@NativeQueryResultColumn(index = 2)
	private String lcNumber;

	/** The authorization no. */
	@NativeQueryResultColumn(index = 3)
	private Date lcDate;

	/** The authorization dt. */
	@NativeQueryResultColumn(index = 4)
	private Long grantAmntCenter;

	/** The major head id. */
	@NativeQueryResultColumn(index = 5)
	private Long grantAmntState;

	/**
	 * Gets the division cd.
	 *
	 * @return the division cd
	 */
	public String getDivisionCd() {
		return divisionCd;
	}

	/**
	 * Sets the division cd.
	 *
	 * @param divisionCd the new division cd
	 */
	public void setDivisionCd(String divisionCd) {
		this.divisionCd = divisionCd;
	}

	/**
	 * Gets the division name.
	 *
	 * @return the division name
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * Sets the division name.
	 *
	 * @param divisionName the new division name
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * Gets the lc number.
	 *
	 * @return the lc number
	 */
	public String getLcNumber() {
		return lcNumber;
	}

	/**
	 * Sets the lc number.
	 *
	 * @param lcNumber the new lc number
	 */
	public void setLcNumber(String lcNumber) {
		this.lcNumber = lcNumber;
	}

	/**
	 * Gets the lc date.
	 *
	 * @return the lc date
	 */
	public Date getLcDate() {
		return lcDate;
	}

	/**
	 * Sets the lc date.
	 *
	 * @param lcDate the new lc date
	 */
	public void setLcDate(Date lcDate) {
		this.lcDate = lcDate;
	}

	/**
	 * Gets the grant amnt center.
	 *
	 * @return the grant amnt center
	 */
	public Long getGrantAmntCenter() {
		return grantAmntCenter;
	}

	/**
	 * Sets the grant amnt center.
	 *
	 * @param grantAmntCenter the new grant amnt center
	 */
	public void setGrantAmntCenter(Long grantAmntCenter) {
		this.grantAmntCenter = grantAmntCenter;
	}

	/**
	 * Gets the grant amnt state.
	 *
	 * @return the grant amnt state
	 */
	public Long getGrantAmntState() {
		return grantAmntState;
	}

	/**
	 * Sets the grant amnt state.
	 *
	 * @param grantAmntState the new grant amnt state
	 */
	public void setGrantAmntState(Long grantAmntState) {
		this.grantAmntState = grantAmntState;
	}

}
