package gov.ifms.pvu.dto;

import java.util.Objects;

/**
 * The Class PvuCommonRequest.
 */
public class PvusixthPayCommissionRequest {

	private String commissionId;
	
	private String deptCategoryId;

	/**
	 * @return the commissionId
	 */
	public String getCommissionId() {
		return commissionId;
	}

	/**
	 * @param commissionId the commissionId to set
	 */
	public void setCommissionId(String commissionId) {
		this.commissionId = commissionId;
	}

	/**
	 * @return the deptCategoryId
	 */
	public String getDeptCategoryId() {
		return deptCategoryId;
	}

	/**
	 * @param deptCategoryId the deptCategoryId to set
	 */
	public void setDeptCategoryId(String deptCategoryId) {
		this.deptCategoryId = deptCategoryId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commissionId, deptCategoryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PvusixthPayCommissionRequest other = (PvusixthPayCommissionRequest) obj;
		return Objects.equals(commissionId, other.commissionId) && Objects.equals(deptCategoryId, other.deptCategoryId);
	}
	
	
	
}
