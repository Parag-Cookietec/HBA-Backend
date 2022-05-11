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
 * The Class PVUDeemedDateAttEntity.
 * 
 * @version v 1.0
 * @created 2020/03/21 11:30:34
 *
 */
@Entity
@Table(name = "T_PVU_DD_ATT", schema = Constant.PVU_SCHEMA)
public class PVUDeemedDateAttEntity extends BasePVUAttachmentEntity {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_DD_ATT_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_DD_EVNT_ID", referencedColumnName = "T_PVU_DD_EVNT_ID")
	private PVUDeemedDateEntity entity;

	/**
	 * PVUDeemedDateAttEntity Constructor
	 */
	public PVUDeemedDateAttEntity() {
		super();
	}

	public PVUDeemedDateAttEntity(Long id) {

		super();
		this.id = id;
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, entity);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUDeemedDateAttEntity)) {
			return false;
		}

		PVUDeemedDateAttEntity other = (PVUDeemedDateAttEntity) obj;

		return Objects.equals(id, other.id) && Objects.equals(entity, other.entity);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "PVUDeemedDateAttEntity [id = " + id + ",entity = " + entity + ",]";
	}

	/**
	 * getter setter
	 */

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
	 * @return the entity
	 */
	public PVUDeemedDateEntity getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(PVUDeemedDateEntity entity) {
		this.entity = entity;
	}

}
