package gov.ifms.doi.db.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_CLAIM_ENTRY database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_CLAIM_ENTRY", schema = DoiJPAConstants.DOI_SCHEMA)
public class TdoiDbClaimEntryEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DB_CLAIM_ID", unique = true, nullable = false)
	private long dbClaimId;

	@Column(name = "CAUSE_OF_LOSS", length = 40)
	private String causeOfLoss;

	@Column(name = "CHEQUE_NUM")
	private long chequeNum;

	@Column(name = "CLAIM_ACCEPT_BY_ID")
	private long claimAcceptById;

	@Temporal(TemporalType.DATE)
	@Column(name = "CLAIM_ACCEPT_DT")
	private Date claimAcceptDt;

	@Column(name = "CLAIM_AMOUNT")
	private double claimAmount;

	@Column(name = "CLAIM_ENTRY_STATUS", length = 30)
	private String claimEntryStatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "CLAIM_GENERATE_DT")
	private Date claimGenerateDt;

	@Column(name = "CLAIM_MONTH_ID")
	private long claimMonthId;

	@Column(name = "CLAIM_NO", nullable = false, length = 20)
	private String claimNo;

	@Column(name = "CLAIM_STATUS", length = 30)
	private String claimStatus;

	@Column(name = "CLAIM_STATUS_ID")
	private long claimStatusId;

	@Column(name = "CLAIM_TYPE_ID")
	private long claimTypeId;

	@Column(name = "CLAIM_YEAR_ID")
	private long claimYearId;

	@Column(name = "CONTACT_NUM", length = 20)
	private String contactNum;

	@Column(name = "DB_POLICY_NO", length = 30)
	private String dbPolicyNo;

	@Column(name = "DISTRICT_ID")
	private long districtId;

	@Column(name = "EMAIL_ADDRESS", length = 40)
	private String emailAddress;

	@Column(name = "EXTENT_OF_LOSS", length = 100)
	private String extentOfLoss;

	@Temporal(TemporalType.DATE)
	@Column(name = "INWARD_ACCEPT_DT")
	private Date inwardAcceptDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "INWARD_DT")
	private Date inwardDt;

	@Column(name = "INWARD_ID")
	private long inwardId;

	@Column(name = "INWARD_NO", length = 60)
	private String inwardNo;

	@NotNull
	@Column(name = "IS_PAYMENT_DONE")
	private short isPaymentDone;

	@NotNull
	@Column(name = "IS_SENT_FOR_PAY")
	private short isSentForPay;

	@Temporal(TemporalType.DATE)
	@Column(name = "LOSS_DATE")
	private Date lossDate;

	@Column(name = "LOSS_TIME", length = 10)
	private String lossTime;

	@Column(name = "PAID_AMOUNT")
	private double paidAmount;

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DT")
	private Date paymentDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_END_DT")
	private Date policyEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_START_DT")
	private Date policyStartDt;

	@Column(name = "PROPOSL_ADDRESS", length = 200)
	private String proposlAddress;

	@Column(name = "PROPOSL_NAME", length = 100)
	private String proposlName;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "REJECT_REASON", length = 100)
	private String rejectReason;

	@Column(name = "REJECTED_BY")
	private long rejectedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "REJECTION_DT")
	private Date rejectionDt;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	@Column(name = "SURVEYOR_PAYMENT")
	private double surveyorPayment;

	@Column(name = "TALUKA_ID")
	private long talukaId;
	

	@Column(name= "ACTIVE_STATUS")
	private int activeStatus;

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Column(name = "TRANSACTION_ID", length = 20)
	private String transactionId;

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID")
	private TdoiDbProposalEntity tdoiDbProposalId;


	// bi-directional many-to-one association to TdoiDbClaimPrevLoss
	@OneToMany(mappedBy = "tdoiDbClaimEntry")
	private List<TdoiDbClaimPrevLossEntity> tdoiDbClaimPrevLosses;

	// bi-directional many-to-one association to TdoiDbClaimPropDtl
	@OneToMany(mappedBy = "tdoiDbClaimEntry")
	private List<TdoiDbClaimPropDtlEntity> tdoiDbClaimPropDtls;

	// bi-directional many-to-one association to TdoiDbClaimQuery
	@OneToMany(mappedBy = "tdoiDbClaimEntry")
	private List<TdoiDbClaimQueryEntity> tdoiDbClaimQueries;

	// bi-directional many-to-one association to TdoiDbClaimRiDtl
	@OneToMany(mappedBy = "tdoiDbClaimEntry")
	private List<TdoiDbClaimRiDtlEntity> tdoiDbClaimRiDtls;

	// bi-directional many-to-one association to TdoiDbClaimWf
	@OneToMany(mappedBy = "tdoiDbClaimEntry")
	private List<TdoiDbClaimWfEntity> tdoiDbClaimWfs;

	public List<TdoiDbClaimWfEntity> getTdoiDbClaimWfs() {
		return tdoiDbClaimWfs;
	}

	public void setTdoiDbClaimWfs(List<TdoiDbClaimWfEntity> tdoiDbClaimWfs) {
		this.tdoiDbClaimWfs = tdoiDbClaimWfs;
	}

	public TdoiDbClaimEntryEntity() {
	}

	public long getDbClaimId() {
		return this.dbClaimId;
	}

	public void setDbClaimId(long dbClaimId) {
		this.dbClaimId = dbClaimId;
	}

	public String getCauseOfLoss() {
		return this.causeOfLoss;
	}

	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}

	public long getChequeNum() {
		return this.chequeNum;
	}

	public void setChequeNum(long chequeNum) {
		this.chequeNum = chequeNum;
	}

	public long getClaimAcceptById() {
		return this.claimAcceptById;
	}

	public TdoiDbProposalEntity getTdoiDbProposalId() {
		return tdoiDbProposalId;
	}

	public void setTdoiDbProposalId(TdoiDbProposalEntity tdoiDbProposalId) {
		this.tdoiDbProposalId = tdoiDbProposalId;
	}

	public void setClaimAcceptById(long claimAcceptById) {
		this.claimAcceptById = claimAcceptById;
	}

	public Date getClaimAcceptDt() {
		return this.claimAcceptDt;
	}

	public void setClaimAcceptDt(Date claimAcceptDt) {
		this.claimAcceptDt = claimAcceptDt;
	}

	public double getClaimAmount() {
		return this.claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimEntryStatus() {
		return this.claimEntryStatus;
	}

	public void setClaimEntryStatus(String claimEntryStatus) {
		this.claimEntryStatus = claimEntryStatus;
	}

	public Date getClaimGenerateDt() {
		return this.claimGenerateDt;
	}

	public void setClaimGenerateDt(Date claimGenerateDt) {
		this.claimGenerateDt = claimGenerateDt;
	}

	public long getClaimMonthId() {
		return this.claimMonthId;
	}

	public void setClaimMonthId(long claimMonthId) {
		this.claimMonthId = claimMonthId;
	}

	public String getClaimNo() {
		return this.claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getClaimStatus() {
		return this.claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public long getClaimStatusId() {
		return this.claimStatusId;
	}

	public void setClaimStatusId(long claimStatusId) {
		this.claimStatusId = claimStatusId;
	}

	public long getClaimTypeId() {
		return this.claimTypeId;
	}

	public void setClaimTypeId(long claimTypeId) {
		this.claimTypeId = claimTypeId;
	}

	public long getClaimYearId() {
		return this.claimYearId;
	}

	public void setClaimYearId(long claimYearId) {
		this.claimYearId = claimYearId;
	}

	public String getContactNum() {
		return this.contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getDbPolicyNo() {
		return this.dbPolicyNo;
	}

	public void setDbPolicyNo(String dbPolicyNo) {
		this.dbPolicyNo = dbPolicyNo;
	}

	public long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getExtentOfLoss() {
		return this.extentOfLoss;
	}

	public void setExtentOfLoss(String extentOfLoss) {
		this.extentOfLoss = extentOfLoss;
	}

	public Date getInwardAcceptDt() {
		return this.inwardAcceptDt;
	}

	public void setInwardAcceptDt(Date inwardAcceptDt) {
		this.inwardAcceptDt = inwardAcceptDt;
	}

	public Date getInwardDt() {
		return this.inwardDt;
	}

	public void setInwardDt(Date inwardDt) {
		this.inwardDt = inwardDt;
	}

	public long getInwardId() {
		return this.inwardId;
	}

	public void setInwardId(long inwardId) {
		this.inwardId = inwardId;
	}

	public String getInwardNo() {
		return this.inwardNo;
	}

	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	public short getIsPaymentDone() {
		return this.isPaymentDone;
	}

	public void setIsPaymentDone(short isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}

	public short getIsSentForPay() {
		return this.isSentForPay;
	}

	public void setIsSentForPay(short isSentForPay) {
		this.isSentForPay = isSentForPay;
	}

	public Date getLossDate() {
		return this.lossDate;
	}

	public void setLossDate(Date lossDate) {
		this.lossDate = lossDate;
	}

	public String getLossTime() {
		return this.lossTime;
	}

	public void setLossTime(String lossTime) {
		this.lossTime = lossTime;
	}

	public double getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Date getPaymentDt() {
		return this.paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	public Date getPolicyEndDt() {
		return this.policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public Date getPolicyStartDt() {
		return this.policyStartDt;
	}

	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	public String getProposlAddress() {
		return this.proposlAddress;
	}

	public void setProposlAddress(String proposlAddress) {
		this.proposlAddress = proposlAddress;
	}

	public String getProposlName() {
		return this.proposlName;
	}

	public void setProposlName(String proposlName) {
		this.proposlName = proposlName;
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

	public String getRejectReason() {
		return this.rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public long getRejectedBy() {
		return this.rejectedBy;
	}

	public void setRejectedBy(long rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public Date getRejectionDt() {
		return this.rejectionDt;
	}

	public void setRejectionDt(Date rejectionDt) {
		this.rejectionDt = rejectionDt;
	}

	public double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public double getSurveyorPayment() {
		return this.surveyorPayment;
	}

	public void setSurveyorPayment(double surveyorPayment) {
		this.surveyorPayment = surveyorPayment;
	}

	public long getTalukaId() {
		return this.talukaId;
	}

	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public List<TdoiDbClaimPrevLossEntity> getTdoiDbClaimPrevLosses() {
		return this.tdoiDbClaimPrevLosses;
	}

	public void setTdoiDbClaimPrevLosses(List<TdoiDbClaimPrevLossEntity> tdoiDbClaimPrevLosses) {
		this.tdoiDbClaimPrevLosses = tdoiDbClaimPrevLosses;
	}

	public TdoiDbClaimPrevLossEntity addTdoiDbClaimPrevLoss(TdoiDbClaimPrevLossEntity tdoiDbClaimPrevLoss) {
		getTdoiDbClaimPrevLosses().add(tdoiDbClaimPrevLoss);
		tdoiDbClaimPrevLoss.setTdoiDbClaimEntry(this);

		return tdoiDbClaimPrevLoss;
	}

	public TdoiDbClaimPrevLossEntity removeTdoiDbClaimPrevLoss(TdoiDbClaimPrevLossEntity tdoiDbClaimPrevLoss) {
		getTdoiDbClaimPrevLosses().remove(tdoiDbClaimPrevLoss);
		tdoiDbClaimPrevLoss.setTdoiDbClaimEntry(null);

		return tdoiDbClaimPrevLoss;
	}

	public List<TdoiDbClaimPropDtlEntity> getTdoiDbClaimPropDtls() {
		return this.tdoiDbClaimPropDtls;
	}

	public void setTdoiDbClaimPropDtls(List<TdoiDbClaimPropDtlEntity> tdoiDbClaimPropDtls) {
		this.tdoiDbClaimPropDtls = tdoiDbClaimPropDtls;
	}

	public TdoiDbClaimPropDtlEntity addTdoiDbClaimPropDtl(TdoiDbClaimPropDtlEntity tdoiDbClaimPropDtl) {
		getTdoiDbClaimPropDtls().add(tdoiDbClaimPropDtl);
		tdoiDbClaimPropDtl.setTdoiDbClaimEntry(this);

		return tdoiDbClaimPropDtl;
	}

	public TdoiDbClaimPropDtlEntity removeTdoiDbClaimPropDtl(TdoiDbClaimPropDtlEntity tdoiDbClaimPropDtl) {
		getTdoiDbClaimPropDtls().remove(tdoiDbClaimPropDtl);
		tdoiDbClaimPropDtl.setTdoiDbClaimEntry(null);

		return tdoiDbClaimPropDtl;
	}

	public List<TdoiDbClaimQueryEntity> getTdoiDbClaimQueries() {
		return this.tdoiDbClaimQueries;
	}

	public void setTdoiDbClaimQueries(List<TdoiDbClaimQueryEntity> tdoiDbClaimQueries) {
		this.tdoiDbClaimQueries = tdoiDbClaimQueries;
	}

	public TdoiDbClaimQueryEntity addTdoiDbClaimQuery(TdoiDbClaimQueryEntity tdoiDbClaimQuery) {
		getTdoiDbClaimQueries().add(tdoiDbClaimQuery);
		tdoiDbClaimQuery.setTdoiDbClaimEntry(this);

		return tdoiDbClaimQuery;
	}

	public TdoiDbClaimQueryEntity removeTdoiDbClaimQuery(TdoiDbClaimQueryEntity tdoiDbClaimQuery) {
		getTdoiDbClaimQueries().remove(tdoiDbClaimQuery);
		tdoiDbClaimQuery.setTdoiDbClaimEntry(null);

		return tdoiDbClaimQuery;
	}

	public List<TdoiDbClaimRiDtlEntity> getTdoiDbClaimRiDtls() {
		return this.tdoiDbClaimRiDtls;
	}

	public void setTdoiDbClaimRiDtls(List<TdoiDbClaimRiDtlEntity> tdoiDbClaimRiDtls) {
		this.tdoiDbClaimRiDtls = tdoiDbClaimRiDtls;
	}

	public TdoiDbClaimRiDtlEntity addTdoiDbClaimRiDtl(TdoiDbClaimRiDtlEntity tdoiDbClaimRiDtl) {
		getTdoiDbClaimRiDtls().add(tdoiDbClaimRiDtl);
		tdoiDbClaimRiDtl.setTdoiDbClaimEntry(this);

		return tdoiDbClaimRiDtl;
	}

	public TdoiDbClaimRiDtlEntity removeTdoiDbClaimRiDtl(TdoiDbClaimRiDtlEntity tdoiDbClaimRiDtl) {
		getTdoiDbClaimRiDtls().remove(tdoiDbClaimRiDtl);
		tdoiDbClaimRiDtl.setTdoiDbClaimEntry(null);

		return tdoiDbClaimRiDtl;
	}


	

}