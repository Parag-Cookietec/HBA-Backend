package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;



/**
 * The Class LocChequeCancelDtlEntity.
 *
 * @version v 1.0
 * @created 2021/03/06 17:42:56
 */
@Entity
@Table(name = "TLOC_CHEQUE_CANCEL_DTL", schema = LocConstant.LOC_SCHEMA)
public class LocChequeCancelDtlEntity extends BaseEntity implements Serializable {


    /** The serialVersionUID. */
    private static final long serialVersionUID = 1L;


    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TLOC_CHEQUE_CANCEL_DTL_ID")
    private String id;

    /** The hdr id. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TLOC_CHEQUE_CANCEL_HDR_ID", referencedColumnName = "CHEQUE_CANCELLATION_ID")
    private LocChequeCancelHdrEntity hdrId;

    /** The advice id. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TLOC_ADVICE_HDR_ID", referencedColumnName = "TLOC_ADVICE_HDR_ID")
    private LocAdvicePrepHdrEntity adviceId;

    /** The head wise id. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LC_ADVICE_HEADWISE_ID", referencedColumnName = "LC_ADVICE_HEADWISE_ID")
    private LocAdvicePartHeadwisedetaisEntity headWiseId;

    /** The head cancel chq amt. */
    @Column(name = "HEAD_CANCEL_CHEQUE_AMT")
    private Double headCancelChqAmt;

    /** The status id. */
    @Column(name = "STATUS_ID")
    private String statusId;

    /** The wf id. */
    @Column(name = "WF_ID")
    private String wfId;

    /** The wf role id. */
    @Column(name = "WF_ROLE_ID")
    private String wfRoleId;


    /**
     * LocChequeCancelDtlEntity Constructor.
     */
    public LocChequeCancelDtlEntity() {
        super();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the hdr id.
     *
     * @return the hdr id
     */
    public LocChequeCancelHdrEntity getHdrId() {
        return hdrId;
    }

    /**
     * Sets the hdr id.
     *
     * @param hdrId the new hdr id
     */
    public void setHdrId(LocChequeCancelHdrEntity hdrId) {
        this.hdrId = hdrId;
    }

    /**
     * Gets the advice id.
     *
     * @return the advice id
     */
    public LocAdvicePrepHdrEntity getAdviceId() {
        return adviceId;
    }

    /**
     * Sets the advice id.
     *
     * @param adviceId the new advice id
     */
    public void setAdviceId(LocAdvicePrepHdrEntity adviceId) {
        this.adviceId = adviceId;
    }

  
   

    /**
     * Gets the head wise id.
     *
     * @return the headWiseId
     */
	public LocAdvicePartHeadwisedetaisEntity getHeadWiseId() {
		return headWiseId;
	}

	/**
	 * Sets the head wise id.
	 *
	 * @param headWiseId the headWiseId to set
	 */
	public void setHeadWiseId(LocAdvicePartHeadwisedetaisEntity headWiseId) {
		this.headWiseId = headWiseId;
	}

	/**
	 * Gets the head cancel chq amt.
	 *
	 * @return the headCancelChqAmt
	 */
	public Double getHeadCancelChqAmt() {
		return headCancelChqAmt;
	}

	/**
	 * Sets the head cancel chq amt.
	 *
	 * @param headCancelChqAmt the headCancelChqAmt to set
	 */
	public void setHeadCancelChqAmt(Double headCancelChqAmt) {
		this.headCancelChqAmt = headCancelChqAmt;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public String getStatusId() {
        return statusId;
    }

    /**
     * Sets the status id.
     *
     * @param statusId the new status id
     */
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    /**
     * Gets the wf id.
     *
     * @return the wf id
     */
    public String getWfId() {
        return wfId;
    }

    /**
     * Sets the wf id.
     *
     * @param wfId the new wf id
     */
    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    /**
     * Gets the wf role id.
     *
     * @return the wf role id
     */
    public String getWfRoleId() {
        return wfRoleId;
    }

    /**
     * Sets the wf role id.
     *
     * @param wfRoleId the new wf role id
     */
    public void setWfRoleId(String wfRoleId) {
        this.wfRoleId = wfRoleId;
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
        if (!(o instanceof LocChequeCancelDtlEntity)) return false;
        LocChequeCancelDtlEntity that = (LocChequeCancelDtlEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getHdrId(), that.getHdrId()) && Objects.equals(getAdviceId(), that.getAdviceId()) && Objects.equals(getHeadWiseId(), that.getHeadWiseId()) && Objects.equals(getHeadCancelChqAmt(), that.getHeadCancelChqAmt()) && Objects.equals(getStatusId(), that.getStatusId()) && Objects.equals(getWfId(), that.getWfId()) && Objects.equals(getWfRoleId(), that.getWfRoleId());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHdrId(), getAdviceId(), getHeadWiseId(), getHeadCancelChqAmt(), getStatusId(), getWfId(), getWfRoleId());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "LocChequeCancelDtlEntity{" +
                "id='" + id + '\'' +
                ", hdrId=" + hdrId +
                ", adviceId=" + adviceId +
                ", headWiseId=" + headWiseId +
                ", headCancelChqAmt='" + headCancelChqAmt + '\'' +
                ", statusId='" + statusId + '\'' +
                ", wfId='" + wfId + '\'' +
                ", wfRoleId='" + wfRoleId + '\'' +
                '}';
    }
}
