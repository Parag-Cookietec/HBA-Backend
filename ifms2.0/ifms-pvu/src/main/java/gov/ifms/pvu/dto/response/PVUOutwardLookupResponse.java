package gov.ifms.pvu.dto.response;

import gov.ifms.edp.dto.ClueDto;

import java.util.List;

/**
 * The Class PVUOutwardLookupResponse.
 */
public class PVUOutwardLookupResponse extends PVUInwardLookupResponse {

	private List<ClueDto> statusList;
	
	private List<PVUOfficeApprover> approverList;

	public List<ClueDto> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<ClueDto> statusList) {
		this.statusList = statusList;
	}

	public List<PVUOfficeApprover> getApproverList() {
		return approverList;
	}

	public void setApproverList(List<PVUOfficeApprover> approverList) {
		this.approverList = approverList;
	}
}
