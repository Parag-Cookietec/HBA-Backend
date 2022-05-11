package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPEmployeePostSearchView.
 */
@NativeQueryResultEntity
public class EDPEmployeePostSearchView extends BaseDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The request no. */
	@NativeQueryResultColumn(index = 0)
	private String empNo;

	/** The district id. */
	@NativeQueryResultColumn(index = 1)
	private String empName;
	
	/** The post name. */
	@NativeQueryResultColumn(index = 2)
	private String postName;
	
	/** The post type. */
	@NativeQueryResultColumn(index = 3)
	private String postType;
	
	/** The user id. */
	@NativeQueryResultColumn(index = 4)
	private String userId;
	
	/** The office id. */
	@NativeQueryResultColumn(index = 5)
	private String officeId;
	
	/** The emp id. */
	@NativeQueryResultColumn(index = 6)
	private String empId;
	
	/** The post office id. */
	@NativeQueryResultColumn(index = 7)
	private String postOfficeId;
	
	/** The post office user id. */
	@NativeQueryResultColumn(index = 8)
	private String postOfficeUserId;
	
	/** The post office user id. */
	@NativeQueryResultColumn(index = 9)
	private String statusId;

	@NativeQueryResultColumn(index = 10)
	private String postId;

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	
	/**
	 * Gets the emp name.
	 *
	 * @return the emp name
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the new emp name
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	
	/**
	 * Gets the post type.
	 *
	 * @return the post type
	 */
	public String getPostType() {
		return postType;
	}

	/**
	 * Sets the post type.
	 *
	 * @param postType the new post type
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public String getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * Gets the post office id.
	 *
	 * @return the post office id
	 */
	public String getPostOfficeId() {
		return postOfficeId;
	}

	/**
	 * Sets the post office id.
	 *
	 * @param postOfficeId the new post office id
	 */
	public void setPostOfficeId(String postOfficeId) {
		this.postOfficeId = postOfficeId;
	}

	/**
	 * Gets the post office user id.
	 *
	 * @return the post office user id
	 */
	public String getPostOfficeUserId() {
		return postOfficeUserId;
	}
	
	/**
	 * Gets the post name.
	 *
	 * @return the post name
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the new post name
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}


	/**
	 * Sets the post office user id.
	 *
	 * @param postOfficeUserId the new post office user id
	 */
	public void setPostOfficeUserId(String postOfficeUserId) {
		this.postOfficeUserId = postOfficeUserId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPEmployeePostSearchView [empNo=" + empNo + ", empName=" + empName + ", postName=" + postName
				+ ", postType=" + postType + ", userId=" + userId + ", officeId=" + officeId + ", empId=" + empId
				+ ", postOfficeId=" + postOfficeId + ", postOfficeUserId=" + postOfficeUserId + " , statusId=" + statusId + "]";
	}
	
	/**
	 * Gets the emp no.
	 *
	 * @return the emp no
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the new emp no
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empId, empName, empNo, officeId, postName, postOfficeId, postOfficeUserId, postType,
				userId, statusId);
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
		EDPEmployeePostSearchView other = (EDPEmployeePostSearchView) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(empName, other.empName)
				&& Objects.equals(empNo, other.empNo) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(postName, other.postName) && Objects.equals(postOfficeId, other.postOfficeId)
				&& Objects.equals(postOfficeUserId, other.postOfficeUserId) && Objects.equals(postType, other.postType)
				&& Objects.equals(userId, other.userId) && Objects.equals(postId, other.postId);
	}

	/**
	 * Instantiates a new EDP employee post search view.
	 */
	public EDPEmployeePostSearchView() {
		super();
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	
}
