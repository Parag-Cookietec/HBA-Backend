package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_RBI_ACC_HDR", schema = GSTConstant.GST_SCHEMA)
public class RBIAccHdr extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_RAH = "RAH";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RBI_ACC_HDR_ID")
	private long id;

	@Column(name = "CIN_NO")
	private String cinNo;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "GOVT_CREDIT_DT")
	private Date govtCreditDt;

	@Column(name = "CREDIT_AMOUNT")
	private Double creditAmount;

	@Column(name = "SCROLL_NO")
	private String scrollNo;

	@Column(name = "SCROLL_DT")
	private Date scrollDt;

	@Column(name = "IS_ENTRY_MATCHED")
	private char isEntryMatched;

	public RBIAccHdr(Long id) {
		super();
		this.id = id;
	}

	public RBIAccHdr() {
		super();
	}

	public RBIAccHdr(String cinNo, String referenceNo, Date referenceDt, Date govtCreditDt, Double creditAmount, String scrollNo, Date scrollDt, char isEntryMatched) {
		this.cinNo = cinNo;
		this.referenceNo = referenceNo;
		this.referenceDt = referenceDt;
		this.govtCreditDt = govtCreditDt;
		this.creditAmount = creditAmount;
		this.scrollNo = scrollNo;
		this.scrollDt = scrollDt;
		this.isEntryMatched = isEntryMatched;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public Date getGovtCreditDt() {
		return govtCreditDt;
	}

	public void setGovtCreditDt(Date govtCreditDt) {
		this.govtCreditDt = govtCreditDt;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getScrollNo() {
		return scrollNo;
	}

	public void setScrollNo(String scrollNo) {
		this.scrollNo = scrollNo;
	}

	public Date getScrollDt() {
		return scrollDt;
	}

	public void setScrollDt(Date scrollDt) {
		this.scrollDt = scrollDt;
	}

	public char getIsEntryMatched() {
		return isEntryMatched;
	}

	public void setIsEntryMatched(char isEntryMatched) {
		this.isEntryMatched = isEntryMatched;
	}

	public static String getTrnScreenRah() {
		return TRN_SCREEN_RAH;
	}

}
