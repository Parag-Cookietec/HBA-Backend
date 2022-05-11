/**
 * 
 */
package gov.ifms.doi.legalentry.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.doi.jpa.dto.DoiJpaClaimListingResponseDTO;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.legalentry.dto.DOIJPALegalDetailEntryDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalDetailEntryResponseDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalEntryForRequestDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalEntryListingRespDTO;

/**
 * @author Rudra
 *
 */
public interface DOIJPALegalDetailsEntryService {

	DOIJPALegalDetailEntryDTO saveOrUpdateDOIJPALegalEntry(DOIJPALegalDetailEntryDTO dto);

	PagebleDTO<DOIJPALegalEntryListingRespDTO> makeJpaLegalEntryforRequest(DOIJPALegalEntryForRequestDTO dto) throws CustomException;

	PagebleDTO<DOIJPALegalEntryListingRespDTO> makeJpaLegalEntryforRequestListing(PageDetails pageDetail)throws CustomException;
	//DOIJPALegalEntryForRequestRespDTO makeJpaLegalEntryforRequestListing(PageDetails pageDetail)throws CustomException;

	PagebleDTO<DOIJPALegalEntryListingRespDTO> getJpaLegalEntryListing(PageDetails pageDetail) throws CustomException;

	PagebleDTO<DoiJpaClaimListingResponseDTO> getJPALegalClaimListingPage(PageDetails pageDetail) throws CustomException;

	DOIJPALegalDetailEntryDTO getDOIJPALegalEntry(Long legalEntryId);

	DOIJPALegalDetailEntryResponseDTO deleteJpaLegalEntryforRequest(Long legalDtlsId) throws CustomException;

}
