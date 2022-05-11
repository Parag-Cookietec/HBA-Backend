package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.VillageDTO;

/**
 * 
 * @author Sagar Jadhav
 *
 */

public interface VillageService {

	/**
	 * 
	 * @return
	 */
	public List<VillageDTO> getVillageListByTalukaId(Long talukaId);
	
	public VillageDTO getVillageById(Long villageId);
}
