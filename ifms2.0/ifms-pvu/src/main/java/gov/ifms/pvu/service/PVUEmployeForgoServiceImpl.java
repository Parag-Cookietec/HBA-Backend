package gov.ifms.pvu.service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeForgoConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeDepartmentDtos;
import gov.ifms.pvu.dto.PVUEmployeForgoDto;
import gov.ifms.pvu.dto.PVUEmployeSevenPayDetailDto;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUForgoView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeForgoEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeForgoRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUForgoEventController.
 * 
 * @version v 1.0
 * @created 2019/12/23 11:00:23
 */
@Service
public class PVUEmployeForgoServiceImpl implements PVUEmployeForgoService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	/** The PVUForgoEventAsMethodName repository. */
	@Autowired
	private PVUEmployeForgoRepository employeeForgoRepository;

	@Autowired
	private PVUEmployeForgoConverter employeeForgoConverter;

	@Autowired
	private EDPLuLookUpInfoRepository lookupinforepository;

	@Autowired
	private PVUEmployeDepartmentServiceImpl serv;

	@Autowired
	private PVUEmployeSevenPayDetailServiceImpl pvuEmployeSevenPayDetailServiceImpl;

	@Autowired
	private PVUCommonService pvuCommonService;

	/** The pvu facade. */
	@Autowired
	private PVYFacade pvuFacade;

	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	/**
	 * Retrieves an PVUForgoEventEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUForgoEventEntity with the given id or {@literal null} if none
	 *         found
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeForgoEntity getForgoEvent(Long id) throws CustomException {
		Optional<PVUEmployeForgoEntity> entity = employeeForgoRepository.findById(id);
		try {
			if (entity.isPresent())
				return entity.get();
			else {
				logger.error(MsgConstant.RECORD_NOT_FOUND);
				throw new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Saves a given PVUForgoEventEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUForgoEventEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmployeForgoDto saveOrUpdateForgoEvent(PVUEmployeForgoDto dto) throws CustomException {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity = null;
		PVUEmployeForgoEntity forgoEntity = employeeForgoConverter.toEntity(dto);
		pvuEmployeeEventStatusService.inProgressSuspensionEvent(forgoEntity.getEmpId().getEmpId());
		try {
			if (!Objects.isNull(dto.isSubmit()) && dto.isSubmit()) {
				pvuCommonService.validatePromotionForgo(dto);
			}
			if (forgoEntity.getId() < 1) {
				pvuEmployeeEventStatusEntity = pvuEmployeeEventStatusService.findByEmpId(dto.getEmployeeId());
				if (pvuEmployeeEventStatusEntity.isPresent()) {
					if (pvuEmployeeEventStatusService
							.getEventStatus(pvuEmployeeEventStatusEntity.get()).isInProgress()) {
						throw new CustomException(HttpStatus.CONFLICT,
								MessageFormat.format(MsgConstant.EVENT_IN_PROGRESS,
										pvuEmployeeEventStatusService
												.getEventStatus(pvuEmployeeEventStatusEntity.get()).getTransId(),
										pvuEmployeeEventStatusService
												.getEventStatus(pvuEmployeeEventStatusEntity.get()).getEmployeeCode()));
					}
					forgoEntity.setTrnNo(pvuCommonService.getTransactionNumber(PvuConstant.TranNo.PRFG.toString()));
					createEmployeForgoEvent(dto, pvuEmployeeEventStatusEntity, forgoEntity);
				}
			}
			forgoEntity.setStatusId(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
			employeeForgoRepository.save(forgoEntity);
			PVUEmployeForgoDto forgoDto = employeeForgoConverter.toDTO(forgoEntity);
			if (!Objects.isNull(forgoDto.getEmployeeNo()) || forgoDto.getEmployeeNo() == 0) {
				forgoDto.setEmployeeNo(dto.getEmployeeNo());
			}
			return forgoDto;
		} catch (DataIntegrityViolationException e) {
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		}
	}

	private void createEmployeForgoEvent(PVUEmployeForgoDto dto,
			Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity, PVUEmployeForgoEntity entity) {
		if (pvuEmployeeEventStatusEntity.isPresent()) {
			pvuEmployeeEventStatusEntity.get().setEmpId(new PVUEmployeEntity(dto.getEmployeeId()));
			pvuEmployeeEventStatusEntity.get().setPromotionForgo(Constant.ACTIVE_STATUS);
			pvuEmployeeEventStatusEntity.get().setTransId(entity.getTrnNo());
			pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity.get());
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
				PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENTS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO, PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMPLOYEE_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_WORKFLOW,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);
	}

	/**
	 * Fetch all the PVUForgoEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUForgoEventDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUForgoView> getForgoEvents(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_FORGO_SEARCH));
			List<PVUForgoView> objStorePro = this.storeProcPvu(procName, map);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
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
	public List<PVUForgoView> storeProcPvu(String procName, Map<String, Object> map) throws CustomException {
		List<Object[]> objectPvuSp = employeeForgoRepository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUForgoView.class)
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
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_FORGO_LOOKUP_SP));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupForgoSp(procName);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup forgo sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupForgoSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = employeeForgoRepository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	@Override
	public void submitValidation(PVUEmployeForgoDto dto) throws CustomException {

		PVUEmployeDepartmentDtos dtos = serv.getEmployeeDepartment(dto.getEmployeeId());
		long empClass = dtos.getPvuEmployeDepartmentDto().getEmpClass();
		if (empClass > dto.getEmployeeClassId())
			throw new CustomException(ErrorResponse.CLASS_NOT_ALLOWED);

		PVUEmployeSevenPayDetailDto sevenPayDto = pvuEmployeSevenPayDetailServiceImpl
				.getEmpByEmpId(dto.getEmployeeId());

		long payLevel = sevenPayDto.getPayLevel();
		long cellId = sevenPayDto.getCellId();
		if (dto.getPayCommId() == 152) {
			if (payLevel < dto.getPayLevelId())
				throw new CustomException(ErrorResponse.LEVEL_NOT_ALLOWED);
			if (cellId < dto.getCellId())
				throw new CustomException(ErrorResponse.CELL_NOT_ALLOWED);
		}

	}

	@Override
	public PVUEmployeForgoDto insertEmployeeItr(final PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		PVUEmployeForgoDto pvuCommonResponse = null;
		Date approvedDate = new Date();

		Optional<PVUEmployeForgoEntity> forgoEntity = employeeForgoRepository.findById(pvuWFWrapperDto.getTrnId());
		if (!forgoEntity.isPresent() && StringUtils.isEmpty(forgoEntity.get())) {
			logger.error("eventId does  not exist");
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		}
		EDPLuLookUpInfoEntity empApprovStatsLookupInfo = lookupinforepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.APPROVED);
		if (forgoEntity.get().getStatusId().getLookUpInfoId() == empApprovStatsLookupInfo.getLookUpInfoId())
			throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.EMP_ALREADY_APPROVED,
					forgoEntity.get().getEmpId().getEmployeeCode()));
		Boolean isReturn = pvuFacade.callWorkFlowApis(pvuWFWrapperDto);
		if (isReturn.equals(Boolean.TRUE)) {
			EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = lookupinforepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.SUBMIT);
			if (empSubmitStatusLookupInfo != null) {
				employeeForgoRepository.updateStatusIdForPVUEmployeForgoEntity(
						empSubmitStatusLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
						OAuthUtility.getCurrentUserUserId(), approvedDate);
			}

			insertEmpInITRs(pvuWFWrapperDto);
			pvuCommonResponse = employeeForgoConverter.toDTO(forgoEntity.get());
			if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
				forgoEntity.get().setStatusId(empSubmitStatusLookupInfo);
				employeeForgoRepository.updateStatusIdForPVUEmployeForgoEntity(
						empSubmitStatusLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
						OAuthUtility.getCurrentUserUserId(), approvedDate);
				pvuEmployeEventsService.saveOrUpdateEmployeEvents(toEntityOfEmpEvent(pvuCommonResponse));
				updateEmpEventStatus(forgoEntity);
			} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
				EDPLuLookUpInfoEntity empRejectStatsLookupInfo = lookupinforepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.REJECTED);
				if (empRejectStatsLookupInfo != null) {
					employeeForgoRepository.updateStatusIdForPVUEmployeForgoEntity(
							empRejectStatsLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
							OAuthUtility.getCurrentUserUserId(), approvedDate);
				}
			}
			return employeeForgoConverter.toDTO(forgoEntity.get());

		}
		return pvuCommonResponse;
	}

	/**
	 * Execute workflow api.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the boolean
	 * @throws CustomException
	 */
	public void insertEmpInITRs(final PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_EVENT_NAME, PvuConstant.FORGO);

		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_COMMON_ITRS));
		employeeForgoRepository.callStoredProcedure(procName, map);

	}

	/**
	 * To entity of emp event.
	 *
	 * @param dto          the dto
	 * @param approvedDate the approved date
	 * @return the PVU employe events entity
	 */
	private PVUEmployeEventsEntity toEntityOfEmpEvent(PVUEmployeForgoDto dto) throws CustomException {
		PVUEmployeEventsEntity employeEventsEntity = new PVUEmployeEventsEntity();
		PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
				.findFirstByPvuEmployeEntityEmpId(dto.getEmployeeId());
		employeEventsEntity.setTrnNo(dto.getTrnNo());
		employeEventsEntity.setEventName(dto.getEventCode());
		employeEventsEntity.setEventDate(LocalDateTime.of(dto.getEventOrderDate(), LocalTime.MIN));
		employeEventsEntity.setEmpId(dto.getEmployeeId());
		employeEventsEntity.setActiveStatus(dto.getActiveStatus());
		employeEventsEntity.setEmpDesignation(department.getDesignationId().getDesignationId());
		employeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
		employeEventsEntity.setOfficeId(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
		employeEventsEntity.setEmpBasicPay((Long) dto.getBasicPay());

		employeEventsEntity.setPayCommission(dto.getPayCommId());

		EDPLuLookUpInfoEntity payCommissionLookup = lookupinforepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
						PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
						PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
		if (payCommissionLookup != null && payCommissionLookup.getLookUpInfoId() == dto.getPayCommId()) {
			employeEventsEntity.setEmpPaylevel(dto.getPayLevelId());
			employeEventsEntity.setCellId(dto.getCellId());
		}
		payCommissionLookup = lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
		if (payCommissionLookup != null && payCommissionLookup.getLookUpInfoId() == dto.getPayCommId()) {
			employeEventsEntity.setEmpGrdPay(dto.getGradePayId());
			employeEventsEntity.setEmpPayBand(dto.getPayBandId());
			employeEventsEntity.setPayBandValue(dto.getPayBandValue());
		}
		setRevisionNo(employeEventsEntity);
		employeEventsEntity.setEmpNextIncrDate(LocalDateTime.of(dto.getDateOfNextIncrement(), LocalTime.MIN));
		return employeEventsEntity;
	}

	/**
	 * Update emp event status.
	 *
	 * @param find the find
	 */
	private void updateEmpEventStatus(Optional<PVUEmployeForgoEntity> find) {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity;
		if (find.isPresent()) {
			pvuEmployeeEventStatusEntity = pvuEmployeeEventStatusService.findByEmpId(find.get().getEmpId().getEmpId());
			if (pvuEmployeeEventStatusEntity.isPresent()) {
				pvuEmployeeEventStatusEntity.get().setPromotionForgo(0);
				pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity.get());
			}
		}
	}

	/**
	 * Sets the revision no.
	 *
	 * @param employeeEventsEntity the new revision no
	 * @throws CustomException the custom exception
	 */
	private void setRevisionNo(PVUEmployeEventsEntity employeeEventsEntity) throws CustomException {
		try {
			employeeEventsEntity.setRevisionNo(pvuEmployeEventsService
					.getLatestRevisionNo(employeeEventsEntity.getEmpId(), employeeEventsEntity.getPayCommission()));
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}
