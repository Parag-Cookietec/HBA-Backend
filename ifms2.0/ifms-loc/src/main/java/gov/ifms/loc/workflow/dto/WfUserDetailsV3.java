package gov.ifms.loc.workflow.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class WfUserDetailsV3.
 */
public class WfUserDetailsV3 implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

    /** The pou id. */
    private Long pouId;

    /** The office id. */
    private Long officeId;

    /** The branch id. */
    private Long branchId;

	/**
	 * Gets the pou id.
	 *
	 * @return the pou id
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the new pou id
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
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
		WfUserDetailsV3 that = (WfUserDetailsV3) o;
		return Objects.equals(pouId, that.pouId) && Objects.equals(officeId, that.officeId) && Objects.equals(branchId, that.branchId);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(pouId, officeId, branchId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("WfUserDetailsV3{");
		sb.append("pouId=").append(pouId);
		sb.append(", officeId=").append(officeId);
		sb.append(", branchId=").append(branchId);
		sb.append('}');
		return sb.toString();
	}
}
