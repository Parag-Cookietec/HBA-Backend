/**
 * 
 */
package gov.ifms.doi.legalentry.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Rudra
 *
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class DOIJpaLegalDtlDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6504517111434518271L;
	
	private long legalDtlsId;
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date accidentDeathDt;

	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date appealAdmtDt;

	private String appealNo;

	private long appealPaidId;

	private String appealRemarks;

	private String applicantName;

	private String claimNumber;

	private String cmaNo;

	private String commissionType;

	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date courtCaseDt;

	private String courtCaseNo;

	private String courtDecision;

	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date courtOrderDt;

	private long courtTypeId;

	private String deadPersonName;

	private long depPaymntModeId;

	private double depositAmount;

	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date depositDt;

	private String districtCaseNo;

	private long districtId;

	private long orderStatusId;

	private long paidPaymntModeId;

	private double paymentAmount;

	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date paymentDt;

	private String policyNum;

	private String queryDetails;

	private long refPaymntModeId;

	private double refundAmount;

	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date refundDt;

	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date replayDt;

	private String replyDetails;

	private String revPetitionNo;

	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date rpAdmtDt;

	private long schemeId;
	
	private List<DOIJpaLegalOthrPaymentDTO> doiJpaLegalOthrPaymentDTO;

	/**
	 * @return the legalDtlsId
	 */
	public long getLegalDtlsId() {
		return legalDtlsId;
	}

	/**
	 * @param legalDtlsId the legalDtlsId to set
	 */
	public void setLegalDtlsId(long legalDtlsId) {
		this.legalDtlsId = legalDtlsId;
	}

	/**
	 * @return the accidentDeathDt
	 */
	public Date getAccidentDeathDt() {
		return accidentDeathDt;
	}

	/**
	 * @param accidentDeathDt the accidentDeathDt to set
	 */
	public void setAccidentDeathDt(Date accidentDeathDt) {
		this.accidentDeathDt = accidentDeathDt;
	}

	/**
	 * @return the appealAdmtDt
	 */
	public Date getAppealAdmtDt() {
		return appealAdmtDt;
	}

	/**
	 * @param appealAdmtDt the appealAdmtDt to set
	 */
	public void setAppealAdmtDt(Date appealAdmtDt) {
		this.appealAdmtDt = appealAdmtDt;
	}

	/**
	 * @return the appealNo
	 */
	public String getAppealNo() {
		return appealNo;
	}

	/**
	 * @param appealNo the appealNo to set
	 */
	public void setAppealNo(String appealNo) {
		this.appealNo = appealNo;
	}

	/**
	 * @return the appealPaidId
	 */
	public long getAppealPaidId() {
		return appealPaidId;
	}

	/**
	 * @param appealPaidId the appealPaidId to set
	 */
	public void setAppealPaidId(long appealPaidId) {
		this.appealPaidId = appealPaidId;
	}

	/**
	 * @return the appealRemarks
	 */
	public String getAppealRemarks() {
		return appealRemarks;
	}

	/**
	 * @param appealRemarks the appealRemarks to set
	 */
	public void setAppealRemarks(String appealRemarks) {
		this.appealRemarks = appealRemarks;
	}

	/**
	 * @return the applicantName
	 */
	public String getApplicantName() {
		return applicantName;
	}

	/**
	 * @param applicantName the applicantName to set
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	/**
	 * @return the claimNumber
	 */
	public String getClaimNumber() {
		return claimNumber;
	}

	/**
	 * @param claimNumber the claimNumber to set
	 */
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	/**
	 * @return the cmaNo
	 */
	public String getCmaNo() {
		return cmaNo;
	}

	/**
	 * @param cmaNo the cmaNo to set
	 */
	public void setCmaNo(String cmaNo) {
		this.cmaNo = cmaNo;
	}

	/**
	 * @return the commissionType
	 */
	public String getCommissionType() {
		return commissionType;
	}

	/**
	 * @param commissionType the commissionType to set
	 */
	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}

	/**
	 * @return the courtCaseDt
	 */
	public Date getCourtCaseDt() {
		return courtCaseDt;
	}

	/**
	 * @param courtCaseDt the courtCaseDt to set
	 */
	public void setCourtCaseDt(Date courtCaseDt) {
		this.courtCaseDt = courtCaseDt;
	}

	/**
	 * @return the courtCaseNo
	 */
	public String getCourtCaseNo() {
		return courtCaseNo;
	}

	/**
	 * @param courtCaseNo the courtCaseNo to set
	 */
	public void setCourtCaseNo(String courtCaseNo) {
		this.courtCaseNo = courtCaseNo;
	}

	/**
	 * @return the courtDecision
	 */
	public String getCourtDecision() {
		return courtDecision;
	}

	/**
	 * @param courtDecision the courtDecision to set
	 */
	public void setCourtDecision(String courtDecision) {
		this.courtDecision = courtDecision;
	}

	/**
	 * @return the courtOrderDt
	 */
	public Date getCourtOrderDt() {
		return courtOrderDt;
	}

	/**
	 * @param courtOrderDt the courtOrderDt to set
	 */
	public void setCourtOrderDt(Date courtOrderDt) {
		this.courtOrderDt = courtOrderDt;
	}

	/**
	 * @return the courtTypeId
	 */
	public long getCourtTypeId() {
		return courtTypeId;
	}

	/**
	 * @param courtTypeId the courtTypeId to set
	 */
	public void setCourtTypeId(long courtTypeId) {
		this.courtTypeId = courtTypeId;
	}

	/**
	 * @return the deadPersonName
	 */
	public String getDeadPersonName() {
		return deadPersonName;
	}

	/**
	 * @param deadPersonName the deadPersonName to set
	 */
	public void setDeadPersonName(String deadPersonName) {
		this.deadPersonName = deadPersonName;
	}

	/**
	 * @return the depPaymntModeId
	 */
	public long getDepPaymntModeId() {
		return depPaymntModeId;
	}

	/**
	 * @param depPaymntModeId the depPaymntModeId to set
	 */
	public void setDepPaymntModeId(long depPaymntModeId) {
		this.depPaymntModeId = depPaymntModeId;
	}

	/**
	 * @return the depositAmount
	 */
	public double getDepositAmount() {
		return depositAmount;
	}

	/**
	 * @param depositAmount the depositAmount to set
	 */
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	/**
	 * @return the depositDt
	 */
	public Date getDepositDt() {
		return depositDt;
	}

	/**
	 * @param depositDt the depositDt to set
	 */
	public void setDepositDt(Date depositDt) {
		this.depositDt = depositDt;
	}

	/**
	 * @return the districtCaseNo
	 */
	public String getDistrictCaseNo() {
		return districtCaseNo;
	}

	/**
	 * @param districtCaseNo the districtCaseNo to set
	 */
	public void setDistrictCaseNo(String districtCaseNo) {
		this.districtCaseNo = districtCaseNo;
	}

	/**
	 * @return the districtId
	 */
	public long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the orderStatusId
	 */
	public long getOrderStatusId() {
		return orderStatusId;
	}

	/**
	 * @param orderStatusId the orderStatusId to set
	 */
	public void setOrderStatusId(long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	/**
	 * @return the paidPaymntModeId
	 */
	public long getPaidPaymntModeId() {
		return paidPaymntModeId;
	}

	/**
	 * @param paidPaymntModeId the paidPaymntModeId to set
	 */
	public void setPaidPaymntModeId(long paidPaymntModeId) {
		this.paidPaymntModeId = paidPaymntModeId;
	}

	/**
	 * @return the paymentAmount
	 */
	public double getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
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
	 * @return the policyNum
	 */
	public String getPolicyNum() {
		return policyNum;
	}

	/**
	 * @param policyNum the policyNum to set
	 */
	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}

	/**
	 * @return the queryDetails
	 */
	public String getQueryDetails() {
		return queryDetails;
	}

	/**
	 * @param queryDetails the queryDetails to set
	 */
	public void setQueryDetails(String queryDetails) {
		this.queryDetails = queryDetails;
	}

	/**
	 * @return the refPaymntModeId
	 */
	public long getRefPaymntModeId() {
		return refPaymntModeId;
	}

	/**
	 * @param refPaymntModeId the refPaymntModeId to set
	 */
	public void setRefPaymntModeId(long refPaymntModeId) {
		this.refPaymntModeId = refPaymntModeId;
	}

	/**
	 * @return the refundAmount
	 */
	public double getRefundAmount() {
		return refundAmount;
	}

	/**
	 * @param refundAmount the refundAmount to set
	 */
	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	/**
	 * @return the refundDt
	 */
	public Date getRefundDt() {
		return refundDt;
	}

	/**
	 * @param refundDt the refundDt to set
	 */
	public void setRefundDt(Date refundDt) {
		this.refundDt = refundDt;
	}

	/**
	 * @return the replayDt
	 */
	public Date getReplayDt() {
		return replayDt;
	}

	/**
	 * @param replayDt the replayDt to set
	 */
	public void setReplayDt(Date replayDt) {
		this.replayDt = replayDt;
	}

	/**
	 * @return the replyDetails
	 */
	public String getReplyDetails() {
		return replyDetails;
	}

	/**
	 * @param replyDetails the replyDetails to set
	 */
	public void setReplyDetails(String replyDetails) {
		this.replyDetails = replyDetails;
	}

	/**
	 * @return the revPetitionNo
	 */
	public String getRevPetitionNo() {
		return revPetitionNo;
	}

	/**
	 * @param revPetitionNo the revPetitionNo to set
	 */
	public void setRevPetitionNo(String revPetitionNo) {
		this.revPetitionNo = revPetitionNo;
	}

	/**
	 * @return the rpAdmtDt
	 */
	public Date getRpAdmtDt() {
		return rpAdmtDt;
	}

	/**
	 * @param rpAdmtDt the rpAdmtDt to set
	 */
	public void setRpAdmtDt(Date rpAdmtDt) {
		this.rpAdmtDt = rpAdmtDt;
	}

	/**
	 * @return the schemeId
	 */
	public long getSchemeId() {
		return schemeId;
	}

	/**
	 * @param schemeId the schemeId to set
	 */
	public void setSchemeId(long schemeId) {
		this.schemeId = schemeId;
	}

	/**
	 * @return the doiJpaLegalOthrPaymentDTO
	 */
	public List<DOIJpaLegalOthrPaymentDTO> getDoiJpaLegalOthrPaymentDTO() {
		return doiJpaLegalOthrPaymentDTO;
	}

	/**
	 * @param doiJpaLegalOthrPaymentDTO the doiJpaLegalOthrPaymentDTO to set
	 */
	public void setDoiJpaLegalOthrPaymentDTO(List<DOIJpaLegalOthrPaymentDTO> doiJpaLegalOthrPaymentDTO) {
		this.doiJpaLegalOthrPaymentDTO = doiJpaLegalOthrPaymentDTO;
	}

}
