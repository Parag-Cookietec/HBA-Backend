package gov.ifms.gst.dto;

import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsBalTrnsPendingTranswise8658ReportDto {
	@NativeQueryResultColumn(index = 0)
	private String gstinTmpidNo;
	@NativeQueryResultColumn(index = 1)
	private String cinNo;
	@NativeQueryResultColumn(index = 2)
	private Date cinDatetime;
	@NativeQueryResultColumn(index = 3)
	private Double sgstTotal;
	@NativeQueryResultColumn(index = 4)
	private Double challanAmount;
	@NativeQueryResultColumn(index = 5)
	private Date gstnFileDate;
	@NativeQueryResultColumn(index = 6)
	private Date paymentDate;
	@NativeQueryResultColumn(index = 7)
	private long bankRefNum;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public GstReportDtlsBalTrnsPendingTranswise8658ReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the gstinTmpidNo
	 */
	public String getGstinTmpidNo() {
		return gstinTmpidNo;
	}

	/**
	 * @param gstinTmpidNo the gstinTmpidNo to set
	 */
	public void setGstinTmpidNo(String gstinTmpidNo) {
		this.gstinTmpidNo = gstinTmpidNo;
	}

	/**
	 * @return the cinNo
	 */
	public String getCinNo() {
		return cinNo;
	}

	/**
	 * @param cinNo the cinNo to set
	 */
	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	/**
	 * @return the cinDatetime
	 */
	public Date getCinDatetime() {
		return cinDatetime;
	}

	/**
	 * @param cinDatetime the cinDatetime to set
	 */
	public void setCinDatetime(Date cinDatetime) {
		this.cinDatetime = cinDatetime;
	}

	/**
	 * @return the sgstTotal
	 */
	public Double getSgstTotal() {
		return sgstTotal;
	}

	/**
	 * @param sgstTotal the sgstTotal to set
	 */
	public void setSgstTotal(Double sgstTotal) {
		this.sgstTotal = sgstTotal;
	}

	/**
	 * @return the challanAmount
	 */
	public Double getChallanAmount() {
		return challanAmount;
	}

	/**
	 * @param challanAmount the challanAmount to set
	 */
	public void setChallanAmount(Double challanAmount) {
		this.challanAmount = challanAmount;
	}

	/**
	 * @return the gstnFileDate
	 */
	public Date getGstnFileDate() {
		return gstnFileDate;
	}

	/**
	 * @param gstnFileDate the gstnFileDate to set
	 */
	public void setGstnFileDate(Date gstnFileDate) {
		this.gstnFileDate = gstnFileDate;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the bankRefNum
	 */
	public long getBankRefNum() {
		return bankRefNum;
	}

	/**
	 * @param bankRefNum the bankRefNum to set
	 */
	public void setBankRefNum(long bankRefNum) {
		this.bankRefNum = bankRefNum;
	}
}
