package gov.ifms.doi.legalentry.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.edp.entity.BaseEntity;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_JPA_LEGAL_DTLS", schema = DoiJPAConstants.DOI_SCHEMA)
public class DOIJpaLegalDtlEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5381469809052317308L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LEGAL_DTLS_ID")
	private long legalDtlsId;

	//@Temporal(TemporalType.DATE )
	@Column(name="ACCIDENT_DEATH_DT")
	private Date accidentDeathDt;

	@Temporal(TemporalType.DATE)
	@Column(name="APPEAL_ADMT_DT")
	private Date appealAdmtDt;

	@Column(name="APPEAL_NO", length=30)
	private String appealNo;

	@Column(name="APPEAL_PAID_ID")
	private long appealPaidId;

	@Column(name="APPEAL_REMARKS", length=200)
	private String appealRemarks;

	@Column(name="APPLICANT_NAME", length=100)
	private String applicantName;

	@Column(name="CLAIM_NUMBER", length=40)
	private String claimNumber;

	@Column(name="CMA_NO", length=30)
	private String cmaNo;

	@Column(name="COMMISSION_TYPE", nullable=false, length=20)
	private String commissionType;

	@Temporal(TemporalType.DATE)
	@Column(name="COURT_CASE_DT", nullable=false)
	private Date courtCaseDt;

	@Column(name="COURT_CASE_NO", length=20)
	private String courtCaseNo;

	@Column(name="COURT_DECISION", length=200)
	private String courtDecision;

	@Temporal(TemporalType.DATE)
	@Column(name="COURT_ORDER_DT")
	private Date courtOrderDt;

	@Column(name="COURT_TYPE_ID")
	private long courtTypeId;

	@Column(name="DEAD_PERSON_NAME", length=100)
	private String deadPersonName;

	@Column(name="DEP_PAYMNT_MODE_ID")
	private long depPaymntModeId;

	@Column(name="DEPOSIT_AMOUNT")
	private double depositAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="DEPOSIT_DT")
	private Date depositDt;

	@Column(name="DISTRICT_CASE_NO", length=20)
	private String districtCaseNo;

	@Column(name="DISTRICT_ID")
	private long districtId;

	@Column(name="ORDER_STATUS_ID")
	private long orderStatusId;

	@Column(name="PAID_PAYMNT_MODE_ID")
	private long paidPaymntModeId;

	@Column(name="PAYMENT_AMOUNT")
	private double paymentAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="PAYMENT_DT")
	private Date paymentDt;

	@Column(name="POLICY_NUM", length=40)
	private String policyNum;

	@Column(name="QUERY_DETAILS", length=200)
	private String queryDetails;

	@Column(name="REF_PAYMNT_MODE_ID")
	private long refPaymntModeId;

	@Column(name="REFUND_AMOUNT")
	private double refundAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="REFUND_DT")
	private Date refundDt;

	@Temporal(TemporalType.DATE)
	@Column(name="REPLAY_DT")
	private Date replayDt;

	@Column(name="REPLY_DETAILS", length=200)
	private String replyDetails;

	@Column(name="REV_PETITION_NO", length=30)
	private String revPetitionNo;

	@Temporal(TemporalType.DATE)
	@Column(name="RP_ADMT_DT")
	private Date rpAdmtDt;

	@Column(name="SCHEME_ID")
	private long schemeId;

	
	@Column(name = "ACTIVE_STATUS")
	private int activeStatus;
	
	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	//bi-directional many-to-one association to TdoiJpaLegalEntry
	@ManyToOne(targetEntity=DOIJPALegalDetailEntryEntity.class)
	@JoinColumn(name="LEGAL_ENTRY_ID", referencedColumnName = "LEGAL_ENTRY_ID" , nullable=false)
	private DOIJPALegalDetailEntryEntity doiJpaLegalEntry;

	//bi-directional many-to-one association to DOIJpaLegalOthrPaymentEntity
	@OneToMany(mappedBy="doiJpaLegalDtl", cascade = CascadeType.ALL)
	private List<DOIJpaLegalOthrPaymentEntity> dOIJpaLegalOthrPaymentEntities;

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
	 * @return the doiJpaLegalEntry
	 */
	public DOIJPALegalDetailEntryEntity getDoiJpaLegalEntry() {
		return doiJpaLegalEntry;
	}

	/**
	 * @param doiJpaLegalEntry the doiJpaLegalEntry to set
	 */
	public void setDoiJpaLegalEntry(DOIJPALegalDetailEntryEntity doiJpaLegalEntry) {
		this.doiJpaLegalEntry = doiJpaLegalEntry;
	}

	/**
	 * @return the dOIJpaLegalOthrPaymentEntities
	 */
	public List<DOIJpaLegalOthrPaymentEntity> getdOIJpaLegalOthrPaymentEntities() {
		return dOIJpaLegalOthrPaymentEntities;
	}

	/**
	 * @param dOIJpaLegalOthrPaymentEntities the dOIJpaLegalOthrPaymentEntities to set
	 */
	public void setdOIJpaLegalOthrPaymentEntities(List<DOIJpaLegalOthrPaymentEntity> dOIJpaLegalOthrPaymentEntities) {
		this.dOIJpaLegalOthrPaymentEntities = dOIJpaLegalOthrPaymentEntities;
	}
}