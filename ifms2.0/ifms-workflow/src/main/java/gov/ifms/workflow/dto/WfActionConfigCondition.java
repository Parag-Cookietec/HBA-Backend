package gov.ifms.workflow.dto;

import java.io.Serializable;

public class WfActionConfigCondition implements Serializable {

    private String condition;

    private Long actionConfigId;

    private int fromIsFD;

    private int isToBranchSelReq;

    private int isToOfficeSelReq;

    private int isToUserSelReq;

    private int sendBackFlag;

    private int groupVersionCode;

    private int activeStatus;

    private int typeId;

    private Long targetMenuId;

    private Long toBranchTypeId;

    private String wfActionCode;

    private String wfActionName;

    private String locationTypeName;

    private Long locationType;

    private Long workflowActionId;

    private Long fromWfRoleId;

    private String locationValue;

    private Long toWfRoleId;

    private Integer toIsFd;

    private Long toOfficeTypeId;

    public Long getToOfficeTypeId() {
        return toOfficeTypeId;
    }

    public void setToOfficeTypeId(Long toOfficeTypeId) {
        this.toOfficeTypeId = toOfficeTypeId;
    }

    public Integer getToIsFd() {
        return toIsFd;
    }

    public void setToIsFd(Integer toIsFd) {
        this.toIsFd = toIsFd;
    }

    public Long getToBranchTypeId() {
        return toBranchTypeId;
    }

    public void setToBranchTypeId(Long toBranchTypeId) {
        this.toBranchTypeId = toBranchTypeId;
    }

    public Long getToWfRoleId() {
        return toWfRoleId;
    }

    public void setToWfRoleId(Long toWfRoleId) {
        this.toWfRoleId = toWfRoleId;
    }

    public String getLocationValue() {
        return locationValue;
    }

    public void setLocationValue(String locationValue) {
        this.locationValue = locationValue;
    }

    public Long getFromWfRoleId() {
        return fromWfRoleId;
    }

    public void setFromWfRoleId(Long fromWfRoleId) {
        this.fromWfRoleId = fromWfRoleId;
    }

    public Long getWorkflowActionId() {
        return workflowActionId;
    }

    public void setWorkflowActionId(Long workflowActionId) {
        this.workflowActionId = workflowActionId;
    }

    public Long getLocationType() {
        return locationType;
    }

    public void setLocationType(Long locationType) {
        this.locationType = locationType;
    }

    public Long getActionConfigId() {
        return actionConfigId;
    }

    public void setActionConfigId(Long actionConfigId) {
        this.actionConfigId = actionConfigId;
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

    public String getLocationTypeName() {
        return locationTypeName;
    }

    public void setLocationTypeName(String locationTypeName) {
        this.locationTypeName = locationTypeName;
    }

    public WfActionConfigCondition() {
    }

    public WfActionConfigCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
