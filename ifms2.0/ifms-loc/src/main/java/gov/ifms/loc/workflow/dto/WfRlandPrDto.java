package gov.ifms.loc.workflow.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class WfRlandPrDto.
 */
public class WfRlandPrDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The wf role id. */
    private Long wfRoleId;

    /** The priority. */
    private int priority;

    /**
     * Instantiates a new wf rland pr dto.
     *
     * @param wfRoleId the wf role id
     * @param priority the priority
     */
    public WfRlandPrDto(Long wfRoleId, int priority) {
        this.wfRoleId = wfRoleId;
        this.priority = priority;
    }

    /**
     * Gets the wf role id.
     *
     * @return the wf role id
     */
    public Long getWfRoleId() {
        return wfRoleId;
    }

    /**
     * Sets the wf role id.
     *
     * @param wfRoleId the new wf role id
     */
    public void setWfRoleId(Long wfRoleId) {
        this.wfRoleId = wfRoleId;
    }

    /**
     * Gets the priority.
     *
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the priority.
     *
     * @param priority the new priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
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
        if (o == null || getClass() != o.getClass()) return false;
        WfRlandPrDto that = (WfRlandPrDto) o;
        return priority == that.priority &&
                Objects.equals(wfRoleId, that.wfRoleId);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(wfRoleId, priority);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", WfRlandPrDto.class.getSimpleName() + "[", "]")
                .add("wfRoleId=" + wfRoleId)
                .add("priority=" + priority)
                .toString();
    }
}
