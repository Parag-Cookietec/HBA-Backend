package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_CLAIM_ENTRY database table.
 * 
 */

public class TdoiDbClaimEntryDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbClaimId;

	private String causeOfLoss;

	private long chequeNum;

	private long claimAcceptById;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date claimAcceptDt;

	private double claimAmount;
	
 

	private String claimEntryStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date claimGenerateDt;

	private long claimMonthId;

	private String claimNo;

	private String claimStatus;

	private long claimStatusId;

	private long claimTypeId;

	private long claimYearId;
	
	private int activeStatus;

	private String contactNum;

	private String dbPolicyNo;

	private long districtId;

	private String emailAddress;

	private String extentOfLoss;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date inwardAcceptDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date inwardDt;

	private long inwardId;

	private String inwardNo;

	private short isPaymentDone;

	private short isSentForPay;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date lossDate;

	private String lossTime;

	private double paidAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyEndDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyStartDt;

	private String proposlAddress;

	private String proposlName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String rejectReason;

	private long rejectedBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date rejectionDt;

	private double sumInsured;

	private double surveyorPayment;

	private long talukaId;

	private String transactionId;

	// bi-directional many-to-one association to TdoiDbProposal

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	private TdoiDbProposalDTO tdoiDbProposalId;

	// bi-directional many-to-one association to TdoiDbClaimPrevLoss
	private List<TdoiDbClaimPrevLossDTO> tdoiDbClaimPrevLosses;

	// bi-directional many-to-one association to TdoiDbClaimPropDtl
	private List<TdoiDbClaimPropDtlDTO> tdoiDbClaimPropDtls;

	// bi-directional many-to-one association to TdoiDbClaimQuery
	private List<TdoiDbClaimQueryDTO> tdoiDbClaimQueries;

	// bi-directional many-to-one association to TdoiDbClaimRiDtl
	private List<TdoiDbClaimRiDtlDTO> tdoiDbClaimRiDtls;

	
	public TdoiDbProposalDTO getTdoiDbProposalId() {
		return tdoiDbProposalId;
	}

	public void setTdoiDbProposalId(TdoiDbProposalDTO tdoiDbProposalId) {
		this.tdoiDbProposalId = tdoiDbProposalId;
	}

		public TdoiDbClaimEntryDTO() {
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

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposalId;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposalId = tdoiDbProposal;
	}

	public List<TdoiDbClaimPrevLossDTO> getTdoiDbClaimPrevLosses() {
		return this.tdoiDbClaimPrevLosses;
	}

	public void setTdoiDbClaimPrevLosses(List<TdoiDbClaimPrevLossDTO> tdoiDbClaimPrevLosses) {
		this.tdoiDbClaimPrevLosses = tdoiDbClaimPrevLosses;
	}

	public TdoiDbClaimPrevLossDTO addTdoiDbClaimPrevLoss(TdoiDbClaimPrevLossDTO tdoiDbClaimPrevLoss) {
		getTdoiDbClaimPrevLosses().add(tdoiDbClaimPrevLoss);
		tdoiDbClaimPrevLoss.setTdoiDbClaimEntry(this);

		return tdoiDbClaimPrevLoss;
	}

	public TdoiDbClaimPrevLossDTO removeTdoiDbClaimPrevLoss(TdoiDbClaimPrevLossDTO tdoiDbClaimPrevLoss) {
		getTdoiDbClaimPrevLosses().remove(tdoiDbClaimPrevLoss);
		tdoiDbClaimPrevLoss.setTdoiDbClaimEntry(null);

		return tdoiDbClaimPrevLoss;
	}

	public List<TdoiDbClaimPropDtlDTO> getTdoiDbClaimPropDtls() {
		return this.tdoiDbClaimPropDtls;
	}

	public void setTdoiDbClaimPropDtls(List<TdoiDbClaimPropDtlDTO> tdoiDbClaimPropDtls) {
		this.tdoiDbClaimPropDtls = tdoiDbClaimPropDtls;
	}

	public TdoiDbClaimPropDtlDTO addTdoiDbClaimPropDtl(TdoiDbClaimPropDtlDTO tdoiDbClaimPropDtl) {
		getTdoiDbClaimPropDtls().add(tdoiDbClaimPropDtl);
		tdoiDbClaimPropDtl.setTdoiDbClaimEntry(this);

		return tdoiDbClaimPropDtl;
	}

	public TdoiDbClaimPropDtlDTO removeTdoiDbClaimPropDtl(TdoiDbClaimPropDtlDTO tdoiDbClaimPropDtl) {
		getTdoiDbClaimPropDtls().remove(tdoiDbClaimPropDtl);
		tdoiDbClaimPropDtl.setTdoiDbClaimEntry(null);

		return tdoiDbClaimPropDtl;
	}

	public List<TdoiDbClaimQueryDTO> getTdoiDbClaimQueries() {
		return this.tdoiDbClaimQueries;
	}

	public void setTdoiDbClaimQueries(List<TdoiDbClaimQueryDTO> tdoiDbClaimQueries) {
		this.tdoiDbClaimQueries = tdoiDbClaimQueries;
	}

	public TdoiDbClaimQueryDTO addTdoiDbClaimQuery(TdoiDbClaimQueryDTO tdoiDbClaimQuery) {
		getTdoiDbClaimQueries().add(tdoiDbClaimQuery);
		tdoiDbClaimQuery.setTdoiDbClaimEntry(this);

		return tdoiDbClaimQuery;
	}

	public TdoiDbClaimQueryDTO removeTdoiDbClaimQuery(TdoiDbClaimQueryDTO tdoiDbClaimQuery) {
		getTdoiDbClaimQueries().remove(tdoiDbClaimQuery);
		tdoiDbClaimQuery.setTdoiDbClaimEntry(null);

		return tdoiDbClaimQuery;
	}

	public List<TdoiDbClaimRiDtlDTO> getTdoiDbClaimRiDtls() {
		return this.tdoiDbClaimRiDtls;
	}

	public void setTdoiDbClaimRiDtls(List<TdoiDbClaimRiDtlDTO> tdoiDbClaimRiDtls) {
		this.tdoiDbClaimRiDtls = tdoiDbClaimRiDtls;
	}

	public TdoiDbClaimRiDtlDTO addTdoiDbClaimRiDtl(TdoiDbClaimRiDtlDTO tdoiDbClaimRiDtl) {
		getTdoiDbClaimRiDtls().add(tdoiDbClaimRiDtl);
		tdoiDbClaimRiDtl.setTdoiDbClaimEntry(this);

		return tdoiDbClaimRiDtl;
	}

	public TdoiDbClaimRiDtlDTO removeTdoiDbClaimRiDtl(TdoiDbClaimRiDtlDTO tdoiDbClaimRiDtl) {
		getTdoiDbClaimRiDtls().remove(tdoiDbClaimRiDtl);
		tdoiDbClaimRiDtl.setTdoiDbClaimEntry(null);

		return tdoiDbClaimRiDtl;
	}

	
}
