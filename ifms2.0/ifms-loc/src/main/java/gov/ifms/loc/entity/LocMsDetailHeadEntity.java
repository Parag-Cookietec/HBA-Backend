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
import javax.persistence.UniqueConstraint;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class BudgetDetailHeadEntity.
 * 
 * @version 1.0
 * @created 2019/08/21 16:50:47
 *
 */
@Entity
@Table(name = "MS_DETAILHEAD", schema = Constant.BUDGET_MASTER_SCHEMA, uniqueConstraints = @UniqueConstraint(columnNames = {
		"DETAILHEAD_ID" }))
public class LocMsDetailHeadEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The detail head id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DETAILHEAD_ID")
	private Long detailHeadId;

	/** The detail head name. */
	@Column(name = "DETAILHEAD_NAME")
	private String detailHeadName;

	/** The detail head name guj. */
	@Column(name = "DETAILHEAD_NAME_GUJ")
	private String detailHeadNameGuj;

	/** The detail head desc. */
	@Column(name = "DETAILHEAD_DESC")
	private String detailHeadDesc;

	/** The detail head desc guj. */
	@Column(name = "DETAILHEAD_DESC_GUJ")
	private String detailHeadDescGuj;

	/** The detail head code. */
	@Column(name = "DETAILHEAD_CODE")
	private String detailHeadCode;

	/** The detail head code guj. */
	@Column(name = "DETAILHEAD_CODE_GUJ")
	private String detailHeadCodeGuj;

	/** The detail head code name. */
	@Column(name = "DETAILHEAD_CODE_NAME")
	private String detailHeadCodeName;

	/** The detail head type id. */
	@Column(name = "DETAILHEAD_TYPE_ID")
	private Long detailHeadTypeId;

	/** The parent detail head id. */
	@Column(name = "PARENT_DETAILHEAD_ID")
	private long parentDetailHeadId;

	/** The edp code. */
	@Column(name = "EDP_CODE")
	private String edpCode;

	/** The planning code. */
	@Column(name = "PLANNING_CODE")
	private String planningCode;

	/** The scheme short name. */
	@Column(name = "SCHEME_SHORT_NAME")
	private String schemeShortName;

	/** The css desc. */
	@Column(name = "CSS_DESC")
	private String cssDesc;

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

	/** The sub head entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBHEAD_ID", referencedColumnName = "SUBHEAD_ID", updatable = false)
	private LocMsSubHeadEntity subHeadEntity;

	/**
	 * Instantiates a new loc ms detail head entity.
	 */
	public LocMsDetailHeadEntity() {
	}

	/**
	 * Instantiates a new loc ms detail head entity.
	 *
	 * @param detailHeadId the detail head id
	 */
	public LocMsDetailHeadEntity(Long detailHeadId) {
		super();
		this.detailHeadId = detailHeadId;
	}

	/**
	 * @return the detailHeadId
	 */
	public Long getDetailHeadId() {
		return detailHeadId;
	}

	/**
	 * @param detailHeadId the detailHeadId to set
	 */
	public void setDetailHeadId(Long detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	/**
	 * @return the detailHeadName
	 */
	public String getDetailHeadName() {
		return detailHeadName;
	}

	/**
	 * @param detailHeadName the detailHeadName to set
	 */
	public void setDetailHeadName(String detailHeadName) {
		this.detailHeadName = detailHeadName;
	}

	/**
	 * @return the detailHeadNameGuj
	 */
	public String getDetailHeadNameGuj() {
		return detailHeadNameGuj;
	}

	/**
	 * @param detailHeadNameGuj the detailHeadNameGuj to set
	 */
	public void setDetailHeadNameGuj(String detailHeadNameGuj) {
		this.detailHeadNameGuj = detailHeadNameGuj;
	}

	/**
	 * @return the detailHeadDesc
	 */
	public String getDetailHeadDesc() {
		return detailHeadDesc;
	}

	/**
	 * @param detailHeadDesc the detailHeadDesc to set
	 */
	public void setDetailHeadDesc(String detailHeadDesc) {
		this.detailHeadDesc = detailHeadDesc;
	}

	/**
	 * @return the detailHeadDescGuj
	 */
	public String getDetailHeadDescGuj() {
		return detailHeadDescGuj;
	}

	/**
	 * @param detailHeadDescGuj the detailHeadDescGuj to set
	 */
	public void setDetailHeadDescGuj(String detailHeadDescGuj) {
		this.detailHeadDescGuj = detailHeadDescGuj;
	}

	/**
	 * @return the detailHeadCode
	 */
	public String getDetailHeadCode() {
		return detailHeadCode;
	}

	/**
	 * @param detailHeadCode the detailHeadCode to set
	 */
	public void setDetailHeadCode(String detailHeadCode) {
		this.detailHeadCode = detailHeadCode;
	}

	/**
	 * @return the detailHeadCodeGuj
	 */
	public String getDetailHeadCodeGuj() {
		return detailHeadCodeGuj;
	}

	/**
	 * @param detailHeadCodeGuj the detailHeadCodeGuj to set
	 */
	public void setDetailHeadCodeGuj(String detailHeadCodeGuj) {
		this.detailHeadCodeGuj = detailHeadCodeGuj;
	}

	/**
	 * @return the detailHeadCodeName
	 */
	public String getDetailHeadCodeName() {
		return detailHeadCodeName;
	}

	/**
	 * @param detailHeadCodeName the detailHeadCodeName to set
	 */
	public void setDetailHeadCodeName(String detailHeadCodeName) {
		this.detailHeadCodeName = detailHeadCodeName;
	}

	/**
	 * @return the detailHeadTypeId
	 */
	public Long getDetailHeadTypeId() {
		return detailHeadTypeId;
	}

	/**
	 * @param detailHeadTypeId the detailHeadTypeId to set
	 */
	public void setDetailHeadTypeId(Long detailHeadTypeId) {
		this.detailHeadTypeId = detailHeadTypeId;
	}

	/**
	 * @return the parentDetailHeadId
	 */
	public long getParentDetailHeadId() {
		return parentDetailHeadId;
	}

	/**
	 * @param parentDetailHeadId the parentDetailHeadId to set
	 */
	public void setParentDetailHeadId(long parentDetailHeadId) {
		this.parentDetailHeadId = parentDetailHeadId;
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

	/**
	 * @return the cssDesc
	 */
	public String getCssDesc() {
		return cssDesc;
	}

	/**
	 * @param cssDesc the cssDesc to set
	 */
	public void setCssDesc(String cssDesc) {
		this.cssDesc = cssDesc;
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
	 * @return the subHeadEntity
	 */
	public LocMsSubHeadEntity getSubHeadEntity() {
		return subHeadEntity;
	}

	/**
	 * @param subHeadEntity the subHeadEntity to set
	 */
	public void setSubHeadEntity(LocMsSubHeadEntity subHeadEntity) {
		this.subHeadEntity = subHeadEntity;
	}

}
