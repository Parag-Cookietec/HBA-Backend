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
 * The Class UpdateOfficeTrnEntity.
 * 
 * @version 1.0
 * @created 2020/09/21 16:41:54
 *
 */
@Entity
@Table(name = "T_EDP_UPD_OFFICE_TRN", schema = Constant.EDP_SCHEMA)
public class EDPUpdateOfficeTrnEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The upd offc trn id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EDP_UPD_OFF_TRN_ID")
	private Long updOffcTrnId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity msOfficeEntity;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	public EDPUpdateOfficeTrnEntity() {
		super();
	}

	/**
	 * Gets the upd offc trn id.
	 *
	 * @return the upd offc trn id
	 */
	public Long getUpdOffcTrnId() {
		return updOffcTrnId;
	}

	/**
	 * Sets the upd offc trn id.
	 *
	 * @param updOffcTrnId the new upd offc trn id
	 */
	public void setUpdOffcTrnId(Long updOffcTrnId) {
		this.updOffcTrnId = updOffcTrnId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public EDPMsOfficeEntity getMsOfficeEntity() {
		return msOfficeEntity;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setMsOfficeEntity(EDPMsOfficeEntity msOfficeEntity) {
		this.msOfficeEntity = msOfficeEntity;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(msOfficeEntity, statusId, updOffcTrnId);
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
		EDPUpdateOfficeTrnEntity other = (EDPUpdateOfficeTrnEntity) obj;
		return Objects.equals(msOfficeEntity, other.msOfficeEntity) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(updOffcTrnId, other.updOffcTrnId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPUpdateOfficeTrnEntity [updOffcTrnId=" + updOffcTrnId + ", officeIdTrn=" + msOfficeEntity + ", statusId="
				+ statusId + "]";
	}

}
