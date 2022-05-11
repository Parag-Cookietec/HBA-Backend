package gov.ifms.doi.ac.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the TDOI_AC_CHEQUE_REGISTER database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcChequeRegisterDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long chequeRegId;

	private double billAmount;

	private String billNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date cashbookEntryDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeEpayDt;

	private long chequeNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date encahDelivDt;

	private String epaymentNo;

	private String messengerName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String remarks;

	public long getChequeRegId() {
		return this.chequeRegId;
	}

	public void setChequeRegId(long chequeRegId) {
		this.chequeRegId = chequeRegId;
	}

	public double getBillAmount() {
		return this.billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getCashbookEntryDt() {
		return this.cashbookEntryDt;
	}

	public void setCashbookEntryDt(Date cashbookEntryDt) {
		this.cashbookEntryDt = cashbookEntryDt;
	}

	public Date getChequeEpayDt() {
		return this.chequeEpayDt;
	}

	public void setChequeEpayDt(Date chequeEpayDt) {
		this.chequeEpayDt = chequeEpayDt;
	}

	public long getChequeNo() {
		return this.chequeNo;
	}

	public void setChequeNo(long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getEncahDelivDt() {
		return this.encahDelivDt;
	}

	public void setEncahDelivDt(Date encahDelivDt) {
		this.encahDelivDt = encahDelivDt;
	}

	public String getEpaymentNo() {
		return this.epaymentNo;
	}

	public void setEpaymentNo(String epaymentNo) {
		this.epaymentNo = epaymentNo;
	}

	public String getMessengerName() {
		return this.messengerName;
	}

	public void setMessengerName(String messengerName) {
		this.messengerName = messengerName;
	}

	public Date getReferenceDt() {
		return this.referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
