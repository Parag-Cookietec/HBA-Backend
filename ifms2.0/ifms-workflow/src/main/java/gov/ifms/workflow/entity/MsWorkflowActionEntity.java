package gov.ifms.workflow.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class MsWorkflowActionEntity.
 * 
 * @version 1.0
 * @created 2019/08/21 12:53:11
 *
 */
@Entity
@Table(name = "WF_MS_WORKFLOW_ACTIONS", schema = Constant.WORKFLOW_SCHEMA)
public class MsWorkflowActionEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WF_ACTION_ID")
	private long wfActionId;

	@Column(name = "WF_ACTION_NAME")
	private String wfActionName;

	@Column(name = "WF_ACTION_DESCRIPTION")
	private String wfActionDescription;

	@Column(name = "VALID_WF_ACTIONS_ID")
	private int validWfActionId;

	@Column(name="WF_ACTION_CODE")
	private String wfActionCode;

	public MsWorkflowActionEntity() {
		super();
	}
	
	public MsWorkflowActionEntity(long wfActionId) {
		super();
		this.wfActionId = wfActionId;
	}
	
	/**
	 * @return the wfActionId
	 */
	public long getWfActionId() {
		return wfActionId;
	}

	/**
	 * @param wfActionId the wfActionId to set
	 */
	public void setWfActionId(long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * @return the wfActionName
	 */
	public String getWfActionName() {
		return wfActionName;
	}

	/**
	 * @param wfActionName the wfActionName to set
	 */
	public void setWfActionName(String wfActionName) {
		this.wfActionName = wfActionName;
	}

	/**
	 * @return the wfActionDescription
	 */
	public String getWfActionDescription() {
		return wfActionDescription;
	}

	/**
	 * @param wfActionDescription the wfActionDescription to set
	 */
	public void setWfActionDescription(String wfActionDescription) {
		this.wfActionDescription = wfActionDescription;
	}

	/**
	 * @return the validWfActionId
	 */
	public int getValidWfActionId() {
		return validWfActionId;
	}

	/**
	 * @param validWfActionId the validWfActionId to set
	 */
	public void setValidWfActionId(int validWfActionId) {
		this.validWfActionId = validWfActionId;
	}

	public String getWfActionCode() {
		return wfActionCode;
	}

	public void setWfActionCode(String wfActionCode) {
		this.wfActionCode = wfActionCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MsWorkflowActionEntity that = (MsWorkflowActionEntity) o;
		return wfActionId == that.wfActionId &&
				validWfActionId == that.validWfActionId &&
				Objects.equals(wfActionName, that.wfActionName) &&
				Objects.equals(wfActionDescription, that.wfActionDescription) &&
				Objects.equals(wfActionCode, that.wfActionCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(wfActionId, wfActionName, wfActionDescription, validWfActionId, wfActionCode);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", MsWorkflowActionEntity.class.getSimpleName() + "[", "]")
				.add("wfActionId=" + wfActionId)
				.add("wfActionName='" + wfActionName + "'")
				.add("wfActionDescription='" + wfActionDescription + "'")
				.add("validWfActionId=" + validWfActionId)
				.add("wfActionCode='" + wfActionCode + "'")
				.toString();
	}
}
