package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.doi.jpa.dto.DoiJPAClaimEntryDTO;
import gov.ifms.doi.jpa.dto.DoiJpaClaimEntryListingDTO;
import gov.ifms.doi.jpa.entity.DoiJPAClaimEntryEntity;
import javassist.NotFoundException;

public interface DoiJPAClaimEntryService {
	
	/**
	 * Convert given DoiJPAClaimEntryDTO to DoiJPAClaimEntryEntity
	 * Saves a given DoiJPAClaimEntryEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiJPAClaimEntryEntity
	 * @throws CustomException 
	 */
	public DoiJPAClaimEntryDTO saveOrUpdate(DoiJPAClaimEntryDTO dto) throws CustomException;
	
	public List<DoiJPAClaimEntryDTO> findAllByCriteria(DoiJPAClaimEntryDTO dto);
	
	public List<DoiJpaClaimEntryListingDTO> findAllByClaimStatus(String claimStatus);
	
	public DoiJPAClaimEntryDTO findClaimById(Long claimId) throws NotFoundException;
}
