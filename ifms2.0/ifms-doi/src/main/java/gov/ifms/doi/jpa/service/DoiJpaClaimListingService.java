/**
 * 
 */
package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.doi.jpa.dto.DoiJpaClaimListingRequestDTO;
import gov.ifms.doi.jpa.dto.DoiJpaClaimListingResponseDTO;
import gov.ifms.doi.jpa.pagination.PageDetails;

/**
 * @author Rudra
 *
 */
public interface DoiJpaClaimListingService {

	List<DoiJpaClaimListingResponseDTO> getJPAClaimListing(DoiJpaClaimListingRequestDTO dto);

	PagebleDTO<DoiJpaClaimListingResponseDTO> getJPAClaimListingPage(PageDetails pageDetail) throws CustomException;

}
