package gov.ifms.pvu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;

@NativeQueryResultEntity
public class PVUHigherPayView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The event id. */
    @NativeQueryResultColumn(index = 0)
    private String eventEffectiveDate;

    /** The trans no. */
    @NativeQueryResultColumn(index = 1)
    private String designationName;

    /** The event name. */
    @NativeQueryResultColumn(index = 2)
    private String scale;

    /** The event name. */
    @JsonIgnore
    @NativeQueryResultColumn(index = 3)
    private Long count;

    public String getEventEffectiveDate() {
        return eventEffectiveDate;
    }

    public void setEventEffectiveDate(String eventEffectiveDate) {
        this.eventEffectiveDate = eventEffectiveDate;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

}
