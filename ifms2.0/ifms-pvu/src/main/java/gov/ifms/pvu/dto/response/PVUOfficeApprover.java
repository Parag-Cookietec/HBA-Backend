package gov.ifms.pvu.dto.response;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;

/**
 * The Class PVUWfTableInfo.
 */
@NativeQueryResultEntity
public class PVUOfficeApprover implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The remarks.
     */
    @NativeQueryResultColumn(index = 0)
    private Long lkPOUId;

    /**
     * The remarks type.
     */
    @NativeQueryResultColumn(index = 1)
    private Long userId;


    /**
     * The remarks type.
     */
    @NativeQueryResultColumn(index = 2)
    private Long wfRoleId;


    /**
     * The remarks type.
     */
    @NativeQueryResultColumn(index = 3)
    private String name;

    public Long getLkPOUId() {
        return lkPOUId;
    }

    public void setLkPOUId(Long lkPOUId) {
        this.lkPOUId = lkPOUId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWfRoleId() {
        return wfRoleId;
    }

    public void setWfRoleId(Long wfRoleId) {
        this.wfRoleId = wfRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
