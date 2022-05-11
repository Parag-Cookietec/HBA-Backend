package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPAddDesignationSearchViewDto;
import gov.ifms.edp.dto.EDPEmpPostDsgnView;
import gov.ifms.edp.dto.EDPMsDesignationDto;
import gov.ifms.edp.dto.EDPTrnUpdDsgnDto;
import gov.ifms.edp.dto.EDPUpdateDesignationDetailsDto;
import gov.ifms.edp.dto.EDPUpdateDesignationSearchViewDto;
import gov.ifms.edp.entity.EDPMsDesignationEntity;

/**
 * The Interface EDPMsDesignationService.
 */
public interface EDPMsDesignationService {

	/**
	 * Returns all instances of the EDPMsDesignationEntity type.
	 * 
	 * @return all EDPMsDesignationEntity
	 */
	List<EDPMsDesignationEntity> getMsDesignations();

	/**
	 * Retrieves an EDPMsDesignationEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsDesignationEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsDesignationDto getMsDesignation(Long id);

	/**
	 * Saves a given EDPMsDesignationEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param desigDto the desig dto
	 * @return the saved EDPMsDesignationEntity
	 * @throws CustomException the custom exception
	 */
	EDPMsDesignationDto saveDesignation(EDPMsDesignationDto desigDto) throws CustomException;

	/**
	 * Saves all given EDPMsDesignationEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsDesignationEntity> saveMsDesignations(List<EDPMsDesignationEntity> entities);

	/**
	 * Deletes the EDPMsDesignationEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @throws CustomException the custom exception
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsDesignation(Long id) throws CustomException;

	/**
	 * Fetch all the EDPMsDesignation items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsDesignationDto>
	 */
	PagebleDTO<EDPMsDesignationDto> edpMsDesignationAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * Fetch all the Active EDPMsDesignation.
	 *
	 * @return List<EDPMsDesignationDto>
	 */
	List<EDPMsDesignationEntity> findactiveedpMsDesignation();

	/**
	 * Gets the update designation details dto.
	 *
	 * @param officeId the office id
	 * @return the update designation details dto
	 * @throws CustomException the custom exception
	 */
	EDPUpdateDesignationDetailsDto getUpdateDesignationDetailsDto(Long officeId) throws CustomException;

	/**
	 * Update dsgn delete.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	boolean updateDsgnDelete(Long id);

	/**
	 * Gets the upd dsgn by id.
	 *
	 * @param id the id
	 * @return the upd dsgn by id
	 * @throws CustomException the custom exception
	 */
	EDPTrnUpdDsgnDto getUpdDsgnById(Long id) throws CustomException;

	/**
	 * Search listfor upd dsg.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<EDPUpdateDesignationSearchViewDto> searchListforUpdDsg(PageDetails pageDetail) throws CustomException;

	/**
	 * Search listfor add designation.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPAddDesignationSearchViewDto> searchListforAddDesignation(PageDetails pageDetail)
			throws CustomException;
	
	/**
	 * Gets the post details by designtion id.
	 *
	 * @param dto the dto
	 * @return the post details by designtion id
	 * @throws CustomException the custom exception
	 */
	ClueDto getPostDetailsByDesigntionId(ClueDto dto) throws CustomException;
	
	/**
	 * Gets the designation list.
	 *
	 * @return the designation list
	 */
	public List<ClueDto> getDesignationList();
	
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

	/**
	 * Update designation.
	 *
	 * @param entity the entity
	 * @param isCreate the is create
	 * @param isUpdate the is update
	 * @param dto the dto
	 * @return the EDP trn upd dsgn dto
	 * @throws CustomException the custom exception
	 */
	EDPTrnUpdDsgnDto updateDesignation(boolean isCreate, boolean isUpdate,
			EDPTrnUpdDsgnDto dto) throws CustomException;

	/**
	 * Checks if is workflow required for update.
	 *
	 * @return the boolean
	 */
	Boolean isWorkflowRequiredForUpdate();

	/**
	 * Gets the listing filter data for upd.
	 *
	 * @return the listing filter data for upd
	 */
	ClueDto getListingFilterDataForUpd();

	/**
	 * Gets the active post for emp in office.
	 *
	 * @param officeId the office id
	 * @param empNo the emp no
	 * @return the active post for emp in office
	 * @throws CustomException the custom exception
	 */
	List<EDPEmpPostDsgnView> getActivePostForEmpInOffice(Long officeId, String empNo) throws CustomException;

	/**
	 * Check update designation request exists.
	 *
	 * @param postId the post id
	 * @throws CustomException the custom exception
	 */
	void checkUpdateDesignationRequestExists(Long postId) throws CustomException;
	
}
