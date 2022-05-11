package gov.ifms.pvu.entity;

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
@Table(name = "T_PVU_ADHC_PROB_REGLR_ATT", schema = Constant.PVU_SCHEMA)
public class PVUEmployeePayTypeAttachmentEntity extends BasePVUAttachmentEntity {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The rev attach id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PVU_ADHC_PROB_REGLR_ATT_ID")
	private Long id;

	/** The cs event id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PVU_ADHC_PROB_REGLR_SD_ID", referencedColumnName = "PVU_ADHC_PROB_REGLR_SD_ID")
	private PVUEmployeTypeChangeSDEntity reversion;

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

	/**
	 * @return the reversion
	 */
	public PVUEmployeTypeChangeSDEntity getReversion() {
		return reversion;
	}

	/**
	 * @param reversion the reversion to set
	 */
	public void setReversion(PVUEmployeTypeChangeSDEntity reversion) {
		this.reversion = reversion;
	}

	
}
