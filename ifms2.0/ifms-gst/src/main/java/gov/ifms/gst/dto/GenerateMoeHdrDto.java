package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class GenerateMoeHdrDto {

	private long id;
	private long BANK_ID;
	private String BANK_NAME;
	private String PARTY_NAME;
	private String GSTIN_TMPID_NO;
	private long CPIN_NO;
	private String CIN_NO;
	private long MOE_REASON_ID;
	private String MOE_REASON_NAME;
	private Date MOE_RAISED_DT;
	private Date MOE_PAYMENT_DT;
	private Double GST_AMOUNT;
	private Double RBI_AMOUNT;
	private Double MOE_GENERATED_AMOUNT;
	private Date GOVT_CREDIT_DT;
	private long MOE_STATUS_ID;
	private String MOE_STATUS;
	private String referenceNo;
	private LocalDateTime referenceDt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBANK_ID() {
		return BANK_ID;
	}

	public void setBANK_ID(long bANK_ID) {
		BANK_ID = bANK_ID;
	}

	public String getBANK_NAME() {
		return BANK_NAME;
	}

	public void setBANK_NAME(String bANK_NAME) {
		BANK_NAME = bANK_NAME;
	}

	public String getPARTY_NAME() {
		return PARTY_NAME;
	}

	public void setPARTY_NAME(String pARTY_NAME) {
		PARTY_NAME = pARTY_NAME;
	}

	public String getGSTIN_TMPID_NO() {
		return GSTIN_TMPID_NO;
	}

	public void setGSTIN_TMPID_NO(String gSTIN_TMPID_NO) {
		GSTIN_TMPID_NO = gSTIN_TMPID_NO;
	}

	public long getCPIN_NO() {
		return CPIN_NO;
	}

	public void setCPIN_NO(long cPIN_NO) {
		CPIN_NO = cPIN_NO;
	}

	public String getCIN_NO() {
		return CIN_NO;
	}

	public void setCIN_NO(String cIN_NO) {
		CIN_NO = cIN_NO;
	}

	public long getMOE_REASON_ID() {
		return MOE_REASON_ID;
	}

	public void setMOE_REASON_ID(long mOE_REASON_ID) {
		MOE_REASON_ID = mOE_REASON_ID;
	}

	public String getMOE_REASON_NAME() {
		return MOE_REASON_NAME;
	}

	public void setMOE_REASON_NAME(String MOE_REASON_NAME) {
		this.MOE_REASON_NAME = MOE_REASON_NAME;
	}

	public Date getMOE_RAISED_DT() {
		return MOE_RAISED_DT;
	}

	public void setMOE_RAISED_DT(Date mOE_RAISED_DT) {
		MOE_RAISED_DT = mOE_RAISED_DT;
	}

	public Date getMOE_PAYMENT_DT() {
		return MOE_PAYMENT_DT;
	}

	public void setMOE_PAYMENT_DT(Date mOE_PAYMENT_DT) {
		MOE_PAYMENT_DT = mOE_PAYMENT_DT;
	}

	public Double getGST_AMOUNT() {
		return GST_AMOUNT;
	}

	public void setGST_AMOUNT(Double gST_AMOUNT) {
		GST_AMOUNT = gST_AMOUNT;
	}

	public Double getRBI_AMOUNT() {
		return RBI_AMOUNT;
	}

	public void setRBI_AMOUNT(Double rBI_AMOUNT) {
		RBI_AMOUNT = rBI_AMOUNT;
	}

	public Double getMOE_GENERATED_AMOUNT() {
		return MOE_GENERATED_AMOUNT;
	}

	public void setMOE_GENERATED_AMOUNT(Double mOE_GENERATED_AMOUNT) {
		MOE_GENERATED_AMOUNT = mOE_GENERATED_AMOUNT;
	}

	public Date getGOVT_CREDIT_DT() {
		return GOVT_CREDIT_DT;
	}

	public void setGOVT_CREDIT_DT(Date gOVT_CREDIT_DT) {
		GOVT_CREDIT_DT = gOVT_CREDIT_DT;
	}

	public long getMOE_STATUS_ID() {
		return MOE_STATUS_ID;
	}

	public void setMOE_STATUS_ID(long mOE_STATUS_ID) {
		MOE_STATUS_ID = mOE_STATUS_ID;
	}

	public String getMOE_STATUS() {
		return MOE_STATUS;
	}

	public void setMOE_STATUS(String mOE_STATUS) {
		MOE_STATUS = mOE_STATUS;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

}
