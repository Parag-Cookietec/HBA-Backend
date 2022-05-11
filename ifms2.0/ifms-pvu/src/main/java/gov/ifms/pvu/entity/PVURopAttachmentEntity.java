package gov.ifms.pvu.entity;

import java.io.Serializable;

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
 * The Class PVURopAttachmentEntity.
 * 
 * @version v 1.0
 * @created 2020/03/17 11:14:39
 *
 */
@Entity
@Table(name = "T_PVU_RP_ATT", schema = Constant.PVU_SCHEMA)
public class PVURopAttachmentEntity extends BasePVUAttachmentEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_RP_ATT_ID")
	private Long id;

	/** The pvu revision of pay entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_RP_EVNT_ID", referencedColumnName = "T_PVU_RP_EVNT_ID")
	private PVURevisionOfPayEntity pvuRevisionOfPayEntity;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the pvu revision of pay entity.
	 *
	 * @return the pvu revision of pay entity
	 */
	public PVURevisionOfPayEntity getPvuRevisionOfPayEntity() {
		return pvuRevisionOfPayEntity;
	}

	/**
	 * Sets the pvu revision of pay entity.
	 *
	 * @param pvuRevisionOfPayEntity the new pvu revision of pay entity
	 */
	public void setPvuRevisionOfPayEntity(PVURevisionOfPayEntity pvuRevisionOfPayEntity) {
		this.pvuRevisionOfPayEntity = pvuRevisionOfPayEntity;
	}

}
