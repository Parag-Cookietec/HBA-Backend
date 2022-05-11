package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.TalukaDTO;

/**
 * 
 * @author Sagar Jadhav
 *
 */

public interface TalukaService {

	/**
	 * 
	 * @return
	 */
	public List<TalukaDTO> getTalukaListByDistrictId(Long districtId);

	public TalukaDTO getTalukaById(Long talukaId);
}
