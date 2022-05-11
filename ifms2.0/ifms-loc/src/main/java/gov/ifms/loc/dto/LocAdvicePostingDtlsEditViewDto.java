/**
 * 
 */
package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocAdvicePostingDtlsEditViewDto.
 *
 * @author swath
 */
public class LocAdvicePostingDtlsEditViewDto implements Serializable {

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
	private Long fundTypeId;

	/** The fund type. */
	@NativeQueryResultColumn(index = 3)
	private String fundType;

	/**
	 * The class expend.
	 */

	@NativeQueryResultColumn(index = 4)
	private Long classExpendId;

	/** The class expend. */
	@NativeQueryResultColumn(index = 5)
	private String classExpend;

	/**
	 * The budget type.
	 */

	@NativeQueryResultColumn(index = 6)
	private Long budgetTypeId;

	/** The budget type name. */
	@NativeQueryResultColumn(index = 7)
	private String budgetTypeName;

	/**
	 * The demand code.
	 */
	@NativeQueryResultColumn(index = 8)
	private Long demandId;

	/**
	 * The demand code.
	 */
	@NativeQueryResultColumn(index = 9)
	private String demandCode;

	/**
	 * The major head name.
	 */
	@NativeQueryResultColumn(index = 10)
	private Long majorHeadId;

	/**
	 * The major head name.
	 */
	@NativeQueryResultColumn(index = 11)
	private String majorHeadName;

	/**
	 * The sub major head Id.
	 */
	@NativeQueryResultColumn(index = 12)
	private Long subMajorHeadId;

	/**
	 * The sub major head name.
	 */
	@NativeQueryResultColumn(index = 13)
	private String subMajorHeadName;

	/**
	 * The minor head id.
	 */
	@NativeQueryResultColumn(index = 14)
	private String minorHeadId;

	/**
	 * The minor head name.
	 */
	@NativeQueryResultColumn(index = 15)
	private String minorHeadName;

	/**
	 * The sub head Id.
	 */
	@NativeQueryResultColumn(index = 16)
	private String subHeadId;

	/**
	 * The sub head name.
	 */
	@NativeQueryResultColumn(index = 17)
	private String subHeadName;

	/**
	 * The detail head id.
	 */
	@NativeQueryResultColumn(index = 18)
	private String detailHeadId;

	/**
	 * The detail head name.
	 */
	@NativeQueryResultColumn(index = 19)
	private String detailHeadName;

	/**
	 * The type of estimate.
	 */
	@NativeQueryResultColumn(index = 20)
	private Long typeOfEstimateId;

	/** The type of estimate. */
	@NativeQueryResultColumn(index = 21)
	private String typeOfEstimate;

	/**
	 * The item id.
	 */
	@NativeQueryResultColumn(index = 22)
	private String itemId;

	/**
	 * The item work name.
	 */
	@NativeQueryResultColumn(index = 23)
	private String itemWorkName;

	/**
	 * The object class Id.
	 */
	@NativeQueryResultColumn(index = 24)
	private String objectClassId;

	/**
	 * The object class.
	 */
	@NativeQueryResultColumn(index = 25)
	private String objectClass;

	/**
	 * The scheme no.
	 */
	@NativeQueryResultColumn(index = 26)
	private String schemeNo;

	/**
	 * The Available amount.
	 */
	@NativeQueryResultColumn(index = 27)
	private Double availableAmount;

	/**
	 * The Expenditure amount.
	 */
	@NativeQueryResultColumn(index = 28)
	private Double expenditureAmount;

	/**
	 * The LC No.
	 */
	@NativeQueryResultColumn(index = 29)
	private String lcNumber;

	/**
	 * The Advice type.
	 */

	@NativeQueryResultColumn(index = 30)
	private Long adviceId;

	/** The advice desc. */
	@NativeQueryResultColumn(index = 31)
	private String adviceDesc;

	/** The DDO No. */
	@NativeQueryResultColumn(index = 32)
	private Long ddoNo;

	/** The Exempt type. */
	@NativeQueryResultColumn(index = 33)
	private String exemptType;

	/** The Amount type. */
	@NativeQueryResultColumn(index = 34)
	private String amountType;

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
	 * Gets the Available amount.
	 *
	 * @return the Available amount
	 */
	public Double getAvailableAmount() {
		return availableAmount;
	}

	/**
	 * Sets the Available amount.
	 *
	 * @param availableAmount the new available amount
	 */
	public void setAvailableAmount(Double availableAmount) {
		this.availableAmount = availableAmount;
	}

	/**
	 * Gets the expenditure amount.
	 *
	 * @return the expenditure amount
	 */
	public Double getExpenditureAmount() {
		return expenditureAmount;
	}

