package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPEmpPostDsgnView.
 */
@NativeQueryResultEntity
public class EDPEmpPostDsgnView implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The request no. */
	@NativeQueryResultColumn(index = 0)
	private String empId;

	/** The district id. */
	@NativeQueryResultColumn(index = 1)
	private String postId;
	
	/** The post name. */
	@NativeQueryResultColumn(index = 2)
	private String postName;
	
	/** The post type. */
	@NativeQueryResultColumn(index = 3)
	private String designationId;

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
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(String postId) {
		this.postId = postId;
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
	 * Gets the designation id.
	 *
	 * @return the designation id
	 */
	public String getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the new designation id
	 */
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empId, postId, postName, designationId);
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
		EDPEmpPostDsgnView other = (EDPEmpPostDsgnView) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(postName, other.postName) 
				&& Objects.equals(postId, other.postId) && Objects.equals(designationId, other.designationId);
	}
	
}
