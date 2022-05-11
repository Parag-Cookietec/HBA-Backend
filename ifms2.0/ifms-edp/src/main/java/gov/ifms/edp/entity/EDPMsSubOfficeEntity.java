package gov.ifms.edp.entity;

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
import javax.persistence.Table;
import javax.persistence.Transient;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsSubOfficeEntity.
 * 
 * @version 1.0
 * @created 2019/12/05 12:35:58
 *
 */
@Entity
@Table(name = "MS_SUB_OFFICE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsSubOfficeEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sub office id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "S_OFFICE_ID")
	private Long subOfficeId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The sub office code. */
	@Column(name = "S_OFFICE_CODE")
	private String subOfficeCode;

	/** The sub office name. */
	@Column(name = "S_OFFICE_NAME")
	private String subOfficeName;

	/** The sub office name guj. */
	@Column(name = "S_OFFICE_NAME_GUJ")
	private String subOfficeNameGuj;

	/** The dept id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
	private EDPMsDepartmentEntity deptId;

	/** The hod id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOD_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity hodId;

	/** The address. */
	@Column(name = "OFF_ADDRESS")
	private String address;

	/** The district. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity district;

	/** The taluka. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TALUKA_ID", referencedColumnName = "TALUKA_ID")
	private EDPMsTalukaEntity taluka;

	/** The station. */
	@Column(name = "STATION")
	private String station;

	/** The pincode. */
	@Column(name = "PIN_CODE")
	private String pincode;

	/** The office email id. */
	@Column(name = "O_EMAIL_ID")
	private String officeEmailId;

	/** The phone no. */
	@Column(name = "PHONE_NO")
	private String phoneNo;

	/** The fax no. */
	@Column(name = "FAX_NO")
	private String faxNo;

	/** The status. */
	@Column(name = "STATUS_ID")
	private Long status;

	/** The is update. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_UPDATE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isUpdate;

	/** The office trn id. */
	@Transient
	private Long officeTrnId;

	/**
	 * Gets the office trn id.
	 *
	 * @return the office trn id
	 */
	public Long getOfficeTrnId() {
		return officeTrnId;
	}

	/**
	 * Sets the office trn id.
	 *
	 * @param officeTrnId the new office trn id
	 */
	public void setOfficeTrnId(Long officeTrnId) {
		this.officeTrnId = officeTrnId;
	}

	/**
	 * EDPMsSubOfficeDto Constructor.
	 */
	public EDPMsSubOfficeEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms sub office entity.
	 *
	 * @param subOfficeId the sub office id
	 */
	public EDPMsSubOfficeEntity(Long subOfficeId) {
		super();
		this.subOfficeId = subOfficeId;
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(subOfficeId, subOfficeCode, subOfficeName, subOfficeNameGuj, deptId, hodId, address,
				district, taluka, station, pincode, officeEmailId, phoneNo, faxNo, status);
	}

	/**
	 * equals method.
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
		if (!(obj instanceof EDPMsSubOfficeEntity)) {
			return false;
		}

		EDPMsSubOfficeEntity other = (EDPMsSubOfficeEntity) obj;

		return Objects.equals(subOfficeId, other.subOfficeId) && Objects.equals(subOfficeCode, other.subOfficeCode)
				&& Objects.equals(subOfficeName, other.subOfficeName)
				&& Objects.equals(subOfficeNameGuj, other.subOfficeNameGuj) && Objects.equals(deptId, other.deptId)
				&& Objects.equals(hodId, other.hodId) && Objects.equals(address, other.address)
				&& Objects.equals(district, other.district) && Objects.equals(taluka, other.taluka)
				&& Objects.equals(station, other.station) && Objects.equals(pincode, other.pincode)
				&& Objects.equals(officeEmailId, other.officeEmailId) && Objects.equals(phoneNo, other.phoneNo)
				&& Objects.equals(faxNo, other.faxNo) && Objects.equals(status, other.status);
	}

	/**
	 * getter setter.
	 *
	 * @return the sub office id
	 */

	/**
	 * @return the subOfficeId
	 */
	public Long getSubOfficeId() {
		return subOfficeId;
	}

	/**
	 * Sets the sub office id.
	 *
	 * @param subOfficeId the subOfficeId to set
	 */
	public void setSubOfficeId(Long subOfficeId) {
		this.subOfficeId = subOfficeId;
	}

	/**
	 * Gets the sub office code.
	 *
	 * @return the subOfficeCode
	 */
	public String getSubOfficeCode() {
		return subOfficeCode;
	}

	/**
	 * Sets the sub office code.
	 *
	 * @param subOfficeCode the subOfficeCode to set
	 */
	public void setSubOfficeCode(String subOfficeCode) {
		this.subOfficeCode = subOfficeCode;
	}

	/**
	 * Gets the sub office name.
	 *
	 * @return the subOfficeName
	 */
	public String getSubOfficeName() {
		return subOfficeName;
	}

	/**
	 * Sets the sub office name.
	 *
	 * @param subOfficeName the subOfficeName to set
	 */
	public void setSubOfficeName(String subOfficeName) {
		this.subOfficeName = subOfficeName;
	}

	/**
	 * Gets the sub office name guj.
	 *
	 * @return the subOfficeNameGuj
	 */
	public String getSubOfficeNameGuj() {
		return subOfficeNameGuj;
	}

	/**
	 * Sets the sub office name guj.
	 *
	 * @param subOfficeNameGuj the subOfficeNameGuj to set
	 */
	public void setSubOfficeNameGuj(String subOfficeNameGuj) {
		this.subOfficeNameGuj = subOfficeNameGuj;
	}

	/**
	 * Gets the dept id.
	 *
	 * @return the deptId
	 */
	public EDPMsDepartmentEntity getDeptId() {
		return deptId;
	}

	/**
	 * Sets the dept id.
	 *
	 * @param deptId the deptId to set
	 */
	public void setDeptId(EDPMsDepartmentEntity deptId) {
		this.deptId = deptId;
	}

	/**
	 * Gets the hod id.
	 *
	 * @return the hodId
	 */
	public EDPMsOfficeEntity getHodId() {
		return hodId;
	}

	/**
	 * Sets the hod id.
	 *
	 * @param hodId the hodId to set
	 */
	public void setHodId(EDPMsOfficeEntity hodId) {
		this.hodId = hodId;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public EDPMsDistrictEntity getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the district to set
	 */
	public void setDistrict(EDPMsDistrictEntity district) {
		this.district = district;
	}

	/**
	 * Gets the taluka.
	 *
	 * @return the taluka
	 */
	public EDPMsTalukaEntity getTaluka() {
		return taluka;
	}

	/**
	 * Sets the taluka.
	 *
	 * @param taluka the taluka to set
	 */
	public void setTaluka(EDPMsTalukaEntity taluka) {
		this.taluka = taluka;
	}

	/**
	 * Gets the station.
	 *
	 * @return the station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * Sets the station.
	 *
	 * @param station the station to set
	 */
	public void setStation(String station) {
		this.station = station;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the pincode.
	 *
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * Sets the pincode.
	 *
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * Gets the office email id.
	 *
	 * @return the officeEmailId
	 */
	public String getOfficeEmailId() {
		return officeEmailId;
	}

	/**
	 * Sets the office email id.
	 *
	 * @param officeEmailId the officeEmailId to set
	 */
	public void setOfficeEmailId(String officeEmailId) {
		this.officeEmailId = officeEmailId;
	}

	/**
	 * Gets the phone no.
	 *
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the phone no.
	 *
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Gets the fax no.
	 *
	 * @return the faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}

	/**
	 * Sets the fax no.
	 *
	 * @param faxNo the faxNo to set
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(Long status) {
		this.status = status;
	}

	/**
	 * Gets the checks if is update.
	 *
	 * @return the isUpdate
	 */
	public EDPLuLookUpInfoEntity getIsUpdate() {
		return isUpdate;
	}

	/**
	 * Sets the checks if is update.
	 *
	 * @param isUpdate the isUpdate to set
	 */
	public void setIsUpdate(EDPLuLookUpInfoEntity isUpdate) {
		this.isUpdate = isUpdate;
	}

}
