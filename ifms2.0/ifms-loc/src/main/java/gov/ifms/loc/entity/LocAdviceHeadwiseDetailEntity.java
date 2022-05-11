package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * The Class LocAdviceDeductionDetailsEntity.
 *
 * @version v 1.0
 * @created 2021/02/23 12:29:53
 */
@Entity
@Table(name = "TLOC_LC_ADVICE_HEADWISE_D", schema = LocConstant.LOC_SCHEMA)
public class LocAdviceHeadwiseDetailEntity extends BaseEntity implements Serializable {


    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LC_ADVICE_HEADWISE_ID")
    private Long id;

    @Column(name = "FUND_TYPE")
    private String fundType;

    @Column(name = "CHARGED_VOTED")
    private Character chargedVoted;

    @Column(name = "BUDGET_TYPE")
    private String budgetType;

    @Column(name = "ESTIMATE_TYPE")
    private String estimateType;

    @Column(name = "SCHEME_NO")
    private String schemeNo;

    @Column(name = "EXPENDITURE_AMT")
    private Double expensitureAmt;

    @Column(name = "AVAILABLE_AMT")
    private Double availableAmt;

    @Column(name = "LC_NO")
    private String lcNo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEMAND_ID", nullable = false, referencedColumnName = "DEMAND_ID")
    private LocMsDemandEntity demandId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAJORHEAD_ID", nullable = false, referencedColumnName = "MAJORHEAD_ID")
    private LocMsMajorHeadEntity majoreheadId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBMAJORHEAD_ID", nullable = false, referencedColumnName = "SUBMAJORHEAD_ID")
    private LocMsSubMajorHeadEntity submajorheadId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINORHEAD_ID", nullable = false, referencedColumnName = "MINORHEAD_ID")
    private LocMsMinorHeadEntity minorheadId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBHEAD_ID", nullable = false, referencedColumnName = "SUBHEAD_ID")
    private LocMsSubHeadEntity subheadId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DETAILHEAD_ID", nullable = false, referencedColumnName = "DETAILHEAD_ID")
    private LocMsDetailHeadEntity detailheadId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ITEM_ID", nullable = false, referencedColumnName = "ITEM_ID")
    private LocMsItemEntity itemId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OBJECTCLASS_ID", nullable = false, referencedColumnName = "OBJECTCLASS_ID")
    private LocMsObjectClassEntity objectclassId;

    @Column(name = "LC_ADVICE_ID")
    private Long lcAdvice;


    /**
     * LocAdviceDeductionDetailsEntity Constructor
     */
    public LocAdviceHeadwiseDetailEntity() {
        super();
    }

