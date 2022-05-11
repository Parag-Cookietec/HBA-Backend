package gov.ifms.loc.workflow.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The Class LocWfActionConfigDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocWfActionConfigDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /** The action config id. */
    private Long actionConfigId;

    /** The menu id. */
    private Long menuId;

    /** The from actor name. */
    private String fromActorName;

    /** The from wf role id. */
    private Long fromWfRoleId;

    /** The from branch type id. */
    private Long fromBranchTypeId;

    /** The from office type id. */
    private Long fromOfficeTypeId;

    /** The from status. */
    private String fromStatus;

    /** The from wf status. */
    private String fromWfStatus;

    /** The from level. */
    private int fromLevel;

    /** The condition. */
    private String condition;

    /** The to level. */
    private int toLevel;

    /** The to wf status. */
    private String toWfStatus;

    /** The to status. */
    private String toStatus;

    /** The to actor name. */
    private String toActorName;

    /** The to wf role id. */
    private Long toWfRoleId;

    /** The to branch type id. */
    private Long toBranchTypeId;

    /** The to office type id. */
    private Long toOfficeTypeId;

    /** The location type. */
    private Long locationType;

    /** The workflow action id. */
    private Long workflowActionId;

    /** The location value. */
    private String locationValue;

    /** The from is FD. */
    private int fromIsFD;

    /** The is to branch sel req. */
    private int isToBranchSelReq;

    /** The is to office sel req. */
    private int isToOfficeSelReq;

    /** The is to user sel req. */
    private int isToUserSelReq;

    /** The send back flag. */
    private int sendBackFlag;

    /** The group version code. */
    private int groupVersionCode;

    /** The active status. */
    private int activeStatus;

    /** The type id. */
    private int typeId;

    /** The target menu id. */
    private Long targetMenuId;

    /** The init wf role id. */
    private Long initWfRoleId;

    /** The wf action code. */
    private String wfActionCode;

    /** The wf action name. */
    private String wfActionName;

    /** The location type name. */
    private String locationTypeName;

    /** The to is fd. */
    private Integer toIsFd;

    /** The to office sub type id. */
    private Long toOfficeSubTypeId;

    /**
     * Gets the to is fd.
     *
     * @return the to is fd
     */
    public Integer getToIsFd() {
        return toIsFd;
    }

    /**
     * Sets the to is fd.
     *
     * @param toIsFd the new to is fd
     */
    public void setToIsFd(Integer toIsFd) {
        this.toIsFd = toIsFd;
    }

    /** The wf action config dto list. */
    private List<LocWfActionConfigCondition> wfActionConfigDtoList = Collections.emptyList();

    /**
     * Gets the wf action config dto list.
     *
     * @return the wf action config dto list
     */
    public List<LocWfActionConfigCondition> getWfActionConfigDtoList() {
        return wfActionConfigDtoList;
    }

    /**
     * Sets the wf action config dto list.
     *
     * @param wfActionConfigDtoList the new wf action config dto list
     */
    public void setWfActionConfigDtoList(List<LocWfActionConfigCondition> wfActionConfigDtoList) {
        this.wfActionConfigDtoList = wfActionConfigDtoList;
    }

    /**
     * Gets the location type name.
     *
     * @return the location type name
     */
    public String getLocationTypeName() {
        return locationTypeName;
    }

    /**
     * Sets the location type name.
     *
     * @param locationTypeName the new location type name
     */
    public void setLocationTypeName(String locationTypeName) {
        this.locationTypeName = locationTypeName;
    }

    /**
     * Gets the wf action code.
     *
     * @return the wf action code
     */
    public String getWfActionCode() {
        return wfActionCode;
    }

    /**
     * Sets the wf action code.
     *
     * @param wfActionCode the new wf action code
     */
    public void setWfActionCode(String wfActionCode) {
        this.wfActionCode = wfActionCode;
    }

    /**
     * Gets the wf action name.
     *
     * @return the wf action name
     */
    public String getWfActionName() {
        return wfActionName;
    }

    /**
     * Sets the wf action name.
     *
     * @param wfActionName the new wf action name
     */
    public void setWfActionName(String wfActionName) {
        this.wfActionName = wfActionName;
    }

    /**
     * Gets the menu id.
     *
     * @return the menu id
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * Sets the menu id.
     *
     * @param menuId the new menu id
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * Gets the from wf role id.
     *
     * @return the from wf role id
     */
    public Long getFromWfRoleId() {
        return fromWfRoleId;
    }

    /**
     * Sets the from wf role id.
     *
     * @param fromWfRoleId the new from wf role id
     */
    public void setFromWfRoleId(Long fromWfRoleId) {
        this.fromWfRoleId = fromWfRoleId;
    }

    /**
     * Gets the from branch type id.
     *
     * @return the from branch type id
     */
    public Long getFromBranchTypeId() {
        return fromBranchTypeId;
    }

    /**
     * Sets the from branch type id.
     *
     * @param fromBranchTypeId the new from branch type id
     */
    public void setFromBranchTypeId(Long fromBranchTypeId) {
        this.fromBranchTypeId = fromBranchTypeId;
    }

    /**
     * Gets the from office type id.
     *
     * @return the from office type id
     */
    public Long getFromOfficeTypeId() {
        return fromOfficeTypeId;
    }

    /**
     * Sets the from office type id.
     *
     * @param fromOfficeTypeId the new from office type id
     */
    public void setFromOfficeTypeId(Long fromOfficeTypeId) {
        this.fromOfficeTypeId = fromOfficeTypeId;
    }

    /**
     * Gets the from status.
     *
     * @return the from status
     */
    public String getFromStatus() {
        return fromStatus;
    }

    /**
     * Sets the from status.
     *
     * @param fromStatus the new from status
     */
    public void setFromStatus(String fromStatus) {
        this.fromStatus = fromStatus;
    }

    /**
     * Gets the from wf status.
     *
     * @return the from wf status
     */
    public String getFromWfStatus() {
        return fromWfStatus;
    }

    /**
     * Sets the from wf status.
     *
     * @param fromWfStatus the new from wf status
     */
    public void setFromWfStatus(String fromWfStatus) {
        this.fromWfStatus = fromWfStatus;
    }

    /**
     * Gets the from level.
     *
     * @return the from level
     */
    public int getFromLevel() {
        return fromLevel;
    }

    /**
     * Sets the from level.
     *
     * @param fromLevel the new from level
     */
    public void setFromLevel(int fromLevel) {
        this.fromLevel = fromLevel;
    }

    /**
     * Gets the condition.
     *
     * @return the condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Sets the condition.
     *
     * @param condition the new condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Gets the to level.
     *
     * @return the to level
     */
    public int getToLevel() {
        return toLevel;
    }

    /**
     * Sets the to level.
     *
     * @param toLevel the new to level
     */
    public void setToLevel(int toLevel) {
        this.toLevel = toLevel;
    }

    /**
     * Gets the to wf status.
     *
     * @return the to wf status
     */
    public String getToWfStatus() {
        return toWfStatus;
    }

    /**
     * Sets the to wf status.
     *
     * @param toWfStatus the new to wf status
     */
    public void setToWfStatus(String toWfStatus) {
        this.toWfStatus = toWfStatus;
    }

    /**
     * Gets the to status.
     *
     * @return the to status
     */
    public String getToStatus() {
        return toStatus;
    }

    /**
     * Sets the to status.
     *
     * @param toStatus the new to status
     */
    public void setToStatus(String toStatus) {
        this.toStatus = toStatus;
    }

    /**
     * Gets the to wf role id.
     *
     * @return the to wf role id
     */
    public Long getToWfRoleId() {
        return toWfRoleId;
    }

    /**
     * Sets the to wf role id.
     *
     * @param toWfRoleId the new to wf role id
     */
    public void setToWfRoleId(Long toWfRoleId) {
        this.toWfRoleId = toWfRoleId;
    }

    /**
     * Gets the to branch type id.
     *
     * @return the to branch type id
     */
    public Long getToBranchTypeId() {
        return toBranchTypeId;
    }

    /**
     * Sets the to branch type id.
     *
     * @param toBranchTypeId the new to branch type id
     */
    public void setToBranchTypeId(Long toBranchTypeId) {
        this.toBranchTypeId = toBranchTypeId;
    }

    /**
     * Gets the to office type id.
     *
     * @return the to office type id
     */
    public Long getToOfficeTypeId() {
        return toOfficeTypeId;
    }

    /**
     * Sets the to office type id.
     *
     * @param toOfficeTypeId the new to office type id
     */
    public void setToOfficeTypeId(Long toOfficeTypeId) {
        this.toOfficeTypeId = toOfficeTypeId;
    }

    /**
     * Gets the location type.
     *
     * @return the location type
     */
    public Long getLocationType() {
        return locationType;
    }

    /**
     * Sets the location type.
     *
     * @param locationType the new location type
     */
    public void setLocationType(Long locationType) {
        this.locationType = locationType;
    }

    /**
     * Gets the location value.
     *
     * @return the location value
     */
    public String getLocationValue() {
        return locationValue;
    }

    /**
     * Sets the location value.
     *
     * @param locationValue the new location value
     */
    public void setLocationValue(String locationValue) {
        this.locationValue = locationValue;
    }

    /**
     * Gets the from is FD.
     *
     * @return the from is FD
     */
    public int getFromIsFD() {
        return fromIsFD;
    }

    /**
     * Sets the from is FD.
     *
     * @param fromIsFD the new from is FD
     */
    public void setFromIsFD(int fromIsFD) {
        this.fromIsFD = fromIsFD;
    }

    /**
     * Gets the checks if is to branch sel req.
     *
     * @return the checks if is to branch sel req
     */
    public int getIsToBranchSelReq() {
        return isToBranchSelReq;
    }

    /**
     * Sets the checks if is to branch sel req.
     *
     * @param isToBranchSelReq the new checks if is to branch sel req
     */
    public void setIsToBranchSelReq(int isToBranchSelReq) {
        this.isToBranchSelReq = isToBranchSelReq;
    }

    /**
     * Gets the checks if is to office sel req.
     *
     * @return the checks if is to office sel req
     */
    public int getIsToOfficeSelReq() {
        return isToOfficeSelReq;
    }

    /**
     * Sets the checks if is to office sel req.
     *
     * @param isToOfficeSelReq the new checks if is to office sel req
     */
    public void setIsToOfficeSelReq(int isToOfficeSelReq) {
        this.isToOfficeSelReq = isToOfficeSelReq;
    }

    /**
     * Gets the checks if is to user sel req.
     *
     * @return the checks if is to user sel req
     */
    public int getIsToUserSelReq() {
        return isToUserSelReq;
    }

    /**
     * Sets the checks if is to user sel req.
     *
     * @param isToUserSelReq the new checks if is to user sel req
     */
    public void setIsToUserSelReq(int isToUserSelReq) {
        this.isToUserSelReq = isToUserSelReq;
    }

    /**
     * Gets the send back flag.
     *
     * @return the send back flag
     */
    public int getSendBackFlag() {
        return sendBackFlag;
    }

    /**
     * Sets the send back flag.
     *
     * @param sendBackFlag the new send back flag
     */
    public void setSendBackFlag(int sendBackFlag) {
        this.sendBackFlag = sendBackFlag;
    }

    /**
     * Gets the group version code.
     *
     * @return the group version code
     */
    public int getGroupVersionCode() {
        return groupVersionCode;
    }

    /**
     * Sets the group version code.
     *
     * @param groupVersionCode the new group version code
     */
    public void setGroupVersionCode(int groupVersionCode) {
        this.groupVersionCode = groupVersionCode;
    }

    /**
     * Gets the active status.
     *
     * @return the active status
     */
    public int getActiveStatus() {
        return activeStatus;
    }

    /**
     * Sets the active status.
     *
     * @param activeStatus the new active status
     */
    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    /**
     * Gets the type id.
     *
     * @return the type id
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Sets the type id.
     *
     * @param typeId the new type id
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * Gets the inits the wf role id.
     *
     * @return the inits the wf role id
     */
    public Long getInitWfRoleId() {
        return initWfRoleId;
    }

    /**
     * Sets the inits the wf role id.
     *
     * @param initWfRoleId the new inits the wf role id
     */
    public void setInitWfRoleId(Long initWfRoleId) {
        this.initWfRoleId = initWfRoleId;
    }

    /**
     * Gets the action config id.
     *
     * @return the actionConfigId
     */
    public Long getActionConfigId() {
        return actionConfigId;
    }

    /**
     * Sets the action config id.
     *
     * @param actionConfigId the actionConfigId to set
     */
    public void setActionConfigId(Long actionConfigId) {
        this.actionConfigId = actionConfigId;
    }

    /**
     * Gets the from actor name.
     *
     * @return the fromActorName
     */
    public String getFromActorName() {
        return fromActorName;
    }

    /**
     * Sets the from actor name.
     *
     * @param fromActorName the fromActorName to set
     */
    public void setFromActorName(String fromActorName) {
        this.fromActorName = fromActorName;
    }

    /**
     * Gets the to actor name.
     *
     * @return the toActorName
     */
    public String getToActorName() {
        return toActorName;
    }

    /**
     * Sets the to actor name.
     *
     * @param toActorName the toActorName to set
     */
    public void setToActorName(String toActorName) {
        this.toActorName = toActorName;
    }

    /**
     * Gets the workflow action id.
     *
     * @return the workflowActionId
     */
    public Long getWorkflowActionId() {
        return workflowActionId;
    }

    /**
     * Sets the workflow action id.
     *
     * @param workflowActionId the workflowActionId to set
     */
    public void setWorkflowActionId(Long workflowActionId) {
        this.workflowActionId = workflowActionId;
    }

    /**
     * Gets the target menu id.
     *
     * @return the targetMenuId
     */
    public Long getTargetMenuId() {
        return targetMenuId;
    }

    /**
     * Sets the target menu id.
     *
     * @param targetMenuId the targetMenuId to set
     */
    public void setTargetMenuId(Long targetMenuId) {
        this.targetMenuId = targetMenuId;
    }

    /**
     * Gets the to office sub type id.
     *
     * @return the to office sub type id
     */
    public Long getToOfficeSubTypeId() {
        return toOfficeSubTypeId;
    }

    /**
     * Sets the to office sub type id.
     *
     * @param toOfficeSubTypeId the new to office sub type id
     */
    public void setToOfficeSubTypeId(Long toOfficeSubTypeId) {
        this.toOfficeSubTypeId = toOfficeSubTypeId;
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocWfActionConfigDto)) return false;
        LocWfActionConfigDto that = (LocWfActionConfigDto) o;
        return getFromLevel() == that.getFromLevel() && getToLevel() == that.getToLevel() && getFromIsFD() == that.getFromIsFD() && getIsToBranchSelReq() == that.getIsToBranchSelReq() && getIsToOfficeSelReq() == that.getIsToOfficeSelReq() && getIsToUserSelReq() == that.getIsToUserSelReq() && getSendBackFlag() == that.getSendBackFlag() && getGroupVersionCode() == that.getGroupVersionCode() && getActiveStatus() == that.getActiveStatus() && getTypeId() == that.getTypeId() && Objects.equals(getActionConfigId(), that.getActionConfigId()) && Objects.equals(getMenuId(), that.getMenuId()) && Objects.equals(getFromActorName(), that.getFromActorName()) && Objects.equals(getFromWfRoleId(), that.getFromWfRoleId()) && Objects.equals(getFromBranchTypeId(), that.getFromBranchTypeId()) && Objects.equals(getFromOfficeTypeId(), that.getFromOfficeTypeId()) && Objects.equals(getFromStatus(), that.getFromStatus()) && Objects.equals(getFromWfStatus(), that.getFromWfStatus()) && Objects.equals(getCondition(), that.getCondition()) && Objects.equals(getToWfStatus(), that.getToWfStatus()) && Objects.equals(getToStatus(), that.getToStatus()) && Objects.equals(getToActorName(), that.getToActorName()) && Objects.equals(getToWfRoleId(), that.getToWfRoleId()) && Objects.equals(getToBranchTypeId(), that.getToBranchTypeId()) && Objects.equals(getToOfficeTypeId(), that.getToOfficeTypeId()) && Objects.equals(getLocationType(), that.getLocationType()) && Objects.equals(getWorkflowActionId(), that.getWorkflowActionId()) && Objects.equals(getLocationValue(), that.getLocationValue()) && Objects.equals(getTargetMenuId(), that.getTargetMenuId()) && Objects.equals(getInitWfRoleId(), that.getInitWfRoleId()) && Objects.equals(getWfActionCode(), that.getWfActionCode()) && Objects.equals(getWfActionName(), that.getWfActionName()) && Objects.equals(getLocationTypeName(), that.getLocationTypeName()) && Objects.equals(getToIsFd(), that.getToIsFd()) && Objects.equals(getToOfficeSubTypeId(), that.getToOfficeSubTypeId()) && Objects.equals(getWfActionConfigDtoList(), that.getWfActionConfigDtoList());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getActionConfigId(), getMenuId(), getFromActorName(), getFromWfRoleId(), getFromBranchTypeId(), getFromOfficeTypeId(), getFromStatus(), getFromWfStatus(), getFromLevel(), getCondition(), getToLevel(), getToWfStatus(), getToStatus(), getToActorName(), getToWfRoleId(), getToBranchTypeId(), getToOfficeTypeId(), getLocationType(), getWorkflowActionId(), getLocationValue(), getFromIsFD(), getIsToBranchSelReq(), getIsToOfficeSelReq(), getIsToUserSelReq(), getSendBackFlag(), getGroupVersionCode(), getActiveStatus(), getTypeId(), getTargetMenuId(), getInitWfRoleId(), getWfActionCode(), getWfActionName(), getLocationTypeName(), getToIsFd(), getToOfficeSubTypeId(), getWfActionConfigDtoList());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocWfActionConfigDto{");
        sb.append("actionConfigId=").append(actionConfigId);
        sb.append(", menuId=").append(menuId);
        sb.append(", fromActorName='").append(fromActorName).append('\'');
        sb.append(", fromWfRoleId=").append(fromWfRoleId);
        sb.append(", fromBranchTypeId=").append(fromBranchTypeId);
        sb.append(", fromOfficeTypeId=").append(fromOfficeTypeId);
        sb.append(", fromStatus='").append(fromStatus).append('\'');
        sb.append(", fromWfStatus='").append(fromWfStatus).append('\'');
        sb.append(", fromLevel=").append(fromLevel);
        sb.append(", condition='").append(condition).append('\'');
        sb.append(", toLevel=").append(toLevel);
        sb.append(", toWfStatus='").append(toWfStatus).append('\'');
        sb.append(", toStatus='").append(toStatus).append('\'');
        sb.append(", toActorName='").append(toActorName).append('\'');
        sb.append(", toWfRoleId=").append(toWfRoleId);
        sb.append(", toBranchTypeId=").append(toBranchTypeId);
        sb.append(", toOfficeTypeId=").append(toOfficeTypeId);
        sb.append(", locationType=").append(locationType);
        sb.append(", workflowActionId=").append(workflowActionId);
        sb.append(", locationValue='").append(locationValue).append('\'');
        sb.append(", fromIsFD=").append(fromIsFD);
        sb.append(", isToBranchSelReq=").append(isToBranchSelReq);
        sb.append(", isToOfficeSelReq=").append(isToOfficeSelReq);
        sb.append(", isToUserSelReq=").append(isToUserSelReq);
        sb.append(", sendBackFlag=").append(sendBackFlag);
        sb.append(", groupVersionCode=").append(groupVersionCode);
        sb.append(", activeStatus=").append(activeStatus);
        sb.append(", typeId=").append(typeId);
        sb.append(", targetMenuId=").append(targetMenuId);
        sb.append(", initWfRoleId=").append(initWfRoleId);
        sb.append(", wfActionCode='").append(wfActionCode).append('\'');
        sb.append(", wfActionName='").append(wfActionName).append('\'');
        sb.append(", locationTypeName='").append(locationTypeName).append('\'');
        sb.append(", toIsFd=").append(toIsFd);
        sb.append(", toOfficeSubTypeId=").append(toOfficeSubTypeId);
        sb.append(", wfActionConfigDtoList=").append(wfActionConfigDtoList);
        sb.append('}');
        return sb.toString();
    }
}
