package gov.ifms.workflow.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.common.util.Constant;

/**
 * The Class MsWorkflowRoleEntity.
 * 
 * @version 1.0
 * @created 2019/08/31 12:19:02
 *
 */
@Entity
@Table(name = "WF_WORKFLOW_ROLE", schema = Constant.WORKFLOW_SCHEMA)
public class MsWorkflowRoleEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WF_ROLE_ID")
	private long wfRoleId;

	@Column(name = "WF_ROLE_NAME")
	private String wfRoleName;

	@Column(name = "WF_ROLE_NAME_GUJ")
	private String wfRoleNameGuj;

	@Column(name = "WF_ROLE_DES")
	private String wfRoleDescription;

	@Column(name = "WF_ROLE_DESC_GUJ")
	private String wfRoleDescriptionGuj;

	@Column(name = "PARENT_WF_ROLE_ID")
	private Long parentWfRoleId;

	@Column(name = "WF_ROLE_CODE")
	private String wfRoleCode;

	public String getWfRoleCode() {
		return wfRoleCode;
	}

	public void setWfRoleCode(String wfRoleCode) {
		this.wfRoleCode = wfRoleCode;
	}

	/**
	 * @return the wfRoleId
	 */
	public long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @return the wfRoleName
	 */
	public String getWfRoleName() {
		return wfRoleName;
	}

	/**
	 * @param wfRoleName the wfRoleName to set
	 */
	public void setWfRoleName(String wfRoleName) {
		this.wfRoleName = wfRoleName;
	}

	/**
	 * @return the wfRoleNameGuj
	 */
	public String getWfRoleNameGuj() {
		return wfRoleNameGuj;
	}

	/**
	 * @param wfRoleNameGuj the wfRoleNameGuj to set
	 */
	public void setWfRoleNameGuj(String wfRoleNameGuj) {
		this.wfRoleNameGuj = wfRoleNameGuj;
	}

	/**
	 * @return the wfRoleDescription
	 */
	public String getWfRoleDescription() {
		return wfRoleDescription;
	}

	/**
	 * @param wfRoleDescription the wfRoleDescription to set
	 */
	public void setWfRoleDescription(String wfRoleDescription) {
		this.wfRoleDescription = wfRoleDescription;
	}

	/**
	 * @return the wfRoleDescriptionGuj
	 */
	public String getWfRoleDescriptionGuj() {
		return wfRoleDescriptionGuj;
	}

	/**
	 * @param wfRoleDescriptionGuj the wfRoleDescriptionGuj to set
	 */
	public void setWfRoleDescriptionGuj(String wfRoleDescriptionGuj) {
		this.wfRoleDescriptionGuj = wfRoleDescriptionGuj;
	}

	/**
	 * @return the parentWfRoleId
	 */
	public Long getParentWfRoleId() {
		return parentWfRoleId;
	}

	/**
	 * @param parentWfRoleId the parentWfRoleId to set
	 */
	public void setParentWfRoleId(Long parentWfRoleId) {
		this.parentWfRoleId = parentWfRoleId;
	}

	public MsWorkflowRoleEntity() {
		super();
	}
	
	public MsWorkflowRoleEntity(long wfRoleId) {
		super();
		this.wfRoleId = wfRoleId;
	}

	public MsWorkflowRoleEntity(int wfRoleId, String wfRoleName, String wfRoleNameGuj, String wfRoleDescription,
			String wfRoleDescriptionGuj, Long parentWfRoleId) {
		super();
		this.wfRoleId = wfRoleId;
		this.wfRoleName = wfRoleName;
		this.wfRoleNameGuj = wfRoleNameGuj;
		this.wfRoleDescription = wfRoleDescription;
		this.wfRoleDescriptionGuj = wfRoleDescriptionGuj;
		this.parentWfRoleId = parentWfRoleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(parentWfRoleId, wfRoleDescription, wfRoleDescriptionGuj, wfRoleId, wfRoleName,
				wfRoleNameGuj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MsWorkflowRoleEntity)) {
			return false;
		}
		MsWorkflowRoleEntity other = (MsWorkflowRoleEntity) obj;
		return Objects.equals(parentWfRoleId, other.parentWfRoleId)
				&& Objects.equals(wfRoleDescription, other.wfRoleDescription)
				&& Objects.equals(wfRoleDescriptionGuj, other.wfRoleDescriptionGuj) && wfRoleId == other.wfRoleId
				&& Objects.equals(wfRoleName, other.wfRoleName) && Objects.equals(wfRoleNameGuj, other.wfRoleNameGuj);
	}
}
