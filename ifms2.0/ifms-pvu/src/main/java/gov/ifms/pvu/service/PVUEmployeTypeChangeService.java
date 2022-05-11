
package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.dto.PVUEmployeTypeChangeDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeListingSPDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeSPDto;

/**
 * The Class PVUEmployeTypeChangeService.
 *
 * @version v 2.0
 * @created 2020/04/20 12:05:07
 *
 */
public interface PVUEmployeTypeChangeService {
	/**
	 * Retrieves an PVUEmployeeTypeChangeDto by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeeTypeChangeDto with the given id or {@literal null} if none
	 *         found
	 * @throws CustomException 
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public List<PVUEmployeeTypeSPDto> getEmployeeDetails(PVUEmployeTypeChangeDto id) throws CustomException;
	/**
	 * Saves a given PVUEmployeEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the entity
	 * @return the saved PVUEmployeEntity
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeTypeChangeDto saveOrUpdateEmploye(PVUEmployeTypeChangeDto dto) throws CustomException;
	
	/**
	 *getEmployeTypeChange method gets the employee Data
	 *
	 * @param dto 
	 * @return the saved PVUEmployeTypeChangeDto
	 */
	public PVUEmployeTypeChangeDto getEmployeTypeChange(PVUEmployeTypeChangeDto id);
	
	/**
	 *deleteEmployeTypeChange method deletes the records
	 *
	 * @param dto 
	 */
	public void deleteEmployeTypeChange(IdDto id);
	
	/**
	 *fetchEmpTypeChange method gets data for listing
	 *
	 * @param dto 
	 * @return list od records
	 */
	public List<PVUEmployeeTypeListingSPDto> fetchEmpTypeChange(PVUEmployeTypeChangeDto dto) throws CustomException;
	
	/**
	 *getEmployeTypeChange method gets the employee Data
	 *
	 * @param empId 
	 * @return the saved PVUEmployeeTypeDto
	 */
	public PVUEmployeeTypeDto findEmployeeOfficedetails(Long empId);

}
