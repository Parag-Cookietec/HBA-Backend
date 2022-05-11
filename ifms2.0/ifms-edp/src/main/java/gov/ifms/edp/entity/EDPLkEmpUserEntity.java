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
import gov.ifms.edp.employe.EDPEmployeEntity;

/**
 * The Class EDPLkEmpUserEntity.
 */
@Entity
@Table(name = "LK_EMP_USER", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkEmpUserEntity extends BaseEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk emp user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_EMP_USER_ID")
	private Long lkEmpUserId;
	
	/** The emp id. */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name ="EMP_ID" ,nullable = false, referencedColumnName ="EMP_ID" )
	private EDPEmployeEntity empId;
	
	/** The user id. */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name ="USER_ID" ,nullable = false, referencedColumnName ="USER_ID" )
	private EDPMsUserEntity userId;

	

	/**
	 * Gets the lk emp user id.
	 *
	 * @return the lkEmpUserId
	 */
	public Long getLkEmpUserId() {
		return lkEmpUserId;
	}

	/**
	 * Sets the lk emp user id.
	 *
	 * @param lkEmpUserId the lkEmpUserId to set
	 */
	public void setLkEmpUserId(Long lkEmpUserId) {
		this.lkEmpUserId = lkEmpUserId;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public EDPEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(EDPEmployeEntity empId) {
		this.empId = empId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public EDPMsUserEntity getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(EDPMsUserEntity userId) {
		this.userId = userId;
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
		return Objects.hash(empId, lkEmpUserId, userId);
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
		if (!(obj instanceof EDPLkEmpUserEntity)) {
			return false;
		}
		EDPLkEmpUserEntity other = (EDPLkEmpUserEntity) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(lkEmpUserId, other.lkEmpUserId)
				&& Objects.equals(userId, other.userId);
	}
	
	
}
