/**
 * 
 */
package gov.ifms.doi.jpa.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

/**
 * @author Rudra
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoiJpaClaimListingResponseDTO extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6631050069451485255L;

	private Long jpaClaimId;
	private String policyNum;
	private Long schemeId;
	private String schemeName;
	private Long personTypeId;
	private String disabledDied;
	private String disabledDiedName;
	private String applicantName;
	private Long districtId;
	private String districtName;
	private Long talukaId;
	private String talukaName;
	
	private Long inwardNo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private LocalDate claimEntryDate;
	
	private String fieldName;
	
	private String remarks;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private LocalDate sendOnDate;
	
	private String sendBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private LocalDate modifiedDate;
	
	private Long claimStatusId;
	
	private String claimStatus;

	/**
	 * @return the jpaClaimId
	 */
	public Long getJpaClaimId() {
		return jpaClaimId;
	}

	/**
	 * @param jpaClaimId the jpaClaimId to set
	 */
	public void setJpaClaimId(Long jpaClaimId) {
		this.jpaClaimId = jpaClaimId;
	}

	/**
	 * @return the policyNum
	 */
	public String getPolicyNum() {
		return policyNum;
	}

	/**
	 * @param policyNum the policyNum to set
	 */
	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}

	/**
	 * @return the schemeId
	 */
	public Long getSchemeId() {
		return schemeId;
	}

	/**
	 * @param schemeId the schemeId to set
	 */
	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}

	/**
	 * @return the schemeName
	 */
	public String getSchemeName() {
		return schemeName;
	}

	/**
	 * @param schemeName the schemeName to set
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	/**
	 * @return the personTypeId
	 */
	public Long getPersonTypeId() {
		return personTypeId;
	}

	/**
	 * @param personTypeId the personTypeId to set
	 */
	public void setPersonTypeId(Long personTypeId) {
		this.personTypeId = personTypeId;
	}

	/**
	 * @return the disabledDied
	 */
	public String getDisabledDied() {
		return disabledDied;
	}

	/**
	 * @param disabledDied the disabledDied to set
	 */
	public void setDisabledDied(String disabledDied) {
		this.disabledDied = disabledDied;
	}

	/**
	 * @return the disabledDiedName
	 */
	public String getDisabledDiedName() {
		return disabledDiedName;
	}

	/**
	 * @param disabledDiedName the disabledDiedName to set
	 */
	public void setDisabledDiedName(String disabledDiedName) {
		this.disabledDiedName = disabledDiedName;
	}

	/**
	 * @return the applicantName
	 */
	public String getApplicantName() {
		return applicantName;
	}

	/**
	 * @param applicantName the applicantName to set
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
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
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * @return the talukaName
	 */
	public String getTalukaName() {
		return talukaName;
	}

	/**
	 * @param talukaName the talukaName to set
	 */
	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	/**
	 * @return the inwardNo
	 */
	public Long getInwardNo() {
		return inwardNo;
	}

	/**
	 * @param inwardNo the inwardNo to set
	 */
	public void setInwardNo(Long inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * @return the claimEntryDate
	 */
	public LocalDate getClaimEntryDate() {
		return claimEntryDate;
	}

	/**
	 * @param claimEntryDate the claimEntryDate to set
	 */
	public void setClaimEntryDate(LocalDate claimEntryDate) {
		this.claimEntryDate = claimEntryDate;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the sendOnDate
	 */
	public LocalDate getSendOnDate() {
		return sendOnDate;
	}

	/**
	 * @param sendOnDate the sendOnDate to set
	 */
	public void setSendOnDate(LocalDate sendOnDate) {
		this.sendOnDate = sendOnDate;
	}

	/**
	 * @return the sendBy
	 */
	public String getSendBy() {
		return sendBy;
	}

	/**
	 * @param sendBy the sendBy to set
	 */
	public void setSendBy(String sendBy) {
		this.sendBy = sendBy;
	}

	

	/**
	 * @return the modifiedDate
	 */
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the claimStatusId
	 */
	public Long getClaimStatusId() {
		return claimStatusId;
	}

	/**
	 * @param claimStatusId the claimStatusId to set
	 */
	public void setClaimStatusId(Long claimStatusId) {
		this.claimStatusId = claimStatusId;
	}

	/**
	 * @return the claimStatus
	 */
	public String getClaimStatus() {
		return claimStatus;
	}

	/**
	 * @param claimStatus the claimStatus to set
	 */
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
}
