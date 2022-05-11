package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPTedpBrDtlDto.
 */
public class EDPBrDtlDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The to post office user id. */
	private Long postOfficeUserId;

	/** The emp no. */
	private String empNo;

	/** The emp name. */
	private String empName;
	
	/** The post name. */
	private String postName;

	/** The mapped branches. */
	private List<Long> mappedBranches;


	public Long getPostOfficeUserId() {
		return postOfficeUserId;
	}

	public void setPostOfficeUserId(Long postOfficeUserId) {
		this.postOfficeUserId = postOfficeUserId;
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
	 * Gets the mapped branches.
	 *
	 * @return the mapped branches
	 */
	public List<Long> getMappedBranches() {
		return mappedBranches;
	}

	/**
	 * Sets the mapped branches.
	 *
	 * @param mappedBranches the new mapped branches
	 */
	public void setMappedBranches(List<Long> mappedBranches) {
		this.mappedBranches = mappedBranches;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash( postOfficeUserId, empName, empNo, mappedBranches, postName);
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPBrDtlDto other = (EDPBrDtlDto) obj;
		return  Objects.equals(empName, other.empName) && Objects.equals(empNo, other.empNo)
				&& Objects.equals(mappedBranches, other.mappedBranches) && Objects.equals(postName, other.postName)
				&& Objects.equals(postOfficeUserId, other.postOfficeUserId); 
	}

}
