package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import gov.ifms.common.validation.annotation.EmailId;
import gov.ifms.common.validation.annotation.Numeric;

/**
 * The Class EDPMsSubOfficeDto.
 * 
 * @version 1.0
 * @created 2019/12/05 12:35:58
 *
 */
public class EDPMsSubOfficeDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sub office id. */
	private Long subOfficeId;

	/** The office id. */
	private Long officeId;

	/** The office name. */
	private String officeName;

	/** The sub office code. */
	private String subOfficeCode;

	/** The sub office name. */
	@NotNull
	private String subOfficeName;

	/** The sub office name guj. */
	private String subOfficeNameGuj;

	/** The department id. */
	@Min(1)
	private Long departmentId;

	/** The department name. */
	private String departmentName;

	/** The hod id. */
	@Min(1)
	private Long hodId;

	/** The hod name. */
	private String hodName;

	/** The address. */
	@NotNull
	private String address;

	/** The district id. */
	private Long districtId;

	/** The district name. */
	private String districtName;

	/** The taluka id. */
	private Long talukaId;

	/** The taluka name. */
	private String talukaName;

	/** The station. */
	private String station;

	/** The pincode. */
	@Numeric(nullable = true)
	private String pincode;

	/** The std code. */
	@Numeric(nullable = true)
	private String stdCode;

	/** The office email id. */
	@EmailId(nullable = true)
	private String officeEmailId;

	/** The phone no. */
	@Numeric(nullable = true)
	private String phoneNo;

	/** The fax no. */
	@Numeric(nullable = true)
	private String faxNo;

	/** The status. */
	private Long status;

	/** The workflow id. */
	private Long workflowId;

	/** The workflow role id. */
	private Long workflowRoleId;

	/** The is update. */
	private Boolean isUpdate;

	/** The sub office itr id. */
	private Long subOfficeItrId;

	/** The flag. */
	private Boolean flag;

	/** The office trn id. */
	private Long officeTrnId;

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
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the department name.
	 *
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * Sets the department name.
	 *
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the district name.
	 *
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Gets the taluka id.
	 *
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * Sets the taluka id.
	 *
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * Gets the taluka name.
	 *
	 * @return the talukaName
	 */
	public String getTalukaName() {
		return talukaName;
	}

	/**
	 * Sets the taluka name.
	 *
	 * @param talukaName the talukaName to set
	 */
	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	/**
	 * Gets the hod name.
	 *
	 * @return the hodName
	 */
	public String getHodName() {
		return hodName;
	}

	/**
	 * Sets the hod name.
	 *
	 * @param hodName the hodName to set
	 */
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	/**
	 * Gets the checks if is update.
	 *
	 * @return the isUpdate
	 */
	public Boolean getIsUpdate() {
		return isUpdate;
	}

	/**
	 * Sets the checks if is update.
	 *
	 * @param isUpdate the isUpdate to set
	 */
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

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
	 * Gets the flag.
	 *
	 * @return the flag
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * Sets the flag.
	 *
	 * @param flag the flag to set
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(address, departmentId, departmentName, districtId, districtName, faxNo,
				flag, hodId, hodName, isUpdate, officeEmailId, officeId, officeName, phoneNo, pincode, station, status,
				stdCode, subOfficeCode, subOfficeId, subOfficeItrId, subOfficeName, subOfficeNameGuj, talukaId,
				talukaName, workflowId, workflowRoleId);
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
		if (!(obj instanceof EDPMsSubOfficeDto)) {
			return false;
		}
		EDPMsSubOfficeDto other = (EDPMsSubOfficeDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(departmentName, other.departmentName) && Objects.equals(districtId, other.districtId)
				&& Objects.equals(districtName, other.districtName) && Objects.equals(faxNo, other.faxNo)
				&& Objects.equals(flag, other.flag) && Objects.equals(hodId, other.hodId)
				&& Objects.equals(hodName, other.hodName) && Objects.equals(isUpdate, other.isUpdate)
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