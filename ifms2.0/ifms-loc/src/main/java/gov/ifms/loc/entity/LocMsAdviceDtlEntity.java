package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocDBConstants;

import javax.persistence.*;

/**
 * The Class LocMsAdviceDtlEntity.
 */
@Entity
@Table(name = "LC_MS_ADVICE_DETAIL", schema = LocDBConstants.LOC_SCHEMA)
public class LocMsAdviceDtlEntity extends BaseEntity {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The advice id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADVICE_ID")
    private Long adviceId;

    /**
     * The advice desc.
     */
    @Column(name = "ADVICE_DESC")
    private String adviceDesc;

    /**
     * Gets the advice id.
     *
     * @return the adviceId
     */
    public long getAdviceId() {
        return adviceId;
    }

    /**
     * Sets the advice id.
     *
     * @param adviceId the adviceId to set
     */
    public void setAdviceId(long adviceId) {
        this.adviceId = adviceId;
    }

    /**
     * Gets the advice desc.
     *
     * @return the adviceDesc
     */
    public String getAdviceDesc() {
        return adviceDesc;
    }

    /**
     * Sets the advice desc.
     *
     * @param adviceDesc the adviceDesc to set
     */
    public void setAdviceDesc(String adviceDesc) {
        this.adviceDesc = adviceDesc;
    }

    /**
     * Sets the advice id.
     *
     * @param adviceId the adviceId to set
     */
    public void setAdviceId(Long adviceId) {
        this.adviceId = adviceId;
    }

}
