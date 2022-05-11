package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocAdvicePartHeadwisedetaisEntity.
 *
 * @version v 1.0
 * @created 2021/02/23 12:51:19
 */
@Entity
@Table(name = "TLOC_LC_ADVICE_PARTYHEADWISE_D", schema = LocConstant.LOC_SCHEMA)
public class LocAdvicePartHeadwisedetaisEntity extends BaseEntity implements Serializable {

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
	public LocAdvicePartHeadwisedetaisEntity() {
		super();
	}

	
	public LocAdvicePartHeadwisedetaisEntity(Long id) {
		super();
		this.id = id;
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
	 * @return the lcAdvicePartyId
	 */
	public Long getLcAdvicePartyId() {
		return lcAdvicePartyId;
	}

	/**
	 * @param lcAdvicePartyId the lcAdvicePartyId to set
	 */
	public void setLcAdvicePartyId(Long lcAdvicePartyId) {
		this.lcAdvicePartyId = lcAdvicePartyId;
	}

	/**
	 * @return the lcAdviceHdrId
	 */
	public Long getLcAdviceHdrId() {
		return lcAdviceHdrId;
	}

	/**
	 * @param lcAdviceHdrId the lcAdviceHdrId to set
	 */
	public void setLcAdviceHdrId(Long lcAdviceHdrId) {
		this.lcAdviceHdrId = lcAdviceHdrId;
	}

	/**
	 * @return the fundType
	 */
	public EDPLuLookUpInfoEntity getFundType() {
		return fundType;
	}

	/**
	 * @param fundType the fundType to set
	 */
	public void setFundType(EDPLuLookUpInfoEntity fundType) {
		this.fundType = fundType;
	}

	/**
	 * @return the chargedVoted
	 */
	public EDPLuLookUpInfoEntity getChargedVoted() {
		return chargedVoted;
	}

	/**
	 * @param chargedVoted the chargedVoted to set
	 */
	public void setChargedVoted(EDPLuLookUpInfoEntity chargedVoted) {
		this.chargedVoted = chargedVoted;
	}

	/**
	 * @return the budgetType
	 */
	public EDPLuLookUpInfoEntity getBudgetType() {
		return budgetType;
	}

	/**
	 * @param budgetType the budgetType to set
	 */
	public void setBudgetType(EDPLuLookUpInfoEntity budgetType) {
		this.budgetType = budgetType;
	}

	/**
	 * @return the estimateType
	 */
	public EDPLuLookUpInfoEntity getEstimateType() {
		return estimateType;
	}

	/**
	 * @param estimateType the estimateType to set
	 */
	public void setEstimateType(EDPLuLookUpInfoEntity estimateType) {
		this.estimateType = estimateType;
	}

	/**
	 * @return the expenditureAmt
	 */
	public Double getExpenditureAmt() {
		return expenditureAmt;
	}

	/**
	 * @param expenditureAmt the expenditureAmt to set
	 */
	public void setExpenditureAmt(Double expenditureAmt) {
		this.expenditureAmt = expenditureAmt;
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
	 * @return the majorheadId
	 */
	public LocMsMajorHeadEntity getMajorheadId() {
		return majorheadId;
	}

	/**
	 * @param majorheadId the majorheadId to set
	 */
	public void setMajorheadId(LocMsMajorHeadEntity majorheadId) {
		this.majorheadId = majorheadId;
	}

	/**
	 * @return the submajorheadId
	 */
	public LocMsSubMajorHeadEntity getSubmajorheadId() {
		return submajorheadId;
	}

	/**
	 * @param submajorheadId the submajorheadId to set
	 */
	public void setSubmajorheadId(LocMsSubMajorHeadEntity submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	/**
	 * @return the minorheadId
	 */
	public LocMsMinorHeadEntity getMinorheadId() {
		return minorheadId;
	}

	/**
	 * @param minorheadId the minorheadId to set
	 */
	public void setMinorheadId(LocMsMinorHeadEntity minorheadId) {
		this.minorheadId = minorheadId;
	}

	/**
	 * @return the subheadId
	 */
	public LocMsSubHeadEntity getSubheadId() {
		return subheadId;
	}

	/**
	 * @param subheadId the subheadId to set
	 */
	public void setSubheadId(LocMsSubHeadEntity subheadId) {
		this.subheadId = subheadId;
	}

	/**
	 * @return the detailHeadId
	 */
	public LocMsDetailHeadEntity getDetailHeadId() {
		return detailHeadId;
	}

	/**
	 * @param detailHeadId the detailHeadId to set
	 */
	public void setDetailHeadId(LocMsDetailHeadEntity detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	/**
	 * @return the demandId
	 */
	public LocMsDemandEntity getDemandId() {
		return demandId;
	}

	/**
	 * @param demandId the demandId to set
	 */
	public void setDemandId(LocMsDemandEntity demandId) {
		this.demandId = demandId;
	}

	/**
	 * @return the itemId
	 */
	public LocMsItemEntity getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(LocMsItemEntity itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the objectClassId
	 */
	public LocMsObjectClassEntity getObjectClassId() {
		return objectClassId;
	}

	/**
	 * @param objectClassId the objectClassId to set
	 */
	public void setObjectClassId(LocMsObjectClassEntity objectClassId) {
		this.objectClassId = objectClassId;
	}

	/**
	 * @return the schemeName
	 */
	public String getSchemeName() {
		return schemeName;
	}

	/**
	 * @param schemeName the schemeName to set
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	/**
	 * @return the adviceTypeId
	 */
	public LocMsAdviceDtlEntity getAdviceTypeId() {
		return adviceTypeId;
	}

	/**
	 * @param adviceTypeId the adviceTypeId to set
	 */
	public void setAdviceTypeId(LocMsAdviceDtlEntity adviceTypeId) {
		this.adviceTypeId = adviceTypeId;
	}

	/**
	 * @return the exemptType
	 */
	public String getExemptType() {
		return exemptType;
	}

	/**
	 * @param exemptType the exemptType to set
	 */
	public void setExemptType(String exemptType) {
		this.exemptType = exemptType;
	}

	/**
	 * @return the ddoNo
	 */
	public Long getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(Long ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, adviceTypeId, budgetType, chargedVoted, ddoNo, demandId, detailHeadId,
				estimateType, exemptType, expenditureAmt, fundType, id, itemId, lcAdviceHdrId, lcAdvicePartyId, lcNo,
				majorheadId, minorheadId, objectClassId, schemeName, subheadId, submajorheadId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LocAdvicePartHeadwisedetaisEntity)) {
			return false;
		}
		LocAdvicePartHeadwisedetaisEntity other = (LocAdvicePartHeadwisedetaisEntity) obj;
		return activeStatus == other.activeStatus && Objects.equals(adviceTypeId, other.adviceTypeId)
				&& Objects.equals(budgetType, other.budgetType) && Objects.equals(chargedVoted, other.chargedVoted)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(demandId, other.demandId)
				&& Objects.equals(detailHeadId, other.detailHeadId) && Objects.equals(estimateType, other.estimateType)
				&& Objects.equals(exemptType, other.exemptType) && Objects.equals(expenditureAmt, other.expenditureAmt)
				&& Objects.equals(fundType, other.fundType) && Objects.equals(id, other.id)
				&& Objects.equals(itemId, other.itemId) && Objects.equals(lcAdviceHdrId, other.lcAdviceHdrId)
				&& Objects.equals(lcAdvicePartyId, other.lcAdvicePartyId) && Objects.equals(lcNo, other.lcNo)
				&& Objects.equals(majorheadId, other.majorheadId) && Objects.equals(minorheadId, other.minorheadId)
				&& Objects.equals(objectClassId, other.objectClassId) && Objects.equals(schemeName, other.schemeName)
				&& Objects.equals(subheadId, other.subheadId) && Objects.equals(submajorheadId, other.submajorheadId);
	}

}
