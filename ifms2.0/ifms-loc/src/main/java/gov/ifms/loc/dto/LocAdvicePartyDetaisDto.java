package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocAdvicePartyDetaisDto.
 * 
 * @version v 1.0
 * @created 2021/02/23 14:53:51
 *
 */
public class LocAdvicePartyDetaisDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The party type. */
	private String partyType;

	/** The party name. */
	private String partyName;

	/** The bank account no. */
	private String bankAccountNo;

	/** The ifsc. */
	private String ifsc;

	/** The party amt. */
	private Double partyAmt;

	/** The lc advice id. */
	private Long lcAdviceId;

	/** The cheque Number */
	private String chequeNo;

	
	/** The cheque Date */
	private Date chequeDate;

	
	/** The lc cheque Amt. */
	private Long chequeAmount;

	/**
	 * LocAdvicePartyDetaisDto Constructor.
	 */
	public LocAdvicePartyDetaisDto() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the partyType
	 */
	public String getPartyType() {
		return partyType;
	}

	/**
	 * @param partyType the partyType to set
	 */
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	/**
	 * @return the partyName
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * @param partyName the partyName to set
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * @return the bankAccountNo
	 */
	public String getBankAccountNo() {
		return bankAccountNo;
	}

	/**
	 * @param bankAccountNo the bankAccountNo to set
	 */
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	/**
	 * @return the ifsc
	 */
	public String getIfsc() {
		return ifsc;
	}

	/**
	 * @param ifsc the ifsc to set
	 */
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	/**
	 * @return the partyAmt
	 */
	public Double getPartyAmt() {
		return partyAmt;
	}

	/**
	 * @param partyAmt the partyAmt to set
	 */
	public void setPartyAmt(Double partyAmt) {
		this.partyAmt = partyAmt;
	}

	/**
	 * @return the lcAdviceId
	 */
	public Long getLcAdviceId() {
		return lcAdviceId;
	}

	/**
	 * @param lcAdviceId the lcAdviceId to set
	 */
	public void setLcAdviceId(Long lcAdviceId) {
		this.lcAdviceId = lcAdviceId;
	}


	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public Long getChequeAmount() {
		return chequeAmount;
	}

	public void setChequeAmount(Long chequeAmount) {
		this.chequeAmount = chequeAmount;
	}

}
