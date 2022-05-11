package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;


/**
 * The Class EDPUpdateDesignationDetailsDto.
 */
public class EDPUpdateDesignationDetailsDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The employee. */
	private Set<ClueDto> employee;
	
	/** The designation. */
	private List<ClueDto> designation;

	/** The office emp details. */
	private List<EDPOffEmpDto> officeEmpDetails;
	
	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public Set<ClueDto> getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the employee to set
	 */
	public void setEmployee(Set<ClueDto> employee) {
		this.employee = employee;
	}
	
	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public List<ClueDto> getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the designation to set
	 */
	public void setDesignation(List<ClueDto> designation) {
		this.designation = designation;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(designation, employee);
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
		if (!(obj instanceof EDPUpdateDesignationDetailsDto)) {
			return false;
		}
		EDPUpdateDesignationDetailsDto other = (EDPUpdateDesignationDetailsDto) obj;
		return Objects.equals(designation, other.designation) && Objects.equals(employee, other.employee);
	}

	/**
	 * Gets the office emp details.
	 *
	 * @return the office emp details
	 */
	public List<EDPOffEmpDto> getOfficeEmpDetails() {
		return officeEmpDetails;
	}

	/**
	 * Sets the office emp details.
	 *
	 * @param officeEmpDetails the new office emp details
	 */
	public void setOfficeEmpDetails(List<EDPOffEmpDto> officeEmpDetails) {
		this.officeEmpDetails = officeEmpDetails;
	}
		
}
