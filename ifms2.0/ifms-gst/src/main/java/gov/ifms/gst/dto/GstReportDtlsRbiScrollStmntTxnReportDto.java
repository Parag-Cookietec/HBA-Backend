package gov.ifms.gst.dto;

import java.sql.Timestamp;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiScrollStmntTxnReportDto {

	@NativeQueryResultColumn(index = 0)
	private String scrollNO;
	@NativeQueryResultColumn(index = 1)
	private Timestamp scrollsDate;
	@NativeQueryResultColumn(index = 2)
	private Double transactionAmount;
	@NativeQueryResultColumn(index = 3)
	private String rbiRefNo;
	@NativeQueryResultColumn(index = 4)
	private String cin;
	@NativeQueryResultColumn(index = 5)
	private String bankRefNo;
	@NativeQueryResultColumn(index = 6)
	private String ifscCode;
	@NativeQueryResultColumn(index = 7)
	private String moeCaseId;
	@NativeQueryResultColumn(index = 8)
	private String hoa;
	@NativeQueryResultColumn(index = 9)
	private Timestamp govtActCreditDate;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsRbiScrollStmntTxnReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the scrollNO
	 */
	public String getScrollNO() {
		return scrollNO;
	}

	/**
	 * @param scrollNO the scrollNO to set
	 */
	public void setScrollNO(String scrollNO) {
		this.scrollNO = scrollNO;
	}

	/**
	 * @return the scrollsDate
	 */
	public Timestamp getScrollsDate() {
		return scrollsDate;
	}

	/**
	 * @param scrollsDate the scrollsDate to set
	 */
	public void setScrollsDate(Timestamp scrollsDate) {
		this.scrollsDate = scrollsDate;
	}

	/**
	 * @return the transactionAmount
	 */
	public Double getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the rbiRefNo
	 */
	public String getRbiRefNo() {
		return rbiRefNo;
	}

	/**
	 * @param rbiRefNo the rbiRefNo to set
	 */
	public void setRbiRefNo(String rbiRefNo) {
		this.rbiRefNo = rbiRefNo;
	}

	/**
	 * @return the cin
	 */
	public String getCin() {
		return cin;
	}

	/**
	 * @param cin the cin to set
	 */
	public void setCin(String cin) {
		this.cin = cin;
	}

	/**
	 * @return the bankRefNo
	 */
	public String getBankRefNo() {
		return bankRefNo;
	}

	/**
	 * @param bankRefNo the bankRefNo to set
	 */
	public void setBankRefNo(String bankRefNo) {
		this.bankRefNo = bankRefNo;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return the moeCaseId
	 */
	public String getMoeCaseId() {
		return moeCaseId;
	}

	/**
	 * @param moeCaseId the moeCaseId to set
	 */
	public void setMoeCaseId(String moeCaseId) {
		this.moeCaseId = moeCaseId;
	}

	/**
	 * @return the hoa
	 */
	public String getHoa() {
		return hoa;
	}

	/**
	 * @param hoa the hoa to set
	 */
	public void setHoa(String hoa) {
		this.hoa = hoa;
	}

	/**
	 * @return the govtActCreditDate
	 */
	public Timestamp getGovtActCreditDate() {
		return govtActCreditDate;
	}

	/**
	 * @param govtActCreditDate the govtActCreditDate to set
	 */
	public void setGovtActCreditDate(Timestamp govtActCreditDate) {
		this.govtActCreditDate = govtActCreditDate;
	}
}
