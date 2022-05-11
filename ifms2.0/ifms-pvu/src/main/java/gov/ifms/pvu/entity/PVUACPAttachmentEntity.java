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
@Table(name = "T_PVU_AP_ATT", schema = Constant.PVU_SCHEMA)
public class PVUACPAttachmentEntity extends BasePVUAttachmentEntity {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cs attachment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_AP_ATT_ID")
	private Long id;

	/** The cs event id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_AP_EVNT_ID", referencedColumnName = "T_PVU_AP_EVNT_ID")
	private PVUEmployeAssuredCareerProgressionEntity acpEntity;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public PVUACPAttachmentEntity() {
		super();
	}

	public PVUACPAttachmentEntity(Long id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acpEntity, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUACPAttachmentEntity other = (PVUACPAttachmentEntity) obj;
		return Objects.equals(acpEntity, other.acpEntity) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PVUACPAttachmentEntity [id=" + id + ", acpEntity=" + acpEntity + "]";
	}

	/**
	 * @return the acpEntity
	 */
	public PVUEmployeAssuredCareerProgressionEntity getAcpEntity() {
		return acpEntity;
	}

	/**
	 * @param acpEntity the acpEntity to set
	 */
	public void setAcpEntity(PVUEmployeAssuredCareerProgressionEntity acpEntity) {
		this.acpEntity = acpEntity;
	}

	


	


}
