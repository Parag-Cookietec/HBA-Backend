package gov.ifms.workflow.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

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
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class MsWorkflowEntity.
 * 
 * @version 1.0
 * @created 2019/08/21 12:53:11
 *
 */
@Entity
@Table(name = "WF_CONFIG", schema = Constant.WORKFLOW_SCHEMA)
public class WfConfigEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WORKFLOW_ID")
	private long workflowId;

	@Column(name = "WORKFLOW_NAME")
	private String workflowName;

	@ManyToOne(fetch = FetchType.LAZY ,optional = false)
	@JoinColumn(name = "OFFICE_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity officeTypeId;

	@ManyToOne(fetch = FetchType.LAZY ,optional = false)
	@JoinColumn(name = "WF_ROLE_ID", referencedColumnName = "WF_ROLE_ID")
	private MsWorkflowRoleEntity msWorkflowRoleEntity;

	@ManyToOne(fetch = FetchType.LAZY ,optional = false)
	@JoinColumn(name = "WF_ACTION_ID", referencedColumnName = "WF_ACTION_ID")
	private MsWorkflowActionEntity msWorkflowActionEntity;

	@Column(name = "TRN_STATUS")
	private String trnStatus;

	@Column(name = "NEXT_WF_ROLE_ID")
	private Long nextWfRoleId;
	
	@Column(name = "MENU_ID")
	private long menuId;

	@Column(name = "WF_LEVEL_ID")
	private long wfLevelId;
	
	@Column(name = "WF_ENDPOINT_ID")
	private long wfEndpointId;
	
	@Column(name = "IS_EXCP_REQ")
	private long isExcpReq;
	
	@Column(name = "WF_INIT_WF_ROLE_ID")
	private Long wfInitWfRoleId;
	
	@Column(name = "WF_STATUS")
	private String wfStatus;
	
	@Column(name = "ACTION_LEVEL")
	private int actionLevel;
	
	@Column(name = "NEXT_ACTION_LEVEL")
	private int nextActionLevel;
	
	public WfConfigEntity() {
		super();
	}

	/**
	 * @return the workflowId
	 */
	public long getWorkflowId() {
		return workflowId;
	}

	/**
	 * @param workflowId the workflowId to set
	 */
	public void setWorkflowId(long workflowId) {
		this.workflowId = workflowId;
	}

	/**
	 * @return the workflowName
	 */
	public String getWorkflowName() {
		return workflowName;
	}

	/**
	 * @param workflowName the workflowName to set
	 */
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	/**
	 * @return the officeTypeId
	 */
	public EDPLuLookUpInfoEntity getOfficeTypeId() {
		return officeTypeId;
	}

	/**
	 * @param officeTypeId the officeTypeId to set
	 */
	public void setOfficeTypeId(EDPLuLookUpInfoEntity officeTypeId) {
		this.officeTypeId = officeTypeId;
	}

	/**
	 * @return the msWorkflowRoleEntity
	 */
	public MsWorkflowRoleEntity getMsWorkflowRoleEntity() {
		return msWorkflowRoleEntity;
	}

	/**
	 * @param msWorkflowRoleEntity the msWorkflowRoleEntity to set
	 */
	public void setMsWorkflowRoleEntity(MsWorkflowRoleEntity msWorkflowRoleEntity) {
		this.msWorkflowRoleEntity = msWorkflowRoleEntity;
	}

	/**
	 * @return the msWorkflowActionEntity
	 */
	public MsWorkflowActionEntity getMsWorkflowActionEntity() {
		return msWorkflowActionEntity;
	}

	/**
	 * @param msWorkflowActionEntity the msWorkflowActionEntity to set
	 */
	public void setMsWorkflowActionEntity(MsWorkflowActionEntity msWorkflowActionEntity) {
		this.msWorkflowActionEntity = msWorkflowActionEntity;
	}

	/**
	 * @return the trnStatus
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * @param trnStatus the trnStatus to set
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * @return the nextWfRoleId
	 */
	public Long getNextWfRoleId() {
		return nextWfRoleId;
	}

	/**
	 * @param nextWfRoleId the nextWfRoleId to set
	 */
	public void setNextWfRoleId(Long nextWfRoleId) {
		this.nextWfRoleId = nextWfRoleId;
	}

	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the wfLevelId
	 */
	public long getWfLevelId() {
		return wfLevelId;
	}

	/**
	 * @param wfLevelId the wfLevelId to set
	 */
	public void setWfLevelId(long wfLevelId) {
		this.wfLevelId = wfLevelId;
	}

	/**
	 * @return the wfEndpointId
	 */
	public long getWfEndpointId() {
		return wfEndpointId;
	}

	/**
	 * @param wfEndpointId the wfEndpointId to set
	 */
	public void setWfEndpointId(long wfEndpointId) {
		this.wfEndpointId = wfEndpointId;
	}

	/**
	 * @return the isExcpReq
	 */
	public long getIsExcpReq() {
		return isExcpReq;
	}

	/**
	 * @param isExcpReq the isExcpReq to set
	 */
	public void setIsExcpReq(long isExcpReq) {
		this.isExcpReq = isExcpReq;
	}
	
	/**
	 * @return the wfInitWfRoleId
	 */
	public Long getWfInitWfRoleId() {
		return wfInitWfRoleId;
	}

	/**
	 * @param wfInitWfRoleId the wfInitWfRoleId to set
	 */
	public void setWfInitWfRoleId(Long wfInitWfRoleId) {
		this.wfInitWfRoleId = wfInitWfRoleId;
	}

	/**
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}
	
	/**
	 * @return the actionLevel
	 */
	public int getActionLevel() {
		return actionLevel;
	}

	/**
	 * @param actionLevel the actionLevel to set
	 */
	public void setActionLevel(int actionLevel) {
		this.actionLevel = actionLevel;
	}

	/**
	 * @return the nextActionLevel
	 */
	public int getNextActionLevel() {
		return nextActionLevel;
	}

	/**
	 * @param nextActionLevel the nextActionLevel to set
	 */
	public void setNextActionLevel(int nextActionLevel) {
		this.nextActionLevel = nextActionLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actionLevel, isExcpReq, menuId, msWorkflowActionEntity, msWorkflowRoleEntity,
				nextActionLevel, nextWfRoleId, officeTypeId, trnStatus, wfEndpointId, wfInitWfRoleId, wfLevelId,
				wfStatus, workflowId, workflowName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WfConfigEntity)) {
			return false;
		}
		WfConfigEntity other = (WfConfigEntity) obj;
		return actionLevel == other.actionLevel && isExcpReq == other.isExcpReq && menuId == other.menuId
				&& Objects.equals(msWorkflowActionEntity, other.msWorkflowActionEntity)
				&& Objects.equals(msWorkflowRoleEntity, other.msWorkflowRoleEntity)
				&& nextActionLevel == other.nextActionLevel && nextWfRoleId == other.nextWfRoleId
				&& Objects.equals(officeTypeId, other.officeTypeId) && Objects.equals(trnStatus, other.trnStatus)
				&& wfEndpointId == other.wfEndpointId && Objects.equals(wfInitWfRoleId, other.wfInitWfRoleId)
				&& wfLevelId == other.wfLevelId && Objects.equals(wfStatus, other.wfStatus)
				&& workflowId == other.workflowId && Objects.equals(workflowName, other.workflowName);
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
}
