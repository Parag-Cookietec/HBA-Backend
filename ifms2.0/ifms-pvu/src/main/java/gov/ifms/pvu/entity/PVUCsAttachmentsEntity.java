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

/**
 * The Class PVUCsAttachmentsEntity.
 * 
 * @version v 1.0
 * @created 2020/01/11 16:50:08
 *
 */
@Entity
@Table(name = "T_PVU_CS_ATT", schema = Constant.PVU_SCHEMA)
public class PVUCsAttachmentsEntity extends BasePVUAttachmentEntity {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cs attachment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_CS_ATT_ID")
	private Long id;

	/** The cs event id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_CS_EVNT_ID", referencedColumnName = "T_PVU_CS_EVNT_ID")
	private PVUCsEventEntity changeOfScale;

	/**
	 * PVUCsAttachmentsEntity Constructor.
	 */
	public PVUCsAttachmentsEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PVUCsEventEntity getChangeOfScale() {
		return changeOfScale;
	}

	public void setChangeOfScale(PVUCsEventEntity changeOfScale) {
		this.changeOfScale = changeOfScale;
	}

	@Override
	public String toString() {
		return "PVUCsAttachmentsEntity [id=" + id + ", changeOfScale=" + changeOfScale + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(changeOfScale, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUCsAttachmentsEntity)) {
			return false;
		}
		PVUCsAttachmentsEntity other = (PVUCsAttachmentsEntity) obj;
		return Objects.equals(changeOfScale, other.changeOfScale) && Objects.equals(id, other.id);
	}

}
