package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.StateDTO;

/**
 * 
 * @author Sagar Jadhav
 *
 */

public interface StateService {

	/**
	 * 
	 * @return
	 */
	public List<StateDTO> getStateList();
	
	public StateDTO getStateByName(String stateName);

}
