package gov.ifms.edp.entity;

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

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsBranchEntity.
 */
@Entity
@Table(name = "MS_BRANCH", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsBranchEntity extends BaseEntity implements Serializable {
	
	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The branch id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BRANCH_ID")
	private Long branchId;

	/** The branch name. */
	@Column(name = "BRANCH_NAME")
	private String branchName;

	/** The branch name guj. */
	@Column(name = "BRANCH_NAME_GUJ")
	private String branchNameGuj;

	/** The branch desc. */
	@Column(name = "BRANCH_DESC")
	private String branchDesc;

	/** The branch desc guj. */
	@Column(name = "BRANCH_DESC_GUJ")
	private String branchDescGuj;

	/** The branch code. */
	@Column(name = "BRANCH_CODE")
	private String branchCode;

	/** The branch code guj. */
	@Column(name = "BRANCH_CODE_GUJ")
	private String branchCodeGuj;

	/** The branch code name. */
	@Column(name = "BRANCH_CODE_NAME")
	private String branchCodeName;

	/** The branch type id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity branchTypeId;

	/** The parent branch id. */
	@Column(name = "PARENT_BRANCH_ID")
	private Long parentBranchId;

	/** The epd ms location entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity edpMsOffice;

	/**
	 * Gets the branch id.
	 *
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * Gets the branch name.
	 *
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Gets the branch name guj.
	 *
	 * @return the branchNameGuj
	 */
	public String getBranchNameGuj() {
		return branchNameGuj;
	}

	/**
	 * Sets the branch name guj.
	 *
	 * @param branchNameGuj the branchNameGuj to set
	 */
	public void setBranchNameGuj(String branchNameGuj) {
		this.branchNameGuj = branchNameGuj;
	}

	/**
	 * Gets the branch desc.
	 *
	 * @return the branchDesc
	 */
	public String getBranchDesc() {
		return branchDesc;
	}

	/**
	 * Sets the branch desc.
	 *
	 * @param branchDesc the branchDesc to set
	 */
	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}

	/**
	 * Gets the branch desc guj.
	 *
	 * @return the branchDescGuj
	 */
	public String getBranchDescGuj() {
		return branchDescGuj;
	}

	/**
	 * Sets the branch desc guj.
	 *
	 * @param branchDescGuj the branchDescGuj to set
	 */
	public void setBranchDescGuj(String branchDescGuj) {
		this.branchDescGuj = branchDescGuj;
	}

	/**
	 * Gets the branch code.
	 *
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * Sets the branch code.
	 *
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * Gets the branch code guj.
	 *
	 * @return the branchCodeGuj
	 */
	public String getBranchCodeGuj() {
		return branchCodeGuj;
	}

	/**
	 * Sets the branch code guj.
	 *
	 * @param branchCodeGuj the branchCodeGuj to set
	 */
	public void setBranchCodeGuj(String branchCodeGuj) {
		this.branchCodeGuj = branchCodeGuj;
	}

	/**
	 * Gets the branch code name.
	 *
	 * @return the branchCodeName
	 */
	public String getBranchCodeName() {
		return branchCodeName;
	}

	/**
	 * Sets the branch code name.
	 *
	 * @param branchCodeName the branchCodeName to set
	 */
	public void setBranchCodeName(String branchCodeName) {
		this.branchCodeName = branchCodeName;
	}

	/**
	 * Gets the branch type id.
	 *
	 * @return the branchTypeId
	 */
	public EDPLuLookUpInfoEntity getBranchTypeId() {
		return branchTypeId;
	}

	/**
	 * Sets the branch type id.
	 *
	 * @param branchTypeId the branchTypeId to set
	 */
	public void setBranchTypeId(EDPLuLookUpInfoEntity branchTypeId) {
		this.branchTypeId = branchTypeId;
	}

	/**
	 * Gets the parent branch id.
	 *
	 * @return the parentBranchId
	 */
	public Long getParentBranchId() {
		return parentBranchId;
	}

	/**
	 * Sets the parent branch id.
	 *
	 * @param parentBranchId the parentBranchId to set
	 */
	public void setParentBranchId(Long parentBranchId) {
		this.parentBranchId = parentBranchId;
	}

	/**
	 * Gets the edp ms office.
	 *
	 * @return the edpMsOffice
	 */
	public EDPMsOfficeEntity getEdpMsOffice() {
		return edpMsOffice;
	}

	/**
	 * Sets the edp ms office.
	 *
	 * @param edpMsOffice the edpMsOffice to set
	 */
	public void setEdpMsOffice(EDPMsOfficeEntity edpMsOffice) {
		this.edpMsOffice = edpMsOffice;
	}
	
	/**
	 * Instantiates a new EDP ms branch entity.
	 */
	public EDPMsBranchEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms branch entity.
	 *
	 * @param branchId the branch id
	 */
	public EDPMsBranchEntity(Long branchId) {
		super();
		this.branchId = branchId;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branchCode, branchCodeGuj, branchCodeName, branchDesc, branchDescGuj, branchId, branchName,
				branchNameGuj, branchTypeId, edpMsOffice, parentBranchId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPMsBranchEntity)) {
			return false;
		}
		EDPMsBranchEntity other = (EDPMsBranchEntity) obj;
		return Objects.equals(branchCode, other.branchCode) && Objects.equals(branchCodeGuj, other.branchCodeGuj)
				&& Objects.equals(branchCodeName, other.branchCodeName) && Objects.equals(branchDesc, other.branchDesc)
				&& Objects.equals(branchDescGuj, other.branchDescGuj) && Objects.equals(branchId, other.branchId)
				&& Objects.equals(branchName, other.branchName) && Objects.equals(branchNameGuj, other.branchNameGuj)
				&& Objects.equals(branchTypeId, other.branchTypeId) && Objects.equals(edpMsOffice, other.edpMsOffice)
				&& Objects.equals(parentBranchId, other.parentBranchId);
	}
	
}