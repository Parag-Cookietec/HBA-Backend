package gov.ifms.loc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocDistributionHeadDtlDto.
 *
 * @version v 1.0
 * @created 2021/02/11 14:51:40
 */
public class LocDistributionHeadDtlDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NotNull
	private Long id;

	/** The hdr id. */
	@NotNull
	private Long hdrId;

	/** The fund type. */
	@NotNull
	private String fundType;

	/** The class expend. */
	@NotNull
	private String classExpend;

	/** The budget type. */
	@NotNull
	private Long budgetType;

	/** The demand id. */
	@NotNull
	private Long demandId;

	/** The major head id. */
	@NotNull
	private Long majorHeadId;

	/** The sub major head id. */
	@NotNull
	private Long subMajorHeadId;

	/** The minor head id. */
	@NotNull
	private Long minorHeadId;

	/** The detailed head id. */
	@NotNull
	private Long detailedHeadId;

	/** The type of estimate. */
	@NotNull
	private String typeOfEstimate;

	/** The item work name. */
	@NotNull
	private Long itemWorkName;

	/** The object class. */
	@NotNull
	private Long objectClass;

	/** The scheme no. */
	@NotNull
	private String schemeNo;

	/** The amount. */
	@NotNull
	private Double amount;

	/** The status id. */
	private Long statusId;

	/** The sub head id. */
	private Long subHeadId;

	/**
	 * LocDistributionHeadDtlDto Constructor.
	 */
	public LocDistributionHeadDtlDto() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdrId
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the hdrId to set
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the fund type.
	 *
	 * @return the fundType
	 */
	public String getFundType() {
		return fundType;
	}

	/**
	 * Sets the fund type.
	 *
	 * @param fundType the fundType to set
	 */
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	/**
	 * Gets the class expend.
	 *
	 * @return the classExpend
	 */
	public String getClassExpend() {
		return classExpend;
	}

	/**
	 * Sets the class expend.
	 *
	 * @param classExpend the classExpend to set
	 */
	public void setClassExpend(String classExpend) {
		this.classExpend = classExpend;
	}

	/**
	 * Gets the budget type.
	 *
	 * @return the budgetType
	 */
	public Long getBudgetType() {
		return budgetType;
	}

	/**
	 * Sets the budget type.
	 *
	 * @param budgetType the budgetType to set
	 */
	public void setBudgetType(Long budgetType) {
		this.budgetType = budgetType;
	}

	/**
	 * Gets the demand id.
	 *
	 * @return the demandId
	 */
	public Long getDemandId() {
		return demandId;
	}

	/**
	 * Sets the demand id.
	 *
	 * @param demandId the demandId to set
	 */
	public void setDemandId(Long demandId) {
		this.demandId = demandId;
	}

	/**
	 * Gets the major head id.
	 *
	 * @return the majorHeadId
	 */
	public Long getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * Sets the major head id.
	 *
	 * @param majorHeadId the majorHeadId to set
	 */
	public void setMajorHeadId(Long majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * Gets the sub major head id.
	 *
	 * @return the subMajorHeadId
	 */
	public Long getSubMajorHeadId() {
		return subMajorHeadId;
	}

	/**
	 * Sets the sub major head id.
	 *
	 * @param subMajorHeadId the subMajorHeadId to set
	 */
	public void setSubMajorHeadId(Long subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	/**
	 * Gets the minor head id.
	 *
	 * @return the minorHeadId
	 */
	public Long getMinorHeadId() {
		return minorHeadId;
	}

	/**
	 * Sets the minor head id.
	 *
	 * @param minorHeadId the minorHeadId to set
	 */
	public void setMinorHeadId(Long minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	/**
	 * Gets the detailed head id.
	 *
	 * @return the detailedHeadId
	 */
	public Long getDetailedHeadId() {
		return detailedHeadId;
	}

	/**
	 * Sets the detailed head id.
	 *
	 * @param detailedHeadId the detailedHeadId to set
	 */
	public void setDetailedHeadId(Long detailedHeadId) {
		this.detailedHeadId = detailedHeadId;
	}

	/**
	 * Gets the type of estimate.
	 *
	 * @return the typeOfEstimate
	 */
	public String getTypeOfEstimate() {
		return typeOfEstimate;
	}

	/**
	 * Sets the type of estimate.
	 *
	 * @param typeOfEstimate the typeOfEstimate to set
	 */
	public void setTypeOfEstimate(String typeOfEstimate) {
		this.typeOfEstimate = typeOfEstimate;
	}

	/**
	 * Gets the item work name.
	 *
	 * @return the itemWorkName
	 */
	public Long getItemWorkName() {
		return itemWorkName;
	}

	/**
	 * Sets the item work name.
	 *
	 * @param itemWorkName the itemWorkName to set
	 */
	public void setItemWorkName(Long itemWorkName) {
		this.itemWorkName = itemWorkName;
	}

	/**
	 * Gets the object class.
	 *
	 * @return the objectClass
	 */
	public Long getObjectClass() {
		return objectClass;
	}

	/**
	 * Sets the object class.
	 *
	 * @param objectClass the objectClass to set
	 */
	public void setObjectClass(Long objectClass) {
		this.objectClass = objectClass;
	}

	/**
	 * Gets the scheme no.
	 *
	 * @return the schemeNo
	 */
	public String getSchemeNo() {
		return schemeNo;
	}

	/**
	 * Sets the scheme no.
	 *
	 * @param schemeNo the schemeNo to set
	 */
	public void setSchemeNo(String schemeNo) {
		this.schemeNo = schemeNo;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
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
	 * Gets the sub head id.
	 *
	 * @return the sub head id
	 */
	public Long getSubHeadId() {

		return subHeadId;
	}

	/**
	 * Sets the sub head id.
	 *
	 * @param subHeadId the new sub head id
	 */
	public void setSubHeadId(Long subHeadId) {
		this.subHeadId = subHeadId;
	}

}
