package gov.ifms.doi.jpa.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DistrictDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("value")
	private Long districtId;

	private String stdCode;

	private Long stateId;

	private String stateCode;

	private String headQuartersGuj;

	private String headquarters;

	private Date effectiveDate;

	private String districtShortCode;

	private String districtNameGuj;

	@JsonProperty("viewValue")
	private String districtName;

	private String districtDescGuj;

	private String districtDesc;

	private String districtCodeName;

	private String districtCodeGuj;

	private String districtCode;

	private List<TalukaDTO> taluka;

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
	 * @return the stdCode
	 */
	public String getStdCode() {
		return stdCode;
	}

	/**
	 * @param stdCode the stdCode to set
	 */
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

	/**
	 * @return the stateId
	 */
	public Long getStateId() {
		return stateId;
	}

	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the headQuartersGuj
	 */
	public String getHeadQuartersGuj() {
		return headQuartersGuj;
	}

	/**
	 * @param headQuartersGuj the headQuartersGuj to set
	 */
	public void setHeadQuartersGuj(String headQuartersGuj) {
		this.headQuartersGuj = headQuartersGuj;
	}

	/**
	 * @return the headquarters
	 */
	public String getHeadquarters() {
		return headquarters;
	}

	/**
	 * @param headquarters the headquarters to set
	 */
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the districtShortCode
	 */
	public String getDistrictShortCode() {
		return districtShortCode;
	}

	/**
	 * @param districtShortCode the districtShortCode to set
	 */
	public void setDistrictShortCode(String districtShortCode) {
		this.districtShortCode = districtShortCode;
	}

	/**
	 * @return the districtNameGuj
	 */
	public String getDistrictNameGuj() {
		return districtNameGuj;
	}

	/**
	 * @param districtNameGuj the districtNameGuj to set
	 */
	public void setDistrictNameGuj(String districtNameGuj) {
		this.districtNameGuj = districtNameGuj;
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
	 * @return the districtDescGuj
	 */
	public String getDistrictDescGuj() {
		return districtDescGuj;
	}

	/**
	 * @param districtDescGuj the districtDescGuj to set
	 */
	public void setDistrictDescGuj(String districtDescGuj) {
		this.districtDescGuj = districtDescGuj;
	}

	/**
	 * @return the districtDesc
	 */
	public String getDistrictDesc() {
		return districtDesc;
	}

	/**
	 * @param districtDesc the districtDesc to set
	 */
	public void setDistrictDesc(String districtDesc) {
		this.districtDesc = districtDesc;
	}

	/**
	 * @return the districtCodeName
	 */
	public String getDistrictCodeName() {
		return districtCodeName;
	}

	/**
	 * @param districtCodeName the districtCodeName to set
	 */
	public void setDistrictCodeName(String districtCodeName) {
		this.districtCodeName = districtCodeName;
	}

	/**
	 * @return the districtCodeGuj
	 */
	public String getDistrictCodeGuj() {
		return districtCodeGuj;
	}

	/**
	 * @param districtCodeGuj the districtCodeGuj to set
	 */
	public void setDistrictCodeGuj(String districtCodeGuj) {
		this.districtCodeGuj = districtCodeGuj;
	}

	/**
	 * @return the districtCode
	 */
	public String getDistrictCode() {
		return districtCode;
	}

	/**
	 * @param districtCode the districtCode to set
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	/**
	 * @return the taluka
	 */
	public List<TalukaDTO> getTaluka() {
		return taluka;
	}

	/**
	 * @param taluka the taluka to set
	 */
	public void setTaluka(List<TalukaDTO> taluka) {
		this.taluka = taluka;
	}

}
