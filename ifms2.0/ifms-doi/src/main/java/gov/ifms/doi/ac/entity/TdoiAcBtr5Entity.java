package gov.ifms.doi.ac.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TDOI_AC_BTR_5 database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_BTR_5", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcBtr5Entity.findAll", query = "SELECT t FROM TdoiAcBtr5Entity t")
public class TdoiAcBtr5Entity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BTR5_REG_ID", unique = true, nullable = false)
	private long btr5RegId;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_NAME", length = 60)
	private String bankName;

	@Column(name = "BRANCH_ID")
	private long branchId;

	@Column(name = "BRANCH_NAME", length = 60)
	private String branchName;

	@Column(name = "CHEQUE_AMT_IN_WORDS", length = 200)
	private String chequeAmtInWords;

	@Column(name = "CHEQUE_DD_AMT")
	private double chequeDdAmt;

	@Column(name = "CHEQUE_DD_CASH_ID")
	private long chequeDdCashId;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHEQUE_DD_DT")
	private Date chequeDdDt;

	@Column(name = "CHEQUE_DD_NO")
	private long chequeDdNo;

	@Column(name = "FIN_YEAR_ID")
	private long finYearId;

	@Column(name = "LETTER_NO", length = 30)
	private String letterNo;

	@Column(name = "PARTY_ADDRESS", length = 200)
	private String partyAddress;

	@Column(name = "PARTY_NAME", length = 60)
	private String partyName;

	@Column(name = "PARTY_TYPE_ID")
	private long partyTypeId;

	@Column(name = "RECEIPT_NO", length = 30)
	private String receiptNo;

	@Column(name = "RECV_FRM_TYPE_ID")
	private long recvFrmTypeId;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "TRANSACTION_DT", nullable = false)
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
