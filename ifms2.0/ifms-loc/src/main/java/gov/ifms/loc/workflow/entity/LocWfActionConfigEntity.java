package gov.ifms.loc.workflow.entity;

import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.loc.util.LocDBConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class LocWfActionConfigEntity.
 */
@Entity
@Table(name = LocDBConstants.LOC_WF_ACTION_CONFIG, schema = LocDBConstants.LOC_SCHEMA)
public class LocWfActionConfigEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The action config id. */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = LocDBConstants.ACTIONCONFIG_ID)
    private long actionConfigId;

    /** The edp ms menu entity. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = LocDBConstants.MENU_ID, referencedColumnName = LocDBConstants.MENU_ID)
    private EDPMsMenuEntity edpMsMenuEntity;

    /** The from actor name. */
    @Column(name = LocDBConstants.FROM_ACTORNAME)
    private String fromActorName;

    /** The from wf role id. */
    @Column(name = LocDBConstants.FROM_WF_ROLE_ID)
    private Long fromWfRoleId;

    /** The from branch type id. */
    @Column(name = LocDBConstants.FROM_BRANCH_TYPE_ID)
    private Long fromBranchTypeId;

    /** The from office type id. */
    @Column(name = LocDBConstants.FROM_OFFICE_TYPE_ID)
    private Long fromOfficeTypeId;

    /** The from status. */
    @Column(name = LocDBConstants.FROM_STATUS)
    private String fromStatus;

    /** The from wf status. */
    @Column(name = LocDBConstants.FROM_WF_STATUS)
    private String fromWfStatus;

    /** The from level. */
    @Column(name = LocDBConstants.FROM_LEVEL)
    private int fromLevel;

    /** The condition. */
    @Column(name = LocDBConstants.CONDITION)
    private String condition;

    /** The to level. */
    @Column(name = LocDBConstants.TO_LEVEL)
    private int toLevel;

    /** The to wf status. */
    @Column(name = LocDBConstants.TO_WF_STATUS)
    private String toWfStatus;

    /** The to status. */
    @Column(name = LocDBConstants.TO_STATUS)
    private String toStatus;

    /** The to actor name. */
    @Column(name = LocDBConstants.TO_ACTORNAME)
    private String toActorName;

    /** The to work flow role id. */
    @Column(name = LocDBConstants.TO_WF_ROLE_ID)
    private Long toWorkFlowRoleId;

    /** The to branch type id. */
    @Column(name = LocDBConstants.TO_BRANCH_TYPE_ID)
    private Long toBranchTypeId;

    /** The to office type id. */
    @Column(name = LocDBConstants.TO_OFFICE_TYPE_ID)
    private Long toOfficeTypeId;

    /** The location type. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = LocDBConstants.LOCATION_TYPE, referencedColumnName = LocDBConstants.LOOKUP_INFO_ID)
    private EDPLuLookUpInfoEntity locationType;

    /** The wf action id. */
    @Column(name = LocDBConstants.WF_ACTION_ID)
    private Long wfActionId;

    /** The location value. */
    @Column(name = LocDBConstants.LOCATION_VALUE)
    private String locationValue;

    /** The from is FD. */
    @Column(name = LocDBConstants.FROM_IS_FD)
    private int fromIsFD;

    /** The is to branch sel req. */
    @Column(name = LocDBConstants.IS_TO_BRANCH_SEL_REQ)
    private int isToBranchSelReq;

    /** The is to office sel req. */
    @Column(name = LocDBConstants.IS_TO_OFFICE_SEL_REQ)
    private int isToOfficeSelReq;

    /** The is to user sel req. */
    @Column(name = LocDBConstants.IS_TO_USER_SEL_REQ)
    private int isToUserSelReq;

    /** The send back flag. */
    @Column(name = LocDBConstants.SEND_BACK_FLAG)
    private int sendBackFlag;

    /** The group version code. */
    @Column(name = LocDBConstants.GROUP_VERSION_CODE)
    private int groupVersionCode;

    /** The active status. */
    @Column(name = LocDBConstants.ACTIVE_STATUS)
    private int activeStatus;

    /** The type id. */
    @Column(name = LocDBConstants.TYPE_ID)
    private int typeId;

    /** The target menu id. */
    @Column(name = LocDBConstants.TARGET_MENU_ID)
    private Long targetMenuId;

    /** The init wf role id. */
    @Column(name = LocDBConstants.INIT_WF_ROLE_ID)
    private Long initWfRoleId;

    /** The is co. */
    @Column(name = LocDBConstants.IS_CO)
    private int isCo;

    /** The to is fd. */
    @Column(name = LocDBConstants.TO_IS_FD)
    private Integer toIsFd;

    /** The is display in popup. */
    @Column(name = LocDBConstants.IS_DISPLAY_IN_POPUP)
    private Integer isDisplayInPopup;

    /** The init wf rl pr. */
    @Column(name = LocDBConstants.INIT_WF_RL_PR)
    private int initWfRlPr;

    /** The from office sub type id. */
    @Column(name = LocDBConstants.FROM_OFFICE_SUB_TYPE_ID)
    private Long fromOfficeSubTypeId;

    /** The to office sub type id. */
    @Column(name = LocDBConstants.TO_OFFICE_SUB_TYPE_ID)
    private Long toOfficeSubTypeId;

    /** The is to. */
    @Column(name = "IS_TO")
    private int isTo;

    /**
     * Gets the action config id.
     *
     * @return the action config id
     */
    public long getActionConfigId() {
        return actionConfigId;
    }

    /**
     * Sets the action config id.
     *
     * @param actionConfigId the new action config id
     */
    public void setActionConfigId(long actionConfigId) {
        this.actionConfigId = actionConfigId;
    }

    /**
     * Gets the edp ms menu entity.
     *
     * @return the edp ms menu entity
     */
    public EDPMsMenuEntity getEdpMsMenuEntity() {
        return edpMsMenuEntity;
    }

    /**
     * Sets the edp ms menu entity.
     *
     * @param edpMsMenuEntity the new edp ms menu entity
     */
    public void setEdpMsMenuEntity(EDPMsMenuEntity edpMsMenuEntity) {
        this.edpMsMenuEntity = edpMsMenuEntity;
    }

    /**
     * Gets the from actor name.
     *
     * @return the from actor name
     */
    public String getFromActorName() {
        return fromActorName;
    }

    /**
     * Sets the from actor name.
     *
     * @param fromActorName the new from actor name
     */
    public void setFromActorName(String fromActorName) {
        this.fromActorName = fromActorName;
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
     * Gets the to actor name.
     *
     * @return the to actor name
     */
    public String getToActorName() {
        return toActorName;
    }

    /**
     * Sets the to actor name.
     *
     * @param toActorName the new to actor name
     */
    public void setToActorName(String toActorName) {
        this.toActorName = toActorName;
    }

    /**
     * Gets the to work flow role id.
     *
     * @return the to work flow role id
     */
    public Long getToWorkFlowRoleId() {
        return toWorkFlowRoleId;
    }

    /**
     * Sets the to work flow role id.
     *
     * @param toWorkFlowRoleId the new to work flow role id
     */
    public void setToWorkFlowRoleId(Long toWorkFlowRoleId) {
        this.toWorkFlowRoleId = toWorkFlowRoleId;
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
    public EDPLuLookUpInfoEntity getLocationType() {
        return locationType;
    }

    /**
     * Sets the location type.
     *
     * @param locationType the new location type
     */
    public void setLocationType(EDPLuLookUpInfoEntity locationType) {
        this.locationType = locationType;
    }

    /**
     * Gets the wf action id.
     *
     * @return the wf action id
     */
    public Long getWfActionId() {
        return wfActionId;
    }

    /**
     * Sets the wf action id.
     *
     * @param wfActionId the new wf action id
     */
    public void setWfActionId(Long wfActionId) {
        this.wfActionId = wfActionId;
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
     * Gets the checks if is co.
     *
     * @return the checks if is co
     */
    public int getIsCo() {
        return isCo;
    }

    /**
     * Sets the checks if is co.
     *
     * @param isCo the new checks if is co
     */
    public void setIsCo(int isCo) {
        this.isCo = isCo;
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
     * Gets the checks if is display in popup.
     *
     * @return the checks if is display in popup
     */
    public Integer getIsDisplayInPopup() {
        return isDisplayInPopup;
    }

    /**
     * Sets the checks if is display in popup.
     *
     * @param isDisplayInPopup the new checks if is display in popup
     */
    public void setIsDisplayInPopup(Integer isDisplayInPopup) {
        this.isDisplayInPopup = isDisplayInPopup;
    }

    /**
     * Gets the inits the wf rl pr.
     *
     * @return the inits the wf rl pr
     */
    public int getInitWfRlPr() {
        return initWfRlPr;
    }

    /**
     * Sets the inits the wf rl pr.
     *
     * @param initWfRlPr the new inits the wf rl pr
     */
    public void setInitWfRlPr(int initWfRlPr) {
        this.initWfRlPr = initWfRlPr;
    }

    /**
     * Gets the from office sub type id.
     *
     * @return the from office sub type id
     */
    public Long getFromOfficeSubTypeId() {
        return fromOfficeSubTypeId;
    }

    /**
     * Sets the from office sub type id.
     *
     * @param fromOfficeSubTypeId the new from office sub type id
     */
    public void setFromOfficeSubTypeId(Long fromOfficeSubTypeId) {
        this.fromOfficeSubTypeId = fromOfficeSubTypeId;
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
     * Gets the checks if is to.
     *
     * @return the checks if is to
     */
    public int getIsTo() {
        return isTo;
    }

    /**
     * Sets the checks if is to.
     *
     * @param isTo the new checks if is to
     */
    public void setIsTo(int isTo) {
        this.isTo = isTo;
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LocWfActionConfigEntity))
            return false;
        LocWfActionConfigEntity that = (LocWfActionConfigEntity) o;
        return getActionConfigId() == that.getActionConfigId() && getFromLevel() == that.getFromLevel()
                && getToLevel() == that.getToLevel() && getFromIsFD() == that.getFromIsFD()
                && getIsToBranchSelReq() == that.getIsToBranchSelReq()
                && getIsToOfficeSelReq() == that.getIsToOfficeSelReq()
                && getIsToUserSelReq() == that.getIsToUserSelReq() && getSendBackFlag() == that.getSendBackFlag()
                && getGroupVersionCode() == that.getGroupVersionCode() && getActiveStatus() == that.getActiveStatus()
                && getTypeId() == that.getTypeId() && getIsCo() == that.getIsCo()
                && getInitWfRlPr() == that.getInitWfRlPr() && getIsTo() == that.getIsTo()
                && Objects.equals(getEdpMsMenuEntity(), that.getEdpMsMenuEntity())
                && Objects.equals(getFromActorName(), that.getFromActorName())
                && Objects.equals(getFromWfRoleId(), that.getFromWfRoleId())
                && Objects.equals(getFromBranchTypeId(), that.getFromBranchTypeId())
                && Objects.equals(getFromOfficeTypeId(), that.getFromOfficeTypeId())
                && Objects.equals(getFromStatus(), that.getFromStatus())
                && Objects.equals(getFromWfStatus(), that.getFromWfStatus())
                && Objects.equals(getCondition(), that.getCondition())
                && Objects.equals(getToWfStatus(), that.getToWfStatus())
                && Objects.equals(getToStatus(), that.getToStatus())
                && Objects.equals(getToActorName(), that.getToActorName())
                && Objects.equals(getToWorkFlowRoleId(), that.getToWorkFlowRoleId())
                && Objects.equals(getToBranchTypeId(), that.getToBranchTypeId())
                && Objects.equals(getToOfficeTypeId(), that.getToOfficeTypeId())
                && Objects.equals(getLocationType(), that.getLocationType())
                && Objects.equals(getWfActionId(), that.getWfActionId())
                && Objects.equals(getLocationValue(), that.getLocationValue())
                && Objects.equals(getTargetMenuId(), that.getTargetMenuId())
                && Objects.equals(getInitWfRoleId(), that.getInitWfRoleId())
                && Objects.equals(getToIsFd(), that.getToIsFd())
                && Objects.equals(getIsDisplayInPopup(), that.getIsDisplayInPopup())
                && Objects.equals(getFromOfficeSubTypeId(), that.getFromOfficeSubTypeId())
                && Objects.equals(getToOfficeSubTypeId(), that.getToOfficeSubTypeId());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getActionConfigId(), getEdpMsMenuEntity(), getFromActorName(), getFromWfRoleId(),
                getFromBranchTypeId(), getFromOfficeTypeId(), getFromStatus(), getFromWfStatus(), getFromLevel(),
                getCondition(), getToLevel(), getToWfStatus(), getToStatus(), getToActorName(), getToWorkFlowRoleId(),
                getToBranchTypeId(), getToOfficeTypeId(), getLocationType(), getWfActionId(), getLocationValue(),
                getFromIsFD(), getIsToBranchSelReq(), getIsToOfficeSelReq(), getIsToUserSelReq(), getSendBackFlag(),
                getGroupVersionCode(), getActiveStatus(), getTypeId(), getTargetMenuId(), getInitWfRoleId(), getIsCo(),
                getToIsFd(), getIsDisplayInPopup(), getInitWfRlPr(), getFromOfficeSubTypeId(), getToOfficeSubTypeId(),
                getIsTo());
    }
}
