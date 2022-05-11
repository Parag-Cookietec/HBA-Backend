package gov.ifms.gst.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiPendingScrollwiseTransDetailsStatusReportDto {
	
	@NativeQueryResultColumn(index = 0)
	private String scrollNo;
	@NativeQueryResultColumn(index = 1)
	private Date scrollDate;
	@NativeQueryResultColumn(index = 2)
	private Double transactionAmount;
	@NativeQueryResultColumn(index = 3)
	private String referenceNumber;
	@NativeQueryResultColumn(index = 4)
	private String cinNo;
	@NativeQueryResultColumn(index = 5)
	private Date govtCreditDate;
	@NativeQueryResultColumn(index = 6)
	private String brn;
	@NativeQueryResultColumn(index = 7)
	private String ifscCode;
	@NativeQueryResultColumn(index = 8)
	private String moeCaseId;
	@NativeQueryResultColumn(index = 9)
	private String hoa;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public GstReportDtlsRbiPendingScrollwiseTransDetailsStatusReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the scrollNo
	 */
	public String getScrollNo() {
		return scrollNo;
	}

	/**
	 * @param scrollNo the scrollNo to set
	 */
	public void setScrollNo(String scrollNo) {
		this.scrollNo = scrollNo;
	}

	/**
	 * @return the scrollDate
	 */
	public Date getScrollDate() {
		return scrollDate;
	}

	/**
	 * @param scrollDate the scrollDate to set
	 */
	public void setScrollDate(Date scrollDate) {
		this.scrollDate = scrollDate;
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
	 * @return the referenceNumber
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * @param referenceNumber the referenceNumber to set
	 */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
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
	 * @return the govtCreditDate
	 */
	public Date getGovtCreditDate() {
		return govtCreditDate;
	}

	/**
	 * @param govtCreditDate the govtCreditDate to set
	 */
	public void setGovtCreditDate(Date govtCreditDate) {
		this.govtCreditDate = govtCreditDate;
	}

	/**
	 * @return the brn
	 */
	public String getBrn() {
		return brn;
	}

	/**
	 * @param brn the brn to set
	 */
	public void setBrn(String brn) {
		this.brn = brn;
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
}
