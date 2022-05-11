package gov.ifms.workflow.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

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
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "WF_ACTION_CONFIG", schema = Constant.WORKFLOW_SCHEMA)
public class WfActionConfigEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTIONCONFIG_ID")
	private long actionconfigId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID")
	private EDPMsMenuEntity edpMsMenuEntity;

	@Column(name = "FROM_ACTORNAME")
	private String fromActorname;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "FROM_WF_ROLE_ID", referencedColumnName = "WF_ROLE_ID")
	private MsWorkflowRoleEntity fromWorkFlowRoleEntity;

	@Column(name = "FROM_BRANCH_TYPE_ID")
	private Long fromBranchTypeId;

	@Column(name = "FROM_OFFICE_TYPE_ID")
	private Long fromOfficeTypeId;

	@Column(name = "FROM_STATUS")
	private String fromStatus;

	@Column(name = "FROM_WF_STATUS")
	private String fromWfStatus;

	@Column(name = "FROM_LEVEL")
	private int fromLevel;

	@Column(name = "CONDITION")
	private String condition;

	@Column(name = "TO_LEVEL")
	private int toLevel;

	@Column(name = "TO_WF_STATUS")
	private String toWfStatus;

	@Column(name = "TO_STATUS")
	private String toStatus;

	@Column(name = "TO_ACTORNAME")
	private String toActorname;

	@Column(name = "TO_WF_ROLE_ID")
	private Long toWorkFlowRoleId;

	@Column(name = "TO_BRANCH_TYPE_ID")
	private Long toBranchTypeId;

	@Column(name = "TO_OFFICE_TYPE_ID")
	private Long toOfficeTypeId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LOCATION_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity locationType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "WF_ACTION_ID", referencedColumnName = "WF_ACTION_ID")
	private MsWorkflowActionEntity msWorkflowActionEntity;

	@Column(name = "LOCATION_VALUE")
	private String locationValue;

	@Column(name = "FROM_IS_FD")
	private int  fromIsFD;

	@Column(name = "IS_TO_BRANCH_SEL_REQ")
	private int isToBranchSelReq;

	@Column(name = "IS_TO_OFFICE_SEL_REQ")
	private int isToOfficeSelReq;

	@Column(name = "IS_TO_USER_SEL_REQ")
	private int isToUserSelReq;

	@Column(name = "SEND_BACK_FLAG")
	private int sendBackFlag;

	@Column(name = "GROUP_VERSION_CODE")
	private int groupVersionCode;

	@Column(name = "ACTIVE_STATUS")
	private int activeStatus;

	@Column(name = "TYPE_ID")
	private int typeId;

	@Column(name = "TARGET_MENU_ID")
	private Long targetMenuId;

	@Column(name = "INIT_WF_ROLE_ID")
	private Long initWfRoleId;

	@Column(name = "IS_CO")
	private int isCo;

	@Column(name = "TO_IS_FD")
	private Integer toIsFd;

	@Column(name = "IS_DISPLAY_IN_POPUP")
	private Integer isDisplayInPopup;

	@Column(name = "INIT_WF_RL_PR")
	private int initWfRlPr;

	public Integer getToIsFd() {
		return toIsFd;
	}

	public void setToIsFd(Integer toIsFd) {
		this.toIsFd = toIsFd;
	}

	public long getActionconfigId() {
		return actionconfigId;
	}

	public void setActionconfigId(long actionconfigId) {
		this.actionconfigId = actionconfigId;
	}

	public EDPMsMenuEntity getEdpMsMenuEntity() {
		return edpMsMenuEntity;
	}

	public void setEdpMsMenuEntity(EDPMsMenuEntity edpMsMenuEntity) {
		this.edpMsMenuEntity = edpMsMenuEntity;
	}

	public String getFromActorname() {
		return fromActorname;
	}

	public void setFromActorname(String fromActorname) {
		this.fromActorname = fromActorname;
	}

	public MsWorkflowRoleEntity getFromWorkFlowRoleEntity() {
		return fromWorkFlowRoleEntity;
	}

	public void setFromWorkFlowRoleEntity(MsWorkflowRoleEntity fromWorkFlowRoleEntity) {
		this.fromWorkFlowRoleEntity = fromWorkFlowRoleEntity;
	}

	public Long getFromBranchTypeId() {
		return fromBranchTypeId;
	}

	public void setFromBranchTypeId(Long fromBranchTypeId) {
		this.fromBranchTypeId = fromBranchTypeId;
	}

	public Long getFromOfficeTypeId() {
		return fromOfficeTypeId;
	}

	public void setFromOfficeTypeId(Long fromOfficeTypeId) {
		this.fromOfficeTypeId = fromOfficeTypeId;
	}

	public String getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}

	public String getFromWfStatus() {
		return fromWfStatus;
	}

	public void setFromWfStatus(String fromWfStatus) {
		this.fromWfStatus = fromWfStatus;
	}

	public int getFromLevel() {
		return fromLevel;
	}

	public void setFromLevel(int fromLevel) {
		this.fromLevel = fromLevel;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getToLevel() {
		return toLevel;
	}

	public void setToLevel(int toLevel) {
		this.toLevel = toLevel;
	}

	public String getToWfStatus() {
		return toWfStatus;
	}

	public void setToWfStatus(String toWfStatus) {
		this.toWfStatus = toWfStatus;
	}

	public String getToStatus() {
		return toStatus;
	}

	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}

	public String getToActorname() {
		return toActorname;
	}

	public void setToActorname(String toActorname) {
		this.toActorname = toActorname;
	}

	public Long getToWorkFlowRoleId() {
		return toWorkFlowRoleId;
	}

	public void setToWorkFlowRoleId(Long toWorkFlowRoleId) {
		this.toWorkFlowRoleId = toWorkFlowRoleId;
	}

	public Long getToBranchTypeId() {
		return toBranchTypeId;
	}

	public void setToBranchTypeId(Long toBranchTypeId) {
		this.toBranchTypeId = toBranchTypeId;
	}

	public Long getToOfficeTypeId() {
		return toOfficeTypeId;
	}

	public void setToOfficeTypeId(Long toOfficeTypeId) {
		this.toOfficeTypeId = toOfficeTypeId;
	}

	public EDPLuLookUpInfoEntity getLocationType() {
		return locationType;
	}

	public void setLocationType(EDPLuLookUpInfoEntity locationType) {
		this.locationType = locationType;
	}

	public MsWorkflowActionEntity getMsWorkflowActionEntity() {
		return msWorkflowActionEntity;
	}

	public void setMsWorkflowActionEntity(MsWorkflowActionEntity msWorkflowActionEntity) {
		this.msWorkflowActionEntity = msWorkflowActionEntity;
	}

	public String getLocationValue() {
		return locationValue;
	}

	public void setLocationValue(String locationValue) {
		this.locationValue = locationValue;
	}

	public int getFromIsFD() {
		return fromIsFD;
	}

	public void setFromIsFD(int fromIsFD) {
		this.fromIsFD = fromIsFD;
	}

	public int getIsToBranchSelReq() {
		return isToBranchSelReq;
	}

	public void setIsToBranchSelReq(int isToBranchSelReq) {
		this.isToBranchSelReq = isToBranchSelReq;
	}

	public int getIsToOfficeSelReq() {
		return isToOfficeSelReq;
	}

	public void setIsToOfficeSelReq(int isToOfficeSelReq) {
		this.isToOfficeSelReq = isToOfficeSelReq;
	}

	public int getIsToUserSelReq() {
		return isToUserSelReq;
	}

	public void setIsToUserSelReq(int isToUserSelReq) {
		this.isToUserSelReq = isToUserSelReq;
	}

	public int getSendBackFlag() {
		return sendBackFlag;
	}

	public void setSendBackFlag(int sendBackFlag) {
		this.sendBackFlag = sendBackFlag;
	}

	public int getGroupVersionCode() {
		return groupVersionCode;
	}

	public void setGroupVersionCode(int groupVersionCode) {
		this.groupVersionCode = groupVersionCode;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Long getTargetMenuId() {
		return targetMenuId;
	}

	public void setTargetMenuId(Long targetMenuId) {
		this.targetMenuId = targetMenuId;
	}

	public Long getInitWfRoleId() {
		return initWfRoleId;
	}

	public void setInitWfRoleId(Long initWfRoleId) {
		this.initWfRoleId = initWfRoleId;
	}

	public int getIsCo() {
		return isCo;
	}

	public void setIsCo(int isCo) {
		this.isCo = isCo;
	}

	public Integer getIsDisplayInPopup() {
		return isDisplayInPopup;
	}

	public void setIsDisplayInPopup(Integer isDisplayInPopup) {
		this.isDisplayInPopup = isDisplayInPopup;
	}

	public int getInitWfRlPr() {
		return initWfRlPr;
	}

	public void setInitWfRlPr(int initWfRlPr) {
		this.initWfRlPr = initWfRlPr;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfActionConfigEntity that = (WfActionConfigEntity) o;
		return actionconfigId == that.actionconfigId &&
				fromLevel == that.fromLevel &&
				toLevel == that.toLevel &&
				fromIsFD == that.fromIsFD &&
				isToBranchSelReq == that.isToBranchSelReq &&
				isToOfficeSelReq == that.isToOfficeSelReq &&
				isToUserSelReq == that.isToUserSelReq &&
				sendBackFlag == that.sendBackFlag &&
				groupVersionCode == that.groupVersionCode &&
				activeStatus == that.activeStatus &&
				typeId == that.typeId &&
				isCo == that.isCo &&
				initWfRlPr == that.initWfRlPr &&
				Objects.equals(edpMsMenuEntity, that.edpMsMenuEntity) &&
				Objects.equals(fromActorname, that.fromActorname) &&
				Objects.equals(fromWorkFlowRoleEntity, that.fromWorkFlowRoleEntity) &&
				Objects.equals(fromBranchTypeId, that.fromBranchTypeId) &&
				Objects.equals(fromOfficeTypeId, that.fromOfficeTypeId) &&
				Objects.equals(fromStatus, that.fromStatus) &&
				Objects.equals(fromWfStatus, that.fromWfStatus) &&
				Objects.equals(condition, that.condition) &&
				Objects.equals(toWfStatus, that.toWfStatus) &&
				Objects.equals(toStatus, that.toStatus) &&
				Objects.equals(toActorname, that.toActorname) &&
				Objects.equals(toWorkFlowRoleId, that.toWorkFlowRoleId) &&
				Objects.equals(toBranchTypeId, that.toBranchTypeId) &&
				Objects.equals(toOfficeTypeId, that.toOfficeTypeId) &&
				Objects.equals(locationType, that.locationType) &&
				Objects.equals(msWorkflowActionEntity, that.msWorkflowActionEntity) &&
				Objects.equals(locationValue, that.locationValue) &&
				Objects.equals(targetMenuId, that.targetMenuId) &&
				Objects.equals(initWfRoleId, that.initWfRoleId) &&
				Objects.equals(toIsFd, that.toIsFd) &&
				Objects.equals(isDisplayInPopup, that.isDisplayInPopup);
	}

	@Override
	public int hashCode() {
		return Objects.hash(actionconfigId, edpMsMenuEntity, fromActorname, fromWorkFlowRoleEntity, fromBranchTypeId, fromOfficeTypeId, fromStatus, fromWfStatus, fromLevel, condition, toLevel, toWfStatus, toStatus, toActorname, toWorkFlowRoleId, toBranchTypeId, toOfficeTypeId, locationType, msWorkflowActionEntity, locationValue, fromIsFD, isToBranchSelReq, isToOfficeSelReq, isToUserSelReq, sendBackFlag, groupVersionCode, activeStatus, typeId, targetMenuId, initWfRoleId, isCo, toIsFd, isDisplayInPopup, initWfRlPr);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", WfActionConfigEntity.class.getSimpleName() + "[", "]")
				.add("actionconfigId=" + actionconfigId)
				.add("edpMsMenuEntity=" + edpMsMenuEntity)
				.add("fromActorname='" + fromActorname + "'")
				.add("fromWorkFlowRoleEntity=" + fromWorkFlowRoleEntity)
				.add("fromBranchTypeId=" + fromBranchTypeId)
				.add("fromOfficeTypeId=" + fromOfficeTypeId)
				.add("fromStatus='" + fromStatus + "'")
				.add("fromWfStatus='" + fromWfStatus + "'")
				.add("fromLevel=" + fromLevel)
				.add("condition='" + condition + "'")
				.add("toLevel=" + toLevel)
				.add("toWfStatus='" + toWfStatus + "'")
				.add("toStatus='" + toStatus + "'")
				.add("toActorname='" + toActorname + "'")
				.add("toWorkFlowRoleId=" + toWorkFlowRoleId)
				.add("toBranchTypeId=" + toBranchTypeId)
				.add("toOfficeTypeId=" + toOfficeTypeId)
				.add("locationType=" + locationType)
				.add("msWorkflowActionEntity=" + msWorkflowActionEntity)
				.add("locationValue='" + locationValue + "'")
				.add("fromIsFD=" + fromIsFD)
				.add("isToBranchSelReq=" + isToBranchSelReq)
				.add("isToOfficeSelReq=" + isToOfficeSelReq)
				.add("isToUserSelReq=" + isToUserSelReq)
				.add("sendBackFlag=" + sendBackFlag)
				.add("groupVersionCode=" + groupVersionCode)
				.add("activeStatus=" + activeStatus)
				.add("typeId=" + typeId)
				.add("targetMenuId=" + targetMenuId)
				.add("initWfRoleId=" + initWfRoleId)
				.add("isCo=" + isCo)
				.add("toIsFd=" + toIsFd)
				.add("isDisplayInPopup=" + isDisplayInPopup)
				.add("initWfRlPr=" + initWfRlPr)
				.toString();
	}
}
