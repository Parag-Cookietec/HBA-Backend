package gov.ifms.doi.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_CLAIM_RI_DTL database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_CLAIM_RI_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbClaimRiDtlEntity.findAll", query = "SELECT t FROM TdoiDbClaimRiDtlEntity t")
public class TdoiDbClaimRiDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLAIM_RI_DTL_ID", unique = true, nullable = false)
	private long claimRiDtlId;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHALLAN_DT")
	private Date challanDt;

	@Column(name = "CHALLAN_NO", length = 20)
	private String challanNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_RECV_ON")
	private Date paymentRecvOn;

	@Column(name = "PAYMENT_RECV_THRU", length = 50)
	private String paymentRecvThru;

	@Column(name = "PAYMENT_RESP_TO", length = 60)
	private String paymentRespTo;

	@Column(name = "RI_COMP_ADDRESS", length = 100)
	private String riCompAddress;

	@Column(name = "RI_COMP_NAME", length = 100)
	private String riCompName;

	@Column(name = "RI_PREM_AMOUNT")
	private double riPremAmount;

	@Column(name = "RI_SHARE_PERC")
	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbClaimEntry
	@ManyToOne
	@JoinColumn(name = "DB_CLAIM_ID", nullable = false)
	private TdoiDbClaimEntryEntity tdoiDbClaimEntry;

	public TdoiDbClaimRiDtlEntity() {
	}

	public long getClaimRiDtlId() {
		return this.claimRiDtlId;
	}

	public void setClaimRiDtlId(long claimRiDtlId) {
		this.claimRiDtlId = claimRiDtlId;
	}

	public Date getChallanDt() {
		return this.challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public Date getPaymentRecvOn() {
		return this.paymentRecvOn;
	}

	public void setPaymentRecvOn(Date paymentRecvOn) {
		this.paymentRecvOn = paymentRecvOn;
	}

	public String getPaymentRecvThru() {
		return this.paymentRecvThru;
	}

	public void setPaymentRecvThru(String paymentRecvThru) {
		this.paymentRecvThru = paymentRecvThru;
	}

	public String getPaymentRespTo() {
		return this.paymentRespTo;
	}

	public void setPaymentRespTo(String paymentRespTo) {
		this.paymentRespTo = paymentRespTo;
	}

	public String getRiCompAddress() {
		return this.riCompAddress;
	}

	public void setRiCompAddress(String riCompAddress) {
		this.riCompAddress = riCompAddress;
	}

	public String getRiCompName() {
		return this.riCompName;
	}

	public void setRiCompName(String riCompName) {
		this.riCompName = riCompName;
	}

	public double getRiPremAmount() {
		return this.riPremAmount;
	}

	public void setRiPremAmount(double riPremAmount) {
		this.riPremAmount = riPremAmount;
	}

	public double getRiSharePerc() {
		return this.riSharePerc;
	}

	public void setRiSharePerc(double riSharePerc) {
		this.riSharePerc = riSharePerc;
	}

	public TdoiDbClaimEntryEntity getTdoiDbClaimEntry() {
		return this.tdoiDbClaimEntry;
	}

	public void setTdoiDbClaimEntry(TdoiDbClaimEntryEntity tdoiDbClaimEntry) {
		this.tdoiDbClaimEntry = tdoiDbClaimEntry;
	}

}