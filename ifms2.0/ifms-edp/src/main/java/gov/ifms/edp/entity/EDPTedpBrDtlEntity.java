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
 * The Class EDPTedpBrDtlEntity.
 */
@Entity
@Table(name = "TEDP_BR_DTL", schema = Constant.EDP_SCHEMA)
public class EDPTedpBrDtlEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tedp br dtl id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_BR_DTL_ID")
	private Long tedpBrDtlId;

    /** The from po off user id. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FROM_POU_ID", referencedColumnName = "LK_PO_OFF_USER_ID")
    private EDPLkPoOffUserEntity fromPouId;
    
    /** The to po off user id. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TO_POU_ID", referencedColumnName = "LK_PO_OFF_USER_ID")
    private EDPLkPoOffUserEntity toPouId;

	/** The branch id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_ID", referencedColumnName = "BRANCH_ID")
	private EDPMsBranchEntity branchId;
	
	/** The tedp br hdr id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEDP_BR_HDR_ID", referencedColumnName = "TEDP_BR_HDR_ID")
	private EDPTedpBrHdrEntity tedpBrHdrId;

	/**
	 * Gets the tedp br dtl id.
	 *
	 * @return the tedp br dtl id
	 */
	public Long getTedpBrDtlId() {
		return tedpBrDtlId;
	}

	/**
	 * Sets the tedp br dtl id.
	 *
	 * @param tedpBrDtlId the new tedp br dtl id
	 */
	public void setTedpBrDtlId(Long tedpBrDtlId) {
		this.tedpBrDtlId = tedpBrDtlId;
	}

	/**
	 * Gets the from pou id.
	 *
	 * @return the from pou id
	 */
	public EDPLkPoOffUserEntity getFromPouId() {
		return fromPouId;
	}

	/**
	 * Sets the from pou id.
	 *
	 * @param fromPouId the new from pou id
	 */
	public void setFromPouId(EDPLkPoOffUserEntity fromPouId) {
		this.fromPouId = fromPouId;
	}

	/**
	 * Gets the to pou id.
	 *
	 * @return the to pou id
	 */
	public EDPLkPoOffUserEntity getToPouId() {
		return toPouId;
	}

	/**
	 * Sets the to pou id.
	 *
	 * @param toPouId the new to pou id
	 */
	public void setToPouId(EDPLkPoOffUserEntity toPouId) {
		this.toPouId = toPouId;
	}

	/**
	 * Gets the branch id.
	 *
	 * @return the branch id
	 */
	public EDPMsBranchEntity getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the new branch id
	 */
	public void setBranchId(EDPMsBranchEntity branchId) {
		this.branchId = branchId;
	}

	/**
	 * Gets the tedp br hdr id.
	 *
	 * @return the tedp br hdr id
	 */
	public EDPTedpBrHdrEntity getTedpBrHdrId() {
		return tedpBrHdrId;
	}

	/**
	 * Sets the tedp br hdr id.
	 *
	 * @param tedpBrHdrId the new tedp br hdr id
	 */
	public void setTedpBrHdrId(EDPTedpBrHdrEntity tedpBrHdrId) {
		this.tedpBrHdrId = tedpBrHdrId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(tedpBrDtlId, fromPouId, toPouId, branchId, tedpBrHdrId);
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
		EDPTedpBrDtlEntity other = (EDPTedpBrDtlEntity) obj;
		return Objects.equals(tedpBrDtlId, other.tedpBrDtlId) && Objects.equals(fromPouId, other.fromPouId)
				&& Objects.equals(toPouId, other.toPouId) && Objects.equals(branchId, other.branchId)
				&& Objects.equals(tedpBrHdrId, other.tedpBrHdrId);
				
	}
	
}
