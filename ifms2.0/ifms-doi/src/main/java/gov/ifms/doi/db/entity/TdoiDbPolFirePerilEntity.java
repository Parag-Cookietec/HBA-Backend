package gov.ifms.doi.db.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_POL_FIRE_PERIL database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_POL_FIRE_PERIL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPolFirePerilEntity.findAll", query = "SELECT t FROM TdoiDbPolFirePerilEntity t")
public class TdoiDbPolFirePerilEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POL_FIRE_PERIL_ID", unique = true, nullable = false)
	private long polFirePerilId;

	@Column(name = "ANY_INDUSTRY_RISK", length = 1)
	private String anyIndustryRisk;

	@Column(name = "ARCHITECT_FEES")
	private double architectFees;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_NAME", length = 40)
	private String bankName;

	@Column(name = "BASIS_PROP_INSUR", length = 20)
	private String basisPropInsur;

	@Column(name = "BRANCH_ID")
	private long branchId;

	@Column(name = "BRANCH_NAME", length = 40)
	private String branchName;

	@Column(name = "BUILDING_AGE_ID")
	private long buildingAgeId;

	@Column(name = "BUILDING_HEIGHT", length = 20)
	private String buildingHeight;

	@Column(name = "CHALLAN_AMOUNT")
	private double challanAmount;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHALLAN_DT")
	private Date challanDt;

	@Column(name = "CHALLAN_NO", length = 20)
	private String challanNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHEQUE_DD_DT")
	private Date chequeDdDt;

	@Column(name = "CHEQUE_DD_NO", length = 20)
	private String chequeDdNo;

	@Column(name = "COLD_STRG_DETOR")
	private double coldStrgDetor;

	@Column(name = "COVERS_INCLUDED", length = 200)
	private String coversIncluded;

	@Column(name = "DEBRIS_REMVL_AMT")
	private double debrisRemvlAmt;

	@Column(name = "DECLARE_BASIS_AMT")
	private double declareBasisAmt;

	@Column(name = "DECLINE_DETAILS", length = 200)
	private String declineDetails;

	@Column(name = "FACTORY_STATUS")
	private long factoryStatus;

	@Column(name = "FIRE_PROTECT_DEVICE", length = 200)
	private String fireProtectDevice;

	@Column(name = "FIRM_CAPITAL_PAID")
	private double firmCapitalPaid;

	@Column(name = "FLOAT_DEC_BASIS_AMT")
	private double floatDecBasisAmt;

	@Column(name = "FLOATER_BASIS_AMT")
	private double floaterBasisAmt;

	@Column(name = "FLOOR_MATERIAL_USED", length = 200)
	private String floorMaterialUsed;

	@Column(name = "FOREST_FIRE")
	private double forestFire;

	@Column(name = "GOODS_AS_PER_LIST", length = 1)
	private String goodsAsPerList;

	@Column(name = "GOODS_STORED_LIST", length = 400)
	private String goodsStoredList;

	@Column(name = "INSRNC_PREMIUM")
	private double insrncPremium;

	@Column(name = "INSRNCE_DETAILS", length = 200)
	private String insrnceDetails;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_END_DT")
	private Date insurEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_START_DT")
	private Date insurStartDt;

	@Column(name = "IS_ARCHITECT_FEES_ADD", length = 1)
	private String isArchitectFeesAdd;

	@Column(name = "IS_COVER_PINTH", length = 1)
	private String isCoverPinth;

	@Column(name = "IS_DEBRIS_REMV_ADD", length = 1)
	private String isDebrisRemvAdd;

	@Column(name = "IS_DECLARAE_BASIS", length = 1)
	private String isDeclaraeBasis;

	@Column(name = "IS_EARTHQUAKE_COV", length = 1)
	private String isEarthquakeCov;

	@Column(name = "IS_FLOAT_DEC_BASIS", length = 1)
	private String isFloatDecBasis;

	@Column(name = "IS_FLOATER_BASIS", length = 1)
	private String isFloaterBasis;

	@Column(name = "IS_INSR_DECLINED", length = 1)
	private String isInsrDeclined;

	@Column(name = "IS_OTHR_COMP_INS", length = 1)
	private String isOthrCompIns;

	@Column(name = "IS_RESI_OFFC_SHOP", length = 1)
	private String isResiOffcShop;

	@Column(name = "IS_RI_REQD", length = 1)
	private String isRiReqd;

	@Column(name = "IS_STOCK_STOR_OPEN", length = 1)
	private String isStockStorOpen;

	@Column(name = "IS_USED_AS_SHOP", length = 1)
	private String isUsedAsShop;

	@Column(name = "ISSUED_IN_FAVOR", length = 200)
	private String issuedInFavor;

	@Column(name = "MANUF_PRODUCT_LIST", length = 400)
	private String manufProductList;

	@Column(name = "MARKET_VAL_BASIS", length = 10)
	private String marketValBasis;

	@Column(name = "OMMISSION_ADDTN")
	private double ommissionAddtn;

	@Column(name = "OPEN_STOCKS_AMT")
	private double openStocksAmt;

	@Column(name = "OPEN_STOR_LOC", length = 50)
	private String openStorLoc;

	@Column(name = "OTHR_COMPNY_NAME", length = 100)
	private String othrCompnyName;

	@Column(name = "OUT_GAS_TANKS_RISK", length = 1)
	private String outGasTanksRisk;

	@Column(name = "OUT_STORG_RISK", length = 1)
	private String outStorgRisk;

	@Column(name = "PAYABLE_PREM_AMT")
	private double payablePremAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;

	@Column(name = "PAYMENT_MODE_ID")
	private long paymentModeId;

	@Column(name = "POLICY_TYPE_ID")
	private long policyTypeId;

	@Column(name = "PREM_DISC_AMT")
	private double premDiscAmt;

	@Column(name = "PREM_DISC_PC")
	private double premDiscPc;

	@Column(name = "PREM_GST_AMT")
	private double premGstAmt;

	@Column(name = "PREM_GST_PC")
	private double premGstPc;

	@Column(name = "PROPOSER_BUSINESS", length = 100)
	private String proposerBusiness;

	@Column(name = "PROPSL_POLICIES_ID", nullable = false)
	private long propslPoliciesId;

	@Column(name = "RATE_OF_INTRST")
	private double rateOfIntrst;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "REINSTAT_VAL_BASIS", length = 10)
	private String reinstatValBasis;

	@Column(name = "ROOF_MATERIAL_USED", length = 200)
	private String roofMaterialUsed;

	@Column(name = "SPONT_COMBUSTION")
	private double spontCombustion;

	@Column(name = "STOCK_VAL_EXCEED", length = 1)
	private String stockValExceed;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	@Column(name = "TERRORISM_DTLS", length = 100)
	private String terrorismDtls;

	@Column(name = "TOT_ADDON_PREM")
	private double totAddonPrem;

	@Column(name = "TOT_RI_AMT")
	private double totRiAmt;

	@Column(name = "TOTAL_PREMIUM")
	private double totalPremium;

	@Column(name = "USED_AS_INDUSTRY", length = 1)
	private String usedAsIndustry;

	@Column(name = "USED_WAREHOUSE_GODWN", length = 1)
	private String usedWarehouseGodwn;

	@Column(name = "UTILITIES_OUT_RISK", length = 1)
	private String utilitiesOutRisk;

	@Column(name = "VEHICLE_DAMAGE")
	private double vehicleDamage;

	@Column(name = "WALL_MATERIAL_USED", length = 200)
	private String wallMaterialUsed;

	// bi-directional many-to-one association to TdoiDbPolFireBuildingVal
	@OneToMany(mappedBy = "tdoiDbPolFirePeril")
	private List<TdoiDbPolFireBuildingValEntity> tdoiDbPolFireBuildingVals;

	// bi-directional many-to-one association to TdoiDbPolFirePastPolicy
	@OneToMany(mappedBy = "tdoiDbPolFirePeril")
	private List<TdoiDbPolFirePastPolicyEntity> tdoiDbPolFirePastPolicies;

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID", nullable = false)
	private TdoiDbProposalEntity tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbPolFireRiDtl
	@OneToMany(mappedBy = "tdoiDbPolFirePeril")
	private List<TdoiDbPolFireRiDtlEntity> tdoiDbPolFireRiDtls;

	// bi-directional many-to-one association to TdoiDbPolFireSumInsured
	@OneToMany(mappedBy = "tdoiDbPolFirePeril")
	private List<TdoiDbPolFireSumInsuredEntity> tdoiDbPolFireSumInsureds;

	// bi-directional many-to-one association to TdoiDbPolFireWf
	@OneToMany(mappedBy = "tdoiDbPolFirePeril")
	private List<TdoiDbPolFireWfEntity> tdoiDbPolFireWfs;

	public TdoiDbPolFirePerilEntity() {
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

	public List<TdoiDbPolFireBuildingValEntity> getTdoiDbPolFireBuildingVals() {
		return this.tdoiDbPolFireBuildingVals;
	}

	public void setTdoiDbPolFireBuildingVals(List<TdoiDbPolFireBuildingValEntity> tdoiDbPolFireBuildingVals) {
		this.tdoiDbPolFireBuildingVals = tdoiDbPolFireBuildingVals;
	}

	public TdoiDbPolFireBuildingValEntity addTdoiDbPolFireBuildingVal(
			TdoiDbPolFireBuildingValEntity tdoiDbPolFireBuildingVal) {
		getTdoiDbPolFireBuildingVals().add(tdoiDbPolFireBuildingVal);
		tdoiDbPolFireBuildingVal.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFireBuildingVal;
	}

	public TdoiDbPolFireBuildingValEntity removeTdoiDbPolFireBuildingVal(
			TdoiDbPolFireBuildingValEntity tdoiDbPolFireBuildingVal) {
		getTdoiDbPolFireBuildingVals().remove(tdoiDbPolFireBuildingVal);
		tdoiDbPolFireBuildingVal.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFireBuildingVal;
	}

	public List<TdoiDbPolFirePastPolicyEntity> getTdoiDbPolFirePastPolicies() {
		return this.tdoiDbPolFirePastPolicies;
	}

	public void setTdoiDbPolFirePastPolicies(List<TdoiDbPolFirePastPolicyEntity> tdoiDbPolFirePastPolicies) {
		this.tdoiDbPolFirePastPolicies = tdoiDbPolFirePastPolicies;
	}

	public TdoiDbPolFirePastPolicyEntity addTdoiDbPolFirePastPolicy(
			TdoiDbPolFirePastPolicyEntity tdoiDbPolFirePastPolicy) {
		getTdoiDbPolFirePastPolicies().add(tdoiDbPolFirePastPolicy);
		tdoiDbPolFirePastPolicy.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFirePastPolicy;
	}

	public TdoiDbPolFirePastPolicyEntity removeTdoiDbPolFirePastPolicy(
			TdoiDbPolFirePastPolicyEntity tdoiDbPolFirePastPolicy) {
		getTdoiDbPolFirePastPolicies().remove(tdoiDbPolFirePastPolicy);
		tdoiDbPolFirePastPolicy.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFirePastPolicy;
	}

	public TdoiDbProposalEntity getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalEntity tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPolFireRiDtlEntity> getTdoiDbPolFireRiDtls() {
		return this.tdoiDbPolFireRiDtls;
	}

	public void setTdoiDbPolFireRiDtls(List<TdoiDbPolFireRiDtlEntity> tdoiDbPolFireRiDtls) {
		this.tdoiDbPolFireRiDtls = tdoiDbPolFireRiDtls;
	}

	public TdoiDbPolFireRiDtlEntity addTdoiDbPolFireRiDtl(TdoiDbPolFireRiDtlEntity tdoiDbPolFireRiDtl) {
		getTdoiDbPolFireRiDtls().add(tdoiDbPolFireRiDtl);
		tdoiDbPolFireRiDtl.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFireRiDtl;
	}

	public TdoiDbPolFireRiDtlEntity removeTdoiDbPolFireRiDtl(TdoiDbPolFireRiDtlEntity tdoiDbPolFireRiDtl) {
		getTdoiDbPolFireRiDtls().remove(tdoiDbPolFireRiDtl);
		tdoiDbPolFireRiDtl.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFireRiDtl;
	}

	public List<TdoiDbPolFireSumInsuredEntity> getTdoiDbPolFireSumInsureds() {
		return this.tdoiDbPolFireSumInsureds;
	}

	public void setTdoiDbPolFireSumInsureds(List<TdoiDbPolFireSumInsuredEntity> tdoiDbPolFireSumInsureds) {
		this.tdoiDbPolFireSumInsureds = tdoiDbPolFireSumInsureds;
	}

	public TdoiDbPolFireSumInsuredEntity addTdoiDbPolFireSumInsured(
			TdoiDbPolFireSumInsuredEntity tdoiDbPolFireSumInsured) {
		getTdoiDbPolFireSumInsureds().add(tdoiDbPolFireSumInsured);
		tdoiDbPolFireSumInsured.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFireSumInsured;
	}

	public TdoiDbPolFireSumInsuredEntity removeTdoiDbPolFireSumInsured(
			TdoiDbPolFireSumInsuredEntity tdoiDbPolFireSumInsured) {
		getTdoiDbPolFireSumInsureds().remove(tdoiDbPolFireSumInsured);
		tdoiDbPolFireSumInsured.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFireSumInsured;
	}

	public List<TdoiDbPolFireWfEntity> getTdoiDbPolFireWfs() {
		return this.tdoiDbPolFireWfs;
	}

	public void setTdoiDbPolFireWfs(List<TdoiDbPolFireWfEntity> tdoiDbPolFireWfs) {
		this.tdoiDbPolFireWfs = tdoiDbPolFireWfs;
	}

	public TdoiDbPolFireWfEntity addTdoiDbPolFireWf(TdoiDbPolFireWfEntity tdoiDbPolFireWf) {
		getTdoiDbPolFireWfs().add(tdoiDbPolFireWf);
		tdoiDbPolFireWf.setTdoiDbPolFirePeril(this);

		return tdoiDbPolFireWf;
	}

	public TdoiDbPolFireWfEntity removeTdoiDbPolFireWf(TdoiDbPolFireWfEntity tdoiDbPolFireWf) {
		getTdoiDbPolFireWfs().remove(tdoiDbPolFireWf);
		tdoiDbPolFireWf.setTdoiDbPolFirePeril(null);

		return tdoiDbPolFireWf;
	}

}