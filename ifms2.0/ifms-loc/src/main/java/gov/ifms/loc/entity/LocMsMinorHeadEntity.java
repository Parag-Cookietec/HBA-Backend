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
 * The Class BudgetMinorHeadEntity.
 * 
 * @version 1.0
 * @created 2019/08/21 17:58:51
 *
 */
@Entity
@Table(name = "MS_MINORHEAD", schema = Constant.BUDGET_MASTER_SCHEMA)
public class LocMsMinorHeadEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The minor head id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MINORHEAD_ID")
	private Long minorHeadId;

	/** The minor head name. */
	@Column(name = "MINORHEAD_NAME")
	private String minorHeadName;

	/** The minor head name guj. */
	@Column(name = "MINORHEAD_NAME_GUJ")
	private String minorHeadNameGuj;

	/** The minor head desc. */
	@Column(name = "MINORHEAD_DESC")
	private String minorHeadDesc;

	/** The minor head desc guj. */
	@Column(name = "MINORHEAD_DESC_GUJ")
	private String minorHeadDescGuj;

	/** The minor head code. */
	@Column(name = "MINORHEAD_CODE")
	private String minorHeadCode;

	/** The minor head code guj. */
	@Column(name = "MINORHEAD_CODE_GUJ")
	private String minorHeadCodeGuj;

	/** The minor head code name. */
	@Column(name = "MINORHEAD_CODE_NAME")
	private String minorHeadCodeName;

	/** The minor head type id. */
	@Column(name = "MINORHEAD_TYPE_ID")
	private long minorHeadTypeId;

	/** The parent minor head id. */
	@Column(name = "PARENT_MINORHEAD_ID")
	private long parentMinorHeadId;

	/** The sub major head entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBMAJORHEAD_ID", referencedColumnName = "SUBMAJORHEAD_ID", insertable = false, updatable = false)
	private LocMsSubMajorHeadEntity subMajorHeadEntity;

	/** The major head entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAJORHEAD_ID", referencedColumnName = "MAJORHEAD_ID", insertable = false, updatable = false)
	private LocMsMajorHeadEntity majorHeadEntity;

	/** The demand id. */
	@Column(name = "DEMAND_ID")
	private Long demandId;

	/**
	 * Instantiates a new loc ms minor head entity.
	 */
	public LocMsMinorHeadEntity() {
		super();
	}

	/**
	 * Instantiates a new loc ms minor head entity.
	 *
	 * @param minorHeadId the minor head id
	 */
	public LocMsMinorHeadEntity(Long minorHeadId) {
		super();
		this.minorHeadId = minorHeadId;
	}

	/**
	 * @return the minorHeadId
	 */
	public Long getMinorHeadId() {
		return minorHeadId;
	}

	/**
	 * @param minorHeadId the minorHeadId to set
	 */
	public void setMinorHeadId(Long minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	/**
	 * @return the minorHeadName
	 */
	public String getMinorHeadName() {
		return minorHeadName;
	}

	/**
	 * @param minorHeadName the minorHeadName to set
	 */
	public void setMinorHeadName(String minorHeadName) {
		this.minorHeadName = minorHeadName;
	}

	/**
	 * @return the minorHeadNameGuj
	 */
	public String getMinorHeadNameGuj() {
		return minorHeadNameGuj;
	}

	/**
	 * @param minorHeadNameGuj the minorHeadNameGuj to set
	 */
	public void setMinorHeadNameGuj(String minorHeadNameGuj) {
		this.minorHeadNameGuj = minorHeadNameGuj;
	}

	/**
	 * @return the minorHeadDesc
	 */
	public String getMinorHeadDesc() {
		return minorHeadDesc;
	}

	/**
	 * @param minorHeadDesc the minorHeadDesc to set
	 */
	public void setMinorHeadDesc(String minorHeadDesc) {
		this.minorHeadDesc = minorHeadDesc;
	}

	/**
	 * @return the minorHeadDescGuj
	 */
	public String getMinorHeadDescGuj() {
		return minorHeadDescGuj;
	}

	/**
	 * @param minorHeadDescGuj the minorHeadDescGuj to set
	 */
	public void setMinorHeadDescGuj(String minorHeadDescGuj) {
		this.minorHeadDescGuj = minorHeadDescGuj;
	}

	/**
	 * @return the minorHeadCode
	 */
	public String getMinorHeadCode() {
		return minorHeadCode;
	}

	/**
	 * @param minorHeadCode the minorHeadCode to set
	 */
	public void setMinorHeadCode(String minorHeadCode) {
		this.minorHeadCode = minorHeadCode;
	}

	/**
	 * @return the minorHeadCodeGuj
	 */
	public String getMinorHeadCodeGuj() {
		return minorHeadCodeGuj;
	}

	/**
	 * @param minorHeadCodeGuj the minorHeadCodeGuj to set
	 */
	public void setMinorHeadCodeGuj(String minorHeadCodeGuj) {
		this.minorHeadCodeGuj = minorHeadCodeGuj;
	}

	/**
	 * @return the minorHeadCodeName
	 */
	public String getMinorHeadCodeName() {
		return minorHeadCodeName;
	}

	/**
	 * @param minorHeadCodeName the minorHeadCodeName to set
	 */
	public void setMinorHeadCodeName(String minorHeadCodeName) {
		this.minorHeadCodeName = minorHeadCodeName;
	}

	/**
	 * @return the minorHeadTypeId
	 */
	public long getMinorHeadTypeId() {
		return minorHeadTypeId;
	}

	/**
	 * @param minorHeadTypeId the minorHeadTypeId to set
	 */
	public void setMinorHeadTypeId(long minorHeadTypeId) {
		this.minorHeadTypeId = minorHeadTypeId;
	}

	/**
	 * @return the parentMinorHeadId
	 */
	public long getParentMinorHeadId() {
		return parentMinorHeadId;
	}

	/**
	 * @param parentMinorHeadId the parentMinorHeadId to set
	 */
	public void setParentMinorHeadId(long parentMinorHeadId) {
		this.parentMinorHeadId = parentMinorHeadId;
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

}
