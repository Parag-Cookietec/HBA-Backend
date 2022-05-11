package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPOfficeItrDto;
import gov.ifms.edp.dto.EDPOfficeItrView;
import gov.ifms.edp.dto.EDPOfficeSummaryDDODto;
import gov.ifms.edp.dto.EDPOfficeSummaryDto;
import gov.ifms.edp.entity.EDPOfficeItrEntity;

/**
 * The Interface EDPOfficeItrService.
 */
public interface EDPOfficeItrService {
	/**
	 * Retrieves an EDPEdpOfficeItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPEdpOfficeItrEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPOfficeItrEntity getEdpOfficeItr(Long id);

	/**
	 * Saves a given EDPEdpOfficeItrEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPEdpOfficeItrEntity
	 * @throws CustomException the custom exception
	 */
	public EDPOfficeItrEntity saveOrUpdateEdpOfficeItr(EDPOfficeItrEntity entity) throws CustomException;

	/**
	 * Saves all given EDPEdpOfficeItrEntity entities.
	 *
	 * @param id       the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteEdpOfficeItr(String trnNumber) throws CustomException;

	/**
	 * Fetch all the EDPEdpOfficeItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPEdpOfficeItrDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeItrDto> getEdpOfficeItrs(PageDetails pageDetail) throws CustomException;

	/**
	 * List edp offices.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeItrView> listEdpOffices(PageDetails pageDetail) throws CustomException;

	/**
	 * Update list edp office.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeSummaryDto> summaryListEdpOffice(PageDetails pageDetail) throws CustomException;

	/**
	 * Search summary list DDO office.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeSummaryDDODto> searchSummaryListDDOOffice(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Search summary list DDO office.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeSummaryDDODto> searchSummaryListDDOOfficeDetail(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Retrieves an EDPEdpOfficeItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsOfficeDto with the given id or {@literal null} if
	 *         none found
	 * @throws CustomException 
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsOfficeDto getEdpOfficeItr(String trnNo) throws CustomException;
	
	/**
	 * List edp update offices.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeItrView> listEdpUpdateOffices(PageDetails pageDetail) throws CustomException;
	
}
