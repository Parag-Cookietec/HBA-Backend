package gov.ifms.pvu.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeSuspensionDto;
import gov.ifms.pvu.dto.PVUEmployeSuspensionView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;


/**
 * The Class PVUEmployeSuspensionService.
 *
 * @version 1.0
 * @created 2019/12/12 15:52:48
 *
 */
public interface PVUEmployeSuspensionService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployeSuspensionEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeSuspensionEntity with the given id or {@literal null}
	 *         if none found
	 * @throws CustomException
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeSuspensionEntity getPVUEmployeSuspension(Long id) throws CustomException;

	/**
	 * Saves a given PVUEmployeSuspensionEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeSuspensionEntity
	 * @throws CustomException
	 */
	public PVUEmployeSuspensionEntity saveOrUpdatePVUEmployeSuspension(PVUEmployeSuspensionEntity entity) throws CustomException;

	/**
	 * Fetch all the PVUEmployeSuspension items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeSuspensionDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUEmployeSuspensionView> getPVUEmployeSuspensions(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

	PVUEmployeSuspensionDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException;

	void deletePayDetail(Long id);

	PVUEmployeSuspensionEntity getOneByTrnNo(String trnNo) throws CustomException;

	public void deleteSusEventsDetails(Long id, int inactiveStatus) throws CustomException;
	
	String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException;
}
