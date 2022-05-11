/*
 * 
 */
package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

/**
 * The Class EDPTrnUpdDsgnDto.
 */
public class EDPTrnUpdDsgnDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tedp upd dsgn id. */
	private Long tedpUpdDsgnId;

	/** The office id. */
	@NotNull
	private Long officeId;

	/** The office name. */
	private String officeName;

	/** The district name. */
	private String districtName;

	/** The ddo number. */
	private String ddoNumber;

	/** The cardex no. */
	private Long cardexNo;

	/** The trn no. */
	private String trnNo;

	/** The emp id. */
	@NotNull
	private Long empId;

	/** The emp name. */
	private String empName;

	/** The emp no. */
	private String empNo;

	/** The active post id. */
	@NotNull
	private Long activePostId;

	/** The active post name. */
	private String activePostName;

	/** The designation id. */
	@NotNull
	private Long designationId;

	/** The designation name. */
	private String designationName;

	/** The post id. */
	private Long postId;

	/** The post name. */
	private String postName;

	/** The status id. */
	private Long statusId;

	/** The menu sh code. */
	private String menuShCode;

	/** The district id. */
	private Long districtId;

	/** The has objection. */
	private boolean objection;

	/** The objection remarks. */
	private String objectionRemarks;

	/** The is objection required. */
	private boolean isObjectionRequired;

	/** The wf in request. */
	private Boolean wfInRequest;

	/** The is wf submite. */
	private boolean wfSubmit;

	/** The wf save drft api call. */
	private boolean wfSaveDrftApiCall;

	/** The emp post view. */
	private List<EDPEmpPostDsgnView> empPostView;

	/**
	 * Gets the tedp upd dsgn id.
	 *
	 * @return the tedpUpdDsgnId
	 */
	public Long getTedpUpdDsgnId() {
		return tedpUpdDsgnId;
	}

	/**
	 * Sets the tedp upd dsgn id.
	 *
	 * @param tedpUpdDsgnId the tedpUpdDsgnId to set
	 */
	public void setTedpUpdDsgnId(Long tedpUpdDsgnId) {
		this.tedpUpdDsgnId = tedpUpdDsgnId;
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
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the active post id.
	 *
	 * @return the activePostId
	 */
	public Long getActivePostId() {
		return activePostId;
	}

	/**
	 * Sets the active post id.
	 *
	 * @param activePostId the activePostId to set
	 */
	public void setActivePostId(Long activePostId) {
		this.activePostId = activePostId;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the district name.
	 *
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Gets the ddo number.
	 *
	 * @return the ddoNumber
	 */
	public String getDdoNumber() {
		return ddoNumber;
	}

	/**
	 * Sets the ddo number.
	 *
	 * @param ddoNumber the ddoNumber to set
	 */
	public void setDdoNumber(String ddoNumber) {
		this.ddoNumber = ddoNumber;
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
	 * Gets the emp name.
	 *
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the active post name.
	 *
	 * @return the activePostName
	 */
	public String getActivePostName() {
		return activePostName;
	}

	/**
	 * Sets the active post name.
	 *
	 * @param activePostName the activePostName to set
	 */
	public void setActivePostName(String activePostName) {
		this.activePostName = activePostName;
	}

	/**
	 * Gets the designation name.
	 *
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets the designation name.
	 *
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
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
	 * Gets the menu sh code.
	 *
	 * @return the menuShCode
	 */
	public String getMenuShCode() {
		return menuShCode;
	}

	/**
	 * Sets the menu sh code.
	 *
	 * @param menuShCode the menuShCode to set
	 */
	public void setMenuShCode(String menuShCode) {
		this.menuShCode = menuShCode;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activePostId, activePostName, cardexNo, ddoNumber, designationId, designationName,
				districtName, empId, empName, empNo, officeId, officeName, postId, postName, statusId, tedpUpdDsgnId,
				trnNo, menuShCode);
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
		if (!(obj instanceof EDPTrnUpdDsgnDto)) {
			return false;
		}
		EDPTrnUpdDsgnDto other = (EDPTrnUpdDsgnDto) obj;
		return Objects.equals(activePostId, other.activePostId) && Objects.equals(activePostName, other.activePostName)
				&& Objects.equals(menuShCode, other.menuShCode) && Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(ddoNumber, other.ddoNumber) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(designationName, other.designationName)
				&& Objects.equals(districtName, other.districtName) && Objects.equals(empId, other.empId)
				&& Objects.equals(empName, other.empName) && Objects.equals(empNo, other.empNo)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(postId, other.postId) && Objects.equals(postName, other.postName)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(tedpUpdDsgnId, other.tedpUpdDsgnId)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(objection, other.objection)
				&& Objects.equals(objectionRemarks, other.objectionRemarks)
				&& Objects.equals(isObjectionRequired, other.isObjectionRequired)
				&& Objects.equals(wfInRequest, other.wfInRequest);
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
	 * Checks if is objection.
	 *
	 * @return true, if is objection
	 */
	public boolean isObjection() {
		return objection;
	}

	/**
	 * Sets the objection.
	 *
	 * @param objection the new objection
	 */
	public void setObjection(boolean objection) {
		this.objection = objection;
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
	 * Checks if is objection required.
	 *
	 * @return true, if is objection required
	 */
	public boolean isObjectionRequired() {
		return isObjectionRequired;
	}

	/**
	 * Sets the objection required.
	 *
	 * @param isObjectionRequired the new objection required
	 */
	public void setObjectionRequired(boolean isObjectionRequired) {
		this.isObjectionRequired = isObjectionRequired;
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
	 * Checks if is wf submit.
	 *
	 * @return true, if is wf submit
	 */
	public boolean isWfSubmit() {
		return wfSubmit;
	}

	/**
	 * Sets the wf submit.
	 *
	 * @param wfSubmit the new wf submit
	 */
	public void setWfSubmit(boolean wfSubmit) {
		this.wfSubmit = wfSubmit;
	}

	/**
	 * Checks if is wf save drft api call.
	 *
	 * @return true, if is wf save drft api call
	 */
	public boolean isWfSaveDrftApiCall() {
		return wfSaveDrftApiCall;
	}

	/**
	 * Sets the wf save drft api call.
	 *
	 * @param wfSaveDrftApiCall the new wf save drft api call
	 */
	public void setWfSaveDrftApiCall(boolean wfSaveDrftApiCall) {
		this.wfSaveDrftApiCall = wfSaveDrftApiCall;
	}

	/**
	 * Gets the emp post view.
	 *
	 * @return the emp post view
	 */
	public List<EDPEmpPostDsgnView> getEmpPostView() {
		return empPostView;
	}

	/**
	 * Sets the emp post view.
	 *
	 * @param empPostView the new emp post view
	 */
	public void setEmpPostView(List<EDPEmpPostDsgnView> empPostView) {
		this.empPostView = empPostView;
	}

}
