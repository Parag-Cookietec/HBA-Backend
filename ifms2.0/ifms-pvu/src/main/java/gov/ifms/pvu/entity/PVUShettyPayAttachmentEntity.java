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
 * The Class PVUShettyPayAttachmentEntity.
 *
 * @version v 1.0
 * @created 2020/01/15 15:00:11
 *
 */
@Entity
@Table(name = "T_PVU_SP_ATT", schema = Constant.PVU_SCHEMA)
public class PVUShettyPayAttachmentEntity extends BasePVUAttachmentEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sp attach id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_SP_ATT_ID")
	private Long id;

	/** The sp event id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_SP_EVNT_ID", nullable = true, referencedColumnName = "T_PVU_SP_EVNT_ID")
	private PVUEmployeShettyPayEntity spId;

	public PVUShettyPayAttachmentEntity(Long id) {
		this.id = id;
	}

	public PVUShettyPayAttachmentEntity() {
	}

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
	 * @return the spId
	 */
	public PVUEmployeShettyPayEntity getSpId() {
		return spId;
	}

	/**
	 * @param spId the spId to set
	 */
	public void setSpId(PVUEmployeShettyPayEntity spId) {
		this.spId = spId;
	}

}
