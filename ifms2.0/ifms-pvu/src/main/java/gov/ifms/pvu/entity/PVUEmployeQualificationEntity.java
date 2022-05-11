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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;

/**
 * The Class PVUEmployeQualificationEntity.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:11:13
 *
 */
@Entity
@Table(name = "T_EMP_QUALI", schema = Constant.PVU_SCHEMA)
public class PVUEmployeQualificationEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp quali id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_QUALI_ID")
	private long empQualiId;

	/** The degree. */
	@OneToOne(optional = false)
	@JoinColumn(name = "SCHOOL_DEGREE", referencedColumnName = "COURSE_ID")
	private PVUMsCourseEntity degree;

	/** The course name. */
	@OneToOne(optional = false)
	@JoinColumn(name = "COURSE_NAME", referencedColumnName = "COURSE_ID")
	private PVUMsCourseEntity courseName;

	/** The passing year. */
	@OneToOne(optional = false)
	@JoinColumn(name = "YEAR_PASSING", referencedColumnName = "FINANCIAL_YEAR_ID")
	private EDPMsFinancialYearEntity passingYear;

	/** The school college. */
	@Column(name = "SCHOOL_COLLEGE")
	private String schoolCollege;

	/** The unversity board. */
	@Column(name = "UNVERSITY_BOARD")
	private String universityBoard;

	/** The percentage CGPA. */
	@Column(name = "PERC_CGPA")
	private Double percentageCGPA;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The pvu employe entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	@Column(name = "OTHER_COURSE_NAME")
	private String otherCourseName;
	
	@Column(name = "CHANGE_TYPE")
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
	public PVUMsCourseEntity getDegree() {
		return degree;
	}

	/**
	 * Sets the degree.
	 *
	 * @param degree the degree to set
	 */
	public void setDegree(PVUMsCourseEntity degree) {
		this.degree = degree;
	}

	/**
	 * Gets the course name.
	 *
	 * @return the courseName
	 */
	public PVUMsCourseEntity getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name.
	 *
	 * @param courseName the courseName to set
	 */
	public void setCourseName(PVUMsCourseEntity courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the passing year.
	 *
	 * @return the passingYear
	 */
	public EDPMsFinancialYearEntity getPassingYear() {
		return passingYear;
	}

	/**
	 * Sets the passing year.
	 *
	 * @param passingYear the passingYear to set
	 */
	public void setPassingYear(EDPMsFinancialYearEntity passingYear) {
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
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the pvu employe entity.
	 *
	 * @return pvuEmployeEntity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the new pvu employe entity
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
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
	 * @return the otherCourseName
	 */
	public String getOtherCourseName() {
		return otherCourseName;
	}

	/**
	 * @param otherCourseName the otherCourseName to set
	 */
	public void setOtherCourseName(String otherCourseName) {
		this.otherCourseName = otherCourseName;
	}

	/**
	 * PVUEmployeQualificationEntity Constructor.
	 */
	public PVUEmployeQualificationEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(courseName, degree, empQualiId, passingYear, percentageCGPA, pvuEmployeEntity, remarks,
				schoolCollege, statusId, universityBoard);
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
		if (!(obj instanceof PVUEmployeQualificationEntity)) {
			return false;
		}
		PVUEmployeQualificationEntity other = (PVUEmployeQualificationEntity) obj;
		return Objects.equals(courseName, other.courseName) && Objects.equals(degree, other.degree)
				&& Objects.equals(empQualiId, other.empQualiId) && Objects.equals(passingYear, other.passingYear)
				&& Objects.equals(percentageCGPA, other.percentageCGPA)
				&& Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(schoolCollege, other.schoolCollege) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(universityBoard, other.universityBoard);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeQualificationEntity [empQualiId=" + empQualiId + ", degree=" + degree + ", courseName="
				+ courseName + ", passingYear=" + passingYear + ", schoolCollege=" + schoolCollege + ", universityBoard="
				+ universityBoard + ", percentageCGPA=" + percentageCGPA + ", remarks=" + remarks + ", pvuEmployeEntity="
				+ pvuEmployeEntity + ", statusId=" + statusId + "]";
	}

}
