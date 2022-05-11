package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentEntity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="T_PVU_HP_ATT"  , schema = Constant.PVU_SCHEMA )
public class PVUHigherPayScaleAttEntity extends BasePVUAttachmentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="T_PVU_HP_ATT_ID")
    private  Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="T_PVU_HP_EVNT_ID" ,referencedColumnName ="T_PVU_HP_EVNT_ID" )
    private  PVUEmployeHigherPayScaleEventEntity entity;

    public PVUHigherPayScaleAttEntity(Long id) {
        this.id = id;
    }

    public PVUHigherPayScaleAttEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVUHigherPayScaleAttEntity that = (PVUHigherPayScaleAttEntity) o;
        return id.equals(that.id) &&
                entity.equals(that.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entity);
    }

    @Override
    public String toString() {
        return "PVUHigherPayScaleAttEntity{" +
                "id=" + id +
                ", entity=" + entity +
                '}';
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PVUEmployeHigherPayScaleEventEntity getEntity() {
        return entity;
    }

    public void setEntity(PVUEmployeHigherPayScaleEventEntity entity) {
        this.entity = entity;
    }
}
