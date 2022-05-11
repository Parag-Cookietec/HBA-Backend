package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;



/**
 * The Class LocAdvicedeductionSdEntity.
 * @version v 1.0
 * @created 2021/02/23 16:58:33
 *
 */
@Entity
@Table(name="TLOC_LC_ADVICE_DEDUCTION_SD"  , schema = LocConstant.LOC_SCHEMA )
public class LocAdviceDeductionSdEntity extends BaseEntity  implements Serializable{
	
	
	/** The serialVersionUID*/ 
	private static final long serialVersionUID = 1L;
	
	
	
 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="LC_ADVICE_DEDUCTION_ID")
private  Long id;

 @PositiveOrZero(message = "Professional Tax  should be greater than or equal to 0")
 @Column(name="PT_AMT")
private  Double ptAmt;

 @PositiveOrZero(message = "Laboue Class Amount should be greater than or equal to 0")
 @Column(name="LABOUR_AMT")
private  Double labourAmt;

 @PositiveOrZero(message = "For All M.H Amount should be greater than or equal to 0")
 @Column(name="FOR_ALL_MH_AMT")
private  Double forAllMhAmt;

 @PositiveOrZero(message = "Income Tax amount should be greater than or equal to 0")
 @Column(name="IT_AMT")
private  Double itAmt;

 @PositiveOrZero(message = "Surcharge amount should be greater than or equal to 0")
 @Column(name="SURCHARGE_AMT")
private  Double surchargeAmt;

 @PositiveOrZero(message = "GPF Class4 Amount should be greater than or equal to 0")
 @Column(name="GPF_CLASS4_AMT")
private  Double gpfClass4Amt;

 @PositiveOrZero(message = "CPF amount should be greater than or equal to 0")
 @Column(name="CPF_AMT")
private  Double cpfAmt;

 @PositiveOrZero(message = "Building Rent amount should be greater than or equal to 0")
 @Column(name="BUILDING_RENT_AMT")
private  Double buildingRentAmt;

 @PositiveOrZero(message = "Govt Insurance Fund amount should be greater than or equal to 0")
 @Column(name="GOVT_INSU_FUND_AMT")
private  Double govtInsuFundAmt;

 @PositiveOrZero(message = "Insurance Fund should be greater than or equal to 0")
 @Column(name="INSURANCE_FUND_AMT")
private  Double insuranceFundAmt;

 @PositiveOrZero(message = "security Deposit amount should be greater than or equal to 0")
 @Column(name="SECURITY_DEPOSIT_AMT")
private  Double securityDepositAmt;

 @PositiveOrZero(message = "Establishment Charges should be greater than or equal to 0")
 @Column(name="ESTD_CHARGE_AMT")
private  Double estdChargeAmt;

 @PositiveOrZero(message = "Machinary Charges should be greater than or equal to 0")
 @Column(name="MACHINERY_CHARGE_AMT")
private  Double machineryChargeAmt;

 @OneToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "TLOC_ADVICE_HDR_ID", referencedColumnName = "TLOC_ADVICE_HDR_ID")
private  LocAdvicePrepHdrEntity lcAdvice;

	
	/**
	 * hascode method
	 */
	   @Override
	public int hashCode()
	{
	 return	Objects.hash(id,ptAmt,labourAmt,forAllMhAmt,itAmt,surchargeAmt,gpfClass4Amt,cpfAmt,buildingRentAmt,govtInsuFundAmt,insuranceFundAmt,securityDepositAmt,estdChargeAmt,machineryChargeAmt,lcAdvice);
	} 
	
	/**
	 * equals method
	 */
	   @Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; 
		}
		if (obj == null) {
			return false; 
		}
		if (!(obj instanceof LocAdviceDeductionSdEntity)) {
			return false;
		}
       LocAdviceDeductionSdEntity other = (LocAdviceDeductionSdEntity) obj ;
     return  Objects.equals(id, other.id) 
&& Objects.equals(ptAmt, other.ptAmt) 
&& Objects.equals(labourAmt, other.labourAmt) 
&& Objects.equals(forAllMhAmt, other.forAllMhAmt) 
&& Objects.equals(itAmt, other.itAmt) 
&& Objects.equals(surchargeAmt, other.surchargeAmt) 
&& Objects.equals(gpfClass4Amt, other.gpfClass4Amt) 
&& Objects.equals(cpfAmt, other.cpfAmt) 
&& Objects.equals(buildingRentAmt, other.buildingRentAmt) 
&& Objects.equals(govtInsuFundAmt, other.govtInsuFundAmt) 
&& Objects.equals(insuranceFundAmt, other.insuranceFundAmt) 
&& Objects.equals(securityDepositAmt, other.securityDepositAmt) 
&& Objects.equals(estdChargeAmt, other.estdChargeAmt) 
&& Objects.equals(machineryChargeAmt, other.machineryChargeAmt) 
&& Objects.equals(lcAdvice, other.lcAdvice) 
 ;
   }
	
	/**
	 * toString method
	 */
	 @Override 
