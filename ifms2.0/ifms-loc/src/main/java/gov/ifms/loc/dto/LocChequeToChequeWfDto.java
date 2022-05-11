package gov.ifms.loc.dto;

import gov.ifms.edp.dto.BaseDto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The Class LocChequeToChequeWfDto.
 *
 * @version 1.0
 * @created 2020/09/09 09:21:24
 */
public class LocChequeToChequeWfDto extends BaseDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The wf id.
     */

    private Long wfId;

    /**
     * The trn id.
     */
    private Long trnId;

    /**
     * The action config id.
     */
    private Long actionConfigId;

    /**
     * The wf action id.
     */
    private Long wfActionId;

    /**
     * The assign to wf role id.
     */
    private Long assignToWfRoleId;

    /**
     * The assign to user id.
     */
    private Long assignToUserId;

    /**
     * The assign to post id.
     */
    private Long assignToPostId;

    /**
     * The assign to pou id.
     */
    private Long assignToPouId;

    /**
     * The assign to office id.
     */
    private Long assignToOfficeId;

    /**
     * The assign to branch id.
     */
    private Long assignToBranchId;

    /**
     * The assign to group id.
     */
    private Long assignToGroupId;

    /**
     * The wf status.
     */
    private String wfStatus;

    /**
     * The trn status.
     */
    private String trnStatus;

    /**
     * The assign by wf role id.
     */
    private Long assignByWfRoleId;

    /**
     * The assign by user id.
     */
    private Long assignByUserId;

    /**
     * The assign by post id.
     */
    private Long assignByPostId;

    /**
     * The assign by pou id.
     */
    private Long assignByPouId;

    /**
     * The assign by office id.
     */
    private Long assignByOfficeId;

    /**
     * The assign by branch id.
     */
    private Long assignByBranchId;

    /**
     * The assign by group id.
     */
    private Long assignByGroupId;

    /**
     * The remarks.
     */
    private String remarks;

    /**
     * The send back flag.
     */
    @NotNull
    private Integer sendBackFlag;

    /**
     * The counter.
     */
    @NotNull
    private Integer counter;

    /**
     * The sub counter.
     */
    @NotNull
    private Integer subCounter;

    /**
     * The level.
     */
    @NotNull
    private Integer level;

    /**
     * The ref col small int.
     */
    @NotNull
    private Integer refColSmallInt;

    /**
     * The ref col varchar.
     */
    private String refColVarchar;

    /**
     * The ref col other.
     */
    private String refColOther;

    /**
     * LocChequeToChequeWfDto Constructor.
     */
    public LocChequeToChequeWfDto() {
        super();
    }

    /**
     * @return the wfId
     */
    public Long getWfId() {
        return wfId;
    }

    /**
     * Sets the wf id.
     *
     * @param wfId the wfId to set
     */
    public void setWfId(Long wfId) {
        this.wfId = wfId;
    }

    /**
     * Gets the trn id.
     *
     * @return the trnId
     */
    public Long getTrnId() {
        return trnId;
    }

    /**
     * Sets the trn id.
     *
     * @param trnId the trnId to set
     */
    public void setTrnId(Long trnId) {
        this.trnId = trnId;
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
     * Gets the wf action id.
     *
     * @return the wfActionId
     */
    public Long getWfActionId() {
        return wfActionId;
    }

    /**
     * Sets the wf action id.
     *
     * @param wfActionId the wfActionId to set
     */
    public void setWfActionId(Long wfActionId) {
        this.wfActionId = wfActionId;
    }

    /**
     * Gets the assign to wf role id.
     *
     * @return the assignToWfRoleId
     */
    public Long getAssignToWfRoleId() {
        return assignToWfRoleId;
    }

    /**
     * Sets the assign to wf role id.
     *
     * @param assignToWfRoleId the assignToWfRoleId to set
     */
    public void setAssignToWfRoleId(Long assignToWfRoleId) {
        this.assignToWfRoleId = assignToWfRoleId;
    }

    /**
     * Gets the assign to user id.
     *
     * @return the assignToUserId
     */
    public Long getAssignToUserId() {
        return assignToUserId;
    }

    /**
     * Sets the assign to user id.
     *
     * @param assignToUserId the assignToUserId to set
     */
    public void setAssignToUserId(Long assignToUserId) {
        this.assignToUserId = assignToUserId;
    }

    /**
     * Gets the assign to post id.
     *
     * @return the assignToPostId
     */
    public Long getAssignToPostId() {
        return assignToPostId;
    }

    /**
     * Sets the assign to post id.
     *
     * @param assignToPostId the assignToPostId to set
     */
    public void setAssignToPostId(Long assignToPostId) {
        this.assignToPostId = assignToPostId;
    }

    /**
     * Gets the assign to pou id.
     *
     * @return the assignToPouId
     */
    public Long getAssignToPouId() {
        return assignToPouId;
    }

    /**
     * Sets the assign to pou id.
     *
     * @param assignToPouId the assignToPouId to set
     */
    public void setAssignToPouId(Long assignToPouId) {
        this.assignToPouId = assignToPouId;
    }

    /**
     * Gets the assign to office id.
     *
     * @return the assignToOfficeId
     */
    public Long getAssignToOfficeId() {
        return assignToOfficeId;
    }

    /**
     * Sets the assign to office id.
     *
     * @param assignToOfficeId the assignToOfficeId to set
     */
    public void setAssignToOfficeId(Long assignToOfficeId) {
        this.assignToOfficeId = assignToOfficeId;
    }

    /**
     * Gets the assign to branch id.
     *
     * @return the assignToBranchId
     */
    public Long getAssignToBranchId() {
        return assignToBranchId;
    }

    /**
     * Sets the assign to branch id.
     *
     * @param assignToBranchId the assignToBranchId to set
     */
    public void setAssignToBranchId(Long assignToBranchId) {
        this.assignToBranchId = assignToBranchId;
    }

    /**
     * Gets the assign to group id.
     *
     * @return the assignToGroupId
     */
    public Long getAssignToGroupId() {
        return assignToGroupId;
    }

    /**
     * Sets the assign to group id.
     *
     * @param assignToGroupId the assignToGroupId to set
     */
    public void setAssignToGroupId(Long assignToGroupId) {
        this.assignToGroupId = assignToGroupId;
    }

    /**
     * Gets the wf status.
     *
     * @return the wfStatus
     */
    public String getWfStatus() {
        return wfStatus;
    }

    /**
     * Sets the wf status.
     *
     * @param wfStatus the wfStatus to set
     */
    public void setWfStatus(String wfStatus) {
        this.wfStatus = wfStatus;
    }

    /**
     * Gets the trn status.
     *
     * @return the trnStatus
     */
    public String getTrnStatus() {
        return trnStatus;
    }

    /**
     * Sets the trn status.
     *
     * @param trnStatus the trnStatus to set
     */
    public void setTrnStatus(String trnStatus) {
        this.trnStatus = trnStatus;
    }

    /**
     * Gets the assign by wf role id.
     *
     * @return the assignByWfRoleId
     */
    public Long getAssignByWfRoleId() {
        return assignByWfRoleId;
    }

    /**
     * Sets the assign by wf role id.
     *
     * @param assignByWfRoleId the assignByWfRoleId to set
     */
    public void setAssignByWfRoleId(Long assignByWfRoleId) {
        this.assignByWfRoleId = assignByWfRoleId;
    }

    /**
     * Gets the assign by user id.
     *
     * @return the assignByUserId
     */
    public Long getAssignByUserId() {
        return assignByUserId;
    }

    /**
     * Sets the assign by user id.
     *
     * @param assignByUserId the assignByUserId to set
     */
    public void setAssignByUserId(Long assignByUserId) {
        this.assignByUserId = assignByUserId;
    }

    /**
     * Gets the assign by post id.
     *
     * @return the assignByPostId
     */
    public Long getAssignByPostId() {
        return assignByPostId;
    }

    /**
     * Sets the assign by post id.
     *
     * @param assignByPostId the assignByPostId to set
     */
    public void setAssignByPostId(Long assignByPostId) {
        this.assignByPostId = assignByPostId;
    }

    /**
     * Gets the assign by pou id.
     *
     * @return the assignByPouId
     */
    public Long getAssignByPouId() {
        return assignByPouId;
    }

    /**
     * Sets the assign by pou id.
     *
     * @param assignByPouId the assignByPouId to set
     */
    public void setAssignByPouId(Long assignByPouId) {
        this.assignByPouId = assignByPouId;
    }

    /**
     * Gets the assign by office id.
     *
     * @return the assignByOfficeId
     */
    public Long getAssignByOfficeId() {
        return assignByOfficeId;
    }

    /**
     * Sets the assign by office id.
     *
     * @param assignByOfficeId the assignByOfficeId to set
     */
    public void setAssignByOfficeId(Long assignByOfficeId) {
        this.assignByOfficeId = assignByOfficeId;
    }

    /**
     * Gets the assign by branch id.
     *
     * @return the assignByBranchId
     */
    public Long getAssignByBranchId() {
        return assignByBranchId;
    }

    /**
     * Sets the assign by branch id.
     *
     * @param assignByBranchId the assignByBranchId to set
     */
    public void setAssignByBranchId(Long assignByBranchId) {
        this.assignByBranchId = assignByBranchId;
    }

    /**
     * Gets the assign by group id.
     *
     * @return the assignByGroupId
     */
    public Long getAssignByGroupId() {
        return assignByGroupId;
    }

    /**
     * Sets the assign by group id.
     *
     * @param assignByGroupId the assignByGroupId to set
     */
    public void setAssignByGroupId(Long assignByGroupId) {
        this.assignByGroupId = assignByGroupId;
    }

    /**
     * Gets the remarks.
     *
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the remarks.
     *
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Gets the send back flag.
     *
     * @return the sendBackFlag
     */
    public Integer getSendBackFlag() {
        return sendBackFlag;
    }

    /**
     * Sets the send back flag.
     *
     * @param sendBackFlag the sendBackFlag to set
     */
    public void setSendBackFlag(Integer sendBackFlag) {
        this.sendBackFlag = sendBackFlag;
    }

    /**
     * Gets the counter.
     *
     * @return the counter
     */
    public Integer getCounter() {
        return counter;
    }

    /**
     * Sets the counter.
     *
     * @param counter the counter to set
     */
    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    /**
     * Gets the sub counter.
     *
     * @return the subCounter
     */
    public Integer getSubCounter() {
        return subCounter;
    }

    /**
     * Sets the sub counter.
     *
     * @param subCounter the subCounter to set
     */
    public void setSubCounter(Integer subCounter) {
        this.subCounter = subCounter;
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Sets the level.
     *
     * @param level the level to set
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * Gets the ref col small int.
     *
     * @return the refColSmallInt
     */
    public Integer getRefColSmallInt() {
        return refColSmallInt;
    }

    /**
     * Sets the ref col small int.
     *
     * @param refColSmallInt the refColSmallInt to set
     */
    public void setRefColSmallInt(Integer refColSmallInt) {
        this.refColSmallInt = refColSmallInt;
    }

    /**
     * Gets the ref col varchar.
     *
     * @return the refColVarchar
     */
    public String getRefColVarchar() {
        return refColVarchar;
    }

    /**
     * Sets the ref col varchar.
     *
     * @param refColVarchar the refColVarchar to set
     */
    public void setRefColVarchar(String refColVarchar) {
        this.refColVarchar = refColVarchar;
    }

    /**
     * Gets the ref col other.
     *
     * @return the refColOther
     */
    public String getRefColOther() {
        return refColOther;
    }

    /**
     * Sets the ref col other.
     *
     * @param refColOther the refColOther to set
     */
    public void setRefColOther(String refColOther) {
        this.refColOther = refColOther;
    }

}
