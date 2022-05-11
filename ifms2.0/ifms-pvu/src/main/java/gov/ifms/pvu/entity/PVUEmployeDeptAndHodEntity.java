package gov.ifms.pvu.entity;

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
 * The Class PVUEmployeDeptAndHodEntity.
 * @version v 1.0
 * @created 2020/01/10 16:26:19
 *
 */
@Entity
@Table(name="LK_DEPT_HOD"  , schema = Constant.PVU_SCHEMA_MASTER )
public class PVUEmployeDeptAndHodEntity extends BaseEntity  implements Serializable{
	
	
	/** The serialVersionUID*/ 
	private static final long serialVersionUID = 1L;
	
	
	
 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="LK_DEPT_HOD_ID")
private  Long deptHodId;

	public void setDeptHodId(Long deptHodId) {
		this.deptHodId = deptHodId;
	}

	@Column(name="DEPARTMENT_ID")
private  Long departmentId;

	public void setHodId(Long hodId) {
		this.hodId = hodId;
	}
	@Column(name="HOD_ID")
private  Long hodId;

	
	/**
	* PVUEmployeDeptAndHodEntity Constructor
	*/
	public PVUEmployeDeptAndHodEntity() {
		super();
	}





	/**
	 * @return the departmentId
	 *//*
	public EDPMsDepartmentEntity getDepartmentId() {
		return departmentId;
	}


	*//**
	 * @param departmentId the departmentId to set
	 *//*
	public void setDepartmentId(EDPMsDepartmentEntity departmentId) {
		this.departmentId = departmentId;
	}


	*//**
	 * @return the hodId
	 *//*
	public EDPEmployeEntity getHodId() {
		return hodId;
	}


	*/

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getHodId() {
		return hodId;
	}

	/**
	 * @param hodId the hodId to set
	 *//*
	public void setHodId(EDPEmployeEntity hodId) {
		this.hodId = hodId;
	}*/


	@Override
	public int hashCode() {
		return Objects.hash(departmentId, deptHodId, hodId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeDeptAndHodEntity other = (PVUEmployeDeptAndHodEntity) obj;
		return Objects.equals(departmentId, other.departmentId) && Objects.equals(deptHodId, other.deptHodId)
				&& Objects.equals(hodId, other.hodId);
	}


	@Override
	public String toString() {
		return "PVUEmployeDeptAndHodEntity [deptHodId=" + deptHodId + ", departmentId=" + departmentId + ", hodId="
				+ hodId + "]";
	}
	
	
    
	
	
	
	
}
