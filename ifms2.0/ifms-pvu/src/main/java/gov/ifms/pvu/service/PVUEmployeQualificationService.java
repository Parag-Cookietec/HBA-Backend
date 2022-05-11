package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.dto.EmployeeChangeType;
import gov.ifms.pvu.dto.PVUEmployeCCCExamDetailView;
import gov.ifms.pvu.dto.PVUEmployeDeptExamDetailsView;
import gov.ifms.pvu.dto.PVUEmployeLangExamView;
import gov.ifms.pvu.dto.PVUEmployeQualificationView;
import gov.ifms.pvu.dto.PVUEmployeeQualificationDtos;
import gov.ifms.pvu.dto.PVUEmployeeQualificationUpdateDtos;
import gov.ifms.pvu.entity.PVUEmployeQualificationEntity;

/**
 * The Class PVUEmployeQualificationService.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:11:13
 *
 */
public interface PVUEmployeQualificationService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployeQualificationEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeQualificationEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeQualificationEntity getEmployeQualification(Long id);

	/**
	 * Saves a given PVUEmployeQualificationEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param dtos the entity
	 * @return the saved PVUEmployeQualificationEntity
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeeQualificationDtos saveOrUpdateEmployeQualification(PVUEmployeeQualificationDtos dtos)
			throws CustomException;

	/**
	 * Fetch all the PVUEmployeQualification items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeQualificationDto>
	 * @throws CustomException the custom exception
	 */
//	public PagebleDTO<PVUEmployeQualificationDto> getEmployeQualifications(PageDetails pageDetail)
//			throws CustomException;

	/**
	 * Gets the employe qualification by emp id.
	 *
	 * @param id the id
	 * @return the employe qualification by emp id
	 * @throws CustomException 
	 */
	public PVUEmployeeQualificationDtos getEmployeQualificationByEmpId(Long id) throws CustomException;

	/**
	 * Update qualification active status.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	public void updateQualificationActiveStatus(Long id, int activeStatus) throws CustomException;

	/**
	 * Update dept exam active status.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	void updateDeptExamActiveStatus(Long id, int activeStatus) throws CustomException;

	/**
	 * Update ccc exam active status.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	public void updateCccExamActiveStatus(Long id, int activeStatus) throws CustomException;

	/**
	 * Update lang exam active status.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	public void updateLangExamActiveStatus(Long id, int activeStatus) throws CustomException;
	
	public PVUEmployeeQualificationUpdateDtos editEmployeQualification(PVUEmployeeQualificationUpdateDtos dto, EmployeeChangeType type) throws CustomException;
	
	public List<PVUEmployeQualificationView> getHistoryOfEmpQulifictionByEmpId(IdDto idDtod) throws CustomException;
	
	public List<PVUEmployeDeptExamDetailsView> getHistoryOfEmpDeptExamDetailsByEmpId(IdDto idDtod) throws CustomException;
	
	public List<PVUEmployeCCCExamDetailView> getHistoryOfEmpCceDeptExamDetailsByEmpId(IdDto idDtod) throws CustomException;
	
	public List<PVUEmployeLangExamView> getHistoryOfEmpLngDeptExamDetailsByEmpId(IdDto idDtod) throws CustomException ;
}
