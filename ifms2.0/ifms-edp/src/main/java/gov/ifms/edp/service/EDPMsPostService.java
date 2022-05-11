package gov.ifms.edp.service;

import java.util.List;
import java.util.Set;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPPostCountDTO;
import gov.ifms.edp.dto.EDPPostHistoryReportView;
import gov.ifms.edp.dto.EDPPostOfficeDetailsDto;
import gov.ifms.edp.dto.EDPPostSearchView;
import gov.ifms.edp.entity.EDPMsPostEntity;

/**
 * The Interface EDPMsPostService.
 */
public interface EDPMsPostService {

	/**
	 * Returns all instances of the EDPMsPostEntity type.
	 * 
	 * @return all EDPMsPostEntity
	 */
	List<EDPMsPostEntity> getMsPosts();

	/**
	 * Retrieves an EDPMsPostEntity by its id.
	 *
	 * @param idDto the id dto
	 * @return the EDPMsPostEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsPostDto getMsPost(IdDto idDto);

	/**
	 * Saves a given EDPMsPostEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved EDPMsPostDto
	 * @throws CustomException the custom exception
	 */
	EDPMsPostDto saveMsPost(EDPMsPostDto dto) throws CustomException;

	/**
	 * Saves a given EDPMsPostEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved EDPMsPostDto
	 * @throws CustomException the custom exception
	 */
	EDPMsPostDto updateMsPost(EDPMsPostDto dto) throws CustomException;

	/**
	 * Saves all given EDPMsPostEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsPostEntity> saveMsPosts(List<EDPMsPostEntity> entities);

	/**
	 * Fetch all the EDPMsPost items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsPostDto>
	 */
	PagebleDTO<EDPMsPostDto> edpMsPostAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * Fetch All EDPMspost BY postID.
	 *
	 * @param idList the id list
	 * @return the EDP ms post by post id
	 */
	List<EDPMsPostEntity> getEDPMsPostByPostId(Set<Long> idList);

	/**
	 * Fetch office details.
	 *
	 * @return the post andofficedetails
	 */

	EDPPostOfficeDetailsDto getpostAndofficedetails();

	/**
	 * Search listfor posts.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<EDPPostSearchView> searchListforPosts(PageDetails pageDetail) throws CustomException;

	/**
	 * Delete ms post.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	public void deleteMsPost(Long id) throws CustomException;

	/**
	 * Gets the post count.
	 *
	 * @param countDto the count dto
	 * @return the post count
	 */
	public EDPPostCountDTO getPostCount(EDPPostCountDTO countDto);

	/**
	 * Avilable vacant post.
	 *
	 * @param idDto the id dto
	 * @return the list
	 */
	EDPPostOfficeDetailsDto avilableVacantPost(IdDto idDto);

	/**
	 * Search for post history report.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<EDPPostHistoryReportView> searchForPostHistoryReport(PageDetails pageDetail) throws CustomException;

	/**
	 * Checks if is workflow required.
	 *
	 * @return the boolean
	 */
	Boolean isWorkflowRequired();

	/**
	 * Gets the listing filter data.
	 *
	 * @return the listing filter data
	 */
	ClueDto getListingFilterData();
	

}
