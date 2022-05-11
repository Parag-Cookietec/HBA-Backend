package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsBranchDto.
 */
public class EDPMsBranchDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The branch id. */
	private Long branchId;

	/** The branch name. */
	private String branchName;

	/** The branch code. */
	private String branchCode;

	/** The branch code name. */
	private String branchCodeName;

	/** The branch type id. */
	private Long branchTypeId;

	/** The parent branch id. */
	private Long parentBranchId;

	/** The office id. */
	private Long officeId;

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
	 * Gets the branch name.
	 *
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Gets the branch code.
	 *
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * Sets the branch code.
	 *
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * Gets the branch code name.
	 *
	 * @return the branchCodeName
	 */
	public String getBranchCodeName() {
		return branchCodeName;
	}

	/**
	 * Sets the branch code name.
	 *
	 * @param branchCodeName the branchCodeName to set
	 */
	public void setBranchCodeName(String branchCodeName) {
		this.branchCodeName = branchCodeName;
	}

	/**
	 * Gets the branch type id.
	 *
	 * @return the branchTypeId
	 */
	public Long getBranchTypeId() {
		return branchTypeId;
	}

	/**
	 * Sets the branch type id.
	 *
	 * @param branchTypeId the branchTypeId to set
	 */
	public void setBranchTypeId(Long branchTypeId) {
		this.branchTypeId = branchTypeId;
	}

	/**
	 * Gets the parent branch id.
	 *
	 * @return the parentBranchId
	 */
	public Long getParentBranchId() {
		return parentBranchId;
	}

	/**
	 * Sets the parent branch id.
	 *
	 * @param parentBranchId the parentBranchId to set
	 */
	public void setParentBranchId(Long parentBranchId) {
		this.parentBranchId = parentBranchId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branchCode, branchCodeName, branchId, branchName, branchTypeId, officeId, parentBranchId);
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
		if (!(obj instanceof EDPMsBranchDto)) {
			return false;
		}
		EDPMsBranchDto other = (EDPMsBranchDto) obj;
		return Objects.equals(branchCode, other.branchCode) && Objects.equals(branchCodeName, other.branchCodeName)
				&& Objects.equals(branchId, other.branchId) && Objects.equals(branchName, other.branchName)
				&& Objects.equals(branchTypeId, other.branchTypeId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(parentBranchId, other.parentBranchId);
	}
	
}
