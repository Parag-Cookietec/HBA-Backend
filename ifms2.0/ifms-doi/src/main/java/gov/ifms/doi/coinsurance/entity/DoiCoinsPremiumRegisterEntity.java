package gov.ifms.doi.coinsurance.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="TDOI_COINS_PREMIUM_REGISTER", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiCoinsPremiumRegisterEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8174787864741018596L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COINS_PREMIUM_ID", unique=true, nullable=false)
	private long coinsPremiumId;

	@Column(name="AGENCY_COMM_AMT")
	private double agencyCommAmt;

	@Column(name="CESSION_TO_GIC_AMT")
	private double cessionToGicAmt;

	@Column(name="CESSION_TO_GIC_PC")
	private double cessionToGicPc;

	@Column(name="CHALLAN_AMOUNT")
	private double challanAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="CHALLAN_DT")
	private Date challanDt;

	@Column(name="CHALLAN_NO", length=30)
	private String challanNo;

	@Column(name="COINS_SHARE_PREM")
	private double coinsSharePrem;

	@Column(name="COINS_SHARE_PREM_PC")
	private double coinsSharePremPc;

	@Column(name="ENDORSEMENT_NO", length=30)
	private String endorsementNo;

	@Column(name="EXCESS_PREM_AMT")
	private double excessPremAmt;

	@Column(name="FAC_RI_PREM_AMT")
	private double facRiPremAmt;

	@Column(name="FAC_RI_PREM_PC")
	private double facRiPremPc;

	@Column(name="GIF_PREM_AMT")
	private double gifPremAmt;

	@Column(name="GIF_PREM_PC")
	private double gifPremPc;

	@Column(name="GIF_TERROR_POOL_AMT")
	private double gifTerrorPoolAmt;

	@Column(name="GIF_TERROR_PREM_PC")
	private double gifTerrorPremPc;

	@Column(name="GROSS_SI_AMT")
	private double grossSiAmt;

	@Column(name="INSUR_COMP_ID")
	private long insurCompId;

	@Column(name="INSUR_COMP_LOC", length=100)
	private String insurCompLoc;

	@Column(name="INSUR_COMP_LOC_ID")
	private long insurCompLocId;

	@Column(name="INSUR_COMP_NAME", length=100)
	private String insurCompName;

	@Column(name="INSUR_COMP_OFFC", length=100)
	private String insurCompOffc;

	@Column(name="INSUR_COMP_OFFC_ID")
	private long insurCompOffcId;

	@Temporal(TemporalType.DATE)
	@Column(name="INSURANCE_END_DT")
	private Date insuranceEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name="INSURANCE_START_DT")
	private Date insuranceStartDt;

	@Column(name="INSURED_NAME", length=100)
	private String insuredName;

	@Column(name="NET_GIF_SHARE")
	private double netGifShare;

	@Column(name="POLICY_NO", length=30)
	private String policyNo;

	@Column(name="POLICY_TYPE_ID")
	private long policyTypeId;

	@Column(name="PREM_100PC_AMT")
	private double prem100pcAmt;

	@Column(name="PREM_MONTH_ID")
	private long premMonthId;

	@Temporal(TemporalType.DATE)
	@Column(name="PREM_RECV_END_DT")
	private Date premRecvEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name="PREM_RECV_START_DT")
	private Date premRecvStartDt;

	@Column(name="PREM_YEAR_ID")
	private long premYearId;

	@Column(name="REFERENCE_DT")
	private Timestamp referenceDt;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;

	@Column(length=200)
	private String remarks;

	@Column(name="RISK_LOCATION", length=100)
	private String riskLocation;

	@Column(name="RISK_TYPE_ID")
	private long riskTypeId;

	@Column(name="SHORT_PREM_AMT")
	private double shortPremAmt;

	@Column(name="TERROR_PREM_AMT")
	private double terrorPremAmt;

	@Column(name="TOT_GIF_PREMIUM")
	private double totGifPremium;

	@Column(name="TOT_PREM_AMT")
	private double totPremAmt;

	/**
	 * @return the coinsPremiumId
	 */
	public long getCoinsPremiumId() {
		return coinsPremiumId;
	}

	/**
	 * @param coinsPremiumId the coinsPremiumId to set
	 */
	public void setCoinsPremiumId(long coinsPremiumId) {
		this.coinsPremiumId = coinsPremiumId;
	}

	/**
	 * @return the agencyCommAmt
	 */
	public double getAgencyCommAmt() {
		return agencyCommAmt;
	}

	/**
	 * @param agencyCommAmt the agencyCommAmt to set
	 */
	public void setAgencyCommAmt(double agencyCommAmt) {
		this.agencyCommAmt = agencyCommAmt;
	}

	/**
	 * @return the cessionToGicAmt
	 */
	public double getCessionToGicAmt() {
		return cessionToGicAmt;
	}

	/**
	 * @param cessionToGicAmt the cessionToGicAmt to set
	 */
	public void setCessionToGicAmt(double cessionToGicAmt) {
		this.cessionToGicAmt = cessionToGicAmt;
	}

	/**
	 * @return the cessionToGicPc
	 */
	public double getCessionToGicPc() {
		return cessionToGicPc;
	}

	/**
	 * @param cessionToGicPc the cessionToGicPc to set
	 */
	public void setCessionToGicPc(double cessionToGicPc) {
		this.cessionToGicPc = cessionToGicPc;
	}

	/**
	 * @return the challanAmount
	 */
	public double getChallanAmount() {
		return challanAmount;
	}

	/**
	 * @param challanAmount the challanAmount to set
	 */
	public void setChallanAmount(double challanAmount) {
		this.challanAmount = challanAmount;
	}

	/**
	 * @return the challanDt
	 */
	public Date getChallanDt() {
		return challanDt;
	}

	/**
	 * @param challanDt the challanDt to set
	 */
	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	/**
	 * @return the challanNo
	 */
	public String getChallanNo() {
		return challanNo;
	}

	/**
	 * @param challanNo the challanNo to set
	 */
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	/**
	 * @return the coinsSharePrem
	 */
	public double getCoinsSharePrem() {
		return coinsSharePrem;
	}

	/**
	 * @param coinsSharePrem the coinsSharePrem to set
	 */
	public void setCoinsSharePrem(double coinsSharePrem) {
		this.coinsSharePrem = coinsSharePrem;
	}

	/**
	 * @return the coinsSharePremPc
	 */
	public double getCoinsSharePremPc() {
		return coinsSharePremPc;
	}

	/**
	 * @param coinsSharePremPc the coinsSharePremPc to set
	 */
	public void setCoinsSharePremPc(double coinsSharePremPc) {
		this.coinsSharePremPc = coinsSharePremPc;
	}

	/**
	 * @return the endorsementNo
	 */
	public String getEndorsementNo() {
		return endorsementNo;
	}

	/**
	 * @param endorsementNo the endorsementNo to set
	 */
	public void setEndorsementNo(String endorsementNo) {
		this.endorsementNo = endorsementNo;
	}

	/**
	 * @return the excessPremAmt
	 */
	public double getExcessPremAmt() {
		return excessPremAmt;
	}

	/**
	 * @param excessPremAmt the excessPremAmt to set
	 */
	public void setExcessPremAmt(double excessPremAmt) {
		this.excessPremAmt = excessPremAmt;
	}

	/**
	 * @return the facRiPremAmt
	 */
	public double getFacRiPremAmt() {
		return facRiPremAmt;
	}

	/**
	 * @param facRiPremAmt the facRiPremAmt to set
	 */
	public void setFacRiPremAmt(double facRiPremAmt) {
		this.facRiPremAmt = facRiPremAmt;
	}

	/**
	 * @return the facRiPremPc
	 */
	public double getFacRiPremPc() {
		return facRiPremPc;
	}

	/**
	 * @param facRiPremPc the facRiPremPc to set
	 */
	public void setFacRiPremPc(double facRiPremPc) {
		this.facRiPremPc = facRiPremPc;
	}

	/**
	 * @return the gifPremAmt
	 */
	public double getGifPremAmt() {
		return gifPremAmt;
	}

	/**
	 * @param gifPremAmt the gifPremAmt to set
	 */
	public void setGifPremAmt(double gifPremAmt) {
		this.gifPremAmt = gifPremAmt;
	}

	/**
	 * @return the gifPremPc
	 */
	public double getGifPremPc() {
		return gifPremPc;
	}

	/**
	 * @param gifPremPc the gifPremPc to set
	 */
	public void setGifPremPc(double gifPremPc) {
		this.gifPremPc = gifPremPc;
	}

	/**
	 * @return the gifTerrorPoolAmt
	 */
	public double getGifTerrorPoolAmt() {
		return gifTerrorPoolAmt;
	}

	/**
	 * @param gifTerrorPoolAmt the gifTerrorPoolAmt to set
	 */
	public void setGifTerrorPoolAmt(double gifTerrorPoolAmt) {
		this.gifTerrorPoolAmt = gifTerrorPoolAmt;
	}

	/**
	 * @return the gifTerrorPremPc
	 */
	public double getGifTerrorPremPc() {
		return gifTerrorPremPc;
	}

	/**
	 * @param gifTerrorPremPc the gifTerrorPremPc to set
	 */
	public void setGifTerrorPremPc(double gifTerrorPremPc) {
		this.gifTerrorPremPc = gifTerrorPremPc;
	}

	/**
	 * @return the grossSiAmt
	 */
	public double getGrossSiAmt() {
		return grossSiAmt;
	}

	/**
	 * @param grossSiAmt the grossSiAmt to set
	 */
	public void setGrossSiAmt(double grossSiAmt) {
		this.grossSiAmt = grossSiAmt;
	}

	/**
	 * @return the insurCompId
	 */
	public long getInsurCompId() {
		return insurCompId;
	}

	/**
	 * @param insurCompId the insurCompId to set
	 */
	public void setInsurCompId(long insurCompId) {
		this.insurCompId = insurCompId;
	}

	/**
	 * @return the insurCompLoc
	 */
	public String getInsurCompLoc() {
		return insurCompLoc;
	}

	/**
	 * @param insurCompLoc the insurCompLoc to set
	 */
	public void setInsurCompLoc(String insurCompLoc) {
		this.insurCompLoc = insurCompLoc;
	}

	/**
	 * @return the insurCompLocId
	 */
	public long getInsurCompLocId() {
		return insurCompLocId;
	}

	/**
	 * @param insurCompLocId the insurCompLocId to set
	 */
	public void setInsurCompLocId(long insurCompLocId) {
		this.insurCompLocId = insurCompLocId;
	}

	/**
	 * @return the insurCompName
	 */
	public String getInsurCompName() {
		return insurCompName;
	}

	/**
	 * @param insurCompName the insurCompName to set
	 */
	public void setInsurCompName(String insurCompName) {
		this.insurCompName = insurCompName;
	}

	/**
	 * @return the insurCompOffc
	 */
	public String getInsurCompOffc() {
		return insurCompOffc;
	}

	/**
	 * @param insurCompOffc the insurCompOffc to set
	 */
	public void setInsurCompOffc(String insurCompOffc) {
		this.insurCompOffc = insurCompOffc;
	}

	/**
	 * @return the insurCompOffcId
	 */
	public long getInsurCompOffcId() {
		return insurCompOffcId;
	}

	/**
	 * @param insurCompOffcId the insurCompOffcId to set
	 */
	public void setInsurCompOffcId(long insurCompOffcId) {
		this.insurCompOffcId = insurCompOffcId;
	}

	/**
	 * @return the insuranceEndDt
	 */
	public Date getInsuranceEndDt() {
		return insuranceEndDt;
	}

	/**
	 * @param insuranceEndDt the insuranceEndDt to set
	 */
	public void setInsuranceEndDt(Date insuranceEndDt) {
		this.insuranceEndDt = insuranceEndDt;
	}

	/**
	 * @return the insuranceStartDt
	 */
	public Date getInsuranceStartDt() {
		return insuranceStartDt;
	}

	/**
	 * @param insuranceStartDt the insuranceStartDt to set
	 */
	public void setInsuranceStartDt(Date insuranceStartDt) {
		this.insuranceStartDt = insuranceStartDt;
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
	 * @return the netGifShare
	 */
	public double getNetGifShare() {
		return netGifShare;
	}

	/**
	 * @param netGifShare the netGifShare to set
	 */
	public void setNetGifShare(double netGifShare) {
		this.netGifShare = netGifShare;
	}

	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}

	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**
	 * @return the policyTypeId
	 */
	public long getPolicyTypeId() {
		return policyTypeId;
	}

	/**
	 * @param policyTypeId the policyTypeId to set
	 */
	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	/**
	 * @return the prem100pcAmt
	 */
	public double getPrem100pcAmt() {
		return prem100pcAmt;
	}

	/**
	 * @param prem100pcAmt the prem100pcAmt to set
	 */
	public void setPrem100pcAmt(double prem100pcAmt) {
		this.prem100pcAmt = prem100pcAmt;
	}

	/**
	 * @return the premMonthId
	 */
	public long getPremMonthId() {
		return premMonthId;
	}

	/**
	 * @param premMonthId the premMonthId to set
	 */
	public void setPremMonthId(long premMonthId) {
		this.premMonthId = premMonthId;
	}

	/**
	 * @return the premRecvEndDt
	 */
	public Date getPremRecvEndDt() {
		return premRecvEndDt;
	}

	/**
	 * @param premRecvEndDt the premRecvEndDt to set
	 */
	public void setPremRecvEndDt(Date premRecvEndDt) {
		this.premRecvEndDt = premRecvEndDt;
	}

	/**
	 * @return the premRecvStartDt
	 */
	public Date getPremRecvStartDt() {
		return premRecvStartDt;
	}

	/**
	 * @param premRecvStartDt the premRecvStartDt to set
	 */
	public void setPremRecvStartDt(Date premRecvStartDt) {
		this.premRecvStartDt = premRecvStartDt;
	}

	/**
	 * @return the premYearId
	 */
	public long getPremYearId() {
		return premYearId;
	}

	/**
	 * @param premYearId the premYearId to set
	 */
	public void setPremYearId(long premYearId) {
		this.premYearId = premYearId;
	}

	/**
	 * @return the referenceDt
	 */
	public Timestamp getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Timestamp referenceDt) {
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
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the riskLocation
	 */
	public String getRiskLocation() {
		return riskLocation;
	}

	/**
	 * @param riskLocation the riskLocation to set
	 */
	public void setRiskLocation(String riskLocation) {
		this.riskLocation = riskLocation;
	}

	/**
	 * @return the riskTypeId
	 */
	public long getRiskTypeId() {
		return riskTypeId;
	}

	/**
	 * @param riskTypeId the riskTypeId to set
	 */
	public void setRiskTypeId(long riskTypeId) {
		this.riskTypeId = riskTypeId;
	}

	/**
	 * @return the shortPremAmt
	 */
	public double getShortPremAmt() {
		return shortPremAmt;
	}

	/**
	 * @param shortPremAmt the shortPremAmt to set
	 */
	public void setShortPremAmt(double shortPremAmt) {
		this.shortPremAmt = shortPremAmt;
	}

	/**
	 * @return the terrorPremAmt
	 */
	public double getTerrorPremAmt() {
		return terrorPremAmt;
	}

	/**
	 * @param terrorPremAmt the terrorPremAmt to set
	 */
	public void setTerrorPremAmt(double terrorPremAmt) {
		this.terrorPremAmt = terrorPremAmt;
	}

	/**
	 * @return the totGifPremium
	 */
	public double getTotGifPremium() {
		return totGifPremium;
	}

	/**
	 * @param totGifPremium the totGifPremium to set
	 */
	public void setTotGifPremium(double totGifPremium) {
		this.totGifPremium = totGifPremium;
	}

	/**
	 * @return the totPremAmt
	 */
	public double getTotPremAmt() {
		return totPremAmt;
	}

	/**
	 * @param totPremAmt the totPremAmt to set
	 */
	public void setTotPremAmt(double totPremAmt) {
		this.totPremAmt = totPremAmt;
	}

}