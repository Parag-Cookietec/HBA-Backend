package gov.ifms.doi.ac.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the TDOI_AC_STAMP_REGISTER database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcStampRegisterDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long stampRegId;

	private double availableAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String remarks;

	private double stampAmt;

	private String stampReferenceNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date transactionDt;

	private long transactionTypeId;

	public long getStampRegId() {
		return this.stampRegId;
	}

	public void setStampRegId(long stampRegId) {
		this.stampRegId = stampRegId;
	}

	public double getAvailableAmt() {
		return this.availableAmt;
	}

	public void setAvailableAmt(double availableAmt) {
		this.availableAmt = availableAmt;
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

	public double getStampAmt() {
		return this.stampAmt;
	}

	public void setStampAmt(double stampAmt) {
		this.stampAmt = stampAmt;
	}

	public String getStampReferenceNo() {
		return this.stampReferenceNo;
	}

	public void setStampReferenceNo(String stampReferenceNo) {
		this.stampReferenceNo = stampReferenceNo;
	}

	public Date getTransactionDt() {
		return this.transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}

	public long getTransactionTypeId() {
		return this.transactionTypeId;
	}

	public void setTransactionTypeId(long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

}
