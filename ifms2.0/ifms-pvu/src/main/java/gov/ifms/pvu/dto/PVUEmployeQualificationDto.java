package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeQualificationDto.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:11:13
 *
 */
public class PVUEmployeQualificationDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp quali id. */
	private long empQualiId;

	/** The degree. */
	@NotBlank
	private long degree;

	private String degreeName;

	/** The course name. */
	private long courseName;

	private String courseIdName;

	/** The passing year. */
	private long passingYear;

	private String passingYearName;

	/** The school college. */
	@NotBlank
	private String schoolCollege;

	/** The unversity board. */
	@NotBlank
	private String universityBoard;

	/** The percentage CGPA. */
	@NotBlank
	private Double percentageCGPA;

	/** The remarks. */
	private String remarks;

	/** The emp id. */
	@NotBlank
	private long empId;

	/** The status id. */
	private long statusId;

	/** The other course name. */
	private String otherCourseName;
	
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
	 * getter setter.
	 *
	 * @return the emp quali id
	 */

	/**
	 * @return the empQualiId
	 */
	public long getEmpQualiId() {
		return empQualiId;
	}

	/**
	 * Sets the emp quali id.
	 *
	 * @param empQualiId the empQualiId to set
	 */
	public void setEmpQualiId(long empQualiId) {
		this.empQualiId = empQualiId;
	}

	/**
	 * Gets the degree.
	 *
	 * @return the degree
	 */
	public long getDegree() {
		return degree;
	}

	/**
	 * Sets the degree.
	 *
	 * @param degree the degree to set
	 */
	public void setDegree(long degree) {
		this.degree = degree;
	}

	/**
	 * Gets the course name.
	 *
	 * @return the courseName
	 */
	public long getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name.
	 *
	 * @param courseName the courseName to set
	 */
	public void setCourseName(long courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the passing year.
	 *
	 * @return the passingYear
	 */
	public long getPassingYear() {
		return passingYear;
	}

	/**
	 * Sets the passing year.
	 *
	 * @param passingYear the passingYear to set
	 */
	public void setPassingYear(long passingYear) {
		this.passingYear = passingYear;
	}

	/**
	 * Gets the school college.
	 *
	 * @return the schoolCollege
	 */
	public String getSchoolCollege() {
		return schoolCollege;
	}

	/**
	 * Sets the school college.
	 *
	 * @param schoolCollege the schoolCollege to set
	 */
	public void setSchoolCollege(String schoolCollege) {
		this.schoolCollege = schoolCollege;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId to set empId
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the percentage CGPA.
	 *
	 * @return the percentageCGPA
	 */
	public Double getPercentageCGPA() {
		return percentageCGPA;
	}

	/**
	 * Sets the percentage CGPA.
	 *
	 * @param percentageCGPA the percentageCGPA to set
	 */
	public void setPercentageCGPA(Double percentageCGPA) {
		this.percentageCGPA = percentageCGPA;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the university board.
	 *
	 * @return the university board
	 */
	public String getUniversityBoard() {
		return universityBoard;
	}

	/**
	 * Sets the university board.
	 *
	 * @param universityBoard the new university board
	 */
	public void setUniversityBoard(String universityBoard) {
		this.universityBoard = universityBoard;
	}

	/**
	 * Gets the other course name.
	 *
	 * @return the other course name
	 */
	public String getOtherCourseName() {
		return otherCourseName;
	}

	/**
	 * Sets the other course name.
	 *
	 * @param otherCourseName the new other course name
	 */
	public void setOtherCourseName(String otherCourseName) {
		this.otherCourseName = otherCourseName;
	}

	/**
	 * @return the degreeName
	 */
	public String getDegreeName() {
		return degreeName;
	}

	/**
	 * @param degreeName the degreeName to set
	 */
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	/**
	 * @return the courseIdName
	 */
	public String getCourseIdName() {
		return courseIdName;
	}

	/**
	 * @param courseIdName the courseIdName to set
	 */
	public void setCourseIdName(String courseIdName) {
		this.courseIdName = courseIdName;
	}

	/**
	 * @return the passingYearName
	 */
	public String getPassingYearName() {
		return passingYearName;
	}

	/**
	 * @param passingYearName the passingYearName to set
	 */
	public void setPassingYearName(String passingYearName) {
		this.passingYearName = passingYearName;
	}

	/**
	 * PVUEmployeQualificationDto Constructor.
	 */
	public PVUEmployeQualificationDto() {
		super();
	}

	/**
	 * Instantiates a new PVU employe qualification dto.
	 *
	 * @param degree          the degree
	 * @param courseName      the course name
	 * @param passingYear     the passing year
	 * @param schoolCollege   the school college
	 * @param universityBoard the university board
	 * @param percentageCGPA  the percentage CGPA
	 * @param empId           the emp id
	 */
	public PVUEmployeQualificationDto(@NotNull Integer degree, @NotNull long courseName, @NotNull Integer passingYear,
			@NotNull String schoolCollege, @NotNull String universityBoard, @NotNull Double percentageCGPA,
			@NotNull long empId) {
		this.degree = degree;
		this.courseName = courseName;
		this.passingYear = passingYear;
		this.schoolCollege = schoolCollege;
		this.universityBoard = universityBoard;
		this.percentageCGPA = percentageCGPA;
		this.empId = empId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(courseName, degree, empId, empQualiId, otherCourseName, passingYear, percentageCGPA,
				remarks, schoolCollege, statusId, universityBoard);
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
		PVUEmployeQualificationDto other = (PVUEmployeQualificationDto) obj;
		return courseName == other.courseName && degree == other.degree && empId == other.empId
				&& empQualiId == other.empQualiId && Objects.equals(otherCourseName, other.otherCourseName)
				&& passingYear == other.passingYear && Objects.equals(percentageCGPA, other.percentageCGPA)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(schoolCollege, other.schoolCollege)
				&& statusId == other.statusId && Objects.equals(universityBoard, other.universityBoard);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeQualificationDto [empQualiId=" + empQualiId + ", degree=" + degree + ", courseName="
				+ courseName + ", passingYear=" + passingYear + ", schoolCollege=" + schoolCollege
				+ ", universityBoard=" + universityBoard + ", percentageCGPA=" + percentageCGPA + ", remarks=" + remarks
				+ ", empId=" + empId + ", statusId=" + statusId + ", otherCourseName=" + otherCourseName + "]";
	}

}