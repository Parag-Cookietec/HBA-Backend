package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROPSL_BURGLARY database table.
 * 
 */
public class TdoiDbPropslBurglaryDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbBurglaryId;

	private double againstFireAmt;

	private long bankId;

	private String bankName;

	private String booksKeptAtnight;

	private long branchId;

	private String branchName;

	private double cashInSafePrem;

	private double cashInSafeRate;

	private double cashInSafeSi;

	private double challanAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date challanDt;

	private String challanNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDdDt;

	private String chequeDdNo;

	private String claimCompanyName;

	private String declPersonName;

	private String externDoorType;

	private double firmCapitalPaid;

	private double fixtureFittingPrem;

	private double fixtureFittingRate;

	private double fixtureFittingSi;

	private double goodsInTrustPrem;

	private double goodsInTrustRate;

	private double goodsInTrustSi;

	private String howGainAccess;

	private double insrncPremium;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurEndDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurStartDt;

	private String isBuildBurgl;

	private String isIncrsdRateReqd;

	private String isLeftUnoccupy;

	private String isOthrCompPropsd;

	private String isPropslAcceptDecl;

	private String isRenewlAcceptDecl;

	private String isRiReqd;

	private String isRobberyClaimed;

	private String isSafeFixWall;

	private String isSoleOccupier;

	private String isStockbookKept;

	private String isValSafeBurg;

	private String issuedInFavor;

	private String keysHeldBy;

	private short keysNumber;

	private String occupationTrade;

	private String otherwiseOccupy;

	private String othrCompanyName;

	private double payablePremAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDate;

	private long paymentModeId;

	private double premDiscAmt;

	private double premDiscPc;

	private double premGstAmt;

	private double premGstPc;

	private String premOccupyDur;

	private String premUnoccupyDur;

	private long premisesDescId;

	private String propertyAddress;

	private String proposerBusiness;

	private double proprtyPremiumAmt;

	private double proprtySumInsrdAmt;

	private long propslPoliciesId;

	private double rateOfIntrst;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String reoccurPrecaution;

	private double robberedAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date robberyDt;

	private double safeCost;

	private String safeDimension;

	private String safeMakerName;

	private String skylightTrapDoor;

	private double stateRentalPa;

	private double stockInTradeAmt;

	private double stockInTradePrem;

	private double stockInTradeRate;

	private double stockInTradeSi;

	private String stockInsrdCompName;

	private String stockbookFreq;

	private double sumInsured;

	private double totAddonPrem;

	private double totRiAmt;

	private double totalPremium;

	private String windowsType;

	private TdoiDbProposalDTO tdoiDbProposal;

	private List<TdoiDbPropslBurglaryWfDTO> tdoiDbPropslBurglaryWfs;

	private List<TdoiDbPropBuglrRiDtlDTO> tdoiDbPropBuglrRiDtls;

	public long getDbBurglaryId() {
		return this.dbBurglaryId;
	}

	public void setDbBurglaryId(long dbBurglaryId) {
		this.dbBurglaryId = dbBurglaryId;
	}

	public double getAgainstFireAmt() {
		return this.againstFireAmt;
	}

	public void setAgainstFireAmt(double againstFireAmt) {
		this.againstFireAmt = againstFireAmt;
	}

	public long getBankId() {
		return this.bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBooksKeptAtnight() {
		return this.booksKeptAtnight;
	}

	public void setBooksKeptAtnight(String booksKeptAtnight) {
		this.booksKeptAtnight = booksKeptAtnight;
	}

	public long getBranchId() {
		return this.branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public double getCashInSafePrem() {
		return this.cashInSafePrem;
	}

	public void setCashInSafePrem(double cashInSafePrem) {
		this.cashInSafePrem = cashInSafePrem;
	}

	public double getCashInSafeRate() {
		return this.cashInSafeRate;
	}

	public void setCashInSafeRate(double cashInSafeRate) {
		this.cashInSafeRate = cashInSafeRate;
	}

	public double getCashInSafeSi() {
		return this.cashInSafeSi;
	}

	public void setCashInSafeSi(double cashInSafeSi) {
		this.cashInSafeSi = cashInSafeSi;
	}

	public double getChallanAmount() {
		return this.challanAmount;
	}

	public void setChallanAmount(double challanAmount) {
		this.challanAmount = challanAmount;
	}

	public Date getChallanDt() {
		return this.challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public Date getChequeDdDt() {
		return this.chequeDdDt;
	}

	public void setChequeDdDt(Date chequeDdDt) {
		this.chequeDdDt = chequeDdDt;
	}

	public String getChequeDdNo() {
		return this.chequeDdNo;
	}

	public void setChequeDdNo(String chequeDdNo) {
		this.chequeDdNo = chequeDdNo;
	}

	public String getClaimCompanyName() {
		return this.claimCompanyName;
	}

	public void setClaimCompanyName(String claimCompanyName) {
		this.claimCompanyName = claimCompanyName;
	}

	public String getDeclPersonName() {
		return this.declPersonName;
	}

	public void setDeclPersonName(String declPersonName) {
		this.declPersonName = declPersonName;
	}

	public String getExternDoorType() {
		return this.externDoorType;
	}

	public void setExternDoorType(String externDoorType) {
		this.externDoorType = externDoorType;
	}

	public double getFirmCapitalPaid() {
		return this.firmCapitalPaid;
	}

	public void setFirmCapitalPaid(double firmCapitalPaid) {
		this.firmCapitalPaid = firmCapitalPaid;
	}

	public double getFixtureFittingPrem() {
		return this.fixtureFittingPrem;
	}

	public void setFixtureFittingPrem(double fixtureFittingPrem) {
		this.fixtureFittingPrem = fixtureFittingPrem;
	}

	public double getFixtureFittingRate() {
		return this.fixtureFittingRate;
	}

	public void setFixtureFittingRate(double fixtureFittingRate) {
		this.fixtureFittingRate = fixtureFittingRate;
	}

	public double getFixtureFittingSi() {
		return this.fixtureFittingSi;
	}

	public void setFixtureFittingSi(double fixtureFittingSi) {
		this.fixtureFittingSi = fixtureFittingSi;
	}

	public double getGoodsInTrustPrem() {
		return this.goodsInTrustPrem;
	}

	public void setGoodsInTrustPrem(double goodsInTrustPrem) {
		this.goodsInTrustPrem = goodsInTrustPrem;
	}

	public double getGoodsInTrustRate() {
		return this.goodsInTrustRate;
	}

	public void setGoodsInTrustRate(double goodsInTrustRate) {
		this.goodsInTrustRate = goodsInTrustRate;
	}

	public double getGoodsInTrustSi() {
		return this.goodsInTrustSi;
	}

	public void setGoodsInTrustSi(double goodsInTrustSi) {
		this.goodsInTrustSi = goodsInTrustSi;
	}

	public String getHowGainAccess() {
		return this.howGainAccess;
	}

	public void setHowGainAccess(String howGainAccess) {
		this.howGainAccess = howGainAccess;
	}

	public double getInsrncPremium() {
		return this.insrncPremium;
	}

	public void setInsrncPremium(double insrncPremium) {
		this.insrncPremium = insrncPremium;
	}

	public Date getInsurEndDt() {
		return this.insurEndDt;
	}

	public void setInsurEndDt(Date insurEndDt) {
		this.insurEndDt = insurEndDt;
	}

	public Date getInsurStartDt() {
		return this.insurStartDt;
	}

	public void setInsurStartDt(Date insurStartDt) {
		this.insurStartDt = insurStartDt;
	}

	public String getIsBuildBurgl() {
		return this.isBuildBurgl;
	}

	public void setIsBuildBurgl(String isBuildBurgl) {
		this.isBuildBurgl = isBuildBurgl;
	}

	public String getIsIncrsdRateReqd() {
		return this.isIncrsdRateReqd;
	}

	public void setIsIncrsdRateReqd(String isIncrsdRateReqd) {
		this.isIncrsdRateReqd = isIncrsdRateReqd;
	}

	public String getIsLeftUnoccupy() {
		return this.isLeftUnoccupy;
	}

	public void setIsLeftUnoccupy(String isLeftUnoccupy) {
		this.isLeftUnoccupy = isLeftUnoccupy;
	}

	public String getIsOthrCompPropsd() {
		return this.isOthrCompPropsd;
	}

	public void setIsOthrCompPropsd(String isOthrCompPropsd) {
		this.isOthrCompPropsd = isOthrCompPropsd;
	}

	public String getIsPropslAcceptDecl() {
		return this.isPropslAcceptDecl;
	}

	public void setIsPropslAcceptDecl(String isPropslAcceptDecl) {
		this.isPropslAcceptDecl = isPropslAcceptDecl;
	}

	public String getIsRenewlAcceptDecl() {
		return this.isRenewlAcceptDecl;
	}

	public void setIsRenewlAcceptDecl(String isRenewlAcceptDecl) {
		this.isRenewlAcceptDecl = isRenewlAcceptDecl;
	}

	public String getIsRiReqd() {
		return this.isRiReqd;
	}

	public void setIsRiReqd(String isRiReqd) {
		this.isRiReqd = isRiReqd;
	}

	public String getIsRobberyClaimed() {
		return this.isRobberyClaimed;
	}

	public void setIsRobberyClaimed(String isRobberyClaimed) {
		this.isRobberyClaimed = isRobberyClaimed;
	}

	public String getIsSafeFixWall() {
		return this.isSafeFixWall;
	}

	public void setIsSafeFixWall(String isSafeFixWall) {
		this.isSafeFixWall = isSafeFixWall;
	}

	public String getIsSoleOccupier() {
		return this.isSoleOccupier;
	}

	public void setIsSoleOccupier(String isSoleOccupier) {
		this.isSoleOccupier = isSoleOccupier;
	}

	public String getIsStockbookKept() {
		return this.isStockbookKept;
	}

	public void setIsStockbookKept(String isStockbookKept) {
		this.isStockbookKept = isStockbookKept;
	}

	public String getIsValSafeBurg() {
		return this.isValSafeBurg;
	}

	public void setIsValSafeBurg(String isValSafeBurg) {
		this.isValSafeBurg = isValSafeBurg;
	}

	public String getIssuedInFavor() {
		return this.issuedInFavor;
	}

	public void setIssuedInFavor(String issuedInFavor) {
		this.issuedInFavor = issuedInFavor;
	}

	public String getKeysHeldBy() {
		return this.keysHeldBy;
	}

	public void setKeysHeldBy(String keysHeldBy) {
		this.keysHeldBy = keysHeldBy;
	}

	public short getKeysNumber() {
		return this.keysNumber;
	}

	public void setKeysNumber(short keysNumber) {
		this.keysNumber = keysNumber;
	}

	public String getOccupationTrade() {
		return this.occupationTrade;
	}

	public void setOccupationTrade(String occupationTrade) {
		this.occupationTrade = occupationTrade;
	}

	public String getOtherwiseOccupy() {
		return this.otherwiseOccupy;
	}

	public void setOtherwiseOccupy(String otherwiseOccupy) {
		this.otherwiseOccupy = otherwiseOccupy;
	}

	public String getOthrCompanyName() {
		return this.othrCompanyName;
	}

	public void setOthrCompanyName(String othrCompanyName) {
		this.othrCompanyName = othrCompanyName;
	}

	public double getPayablePremAmt() {
		return this.payablePremAmt;
	}

	public void setPayablePremAmt(double payablePremAmt) {
		this.payablePremAmt = payablePremAmt;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public long getPaymentModeId() {
		return this.paymentModeId;
	}

	public void setPaymentModeId(long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public double getPremDiscAmt() {
		return this.premDiscAmt;
	}

	public void setPremDiscAmt(double premDiscAmt) {
		this.premDiscAmt = premDiscAmt;
	}

	public double getPremDiscPc() {
		return this.premDiscPc;
	}

	public void setPremDiscPc(double premDiscPc) {
		this.premDiscPc = premDiscPc;
	}

	public double getPremGstAmt() {
		return this.premGstAmt;
	}

	public void setPremGstAmt(double premGstAmt) {
		this.premGstAmt = premGstAmt;
	}

	public double getPremGstPc() {
		return this.premGstPc;
	}

	public void setPremGstPc(double premGstPc) {
		this.premGstPc = premGstPc;
	}

	public String getPremOccupyDur() {
		return this.premOccupyDur;
	}

	public void setPremOccupyDur(String premOccupyDur) {
		this.premOccupyDur = premOccupyDur;
	}

	public String getPremUnoccupyDur() {
		return this.premUnoccupyDur;
	}

	public void setPremUnoccupyDur(String premUnoccupyDur) {
		this.premUnoccupyDur = premUnoccupyDur;
	}

	public long getPremisesDescId() {
		return this.premisesDescId;
	}

	public void setPremisesDescId(long premisesDescId) {
		this.premisesDescId = premisesDescId;
	}

	public String getPropertyAddress() {
		return this.propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getProposerBusiness() {
		return this.proposerBusiness;
	}

	public void setProposerBusiness(String proposerBusiness) {
		this.proposerBusiness = proposerBusiness;
	}

	public double getProprtyPremiumAmt() {
		return this.proprtyPremiumAmt;
	}

	public void setProprtyPremiumAmt(double proprtyPremiumAmt) {
		this.proprtyPremiumAmt = proprtyPremiumAmt;
	}

	public double getProprtySumInsrdAmt() {
		return this.proprtySumInsrdAmt;
	}

	public void setProprtySumInsrdAmt(double proprtySumInsrdAmt) {
		this.proprtySumInsrdAmt = proprtySumInsrdAmt;
	}

	public long getPropslPoliciesId() {
		return this.propslPoliciesId;
	}

	public void setPropslPoliciesId(long propslPoliciesId) {
		this.propslPoliciesId = propslPoliciesId;
	}

	public double getRateOfIntrst() {
		return this.rateOfIntrst;
	}

	public void setRateOfIntrst(double rateOfIntrst) {
		this.rateOfIntrst = rateOfIntrst;
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

	public String getReoccurPrecaution() {
		return this.reoccurPrecaution;
	}

	public void setReoccurPrecaution(String reoccurPrecaution) {
		this.reoccurPrecaution = reoccurPrecaution;
	}

	public double getRobberedAmt() {
		return this.robberedAmt;
	}

	public void setRobberedAmt(double robberedAmt) {
		this.robberedAmt = robberedAmt;
	}

	public Date getRobberyDt() {
		return this.robberyDt;
	}

	public void setRobberyDt(Date robberyDt) {
		this.robberyDt = robberyDt;
	}

	public double getSafeCost() {
		return this.safeCost;
	}

	public void setSafeCost(double safeCost) {
		this.safeCost = safeCost;
	}

	public String getSafeDimension() {
		return this.safeDimension;
	}

	public void setSafeDimension(String safeDimension) {
		this.safeDimension = safeDimension;
	}

	public String getSafeMakerName() {
		return this.safeMakerName;
	}

	public void setSafeMakerName(String safeMakerName) {
		this.safeMakerName = safeMakerName;
	}

	public String getSkylightTrapDoor() {
		return this.skylightTrapDoor;
	}

	public void setSkylightTrapDoor(String skylightTrapDoor) {
		this.skylightTrapDoor = skylightTrapDoor;
	}

	public double getStateRentalPa() {
		return this.stateRentalPa;
	}

	public void setStateRentalPa(double stateRentalPa) {
		this.stateRentalPa = stateRentalPa;
	}

	public double getStockInTradeAmt() {
		return this.stockInTradeAmt;
	}

	public void setStockInTradeAmt(double stockInTradeAmt) {
		this.stockInTradeAmt = stockInTradeAmt;
	}

	public double getStockInTradePrem() {
		return this.stockInTradePrem;
	}

	public void setStockInTradePrem(double stockInTradePrem) {
		this.stockInTradePrem = stockInTradePrem;
	}

	public double getStockInTradeRate() {
		return this.stockInTradeRate;
	}

	public void setStockInTradeRate(double stockInTradeRate) {
		this.stockInTradeRate = stockInTradeRate;
	}

	public double getStockInTradeSi() {
		return this.stockInTradeSi;
	}

	public void setStockInTradeSi(double stockInTradeSi) {
		this.stockInTradeSi = stockInTradeSi;
	}

	public String getStockInsrdCompName() {
		return this.stockInsrdCompName;
	}

	public void setStockInsrdCompName(String stockInsrdCompName) {
		this.stockInsrdCompName = stockInsrdCompName;
	}

	public String getStockbookFreq() {
		return this.stockbookFreq;
	}

	public void setStockbookFreq(String stockbookFreq) {
		this.stockbookFreq = stockbookFreq;
	}

	public double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public double getTotAddonPrem() {
		return this.totAddonPrem;
	}

	public void setTotAddonPrem(double totAddonPrem) {
		this.totAddonPrem = totAddonPrem;
	}

	public double getTotRiAmt() {
		return this.totRiAmt;
	}

	public void setTotRiAmt(double totRiAmt) {
		this.totRiAmt = totRiAmt;
	}

	public double getTotalPremium() {
		return this.totalPremium;
	}

	public void setTotalPremium(double totalPremium) {
		this.totalPremium = totalPremium;
	}

	public String getWindowsType() {
		return this.windowsType;
	}

	public void setWindowsType(String windowsType) {
		this.windowsType = windowsType;
	}

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPropslBurglaryWfDTO> getTdoiDbPropslBurglaryWfs() {
		return this.tdoiDbPropslBurglaryWfs;
	}

	public void setTdoiDbPropslBurglaryWfs(List<TdoiDbPropslBurglaryWfDTO> tdoiDbPropslBurglaryWfs) {
		this.tdoiDbPropslBurglaryWfs = tdoiDbPropslBurglaryWfs;
	}

	public TdoiDbPropslBurglaryWfDTO addTdoiDbPropslBurglaryWf(TdoiDbPropslBurglaryWfDTO tdoiDbPropslBurglaryWf) {
		getTdoiDbPropslBurglaryWfs().add(tdoiDbPropslBurglaryWf);
		tdoiDbPropslBurglaryWf.setTdoiDbPropslBurglary(this);

		return tdoiDbPropslBurglaryWf;
	}

	public TdoiDbPropslBurglaryWfDTO removeTdoiDbPropslBurglaryWf(TdoiDbPropslBurglaryWfDTO tdoiDbPropslBurglaryWf) {
		getTdoiDbPropslBurglaryWfs().remove(tdoiDbPropslBurglaryWf);
		tdoiDbPropslBurglaryWf.setTdoiDbPropslBurglary(null);

		return tdoiDbPropslBurglaryWf;
	}

	public List<TdoiDbPropBuglrRiDtlDTO> getTdoiDbPropBuglrRiDtls() {
		return this.tdoiDbPropBuglrRiDtls;
	}

	public void setTdoiDbPropBuglrRiDtls(List<TdoiDbPropBuglrRiDtlDTO> tdoiDbPropBuglrRiDtls) {
		this.tdoiDbPropBuglrRiDtls = tdoiDbPropBuglrRiDtls;
	}

	public TdoiDbPropBuglrRiDtlDTO addTdoiDbPropBuglrRiDtl(TdoiDbPropBuglrRiDtlDTO tdoiDbPropBuglrRiDtl) {
		getTdoiDbPropBuglrRiDtls().add(tdoiDbPropBuglrRiDtl);
		tdoiDbPropBuglrRiDtl.setTdoiDbPropslBurglary(this);

		return tdoiDbPropBuglrRiDtl;
	}

	public TdoiDbPropBuglrRiDtlDTO removeTdoiDbPropBuglrRiDtl(TdoiDbPropBuglrRiDtlDTO tdoiDbPropBuglrRiDtl) {
		getTdoiDbPropBuglrRiDtls().remove(tdoiDbPropBuglrRiDtl);
		tdoiDbPropBuglrRiDtl.setTdoiDbPropslBurglary(null);

		return tdoiDbPropBuglrRiDtl;
	}

}
