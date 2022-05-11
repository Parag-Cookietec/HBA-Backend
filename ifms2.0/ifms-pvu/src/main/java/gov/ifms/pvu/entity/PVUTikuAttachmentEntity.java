package gov.ifms.pvu.entity;

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



@Entity
@Table(name = "T_PVU_TK_ATT", schema = Constant.PVU_SCHEMA)
public class PVUTikuAttachmentEntity extends BasePVUAttachmentEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_TK_ATT_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_TK_EVNT_ID", referencedColumnName = "T_PVU_TK_EVNT_ID")
	private PVUEmployeTikuPayEntity tikuPayEntity;

	public PVUTikuAttachmentEntity() {
		super();
	}

	public PVUTikuAttachmentEntity(Long id) {
		super();
		this.id = id;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PVUEmployeTikuPayEntity getTikuPayEntity() {
		return tikuPayEntity;
	}

	public void setTikuPayEntity(PVUEmployeTikuPayEntity tikuPayEntity) {
		this.tikuPayEntity = tikuPayEntity;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, tikuPayEntity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUTikuAttachmentEntity)) {
			return false;
		}
		PVUTikuAttachmentEntity other = (PVUTikuAttachmentEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(tikuPayEntity, other.tikuPayEntity);
	}

	
	@Override
	public String toString() {
		return "PVUTikuAttachmentEntity [id=" + id + ", tikuPayEntity=" + tikuPayEntity + "]";
	}


	

}
