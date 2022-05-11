package gov.ifms.workflow.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WfActionConfigDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

    private Long actionConfigId;

    private Long menuId;

    private String fromActorName;

    private Long fromWfRoleId;

    private Long fromBranchTypeId;

    private Long fromOfficeTypeId;

    private String fromStatus;

    private String fromWfStatus;

    private int fromLevel;

    private String condition;

    private int toLevel;

    private String toWfStatus;

    private String toStatus;

    private String toActorName;

    private Long toWfRoleId;

    private Long toBranchTypeId;

    private Long toOfficeTypeId;

    private Long locationType;

    private Long workflowActionId;

    private String locationValue;

    private int fromIsFD;

    private int isToBranchSelReq;

    private int isToOfficeSelReq;

    private int isToUserSelReq;

    private int sendBackFlag;

    private int groupVersionCode;

    private int activeStatus;

    private int typeId;

    private Long targetMenuId;

    private Long initWfRoleId;

    private String wfActionCode;

    private String wfActionName;

    private String locationTypeName;

    private Integer toIsFd;

    public Integer getToIsFd() {
        return toIsFd;
    }

    public void setToIsFd(Integer toIsFd) {
        this.toIsFd = toIsFd;
    }

    private List<WfActionConfigCondition> wfActionConfigDtoList = Collections.emptyList();

    public List<WfActionConfigCondition> getWfActionConfigDtoList() {
        return wfActionConfigDtoList;
    }

    public void setWfActionConfigDtoList(List<WfActionConfigCondition> wfActionConfigDtoList) {
        this.wfActionConfigDtoList = wfActionConfigDtoList;
    }

    public String getLocationTypeName() {
        return locationTypeName;
    }

    public void setLocationTypeName(String locationTypeName) {
        this.locationTypeName = locationTypeName;
    }

    public String getWfActionCode() {
        return wfActionCode;
    }

    public void setWfActionCode(String wfActionCode) {
        this.wfActionCode = wfActionCode;
    }

    public String getWfActionName() {
        return wfActionName;
    }

    public void setWfActionName(String wfActionName) {
        this.wfActionName = wfActionName;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getFromWfRoleId() {
        return fromWfRoleId;
    }

    public void setFromWfRoleId(Long fromWfRoleId) {
        this.fromWfRoleId = fromWfRoleId;
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

    public Long getToWfRoleId() {
        return toWfRoleId;
    }

    public void setToWfRoleId(Long toWfRoleId) {
        this.toWfRoleId = toWfRoleId;
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

    public Long getLocationType() {
        return locationType;
    }

    public void setLocationType(Long locationType) {
        this.locationType = locationType;
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

    public Long getInitWfRoleId() {
        return initWfRoleId;
    }

    public void setInitWfRoleId(Long initWfRoleId) {
        this.initWfRoleId = initWfRoleId;
    }

	/**
	 * @return the actionConfigId
	 */
	public Long getActionConfigId() {
		return actionConfigId;
	}

	/**
	 * @param actionConfigId the actionConfigId to set
	 */
	public void setActionConfigId(Long actionConfigId) {
		this.actionConfigId = actionConfigId;
	}

	/**
	 * @return the fromActorName
	 */
	public String getFromActorName() {
		return fromActorName;
	}

	/**
	 * @param fromActorName the fromActorName to set
	 */
	public void setFromActorName(String fromActorName) {
		this.fromActorName = fromActorName;
	}

	/**
	 * @return the toActorName
	 */
	public String getToActorName() {
		return toActorName;
	}

	/**
	 * @param toActorName the toActorName to set
	 */
	public void setToActorName(String toActorName) {
		this.toActorName = toActorName;
	}

	/**
	 * @return the workflowActionId
	 */
	public Long getWorkflowActionId() {
		return workflowActionId;
	}

	/**
	 * @param workflowActionId the workflowActionId to set
	 */
	public void setWorkflowActionId(Long workflowActionId) {
		this.workflowActionId = workflowActionId;
	}

	/**
	 * @return the targetMenuId
	 */
	public Long getTargetMenuId() {
		return targetMenuId;
	}

	/**
	 * @param targetMenuId the targetMenuId to set
	 */
	public void setTargetMenuId(Long targetMenuId) {
		this.targetMenuId = targetMenuId;
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WfActionConfigDto that = (WfActionConfigDto) o;
        return fromLevel == that.fromLevel &&
                toLevel == that.toLevel &&
                fromIsFD == that.fromIsFD &&
                isToBranchSelReq == that.isToBranchSelReq &&
                isToOfficeSelReq == that.isToOfficeSelReq &&
                isToUserSelReq == that.isToUserSelReq &&
                sendBackFlag == that.sendBackFlag &&
                groupVersionCode == that.groupVersionCode &&
                activeStatus == that.activeStatus &&
                typeId == that.typeId &&
                Objects.equals(actionConfigId, that.actionConfigId) &&
                Objects.equals(menuId, that.menuId) &&
                Objects.equals(fromActorName, that.fromActorName) &&
                Objects.equals(fromWfRoleId, that.fromWfRoleId) &&
                Objects.equals(fromBranchTypeId, that.fromBranchTypeId) &&
                Objects.equals(fromOfficeTypeId, that.fromOfficeTypeId) &&
                Objects.equals(fromStatus, that.fromStatus) &&
                Objects.equals(fromWfStatus, that.fromWfStatus) &&
                Objects.equals(condition, that.condition) &&
                Objects.equals(toWfStatus, that.toWfStatus) &&
                Objects.equals(toStatus, that.toStatus) &&
                Objects.equals(toActorName, that.toActorName) &&
                Objects.equals(toWfRoleId, that.toWfRoleId) &&
                Objects.equals(toBranchTypeId, that.toBranchTypeId) &&
                Objects.equals(toOfficeTypeId, that.toOfficeTypeId) &&
                Objects.equals(locationType, that.locationType) &&
                Objects.equals(workflowActionId, that.workflowActionId) &&
                Objects.equals(locationValue, that.locationValue) &&
                Objects.equals(targetMenuId, that.targetMenuId) &&
                Objects.equals(initWfRoleId, that.initWfRoleId) &&
                Objects.equals(wfActionCode, that.wfActionCode) &&
                Objects.equals(wfActionName, that.wfActionName) &&
                Objects.equals(locationTypeName, that.locationTypeName) &&
                Objects.equals(wfActionConfigDtoList, that.wfActionConfigDtoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionConfigId, menuId, fromActorName, fromWfRoleId, fromBranchTypeId, fromOfficeTypeId, fromStatus, fromWfStatus, fromLevel, condition, toLevel, toWfStatus, toStatus, toActorName, toWfRoleId, toBranchTypeId, toOfficeTypeId, locationType, workflowActionId, locationValue, fromIsFD, isToBranchSelReq, isToOfficeSelReq, isToUserSelReq, sendBackFlag, groupVersionCode, activeStatus, typeId, targetMenuId, initWfRoleId, wfActionCode, wfActionName, locationTypeName, wfActionConfigDtoList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WfActionConfigDto.class.getSimpleName() + "[", "]")
                .add("actionConfigId=" + actionConfigId)
                .add("menuId=" + menuId)
                .add("fromActorName='" + fromActorName + "'")
                .add("fromWfRoleId=" + fromWfRoleId)
                .add("fromBranchTypeId=" + fromBranchTypeId)
                .add("fromOfficeTypeId=" + fromOfficeTypeId)
                .add("fromStatus='" + fromStatus + "'")
                .add("fromWfStatus='" + fromWfStatus + "'")
                .add("fromLevel=" + fromLevel)
                .add("condition='" + condition + "'")
                .add("toLevel=" + toLevel)
                .add("toWfStatus='" + toWfStatus + "'")
                .add("toStatus='" + toStatus + "'")
                .add("toActorName='" + toActorName + "'")
                .add("toWfRoleId=" + toWfRoleId)
                .add("toBranchTypeId=" + toBranchTypeId)
                .add("toOfficeTypeId=" + toOfficeTypeId)
                .add("locationType=" + locationType)
                .add("workflowActionId=" + workflowActionId)
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
                .add("wfActionCode='" + wfActionCode + "'")
                .add("wfActionName='" + wfActionName + "'")
                .add("locationTypeName='" + locationTypeName + "'")
                .add("toIsFd=" + toIsFd)
                .add("wfActionConfigDtoList=" + wfActionConfigDtoList)
                .toString();
    }
}
