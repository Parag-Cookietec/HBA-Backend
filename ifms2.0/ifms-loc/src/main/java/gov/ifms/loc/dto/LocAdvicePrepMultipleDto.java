package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAdvicePrepMultipleDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocAdvicePrepMultipleDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1331089443596129364L;

	/** The party name. */
	@NativeQueryResultColumn(index = 0)
	private String partyName;

	/** The chq amnt. */
	@NativeQueryResultColumn(index = 1)
	private Double chqAmnt;

	/** The epay amnt. */
	@NativeQueryResultColumn(index = 2)
	private Double epayAmnt;

	/** The amnt. */
	private Double amnt;

	/** The multiple list. */
	private List<LocAdvicePrepMultipleDto> multipleList;

	/**
	 * Gets the party name.
	 *
	 * @return the party name
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * Sets the party name.
	 *
	 * @param partyName the new party name
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * Gets the chq amnt.
	 *
	 * @return the chq amnt
	 */
	public Double getChqAmnt() {
		return chqAmnt;
	}

	/**
	 * Sets the chq amnt.
	 *
	 * @param chqAmnt the new chq amnt
	 */
	public void setChqAmnt(Double chqAmnt) {
		this.chqAmnt = chqAmnt;
	}

	/**
	 * Gets the epay amnt.
	 *
	 * @return the epay amnt
	 */
	public Double getEpayAmnt() {
		return epayAmnt;
	}

	/**
	 * Sets the epay amnt.
	 *
	 * @param epayAmnt the new epay amnt
	 */
	public void setEpayAmnt(Double epayAmnt) {
		this.epayAmnt = epayAmnt;
	}

	/**
	 * Gets the amnt.
	 *
	 * @return the amnt
	 */
	public Double getAmnt() {
		return amnt;
	}

	/**
	 * Sets the amnt.
	 *
	 * @param amnt the new amnt
	 */
	public void setAmnt(Double amnt) {
		this.amnt = amnt;
	}

	/**
	 * Gets the multiple list.
	 *
	 * @return the multiple list
	 */
	public List<LocAdvicePrepMultipleDto> getMultipleList() {
		return multipleList;
	}

	/**
	 * Sets the multiple list.
	 *
	 * @param multipleList the new multiple list
	 */
	public void setMultipleList(List<LocAdvicePrepMultipleDto> multipleList) {
		this.multipleList = multipleList;
	}
}
