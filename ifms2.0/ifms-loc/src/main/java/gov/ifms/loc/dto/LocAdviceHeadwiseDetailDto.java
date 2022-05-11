package gov.ifms.loc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocAdviceDeductionDetailsEntity.
 * 
 * @version v 1.0
 * @created 2021/02/23 12:29:53
 *
 */
public class LocAdviceHeadwiseDetailDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NotNull
	private Long id;

	/** The fund type. */
	private String fundType;

	/** The charged voted. */
	private Character chargedVoted;

	/** The budget type. */
	private String budgetType;

	/** The estimate type. */
	private String estimateType;

	/** The scheme no. */
	private String schemeNo;

	/** The expensiture amt. */
	private Double expensitureAmt;

	/** The available amt. */
	private Double availableAmt;

	/** The lc no. */
	private String lcNo;

	/** The demand id. */
	private Long demandId;

	/** The majorehead id. */
	private Long majoreheadId;

	/** The submajorhead id. */
	private Long submajorheadId;

	/** The minorhead id. */
	private Long minorheadId;

	/** The subhead id. */
	private Long subheadId;

	/** The detailhead id. */
	private Long detailheadId;

	/** The item id. */
	private Long itemId;

	/** The objectclass id. */
	private Long objectclassId;

	/** The lc advice id. */
	private Long lcAdviceId;

	/**
	 * LocAdviceDeductionDetailsEntity Constructor.
	 */
	public LocAdviceHeadwiseDetailDto() {
		super();
	}

	/**
	 * @return the id
	 */

	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fundType
	 */
	public String getFundType() {
		return fundType;
	}

	/**
	 * @param fundType the fundType to set
	 */
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	/**
	 * @return the chargedVoted
	 */
	public Character getChargedVoted() {
		return chargedVoted;
	}

	/**
	 * @param chargedVoted the chargedVoted to set
	 */
	public void setChargedVoted(Character chargedVoted) {
		this.chargedVoted = chargedVoted;
	}

	/**
	 * @return the budgetType
	 */
	public String getBudgetType() {
		return budgetType;
	}

	/**
	 * @param budgetType the budgetType to set
	 */
	public void setBudgetType(String budgetType) {
		this.budgetType = budgetType;
	}

	/**
	 * @return the estimateType
	 */
	public String getEstimateType() {
		return estimateType;
	}

	/**
	 * @param estimateType the estimateType to set
	 */
	public void setEstimateType(String estimateType) {
		this.estimateType = estimateType;
	}

	/**
	 * @return the schemeNo
	 */
	public String getSchemeNo() {
		return schemeNo;
	}

	/**
	 * @param schemeNo the schemeNo to set
	 */
	public void setSchemeNo(String schemeNo) {
		this.schemeNo = schemeNo;
	}

	/**
	 * @return the expensitureAmt
	 */
	public Double getExpensitureAmt() {
		return expensitureAmt;
	}

	/**
	 * @param expensitureAmt the expensitureAmt to set
	 */
	public void setExpensitureAmt(Double expensitureAmt) {
		this.expensitureAmt = expensitureAmt;
	}

	/**
	 * @return the availableAmt
	 */
	public Double getAvailableAmt() {
		return availableAmt;
	}

	/**
	 * @param availableAmt the availableAmt to set
	 */
	public void setAvailableAmt(Double availableAmt) {
		this.availableAmt = availableAmt;
	}

	/**
	 * @return the lcNo
	 */
	public String getLcNo() {
		return lcNo;
	}

	/**
	 * @param lcNo the lcNo to set
	 */
	public void setLcNo(String lcNo) {
		this.lcNo = lcNo;
	}

	/**
	 * @return the demandId
	 */
	public Long getDemandId() {
		return demandId;
	}

	/**
	 * @param demandId the demandId to set
	 */
	public void setDemandId(Long demandId) {
		this.demandId = demandId;
	}

	/**
	 * @return the majoreheadId
	 */
	public Long getMajoreheadId() {
		return majoreheadId;
	}

	/**
	 * @param majoreheadId the majoreheadId to set
	 */
	public void setMajoreheadId(Long majoreheadId) {
		this.majoreheadId = majoreheadId;
	}

	/**
	 * @return the submajorheadId
	 */
	public Long getSubmajorheadId() {
		return submajorheadId;
	}

	/**
	 * @param submajorheadId the submajorheadId to set
	 */
	public void setSubmajorheadId(Long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	/**
	 * @return the minorheadId
	 */
	public Long getMinorheadId() {
		return minorheadId;
	}

	/**
	 * @param minorheadId the minorheadId to set
	 */
	public void setMinorheadId(Long minorheadId) {
		this.minorheadId = minorheadId;
	}

	/**
	 * @return the subheadId
	 */
	public Long getSubheadId() {
		return subheadId;
	}

	/**
	 * @param subheadId the subheadId to set
	 */
	public void setSubheadId(Long subheadId) {
		this.subheadId = subheadId;
	}

	/**
	 * @return the detailheadId
	 */
	public Long getDetailheadId() {
		return detailheadId;
	}

	/**
	 * @param detailheadId the detailheadId to set
	 */
	public void setDetailheadId(Long detailheadId) {
		this.detailheadId = detailheadId;
	}

	/**
	 * @return the itemId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the objectclassId
	 */
	public Long getObjectclassId() {
		return objectclassId;
	}

	/**
	 * @param objectclassId the objectclassId to set
	 */
	public void setObjectclassId(Long objectclassId) {
		this.objectclassId = objectclassId;
	}

	/**
	 * @return the lcAdviceId
	 */
	public Long getLcAdviceId() {
		return lcAdviceId;
	}

	/**
	 * @param lcAdviceId the lcAdviceId to set
	 */
	public void setLcAdviceId(Long lcAdviceId) {
		this.lcAdviceId = lcAdviceId;
	}

}
