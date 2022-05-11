package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsStateEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;

/**
 * The Class PVUEmployeAddressEntity.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */
@Entity
@Table(name = "T_EMP_ADDR", schema = Constant.PVU_SCHEMA)
public class PVUEmployeAddressEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp address id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_ADDR_ID")
	private long empAddressId;

	/** The cur address 1. */
	@Column(name = "C_ADDR_LINE1")
	private String curAddress1;

	/** The cur address 2. */
	@Column(name = "C_ADDR_LINE2")
	private String curAddress2;

	/** The cur state. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_STATE_ID", referencedColumnName = "STATE_ID")
	private EDPMsStateEntity curState;

	/** The cur district. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity curDistrict;

	/** The cur taluka. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_TALUKA_ID", referencedColumnName = "TALUKA_ID")
	private EDPMsTalukaEntity curTaluka;

	/** The cur other taluka. */
	@Column(name = "C_TALUKA_NAME")
	private String curOtherTaluka;

	/** The cur city. */
	@Column(name = "C_CITY")
	private String curCity;

	/** The cur pin code. */
	@Column(name = "C_PIN_CODE")
	private Integer curPinCode;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_DIST_FROM_OFFICE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity curOfficeDist;

	/** The per address 1. */
	@Column(name = "P_ADDR_LINE1")
	private String perAddress1;

	/** The per address 2. */
	@Column(name = "P_ADDR_LINE2")
	private String perAddress2;

	/** The per state. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "P_STATE_ID", referencedColumnName = "STATE_ID")
	private EDPMsStateEntity perState;

	/** The per district. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "P_DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity perDistrict;

	/** The per taluka. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "P_TALUKA_ID", referencedColumnName = "TALUKA_ID")
	private EDPMsTalukaEntity perTaluka;

	/** The per other taluka. */
	@Column(name = "P_TALUKA_NAME")
	private String perOtherTaluka;

	/** The per city. */
	@Column(name = "P_CITY")
	private String perCity;

	/** The per pincode. */
	@Column(name = "P_PIN_CODE")
	private Integer perPinCode;

	/** The nat address 1. */
	@Column(name = "N_ADDR_LINE1")
	private String natAddress1;

	/** The nat address 2. */
	@Column(name = "N_ADDR_LINE2")
	private String natAddress2;

	/** The nat state. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_STATE_ID", referencedColumnName = "STATE_ID")
	private EDPMsStateEntity natState;

	/** The nat district. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity natDistrict;

	/** The nat taluka. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_TALUKA_ID", referencedColumnName = "TALUKA_ID")
	private EDPMsTalukaEntity natTaluka;

	/** The nat other taluka. */
	@Column(name = "N_TALUKA_NAME")
	private String natOtherTaluka;

	/** The nat city. */
	@Column(name = "N_CITY")
	private String natCity;

	/** The nat pincode. */
	@Column(name = "N_PIN_CODE")
	private Integer natPinCode;

	/** The pvu employe entity. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/**
	 * The is per add cur add. 0 for not set 1 for same as current address
	 */
	@Column(name = "IS_PERMADD_CA")
	private int isPerAddCurAdd;

	/**
	 * The is nat add cur add per add. 0 not set and 1 for same as current address 2
	 * for permanent address
	 */
	@Column(name = "IS_NATIVEADD_CA_PA")
	private int isNatAddCurAddPerAdd;
	
	@Column(name = "CHANGE_TYPE")
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
	 * PVUEmployeAddressEntity Constructor.
	 */
	public PVUEmployeAddressEntity() {
		super();
	}

	/**
	 * @return the empAddressId
	 */
	public long getEmpAddressId() {
		return empAddressId;
	}

	/**
	 * @param empAddressId the empAddressId to set
	 */
	public void setEmpAddressId(long empAddressId) {
		this.empAddressId = empAddressId;
	}

	/**
	 * @return the curAddress1
	 */
	public String getCurAddress1() {
		return curAddress1;
	}

	/**
	 * @param curAddress1 the curAddress1 to set
	 */
	public void setCurAddress1(String curAddress1) {
		this.curAddress1 = curAddress1;
	}

	/**
	 * @return the curAddress2
	 */
	public String getCurAddress2() {
		return curAddress2;
	}

	/**
	 * @param curAddress2 the curAddress2 to set
	 */
	public void setCurAddress2(String curAddress2) {
		this.curAddress2 = curAddress2;
	}

	/**
	 * @return the curCity
	 */
	public String getCurCity() {
		return curCity;
	}

	/**
	 * @param curCity the curCity to set
	 */
	public void setCurCity(String curCity) {
		this.curCity = curCity;
	}

	/**
	 * @return the curPinCode
	 */
	public Integer getCurPinCode() {
		return curPinCode;
	}

	/**
	 * @param curPinCode the curPinCode to set
	 */
	public void setCurPinCode(Integer curPinCode) {
		this.curPinCode = curPinCode;
	}

	/**
	 * @return the curOfficeDist
	 */
	public EDPLuLookUpInfoEntity getCurOfficeDist() {
		return curOfficeDist;
	}

	/**
	 * @param curOfficeDist the curOfficeDist to set
	 */
	public void setCurOfficeDist(EDPLuLookUpInfoEntity curOfficeDist) {
		this.curOfficeDist = curOfficeDist;
	}

	/**
	 * @return the perAddress1
	 */
	public String getPerAddress1() {
		return perAddress1;
	}

	/**
	 * @param perAddress1 the perAddress1 to set
	 */
	public void setPerAddress1(String perAddress1) {
		this.perAddress1 = perAddress1;
	}

	/**
	 * @return the perAddress2
	 */
	public String getPerAddress2() {
		return perAddress2;
	}

	/**
	 * @param perAddress2 the perAddress2 to set
	 */
	public void setPerAddress2(String perAddress2) {
		this.perAddress2 = perAddress2;
	}

	/**
	 * @return the perCity
	 */
	public String getPerCity() {
		return perCity;
	}

	/**
	 * @param perCity the perCity to set
	 */
	public void setPerCity(String perCity) {
		this.perCity = perCity;
	}

	/**
	 * @return the perPincode
	 */
	public Integer getPerPinCode() {
		return perPinCode;
	}

	/**
	 * @param perPinCode the perPinCode to set
	 */
	public void setPerPinCode(Integer perPinCode) {
		this.perPinCode = perPinCode;
	}

	/**
	 * @return the natAddress1
	 */
	public String getNatAddress1() {
		return natAddress1;
	}

	/**
	 * @param natAddress1 the natAddress1 to set
	 */
	public void setNatAddress1(String natAddress1) {
		this.natAddress1 = natAddress1;
	}

	/**
	 * @return the natAddress2
	 */
	public String getNatAddress2() {
		return natAddress2;
	}

	/**
	 * @param natAddress2 the natAddress2 to set
	 */
	public void setNatAddress2(String natAddress2) {
		this.natAddress2 = natAddress2;
	}

	/**
	 * @return the natCity
	 */
	public String getNatCity() {
		return natCity;
	}

	/**
	 * @param natCity the natCity to set
	 */
	public void setNatCity(String natCity) {
		this.natCity = natCity;
	}

	/**
	 * @return the natPinCode
	 */
	public Integer getNatPinCode() {
		return natPinCode;
	}

	/**
	 * @param natPinCode the natPinCode to set
	 */
	public void setNatPinCode(Integer natPinCode) {
		this.natPinCode = natPinCode;
	}

	/**
	 * @return the pvuEmployeEntity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * @param pvuEmployeEntity the pvuEmployeEntity to set
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	/**
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the curState
	 */
	public EDPMsStateEntity getCurState() {
		return curState;
	}

	/**
	 * @param curState the curState to set
	 */
	public void setCurState(EDPMsStateEntity curState) {
		this.curState = curState;
	}

	/**
	 * @return the curDistrict
	 */
	public EDPMsDistrictEntity getCurDistrict() {
		return curDistrict;
	}

	/**
	 * @param curDistrict the curDistrict to set
	 */
	public void setCurDistrict(EDPMsDistrictEntity curDistrict) {
		this.curDistrict = curDistrict;
	}

	/**
	 * @return the curTaluka
	 */
	public EDPMsTalukaEntity getCurTaluka() {
		return curTaluka;
	}

	/**
	 * @param curTaluka the curTaluka to set
	 */
	public void setCurTaluka(EDPMsTalukaEntity curTaluka) {
		this.curTaluka = curTaluka;
	}

	/**
	 * @return the perState
	 */
	public EDPMsStateEntity getPerState() {
		return perState;
	}

	/**
	 * @param perState the perState to set
	 */
	public void setPerState(EDPMsStateEntity perState) {
		this.perState = perState;
	}

	/**
	 * @return the perDistrict
	 */
	public EDPMsDistrictEntity getPerDistrict() {
		return perDistrict;
	}

	/**
	 * @param perDistrict the perDistrict to set
	 */
	public void setPerDistrict(EDPMsDistrictEntity perDistrict) {
		this.perDistrict = perDistrict;
	}

	/**
	 * @return the perTaluka
	 */
	public EDPMsTalukaEntity getPerTaluka() {
		return perTaluka;
	}

	/**
	 * @param perTaluka the perTaluka to set
	 */
	public void setPerTaluka(EDPMsTalukaEntity perTaluka) {
		this.perTaluka = perTaluka;
	}

	/**
	 * @return the natState
	 */
	public EDPMsStateEntity getNatState() {
		return natState;
	}

	/**
	 * @param natState the natState to set
	 */
	public void setNatState(EDPMsStateEntity natState) {
		this.natState = natState;
	}

	/**
	 * @return the natDistrict
	 */
	public EDPMsDistrictEntity getNatDistrict() {
		return natDistrict;
	}

	/**
	 * @param natDistrict the natDistrict to set
	 */
	public void setNatDistrict(EDPMsDistrictEntity natDistrict) {
		this.natDistrict = natDistrict;
	}

	/**
	 * @return the natTaluka
	 */
	public EDPMsTalukaEntity getNatTaluka() {
		return natTaluka;
	}

	/**
	 * @param natTaluka the natTaluka to set
	 */
	public void setNatTaluka(EDPMsTalukaEntity natTaluka) {
		this.natTaluka = natTaluka;
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
				curTaluka, empAddressId, natAddress1, natAddress2, natCity, natDistrict, natPinCode, natState,
				natTaluka, perAddress1, perAddress2, perCity, perDistrict, perPinCode, perState, perTaluka,
				pvuEmployeEntity, statusId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUEmployeAddressEntity)) {
			return false;
		}
		PVUEmployeAddressEntity other = (PVUEmployeAddressEntity) obj;
		return Objects.equals(curAddress1, other.curAddress1) && Objects.equals(curAddress2, other.curAddress2)
				&& Objects.equals(curCity, other.curCity) && Objects.equals(curDistrict, other.curDistrict)
				&& Objects.equals(curOfficeDist, other.curOfficeDist) && Objects.equals(curPinCode, other.curPinCode)
				&& Objects.equals(curState, other.curState) && Objects.equals(curTaluka, other.curTaluka)
				&& Objects.equals(empAddressId, other.empAddressId) && Objects.equals(natAddress1, other.natAddress1)
				&& Objects.equals(natAddress2, other.natAddress2) && Objects.equals(natCity, other.natCity)
				&& Objects.equals(natDistrict, other.natDistrict) && Objects.equals(natPinCode, other.natPinCode)
				&& Objects.equals(natState, other.natState) && Objects.equals(natTaluka, other.natTaluka)
				&& Objects.equals(perAddress1, other.perAddress1) && Objects.equals(perAddress2, other.perAddress2)
				&& Objects.equals(perCity, other.perCity) && Objects.equals(perDistrict, other.perDistrict)
				&& Objects.equals(perPinCode, other.perPinCode) && Objects.equals(perState, other.perState)
				&& Objects.equals(perTaluka, other.perTaluka)
				&& Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity) && Objects.equals(statusId, other.statusId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeAddressEntity [empAddressId=" + empAddressId + ", curAddress1=" + curAddress1
				+ ", curAddress2=" + curAddress2 + ", curState=" + curState + ", curDistrict=" + curDistrict
				+ ", curTaluka=" + curTaluka + ", curCity=" + curCity + ", curPinCode=" + curPinCode
				+ ", curOfficeDist=" + curOfficeDist + ", perAddress1=" + perAddress1 + ", perAddress2=" + perAddress2
				+ ", perState=" + perState + ", perDistrict=" + perDistrict + ", perTaluka=" + perTaluka + ", perCity="
				+ perCity + ", perPinCode=" + perPinCode + ", natAddress1=" + natAddress1 + ", natAddress2="
				+ natAddress2 + ", natState=" + natState + ", natDistrict=" + natDistrict + ", natTaluka=" + natTaluka
				+ ", natCity=" + natCity + ", natPinCode=" + natPinCode + ", pvuEmployeEntity=" + pvuEmployeEntity
				+ ", statusId=" + statusId + "]";
	}

}
