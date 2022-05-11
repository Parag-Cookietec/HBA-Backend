package gov.ifms.pvu.service;

import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUIncrementCreateListView;
import gov.ifms.pvu.dto.PVUIncrementEditListView;
import gov.ifms.pvu.dto.PVUIncrementEventDto;
import gov.ifms.pvu.dto.PVUIncrementListView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;

/**
 * The Class PVUIncrementEventController.
 * 
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 *
 */
public interface PVUIncrementEventService {
	/**
	 * Retrieves an PVUIncrementEventEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUIncrementEventEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUIncrementEventEntity getIncrementEvent(Long id);

	/**
	 * Saves a given PVUIncrementEventEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUIncrementEventEntity
	 * @throws CustomException the custom exception
	 */
	public PVUIncrementEventEntity saveOrUpdateIncrementEvent(PVUIncrementEventEntity entity) throws CustomException;

	/**
	 * Fetch all the PVUIncrementEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUIncrementEventDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUIncrementCreateListView> getIncrementCreateIncludeExcludeEvents(PageDetails pageDetail)
			throws CustomException;

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @param procedureName the procedure name
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getLookUpInfoAsMap(String procedureName) throws CustomException;

	/**
	 * Gets the increment list events.
	 *
	 * @param pageDetail the page detail
	 * @return the increment list events
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUIncrementListView> getIncrementListEvents(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the increment event emp summary.
	 *
	 * @param id the id
	 * @return the increment event emp summary
	 */
	public PVUIncrementEventDto getIncrementEventEmpSummary(Long id);

	/**
	 * Save or update increment event emp summary.
	 *
	 * @param dto the dto
	 * @return the PVU increment event dto
	 * @throws CustomException the custom exception
	 */
	public PVUIncrementEventDto saveOrUpdateIncrementEventEmpSummary(PVUIncrementEventDto dto) throws CustomException;

	/**
	 * Gets the increment edit events.
	 *
	 * @param pageDetail the page detail
	 * @return the increment edit events
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUIncrementEditListView> getIncrementEditEvents(PageDetails pageDetail) throws CustomException;

	/**
	 * Insert increment itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU common response
	 * @throws CustomException the custom exception
	 */
	public PVUIncrementEventDto insertIncrementItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

	/**
	 * Insert increment itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU common response
	 */
	public Boolean approveRejectIncrementEvent(PvuWFWrapperDto pvuWFWrapperDto);

	/**
	 * Delete increment trns.
	 *
	 * @param idDto the id dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public boolean deleteIncrementTrns(IdDto idDto) throws CustomException;

	/**
	 * Validate increment submit.
	 *
	 * @param dto the dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public Boolean validateIncrementSubmit(PVUIncrementEventDto dto) throws CustomException;

}
