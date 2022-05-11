package gov.ifms.doi.hba.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;
import gov.ifms.doi.jpa.entity.DoiInwardEntry;

/**
 * The persistent class for the TDOI_HBA_CLAIM_ENTRY database table. * @author
 * Sagar Jadhav
 * 
 */
@Entity
@Table(name = "TDOI_HBA_CLAIM_ENTRY", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiHbaClaimEntryEntity.findAll", query = "SELECT t FROM TdoiHbaClaimEntryEntity t")
public class TdoiHbaClaimEntryEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	public TdoiHbaClaimEntryEntity() {
	}

	public TdoiHbaClaimEntryEntity(long hbaClaimId) {
		this.hbaClaimId = hbaClaimId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HBA_CLAIM_ID", unique = true, nullable = false)
	private long hbaClaimId;

	@Column(name = "AADHAR_NUM", nullable = false)
	private long aadharNum;

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

	@Column(name = "CLAIM_YEAR_ID")
	private long claimYearId;

	@Column(name = "EMAIL_ADDRESS", length = 40)
	private String emailAddress;

	@Column(name = "EXTENT_OF_LOSS", length = 100)
	private String extentOfLoss;

	@Column(name = "HBA_POLICY_NO", length = 30)
	private String hbaPolicyNo;

	@Column(name = "INSUR_OTHER_COMPANY")
	private short insurOtherCompany;

	@Column(name = "INSURED_ADDRESS", length = 200)
	private String insuredAddress;

	@Column(name = "INSURED_NAME", length = 100)
	private String insuredName;

	@Temporal(TemporalType.DATE)
	@Column(name = "INWARD_ACCEPT_DT")
	private Date inwardAcceptDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "INWARD_DT")
	private Date inwardDt;

	@Column(name = "INWARD_NO", length = 60)
	private String inwardNo;

	@Column(name = "IS_PAYMENT_DONE", nullable = false)
	private short isPaymentDone;

	@Column(name = "IS_SENT_FOR_PAY", nullable = false)
	private short isSentForPay;

	@Column(name = "IS_SURVEYOR_ASSGN", nullable = false)
	private short isSurveyorAssgn;

	@Temporal(TemporalType.DATE)
	@Column(name = "LOSS_DATE")
	private Date lossDate;

	@Column(name = "LOSS_TIME", length = 10)
	private String lossTime;

	@Column(name = "MOBILE_NUM")
	private long mobileNum;

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

	@Temporal(TemporalType.DATE)
	@Column(name = "SURV_BILL_DT")
	private Date survBillDt;

	@Column(name = "SURV_BILL_NO", length = 20)
	private String survBillNo;

	@Column(name = "SURV_FEE_AMOUNT")
	private double survFeeAmount;

	@Column(name = "SURVEYOR_ID")
	private long surveyorId;

	@Column(name = "SURVEYOR_NAME", length = 100)
	private String surveyorName;

	@Column(name = "SURVEYOR_PAYMENT")
	private double surveyorPayment;

	@Column(name = "TRANSACTION_ID", length = 20)
	private String transactionId;

	// bi-directional many-to-one association to TdoiHbaProposal
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HBA_PROPOSAL_ID", nullable = false)
	@JsonBackReference
	private TdoiHbaProposalEntity tdoiHbaProposal;

	// bi-directional many-to-one association to TdoiInwardEntry
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "INWARD_ID")
	@JsonBackReference
	private DoiInwardEntry tdoiInwardEntry;

	// bi-directional many-to-one association to TdoiHbaClaimLossDtl
	@OneToMany(mappedBy = "tdoiHbaClaimEntry")
	@JsonManagedReference
	private List<TdoiHbaClaimLossDtlEntity> tdoiHbaClaimLossDtls;

	// bi-directional many-to-one association to TdoiHbaClaimReject
	@OneToMany(mappedBy = "tdoiHbaClaimEntry")
	@JsonManagedReference
	private List<TdoiHbaClaimRejectEntity> tdoiHbaClaimRejects;

	// bi-directional many-to-one association to TdoiHbaClaimWf
	@OneToMany(mappedBy = "tdoiHbaClaimEntry")
	@JsonManagedReference
	private List<TdoiHbaClaimWfEntity> tdoiHbaClaimWfs;

	// bi-directional many-to-one association to TdoiHbaOthrCompClaim
	@OneToMany(mappedBy = "tdoiHbaClaimEntry")
	@JsonManagedReference
	private List<TdoiHbaOthrCompClaimEntity> tdoiHbaOthrCompClaims;

	/**
	 * @return the hbaClaimId
	 */
	public long getHbaClaimId() {
		return hbaClaimId;
	}

	/**
	 * @param hbaClaimId the hbaClaimId to set
	 */
	public void setHbaClaimId(long hbaClaimId) {
		this.hbaClaimId = hbaClaimId;
	}

	/**
	 * @return the aadharNum
	 */
	public long getAadharNum() {
		return aadharNum;
	}

	/**
	 * @param aadharNum the aadharNum to set
	 */
	public void setAadharNum(long aadharNum) {
		this.aadharNum = aadharNum;
	}

	/**
	 * @return the causeOfLoss
	 */
	public String getCauseOfLoss() {
		return causeOfLoss;
	}

	/**
	 * @param causeOfLoss the causeOfLoss to set
	 */
	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}

	/**
	 * @return the chequeNum
	 */
	public long getChequeNum() {
		return chequeNum;
	}

	/**
	 * @param chequeNum the chequeNum to set
	 */
	public void setChequeNum(long chequeNum) {
		this.chequeNum = chequeNum;
	}

	/**
	 * @return the claimAcceptById
	 */
	
	  public long getClaimAcceptById() { return claimAcceptById; }
	  
	 
	/**
	 * @param claimAcceptById the claimAcceptById to set
	 */
	 public void setClaimAcceptById(long claimAcceptById) { 
		 this.claimAcceptById = claimAcceptById; 
	 }
			 

	/**
	 * @return the claimAcceptDt
	 */
	public Date getClaimAcceptDt() {
		return claimAcceptDt;
	}

	/**
	 * @param claimAcceptDt the claimAcceptDt to set
	 */
	public void setClaimAcceptDt(Date claimAcceptDt) {
		this.claimAcceptDt = claimAcceptDt;
	}

	/**
	 * @return the claimAmount
	 */
	public double getClaimAmount() {
		return claimAmount;
	}

	/**
	 * @param claimAmount the claimAmount to set
	 */
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	/**
	 * @return the claimEntryStatus
	 */
	public String getClaimEntryStatus() {
		return claimEntryStatus;
	}

	/**
	 * @param claimEntryStatus the claimEntryStatus to set
	 */
	public void setClaimEntryStatus(String claimEntryStatus) {
		this.claimEntryStatus = claimEntryStatus;
	}

	/**
	 * @return the claimGenerateDt
	 */
	public Date getClaimGenerateDt() {
		return claimGenerateDt;
	}

	/**
	 * @param claimGenerateDt the claimGenerateDt to set
	 */
	public void setClaimGenerateDt(Date claimGenerateDt) {
		this.claimGenerateDt = claimGenerateDt;
	}

	/**
	 * @return the claimMonthId
	 */
	public long getClaimMonthId() {
		return claimMonthId;
	}

	/**
	 * @param claimMonthId the claimMonthId to set
	 */
	public void setClaimMonthId(long claimMonthId) {
		this.claimMonthId = claimMonthId;
	}

	/**
	 * @return the claimNo
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * @param claimNo the claimNo to set
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	/**
	 * @return the claimStatus
	 */
	public String getClaimStatus() {
		return claimStatus;
	}

	/**
	 * @param claimStatus the claimStatus to set
	 */
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	/**
	 * @return the claimStatusId
	 */
	public long getClaimStatusId() {
		return claimStatusId;
	}

	/**
	 * @param claimStatusId the claimStatusId to set
	 */
	public void setClaimStatusId(long claimStatusId) {
		this.claimStatusId = claimStatusId;
	}

	/**
	 * @return the claimYearId
	 */
	public long getClaimYearId() {
		return claimYearId;
	}

	/**
	 * @param claimYearId the claimYearId to set
	 */
	public void setClaimYearId(long claimYearId) {
		this.claimYearId = claimYearId;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the extentOfLoss
	 */
	public String getExtentOfLoss() {
		return extentOfLoss;
	}

	/**
	 * @param extentOfLoss the extentOfLoss to set
	 */
	public void setExtentOfLoss(String extentOfLoss) {
		this.extentOfLoss = extentOfLoss;
	}

	/**
	 * @return the hbaPolicyNo
	 */
	public String getHbaPolicyNo() {
		return hbaPolicyNo;
	}

	/**
	 * @param hbaPolicyNo the hbaPolicyNo to set
	 */
	public void setHbaPolicyNo(String hbaPolicyNo) {
		this.hbaPolicyNo = hbaPolicyNo;
	}

	/**
	 * @return the insurOtherCompany
	 */
	public short getInsurOtherCompany() {
		return insurOtherCompany;
	}

	/**
	 * @param insurOtherCompany the insurOtherCompany to set
	 */
	public void setInsurOtherCompany(short insurOtherCompany) {
		this.insurOtherCompany = insurOtherCompany;
	}

	/**
	 * @return the insuredAddress
	 */
	public String getInsuredAddress() {
		return insuredAddress;
	}

	/**
	 * @param insuredAddress the insuredAddress to set
	 */
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	/**
	 * @return the insuredName
	 */
	public String getInsuredName() {
		return insuredName;
	}

	/**
	 * @param insuredName the insuredName to set
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	/**
	 * @return the inwardAcceptDt
	 */
	public Date getInwardAcceptDt() {
		return inwardAcceptDt;
	}

	/**
	 * @param inwardAcceptDt the inwardAcceptDt to set
	 */
	public void setInwardAcceptDt(Date inwardAcceptDt) {
		this.inwardAcceptDt = inwardAcceptDt;
	}

	/**
	 * @return the inwardDt
	 */
	public Date getInwardDt() {
		return inwardDt;
	}

	/**
	 * @param inwardDt the inwardDt to set
	 */
	public void setInwardDt(Date inwardDt) {
		this.inwardDt = inwardDt;
	}

	/**
	 * @return the inwardNo
	 */
	public String getInwardNo() {
		return inwardNo;
	}

	/**
	 * @param inwardNo the inwardNo to set
	 */
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * @return the isPaymentDone
	 */
	public short getIsPaymentDone() {
		return isPaymentDone;
	}

	/**
	 * @param isPaymentDone the isPaymentDone to set
	 */
	public void setIsPaymentDone(short isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}

	/**
	 * @return the isSentForPay
	 */
	public short getIsSentForPay() {
		return isSentForPay;
	}

	/**
	 * @param isSentForPay the isSentForPay to set
	 */
	public void setIsSentForPay(short isSentForPay) {
		this.isSentForPay = isSentForPay;
	}

	/**
	 * @return the isSurveyorAssgn
	 */
	public short getIsSurveyorAssgn() {
		return isSurveyorAssgn;
	}

	/**
	 * @param isSurveyorAssgn the isSurveyorAssgn to set
	 */
	public void setIsSurveyorAssgn(short isSurveyorAssgn) {
		this.isSurveyorAssgn = isSurveyorAssgn;
	}

	/**
	 * @return the lossDate
	 */
	public Date getLossDate() {
		return lossDate;
	}

	/**
	 * @param lossDate the lossDate to set
	 */
	public void setLossDate(Date lossDate) {
		this.lossDate = lossDate;
	}

	/**
	 * @return the lossTime
	 */
	public String getLossTime() {
		return lossTime;
	}

	/**
	 * @param lossTime the lossTime to set
	 */
	public void setLossTime(String lossTime) {
		this.lossTime = lossTime;
	}

	/**
	 * @return the mobileNum
	 */
	public long getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}

	/**
	 * @return the paidAmount
	 */
	public double getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @param paidAmount the paidAmount to set
	 */
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * @return the paymentDt
	 */
	public Date getPaymentDt() {
		return paymentDt;
	}

	/**
	 * @param paymentDt the paymentDt to set
	 */
	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	/**
	 * @return the policyEndDt
	 */
	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	/**
	 * @param policyEndDt the policyEndDt to set
	 */
	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	/**
	 * @return the policyStartDt
	 */
	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	/**
	 * @param policyStartDt the policyStartDt to set
	 */
	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	/**
	 * @return the referenceDt
	 */
	public Date getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the rejectReason
	 */
	public String getRejectReason() {
		return rejectReason;
	}

	/**
	 * @param rejectReason the rejectReason to set
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	/**
	 * @return the rejectedBy
	 */
	public long getRejectedBy() {
		return rejectedBy;
	}

	/**
	 * @param rejectedBy the rejectedBy to set
	 */
	public void setRejectedBy(long rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	/**
	 * @return the rejectionDt
	 */
	public Date getRejectionDt() {
		return rejectionDt;
	}

	/**
	 * @param rejectionDt the rejectionDt to set
	 */
	public void setRejectionDt(Date rejectionDt) {
		this.rejectionDt = rejectionDt;
	}

	/**
	 * @return the sumInsured
	 */
	public double getSumInsured() {
		return sumInsured;
	}

	/**
	 * @param sumInsured the sumInsured to set
	 */
	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	/**
	 * @return the survBillDt
	 */
	public Date getSurvBillDt() {
		return survBillDt;
	}

	/**
	 * @param survBillDt the survBillDt to set
	 */
	public void setSurvBillDt(Date survBillDt) {
		this.survBillDt = survBillDt;
	}

	/**
	 * @return the survBillNo
	 */
	public String getSurvBillNo() {
		return survBillNo;
	}

	/**
	 * @param survBillNo the survBillNo to set
	 */
	public void setSurvBillNo(String survBillNo) {
		this.survBillNo = survBillNo;
	}

	/**
	 * @return the survFeeAmount
	 */
	public double getSurvFeeAmount() {
		return survFeeAmount;
	}

	/**
	 * @param survFeeAmount the survFeeAmount to set
	 */
	public void setSurvFeeAmount(double survFeeAmount) {
		this.survFeeAmount = survFeeAmount;
	}

	/**
	 * @return the surveyorId
	 */
	public long getSurveyorId() {
		return surveyorId;
	}

	/**
	 * @param surveyorId the surveyorId to set
	 */
	public void setSurveyorId(long surveyorId) {
		this.surveyorId = surveyorId;
	}

	/**
	 * @return the surveyorName
	 */
	public String getSurveyorName() {
		return surveyorName;
	}

	/**
	 * @param surveyorName the surveyorName to set
	 */
	public void setSurveyorName(String surveyorName) {
		this.surveyorName = surveyorName;
	}

	/**
	 * @return the surveyorPayment
	 */
	public double getSurveyorPayment() {
		return surveyorPayment;
	}

	/**
	 * @param surveyorPayment the surveyorPayment to set
	 */
	public void setSurveyorPayment(double surveyorPayment) {
		this.surveyorPayment = surveyorPayment;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the tdoiHbaProposal
	 */
	public TdoiHbaProposalEntity getTdoiHbaProposal() {
		return tdoiHbaProposal;
	}

	/**
	 * @param tdoiHbaProposal the tdoiHbaProposal to set
	 */
	public void setTdoiHbaProposal(TdoiHbaProposalEntity tdoiHbaProposal) {
		this.tdoiHbaProposal = tdoiHbaProposal;
	}

	/**
	 * @return the tdoiInwardEntry
	 */
	public DoiInwardEntry getTdoiInwardEntry() {
		return tdoiInwardEntry;
	}

	/**
	 * @param tdoiInwardEntry the tdoiInwardEntry to set
	 */
	public void setTdoiInwardEntry(DoiInwardEntry tdoiInwardEntry) {
		this.tdoiInwardEntry = tdoiInwardEntry;
	}

	/**
	 * @return the tdoiHbaClaimLossDtls
	 */
	public List<TdoiHbaClaimLossDtlEntity> getTdoiHbaClaimLossDtls() {
		return tdoiHbaClaimLossDtls;
	}

	/**
	 * @param tdoiHbaClaimLossDtls the tdoiHbaClaimLossDtls to set
	 */
	public void setTdoiHbaClaimLossDtls(List<TdoiHbaClaimLossDtlEntity> tdoiHbaClaimLossDtls) {
		this.tdoiHbaClaimLossDtls = tdoiHbaClaimLossDtls;
	}

	/**
	 * @return the tdoiHbaClaimRejects
	 */
	public List<TdoiHbaClaimRejectEntity> getTdoiHbaClaimRejects() {
		return tdoiHbaClaimRejects;
	}

	/**
	 * @param tdoiHbaClaimRejects the tdoiHbaClaimRejects to set
	 */
	public void setTdoiHbaClaimRejects(List<TdoiHbaClaimRejectEntity> tdoiHbaClaimRejects) {
		this.tdoiHbaClaimRejects = tdoiHbaClaimRejects;
	}

	/**
	 * @return the tdoiHbaClaimWfs
	 */
	public List<TdoiHbaClaimWfEntity> getTdoiHbaClaimWfs() {
		return tdoiHbaClaimWfs;
	}

	/**
	 * @param tdoiHbaClaimWfs the tdoiHbaClaimWfs to set
	 */
	public void setTdoiHbaClaimWfs(List<TdoiHbaClaimWfEntity> tdoiHbaClaimWfs) {
		this.tdoiHbaClaimWfs = tdoiHbaClaimWfs;
	}

	/**
	 * @return the tdoiHbaOthrCompClaims
	 */
	public List<TdoiHbaOthrCompClaimEntity> getTdoiHbaOthrCompClaims() {
		return tdoiHbaOthrCompClaims;
	}

	/**
	 * @param tdoiHbaOthrCompClaims the tdoiHbaOthrCompClaims to set
	 */
	public void setTdoiHbaOthrCompClaims(List<TdoiHbaOthrCompClaimEntity> tdoiHbaOthrCompClaims) {
		this.tdoiHbaOthrCompClaims = tdoiHbaOthrCompClaims;
	}

}