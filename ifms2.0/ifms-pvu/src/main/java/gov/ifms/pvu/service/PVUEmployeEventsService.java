package gov.ifms.pvu.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmpEventsResponse;
import gov.ifms.pvu.dto.PVUEmpEventsRevisedRegularTab;
import gov.ifms.pvu.dto.PVUEmpTrnEventTabView;
import gov.ifms.pvu.dto.PVUEmployeEventView;
import gov.ifms.pvu.dto.PVUEmployeFifthPayEventView;
import gov.ifms.pvu.dto.PVUEmployeJoinPayEventView;
import gov.ifms.pvu.dto.PVUEmployeSixPayEventView;
import gov.ifms.pvu.dto.PVUEmployeSusEolView;
import gov.ifms.pvu.dto.PVUEmployeeSevenPayEventView;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;

/**
 * The Class PVUEmployeEventsService.
 *
 * @version v 1.0
 * @created 2019/12/03 03:14:53
 */
public interface PVUEmployeEventsService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployeEventsEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeEventsEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	PVUEmployeEventsEntity getEmployeEvents(Long id);

	/**
	 * Saves a given PVUEmployeEventsEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeEventsEntity
	 */
	PVUEmployeEventsEntity saveOrUpdateEmployeEvents(PVUEmployeEventsEntity entity);

	/**
	 * Fetch all the PVUEmployeEvents items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeEventsDto>
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<PVUEmployeEventView> getEmployeEventss(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the employee check pay level by emp id.
	 *
	 * @param id the id
	 * @return the employee check pay level by emp id
	 * @throws CustomException the custom exception
	 */
	List<Object> getEmployeeCheckPayLevelByEmpId(Long id) throws CustomException;

	/**
	 * Gets the list of event exists on date or after.
	 *
	 * @param employeeId the employee id
	 * @param eventIds   the event ids
	 * @param after      the after
	 * @return the list of event exists on date or after
	 */
	List<PVUEmployeEventsEntity> getListOfEventExistsOnDateOrAfter(Long employeeId, List<Long> eventIds,
			LocalDate after);

	/**
	 * Gets the all events after date.
	 *
	 * @param employeeId the employee id
	 * @param after      the after
	 * @return the all events after date
	 */
	List<PVUEmployeEventsEntity> getAllEventsAfterDate(Long employeeId, LocalDate after);

	/**
	 * Find one by emp id and event name.
	 *
	 * @param employeeId the employee id
	 * @param eventName  the event name
	 * @return the PVU employe events entity
	 */
	PVUEmployeEventsEntity findOneByEmpIdAndEventName(Long employeeId, String eventName);

	/**
	 * Exists from to.
	 *
	 * @param employeeId the employee id
	 * @param eventCode  the event code
	 * @param from       the from
	 * @param to         the to
	 * @return true, if successful
	 */
	boolean existsFromTo(Long employeeId, String eventCode, LocalDateTime from, LocalDateTime to);

	/**
	 * Gets the event list from effective and to effective events in.
	 *
	 * @param employeeId the employee id
	 * @param from       the from
	 * @param to         the to
	 * @param events     the events
	 * @return the event list from effective and to effective events in
	 */
	List<PVUEmployeEventsEntity> getEventListFromEffectiveAndToEffectiveEventsIn(Long employeeId, LocalDate from,
			LocalDate to, List<String> events);

	/**
	 * Find one by emp id and trn no.
	 *
	 * @param employeeId the employee id
	 * @param trnNo      the trn no
	 * @return the PVU employe events entity
	 */
	PVUEmployeEventsEntity findOneByEmpIdAndTrnNo(Long employeeId, String trnNo);

	/**
	 * Find one by emp id and pay commission.
	 *
	 * @param employeeId the employee id
	 * @param comm       the comm
	 * @return the PVU employe events entity
	 */
	PVUEmployeEventsEntity findOneByEmpIdAndPayCommission(Long employeeId, Long comm);

	/**
	 * Gets the common api response.
	 *
	 * @param id the id
	 * @return the common api response
	 */
	PVUCommonApiDto getCommonApiResponse(Long id);

	/**
	 * Gets the common api response for selection grade.
	 *
	 * @param id the id
	 * @return the common api response for selection grade
	 */
	PVUCommonApiDto getCommonApiResponseForSelectionGrade(Long id);

	/**
	 * Gets the employe join pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe join pay events
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<PVUEmployeJoinPayEventView> getEmployeJoinPayEvents(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the employe fifth pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe fifth pay events
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<PVUEmployeFifthPayEventView> getEmployeFifthPayEvents(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the employee six pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employee six pay events
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<PVUEmployeSixPayEventView> getEmployeeSixPayEvents(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the employe seven pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe seven pay events
	 * @throws CustomException
	 */
	PagebleDTO<PVUEmployeeSevenPayEventView> getEmployeSevenPayEvents(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the employe sus eol trn events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe sus eol trn events
	 * @throws CustomException
	 */
	PagebleDTO<PVUEmpTrnEventTabView> getEmployeSusEolTrnEvents(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the emp trn event.
	 *
	 * @param pageDetail the page detail
	 * @return the emp trn event
	 * @throws CustomException
	 */
	PagebleDTO<PVUEmpTrnEventTabView> getEmpTrnEvent(PageDetails pageDetail) throws CustomException;

	PVUEmployeEventsEntity findLatestEvent(Long employeeId);

	PagebleDTO<PVUEmployeSusEolView> getSusEolDetails(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the latest revision no.
	 *
	 * @param empId     the emp id
	 * @param payCommId the pay comm id
	 * @return the latest revision no
	 * @throws CustomException the custom exception
	 */
	Long getLatestRevisionNo(Long empId, Long payCommId) throws CustomException;

	List<PVUEmployeEventsEntity> findAllByEmpIdAndEventNameAndActiveStatus(Long employeeId, String eventName);

	/**
	 * Gets the emp event tab revised.
	 *
	 * @param pageDetail the page detail
	 * @return the emp event tab revised
	 * @throws CustomException the custom exception
	 */
	PVUEmpEventsRevisedRegularTab getEmpEventTabRevised(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the event ID by event code and trn no.
	 *
	 * @param eventCode the event code
	 * @param trnNo     the trn no
	 * @param empId     the emp id
	 * @param empNo     the emp no
	 * @return the event ID by event code and trn no
	 * @throws CustomException the custom exception
	 */
	public PVUEmpEventsResponse getEventIdByEventCodeAndTrnNo(String eventCode, String trnNo) throws CustomException;
}
