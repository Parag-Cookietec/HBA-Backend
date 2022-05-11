package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeSuspensionConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeSuspensionDto;
import gov.ifms.pvu.dto.PVUEmployeSuspensionView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUSuspensionPayDetailsEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeSuspensionRepository;
import gov.ifms.pvu.repository.PVUSuspensionPayDetailsRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUEmployeSuspensionServiceImpl.
 *
 * @version 1.0
 * @created 2019/12/12 15:52:48
 */
@Service
public class PVUEmployeSuspensionServiceImpl implements PVUEmployeSuspensionService {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PVUEmployeSuspensionServiceImpl.class.getName());

	/**
	 * The PVUEmployeSuspensionRepository repository.
	 */
	@Autowired
	private PVUEmployeSuspensionRepository repository;

	@Autowired
	private PVUSuspensionPayDetailsRepository pvuSuspensionPayDetailsRepository;

	/**
	 * The EDP lu look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/**
	 * The pvu facade.
	 */
	@Autowired
	private PVYFacade pvuFacade;

	/**
	 * The pvu facade.
	 */
	@Autowired
	private PVUEmployeSuspensionConverter converter;

	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Autowired
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	@Autowired
	private PVUCommonService pvuCommonService;

	@Autowired
	private OAuthService authService;

	@Autowired
	private PVUCommonService commonService;

	/**
	 * Retrieves an PVUEmployeSuspensionEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeSuspensionEntity with the given id or {@literal null}
	 *         if none found
	 * @throws CustomException
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeSuspensionEntity getPVUEmployeSuspension(Long id) throws CustomException {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeSuspensionEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeSuspensionEntity
	 * @throws CustomException e
	 */
	@Override
	public PVUEmployeSuspensionEntity saveOrUpdatePVUEmployeSuspension(PVUEmployeSuspensionEntity entity)
			throws CustomException {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity = null;
		PVUEmployeSuspensionDto dto = converter.toDTO(entity);
		try {
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = eDPLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);
			if (dto.getFormAction() == Status.SUBMITTED && dto.getTrnNo() == null) {
				pvuEmployeeEventStatusEntity = pvuEmployeeEventStatusService
						.findByEmpId(entity.getEmployee().getEmpId());
				if (pvuEmployeeEventStatusEntity.isPresent()) {
					pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmployee().getEmpId());
				} else {
					LOGGER.error("==========Employee Joining Event is not present ==========");
				}

			}
			checkValidation(dto, empApprovStatsLookupInfo);
			return repository.save(entity);
		} catch (DataIntegrityViolationException e) {
			LOGGER.error(e.toString(), e);
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		}
	}

	private void checkValidation(PVUEmployeSuspensionDto dto, EDPLuLookUpInfoEntity empApprovStatsLookupInfo)
			throws CustomException {
		PVUEmployeSuspensionEntity existingSusEntity = new PVUEmployeSuspensionEntity();
		boolean exists = dateValidate(dto, empApprovStatsLookupInfo, existingSusEntity);
		if (exists) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.SUS_ALREADY_APPROVED, existingSusEntity.getTrnNo()));
		} else {
			boolean b = suspensionCriteriaPayCommisionCheck(dto);
			if (!b) {
				throw new CustomException(HttpStatus.CONFLICT,
						MessageFormat.format(MsgConstant.PVU_EMP_COMMSION_CHECK_VALIDATION, dto.getEmployeeNumber()));
			}
		}
	}

	/**
	 * Fetch all the PVUEmployeSuspension items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeSuspensionDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeSuspensionView> getPVUEmployeSuspensions(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = Constant.PVU_SCHEMA
					.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_SUSPENSION_SEARCH));
			List<PVUEmployeSuspensionView> objStorePro = this.storeProcPvu(procName, map);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	@Override
	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_START_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM, PVUSearchEnum.PVU_SEARCH_FIELD_REASON_FOR_SUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID

		);
	}

	/**
	 * Builds the page in map.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> buildPageInMap(PageDetails pageDetail) {
		IdDto idDto = new IdDto();
		idDto.setId(OAuthUtility.getCurrentUserUserId());
		List<IdDto> lst = new ArrayList<>();
		lst.add(idDto);

		StringBuilder stringBuilder = new StringBuilder();
		for (IdDto dto : lst) {
			stringBuilder.append((dto.getId().toString())).append(Constant.COMMA);
		}
		Map<String, String> collect = getPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(stringBuilder, pageDetail, collect);
	}

	/**
	 * Store proc pvu.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<PVUEmployeSuspensionView> storeProcPvu(String procName, Map<String, Object> map)
			throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeSuspensionView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
			String procName = Constant.PVU_SCHEMA
					.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_SUSPENSION_LOOKUP_SP));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeEOLCreationSp(procName);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup employee EOL creation sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupEmployeeEOLCreationSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * Insert employee promotion itr.
	 *
	 * @param wrapperDto the wrapperDto
	 * @return
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmployeSuspensionDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException {
		Optional<PVUEmployeSuspensionEntity> find = repository.findWithPayDetailsEntityById(wrapperDto.getTrnId());
		EDPLuLookUpInfoEntity empApprovStatsLookupInfo = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.APPROVED);
		Long approvedId = empApprovStatsLookupInfo.getLookUpInfoId();
		PVUEmployeSuspensionEntity entity;
		PVUEmployeeEventStatusEntity statusEntry;
		if (find.isPresent()) {
			entity = find.get();
			if (entity.getTrnNo() == null && entity.getReinstateFlag() == null) {
				statusEntry = pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmployee().getEmpId());
				entity.setTrnNo(getTransactionNumber(Constant.SUS));
				statusEntry.setSuspension(Constant.ACTIVE_STATUS);
				repository.save(entity);
				pvuEmployeeEventStatusService.updateEventInfo(statusEntry, entity.getTrnNo());
			}
			Boolean isReturn = pvuFacade.callWorkFlowApis(wrapperDto);
			if (isReturn.equals(Boolean.TRUE)) {
				EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = lookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.SUBMIT);
				if (empSubmitStatusLookupInfo != null) {
					repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId());
					find.get().getPayDetailsEntity().stream().forEach(e -> {
						PVUSuspensionPayDetailsEntity obj = e;
						if (!approvedId.equals(obj.getStatus().getLookUpInfoId())) {
							pvuSuspensionPayDetailsRepository
									.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), e.getId());
						}

					});

				}
				insertITR(wrapperDto);
				onWorkflowAction(wrapperDto, find, empApprovStatsLookupInfo, approvedId, empSubmitStatusLookupInfo);
				return converter.toDTO(find.get());
			} else {
				throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.EMP_ALREADY_APPROVED,
						find.get().getEmployee().getEmployeeCode()));
			}
		}

		return null;
	}

	private void onWorkflowAction(PvuWFWrapperDto wrapperDto, Optional<PVUEmployeSuspensionEntity> find,
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo, Long approvedId,
			EDPLuLookUpInfoEntity empSubmitStatusLookupInfo) {
		if (find.isPresent()) {
			if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
				onApprove(wrapperDto, find, empApprovStatsLookupInfo);
			} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVAL_IN_PROGRESS)) {
				onApprovalProgress(wrapperDto, find, approvedId, empSubmitStatusLookupInfo);
			}
			if (find.get().getSusEndDate() != null) {
				find.get().setFinalClosure(true);
				repository.updateFinalFlag(true, wrapperDto.getTrnId());
			}
			if (find.get().isSuspensionClosure() && find.get().getSusClsDate() != null) {
				find.get().setCloseSubmit(true);
				repository.updateClosureSubmittedFlag(true, wrapperDto.getTrnId());
			}
			if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
				onWorkflowReject(wrapperDto, find, approvedId);
				repository.updateClosureSubmittedFlag(false, wrapperDto.getTrnId());
				repository.updateFinalFlag(false, wrapperDto.getTrnId());
			}
		}
	}

	private void onApprovalProgress(PvuWFWrapperDto wrapperDto, Optional<PVUEmployeSuspensionEntity> find,
			Long approvedId, EDPLuLookUpInfoEntity empSubmitStatusLookupInfo) {
		if (find.isPresent()) {
			find.get().setStatus(empSubmitStatusLookupInfo);
			if (empSubmitStatusLookupInfo != null) {
				repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId());
			}
			find.get().getPayDetailsEntity().stream().forEach(e -> {
				PVUSuspensionPayDetailsEntity obj = e;
				if (!approvedId.equals(obj.getStatus().getLookUpInfoId())) {
					pvuSuspensionPayDetailsRepository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(),
							e.getId());
				}

			});
		}
	}

	private void onApprove(PvuWFWrapperDto wrapperDto, Optional<PVUEmployeSuspensionEntity> find,
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo) {
		if (find.isPresent()) {
			find.get().setStatus(empApprovStatsLookupInfo);
			if (find.get().isSuspensionClosure() && find.get().getSusClsDate() != null) {
				find.get().setFinalClosure(true);
				repository.updateFinalFlag(true, wrapperDto.getTrnId());
			}
			if (find.get().getSusEndDate() != null) {
				find.get().setFinalEnd(true);
				repository.updateFinalEndFlag(true, wrapperDto.getTrnId());
			}
			repository.updateStatusId(empApprovStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId());
			find.get().getPayDetailsEntity().stream().forEach(e -> pvuSuspensionPayDetailsRepository
					.updateStatusId(empApprovStatsLookupInfo.getLookUpInfoId(), e.getId()));
			pvuEmployeEventsService.saveOrUpdateEmployeEvents(toEntityOfEmpEvent(converter.toDTO(find.get())));
			updateEmpEventStatus(find);
			updateEmployeeSuspension(find.get().getId());
		}
	}

	private void onWorkflowReject(PvuWFWrapperDto wrapperDto, Optional<PVUEmployeSuspensionEntity> find,
			Long approvedId) {
		if (find.isPresent()) {
			EDPLuLookUpInfoEntity empRejectStatusLookupInfo = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);
			pvuEmployeeEventStatusService.findByEmpId(find.get().getEmployee().getEmpId());
			find.get().setStatus(empRejectStatusLookupInfo);
			repository.updateStatusId(empRejectStatusLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId());
			find.get().getPayDetailsEntity().stream().forEach(e -> {
				PVUSuspensionPayDetailsEntity obj = e;
				if (!approvedId.equals(obj.getStatus().getLookUpInfoId())) {
					pvuSuspensionPayDetailsRepository.updateStatusId(empRejectStatusLookupInfo.getLookUpInfoId(),
							e.getId());
				}

			});
			updateEmpEventStatus(find);
			updateEmployeeSuspension(find.get().getId());
		}
	}

	@Override
	public void deletePayDetail(Long id) {
		pvuSuspensionPayDetailsRepository.deleteById(id);

	}

	@Transactional
	public void updateEmpEventStatus(Optional<PVUEmployeSuspensionEntity> find) {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity;
		if (find.isPresent()) {
			pvuEmployeeEventStatusEntity = pvuEmployeeEventStatusService
					.findByEmpId(find.get().getEmployee().getEmpId());
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);
			Long rejectedId = empApprovStatsLookupInfo.getLookUpInfoId();
			if (pvuEmployeeEventStatusEntity.isPresent()) {
				if (find.get().isSuspensionClosure() && find.get().getSusClsDate() != null) {
					pvuEmployeeEventStatusEntity.get().setSuspension(0);
					pvuEmployeeEventStatusEntity.get().setTransId(null);
				}
				if (rejectedId.equals(find.get().getStatus().getLookUpInfoId())) {
					pvuEmployeeEventStatusEntity.get().setSuspension(0);
					pvuEmployeeEventStatusEntity.get().setTransId(null);
				}
				pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity.get());
			}
		}
	}

	/**
	 * To entity of emp event.
	 *
	 * @param dto          the dto
	 * @param approvedDate the approved date
	 * @return the PVU employe events entity
	 */
	private PVUEmployeEventsEntity toEntityOfEmpEvent(PVUEmployeSuspensionDto dto) {

		PVUEmployeEventsEntity employeEventsEntity = new PVUEmployeEventsEntity();
		PVUEmployeEventsEntity entity = pvuEmployeEventsService.findOneByEmpIdAndTrnNo(dto.getEmpId(), dto.getTrnNo());
		if (entity != null) {
			employeEventsEntity.setEmpEventId(entity.getEmpEventId());
		}
		PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
				.findFirstByPvuEmployeEntityEmpId(dto.getEmpId());
		employeEventsEntity.setTrnNo(dto.getTrnNo());
		employeEventsEntity.setEventName(dto.getEventCode());
		employeEventsEntity.setEventDate(LocalDateTime.of(dto.getSusStartDate(), LocalTime.MIN));
		employeEventsEntity.setEmpId(dto.getEmpId());
		employeEventsEntity.setActiveStatus(dto.getActiveStatus());
		employeEventsEntity.setEmpDesignation(department.getDesignationId().getDesignationId());
		employeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
		employeEventsEntity.setPayCommission(dto.getPayCommission());
		employeEventsEntity.setOfficeId(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
		employeEventsEntity.setEventId(PvuConstant.SUSPENSION_EVENT_ID);
		employeEventsEntity.setSourceId(PvuConstant.SUSPENSION_EVENT_ID);

		return employeEventsEntity;
	}

	/**
	 * Execute workflow api.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 */
	public void insertITR(final PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_EMP_SUSPENSION_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	public void updateEmployeeSuspension(Long trnNo) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.UPDATE_EMP_SUSPENDED));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Gets the transaction number.
	 *
	 * @param eventName the event name
	 * @return the transaction number
	 * @throws CustomException the custom exception
	 */
	private String getTransactionNumber(String eventName) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, eventName);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> nextSequanceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequanceNumber)) {
			return (String) nextSequanceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.TRN_GENERATION_FAILED);
		}
	}

	public boolean dateValidate(PVUEmployeSuspensionDto dto, EDPLuLookUpInfoEntity compare,
			PVUEmployeSuspensionEntity suspensionEntity) {
		boolean exists = true;
		if (dto.getSusStartDate() != null) {
			long empId = dto.getEmpId();
			long compareId = compare.getLookUpInfoId();
			LocalDate startDate = dto.getSusStartDate();
			LocalDate endDate = dto.getSusStartDate();
			if (dto.getSusEndDate() != null) {
				endDate = dto.getSusEndDate();
				startDate = dto.getSusEndDate();
			}

			List<PVUEmployeSuspensionEntity> n1 = repository
					.findAllByEmployeeEmpIdAndStatusLookUpInfoIdAndSusStartDateLessThanEqualAndSusEndDateGreaterThanEqualAndIdNotAndPayCommissionLookUpInfoIdAndActiveStatusIs(
							empId, compareId, startDate, endDate, dto.getId(), dto.getPayCommission(), 1);

			if (org.springframework.util.CollectionUtils.isEmpty(n1)) {
				exists = false;
			}
			if (exists && !org.springframework.util.CollectionUtils.isEmpty(n1)) {
				suspensionEntity.setTrnNo(n1.get(0).getTrnNo());
			}
		} else {
			exists = false;
		}
		return exists;
	}

	public boolean suspensionCriteriaPayCommisionCheck(PVUEmployeSuspensionDto dto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_EVENT_DATE, dto.getSusEventDate().toString());
		map.put(Constant.IN_PAY_COMM, dto.getPayCommission());
		map.put(Constant.IN_EMP_ID, dto.getEmpId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.EMP_SUSPENSION_VALIDATION_CHECK));
		List<Object[]> validate = repository.callStoredProcedure(procName, map);
		if (!validate.isEmpty()) {
			Object[] obj = validate.get(0);
			if ("false".equals(obj[0])) {
				return false;
			}
		}
		return true;

	}

	@Override
	public PVUEmployeSuspensionEntity getOneByTrnNo(String trnNo) throws CustomException {
		return repository.findOneByTrnNo(trnNo).orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
	}

	@Override
	public void deleteSusEventsDetails(Long stEventId, int inactiveStatus) throws CustomException {
		try {
			this.repository.updateActiveStatus(stEventId, inactiveStatus, OAuthUtility.getCurrentUserUserId(),
					new Date());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	@Override
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException {
		return generatePdf(dto);
	}

	public String generatePdf(IdDto dto) throws CustomException {

		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		// create a new document
		Document document = new Document();
		try {
			String htmltoPdf = null;
			Map<String, Object> map = new HashMap<>();
			document = new Document();
			// document header attributes
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Suspension Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();
			writer.write(generatePrint(dto).toString());

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			map.put("content", writer.toString());
			htmltoPdf = commonService.htmlToPdfRequest(map); // call this method for node js API for html to Base64
			return htmltoPdf;

		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public StringWriter generatePrint(IdDto dto) throws CustomException {
		StringWriter writer = new StringWriter();
		PVUEmployeSuspensionEntity entity = repository.getOne(dto.getId());
		// Employee Current Details
		Map<String, Object> map1 = new HashMap<>();
		map1.put("IN_PAGE_INDEX", 0);
		map1.put("IN_PAGE_SIZE", 10);
		map1.put("IN_EFFECTIVE_DATE", PvuUtils.getStrOfLocalDateInYMD(entity.getSusEventDate()));
		map1.put("IN_PAY_COMM", entity.getPayCommission().getLookUpInfoId());
		map1.put("IN_EVENT_ID", 0);
		map1.put("IN_EMPLOYEE_NO", entity.getEmployee().getEmployeeCode());
		map1.put("IN_OFFICE_ID", entity.getOffice().getOfficeId());
		PVUCommonApiDto pvuCommonApiDto = pvuCommonService.getCommonDetailsBasedOnEventDate(map1);

		VelocityContext context = converter.populateVContext(entity, pvuCommonApiDto);

		String watermark;
		if (entity.getOffice().getOfficeId().equals(entity.getOffice().getPvuId())
				&& entity.getOffice().getOfficeId() != Constant.PVU_OFFICE_ID) {
			watermark = "Self Pay Verification Unit";
		} else {
			watermark = "Pay Verification Unit, Gandhinagar";
		}
		context.put("watermark", watermark);
		context.put("approverName", String.valueOf(authService.getOnlyIdAndName(entity.getUpdatedBy()).getName()));
		Map<String, Object> map = new HashMap<>();
		map.put("userId", entity.getUpdatedBy());
		setApprover(context, map);
		Template template = getPrintTemplateForPayFixation();
		template.merge(context, writer);

		return writer;
	}

	private void setApprover(VelocityContext context, Map<String, Object> map) {
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getUserDesgnationFromUserId(),
				map);
		if (objects == null || objects.isEmpty()) {
			context.put("approverDesignation", "");
		} else {
			context.put("approverDesignation", String.valueOf(objects.get(0)[0]));
		}
	}

	public Template getPrintTemplateForPayFixation() {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		return ve.getTemplate("templates/suspension/Suspension.vm");
	}

}
