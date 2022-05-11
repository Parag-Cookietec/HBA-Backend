package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Class EDPMsDesignationDto.
 * 
 * @version 1.0
 * @created 2019/08/29 18:35:30
 *
 */
/**
 * @author AK20098889
 *
 */
public class EDPMsDesignationDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The designation id. */
	private Long designationId;

	/** The designation name. */
	@NotNull
	@Size(max = 100)
	private String designationName;

	/** The designation name guj. */
	private String designationNameGuj;

	/** The designation description. */
	private String designationDescription;

	/** The designation description guj. */
	private String designationDescriptionGuj;

	/** The designation short name. */
	private String designationShortName;

	/** The designation short name guj. */
	private String designationShortNameGuj;

	/** The designation code. */
	private String designationCode;

	/** The designation code guj. */
	private String designationCodeGuj;

	/** The parent designation id. */
	private Long parentDesignationId;

	/** The status id. */
	private Long statusId;

	/** The office id. */
	private Long officeId;

	/** The trn no. */
	private String trnNo;

	/** The trn date. */
	private Date trnDate;

	/** The menu code. */
	private String menuCode;

	/** The district name. */
	private String districtName;

	/** The ddo number. */
	private String ddoNumber;

	/** The cardex no. */
	private Long cardexNo;

	/** The office name. */
	private String officeName;

	/** The district id. */
	private Long districtId;

	/** The has objection. */
	private Boolean hasObjection;

	/** The objection remarks. */
	private String objectionRemarks;

	/** The initiated by. */
	private Long initiatedBy;

	/** The is objection required. */
	private boolean isObjectionRequired;

	/** The is wf in request. */
	private Boolean wfInRequest;

	/** The is wf submite. */
	private boolean wfSubmit;

	/** The wf save drft api call. */
	private boolean wfSaveDrftApiCall;

	/** The wf save drft api call. */
	private boolean approvedStatus;

	/**
	 * @return the approvedStatus
	 */
	public boolean isApprovedStatus() {
		return approvedStatus;
	}

	/**
	 * @param approvedStatus the approvedStatus to set
	 */
	public void setApprovedStatus(boolean approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	/**
	 * @return the wfInRequest
	 */
	public Boolean isWfInRequest() {
		return wfInRequest;
	}

	/**
	 * @param wfInRequest the wfInRequest to set
	 */
	public void setWfInRequest(Boolean wfInRequest) {
		this.wfInRequest = wfInRequest;
	}

	/**
	 * @return the isObjectionRequired
	 */
	public Boolean getIsObjectionRequired() {
		return isObjectionRequired;
	}

	/**
	 * @param isObjectionRequired the isObjectionRequired to set
	 */
	public void setIsObjectionRequired(Boolean isObjectionRequired) {
		this.isObjectionRequired = isObjectionRequired;
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
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
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
	 * Gets the designation name guj.
	 *
	 * @return the designationNameGuj
	 */
	public String getDesignationNameGuj() {
		return designationNameGuj;
	}

	/**
	 * @return the hasObjection
	 */
	public Boolean getHasObjection() {
		return hasObjection;
	}

	/**
	 * @param hasObjection the hasObjection to set
	 */
	public void setHasObjection(Boolean hasObjection) {
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
	 * @return the initiatedBy
	 */
	public Long getInitiatedBy() {
		return initiatedBy;
	}

	/**
	 * @param initiatedBy the initiatedBy to set
	 */
	public void setInitiatedBy(Long initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	/**
	 * Gets the designation description.
	 *
	 * @return the designationDescription
	 */
	public String getDesignationDescription() {
		return designationDescription;
	}

	/**
	 * Sets the designation name guj.
	 *
	 * @param designationNameGuj the designationNameGuj to set
	 */
	public void setDesignationNameGuj(String designationNameGuj) {
		this.designationNameGuj = designationNameGuj;
	}

	/**
	 * Sets the designation description.
	 *
	 * @param designationDescription the designationDescription to set
	 */
	public void setDesignationDescription(String designationDescription) {
		this.designationDescription = designationDescription;
	}

	/**
	 * Sets the designation description guj.
	 *
	 * @param designationDescriptionGuj the designationDescriptionGuj to set
	 */
	public void setDesignationDescriptionGuj(String designationDescriptionGuj) {
		this.designationDescriptionGuj = designationDescriptionGuj;
	}

	/**
	 * Gets the designation description guj.
	 *
	 * @return the designationDescriptionGuj
	 */
	public String getDesignationDescriptionGuj() {
		return designationDescriptionGuj;
	}

	/**
	 * Sets the designation short name.
	 *
	 * @param designationShortName the designationShortName to set
	 */
	public void setDesignationShortName(String designationShortName) {
		this.designationShortName = designationShortName;
	}

	/**
	 * Gets the designation short name.
	 *
	 * @return the designationShortName
	 */
	public String getDesignationShortName() {
		return designationShortName;
	}

	/**
	 * Sets the designation short name guj.
	 *
	 * @param designationShortNameGuj the designationShortNameGuj to set
	 */
	public void setDesignationShortNameGuj(String designationShortNameGuj) {
		this.designationShortNameGuj = designationShortNameGuj;
	}

	/**
	 * Gets the designation short name guj.
	 *
	 * @return the designationShortNameGuj
	 */
	public String getDesignationShortNameGuj() {
		return designationShortNameGuj;
	}

	/**
	 * Sets the designation code.
	 *
	 * @param designationCode the designationCode to set
	 */
	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	/**
	 * Gets the designation code.
	 *
	 * @return the designationCode
	 */
	public String getDesignationCode() {
		return designationCode;
	}

	/**
	 * Sets the designation code guj.
	 *
	 * @param designationCodeGuj the designationCodeGuj to set
	 */
	public void setDesignationCodeGuj(String designationCodeGuj) {
		this.designationCodeGuj = designationCodeGuj;
	}

	/**
	 * Gets the designation code guj.
	 *
	 * @return the designationCodeGuj
	 */
	public String getDesignationCodeGuj() {
		return designationCodeGuj;
	}

	/**
	 * Gets the parent designation id.
	 *
	 * @return the parentDesignationId
	 */
	public Long getParentDesignationId() {
		return parentDesignationId;
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
	 * Sets the parent designation id.
	 *
	 * @param parentDesignationId the parentDesignationId to set
	 */
	public void setParentDesignationId(Long parentDesignationId) {
		this.parentDesignationId = parentDesignationId;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(approvedStatus, cardexNo, ddoNumber, designationCode, designationCodeGuj,
				designationDescription, designationDescriptionGuj, designationId, designationName, designationNameGuj,
				designationShortName, designationShortNameGuj, districtId, districtName, hasObjection, initiatedBy,
				isObjectionRequired, menuCode, objectionRemarks, officeId, officeName, parentDesignationId, statusId,
				trnDate, trnNo, wfInRequest, wfSaveDrftApiCall, wfSubmit);
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
		if (!(obj instanceof EDPMsDesignationDto)) {
			return false;
		}
		EDPMsDesignationDto other = (EDPMsDesignationDto) obj;
		return approvedStatus == other.approvedStatus && Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(ddoNumber, other.ddoNumber) && Objects.equals(designationCode, other.designationCode)
				&& Objects.equals(designationCodeGuj, other.designationCodeGuj)
				&& Objects.equals(designationDescription, other.designationDescription)
				&& Objects.equals(designationDescriptionGuj, other.designationDescriptionGuj)
				&& Objects.equals(designationId, other.designationId)
				&& Objects.equals(designationName, other.designationName)
				&& Objects.equals(designationNameGuj, other.designationNameGuj)
				&& Objects.equals(designationShortName, other.designationShortName)
				&& Objects.equals(designationShortNameGuj, other.designationShortNameGuj)
				&& Objects.equals(districtId, other.districtId) && Objects.equals(districtName, other.districtName)
				&& Objects.equals(hasObjection, other.hasObjection) && Objects.equals(initiatedBy, other.initiatedBy)
				&& isObjectionRequired == other.isObjectionRequired && Objects.equals(menuCode, other.menuCode)
				&& Objects.equals(objectionRemarks, other.objectionRemarks) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName)
				&& Objects.equals(parentDesignationId, other.parentDesignationId)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(trnDate, other.trnDate)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(wfInRequest, other.wfInRequest)
				&& wfSaveDrftApiCall == other.wfSaveDrftApiCall && wfSubmit == other.wfSubmit;
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
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the trnDate
	 */
	public Date getTrnDate() {
		return trnDate;
	}

	/**
	 * @param trnDate the trnDate to set
	 */
	public void setTrnDate(Date trnDate) {
		this.trnDate = trnDate;
	}

	/**
	 * @return the wfSubmit
	 */
	public boolean isWfSubmit() {
		return wfSubmit;
	}

	/**
	 * @param wfSubmit the wfSubmit to set
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

}
