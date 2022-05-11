package gov.ifms.gst.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.gst.util.GSTUtility;

public class GSTMoeListingDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private long id;

	/** The BANK_ID. */
	@NativeQueryResultColumn(index = 1)
	private String BANK_ID;

	/** The BANK_NAME. */
	@NativeQueryResultColumn(index = 2)
	private String BANK_NAME;

	/** The PARTY_NAME. */
	@NativeQueryResultColumn(index = 3)
	private String PARTY_NAME;

	/** The GSTIN_TMPID_NO. */
	@NativeQueryResultColumn(index = 4)
	private String GSTIN_TMPID_NO;

	/** The CPIN_NO. */
	@NativeQueryResultColumn(index = 5)
	private String CPIN_NO;

	/** The CIN_NO. */
	@NativeQueryResultColumn(index = 6)
	private String CIN_NO;

	/** The MOE_REASON_ID. */
	@NativeQueryResultColumn(index = 7)
	private String MOE_REASON_ID;

	/** The MOE_RAISED_DT. */
	@NativeQueryResultColumn(index = 8)
	private String MOE_RAISED_DT;

	/** The MOE_PAYMENT_DT. */
	@NativeQueryResultColumn(index = 9)
	private String MOE_PAYMENT_DT;

	/** The GST_AMOUNT. */
	@NativeQueryResultColumn(index = 10)
	private Double GST_AMOUNT;

	/** The RBI_AMOUNT. */
	@NativeQueryResultColumn(index = 11)
	private Double RBI_AMOUNT;

	/** The MOE_GENERATED_AMOUNT. */
	@NativeQueryResultColumn(index = 12)
	private Double MOE_GENERATED_AMOUNT;

	/** The GOVT_CREDIT_DT. */
	@NativeQueryResultColumn(index = 13)
	private String GOVT_CREDIT_DT;

	/** The MOE_STATUS_ID. */
	@NativeQueryResultColumn(index = 14)
	private String MOE_STATUS_ID;

	/** The MOE_STATUS. */
	@NativeQueryResultColumn(index = 15)
	private String MOE_STATUS;

	/** The referenceNo. */
	@NativeQueryResultColumn(index = 16)
	private String referenceNo;

	/** The referenceDt. */
	@NativeQueryResultColumn(index = 17)
	private String referenceDt;

	/** The wfStatus. */
	@NativeQueryResultColumn(index = 19)
	private String wfStatus;

	/** The referenceDt. */
	@NativeQueryResultColumn(index = 18)
	private String isEditable;
	
	/** The referenceDt. */ 
	@NativeQueryResultColumn(index = 20)
	private String remarks;

	/** The referenceDt. */ 
	@NativeQueryResultColumn(index = 21)
	private String totalRecords;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBANK_ID() {
		return BANK_ID;
	}

	public void setBANK_ID(String bANK_ID) {
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

	public String getCPIN_NO() {
		return CPIN_NO;
	}

	public void setCPIN_NO(String cPIN_NO) {
		CPIN_NO = cPIN_NO;
	}

	public String getCIN_NO() {
		return CIN_NO;
	}

	public void setCIN_NO(String cIN_NO) {
		CIN_NO = cIN_NO;
	}

	public String getMOE_REASON_ID() {
		return MOE_REASON_ID;
	}

	public void setMOE_REASON_ID(String mOE_REASON_ID) {
		MOE_REASON_ID = mOE_REASON_ID;
	}

	public Double getGST_AMOUNT() {
		return GSTUtility.roundUpDoubleValue(GST_AMOUNT);
	}

	public void setGST_AMOUNT(Double gST_AMOUNT) {
		GST_AMOUNT = gST_AMOUNT;
	}

	public Double getRBI_AMOUNT() {
		return GSTUtility.roundUpDoubleValue(RBI_AMOUNT);
	}

	public void setRBI_AMOUNT(Double rBI_AMOUNT) {
		RBI_AMOUNT = rBI_AMOUNT;
	}

	public Double getMOE_GENERATED_AMOUNT() {
		return GSTUtility.roundUpDoubleValue(MOE_GENERATED_AMOUNT);
	}

	public void setMOE_GENERATED_AMOUNT(Double mOE_GENERATED_AMOUNT) {
		MOE_GENERATED_AMOUNT = mOE_GENERATED_AMOUNT;
	}

	public String getMOE_STATUS_ID() {
		return MOE_STATUS_ID;
	}

	public void setMOE_STATUS_ID(String mOE_STATUS_ID) {
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

	public String getMOE_RAISED_DT() {
		return MOE_RAISED_DT;
	}

	public void setMOE_RAISED_DT(String MOE_RAISED_DT) {
		this.MOE_RAISED_DT = MOE_RAISED_DT;
	}

	public String getMOE_PAYMENT_DT() {
		return MOE_PAYMENT_DT;
	}

	public void setMOE_PAYMENT_DT(String MOE_PAYMENT_DT) {
		this.MOE_PAYMENT_DT = MOE_PAYMENT_DT;
	}

	public String getGOVT_CREDIT_DT() {
		return GOVT_CREDIT_DT;
	}

	public void setGOVT_CREDIT_DT(String GOVT_CREDIT_DT) {
		this.GOVT_CREDIT_DT = GOVT_CREDIT_DT;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(String referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}

	public String getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(String totalRecords) {
		this.totalRecords = totalRecords;
	}
}
