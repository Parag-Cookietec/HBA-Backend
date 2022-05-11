package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPLkPuoMenuRLWFEntity.
 * 
 * @version 1.0
 * @created 2019/11/28 12:49:10
 *
 */
@Entity
@Table(name = "LK_PUO_MENU_RL_WF", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPuoMenuRLWFEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_PUO_MENU_RL_WF_ID")
	private Long lkPuoMenuRlwfId;

	@Column(name = "LK_PUO_MENU_ROLES_ID")
	private  Long lkPuoMenuRoleId;

	@Column(name = "WF_ROLE_ID")
	private  Long workflowRoleId;

	/**
	 * EDPLkPuoMenuRLWFDto Constructor
	 */
	public EDPLkPuoMenuRLWFEntity() {
		super();
	}

	/**
	 * @return the lkPuoMenuRlwfId
	 */
	public Long getLkPuoMenuRlwfId() {
		return lkPuoMenuRlwfId;
	}

	/**
	 * @param lkPuoMenuRlwfId the lkPuoMenuRlwfId to set
	 */
	public void setLkPuoMenuRlwfId(Long lkPuoMenuRlwfId) {
		this.lkPuoMenuRlwfId = lkPuoMenuRlwfId;
	}

	/**
	 * @return the lkPuoMenuRoleId
	 */
	public Long getLkPuoMenuRoleId() {
		return lkPuoMenuRoleId;
	}

	/**
	 * @param lkPuoMenuRoleId the lkPuoMenuRoleId to set
	 */
	public void setLkPuoMenuRoleId(Long lkPuoMenuRoleId) {
		this.lkPuoMenuRoleId = lkPuoMenuRoleId;
	}

	/**
	 * @return the workflowRoleId
	 */
	public Long getWorkflowRoleId() {
		return workflowRoleId;
	}

	/**
	 * @param workflowRoleId the workflowRoleId to set
	 */
	public void setWorkflowRoleId(Long workflowRoleId) {
		this.workflowRoleId = workflowRoleId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lkPuoMenuRlwfId, lkPuoMenuRoleId, workflowRoleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPLkPuoMenuRLWFEntity)) {
			return false;
		}
		EDPLkPuoMenuRLWFEntity other = (EDPLkPuoMenuRLWFEntity) obj;
		return Objects.equals(lkPuoMenuRlwfId, other.lkPuoMenuRlwfId)
				&& Objects.equals(lkPuoMenuRoleId, other.lkPuoMenuRoleId)
				&& Objects.equals(workflowRoleId, other.workflowRoleId);
	}

	

}
