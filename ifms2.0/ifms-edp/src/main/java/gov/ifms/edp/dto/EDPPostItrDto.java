package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPPostItrDto.
 * 
 * @version 1.0
 * @created 2019/12/09 12:27:17
 *
 */
public class EDPPostItrDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp po itr id. */
	private Long edpPoItrId;

	/** The post id. */
	private Long postId;

	/** The transactionnumber. */
	private String transactionnumber;

	/** The post name. */
	private String postName;

	/** The post name guj. */
	private String postNameGuj;

	/** The post decscription. */
	private String postDecscription;

	/** The post decscription guj. */
	private String postDecscriptionGuj;

	/** The post code. */
	private String postCode;

	/** The post code guj. */
	private String postCodeGuj;

	/** The post code name. */
	private String postCodeName;

	/** The post type id. */
	private Long postTypeId;

	/** The parent post id. */
	private Integer parentPostId;

	/** The designation id. */
	private Long designationId;

	/** The work flow role id. */
	private Long workFlowRoleId;

	/** The status id. */
	private Short statusId;

	/**
	 * Gets the edp po itr id.
	 *
	 * @return the edpPoItrId
	 */
	public Long getEdpPoItrId() {
		return edpPoItrId;
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
	 * Gets the transactionnumber.
	 *
	 * @return the transactionnumber
	 */
	public String getTransactionnumber() {
		return transactionnumber;
	}

	/**
	 * Sets the transactionnumber.
	 *
	 * @param transactionnumber the transactionnumber to set
	 */
	public void setTransactionnumber(String transactionnumber) {
		this.transactionnumber = transactionnumber;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
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
	 * Gets the work flow role id.
	 *
	 * @return the workFlowRoleId
	 */
	public Long getWorkFlowRoleId() {
		return workFlowRoleId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Short getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Short statusId) {
		this.statusId = statusId;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(designationId, edpPoItrId, parentPostId, postCode, postCodeGuj, postCodeName,
				postDecscription, postDecscriptionGuj, postId, postName, postNameGuj, postTypeId, transactionnumber,
				workFlowRoleId, statusId);
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
		EDPPostItrDto other = (EDPPostItrDto) obj;
		return Objects.equals(designationId, other.designationId) && Objects.equals(edpPoItrId, other.edpPoItrId)
				&& Objects.equals(parentPostId, other.parentPostId) && Objects.equals(postCode, other.postCode)
				&& Objects.equals(postCodeGuj, other.postCodeGuj) && Objects.equals(postCodeName, other.postCodeName)
				&& Objects.equals(postDecscription, other.postDecscription)
				&& Objects.equals(postDecscriptionGuj, other.postDecscriptionGuj)
				&& Objects.equals(postId, other.postId) && Objects.equals(postName, other.postName)
				&& Objects.equals(postNameGuj, other.postNameGuj) && Objects.equals(postTypeId, other.postTypeId)
				&& Objects.equals(transactionnumber, other.transactionnumber)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(workFlowRoleId, other.workFlowRoleId);
	}

}