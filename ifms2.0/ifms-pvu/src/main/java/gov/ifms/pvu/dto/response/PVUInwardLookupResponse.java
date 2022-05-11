package gov.ifms.pvu.dto.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import gov.ifms.edp.dto.ClueDto;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;

/**
 * The Class PVUEmployeDetailsDto.
 */
public class PVUInwardLookupResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lst lu look up. */
	private Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp;

	/** The designation. */
	private List<ClueDto> designation;
	
	/** The district. */
	private List<ClueDto> district;
	
	/** The pvu events. */
	private List<ClueDto> pvuEvents;

	/**
	 * Gets the lst lu look up.
	 *
	 * @return the lst lu look up
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getLstLuLookUp() {
		return lstLuLookUp;
	}

	/**
	 * Sets the lst lu look up.
	 *
	 * @param lstLuLookUp the lst lu look up
	 */
	public void setLstLuLookUp(Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp) {
		this.lstLuLookUp = lstLuLookUp;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public List<ClueDto> getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the new designation
	 */
	public void setDesignation(List<ClueDto> designation) {
		this.designation = designation;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public List<ClueDto> getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the new district
	 */
	public void setDistrict(List<ClueDto> district) {
		this.district = district;
	}

	/**
	 * Gets the pvu events.
	 *
	 * @return the pvu events
	 */
	public List<ClueDto> getPvuEvents() {
		return pvuEvents;
	}

	/**
	 * Sets the pvu events.
	 *
	 * @param pvuEvents the pvu events
	 */
	public void setPvuEvents(List<ClueDto> pvuEvents) {
		this.pvuEvents = pvuEvents;
	}
}
