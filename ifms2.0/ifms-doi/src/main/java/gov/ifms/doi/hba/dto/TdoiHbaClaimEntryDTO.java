package gov.ifms.doi.hba.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;
import gov.ifms.doi.jpa.entity.DoiInwardEntry;

/**
 * The persistent class for the TDOI_HBA_CLAIM_ENTRY database table. * @author
 * Sagar Jadhav
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TdoiHbaClaimEntryDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long hbaClaimId;

	private long aadharNum;

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

	private long claimYearId;

	private String emailAddress;

	private String extentOfLoss;

	private String hbaPolicyNo;

	private short insurOtherCompany;

	private String insuredAddress;

	private String insuredName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date inwardAcceptDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date inwardDt;

	private String inwardNo;

	private short isPaymentDone;

	private short isSentForPay;

	private short isSurveyorAssgn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date lossDate;

	private String lossTime;

	private long mobileNum;

	private double paidAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyEndDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyStartDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String rejectReason;

	private long rejectedBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date rejectionDt;

	private double sumInsured;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date survBillDt;

	private String survBillNo;

	private double survFeeAmount;

	private long surveyorId;

	private String surveyorName;

	private double surveyorPayment;

	private String transactionId;

	private TdoiHbaProposalDTO tdoiHbaProposal;

	private DoiInwardEntry tdoiInwardEntry;

	private List<TdoiHbaClaimLossDtlDTO> tdoiHbaClaimLossDtls;

	private List<TdoiHbaClaimRejectDTO> tdoiHbaClaimRejects;

	private List<TdoiHbaClaimWfDTO> tdoiHbaClaimWfs;

	private List<TdoiHbaOthrCompClaimDTO> tdoiHbaOthrCompClaims;

	public long getHbaClaimId() {
		return hbaClaimId;
	}

	public void setHbaClaimId(long hbaClaimId) {
		this.hbaClaimId = hbaClaimId;
	}

	public long getAadharNum() {
		return aadharNum;
	}

	public void setAadharNum(long aadharNum) {
		this.aadharNum = aadharNum;
	}

	public String getCauseOfLoss() {
		return causeOfLoss;
	}

	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}

	public long getChequeNum() {
		return chequeNum;
	}

	public void setChequeNum(long chequeNum) {
		this.chequeNum = chequeNum;
	}

	public long getClaimAcceptById() {
		return claimAcceptById;
	}

	public void setClaimAcceptById(long claimAcceptById) {
		this.claimAcceptById = claimAcceptById;
	}

	public Date getClaimAcceptDt() {
		return claimAcceptDt;
	}

	public void setClaimAcceptDt(Date claimAcceptDt) {
		this.claimAcceptDt = claimAcceptDt;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimEntryStatus() {
		return claimEntryStatus;
	}

	public void setClaimEntryStatus(String claimEntryStatus) {
		this.claimEntryStatus = claimEntryStatus;
	}

	public Date getClaimGenerateDt() {
		return claimGenerateDt;
	}

	public void setClaimGenerateDt(Date claimGenerateDt) {
		this.claimGenerateDt = claimGenerateDt;
	}

	public long getClaimMonthId() {
		return claimMonthId;
	}

	public void setClaimMonthId(long claimMonthId) {
		this.claimMonthId = claimMonthId;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public long getClaimStatusId() {
		return claimStatusId;
	}

	public void setClaimStatusId(long claimStatusId) {
		this.claimStatusId = claimStatusId;
	}

	public long getClaimYearId() {
		return claimYearId;
	}

	public void setClaimYearId(long claimYearId) {
		this.claimYearId = claimYearId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getExtentOfLoss() {
		return extentOfLoss;
	}

	public void setExtentOfLoss(String extentOfLoss) {
		this.extentOfLoss = extentOfLoss;
	}

	public String getHbaPolicyNo() {
		return hbaPolicyNo;
	}

	public void setHbaPolicyNo(String hbaPolicyNo) {
		this.hbaPolicyNo = hbaPolicyNo;
	}

	public short getInsurOtherCompany() {
		return insurOtherCompany;
	}

	public void setInsurOtherCompany(short insurOtherCompany) {
		this.insurOtherCompany = insurOtherCompany;
	}

	public String getInsuredAddress() {
		return insuredAddress;
	}

	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public Date getInwardAcceptDt() {
		return inwardAcceptDt;
	}

	public void setInwardAcceptDt(Date inwardAcceptDt) {
		this.inwardAcceptDt = inwardAcceptDt;
	}

	public Date getInwardDt() {
		return inwardDt;
	}

	public void setInwardDt(Date inwardDt) {
		this.inwardDt = inwardDt;
	}

	public String getInwardNo() {
		return inwardNo;
	}

	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	public short getIsPaymentDone() {
		return isPaymentDone;
	}

	public void setIsPaymentDone(short isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}

	public short getIsSentForPay() {
		return isSentForPay;
	}

	public void setIsSentForPay(short isSentForPay) {
		this.isSentForPay = isSentForPay;
	}

	public short getIsSurveyorAssgn() {
		return isSurveyorAssgn;
	}

	public void setIsSurveyorAssgn(short isSurveyorAssgn) {
		this.isSurveyorAssgn = isSurveyorAssgn;
	}

	public Date getLossDate() {
		return lossDate;
	}

	public void setLossDate(Date lossDate) {
		this.lossDate = lossDate;
	}

	public String getLossTime() {
		return lossTime;
	}

	public void setLossTime(String lossTime) {
		this.lossTime = lossTime;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Date getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public long getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(long rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public Date getRejectionDt() {
		return rejectionDt;
	}

	public void setRejectionDt(Date rejectionDt) {
		this.rejectionDt = rejectionDt;
	}

	public double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public Date getSurvBillDt() {
		return survBillDt;
	}

	public void setSurvBillDt(Date survBillDt) {
		this.survBillDt = survBillDt;
	}

	public String getSurvBillNo() {
		return survBillNo;
	}

	public void setSurvBillNo(String survBillNo) {
		this.survBillNo = survBillNo;
	}

	public double getSurvFeeAmount() {
		return survFeeAmount;
	}

	public void setSurvFeeAmount(double survFeeAmount) {
		this.survFeeAmount = survFeeAmount;
	}

	public long getSurveyorId() {
		return surveyorId;
	}

	public void setSurveyorId(long surveyorId) {
		this.surveyorId = surveyorId;
	}

	public String getSurveyorName() {
		return surveyorName;
	}

	public void setSurveyorName(String surveyorName) {
		this.surveyorName = surveyorName;
	}

	public double getSurveyorPayment() {
		return surveyorPayment;
	}

	public void setSurveyorPayment(double surveyorPayment) {
		this.surveyorPayment = surveyorPayment;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public TdoiHbaProposalDTO getTdoiHbaProposal() {
		return tdoiHbaProposal;
	}

	public void setTdoiHbaProposal(TdoiHbaProposalDTO tdoiHbaProposal) {
		this.tdoiHbaProposal = tdoiHbaProposal;
	}

	public DoiInwardEntry getTdoiInwardEntry() {
		return tdoiInwardEntry;
	}

	public void setTdoiInwardEntry(DoiInwardEntry tdoiInwardEntry) {
		this.tdoiInwardEntry = tdoiInwardEntry;
	}

	public List<TdoiHbaClaimLossDtlDTO> getTdoiHbaClaimLossDtls() {
		return tdoiHbaClaimLossDtls;
	}

	public void setTdoiHbaClaimLossDtls(List<TdoiHbaClaimLossDtlDTO> tdoiHbaClaimLossDtls) {
		this.tdoiHbaClaimLossDtls = tdoiHbaClaimLossDtls;
	}

	public List<TdoiHbaClaimRejectDTO> getTdoiHbaClaimRejects() {
		return tdoiHbaClaimRejects;
	}

	public void setTdoiHbaClaimRejects(List<TdoiHbaClaimRejectDTO> tdoiHbaClaimRejects) {
		this.tdoiHbaClaimRejects = tdoiHbaClaimRejects;
	}

	public List<TdoiHbaClaimWfDTO> getTdoiHbaClaimWfs() {
		return tdoiHbaClaimWfs;
	}

	public void setTdoiHbaClaimWfs(List<TdoiHbaClaimWfDTO> tdoiHbaClaimWfs) {
		this.tdoiHbaClaimWfs = tdoiHbaClaimWfs;
	}

	public List<TdoiHbaOthrCompClaimDTO> getTdoiHbaOthrCompClaims() {
		return tdoiHbaOthrCompClaims;
	}

	public void setTdoiHbaOthrCompClaims(List<TdoiHbaOthrCompClaimDTO> tdoiHbaOthrCompClaims) {
		this.tdoiHbaOthrCompClaims = tdoiHbaOthrCompClaims;
	}


}
