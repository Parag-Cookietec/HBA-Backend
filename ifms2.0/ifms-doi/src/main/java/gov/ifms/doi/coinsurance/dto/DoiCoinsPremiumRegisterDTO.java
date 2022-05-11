package gov.ifms.doi.coinsurance.dto;

import java.sql.Timestamp;
import java.util.Date;

import gov.ifms.doi.jpa.dto.BaseDto;


/**
 * @author Rudra
 *
 */

public class DoiCoinsPremiumRegisterDTO extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2693199660342142967L;

	private long coinsPremiumId;

	private double agencyCommAmt;

	private double cessionToGicAmt;

	private double cessionToGicPc;

	private double challanAmount;

	private Date challanDt;

	private String challanNo;

	private double coinsSharePrem;

	private double coinsSharePremPc;

	private String endorsementNo;

	private double excessPremAmt;

	private double facRiPremAmt;

	private double facRiPremPc;

	private double gifPremAmt;

	private double gifPremPc;

	private double gifTerrorPoolAmt;

	private double gifTerrorPremPc;

	private double grossSiAmt;

	private long insurCompId;

	private String insurCompLoc;

	private long insurCompLocId;

	private String insurCompName;

	private String insurCompOffc;

	private long insurCompOffcId;

	private Date insuranceEndDt;

	private Date insuranceStartDt;

	private String insuredName;

	private double netGifShare;

	private String policyNo;

	private long policyTypeId;

	private double prem100pcAmt;

	private long premMonthId;

	private Date premRecvEndDt;

	private Date premRecvStartDt;

	private long premYearId;

	private Timestamp referenceDt;

	private String referenceNo;

	private String remarks;

	private String riskLocation;

	private long riskTypeId;

	private double shortPremAmt;

	private double terrorPremAmt;

	private double totGifPremium;

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