package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class LocAdviceReqDtlDto implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/** The id. */
	//@NativeQueryResultColumn(index = 0)
	//private Long id;
	
	/** The cheque Number */
	@NativeQueryResultColumn(index = 0)
	private String chequeAmount;

	
	/** The cheque Date */
	@NativeQueryResultColumn(index = 1)
	private Date chequeDate;

	
	/** The lc cheque Amt. */
	@NativeQueryResultColumn(index = 2)
	private Long chequeNo;
	
	/** The lc cheque Amt. */
	@NativeQueryResultColumn(index = 3)
	private String partyName;

	public String getChequeAmount() {
		return chequeAmount;
	}

	public void setChequeAmount(String chequeAmount) {
		this.chequeAmount = chequeAmount;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}


}
