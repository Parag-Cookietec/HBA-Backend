package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.EDPSDTDto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * The Class PVUEmployeeLookupInfoDto.
 */
public class PvuLookupInfoDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lst lu look up. */
	private Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp;

	/** The school degree. */
	private List<EDPSDTDto> schoolDegree;

	/** The course. */
	private List<EDPSDTDto> course;

	/** The ccc exam body. */
	private List<EDPSDTDto> cccExamBody;

	/** The year of passing. */
	private List<EDPSDTDto> yearOfPassing;

	/** The hod department. */
	private List<EDPSDTDto> hodDepartment;

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
