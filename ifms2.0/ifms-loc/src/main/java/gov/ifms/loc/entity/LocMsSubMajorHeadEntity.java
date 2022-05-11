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
 * The Class LocMsSubMajorHeadEntity.
 */
@Entity
@Table(name = "MS_SUBMAJORHEAD", schema = Constant.BUDGET_MASTER_SCHEMA)
public class LocMsSubMajorHeadEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** The sub major head id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBMAJORHEAD_ID")
	private Long subMajorHeadId;

	/** The submajor head name. */
	@Column(name = "SUBMAJORHEAD_NAME")
	private String submajorHeadName;

	/** The submajor head name guj. */
	@Column(name = "SUBMAJORH_NAME_GUJ")
	private String submajorHeadNameGuj;

	/** The sub major head desc. */
	@Column(name = "SUBMAJORHEAD_DESC")
	private String subMajorHeadDesc;

	/** The sub major head desc guj. */
	@Column(name = "SUBMAJORH_DESC_GUJ")
	private String subMajorHeadDescGuj;

	/** The sub major head code. */
	@Column(name = "SUBMAJORHEAD_CODE")
	private String subMajorHeadCode;

	/** The sub major head code guj. */
	@Column(name = "SUBMAJORH_CODE_GUJ")
	private String subMajorHeadCodeGuj;

	/** The sub major head code names. */
	@Column(name = "SUBMAJORH_CODE_NAME")
	private String subMajorHeadCodeNames;

	/** The submajor head type id. */
	@Column(name = "SUBMAJORHEAD_TYPE_ID")
	private Long submajorHeadTypeId;

	/** The p sub major head id. */
	@Column(name = "P_SUBMAJORHEAD_ID")
	private String pSubMajorHeadId;

	/** The demand id. */
	@Column(name = "DEMAND_ID")
	private Long demandId;

	/** The major head entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MAJORHEAD_ID", referencedColumnName = "MAJORHEAD_ID")
	private LocMsMajorHeadEntity majorHeadEntity;

	/**
	 * Instantiates a new loc ms sub major head entity.
	 */
	public LocMsSubMajorHeadEntity() {
		super();
	}

	/**
	 * Instantiates a new loc ms sub major head entity.
	 *
	 * @param submajorHeadId the submajor head id
	 */
	public LocMsSubMajorHeadEntity(Long submajorHeadId) {
		super();
		this.subMajorHeadId = submajorHeadId;
	}

	/**
	 * @return the subMajorHeadId
	 */
	public Long getSubMajorHeadId() {
		return subMajorHeadId;
	}

	/**
	 * @param subMajorHeadId the subMajorHeadId to set
	 */
	public void setSubMajorHeadId(Long subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	/**
	 * @return the submajorHeadName
	 */
	public String getSubmajorHeadName() {
		return submajorHeadName;
	}

	/**
	 * @param submajorHeadName the submajorHeadName to set
	 */
	public void setSubmajorHeadName(String submajorHeadName) {
		this.submajorHeadName = submajorHeadName;
	}

	/**
	 * @return the submajorHeadNameGuj
	 */
	public String getSubmajorHeadNameGuj() {
		return submajorHeadNameGuj;
	}

	/**
	 * @param submajorHeadNameGuj the submajorHeadNameGuj to set
	 */
	public void setSubmajorHeadNameGuj(String submajorHeadNameGuj) {
		this.submajorHeadNameGuj = submajorHeadNameGuj;
	}

	/**
	 * @return the subMajorHeadDesc
	 */
	public String getSubMajorHeadDesc() {
		return subMajorHeadDesc;
	}

	/**
	 * @param subMajorHeadDesc the subMajorHeadDesc to set
	 */
	public void setSubMajorHeadDesc(String subMajorHeadDesc) {
		this.subMajorHeadDesc = subMajorHeadDesc;
	}

	/**
	 * @return the subMajorHeadDescGuj
	 */
	public String getSubMajorHeadDescGuj() {
		return subMajorHeadDescGuj;
	}

	/**
	 * @param subMajorHeadDescGuj the subMajorHeadDescGuj to set
	 */
	public void setSubMajorHeadDescGuj(String subMajorHeadDescGuj) {
		this.subMajorHeadDescGuj = subMajorHeadDescGuj;
	}

	/**
	 * @return the subMajorHeadCode
	 */
	public String getSubMajorHeadCode() {
		return subMajorHeadCode;
	}

	/**
	 * @param subMajorHeadCode the subMajorHeadCode to set
	 */
	public void setSubMajorHeadCode(String subMajorHeadCode) {
		this.subMajorHeadCode = subMajorHeadCode;
	}

	/**
	 * @return the subMajorHeadCodeGuj
	 */
	public String getSubMajorHeadCodeGuj() {
		return subMajorHeadCodeGuj;
	}

	/**
	 * @param subMajorHeadCodeGuj the subMajorHeadCodeGuj to set
	 */
	public void setSubMajorHeadCodeGuj(String subMajorHeadCodeGuj) {
		this.subMajorHeadCodeGuj = subMajorHeadCodeGuj;
	}

	/**
	 * @return the subMajorHeadCodeNames
	 */
	public String getSubMajorHeadCodeNames() {
		return subMajorHeadCodeNames;
	}

	/**
	 * @param subMajorHeadCodeNames the subMajorHeadCodeNames to set
	 */
	public void setSubMajorHeadCodeNames(String subMajorHeadCodeNames) {
		this.subMajorHeadCodeNames = subMajorHeadCodeNames;
	}

	/**
	 * @return the submajorHeadTypeId
	 */
	public Long getSubmajorHeadTypeId() {
		return submajorHeadTypeId;
	}

	/**
	 * @param submajorHeadTypeId the submajorHeadTypeId to set
	 */
	public void setSubmajorHeadTypeId(Long submajorHeadTypeId) {
		this.submajorHeadTypeId = submajorHeadTypeId;
	}

	/**
	 * @return the pSubMajorHeadId
	 */
	public String getpSubMajorHeadId() {
		return pSubMajorHeadId;
	}

	/**
	 * @param pSubMajorHeadId the pSubMajorHeadId to set
	 */
	public void setpSubMajorHeadId(String pSubMajorHeadId) {
		this.pSubMajorHeadId = pSubMajorHeadId;
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

}
