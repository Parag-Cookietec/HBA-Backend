package gov.ifms.edp.entity;

import java.io.Serializable;
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

/**
 * The Class EDPLkPostOfficeEntity.
 */
@Entity
@Table(name = "LK_POST_OFFICE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPostOfficeEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_POST_OFFICE_ID")
	private Long postOfficeId;

	/** The post entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID", referencedColumnName = "POST_ID")
	private EDPMsPostEntity postEntity;

	/** The office entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeEntity;

	/** The is vacant. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_VACANT_POST", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isVacant;

	/**
	 * Instantiates a new EDP lk post office entity.
	 */
	public EDPLkPostOfficeEntity() {

	}

	/**
	 * Instantiates a new EDP lk post office entity.
	 *
	 * @param postOfficeId the post office id
	 */
	public EDPLkPostOfficeEntity(Long postOfficeId) {
		this.postOfficeId = postOfficeId;
	}

	/**
	 * Gets the post user id.
	 *
	 * @return the postUserId
	 */
	public Long getPostOfficeId() {
		return postOfficeId;
	}

	/**
	 * Sets the post user id.
	 *
	 * @param postOfficeId the new post office id
	 */
	public void setPostOfficeId(Long postOfficeId) {
		this.postOfficeId = postOfficeId;
	}

	/**
	 * Gets the post entity.
	 *
	 * @return the post entity
	 */
	public EDPMsPostEntity getPostEntity() {
		return postEntity;
	}

	/**
	 * Sets the post entity.
	 *
	 * @param postEntity the new post entity
	 */
	public void setPostEntity(EDPMsPostEntity postEntity) {
		this.postEntity = postEntity;
	}

	/**
	 * Gets the office entity.
	 *
	 * @return the office entity
	 */
	public EDPMsOfficeEntity getOfficeEntity() {
		return officeEntity;
	}

	/**
	 * Sets the office entity.
	 *
	 * @param officeEntity the new office entity
	 */
	public void setOfficeEntity(EDPMsOfficeEntity officeEntity) {
		this.officeEntity = officeEntity;
	}

	/**
	 * Gets the checks if is vacant.
	 *
	 * @return the isVacant
	 */
	public EDPLuLookUpInfoEntity getIsVacant() {
		return isVacant;
	}

	/**
	 * Sets the checks if is vacant.
	 *
	 * @param isVacant the isVacant to set
	 */
	public void setIsVacant(EDPLuLookUpInfoEntity isVacant) {
		this.isVacant = isVacant;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isVacant, officeEntity, postEntity, postOfficeId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPLkPostOfficeEntity other = (EDPLkPostOfficeEntity) obj;
		return Objects.equals(isVacant, other.isVacant) && Objects.equals(officeEntity, other.officeEntity)
				&& Objects.equals(postEntity, other.postEntity) && Objects.equals(postOfficeId, other.postOfficeId);
	}

}
