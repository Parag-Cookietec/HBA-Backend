package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_FIRE_PERIL database table.
 * 
 */

public class TdoiDbPolFirePerilDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long polFirePerilId;

	private String anyIndustryRisk;

	private double architectFees;

	private long bankId;

	private String bankName;

	private String basisPropInsur;

	private long branchId;

	private String branchName;

	private long buildingAgeId;

	private String buildingHeight;

	private double challanAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date challanDt;

	private String challanNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDdDt;

	private String chequeDdNo;

	private double coldStrgDetor;

	private String coversIncluded;

	private double debrisRemvlAmt;

	private double declareBasisAmt;

	private String declineDetails;

	private long factoryStatus;

	private String fireProtectDevice;

	private double firmCapitalPaid;

	private double floatDecBasisAmt;

	private double floaterBasisAmt;

	private String floorMaterialUsed;

	private double forestFire;

	private String goodsAsPerList;

	private String goodsStoredList;

	private double insrncPremium;

	private String insrnceDetails;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurEndDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurStartDt;

	private String isArchitectFeesAdd;

	private String isCoverPinth;

	private String isDebrisRemvAdd;

	private String isDeclaraeBasis;

	private String isEarthquakeCov;

	private String isFloatDecBasis;

	private String isFloaterBasis;

	private String isInsrDeclined;

	private String isOthrCompIns;

	private String isResiOffcShop;

	private String isRiReqd;

	private String isStockStorOpen;

	private String isUsedAsShop;

	private String issuedInFavor;

	private String manufProductList;

	private String marketValBasis;

	private double ommissionAddtn;

	private double openStocksAmt;

	private String openStorLoc;

	private String othrCompnyName;

	private String outGasTanksRisk;

	private String outStorgRisk;

	private double payablePremAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDate;

	private long paymentModeId;

	private long policyTypeId;

	private double premDiscAmt;

	private double premDiscPc;

	private double premGstAmt;

	private double premGstPc;

	private String proposerBusiness;

	private long propslPoliciesId;

	private double rateOfIntrst;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String reinstatValBasis;

	private String roofMaterialUsed;

	private double spontCombustion;

	private String stockValExceed;

	private double sumInsured;

	private String terrorismDtls;

	private double totAddonPrem;

	private double totRiAmt;

	private double totalPremium;

	private String usedAsIndustry;

	private String usedWarehouseGodwn;

	private String utilitiesOutRisk;

	private double vehicleDamage;

	private String wallMaterialUsed;

	// bi-directional many-to-one association to TdoiDbPolFireBuildingVal
	private List<TdoiDbPolFireBuildingValDTO> tdoiDbPolFireBuildingVals;

	// bi-directional many-to-one association to TdoiDbPolFirePastPolicy
	private List<TdoiDbPolFirePastPolicyDTO> tdoiDbPolFirePastPolicies;

	// bi-directional many-to-one association to TdoiDbProposal

	private TdoiDbProposalDTO tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbPolFireRiDtl
	private List<TdoiDbPolFireRiDtlDTO> tdoiDbPolFireRiDtls;

	// bi-directional many-to-one association to TdoiDbPolFireSumInsured
	private List<TdoiDbPolFireSumInsuredDTO> tdoiDbPolFireSumInsureds;

	// bi-directional many-to-one association to TdoiDbPolFireWf
	private List<TdoiDbPolFireWfDTO> tdoiDbPolFireWfs;

	public TdoiDbPolFirePerilDTO() {
	}

	public long getPolFirePerilId() {
		return this.polFirePerilId;
	}

	public void setPolFirePerilId(long polFirePerilId) {
		this.polFirePerilId = polFirePerilId;
	}

	public String getAnyIndustryRisk() {
		return this.anyIndustryRisk;
	}

	public void setAnyIndustryRisk(String anyIndustryRisk) {
		this.anyIndustryRisk = anyIndustryRisk;
	}

	public double getArchitectFees() {
		return this.architectFees;
	}

	public void setArchitectFees(double architectFees) {
		this.architectFees = architectFees;
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

	public String getBasisPropInsur() {
		return this.basisPropInsur;
	}

	public void setBasisPropInsur(String basisPropInsur) {
		this.basisPropInsur = basisPropInsur;
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

	public long getBuildingAgeId() {
		return this.buildingAgeId;
	}

	public void setBuildingAgeId(long buildingAgeId) {
		this.buildingAgeId = buildingAgeId;
	}

	public String getBuildingHeight() {
		return this.buildingHeight;
	}

	public void setBuildingHeight(String buildingHeight) {
		this.buildingHeight = buildingHeight;
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

	public double getColdStrgDetor() {
		return this.coldStrgDetor;
	}

	public void setColdStrgDetor(double coldStrgDetor) {
		this.coldStrgDetor = coldStrgDetor;
	}

	public String getCoversIncluded() {
		return this.coversIncluded;
	}

	public void setCoversIncluded(String coversIncluded) {
		this.coversIncluded = coversIncluded;
	}

	public double getDebrisRemvlAmt() {
		return this.debrisRemvlAmt;
	}

	public void setDebrisRemvlAmt(double debrisRemvlAmt) {
		this.debrisRemvlAmt = debrisRemvlAmt;
	}

	public double getDeclareBasisAmt() {
		return this.declareBasisAmt;
	}

	public void setDeclareBasisAmt(double declareBasisAmt) {
		this.declareBasisAmt = declareBasisAmt;
	}

	public String getDeclineDetails() {
		return this.declineDetails;
	}

	public void setDeclineDetails(String declineDetails) {
		this.declineDetails = declineDetails;
	}

	public long getFactoryStatus() {
		return this.factoryStatus;
	}

	public void setFactoryStatus(long factoryStatus) {
		this.factoryStatus = factoryStatus;
	}

	public String getFireProtectDevice() {
		return this.fireProtectDevice;
	}

	public void setFireProtectDevice(String fireProtectDevice) {
		this.fireProtectDevice = fireProtectDevice;
	}

	public double getFirmCapitalPaid() {
		return this.firmCapitalPaid;
	}

	public void setFirmCapitalPaid(double firmCapitalPaid) {
		this.firmCapitalPaid = firmCapitalPaid;
	}

	public double getFloatDecBasisAmt() {
		return this.floatDecBasisAmt;
	}

	public void setFloatDecBasisAmt(double floatDecBasisAmt) {
		this.floatDecBasisAmt = floatDecBasisAmt;
	}

	public double getFloaterBasisAmt() {
		return this.floaterBasisAmt;
	}

	public void setFloaterBasisAmt(double floaterBasisAmt) {
		this.floaterBasisAmt = floaterBasisAmt;
	}

	public String getFloorMaterialUsed() {
		return this.floorMaterialUsed;
	}

	public void setFloorMaterialUsed(String floorMaterialUsed) {
		this.floorMaterialUsed = floorMaterialUsed;
	}

	public double getForestFire() {
		return this.forestFire;
	}

	public void setForestFire(double forestFire) {
		this.forestFire = forestFire;
	}

	public String getGoodsAsPerList() {
		return this.goodsAsPerList;
	}

	public void setGoodsAsPerList(String goodsAsPerList) {
		this.goodsAsPerList = goodsAsPerList;
	}

	public String getGoodsStoredList() {
		return this.goodsStoredList;
	}

	public void setGoodsStoredList(String goodsStoredList) {
		this.goodsStoredList = goodsStoredList;
	}

	public double getInsrncPremium() {
		return this.insrncPremium;
	}

	public void setInsrncPremium(double insrncPremium) {
		this.insrncPremium = insrncPremium;
	}

	public String getInsrnceDetails() {
		return this.insrnceDetails;
	}

	public void setInsrnceDetails(String insrnceDetails) {
		this.insrnceDetails = insrnceDetails;
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

	public String getIsArchitectFeesAdd() {
		return this.isArchitectFeesAdd;
	}

	public void setIsArchitectFeesAdd(String isArchitectFeesAdd) {
		this.isArchitectFeesAdd = isArchitectFeesAdd;
	}

	public String getIsCoverPinth() {
		return this.isCoverPinth;
	}

	public void setIsCoverPinth(String isCoverPinth) {
		this.isCoverPinth = isCoverPinth;
	}

	public String getIsDebrisRemvAdd() {
		return this.isDebrisRemvAdd;
	}

	public void setIsDebrisRemvAdd(String isDebrisRemvAdd) {
		this.isDebrisRemvAdd = isDebrisRemvAdd;
	}

	public String getIsDeclaraeBasis() {
		return this.isDeclaraeBasis;
	}

	public void setIsDeclaraeBasis(String isDeclaraeBasis) {
		this.isDeclaraeBasis = isDeclaraeBasis;
	}

	public String getIsEarthquakeCov() {
		return this.isEarthquakeCov;
	}

	public void setIsEarthquakeCov(String isEarthquakeCov) {
		this.isEarthquakeCov = isEarthquakeCov;
	}

	public String getIsFloatDecBasis() {
		return this.isFloatDecBasis;
	}

	public void setIsFloatDecBasis(String isFloatDecBasis) {
		this.isFloatDecBasis = isFloatDecBasis;
	}

	public String getIsFloaterBasis() {
		return this.isFloaterBasis;
	}

	public void setIsFloaterBasis(String isFloaterBasis) {
		this.isFloaterBasis = isFloaterBasis;
	}

	public String getIsInsrDeclined() {
		return this.isInsrDeclined;
	}

	public void setIsInsrDeclined(String isInsrDeclined) {
		this.isInsrDeclined = isInsrDeclined;
	}

	public String getIsOthrCompIns() {
		return this.isOthrCompIns;
	}

	public void setIsOthrCompIns(String isOthrCompIns) {
		this.isOthrCompIns = isOthrCompIns;
	}

	public String getIsResiOffcShop() {
		return this.isResiOffcShop;
	}

	public void setIsResiOffcShop(String isResiOffcShop) {
		this.isResiOffcShop = isResiOffcShop;
	}

	public String getIsRiReqd() {
		return this.isRiReqd;
	}

	public void setIsRiReqd(String isRiReqd) {
		this.isRiReqd = isRiReqd;
	}

	public String getIsStockStorOpen() {
		return this.isStockStorOpen;
	}

	public void setIsStockStorOpen(String isStockStorOpen) {
		this.isStockStorOpen = isStockStorOpen;
	}

	public String getIsUsedAsShop() {
		return this.isUsedAsShop;
	}

	public void setIsUsedAsShop(String isUsedAsShop) {
		this.isUsedAsShop = isUsedAsShop;
	}

	public String getIssuedInFavor() {
		return this.issuedInFavor;
	}

	public void setIssuedInFavor(String issuedInFavor) {
		this.issuedInFavor = issuedInFavor;
	}

	public String getManufProductList() {
		return this.manufProductList;
	}

	public void setManufProductList(String manufProductList) {
		this.manufProductList = manufProductList;
	}

	public String getMarketValBasis() {
		return this.marketValBasis;
	}

	public void setMarketValBasis(String marketValBasis) {
		this.marketValBasis = marketValBasis;
	}

	public double getOmmissionAddtn() {
		return this.ommissionAddtn;
	}

	public void setOmmissionAddtn(double ommissionAddtn) {
		this.ommissionAddtn = ommissionAddtn;
	}

	public double getOpenStocksAmt() {
		return this.openStocksAmt;
	}

	public void setOpenStocksAmt(double openStocksAmt) {
		this.openStocksAmt = openStocksAmt;
	}

	public String getOpenStorLoc() {
		return this.openStorLoc;
	}

	public void setOpenStorLoc(String openStorLoc) {
		this.openStorLoc = openStorLoc;
	}

	public String getOthrCompnyName() {
		return this.othrCompnyName;
	}

	public void setOthrCompnyName(String othrCompnyName) {
		this.othrCompnyName = othrCompnyName;
	}

	public String getOutGasTanksRisk() {
		return this.outGasTanksRisk;
	}

	public void setOutGasTanksRisk(String outGasTanksRisk) {
		this.outGasTanksRisk = outGasTanksRisk;
	}

	public String getOutStorgRisk() {
		return this.outStorgRisk;
	}

	public void setOutStorgRisk(String outStorgRisk) {
		this.outStorgRisk = outStorgRisk;
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

	public long getPolicyTypeId() {
		return this.policyTypeId;
	}

	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
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

	public String getProposerBusiness() {
		return this.proposerBusiness;
	}

	public void setProposerBusiness(String proposerBusiness) {
		this.proposerBusiness = proposerBusiness;
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

	public String getReinstatValBasis() {
		return this.reinstatValBasis;
	}

	public void setReinstatValBasis(String reinstatValBasis) {
		this.reinstatValBasis = reinstatValBasis;
	}

	public String getRoofMaterialUsed() {
		return this.roofMaterialUsed;
	}

	public void setRoofMaterialUsed(String roofMaterialUsed) {
		this.roofMaterialUsed = roofMaterialUsed;
	}

	public double getSpontCombustion() {
		return this.spontCombustion;
	}

	public void setSpontCombustion(double spontCombustion) {
		this.spontCombustion = spontCombustion;
	}

	public String getStockValExceed() {
		return this.stockValExceed;
	}

	public void setStockValExceed(String stockValExceed) {
		this.stockValExceed = stockValExceed;
	}

	public double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getTerrorismDtls() {
		return this.terrorismDtls;
	}

	public void setTerrorismDtls(String terrorismDtls) {
		this.terrorismDtls = terrorismDtls;
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

	public String getUsedAsIndustry() {
		return this.usedAsIndustry;
	}

	public void setUsedAsIndustry(String usedAsIndustry) {
		this.usedAsIndustry = usedAsIndustry;
	}

	public String getUsedWarehouseGodwn() {
		return this.usedWarehouseGodwn;
	}

	public void setUsedWarehouseGodwn(String usedWarehouseGodwn) {
		this.usedWarehouseGodwn = usedWarehouseGodwn;
	}

	public String getUtilitiesOutRisk() {
		return this.utilitiesOutRisk;
	}

	public void setUtilitiesOutRisk(String utilitiesOutRisk) {
		this.utilitiesOutRisk = utilitiesOutRisk;
	}

	public double getVehicleDamage() {
		return this.vehicleDamage;
	}

	public void setVehicleDamage(double vehicleDamage) {
		this.vehicleDamage = vehicleDamage;
	}

	public String getWallMaterialUsed() {
		return this.wallMaterialUsed;
	}

	public void setWallMaterialUsed(String wallMaterialUsed) {
		this.wallMaterialUsed = wallMaterialUsed;
	}

	public List<TdoiDbPolFireBuildingValDTO> getTdoiDbPolFireBuildingVals() {
		return this.tdoiDbPolFireBuildingVals;
	}

	public void setTdoiDbPolFireBuildingVals(List<TdoiDbPolFireBuildingValDTO> tdoiDbPolFireBuildingVals) {
		this.tdoiDbPolFireBuildingVals = tdoiDbPolFireBuildingVals;
	}

	public TdoiDbPolFireBuildingValDTO addTdoiDbPolFireBuildingVal(
			TdoiDbPolFireBuildingValDTO tdoiDbPolFireBuildingVal) {
		getTdoiDbPolFireBuildingVals().add(tdoiDbPolFireBuildingVal);
		tdoiDbPolFireBuildingVal.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFireBuildingVal;
	}

	public TdoiDbPolFireBuildingValDTO removeTdoiDbPolFireBuildingVal(
			TdoiDbPolFireBuildingValDTO tdoiDbPolFireBuildingVal) {
		getTdoiDbPolFireBuildingVals().remove(tdoiDbPolFireBuildingVal);
		tdoiDbPolFireBuildingVal.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFireBuildingVal;
	}

	public List<TdoiDbPolFirePastPolicyDTO> getTdoiDbPolFirePastPolicies() {
		return this.tdoiDbPolFirePastPolicies;
	}

	public void setTdoiDbPolFirePastPolicies(List<TdoiDbPolFirePastPolicyDTO> tdoiDbPolFirePastPolicies) {
		this.tdoiDbPolFirePastPolicies = tdoiDbPolFirePastPolicies;
	}

	public TdoiDbPolFirePastPolicyDTO addTdoiDbPolFirePastPolicy(TdoiDbPolFirePastPolicyDTO tdoiDbPolFirePastPolicy) {
		getTdoiDbPolFirePastPolicies().add(tdoiDbPolFirePastPolicy);
		tdoiDbPolFirePastPolicy.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFirePastPolicy;
	}

	public TdoiDbPolFirePastPolicyDTO removeTdoiDbPolFirePastPolicy(
			TdoiDbPolFirePastPolicyDTO tdoiDbPolFirePastPolicy) {
		getTdoiDbPolFirePastPolicies().remove(tdoiDbPolFirePastPolicy);
		tdoiDbPolFirePastPolicy.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFirePastPolicy;
	}

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPolFireRiDtlDTO> getTdoiDbPolFireRiDtls() {
		return this.tdoiDbPolFireRiDtls;
	}

	public void setTdoiDbPolFireRiDtls(List<TdoiDbPolFireRiDtlDTO> tdoiDbPolFireRiDtls) {
		this.tdoiDbPolFireRiDtls = tdoiDbPolFireRiDtls;
	}

	public TdoiDbPolFireRiDtlDTO addTdoiDbPolFireRiDtl(TdoiDbPolFireRiDtlDTO tdoiDbPolFireRiDtl) {
		getTdoiDbPolFireRiDtls().add(tdoiDbPolFireRiDtl);
		tdoiDbPolFireRiDtl.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFireRiDtl;
	}

	public TdoiDbPolFireRiDtlDTO removeTdoiDbPolFireRiDtl(TdoiDbPolFireRiDtlDTO tdoiDbPolFireRiDtl) {
		getTdoiDbPolFireRiDtls().remove(tdoiDbPolFireRiDtl);
		tdoiDbPolFireRiDtl.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFireRiDtl;
	}

	public List<TdoiDbPolFireSumInsuredDTO> getTdoiDbPolFireSumInsureds() {
		return this.tdoiDbPolFireSumInsureds;
	}

	public void setTdoiDbPolFireSumInsureds(List<TdoiDbPolFireSumInsuredDTO> tdoiDbPolFireSumInsureds) {
		this.tdoiDbPolFireSumInsureds = tdoiDbPolFireSumInsureds;
	}

	public TdoiDbPolFireSumInsuredDTO addTdoiDbPolFireSumInsured(TdoiDbPolFireSumInsuredDTO tdoiDbPolFireSumInsured) {
		getTdoiDbPolFireSumInsureds().add(tdoiDbPolFireSumInsured);
		tdoiDbPolFireSumInsured.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFireSumInsured;
	}

	public TdoiDbPolFireSumInsuredDTO removeTdoiDbPolFireSumInsured(
			TdoiDbPolFireSumInsuredDTO tdoiDbPolFireSumInsured) {
		getTdoiDbPolFireSumInsureds().remove(tdoiDbPolFireSumInsured);
		tdoiDbPolFireSumInsured.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFireSumInsured;
	}

	public List<TdoiDbPolFireWfDTO> getTdoiDbPolFireWfs() {
		return this.tdoiDbPolFireWfs;
	}

	public void setTdoiDbPolFireWfs(List<TdoiDbPolFireWfDTO> tdoiDbPolFireWfs) {
		this.tdoiDbPolFireWfs = tdoiDbPolFireWfs;
	}

	public TdoiDbPolFireWfDTO addTdoiDbPolFireWf(TdoiDbPolFireWfDTO tdoiDbPolFireWf) {
		getTdoiDbPolFireWfs().add(tdoiDbPolFireWf);
		tdoiDbPolFireWf.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFireWf;
	}

	public TdoiDbPolFireWfDTO removeTdoiDbPolFireWf(TdoiDbPolFireWfDTO tdoiDbPolFireWf) {
		getTdoiDbPolFireWfs().remove(tdoiDbPolFireWf);
		tdoiDbPolFireWf.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFireWf;
	}

}
