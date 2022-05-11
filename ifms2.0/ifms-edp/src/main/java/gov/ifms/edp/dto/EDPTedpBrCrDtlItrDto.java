package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;


/**
 * The Class EDPTedpBrCrDtlItrDto.
 */
public class EDPTedpBrCrDtlItrDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tedp br cr dtl id. */
	private Long tedpBrCrDtlId;
	
	/** The tedp br hdr id. */
	private Long tedpBrHdrId;

	/** The branch name. */
	private String branchName;

	/** The branch type id. */
	private Long branchTypeId;
	
	/** The office id. */
	private Long officeId;

	/**
	 * @return the tedpBrCrDtlId
	 */
	public Long getTedpBrCrDtlId() {
		return tedpBrCrDtlId;
	}

	/**
	 * @param tedpBrCrDtlId the tedpBrCrDtlId to set
	 */
	public void setTedpBrCrDtlId(Long tedpBrCrDtlId) {
		this.tedpBrCrDtlId = tedpBrCrDtlId;
	}

	/**
	 * @return the tedpBrHdrId
	 */
	public Long getTedpBrHdrId() {
		return tedpBrHdrId;
	}

	/**
	 * @param tedpBrHdrId the tedpBrHdrId to set
	 */
	public void setTedpBrHdrId(Long tedpBrHdrId) {
		this.tedpBrHdrId = tedpBrHdrId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the branchTypeId
	 */
	public Long getBranchTypeId() {
		return branchTypeId;
	}

	/**
	 * @param branchTypeId the branchTypeId to set
	 */
	public void setBranchTypeId(Long branchTypeId) {
		this.branchTypeId = branchTypeId;
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(branchName, branchTypeId, officeId, tedpBrCrDtlId, tedpBrHdrId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPTedpBrCrDtlItrDto)) {
			return false;
		}
		EDPTedpBrCrDtlItrDto other = (EDPTedpBrCrDtlItrDto) obj;
		return Objects.equals(branchName, other.branchName) && Objects.equals(branchTypeId, other.branchTypeId)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(tedpBrCrDtlId, other.tedpBrCrDtlId)
				&& Objects.equals(tedpBrHdrId, other.tedpBrHdrId);
	}

	
}
