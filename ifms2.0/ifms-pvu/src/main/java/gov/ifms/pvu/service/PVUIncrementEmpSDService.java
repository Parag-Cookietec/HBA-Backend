package gov.ifms.pvu.service;

import com.itextpdf.text.DocumentException;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.dto.PVUIncrementEmpSDDto;
import gov.ifms.pvu.entity.PVUIncrementEmpSDEntity;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * The Class PVUIncrementEmpController.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 *
 */
public interface PVUIncrementEmpSDService {
	/**
	 * Retrieves an PVUIncrementEmpEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUIncrementEmpEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUIncrementEmpSDEntity getIncrementEmp(Long id);

	/**
	 * Saves a given PVUIncrementEmpEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUIncrementEmpEntity
	 */
	public PVUIncrementEmpSDEntity saveOrUpdateIncrementEmp(PVUIncrementEmpSDEntity entity);

	/**
	 * Save or update increment emp.
	 *
	 * @param lstPVUIncrementEmpDto the lst PVU increment emp dto
	 * @param inEventId             the in event id
	 * @return the list
	 */
	public List<PVUIncrementEmpSDDto> saveOrUpdateIncrementEmpDto(List<PVUIncrementEmpSDDto> lstPVUIncrementEmpDto);

	/**
	 * Save or update increment emp.
	 *
	 * @param lstEntity the lst entity
	 * @return the list
	 */
	public List<PVUIncrementEmpSDEntity> saveOrUpdateIncrementEmp(List<PVUIncrementEmpSDEntity> lstEntity);

	/**
	 * Gets the increment emp by event id.
	 *
	 * @param inEventId the in event id
	 * @return the increment emp by event id
	 */
	public List<PVUIncrementEmpSDDto> getIncrementEmpByEventId(Long inEventId);

	/**
	 * Delete increment emp id by event id.
	 *
	 * @param inActiveStatus the in active status
	 * @param incrementEvent the increment event
	 * @param updatedBy      the updated by
	 * @param updatedDate    the updated date
	 */
	public void deleteIncrementEmpIdByEventId(int inActiveStatus, Long incrementEvent, Date updatedDate);

	/**
	 * Delete irrelevant employee from transaction.
	 *
	 * @param inEventId the in event id
	 */
	public void deleteIrrelevantEmployeeFromTransaction(Long inEventId);
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException;
	
}
