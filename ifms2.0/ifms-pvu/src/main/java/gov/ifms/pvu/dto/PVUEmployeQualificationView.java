package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeQualificationDto.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:11:13
 *
 */
@NativeQueryResultEntity
public class PVUEmployeQualificationView implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp quali id. */
	@NativeQueryResultColumn(index = 0)
	private String empQualiId;

	@NativeQueryResultColumn(index = 1)
	private String degreeName;

	@NativeQueryResultColumn(index = 2)
	private String courseName;

	@NativeQueryResultColumn(index = 3)
	private String passingYear;

	@NativeQueryResultColumn(index = 4)
	private String schoolCollege;

	@NativeQueryResultColumn(index = 5)
	private String universityBoard;

	@NativeQueryResultColumn(index = 6)
	private String percentageCGPA;

	@NativeQueryResultColumn(index = 7)
	private String remarks;

	@NativeQueryResultColumn(index = 8)
	private String updateByUpdateDate;

	@NativeQueryResultColumn(index = 9)
	private String updateByUserCode;

	@NativeQueryResultColumn(index = 10)
	private String updateByUserName;

	@NativeQueryResultColumn(index = 11)
	private String updateByPostName;

	@NativeQueryResultColumn(index = 12)
	private String officeName;

	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	@NativeQueryResultColumn(index = 13)
	private String changeType ;


	@NativeQueryResultColumn(index = 14)
	private String courseId ;

	@NativeQueryResultColumn(index = 15)
	private String  otherCourseName;


	/**
	 * @return the empQualiId
	 */
	public String getEmpQualiId() {
		return empQualiId;
	}

	/**
	 * @param empQualiId the empQualiId to set
	 */
	public void setEmpQualiId(String empQualiId) {
		this.empQualiId = empQualiId;
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
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the passingYear
	 */
	public String getPassingYear() {
		return passingYear;
	}

	/**
	 * @param passingYear the passingYear to set
	 */
	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}

	/**
	 * @return the schoolCollege
	 */
	public String getSchoolCollege() {
		return schoolCollege;
	}

	/**
	 * @param schoolCollege the schoolCollege to set
	 */
	public void setSchoolCollege(String schoolCollege) {
		this.schoolCollege = PvuUtils.ternaryOperator(schoolCollege);
	}

	/**
	 * @return the universityBoard
	 */
	public String getUniversityBoard() {
		return universityBoard;
	}

	/**
	 * @param universityBoard the universityBoard to set
	 */
	public void setUniversityBoard(String universityBoard) {
		this.universityBoard = universityBoard;
	}

	/**
	 * @return the percentageCGPA
	 */
	public String getPercentageCGPA() {
		return percentageCGPA;
	}

	/**
	 * @param percentageCGPA the percentageCGPA to set
	 */
	public void setPercentageCGPA(String percentageCGPA) {
		this.percentageCGPA = percentageCGPA;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = PvuUtils.ternaryOperator(remarks);
	}

	/**
	 * @return the updateByUpdateDate
	 */
	public String getUpdateByUpdateDate() {
		return updateByUpdateDate;
	}

	/**
	 * @param updateByUpdateDate the updateByUpdateDate to set
	 */
	public void setUpdateByUpdateDate(String updateByUpdateDate) {
		this.updateByUpdateDate = updateByUpdateDate;
	}

	/**
	 * @return the updateByUserCode
	 */
	public String getUpdateByUserCode() {
		return updateByUserCode;
	}

	/**
	 * @param updateByUserCode the updateByUserCode to set
	 */
	public void setUpdateByUserCode(String updateByUserCode) {
		this.updateByUserCode = updateByUserCode;
	}

	/**
	 * @return the updateByUserName
	 */
	public String getUpdateByUserName() {
		return updateByUserName;
	}

	/**
	 * @param updateByUserName the updateByUserName to set
	 */
	public void setUpdateByUserName(String updateByUserName) {
		this.updateByUserName = updateByUserName;
	}

	/**
	 * @return the updateByPostName
	 */
	public String getUpdateByPostName() {
		return updateByPostName;
	}

	/**
	 * @param updateByPostName the updateByPostName to set
	 */
	public void setUpdateByPostName(String updateByPostName) {
		this.updateByPostName = updateByPostName;
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
	 * @return the changeType
	 */
	public String getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getOtherCourseName() {
		return otherCourseName;
	}

	public void setOtherCourseName(String otherCourseName) {
		this.otherCourseName = otherCourseName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
}