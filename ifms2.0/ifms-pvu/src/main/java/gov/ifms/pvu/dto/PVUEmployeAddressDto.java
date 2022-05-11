package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeAddressDto.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */
public class PVUEmployeAddressDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp address id. */
	private long empAddressId;

	/** The cur address 1. */
	@NotBlank
	private String curAddress1;

	/** The cur address 2. */
	private String curAddress2;

	/** The cur state. */
	@NotNull
	private long curState;

	private String curStateName;

	/** The cur district. */
	@NotNull
	private long curDistrict;

	private String curDistrictName;

	/** The cur taluka. */
	private long curTaluka;

	private String curTalukaName;

	/** The cur other taluka. */
	private String curOtherTaluka;

	/** The cur city. */
	@NotNull
	private String curCity;

	/** The cur pin code. */
	@NotNull
	private Integer curPinCode;

	/** The cur office dist. */
	@NotNull
	private long curOfficeDist;

	private String curOfficeDistName;

	/** The per address 1. */
	@NotNull
	private String perAddress1;

	/** The per address 2. */
	private String perAddress2;

	/** The per state. */
	@NotNull
	private long perState;

	private String perStateName;

	/** The per district. */
	@NotNull
	private long perDistrict;

	private String perDistrictName;

	/** The per taluka. */
	private long perTaluka;

	private String perTalukaName;

	/** The per other taluka. */
	private String perOtherTaluka;

	/** The per city. */
	@NotNull
	private String perCity;

	/** The per pin code. */
	@NotNull
	private Integer perPinCode;

	/** The nat address 1. */
	@NotNull
	private String natAddress1;

	/** The nat address 2. */
	private String natAddress2;

	/** The nat state. */
	@NotNull
	private long natState;

	private String natStateName;

	/** The nat district. */
	@NotNull
	private long natDistrict;

	private String natDistrictName;

	/** The nat taluka. */
	private long natTaluka;

	private String natTalukaName;

	/** The nat other taluka. */
	private String natOtherTaluka;

	/** The nat city. */
	@NotNull
	private String natCity;

	/** The nat pin code. */
	@NotNull
	private Integer natPinCode;

	/** The emp id. */
	@NotNull
	private long empId;

	/** The status id. */
	private long statusId;

	/**
	 * The is per add cur add. 0 for not set 1 for same as current address
	 */
	private int isPerAddCurAdd;

	/**
	 * The is nat add cur add per add. 0 not set and 1 for same as current address 2
	 * for permanent address
	 */
	private int isNatAddCurAddPerAdd;
	
	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	private long changeType;

	/**
	 * @return the changeType
	 */
	public long getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(long changeType) {
		this.changeType = changeType;
	}

	/**
	 * Gets the emp address id.
	 *
	 * @return the empAddressId
	 */
	public long getEmpAddressId() {
		return empAddressId;
	}

	/**
	 * Sets the emp address id.
	 *
	 * @param empAddressId the empAddressId to set
	 */
	public void setEmpAddressId(long empAddressId) {
		this.empAddressId = empAddressId;
	}

	/**
	 * Gets the cur address 1.
	 *
	 * @return the curAddress1
	 */
	public String getCurAddress1() {
		return curAddress1;
	}

	/**
	 * Sets the cur address 1.
	 *
	 * @param curAddress1 the curAddress1 to set
	 */
	public void setCurAddress1(String curAddress1) {
		this.curAddress1 = curAddress1;
	}

	/**
	 * Gets the cur address 2.
	 *
	 * @return the curAddress2
	 */
	public String getCurAddress2() {
		return curAddress2;
	}

	/**
	 * Sets the cur address 2.
	 *
	 * @param curAddress2 the curAddress2 to set
	 */
	public void setCurAddress2(String curAddress2) {
		this.curAddress2 = curAddress2;
	}

	/**
	 * Gets the cur state.
	 *
	 * @return the curState
	 */
	public long getCurState() {
		return curState;
	}

	/**
	 * Sets the cur state.
	 *
	 * @param curState the curState to set
	 */
	public void setCurState(long curState) {
		this.curState = curState;
	}

	/**
	 * Gets the cur district.
	 *
	 * @return the curDistrict
	 */
	public long getCurDistrict() {
		return curDistrict;
	}

	/**
	 * Sets the cur district.
	 *
	 * @param curDistrict the curDistrict to set
	 */
	public void setCurDistrict(long curDistrict) {
		this.curDistrict = curDistrict;
	}

	/**
	 * Gets the cur taluka.
	 *
	 * @return the curTaluka
	 */
	public long getCurTaluka() {
		return curTaluka;
	}

	/**
	 * Sets the cur taluka.
	 *
	 * @param curTaluka the curTaluka to set
	 */
	public void setCurTaluka(long curTaluka) {
		this.curTaluka = curTaluka;
	}

	/**
	 * Gets the cur city.
	 *
	 * @return the curCity
	 */
	public String getCurCity() {
		return curCity;
	}

	/**
	 * Sets the cur city.
	 *
	 * @param curCity the curCity to set
	 */
	public void setCurCity(String curCity) {
		this.curCity = curCity;
	}

	/**
	 * Gets the cur pincode.
	 *
	 * @return the curPincode
	 */
	public Integer getCurPinCode() {
		return curPinCode;
	}

	/**
	 * Sets the cur pincode.
	 *
	 * @param curPinCode the curPincode to set
	 */
	public void setCurPinCode(Integer curPinCode) {
		this.curPinCode = curPinCode;
	}

	/**
	 * Gets the cur office dist.
	 *
	 * @return the curOfficeDist
	 */
	public long getCurOfficeDist() {
		return curOfficeDist;
	}

	/**
	 * Sets the cur office dist.
	 *
	 * @param curOfficeDist the curOfficeDist to set
	 */
	public void setCurOfficeDist(long curOfficeDist) {
		this.curOfficeDist = curOfficeDist;
	}

	/**
	 * Gets the per address 1.
	 *
	 * @return the perAddress1
	 */
	public String getPerAddress1() {
		return perAddress1;
	}

	/**
	 * Sets the per address 1.
	 *
	 * @param perAddress1 the perAddress1 to set
	 */
	public void setPerAddress1(String perAddress1) {
		this.perAddress1 = perAddress1;
	}

	/**
	 * Gets the per address 2.
	 *
	 * @return the perAddress2
	 */
	public String getPerAddress2() {
		return perAddress2;
	}

	/**
	 * Sets the per address 2.
	 *
	 * @param perAddress2 the perAddress2 to set
	 */
	public void setPerAddress2(String perAddress2) {
		this.perAddress2 = perAddress2;
	}

	/**
	 * Gets the per state.
	 *
	 * @return the perState
	 */
	public long getPerState() {
		return perState;
	}

	/**
	 * Sets the per state.
	 *
	 * @param perState the perState to set
	 */
	public void setPerState(long perState) {
		this.perState = perState;
	}

	/**
	 * Gets the per district.
	 *
	 * @return the perDistrict
	 */
	public long getPerDistrict() {
		return perDistrict;
	}

	/**
	 * Sets the per district.
	 *
	 * @param perDistrict the perDistrict to set
	 */
	public void setPerDistrict(long perDistrict) {
		this.perDistrict = perDistrict;
	}

	/**
	 * Gets the per taluka.
	 *
	 * @return the perTaluka
	 */
	public long getPerTaluka() {
		return perTaluka;
	}

	/**
	 * Sets the per taluka.
	 *
	 * @param perTaluka the perTaluka to set
	 */
	public void setPerTaluka(long perTaluka) {
		this.perTaluka = perTaluka;
	}

	/**
	 * Gets the per city.
	 *
	 * @return the perCity
	 */
	public String getPerCity() {
		return perCity;
	}

	/**
	 * Sets the per city.
	 *
	 * @param perCity the perCity to set
	 */
	public void setPerCity(String perCity) {
		this.perCity = perCity;
	}

	/**
	 * Gets the per pin code.
	 *
	 * @return the perPinCode
	 */
	public Integer getPerPinCode() {
		return perPinCode;
	}

	/**
	 * Sets the per pin code.
	 *
	 * @param perPinCode the perPinCode to set
	 */
	public void setPerPinCode(Integer perPinCode) {
		this.perPinCode = perPinCode;
	}

	/**
	 * Gets the nat address 1.
	 *
	 * @return the natAddress1
	 */
	public String getNatAddress1() {
		return natAddress1;
	}

	/**
	 * Sets the nat address 1.
	 *
	 * @param natAddress1 the natAddress1 to set
	 */
	public void setNatAddress1(String natAddress1) {
		this.natAddress1 = natAddress1;
	}

	/**
	 * Gets the nat address 2.
	 *
	 * @return the natAddress2
	 */
	public String getNatAddress2() {
		return natAddress2;
	}

	/**
	 * Sets the nat address 2.
	 *
	 * @param natAddress2 the natAddress2 to set
	 */
	public void setNatAddress2(String natAddress2) {
		this.natAddress2 = natAddress2;
	}

	/**
	 * Gets the nat state.
	 *
	 * @return the natState
	 */
	public long getNatState() {
		return natState;
	}

	/**
	 * Sets the nat state.
	 *
	 * @param natState the natState to set
	 */
	public void setNatState(long natState) {
		this.natState = natState;
	}

	/**
	 * Gets the nat district.
	 *
	 * @return the natDistrict
	 */
	public long getNatDistrict() {
		return natDistrict;
	}

	/**
	 * Sets the nat district.
	 *
	 * @param natDistrict the natDistrict to set
	 */
	public void setNatDistrict(long natDistrict) {
		this.natDistrict = natDistrict;
	}

	/**
	 * Gets the nat taluka.
	 *
	 * @return the natTaluka
	 */
	public long getNatTaluka() {
		return natTaluka;
	}

	/**
	 * Sets the nat taluka.
	 *
	 * @param natTaluka the natTaluka to set
	 */
	public void setNatTaluka(long natTaluka) {
		this.natTaluka = natTaluka;
	}

	/**
	 * Gets the nat city.
	 *
	 * @return the natCity
	 */
	public String getNatCity() {
		return natCity;
	}

	/**
	 * Sets the nat city.
	 *
	 * @param natCity the natCity to set
	 */
	public void setNatCity(String natCity) {
		this.natCity = natCity;
	}

	/**
	 * Gets the nat pin code.
	 *
	 * @return the natPinCode
	 */
	public Integer getNatPinCode() {
		return natPinCode;
	}

	/**
	 * Sets the nat pin code.
	 *
	 * @param natPinCode the natPinCode to set
	 */
	public void setNatPinCode(Integer natPinCode) {
		this.natPinCode = natPinCode;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the checks if is per add cur add.
	 *
	 * @return the checks if is per add cur add
	 */
	public int getIsPerAddCurAdd() {
		return isPerAddCurAdd;
	}

	/**
	 * Sets the checks if is per add cur add.
	 *
	 * @param isPerAddCurAdd the new checks if is per add cur add
	 */
	public void setIsPerAddCurAdd(int isPerAddCurAdd) {
		this.isPerAddCurAdd = isPerAddCurAdd;
	}

	/**
	 * Gets the checks if is nat add cur add per add.
	 *
	 * @return the checks if is nat add cur add per add
	 */
	public int getIsNatAddCurAddPerAdd() {
		return isNatAddCurAddPerAdd;
	}

	/**
	 * Sets the checks if is nat add cur add per add.
	 *
	 * @param isNatAddCurAddPerAdd the new checks if is nat add cur add per add
	 */
	public void setIsNatAddCurAddPerAdd(int isNatAddCurAddPerAdd) {
		this.isNatAddCurAddPerAdd = isNatAddCurAddPerAdd;
	}

	/**
	 * @return the curStateName
	 */
	public String getCurStateName() {
		return curStateName;
	}

	/**
	 * @param curStateName the curStateName to set
	 */
	public void setCurStateName(String curStateName) {
		this.curStateName = curStateName;
	}

	/**
	 * @return the curDistrictName
	 */
	public String getCurDistrictName() {
		return curDistrictName;
	}

	/**
	 * @param curDistrictName the curDistrictName to set
	 */
	public void setCurDistrictName(String curDistrictName) {
		this.curDistrictName = curDistrictName;
	}

	/**
	 * @return the curTalukaName
	 */
	public String getCurTalukaName() {
		return curTalukaName;
	}

	/**
	 * @param curTalukaName the curTalukaName to set
	 */
	public void setCurTalukaName(String curTalukaName) {
		this.curTalukaName = curTalukaName;
	}

	/**
	 * @return the curOfficeDistName
	 */
	public String getCurOfficeDistName() {
		return curOfficeDistName;
	}

	/**
	 * @param curOfficeDistName the curOfficeDistName to set
	 */
	public void setCurOfficeDistName(String curOfficeDistName) {
		this.curOfficeDistName = curOfficeDistName;
	}

	/**
	 * @return the perStateName
	 */
	public String getPerStateName() {
		return perStateName;
	}

	/**
	 * @param perStateName the perStateName to set
	 */
	public void setPerStateName(String perStateName) {
		this.perStateName = perStateName;
	}

	/**
	 * @return the perDistrictName
	 */
	public String getPerDistrictName() {
		return perDistrictName;
	}

	/**
	 * @param perDistrictName the perDistrictName to set
	 */
	public void setPerDistrictName(String perDistrictName) {
		this.perDistrictName = perDistrictName;
	}

	/**
	 * @return the perTalukaName
	 */
	public String getPerTalukaName() {
		return perTalukaName;
	}

	/**
	 * @param perTalukaName the perTalukaName to set
	 */
	public void setPerTalukaName(String perTalukaName) {
		this.perTalukaName = perTalukaName;
	}

	/**
	 * @return the natStateName
	 */
	public String getNatStateName() {
		return natStateName;
	}

	/**
	 * @param natStateName the natStateName to set
	 */
	public void setNatStateName(String natStateName) {
		this.natStateName = natStateName;
	}

	/**
	 * @return the natDistrictName
	 */
	public String getNatDistrictName() {
		return natDistrictName;
	}

	/**
	 * @param natDistrictName the natDistrictName to set
	 */
	public void setNatDistrictName(String natDistrictName) {
		this.natDistrictName = natDistrictName;
	}

	/**
	 * @return the natTalukaName
	 */
	public String getNatTalukaName() {
		return natTalukaName;
	}

	/**
	 * @param natTalukaName the natTalukaName to set
	 */
	public void setNatTalukaName(String natTalukaName) {
		this.natTalukaName = natTalukaName;
	}

	/**
	 * @return the curOtherTaluka
	 */
	public String getCurOtherTaluka() {
		return curOtherTaluka;
	}

	/**
	 * @param curOtherTaluka the curOtherTaluka to set
	 */
	public void setCurOtherTaluka(String curOtherTaluka) {
		this.curOtherTaluka = curOtherTaluka;
	}

	/**
	 * @return the perOtherTaluka
	 */
	public String getPerOtherTaluka() {
		return perOtherTaluka;
	}

	/**
	 * @param perOtherTaluka the perOtherTaluka to set
	 */
	public void setPerOtherTaluka(String perOtherTaluka) {
		this.perOtherTaluka = perOtherTaluka;
	}

	/**
	 * @return the natOtherTaluka
	 */
	public String getNatOtherTaluka() {
		return natOtherTaluka;
	}

	/**
	 * @param natOtherTaluka the natOtherTaluka to set
	 */
	public void setNatOtherTaluka(String natOtherTaluka) {
		this.natOtherTaluka = natOtherTaluka;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(curAddress1, curAddress2, curCity, curDistrict, curOfficeDist, curPinCode, curState,
				curTaluka, empAddressId, empId, isNatAddCurAddPerAdd, isPerAddCurAdd, natAddress1, natAddress2, natCity,
				natDistrict, natPinCode, natState, natTaluka, perAddress1, perAddress2, perCity, perDistrict,
				perPinCode, perState, perTaluka, statusId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeAddressDto other = (PVUEmployeAddressDto) obj;
		return Objects.equals(curAddress1, other.curAddress1) && Objects.equals(curAddress2, other.curAddress2)
				&& Objects.equals(curCity, other.curCity) && curDistrict == other.curDistrict
				&& curOfficeDist == other.curOfficeDist && Objects.equals(curPinCode, other.curPinCode)
				&& curState == other.curState && curTaluka == other.curTaluka && empAddressId == other.empAddressId
				&& empId == other.empId && isNatAddCurAddPerAdd == other.isNatAddCurAddPerAdd
				&& isPerAddCurAdd == other.isPerAddCurAdd && Objects.equals(natAddress1, other.natAddress1)
				&& Objects.equals(natAddress2, other.natAddress2) && Objects.equals(natCity, other.natCity)
				&& natDistrict == other.natDistrict && Objects.equals(natPinCode, other.natPinCode)
				&& natState == other.natState && natTaluka == other.natTaluka
				&& Objects.equals(perAddress1, other.perAddress1) && Objects.equals(perAddress2, other.perAddress2)
				&& Objects.equals(perCity, other.perCity) && perDistrict == other.perDistrict
				&& Objects.equals(perPinCode, other.perPinCode) && perState == other.perState
				&& perTaluka == other.perTaluka && statusId == other.statusId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeAddressDto [empAddressId=" + empAddressId + ", curAddress1=" + curAddress1 + ", curAddress2="
				+ curAddress2 + ", curState=" + curState + ", curDistrict=" + curDistrict + ", curTaluka=" + curTaluka
				+ ", curCity=" + curCity + ", curPinCode=" + curPinCode + ", curOfficeDist=" + curOfficeDist
				+ ", perAddress1=" + perAddress1 + ", perAddress2=" + perAddress2 + ", perState=" + perState
				+ ", perDistrict=" + perDistrict + ", perTaluka=" + perTaluka + ", perCity=" + perCity + ", perPinCode="
				+ perPinCode + ", natAddress1=" + natAddress1 + ", natAddress2=" + natAddress2 + ", natState="
				+ natState + ", natDistrict=" + natDistrict + ", natTaluka=" + natTaluka + ", natCity=" + natCity
				+ ", natPinCode=" + natPinCode + ", empId=" + empId + ", statusId=" + statusId + ", isPerAddCurAdd="
				+ isPerAddCurAdd + ", isNatAddCurAddPerAdd=" + isNatAddCurAddPerAdd + "]";
	}

}
