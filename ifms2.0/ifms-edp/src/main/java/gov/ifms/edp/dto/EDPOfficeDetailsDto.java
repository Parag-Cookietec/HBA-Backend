package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The Class EDPOfficeDetailsDto.
 */
public class EDPOfficeDetailsDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The districts. */
	private List<ClueDto> districts;

	/** The office type. */
	private List<ClueDto> officeType;

	/** The level. */
	private List<ClueDto> level;

	/** The pvu. */
	private List<ClueDto> pvu;

	/** The designation of ddo. */
	private List<ClueDto> designationOfDdo;

	/** The request tos. */
	private List<ClueDto> requestTos;

	/** The co office. */
	private List<ClueDto> coOffice;

	/** The department. */
	private ClueDto department;

	/** The controlling office. */
	private List<ClueDto> controllingOffice;
	
	
	/** The bill submitted to. */
	private List<ClueDto> billSubmittedTo;
	
	/** The bill type. */
	private List<ClueDto> billType;
	
	/** The listsof bill. */
	private List<ClueDto> listsofBill;
	
	/** The module type. */
	private List<ClueDto> moduleType;
	
	/** The status. */
	private List<ClueDto> status;

	/** The cardexno. */
	private ClueDto cardexno;

	/** The hod. */
	private ClueDto hod;
	
	/** The non ddo type. */
	private List<ClueDto> nonDdoType;
	
	/** The ddo type. */
	private List<ClueDto> ddoType;
	
	/** The departments. */
	private List<ClueDto> departments;
	
	/** The update status. */
	private List<ClueDto> updateStatus;
	
	/** The update status. */
	private List<ClueDto> hodList;
	
	/** The status. */
	private Set<ClueDto> wfStatus;
	
	/** The trans status list. */
	private Set<ClueDto> transStatusList;

	public Set<ClueDto> getTransStatusList() {
		return transStatusList;
	}

	public void setTransStatusList(Set<ClueDto> transStatusList) {
		this.transStatusList = transStatusList;
	}

	/**
	 * Gets the districts.
	 *
	 * @return the districts
	 */
	public List<ClueDto> getDistricts() {
		return districts;
	}

	/**
	 * Sets the districts.
	 *
	 * @param districts the districts to set
	 */
	public void setDistricts(List<ClueDto> districts) {
		this.districts = districts;
	}

	/**
	 * Gets the office type.
	 *
	 * @return the officeType
	 */
	public List<ClueDto> getOfficeType() {
		return officeType;
	}

	/**
	 * Sets the office type.
	 *
	 * @param officeType the officeType to set
	 */
	public void setOfficeType(List<ClueDto> officeType) {
		this.officeType = officeType;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public List<ClueDto> getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the level to set
	 */
	public void setLevel(List<ClueDto> level) {
		this.level = level;
	}

	/**
	 * Gets the pvu.
	 *
	 * @return the pvu
	 */
	public List<ClueDto> getPvu() {
		return pvu;
	}

	/**
	 * Sets the pvu.
	 *
	 * @param pvu the pvu to set
	 */
	public void setPvu(List<ClueDto> pvu) {
		this.pvu = pvu;
	}

	/**
	 * Gets the designation of ddo.
	 *
	 * @return the designationOfDdo
	 */
	public List<ClueDto> getDesignationOfDdo() {
		return designationOfDdo;
	}

	/**
	 * Sets the designation of ddo.
	 *
	 * @param designationOfDdo the designationOfDdo to set
	 */
	public void setDesignationOfDdo(List<ClueDto> designationOfDdo) {
		this.designationOfDdo = designationOfDdo;
	}

	/**
	 * Gets the request tos.
	 *
	 * @return the requestTos
	 */
	public List<ClueDto> getRequestTos() {
		return requestTos;
	}

	/**
	 * Sets the request tos.
	 *
	 * @param requestTos the requestTos to set
	 */
	public void setRequestTos(List<ClueDto> requestTos) {
		this.requestTos = requestTos;
	}

	/**
	 * Gets the co office.
	 *
	 * @return the coOffice
	 */
	public List<ClueDto> getCoOffice() {
		return coOffice;
	}

	/**
	 * Sets the co office.
	 *
	 * @param coOffice the coOffice to set
	 */
	public void setCoOffice(List<ClueDto> coOffice) {
		this.coOffice = coOffice;
	}

	/**
	 * Gets the department.
	 *
	 * @return the department
	 */
	public ClueDto getDepartment() {
		return department;
	}

	/**
	 * Sets the department.
	 *
	 * @param department the department to set
	 */
	public void setDepartment(ClueDto department) {
		this.department = department;
	}

	/**
	 * Gets the hod.
	 *
	 * @return the hod
	 */
	public ClueDto getHod() {
		return hod;
	}

	/**
	 * Sets the hod.
	 *
	 * @param hod the hod to set
	 */
	public void setHod(ClueDto hod) {
		this.hod = hod;
	}

	/**
	 * Gets the controlling office.
	 *
	 * @return the controllingOffice
	 */
	public List<ClueDto> getControllingOffice() {
		return controllingOffice;
	}

	/**
	 * Sets the controlling office.
	 *
	 * @param controllingOffice the controllingOffice to set
	 */
	public void setControllingOffice(List<ClueDto> controllingOffice) {
		this.controllingOffice = controllingOffice;
	}
	
	/**
	 * Gets the cardexno.
	 *
	 * @return the cardexno
	 */
	public ClueDto getCardexno() {
		return cardexno;
	}

	public Set<ClueDto> getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(Set<ClueDto> wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Sets the cardexno.
	 *
	 * @param cardexno the new cardexno
	 */
	public void setCardexno(ClueDto cardexno) {
		this.cardexno = cardexno;
	}

	/**
	 * Gets the bill submitted to.
	 *
	 * @return the billSubmittedTo
	 */
	public List<ClueDto> getBillSubmittedTo() {
		return billSubmittedTo;
	}

	/**
	 * Sets the bill submitted to.
	 *
	 * @param billSubmittedTo the billSubmittedTo to set
	 */
	public void setBillSubmittedTo(List<ClueDto> billSubmittedTo) {
		this.billSubmittedTo = billSubmittedTo;
	}

	/**
	 * Gets the bill type.
	 *
	 * @return the billType
	 */
	public List<ClueDto> getBillType() {
		return billType;
	}

	/**
	 * Sets the bill type.
	 *
	 * @param billType the billType to set
	 */
	public void setBillType(List<ClueDto> billType) {
		this.billType = billType;
	}

	/**
	 * Gets the listsof bill.
	 *
	 * @return the listsofBill
	 */
	public List<ClueDto> getListsofBill() {
		return listsofBill;
	}

	/**
	 * Sets the listsof bill.
	 *
	 * @param listsofBill the listsofBill to set
	 */
	public void setListsofBill(List<ClueDto> listsofBill) {
		this.listsofBill = listsofBill;
	}

	/**
	 * Gets the module type.
	 *
	 * @return the moduleType
	 */
	public List<ClueDto> getModuleType() {
		return moduleType;
	}

	/**
	 * Sets the module type.
	 *
	 * @param moduleType the moduleType to set
	 */
	public void setModuleType(List<ClueDto> moduleType) {
		this.moduleType = moduleType;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public List<ClueDto> getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(List<ClueDto> status) {
		this.status = status;
	}

	/**
	 * Gets the non ddo type.
	 *
	 * @return the nonDdoType
	 */
	public List<ClueDto> getNonDdoType() {
		return nonDdoType;
	}

	/**
	 * Sets the non ddo type.
	 *
	 * @param nonDdoType the nonDdoType to set
	 */
	public void setNonDdoType(List<ClueDto> nonDdoType) {
		this.nonDdoType = nonDdoType;
	}

	/**
	 * Gets the ddo type.
	 *
	 * @return the ddoType
	 */
	public List<ClueDto> getDdoType() {
		return ddoType;
	}

	/**
	 * Sets the ddo type.
	 *
	 * @param ddoType the ddoType to set
	 */
	public void setDdoType(List<ClueDto> ddoType) {
		this.ddoType = ddoType;
	}

	/**
	 * Gets the departments.
	 *
	 * @return the departments
	 */
	public List<ClueDto> getDepartments() {
		return departments;
	}
	
	/**
	 * Gets the update status.
	 *
	 * @return the updateStatus
	 */
	public List<ClueDto> getUpdateStatus() {
		return updateStatus;
	}

	/**
	 * Sets the update status.
	 *
	 * @param updateStatus the updateStatus to set
	 */
	public void setUpdateStatus(List<ClueDto> updateStatus) {
		this.updateStatus = updateStatus;
	}

	/**
	 * Sets the departments.
	 *
	 * @param departments the departments to set
	 */
	public void setDepartments(List<ClueDto> departments) {
		this.departments = departments;
	}
	
	

	public List<ClueDto> getHodList() {
		return hodList;
	}

	public void setHodList(List<ClueDto> hodList) {
		this.hodList = hodList;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(billSubmittedTo, billType, cardexno, coOffice, controllingOffice, ddoType, department,
				designationOfDdo, districts, hod, level, listsofBill, moduleType, nonDdoType, officeType, pvu,
				requestTos, status);
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
		if (!(obj instanceof EDPOfficeDetailsDto)) {
			return false;
		}
		EDPOfficeDetailsDto other = (EDPOfficeDetailsDto) obj;
		return Objects.equals(billSubmittedTo, other.billSubmittedTo) && Objects.equals(billType, other.billType)
				&& Objects.equals(cardexno, other.cardexno) && Objects.equals(coOffice, other.coOffice)
				&& Objects.equals(controllingOffice, other.controllingOffice) && Objects.equals(ddoType, other.ddoType)
				&& Objects.equals(department, other.department)
				&& Objects.equals(designationOfDdo, other.designationOfDdo)
				&& Objects.equals(districts, other.districts) && Objects.equals(hod, other.hod)
				&& Objects.equals(level, other.level) && Objects.equals(listsofBill, other.listsofBill)
				&& Objects.equals(moduleType, other.moduleType) && Objects.equals(nonDdoType, other.nonDdoType)
				&& Objects.equals(officeType, other.officeType) && Objects.equals(pvu, other.pvu)
				&& Objects.equals(requestTos, other.requestTos) && Objects.equals(status, other.status);
	}

	

}
