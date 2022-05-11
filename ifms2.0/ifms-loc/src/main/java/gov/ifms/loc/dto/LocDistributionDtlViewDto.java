package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocDistributionDtlViewDto.
 */
@NativeQueryResultEntity
public class LocDistributionDtlViewDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/**
	 * The hdr id.
	 */
	@NativeQueryResultColumn(index = 1)
	private Long hdrId;

	/**
	 * The fund type.
	 */
	@NativeQueryResultColumn(index = 2)
	private String fundType;

	/**
	 * The class expend.
	 */
	@NativeQueryResultColumn(index = 3)
	private String classExpend;

	/**
	 * The budget type.
	 */
	@NativeQueryResultColumn(index = 4)
	private Long budgetTypeId;

	/** The budget type name. */
	@NativeQueryResultColumn(index = 5)
	private String budgetTypeName;

	/**
	 * The demand code.
	 */
	@NativeQueryResultColumn(index = 6)
	private String demandCode;

	/**
	 * The major head name.
	 */
	@NativeQueryResultColumn(index = 7)
	private String majorHeadName;

	/**
	 * The sub major head name.
	 */
	@NativeQueryResultColumn(index = 8)
	private String subMajorHeadName;

	/**
	 * The minor head name.
	 */
	@NativeQueryResultColumn(index = 9)
	private String minorHeadName;

	/**
	 * The sub head name.
	 */
	@NativeQueryResultColumn(index = 10)
	private String subHeadName;

	/**
	 * The detail head name.
	 */
	@NativeQueryResultColumn(index = 11)
	private String detailHeadName;

	/**
	 * The type of estimate.
	 */
	@NativeQueryResultColumn(index = 12)
	private String typeOfEstimate;

	/**
	 * The item work name.
	 */
	@NativeQueryResultColumn(index = 13)
	private String itemWorkName;

	/**
	 * The object class.
	 */
	@NativeQueryResultColumn(index = 14)
	private String objectClass;

	/**
	 * The scheme no.
	 */
	@NativeQueryResultColumn(index = 15)
	private String schemeNo;

	/**
	 * The center amount.
	 */
	@NativeQueryResultColumn(index = 16)
	private Double centerAmount;
	
	/**
	 * The state amount.
	 */
	@NativeQueryResultColumn(index = 17)
	private Double stateAmount;

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
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the fund type.
	 *
	 * @return the fund type
	 */
	public String getFundType() {
		return fundType;
	}

	/**
	 * Sets the fund type.
	 *
	 * @param fundType the new fund type
	 */
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	/**
	 * Gets the class expend.
	 *
	 * @return the class expend
	 */
	public String getClassExpend() {
		return classExpend;
	}

	/**
	 * Sets the class expend.
	 *
	 * @param classExpend the new class expend
	 */
	public void setClassExpend(String classExpend) {
		this.classExpend = classExpend;
	}

	/**
	 * Gets the demand code.
	 *
	 * @return the demand code
	 */
	public String getDemandCode() {
		return demandCode;
	}

	/**
	 * Sets the demand code.
	 *
	 * @param demandCode the new demand code
	 */
	public void setDemandCode(String demandCode) {
		this.demandCode = demandCode;
	}

	/**
	 * Gets the major head name.
	 *
	 * @return the major head name
	 */
	public String getMajorHeadName() {
		return majorHeadName;
	}

	/**
	 * Sets the major head name.
	 *
	 * @param majorHeadName the new major head name
	 */
	public void setMajorHeadName(String majorHeadName) {
		this.majorHeadName = majorHeadName;
	}

	/**
	 * Gets the sub major head name.
	 *
	 * @return the sub major head name
	 */
	public String getSubMajorHeadName() {
		return subMajorHeadName;
	}

	/**
	 * Sets the sub major head name.
	 *
	 * @param subMajorHeadName the new sub major head name
	 */
	public void setSubMajorHeadName(String subMajorHeadName) {
		this.subMajorHeadName = subMajorHeadName;
	}

	/**
	 * Gets the minor head name.
	 *
	 * @return the minor head name
	 */
	public String getMinorHeadName() {
		return minorHeadName;
	}

	/**
	 * Sets the minor head name.
	 *
	 * @param minorHeadName the new minor head name
	 */
	public void setMinorHeadName(String minorHeadName) {
		this.minorHeadName = minorHeadName;
	}

	/**
	 * Gets the sub head name.
	 *
	 * @return the sub head name
	 */
	public String getSubHeadName() {
		return subHeadName;
	}

	/**
	 * Sets the sub head name.
	 *
	 * @param subHeadName the new sub head name
	 */
	public void setSubHeadName(String subHeadName) {
		this.subHeadName = subHeadName;
	}

	/**
	 * Gets the detail head name.
	 *
	 * @return the detail head name
	 */
	public String getDetailHeadName() {
		return detailHeadName;
	}

	/**
	 * Sets the detail head name.
	 *
	 * @param detailHeadName the new detail head name
	 */
	public void setDetailHeadName(String detailHeadName) {
		this.detailHeadName = detailHeadName;
	}

	/**
	 * Gets the type of estimate.
	 *
	 * @return the type of estimate
	 */
	public String getTypeOfEstimate() {
		return typeOfEstimate;
	}

	/**
	 * Sets the type of estimate.
	 *
	 * @param typeOfEstimate the new type of estimate
	 */
	public void setTypeOfEstimate(String typeOfEstimate) {
		this.typeOfEstimate = typeOfEstimate;
	}

	/**
	 * Gets the item work name.
	 *
	 * @return the item work name
	 */
	public String getItemWorkName() {
		return itemWorkName;
	}

	/**
	 * Sets the item work name.
	 *
	 * @param itemWorkName the new item work name
	 */
	public void setItemWorkName(String itemWorkName) {
		this.itemWorkName = itemWorkName;
	}

	/**
	 * Gets the object class.
	 *
	 * @return the object class
	 */
	public String getObjectClass() {
		return objectClass;
	}

	/**
	 * Sets the object class.
	 *
	 * @param objectClass the new object class
	 */
	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}

	/**
	 * Gets the scheme no.
	 *
	 * @return the scheme no
	 */
	public String getSchemeNo() {
		return schemeNo;
	}

	/**
	 * Sets the scheme no.
	 *
	 * @param schemeNo the new scheme no
	 */
	public void setSchemeNo(String schemeNo) {
		this.schemeNo = schemeNo;
	}

	
	
	/**
	 * @return the centerAmount
	 */
	public Double getCenterAmount() {
		return centerAmount;
	}

	/**
	 * @param centerAmount the centerAmount to set
	 */
	public void setCenterAmount(Double centerAmount) {
		this.centerAmount = centerAmount;
	}

	/**
	 * @return the stateAmount
	 */
	public Double getStateAmount() {
		return stateAmount;
	}

	/**
	 * @param stateAmount the stateAmount to set
	 */
	public void setStateAmount(Double stateAmount) {
		this.stateAmount = stateAmount;
	}

	/**
	 * Gets the budget type id.
	 *
	 * @return the budget type id
	 */
	public Long getBudgetTypeId() {
		return budgetTypeId;
	}

	/**
	 * Sets the budget type id.
	 *
	 * @param budgetTypeId the new budget type id
	 */
	public void setBudgetTypeId(Long budgetTypeId) {
		this.budgetTypeId = budgetTypeId;
	}

	/**
	 * Gets the budget type name.
	 *
	 * @return the budget type name
	 */
	public String getBudgetTypeName() {
		return budgetTypeName;
	}

	/**
	 * Sets the budget type name.
	 *
	 * @param budgetTypeName the new budget type name
	 */
	public void setBudgetTypeName(String budgetTypeName) {
		this.budgetTypeName = budgetTypeName;
	}
}
