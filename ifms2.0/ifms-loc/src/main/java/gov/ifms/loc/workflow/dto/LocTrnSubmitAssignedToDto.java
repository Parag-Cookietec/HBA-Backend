package gov.ifms.loc.workflow.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class LocTrnSubmitAssignedToDto.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "assignType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LocTrnSubmitAssignedToUserImpl.class, name = "SINGLE_USER"),
        @JsonSubTypes.Type(value = LocTrnSubmitAssignedToUsersImpl.class, name = "MULTIPLE_USER"),
})
public class LocTrnSubmitAssignedToDto implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The wf request no. */
    private String wfRequestNo;

    /** The action config id. */
    private long actionConfigId;

    /** The menu id. */
    private long menuId;

    /** The assign type. */
    private LocAssignType assignType;

    public String getWfRequestNo() {
        return wfRequestNo;
    }

    /**
     * Sets the wf request no.
     *
     * @param wfRequestNo the new wf request no
     */
    public void setWfRequestNo(String wfRequestNo) {
        this.wfRequestNo = wfRequestNo;
    }

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
     * Gets the assign type.
     *
     * @return the assign type
     */
    public LocAssignType getAssignType() {
        return assignType;
    }

    /**
     * Sets the assign type.
     *
     * @param assignType the new assign type
     */
    public void setAssignType(LocAssignType assignType) {
        this.assignType = assignType;
    }

    public List<LocTrnIdRemAssToUserDto> prepareTrnDto(){
        return null;
    }

    /**
     * Gets the menu id.
     *
     * @return the menu id
     */
    public long getMenuId() {
        return menuId;
    }

    /**
     * Sets the menu id.
     *
     * @param menuId the new menu id
     */
    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocTrnSubmitAssignedToDto that = (LocTrnSubmitAssignedToDto) o;
        return actionConfigId == that.actionConfigId && menuId == that.menuId && Objects.equals(wfRequestNo, that.wfRequestNo) && assignType == that.assignType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wfRequestNo, actionConfigId, menuId, assignType);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocTrnSubmitAssignedToDto{");
        sb.append("wfRequestNo='").append(wfRequestNo).append('\'');
        sb.append(", actionConfigId=").append(actionConfigId);
        sb.append(", menuId=").append(menuId);
        sb.append(", assignType=").append(assignType);
        sb.append('}');
        return sb.toString();
    }
}
