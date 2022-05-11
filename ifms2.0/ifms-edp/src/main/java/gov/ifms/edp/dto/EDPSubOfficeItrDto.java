package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPSubOfficeItrDto.
 */
public class EDPSubOfficeItrDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sub office itr id. */
	private Long subOfficeItrId;

	/** The sub office id. */
	private Long subOfficeId;

	/** The office id. */
	private Long officeId;

	/** The sub office code. */
	private String subOfficeCode;

	/** The sub office name. */
	private String subOfficeName;

	/** The sub office name guj. */
	private String subOfficeNameGuj;

	/** The department id. */
	private Long departmentId;

	/** The hod id. */
	private Long hodId;

	/** The address. */
	private String address;

	/** The district id. */
	private Long districtId;

	/** The taluka id. */
	private Long talukaId;

	/** The station. */
	private String station;

	/** The pincode. */
	private String pincode;

	/** The std code. */
	private String stdCode;

	/** The office email id. */
	private String officeEmailId;

	/** The phone no. */
	private String phoneNo;

	/** The fax no. */
	private String faxNo;

	/** The status. */
	private Long status;

	/** The workflow id. */
	private Long workflowId;

	/** The workflow role id. */
	private Long workflowRoleId;
	
	/** The office name. */
	private String officeName;

	/** The hod name. */
	private String hodName;

	/** The district name. */
	private String districtName;
	
	/** The taluka name. */
	private String talukaName;
	
	/** The department name. */
	private String departmentName;
	
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
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
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
	 * Gets the department id.
	 *
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Gets the hod id.
	 *
	 * @return the hodId
	 */
	public Long getHodId() {
		return hodId;
	}

	/**
	 * Sets the hod id.
	 *
	 * @param hodId the hodId to set
	 */
	public void setHodId(Long hodId) {
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
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
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
	 * Gets the std code.
	 *
	 * @return the stdCode
	 */
	public String getStdCode() {
		return stdCode;
	}

	/**
	 * Sets the std code.
	 *
	 * @param stdCode the stdCode to set
	 */
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
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
	 * Gets the workflow id.
	 *
	 * @return the workflowId
	 */
	public Long getWorkflowId() {
		return workflowId;
	}

	/**
	 * Sets the workflow id.
	 *
	 * @param workflowId the workflowId to set
	 */
	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
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

	/**
	 * @return the hodName
	 */
	public String getHodName() {
		return hodName;
	}

	/**
	 * @param hodName the hodName to set
	 */
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the talukaName
	 */
	public String getTalukaName() {
		return talukaName;
	}

	/**
	 * @param talukaName the talukaName to set
	 */
	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(address, departmentId, departmentName, districtId, districtName, faxNo,
				hodId, hodName, officeEmailId, officeId, officeName, phoneNo, pincode, station, status, stdCode,
				subOfficeCode, subOfficeId, subOfficeItrId, subOfficeName, subOfficeNameGuj, talukaId, talukaName,
				workflowId, workflowRoleId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPSubOfficeItrDto)) {
			return false;
		}
		EDPSubOfficeItrDto other = (EDPSubOfficeItrDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(departmentName, other.departmentName) && Objects.equals(districtId, other.districtId)
				&& Objects.equals(districtName, other.districtName) && Objects.equals(faxNo, other.faxNo)
				&& Objects.equals(hodId, other.hodId) && Objects.equals(hodName, other.hodName)
				&& Objects.equals(officeEmailId, other.officeEmailId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(phoneNo, other.phoneNo)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(station, other.station)
				&& Objects.equals(status, other.status) && Objects.equals(stdCode, other.stdCode)
				&& Objects.equals(subOfficeCode, other.subOfficeCode) && Objects.equals(subOfficeId, other.subOfficeId)
				&& Objects.equals(subOfficeItrId, other.subOfficeItrId)
				&& Objects.equals(subOfficeName, other.subOfficeName)
				&& Objects.equals(subOfficeNameGuj, other.subOfficeNameGuj) && Objects.equals(talukaId, other.talukaId)
				&& Objects.equals(talukaName, other.talukaName) && Objects.equals(workflowId, other.workflowId)
				&& Objects.equals(workflowRoleId, other.workflowRoleId);
	}
	
	
}
