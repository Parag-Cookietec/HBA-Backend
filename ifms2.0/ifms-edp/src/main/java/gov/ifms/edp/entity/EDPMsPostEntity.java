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
 * The Class EDPMsPostEntity.
 */
@Entity
@Table(name = "MS_POST", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsPostEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "POST_CODE", updatable = false)
	private String postCode;

	/** The post code guj. */
	@Column(name = "POST_CODE_GUJ")
	private String postCodeGuj;

	/** The post code name. */
	@Column(name = "POST_CODE_NAME")
	private String postCodeName;

	/** The post type id. */
	@Column(name = "POST_TYPE_ID")
	private Long postTypeId;

	/** The parent post id. */
	@Column(name = "PARENT_POST_ID")
	private Integer parentPostId;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The post short name. */
	@Column(name = "POST_SHORT_NAME")
	private String postShortName;

	/** The post short name guj. */
	@Column(name = "POST_SHORT_NAME_GUJ")
	private String postShortNameGuj;

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
	 * Instantiates a new EDP ms post entity.
	 */
	public EDPMsPostEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms post entity.
	 *
	 * @param postId the post id
	 */
	public EDPMsPostEntity(Long postId) {
		super();
		this.postId = postId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the transaction no.
	 *
	 * @return the transaction no
	 */
	public String getTransactionNo() {
		return transactionNo;
	}

	/**
	 * Sets the transaction no.
	 *
	 * @param transactionNo the new transaction no
	 */
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	/**
	 * Gets the post name.
	 *
	 * @return the post name
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the new post name
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * Gets the post name guj.
	 *
	 * @return the post name guj
	 */
	public String getPostNameGuj() {
		return postNameGuj;
	}

	/**
	 * Sets the post name guj.
	 *
	 * @param postNameGuj the new post name guj
	 */
	public void setPostNameGuj(String postNameGuj) {
		this.postNameGuj = postNameGuj;
	}

	/**
	 * Gets the post decscription.
	 *
	 * @return the post decscription
	 */
	public String getPostDecscription() {
		return postDecscription;
	}

	/**
	 * Sets the post decscription.
	 *
	 * @param postDecscription the new post decscription
	 */
	public void setPostDecscription(String postDecscription) {
		this.postDecscription = postDecscription;
	}

	/**
	 * Gets the post decscription guj.
	 *
	 * @return the post decscription guj
	 */
	public String getPostDecscriptionGuj() {
		return postDecscriptionGuj;
	}

	/**
	 * Sets the post decscription guj.
	 *
	 * @param postDecscriptionGuj the new post decscription guj
	 */
	public void setPostDecscriptionGuj(String postDecscriptionGuj) {
		this.postDecscriptionGuj = postDecscriptionGuj;
	}

	/**
	 * Gets the post code.
	 *
	 * @return the post code
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * Sets the post code.
	 *
	 * @param postCode the new post code
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * Gets the post code guj.
	 *
	 * @return the post code guj
	 */
	public String getPostCodeGuj() {
		return postCodeGuj;
	}

	/**
	 * Sets the post code guj.
	 *
	 * @param postCodeGuj the new post code guj
	 */
	public void setPostCodeGuj(String postCodeGuj) {
		this.postCodeGuj = postCodeGuj;
	}

	/**
	 * Gets the post code name.
	 *
	 * @return the post code name
	 */
	public String getPostCodeName() {
		return postCodeName;
	}

	/**
	 * Sets the post code name.
	 *
	 * @param postCodeName the new post code name
	 */
	public void setPostCodeName(String postCodeName) {
		this.postCodeName = postCodeName;
	}

	/**
	 * Gets the post type id.
	 *
	 * @return the post type id
	 */
	public Long getPostTypeId() {
		return postTypeId;
	}

	/**
	 * Sets the post type id.
	 *
	 * @param postTypeId the new post type id
	 */
	public void setPostTypeId(Long postTypeId) {
		this.postTypeId = postTypeId;
	}

	/**
	 * Gets the parent post id.
	 *
	 * @return the parent post id
	 */
	public Integer getParentPostId() {
		return parentPostId;
	}

	/**
	 * Sets the parent post id.
	 *
	 * @param parentPostId the new parent post id
	 */
	public void setParentPostId(Integer parentPostId) {
		this.parentPostId = parentPostId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designation id
	 */
	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the new designation id
	 */
	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the post short name.
	 *
	 * @return the post short name
	 */
	public String getPostShortName() {
		return postShortName;
	}

	/**
	 * Sets the post short name.
	 *
	 * @param postShortName the new post short name
	 */
	public void setPostShortName(String postShortName) {
		this.postShortName = postShortName;
	}

	/**
	 * Gets the post short name guj.
	 *
	 * @return the post short name guj
	 */
	public String getPostShortNameGuj() {
		return postShortNameGuj;
	}

	/**
	 * Sets the post short name guj.
	 *
	 * @param postShortNameGuj the new post short name guj
	 */
	public void setPostShortNameGuj(String postShortNameGuj) {
		this.postShortNameGuj = postShortNameGuj;
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
		return Objects.hash(designationId, initiatedBy, hasObjection, objectionRemarks, parentPostId, postCode,
				postCodeGuj, postCodeName, postDecscription, postDecscriptionGuj, postId, postName, postNameGuj,
				postShortName, postShortNameGuj, postTypeId, statusId, transactionNo, wfInRequest);
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
		EDPMsPostEntity other = (EDPMsPostEntity) obj;
		return Objects.equals(designationId, other.designationId) && Objects.equals(initiatedBy, other.initiatedBy)
				&& Objects.equals(hasObjection, other.hasObjection)
				&& Objects.equals(objectionRemarks, other.objectionRemarks)
				&& Objects.equals(parentPostId, other.parentPostId) && Objects.equals(postCode, other.postCode)
				&& Objects.equals(postCodeGuj, other.postCodeGuj) && Objects.equals(postCodeName, other.postCodeName)
				&& Objects.equals(postDecscription, other.postDecscription)
				&& Objects.equals(postDecscriptionGuj, other.postDecscriptionGuj)
				&& Objects.equals(postId, other.postId) && Objects.equals(postName, other.postName)
				&& Objects.equals(postNameGuj, other.postNameGuj) && Objects.equals(postShortName, other.postShortName)
				&& Objects.equals(postShortNameGuj, other.postShortNameGuj)
				&& Objects.equals(postTypeId, other.postTypeId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(transactionNo, other.transactionNo) && Objects.equals(wfInRequest, other.wfInRequest);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPMsPostEntity [postId=" + postId + ", transactionNo=" + transactionNo + ", postName=" + postName
				+ ", postNameGuj=" + postNameGuj + ", postDecscription=" + postDecscription + ", postDecscriptionGuj="
				+ postDecscriptionGuj + ", postCode=" + postCode + ", postCodeGuj=" + postCodeGuj + ", postCodeName="
				+ postCodeName + ", postTypeId=" + postTypeId + ", parentPostId=" + parentPostId + ", designationId="
				+ designationId + ", postShortName=" + postShortName + ", postShortNameGuj=" + postShortNameGuj
				+ ", statusId=" + statusId + ", isObjectionRequired=" + hasObjection + ", objectionRemarks="
				+ objectionRemarks + ", initiatedBy=" + initiatedBy + ", wfInRequest=" + wfInRequest + "]";
	}

}
