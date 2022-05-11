package gov.ifms.loc.dto;

import java.io.Serializable;

/**
 * The Class LocAdvicedeductionSdDto.
 * 
 * @version v 1.0
 * @created 2021/02/23 16:58:33
 *
 */
public class LocAdviceDeductionDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The pt amt. */
	private Double ptAmt;

	/** The labour amt. */
	private Double labourAmt;

	/** The for all mh amt. */
	private Double forAllMhAmt;

	/** The it amt. */
	private Double itAmt;

	/** The surcharge amt. */
	private Double surchargeAmt;

	/** The gpf class 4 amt. */
	private Double gpfClass4Amt;

	/** The cpf amt. */
	private Double cpfAmt;

	/** The building rent amt. */
	private Double buildingRentAmt;

	/** The govt insu fund amt. */
	private Double govtInsuFundAmt;

	/** The insurance fund amt. */
	private Double insuranceFundAmt;

	/** The security deposit amt. */
	private Double securityDepositAmt;

	/** The estd charge amt. */
	private Double estdChargeAmt;

	/** The machinery charge amt. */
	private Double machineryChargeAmt;

	/** The loc advice hrd id. */
	private Long locAdviceHrdId;

	/** The loc Net total. */
	private Double netTotal;

	/** The loc Gross total. */
	private Double grossAmount;
	
	/** The loc opening balance. */
	private Double openingBalance;
	
	/** The loc new lc balance. */
	private Double newBalance;
	
	
	/** The loc Closing balance. */
	private Double closingBalance;

	/** The loc Deduction Amount. */
	private Double deductionTotal;

	/**
	 * LocAdvicedeductionSdDto Constructor.
	 */
	public LocAdviceDeductionDto() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the id
	 */

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the ptAmt
	 */
	public Double getPtAmt() {
		return ptAmt;
	}

	/**
	 * @param ptAmt the ptAmt to set
	 */
	public void setPtAmt(Double ptAmt) {
		this.ptAmt = ptAmt;
	}

	/**
	 * @return the labourAmt
	 */
	public Double getLabourAmt() {
		return labourAmt;
	}

	/**
	 * @param labourAmt the labourAmt to set
	 */
	public void setLabourAmt(Double labourAmt) {
		this.labourAmt = labourAmt;
	}

	/**
	 * @return the forAllMhAmt
	 */
	public Double getForAllMhAmt() {
		return forAllMhAmt;
	}

	/**
	 * @param forAllMhAmt the forAllMhAmt to set
	 */
	public void setForAllMhAmt(Double forAllMhAmt) {
		this.forAllMhAmt = forAllMhAmt;
	}

	/**
	 * @return the itAmt
	 */
	public Double getItAmt() {
		return itAmt;
	}

	/**
	 * @param itAmt the itAmt to set
	 */
	public void setItAmt(Double itAmt) {
		this.itAmt = itAmt;
	}

	/**
	 * @return the surchargeAmt
	 */
	public Double getSurchargeAmt() {
		return surchargeAmt;
	}

	/**
	 * @param surchargeAmt the surchargeAmt to set
	 */
	public void setSurchargeAmt(Double surchargeAmt) {
		this.surchargeAmt = surchargeAmt;
	}

	/**
	 * @return the gpfClass4Amt
	 */
	public Double getGpfClass4Amt() {
		return gpfClass4Amt;
	}

	/**
	 * @param gpfClass4Amt the gpfClass4Amt to set
	 */
	public void setGpfClass4Amt(Double gpfClass4Amt) {
		this.gpfClass4Amt = gpfClass4Amt;
	}

	/**
	 * @return the cpfAmt
	 */
	public Double getCpfAmt() {
		return cpfAmt;
	}

	/**
	 * @param cpfAmt the cpfAmt to set
	 */
	public void setCpfAmt(Double cpfAmt) {
		this.cpfAmt = cpfAmt;
	}

	/**
	 * @return the buildingRentAmt
	 */
	public Double getBuildingRentAmt() {
		return buildingRentAmt;
	}

	/**
	 * @param buildingRentAmt the buildingRentAmt to set
	 */
	public void setBuildingRentAmt(Double buildingRentAmt) {
		this.buildingRentAmt = buildingRentAmt;
	}

	/**
	 * @return the govtInsuFundAmt
	 */
	public Double getGovtInsuFundAmt() {
		return govtInsuFundAmt;
	}

	/**
	 * @param govtInsuFundAmt the govtInsuFundAmt to set
	 */
	public void setGovtInsuFundAmt(Double govtInsuFundAmt) {
		this.govtInsuFundAmt = govtInsuFundAmt;
	}

	/**
	 * @return the insuranceFundAmt
	 */
	public Double getInsuranceFundAmt() {
		return insuranceFundAmt;
	}

	/**
	 * @param insuranceFundAmt the insuranceFundAmt to set
	 */
	public void setInsuranceFundAmt(Double insuranceFundAmt) {
		this.insuranceFundAmt = insuranceFundAmt;
	}

	/**
	 * @return the securityDepositAmt
	 */
	public Double getSecurityDepositAmt() {
		return securityDepositAmt;
	}

	/**
	 * @param securityDepositAmt the securityDepositAmt to set
	 */
	public void setSecurityDepositAmt(Double securityDepositAmt) {
		this.securityDepositAmt = securityDepositAmt;
	}

	/**
	 * @return the estdChargeAmt
	 */
	public Double getEstdChargeAmt() {
		return estdChargeAmt;
	}

	/**
	 * @param estdChargeAmt the estdChargeAmt to set
	 */
	public void setEstdChargeAmt(Double estdChargeAmt) {
		this.estdChargeAmt = estdChargeAmt;
	}

	/**
	 * @return the machineryChargeAmt
	 */
	public Double getMachineryChargeAmt() {
		return machineryChargeAmt;
	}

	/**
	 * @param machineryChargeAmt the machineryChargeAmt to set
	 */
	public void setMachineryChargeAmt(Double machineryChargeAmt) {
		this.machineryChargeAmt = machineryChargeAmt;
	}

	/**
	 * @return the locAdviceHrdId
	 */
	public Long getLocAdviceHrdId() {
		return locAdviceHrdId;
	}

	/**
	 * @param locAdviceHrdId the locAdviceHrdId to set
	 */
	public void setLocAdviceHrdId(Long locAdviceHrdId) {
		this.locAdviceHrdId = locAdviceHrdId;
	}

	/**
	 * @return the net total
	 */
	public Double getNetTotal() {
		return netTotal;
	}

	/**
	 * @param netTotal the netTotal to set
	 */

	public void setNetTotal(Double netTotal) {
		this.netTotal = netTotal;
	}

	/**
	 * @return the closing balance
	 */
	public Double getClosingBalance() {
		return closingBalance;
	}

	/**
	 * @param closingBalance the closingBalance to set
	 */
	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	/**
	 * @return the grossAmount
	 */
	public Double getGrossAmount() {
		return grossAmount;
	}

	/**
	 * @param grossAmount the grossAmount to set
	 */
	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

	/**
	 * @return the openingBalance
	 */
	public Double getOpeningBalance() {
		return openingBalance;
	}

	/**
	 * @param openingBalance the openingBalance to set
	 */
	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	/**
	 * @return the newBalance
	 */
	public Double getNewBalance() {
		return newBalance;
	}

	/**
	 * @param newBalance the newBalance to set
	 */
	public void setNewBalance(Double newBalance) {
		this.newBalance = newBalance;
	}

	/**
	 * @return the deductionTotal
	 */
	public Double getDeductionTotal() {
		return deductionTotal;
	}

	/**
	 * @param deductionTotal the deductionTotal to set
	 */
	public void setDeductionTotal(Double deductionTotal) {
		this.deductionTotal = deductionTotal;
	}
}
