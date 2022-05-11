package gov.ifms.loc.workflow.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class WfRequestDto
 */
public class WfUserRequestDtoV3 implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The menu id. */
	@NotNull
	private Long menuId;
	
	/** The wf action config id. */
	@NotNull
	private Long wfActionConfigId;

	/** The office id. */
	private Long officeId;

	/** The branch id. */
	private Long branchId;

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the wf action config id.
	 *
	 * @return the wf action config id
	 */
	public Long getWfActionConfigId() {
		return wfActionConfigId;
	}

	/**
	 * Sets the wf action config id.
	 *
	 * @param wfActionConfigId the new wf action config id
	 */
	public void setWfActionConfigId(Long wfActionConfigId) {
		this.wfActionConfigId = wfActionConfigId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the branch id.
	 *
	 * @return the branch id
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the new branch id
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfUserRequestDtoV3 that = (WfUserRequestDtoV3) o;
		return Objects.equals(menuId, that.menuId) && Objects.equals(wfActionConfigId, that.wfActionConfigId) && Objects.equals(officeId, that.officeId) && Objects.equals(branchId, that.branchId);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(menuId, wfActionConfigId, officeId, branchId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String
	toString() {
		final StringBuilder sb = new StringBuilder("WfUserRequestDtoV3{");
		sb.append("menuId=").append(menuId);
		sb.append(", wfActionConfigId=").append(wfActionConfigId);
		sb.append(", officeId=").append(officeId);
		sb.append(", branchId=").append(branchId);
		sb.append('}');
		return sb.toString();
	}
}
