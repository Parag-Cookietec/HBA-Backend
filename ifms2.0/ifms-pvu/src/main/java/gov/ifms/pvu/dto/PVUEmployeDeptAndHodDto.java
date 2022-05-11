package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeDeptAndHodDto.
 * 
 * @version v 1.0
 * @created 2020/01/10 16:26:19
 *
 */
public class PVUEmployeDeptAndHodDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String deptHodId;

	private Long departmentId;

	private Long hodId;

	/**
	 * PVUEmployeDeptAndHodDto Constructor
	 */
	public PVUEmployeDeptAndHodDto() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(deptHodId, departmentId, hodId);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUEmployeDeptAndHodDto)) {
			return false;
		}

		PVUEmployeDeptAndHodDto other = (PVUEmployeDeptAndHodDto) obj;

		return Objects.equals(deptHodId, other.deptHodId) && Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(hodId, other.hodId);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "PVUEmployeDeptAndHodDto [deptHodId = " + deptHodId + ",departmentId = " + departmentId + ",hodId = "
				+ hodId + ",]";
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the deptHodId
	 */
	public String getDeptHodId() {
		return deptHodId;
	}

	/**
	 * @param deptHodId the deptHodId to set
	 */
	public void setDeptHodId(String deptHodId) {
		this.deptHodId = deptHodId;
	}

	/**
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the hodId
	 */
	public Long getHodId() {
		return hodId;
	}

	/**
	 * @param hodId the hodId to set
	 */
	public void setHodId(Long hodId) {
		this.hodId = hodId;
	}

}
