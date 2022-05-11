package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPHeaderParam;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPPostMapDto;
import gov.ifms.edp.dto.EDPUserPostDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsHeaderDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsSearchViewDto;

/**
 * The Interface EDPMsUserPostMappingService.
 */
public interface EDPMsUserPostMappingService {

	/**
	 * Gets the post user mapping by header id.
	 *
	 * @param edpUsrTrnHeaderId the edp usr trn header id
	 * @return the post user mapping by header id
	 * @throws CustomException the custom exception
	 */
	public EDPUsrPoTrnsHeaderDto getPostUserMappingByHeaderId(Long edpUsrTrnHeaderId) throws CustomException;

	/**
	 * Creates the UP mapping attachment.
	 *
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public EDPUsrPoTrnsHeaderDto createUserPostMapping(EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto)
			throws CustomException;

	/**
	 * Delete UP mapping attachment.
	 *
	 * @param headerId the header id
	 * @throws CustomException the custom exception
	 */
	void deleteUPMapping(Long headerId) throws CustomException;

	/**
	 * Downloadcreate UP mapping attachment files.
	 *
	 * @param dto the dto
	 * @return the resource
	 * @throws CustomException the custom exception
	 */

	EDPUserPostDto getPostDetailsByEmpNo(EDPIdDto dto) throws CustomException;

	/**
	 * Change post.
	 *
	 * @param dto the dto
	 * @return the EDP user post dto
	 * @throws CustomException the custom exception
	 */
	Boolean changePost(EDPIdDto dto) throws CustomException;

	/**
	 * Gets the vacant post.
	 *
	 * @param idDto the id dto
	 * @return the vacant post
	 * @throws CustomException the custom exception
	 */
	public List<EDPPostMapDto> getVacantPost(EDPIdDto idDto) throws CustomException ;

	/**
	 * Search listfor upd dsg.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<EDPUsrPoTrnsSearchViewDto> searchListforUpdDsg(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Gets the approve post user mapping by header id.
	 *
	 * @param edpUsrTrnHeaderId the edp usr trn header id
	 * @return the approve post user mapping by header id
	 * @throws CustomException the custom exception
	 */
	public EDPUsrPoTrnsHeaderDto getApprovePostUserMappingByHeaderId(Long edpUsrTrnHeaderId) throws CustomException;

	/**
	 * Gets the submit popup details.
	 *
	 * @param headerId the header id
	 * @return the submit popup details
	 * @throws CustomException the custom exception
	 */
	List<EDPHeaderParam> getSubmitPopupDetails(Long headerId) throws CustomException;

	/**
	 * Checks if is workflow required.
	 *
	 * @param officeId the office id
	 * @param userId the user id
	 * @return the boolean
	 */
	Boolean isWorkflowRequired(Long officeId, Long userId);
	
	
	/**
	 * Gets the listing filter data.
	 *
	 * @return the listing filter data
	 */
	ClueDto getListingFilterData();

}
