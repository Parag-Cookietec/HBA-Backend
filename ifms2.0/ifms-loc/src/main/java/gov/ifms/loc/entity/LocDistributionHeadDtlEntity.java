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
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Class LocDistributionHeadDtlEntity.
 *
 * @version v 1.0
 * @created 2021/02/11 14:51:40
 */
@Entity
@Table(name = "TLOC_DISTRIBUTION_HEAD_DTL", schema = LocDBConstants.LOC_SCHEMA)
public class LocDistributionHeadDtlEntity extends BaseEntity implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TLOC_DIST_HEAD_DTL_ID")
	private Long id;

	/**
	 * The hdr id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TLOC_DISTRIBUTION_HDR_ID", referencedColumnName = "LC_TRANSACTION_ID")
	private LocDistributionHdrEntity hdrId;

	/**
	 * The fund type.
	 */
	@Column(name = "FUND_TYPE")
	private String fundType;

	/**
	 * The class expend.
	 */
	@Column(name = "CLASS_EXPENDITURE")
	private String classExpend;

	/**
	 * The budget type.
	 */
	@Column(name = "BUDGET_TYPE")
	private Long budgetType;

	/**
	 * The demand id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEMAND_ID", referencedColumnName = "DEMAND_ID")
	private LocMsDemandEntity demandId;

	/**
	 * The major head id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAJOR_HEAD_ID", referencedColumnName = "MAJORHEAD_ID")
	private LocMsMajorHeadEntity majorHeadId;

	/**
	 * The sub major head id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBMAJOR_HEAD_ID", referencedColumnName = "SUBMAJORHEAD_ID")
	private LocMsSubMajorHeadEntity subMajorHeadId;

	/**
	 * The minor head id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MINOR_HEAD_ID", referencedColumnName = "MINORHEAD_ID")
	private LocMsMinorHeadEntity minorHeadId;

	/** The sub head id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBHEAD_ID", referencedColumnName = "SUBHEAD_ID")
	private LocMsSubHeadEntity subHeadId;

	/**
	 * The detailed head id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DETAILED_HEAD_ID", referencedColumnName = "DETAILHEAD_ID")
	private LocMsDetailHeadEntity detailedHeadId;

	/**
	 * The type of estimate.
	 */
	@Column(name = "TYPE_OF_ESTIMATE")
	private String typeOfEstimate;

	/**
	 * The item work name.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_WORK_NAME", referencedColumnName = "ITEM_ID")
	private LocMsItemEntity itemWorkName;

	/**
	 * The object class.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECT_CLASS", referencedColumnName = "OBJECTCLASS_ID")
	private LocMsObjectClassEntity objectClass;

	/**
	 * The scheme no.
	 */
	@Column(name = "SCHEME_NO")
	private String schemeNo;

	/**
	 * The amount.
	 */
	@Column(name = "CENTER_AMOUNT")
	private Double centerAmount;

	/**
	 * The amount.
	 */
	@Column(name = "STATE_AMOUNT")
	private Double stateAmount;

	/**
	 * The status id.
	 */
	@Column(name = "STATUS_ID")
	private Long statusId;

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
	public LocDistributionHdrEntity getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(LocDistributionHdrEntity hdrId) {
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
	 * Gets the budget type.
	 *
	 * @return the budget type
	 */
	public Long getBudgetType() {
		return budgetType;
	}

	/**
	 * Sets the budget type.
	 *
	 * @param budgetType the new budget type
	 */
	public void setBudgetType(Long budgetType) {
		this.budgetType = budgetType;
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
	 * Gets the major head id.
	 *
	 * @return the major head id
	 */
	public LocMsMajorHeadEntity getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * Sets the major head id.
	 *
	 * @param majorHeadId the new major head id
	 */
	public void setMajorHeadId(LocMsMajorHeadEntity majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * Gets the sub major head id.
	 *
	 * @return the sub major head id
	 */
	public LocMsSubMajorHeadEntity getSubMajorHeadId() {
		return subMajorHeadId;
	}

	/**
	 * Sets the sub major head id.
	 *
	 * @param subMajorHeadId the new sub major head id
	 */
	public void setSubMajorHeadId(LocMsSubMajorHeadEntity subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	/**
	 * Gets the minor head id.
	 *
	 * @return the minor head id
	 */
	public LocMsMinorHeadEntity getMinorHeadId() {
		return minorHeadId;
	}

	/**
	 * Sets the minor head id.
	 *
	 * @param minorHeadId the new minor head id
	 */
	public void setMinorHeadId(LocMsMinorHeadEntity minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	/**
	 * Gets the detailed head id.
	 *
	 * @return the detailed head id
	 */
	public LocMsDetailHeadEntity getDetailedHeadId() {
		return detailedHeadId;
	}

	/**
	 * Sets the detailed head id.
	 *
	 * @param detailedHeadId the new detailed head id
	 */
	public void setDetailedHeadId(LocMsDetailHeadEntity detailedHeadId) {
		this.detailedHeadId = detailedHeadId;
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
	public LocMsItemEntity getItemWorkName() {
		return itemWorkName;
	}

	/**
	 * Sets the item work name.
	 *
	 * @param itemWorkName the new item work name
	 */
	public void setItemWorkName(LocMsItemEntity itemWorkName) {
		this.itemWorkName = itemWorkName;
	}

	/**
	 * Gets the object class.
	 *
	 * @return the object class
	 */
	public LocMsObjectClassEntity getObjectClass() {
		return objectClass;
	}

	/**
	 * Sets the object class.
	 *
	 * @param objectClass the new object class
	 */
	public void setObjectClass(LocMsObjectClassEntity objectClass) {
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
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the sub head id.
	 *
	 * @return the sub head id
	 */
	public LocMsSubHeadEntity getSubHeadId() {
		return subHeadId;
	}

	/**
	 * Sets the sub head id.
	 *
	 * @param subHeadId the new sub head id
	 */
	public void setSubHeadId(LocMsSubHeadEntity subHeadId) {
		this.subHeadId = subHeadId;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocDistributionHeadDtlEntity))
			return false;
		LocDistributionHeadDtlEntity that = (LocDistributionHeadDtlEntity) o;
		return getId().equals(that.getId()) && getHdrId().equals(that.getHdrId())
				&& getFundType().equals(that.getFundType()) && getClassExpend().equals(that.getClassExpend())
				&& Objects.equals(getBudgetType(), that.getBudgetType())
				&& Objects.equals(getDemandId(), that.getDemandId())
				&& Objects.equals(getMajorHeadId(), that.getMajorHeadId())
				&& Objects.equals(getSubMajorHeadId(), that.getSubMajorHeadId())
				&& Objects.equals(getMinorHeadId(), that.getMinorHeadId())
				&& Objects.equals(getSubHeadId(), that.getSubHeadId())
				&& Objects.equals(getDetailedHeadId(), that.getDetailedHeadId())
				&& Objects.equals(getTypeOfEstimate(), that.getTypeOfEstimate())
				&& Objects.equals(getItemWorkName(), that.getItemWorkName())
				&& Objects.equals(getObjectClass(), that.getObjectClass())
				&& Objects.equals(getSchemeNo(), that.getSchemeNo()) && Objects.equals(getCenterAmount(), that.getCenterAmount())
				&& Objects.equals(getStatusId(), that.getStatusId());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getHdrId(), getFundType(), getClassExpend(), getBudgetType(), getDemandId(),
				getMajorHeadId(), getSubMajorHeadId(), getMinorHeadId(), getSubHeadId(), getDetailedHeadId(),
				getTypeOfEstimate(), getItemWorkName(), getObjectClass(), getSchemeNo(), getCenterAmount(),getStateAmount(), getStatusId());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocDistributionHeadDtlEntity{" + "id=" + id + ", hdrId=" + hdrId + ", fundType='" + fundType + '\''
				+ ", classExpend='" + classExpend + '\'' + ", budgetType=" + budgetType + ", demandId=" + demandId
				+ ", majorHeadId=" + majorHeadId + ", subMajorHeadId=" + subMajorHeadId + ", minorHeadId=" + minorHeadId
				+ ", subHeadId=" + subHeadId + ", detailedHeadId=" + detailedHeadId + ", typeOfEstimate='"
				+ typeOfEstimate + '\'' + ", itemWorkName=" + itemWorkName + ", objectClass=" + objectClass
				+ ", schemeNo='" + schemeNo + '\'' + ", centerAmount=" + centerAmount  + ", stateAmount=" + stateAmount + ", statusId=" + statusId + '}';
	}
}
