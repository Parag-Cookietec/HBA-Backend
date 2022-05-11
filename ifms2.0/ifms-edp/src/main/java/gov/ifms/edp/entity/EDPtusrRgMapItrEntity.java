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

import gov.ifms.edp.employe.EDPEmployeEntity;

/**
 * The Class EDPtusrRgMapItrEntity.
 * 
 * @version 1.0
 * @created 2020/07/16 09:28:25
 *
 */
@Entity
@Table(name = "T_USR_RG_MAP_ITR")
public class EDPtusrRgMapItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tusr rg map itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_USR_RG_MAP_ITR_ID")
	private Long tusrRgMapItrId;

	/** The tusr rg map id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_USR_RG_MAP_ID", referencedColumnName = "T_USR_RG_MAP_ID")
	private EDPtusrRgMapEntity tusrRgMapId;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The to emp id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private EDPEmployeEntity toEmpId;

	/** The post user office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LK_PO_OFF_USER_ID", nullable = false, referencedColumnName = "LK_PO_OFF_USER_ID")
	private EDPLkPoOffUserEntity poOffUserId;
	
	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The remarks. */
	@Column(name = "REMARKS")
	private Long remarks;

	/**
	 * Gets the tusr rg map itr id.
	 *
	 * @return the tusrRgMapItrId
	 */
	public Long getTusrRgMapItrId() {
		return tusrRgMapItrId;
	}

	/**
	 * Sets the tusr rg map itr id.
	 *
	 * @param tusrRgMapItrId the tusrRgMapItrId to set
	 */
	public void setTusrRgMapItrId(Long tusrRgMapItrId) {
		this.tusrRgMapItrId = tusrRgMapItrId;
	}

	/**
	 * Gets the tusr rg map id.
	 *
	 * @return the tusrRgMapId
	 */
	public EDPtusrRgMapEntity getTusrRgMapId() {
		return tusrRgMapId;
	}

	/**
	 * Sets the tusr rg map id.
	 *
	 * @param tusrRgMapId the tusrRgMapId to set
	 */
	public void setTusrRgMapId(EDPtusrRgMapEntity tusrRgMapId) {
		this.tusrRgMapId = tusrRgMapId;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the to emp id.
	 *
	 * @return the toEmpId
	 */
	public EDPEmployeEntity getToEmpId() {
		return toEmpId;
	}

	/**
	 * Sets the to emp id.
	 *
	 * @param toEmpId the toEmpId to set
	 */
	public void setToEmpId(EDPEmployeEntity toEmpId) {
		this.toEmpId = toEmpId;
	}

	/**
	 * Gets the po off user id.
	 *
	 * @return the poOffUserId
	 */
	public EDPLkPoOffUserEntity getPoOffUserId() {
		return poOffUserId;
	}

	/**
	 * Sets the po off user id.
	 *
	 * @param poOffUserId the poOffUserId to set
	 */
	public void setPoOffUserId(EDPLkPoOffUserEntity poOffUserId) {
		this.poOffUserId = poOffUserId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public Long getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(Long remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(poOffUserId, remarks, statusId, toEmpId, trnNo, tusrRgMapId, tusrRgMapItrId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPtusrRgMapItrEntity)) {
			return false;
		}
		EDPtusrRgMapItrEntity other = (EDPtusrRgMapItrEntity) obj;
		return Objects.equals(poOffUserId, other.poOffUserId) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(toEmpId, other.toEmpId)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(tusrRgMapId, other.tusrRgMapId)
				&& Objects.equals(tusrRgMapItrId, other.tusrRgMapItrId);
	}
	
}
