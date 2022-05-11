package gov.ifms.doi.coinsurance.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.workflow.entity.DoiCoinsClaimHdrWfEntity;
import gov.ifms.edp.entity.BaseEntity;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_COINS_CLAIM_HDR", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiCoinsClaimHdrEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 452212074605370511L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COINS_CLAIM_ID", unique=true, nullable=false)
	private long coinsClaimId;

	@Column(name="ACCEPTED_POL_DTLS", length=100)
	private String acceptedPolDtls;

	@Column(name="CHALLAN_AMT")
	private double challanAmt;

	@Temporal(TemporalType.DATE)
	@Column(name="CHALLAN_DT")
	private Date challanDt;

	@Column(name="CLAIM_AMOUNT")
	private double claimAmount;

	@Column(name="CLAIM_DESC", length=100)
	private String claimDesc;

	@Column(name="CLAIM_FORM_PAGE_NO")
	private short claimFormPageNo;

	@Column(name="CLAIM_STATUS", length=30)
	private String claimStatus;

	@Column(name="CLAIM_STATUS_ID")
	private long claimStatusId;

	@Temporal(TemporalType.DATE)
	@Column(name="COINS_CLAIM_DT")
	private Date coinsClaimDt;

	@Column(name="COINS_CLAIM_NO", length=30)
	private String coinsClaimNo;

	@Column(name="COINS_POLICY_HDR_ID", nullable=false)
	private long coinsPolicyHdrId;

	@Column(name="COINS_POLICY_NO", length=30)
	private String coinsPolicyNo;

	@Temporal(TemporalType.DATE)
	@Column(name="DAMAGE_DT")
	private Date damageDt;

	@Column(name="DAMAGE_REASON", length=200)
	private String damageReason;

	@Column(name="DMAMGE_SCALP_AMT")
	private double dmamgeScalpAmt;

	@Column(name="DOI_RESP_PAGE_NO")
	private short doiRespPageNo;

	@Column(name="GIF_CLAIM_AMT")
	private double gifClaimAmt;

	@Column(name="GIF_CLAIM_PERC")
	private double gifClaimPerc;

	@Column(name="GIF_SHARE_PERC")
	private double gifSharePerc;

	@Column(name="GIF_SURVEY_AMT")
	private double gifSurveyAmt;

	@Column(name="GIF_TOT_AMT")
	private double gifTotAmt;

	@Column(name="INSURED_ADDRESS", length=100)
	private String insuredAddress;

	@Column(name="INSURED_NAME", length=60)
	private String insuredName;

	@Column(name="INTIM_CLAIM_AMT")
	private double intimClaimAmt;

	@Column(name="INTIM_CLAIM_PERC")
	private double intimClaimPerc;

	@Column(name="INTIM_SURVEY_AMT")
	private double intimSurveyAmt;

	@Column(name="INTIM_TOT_AMT")
	private double intimTotAmt;

	@Temporal(TemporalType.DATE)
	@Column(name="INTIMATION_DT")
	private Date intimationDt;

	@Column(name="INTIMATION_THRU_ID")
	private long intimationThruId;

	@Column(name="IS_CLAIM_FORM_RECV")
	private long isClaimFormRecv;

	@Column(name="IS_CLAIM_UNDER_INV")
	private long isClaimUnderInv;

	@Column(name="IS_DOI_RESPONSIBLE")
	private long isDoiResponsible;

	@Column(name="IS_SURVEY_REP_RECV")
	private long isSurveyRepRecv;

	@Column(name="IS_TP_CLAIM_RECV")
	private long isTpClaimRecv;

	@Column(name="LEADER_ADDRESS", length=100)
	private String leaderAddress;

	@Column(name="LEADER_CLAIM_AMT")
	private double leaderClaimAmt;

	@Column(name="LEADER_CLAIM_ID", length=30)
	private String leaderClaimId;

	@Column(name="LEADER_EMAIL", length=40)
	private String leaderEmail;

	@Column(name="LEADER_ID")
	private long leaderId;

	@Column(name="LEADER_NAME", length=60)
	private String leaderName;

	@Column(name="LEADER_PAID_PERC")
	private double leaderPaidPerc;

	@Column(name="LEADER_PHONE", length=20)
	private String leaderPhone;

	@Column(name="LEADER_POLICY_NO", length=30)
	private String leaderPolicyNo;

	@Column(name="LEADER_SURVEY_AMT")
	private double leaderSurveyAmt;

	@Column(name="LEADER_TOT_AMT")
	private double leaderTotAmt;

	@Column(name="NET_CLAIM_AMT")
	private double netClaimAmt;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_END_DT")
	private Date policyEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_START_DT")
	private Date policyStartDt;

	@Column(name="POLICY_TYPE_ID")
	private long policyTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name="PREM_PAID_CHALLAN_DT")
	private Date premPaidChallanDt;

	@Column(name="PREMIUM_AMT")
	private double premiumAmt;

	@Column(name="PREMIUM_SHARE_AMT")
	private double premiumShareAmt;

	@Temporal(TemporalType.DATE)
	@Column(name="RAIL_RECEIPT_DT")
	private Date railReceiptDt;

	@Column(name="RAIL_RECEIPT_NO", length=20)
	private String railReceiptNo;

	@Column(name="RECEIVED_AMT")
	private double receivedAmt;

	@Column(name="REFERENCE_DT")
	private Timestamp referenceDt;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;

	@Column(length=200)
	private String remarks;

	@Column(name="RISK_LOCATION", length=100)
	private String riskLocation;

	@Column(name="SUM_INSURED_AMT")
	private double sumInsuredAmt;

	@Column(name="SURVEY_REP_PAGE_NO")
	private short surveyRepPageNo;

	@Column(name="TOT_CLAIM_AMT")
	private double totClaimAmt;

	@Column(name="TOT_SURVEY_AMT")
	private double totSurveyAmt;

	//bi-directional many-to-one association to DoiCoinsClaimHdrWfEntity
	@OneToMany(mappedBy="doiCoinsClaimHdrEntity")
	private List<DoiCoinsClaimHdrWfEntity> doiCoinsClaimHdrWfEntities;

	//bi-directional many-to-one association to DoiCoinsClaimRiDtlEntity
	@OneToMany(mappedBy="doiCoinsClaimHdrEntity")
	private List<DoiCoinsClaimRiDtlEntity> doiCoinsClaimRiDtlEntities;

	public long getCoinsClaimId() {
		return this.coinsClaimId;
	}

	public void setCoinsClaimId(long coinsClaimId) {
		this.coinsClaimId = coinsClaimId;
	}

	public String getAcceptedPolDtls() {
		return this.acceptedPolDtls;
	}

	public void setAcceptedPolDtls(String acceptedPolDtls) {
		this.acceptedPolDtls = acceptedPolDtls;
	}

	public double getChallanAmt() {
		return this.challanAmt;
	}

	public void setChallanAmt(double challanAmt) {
		this.challanAmt = challanAmt;
	}

	public Date getChallanDt() {
		return this.challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public double getClaimAmount() {
		return this.claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimDesc() {
		return this.claimDesc;
	}

	public void setClaimDesc(String claimDesc) {
		this.claimDesc = claimDesc;
	}

	public short getClaimFormPageNo() {
		return this.claimFormPageNo;
	}

	public void setClaimFormPageNo(short claimFormPageNo) {
		this.claimFormPageNo = claimFormPageNo;
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

	public Date getCoinsClaimDt() {
		return this.coinsClaimDt;
	}

	public void setCoinsClaimDt(Date coinsClaimDt) {
		this.coinsClaimDt = coinsClaimDt;
	}

	public String getCoinsClaimNo() {
		return this.coinsClaimNo;
	}

	public void setCoinsClaimNo(String coinsClaimNo) {
		this.coinsClaimNo = coinsClaimNo;
	}

	public long getCoinsPolicyHdrId() {
		return this.coinsPolicyHdrId;
	}

	public void setCoinsPolicyHdrId(long coinsPolicyHdrId) {
		this.coinsPolicyHdrId = coinsPolicyHdrId;
	}

	public String getCoinsPolicyNo() {
		return this.coinsPolicyNo;
	}

	public void setCoinsPolicyNo(String coinsPolicyNo) {
		this.coinsPolicyNo = coinsPolicyNo;
	}

	public Date getDamageDt() {
		return this.damageDt;
	}

	public void setDamageDt(Date damageDt) {
		this.damageDt = damageDt;
	}

	public String getDamageReason() {
		return this.damageReason;
	}

	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason;
	}

	public double getDmamgeScalpAmt() {
		return this.dmamgeScalpAmt;
	}

	public void setDmamgeScalpAmt(double dmamgeScalpAmt) {
		this.dmamgeScalpAmt = dmamgeScalpAmt;
	}

	public short getDoiRespPageNo() {
		return this.doiRespPageNo;
	}

	public void setDoiRespPageNo(short doiRespPageNo) {
		this.doiRespPageNo = doiRespPageNo;
	}

	public double getGifClaimAmt() {
		return this.gifClaimAmt;
	}

	public void setGifClaimAmt(double gifClaimAmt) {
		this.gifClaimAmt = gifClaimAmt;
	}

	public double getGifClaimPerc() {
		return this.gifClaimPerc;
	}

	public void setGifClaimPerc(double gifClaimPerc) {
		this.gifClaimPerc = gifClaimPerc;
	}

	public double getGifSharePerc() {
		return this.gifSharePerc;
	}

	public void setGifSharePerc(double gifSharePerc) {
		this.gifSharePerc = gifSharePerc;
	}

	public double getGifSurveyAmt() {
		return this.gifSurveyAmt;
	}

	public void setGifSurveyAmt(double gifSurveyAmt) {
		this.gifSurveyAmt = gifSurveyAmt;
	}

	public double getGifTotAmt() {
		return this.gifTotAmt;
	}

	public void setGifTotAmt(double gifTotAmt) {
		this.gifTotAmt = gifTotAmt;
	}

	public String getInsuredAddress() {
		return this.insuredAddress;
	}

	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	public String getInsuredName() {
		return this.insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public double getIntimClaimAmt() {
		return this.intimClaimAmt;
	}

	public void setIntimClaimAmt(double intimClaimAmt) {
		this.intimClaimAmt = intimClaimAmt;
	}

	public double getIntimClaimPerc() {
		return this.intimClaimPerc;
	}

	public void setIntimClaimPerc(double intimClaimPerc) {
		this.intimClaimPerc = intimClaimPerc;
	}

	public double getIntimSurveyAmt() {
		return this.intimSurveyAmt;
	}

	public void setIntimSurveyAmt(double intimSurveyAmt) {
		this.intimSurveyAmt = intimSurveyAmt;
	}

	public double getIntimTotAmt() {
		return this.intimTotAmt;
	}

	public void setIntimTotAmt(double intimTotAmt) {
		this.intimTotAmt = intimTotAmt;
	}

	public Date getIntimationDt() {
		return this.intimationDt;
	}

	public void setIntimationDt(Date intimationDt) {
		this.intimationDt = intimationDt;
	}

	public long getIntimationThruId() {
		return this.intimationThruId;
	}

	public void setIntimationThruId(long intimationThruId) {
		this.intimationThruId = intimationThruId;
	}

	public long getIsClaimFormRecv() {
		return this.isClaimFormRecv;
	}

	public void setIsClaimFormRecv(long isClaimFormRecv) {
		this.isClaimFormRecv = isClaimFormRecv;
	}

	public long getIsClaimUnderInv() {
		return this.isClaimUnderInv;
	}

	public void setIsClaimUnderInv(long isClaimUnderInv) {
		this.isClaimUnderInv = isClaimUnderInv;
	}

	public long getIsDoiResponsible() {
		return this.isDoiResponsible;
	}

	public void setIsDoiResponsible(long isDoiResponsible) {
		this.isDoiResponsible = isDoiResponsible;
	}

	public long getIsSurveyRepRecv() {
		return this.isSurveyRepRecv;
	}

	public void setIsSurveyRepRecv(long isSurveyRepRecv) {
		this.isSurveyRepRecv = isSurveyRepRecv;
	}

	public long getIsTpClaimRecv() {
		return this.isTpClaimRecv;
	}

	public void setIsTpClaimRecv(long isTpClaimRecv) {
		this.isTpClaimRecv = isTpClaimRecv;
	}

	public String getLeaderAddress() {
		return this.leaderAddress;
	}

	public void setLeaderAddress(String leaderAddress) {
		this.leaderAddress = leaderAddress;
	}

	public double getLeaderClaimAmt() {
		return this.leaderClaimAmt;
	}

	public void setLeaderClaimAmt(double leaderClaimAmt) {
		this.leaderClaimAmt = leaderClaimAmt;
	}

	public String getLeaderClaimId() {
		return this.leaderClaimId;
	}

	public void setLeaderClaimId(String leaderClaimId) {
		this.leaderClaimId = leaderClaimId;
	}

	public String getLeaderEmail() {
		return this.leaderEmail;
	}

	public void setLeaderEmail(String leaderEmail) {
		this.leaderEmail = leaderEmail;
	}

	public long getLeaderId() {
		return this.leaderId;
	}

	public void setLeaderId(long leaderId) {
		this.leaderId = leaderId;
	}

	public String getLeaderName() {
		return this.leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public double getLeaderPaidPerc() {
		return this.leaderPaidPerc;
	}

	public void setLeaderPaidPerc(double leaderPaidPerc) {
		this.leaderPaidPerc = leaderPaidPerc;
	}

	public String getLeaderPhone() {
		return this.leaderPhone;
	}

	public void setLeaderPhone(String leaderPhone) {
		this.leaderPhone = leaderPhone;
	}

	public String getLeaderPolicyNo() {
		return this.leaderPolicyNo;
	}

	public void setLeaderPolicyNo(String leaderPolicyNo) {
		this.leaderPolicyNo = leaderPolicyNo;
	}

	public double getLeaderSurveyAmt() {
		return this.leaderSurveyAmt;
	}

	public void setLeaderSurveyAmt(double leaderSurveyAmt) {
		this.leaderSurveyAmt = leaderSurveyAmt;
	}

	public double getLeaderTotAmt() {
		return this.leaderTotAmt;
	}

	public void setLeaderTotAmt(double leaderTotAmt) {
		this.leaderTotAmt = leaderTotAmt;
	}

	public double getNetClaimAmt() {
		return this.netClaimAmt;
	}

	public void setNetClaimAmt(double netClaimAmt) {
		this.netClaimAmt = netClaimAmt;
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

	public long getPolicyTypeId() {
		return this.policyTypeId;
	}

	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	public Date getPremPaidChallanDt() {
		return this.premPaidChallanDt;
	}

	public void setPremPaidChallanDt(Date premPaidChallanDt) {
		this.premPaidChallanDt = premPaidChallanDt;
	}

	public double getPremiumAmt() {
		return this.premiumAmt;
	}

	public void setPremiumAmt(double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	public double getPremiumShareAmt() {
		return this.premiumShareAmt;
	}

	public void setPremiumShareAmt(double premiumShareAmt) {
		this.premiumShareAmt = premiumShareAmt;
	}

	public Date getRailReceiptDt() {
		return this.railReceiptDt;
	}

	public void setRailReceiptDt(Date railReceiptDt) {
		this.railReceiptDt = railReceiptDt;
	}

	public String getRailReceiptNo() {
		return this.railReceiptNo;
	}

	public void setRailReceiptNo(String railReceiptNo) {
		this.railReceiptNo = railReceiptNo;
	}

	public double getReceivedAmt() {
		return this.receivedAmt;
	}

	public void setReceivedAmt(double receivedAmt) {
		this.receivedAmt = receivedAmt;
	}

	public Timestamp getReferenceDt() {
		return this.referenceDt;
	}

	public void setReferenceDt(Timestamp referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRiskLocation() {
		return this.riskLocation;
	}

	public void setRiskLocation(String riskLocation) {
		this.riskLocation = riskLocation;
	}

	public double getSumInsuredAmt() {
		return this.sumInsuredAmt;
	}

	public void setSumInsuredAmt(double sumInsuredAmt) {
		this.sumInsuredAmt = sumInsuredAmt;
	}

	public short getSurveyRepPageNo() {
		return this.surveyRepPageNo;
	}

	public void setSurveyRepPageNo(short surveyRepPageNo) {
		this.surveyRepPageNo = surveyRepPageNo;
	}

	public double getTotClaimAmt() {
		return this.totClaimAmt;
	}

	public void setTotClaimAmt(double totClaimAmt) {
		this.totClaimAmt = totClaimAmt;
	}

	public double getTotSurveyAmt() {
		return this.totSurveyAmt;
	}

	public void setTotSurveyAmt(double totSurveyAmt) {
		this.totSurveyAmt = totSurveyAmt;
	}

	public List<DoiCoinsClaimHdrWfEntity> getTdoiCoinsClaimHdrWfs() {
		return this.doiCoinsClaimHdrWfEntities;
	}

	public void setTdoiCoinsClaimHdrWfs(List<DoiCoinsClaimHdrWfEntity> doiCoinsClaimHdrWfEntities) {
		this.doiCoinsClaimHdrWfEntities = doiCoinsClaimHdrWfEntities;
	}

	public DoiCoinsClaimHdrWfEntity addTdoiCoinsClaimHdrWf(DoiCoinsClaimHdrWfEntity doiCoinsClaimHdrWfEntity) {
		getTdoiCoinsClaimHdrWfs().add(doiCoinsClaimHdrWfEntity);
		doiCoinsClaimHdrWfEntity.setDoiCoinsClaimHdrEntity(this);

		return doiCoinsClaimHdrWfEntity;
	}

	public DoiCoinsClaimHdrWfEntity removeTdoiCoinsClaimHdrWf(DoiCoinsClaimHdrWfEntity doiCoinsClaimHdrWfEntity) {
		getTdoiCoinsClaimHdrWfs().remove(doiCoinsClaimHdrWfEntity);
		doiCoinsClaimHdrWfEntity.setDoiCoinsClaimHdrEntity(null);

		return doiCoinsClaimHdrWfEntity;
	}

	public List<DoiCoinsClaimRiDtlEntity> getTdoiCoinsClaimRiDtls() {
		return this.doiCoinsClaimRiDtlEntities;
	}

	public void setTdoiCoinsClaimRiDtls(List<DoiCoinsClaimRiDtlEntity> doiCoinsClaimRiDtlEntities) {
		this.doiCoinsClaimRiDtlEntities = doiCoinsClaimRiDtlEntities;
	}

	public DoiCoinsClaimRiDtlEntity addTdoiCoinsClaimRiDtl(DoiCoinsClaimRiDtlEntity doiCoinsClaimRiDtlEntity) {
		getTdoiCoinsClaimRiDtls().add(doiCoinsClaimRiDtlEntity);
		doiCoinsClaimRiDtlEntity.setDoiCoinsClaimHdrEntity(this);

		return doiCoinsClaimRiDtlEntity;
	}

	public DoiCoinsClaimRiDtlEntity removeTdoiCoinsClaimRiDtl(DoiCoinsClaimRiDtlEntity doiCoinsClaimRiDtlEntity) {
		getTdoiCoinsClaimRiDtls().remove(doiCoinsClaimRiDtlEntity);
		doiCoinsClaimRiDtlEntity.setDoiCoinsClaimHdrEntity(null);

		return doiCoinsClaimRiDtlEntity;
	}

}