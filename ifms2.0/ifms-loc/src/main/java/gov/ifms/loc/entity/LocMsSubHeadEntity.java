package gov.ifms.loc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class BudgetBudgetMsSubHeadEntity.
 * 
 * @version 1.0
 * @created 2019/08/21 15:53:31
 *
 */
@Entity
@Table(name = "MS_SUBHEAD", schema = Constant.BUDGET_MASTER_SCHEMA)
public class LocMsSubHeadEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sub head id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBHEAD_ID")
	private Long subHeadId;

	/** The sub head name. */
	@Column(name = "SUBHEAD_NAME")
	private String subHeadName;

	/** The subhead name guj. */
	@Column(name = "SUBHEAD_NAME_GUJ")
	private String subheadNameGuj;

	/** The sub head desc. */
	@Column(name = "SUBHEAD_DESC")
	private String subHeadDesc;

	/** The sub head desc guj. */
	@Column(name = "SUBHEAD_DESC_GUJ")
	private String subHeadDescGuj;

	/** The sub head code. */
	@Column(name = "SUBHEAD_CODE")
	private String subHeadCode;

	/** The sub head codec guj. */
	@Column(name = "SUBHEAD_CODE_GUJ")
	private String subHeadCodecGuj;

	/** The sub head code name. */
	@Column(name = "SUBHEAD_CODE_NAME")
	private String subHeadCodeName;

	@Column(name = "SUBHEAD_CAT_TYPE")
	private String subHeadCatType;

	/** The sub head type id. */
	@Column(name = "SUBHEAD_TYPE_ID")
	private Long subHeadTypeId;

	/** The parent subhead id. */
	@Column(name = "PARENT_SUBHEAD_ID")
	private long parentSubheadId;

	/** The edp code. */
	@Column(name = "EDP_CODE")
	private String edpCode;

	/** The planning code. */
	@Column(name = "PLANNING_CODE")
	private String planningCode;

	/** The css description. */
	@Column(name = "CSS_DESCRIPTION")
	private String cssDescription;

	/** The is css. */
	@Column(name = "IS_CSS")
	private long isCss;

	/** The minor head entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MINORHEAD_ID", referencedColumnName = "MINORHEAD_ID", updatable = false)
	private LocMsMinorHeadEntity minorHeadEntity;

	/** The demand id. */
	@Column(name = "DEMAND_ID")
	private Long demandId;

	/** The major head entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAJORHEAD_ID", referencedColumnName = "MAJORHEAD_ID", updatable = false)
	private LocMsMajorHeadEntity majorHeadEntity;

	/** The sub major head entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBMAJORHEAD_ID", referencedColumnName = "SUBMAJORHEAD_ID", updatable = false)
	private LocMsSubMajorHeadEntity subMajorHeadEntity;

	/** The scheme short name. */
	@Column(name = "SCHEME_SHORT_NAME")
	private String schemeShortName;

	/**
	 * Instantiates a new loc ms sub head entity.
	 */
	public LocMsSubHeadEntity() {
		super();
	}

	/**
	 * Instantiates a new loc ms sub head entity.
	 *
	 * @param subHeadId the sub head id
	 */
	public LocMsSubHeadEntity(Long subHeadId) {
		super();
		this.subHeadId = subHeadId;
	}

	/**
	 * @return the subHeadId
	 */
	public Long getSubHeadId() {
		return subHeadId;
	}

	/**
	 * @param subHeadId the subHeadId to set
	 */
	public void setSubHeadId(Long subHeadId) {
		this.subHeadId = subHeadId;
	}

	/**
	 * @return the subHeadName
	 */
	public String getSubHeadName() {
		return subHeadName;
	}

	/**
	 * @param subHeadName the subHeadName to set
	 */
	public void setSubHeadName(String subHeadName) {
		this.subHeadName = subHeadName;
	}

	/**
	 * @return the subheadNameGuj
	 */
	public String getSubheadNameGuj() {
		return subheadNameGuj;
	}

	/**
	 * @param subheadNameGuj the subheadNameGuj to set
	 */
	public void setSubheadNameGuj(String subheadNameGuj) {
		this.subheadNameGuj = subheadNameGuj;
	}

	/**
	 * @return the subHeadDesc
	 */
	public String getSubHeadDesc() {
		return subHeadDesc;
	}

	/**
	 * @param subHeadDesc the subHeadDesc to set
	 */
	public void setSubHeadDesc(String subHeadDesc) {
		this.subHeadDesc = subHeadDesc;
	}

	/**
	 * @return the subHeadDescGuj
	 */
	public String getSubHeadDescGuj() {
		return subHeadDescGuj;
	}

	/**
	 * @param subHeadDescGuj the subHeadDescGuj to set
	 */
	public void setSubHeadDescGuj(String subHeadDescGuj) {
		this.subHeadDescGuj = subHeadDescGuj;
	}

	/**
	 * @return the subHeadCode
	 */
	public String getSubHeadCode() {
		return subHeadCode;
	}

	/**
	 * @param subHeadCode the subHeadCode to set
	 */
	public void setSubHeadCode(String subHeadCode) {
		this.subHeadCode = subHeadCode;
	}

	/**
	 * @return the subHeadCodecGuj
	 */
	public String getSubHeadCodecGuj() {
		return subHeadCodecGuj;
	}

	/**
	 * @param subHeadCodecGuj the subHeadCodecGuj to set
	 */
	public void setSubHeadCodecGuj(String subHeadCodecGuj) {
		this.subHeadCodecGuj = subHeadCodecGuj;
	}

	/**
	 * @return the subHeadCodeName
	 */
	public String getSubHeadCodeName() {
		return subHeadCodeName;
	}

	/**
	 * @param subHeadCodeName the subHeadCodeName to set
	 */
	public void setSubHeadCodeName(String subHeadCodeName) {
		this.subHeadCodeName = subHeadCodeName;
	}

	/**
	 * @return the subHeadCatType
	 */
	public String getSubHeadCatType() {
		return subHeadCatType;
	}

	/**
	 * @param subHeadCatType the subHeadCatType to set
	 */
	public void setSubHeadCatType(String subHeadCatType) {
		this.subHeadCatType = subHeadCatType;
	}

	/**
	 * @return the subHeadTypeId
	 */
	public Long getSubHeadTypeId() {
		return subHeadTypeId;
	}

	/**
	 * @param subHeadTypeId the subHeadTypeId to set
	 */
	public void setSubHeadTypeId(Long subHeadTypeId) {
		this.subHeadTypeId = subHeadTypeId;
	}

	/**
	 * @return the parentSubheadId
	 */
	public long getParentSubheadId() {
		return parentSubheadId;
	}

	/**
	 * @param parentSubheadId the parentSubheadId to set
	 */
	public void setParentSubheadId(long parentSubheadId) {
		this.parentSubheadId = parentSubheadId;
	}

	/**
	 * @return the edpCode
	 */
	public String getEdpCode() {
		return edpCode;
	}

	/**
	 * @param edpCode the edpCode to set
	 */
	public void setEdpCode(String edpCode) {
		this.edpCode = edpCode;
	}

	/**
	 * @return the planningCode
	 */
	public String getPlanningCode() {
		return planningCode;
	}

	/**
	 * @param planningCode the planningCode to set
	 */
	public void setPlanningCode(String planningCode) {
		this.planningCode = planningCode;
	}

	/**
	 * @return the cssDescription
	 */
	public String getCssDescription() {
		return cssDescription;
	}

	/**
	 * @param cssDescription the cssDescription to set
	 */
	public void setCssDescription(String cssDescription) {
		this.cssDescription = cssDescription;
	}

	/**
	 * @return the isCss
	 */
	public long getIsCss() {
		return isCss;
	}

	/**
	 * @param isCss the isCss to set
	 */
	public void setIsCss(long isCss) {
		this.isCss = isCss;
	}

	/**
	 * @return the minorHeadEntity
	 */
	public LocMsMinorHeadEntity getMinorHeadEntity() {
		return minorHeadEntity;
	}

	/**
	 * @param minorHeadEntity the minorHeadEntity to set
	 */
	public void setMinorHeadEntity(LocMsMinorHeadEntity minorHeadEntity) {
		this.minorHeadEntity = minorHeadEntity;
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
	 * @return the majorHeadEntity
	 */
	public LocMsMajorHeadEntity getMajorHeadEntity() {
		return majorHeadEntity;
	}

	/**
	 * @param majorHeadEntity the majorHeadEntity to set
	 */
	public void setMajorHeadEntity(LocMsMajorHeadEntity majorHeadEntity) {
		this.majorHeadEntity = majorHeadEntity;
	}

	/**
	 * @return the subMajorHeadEntity
	 */
	public LocMsSubMajorHeadEntity getSubMajorHeadEntity() {
		return subMajorHeadEntity;
	}

	/**
	 * @param subMajorHeadEntity the subMajorHeadEntity to set
	 */
	public void setSubMajorHeadEntity(LocMsSubMajorHeadEntity subMajorHeadEntity) {
		this.subMajorHeadEntity = subMajorHeadEntity;
	}

	/**
	 * @return the schemeShortName
	 */
	public String getSchemeShortName() {
		return schemeShortName;
	}

	/**
	 * @param schemeShortName the schemeShortName to set
	 */
	public void setSchemeShortName(String schemeShortName) {
		this.schemeShortName = schemeShortName;
	}

}
