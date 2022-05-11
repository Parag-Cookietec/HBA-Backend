package gov.ifms.doi.jpa.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
/**
 * 
 * @author Sagar Patil
 *
 */

public class DoiJpaSchemePolicyMasterDTO extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long schemeId;
	private String schemeNameEnglish;
	private String schemeNameGujrati;
	private String schemeShortName;
	private String nodelOfficeName;
	private Long nodelOfficeId;
	private Double claimAmount;
	private String remarks;
	private Long schemeStatusId;
	private String schemeStatus;
	private String referenceNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDate;

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
	 * @return the schemeNameEnglish
	 */
	public String getSchemeNameEnglish() {
		return schemeNameEnglish;
	}

	/**
	 * @param schemeNameEnglish the schemeNameEnglish to set
	 */
	public void setSchemeNameEnglish(String schemeNameEnglish) {
		this.schemeNameEnglish = schemeNameEnglish;
	}

	/**
	 * @return the schemeNameGujrati
	 */
	public String getSchemeNameGujrati() {
		return schemeNameGujrati;
	}

	/**
	 * @param schemeNameGujrati the schemeNameGujrati to set
	 */
	public void setSchemeNameGujrati(String schemeNameGujrati) {
		this.schemeNameGujrati = schemeNameGujrati;
	}

	/**
	 * @return the schemeShortName
	 */
	public String getSchemeShortName() {
		return schemeShortName;
	}

	/**
	 * @param schemeShortName the schemeShortName to set
	 */
	public void setSchemeShortName(String schemeShortName) {
		this.schemeShortName = schemeShortName;
	}

	/**
	 * @return the nodelOfficeName
	 */
	public String getNodelOfficeName() {
		return nodelOfficeName;
	}

	/**
	 * @param nodelOfficeName the nodelOfficeName to set
	 */
	public void setNodelOfficeName(String nodelOfficeName) {
		this.nodelOfficeName = nodelOfficeName;
	}

	/**
	 * @return the nodelOfficeId
	 */
	public Long getNodelOfficeId() {
		return nodelOfficeId;
	}

	/**
	 * @param nodelOfficeId the nodelOfficeId to set
	 */
	public void setNodelOfficeId(Long nodelOfficeId) {
		this.nodelOfficeId = nodelOfficeId;
	}

	/**
	 * @return the claimAmount
	 */
	public Double getClaimAmount() {
		return claimAmount;
	}

	/**
	 * @param claimAmount the claimAmount to set
	 */
	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
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
	 * @return the schemeStatusId
	 */
	public Long getSchemeStatusId() {
		return schemeStatusId;
	}

	/**
	 * @param schemeStatusId the schemeStatusId to set
	 */
	public void setSchemeStatusId(Long schemeStatusId) {
		this.schemeStatusId = schemeStatusId;
	}

	/**
	 * @return the schemeStatus
	 */
	public String getSchemeStatus() {
		return schemeStatus;
	}

	/**
	 * @param schemeStatus the schemeStatus to set
	 */
	public void setSchemeStatus(String schemeStatus) {
		this.schemeStatus = schemeStatus;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the referenceDate
	 */
	public Date getReferenceDate() {
		return referenceDate;
	}

	/**
	 * @param referenceDate the referenceDate to set
	 */
	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

}
