package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
 * The Class PVURopEventConfigurationEntity.
 */
@Entity
@Table(name = "PVU_ROP_EVNT_CONFIG", schema = Constant.PVU_SCHEMA)
public class PVURopEventConfigurationEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROP_EVNT_CONFIG_ID")
	private long id;

	/** The rop type. */
	@Column(name = "ROP_TYPE")
	private Long ropType;

	/** The with npa. */
	@Column(name = "WITH_NPA")
	private BigDecimal withNpa;

	/** The without npa. */
	@Column(name = "WIHTOUT_NPA")
	private BigDecimal withoutNpa;

	/** The effective date. */
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;

	/** The master table. */
	@Column(name = "MST_TABLE")
	private String masterTable;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the rop type.
	 *
	 * @return the ropType
	 */
	public Long getRopType() {
		return ropType;
	}

	/**
	 * Sets the rop type.
	 *
	 * @param ropType the ropType to set
	 */
	public void setRopType(Long ropType) {
		this.ropType = ropType;
	}

	/**
	 * Gets the with npa.
	 *
	 * @return the withNpa
	 */
	public BigDecimal getWithNpa() {
		return withNpa;
	}

	/**
	 * Sets the with npa.
	 *
	 * @param withNpa the withNpa to set
	 */
	public void setWithNpa(BigDecimal withNpa) {
		this.withNpa = withNpa;
	}

	/**
	 * Gets the without npa.
	 *
	 * @return the withoutNpa
	 */
	public BigDecimal getWithoutNpa() {
		return withoutNpa;
	}

	/**
	 * Sets the without npa.
	 *
	 * @param withoutNpa the withoutNpa to set
	 */
	public void setWithoutNpa(BigDecimal withoutNpa) {
		this.withoutNpa = withoutNpa;
	}

	/**
	 * Gets the effective date.
	 *
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Sets the effective date.
	 *
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Gets the master table.
	 *
	 * @return the masterTable
	 */
	public String getMasterTable() {
		return masterTable;
	}

	/**
	 * Sets the master table.
	 *
	 * @param masterTable the masterTable to set
	 */
	public void setMasterTable(String masterTable) {
		this.masterTable = masterTable;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(effectiveDate, id, masterTable, ropType, withNpa, withoutNpa);
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
		if (!(obj instanceof PVURopEventConfigurationEntity)) {
			return false;
		}
		PVURopEventConfigurationEntity other = (PVURopEventConfigurationEntity) obj;
		return Objects.equals(effectiveDate, other.effectiveDate) && id == other.id
				&& Objects.equals(masterTable, other.masterTable) && Objects.equals(ropType, other.ropType)
				&& Objects.equals(withNpa, other.withNpa) && Objects.equals(withoutNpa, other.withoutNpa);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVURopEventConfigurationEntity [id=" + id + ", ropType=" + ropType + ", withNpa=" + withNpa
				+ ", withoutNpa=" + withoutNpa + ", effectiveDate=" + effectiveDate + ", masterTable=" + masterTable
				+ "]";
	}

}
