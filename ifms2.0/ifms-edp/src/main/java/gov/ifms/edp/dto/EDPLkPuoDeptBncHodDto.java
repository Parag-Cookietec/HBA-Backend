package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLkPuoDeptBncHodDto.
 * 
 * @version 1.0
 * @created 2019/12/19 12:31:18
 *
 */
public class EDPLkPuoDeptBncHodDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk puo dept bpn. */
	private Long lkPuoDeptBpn;

	/** The post user office id. */
	private Long postUserOfficeId;

	/** The department id. */
	private Long departmentId;

	/** The bpn id. */
	private Long bpnId;

	/** The branch id. */
	private Long branchId;

	/** The hod name id. */
	private Long hodNameId;

	/**
	 * EDPLkPuoDeptBncHodDto Constructor.
	 */
	public EDPLkPuoDeptBncHodDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkPuoDeptBpn, postUserOfficeId, departmentId, bpnId, branchId, hodNameId);
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
		if (!(obj instanceof EDPLkPuoDeptBncHodDto)) {
			return false;
		}

		EDPLkPuoDeptBncHodDto other = (EDPLkPuoDeptBncHodDto) obj;

		return Objects.equals(lkPuoDeptBpn, other.lkPuoDeptBpn)
				&& Objects.equals(postUserOfficeId, other.postUserOfficeId) && Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(bpnId, other.bpnId) && Objects.equals(branchId, other.branchId)
				&& Objects.equals(hodNameId, other.hodNameId);
	}

	/**
	 * getter setter.
	 *
	 * @return the lk puo dept bpn
	 */

	/**
	 * @return the lkPuoDeptBpn
	 */
	public Long getLkPuoDeptBpn() {
		return lkPuoDeptBpn;
	}

	/**
	 * Sets the lk puo dept bpn.
	 *
	 * @param lkPuoDeptBpn the lkPuoDeptBpn to set
	 */
	public void setLkPuoDeptBpn(Long lkPuoDeptBpn) {
		this.lkPuoDeptBpn = lkPuoDeptBpn;
	}

	/**
	 * Gets the post user office id.
	 *
	 * @return the postUserOfficeId
	 */
	public Long getPostUserOfficeId() {
		return postUserOfficeId;
	}

	/**
	 * Sets the post user office id.
	 *
	 * @param postUserOfficeId the postUserOfficeId to set
	 */
	public void setPostUserOfficeId(Long postUserOfficeId) {
		this.postUserOfficeId = postUserOfficeId;
	}

	/**
	 * Gets the department id.
	 *
	 * @return the deptId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param deptId the deptId to set
	 */
	public void setDepartmentId(Long deptId) {
		this.departmentId = deptId;
	}

	/**
	 * Gets the bpn id.
	 *
	 * @return the bpnId
	 */
	public Long getBpnId() {
		return bpnId;
	}

	/**
	 * Sets the bpn id.
	 *
	 * @param bpnId the bpnId to set
	 */
	public void setBpnId(Long bpnId) {
		this.bpnId = bpnId;
	}

	/**
	 * Gets the branch id.
	 *
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * Gets the hod name id.
	 *
	 * @return the hodNameId
	 */
	public Long getHodNameId() {
		return hodNameId;
	}

	/**
	 * Sets the hod name id.
	 *
	 * @param hodNameId the hodNameId to set
	 */
	public void setHodNameId(Long hodNameId) {
		this.hodNameId = hodNameId;
	}

}
