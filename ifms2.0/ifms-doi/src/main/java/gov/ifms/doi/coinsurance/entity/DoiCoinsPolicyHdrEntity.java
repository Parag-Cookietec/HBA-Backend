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
import gov.ifms.doi.workflow.entity.DoiCoinsPolicyHdrWfEntity;
import gov.ifms.edp.entity.BaseEntity;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_COINS_POLICY_HDR", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiCoinsPolicyHdrEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5129338544777142124L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COINS_POLICY_HDR_ID", unique=true, nullable=false)
	private long coinsPolicyHdrId;

	@Column(name="BASIC_SUM_INSRD")
	private double basicSumInsrd;

	@Column(name="CHALLAN_NO", length=30)
	private String challanNo;

	@Column(name="INSURED_ADDRESS", length=100)
	private String insuredAddress;

	@Column(name="INSURED_CITY", length=50)
	private String insuredCity;

	@Column(name="INSURED_DISTRICT_ID")
	private long insuredDistrictId;

	@Column(name="INSURED_NAME", length=60)
	private String insuredName;

	@Column(name="INSURED_PINCODE")
	private long insuredPincode;

	@Column(name="INSURED_TALUKA_ID")
	private long insuredTalukaId;

	@Column(name="IS_FAC_TREATY")
	private long isFacTreaty;

	@Column(name="IS_RI_REQD")
	private long isRiReqd;

	@Column(name="LEADER_ADDR_ID")
	private long leaderAddrId;

	@Column(name="LEADER_ADDRESS", length=100)
	private String leaderAddress;

	@Column(name="LEADER_EMAIL", length=40)
	private String leaderEmail;

	@Column(name="LEADER_ID")
	private long leaderId;

	@Column(name="LEADER_NAME", length=60)
	private String leaderName;

	@Column(name="LEADER_PHONE", length=20)
	private String leaderPhone;

	@Column(name="LEADER_POLICY_NO", length=30)
	private String leaderPolicyNo;

	@Column(name="OUR_AGENT_COMMISS")
	private double ourAgentCommiss;

	@Column(name="OUR_SHARE_PC")
	private double ourSharePc;

	@Column(name="OUR_SHARE_PREMIUM")
	private double ourSharePremium;

	@Column(name="OUR_SHARE_SI")
	private double ourShareSi;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_END_DT")
	private Date policyEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_ISS_DT")
	private Date policyIssDt;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_ISSUE_DT")
	private Date policyIssueDt;

	@Column(name="POLICY_NO", length=30)
	private String policyNo;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_START_DT")
	private Date policyStartDt;

	@Column(name="POLICY_TYPE_ID")
	private long policyTypeId;

	@Column(name="PREMIUM_AMOUNT")
	private double premiumAmount;

	@Column(name="REFERENCE_DT")
	private Timestamp referenceDt;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;

	@Column(length=100)
	private String remarks;

	@Column(name="RISK_DETAILS", length=100)
	private String riskDetails;

	@Column(name="RISK_TYPE_ID")
	private long riskTypeId;

	@Column(name="TERROR_POOL", length=100)
	private String terrorPool;

	@Column(name="TOTAL_SI_AMT")
	private double totalSiAmt;

	//bi-directional many-to-one association to DoiCoinsPolicyHdrWfEntity
	@OneToMany(mappedBy="doiCoinsPolicyHdrEntity")
	private List<DoiCoinsPolicyHdrWfEntity> doiCoinsPolicyHdrWfEntities;

	//bi-directional many-to-one association to DoiCoinsPolicyRiEntity
	@OneToMany(mappedBy="doiCoinsPolicyHdrEntity")
	private List<DoiCoinsPolicyRiEntity> doiCoinsPolicyRiEntities;

	public long getCoinsPolicyHdrId() {
		return this.coinsPolicyHdrId;
	}

	public void setCoinsPolicyHdrId(long coinsPolicyHdrId) {
		this.coinsPolicyHdrId = coinsPolicyHdrId;
	}

	public double getBasicSumInsrd() {
		return this.basicSumInsrd;
	}

	public void setBasicSumInsrd(double basicSumInsrd) {
		this.basicSumInsrd = basicSumInsrd;
	}

	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getInsuredAddress() {
		return this.insuredAddress;
	}

	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	public String getInsuredCity() {
		return this.insuredCity;
	}

	public void setInsuredCity(String insuredCity) {
		this.insuredCity = insuredCity;
	}

	public long getInsuredDistrictId() {
		return this.insuredDistrictId;
	}

	public void setInsuredDistrictId(long insuredDistrictId) {
		this.insuredDistrictId = insuredDistrictId;
	}

	public String getInsuredName() {
		return this.insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public long getInsuredPincode() {
		return this.insuredPincode;
	}

	public void setInsuredPincode(long insuredPincode) {
		this.insuredPincode = insuredPincode;
	}

	public long getInsuredTalukaId() {
		return this.insuredTalukaId;
	}

	public void setInsuredTalukaId(long insuredTalukaId) {
		this.insuredTalukaId = insuredTalukaId;
	}

	public long getIsFacTreaty() {
		return this.isFacTreaty;
	}

	public void setIsFacTreaty(long isFacTreaty) {
		this.isFacTreaty = isFacTreaty;
	}

	public long getIsRiReqd() {
		return this.isRiReqd;
	}

	public void setIsRiReqd(long isRiReqd) {
		this.isRiReqd = isRiReqd;
	}

	public long getLeaderAddrId() {
		return this.leaderAddrId;
	}

	public void setLeaderAddrId(long leaderAddrId) {
		this.leaderAddrId = leaderAddrId;
	}

	public String getLeaderAddress() {
		return this.leaderAddress;
	}

	public void setLeaderAddress(String leaderAddress) {
		this.leaderAddress = leaderAddress;
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

	public double getOurAgentCommiss() {
		return this.ourAgentCommiss;
	}

	public void setOurAgentCommiss(double ourAgentCommiss) {
		this.ourAgentCommiss = ourAgentCommiss;
	}

	public double getOurSharePc() {
		return this.ourSharePc;
	}

	public void setOurSharePc(double ourSharePc) {
		this.ourSharePc = ourSharePc;
	}

	public double getOurSharePremium() {
		return this.ourSharePremium;
	}

	public void setOurSharePremium(double ourSharePremium) {
		this.ourSharePremium = ourSharePremium;
	}

	public double getOurShareSi() {
		return this.ourShareSi;
	}

	public void setOurShareSi(double ourShareSi) {
		this.ourShareSi = ourShareSi;
	}

	public Date getPolicyEndDt() {
		return this.policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public Date getPolicyIssDt() {
		return this.policyIssDt;
	}

	public void setPolicyIssDt(Date policyIssDt) {
		this.policyIssDt = policyIssDt;
	}

	public Date getPolicyIssueDt() {
		return this.policyIssueDt;
	}

	public void setPolicyIssueDt(Date policyIssueDt) {
		this.policyIssueDt = policyIssueDt;
	}

	public String getPolicyNo() {
		return this.policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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

	public double getPremiumAmount() {
		return this.premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
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

	public String getRiskDetails() {
		return this.riskDetails;
	}

	public void setRiskDetails(String riskDetails) {
		this.riskDetails = riskDetails;
	}

	public long getRiskTypeId() {
		return this.riskTypeId;
	}

	public void setRiskTypeId(long riskTypeId) {
		this.riskTypeId = riskTypeId;
	}

	public String getTerrorPool() {
		return this.terrorPool;
	}

	public void setTerrorPool(String terrorPool) {
		this.terrorPool = terrorPool;
	}

	public double getTotalSiAmt() {
		return this.totalSiAmt;
	}

	public void setTotalSiAmt(double totalSiAmt) {
		this.totalSiAmt = totalSiAmt;
	}

	public List<DoiCoinsPolicyHdrWfEntity> getTdoiCoinsPolicyHdrWfs() {
		return this.doiCoinsPolicyHdrWfEntities;
	}

	public void setTdoiCoinsPolicyHdrWfs(List<DoiCoinsPolicyHdrWfEntity> doiCoinsPolicyHdrWfEntities) {
		this.doiCoinsPolicyHdrWfEntities = doiCoinsPolicyHdrWfEntities;
	}

	public DoiCoinsPolicyHdrWfEntity addTdoiCoinsPolicyHdrWf(DoiCoinsPolicyHdrWfEntity doiCoinsPolicyHdrWfEntity) {
		getTdoiCoinsPolicyHdrWfs().add(doiCoinsPolicyHdrWfEntity);
		doiCoinsPolicyHdrWfEntity.setDoiCoinsPolicyHdrEntity(this);

		return doiCoinsPolicyHdrWfEntity;
	}

	public DoiCoinsPolicyHdrWfEntity removeTdoiCoinsPolicyHdrWf(DoiCoinsPolicyHdrWfEntity doiCoinsPolicyHdrWfEntity) {
		getTdoiCoinsPolicyHdrWfs().remove(doiCoinsPolicyHdrWfEntity);
		doiCoinsPolicyHdrWfEntity.setDoiCoinsPolicyHdrEntity(null);

		return doiCoinsPolicyHdrWfEntity;
	}

	public List<DoiCoinsPolicyRiEntity> getTdoiCoinsPolicyRis() {
		return this.doiCoinsPolicyRiEntities;
	}

	public void setTdoiCoinsPolicyRis(List<DoiCoinsPolicyRiEntity> doiCoinsPolicyRiEntities) {
		this.doiCoinsPolicyRiEntities = doiCoinsPolicyRiEntities;
	}

	public DoiCoinsPolicyRiEntity addTdoiCoinsPolicyRi(DoiCoinsPolicyRiEntity doiCoinsPolicyRiEntity) {
		getTdoiCoinsPolicyRis().add(doiCoinsPolicyRiEntity);
		doiCoinsPolicyRiEntity.setDoiCoinsPolicyHdrEntity(this);

		return doiCoinsPolicyRiEntity;
	}

	public DoiCoinsPolicyRiEntity removeTdoiCoinsPolicyRi(DoiCoinsPolicyRiEntity doiCoinsPolicyRiEntity) {
		getTdoiCoinsPolicyRis().remove(doiCoinsPolicyRiEntity);
		doiCoinsPolicyRiEntity.setDoiCoinsPolicyHdrEntity(null);

		return doiCoinsPolicyRiEntity;
	}

}