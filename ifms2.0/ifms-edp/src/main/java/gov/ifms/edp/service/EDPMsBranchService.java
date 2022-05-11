package gov.ifms.edp.service;

import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPBrDtlDto;
import gov.ifms.edp.dto.EDPBranchCrViewDto;
import gov.ifms.edp.dto.EDPEmployeePostView;
import gov.ifms.edp.dto.EDPMsBranchDto;
import gov.ifms.edp.dto.EDPTedpBrDtlDto;
import gov.ifms.edp.dto.EDPTedpBrHdrDto;
import gov.ifms.edp.dto.EDPUsrBrMapSearchView;
import gov.ifms.edp.entity.EDPMsBranchEntity;

/**
 * The Interface EDPMsBranchService.
 */
public interface EDPMsBranchService {
	
	/**
	 * Gets the branch listby branch type.
	 *
	 * @param branchTypeId the branch type id
	 * @return the branch listby branch type
	 */
	List<EDPMsBranchEntity> getBranchListbyBranchType(Long branchTypeId);
	
	/**
	 * Find all active branches.
	 *
	 * @return the list
	 */
	List<EDPMsBranchDto> findAllActiveBranches();
	
	/**
	 * Gets the branch data.
	 *
	 * @return the branch data
	 */
	List<ClueDto> getBranchData();

	/**
	 * Save branch.
	 *
	 * @param hdrDto the hdr dto
	 * @return the object
	 * @throws CustomException the custom exception
	 */
	EDPTedpBrHdrDto saveBranch(EDPTedpBrHdrDto hdrDto) throws CustomException;
	

	/**
	 * Gets the branch request type.
	 *
	 * @return the branch request type
	 */
	List<ClueDto> getBranchRequestType();

	/**
	 * Gets the emp post in office.
	 *
	 * @param officeId the office id
	 * @return the emp post in office
	 * @throws CustomException the custom exception
	 */
	List<EDPEmployeePostView> getEmpPostInOffice(Long officeId) throws CustomException;
	
	/**
	 * Search list.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<EDPBranchCrViewDto> searchList(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the branches for office.
	 *
	 * @return the branches for office
	 */
	List<ClueDto> getBranchesForOffice();

	/**
	 * Gets the emp mapped branches.
	 *
	 * @param pouId the pou id
	 * @return the emp mapped branches
	 * @throws CustomException the custom exception
	 */
	EDPBrDtlDto getEmpMappedBranches(Long pouId) throws CustomException;

	/**
	 * Save branch mapping.
	 *
	 * @param hdrDto the hdr dto
	 * @return the EDP br dtl hdr dto
	 * @throws CustomException the custom exception
	 */
	EDPTedpBrDtlDto saveBranchMapping(EDPTedpBrDtlDto hdrDto) throws CustomException;
	
	/**
	 * Delete branch cr request.
	 *
	 * @param hdrId the hdr id
	 * @throws CustomException the custom exception
	 */
	void deleteBranchCrRequest(Long hdrId) throws CustomException;

	/**
	 * Gets the search filter.
	 *
	 * @return the search filter
	 */
	ClueDto getSearchFilter();

	/**
	 * Search listfor br map.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<EDPUsrBrMapSearchView> getBranchMappingList(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the br map dtl by hdr.
	 *
	 * @param hdrId the hdr id
	 * @return the br map dtl by hdr
	 * @throws CustomException the custom exception
	 */
	EDPTedpBrDtlDto getBrMapDtlByHdr(Long hdrId) throws CustomException;

	/**
	 * Delete br map request.
	 *
	 * @param hdrId the hdr id
	 * @throws CustomException the custom exception
	 */
	void deleteBrMapRequest(Long hdrId) throws CustomException;

	/**
	 * Check for existing request.
	 *
	 * @param pouId the pou id
	 * @throws CustomException the custom exception
	 */
	void checkForExistingRequest(Long pouId) throws CustomException;

	/**
	 * Check user access.
	 *
	 * @param fromPouId the from pou id
	 * @param toPouId the to pou id
	 * @return the list
	 */
	Map<String, Object> checkUserAccess(Long fromPouId, Long toPouId);
	

	/**
	 * Gets the branch listby branch type.
	 *
	 * @param branchTypeId the branch type id
	 * @return the branch listby branch type
	 */
	List<EDPMsBranchEntity> getBranchListbyBranchTypeAndOfficeId(Long branchTypeId);

}
