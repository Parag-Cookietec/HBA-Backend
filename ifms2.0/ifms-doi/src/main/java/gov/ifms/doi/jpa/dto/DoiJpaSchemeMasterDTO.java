package gov.ifms.doi.jpa.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

/**
 * 
 * @author Sagar Patil
 *
 */

public class DoiJpaSchemeMasterDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long schemeId;
	private String schemeName;
	private String schemeNameGuj;
	private String schemeShortname;
	private String nodalOffice;
	private Long nodelOfficeId;
	private Double claimAmount;
	private String remarks;
	private Long schemeStatusId;
	private String status;
	private String referenceNo;
	private Date referenceDate;
	private Long maximumAgeRange;
	private Long minimumAgeRange;

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
	 * @return the schemeNameGuj
	 */
	public String getSchemeNameGuj() {
		return schemeNameGuj;
	}

	/**
	 * @param schemeNameGuj the schemeNameGuj to set
	 */
	public void setSchemeNameGuj(String schemeNameGuj) {
		this.schemeNameGuj = schemeNameGuj;
	}

	/**
	 * @return the schemeShortname
	 */
	public String getSchemeShortname() {
		return schemeShortname;
	}

	/**
	 * @param schemeShortname the schemeShortname to set
	 */
	public void setSchemeShortname(String schemeShortname) {
		this.schemeShortname = schemeShortname;
	}

	/**
	 * @return the nodalOffice
	 */
	public String getNodalOffice() {
		return nodalOffice;
	}

	/**
	 * @param nodalOffice the nodalOffice to set
	 */
	public void setNodalOffice(String nodalOffice) {
		this.nodalOffice = nodalOffice;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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

	/**
	 * @return the maximumAgeRange
	 */
	public Long getMaximumAgeRange() {
		return maximumAgeRange;
	}

	/**
	 * @param maximumAgeRange the maximumAgeRange to set
	 */
	public void setMaximumAgeRange(Long maximumAgeRange) {
		this.maximumAgeRange = maximumAgeRange;
	}

	/**
	 * @return the minimumAgeRange
	 */
	public Long getMinimumAgeRange() {
		return minimumAgeRange;
	}

	/**
	 * @param minimumAgeRange the minimumAgeRange to set
	 */
	public void setMinimumAgeRange(Long minimumAgeRange) {
		this.minimumAgeRange = minimumAgeRange;
	}

}
