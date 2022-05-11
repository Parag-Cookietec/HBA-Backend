package gov.ifms.loc.workflow.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class WfActionConfigSubmitTrnDto.
 */
public class WfActionConfigSubmitTrnDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The wf details. */
	private List<WfActionConfigTrnDto> wfDetails;
	
	/**
	 * @return the wfDetails
	 */
	public List<WfActionConfigTrnDto> getWfDetails() {
		return wfDetails;
	}

	/**
	 * @param wfDetails the wfDetails to set
	 */
	public void setWfDetails(List<WfActionConfigTrnDto> wfDetails) {
		this.wfDetails = wfDetails;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(wfDetails);
	}

	/**
	 * Equals.
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
		if (!(obj instanceof WfActionConfigSubmitTrnDto)) {
			return false;
		}
		WfActionConfigSubmitTrnDto other = (WfActionConfigSubmitTrnDto) obj;
		return Objects.equals(wfDetails, other.wfDetails);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("WfActionConfigSubmitTrnDto [wfDetails=%s]", wfDetails);
	}
}
