package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Class PVUSuspensionAttachmentEntity.
 */
@Entity
@Table(name = "T_PVU_SUS_ATT", schema = Constant.PVU_SCHEMA)
public class PVUSuspensionAttachmentEntity extends BasePVUAttachmentEntity {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_PVU_SUS_ATT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "T_PVU_SUS_CRT_ID", referencedColumnName = "T_PVU_SUS_CRT_ID")
    private PVUEmployeSuspensionEntity suspension;

    /**
     * Instantiates a new PVU career advancement entity.
     */
    public PVUSuspensionAttachmentEntity() {
        super();
    }

    /**
     * Instantiates a new PVU career advancement entity.
     *
     * @param id the id
     */
    public PVUSuspensionAttachmentEntity(Long id) {
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
     * Gets the suspension.
     *
     * @return the suspension
     */
    public PVUEmployeSuspensionEntity getSuspension() {
        return suspension;
    }

    /**
     * Sets the suspension.
     *
     * @param suspension the suspension to set
     */
    public void setSuspension(PVUEmployeSuspensionEntity suspension) {
        this.suspension = suspension;
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
        PVUSuspensionAttachmentEntity that = (PVUSuspensionAttachmentEntity) obj;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getSuspension(), that.getSuspension());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSuspension());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUSuspensionAttachmentEntity{" + "id=" + id +
                ", suspension=" + suspension +
                '}';
    }
}
