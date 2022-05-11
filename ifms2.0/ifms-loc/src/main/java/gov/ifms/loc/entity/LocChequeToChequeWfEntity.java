package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;



/**
 * The Class LOCLocChequeCancelWfEntity.
 *
 * @version v 1.0
 * @created 2021/03/05 18:24:32
 */
@Entity
@Table(name = "TLOC_CHEQUE2CHEQUE_WF", schema = LocConstant.LOC_SCHEMA)
public class LocChequeToChequeWfEntity extends BaseEntity implements Serializable {


    /** The serialVersionUID. */
    private static final long serialVersionUID = 1L;


    /** The Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WF_ID")
    private Long id;

    /** The trn id. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TRN_ID", nullable = false, referencedColumnName = "CHEQUE2CHEQUE_ID")
    private LocChequeToChequeHDREntity trnId;

    /** The actionconfig id. */
    @Column(name = "ACTIONCONFIG_ID")
    private Long actionconfigId;

    /** The wf action id. */
    @Column(name = "WF_ACTION_ID")
    private Long wfActionId;

    /** The assign to wf role id. */
    @Column(name = "ASSIGN_TO_WF_ROLE_ID")
    private Long assignToWfRoleId;

    /** The assign to user id. */
    @Column(name = "ASSIGN_TO_USER_ID")
    private Long assignToUserId;

    /** The assign to post id. */
    @Column(name = "ASSIGN_TO_POST_ID")
    private Long assignToPostId;

    /** The assign to pou id. */
    @Column(name = "ASSIGN_TO_POU_ID")
    private Long assignToPouId;

    /** The assign tooffice id. */
    @Column(name = "ASSIGN_TO_OFFICE_ID")
    private Long assignToofficeId;

    /** The assign to branch id. */
    @Column(name = "ASSIGN_TO_BRANCH_ID")
    private Long assignToBranchId;

    /** The assign to group id. */
    @Column(name = "ASSIGN_TO_GROUP_ID")
    private Long assignToGroupId;

    /** The wf status. */
    @Column(name = "WF_STATUS")
    private String wfStatus;

    /** The trn status. */
    @Column(name = "TRN_STATUS")
    private String trnStatus;

    /** The assign by wf role id. */
    @Column(name = "ASSIGN_BY_WF_ROLE_ID")
    private Long assignByWfRoleId;

    /** The assign by user id. */
    @Column(name = "ASSIGN_BY_USER_ID")
    private Long assignByUserId;

    /** The assign by post id. */
    @Column(name = "ASSIGN_BY_POST_ID")
    private Long assignByPostId;

    /** The assign by pou id. */
    @Column(name = "ASSIGN_BY_POU_ID")
    private Long assignByPouId;

    /** The assign by office id. */
    @Column(name = "ASSIGN_BY_OFFICE_ID")
    private Long assignByOfficeId;

    /** The assign by branch id. */
    @Column(name = "ASSIGN_BY_BRANCH_ID")
    private Long assignByBranchId;

    /** The assign by group id. */
    @Column(name = "ASSIGN_BY_GROUP_ID")
    private Long assignByGroupId;

    /** The remarks. */
    @Column(name = "REMARKS")
    private String remarks;

    /** The send back flag. */
    @Column(name = "SEND_BACK_FLAG")
    private int sendBackFlag;

    /** The counter. */
    @Column(name = "COUNTER")
    private int counter;

    /** The sub counter. */
    @Column(name = "SUB_COUNTER")
    private int subCounter;

    /** The level. */
    @Column(name = "LEVEL")
    private int level;

    /** The ref col smallint. */
    @Column(name = "REF_COL_SMALLINT")
    private int refColSmallint;

    /** The ref col varchar. */
    @Column(name = "REF_COL_VARCHAR")
    private String refColVarchar;

    /** The ref col other. */
    @Column(name = "REF_COL_OTHER")
    private String refColOther;


    /**
     * LocChequeToChequeWfEntity Constructor.
     */
    public LocChequeToChequeWfEntity() {
        super();
    }

