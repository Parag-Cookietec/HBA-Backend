package gov.ifms.loc.workflow.dto;

import java.io.Serializable;

/**
 * The Class LocWfActionConfigCondition.
 */
public class LocWfActionConfigCondition implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The condition. */
	private String condition;

    /** The action config id. */
    private Long actionConfigId;

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

    /** The to branch type id. */
    private Long toBranchTypeId;

    /** The wf action code. */
    private String wfActionCode;

    /** The wf action name. */
    private String wfActionName;

    /** The location type name. */
    private String locationTypeName;

    /** The location type. */
    private Long locationType;

    /** The workflow action id. */
    private Long workflowActionId;

    /** The from wf role id. */
    private Long fromWfRoleId;

    /** The location value. */
    private String locationValue;

    /** The to wf role id. */
    private Long toWfRoleId;

    /** The to is fd. */
    private Integer toIsFd;

    private Long toOfficeTypeId;

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
     * Gets the workflow action id.
     *
     * @return the workflow action id
     */
    public Long getWorkflowActionId() {
        return workflowActionId;
    }

    /**
     * Sets the workflow action id.
     *
     * @param workflowActionId the new workflow action id
     */
    public void setWorkflowActionId(Long workflowActionId) {
        this.workflowActionId = workflowActionId;
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
     * Gets the action config id.
     *
     * @return the action config id
     */
    public Long getActionConfigId() {
        return actionConfigId;
    }

    /**
     * Sets the action config id.
     *
     * @param actionConfigId the new action config id
     */
    public void setActionConfigId(Long actionConfigId) {
        this.actionConfigId = actionConfigId;
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
     * Gets the target menu id.
     *
     * @return the target menu id
     */
    public Long getTargetMenuId() {
        return targetMenuId;
    }

    /**
     * Sets the target menu id.
     *
     * @param targetMenuId the new target menu id
     */
    public void setTargetMenuId(Long targetMenuId) {
        this.targetMenuId = targetMenuId;
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
     * Instantiates a new loc wf action config condition.
     */
    public LocWfActionConfigCondition() {
    }

    /**
     * Instantiates a new loc wf action config condition.
     *
     * @param condition the condition
     */
    public LocWfActionConfigCondition(String condition) {
        this.condition = condition;
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
}
