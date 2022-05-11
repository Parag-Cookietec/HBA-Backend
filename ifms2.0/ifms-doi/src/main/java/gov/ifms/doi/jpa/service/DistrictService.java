package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.DistrictDTO;

/**
 * 
 * @author Sagar Jadhav
 *
 */

public interface DistrictService {

	/**
	 * 
	 * @return
	 */
	public List<DistrictDTO> getDistrictList();

	public DistrictDTO getDistrictById(Long districtId);

	public List<DistrictDTO> getDistrictByStateId(Long stateId);
}