    /**
     * hascode method.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, trnId, actionconfigId, wfActionId, assignToWfRoleId, assignToUserId, assignToPostId, assignToPouId, assignToofficeId, assignToBranchId, assignToGroupId, wfStatus, trnStatus, assignByWfRoleId, assignByUserId, assignByPostId, assignByPouId, assignByOfficeId, assignByBranchId, assignByGroupId, remarks, sendBackFlag, counter, subCounter, level, refColSmallint, refColVarchar, refColOther);
    }

    /**
     * equals method.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LocChequeToChequeWfEntity)) {
            return false;
        }

        LocChequeToChequeWfEntity other = (LocChequeToChequeWfEntity) obj;

        return Objects.equals(id, other.id)
                && Objects.equals(trnId, other.trnId)
                && Objects.equals(actionconfigId, other.actionconfigId)
                && Objects.equals(wfActionId, other.wfActionId)
                && Objects.equals(assignToWfRoleId, other.assignToWfRoleId)
                && Objects.equals(assignToUserId, other.assignToUserId)
                && Objects.equals(assignToPostId, other.assignToPostId)
                && Objects.equals(assignToPouId, other.assignToPouId)
                && Objects.equals(assignToofficeId, other.assignToofficeId)
                && Objects.equals(assignToBranchId, other.assignToBranchId)
                && Objects.equals(assignToGroupId, other.assignToGroupId)
                && Objects.equals(wfStatus, other.wfStatus)
                && Objects.equals(trnStatus, other.trnStatus)
                && Objects.equals(assignByWfRoleId, other.assignByWfRoleId)
                && Objects.equals(assignByUserId, other.assignByUserId)
                && Objects.equals(assignByPostId, other.assignByPostId)
                && Objects.equals(assignByPouId, other.assignByPouId)
                && Objects.equals(assignByOfficeId, other.assignByOfficeId)
                && Objects.equals(assignByBranchId, other.assignByBranchId)
                && Objects.equals(assignByGroupId, other.assignByGroupId)
                && Objects.equals(remarks, other.remarks)
                && sendBackFlag == other.sendBackFlag
                && counter == other.counter
                && subCounter == other.subCounter
                && level == other.level
                && refColSmallint == other.refColSmallint
                && Objects.equals(refColVarchar, other.refColVarchar)
                && Objects.equals(refColOther, other.refColOther)
                ;
    }

    /**
     * toString method.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "LOCLocChequeCancelWfEntity [id = " + id + ",trnId = " + trnId + ",actionconfigId = " + actionconfigId + ",wfActionId = " + wfActionId + ",assignToWfRoleId = " + assignToWfRoleId + ",assignToUserId = " + assignToUserId + ",assignToPostId = " + assignToPostId + ",assignToPouId = " + assignToPouId + ",assignToofficeId = " + assignToofficeId + ",assignToBranchId = " + assignToBranchId + ",assignToGroupId = " + assignToGroupId + ",wfStatus = " + wfStatus + ",trnStatus = " + trnStatus + ",assignByWfRoleId = " + assignByWfRoleId + ",assignByUserId = " + assignByUserId + ",assignByPostId = " + assignByPostId + ",assignByPouId = " + assignByPouId + ",assignByOfficeId = " + assignByOfficeId + ",assignByBranchId = " + assignByBranchId + ",assignByGroupId = " + assignByGroupId + ",remarks = " + remarks + ",sendBackFlag = " + sendBackFlag + ",counter = " + counter + ",subCounter = " + subCounter + ",level = " + level + ",refColSmallint = " + refColSmallint + ",refColVarchar = " + refColVarchar + ",refColOther = " + refColOther + ",]";
    }

    /**
     * getter setter.
     *
     * @return the id
     */

    /**
     * @return the Id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param Id the Id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the trn id.
     *
     * @return the trn id
     */
    public LocChequeToChequeHDREntity getTrnId() {
        return trnId;
    }

    /**
     * Sets the trn id.
     *
     * @param trnId the new trn id
     */
    public void setTrnId(LocChequeToChequeHDREntity trnId) {
        this.trnId = trnId;
    }

    /**
     * Gets the actionconfig id.
     *
     * @return the actionconfigId
     */
    public Long getActionconfigId() {
        return actionconfigId;
    }

    /**
     * Sets the actionconfig id.
     *
     * @param actionconfigId the actionconfigId to set
     */
    public void setActionconfigId(Long actionconfigId) {
        this.actionconfigId = actionconfigId;
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
     * Gets the assign tooffice id.
     *
     * @return the assignToofficeId
     */
    public Long getAssignToofficeId() {
        return assignToofficeId;
    }

    /**
     * Sets the assign tooffice id.
     *
     * @param assignToofficeId the assignToofficeId to set
     */
    public void setAssignToofficeId(Long assignToofficeId) {
        this.assignToofficeId = assignToofficeId;
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
    public int getSendBackFlag() {
        return sendBackFlag;
    }

    /**
     * Sets the send back flag.
     *
     * @param sendBackFlag the sendBackFlag to set
     */
    public void setSendBackFlag(int sendBackFlag) {
        this.sendBackFlag = sendBackFlag;
    }

    /**
     * Gets the counter.
     *
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Sets the counter.
     *
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * Gets the sub counter.
     *
     * @return the subCounter
     */
    public int getSubCounter() {
        return subCounter;
    }

    /**
     * Sets the sub counter.
     *
     * @param subCounter the subCounter to set
     */
    public void setSubCounter(int subCounter) {
        this.subCounter = subCounter;
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level.
     *
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the ref col smallint.
     *
     * @return the refColSmallint
     */
    public int getRefColSmallint() {
        return refColSmallint;
    }

    /**
     * Sets the ref col smallint.
     *
     * @param refColSmallint the refColSmallint to set
     */
    public void setRefColSmallint(int refColSmallint) {
        this.refColSmallint = refColSmallint;
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
