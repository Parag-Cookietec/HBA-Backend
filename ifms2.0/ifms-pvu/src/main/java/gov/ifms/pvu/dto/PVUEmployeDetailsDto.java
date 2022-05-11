package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import gov.ifms.edp.dto.EDPSDTDto;

/**
 * The Class PVUEmployeDetailsDto.
 */
public class PVUEmployeDetailsDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lst lu look up. */
	private Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp;

	/** The lst SDT data. */
	private List<EDPSDTDto> lstSDTData;

	/** The school degree. */
	private List<EDPSDTDto> schoolDegree;

	/** The course. */
	private List<EDPSDTDto> course;

	/** The ccc exam body. */
	private List<EDPSDTDto> cccExamBody;

	/** The year of passing. */
	private List<EDPSDTDto> yearOfPassing;

	/** The administrative department. */
	private List<EDPSDTDto> administrativeDepartment;

	/** The hod department. */
	private List<EDPSDTDto> hodDepartment;

	/** The designation. */
	private List<EDPSDTDto> designation;

	/** The district. */
	private List<EDPSDTDto> district;

	/** The dept category. */
	private List<EDPSDTDto> deptCategory;

	private List<EDPSDTDto> bankIfsc;

	/**
	 * Gets the lst lu look up.
	 *
	 * @return the lst lu look up
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getLstLuLookUp() {
		return lstLuLookUp;
	}

	/**
	 * Sets the lst lu look up.
	 *
	 * @param lstLuLookUp the lst lu look up
	 */
	public void setLstLuLookUp(Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp) {
		this.lstLuLookUp = lstLuLookUp;
	}

	/**
	 * Gets the lst SDT data.
	 *
	 * @return the lst SDT data
	 */
	public List<EDPSDTDto> getLstSDTData() {
		return lstSDTData;
	}

	/**
	 * Sets the lst SDT data.
	 *
	 * @param lstSDTData the new lst SDT data
	 */
	public void setLstSDTData(List<EDPSDTDto> lstSDTData) {
		this.lstSDTData = lstSDTData;
	}

	/**
	 * Gets the school degree.
	 *
	 * @return the school degree
	 */
	public List<EDPSDTDto> getSchoolDegree() {
		return schoolDegree;
	}

	/**
	 * Sets the school degree.
	 *
	 * @param schoolDegree the new school degree
	 */
	public void setSchoolDegree(List<EDPSDTDto> schoolDegree) {
		this.schoolDegree = schoolDegree;
	}

	/**
	 * Gets the course.
	 *
	 * @return the course
	 */
	public List<EDPSDTDto> getCourse() {
		return course;
	}

	/**
	 * Sets the course.
	 *
	 * @param course the new course
	 */
	public void setCourse(List<EDPSDTDto> course) {
		this.course = course;
	}

	/**
	 * Gets the ccc exam body.
	 *
	 * @return the ccc exam body
	 */
	public List<EDPSDTDto> getCccExamBody() {
		return cccExamBody;
	}

	/**
	 * Sets the ccc exam body.
	 *
	 * @param cccExamBody the new ccc exam body
	 */
	public void setCccExamBody(List<EDPSDTDto> cccExamBody) {
		this.cccExamBody = cccExamBody;
	}

	/**
	 * Gets the year of passing.
	 *
	 * @return the year of passing
	 */
	public List<EDPSDTDto> getYearOfPassing() {
		return yearOfPassing;
	}

	/**
	 * Sets the year of passing.
	 *
	 * @param yearOfPassing the new year of passing
	 */
	public void setYearOfPassing(List<EDPSDTDto> yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	/**
	 * Gets the administrative department.
	 *
	 * @return the administrative department
	 */
	public List<EDPSDTDto> getAdministrativeDepartment() {
		return administrativeDepartment;
	}

	/**
	 * Sets the administrative department.
	 *
	 * @param administrativeDepartment the new administrative department
	 */
	public void setAdministrativeDepartment(List<EDPSDTDto> administrativeDepartment) {
		this.administrativeDepartment = administrativeDepartment;
	}

	/**
	 * Gets the hod department.
	 *
	 * @return the hod department
	 */
	public List<EDPSDTDto> getHodDepartment() {
		return hodDepartment;
	}

	/**
	 * Sets the hod department.
	 *
	 * @param hodDepartment the new hod department
	 */
	public void setHodDepartment(List<EDPSDTDto> hodDepartment) {
		this.hodDepartment = hodDepartment;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public List<EDPSDTDto> getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the new designation
	 */
	public void setDesignation(List<EDPSDTDto> designation) {
		this.designation = designation;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public List<EDPSDTDto> getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the new district
	 */
	public void setDistrict(List<EDPSDTDto> district) {
		this.district = district;
	}

	/**
	 * Gets the dept category.
	 *
	 * @return the dept category
	 */
	public List<EDPSDTDto> getDeptCategory() {
		return deptCategory;
	}

	/**
	 * Sets the dept category.
	 *
	 * @param deptCategory the new dept category
	 */
	public void setDeptCategory(List<EDPSDTDto> deptCategory) {
		this.deptCategory = deptCategory;
	}

	/**
	 * Gets the bank ifsc.
	 *
	 * @return the bank ifsc
	 */
	public List<EDPSDTDto> getBankIfsc() {
		return bankIfsc;
	}

	/**
	 * Sets the bank ifsc.
	 *
	 * @param bankIfsc the new bank ifsc
	 */
	public void setBankIfsc(List<EDPSDTDto> bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

}
