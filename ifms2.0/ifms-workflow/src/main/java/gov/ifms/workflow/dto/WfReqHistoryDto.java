package gov.ifms.workflow.dto;

import java.io.Serializable;

public class WfReqHistoryDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long eventId;

    private Long menuId;

    private Long trnId;

    private Long officeId;

    private Long postId;

    private String wfRoleCode;

    private Integer[] wfRoles;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getTrnId() {
        return trnId;
    }

    public void setTrnId(Long trnId) {
        this.trnId = trnId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getWfRoleCode() {
        return wfRoleCode;
    }

    public void setWfRoleCode(String wfRoleCode) {
        this.wfRoleCode = wfRoleCode;
    }

    public Integer[] getWfRoles() {
        return wfRoles;
    }

    public void setWfRoles(Integer[] wfRoles) {
        this.wfRoles = wfRoles;
    }
}
