package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class BudgetBPNEntity.
 *
 * @version 1.0
 * @created 2019/08/21 15:05:22
 */
@Entity
@Table(name = "MS_BPN", schema = Constant.BUDGET_MASTER_SCHEMA)
public class LocMsBPNEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bpn id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BPN_ID")
	private long bpnId;

	/** The bpn name. */
	@Column(name = "BPN_NAME")
	private String bpnName;

	/** The bpn name guj. */
	@Column(name = "BPN_NAME_GUJ")
	private String bpnNameGuj;

	/** The bpn code. */
	@Column(name = "BPN_CODE", unique = true)
	private String bpnCode;

	/** The bpn code guj. */
	@Column(name = "BPN_CODE_GUJ")
	private String bpnCodeGuj;

	/** The bpn description. */
	@Column(name = "BPN_DESCRIPTION")
	private String bpnDescription;

	/** The bpn description guj. */
	@Column(name = "BPN_DESCRIPTION_GUJ")
	private String bpnDescriptionGuj;

	/** The bpn code name. */
	@Column(name = "BPN_CODE_NAME")
	private String bpnCodeName;

	/** The bpn type id. */
	@Column(name = "BPN_TYPE_ID")
	private Long bpnTypeId;

	/** The parent bpn id. */
	@Column(name = "PARENT_BPN_ID")
	private int parentBpnId;

	/**
	 * Gets the bpn id.
	 *
	 * @return the bpnId
	 */
	public long getBpnId() {
		return bpnId;
	}

	/**
	 * Sets the bpn id.
	 *
	 * @param bpnId the bpnId to set
	 */
	public void setBpnId(long bpnId) {
		this.bpnId = bpnId;
	}

	/**
	 * Gets the bpn name.
	 *
	 * @return the bpnName
	 */
	public String getBpnName() {
		return bpnName;
	}

	/**
	 * Sets the bpn name.
	 *
	 * @param bpnName the bpnName to set
	 */
	public void setBpnName(String bpnName) {
		this.bpnName = bpnName;
	}

	/**
	 * Gets the bpn name guj.
	 *
	 * @return the bpnNameGuj
	 */
	public String getBpnNameGuj() {
		return bpnNameGuj;
	}

	/**
	 * Sets the bpn name guj.
	 *
	 * @param bpnNameGuj the bpnNameGuj to set
	 */
	public void setBpnNameGuj(String bpnNameGuj) {
		this.bpnNameGuj = bpnNameGuj;
	}

	/**
	 * Gets the bpn code.
	 *
	 * @return the bpnCode
	 */
	public String getBpnCode() {
		return bpnCode;
	}

	/**
	 * Sets the bpn code.
	 *
	 * @param bpnCode the bpnCode to set
	 */
	public void setBpnCode(String bpnCode) {
		this.bpnCode = bpnCode;
	}

	/**
	 * Gets the bpn code guj.
	 *
	 * @return the bpnCodeGuj
	 */
	public String getBpnCodeGuj() {
		return bpnCodeGuj;
	}

	/**
	 * Sets the bpn code guj.
	 *
	 * @param bpnCodeGuj the bpnCodeGuj to set
	 */
	public void setBpnCodeGuj(String bpnCodeGuj) {
		this.bpnCodeGuj = bpnCodeGuj;
	}

	/**
	 * Gets the bpn description.
	 *
	 * @return the bpnDescription
	 */
	public String getBpnDescription() {
		return bpnDescription;
	}

	/**
	 * Sets the bpn description.
	 *
	 * @param bpnDescription the bpnDescription to set
	 */
	public void setBpnDescription(String bpnDescription) {
		this.bpnDescription = bpnDescription;
	}

	/**
	 * Gets the bpn description guj.
	 *
	 * @return the bpnDescriptionGuj
	 */
	public String getBpnDescriptionGuj() {
		return bpnDescriptionGuj;
	}

	/**
	 * Sets the bpn description guj.
	 *
	 * @param bpnDescriptionGuj the bpnDescriptionGuj to set
	 */
	public void setBpnDescriptionGuj(String bpnDescriptionGuj) {
		this.bpnDescriptionGuj = bpnDescriptionGuj;
	}

	/**
	 * Gets the bpn code name.
	 *
	 * @return the bpnCodeName
	 */
	public String getBpnCodeName() {
		return bpnCodeName;
	}

	/**
	 * Sets the bpn code name.
	 *
	 * @param bpnCodeName the bpnCodeName to set
	 */
	public void setBpnCodeName(String bpnCodeName) {
		this.bpnCodeName = bpnCodeName;
	}

	/**
	 * Gets the bpn type id.
	 *
	 * @return the bpn type id
	 */
	public Long getBpnTypeId() {
		return bpnTypeId;
	}

	/**
	 * Sets the bpn type id.
	 *
	 * @param bpnTypeId the new bpn type id
	 */
	public void setBpnTypeId(Long bpnTypeId) {
		this.bpnTypeId = bpnTypeId;
	}

	/**
	 * Gets the parent bpn id.
	 *
	 * @return the parentBpnId
	 */
	public int getParentBpnId() {
		return parentBpnId;
	}

	/**
	 * Sets the parent bpn id.
	 *
	 * @param parentBpnId the parentBpnId to set
	 */
	public void setParentBpnId(int parentBpnId) {
		this.parentBpnId = parentBpnId;
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
	 * Instantiates a new loc ms BPN entity.
	 */
	public LocMsBPNEntity() {
		super();
	}

	/**
	 * Instantiates a new loc ms BPN entity.
	 *
	 * @param bpnId the bpn id
	 */
	public LocMsBPNEntity(long bpnId) {
		super();
		this.bpnId = bpnId;
	}

	/**
	 * Instantiates a new loc ms BPN entity.
	 *
	 * @param bpnId   the bpn id
	 * @param bpnCode the bpn code
	 */
	public LocMsBPNEntity(long bpnId, String bpnCode) {
		super();
		this.bpnId = bpnId;
		this.bpnCode = bpnCode;
	}

	/**
	 * Instantiates a new loc ms BPN entity.
	 *
	 * @param bpnCode the bpn code
	 */
	public LocMsBPNEntity(String bpnCode) {
		super();
		this.bpnCode = bpnCode;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(bpnCode, bpnCodeGuj, bpnCodeName, bpnDescription, bpnDescriptionGuj, bpnId, bpnName,
				bpnNameGuj, bpnTypeId, parentBpnId/* , financialYear, demandId */);
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
		if (!(obj instanceof LocMsBPNEntity)) {
			return false;
		}
		LocMsBPNEntity other = (LocMsBPNEntity) obj;
		return Objects.equals(bpnCode, other.bpnCode) && Objects.equals(bpnCodeGuj, other.bpnCodeGuj)
				&& Objects.equals(bpnCodeName, other.bpnCodeName)
				&& Objects.equals(bpnDescription, other.bpnDescription)
				&& Objects.equals(bpnDescriptionGuj, other.bpnDescriptionGuj) && bpnId == other.bpnId
				&& Objects.equals(bpnName, other.bpnName) && Objects.equals(bpnNameGuj, other.bpnNameGuj)
				&& Objects.equals(bpnTypeId, other.bpnTypeId) && parentBpnId == other.parentBpnId;
	}

}