	/**
	 * Sets the expenditure amount.
	 *
	 * @param expenditureAmount the new expenditure amount
	 */
	public void setExpenditureAmount(Double expenditureAmount) {
		this.expenditureAmount = expenditureAmount;
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

	/**
	 * Gets the demand id.
	 *
	 * @return the demand id
	 */
	public Long getDemandId() {
		return demandId;
	}

	/**
	 * Sets the demand id.
	 *
	 * @param demandId the new demand id
	 */
	public void setDemandId(Long demandId) {
		this.demandId = demandId;
	}

	/**
	 * Gets the major head id.
	 *
	 * @return the major head id
	 */
	public Long getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * Sets the major head id.
	 *
	 * @param majorHeadId the new major head id
	 */
	public void setMajorHeadId(Long majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * Gets the sub major head id.
	 *
	 * @return the sub major head id
	 */
	public Long getSubMajorHeadId() {
		return subMajorHeadId;
	}

	/**
	 * Sets the sub major head id.
	 *
	 * @param subMajorHeadId the new sub major head id
	 */
	public void setSubMajorHeadId(Long subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	/**
	 * Gets the minor head id.
	 *
	 * @return the minor head id
	 */
	public String getMinorHeadId() {
		return minorHeadId;
	}

	/**
	 * Sets the minor head id.
	 *
	 * @param minorHeadId the new minor head id
	 */
	public void setMinorHeadId(String minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	/**
	 * Gets the sub head id.
	 *
	 * @return the sub head id
	 */
	public String getSubHeadId() {
		return subHeadId;
	}

	/**
	 * Sets the sub head id.
	 *
	 * @param subHeadId the new sub head id
	 */
	public void setSubHeadId(String subHeadId) {
		this.subHeadId = subHeadId;
	}

	/**
	 * Gets the detail head id.
	 *
	 * @return the detail head id
	 */
	public String getDetailHeadId() {
		return detailHeadId;
	}

	/**
	 * Sets the detail head id.
	 *
	 * @param detailHeadId the new detail head id
	 */
	public void setDetailHeadId(String detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the object class id.
	 *
	 * @return the object class id
	 */
	public String getObjectClassId() {
		return objectClassId;
	}

	/**
	 * Sets the object class id.
	 *
	 * @param objectClassId the new object class id
	 */
	public void setObjectClassId(String objectClassId) {
		this.objectClassId = objectClassId;
	}

	/**
	 * Gets the lc number.
	 *
	 * @return the lc number
	 */
	public String getLcNumber() {
		return lcNumber;
	}

	/**
	 * Sets the lc number.
	 *
	 * @param lcNumber the new lc number
	 */
	public void setLcNumber(String lcNumber) {
		this.lcNumber = lcNumber;
	}

	/**
	 * Gets the advice desc.
	 *
	 * @return the advice desc
	 */
	public String getAdviceDesc() {
		return adviceDesc;
	}

	/**
	 * Sets the advice desc.
	 *
	 * @param adviceDesc the new advice desc
	 */
	public void setAdviceDesc(String adviceDesc) {
		this.adviceDesc = adviceDesc;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public Long getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(Long ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the exempt type.
	 *
	 * @return the exempt type
	 */
	public String getExemptType() {
		return exemptType;
	}

	/**
	 * Sets the exempt type.
	 *
	 * @param exemptType the new exempt type
	 */
	public void setExemptType(String exemptType) {
		this.exemptType = exemptType;
	}

	/**
	 * Gets the fund type id.
	 *
	 * @return the fund type id
	 */
	public Long getFundTypeId() {
		return fundTypeId;
	}

	/**
	 * Sets the fund type id.
	 *
	 * @param fundTypeId the new fund type id
	 */
	public void setFundTypeId(Long fundTypeId) {
		this.fundTypeId = fundTypeId;
	}

	/**
	 * Gets the class expend id.
	 *
	 * @return the class expend id
	 */
	public Long getClassExpendId() {
		return classExpendId;
	}

	/**
	 * Sets the class expend id.
	 *
	 * @param classExpendId the new class expend id
	 */
	public void setClassExpendId(Long classExpendId) {
		this.classExpendId = classExpendId;
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
	 * Gets the type of estimate id.
	 *
	 * @return the type of estimate id
	 */
	public Long getTypeOfEstimateId() {
		return typeOfEstimateId;
	}

	/**
	 * Sets the type of estimate id.
	 *
	 * @param typeOfEstimateId the new type of estimate id
	 */
	public void setTypeOfEstimateId(Long typeOfEstimateId) {
		this.typeOfEstimateId = typeOfEstimateId;
	}

	/**
	 * Gets the advice id.
	 *
	 * @return the advice id
	 */
	public Long getAdviceId() {
		return adviceId;
	}

	/**
	 * Sets the advice id.
	 *
	 * @param adviceId the new advice id
	 */
	public void setAdviceId(Long adviceId) {
		this.adviceId = adviceId;
	}

	/**
	 * @return the amountType
	 */
	public String getAmountType() {
		return amountType;
	}

	/**
	 * @param amountType the amountType to set
	 */
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

}
