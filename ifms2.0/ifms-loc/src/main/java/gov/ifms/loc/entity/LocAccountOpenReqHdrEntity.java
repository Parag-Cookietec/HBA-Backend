package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocAccountOpenReqHdrEntity.
 * 
 * @version 1.0
 * @created 2020/12/22 12:52:20
 *
 */
@Entity
@Table(name = "TLOC_LC_OPEN_REQ_HDR", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpenReqHdrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The lc open req hdr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_OPEN_REQ_HDR_ID")
	private Long lcOpenReqHdrId;

	/** The reference no. */
	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	/** The reference dt. */
	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	/** The division office address. */
	@Column(name = "DIVISION_OFFICE_ADDRESS")
	private String divisionOfficeAddress;

	/** The dept id re hdr. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID", nullable = true)
	private EDPMsDepartmentEntity deptIdReHdr;

	/** The hod id. */
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "HOD_ID", referencedColumnName = "OFFICE_ID")
	@Column(name = "HOD_ID")
	private Long hodId;

	/** The office id re lay. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TO_OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity toOfficeId;

	/** The district id gia urb. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity districtIdReHdr;

	/** The cardex no. */
	@Column(name = "CARDEX_NO")
	private Long cardexNo;

	/** The ddo no. */
	@Column(name = "DDO_NO")
	private Long ddoNo;

	/** The status id re hdr. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The wf id. */
	@Column(name = "WF_ID")
	private Long wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The pending with user id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PENDING_WITH_USERID", referencedColumnName = "USER_ID")
	private EDPMsUserEntity pendingWithUserId;

	/** The office id re lay. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REQUESTING_OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity requestingOfficeId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_NAME_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeNameId;

	/**
	 * LocAccountOpenReqHdrDto Constructor
	 */
	public LocAccountOpenReqHdrEntity() {
		super();
	}

	/**
	 * Instantiates a new loc account open req hdr entity.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 */
	public LocAccountOpenReqHdrEntity(Long lcOpenReqHdrId) {
		super();
		this.lcOpenReqHdrId = lcOpenReqHdrId;
	}

	/**
	 * @return the lcOpenReqHdrId
	 */
	public Long getLcOpenReqHdrId() {
		return lcOpenReqHdrId;
	}

	/**
	 * @param lcOpenReqHdrId the lcOpenReqHdrId to set
	 */
	public void setLcOpenReqHdrId(Long lcOpenReqHdrId) {
		this.lcOpenReqHdrId = lcOpenReqHdrId;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the referenceDt
	 */
	public Date getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	/**
	 * @return the divisionOfficeAddress
	 */
	public String getDivisionOfficeAddress() {
		return divisionOfficeAddress;
	}

	/**
	 * @param divisionOfficeAddress the divisionOfficeAddress to set
	 */
	public void setDivisionOfficeAddress(String divisionOfficeAddress) {
		this.divisionOfficeAddress = divisionOfficeAddress;
	}

	/**
	 * @return the deptIdReHdr
	 */
	public EDPMsDepartmentEntity getDeptIdReHdr() {
		return deptIdReHdr;
	}

	/**
	 * @param deptIdReHdr the deptIdReHdr to set
	 */
	public void setDeptIdReHdr(EDPMsDepartmentEntity deptIdReHdr) {
		this.deptIdReHdr = deptIdReHdr;
	}

	public Long getHodId() {
		return hodId;
	}

	public void setHodId(Long hodId) {
		this.hodId = hodId;
	}

	/**
	 * @return the toOfficeId
	 */
	public EDPMsOfficeEntity getToOfficeId() {
		return toOfficeId;
	}

	/**
	 * @param toOfficeId the toOfficeId to set
	 */
	public void setToOfficeId(EDPMsOfficeEntity toOfficeId) {
		this.toOfficeId = toOfficeId;
	}

	/**
	 * @return the districtIdReHdr
	 */
	public EDPMsDistrictEntity getDistrictIdReHdr() {
		return districtIdReHdr;
	}

	/**
	 * @param districtIdReHdr the districtIdReHdr to set
	 */
	public void setDistrictIdReHdr(EDPMsDistrictEntity districtIdReHdr) {
		this.districtIdReHdr = districtIdReHdr;
	}

	/**
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * @return the ddoNo
	 */
	public Long getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(Long ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public EDPMsUserEntity getPendingWithUserId() {
		return pendingWithUserId;
	}

	public void setPendingWithUserId(EDPMsUserEntity pendingWithUserId) {
		this.pendingWithUserId = pendingWithUserId;
	}

	/**
	 * @return the requestingOfficeId
	 */
	public EDPMsOfficeEntity getRequestingOfficeId() {
		return requestingOfficeId;
	}

	/**
	 * @param requestingOfficeId the requestingOfficeId to set
	 */
	public void setRequestingOfficeId(EDPMsOfficeEntity requestingOfficeId) {
		this.requestingOfficeId = requestingOfficeId;
	}

	/**
	 * @return the officeNameId
	 */
	public EDPMsOfficeEntity getOfficeNameId() {
		return officeNameId;
	}

	/**
	 * @param officeNameId the officeNameId to set
	 */
	public void setOfficeNameId(EDPMsOfficeEntity officeNameId) {
		this.officeNameId = officeNameId;
	}

	@Override
	public String toString() {
		return "LocAccountOpenReqHdrEntity [lcOpenReqHdrId=" + lcOpenReqHdrId + ", referenceNo=" + referenceNo
				+ ", referenceDt=" + referenceDt + ", divisionOfficeAddress=" + divisionOfficeAddress + ", deptIdReHdr="
				+ deptIdReHdr + ", hodId=" + hodId + ", toOfficeId=" + toOfficeId + ", districtIdReHdr="
				+ districtIdReHdr + ", cardexNo=" + cardexNo + ", ddoNo=" + ddoNo + ", statusId=" + statusId + ", wfId="
				+ wfId + ", wfRoleId=" + wfRoleId + ", pendingWithUserId=" + pendingWithUserId + ", requestingOfficeId="
				+ requestingOfficeId + ", officeNameId=" + officeNameId + "]";
	}

}
