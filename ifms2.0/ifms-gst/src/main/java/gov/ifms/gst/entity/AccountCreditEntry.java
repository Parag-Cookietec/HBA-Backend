package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_ACC_CREDIT_ENTRY", schema = GSTConstant.GST_SCHEMA)
public class AccountCreditEntry extends BaseEntity implements Serializable {
	public static final String TRN_SCREEN_ACE = "ACE";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACC_CREDIT_ID")
	private long id;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "CIN_NO")
	private String cinNo;

	@Column(name = "MAJORHEAD_ID")
	private long majorheadId;

	@Column(name = "MAJORHEAD")
	private String majorhead;

	@Column(name = "SUBMAJORHEAD_ID")
	private long submajorheadId;

	@Column(name = "SUBMAJORHEAD")
	private String submajorhead;

	@Column(name = "MINORHEAD_ID")
	private long minorheadId;

	@Column(name = "MINORHEAD")
	private String minorhead;

	@Column(name = "SUBHEAD")
	private String subhead;

	@Column(name = "SUBHEAD_ID")
	private long subheadId;

	@Column(name = "DETAILHEAD_ID")
	private long detailheadId;

	@Column(name = "DETAILHEAD")
	private String detailhead;

	@Column(name = "ENTRY_DESC")
	private String entryDesc;
	
	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public long getMajorheadId() {
		return majorheadId;
	}

	public void setMajorheadId(long majorheadId) {
		this.majorheadId = majorheadId;
	}

	public String getMajorhead() {
		return majorhead;
	}

	public void setMajorhead(String majorhead) {
		this.majorhead = majorhead;
	}

	public long getSubmajorheadId() {
		return submajorheadId;
	}

	public void setSubmajorheadId(long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	public String getSubmajorhead() {
		return submajorhead;
	}

	public void setSubmajorhead(String submajorhead) {
		this.submajorhead = submajorhead;
	}

	public long getMinorheadId() {
		return minorheadId;
	}

	public void setMinorheadId(long minorheadId) {
		this.minorheadId = minorheadId;
	}

	public String getMinorhead() {
		return minorhead;
	}

	public void setMinorhead(String minorhead) {
		this.minorhead = minorhead;
	}

	public String getSubhead() {
		return subhead;
	}

	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}

	public long getSubheadId() {
		return subheadId;
	}

	public void setSubheadId(long subheadId) {
		this.subheadId = subheadId;
	}

	public long getDetailheadId() {
		return detailheadId;
	}

	public void setDetailheadId(long detailheadId) {
		this.detailheadId = detailheadId;
	}

	public String getDetailhead() {
		return detailhead;
	}

	public void setDetailhead(String detailhead) {
		this.detailhead = detailhead;
	}

	public String getEntryDesc() {
		return entryDesc;
	}

	public void setEntryDesc(String entryDesc) {
		this.entryDesc = entryDesc;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	@Column(name = "CREDIT_AMOUNT")
	private Double creditAmount;

	public AccountCreditEntry(long id) {
		super();
		this.id = id;
	}

	public AccountCreditEntry() {
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

	public static String getTrnScreenAce() {
		return TRN_SCREEN_ACE;
	}

}
