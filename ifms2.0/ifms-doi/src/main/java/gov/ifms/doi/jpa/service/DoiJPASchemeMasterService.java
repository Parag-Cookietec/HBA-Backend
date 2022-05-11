package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeMasterDTO;
import gov.ifms.doi.jpa.pagination.PageDetails;

/**
 * 
 * @author Sagar Patil
 *
 */
public interface DoiJPASchemeMasterService {

	/**
	 * Convert given DoiJpaSchemeMasterDTO to DoiJPASchemeMaster Saves a given
	 * DoiJPASchemeMaster. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param DoiJpaSchemeMasterDTO the dto
	 * @return the saved DoiJPASchemeMaster
	 */
	public List<DoiJpaSchemeMasterDTO>  saveOrUpdate(List<DoiJpaSchemeMasterDTO> dto);

	/**
	 * Fetch all the scheme details convert it into dto and return
	 * 
	 * @return
	 */
	public List<DoiJpaSchemeMasterDTO> getAllSchemes(DoiJpaSchemeMasterDTO dto);

	public List<DoiJpaSchemeMasterDTO> softDeleteBySchemeId(Long schemeId);

	public int updateSchemeStatusBySchemeId(Long schemeId, String status);

	public List<DoiJpaSchemeMasterDTO> getAllActiveSchemes();


	public DoiJpaSchemeMasterDTO getSchemeBySchemeId(Long schemeId) throws CustomException;

	PagebleDTO<DoiJpaSchemeMasterDTO> getAllActiveSchemes(PageDetails pageDetail) throws CustomException;

	/**
	 * Convert given DMOMarketLoanDto to DMOMarketLoanEntity Saves a given
	 * DMOMarketLoanEntity. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DMOMarketLoanEntity
	 */


}
