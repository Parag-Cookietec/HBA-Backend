package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TPAO_GST_ACC_HDR", schema = GSTConstant.GST_SCHEMA)
public class GSTAccountHdr extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_AH = "AH";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GST_ACC_HDR_ID")
	private long id;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDate referenceDt;

	@Column(name = "IS_GSTIN_TMPID")
	private char isGstinTmpid;

	@Column(name = "GSTIN_TMPID_NO")
	private String gstinTmpidNo;

	@Column(name = "PARTY_NAME")
	private String partyName;

	@Column(name = "PAYMENT_DT")
	private LocalDate paymentDt;

	@Column(name = "SGST_TAX")
	private Double sgstTax;

	@Column(name = "SGST_INTR")
	private Double sgstIntr;

	@Column(name = "SGST_FEE")
	private Double sgstFee;

	@Column(name = "SGST_PNLTY")
	private Double sgstPnlty;

	@Column(name = "SGST_OTH")
	private Double sgstOth;

	@Column(name = "SGST_TOTAL")
	private Double sgstTotal;

	@Column(name = "IS_ENTRY_MATCHED")
	private char isEntryMatched;

	@Column(name = "CIN_NO")
	private String cinNo;

	public GSTAccountHdr(Long id) {
		super();
		this.id = id;
	}

	public GSTAccountHdr() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDate getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDate referenceDt) {
		this.referenceDt = referenceDt;
	}

	public char getIsGstinTmpid() {
		return isGstinTmpid;
	}

	public void setIsGstinTmpid(char isGstinTmpid) {
		this.isGstinTmpid = isGstinTmpid;
	}

	public String getGstinTmpidNo() {
		return gstinTmpidNo;
	}

	public void setGstinTmpidNo(String gstinTmpidNo) {
		this.gstinTmpidNo = gstinTmpidNo;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public LocalDate getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(LocalDate paymentDt) {
		this.paymentDt = paymentDt;
	}

	public Double getSgstTax() {
		return sgstTax;
	}

	public void setSgstTax(Double sgstTax) {
		this.sgstTax = sgstTax;
	}

	public Double getSgstIntr() {
		return sgstIntr;
	}

	public void setSgstIntr(Double sgstIntr) {
		this.sgstIntr = sgstIntr;
	}

	public Double getSgstFee() {
		return sgstFee;
	}

	public void setSgstFee(Double sgstFee) {
		this.sgstFee = sgstFee;
	}

	public Double getSgstPnlty() {
		return sgstPnlty;
	}

	public void setSgstPnlty(Double sgstPnlty) {
		this.sgstPnlty = sgstPnlty;
	}

	public Double getSgstOth() {
		return sgstOth;
	}

	public void setSgstOth(Double sgstOth) {
		this.sgstOth = sgstOth;
	}

	public Double getSgstTotal() {
		return sgstTotal;
	}

	public void setSgstTotal(Double sgstTotal) {
		this.sgstTotal = sgstTotal;
	}

	public char getIsEntryMatched() {
		return isEntryMatched;
	}

	public void setIsEntryMatched(char isEntryMatched) {
		this.isEntryMatched = isEntryMatched;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public static String getTrnScreenAh() {
		return TRN_SCREEN_AH;
	}
}
