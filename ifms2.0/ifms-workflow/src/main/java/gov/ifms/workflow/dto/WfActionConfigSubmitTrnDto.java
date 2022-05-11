package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class WfActionConfigSubmitTrnDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(wfDetails);
	}

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

	@Override
	public String toString() {
		return String.format("WfActionConfigSubmitTrnDto [wfDetails=%s]", wfDetails);
	}
}
