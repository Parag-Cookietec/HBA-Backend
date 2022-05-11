package gov.ifms.pvu.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;

/**
 * The Class PVUEmployeeEventStatusController.
 */
public interface PVUEmployeeEventStatusService {
	/**
	 * Retrieves an PVUEmployeeEventStatusEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeeEventStatusEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeeEventStatusEntity getEmployeeEventStatus(Long id);

	/**
	 * Saves a given PVUEmployeeEventStatusEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeeEventStatusEntity
	 */
	public PVUEmployeeEventStatusEntity saveOrUpdateEmployeeEventStatus(PVUEmployeeEventStatusEntity entity);

	/**
	 * Find by emp id.
	 *
	 * @param empId the emp id
	 * @return the PVU employee event status entity
	 */
	public Optional<PVUEmployeeEventStatusEntity> findByEmpId(long empId);

	/**
	 * Find by emp id.
	 *
	 * @param empId the emp id
	 * @return the PVU employee event status entity
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeeEventStatusEntity findOneByEmpId(long empId) throws CustomException;

	/**
	 * Gets the event status.
	 *
	 * @param pvuEmployeeEventStatusEntity the pvu employee event status entity
	 * @return the event status
	 */
	public PVUEmployeeEventStatusDto getEventStatus(PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity);

	/**
	 * Reset inc employee event status.
	 *
	 * @param trnId the trn id
	 */
	public void resetIncEmployeeEventStatus(Long trnId, Date updatedDate);

	/**
	 * Gets the employee in process by emp ids.
	 *
	 * @param lstEmpIncludeList the lst emp include list
	 * @return the employee in process by emp ids
	 */
	public List<PVUEmployeeEventStatusDto> getEmployeeInProcessByEmpIds(List<Long> lstEmpIncludeList);

	/**
	 * Update employee inc event status.
	 *
	 * @param trnNo             the trn no
	 * @param lstEmpIncludeList the lst emp include list
	 */
	public void updateEmployeeIncEventStatus(String trnNo, List<Long> lstEmpIncludeList);

	/**
	 * In progress any event.
	 *
	 * @param employeeId the employee id
	 * @return PVUEmployeeEventStatusEntity entity
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeeEventStatusEntity inProgressAnyEvent(Long employeeId) throws CustomException;

    public PVUEmployeeEventStatusEntity inProgressSuspensionEvent(Long employeeId) throws CustomException;

	/**
	 * Find PVU employee status dto.
	 *
	 * @param empId the emp id
	 * @return the PVU employee event status dto
	 */
	public PVUEmployeeEventStatusDto findPVUEmployeeStatusDto(Long empId);

	/**
	 * Update event info.
	 *
	 * @param statusEntry the status entry
	 * @param trnNo       the trn no
	 */
	public void updateEventInfo(PVUEmployeeEventStatusEntity statusEntry, String trnNo);

	/**
	 * Reset in progress employee event status.
	 *
	 * @param empId        the emp id
	 * @param updateByPost the update by post
	 */
	public void resetInProgressEmployeeEventStatus(Long empId, Long updateByPost);

	/**
	 * Reset in progress event status by trans no.
	 *
	 * @param trnNo             the trn no
	 * @param currentUserUserId the current user user id
	 * @param date              the date
	 */
	public void resetInProgressEventStatusByTransNo(String trnNo, long updatedBy);

	/**
	 * Gets the employee in process by emp ids in other trans.
	 *
	 * @param lstEmpIncludeList the lst emp include list
	 * @param trnNo the trn no
	 * @return the employee in process by emp ids in other trans
	 */
	public List<PVUEmployeeEventStatusDto> getEmployeeInProcessByEmpIdsInOtherTrans(List<Long> lstEmpIncludeList,
			String trnNo);

	/**
	 * Reset employee inc event status.
	 *
	 * @param trnNo the trn no
	 * @param lstEmpExcludeList the lst emp exclude list
	 */
	public void resetEmployeeIncEventStatus(String trnNo, List<Long> lstEmpExcludeList);

	/**
	 * In progress any event by trn no.
	 *
	 * @param employeeId the employee id
	 * @param trnNo the trn no
	 * @return the PVU employee event status entity
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeeEventStatusEntity inProgressAnyEventByTrnNo(Long employeeId, String trnNo) throws CustomException;
}
