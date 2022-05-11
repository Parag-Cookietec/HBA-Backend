package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.edp.dto.BaseDto;


/**
 * The Class LocChequeCancelEditViewDtlDto.
 */
public class LocChequeCancelEditViewDtlDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dtl id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The hd cncl chq amt. */
	@NativeQueryResultColumn(index = 1)
	private Double hdCnclChqAmt;
	
	/** The fund type. */
	@NativeQueryResultColumn(index = 2)
	private String fundType;

	/** The charged voted. */
	@NativeQueryResultColumn(index = 3)
	private Character chargedVoted;

	/** The budget type. */
	@NativeQueryResultColumn(index = 4)
	private String budgetType;

	/** The demand id. */
	@NativeQueryResultColumn(index = 5)
	private String demandCode;
	
	/** The demand code name. */
	@NativeQueryResultColumn(index = 6)
	private String demandCodeName;

	/** The majorehead id. */
	@NativeQueryResultColumn(index = 7)
	private String majoreheadCode;
	
	/** The majorehead code name. */
	@NativeQueryResultColumn(index = 8)
	private String majoreheadCodeName;

	/** The submajorhead id. */
	@NativeQueryResultColumn(index = 9)
	private String submajorheadCode;
	
	/** The submajorhead code name. */
	@NativeQueryResultColumn(index = 10)
	private String submajorheadCodeName;

	/** The minorhead id. */
	@NativeQueryResultColumn(index = 11)
	private String minorheadCode;
	
	/** The minorhead code name. */
	@NativeQueryResultColumn(index = 12)
	private String minorheadCodeName;

	/** The subhead id. */
	@NativeQueryResultColumn(index = 13)
	private String subheadCode;
	
	/** The subhead code name. */
	@NativeQueryResultColumn(index = 14)
	private String subheadCodeName;

	/** The detailhead id. */
	@NativeQueryResultColumn(index = 15)
	private String detailheadCode;
	
	/** The detailhead code name. */
	@NativeQueryResultColumn(index = 16)
	private String detailheadCodeName;

	/** The estimate type. */
	@NativeQueryResultColumn(index = 17)
	private String estimateType;
	
	/** The item id. */
	@NativeQueryResultColumn(index = 18)
	private String itemCode;
	
	/** The item code name. */
	@NativeQueryResultColumn(index = 19)
	private String itemCodeName;

	/** The objectclass id. */
	@NativeQueryResultColumn(index = 20)
	private String objectclassCode;
	
	/** The objectclass code name. */
	@NativeQueryResultColumn(index = 21)
	private String objectclassCodeName;


	/** The scheme no. */
	@NativeQueryResultColumn(index = 22)
	private String schemeNo;

	/** The expensiture amt. */
	@NativeQueryResultColumn(index = 23)
	private Double expensitureAmt;

	/** The scheme no. */
	@NativeQueryResultColumn(index = 24)
	private Long lcAdviceHeadwiseId;

	/** The scheme no. */
	@NativeQueryResultColumn(index = 25)
	private Long lcAdviceId;

	/**
	 * Instantiates a new loc cheque cancel edit view dtl dto.
	 */
	public LocChequeCancelEditViewDtlDto() {
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
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Gets the hd cncl chq amt.
	 *
	 * @return the hdCnclChqAmt
	 */
	public Double getHdCnclChqAmt() {
		return hdCnclChqAmt;
	}

	/**
	 * Sets the hd cncl chq amt.
	 *
	 * @param hdCnclChqAmt the hdCnclChqAmt to set
	 */
	public void setHdCnclChqAmt(Double hdCnclChqAmt) {
		this.hdCnclChqAmt = hdCnclChqAmt;
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
	 * Gets the charged voted.
	 *
	 * @return the chargedVoted
	 */
	public Character getChargedVoted() {
		return chargedVoted;
	}

	/**
	 * Sets the charged voted.
	 *
	 * @param chargedVoted the chargedVoted to set
	 */
	public void setChargedVoted(Character chargedVoted) {
		this.chargedVoted = chargedVoted;
	}

	/**
	 * Gets the budget type.
	 *
	 * @return the budgetType
	 */
	public String getBudgetType() {
		return budgetType;
	}

	/**
	 * Sets the budget type.
	 *
	 * @param budgetType the budgetType to set
	 */
	public void setBudgetType(String budgetType) {
		this.budgetType = budgetType;
	}

	/**
	 * Gets the demand code.
	 *
	 * @return the demandCode
	 */
	public String getDemandCode() {
		return demandCode;
	}

	/**
	 * Sets the demand code.
	 *
	 * @param demandCode the demandCode to set
	 */
	public void setDemandCode(String demandCode) {
		this.demandCode = demandCode;
	}

	/**
	 * Gets the majorehead code.
	 *
	 * @return the majoreheadCode
	 */
	public String getMajoreheadCode() {
		return majoreheadCode;
	}

	/**
	 * Sets the majorehead code.
	 *
	 * @param majoreheadCode the majoreheadCode to set
	 */
	public void setMajoreheadCode(String majoreheadCode) {
		this.majoreheadCode = majoreheadCode;
	}

	/**
	 * Gets the submajorhead code.
	 *
	 * @return the submajorheadCode
	 */
	public String getSubmajorheadCode() {
		return submajorheadCode;
	}

	/**
	 * Sets the submajorhead code.
	 *
	 * @param submajorheadCode the submajorheadCode to set
	 */
	public void setSubmajorheadCode(String submajorheadCode) {
		this.submajorheadCode = submajorheadCode;
	}

	/**
	 * Gets the minorhead code.
	 *
	 * @return the minorheadCode
	 */
	public String getMinorheadCode() {
		return minorheadCode;
	}

	/**
	 * Sets the minorhead code.
	 *
	 * @param minorheadCode the minorheadCode to set
	 */
	public void setMinorheadCode(String minorheadCode) {
		this.minorheadCode = minorheadCode;
	}

	/**
	 * Gets the subhead code.
	 *
	 * @return the subheadCode
	 */
	public String getSubheadCode() {
		return subheadCode;
	}

	/**
	 * Sets the subhead code.
	 *
	 * @param subheadCode the subheadCode to set
	 */
	public void setSubheadCode(String subheadCode) {
		this.subheadCode = subheadCode;
	}

	/**
	 * Gets the detailhead code.
	 *
	 * @return the detailheadCode
	 */
	public String getDetailheadCode() {
		return detailheadCode;
	}

	/**
	 * Sets the detailhead code.
	 *
	 * @param detailheadCode the detailheadCode to set
	 */
	public void setDetailheadCode(String detailheadCode) {
		this.detailheadCode = detailheadCode;
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
	 * Gets the item code.
	 *
	 * @return the itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * Sets the item code.
	 *
	 * @param itemCode the itemCode to set
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * Gets the objectclass code.
	 *
	 * @return the objectclassCode
	 */
	public String getObjectclassCode() {
		return objectclassCode;
	}

	/**
	 * Sets the objectclass code.
	 *
	 * @param objectclassCode the objectclassCode to set
	 */
	public void setObjectclassCode(String objectclassCode) {
		this.objectclassCode = objectclassCode;
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
	 * Gets the expensiture amt.
	 *
	 * @return the expensitureAmt
	 */
	public Double getExpensitureAmt() {
		return expensitureAmt;
	}

	/**
	 * Sets the expensiture amt.
	 *
	 * @param expensitureAmt the expensitureAmt to set
	 */
	public void setExpensitureAmt(Double expensitureAmt) {
		this.expensitureAmt = expensitureAmt;
	}

	/**
	 * Gets the lc advice headwise id.
	 *
	 * @return the lcAdviceHeadwiseId
	 */
	public Long getLcAdviceHeadwiseId() {
		return lcAdviceHeadwiseId;
	}

	/**
	 * Sets the lc advice headwise id.
	 *
	 * @param lcAdviceHeadwiseId the lcAdviceHeadwiseId to set
	 */
	public void setLcAdviceHeadwiseId(Long lcAdviceHeadwiseId) {
		this.lcAdviceHeadwiseId = lcAdviceHeadwiseId;
	}

	/**
	 * Gets the lc advice id.
	 *
	 * @return the lcAdviceId
	 */
	public Long getLcAdviceId() {
		return lcAdviceId;
	}

	/**
	 * Sets the lc advice id.
	 *
	 * @param lcAdviceId the lcAdviceId to set
	 */
	public void setLcAdviceId(Long lcAdviceId) {
		this.lcAdviceId = lcAdviceId;
	}

	/**
	 * Gets the demand code name.
	 *
	 * @return the demandCodeName
	 */
	public String getDemandCodeName() {
		return demandCodeName;
	}

	/**
	 * Sets the demand code name.
	 *
	 * @param demandCodeName the demandCodeName to set
	 */
	public void setDemandCodeName(String demandCodeName) {
		this.demandCodeName = demandCodeName;
	}

	/**
	 * Gets the majorehead code name.
	 *
	 * @return the majoreheadCodeName
	 */
	public String getMajoreheadCodeName() {
		return majoreheadCodeName;
	}

	/**
	 * Sets the majorehead code name.
	 *
	 * @param majoreheadCodeName the majoreheadCodeName to set
	 */
	public void setMajoreheadCodeName(String majoreheadCodeName) {
		this.majoreheadCodeName = majoreheadCodeName;
	}

	/**
	 * Gets the submajorhead code name.
	 *
	 * @return the submajorheadCodeName
	 */
	public String getSubmajorheadCodeName() {
		return submajorheadCodeName;
	}

	/**
	 * Sets the submajorhead code name.
	 *
	 * @param submajorheadCodeName the submajorheadCodeName to set
	 */
	public void setSubmajorheadCodeName(String submajorheadCodeName) {
		this.submajorheadCodeName = submajorheadCodeName;
	}

	/**
	 * Gets the minorhead code name.
	 *
	 * @return the minorheadCodeName
	 */
	public String getMinorheadCodeName() {
		return minorheadCodeName;
	}

	/**
	 * Sets the minorhead code name.
	 *
	 * @param minorheadCodeName the minorheadCodeName to set
	 */
	public void setMinorheadCodeName(String minorheadCodeName) {
		this.minorheadCodeName = minorheadCodeName;
	}

	/**
	 * Gets the subhead code name.
	 *
	 * @return the subheadCodeName
	 */
	public String getSubheadCodeName() {
		return subheadCodeName;
	}

	/**
	 * Sets the subhead code name.
	 *
	 * @param subheadCodeName the subheadCodeName to set
	 */
	public void setSubheadCodeName(String subheadCodeName) {
		this.subheadCodeName = subheadCodeName;
	}

	/**
	 * Gets the detailhead code name.
	 *
	 * @return the detailheadCodeName
	 */
	public String getDetailheadCodeName() {
		return detailheadCodeName;
	}

	/**
	 * Sets the detailhead code name.
	 *
	 * @param detailheadCodeName the detailheadCodeName to set
	 */
	public void setDetailheadCodeName(String detailheadCodeName) {
		this.detailheadCodeName = detailheadCodeName;
	}

	/**
	 * Gets the item code name.
	 *
	 * @return the itemCodeName
	 */
	public String getItemCodeName() {
		return itemCodeName;
	}

	/**
	 * Sets the item code name.
	 *
	 * @param itemCodeName the itemCodeName to set
	 */
	public void setItemCodeName(String itemCodeName) {
		this.itemCodeName = itemCodeName;
	}

	/**
	 * Gets the objectclass code name.
	 *
	 * @return the objectclassCodeName
	 */
	public String getObjectclassCodeName() {
		return objectclassCodeName;
	}

	/**
	 * Sets the objectclass code name.
	 *
	 * @param objectclassCodeName the objectclassCodeName to set
	 */
	public void setObjectclassCodeName(String objectclassCodeName) {
		this.objectclassCodeName = objectclassCodeName;
	}

}