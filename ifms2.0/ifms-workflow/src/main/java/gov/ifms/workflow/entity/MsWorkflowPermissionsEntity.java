package gov.ifms.workflow.entity;

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
 * The Class BudgetBudgetWfMsWorkflowPermissionsEntity.
 * 
 * @version 1.0
 * @created 2019/08/21 13:04:28
 *
 */
@Entity
@Table(name = "WF_MS_WORKFLOW_PERMISSIONS", schema = Constant.WORKFLOW_SCHEMA)
public class MsWorkflowPermissionsEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WF_PERM_ID")
	private long wfPermId;

	@Column(name = "WF_PERM_NAME")
	private String wfPermName;

	@Column(name = "WF_PERM_NAME_GUJ")
	private String wfPermNameGuj;

	@Column(name = "WF_PERM_DESCRIPTION")
	private String wfPermDescription;

	@Column(name = "WF_PERM_DESCRIPTION_GUJ")
	private String wfPermDescriptionGuj;
	
	@Column(name = "PARENT_WF_PERM_ID")
	private long parentWfPermId;

	public MsWorkflowPermissionsEntity(int wfPermId, String wfPermName, String wfPermNameGuj, String wfPermDescription,
			String wfPermDescriptionGuj, int parentWfPermId) {
		super();
		this.wfPermId = wfPermId;
		this.wfPermName = wfPermName;
		this.wfPermNameGuj = wfPermNameGuj;
		this.wfPermDescription = wfPermDescription;
		this.wfPermDescriptionGuj = wfPermDescriptionGuj;
		this.parentWfPermId = parentWfPermId;
	}

	public MsWorkflowPermissionsEntity() {
		super();
	}

	public MsWorkflowPermissionsEntity(long wfPermId) {
		super();
		this.wfPermId = wfPermId;
	}

	/**
	 * @return the wfPermId
	 */
	public long getWfPermId() {
		return wfPermId;
	}

	/**
	 * @param wfPermId the wfPermId to set
	 */
	public void setWfPermId(long wfPermId) {
		this.wfPermId = wfPermId;
	}

	/**
	 * @return the wfPermName
	 */
	public String getWfPermName() {
		return wfPermName;
	}

	/**
	 * @param wfPermName the wfPermName to set
	 */
	public void setWfPermName(String wfPermName) {
		this.wfPermName = wfPermName;
	}

	/**
	 * @return the wfPermNameGuj
	 */
	public String getWfPermNameGuj() {
		return wfPermNameGuj;
	}

	/**
	 * @param wfPermNameGuj the wfPermNameGuj to set
	 */
	public void setWfPermNameGuj(String wfPermNameGuj) {
		this.wfPermNameGuj = wfPermNameGuj;
	}

	/**
	 * @return the wfPermDescription
	 */
	public String getWfPermDescription() {
		return wfPermDescription;
	}

	/**
	 * @param wfPermDescription the wfPermDescription to set
	 */
	public void setWfPermDescription(String wfPermDescription) {
		this.wfPermDescription = wfPermDescription;
	}

	/**
	 * @return the wfPermDescriptionGuj
	 */
	public String getWfPermDescriptionGuj() {
		return wfPermDescriptionGuj;
	}

	/**
	 * @param wfPermDescriptionGuj the wfPermDescriptionGuj to set
	 */
	public void setWfPermDescriptionGuj(String wfPermDescriptionGuj) {
		this.wfPermDescriptionGuj = wfPermDescriptionGuj;
	}

	/**
	 * @return the parentWfPermId
	 */
	public long getParentWfPermId() {
		return parentWfPermId;
	}

	/**
	 * @param parentWfPermId the parentWfPermId to set
	 */
	public void setParentWfPermId(long parentWfPermId) {
		this.parentWfPermId = parentWfPermId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(parentWfPermId, wfPermDescription, wfPermDescriptionGuj, wfPermId, wfPermName,
				wfPermNameGuj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MsWorkflowPermissionsEntity)) {
			return false;
		}
		MsWorkflowPermissionsEntity other = (MsWorkflowPermissionsEntity) obj;
		return parentWfPermId == other.parentWfPermId && Objects.equals(wfPermDescription, other.wfPermDescription)
				&& Objects.equals(wfPermDescriptionGuj, other.wfPermDescriptionGuj) && wfPermId == other.wfPermId
				&& Objects.equals(wfPermName, other.wfPermName) && Objects.equals(wfPermNameGuj, other.wfPermNameGuj);
	}

	@Override
	public String toString() {
		return "MsWorkflowPermissionsEntity [wfPermId=" + wfPermId + ", wfPermName=" + wfPermName + ", wfPermNameGuj="
				+ wfPermNameGuj + ", wfPermDescription=" + wfPermDescription + ", wfPermDescriptionGuj="
				+ wfPermDescriptionGuj + ", parentWfPermId=" + parentWfPermId + "]";
	}
}
