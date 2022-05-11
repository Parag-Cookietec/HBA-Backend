package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocAdvicePartHeadwisedetaisDto.
 * 
 * @version v 1.0
 * @created 2021/02/23 12:51:19
 *
 */
public class LocAdvicePartHeadwisedetaisDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The advice type id. */
	private Long adviceTypeId;

	/** The exempt type. */
	private String exemptType;

	/** The ddo no. */
	private Long ddoNo;

	/** The fund type. */
	private Long fundType;

	/** The charged voted. */
	private Long chargedVoted;

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
	private Long estimateType;

	/** The item id. */
	private Long itemId;

	/** The object class id. */
	private Long objectClassId;

	/** The expenditure amt. */
	private Double expenditureAmt;

	/** The headwise available amt. */
	private Double headwiseAvailableAmt;

	/** The lc no. */
	private String lcNo;

	/** The lc advice party id. */
	private Long lcAdvicePartyId;

	/** The scheme name. */
	private String schemeName;

	/** The lc advice hdr id. */
	private Long lcAdviceHdrId;

	/**
	 * LocAdvicePartHeadwisedetaisDto Constructor.
	 */
	public LocAdvicePartHeadwisedetaisDto() {
		super();
	}



	

	/**
	 * Gets the lc advice party id.
	 *
	 * @return the lcAdvicePartyId
	 */
	public Long getLcAdvicePartyId() {
		return lcAdvicePartyId;
	}

	/**
	 * Sets the lc advice party id.
	 *
	 * @param lcAdvicePartyId the lcAdvicePartyId to set
	 */
	public void setLcAdvicePartyId(Long lcAdvicePartyId) {
		this.lcAdvicePartyId = lcAdvicePartyId;
	}

	/**
	 * Gets the fund type.
	 *
	 * @return the fundType
	 */
	public Long getFundType() {
		return fundType;
	}

	/**
	 * Sets the fund type.
	 *
	 * @param fundType the fundType to set
	 */
	public void setFundType(Long fundType) {
		this.fundType = fundType;
	}

	/**
	 * Gets the charged voted.
	 *
	 * @return the chargedVoted
	 */
	public Long getChargedVoted() {
		return chargedVoted;
	}

	/**
	 * Sets the charged voted.
	 *
	 * @param chargedVoted the chargedVoted to set
	 */
	public void setChargedVoted(Long chargedVoted) {
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
	public Long getEstimateType() {
		return estimateType;
	}

	/**
	 * Sets the estimate type.
	 *
	 * @param estimateType the estimateType to set
	 */
	public void setEstimateType(Long estimateType) {
		this.estimateType = estimateType;
	}

	/**
	 * Gets the expenditure amt.
	 *
	 * @return the expenditureAmt
	 */
	public Double getExpenditureAmt() {
		return expenditureAmt;
	}

	/**
	 * Sets the expenditure amt.
	 *
	 * @param expenditureAmt the expenditureAmt to set
	 */
	public void setExpenditureAmt(Double expenditureAmt) {
		this.expenditureAmt = expenditureAmt;
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
	 * Gets the headwise available amount.
	 *
	 * @return the headwise available amount
	 */
	public Double getHeadwiseAvailableAmount() {
		return headwiseAvailableAmt;
	}

	/**
	 * Sets the headwise available amount.
	 *
	 * @param headwiseAvailableAmt the new headwise available amount
	 */
	public void setHeadwiseAvailableAmount(Double headwiseAvailableAmt) {
		this.headwiseAvailableAmt = headwiseAvailableAmt;
	}

	/**
	 * Gets the lc advice hdr id.
	 *
	 * @return the lc advice hdr id
	 */
	public Long getLcAdviceHdrId() {
		return lcAdviceHdrId;
	}

	/**
	 * Sets the lc advice hdr id.
	 *
	 * @param lcAdviceHdrId the new lc advice hdr id
	 */
	public void setLcAdviceHdrId(Long lcAdviceHdrId) {
		this.lcAdviceHdrId = lcAdviceHdrId;
	}

}