    /**
     * Instantiates a new loc advice headwise detail entity.
     *
     * @param id the id
     */
    public LocAdviceHeadwiseDetailEntity(Long id) {
        this.id = id;
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
     * Gets the charged voted.
     *
     * @return the charged voted
     */
    public Character getChargedVoted() {
        return chargedVoted;
    }

    /**
     * Sets the charged voted.
     *
     * @param chargedVoted the new charged voted
     */
    public void setChargedVoted(Character chargedVoted) {
        this.chargedVoted = chargedVoted;
    }

    /**
     * Gets the budget type.
     *
     * @return the budget type
     */
    public String getBudgetType() {
        return budgetType;
    }

    /**
     * Sets the budget type.
     *
     * @param budgetType the new budget type
     */
    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    /**
     * Gets the estimate type.
     *
     * @return the estimate type
     */
    public String getEstimateType() {
        return estimateType;
    }

    /**
     * Sets the estimate type.
     *
     * @param estimateType the new estimate type
     */
    public void setEstimateType(String estimateType) {
        this.estimateType = estimateType;
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
     * Gets the expensiture amt.
     *
     * @return the expensiture amt
     */
    public Double getExpensitureAmt() {
        return expensitureAmt;
    }

    /**
     * Sets the expensiture amt.
     *
     * @param expensitureAmt the new expensiture amt
     */
    public void setExpensitureAmt(Double expensitureAmt) {
        this.expensitureAmt = expensitureAmt;
    }

    /**
     * Gets the available amt.
     *
     * @return the available amt
     */
    public Double getAvailableAmt() {
        return availableAmt;
    }

    /**
     * Sets the available amt.
     *
     * @param availableAmt the new available amt
     */
    public void setAvailableAmt(Double availableAmt) {
        this.availableAmt = availableAmt;
    }

    /**
     * Gets the lc no.
     *
     * @return the lc no
     */
    public String getLcNo() {
        return lcNo;
    }

    /**
     * Sets the lc no.
     *
     * @param lcNo the new lc no
     */
    public void setLcNo(String lcNo) {
        this.lcNo = lcNo;
    }

    /**
     * Gets the demand id.
     *
     * @return the demand id
     */
    public LocMsDemandEntity getDemandId() {
        return demandId;
    }

    /**
     * Sets the demand id.
     *
     * @param demandId the new demand id
     */
    public void setDemandId(LocMsDemandEntity demandId) {
        this.demandId = demandId;
    }

    /**
     * Gets the majorehead id.
     *
     * @return the majorehead id
     */
    public LocMsMajorHeadEntity getMajoreheadId() {
        return majoreheadId;
    }

    /**
     * Sets the majorehead id.
     *
     * @param majoreheadId the new majorehead id
     */
    public void setMajoreheadId(LocMsMajorHeadEntity majoreheadId) {
        this.majoreheadId = majoreheadId;
    }

    /**
     * Gets the submajorhead id.
     *
     * @return the submajorhead id
     */
    public LocMsSubMajorHeadEntity getSubmajorheadId() {
        return submajorheadId;
    }

    /**
     * Sets the submajorhead id.
     *
     * @param submajorheadId the new submajorhead id
     */
    public void setSubmajorheadId(LocMsSubMajorHeadEntity submajorheadId) {
        this.submajorheadId = submajorheadId;
    }

    /**
     * Gets the minorhead id.
     *
     * @return the minorhead id
     */
    public LocMsMinorHeadEntity getMinorheadId() {
        return minorheadId;
    }

    /**
     * Sets the minorhead id.
     *
     * @param minorheadId the new minorhead id
     */
    public void setMinorheadId(LocMsMinorHeadEntity minorheadId) {
        this.minorheadId = minorheadId;
    }

    /**
     * Gets the subhead id.
     *
     * @return the subhead id
     */
    public LocMsSubHeadEntity getSubheadId() {
        return subheadId;
    }

    /**
     * Sets the subhead id.
     *
     * @param subheadId the new subhead id
     */
    public void setSubheadId(LocMsSubHeadEntity subheadId) {
        this.subheadId = subheadId;
    }

    /**
     * Gets the detailhead id.
     *
     * @return the detailhead id
     */
    public LocMsDetailHeadEntity getDetailheadId() {
        return detailheadId;
    }

    /**
     * Sets the detailhead id.
     *
     * @param detailheadId the new detailhead id
     */
    public void setDetailheadId(LocMsDetailHeadEntity detailheadId) {
        this.detailheadId = detailheadId;
    }

    /**
     * Gets the item id.
     *
     * @return the item id
     */
    public LocMsItemEntity getItemId() {
        return itemId;
    }

    /**
     * Sets the item id.
     *
     * @param itemId the new item id
     */
    public void setItemId(LocMsItemEntity itemId) {
        this.itemId = itemId;
    }

    /**
     * Gets the objectclass id.
     *
     * @return the objectclass id
     */
    public LocMsObjectClassEntity getObjectclassId() {
        return objectclassId;
    }

    /**
     * Sets the objectclass id.
     *
     * @param objectclassId the new objectclass id
     */
    public void setObjectclassId(LocMsObjectClassEntity objectclassId) {
        this.objectclassId = objectclassId;
    }

 

    /**
	 * @return the lcAdvice
	 */
	public Long getLcAdvice() {
		return lcAdvice;
	}

	/**
	 * @param lcAdvice the lcAdvice to set
	 */
	public void setLcAdvice(Long lcAdvice) {
		this.lcAdvice = lcAdvice;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocAdviceHeadwiseDetailEntity)) return false;
        LocAdviceHeadwiseDetailEntity that = (LocAdviceHeadwiseDetailEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFundType(), that.getFundType()) && Objects.equals(getChargedVoted(), that.getChargedVoted()) && Objects.equals(getBudgetType(), that.getBudgetType()) && Objects.equals(getEstimateType(), that.getEstimateType()) && Objects.equals(getSchemeNo(), that.getSchemeNo()) && Objects.equals(getExpensitureAmt(), that.getExpensitureAmt()) && Objects.equals(getAvailableAmt(), that.getAvailableAmt()) && Objects.equals(getLcNo(), that.getLcNo()) && Objects.equals(getDemandId(), that.getDemandId()) && Objects.equals(getMajoreheadId(), that.getMajoreheadId()) && Objects.equals(getSubmajorheadId(), that.getSubmajorheadId()) && Objects.equals(getMinorheadId(), that.getMinorheadId()) && Objects.equals(getSubheadId(), that.getSubheadId()) && Objects.equals(getDetailheadId(), that.getDetailheadId()) && Objects.equals(getItemId(), that.getItemId()) && Objects.equals(getObjectclassId(), that.getObjectclassId()) && Objects.equals(getLcAdvice(), that.getLcAdvice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFundType(), getChargedVoted(), getBudgetType(), getEstimateType(), getSchemeNo(), getExpensitureAmt(), getAvailableAmt(), getLcNo(), getDemandId(), getMajoreheadId(), getSubmajorheadId(), getMinorheadId(), getSubheadId(), getDetailheadId(), getItemId(), getObjectclassId(), getLcAdvice());
    }
}
