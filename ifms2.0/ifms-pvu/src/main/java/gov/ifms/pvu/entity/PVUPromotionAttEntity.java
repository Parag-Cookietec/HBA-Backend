package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Class PVUPromotionAttEntity.
 */
@Entity
@Table(name = "T_PVU_PR_ATT", schema = Constant.PVU_SCHEMA)
public class PVUPromotionAttEntity extends BasePVUAttachmentEntity {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_PVU_PR_ATT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "T_PVU_PR_EVNT_ID", referencedColumnName = "T_PVU_PR_EVNT_ID")
    private PVUPromotionEntity entity;

    /**
     * Instantiates a new Pvu senior scale att entity.
     */
    public PVUPromotionAttEntity() {
        super();
    }

    /**
     * Instantiates a new Pvu senior scale att entity.
     *
     * @param id the id
     */
    public PVUPromotionAttEntity(Long id) {
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
    public PVUPromotionEntity getEntity() {
        return entity;
    }

    /**
     * Sets the entity.
     *
     * @param entity the entity to set
     */
    public void setEntity(PVUPromotionEntity entity) {
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
        PVUPromotionAttEntity that = (PVUPromotionAttEntity) obj;
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
        return "PVUSuspensionAttachmentEntity{" + "id=" + id +
                ", entity=" + entity +
                '}';
    }
}
