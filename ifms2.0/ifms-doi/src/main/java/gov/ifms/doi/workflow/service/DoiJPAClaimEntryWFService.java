package gov.ifms.doi.workflow.service;

import java.util.List;

import gov.ifms.doi.workflow.dto.DoiJpaClaimEntryWFDTO;

public interface DoiJPAClaimEntryWFService {

	/**
	 * Convert given DoiJpaDTO to DoiJPA Saves a given DoiJPA. Use the returned
	 * instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiJPA
	 */
	public List<DoiJpaClaimEntryWFDTO> saveOrUpdate(DoiJpaClaimEntryWFDTO dto);

	/**
	 * 
	 * @return List<DoiJPAMasterPolicy>
	 */
	public List<DoiJpaClaimEntryWFDTO> findAll();

	/**
	 * 
	 * @return
	 *//*
		 * public List<DoiJPAMasterPolicyWF> findBySchemeId(Long schemeId);
		 */

}
