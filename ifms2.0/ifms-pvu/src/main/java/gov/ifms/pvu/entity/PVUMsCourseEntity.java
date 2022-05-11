package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUMsCourseEntity.
 * 
 * @version v 1.0
 * @created 2020/01/01 02:52:33
 *
 */
@Entity
@Table(name = "MS_COURSE", schema = Constant.EDP_MASTER_SCHEMA)
public class PVUMsCourseEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The course id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID")
	private long courseId;

	/** The course name. */
	@Column(name = "COURSE_NAME")
	private String courseName;

	/** The course name guj. */
	@Column(name = "COURSE_NAME_GUJ")
	private String courseNameGuj;

	/** The course desc. */
	@Column(name = "COURSE_DESC")
	private String courseDesc;

	/** The course desc guj. */
	@Column(name = "COURSE_DESC_GUJ")
	private String courseDescGuj;

	/** The course code. */
	@Column(name = "COURSE_CODE")
	private String courseCode;

	/** The course code guj. */
	@Column(name = "COURSE_CODE_GUJ")
	private String courseCodeGuj;

	/** The course code name. */
	@Column(name = "COURSE_CODE_NAME")
	private String courseCodeName;

	/** The course type id. */
	@Column(name = "COURSE_TYPE_ID")
	private long courseTypeId;

	/** The parent course id. */
	@Column(name = "PARENT_COURSE_ID")
	private long parentCourseId;

	
	/** The course category. */
	@OneToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "COURSE_CATEGORY", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity courseCategory;
	
	/** The is CCC exempted. */
	@Column(name = "IS_CCC_EXEMPTED")
	private int isCCCExempted;
	
	/**
	 * PVUMsCourseEntity Constructor.
	 *
	 * @param courseId the course id
	 */
	public PVUMsCourseEntity(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * Instantiates a new PVU ms course entity.
	 */
	public PVUMsCourseEntity() {
	}
	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, courseNameGuj, courseDesc, courseDescGuj, courseCode, courseCodeGuj,
				courseCodeName, courseTypeId, parentCourseId);
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
		if (!(obj instanceof PVUMsCourseEntity)) {
			return false;
		}

		PVUMsCourseEntity other = (PVUMsCourseEntity) obj;

		return courseId == other.courseId && Objects.equals(courseName, other.courseName)
				&& Objects.equals(courseNameGuj, other.courseNameGuj) && Objects.equals(courseDesc, other.courseDesc)
				&& Objects.equals(courseDescGuj, other.courseDescGuj) && Objects.equals(courseCode, other.courseCode)
				&& Objects.equals(courseCodeGuj, other.courseCodeGuj)
				&& Objects.equals(courseCodeName, other.courseCodeName) && courseTypeId == other.courseTypeId
				&& parentCourseId == other.parentCourseId;
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsCourseEntity [courseId = " + courseId + ",courseName = " + courseName + ",courseNameGuj = "
				+ courseNameGuj + ",courseDesc = " + courseDesc + ",courseDescGuj = " + courseDescGuj + ",courseCode = "
				+ courseCode + ",courseCodeGuj = " + courseCodeGuj + ",courseCodeName = " + courseCodeName
				+ ",courseTypeId = " + courseTypeId + ",parentCourseId = " + parentCourseId + ",]";
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
	public EDPLuLookUpInfoEntity getCourseCategory() {
		return courseCategory;
	}

	/**
	 * Sets the course category.
	 *
	 * @param courseCategory the new course category
	 */
	public void setCourseCategory(EDPLuLookUpInfoEntity courseCategory) {
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

}
