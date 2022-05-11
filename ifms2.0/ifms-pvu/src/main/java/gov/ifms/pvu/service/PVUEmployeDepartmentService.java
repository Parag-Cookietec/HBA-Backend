package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.EmployeeChangeType;
import gov.ifms.pvu.dto.PVUEmployeDepartmentDto;
import gov.ifms.pvu.dto.PVUEmployeDepartmentDtos;
import gov.ifms.pvu.dto.PVUEmployeDepartmentUpdateDtos;
import gov.ifms.pvu.dto.PVUEmployeeDepartmentView;
import gov.ifms.pvu.dto.PVUEmployeeHistoryView;
import gov.ifms.pvu.dto.response.PVUPairView;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;

/**
 * The Class PVUEmployeDepartmentService.
 * 
 * @version v 1.0
 * @created 2019/11/21 14:17:25
 *
 */
public interface PVUEmployeDepartmentService extends PVUBaseService {

	/**
	 * Retrieves an PVUEmployeeDepartmentEntity by its id.
	 *
	 * @param dtos the dtos
	 * @return the PVUEmployeeDepartmentEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */

	/**
	 * Saves a given PVUEmployeeDepartmentEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param dtos the dtos
	 * @return the saved PVUEmployeeDepartmentEntity
	 */

	public PVUEmployeDepartmentDtos saveOrUpdateEmployeeDepartment(PVUEmployeDepartmentDtos dtos);

	/**
	 * Fetch all the PVUEmployeeDepartment items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeeDepartmentDto>
	 */
	public PagebleDTO<PVUEmployeDepartmentDto> getEmployeDepartments(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the employee department.
	 *
	 * @param id the id
	 * @return the employee department
	 */
	public PVUEmployeDepartmentDtos getEmployeeDepartment(Long id);
	
	public long getClassIdByEmpId(Long empId);
	
	public PVUEmployeDepartmentEntity getEmployeDepartmentEntityByEmpId(Long empId);
	
	public PVUEmployeDepartmentEntity saveEmployeeDepartment(PVUEmployeDepartmentEntity pvuEmployedepartmentEntity);
	
	public PVUEmployeDepartmentUpdateDtos editEmployeeDepartment(PVUEmployeDepartmentUpdateDtos dto,EmployeeChangeType type) ;
	
	public List<PVUEmployeeHistoryView> getQuerieOfHistoryOfEmpPRVHistByEmpId(IdDto idDtod) throws CustomException; 
	
	public List<PVUEmployeeDepartmentView> getQuerieOfHistoryOfEmpDepartmentByEmpId(IdDto idDtod) throws CustomException;

	public List<PVUPairView> getOfficeDetailsByCardexAndDDOAndDId(long districtId,long dooNo ,long cardexNo) throws CustomException;

}
