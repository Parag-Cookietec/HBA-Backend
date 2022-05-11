package gov.ifms.loc.workflow.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class WfActCodeAndNameDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class WfActCodeAndNameDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /** The wf action code. */
    @NativeQueryResultColumn(index = 0)
    private String wfActionCode;

    /** The wf action name. */
    @NativeQueryResultColumn(index = 1)
    private String wfActionName;

    /**
     * Instantiates a new wf act code and name dto.
     */
    public WfActCodeAndNameDto() {
    }

    /**
     * Instantiates a new wf act code and name dto.
     *
     * @param wfActionCode the wf action code
     * @param wfActionName the wf action name
     */
    public WfActCodeAndNameDto(String wfActionCode, String wfActionName) {
        this.wfActionCode = wfActionCode;
        this.wfActionName = wfActionName;
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
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WfActCodeAndNameDto)) return false;
        WfActCodeAndNameDto that = (WfActCodeAndNameDto) o;
        return Objects.equals(getWfActionCode(), that.getWfActionCode()) && Objects.equals(getWfActionName(), that.getWfActionName());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWfActionCode(), getWfActionName());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WfActCodeAndNameDto{");
        sb.append("wfActionCode='").append(wfActionCode).append('\'');
        sb.append(", wfActionName='").append(wfActionName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
