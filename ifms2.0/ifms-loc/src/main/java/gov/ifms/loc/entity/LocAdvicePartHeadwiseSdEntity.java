package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.loc.util.LocConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class LocAdvicePartHeadwisedetaisEntity.
 *
 * @version v 1.0
 * @created 2021/02/23 12:51:19
 */
@Entity
@Table(name = "TLOC_LC_ADVICE_PARTYHEADWISE_SD", schema = LocConstant.LOC_SCHEMA)
public class LocAdvicePartHeadwiseSdEntity extends BaseEntity implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_ADVICE_HEADWISE_ID")
	private Long id;

	@Column(name = "LC_ADVICE_PARTY_ID")
	private Long lcAdvicePartyId;

	@Column(name = "TLOC_ADVICE_HDR_ID")
	private Long lcAdviceHdrId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "FUND_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity fundType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CHARGED_VOTED", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity chargedVoted;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "BUDGET_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity budgetType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ESTIMATE_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity estimateType;

	@Column(name = "EXPENDITURE_AMT")
	private Double expenditureAmt;

	@Column(name = "HEADWISE_AVAIL_AMNT")
	private Double headwiseAvailableAmt;

	@Column(name = "LC_NO")
	private String lcNo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MAJORHEAD_ID", nullable = false, referencedColumnName = "MAJORHEAD_ID")
	private LocMsMajorHeadEntity majorheadId;

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
	private LocMsDetailHeadEntity detailHeadId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DEMAND_ID", nullable = false, referencedColumnName = "DEMAND_ID")
	private LocMsDemandEntity demandId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ITEM_ID", nullable = false, referencedColumnName = "ITEM_ID")
	private LocMsItemEntity itemId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OBJECTCLASS_ID", nullable = false, referencedColumnName = "OBJECTCLASS_ID")
	private LocMsObjectClassEntity objectClassId;

	@Column(name = "SCHEME_NO")
	private String schemeName;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ADVICE_TYPE_ID", nullable = false, referencedColumnName = "ADVICE_ID")
	private LocMsAdviceDtlEntity adviceTypeId;

	@Column(name = "EXEMPT_TYPE")
	private String exemptType;

	@Column(name = "DDO_NO")
	private Long ddoNo;

	@Column(name = "ACTIVE_STATUS")
	private int activeStatus;

	/**
	 * LocAdvicePartHeadwisedetaisEntity Constructor
	 */
	public LocAdvicePartHeadwiseSdEntity() {
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
	 * Gets the lc advice party id.
	 *
	 * @return the lc advice party id
	 */
	public Long getLcAdvicePartyId() {
		return lcAdvicePartyId;
	}

	/**
	 * Sets the lc advice party id.
	 *
	 * @param lcAdvicePartyId the new lc advice party id
	 */
	public void setLcAdvicePartyId(Long lcAdvicePartyId) {
		this.lcAdvicePartyId = lcAdvicePartyId;
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

	/**
	 * Gets the fund type.
	 *
	 * @return the fund type
	 */
	public EDPLuLookUpInfoEntity getFundType() {
		return fundType;
	}

	/**
	 * Sets the fund type.
	 *
	 * @param fundType the new fund type
	 */
	public void setFundType(EDPLuLookUpInfoEntity fundType) {
		this.fundType = fundType;
	}

	/**
	 * Gets the charged voted.
	 *
	 * @return the charged voted
	 */
	public EDPLuLookUpInfoEntity getChargedVoted() {
		return chargedVoted;
	}

	/**
	 * Sets the charged voted.
	 *
	 * @param chargedVoted the new charged voted
	 */
	public void setChargedVoted(EDPLuLookUpInfoEntity chargedVoted) {
		this.chargedVoted = chargedVoted;
	}

	/**
	 * Gets the budget type.
	 *
	 * @return the budget type
	 */
	public EDPLuLookUpInfoEntity getBudgetType() {
		return budgetType;
	}

	/**
	 * Sets the budget type.
	 *
	 * @param budgetType the new budget type
	 */
	public void setBudgetType(EDPLuLookUpInfoEntity budgetType) {
		this.budgetType = budgetType;
	}

	/**
	 * Gets the estimate type.
	 *
	 * @return the estimate type
	 */
	public EDPLuLookUpInfoEntity getEstimateType() {
		return estimateType;
	}

	/**
	 * Sets the estimate type.
	 *
	 * @param estimateType the new estimate type
	 */
	public void setEstimateType(EDPLuLookUpInfoEntity estimateType) {
		this.estimateType = estimateType;
	}

	/**
	 * Gets the headwise available amt.
	 *
	 * @return the headwise available amt
	 */
	public Double getHeadwiseAvailableAmt() {
		return headwiseAvailableAmt;
	}

	/**
	 * Sets the headwise available amt.
	 *
	 * @param headwiseAvailableAmt the new headwise available amt
	 */
	public void setHeadwiseAvailableAmt(Double headwiseAvailableAmt) {
		this.headwiseAvailableAmt = headwiseAvailableAmt;
	}

	/**
	 * Sets the majorhead id.
	 *
	 * @param majorheadId the new majorhead id
	 */
	public void setMajorheadId(LocMsMajorHeadEntity majorheadId) {
		this.majorheadId = majorheadId;
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
	 * Sets the minorhead id.
	 *
	 * @param minorheadId the new minorhead id
	 */
	public void setMinorheadId(LocMsMinorHeadEntity minorheadId) {
		this.minorheadId = minorheadId;
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
	 * Sets the detail head id.
	 *
	 * @param detailHeadId the new detail head id
	 */
	public void setDetailHeadId(LocMsDetailHeadEntity detailHeadId) {
		this.detailHeadId = detailHeadId;
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
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(LocMsItemEntity itemId) {
		this.itemId = itemId;
	}

	/**
	 * Sets the object class id.
	 *
	 * @param objectClassId the new object class id
	 */
	public void setObjectClassId(LocMsObjectClassEntity objectClassId) {
		this.objectClassId = objectClassId;
	}

	/**
	 * Gets the expenditure amt.
	 *
	 * @return the expenditure amt
	 */
	public Double getExpenditureAmt() {
		return expenditureAmt;
	}

	/**
	 * Sets the expenditure amt.
	 *
	 * @param expenditureAmt the new expenditure amt
	 */
	public void setExpenditureAmt(Double expenditureAmt) {
		this.expenditureAmt = expenditureAmt;
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
	 * Gets the scheme name.
	 *
	 * @return the scheme name
	 */
	public String getSchemeName() {
		return schemeName;
	}

	/**
	 * Sets the scheme name.
	 *
	 * @param schemeName the new scheme name
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	/**
	 * Gets the advice type id.
	 *
	 * @return the advice type id
	 */
	public LocMsAdviceDtlEntity getAdviceTypeId() {
		return adviceTypeId;
	}

	/**
	 * Sets the advice type id.
	 *
	 * @param adviceTypeId the new advice type id
	 */
	public void setAdviceTypeId(LocMsAdviceDtlEntity adviceTypeId) {
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
	 * Gets the majorhead id.
	 *
	 * @return the majorhead id
	 */
	public LocMsMajorHeadEntity getMajorheadId() {
		return majorheadId;
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
	 * Gets the minorhead id.
	 *
	 * @return the minorhead id
	 */
	public LocMsMinorHeadEntity getMinorheadId() {
		return minorheadId;
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
	 * Gets the detail head id.
	 *
	 * @return the detail head id
	 */
	public LocMsDetailHeadEntity getDetailHeadId() {
		return detailHeadId;
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
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public LocMsItemEntity getItemId() {
		return itemId;
	}

	/**
	 * Gets the object class id.
	 *
	 * @return the object class id
	 */
	public LocMsObjectClassEntity getObjectClassId() {
		return objectClassId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocAdvicePartHeadwiseSdEntity))
			return false;
		LocAdvicePartHeadwiseSdEntity that = (LocAdvicePartHeadwiseSdEntity) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getLcAdvicePartyId(), that.getLcAdvicePartyId())
				&& Objects.equals(getFundType(), that.getFundType())
				&& Objects.equals(getChargedVoted(), that.getChargedVoted())
				&& Objects.equals(getBudgetType(), that.getBudgetType())
				&& Objects.equals(getEstimateType(), that.getEstimateType())
				&& Objects.equals(getExpenditureAmt(), that.getExpenditureAmt())
				&& Objects.equals(getLcNo(), that.getLcNo()) && Objects.equals(getMajorheadId(), that.getMajorheadId())
				&& Objects.equals(getSubmajorheadId(), that.getSubmajorheadId())
				&& Objects.equals(getMinorheadId(), that.getMinorheadId())
				&& Objects.equals(getSubheadId(), that.getSubheadId())
				&& Objects.equals(getDetailHeadId(), that.getDetailHeadId())
				&& Objects.equals(getDemandId(), that.getDemandId()) && Objects.equals(getItemId(), that.getItemId())
				&& Objects.equals(getObjectClassId(), that.getObjectClassId())
				&& Objects.equals(getSchemeName(), that.getSchemeName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getLcAdvicePartyId(), getFundType(), getChargedVoted(), getBudgetType(),
				getEstimateType(), getExpenditureAmt(), getLcNo(), getMajorheadId(), getSubmajorheadId(),
				getMinorheadId(), getSubheadId(), getDetailHeadId(), getDemandId(), getItemId(), getObjectClassId(),
				getSchemeName());
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

}
