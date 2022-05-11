package gov.ifms.gst.workflow.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsRbiScrollDetailsDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsRbiScrollDetailsDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public GstReportDtlsRbiScrollDetailsDto() {
		super();
	}

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
	private String hoe;

	public GstReportDtlsRbiScrollDetailsDto(String scrollNo, Date scrollDate, Double transactionAmount,
			String referenceNumber, String cinNo, Date govtCreditDate, String brn, String ifscCode, String moeCaseId,
			String hoe) {
		super();
		this.scrollNo = scrollNo;
		this.scrollDate = scrollDate;
		this.transactionAmount = transactionAmount;
		this.referenceNumber = referenceNumber;
		this.cinNo = cinNo;
		this.govtCreditDate = govtCreditDate;
		this.brn = brn;
		this.ifscCode = ifscCode;
		this.moeCaseId = moeCaseId;
		this.hoe = hoe;
	}

	public String getScrollNo() {
		return scrollNo;
	}

	public void setScrollNo(String scrollNo) {
		this.scrollNo = scrollNo;
	}

	public Date getScrollDate() {
		return scrollDate;
	}

	public void setScrollDate(Date scrollDate) {
		this.scrollDate = scrollDate;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public Date getGovtCreditDate() {
		return govtCreditDate;
	}

	public void setGovtCreditDate(Date govtCreditDate) {
		this.govtCreditDate = govtCreditDate;
	}

	public String getBrn() {
		return brn;
	}

	public void setBrn(String brn) {
		this.brn = brn;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getMoeCaseId() {
		return moeCaseId;
	}

	public void setMoeCaseId(String moeCaseId) {
		this.moeCaseId = moeCaseId;
	}

	public String getHoe() {
		return hoe;
	}

	public void setHoe(String hoe) {
		this.hoe = hoe;
	}

}
