package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Class PVUSteppingUpAttEntity.
 */
@Entity
@Table(name = "T_PVU_ST_ATT", schema = Constant.PVU_SCHEMA)
public class PVUSteppingUpAttEntity extends BasePVUAttachmentEntity {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_PVU_ST_ATT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "T_PVU_ST_EVNT_ID", referencedColumnName = "T_PVU_ST_EVNT_ID")
    private PVUSteppingUpEventEntity entity;

    
	public PVUSteppingUpEventEntity getEntity() {
		return entity;
	}

	public void setEntity(PVUSteppingUpEventEntity entity) {
		this.entity = entity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getEntity());
	}

	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PVUSteppingUpAttEntity that = (PVUSteppingUpAttEntity) obj;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getEntity(), that.getEntity());
	}

	@Override
	public String toString() {
		return "PVUSteppingUpAttEntity [id=" + id + ", entity=" + entity + "]";
	}

   
    
    
    
    
    
}
