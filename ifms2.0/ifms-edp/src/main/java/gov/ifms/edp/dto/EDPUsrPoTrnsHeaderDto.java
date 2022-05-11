package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPUsrPoTrnsHeaderDto.
 */
public class EDPUsrPoTrnsHeaderDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn no. */
	private String trnNo;
	
	/** The trn date. */
	private Date trnDate;

	/** The menu code. */
	private String menuCode;

	/** The edp usr po trns detail dto. */
	private List<EDPUsrPoTrnsDetailDto> edpUsrPoTrnsDetailDto;

	/** The edp usr po trns att dtos. */
	private List<EDPUsrPoTrnsAttDto> edpUsrPoTrnsAttDtos;

	/** The edp usr po trns header id. */
	private Long edpUsrPoTrnsHeaderId;

	/** The office id. */
	private Long officeId;

	/** The district id. */
	private Long districtId;

	/** The status id. */
	private Long statusId;

	/** The from user id. */
	private Long fromUserId;

	/** The to user id. */
	private Long toUserId;
	
	/** The to emp id. */
	private Long toEmpId;

	/** The from user code. */
	private String fromUserCode;

	/** The to user code. */
	private String toUserCode;

	/** The from user name. */
	private String fromUserName;

	/** The to user name. */
	private String toUserName;

	/** The office name. */
	private String officeName;

	/** The edp usr po trns id. */
	private Long edpUsrPoTrnsId;

	/** The post office id. */
	private Long postOfficeId;

	/** The post name. */
	private String postName;

	/** The from user post. */
	private EDPUserPostDto fromUserPost;

	/** The to user post. */
	private EDPUserPostDto toUserPost;

	/** The vacant posts dto. */
	private List<EDPPostMapDto> vacantPostsDto;
	
	/** The detail dto. */
	private List<ClueDto> detailDto;

	/** The has objection. */
	private Boolean hasObjection;

	/** The objection remarks. */
	private String objectionRemarks;

	/** The wf request dto. */
	private EdpWorkflowRequestDto wfRequestDto;
	
	/** The initiated by. */
	private Long initiatedBy;

	/** The is objection required. */
	private Boolean isObjectionRequired;
	
	/** The is wf in request. */
	private boolean wfInRequest;
	
	/** The is wf submite. */
	private boolean wfSubmit;
	
	/** The wf save drft api call. */
	private boolean wfSaveDrftApiCall;

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
	 * Gets the menu code.
	 *
	 * @return the menuCode
	 */
	public String getMenuCode() {
		return menuCode;
	}

	/**
	 * Sets the menu code.
	 *
	 * @param menuCode the menuCode to set
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	/**
	 * Gets the edp usr po trns att dtos.
	 *
	 * @return the edpUsrPoTrnsAttDtos
	 */
	public List<EDPUsrPoTrnsAttDto> getEdpUsrPoTrnsAttDtos() {
		return edpUsrPoTrnsAttDtos;
	}

	/**
	 * Sets the edp usr po trns att dtos.
	 *
	 * @param edpUsrPoTrnsAttDtos the edpUsrPoTrnsAttDtos to set
	 */
	public void setEdpUsrPoTrnsAttDtos(List<EDPUsrPoTrnsAttDto> edpUsrPoTrnsAttDtos) {
		this.edpUsrPoTrnsAttDtos = edpUsrPoTrnsAttDtos;
	}

	
	/**
	 * Gets the edp usr po trns detail dto.
	 *
	 * @return the edp usr po trns detail dto
	 */
	public List<EDPUsrPoTrnsDetailDto> getEdpUsrPoTrnsDetailDto() {
		return edpUsrPoTrnsDetailDto;
	}

	/**
	 * Sets the edp usr po trns detail dto.
	 *
	 * @param edpUsrPoTrnsDetailDto the new edp usr po trns detail dto
	 */
	public void setEdpUsrPoTrnsDetailDto(List<EDPUsrPoTrnsDetailDto> edpUsrPoTrnsDetailDto) {
		this.edpUsrPoTrnsDetailDto = edpUsrPoTrnsDetailDto;
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
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
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
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the from user id.
	 *
	 * @return the fromUserId
	 */
	public Long getFromUserId() {
		return fromUserId;
	}

	/**
	 * Sets the from user id.
	 *
	 * @param fromUserId the fromUserId to set
	 */
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	/**
	 * Gets the to user id.
	 *
	 * @return the toUserId
	 */
	public Long getToUserId() {
		return toUserId;
	}

	/**
	 * Sets the to user id.
	 *
	 * @param toUserId the toUserId to set
	 */
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	/**
	 * Gets the to emp id.
	 *
	 * @return the toEmpId
	 */
	public Long getToEmpId() {
		return toEmpId;
	}

	/**
	 * Sets the to emp id.
	 *
	 * @param toEmpId the toEmpId to set
	 */
	public void setToEmpId(Long toEmpId) {
		this.toEmpId = toEmpId;
	}

	
	/**
	 * Gets the from user code.
	 *
	 * @return the from user code
	 */
	public String getFromUserCode() {
		return fromUserCode;
	}

	/**
	 * Sets the from user code.
	 *
	 * @param fromUserCode the new from user code
	 */
	public void setFromUserCode(String fromUserCode) {
		this.fromUserCode = fromUserCode;
	}

	/**
	 * Gets the to user code.
	 *
	 * @return the to user code
	 */
	public String getToUserCode() {
		return toUserCode;
	}

	/**
	 * Sets the to user code.
	 *
	 * @param toUserCode the new to user code
	 */
	public void setToUserCode(String toUserCode) {
		this.toUserCode = toUserCode;
	}

	
	/**
	 * Gets the from user name.
	 *
	 * @return the from user name
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * Sets the from user name.
	 *
	 * @param fromUserName the new from user name
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * Gets the to user name.
	 *
	 * @return the to user name
	 */
	public String getToUserName() {
		return toUserName;
	}

	/**
	 * Sets the to user name.
	 *
	 * @param toUserName the new to user name
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	/**
	 * Gets the trn date.
	 *
	 * @return the trnDate
	 */
	public Date getTrnDate() {
		return trnDate;
	}

	/**
	 * Sets the trn date.
	 *
	 * @param trnDate the trnDate to set
	 */
	public void setTrnDate(Date trnDate) {
		this.trnDate = trnDate;
	}

	
	/**
	 * Gets the edp usr po trns id.
	 *
	 * @return the edp usr po trns id
	 */
	public Long getEdpUsrPoTrnsId() {
		return edpUsrPoTrnsId;
	}

	/**
	 * Sets the edp usr po trns id.
	 *
	 * @param edpUsrPoTrnsId the new edp usr po trns id
	 */
	public void setEdpUsrPoTrnsId(Long edpUsrPoTrnsId) {
		this.edpUsrPoTrnsId = edpUsrPoTrnsId;
	}

	/**
	 * Gets the post office id.
	 *
	 * @return the post office id
	 */
	public Long getPostOfficeId() {
		return postOfficeId;
	}

	/**
	 * Sets the post office id.
	 *
	 * @param postOfficeId the new post office id
	 */
	public void setPostOfficeId(Long postOfficeId) {
		this.postOfficeId = postOfficeId;
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
	 * Gets the from user post.
	 *
	 * @return the from user post
	 */
	public EDPUserPostDto getFromUserPost() {
		return fromUserPost;
	}

	/**
	 * Sets the from user post.
	 *
	 * @param fromUserPost the new from user post
	 */
	public void setFromUserPost(EDPUserPostDto fromUserPost) {
		this.fromUserPost = fromUserPost;
	}

	/**
	 * Gets the to user post.
	 *
	 * @return the to user post
	 */
	public EDPUserPostDto getToUserPost() {
		return toUserPost;
	}

	/**
	 * Sets the to user post.
	 *
	 * @param toUserPost the new to user post
	 */
	public void setToUserPost(EDPUserPostDto toUserPost) {
		this.toUserPost = toUserPost;
	}

	
	/**
	 * Gets the vacant posts dto.
	 *
	 * @return the vacant posts dto
	 */
	public List<EDPPostMapDto> getVacantPostsDto() {
		return vacantPostsDto;
	}

	/**
	 * Sets the vacant posts dto.
	 *
	 * @param vacantPostsDto the new vacant posts dto
	 */
	public void setVacantPostsDto(List<EDPPostMapDto> vacantPostsDto) {
		this.vacantPostsDto = vacantPostsDto;
	}

	
	/**
	 * Gets the detail dto.
	 *
	 * @return the detail dto
	 */
	public List<ClueDto> getDetailDto() {
		return detailDto;
	}

	/**
	 * Sets the detail dto.
	 *
	 * @param detailDto the new detail dto
	 */
	public void setDetailDto(List<ClueDto> detailDto) {
		this.detailDto = detailDto;
	}

	/**
	 * Gets the checks for objection.
	 *
	 * @return the checks for objection
	 */
	public Boolean getHasObjection() {
		return hasObjection;
	}

	/**
	 * Sets the checks for objection.
	 *
	 * @param hasObjection the new checks for objection
	 */
	public void setHasObjection(Boolean hasObjection) {
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
	 * Gets the wf request dto.
	 *
	 * @return the wf request dto
	 */
	public EdpWorkflowRequestDto getWfRequestDto() {
		return wfRequestDto;
	}

	/**
	 * Sets the wf request dto.
	 *
	 * @param wfRequestDto the new wf request dto
	 */
	public void setWfRequestDto(EdpWorkflowRequestDto wfRequestDto) {
		this.wfRequestDto = wfRequestDto;
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
	 * Gets the checks if is objection required.
	 *
	 * @return the checks if is objection required
	 */
	public Boolean getIsObjectionRequired() {
		return isObjectionRequired;
	}

	/**
	 * Sets the checks if is objection required.
	 *
	 * @param isObjectionRequired the new checks if is objection required
	 */
	public void setIsObjectionRequired(Boolean isObjectionRequired) {
		this.isObjectionRequired = isObjectionRequired;
	}

	/**
	 * Checks if is wf in request.
	 *
	 * @return true, if is wf in request
	 */
	public boolean isWfInRequest() {
		return wfInRequest;
	}

	/**
	 * Sets the wf in request.
	 *
	 * @param wfInRequest the new wf in request
	 */
	public void setWfInRequest(boolean wfInRequest) {
		this.wfInRequest = wfInRequest;
	}

	/**
	 * Checks if is wf submite.
	 *
	 * @return true, if is wf submite
	 */
	public boolean isWfSubmit() {
		return wfSubmit;
	}
	
	/**
	 * Sets the wf submite.
	 *
	 * @param wfSubmite the new wf submite
	 */
	public void setWfSubmit(boolean wfSubmit) {
		this.wfSubmit = wfSubmit;
	}
	
	/**
	 * @return the wfSaveDrftApiCall
	 */
	public boolean isWfSaveDrftApiCall() {
		return wfSaveDrftApiCall;
	}

	/**
	 * @param wfSaveDrftApiCall the wfSaveDrftApiCall to set
	 */
	public void setWfSaveDrftApiCall(boolean wfSaveDrftApiCall) {
		this.wfSaveDrftApiCall = wfSaveDrftApiCall;
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
		result = prime * result + Objects.hash(detailDto, districtId, edpUsrPoTrnsAttDtos, edpUsrPoTrnsDetailDto,
				edpUsrPoTrnsHeaderId, edpUsrPoTrnsId, fromUserCode, fromUserId, fromUserName, fromUserPost,
				hasObjection, initiatedBy, isObjectionRequired, menuCode, objectionRemarks, officeId, officeName,
				postName, postOfficeId, statusId, toEmpId, toUserCode, toUserId, toUserName, toUserPost, trnDate, trnNo,
				vacantPostsDto, wfInRequest, wfRequestDto, wfSaveDrftApiCall, wfSubmit);
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
		if (!(obj instanceof EDPUsrPoTrnsHeaderDto)) {
			return false;
		}
		EDPUsrPoTrnsHeaderDto other = (EDPUsrPoTrnsHeaderDto) obj;
		return Objects.equals(detailDto, other.detailDto) && Objects.equals(districtId, other.districtId)
				&& Objects.equals(edpUsrPoTrnsAttDtos, other.edpUsrPoTrnsAttDtos)
				&& Objects.equals(edpUsrPoTrnsDetailDto, other.edpUsrPoTrnsDetailDto)
				&& Objects.equals(edpUsrPoTrnsHeaderId, other.edpUsrPoTrnsHeaderId)
				&& Objects.equals(edpUsrPoTrnsId, other.edpUsrPoTrnsId)
				&& Objects.equals(fromUserCode, other.fromUserCode) && Objects.equals(fromUserId, other.fromUserId)
				&& Objects.equals(fromUserName, other.fromUserName) && Objects.equals(fromUserPost, other.fromUserPost)
				&& Objects.equals(hasObjection, other.hasObjection) && Objects.equals(initiatedBy, other.initiatedBy)
				&& Objects.equals(isObjectionRequired, other.isObjectionRequired)
				&& Objects.equals(menuCode, other.menuCode) && Objects.equals(objectionRemarks, other.objectionRemarks)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(postName, other.postName) && Objects.equals(postOfficeId, other.postOfficeId)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(toEmpId, other.toEmpId)
				&& Objects.equals(toUserCode, other.toUserCode) && Objects.equals(toUserId, other.toUserId)
				&& Objects.equals(toUserName, other.toUserName) && Objects.equals(toUserPost, other.toUserPost)
				&& Objects.equals(trnDate, other.trnDate) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(vacantPostsDto, other.vacantPostsDto) && wfInRequest == other.wfInRequest
				&& Objects.equals(wfRequestDto, other.wfRequestDto) && wfSaveDrftApiCall == other.wfSaveDrftApiCall
				&& wfSubmit == other.wfSubmit;
	}

}
