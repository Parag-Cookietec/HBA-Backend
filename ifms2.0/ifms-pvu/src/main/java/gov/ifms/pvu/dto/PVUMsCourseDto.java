package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUMsCourseDto.
 * 
 * @version v 1.0
 * @created 2020/01/01 02:52:33
 *
 */
public class PVUMsCourseDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The course id. */
	private long courseId;

	/** The course name. */
	private String courseName;

	/** The course name guj. */
	private String courseNameGuj;

	/** The course desc. */
	private String courseDesc;

	/** The course desc guj. */
	private String courseDescGuj;

	/** The course code. */
	private String courseCode;

	/** The course code guj. */
	private String courseCodeGuj;

	/** The course code name. */
	private String courseCodeName;

	/** The course type id. */
	private long courseTypeId;

	/** The parent course id. */
	private long parentCourseId;

	/** The course category. */
	private long courseCategory;

	/** The is CCC exempted. */
	private int isCCCExempted;

	/**
	 * PVUMsCourseDto Constructor.
	 */
	public PVUMsCourseDto() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the course id
	 */

	/**
	 * @return the courseId
	 */
	public long getCourseId() {
		return courseId;
	}

	/**
	 * Sets the course id.
	 *
	 * @param courseId the courseId to set
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * Gets the course name.
	 *
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name.
	 *
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the course name guj.
	 *
	 * @return the courseNameGuj
	 */
	public String getCourseNameGuj() {
		return courseNameGuj;
	}

	/**
	 * Sets the course name guj.
	 *
	 * @param courseNameGuj the courseNameGuj to set
	 */
	public void setCourseNameGuj(String courseNameGuj) {
		this.courseNameGuj = courseNameGuj;
	}

	/**
	 * Gets the course desc.
	 *
	 * @return the courseDesc
	 */
	public String getCourseDesc() {
		return courseDesc;
	}

	/**
	 * Sets the course desc.
	 *
	 * @param courseDesc the courseDesc to set
	 */
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	/**
	 * Gets the course desc guj.
	 *
	 * @return the courseDescGuj
	 */
	public String getCourseDescGuj() {
		return courseDescGuj;
	}

	/**
	 * Sets the course desc guj.
	 *
	 * @param courseDescGuj the courseDescGuj to set
	 */
	public void setCourseDescGuj(String courseDescGuj) {
		this.courseDescGuj = courseDescGuj;
	}

	/**
	 * Gets the course code.
	 *
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * Sets the course code.
	 *
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Gets the course code guj.
	 *
	 * @return the courseCodeGuj
	 */
	public String getCourseCodeGuj() {
		return courseCodeGuj;
	}

	/**
	 * Sets the course code guj.
	 *
	 * @param courseCodeGuj the courseCodeGuj to set
	 */
	public void setCourseCodeGuj(String courseCodeGuj) {
		this.courseCodeGuj = courseCodeGuj;
	}

	/**
	 * Gets the course code name.
	 *
	 * @return the courseCodeName
	 */
	public String getCourseCodeName() {
		return courseCodeName;
	}

	/**
	 * Sets the course code name.
	 *
	 * @param courseCodeName the courseCodeName to set
	 */
	public void setCourseCodeName(String courseCodeName) {
		this.courseCodeName = courseCodeName;
	}

	/**
	 * Gets the course type id.
	 *
	 * @return the courseTypeId
	 */
	public long getCourseTypeId() {
		return courseTypeId;
	}

	/**
	 * Sets the course type id.
	 *
	 * @param courseTypeId the courseTypeId to set
	 */
	public void setCourseTypeId(long courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	/**
	 * Gets the parent course id.
	 *
	 * @return the parentCourseId
	 */
	public long getParentCourseId() {
		return parentCourseId;
	}

	/**
	 * Sets the parent course id.
	 *
	 * @param parentCourseId the parentCourseId to set
	 */
	public void setParentCourseId(long parentCourseId) {
		this.parentCourseId = parentCourseId;
	}

	/**
	 * Gets the course category.
	 *
	 * @return the course category
	 */
	public long getCourseCategory() {
		return courseCategory;
	}

	/**
	 * Sets the course category.
	 *
	 * @param courseCategory the new course category
	 */
	public void setCourseCategory(long courseCategory) {
		this.courseCategory = courseCategory;
	}

	/**
	 * Gets the checks if is CCC exempted.
	 *
	 * @return the checks if is CCC exempted
	 */
	public int getIsCCCExempted() {
		return isCCCExempted;
	}

	/**
	 * Sets the checks if is CCC exempted.
	 *
	 * @param isCCCExempted the new checks if is CCC exempted
	 */
	public void setIsCCCExempted(int isCCCExempted) {
		this.isCCCExempted = isCCCExempted;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(courseCategory, courseCode, courseCodeGuj, courseCodeName, courseDesc, courseDescGuj,
				courseId, courseName, courseNameGuj, courseTypeId, isCCCExempted, parentCourseId);
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
		PVUMsCourseDto other = (PVUMsCourseDto) obj;
		return courseCategory == other.courseCategory && Objects.equals(courseCode, other.courseCode)
				&& Objects.equals(courseCodeGuj, other.courseCodeGuj)
				&& Objects.equals(courseCodeName, other.courseCodeName) && Objects.equals(courseDesc, other.courseDesc)
				&& Objects.equals(courseDescGuj, other.courseDescGuj) && courseId == other.courseId
				&& Objects.equals(courseName, other.courseName) && Objects.equals(courseNameGuj, other.courseNameGuj)
				&& courseTypeId == other.courseTypeId && isCCCExempted == other.isCCCExempted
				&& parentCourseId == other.parentCourseId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsCourseDto [courseId=" + courseId + ", courseName=" + courseName + ", courseNameGuj="
				+ courseNameGuj + ", courseDesc=" + courseDesc + ", courseDescGuj=" + courseDescGuj + ", courseCode="
				+ courseCode + ", courseCodeGuj=" + courseCodeGuj + ", courseCodeName=" + courseCodeName
				+ ", courseTypeId=" + courseTypeId + ", parentCourseId=" + parentCourseId + ", courseCategory="
				+ courseCategory + ", isCCCExempted=" + isCCCExempted + "]";
	}

}
