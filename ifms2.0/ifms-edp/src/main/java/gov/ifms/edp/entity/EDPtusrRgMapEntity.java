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
import gov.ifms.edp.employe.EDPEmployeEntity;

/**
 * The Class EDPtusrRgMapEntity.
 * 
 * @version 1.0
 * @created 2020/07/16 09:23:40
 *
 */
@Entity
@Table(name = "T_USR_RG_MAP", schema = Constant.EDP_SCHEMA)
public class EDPtusrRgMapEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tusr rg map id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_USR_RG_MAP_ID")
	private Long tusrRgMapId;

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

	/** The has objection. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECTION", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity hasObjection;

	/** The objection remarks. */
	@Column(name = "OBJECTION_REMARKS")
	private String objectionRemarks;

    /** The initiated by. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INITIATED_BY", referencedColumnName = "LK_PO_OFF_USER_ID")
    private EDPLkPoOffUserEntity initiatedBy;

	/** The wf in request. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_IN_REQUEST", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity wfInRequest;

	/**
	 * EDPtusrRgMapDto Constructor.
	 */
	public EDPtusrRgMapEntity() {
		super();
	}
	
	/**
	 * @param tusrRgMapId
	 */
	public EDPtusrRgMapEntity(Long tusrRgMapId) {
		this.tusrRgMapId = tusrRgMapId;
	}



	/**
	 * Gets the tusr rg map id.
	 *
	 * @return the tusrRgMapId
	 */
	public Long getTusrRgMapId() {
		return tusrRgMapId;
	}

	/**
	 * Sets the tusr rg map id.
	 *
	 * @param tusrRgMapId the tusrRgMapId to set
	 */
	public void setTusrRgMapId(Long tusrRgMapId) {
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the hasObjection
	 */
	public EDPLuLookUpInfoEntity getHasObjection() {
		return hasObjection;
	}

	/**
	 * @param hasObjection the hasObjection to set
	 */
	public void setHasObjection(EDPLuLookUpInfoEntity hasObjection) {
		this.hasObjection = hasObjection;
	}

	/**
	 * @return the objectionRemarks
	 */
	public String getObjectionRemarks() {
		return objectionRemarks;
	}

	/**
	 * @param objectionRemarks the objectionRemarks to set
	 */
	public void setObjectionRemarks(String objectionRemarks) {
		this.objectionRemarks = objectionRemarks;
	}

	/**
	 * @return the initiatedBy
	 */
	public EDPLkPoOffUserEntity getInitiatedBy() {
		return initiatedBy;
	}

	/**
	 * @param initiatedBy the initiatedBy to set
	 */
	public void setInitiatedBy(EDPLkPoOffUserEntity initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	/**
	 * @return the wfInRequest
	 */
	public EDPLuLookUpInfoEntity getWfInRequest() {
		return wfInRequest;
	}

	/**
	 * @param wfInRequest the wfInRequest to set
	 */
	public void setWfInRequest(EDPLuLookUpInfoEntity wfInRequest) {
		this.wfInRequest = wfInRequest;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(hasObjection, initiatedBy, objectionRemarks, poOffUserId, statusId, toEmpId, trnNo,
				tusrRgMapId, wfInRequest);
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
		if (!(obj instanceof EDPtusrRgMapEntity)) {
			return false;
		}
		EDPtusrRgMapEntity other = (EDPtusrRgMapEntity) obj;
		return Objects.equals(hasObjection, other.hasObjection) && Objects.equals(initiatedBy, other.initiatedBy)
				&& Objects.equals(objectionRemarks, other.objectionRemarks)
				&& Objects.equals(poOffUserId, other.poOffUserId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(toEmpId, other.toEmpId) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(tusrRgMapId, other.tusrRgMapId) && Objects.equals(wfInRequest, other.wfInRequest);
	}

}
