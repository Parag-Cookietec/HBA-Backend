package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUEmployeFixPayDetailsEntity.
 * 
 * @version v 1.0
 * @created 2020/01/08 20:46:39
 *
 */
@Entity
@Table(name = "T_EMP_FIX_PAY", schema = Constant.PVU_SCHEMA)
public class PVUEmployeFixPayDetailsEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The fix pay id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_FIX_PAY_ID")
	private long fixPayId;

	/** The eff date. */
	@Column(name = "EFF_DATE")
	private Date effDate;

	/** The fix pay value. */
	@OneToOne(optional = false)
	@JoinColumn(name = "FIX_PAY_VALUE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity fixPayValue;

	/** The pvu employe entity. */
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	private PVUEmployeEntity empId;

	/**
	 * PVUEmployeFixPayDetailsEntity Constructor.
	 */
	public PVUEmployeFixPayDetailsEntity() {
		super();
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(PVUEmployeEntity empId) {
		this.empId = empId;
	}

	/**
	 * Gets the fix pay id.
	 *
	 * @return the fixPayId
	 */
	public long getFixPayId() {
		return fixPayId;
	}

	/**
	 * Sets the fix pay id.
	 *
	 * @param fixPayId the fixPayId to set
	 */
	public void setFixPayId(long fixPayId) {
		this.fixPayId = fixPayId;
	}

	/**
	 * Gets the eff date.
	 *
	 * @return the effDate
	 */
	public Date getEffDate() {
		return effDate;
	}

	/**
	 * Sets the eff date.
	 *
	 * @param effDate the effDate to set
	 */
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	/**
	 * Gets the fix pay value.
	 *
	 * @return the fix pay value
	 */
	public EDPLuLookUpInfoEntity getFixPayValue() {
		return fixPayValue;
	}

	/**
	 * Sets the fix pay value.
	 *
	 * @param fixPayValue the new fix pay value
	 */
	public void setFixPayValue(EDPLuLookUpInfoEntity fixPayValue) {
		this.fixPayValue = fixPayValue;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(effDate, empId, fixPayId, fixPayValue);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeFixPayDetailsEntity other = (PVUEmployeFixPayDetailsEntity) obj;
		return Objects.equals(effDate, other.effDate) && Objects.equals(empId, other.empId)
				&& fixPayId == other.fixPayId && fixPayValue == other.fixPayValue;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeFixPayDetailsEntity [fixPayId=" + fixPayId + ", effDate=" + effDate + ", fixPayValue="
				+ fixPayValue + ", empId=" + empId + "]";
	}
}