package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;

/**
 * The Class PVUSourceUserDetails.
 */
@NativeQueryResultEntity
public class PVUSourceUserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @NativeQueryResultColumn(index = 0)
    private Long assignByPostId;

    @NativeQueryResultColumn(index = 1)
    private Long assignByUserId;

    @NativeQueryResultColumn(index = 2)
    private Long assignByOfficeId;

    @NativeQueryResultColumn(index = 3)
    private Long assignByPouId;


    public Long getAssignByPostId() {
        return assignByPostId;
    }

    /**
     * Gets the remarks type.
     *
     * @return the remarksType
     */
    public Long getAssignByUserId() {
        return assignByUserId;
    }

    /**
     * Sets the remarks type.
     *
     * @param assignByUserId the remarksType to set
     */
    public void setAssignByUserId(Long assignByUserId) {
        this.assignByUserId = assignByUserId;
    }

    public void setAssignByPostId(Long assignByPostId) {
        this.assignByPostId = assignByPostId;
    }

    public Long getAssignByOfficeId() {
        return assignByOfficeId;
    }

    public void setAssignByOfficeId(Long assignByOfficeId) {
        this.assignByOfficeId = assignByOfficeId;
    }

    public Long getAssignByPouId() {
        return assignByPouId;
    }

    public void setAssignByPouId(Long assignByPouId) {
        this.assignByPouId = assignByPouId;
    }



}
