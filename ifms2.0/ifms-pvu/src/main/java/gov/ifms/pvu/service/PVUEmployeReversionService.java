package gov.ifms.pvu.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeReversionDto;
import gov.ifms.pvu.dto.PVUReversionPayLelevView;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeReversionEntity;

/**
 * The Class PVUEmployeReversionEventController.
 *
 * @version v 1.0
 * @created 2019/12/20 11:11:57
 *
 */
public interface PVUEmployeReversionService extends PVUBaseService {

	/**
	 * Retrieves an PVUEmployeReversionEventEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeReversionEventEntity with the given id or
	 *         {@literal null} if none found
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeReversionEntity getPVUEmployeReversionEvent(Long id) throws CustomException;

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

	/**
	 * Save or update PVU employe reversion event.
	 *
	 * @param dto the dto
	 * @return the PVU employe reversion entity
	 * @throws CustomException the custom exception
	 */
	PVUEmployeReversionEntity saveOrUpdatePVUEmployeReversionEvent(PVUEmployeReversionDto dto) throws CustomException;

	/**
	 * Insert reversion itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU employe reversion dto
	 * @throws CustomException the custom exception
	 */
	PVUEmployeReversionDto insertReversionItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

	/**
	 * Gets the employee check pay level by emp id.
	 *
	 * @param id the id
	 * @param payCommisionId the pay commision id
	 * @param effectiveDate the effective date
	 * @return the employee check pay level by emp id
	 * @throws CustomException the custom exception
	 */
	List<PVUReversionPayLelevView> getEmployeeCheckPayLevelByEmpId(Long id, Long payCommisionId, LocalDate effectiveDate) throws CustomException;

	/**
	 * Gets the pay commition details.
	 *
	 * @param param the param
	 * @return the pay commition details
	 */
	PVUReversionPayLelevView getPayCommitionDetails(Map<String, Object> param);
	
	/**
	 * Generate print endorsement.
	 *
	 * @param dto the dto
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws CustomException the custom exception
	 * @throws DocumentException the document exception
	 */
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException;
	
	/**
	 * Delete by id.
	 *
	 * @param dto the dto
	 */
	void deleteById(IdDto dto);

	/**
	 * Gets the available class for emp.
	 *
	 * @param request the request
	 * @return the available class for emp
	 * @throws CustomException 
	 */
	Map<String, List<PVUEmployeCreationDDLView>> getAvailableClassForEmp(Long employeeId) throws CustomException;

}
