package gov.ifms.pvu.entity;

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
import gov.ifms.pvu.common.BasePVUAttachmentEntity;

/**
 * The Class PVUCareerAdvanceAttachmentsEntity.
 * 
 * @version v 1.0
 * @created 2020/01/17 11:30:23
 *
 */
@Entity
@Table(name = "T_PVU_CA_ATT", schema = Constant.PVU_SCHEMA)
public class PVUCareerAdvanceAttachmentsEntity extends BasePVUAttachmentEntity implements Serializable {

	/**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_PVU_CA_ATT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "T_PVU_CA_EVNT_ID", referencedColumnName = "T_PVU_CA_EVNT_ID")
    private PVUCareerAdvancementEntity entity;

    /**
     * Instantiates a new Pvu CAS att entity.
     */
    public PVUCareerAdvanceAttachmentsEntity() {
        super();
    }

    /**
     * Instantiates a new Pvu senior scale att entity.
     *
     * @param id the id
     */
    public PVUCareerAdvanceAttachmentsEntity(Long id) {
        super();
        this.id = id;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the entity.
     *
     * @return the entity
     */
    public PVUCareerAdvancementEntity getEntity() {
        return entity;
    }

    /**
     * Sets the entity.
     *
     * @param entity the entity to set
     */
    public void setEntity(PVUCareerAdvancementEntity entity) {
        this.entity = entity;
    }

    /**
     * Equals .
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PVUCareerAdvanceAttachmentsEntity that = (PVUCareerAdvanceAttachmentsEntity) obj;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getEntity(), that.getEntity());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEntity());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUCareerAdvanceAttachmentsEntity{" + "id=" + id +
                ", entity=" + entity +
                '}';
    }

}
