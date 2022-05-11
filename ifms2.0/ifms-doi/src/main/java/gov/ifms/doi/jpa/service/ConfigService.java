package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.DoiJPASchemePolicyDTO;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface ConfigService {

	/**
	 * 
	 * @return
	 */
	public List<DoiJPASchemePolicyDTO> getSchemePolicyList();

}
