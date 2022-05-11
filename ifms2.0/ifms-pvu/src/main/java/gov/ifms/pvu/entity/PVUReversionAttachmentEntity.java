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
 * The Class PVUReversionAttachmentEntity.
 * 
 * @version v 1.0
 * @created 2020/01/13 15:56:29
 *
 */
@Entity
@Table(name = "T_PVU_RV_ATT", schema = Constant.PVU_SCHEMA)
public class PVUReversionAttachmentEntity extends BasePVUAttachmentEntity {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The rev attach id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_RV_ATT_ID")
	private Long id;

	/** The cs event id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_RV_EVNT_ID", referencedColumnName = "T_PVU_RV_EVNT_ID")
	private PVUEmployeReversionEntity reversion;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public PVUEmployeReversionEntity getReversion() {
		return reversion;
	}

	public void setReversion(PVUEmployeReversionEntity reversion) {
		this.reversion = reversion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, reversion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (!(obj instanceof PVUReversionAttachmentEntity)) {
			return false;
		}
		PVUReversionAttachmentEntity other = (PVUReversionAttachmentEntity) obj;
		return	Objects.equals(getId(), other.getId()) &&
        Objects.equals(getReversion(), other.getReversion());
	}

	
	@Override
	public String toString() {
		return "PVUReversionAttachmentEntity [id=" + id + ", reversion=" + reversion + "]";
	}
}
