package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.DoiCommonLookUpDTO;

public interface DoiCommonLookupService {

	/**
	 * Convert given DoiJpaDTO to DoiJPA Saves a given DoiJPA. Use the returned
	 * instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiJPA
	 */
	public List<DoiCommonLookUpDTO> getByLookUpName(DoiCommonLookUpDTO dto);

}
