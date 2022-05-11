package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocDistributionDtlViewDto.
 */
@NativeQueryResultEntity
public class LocAdvicePaymntLCSearchDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The demand code.
	 */
	@NativeQueryResultColumn(index = 0)
	private String lcNumber;

	/**
	 * The demand code.
	 */
	@NativeQueryResultColumn(index = 1)
	private String demandCode;

	/**
	 * The major head name.
	 */
	@NativeQueryResultColumn(index = 2)
	private String majorHeadName;

	/**
	 * The minorHead head name.
	 */
	@NativeQueryResultColumn(index = 3)
	private String minorHeadCode;

	/**
	 * The sub major head name.
	 */
	@NativeQueryResultColumn(index = 4)
	private String subMajorHeadName;
	/**
	 * The sub head name.
	 */
	@NativeQueryResultColumn(index = 5)
	private String subHeadName;
	/**
	 * The detail head name.
	 */
	@NativeQueryResultColumn(index = 6)
	private String detailHeadName;

	/**
	 * The item name.
	 */
	@NativeQueryResultColumn(index = 7)
	private String itemCode;

	/**
	 * The ObjectClass name.
	 */
	@NativeQueryResultColumn(index = 8)
	private String objectClassCode;
	/**
	 * The type of Estimate name.
	 */
	@NativeQueryResultColumn(index = 9)
	private String typeofEstimate;

	/**
	 * The ChargedVoted name.
	 */
	@NativeQueryResultColumn(index = 10)
	private String chargedVoted;

	/**
	 * The fundType.
	 */
	@NativeQueryResultColumn(index = 11)
	private String fundType;

	/**
	 * The amount.
	 */
	@NativeQueryResultColumn(index = 12)
	private Double amount;

	/**
	 * The sTATEamount.
	 */
	@NativeQueryResultColumn(index = 13)
	private Double stateAmount;

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
	 * @param amount the new amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the minor head code.
	 *
	 * @return the minor head code
	 */
	public String getMinorHeadCode() {
		return minorHeadCode;
	}

	/**
	 * Sets the minor head code.
	 *
	 * @param minorHeadCode the new minor head code
	 */
	public void setMinorHeadCode(String minorHeadCode) {
		this.minorHeadCode = minorHeadCode;
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
	 * Gets the item code.
	 *
	 * @return the item code
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * Sets the item code.
	 *
	 * @param itemCode the new item code
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * Gets the object class code.
	 *
	 * @return the object class code
	 */
	public String getObjectClassCode() {
		return objectClassCode;
	}

	/**
	 * Sets the object class code.
	 *
	 * @param objectClassCode the new object class code
	 */
	public void setObjectClassCode(String objectClassCode) {
		this.objectClassCode = objectClassCode;
	}

	/**
	 * Gets the typeof estimate.
	 *
	 * @return the typeof estimate
	 */
	public String getTypeofEstimate() {
		return typeofEstimate;
	}

	/**
	 * Sets the typeof estimate.
	 *
	 * @param typeofEstimate the new typeof estimate
	 */
	public void setTypeofEstimate(String typeofEstimate) {
		this.typeofEstimate = typeofEstimate;
	}

	/**
	 * Gets the charged voted.
	 *
	 * @return the charged voted
	 */
	public String getChargedVoted() {
		return chargedVoted;
	}

	/**
	 * Sets the charged voted.
	 *
	 * @param chargedVoted the new charged voted
	 */
	public void setChargedVoted(String chargedVoted) {
		this.chargedVoted = chargedVoted;
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

}
