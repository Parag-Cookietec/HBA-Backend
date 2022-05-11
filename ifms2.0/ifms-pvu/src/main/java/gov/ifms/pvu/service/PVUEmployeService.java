
package gov.ifms.pvu.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.SearchDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.dto.response.PVUPairView;
import gov.ifms.pvu.entity.PVUEmployeEntity;

/**
 * The Class PVUEmployeService.
 *
 * @version v 1.0
 * @created 2019/11/20 12:05:07
 *
 */
public interface PVUEmployeService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployeEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeEntity getEmploye(Long id);

	/**
	 * Retrieves an PVUEmployeEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeEntity getActiveEmployee(Long id, int activeStatus) throws CustomException;

	/**
	 * Saves a given PVUEmployeEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the entity
	 * @return the saved PVUEmployeEntity
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeeDtos saveOrUpdateEmploye(PVUEmployeeDtos dto) throws CustomException;

	/**
	 * Fetch all the PVUEmploye items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUEmployeAddressView> getEmployes(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the all employe events.
	 *
	 * @param pageDetail the page detail
	 * @return the all employe events
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUCommonEmployeView> getAllCommonEmploye(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

	/**
	 * Gets the employee details.
	 *
	 * @param id the id
	 * @return the employee details
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeeDtos getEmployeeDetails(Long id) throws CustomException;

	/**
	 * Gets the employe look up info.
	 *
	 * @return the employe look up info
	 */
	public PVUEmployeDetailsDto getEmployeLookUpInfo();

	/**
	 * Gets the employee lookup and master info.
	 *
	 * @return the employee lookup info
	 */
	public PvuLookupInfoDto getPvuLookupInfo();

	/**
	 * This is cache method to set all lookup and master to DTO object.
	 * @return PvuLookupInfoDto
	 */
	public PvuLookupInfoDto getPvuLookupInfoDto();

	/**
	 * This is cache method to get Hod department DTO object.
	 * @return PVUEmployeDetailsDto
	 */
	public List<EDPSDTDto> getHODDepartments();

	/**
	 * This is evict cache method to flush HOD data.
	 */
	public boolean evictHODDepartmentsCache();

	/**
	 * Gets the common response by id.
	 *
	 * @param dto the dto
	 * @return the common response by id
	 * @throws CustomException the custom exception
	 */
	PVUCommonResponse getCommonResponseById(IdDto dto) throws CustomException;

	/**
	 * Gets the emp by emp number.
	 *
	 * @param id the field value
	 * @return the emp by emp number
	 * @throws CustomException the custom exception
	 */
	public PVUCommonResponse getEmpByEmpNumber(Long id) throws CustomException;

	/**
	 * Gets the DDL lu look up info as map.
	 *
	 * @return the DDL lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getDDLLuLookUpInfoAsMap() throws CustomException;

	/**
	 * Gets the office type by edp id.
	 *
	 * @param id the id
	 * @return the office type by edp id
	 * @throws CustomException the custom exception
	 */
	public List<PVUEmployeCreationDDLView> getOfficeTypeByEdpId(Long id) throws CustomException;

	/**
	 * Update active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	public void updateActiveStatus(Long id, int activeStatus) throws CustomException;

	/**
	 * Validate pan number.
	 *
	 * @param fieldValue the field value
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	Boolean validatePanNumber(String fieldValue) throws CustomException;

	/**
	 * Gets the duplicate pan no detail.
	 *
	 * @param fieldValue the field value
	 * @return the duplicate pan no detail
	 * @throws CustomException the custom exception
	 */
	PVUCommonResponse getDuplicatePanNoDetail(String fieldValue) throws CustomException;

	/**
	 * Gets the employee WF history by emp id.
	 *
	 * @param id the id
	 * @return the employee WF history by emp id
	 * @throws CustomException the custom exception
	 */
	public List<PVUEmployeeWfHSTDto> getEmployeeWFHistoryByEmpId(Long id) throws CustomException;


	/**
	 * Insert employee itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU common response
	 * @throws CustomException the custom exception
	 */
	PVUCommonResponse insertEmployeeItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

	/**
	 * Gets the auto employee number.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the auto employee number
	 * @throws CustomException the custom exception
	 */
	Boolean getAutoEmployeeNumber(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

	/**
	 * Update active status by emp id.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 */
	public void updateActiveStatusByEmpId(Long id, int activeStatus);

	/**
	 * Gets the employee nominee photos by nominee id.
	 *
	 * @param string the id
	 * @return the employee nominee photos by nominee id
	 * @throws CustomException 
	 * @throws IOException 
	 */
	public ClueDto getAttachments(String string) throws CustomException, IOException;

	/**
	 * Delete employee photo by emp id.
	 *
	 * @param id the id
	 * @return the clue dto
	 * @throws CustomException 
	 * @throws IOException 
	 */
	public void deleteEmployeePhotoByEmpId(Long id) throws CustomException ;

	public void deleteNomineeAttachementsByNomineeId(PvuCommonRequest pvuCommonRequest);
	/*
	 * For Transfer get employee details by empno
	 *
	 * */
	public PVUCommonResponse getEmpByEmpNo(SearchDto dto) throws CustomException;
	
	public Map<String, Object> getEmployeeApproverNameAndDesignation(Long id) throws CustomException;
	
	public Long getEntryPaySearchEmployes(PageDetails pageDetail) throws CustomException;

	public Boolean employeUpdateAllfiled(PVUEmpDeptQualifiUpdate dto) throws CustomException;
	
	public List<PVUEmployeUpdateDto> getHistoryOfEmpDetailsByItrTabel(IdDto idDtod) throws CustomException;
	
	public List<PVUEmployeNomineeUpdateDto> getHistoryOfEmpNominiByEmpId(IdDto idDtod) throws CustomException;
	
	public List<PVUEmployeAddressUpdateDto> getHistoryOfEmpAddressByEmpId(IdDto idDtod) throws CustomException;

	public List<PVUPairView> getOfficeNameByOfficeType(IdDto idDtod) throws CustomException;

}
