package gov.ifms.pvu.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import gov.ifms.pvu.util.PvuUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.converter.PVUIncrementEventConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUIncrementCreateListView;
import gov.ifms.pvu.dto.PVUIncrementEditListView;
import gov.ifms.pvu.dto.PVUIncrementEmpDto;
import gov.ifms.pvu.dto.PVUIncrementEventDto;
import gov.ifms.pvu.dto.PVUIncrementEventSummaryDto;
import gov.ifms.pvu.dto.PVUIncrementListView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.repository.PVUIncrementEventRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUIncrementEventController.
 * 
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 */
@Service
public class PVUIncrementEventServiceImpl implements PVUIncrementEventService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUIncrementEventAsMethodName repository. */
	@Autowired
	private PVUIncrementEventRepository repository;

	/** The PVUIncrementEventAsMethodName helper. */
	@Autowired
	private PVUIncrementEventConverter converter;

	@Autowired
	private PVUIncrementEmpService pvuIncrementEmpService;

	@Autowired
	private PVUIncrementEventSummaryService pvuIncSummaryService;

	@Autowired
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	@Autowired
	private PVYFacade pvuFacade;

	/** Lookup repository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_PAY_INCR_FOR,
				PVUSearchEnum.PVU_SEARCH_FIELD_FINANCIAL_YEAR_ID,
				// PVUSearchEnum.PVU_SEARCH_PAY_INCR_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_PAY_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_FIELD_INCR_EFFECTIVE_DATE, PVUSearchEnum.PVU_SEARCH_DATE_NXT_INCR,
				PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO);
	}

	public List<PVUSearchEnum> getIncEditSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IN_EVENT_ID);
	}

	public List<PVUSearchEnum> getPvuSearchFieldsList() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_FROM,
				PVUSearchEnum.PVU_SEARCH_FIELD_TO, PVUSearchEnum.PVU_SEARCH_FIELD_TRAN_NO,
				// PVUSearchEnum.PVU_SEARCH_FIELD_INC_TYPE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_TYPE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_PAY_TYPE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS_ID,
				PVUSearchEnum.PVU_SEARCH_PAY_INC_FOR, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);
	}

	/**
	 * Retrieves an PVUIncrementEventEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUIncrementEventEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUIncrementEventEntity getIncrementEvent(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));
	}

	/**
	 * Saves a given PVUIncrementEventEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUIncrementEventEntity
	 * @throws CustomException
	 */
	@Override
	public PVUIncrementEventEntity saveOrUpdateIncrementEvent(PVUIncrementEventEntity entity) throws CustomException {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUIncrementEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUIncrementEventDto>
	 * @throws CustomException
	 */
	@Override
	public PagebleDTO<PVUIncrementCreateListView> getIncrementCreateIncludeExcludeEvents(PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = buildPageInMap(pageDetail, getPvuSearchFields());
		List<PVUIncrementCreateListView> objStorePro = getIncrementCreateIncludeExcludeEvent(map);
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
	}

	public List<PVUIncrementCreateListView> getIncrementCreateIncludeExcludeEvent(Map<String, Object> map)
			throws CustomException {
		try {
			String procName = Constant.PVU_SCHEMA
					.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_INCR_INCLUDE_EXCLUDE));
			return repository.storeProc(procName, map, PVUIncrementCreateListView.class);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<PVUIncrementListView> getIncrementListEvents(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail, getPvuSearchFieldsList());
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_INCREMENT_LIST));
			List<PVUIncrementListView> objStorePro = repository.storeProc(procName, map, PVUIncrementListView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, getRowCount(objStorePro), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private long getRowCount(List<PVUIncrementListView> objStorePro) throws CustomException {
		try {
			return objStorePro.isEmpty() ? 0 : objStorePro.get(0).getRecordCount();
		}catch (NumberFormatException ex) {
			logger.error(ex.toString(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	/**
	 * Builds the page in map.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> buildPageInMap(PageDetails pageDetail, List<PVUSearchEnum> lstSearchEum) {
		IdDto idDto = new IdDto();
		idDto.setId(OAuthUtility.getCurrentUserUserId());
		List<IdDto> lst = new ArrayList<>();
		lst.add(idDto);

		StringBuilder stringBuilder = new StringBuilder();
		for (IdDto dto : lst) {
			stringBuilder.append((dto.getId().toString())).append(Constant.COMMA);
		}
		Map<String, String> collect = lstSearchEum.stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(stringBuilder, pageDetail, collect);
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getLookUpInfoAsMap(String procedureName)
			throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = repository.storeProc(procName,
					PVUEmployeCreationDDLView.class);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PVUIncrementEventDto getIncrementEventEmpSummary(Long id) {
		PVUIncrementEventEntity pvuIncrementEventEntity = getIncrementEvent(id);
		PVUIncrementEventDto pvuIncrementEventDto = converter.toDTO(pvuIncrementEventEntity);
		pvuIncrementEventDto.setPvuIncrementEmpDtos(pvuIncrementEmpService.getIncrementEmpByEventId(id));
		pvuIncrementEventDto.setPvuIncrementEventSummaryDto(pvuIncSummaryService.getIncCountSummaryByInEventIdDto(id));
		return pvuIncrementEventDto;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = {Exception.class, CustomException.class})
	public PVUIncrementEventDto saveOrUpdateIncrementEventEmpSummary(PVUIncrementEventDto dto) throws CustomException {
		List<PVUIncrementEmpDto> lstPVUIncrementEmpDtos = dto.getPvuIncrementEmpDtos();
		PVUIncrementEventSummaryDto pvuIncrementEventSummaryDto = dto.getPvuIncrementEventSummaryDto();
		PVUIncrementEventEntity entity = null;
		PVUIncrementEventEntity requestedEntity = null;
		EDPLuLookUpInfoEntity statusId = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
		boolean oldTransaction = Utils.isOldTransaction(dto.getInEventId());

		// entity created upon user event request
		requestedEntity = converter.toEntity(dto);

		// Check transaction new/old
		if (oldTransaction) {

			/**
			// get old transaction event
			entity = getIncrementEvent(dto.getInEventId());

			// verifying, is transaction event criteria changed with help equals method.
			if (isSearchCriteriaChanged(entity, requestedEntity)) {

				// update transaction event
				entity = saveOrUpdateIncrementEvent(requestedEntity);

				// event criteria changed, now previous employee details are irrelevant.
				pvuIncrementEmpService.deleteIrrelevantEmployeeFromTransaction(entity.getInEventId());
			}*/
			
			// update transaction event
			entity = saveOrUpdateIncrementEvent(requestedEntity);
			
		} else {
			//pvuEmployeeEventStatusService.inProgressSuspensionEvent(entity.getEmpId().getEmpId());
			// save transaction event first
			requestedEntity.setStatusId(statusId);
			entity = saveOrUpdateIncrementEvent(requestedEntity);
			repository.flush();
		}

		if (!Utils.isEmpty(lstPVUIncrementEmpDtos)) {
			final long eventId = entity.getInEventId();
			final long transactionStatus = entity.getStatusId().getLookUpInfoId();
			
			//if in list inempid = 0, mean new list and need to remove old transaction employee list
			if (lstPVUIncrementEmpDtos.stream().anyMatch(e -> e.getInEmpId() == 0)) {
				pvuIncrementEmpService.deleteIrrelevantEmployeeFromTransaction(entity.getInEventId());
			}
			
			lstPVUIncrementEmpDtos.forEach(e -> {
				e.setInEventId(eventId);
				e.setStatusId(transactionStatus);
			});
			lstPVUIncrementEmpDtos = pvuIncrementEmpService.saveOrUpdateIncrementEmpDto(lstPVUIncrementEmpDtos);
		}

		if (!Utils.isEmpty(pvuIncrementEventSummaryDto)) {
			pvuIncrementEventSummaryDto.setInEventId(entity.getInEventId());
			pvuIncrementEventSummaryDto = pvuIncSummaryService
					.saveOrUpdateIncrementEventSummary(pvuIncrementEventSummaryDto);
		}

		dto = converter.toDTO(entity);
		dto.setPvuIncrementEmpDtos(lstPVUIncrementEmpDtos);
		dto.setPvuIncrementEventSummaryDto(pvuIncrementEventSummaryDto);
		return dto;
	}

	@Override
	public PagebleDTO<PVUIncrementEditListView> getIncrementEditEvents(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail, getIncEditSearchFields());
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_INCR_EDIT_LIST));
			List<PVUIncrementEditListView> objStorePro = repository.storeProc(procName, map,
					PVUIncrementEditListView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Trace
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = {Exception.class, CustomException.class})
	public PVUIncrementEventDto insertIncrementItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		PVUIncrementEventDto pvuIncrementEventDto = null;
		List<Long> lstEmpIncludeList = null;
		List<Long> lstEmpExcludeList = null;
		Date updatedDate = new Date();
		pvuWFWrapperDto.setUpdatedDate(updatedDate);

		PVUIncrementEventEntity pvuIncrementEventEntity = getIncrementEvent(pvuWFWrapperDto.getTrnId());
		List<PVUIncrementEmpDto> lstPVUIncrementEmpDtos = pvuIncrementEmpService
				.getIncrementEmpByEventId(pvuIncrementEventEntity.getInEventId());
		lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpDto::getEmpId).collect(Collectors.toList());

		lstEmpExcludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() != Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpDto::getEmpId).collect(Collectors.toList());

		EDPLuLookUpInfoEntity empApprovStatsLookupInfo = eDPLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.APPROVED);
		EDPLuLookUpInfoEntity rejectStatus = eDPLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.REJECTED);

		if (pvuIncrementEventEntity.getStatusId().getLookUpInfoId() == empApprovStatsLookupInfo.getLookUpInfoId()) {
			logger.error(MsgConstant.TRN_ALREADY_APPROVED);
			throw new CustomException(ErrorResponse.TRN_ALREADY_APPROVED);
		} else if (pvuIncrementEventEntity.getStatusId().getLookUpInfoId() == rejectStatus.getLookUpInfoId()) {
			logger.error(MsgConstant.TRN_ALREADY_REJECTED);
			throw new CustomException(ErrorResponse.TRN_ALREADY_REJECTED);
		}

		// employee lock validating
		validateNoInProgressEvent(lstPVUIncrementEmpDtos, pvuIncrementEventEntity.getTrnNo());

		// employee salary sync validating

		// transaction number generation if transaction number not generated
		if (Utils.isEmpty(pvuIncrementEventEntity.getTrnNo())) {
			pvuIncrementEventEntity.setTrnNo(getTransactionNumber(Constant.INC));
			pvuIncrementEventEntity = saveOrUpdateIncrementEvent(pvuIncrementEventEntity);
		} else if (!Utils.isEmpty(lstEmpExcludeList)) {
			// if exclude list not empty then need to release previous locks
			pvuEmployeeEventStatusService.resetEmployeeIncEventStatus(pvuIncrementEventEntity.getTrnNo(),
					lstEmpExcludeList);
		}

		// Need to lock include employee with transaction no
		pvuEmployeeEventStatusService.updateEmployeeIncEventStatus(pvuIncrementEventEntity.getTrnNo(),
				lstEmpIncludeList);

		if (!pvuFacade.callWorkFlowApis(pvuWFWrapperDto)) {
			logger.error("Increment workflow entry failed.");
			throw new CustomException(ErrorResponse.WF_FAILED);
		} else {
			EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = eDPLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.SUBMIT);
			if (!Utils.isEmpty(empSubmitStatusLookupInfo)) {
				repository.updateStatusIdForPVUIncrementEventEntity(empSubmitStatusLookupInfo.getLookUpInfoId(),
						pvuWFWrapperDto.getTrnId(), updatedDate, OAuthUtility.getCurrentUserUserId(),
						OAuthUtility.getCurrentUserLkPOUId());
			}
			insertIncrementInITRs(pvuWFWrapperDto);
			approveRejectIncrement(pvuWFWrapperDto, pvuIncrementEventEntity.getTrnNo());
			
			repository.flush();
			pvuIncrementEventDto = getIncrementEventEmpSummary(pvuWFWrapperDto.getTrnId());
		}
		return pvuIncrementEventDto;
	}

	public void submitAutoIncrement(String trnNo) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat("PVU_INCREMENT_AUTO_INCR"));
		Object getResult = repository.callUsingCallableStmt(procName, map);
		logger.info("Transaction no: {} for submit transaction ", trnNo);
		if(!getResult.equals(0l)) {
			logger.error("Increment Autoincrement procedure execution failed.");
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Trace
	public void insertIncrementInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_WF_ROLE_ID, pvuWFWrapperDto.getAssignToWfRoleId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_INCREMENT_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	@Trace
	public void approveRejectIncrement(PvuWFWrapperDto pvuWFWrapperDto, String transNo) throws CustomException {
		if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)
				|| pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
			approveRejectIncrementEvent(pvuWFWrapperDto);
			if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
				submitAutoIncrement(transNo);
			}
			pvuEmployeeEventStatusService.resetIncEmployeeEventStatus(pvuWFWrapperDto.getTrnId(),
					pvuWFWrapperDto.getUpdatedDate());
		}
	}

	@Trace
	@Override
	public Boolean approveRejectIncrementEvent(final PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_STATUS_ID, pvuWFWrapperDto.getWfStatus());
		map.put(Constant.IN_UPDATED_BY, pvuWFWrapperDto.getUpdatedBy());
		map.put(Constant.IN_UPDATED_BY_POST, pvuWFWrapperDto.getUpdatedByPost());
		map.put(Constant.IN_UPDATED_DATE, pvuWFWrapperDto.getUpdatedDate());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_APPROVE_INCREMENT));
		try {
			repository.callStoredProcedure(procName, map);
			logger.info("Transaction no : {} approved and reject", pvuWFWrapperDto.getTrnId());
			return Boolean.TRUE;
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return Boolean.FALSE;
	}

	public String getTransactionNumber(String eventName) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, eventName);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> nextSequanceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequanceNumber)) {
			return (String) nextSequanceNumber.get(0)[0];
		} else {
			logger.error(MsgConstant.TRN_GENERATION_FAILED);
			throw new CustomException(ErrorResponse.TRN_GENERATION_FAILED);
		}
	}

	@Trace
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = {Exception.class, CustomException.class})
	public boolean deleteIncrementTrns(IdDto idDto) throws CustomException {
		Optional<PVUIncrementEventEntity> incrementEventEntity = repository.findById(idDto.getId());
		Date updatedDate = new Date();
		if (incrementEventEntity.isPresent()) {
			PVUIncrementEventEntity entity = incrementEventEntity.get();
			EDPLuLookUpInfoEntity saveAsDraft = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			if (entity.getStatusId().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
				repository.deleteIncrementEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(), updatedDate,
						OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId());
				pvuIncrementEmpService.deleteIncrementEmpIdByEventId(Constant.IN_ACTIVE_STATUS, idDto.getId(),
						updatedDate);
				pvuIncSummaryService.deleteIncrementSummaryIdByEventId(Constant.IN_ACTIVE_STATUS, idDto.getId(),
						updatedDate);
				return Boolean.TRUE;
			} else {
				logger.error(MsgConstant.ERROR_WHILE_DELETE);
				throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean validateIncrementSubmit(PVUIncrementEventDto dto) throws CustomException {
		validateAtLeastOneIncludeRecord(dto.getPvuIncrementEmpDtos());
		validateNoInProgressEvent(dto.getPvuIncrementEmpDtos(), dto.getTrnNo());
		validateEmpSalaryInSync(dto);
		return Boolean.TRUE;
	}

	public void validateAtLeastOneIncludeRecord(List<PVUIncrementEmpDto> lstPVUIncrementEmpDtos)
			throws CustomException {
		List<Long> lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpDto::getEmpId).collect(Collectors.toList());
		if (Utils.isEmpty(lstEmpIncludeList)) {
			logger.error("Transaction can't created without include employee");
			throw new CustomException(ErrorResponse.TRN_WITHOUT_INCLUDE_FAILED);
		}
	}

	public void validateNoInProgressEvent(List<PVUIncrementEmpDto> lstPVUIncrementEmpDtos, String tranNo)
			throws CustomException {
		List<PVUEmployeeEventStatusDto> lstPVUEmployeeEventStatusDto = null;

		List<Long> lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpDto::getEmpId).collect(Collectors.toList());

		if (Utils.isEmpty(tranNo)) {
			lstPVUEmployeeEventStatusDto = pvuEmployeeEventStatusService
					.getEmployeeInProcessByEmpIds(lstEmpIncludeList);
		} else {
			lstPVUEmployeeEventStatusDto = pvuEmployeeEventStatusService
					.getEmployeeInProcessByEmpIdsInOtherTrans(lstEmpIncludeList, tranNo);
		}

		if (!Utils.isEmpty(lstPVUEmployeeEventStatusDto)) {
			StringBuilder errorMessage = new StringBuilder();
			for (PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto : lstPVUEmployeeEventStatusDto) {
				String message = MessageFormat.format(MsgConstant.EVENT_IN_PROGRESS,
						pvuEmployeeEventStatusDto.getTransId(), pvuEmployeeEventStatusDto.getEmployeeCode());
				errorMessage.append(message).append(".\n");
			}
			logger.info("An exception occurred with message: {}", errorMessage);
			throw new CustomException(HttpStatus.CONFLICT, errorMessage.toString());
		}
	}

	public void validateEmpSalaryInSync(PVUIncrementEventDto dto) throws CustomException {

		if (Utils.isEmpty(dto.getTrnNo())) {
			List<PVUIncrementCreateListView> lstIncludeExclude = getIncrementCreateIncludeExcludeEvent(
					prepareIncExcReqestMap(dto));

			if (lstIncludeExclude.size() != dto.getPvuIncrementEmpDtos().size()) {
				logger.error(MsgConstant.TRANSACTION_OUT_OF_SYNCH);
				throw new CustomException(ErrorResponse.TRANSACTION_OUT_OF_SYNCH);
			}

			if (!isSalaryInSalaryInSynch(lstIncludeExclude, dto.getPvuIncrementEmpDtos())) {
				logger.error(MsgConstant.TRANSACTION_OUT_OF_SYNCH);
				throw new CustomException(ErrorResponse.TRANSACTION_OUT_OF_SYNCH);
			}
		}
	}

	public Map<String, Object> prepareIncExcReqestMap(PVUIncrementEventDto dto) {
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("IN_OFFICE_ID", String.valueOf(dto.getOfficeId()));
		requestMap.put("IN_INCR_FOR", String.valueOf(dto.getIncrementFor()));
		requestMap.put("IN_FY", String.valueOf(dto.getFinancialYear()));
		requestMap.put("IN_EMP_TYPE", String.valueOf(dto.getEmpType()));
		requestMap.put("IN_CLASS_ID", String.valueOf(dto.getClassId()));
		requestMap.put("IN_EMP_PAY_TYPE", String.valueOf(dto.getEmpPayType()));
		requestMap.put("IN_DESIGNATION_ID", String.valueOf(dto.getDesignationId()));
		requestMap.put("IN_INCR_EFFECTIVE_DATE", Utils.getDateStr(dto.getIncrementEffDate()));
		requestMap.put("IN_DATE_NXT_INCR", Utils.getDateStr(dto.getDateNextInc()));
		requestMap.put("IN_EMPLOYEE_NO", String.valueOf(dto.getEmpNo().isEmpty()? "0" : dto.getEmpNo()));
		requestMap.put("IN_PPAN_NO", dto.getGpf());
		requestMap.put(Constant.IN_PAGE_INDEX, 0);
		requestMap.put(Constant.IN_PAGE_SIZE, 250);
		requestMap.put(Constant.IN_USER_LIST, "1");
		return requestMap;
	}

	public boolean isSalaryInSalaryInSynch(List<PVUIncrementCreateListView> lstIncIncludeExclude,
			List<PVUIncrementEmpDto> lstIncrementEmpDto) {
		Map<String, PVUIncrementCreateListView> lstView = lstIncIncludeExclude.stream()
				.collect(Collectors.toMap(view -> view.getEmpId() + "_" + view.getIncrementType(), view -> view));
		Map<String, PVUIncrementEmpDto> lstDto = lstIncrementEmpDto.stream()
				.collect(Collectors.toMap(key -> key.getEmpId() + "_" + key.getIncrementType(), dto -> dto));
		PVUIncrementCreateListView view = null;
		PVUIncrementEmpDto dto = null;

		for (Entry<String, PVUIncrementCreateListView> map : lstView.entrySet()) {
			view = lstView.get(map.getKey());
			dto = lstDto.get(map.getKey());

			if (view.getCurCellId() != dto.getCurCellId() || view.getCurGrade() != dto.getCurGrade()
					|| view.getCurScale() != dto.getCurScale() || view.getCurPayBand() != dto.getCurPayBand()
					|| view.getCurPayBandValue() != dto.getCurPayBandValue()
					|| view.getCurGradePay() != dto.getCurGradePay() || view.getCurBasicPay() != dto.getCurBasicPay()
					|| view.getClassId() != dto.getClassId() || view.getDesignationId() != dto.getDesignationId()) {
				return false;
			}
		}
		return true;
	}

	public boolean isSearchCriteriaChanged(PVUIncrementEventEntity entity, PVUIncrementEventEntity requestedEntity) {
		boolean isSerachCriteriaChanged = false;
		if (entity.getInEventId() != requestedEntity.getInEventId()) {
			return true;
		} else if (Utils.isDifferentData(entity.getTrnNo(), requestedEntity.getTrnNo())) {
			isSerachCriteriaChanged = true;
		} else if (isDifferentFinanceYear(entity, requestedEntity)) {
			isSerachCriteriaChanged = true;
		} else if (isDifferentPayCommission(entity, requestedEntity)) {
			isSerachCriteriaChanged = true;
		} else if (isDifferentIncrementType(entity, requestedEntity)) {
			isSerachCriteriaChanged = true;
		} else if (isDifferentPayType(entity, requestedEntity)) {
			isSerachCriteriaChanged = true;
		} else if (isDifferentEmpType(entity, requestedEntity)) {
			isSerachCriteriaChanged = true;
		} else if (isDifferentClass(entity, requestedEntity)) {
			isSerachCriteriaChanged = true;
		} else if (isDifferentDesignation(entity, requestedEntity)) {
			isSerachCriteriaChanged = true;
		} else if (!Utils.compareDates(entity.getIncrementEffDate(), requestedEntity.getIncrementEffDate())) {
			isSerachCriteriaChanged = true;
		} else if (!Utils.compareDates(entity.getDateNextInc(), requestedEntity.getDateNextInc())) {
			isSerachCriteriaChanged = true;
		} else if (!Utils.isDifferentData(entity.getEmpNo(), requestedEntity.getEmpNo())) {
			isSerachCriteriaChanged = true;
		}

		return isSerachCriteriaChanged;
	}

	private boolean isDifferentDesignation(PVUIncrementEventEntity entity, PVUIncrementEventEntity requestedEntity) {
		return (entity.getDesignationId() == null && requestedEntity.getDesignationId() != null)
				|| (entity.getDesignationId() != null && requestedEntity.getDesignationId() == null)
				|| (entity.getDesignationId() != null && requestedEntity.getDesignationId() != null
						&& !entity.getDesignationId().getDesignationId()
								.equals(requestedEntity.getDesignationId().getDesignationId()));
	}

	private boolean isDifferentClass(PVUIncrementEventEntity entity, PVUIncrementEventEntity requestedEntity) {
		return (entity.getClassId() == null && requestedEntity.getClassId() != null)
				|| (entity.getClassId() != null && requestedEntity.getClassId() == null)
				|| (entity.getClassId() != null && requestedEntity.getClassId() != null
						&& entity.getClassId().getLookUpInfoId() != requestedEntity.getClassId().getLookUpInfoId());
	}

	private boolean isDifferentEmpType(PVUIncrementEventEntity entity, PVUIncrementEventEntity requestedEntity) {
		return (entity.getEmpType() == null && requestedEntity.getEmpType() != null)
				|| (entity.getEmpType() != null && requestedEntity.getEmpType() == null)
				|| (entity.getEmpType() != null && requestedEntity.getEmpType() != null
						&& entity.getEmpType().getLookUpInfoId() != requestedEntity.getEmpType().getLookUpInfoId());
	}

	private boolean isDifferentPayType(PVUIncrementEventEntity entity, PVUIncrementEventEntity requestedEntity) {
		return (entity.getEmpPayType() == null && requestedEntity.getEmpPayType() != null)
				|| (entity.getEmpPayType() != null && requestedEntity.getEmpPayType() == null)
				|| (entity.getEmpPayType() != null && requestedEntity.getEmpPayType() != null && entity.getEmpPayType()
						.getLookUpInfoId() != requestedEntity.getEmpPayType().getLookUpInfoId());
	}

	private boolean isDifferentIncrementType(PVUIncrementEventEntity entity, PVUIncrementEventEntity requestedEntity) {
		return (entity.getIncrementType() == null && requestedEntity.getIncrementType() != null)
				|| (entity.getIncrementType() != null && requestedEntity.getIncrementType() == null)
				|| (entity.getIncrementType() != null && requestedEntity.getIncrementType() != null && entity
						.getIncrementType().getLookUpInfoId() != requestedEntity.getIncrementType().getLookUpInfoId());
	}

	private boolean isDifferentPayCommission(PVUIncrementEventEntity entity, PVUIncrementEventEntity requestedEntity) {
		return (entity.getIncrementFor() == null && requestedEntity.getIncrementFor() != null)
				|| (entity.getIncrementFor() != null && requestedEntity.getIncrementFor() == null)
				|| (entity.getIncrementFor() != null && requestedEntity.getIncrementFor() != null && entity
						.getIncrementFor().getLookUpInfoId() != requestedEntity.getIncrementFor().getLookUpInfoId());
	}

	private boolean isDifferentFinanceYear(PVUIncrementEventEntity entity, PVUIncrementEventEntity requestedEntity) {
		return (entity.getFinancialYear() == null && requestedEntity.getFinancialYear() != null)
				|| (entity.getFinancialYear() != null && requestedEntity.getFinancialYear() == null)
				|| (entity.getFinancialYear() != null && requestedEntity.getFinancialYear() != null
						&& entity.getFinancialYear().getFinancialYearId() != requestedEntity.getFinancialYear()
								.getFinancialYearId());
	}
}
