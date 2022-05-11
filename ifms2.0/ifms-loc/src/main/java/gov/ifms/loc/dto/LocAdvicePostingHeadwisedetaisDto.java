package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class LocAdvicePartHeadwisedetaisDto.
 * 
 * @version v 1.0
 * @created 2021/02/23 12:51:19
 *
 */
public class LocAdvicePostingHeadwisedetaisDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The advice type id. */
	private Long adviceTypeId;

	/** The exempt type. */
	private String exemptType;

	/** The ddo no. */
	private String ddoNo;

	/** The fund type. */
	private String fundType;

	/** The charged voted. */
	private String chargedVoted;

	/** The budget type. */
	private Long budgetType;

	/** The demand id. */
	private Long demandId;

	/** The majorhead id. */
	private Long majorheadId;

	/** The submajorhead id. */
	private Long submajorheadId;

	/** The minorhead id. */
	private Long minorheadId;

	/** The subhead id. */
	private Long subheadId;

	/** The detail head id. */
	private Long detailHeadId;

	/** The estimate type. */
	private String estimateType;

	/** The item id. */
	private Long itemId;

	/** The object class id. */
	private Long objectClassId;

	/** The lc no. */
	private String lcNo;

	/** The scheme name. */
	private String schemeName;

	/** The chargedVotedId. */
	private Long chargedVotedId;

	/** The fundTypeId. */
	private Long fundTypeId;
	
	/** The estimate type Id. */
	private Long estimateTypeId;

	/**
	 * LocAdvicePartHeadwisedetaisDto Constructor.
	 */
	public LocAdvicePostingHeadwisedetaisDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(fundType, chargedVoted, budgetType, estimateType, lcNo, majorheadId, submajorheadId,
				minorheadId, subheadId, detailHeadId, demandId, itemId, objectClassId, schemeName);
	}

	/**
	 * equals method.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LocAdvicePostingHeadwisedetaisDto)) {
			return false;
		}

		LocAdvicePostingHeadwisedetaisDto other = (LocAdvicePostingHeadwisedetaisDto) obj;

		return Objects.equals(fundType, other.fundType) && Objects.equals(chargedVoted, other.chargedVoted)
				&& Objects.equals(budgetType, other.budgetType) && Objects.equals(estimateType, other.estimateType)
				&& Objects.equals(lcNo, other.lcNo) && Objects.equals(majorheadId, other.majorheadId)
				&& Objects.equals(submajorheadId, other.submajorheadId)
				&& Objects.equals(minorheadId, other.minorheadId) && Objects.equals(subheadId, other.subheadId)
				&& Objects.equals(detailHeadId, other.detailHeadId) && Objects.equals(demandId, other.demandId)
				&& Objects.equals(itemId, other.itemId) && Objects.equals(objectClassId, other.objectClassId)
				&& Objects.equals(schemeName, other.schemeName);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocAdvicePartHeadwisedetaisDto [fundType = " + fundType + ",chargedVoted = " + chargedVoted
				+ ",budgetType = " + budgetType + ",estimateType = " + estimateType + ",lcNo = " + lcNo
				+ ",majorheadId = " + majorheadId + ",submajorheadId = " + submajorheadId + ",minorheadId = "
				+ minorheadId + ",subheadId = " + subheadId + ",detailHeadId = " + detailHeadId + ",demandId = "
				+ demandId + ",itemId = " + itemId + ",objectClassId = " + objectClassId + ",schemeName = " + schemeName
				+ "]";
	}

	/**
	 * getter setter.
	 *
	 * @return the fund type
	 */

	/**
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
	 * Gets the charged voted.
	 *
	 * @return the chargedVoted
	 */
	public String getChargedVoted() {
		return chargedVoted;
	}

	/**
	 * Sets the charged voted.
	 *
	 * @param chargedVoted the chargedVoted to set
	 */
	public void setChargedVoted(String chargedVoted) {
		this.chargedVoted = chargedVoted;
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
	 * Gets the estimate type.
	 *
	 * @return the estimateType
	 */
	public String getEstimateType() {
		return estimateType;
	}

	/**
	 * Sets the estimate type.
	 *
	 * @param estimateType the estimateType to set
	 */
	public void setEstimateType(String estimateType) {
		this.estimateType = estimateType;
	}

	/**
	 * Gets the lc no.
	 *
	 * @return the lcNo
	 */
	public String getLcNo() {
		return lcNo;
	}

	/**
	 * Sets the lc no.
	 *
	 * @param lcNo the lcNo to set
	 */
	public void setLcNo(String lcNo) {
		this.lcNo = lcNo;
	}

	/**
	 * Gets the majorhead id.
	 *
	 * @return the majorheadId
	 */
	public Long getMajorheadId() {
		return majorheadId;
	}

	/**
	 * Sets the majorhead id.
	 *
	 * @param majorheadId the majorheadId to set
	 */
	public void setMajorheadId(Long majorheadId) {
		this.majorheadId = majorheadId;
	}

	/**
	 * Gets the submajorhead id.
	 *
	 * @return the submajorheadId
	 */
	public Long getSubmajorheadId() {
		return submajorheadId;
	}

	/**
	 * Sets the submajorhead id.
	 *
	 * @param submajorheadId the submajorheadId to set
	 */
	public void setSubmajorheadId(Long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	/**
	 * Gets the minorhead id.
	 *
	 * @return the minorheadId
	 */
	public Long getMinorheadId() {
		return minorheadId;
	}

	/**
	 * Sets the minorhead id.
	 *
	 * @param minorheadId the minorheadId to set
	 */
	public void setMinorheadId(Long minorheadId) {
		this.minorheadId = minorheadId;
	}

	/**
	 * Gets the subhead id.
	 *
	 * @return the subheadId
	 */
	public Long getSubheadId() {
		return subheadId;
	}

	/**
	 * Sets the subhead id.
	 *
	 * @param subheadId the subheadId to set
	 */
	public void setSubheadId(Long subheadId) {
		this.subheadId = subheadId;
	}

	/**
	 * Gets the detail head id.
	 *
	 * @return the detailHeadId
	 */
	public Long getDetailHeadId() {
		return detailHeadId;
	}

	/**
	 * Sets the detail head id.
	 *
	 * @param detailHeadId the detailHeadId to set
	 */
	public void setDetailHeadId(Long detailHeadId) {
		this.detailHeadId = detailHeadId;
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
	 * Gets the item id.
	 *
	 * @return the itemId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the itemId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the object class id.
	 *
	 * @return the objectClassId
	 */
	public Long getObjectClassId() {
		return objectClassId;
	}

	/**
	 * Sets the object class id.
	 *
	 * @param objectClassId the objectClassId to set
	 */
	public void setObjectClassId(Long objectClassId) {
		this.objectClassId = objectClassId;
	}

	/**
	 * Gets the scheme name.
	 *
	 * @return the schemeName
	 */
	public String getSchemeName() {
		return schemeName;
	}

	/**
	 * Sets the scheme name.
	 *
	 * @param schemeName the schemeName to set
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	/**
	 * Gets the advice type id.
	 *
	 * @return the advice type id
	 */
	public Long getAdviceTypeId() {
		return adviceTypeId;
	}

	/**
	 * Sets the advice type id.
	 *
	 * @param adviceTypeId the new advice type id
	 */
	public void setAdviceTypeId(Long adviceTypeId) {
		this.adviceTypeId = adviceTypeId;
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
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the chargedVotedId
	 */
	public Long getChargedVotedId() {
		return chargedVotedId;
	}

	/**
	 * @param chargedVotedId the chargedVotedId to set
	 */
	public void setChargedVotedId(Long chargedVotedId) {
		this.chargedVotedId = chargedVotedId;
	}

	/**
	 * @return the fundTypeId
	 */
	public Long getFundTypeId() {
		return fundTypeId;
	}

	/**
	 * @param fundTypeId the fundTypeId to set
	 */
	public void setFundTypeId(Long fundTypeId) {
		this.fundTypeId = fundTypeId;
	}

	/**
	 * @return the estimateTypeId
	 */
	public Long getEstimateTypeId() {
		return estimateTypeId;
	}

	/**
	 * @param estimateTypeId the estimateTypeId to set
	 */
	public void setEstimateTypeId(Long estimateTypeId) {
		this.estimateTypeId = estimateTypeId;
	}
	
	

}
