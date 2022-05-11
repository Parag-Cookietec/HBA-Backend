package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocAdvicePartyDetaisDto.
 * 
 * @version v 1.0
 * @created 2021/02/23 14:53:51
 *
 */
public class LocAdviceMapEpymntEditViewDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The party name. */
	@NativeQueryResultColumn(index = 1)
	private String partyName;

	/** The bank account no. */
	@NativeQueryResultColumn(index = 2)
	private String bankAccountNo;

	/** The ifsc. */
	@NativeQueryResultColumn(index = 3)
	private String ifsc;

	/** The party amt. */
	@NativeQueryResultColumn(index = 4)
	private Double partyAmt;

	/** The lc advice id. */
	@NativeQueryResultColumn(index = 5)
	private Long lcAdviceId;

	/**
	 * LocAdvicePartyDetaisDto Constructor.
	 */
	public LocAdviceMapEpymntEditViewDto() {
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
	 * Gets the party name.
	 *
	 * @return the partyName
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * Sets the party name.
	 *
	 * @param partyName the partyName to set
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * Gets the bank account no.
	 *
	 * @return the bankAccountNo
	 */
	public String getBankAccountNo() {
		return bankAccountNo;
	}

	/**
	 * Sets the bank account no.
	 *
	 * @param bankAccountNo the bankAccountNo to set
	 */
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	/**
	 * Gets the ifsc.
	 *
	 * @return the ifsc
	 */
	public String getIfsc() {
		return ifsc;
	}

	/**
	 * Sets the ifsc.
	 *
	 * @param ifsc the ifsc to set
	 */
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	/**
	 * Gets the party amt.
	 *
	 * @return the partyAmt
	 */
	public Double getPartyAmt() {
		return partyAmt;
	}

	/**
	 * Sets the party amt.
	 *
	 * @param partyAmt the partyAmt to set
	 */
	public void setPartyAmt(Double partyAmt) {
		this.partyAmt = partyAmt;
	}

	/**
	 * Gets the lc advice id.
	 *
	 * @return the lcAdviceId
	 */
	public Long getLcAdviceId() {
		return lcAdviceId;
	}

	/**
	 * Sets the lc advice id.
	 *
	 * @param lcAdviceId the lcAdviceId to set
	 */
	public void setLcAdviceId(Long lcAdviceId) {
		this.lcAdviceId = lcAdviceId;
	}

}
