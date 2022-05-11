package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;

/**
 * The Class PVUMsEventDto.
 *
 * @version v 1.0
 * @created 2020/01/09 11:46:59
 */
public class PVUMsEventDto extends BaseDto implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private long id;

    /**
     * The course name.
     */
    private String eventName;

    /**
     * The course name guj.
     */
    private int screenType;

    /**
     * The course desc.
     */
    private String eventCode;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getScreenType() {
        return screenType;
    }

    public void setScreenType(int screenType) {
        this.screenType = screenType;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
}
