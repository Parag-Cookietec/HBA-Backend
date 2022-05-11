package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.doi.jpa.dto.DoiCommonLookUpInfoDTO;
import gov.ifms.doi.jpa.dto.DoiJpaMasterPolicyDTO;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeMasterDTO;
import gov.ifms.doi.jpa.pagination.PageDetails;

public interface DoiJPAMasterPolicyService {

	/**
	 * Convert given DoiJpaDTO to DoiJPA Saves a given DoiJPA. Use the returned
	 * instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiJPA
	 */
	public List<DoiJpaMasterPolicyDTO> saveOrUpdate(List<DoiJpaMasterPolicyDTO> dto);

	/**
	 * 
	 * @return List<DoiJPAMasterPolicy>
	 */
	public List<DoiJpaMasterPolicyDTO> findAll(DoiJpaMasterPolicyDTO dto);
	
	/**
	 * 
	 * @return
	 */
	public List<DoiJpaMasterPolicyDTO> deleteByPolicyId(Long schemeId);

	/**
	 * 
	 * @return
	 */
	public List<DoiJpaMasterPolicyDTO> findBySchemeId(Long schemeId);
	/**
	 * 
	 * @return
	 */
	public List<DoiJpaSchemeMasterDTO> getAllSchemes();
	/**
	 * 
	 * @return
	 */
	public List<DoiCommonLookUpInfoDTO> getAllPolicyTypes();
	/**
	 * 
	 * @return
	 */
	public List<DoiCommonLookUpInfoDTO> getAllStatus();

	public PagebleDTO<DoiJpaMasterPolicyDTO> getJpaPolicyMasterPage(PageDetails pageDetail) throws CustomException;

	


}
