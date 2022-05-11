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
 * The Class EDPPostItrEntity.
 * 
 * @version 1.0
 * @created 2019/12/09 12:27:17
 *
 */
@Entity
@Table(name = "T_POST_ITR", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPPostItrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp po itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_POST_ITR_ID")
	private Long edpPoItrId;

	/** The post id. */
	@Column(name = "POST_ID")
	private Long postId;

	/** The transaction no. */
	@Column(name = "TRN_NO")
	private String transactionNo;

	/** The post name. */
	@Column(name = "POST_NAME")
	private String postName;

	/** The post name guj. */
	@Column(name = "POST_NAME_GUJ")
	private String postNameGuj;

	/** The post decscription. */
	@Column(name = "POST_DESCRIPTION")
	private String postDecscription;

	/** The post decscription guj. */
	@Column(name = "POST_DESCRIPTION_GUJ")
	private String postDecscriptionGuj;

	/** The post code. */
	@Column(name = "POST_CODE")
	private String postCode;

	/** The post code guj. */
	@Column(name = "POST_CODE_GUJ")
	private String postCodeGuj;

	/** The post code name. */
	@Column(name = "POST_CODE_NAME")
	private String postCodeName;

	/** The post type id. */
	@Column(name = "POST_TYPE_ID")
	private Long officeId;

	/** The parent post id. */
	@Column(name = "PARENT_POST_ID")
	private Long parentPostId;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The work flow role id. */
	@Column(name = "WF_ROLE_ID")
	private Long workFlowRoleId;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The has objection. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECTION", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isObjectionRequired;

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
	 * EDPPostItrDto Constructor.
	 */
	public EDPPostItrEntity() {
		super();
	}

	/**
	 * Gets the edp po itr id.
	 *
	 * @return the edpPoItrId
	 */
	public Long getEdpPoItrId() {
		return edpPoItrId;
	}

	/**
	 * Sets the edp po itr id.
	 *
	 * @param edpPoItrId the edpPoItrId to set
	 */
	public void setEdpPoItrId(Long edpPoItrId) {
		this.edpPoItrId = edpPoItrId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
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
	 * Gets the transaction no.
	 *
	 * @return the transactionNo
	 */
	public String getTransactionNo() {
		return transactionNo;
	}

	/**
	 * Sets the transaction no.
	 *
	 * @param transactionNo the transactionNo to set
	 */
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	/**
	 * Gets the work flow role id.
	 *
	 * @return the workFlowRoleId
	 */
	public Long getWorkFlowRoleId() {
		return workFlowRoleId;
	}

	/**
	 * Sets the work flow role id.
	 *
	 * @param workFlowRoleId the workFlowRoleId to set
	 */
	public void setWorkFlowRoleId(Long workFlowRoleId) {
		this.workFlowRoleId = workFlowRoleId;
	}

	/**
	 * Gets the post name.
	 *
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * Gets the post name guj.
	 *
	 * @return the postNameGuj
	 */
	public String getPostNameGuj() {
		return postNameGuj;
	}

	/**
	 * Sets the post name guj.
	 *
	 * @param postNameGuj the postNameGuj to set
	 */
	public void setPostNameGuj(String postNameGuj) {
		this.postNameGuj = postNameGuj;
	}

	/**
	 * Gets the post decscription.
	 *
	 * @return the postDecscription
	 */
	public String getPostDecscription() {
		return postDecscription;
	}

	/**
	 * Sets the post decscription.
	 *
	 * @param postDecscription the postDecscription to set
	 */
	public void setPostDecscription(String postDecscription) {
		this.postDecscription = postDecscription;
	}

	/**
	 * Gets the checks if is objection required.
	 *
	 * @return the checks if is objection required
	 */
	public EDPLuLookUpInfoEntity getIsObjectionRequired() {
		return isObjectionRequired;
	}

	/**
	 * Sets the checks if is objection required.
	 *
	 * @param isObjectionRequired the new checks if is objection required
	 */
	public void setIsObjectionRequired(EDPLuLookUpInfoEntity isObjectionRequired) {
		this.isObjectionRequired = isObjectionRequired;
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
	 * Gets the post decscription guj.
	 *
	 * @return the postDecscriptionGuj
	 */
	public String getPostDecscriptionGuj() {
		return postDecscriptionGuj;
	}

	/**
	 * Sets the post decscription guj.
	 *
	 * @param postDecscriptionGuj the postDecscriptionGuj to set
	 */
	public void setPostDecscriptionGuj(String postDecscriptionGuj) {
		this.postDecscriptionGuj = postDecscriptionGuj;
	}

	/**
	 * Gets the post code.
	 *
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * Sets the post code.
	 *
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * Gets the post code guj.
	 *
	 * @return the postCodeGuj
	 */
	public String getPostCodeGuj() {
		return postCodeGuj;
	}

	/**
	 * Sets the post code guj.
	 *
	 * @param postCodeGuj the postCodeGuj to set
	 */
	public void setPostCodeGuj(String postCodeGuj) {
		this.postCodeGuj = postCodeGuj;
	}

	/**
	 * Gets the post code name.
	 *
	 * @return the postCodeName
	 */
	public String getPostCodeName() {
		return postCodeName;
	}

	/**
	 * Sets the post code name.
	 *
	 * @param postCodeName the postCodeName to set
	 */
	public void setPostCodeName(String postCodeName) {
		this.postCodeName = postCodeName;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the parent post id.
	 *
	 * @return the parentPostId
	 */
	public Long getParentPostId() {
		return parentPostId;
	}

	/**
	 * Sets the parent post id.
	 *
	 * @param parentPostId the parentPostId to set
	 */
	public void setParentPostId(Long parentPostId) {
		this.parentPostId = parentPostId;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(designationId, edpPoItrId, initiatedBy, isObjectionRequired, objectionRemarks, officeId,
				parentPostId, postCode, postCodeGuj, postCodeName, postDecscription, postDecscriptionGuj, postId,
				postName, postNameGuj, statusId, transactionNo, wfInRequest, workFlowRoleId);
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
		EDPPostItrEntity other = (EDPPostItrEntity) obj;
		return Objects.equals(designationId, other.designationId) && Objects.equals(edpPoItrId, other.edpPoItrId)
				&& Objects.equals(initiatedBy, other.initiatedBy)
				&& Objects.equals(isObjectionRequired, other.isObjectionRequired)
				&& Objects.equals(objectionRemarks, other.objectionRemarks) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(parentPostId, other.parentPostId) && Objects.equals(postCode, other.postCode)
				&& Objects.equals(postCodeGuj, other.postCodeGuj) && Objects.equals(postCodeName, other.postCodeName)
				&& Objects.equals(postDecscription, other.postDecscription)
				&& Objects.equals(postDecscriptionGuj, other.postDecscriptionGuj)
				&& Objects.equals(postId, other.postId) && Objects.equals(postName, other.postName)
				&& Objects.equals(postNameGuj, other.postNameGuj) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(transactionNo, other.transactionNo) && Objects.equals(wfInRequest, other.wfInRequest)
				&& Objects.equals(workFlowRoleId, other.workFlowRoleId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPPostItrEntity [edpPoItrId=" + edpPoItrId + ", postId=" + postId + ", transactionNo=" + transactionNo
				+ ", postName=" + postName + ", postNameGuj=" + postNameGuj + ", postDecscription=" + postDecscription
				+ ", postDecscriptionGuj=" + postDecscriptionGuj + ", postCode=" + postCode + ", postCodeGuj="
				+ postCodeGuj + ", postCodeName=" + postCodeName + ", officeId=" + officeId + ", parentPostId="
				+ parentPostId + ", designationId=" + designationId + ", workFlowRoleId=" + workFlowRoleId
				+ ", statusId=" + statusId + ", isObjectionRequired=" + isObjectionRequired + ", objectionRemarks="
				+ objectionRemarks + ", initiatedBy=" + initiatedBy + ", wfInRequest=" + wfInRequest + "]";
	}

}
