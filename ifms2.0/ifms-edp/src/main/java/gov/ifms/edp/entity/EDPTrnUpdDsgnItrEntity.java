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
 * The Class EDPTrnUpdDsgnItrEntity.
 */
@Entity
@Table(name = "TEDP_UPD_DSGN_ITR", schema = Constant.EDP_SCHEMA)
public class EDPTrnUpdDsgnItrEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tedp upd dsgn itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_UPDSGN_ITR_ID")
	private Long tedpUpdDsgnItrId;

	/** The tedp upd dsgn id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TEDP_UPD_DSGN_ID", nullable = false, referencedColumnName = "TEDP_UPD_DSGN_ID")
	private EDPTrnUpdDsgnEntity tedpUpdDsgnId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", nullable = false, referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The emp id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private EDPEmployeEntity empId;

	/** The active post id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ACTIVE_POST_ID", nullable = false, referencedColumnName = "POST_ID")
	private EDPMsPostEntity activePostId;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", nullable = false, referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The post id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "POST_ID", nullable = false, referencedColumnName = "POST_ID")
	private EDPMsPostEntity postId;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The has objection. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECTION", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity hasObjection;

	/** The objection remarks. */
	@Column(name = "OBJECTION_REMARKS")
	private String objectionRemarks;

	/** The wf in request. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_IN_REQUEST", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity wfInRequest;

	/**
	 * Gets the tedp upd dsgn itr id.
	 *
	 * @return the tedpUpdDsgnItrId
	 */
	public Long getTedpUpdDsgnItrId() {
		return tedpUpdDsgnItrId;
	}

	/**
	 * Sets the tedp upd dsgn itr id.
	 *
	 * @param tedpUpdDsgnItrId the tedpUpdDsgnItrId to set
	 */
	public void setTedpUpdDsgnItrId(Long tedpUpdDsgnItrId) {
		this.tedpUpdDsgnItrId = tedpUpdDsgnItrId;
	}

	/**
	 * Gets the tedp upd dsgn id.
	 *
	 * @return the tedpUpdDsgnId
	 */
	public EDPTrnUpdDsgnEntity getTedpUpdDsgnId() {
		return tedpUpdDsgnId;
	}

	/**
	 * Sets the tedp upd dsgn id.
	 *
	 * @param tedpUpdDsgnId the tedpUpdDsgnId to set
	 */
	public void setTedpUpdDsgnId(EDPTrnUpdDsgnEntity tedpUpdDsgnId) {
		this.tedpUpdDsgnId = tedpUpdDsgnId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
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
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public EDPEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(EDPEmployeEntity empId) {
		this.empId = empId;
	}

	/**
	 * Gets the active post id.
	 *
	 * @return the activePostId
	 */
	public EDPMsPostEntity getActivePostId() {
		return activePostId;
	}

	/**
	 * Sets the active post id.
	 *
	 * @param activePostId the activePostId to set
	 */
	public void setActivePostId(EDPMsPostEntity activePostId) {
		this.activePostId = activePostId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public EDPMsPostEntity getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(EDPMsPostEntity postId) {
		this.postId = postId;
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
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
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
		return Objects.hash(activePostId, designationId, empId, officeId, postId, statusId, tedpUpdDsgnId,
				tedpUpdDsgnItrId, trnNo, wfRoleId, hasObjection, objectionRemarks, wfInRequest);
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
		if (!(obj instanceof EDPTrnUpdDsgnItrEntity)) {
			return false;
		}
		EDPTrnUpdDsgnItrEntity other = (EDPTrnUpdDsgnItrEntity) obj;
		return Objects.equals(activePostId, other.activePostId) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(empId, other.empId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(postId, other.postId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(tedpUpdDsgnId, other.tedpUpdDsgnId)
				&& Objects.equals(tedpUpdDsgnItrId, other.tedpUpdDsgnItrId) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(wfRoleId, other.wfRoleId) && Objects.equals(hasObjection, other.hasObjection)
				&& Objects.equals(objectionRemarks, other.objectionRemarks) && Objects.equals(wfInRequest, other.wfInRequest);

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

	
}
