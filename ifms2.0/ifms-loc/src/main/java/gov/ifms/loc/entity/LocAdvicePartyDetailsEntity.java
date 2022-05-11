package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;



/**
 * The Class LocAdvicePartyDetaisEntity.
 * @version v 1.0
 * @created 2021/02/23 14:53:51
 *
 */
@Entity
@Table(name="TLOC_LC_ADVICE_PARTY_D"  , schema = LocConstant.LOC_SCHEMA )
public class LocAdvicePartyDetailsEntity extends BaseEntity  implements Serializable{
	
	
	/** The serialVersionUID*/ 
	private static final long serialVersionUID = 1L;
	
	
	
 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="LC_ADVICE_PARTY_ID")
private  Long id;

 @Column(name="PARTY_TYPE")
private  String partyType;

 @Column(name="PARTY_NAME")
private  String partyName;

 @Column(name="BANK_ACCOUNT_NO")
private  String bankAccountNo;

 @Column(name="IFSC")
private  String ifsc;

 @Column(name="PARTY_AMT")
private  Double partyAmt;

 @Column(name="LC_ADVICE_ID")
private  Long lcAdviceId;

	
	/**
	* LocAdvicePartyDetaisEntity Constructor
	*/
	public LocAdvicePartyDetailsEntity() {
		super();
	}
	
	/**
	 * hascode method
	 */
	   @Override
	public int hashCode()
	{
	 return	Objects.hash(id,partyType,partyName,bankAccountNo,ifsc,partyAmt,lcAdviceId);
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
		if (!(obj instanceof LocAdvicePartyDetailsEntity)) {
			return false;
		}
       LocAdvicePartyDetailsEntity other = (LocAdvicePartyDetailsEntity) obj ;
     return  Objects.equals(id, other.id) 
&& Objects.equals(partyType, other.partyType) 
&& Objects.equals(partyName, other.partyName) 
&& Objects.equals(bankAccountNo, other.bankAccountNo) 
&& Objects.equals(ifsc, other.ifsc) 
&& Objects.equals(partyAmt, other.partyAmt) 
&& Objects.equals(lcAdviceId, other.lcAdviceId) 
 ;
   }
	
	/**
	 * toString method
	 */
	 @Override 
public String toString() { 
 return "LocAdvicePartyDetaisEntity [id = "+id+",partyType = "+partyType+",partyName = "+partyName+",bankAccountNo = "+bankAccountNo+",ifsc = "+ifsc+",partyAmt = "+partyAmt+",lcAdviceId = "+lcAdviceId+",]";
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
* @return the partyType 
*/
public String  getPartyType() { 
 return partyType;
}

/** 
* @param partyType the partyType to set 
*/ 
public void setPartyType(String partyType) {
this.partyType=partyType;
}
/** 
* @return the partyName 
*/
public String  getPartyName() { 
 return partyName;
}

/** 
* @param partyName the partyName to set 
*/ 
public void setPartyName(String partyName) {
this.partyName=partyName;
}
/** 
* @return the bankAccountNo 
*/
public String  getBankAccountNo() { 
 return bankAccountNo;
}

/** 
* @param bankAccountNo the bankAccountNo to set 
*/ 
public void setBankAccountNo(String bankAccountNo) {
this.bankAccountNo=bankAccountNo;
}
/** 
* @return the ifsc 
*/
public String  getIfsc() { 
 return ifsc;
}

/** 
* @param ifsc the ifsc to set 
*/ 
public void setIfsc(String ifsc) {
this.ifsc=ifsc;
}
/** 
* @return the partyAmt 
*/
public Double  getPartyAmt() { 
 return partyAmt;
}

/** 
* @param partyAmt the partyAmt to set 
*/ 
public void setPartyAmt(Double partyAmt) {
this.partyAmt=partyAmt;
}
/** 
* @return the lcAdviceId 
*/
public Long  getLcAdviceId() { 
 return lcAdviceId;
}

/** 
* @param lcAdviceId the lcAdviceId to set 
*/ 
public void setLcAdviceId(Long lcAdviceId) {
this.lcAdviceId=lcAdviceId;
}
		
}
