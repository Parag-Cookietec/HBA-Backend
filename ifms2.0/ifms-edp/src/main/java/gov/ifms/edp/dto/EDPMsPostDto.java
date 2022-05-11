package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.oauth.dto.OAuthTokenPostDTO;

/**
 * The Class EDPMsPostDto.
 * 
 * @version 1.0
 * @created 2019/08/29 17:22:45
 *
 */
public class EDPMsPostDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post id. */
	private Long postId;

	/** The transaction no. */
	private String transactionNo;

	/** The post name. */
	@NotNull
	@NotBlank
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

	/** The post short name. */
	private String postShortName;

	/** The post short name guj. */
	private String postShortNameGuj;

	/** The is primary post. */
	private boolean isPrimaryPost = false;

	/** The oauth token post DTO. */
	private OAuthTokenPostDTO oauthTokenPostDTO;

	/** The office id. */
	@NotNull
	private Long officeId;

	/** The designation id. */
	@NotNull
	private Long designationId;

	/** The is loggin post. */
	private boolean isLoginPost = false;

	/** The work flow role id. */
	@Digits(fraction = 0, integer = Constant.DOUBLE_MAX_INTEGER)
	private Long workFlowRoleId;

	/** The menucode. */
	private String menucode;

	/** The status id. */
	private Long statusId;

	/** The district. */
	private ClueDto district;

	/** The ddo no. */
	private String ddoNo;

	/** The cardex no. */
	private Long cardexNo;

	/** The ddo office. */
	private String ddoOffice;

	/** The lk po off user id. */
	private Long lkPoOffUserId;

	/** The objection remarks. */
	private String objectionRemarks;

	/** The initiated by. */
	private Long initiatedBy;

	/** The is objection required. */
	private Boolean isObjectionRequired;

	/** The wf in request. */
	private Boolean wfInRequest;

	/** The is wf submit. */
	private boolean isWfSubmit;

	/** The is wf save drft api call. */
	private Boolean isWfSaveDrftApiCall;

	/** The has objection. */
	private boolean hasObjection;

	/** The trn date. */
	private Date trnDate;
	
	/** The branches. */
	private List<EDPMsBranchDto> branches;

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
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
	 * Gets the parent post id.
	 *
	 * @return the parentPostId
	 */
	public Integer getParentPostId() {
		return parentPostId;
	}

	/**
	 * Checks if is primary post.
	 *
	 * @return true, if is primary post
	 */
	public boolean isPrimaryPost() {
		return isPrimaryPost;
	}

	/**
	 * Sets the primary post.
	 *
	 * @param isPrimaryPost the new primary post
	 */
	public void setPrimaryPost(boolean isPrimaryPost) {
		this.isPrimaryPost = isPrimaryPost;
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
	 * Gets the oauth token post DTO.
	 *
	 * @return the oauthTokenPostDTO
	 */
	public OAuthTokenPostDTO getOauthTokenPostDTO() {
		return oauthTokenPostDTO;
	}

	/**
	 * Sets the oauth token post DTO.
	 *
	 * @param oauthTokenPostDTO the oauthTokenPostDTO to set
	 */
	public void setOauthTokenPostDTO(OAuthTokenPostDTO oauthTokenPostDTO) {
		this.oauthTokenPostDTO = oauthTokenPostDTO;
	}

	/**
	 * Checks if is login post.
	 *
	 * @return the isLoginPost
	 */
	public boolean isLoginPost() {
		return isLoginPost;
	}

	/**
	 * Sets the login post.
	 *
	 * @param isLoginPost the isLoginPost to set
	 */
	public void setLoginPost(boolean isLoginPost) {
		this.isLoginPost = isLoginPost;
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
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
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
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
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
	 * Gets the menucode.
	 *
	 * @return the menucode
	 */
	public String getMenucode() {
		return menucode;
	}

	/**
	 * Sets the menucode.
	 *
	 * @param menucode the menucode to set
	 */
	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param saveAsDraftStatusId the statusId to set
	 */
	public void setStatusId(Long saveAsDraftStatusId) {
		this.statusId = saveAsDraftStatusId;
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
	 * Gets the wf in request.
	 *
	 * @return the wf in request
	 */
	public Boolean getWfInRequest() {
		return wfInRequest;
	}

	/**
	 * Sets the wf in request.
	 *
	 * @param wfInRequest the new wf in request
	 */
	public void setWfInRequest(Boolean wfInRequest) {
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
	 * Gets the post type id.
	 *
	 * @return the postTypeId
	 */
	public Long getPostTypeId() {
		return postTypeId;
	}

	/**
	 * Sets the post type id.
	 *
	 * @param postTypeId the postTypeId to set
	 */
	public void setPostTypeId(Long postTypeId) {
		this.postTypeId = postTypeId;
	}

	/**
	 * Gets the post short name.
	 *
	 * @return the postShortName
	 */
	public String getPostShortName() {
		return postShortName;
	}

	/**
	 * Sets the post short name.
	 *
	 * @param postShortName the postShortName to set
	 */
	public void setPostShortName(String postShortName) {
		this.postShortName = postShortName;
	}

	/**
	 * Gets the post short name guj.
	 *
	 * @return the postShortNameGuj
	 */
	public String getPostShortNameGuj() {
		return postShortNameGuj;
	}

	/**
	 * Sets the post short name guj.
	 *
	 * @param postShortNameGuj the postShortNameGuj to set
	 */
	public void setPostShortNameGuj(String postShortNameGuj) {
		this.postShortNameGuj = postShortNameGuj;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public ClueDto getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the district to set
	 */
	public void setDistrict(ClueDto district) {
		this.district = district;
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
	 * Sets the parent post id.
	 *
	 * @param parentPostId the parentPostId to set
	 */
	public void setParentPostId(Integer parentPostId) {
		this.parentPostId = parentPostId;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the ddo office.
	 *
	 * @return the ddoOffice
	 */
	public String getDdoOffice() {
		return ddoOffice;
	}

	/**
	 * Sets the ddo office.
	 *
	 * @param ddoOffice the ddoOffice to set
	 */
	public void setDdoOffice(String ddoOffice) {
		this.ddoOffice = ddoOffice;
	}

	/**
	 * Gets the lk po off user id.
	 *
	 * @return the lkPoOffUserId
	 */
	public Long getLkPoOffUserId() {
		return lkPoOffUserId;
	}

	/**
	 * Sets the lk po off user id.
	 *
	 * @param lkPoOffUserId the lkPoOffUserId to set
	 */
	public void setLkPoOffUserId(Long lkPoOffUserId) {
		this.lkPoOffUserId = lkPoOffUserId;
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
	public Long getInitiatedBy() {
		return initiatedBy;
	}

	/**
	 * Sets the initiated by.
	 *
	 * @param initiatedBy the new initiated by
	 */
	public void setInitiatedBy(Long initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	/**
	 * Gets the checks for objection.
	 *
	 * @return the checks for objection
	 */
	public Boolean getIsObjectionRequired() {
		return isObjectionRequired;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Sets the checks for objection.
	 *
	 * @param isObjectionRequired the new checks for objection
	 */
	public void setIsObjectionRequired(Boolean isObjectionRequired) {
		this.isObjectionRequired = isObjectionRequired;
	}

	/**
	 * Gets the checks if is wf submit.
	 *
	 * @return the checks if is wf submit
	 */
	public boolean getIsWfSubmit() {
		return isWfSubmit;
	}

	/**
	 * Gets the checks if is wf save drft api call.
	 *
	 * @return the checks if is wf save drft api call
	 */
	public Boolean getIsWfSaveDrftApiCall() {
		return isWfSaveDrftApiCall;
	}

	/**
	 * Sets the checks if is wf save drft api call.
	 *
	 * @param isWfSaveDrftApiCall the new checks if is wf save drft api call
	 */
	public void setIsWfSaveDrftApiCall(Boolean isWfSaveDrftApiCall) {
		this.isWfSaveDrftApiCall = isWfSaveDrftApiCall;
	}

	/**
	 * Checks if is checks for objection.
	 *
	 * @return true, if is checks for objection
	 */
	public boolean isHasObjection() {
		return hasObjection;
	}

	/**
	 * Sets the checks for objection.
	 *
	 * @param hasObjection the new checks for objection
	 */
	public void setHasObjection(boolean hasObjection) {
		this.hasObjection = hasObjection;
	}

	
	/**
	 * Gets the trn date.
	 *
	 * @return the trn date
	 */
	public Date getTrnDate() {
		return trnDate;
	}

	/**
	 * Sets the trn date.
	 *
	 * @param trnDate the new trn date
	 */
	public void setTrnDate(Date trnDate) {
		this.trnDate = trnDate;
	}

	
	/**
	 * Sets the wf submit.
	 *
	 * @param isWfSubmit the new wf submit
	 */
	public void setWfSubmit(boolean isWfSubmit) {
		this.isWfSubmit = isWfSubmit;
	}
	
	
	

	/**
	 * @return the branches
	 */
	public List<EDPMsBranchDto> getBranches() {
		return branches;
	}

	/**
	 * @param branches the branches to set
	 */
	public void setBranches(List<EDPMsBranchDto> branches) {
		this.branches = branches;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cardexNo, ddoNo, ddoOffice, designationId, district, hasObjection,
				initiatedBy, isLoginPost, isObjectionRequired, isPrimaryPost, isWfSaveDrftApiCall, isWfSubmit,
				lkPoOffUserId, menucode, oauthTokenPostDTO, objectionRemarks, officeId, parentPostId, postCode,
				postCodeGuj, postCodeName, postDecscription, postDecscriptionGuj, postId, postName, postNameGuj,
				postShortName, postShortNameGuj, postTypeId, statusId, transactionNo, trnDate, wfInRequest,
				workFlowRoleId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPMsPostDto)) {
			return false;
		}
		EDPMsPostDto other = (EDPMsPostDto) obj;
		return Objects.equals(cardexNo, other.cardexNo) && Objects.equals(ddoNo, other.ddoNo)
				&& Objects.equals(ddoOffice, other.ddoOffice) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(district, other.district) && hasObjection == other.hasObjection
				&& Objects.equals(initiatedBy, other.initiatedBy) && isLoginPost == other.isLoginPost
				&& Objects.equals(isObjectionRequired, other.isObjectionRequired)
				&& isPrimaryPost == other.isPrimaryPost
				&& Objects.equals(isWfSaveDrftApiCall, other.isWfSaveDrftApiCall) && isWfSubmit == other.isWfSubmit
				&& Objects.equals(lkPoOffUserId, other.lkPoOffUserId) && Objects.equals(menucode, other.menucode)
				&& Objects.equals(oauthTokenPostDTO, other.oauthTokenPostDTO)
				&& Objects.equals(objectionRemarks, other.objectionRemarks) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(parentPostId, other.parentPostId) && Objects.equals(postCode, other.postCode)
				&& Objects.equals(postCodeGuj, other.postCodeGuj) && Objects.equals(postCodeName, other.postCodeName)
				&& Objects.equals(postDecscription, other.postDecscription)
				&& Objects.equals(postDecscriptionGuj, other.postDecscriptionGuj)
				&& Objects.equals(postId, other.postId) && Objects.equals(postName, other.postName)
				&& Objects.equals(postNameGuj, other.postNameGuj) && Objects.equals(postShortName, other.postShortName)
				&& Objects.equals(postShortNameGuj, other.postShortNameGuj)
				&& Objects.equals(postTypeId, other.postTypeId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(transactionNo, other.transactionNo) && Objects.equals(trnDate, other.trnDate)
				&& Objects.equals(wfInRequest, other.wfInRequest)
				&& Objects.equals(workFlowRoleId, other.workFlowRoleId);
	}

}
