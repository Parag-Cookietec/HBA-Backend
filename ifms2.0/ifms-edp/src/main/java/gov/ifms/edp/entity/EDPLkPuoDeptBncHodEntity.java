package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
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
 * The Class EDPLkPuoDeptBncHodEntity.
 * 
 * @version 1.0
 * @created 2019/12/19 12:31:18
 *
 */
@Entity
@Table(name = "LK_PUO_DEPT_BNC_HOD", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPuoDeptBncHodEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk puo dept bpn. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LKPUO_DEPTBNC_HOD_ID")
	private Long lkPuoDeptBpn;

	/** The lk po off user id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "LK_PO_OFF_USER_ID", referencedColumnName = "LK_PO_OFF_USER_ID")
	private EDPLkPoOffUserEntity lkPoOffUserId;

	/** The department id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
	private EDPMsDepartmentEntity departmentId;

	/** The branch id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "BRANCH_ID", referencedColumnName = "BRANCH_ID")
	private EDPMsBranchEntity branchId;

	/** The hod name id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "HOD_NAME_ID", referencedColumnName = "EMP_ID")
	private EDPEmployeEntity hodNameId;

	/**
	 * EDPLkPuoDeptBncHodDto Constructor.
	 */
	public EDPLkPuoDeptBncHodEntity() {
		super();
	}

	/**
	 * Gets the lk puo dept bpn.
	 *
	 * @return the lkPuoDeptBpn
	 */
	public Long getLkPuoDeptBpn() {
		return lkPuoDeptBpn;
	}

	/**
	 * Sets the lk puo dept bpn.
	 *
	 * @param lkPuoDeptBpn the lkPuoDeptBpn to set
	 */
	public void setLkPuoDeptBpn(Long lkPuoDeptBpn) {
		this.lkPuoDeptBpn = lkPuoDeptBpn;
	}

	/**
	 * Gets the department id.
	 *
	 * @return the departmentId
	 */
	public EDPMsDepartmentEntity getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(EDPMsDepartmentEntity departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Gets the branch id.
	 *
	 * @return the branchId
	 */
	public EDPMsBranchEntity getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the branchId to set
	 */
	public void setBranchId(EDPMsBranchEntity branchId) {
		this.branchId = branchId;
	}

	/**
	 * Gets the hod name id.
	 *
	 * @return the hodNameId
	 */
	public EDPEmployeEntity getHodNameId() {
		return hodNameId;
	}

	/**
	 * Sets the hod name id.
	 *
	 * @param hodNameId the hodNameId to set
	 */
	public void setHodNameId(EDPEmployeEntity hodNameId) {
		this.hodNameId = hodNameId;
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
	 * Gets the lk po off user id.
	 *
	 * @return the lkPoOffUserId
	 */
	public EDPLkPoOffUserEntity getLkPoOffUserId() {
		return lkPoOffUserId;
	}

	/**
	 * Sets the lk po off user id.
	 *
	 * @param lkPoOffUserId the lkPoOffUserId to set
	 */
	public void setLkPoOffUserId(EDPLkPoOffUserEntity lkPoOffUserId) {
		this.lkPoOffUserId = lkPoOffUserId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branchId, departmentId, hodNameId, lkPoOffUserId, lkPuoDeptBpn);
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
		if (!(obj instanceof EDPLkPuoDeptBncHodEntity)) {
			return false;
		}
		EDPLkPuoDeptBncHodEntity other = (EDPLkPuoDeptBncHodEntity) obj;
		return Objects.equals(branchId, other.branchId) && Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(hodNameId, other.hodNameId) && Objects.equals(lkPoOffUserId, other.lkPoOffUserId)
				&& Objects.equals(lkPuoDeptBpn, other.lkPuoDeptBpn);
	}

}
