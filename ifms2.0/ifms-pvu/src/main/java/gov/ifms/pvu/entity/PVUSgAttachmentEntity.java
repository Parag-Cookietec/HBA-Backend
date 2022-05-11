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
 * The Class PVUSgAttachmentEntity.
 *
 * @version v 1.0
 * @created 2019/12/19 18:51:39
 *
 */
@Entity
@Table(name = "T_PVU_SG_ATT", schema = Constant.PVU_SCHEMA)
public class PVUSgAttachmentEntity extends BasePVUAttachmentEntity {

	/** The serialVersionUID. */
	private static final Long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_SG_ATT_ID")
	private Long id;

	/** The cs event id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_SG_EVNT_ID", referencedColumnName = "T_PVU_SG_EVNT_ID")
	private PVUSelectionGradeEventEntity sgEntity;

	public PVUSgAttachmentEntity() {
	}




	public PVUSgAttachmentEntity(PVUSelectionGradeEventEntity sgEntity) {
		super();
		this.sgEntity = sgEntity;
	}




	public PVUSgAttachmentEntity(Long id) {
		super();
		this.id = id;
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
	 * @return the sgEntity
	 */
	public PVUSelectionGradeEventEntity getSgEntity() {
		return sgEntity;
	}

	/**
	 * @param sgEntity the sgEntity to set
	 */
	public void setSgEntity(PVUSelectionGradeEventEntity sgEntity) {
		this.sgEntity = sgEntity;
	}






}
