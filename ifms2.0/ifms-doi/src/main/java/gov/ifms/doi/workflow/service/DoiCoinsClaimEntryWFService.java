package gov.ifms.doi.workflow.service;

import java.util.List;

import gov.ifms.doi.workflow.dto.DoiCoinsClaimHdrWfDTO;

public interface DoiCoinsClaimEntryWFService {

	/**
	 * Convert given DoiCoinsClaimHdrWfDTO to DoiJPA Saves a given DoiJPA. Use the returned
	 * instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiJPA
	 */
	public List<DoiCoinsClaimHdrWfDTO> saveOrUpdate(DoiCoinsClaimHdrWfDTO dto);

	/**
	 * 
	 * @return List<DoiJPAMasterPolicy>
	 */
	public List<DoiCoinsClaimHdrWfDTO> findAll();

}
