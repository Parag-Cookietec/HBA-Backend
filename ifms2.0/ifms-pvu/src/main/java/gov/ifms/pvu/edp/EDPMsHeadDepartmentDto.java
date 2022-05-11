package gov.ifms.pvu.edp;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;




/**
 * The Class EDPMsHeadDepartmentDto.
 * @version v 1.0
 * @created 2020/01/15 15:35:39
 *
 */
public class EDPMsHeadDepartmentDto extends BaseDto implements Serializable  {
	
    /** The serialVersionUID*/ 
	private static final long serialVersionUID = 1L;
	
	
 private  Long hodId;

 private  String hodName;

 private  String hodnameGuj;

 private  String hodDesc;

 private  String hodDescGuj;

 private  String hodCode;

 private  String hodCodeGuj;

 private  String hodShortName;

 private  String hodShortNameGuj;

 private  Long departmentId;

	
	/**
	* EDPMsHeadDepartmentDto Constructor
	*/
	public EDPMsHeadDepartmentDto() {
		super();
	}
	
	/**
	 * hascode method
	 */
	   @Override
	public int hashCode()
	{
	 return	Objects.hash(hodId,hodName,hodnameGuj,hodDesc,hodDescGuj,hodCode,hodCodeGuj,hodShortName,hodShortNameGuj,departmentId);
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
		if (!(obj instanceof EDPMsHeadDepartmentDto)) {
			return false;
		}
       
EDPMsHeadDepartmentDto other = (EDPMsHeadDepartmentDto) obj ;
    
 return  Objects.equals(hodId, other.hodId) 
&& Objects.equals(hodName, other.hodName) 
&& Objects.equals(hodnameGuj, other.hodnameGuj) 
&& Objects.equals(hodDesc, other.hodDesc) 
&& Objects.equals(hodDescGuj, other.hodDescGuj) 
&& Objects.equals(hodCode, other.hodCode) 
&& Objects.equals(hodCodeGuj, other.hodCodeGuj) 
&& Objects.equals(hodShortName, other.hodShortName) 
&& Objects.equals(hodShortNameGuj, other.hodShortNameGuj) 
&& Objects.equals(departmentId, other.departmentId) 
 ;
   }
	
	/**
	 * toString method
	 */
	 @Override 
public String toString() { 
 return "EDPMsHeadDepartmentDto [hodId = "+hodId+",hodName = "+hodName+",hodnameGuj = "+hodnameGuj+",hodDesc = "+hodDesc+",hodDescGuj = "+hodDescGuj+",hodCode = "+hodCode+",hodCodeGuj = "+hodCodeGuj+",hodShortName = "+hodShortName+",hodShortNameGuj = "+hodShortNameGuj+",departmentId = "+departmentId+",]";
}
	
	/**
	 * getter setter
	 */
	
/** 
* @return the hodId 
*/
public Long  getHodId() { 
 return hodId;
}

/** 
* @param hodId the hodId to set 
*/ 
public void setHodId(Long hodId) {
this.hodId=hodId;
}
/** 
* @return the hodName 
*/
public String  getHodName() { 
 return hodName;
}

/** 
* @param hodName the hodName to set 
*/ 
public void setHodName(String hodName) {
this.hodName=hodName;
}
/** 
* @return the hodnameGuj 
*/
public String  getHodnameGuj() { 
 return hodnameGuj;
}

/** 
* @param hodnameGuj the hodnameGuj to set 
*/ 
public void setHodnameGuj(String hodnameGuj) {
this.hodnameGuj=hodnameGuj;
}
/** 
* @return the hodDesc 
*/
public String  getHodDesc() { 
 return hodDesc;
}

/** 
* @param hodDesc the hodDesc to set 
*/ 
public void setHodDesc(String hodDesc) {
this.hodDesc=hodDesc;
}
/** 
* @return the hodDescGuj 
*/
public String  getHodDescGuj() { 
 return hodDescGuj;
}

/** 
* @param hodDescGuj the hodDescGuj to set 
*/ 
public void setHodDescGuj(String hodDescGuj) {
this.hodDescGuj=hodDescGuj;
}
/** 
* @return the hodCode 
*/
public String  getHodCode() { 
 return hodCode;
}

/** 
* @param hodCode the hodCode to set 
*/ 
public void setHodCode(String hodCode) {
this.hodCode=hodCode;
}
/** 
* @return the hodCodeGuj 
*/
public String  getHodCodeGuj() { 
 return hodCodeGuj;
}

/** 
* @param hodCodeGuj the hodCodeGuj to set 
*/ 
public void setHodCodeGuj(String hodCodeGuj) {
this.hodCodeGuj=hodCodeGuj;
}
/** 
* @return the hodShortName 
*/
public String  getHodShortName() { 
 return hodShortName;
}

/** 
* @param hodShortName the hodShortName to set 
*/ 
public void setHodShortName(String hodShortName) {
this.hodShortName=hodShortName;
}
/** 
* @return the hodShortNameGuj 
*/
public String  getHodShortNameGuj() { 
 return hodShortNameGuj;
}

/** 
* @param hodShortNameGuj the hodShortNameGuj to set 
*/ 
public void setHodShortNameGuj(String hodShortNameGuj) {
this.hodShortNameGuj=hodShortNameGuj;
}
/** 
* @return the departmentId 
*/
public Long  getDepartmentId() { 
 return departmentId;
}

/** 
* @param departmentId the departmentId to set 
*/ 
public void setDepartmentId(Long departmentId) {
this.departmentId=departmentId;
}

	
}
