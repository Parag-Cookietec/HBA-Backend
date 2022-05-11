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
 * The persistent class for the TDOI_DB_PROPSL_BURGLARY database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROPSL_BURGLARY", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropslBurglaryEntity.findAll", query = "SELECT t FROM TdoiDbPropslBurglaryEntity t")
public class TdoiDbPropslBurglaryEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DB_BURGLARY_ID", unique = true, nullable = false)
	private long dbBurglaryId;

	@Column(name = "AGAINST_FIRE_AMT")
	private double againstFireAmt;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_NAME", length = 40)
	private String bankName;

	@Column(name = "BOOKS_KEPT_ATNIGHT", length = 50)
	private String booksKeptAtnight;

	@Column(name = "BRANCH_ID")
	private long branchId;

	@Column(name = "BRANCH_NAME", length = 40)
	private String branchName;

	@Column(name = "CASH_IN_SAFE_PREM")
	private double cashInSafePrem;

	@Column(name = "CASH_IN_SAFE_RATE")
	private double cashInSafeRate;

	@Column(name = "CASH_IN_SAFE_SI")
	private double cashInSafeSi;

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

	@Column(name = "CLAIM_COMPANY_NAME", length = 100)
	private String claimCompanyName;

	@Column(name = "DECL_PERSON_NAME", length = 60)
	private String declPersonName;

	@Column(name = "EXTERN_DOOR_TYPE", length = 50)
	private String externDoorType;

	@Column(name = "FIRM_CAPITAL_PAID")
	private double firmCapitalPaid;

	@Column(name = "FIXTURE_FITTING_PREM")
	private double fixtureFittingPrem;

	@Column(name = "FIXTURE_FITTING_RATE")
	private double fixtureFittingRate;

	@Column(name = "FIXTURE_FITTING_SI")
	private double fixtureFittingSi;

	@Column(name = "GOODS_IN_TRUST_PREM")
	private double goodsInTrustPrem;

	@Column(name = "GOODS_IN_TRUST_RATE")
	private double goodsInTrustRate;

	@Column(name = "GOODS_IN_TRUST_SI")
	private double goodsInTrustSi;

	@Column(name = "HOW_GAIN_ACCESS", length = 100)
	private String howGainAccess;

	@Column(name = "INSRNC_PREMIUM")
	private double insrncPremium;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_END_DT")
	private Date insurEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_START_DT")
	private Date insurStartDt;

	@Column(name = "IS_BUILD_BURGL", length = 1)
	private String isBuildBurgl;

	@Column(name = "IS_INCRSD_RATE_REQD", length = 1)
	private String isIncrsdRateReqd;

	@Column(name = "IS_LEFT_UNOCCUPY", length = 1)
	private String isLeftUnoccupy;

	@Column(name = "IS_OTHR_COMP_PROPSD", length = 1)
	private String isOthrCompPropsd;

	@Column(name = "IS_PROPSL_ACCEPT_DECL", length = 1)
	private String isPropslAcceptDecl;

	@Column(name = "IS_RENEWL_ACCEPT_DECL", length = 1)
	private String isRenewlAcceptDecl;

	@Column(name = "IS_RI_REQD", length = 1)
	private String isRiReqd;

	@Column(name = "IS_ROBBERY_CLAIMED", length = 1)
	private String isRobberyClaimed;

	@Column(name = "IS_SAFE_FIX_WALL", length = 1)
	private String isSafeFixWall;

	@Column(name = "IS_SOLE_OCCUPIER", length = 1)
	private String isSoleOccupier;

	@Column(name = "IS_STOCKBOOK_KEPT", length = 1)
	private String isStockbookKept;

	@Column(name = "IS_VAL_SAFE_BURG", length = 1)
	private String isValSafeBurg;

	@Column(name = "ISSUED_IN_FAVOR", length = 200)
	private String issuedInFavor;

	@Column(name = "KEYS_HELD_BY", length = 30)
	private String keysHeldBy;

	@Column(name = "KEYS_NUMBER")
	private short keysNumber;

	@Column(name = "OCCUPATION_TRADE", length = 100)
	private String occupationTrade;

	@Column(name = "OTHERWISE_OCCUPY", length = 100)
	private String otherwiseOccupy;

	@Column(name = "OTHR_COMPANY_NAME", length = 100)
	private String othrCompanyName;

	@Column(name = "PAYABLE_PREM_AMT")
	private double payablePremAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;

	@Column(name = "PAYMENT_MODE_ID")
	private long paymentModeId;

	@Column(name = "PREM_DISC_AMT")
	private double premDiscAmt;

	@Column(name = "PREM_DISC_PC")
	private double premDiscPc;

	@Column(name = "PREM_GST_AMT")
	private double premGstAmt;

	@Column(name = "PREM_GST_PC")
	private double premGstPc;

	@Column(name = "PREM_OCCUPY_DUR", length = 100)
	private String premOccupyDur;

	@Column(name = "PREM_UNOCCUPY_DUR", length = 100)
	private String premUnoccupyDur;

	@Column(name = "PREMISES_DESC_ID")
	private long premisesDescId;

	@Column(name = "PROPERTY_ADDRESS", length = 200)
	private String propertyAddress;

	@Column(name = "PROPOSER_BUSINESS", length = 100)
	private String proposerBusiness;

	@Column(name = "PROPRTY_PREMIUM_AMT")
	private double proprtyPremiumAmt;

	@Column(name = "PROPRTY_SUM_INSRD_AMT")
	private double proprtySumInsrdAmt;

	@Column(name = "PROPSL_POLICIES_ID", nullable = false)
	private long propslPoliciesId;

	@Column(name = "RATE_OF_INTRST")
	private double rateOfIntrst;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "REOCCUR_PRECAUTION", length = 100)
	private String reoccurPrecaution;

	@Column(name = "ROBBERED_AMT")
	private double robberedAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "ROBBERY_DT")
	private Date robberyDt;

	@Column(name = "SAFE_COST")
	private double safeCost;

	@Column(name = "SAFE_DIMENSION", length = 30)
	private String safeDimension;

	@Column(name = "SAFE_MAKER_NAME", length = 50)
	private String safeMakerName;

	@Column(name = "SKYLIGHT_TRAP_DOOR", length = 50)
	private String skylightTrapDoor;

	@Column(name = "STATE_RENTAL_PA")
	private double stateRentalPa;

	@Column(name = "STOCK_IN_TRADE_AMT")
	private double stockInTradeAmt;

	@Column(name = "STOCK_IN_TRADE_PREM")
	private double stockInTradePrem;

	@Column(name = "STOCK_IN_TRADE_RATE")
	private double stockInTradeRate;

	@Column(name = "STOCK_IN_TRADE_SI")
	private double stockInTradeSi;

	@Column(name = "STOCK_INSRD_COMP_NAME", length = 100)
	private String stockInsrdCompName;

	@Column(name = "STOCKBOOK_FREQ", length = 50)
	private String stockbookFreq;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	@Column(name = "TOT_ADDON_PREM")
	private double totAddonPrem;

	@Column(name = "TOT_RI_AMT")
	private double totRiAmt;

	@Column(name = "TOTAL_PREMIUM")
	private double totalPremium;

	@Column(name = "WINDOWS_TYPE", length = 50)
	private String windowsType;

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID", nullable = false)
	private TdoiDbProposalEntity tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbPropslBurglaryWf
	@OneToMany(mappedBy = "tdoiDbPropslBurglary")
	private List<TdoiDbPropslBurglaryWfEntity> tdoiDbPropslBurglaryWfs;

	// bi-directional many-to-one association to TdoiDbPropBuglrRiDtl
	@OneToMany(mappedBy = "tdoiDbPropslBurglary")
	private List<TdoiDbPropBuglrRiDtlEntity> tdoiDbPropBuglrRiDtls;

	public TdoiDbPropslBurglaryEntity() {
	}

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

	public TdoiDbProposalEntity getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalEntity tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPropslBurglaryWfEntity> getTdoiDbPropslBurglaryWfs() {
		return this.tdoiDbPropslBurglaryWfs;
	}

	public void setTdoiDbPropslBurglaryWfs(List<TdoiDbPropslBurglaryWfEntity> tdoiDbPropslBurglaryWfs) {
		this.tdoiDbPropslBurglaryWfs = tdoiDbPropslBurglaryWfs;
	}

	public TdoiDbPropslBurglaryWfEntity addTdoiDbPropslBurglaryWf(TdoiDbPropslBurglaryWfEntity tdoiDbPropslBurglaryWf) {
		getTdoiDbPropslBurglaryWfs().add(tdoiDbPropslBurglaryWf);
		tdoiDbPropslBurglaryWf.setTdoiDbPropslBurglary(this);

		return tdoiDbPropslBurglaryWf;
	}

	public TdoiDbPropslBurglaryWfEntity removeTdoiDbPropslBurglaryWf(
			TdoiDbPropslBurglaryWfEntity tdoiDbPropslBurglaryWf) {
		getTdoiDbPropslBurglaryWfs().remove(tdoiDbPropslBurglaryWf);
		tdoiDbPropslBurglaryWf.setTdoiDbPropslBurglary(null);

		return tdoiDbPropslBurglaryWf;
	}

	public List<TdoiDbPropBuglrRiDtlEntity> getTdoiDbPropBuglrRiDtls() {
		return this.tdoiDbPropBuglrRiDtls;
	}

	public void setTdoiDbPropBuglrRiDtls(List<TdoiDbPropBuglrRiDtlEntity> tdoiDbPropBuglrRiDtls) {
		this.tdoiDbPropBuglrRiDtls = tdoiDbPropBuglrRiDtls;
	}

	public TdoiDbPropBuglrRiDtlEntity addTdoiDbPropBuglrRiDtl(TdoiDbPropBuglrRiDtlEntity tdoiDbPropBuglrRiDtl) {
		getTdoiDbPropBuglrRiDtls().add(tdoiDbPropBuglrRiDtl);
		tdoiDbPropBuglrRiDtl.setTdoiDbPropslBurglary(this);

		return tdoiDbPropBuglrRiDtl;
	}

	public TdoiDbPropBuglrRiDtlEntity removeTdoiDbPropBuglrRiDtl(TdoiDbPropBuglrRiDtlEntity tdoiDbPropBuglrRiDtl) {
		getTdoiDbPropBuglrRiDtls().remove(tdoiDbPropBuglrRiDtl);
		tdoiDbPropBuglrRiDtl.setTdoiDbPropslBurglary(null);

		return tdoiDbPropBuglrRiDtl;
	}

}