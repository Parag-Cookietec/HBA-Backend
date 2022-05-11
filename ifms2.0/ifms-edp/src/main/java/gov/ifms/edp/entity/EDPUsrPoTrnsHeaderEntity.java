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
 * The Class EDPUsrPoTrnsHeaderEntity.
 */
@Entity
@Table(name = "TEDP_UPT_HDR", schema = Constant.EDP_SCHEMA)
public class EDPUsrPoTrnsHeaderEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp usr po trns header id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_UPT_HDR_ID")
	private Long edpUsrPoTrnsHeaderId;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;
	
	/** The request type. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REQUEST_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity requestType;

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
	 * Instantiates a new EDP usr po trns header entity.
	 *
	 * @param edpUsrPoTrnsHeadrId the edp usr po trns headr id
	 */
	public EDPUsrPoTrnsHeaderEntity(Long edpUsrPoTrnsHeadrId) {
		this.edpUsrPoTrnsHeaderId = edpUsrPoTrnsHeadrId;
	}

	/**
	 * Instantiates a new EDP usr po trns header entity.
	 */
	public EDPUsrPoTrnsHeaderEntity() {
	}

	/**
	 * Gets the edp usr po trns header id.
	 *
	 * @return the edpUsrPoTrnsHeaderId
	 */
	public Long getEdpUsrPoTrnsHeaderId() {
		return edpUsrPoTrnsHeaderId;
	}

	/**
	 * Sets the edp usr po trns header id.
	 *
	 * @param edpUsrPoTrnsHeaderId the edpUsrPoTrnsHeaderId to set
	 */
	public void setEdpUsrPoTrnsHeaderId(Long edpUsrPoTrnsHeaderId) {
		this.edpUsrPoTrnsHeaderId = edpUsrPoTrnsHeaderId;
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
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}
	
	/**
	 * Gets the request type.
	 *
	 * @return the requestType
	 */
	public EDPLuLookUpInfoEntity getRequestType() {
		return requestType;
	}

	/**
	 * Sets the request type.
	 *
	 * @param requestType the requestType to set
	 */
	public void setRequestType(EDPLuLookUpInfoEntity requestType) {
		this.requestType = requestType;
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
	 * Gets the checks for objection.
	 *
	 * @return the checks for objection
	 */
	public EDPLuLookUpInfoEntity getHasObjection() {
		return hasObjection;
	}

	/**
	 * Sets the checks for objection.
	 *
	 * @param hasObjection the new checks for objection
	 */
	public void setHasObjection(EDPLuLookUpInfoEntity hasObjection) {
		this.hasObjection = hasObjection;
	}

	/**
	 * Gets the objection remarks.
	 *
	 * @return the objection remarks
	 */
	public String getObjectionRemarks() {
		return objectionRemarks;
	}

	/**
	 * Sets the objection remarks.
	 *
	 * @param objectionRemarks the new objection remarks
	 */
	public void setObjectionRemarks(String objectionRemarks) {
		this.objectionRemarks = objectionRemarks;
	}

	
	/**
	 * Gets the initiated by.
	 *
	 * @return the initiated by
	 */
	public EDPLkPoOffUserEntity getInitiatedBy() {
		return initiatedBy;
	}

	/**
	 * Sets the initiated by.
	 *
	 * @param initiatedBy the new initiated by
	 */
	public void setInitiatedBy(EDPLkPoOffUserEntity initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	/**
	 * Gets the wf in request.
	 *
	 * @return the wf in request
	 */
	public EDPLuLookUpInfoEntity getWfInRequest() {
		return wfInRequest;
	}

	/**
	 * Sets the wf in request.
	 *
	 * @param wfInRequest the new wf in request
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
		return Objects.hash(edpUsrPoTrnsHeaderId, statusId, trnNo, requestType, hasObjection, objectionRemarks, initiatedBy, wfInRequest);
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
		if (!(obj instanceof EDPUsrPoTrnsHeaderEntity)) {
			return false;
		}
		EDPUsrPoTrnsHeaderEntity other = (EDPUsrPoTrnsHeaderEntity) obj;
		return Objects.equals(edpUsrPoTrnsHeaderId, other.edpUsrPoTrnsHeaderId)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(hasObjection, other.hasObjection) && Objects.equals(objectionRemarks, other.objectionRemarks)
				&& Objects.equals(requestType, other.requestType) && Objects.equals(initiatedBy, other.initiatedBy) && Objects.equals(wfInRequest, other.wfInRequest);
	}

}
