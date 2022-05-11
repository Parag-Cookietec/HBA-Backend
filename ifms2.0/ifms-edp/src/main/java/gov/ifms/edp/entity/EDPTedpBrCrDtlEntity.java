package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPTedpBrCrDtlEntity.
 */
@Entity
@Table(name = "TEDP_BR_CR_DTL", schema = Constant.EDP_SCHEMA)
public class EDPTedpBrCrDtlEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tedp br cr dtl id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_BR_CR_DTL_ID")
	private Long tedpBrCrDtlId;
	
	/** The tedp br hdr id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEDP_BR_HDR_ID", referencedColumnName = "TEDP_BR_HDR_ID")
	private EDPTedpBrHdrEntity tedpBrHdrId;

	/** The branch name. */
	@Column(name = "BRANCH_NAME")
	private String branchName;

	/** The branch type id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity branchTypeId;
	
	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;
	
	/** The branch id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_ID", referencedColumnName = "BRANCH_ID")
	private EDPMsBranchEntity branchId;
	

	/**
	 * Gets the tedp br cr dtl id.
	 *
	 * @return the tedpBrCrDtlId
	 */
	public Long getTedpBrCrDtlId() {
		return tedpBrCrDtlId;
	}

	/**
	 * Sets the tedp br cr dtl id.
	 *
	 * @param tedpBrCrDtlId the tedpBrCrDtlId to set
	 */
	public void setTedpBrCrDtlId(Long tedpBrCrDtlId) {
		this.tedpBrCrDtlId = tedpBrCrDtlId;
	}

	/**
	 * Gets the tedp br hdr id.
	 *
	 * @return the tedpBrHdrId
	 */
	public EDPTedpBrHdrEntity getTedpBrHdrId() {
		return tedpBrHdrId;
	}

	/**
	 * Sets the tedp br hdr id.
	 *
	 * @param tedpBrHdrId the tedpBrHdrId to set
	 */
	public void setTedpBrHdrId(EDPTedpBrHdrEntity tedpBrHdrId) {
		this.tedpBrHdrId = tedpBrHdrId;
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
	 * Gets the branch type id.
	 *
	 * @return the branchTypeId
	 */
	public EDPLuLookUpInfoEntity getBranchTypeId() {
		return branchTypeId;
	}

	/**
	 * Sets the branch type id.
	 *
	 * @param branchTypeId the branchTypeId to set
	 */
	public void setBranchTypeId(EDPLuLookUpInfoEntity branchTypeId) {
		this.branchTypeId = branchTypeId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the branchId
	 */
	public EDPMsBranchEntity getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(EDPMsBranchEntity branchId) {
		this.branchId = branchId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branchId, branchName, branchTypeId, officeId, tedpBrCrDtlId, tedpBrHdrId);
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
		if (!(obj instanceof EDPTedpBrCrDtlEntity)) {
			return false;
		}
		EDPTedpBrCrDtlEntity other = (EDPTedpBrCrDtlEntity) obj;
		return Objects.equals(branchId, other.branchId) && Objects.equals(branchName, other.branchName)
				&& Objects.equals(branchTypeId, other.branchTypeId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(tedpBrCrDtlId, other.tedpBrCrDtlId) && Objects.equals(tedpBrHdrId, other.tedpBrHdrId);
	}
	
}
