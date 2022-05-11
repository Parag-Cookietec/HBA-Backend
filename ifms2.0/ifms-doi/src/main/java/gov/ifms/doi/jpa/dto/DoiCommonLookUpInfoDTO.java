package gov.ifms.doi.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoiCommonLookUpInfoDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Long lookupInfoId;

	@JsonProperty("value")
	private String lookupInfoValue;

	@JsonProperty("viewValue")
	private String lookupInfoName;

	private String lookupInfoNameGuj;

	private String lookupInfoDescription;

	private String lookupInfoDescriptionGuj;

	private Long parentLookupId;

	private String orderId;

	/**
	 * @return the lookupInfoId
	 */
	public Long getLookupInfoId() {
		return lookupInfoId;
	}

	/**
	 * @param lookupInfoId the lookupInfoId to set
	 */
	public void setLookupInfoId(Long lookupInfoId) {
		this.lookupInfoId = lookupInfoId;
	}

	/**
	 * @return the lookupInfoValue
	 */
	public String getLookupInfoValue() {
		return lookupInfoValue;
	}

	/**
	 * @param lookupInfoValue the lookupInfoValue to set
	 */
	public void setLookupInfoValue(String lookupInfoValue) {
		this.lookupInfoValue = lookupInfoValue;
	}

	/**
	 * @return the lookupInfoName
	 */
	public String getLookupInfoName() {
		return lookupInfoName;
	}

	/**
	 * @param lookupInfoName the lookupInfoName to set
	 */
	public void setLookupInfoName(String lookupInfoName) {
		this.lookupInfoName = lookupInfoName;
	}

	/**
	 * @return the lookupInfoNameGuj
	 */
	public String getLookupInfoNameGuj() {
		return lookupInfoNameGuj;
	}

	/**
	 * @param lookupInfoNameGuj the lookupInfoNameGuj to set
	 */
	public void setLookupInfoNameGuj(String lookupInfoNameGuj) {
		this.lookupInfoNameGuj = lookupInfoNameGuj;
	}

	/**
	 * @return the lookupInfoDescription
	 */
	public String getLookupInfoDescription() {
		return lookupInfoDescription;
	}

	/**
	 * @param lookupInfoDescription the lookupInfoDescription to set
	 */
	public void setLookupInfoDescription(String lookupInfoDescription) {
		this.lookupInfoDescription = lookupInfoDescription;
	}

	/**
	 * @return the lookupInfoDescriptionGuj
	 */
	public String getLookupInfoDescriptionGuj() {
		return lookupInfoDescriptionGuj;
	}

	/**
	 * @param lookupInfoDescriptionGuj the lookupInfoDescriptionGuj to set
	 */
	public void setLookupInfoDescriptionGuj(String lookupInfoDescriptionGuj) {
		this.lookupInfoDescriptionGuj = lookupInfoDescriptionGuj;
	}

	/**
	 * @return the parentLookupId
	 */
	public Long getParentLookupId() {
		return parentLookupId;
	}

	/**
	 * @param parentLookupId the parentLookupId to set
	 */
	public void setParentLookupId(Long parentLookupId) {
		this.parentLookupId = parentLookupId;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
