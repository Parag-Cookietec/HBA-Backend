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
 * The persistent class for the TDOI_AC_CHALLAN_DTL database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_CHALLAN_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcChallanDtlEntity.findAll", query = "SELECT t FROM TdoiAcChallanDtlEntity t")
public class TdoiAcChallanDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHALLAN_DTL_ID", unique = true, nullable = false)
	private long challanDtlId;

	@Column(name = "BTR_RECEIPT_NO")
	private long btrReceiptNo;

	@Column(name = "CHALLAN_NO", length = 30)
	private String challanNo;

	@Column(name = "CHEQUE_AMT_IN_WORDS", length = 200)
	private String chequeAmtInWords;

	@Column(name = "CHEQUE_DD_AMT")
	private double chequeDdAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHEQUE_DD_DT")
	private Date chequeDdDt;

	@Column(name = "CHEQUE_DD_NO")
	private long chequeDdNo;

	@Column(name = "DETAIL_HEAD_ID")
	private long detailHeadId;

	@Column(name = "MAJORHEAD_ID")
	private long majorheadId;

	@Column(name = "MINORHEAD_ID")
	private long minorheadId;

	@Column(name = "MOBILE_NO")
	private long mobileNo;

	@Column(name = "PARTY_DESC", length = 200)
	private String partyDesc;

	@Column(name = "PARTY_NAME", length = 60)
	private String partyName;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "SUBHEAD_ID")
	private long subheadId;

	@Column(name = "SUBMAJORHEAD_ID")
	private long submajorheadId;

	public long getChallanDtlId() {
		return this.challanDtlId;
	}

	public void setChallanDtlId(long challanDtlId) {
		this.challanDtlId = challanDtlId;
	}

	public long getBtrReceiptNo() {
		return this.btrReceiptNo;
	}

	public void setBtrReceiptNo(long btrReceiptNo) {
		this.btrReceiptNo = btrReceiptNo;
	}

	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
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

	public long getDetailHeadId() {
		return this.detailHeadId;
	}

	public void setDetailHeadId(long detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	public long getMajorheadId() {
		return this.majorheadId;
	}

	public void setMajorheadId(long majorheadId) {
		this.majorheadId = majorheadId;
	}

	public long getMinorheadId() {
		return this.minorheadId;
	}

	public void setMinorheadId(long minorheadId) {
		this.minorheadId = minorheadId;
	}

	public long getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPartyDesc() {
		return this.partyDesc;
	}

	public void setPartyDesc(String partyDesc) {
		this.partyDesc = partyDesc;
	}

	public String getPartyName() {
		return this.partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
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

	public long getSubheadId() {
		return this.subheadId;
	}

	public void setSubheadId(long subheadId) {
		this.subheadId = subheadId;
	}

	public long getSubmajorheadId() {
		return this.submajorheadId;
	}

	public void setSubmajorheadId(long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

}
