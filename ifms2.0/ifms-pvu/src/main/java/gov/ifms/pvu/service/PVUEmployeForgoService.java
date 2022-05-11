package gov.ifms.pvu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUCommonResponse;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeForgoDto;
import gov.ifms.pvu.dto.PVUEmployeeWfHSTDto;
import gov.ifms.pvu.dto.PVUForgoView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeForgoEntity;

/**
 * The Class PVUForgoEventController.
 * 
 * @version v 1.0
 * @created 2019/12/23 11:00:23
 *
 */
public interface PVUEmployeForgoService extends PVUBaseService {
	/**
	 * Retrieves an PVUForgoEventEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUForgoEventEntity with the given id or {@literal null} if none
	 *         found
	 * @throws CustomException
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeForgoEntity getForgoEvent(Long id) throws CustomException;

	/**
	 * Saves a given PVUForgoEventEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUForgoEventEntity
	 * @throws CustomException
	 */
	public PVUEmployeForgoDto saveOrUpdateForgoEvent(PVUEmployeForgoDto dto) throws CustomException;

	/**
	 * Fetch all the PVUForgoEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUForgoEventDto>
	 */
	public PagebleDTO<PVUForgoView> getForgoEvents(PageDetails pageDetail) throws CustomException;

	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

	void submitValidation(PVUEmployeForgoDto dto) throws CustomException;



	PVUEmployeForgoDto insertEmployeeItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;





}