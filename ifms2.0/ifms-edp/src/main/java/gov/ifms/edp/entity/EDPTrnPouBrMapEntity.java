package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

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
 * The Class EDPTrnPouBrMapEntity.
 */
@Entity
@Table(name = "TRN_POU_BR_MAP", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPTrnPouBrMapEntity extends  BaseEntity implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;


    /** The trn pou br map id. */
    @Id
    @Column(name = "TRN_POU_BR_MAP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trnPouBrMapId;

    /** The edp lk po off user id. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LK_PO_OFF_USER_ID", referencedColumnName = "LK_PO_OFF_USER_ID")
    private EDPLkPoOffUserEntity edpLkPoOffUserId;

    /** The edp ms branch entity. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_ID", referencedColumnName = "BRANCH_ID")
    private EDPMsBranchEntity edpMsBranchEntity;

    /** The tr from POU id. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TR_FROM_POU_ID", referencedColumnName = "LK_PO_OFF_USER_ID")
    private EDPLkPoOffUserEntity trFromPOUId;


    /**
     * Gets the trn pou br map id.
     *
     * @return the trn pou br map id
     */
    public long getTrnPouBrMapId() {
        return trnPouBrMapId;
    }

    /**
     * Sets the trn pou br map id.
     *
     * @param trnPouBrMapId the new trn pou br map id
     */
    public void setTrnPouBrMapId(long trnPouBrMapId) {
        this.trnPouBrMapId = trnPouBrMapId;
    }

    /**
     * Gets the edp lk po off user id.
     *
     * @return the edp lk po off user id
     */
    public EDPLkPoOffUserEntity getEdpLkPoOffUserId() {
        return edpLkPoOffUserId;
    }

    /**
     * Sets the edp lk po off user id.
     *
     * @param edpLkPoOffUserId the new edp lk po off user id
     */
    public void setEdpLkPoOffUserId(EDPLkPoOffUserEntity edpLkPoOffUserId) {
        this.edpLkPoOffUserId = edpLkPoOffUserId;
    }

    /**
     * Gets the edp ms branch entity.
     *
     * @return the edp ms branch entity
     */
    public EDPMsBranchEntity getEdpMsBranchEntity() {
        return edpMsBranchEntity;
    }

    /**
     * Sets the edp ms branch entity.
     *
     * @param edpMsBranchEntity the new edp ms branch entity
     */
    public void setEdpMsBranchEntity(EDPMsBranchEntity edpMsBranchEntity) {
        this.edpMsBranchEntity = edpMsBranchEntity;
    }

    /**
     * Gets the tr from POU id.
     *
     * @return the tr from POU id
     */
    public EDPLkPoOffUserEntity getTrFromPOUId() {
		return trFromPOUId;
	}

	/**
	 * Sets the tr from POU id.
	 *
	 * @param trFromPOUId the new tr from POU id
	 */
	public void setTrFromPOUId(EDPLkPoOffUserEntity trFromPOUId) {
		this.trFromPOUId = trFromPOUId;
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
        EDPTrnPouBrMapEntity that = (EDPTrnPouBrMapEntity) o;
        return trnPouBrMapId == that.trnPouBrMapId &&
                Objects.equals(edpLkPoOffUserId, that.edpLkPoOffUserId) &&
                Objects.equals(edpMsBranchEntity, that.edpMsBranchEntity) &&
                Objects.equals(trFromPOUId, that.trFromPOUId);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(trnPouBrMapId, edpLkPoOffUserId, edpMsBranchEntity, trFromPOUId);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", EDPTrnPouBrMapEntity.class.getSimpleName() + "[", "]")
                .add("trnPouBrMapId=" + trnPouBrMapId)
                .add("edpLkPoOffUserId=" + edpLkPoOffUserId)
                .add("edpMsBranchEntity=" + edpMsBranchEntity)
                .add("trFromPOUId=" + trFromPOUId)
                .toString();
    }
}
