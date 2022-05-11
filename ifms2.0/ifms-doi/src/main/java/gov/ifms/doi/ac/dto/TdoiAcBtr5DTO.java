package gov.ifms.doi.ac.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the TDOI_AC_BTR_5 database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcBtr5DTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long btr5RegId;

	private long bankId;

	private String bankName;

	private long branchId;

	private String branchName;

	private String chequeAmtInWords;

	private double chequeDdAmt;

	private long chequeDdCashId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDdDt;

	private long chequeDdNo;

	private long finYearId;

	private String letterNo;

	private String partyAddress;

	private String partyName;

	private long partyTypeId;

	private String receiptNo;

	private long recvFrmTypeId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date transactionDt;

	public long getBtr5RegId() {
		return this.btr5RegId;
	}

	public void setBtr5RegId(long btr5RegId) {
		this.btr5RegId = btr5RegId;
	}

	public long getBankId() {
		return this.bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getBranchId() {
		return this.branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getChequeAmtInWords() {
		return this.chequeAmtInWords;
	}

	public void setChequeAmtInWords(String chequeAmtInWords) {
		this.chequeAmtInWords = chequeAmtInWords;
	}

	public double getChequeDdAmt() {
		return this.chequeDdAmt;
	}

	public void setChequeDdAmt(double chequeDdAmt) {
		this.chequeDdAmt = chequeDdAmt;
	}

	public long getChequeDdCashId() {
		return this.chequeDdCashId;
	}

	public void setChequeDdCashId(long chequeDdCashId) {
		this.chequeDdCashId = chequeDdCashId;
	}

	public Date getChequeDdDt() {
		return this.chequeDdDt;
	}

	public void setChequeDdDt(Date chequeDdDt) {
		this.chequeDdDt = chequeDdDt;
	}

	public long getChequeDdNo() {
		return this.chequeDdNo;
	}

	public void setChequeDdNo(long chequeDdNo) {
		this.chequeDdNo = chequeDdNo;
	}

	public long getFinYearId() {
		return this.finYearId;
	}

	public void setFinYearId(long finYearId) {
		this.finYearId = finYearId;
	}

	public String getLetterNo() {
		return this.letterNo;
	}

	public void setLetterNo(String letterNo) {
		this.letterNo = letterNo;
	}

	public String getPartyAddress() {
		return this.partyAddress;
	}

	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}

	public String getPartyName() {
		return this.partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public long getPartyTypeId() {
		return this.partyTypeId;
	}

	public void setPartyTypeId(long partyTypeId) {
		this.partyTypeId = partyTypeId;
	}

	public String getReceiptNo() {
		return this.receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public long getRecvFrmTypeId() {
		return this.recvFrmTypeId;
	}

	public void setRecvFrmTypeId(long recvFrmTypeId) {
		this.recvFrmTypeId = recvFrmTypeId;
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

	public Date getTransactionDt() {
		return this.transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}

}
