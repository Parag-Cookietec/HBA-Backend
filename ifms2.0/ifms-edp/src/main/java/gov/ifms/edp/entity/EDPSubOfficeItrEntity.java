package gov.ifms.edp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPSubOfficeItrEntity.
 */
@Entity
@Table(name = "T_SUB_OFF_ITR", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPSubOfficeItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sub office itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_SUB_OFF_ITR_ID")
	private Long subOfficeItrId;

	/** The sub office id. */
	@Column(name = "S_OFFICE_ID")
	private Long subOfficeId;
	
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
	
	/** The workflow role id. */
	@Column(name = "WF_ROLE_ID")
	private Long workflowRoleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_UPDATE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isUpdate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_EDP_UPD_OFF_TRN_ID", referencedColumnName = "T_EDP_UPD_OFF_TRN_ID")
	private EDPUpdateOfficeTrnEntity officeTrnEntity;

	/**
	 * Gets the sub office itr id.
	 *
	 * @return the subOfficeItrId
	 */
	public Long getSubOfficeItrId() {
		return subOfficeItrId;
	}

	/**
	 * Sets the sub office itr id.
	 *
	 * @param subOfficeItrId the subOfficeItrId to set
	 */
	public void setSubOfficeItrId(Long subOfficeItrId) {
		this.subOfficeItrId = subOfficeItrId;
	}

	/**
	 * Gets the sub office id.
	 *
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
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
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
	 * Gets the workflow role id.
	 *
	 * @return the workflowRoleId
	 */
	public Long getWorkflowRoleId() {
		return workflowRoleId;
	}

	/**
	 * Sets the workflow role id.
	 *
	 * @param workflowRoleId the workflowRoleId to set
	 */
	public void setWorkflowRoleId(Long workflowRoleId) {
		this.workflowRoleId = workflowRoleId;
	}
	
	/**
	 * @return the isUpdate
	 */
	public EDPLuLookUpInfoEntity getIsUpdate() {
		return isUpdate;
	}

	/**
	 * @param isUpdate the isUpdate to set
	 */
	public void setIsUpdate(EDPLuLookUpInfoEntity isUpdate) {
		this.isUpdate = isUpdate;
	}

	/**
	 * @return the deptId
	 */
	public EDPMsDepartmentEntity getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(EDPMsDepartmentEntity deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the hodId
	 */
	public EDPMsOfficeEntity getHodId() {
		return hodId;
	}

	/**
	 * @param hodId the hodId to set
	 */
	public void setHodId(EDPMsOfficeEntity hodId) {
		this.hodId = hodId;
	}

	/**
	 * @return the district
	 */
	public EDPMsDistrictEntity getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(EDPMsDistrictEntity district) {
		this.district = district;
	}

	/**
	 * @return the taluka
	 */
	public EDPMsTalukaEntity getTaluka() {
		return taluka;
	}

	/**
	 * @param taluka the taluka to set
	 */
	public void setTaluka(EDPMsTalukaEntity taluka) {
		this.taluka = taluka;
	}

	/**
	 * @return the officeTrnEntity
	 */
	public EDPUpdateOfficeTrnEntity getOfficeTrnEntity() {
		return officeTrnEntity;
	}

	/**
	 * @param officeTrnEntity the officeTrnEntity to set
	 */
	public void setOfficeTrnEntity(EDPUpdateOfficeTrnEntity officeTrnEntity) {
		this.officeTrnEntity = officeTrnEntity;
	}
	
}
