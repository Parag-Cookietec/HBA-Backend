package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class EDPMenuUserRightsAndRolesViewDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EDPMenuUserRightsAndRolesViewDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn id. */
	private Long trnId;
	
	/** The trn no. */
	private String trnNo;

	/** The trn date. */
	private Long empId;

	/** The district. */
	private Long district;

	/** The cardex no. */
	private String cardexNo;

	/** The ddo no. */
	private String ddoNo;

	/** The ddo office. */
	private String ddoOffice;

	/** The emp no. */
	private String empNo;

	/** The emp name. */
	private String empName;

	/** The status. */
	private String status;

	/** The trn date. */
	private Date trnDate;

	/** The post view. */
	private EDPEmployeePostSearchView postView;

	/** The rights dto. */
	private List<EDPUserMenuRightsAddedDto> addedRightsDto;

	/** The removed rights dto. */
	private List<EDPUserMenuRightsAddedDto> removedRightsDto;
	
	/** The has objection. */
	private boolean hasObjection;

	/** The objection remarks. */
	private String objectionRemarks;

	/** The is objection required. */
	private boolean isObjectionRequired;
	
	/** The is wf in request. */
	private boolean wfInRequest;
	
	
	/**
	 * Gets the trn id.
	 *
	 * @return the trn id
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the new trn id
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trn no
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the new trn no
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public Long getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the new district
	 */
	public void setDistrict(Long district) {
		this.district = district;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the ddo office.
	 *
	 * @return the ddo office
	 */
	public String getDdoOffice() {
		return ddoOffice;
	}

	/**
	 * Sets the ddo office.
	 *
	 * @param ddoOffice the new ddo office
	 */
	public void setDdoOffice(String ddoOffice) {
		this.ddoOffice = ddoOffice;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the emp no
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the new emp no
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the emp name
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the new emp name
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * Gets the post view.
	 *
	 * @return the post view
	 */
	public EDPEmployeePostSearchView getPostView() {
		return postView;
	}

	/**
	 * Sets the post view.
	 *
	 * @param postView the new post view
	 */
	public void setPostView(EDPEmployeePostSearchView postView) {
		this.postView = postView;
	}

	/**
	 * Gets the added rights dto.
	 *
	 * @return the added rights dto
	 */
	public List<EDPUserMenuRightsAddedDto> getAddedRightsDto() {
		return addedRightsDto;
	}

	/**
	 * Sets the added rights dto.
	 *
	 * @param addedRightsDto the new added rights dto
	 */
	public void setAddedRightsDto(List<EDPUserMenuRightsAddedDto> addedRightsDto) {
		this.addedRightsDto = addedRightsDto;
	}

	/**
	 * Gets the removed rights dto.
	 *
	 * @return the removed rights dto
	 */
	public List<EDPUserMenuRightsAddedDto> getRemovedRightsDto() {
		return removedRightsDto;
	}

	/**
	 * Sets the removed rights dto.
	 *
	 * @param removedRightsDto the new removed rights dto
	 */
	public void setRemovedRightsDto(List<EDPUserMenuRightsAddedDto> removedRightsDto) {
		this.removedRightsDto = removedRightsDto;
	}

	/**
	 * @return the hasObjection
	 */
	public boolean isHasObjection() {
		return hasObjection;
	}

	/**
	 * @param hasObjection the hasObjection to set
	 */
	public void setHasObjection(boolean hasObjection) {
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
	 * @return the isObjectionRequired
	 */
	public boolean isObjectionRequired() {
		return isObjectionRequired;
	}

	/**
	 * @param isObjectionRequired the isObjectionRequired to set
	 */
	public void setObjectionRequired(boolean isObjectionRequired) {
		this.isObjectionRequired = isObjectionRequired;
	}

	/**
	 * @return the wfInRequest
	 */
	public boolean isWfInRequest() {
		return wfInRequest;
	}

	/**
	 * @param wfInRequest the wfInRequest to set
	 */
	public void setWfInRequest(boolean wfInRequest) {
		this.wfInRequest = wfInRequest;
	}

	/**
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
		return Objects.hash(addedRightsDto, cardexNo, ddoNo, ddoOffice, district, empId, empName, empNo, hasObjection,
				isObjectionRequired, objectionRemarks, postView, removedRightsDto, status, trnDate, trnId, trnNo,
				wfInRequest);
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
		if (!(obj instanceof EDPMenuUserRightsAndRolesViewDto)) {
			return false;
		}
		EDPMenuUserRightsAndRolesViewDto other = (EDPMenuUserRightsAndRolesViewDto) obj;
		return Objects.equals(addedRightsDto, other.addedRightsDto) && Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(ddoOffice, other.ddoOffice)
				&& Objects.equals(district, other.district) && Objects.equals(empId, other.empId)
				&& Objects.equals(empName, other.empName) && Objects.equals(empNo, other.empNo)
				&& hasObjection == other.hasObjection && isObjectionRequired == other.isObjectionRequired
				&& Objects.equals(objectionRemarks, other.objectionRemarks) && Objects.equals(postView, other.postView)
				&& Objects.equals(removedRightsDto, other.removedRightsDto) && Objects.equals(status, other.status)
				&& Objects.equals(trnDate, other.trnDate) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(trnNo, other.trnNo) && wfInRequest == other.wfInRequest;
	}
		
}