public String toString() { 
 return "LocAdvicedeductionSdEntity [id = "+id+",ptAmt = "+ptAmt+",labourAmt = "+labourAmt+",forAllMhAmt = "+forAllMhAmt+",itAmt = "+itAmt+",surchargeAmt = "+surchargeAmt+",gpfClass4Amt = "+gpfClass4Amt+",cpfAmt = "+cpfAmt+",buildingRentAmt = "+buildingRentAmt+",govtInsuFundAmt = "+govtInsuFundAmt+",insuranceFundAmt = "+insuranceFundAmt+",securityDepositAmt = "+securityDepositAmt+",estdChargeAmt = "+estdChargeAmt+",machineryChargeAmt = "+machineryChargeAmt+",lcAdvice = "+lcAdvice+",]";
}
	
	/**
	 * getter setter
	 */
	
/** 
* @return the id 
*/
public Long  getId() { 
 return id;
}

/** 
* @param id the id to set 
*/ 
public void setId(Long id) {
this.id=id;
}
/** 
* @return the ptAmt 
*/
public Double  getPtAmt() { 
 return ptAmt;
}

/** 
* @param ptAmt the ptAmt to set 
*/ 
public void setPtAmt(Double ptAmt) {
this.ptAmt=ptAmt;
}
/** 
* @return the labourAmt 
*/
public Double  getLabourAmt() { 
 return labourAmt;
}

/** 
* @param labourAmt the labourAmt to set 
*/ 
public void setLabourAmt(Double labourAmt) {
this.labourAmt=labourAmt;
}
/** 
* @return the forAllMhAmt 
*/
public Double  getForAllMhAmt() { 
 return forAllMhAmt;
}

/** 
* @param forAllMhAmt the forAllMhAmt to set 
*/ 
public void setForAllMhAmt(Double forAllMhAmt) {
this.forAllMhAmt=forAllMhAmt;
}
/** 
* @return the itAmt 
*/
public Double  getItAmt() { 
 return itAmt;
}

/** 
* @param itAmt the itAmt to set 
*/ 
public void setItAmt(Double itAmt) {
this.itAmt=itAmt;
}
/** 
* @return the surchargeAmt 
*/
public Double  getSurchargeAmt() { 
 return surchargeAmt;
}

/** 
* @param surchargeAmt the surchargeAmt to set 
*/ 
public void setSurchargeAmt(Double surchargeAmt) {
this.surchargeAmt=surchargeAmt;
}
/** 
* @return the gpfClass4Amt 
*/
public Double  getGpfClass4Amt() { 
 return gpfClass4Amt;
}

/** 
* @param gpfClass4Amt the gpfClass4Amt to set 
*/ 
public void setGpfClass4Amt(Double gpfClass4Amt) {
this.gpfClass4Amt=gpfClass4Amt;
}
/** 
* @return the cpfAmt 
*/
public Double  getCpfAmt() { 
 return cpfAmt;
}

/** 
* @param cpfAmt the cpfAmt to set 
*/ 
public void setCpfAmt(Double cpfAmt) {
this.cpfAmt=cpfAmt;
}
/** 
* @return the buildingRentAmt 
*/
public Double  getBuildingRentAmt() { 
 return buildingRentAmt;
}

/** 
* @param buildingRentAmt the buildingRentAmt to set 
*/ 
public void setBuildingRentAmt(Double buildingRentAmt) {
this.buildingRentAmt=buildingRentAmt;
}
/** 
* @return the govtInsuFundAmt 
*/
public Double  getGovtInsuFundAmt() { 
 return govtInsuFundAmt;
}

/** 
* @param govtInsuFundAmt the govtInsuFundAmt to set 
*/ 
public void setGovtInsuFundAmt(Double govtInsuFundAmt) {
this.govtInsuFundAmt=govtInsuFundAmt;
}
/** 
* @return the insuranceFundAmt 
*/
public Double  getInsuranceFundAmt() { 
 return insuranceFundAmt;
}

/** 
* @param insuranceFundAmt the insuranceFundAmt to set 
*/ 
public void setInsuranceFundAmt(Double insuranceFundAmt) {
this.insuranceFundAmt=insuranceFundAmt;
}
/** 
* @return the securityDepositAmt 
*/
public Double  getSecurityDepositAmt() { 
 return securityDepositAmt;
}

/** 
* @param securityDepositAmt the securityDepositAmt to set 
*/ 
public void setSecurityDepositAmt(Double securityDepositAmt) {
this.securityDepositAmt=securityDepositAmt;
}
/** 
* @return the estdChargeAmt 
*/
public Double  getEstdChargeAmt() { 
 return estdChargeAmt;
}

/** 
* @param estdChargeAmt the estdChargeAmt to set 
*/ 
public void setEstdChargeAmt(Double estdChargeAmt) {
this.estdChargeAmt=estdChargeAmt;
}
/** 
* @return the machineryChargeAmt 
*/
public Double  getMachineryChargeAmt() { 
 return machineryChargeAmt;
}

/** 
* @param machineryChargeAmt the machineryChargeAmt to set 
*/ 
public void setMachineryChargeAmt(Double machineryChargeAmt) {
this.machineryChargeAmt=machineryChargeAmt;
}
/** 
* @return the locAdviceHrdId 
*/

/**
 * @return the locAdviceHrdId
 */

public LocAdviceDeductionSdEntity() {
	super();
}

/**
 * @return the lcAdvice
 */
public LocAdvicePrepHdrEntity getLcAdvice() {
	return lcAdvice;
}

/**
 * @param lcAdvice the lcAdvice to set
 */
public void setLcAdvice(LocAdvicePrepHdrEntity lcAdvice) {
	this.lcAdvice = lcAdvice;
}
	
}
