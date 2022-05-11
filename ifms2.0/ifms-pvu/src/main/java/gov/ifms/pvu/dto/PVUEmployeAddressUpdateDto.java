package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeAddressDto.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */
@NativeQueryResultEntity
public class PVUEmployeAddressUpdateDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp address id. */
	@NativeQueryResultColumn(index = 0)
	private String empAddressId;

	/** The cur address 1. */
	@NativeQueryResultColumn(index = 1)
	private String currentAddressOne;

	/** The cur address 2. */
	@NativeQueryResultColumn(index = 2)
	private String currentAddressTwo;

	@NativeQueryResultColumn(index = 3)
	private String currentStateName;

	@NativeQueryResultColumn(index = 4)
	private String currentDistrictName;

	@NativeQueryResultColumn(index = 5)
	private String currentTalukaName;

	/** The cur city. */
	@NativeQueryResultColumn(index = 6)
	private String currentCity;

	/** The current pin code. */
	@NativeQueryResultColumn(index = 7)
	private String currentPinCode;

	@NativeQueryResultColumn(index = 8)
	private String currentOfficeDistName;

	/** The permanent address 1. */
	@NativeQueryResultColumn(index = 9)
	private String permanentAddressOne;

	/** The permanent address 2. */
	@NativeQueryResultColumn(index = 10)
	private String permanentAddressTwo;

	@NativeQueryResultColumn(index = 11)
	private String permanentStateName;

	@NativeQueryResultColumn(index = 12)
	private String permanentDistrictName;

	@NativeQueryResultColumn(index = 13)
	private String permanentTalukaName;

	/** The permanent city. */

	@NativeQueryResultColumn(index = 14)
	private String permanentCity;

	/** The permanent pin code. */
	@NativeQueryResultColumn(index = 15)
	private String permanentPinCode;

	/** The native address 1. */
	@NativeQueryResultColumn(index = 16)
	private String nativeAddressOne;

	/** The native address 2. */
	@NativeQueryResultColumn(index = 17)
	private String nativeAddressTwo;

	@NativeQueryResultColumn(index = 18)
	private String nativeStateName;

	@NativeQueryResultColumn(index = 19)
	private String nativeDistrictName;

	@NativeQueryResultColumn(index = 20)
	private String nativeTalukaName;

	/** The native city. */
	@NativeQueryResultColumn(index = 21)
	private String nativeCity;

	@NativeQueryResultColumn(index = 22)
	private String nativePinCode;

	@NativeQueryResultColumn(index = 23)
	private String updateByUpdateDate;

	@NativeQueryResultColumn(index = 24)
	private String updateByUserCode;

	@NativeQueryResultColumn(index = 25)
	private String updateByUserName;

	@NativeQueryResultColumn(index = 26)
	private String updateByPostName;
	
	@NativeQueryResultColumn(index = 27)
    private String officeName;


	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	@NativeQueryResultColumn(index = 28)
	private String changeType;

	/**
	 * @return the changeType
	 */
	public String getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	
	/**
	 * @return the empAddressId
	 */
	public String getEmpAddressId() {
		return empAddressId;
	}

	/**
	 * @param empAddressId the empAddressId to set
	 */
	public void setEmpAddressId(String empAddressId) {
		this.empAddressId = empAddressId;
	}

	/**
	 * @return the currentAddressOne
	 */
	public String getCurrentAddressOne() {
		return PvuUtils.ternaryOperator(currentAddressOne);
	}

	/**
	 * @param currentAddressOne the currentAddressOne to set
	 */
	public void setCurrentAddressOne(String currentAddressOne) {
		this.currentAddressOne = PvuUtils.ternaryOperator(currentAddressOne);
	}

	/**
	 * @return the currentAddressTwo
	 */
	public String getCurrentAddressTwo() {
		return currentAddressTwo;
	}

	/**
	 * @param currentAddressTwo the currentAddressTwo to set
	 */
	public void setCurrentAddressTwo(String currentAddressTwo) {
		this.currentAddressTwo = PvuUtils.ternaryOperator(currentAddressTwo);
	}

	/**
	 * @return the currentStateName
	 */
	public String getCurrentStateName() {
		return currentStateName;
	}

	/**
	 * @param currentStateName the currentStateName to set
	 */
	public void setCurrentStateName(String currentStateName) {
		this.currentStateName = currentStateName;
	}

	/**
	 * @return the currentDistrictName
	 */
	public String getCurrentDistrictName() {
		return currentDistrictName;
	}

	/**
	 * @param currentDistrictName the currentDistrictName to set
	 */
	public void setCurrentDistrictName(String currentDistrictName) {
		this.currentDistrictName = currentDistrictName;
	}

	/**
	 * @return the currentTalukaName
	 */
	public String getCurrentTalukaName() {
		return currentTalukaName;
	}

	/**
	 * @param currentTalukaName the currentTalukaName to set
	 */
	public void setCurrentTalukaName(String currentTalukaName) {
		this.currentTalukaName = currentTalukaName;
	}

	/**
	 * @return the currentCity
	 */
	public String getCurrentCity() {
		return currentCity;
	}

	/**
	 * @param currentCity the currentCity to set
	 */
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	/**
	 * @return the currentPinCode
	 */
	public String getCurrentPinCode() {
		return currentPinCode;
	}

	/**
	 * @param currentPinCode the currentPinCode to set
	 */
	public void setCurrentPinCode(String currentPinCode) {
		this.currentPinCode = currentPinCode;
	}

	/**
	 * @return the currentOfficeDistName
	 */
	public String getCurrentOfficeDistName() {
		return currentOfficeDistName;
	}

	/**
	 * @param currentOfficeDistName the currentOfficeDistName to set
	 */
	public void setCurrentOfficeDistName(String currentOfficeDistName) {
		this.currentOfficeDistName = currentOfficeDistName;
	}

	/**
	 * @return the permanentAddressOne
	 */
	public String getPermanentAddressOne() {
		return permanentAddressOne;
	}

	/**
	 * @param permanentAddressOne the permanentAddressOne to set
	 */
	public void setPermanentAddressOne(String permanentAddressOne) {
		this.permanentAddressOne = permanentAddressOne;
	}

	/**
	 * @return the permanentAddressTwo
	 */
	public String getPermanentAddressTwo() {
		return PvuUtils.ternaryOperator(permanentAddressTwo);
	}

	/**
	 * @param permanentAddressTwo the permanentAddressTwo to set
	 */
	public void setPermanentAddressTwo(String permanentAddressTwo) {
		this.permanentAddressTwo = permanentAddressTwo;
	}

	/**
	 * @return the permanentStateName
	 */
	public String getPermanentStateName() {
		return permanentStateName;
	}

	/**
	 * @param permanentStateName the permanentStateName to set
	 */
	public void setPermanentStateName(String permanentStateName) {
		this.permanentStateName = permanentStateName;
	}

	/**
	 * @return the permanentDistrictName
	 */
	public String getPermanentDistrictName() {
		return permanentDistrictName;
	}

	/**
	 * @param permanentDistrictName the permanentDistrictName to set
	 */
	public void setPermanentDistrictName(String permanentDistrictName) {
		this.permanentDistrictName = permanentDistrictName;
	}

	/**
	 * @return the permanentTalukaName
	 */
	public String getPermanentTalukaName() {
		return permanentTalukaName;
	}

	/**
	 * @param permanentTalukaName the permanentTalukaName to set
	 */
	public void setPermanentTalukaName(String permanentTalukaName) {
		this.permanentTalukaName = permanentTalukaName;
	}

	/**
	 * @return the permanentCity
	 */
	public String getPermanentCity() {
		return permanentCity;
	}

	/**
	 * @param permanentCity the permanentCity to set
	 */
	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	/**
	 * @return the permanentPinCode
	 */
	public String getPermanentPinCode() {
		return permanentPinCode;
	}

	/**
	 * @param permanentPinCode the permanentPinCode to set
	 */
	public void setPermanentPinCode(String permanentPinCode) {
		this.permanentPinCode = permanentPinCode;
	}

	/**
	 * @return the nativeAddressOne
	 */
	public String getNativeAddressOne() {
		return nativeAddressOne;
	}

	/**
	 * @param nativeAddressOne the nativeAddressOne to set
	 */
	public void setNativeAddressOne(String nativeAddressOne) {
		this.nativeAddressOne = nativeAddressOne;
	}

	/**
	 * @return the nativeAddressTwo
	 */
	public String getNativeAddressTwo() {
		return PvuUtils.ternaryOperator(nativeAddressTwo);
	}

	/**
	 * @param nativeAddressTwo the nativeAddressTwo to set
	 */
	public void setNativeAddressTwo(String nativeAddressTwo) {
		this.nativeAddressTwo = nativeAddressTwo;
	}

	/**
	 * @return the nativeStateName
	 */
	public String getNativeStateName() {
		return nativeStateName;
	}

	/**
	 * @param nativeStateName the nativeStateName to set
	 */
	public void setNativeStateName(String nativeStateName) {
		this.nativeStateName = nativeStateName;
	}

	/**
	 * @return the nativeDistrictName
	 */
	public String getNativeDistrictName() {
		return nativeDistrictName;
	}

	/**
	 * @param nativeDistrictName the nativeDistrictName to set
	 */
	public void setNativeDistrictName(String nativeDistrictName) {
		this.nativeDistrictName = nativeDistrictName;
	}

	/**
	 * @return the nativeTalukaName
	 */
	public String getNativeTalukaName() {
		return nativeTalukaName;
	}

	/**
	 * @param nativeTalukaName the nativeTalukaName to set
	 */
	public void setNativeTalukaName(String nativeTalukaName) {
		this.nativeTalukaName = nativeTalukaName;
	}

	/**
	 * @return the nativeCity
	 */
	public String getNativeCity() {
		return nativeCity;
	}

	/**
	 * @param nativeCity the nativeCity to set
	 */
	public void setNativeCity(String nativeCity) {
		this.nativeCity = nativeCity;
	}

	/**
	 * @return the nativePinCode
	 */
	public String getNativePinCode() {
		return nativePinCode;
	}

	/**
	 * @param nativePinCode the nativePinCode to set
	 */
	public void setNativePinCode(String nativePinCode) {
		this.nativePinCode = nativePinCode;
	}

	/**
	 * @return the updateByUpdateDate
	 */
	public String getUpdateByUpdateDate() {
		return updateByUpdateDate;
	}

	/**
	 * @param updateByUpdateDate the updateByUpdateDate to set
	 */
	public void setUpdateByUpdateDate(String updateByUpdateDate) {
		this.updateByUpdateDate = updateByUpdateDate;
	}

	/**
	 * @return the updateByUserCode
	 */
	public String getUpdateByUserCode() {
		return updateByUserCode;
	}

	/**
	 * @param updateByUserCode the updateByUserCode to set
	 */
	public void setUpdateByUserCode(String updateByUserCode) {
		this.updateByUserCode = updateByUserCode;
	}

	/**
	 * @return the updateByUserName
	 */
	public String getUpdateByUserName() {
		return updateByUserName;
	}

	/**
	 * @param updateByUserName the updateByUserName to set
	 */
	public void setUpdateByUserName(String updateByUserName) {
		this.updateByUserName = updateByUserName;
	}

	/**
	 * @return the updateByPostName
	 */
	public String getUpdateByPostName() {
		return updateByPostName;
	}

	/**
	 * @param updateByPostName the updateByPostName to set
	 */
	public void setUpdateByPostName(String updateByPostName) {
		this.updateByPostName = updateByPostName;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	
}
