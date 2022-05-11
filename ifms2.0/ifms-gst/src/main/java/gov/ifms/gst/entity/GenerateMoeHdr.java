package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TPAO_GENERATE_MOE_HDR", schema = GSTConstant.GST_SCHEMA)
public class GenerateMoeHdr extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_LBAO = "RMRH";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOE_GENERATE_ID")
	private long id;

	@Column(name = "BANK_ID")
	private long BANK_ID;

	@Column(name = "BANK_NAME")
	private String BANK_NAME;

	@Column(name = "PARTY_NAME")
	private String PARTY_NAME;

	@Column(name = "GSTIN_TMPID_NO")
	private String GSTIN_TMPID_NO;

	@Column(name = "CPIN_NO")
	private long CPIN_NO;

	@Column(name = "CIN_NO")
	private String CIN_NO;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "MOE_REASON_ID", referencedColumnName = "LOOKUP_INFO_ID", nullable = false)
	private EDPLuLookUpInfoEntity MOE_REASON;

	@Column(name = "MOE_RAISED_DT")
	private Date MOE_RAISED_DT;

	@Column(name = "MOE_PAYMENT_DT")
	private Date MOE_PAYMENT_DT;

	@Column(name = "GST_AMOUNT")
	private Double GST_AMOUNT;

	@Column(name = "RBI_AMOUNT")
	private Double RBI_AMOUNT;

	@Column(name = "MOE_GENERATED_AMOUNT")
	private Double MOE_GENERATED_AMOUNT;

	@Column(name = "GOVT_CREDIT_DT")
	private Date GOVT_CREDIT_DT;

	@Column(name = "MOE_STATUS_ID")
	private long MOE_STATUS_ID;

	@Column(name = "MOE_STATUS")
	private String MOE_STATUS;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	public GenerateMoeHdr(Long id) {
		super();
		this.id = id;
	}

	public GenerateMoeHdr() {
		super();
	}

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

	public EDPLuLookUpInfoEntity getMOE_REASON() {
		return MOE_REASON;
	}

	public void setMOE_REASON(EDPLuLookUpInfoEntity MOE_REASON) {
		this.MOE_REASON = MOE_REASON;
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
