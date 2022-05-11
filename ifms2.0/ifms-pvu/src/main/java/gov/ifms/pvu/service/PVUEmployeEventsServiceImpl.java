package gov.ifms.pvu.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import gov.ifms.pvu.repository.*;
import javassist.bytecode.stackmap.BasicBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.pvu.dto.PVUEmpEventsResponse;
import gov.ifms.pvu.dto.PVUEmpEventsRevisedRegularTab;
import gov.ifms.pvu.dto.PVUEmpEventsRevisedRegularTabView;
import gov.ifms.pvu.dto.PVUEmpEventsRevision;
import gov.ifms.pvu.dto.PVUEmpTrnEventTabView;
import gov.ifms.pvu.dto.PVUEmployeEventView;
import gov.ifms.pvu.dto.PVUEmployeFifthPayEventView;
import gov.ifms.pvu.dto.PVUEmployeJoinPayEventView;
import gov.ifms.pvu.dto.PVUEmployeSixPayEventView;
import gov.ifms.pvu.dto.PVUEmployeSusEolView;
import gov.ifms.pvu.dto.PVUEmployeeSevenPayEventView;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUDepartmentQueryDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeEventsServiceImpl.
 *
 * @version v 1.0
 * @created 2019/12/03 03:14:53
 */
@Service
public class PVUEmployeEventsServiceImpl implements PVUEmployeEventsService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * The PVUEmployeEventsAsMethodName repository.
	 */
	@Autowired
	private PVUEmployeEventsRepository repository;

	/**
	 * The PVUEmployeRepository empRepo.
	 */
	@Autowired
	private PVUEmployeRepository empRepo;

	/**
	 * The PVUEmployeRepository empRepo.
	 */
	@Autowired
	private PVUDepartmentCategoryRepository categoryRepository;

	/**
	 * The EDPMsDesignationRepository empRepo.
	 */
	@Autowired
	private EDPMsDesignationRepository designationRepository;

	/**
	 * The EDPMsDesignationRepository empRepo.
	 */
	@Autowired
	private PVUEmployeDepartmentRepository departmentRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayCellRepository cellRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsGradePayRepository gradePayRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayBandRepository bandRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayLevelRepository levelRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayScaleRepository scaleRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Autowired
	private PVUEmployeShettyPayRepository employeShettyPayRepo;
	@Autowired
	private PVUEmployeAssuredCareerProgressionRepository employeACPRepo;
	@Autowired
	private PVUSelectionGradeEventRepository empSelectionGradeRepo;

	@Autowired
	private PVUCareerAdvancementRepository empCASRepo;

	@Autowired
	private PVUCsEventRepository scEventRepo;

	@Autowired
	private PVUSeniorScaleRepository ssEventRepo;
	@Autowired
	private PVUEmployeHigherPayScaleEventRepository hpsEventRepo;
	@Autowired
	private PVUSteppingUpEventRepository stepupRepo;

	@Autowired
	private PVUDeemedDateRepository deemedRepo;
	@Autowired
	private PVUPromotionRepository promotionRepo;
	@Autowired
	private PVUEmployeForgoRepository forgoRepo;

	@Autowired
	private PVUEmployeSuspensionRepository suspensionRepo;

	@Autowired
	private PVUEmployeeEOLeaveRepository eolRepo;

	@Autowired
	private PVUTransferRepository transferRepo;

	@Autowired
	private PVUIncrementEventRepository incrementRepo;

	@Autowired
	private PVUEmployeTikuPayRepository tikuRepo;

	@Autowired
	private PVUEmployeReversionRepository reversionRepo;

	@Autowired
	private PVURevisionOfPayRepository ropRepo;

	@Autowired
	private PVUFixToRegularPayConRepository pvuFixToRegularPayConRepository;

	@Autowired
	private PVUEmployeTypeChangeSDRepository pvuEmployeTypeChangeSDRepository;
	/**
	 * Retrieves an PVUEmployeEventsEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeEventsEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeEventsEntity getEmployeEvents(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeEventsEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeEventsEntity
	 */
	@Override
	public PVUEmployeEventsEntity saveOrUpdateEmployeEvents(PVUEmployeEventsEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUEmployeEvents items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeEventsDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeEventView> getEmployeEventss(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = PvuConstant.buildPageInMapPageIndexAndSize(pageDetail);
			List<SearchParam> searchParams = pageDetail.getJsonArr();
			if (searchParams != null && !searchParams.isEmpty()) {
				searchParams.forEach(search -> map.put((Constant.IN_EMP_ID), search.getValue()));
			}
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_EVENTS));
			List<Object[]> objStorePro = this.storeProcPvu(procName, map);
			List<PVUEmployeEventView> eventView = NativeQueryResultsMapper.map(objStorePro, PVUEmployeEventView.class);

			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, eventView);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the employe join pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe join pay events
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeJoinPayEventView> getEmployeJoinPayEvents(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = PvuConstant.buildPageInMapPageIndexAndSize(pageDetail);
			List<SearchParam> searchParams = pageDetail.getJsonArr();
			if (searchParams != null && !searchParams.isEmpty()) {
				searchParams.forEach(search -> map.put((Constant.IN_EMP_ID), search.getValue()));
			}
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.EMPLOYEE_JOINING_PAY_DETAIL));
			List<Object[]> objStorePro = this.storeProcPvu(procName, map);
			List<PVUEmployeJoinPayEventView> empyeeJoinEventView = NativeQueryResultsMapper.map(objStorePro,
					PVUEmployeJoinPayEventView.class);

			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, empyeeJoinEventView);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the employe fifth pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe fifth pay events
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeFifthPayEventView> getEmployeFifthPayEvents(PageDetails pageDetail)
			throws CustomException {
		try {
			return getFifthPayEvents(pageDetail);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the fifth pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the fifth pay events
	 * @throws CustomException the custom exception
	 */
	private PagebleDTO<PVUEmployeFifthPayEventView> getFifthPayEvents(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = getEventTabSpParam(pageDetail);
		List<Object[]> fifthPayObjStorePro = this
				.storeProcPvu(Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.EMP_5TH_PAY_EVNT)), map);
		List<PVUEmployeFifthPayEventView> fifthPayEventView = NativeQueryResultsMapper.map(fifthPayObjStorePro,
				PVUEmployeFifthPayEventView.class);
		int totalPages = fifthPayObjStorePro.size();
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fifthPayEventView);
	}

	/**
	 * Gets the employee six pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employee six pay events
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeSixPayEventView> getEmployeeSixPayEvents(PageDetails pageDetail)
			throws CustomException {
		try {
			return getSixPayDetails(pageDetail);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the six pay details.
	 *
	 * @param pageDetail the page detail
	 * @return the six pay details
	 * @throws CustomException the custom exception
	 */
	private PagebleDTO<PVUEmployeSixPayEventView> getSixPayDetails(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = getEventTabSpParam(pageDetail);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.EMP_6TH_PAY_EVNT));
		List<Object[]> objStorePro = this.storeProcPvu(procName, map);
		List<PVUEmployeSixPayEventView> employeeSixPayEventView = NativeQueryResultsMapper.map(objStorePro,
				PVUEmployeSixPayEventView.class);
		int totalPages = objStorePro.size();
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, employeeSixPayEventView);
	}

	/**
	 * Store proc pvu.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<Object[]> storeProcPvu(String procName, Map<String, Object> map) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? objectPvuSp : Collections.emptyList();
	}

	/**
	 * Gets the employee check pay level by emp id.
	 *
	 * @param id the id
	 * @return the employee check pay level by emp id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<Object> getEmployeeCheckPayLevelByEmpId(Long id) throws CustomException {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"select event.EMP_ID,dt.DATE_JOINING,event.CELL_ID,event.EMP_BASIC_PAY,event.EMP_GRD_PAY,event.EMP_PAY_BAND   ")
				.append(" FROM   ").append(Constant.PVU_SCHEMA_MASTER).append(".MS_EMPLOYEE emp ,   ")
				.append(Constant.PVU_SCHEMA).append(".T_EMP_DPT_DTL dt , ").append(Constant.PVU_SCHEMA)
				.append(".T_EMP_EVENTS event ")
				.append(" WHERE emp.EMP_ID = dt.EMP_ID AND emp.EMP_ID = event.EMP_ID AND emp.emp_id = :empId ORDER BY event.EVNT_DATE DESC LIMIT 1");
		HashMap<String, Object> objectMap = new HashMap<>();
		objectMap.put(" empId ", id);
		List<Object[]> objectPvuSp = repository.executeSQLQuery(sb.toString(), objectMap);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, Object.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the list of event exists on date or after.
	 *
	 * @param employeeId the employee id
	 * @param eventIds   the event ids
	 * @param after      the after
	 * @return the list of event exists on date or after
	 */
	@Override
	public List<PVUEmployeEventsEntity> getListOfEventExistsOnDateOrAfter(Long employeeId, List<Long> eventIds,
			LocalDate after) {
		return this.repository.findAllByEmpIdAndEventIdInAndEventDateIsAfter(employeeId, eventIds,
				PvuUtils.startDay(after));
	}

	/**
	 * Gets the all events after date.
	 *
	 * @param employeeId the employee id
	 * @param after      the after
	 * @return the all events after date
	 */
	@Override
	public List<PVUEmployeEventsEntity> getAllEventsAfterDate(Long employeeId, LocalDate after) {
		return this.repository.findAllByEmpIdAndEventDateIsAfter(employeeId, PvuUtils.startDay(after));
	}

	/**
	 * Exists from to.
	 *
	 * @param employeeId     the employee id
	 * @param eventCodeForgo the event code forgo
	 * @param from           the from
	 * @param to             the to
	 * @return true, if successful
	 */
	@Override
	public boolean existsFromTo(Long employeeId, String eventCodeForgo, LocalDateTime from, LocalDateTime to) {
		return repository.existsByEmpIdAndEventNameAndEventDateIsBetween(employeeId, eventCodeForgo, from, to);
	}

	/**
	 * Find one by emp id and event name.
	 *
	 * @param employeeId the employee id
	 * @param eventName  the event name
	 * @return the PVU employe events entity
	 */
	@Override
	public PVUEmployeEventsEntity findOneByEmpIdAndEventName(Long employeeId, String eventName) {
		return repository.findOneByEmpIdAndEventNameAndActiveStatus(employeeId, eventName, Constant.ACTIVE_STATUS);
	}

	/**
	 * Gets the event list from effective and to effective events in.
	 *
	 * @param employeeId the employee id
	 * @param from       the from
	 * @param to         the to
	 * @param events     the events
	 * @return the event list from effective and to effective events in
	 */
	public List<PVUEmployeEventsEntity> getEventListFromEffectiveAndToEffectiveEventsIn(Long employeeId, LocalDate from,
			LocalDate to, List<String> events) {
		return repository.findAllByEmpIdAndEventDateBetweenAndEventNameIn(employeeId, PvuUtils.startDay(from),
				PvuUtils.endDay(to), events);
	}

	/**
	 * Find one by emp id and trn no.
	 *
	 * @param employeeId the employee id
	 * @param trnNo      the trn no
	 * @return the PVU employe events entity
	 */
	@Override
	public PVUEmployeEventsEntity findOneByEmpIdAndTrnNo(Long employeeId, String trnNo) {
		return repository.findOneByEmpIdAndTrnNo(employeeId, trnNo);
	}

	/**
	 * Find one by emp id and pay commission.
	 *
	 * @param employeeId the employee id
	 * @param commId     the comm id
	 * @return the PVU employe events entity
	 */
	@Override
	public PVUEmployeEventsEntity findOneByEmpIdAndPayCommission(Long employeeId, Long commId) {
		return repository.findTopByEmpIdAndPayCommissionAndActiveStatusOrderByEmpIdDesc(employeeId, commId,
				Constant.ACTIVE_STATUS);
	}

	/**
	 * Gets the common api response.
	 *
	 * @param id the id
	 * @return the common api response
	 */
	@Override
	public PVUCommonApiDto getCommonApiResponse(Long id) {
		PVUEmployeEventsEntity event = this.getEmployeEvents(id);
		PVUCommonApiDto response = new PVUCommonApiDto(event);
		IdNameDto val;
		try{
			if (Objects.equals(event.getPayCommission(), PvuConstant.SEVENTH_COMMISSION_ID)) {
				response.setCellId(event.getCellId());
				val = this.cellRepository.getOnlyIdAndName(event.getCellId());
				response.setCellName(val.getName());
				response.setPayLevelId(event.getCellId());
				val = this.levelRepository.getOnlyIdAndName(event.getEmpPaylevel());
				response.setPayLevelName(val.getName());
				response.setPayCommName(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
			} else if (Objects.equals(event.getPayCommission(), PvuConstant.SIXTH_COMMISSION_ID)) {
				response.setPayCommName(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
				response.setPayBandValue(event.getPayBandValue());
				response.setGradePayId(event.getEmpGrdPay());
				val = this.gradePayRepository.getOnlyIdAndName(event.getEmpGrdPay());
				response.setGradePayName(val.getName());
				response.setPayBandId(event.getEmpPayBand());
				val = this.bandRepository.getOnlyIdAndName(event.getEmpPayBand());
				response.setPayBandName(PvuUtils.ternaryOperator(val.getName()));
			} else if (Objects.equals(event.getPayCommission(), PvuConstant.FIFTH_COMMISSION_ID)) {
				val = this.scaleRepository.getOnlyIdAndName(event.getPayScale());
				response.setPayScale(event.getPayScale());
				response.setPayScaleName(val.getName());
				response.setPayCommName(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
			}
			PVUEmployeEntity one = this.empRepo.getOne(response.getEmployeeId());
			response.setEmployeeNo(one.getEmployeeCode().toString());
			setFullEmployeeName(one, response);
			response.setOfficeName(one.getOfficeId().getOfficeName()); // 25
			if(event.getDepartmentCategoryId() != null){
				val = categoryRepository.getOnlyIdAndName(event.getDepartmentCategoryId());
				response.setDepartmentCategoryName(PvuUtils.ternaryOperator(val.getName()));
			}
			if(event.getEmployeeClassId() != null){
				val = lookUpInfoRepository.getOnlyIdAndName(event.getEmployeeClassId());
				response.setEmployeeClass(PvuUtils.ternaryOperator(val.getName()));
			}
			if(event.getEmpDesignation() != null){
				val = designationRepository.getOnlyIdAndName(event.getEmpDesignation());
				response.setDesignationName(PvuUtils.ternaryOperator(val.getName()));
			}
			PVUDepartmentQueryDto dojAndRetDate = departmentRepository
					.getDateOfJoiningGOGAndDateOfRetirement(response.getEmployeeId());
			response.setDateJoining(Utils.getDateStr(dojAndRetDate.getDateOfJoiningGOG()));
			response.setRetirementDate(dojAndRetDate.getDateOfRetirement().toString());
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
		}
		return response;
	}

	/**
	 * Gets the common api response for selection grade.
	 *
	 * @param id the id
	 * @return the common api response for selection grade
	 */
	public PVUCommonApiDto getCommonApiResponseForSelectionGrade(Long id) {
		PVUEmployeEventsEntity event = this.getEmployeEvents(id);
		PVUCommonApiDto response = new PVUCommonApiDto(event);
		IdNameDto val;
		if (Objects.equals(event.getPayCommission(), PvuConstant.SEVENTH_COMMISSION_ID)) {
			response.setCellId(event.getCellId());
			val = this.cellRepository.getOnlyIdAndName(event.getCellId());
			response.setCellName(val.getName());
			response.setPayLevelId(event.getPayBandValue());
			val = this.levelRepository.getOnlyIdAndName(event.getEmpPaylevel());
			response.setPayLevelName(val.getName());
			response.setPayCommName(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
		} else if (Objects.equals(event.getPayCommission(), PvuConstant.SIXTH_COMMISSION_ID)) {
			response.setPayCommName(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
			response.setPayBandValue(event.getPayBandValue());
			response.setGradePayId(event.getEmpGrdPay());
			val = this.gradePayRepository.getOnlyIdAndName(event.getEmpGrdPay());
			response.setGradePayName(val.getName());
			response.setPayBandId(event.getEmpPayBand());
			val = this.bandRepository.getOnlyIdAndName(event.getEmpPayBand());
			response.setPayBandName(val.getName());
		} else if (Objects.equals(event.getPayCommission(), PvuConstant.FIFTH_COMMISSION_ID)) {
			val = this.scaleRepository.getOnlyIdAndName(event.getPayScale());
			response.setPayScale(event.getPayScale());
			response.setPayScaleName(val.getName());
			response.setPayCommName(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
		}
		if (event.getEmpNextIncrDate() != null) {
			response.setDateNxtIncr(event.getEmpNextIncrDate().toString());
		}
		if (event.getEmployeeClassId() != null) {
			val = lookUpInfoRepository.getOnlyIdAndName(event.getEmployeeClassId());
			response.setEmployeeClass(val.getName());
		}
		if (event.getDepartmentCategoryId() != null) {
			val = designationRepository.getOnlyIdAndName(event.getEmpDesignation());
			response.setDesignationName(val.getName());
		}
		if (event.getDepartmentCategoryId() != null) {
			val = categoryRepository.getOnlyIdAndName(event.getDepartmentCategoryId());
			response.setDepartmentCategoryName(val.getName());
		}
		if (response.getEmployeeId() != null) {
			PVUEmployeEntity one = this.empRepo.getOne(response.getEmployeeId());
			response.setEmployeeNo(one.getEmployeeCode().toString());
			setFullEmployeeName(one, response);
			response.setOfficeName(one.getOfficeId().getOfficeName()); // 25
		}
		PVUDepartmentQueryDto dojAndRetDate = departmentRepository
				.getDateOfJoiningGOGAndDateOfRetirement(response.getEmployeeId());
		response.setDateJoining(dojAndRetDate.getDateOfJoiningGOG().toString());
		response.setRetirementDate(dojAndRetDate.getDateOfRetirement().toString());
		return response;
	}

	/**
	 * Gets the employe seven pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe seven pay events
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeeSevenPayEventView> getEmployeSevenPayEvents(PageDetails pageDetail)
			throws CustomException {
		try {
			return getSevenPayDetails(pageDetail);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the seven pay details.
	 *
	 * @param pageDetail the page detail
	 * @return the seven pay details
	 * @throws CustomException the custom exception
	 */
	private PagebleDTO<PVUEmployeeSevenPayEventView> getSevenPayDetails(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = getEventTabSpParam(pageDetail);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.EMP_7TH_PAY_EVNT));
		List<Object[]> objStorePro = this.storeProcPvu(procName, map);
		List<PVUEmployeeSevenPayEventView> empyeeSevenPayEventView = NativeQueryResultsMapper.map(objStorePro,
				PVUEmployeeSevenPayEventView.class);

		int totalPages = objStorePro.size();
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, empyeeSevenPayEventView);
	}

	/**
	 * Gets the employe sus eol trn events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe sus eol trn events
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmpTrnEventTabView> getEmployeSusEolTrnEvents(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = getEventTabSpParam(pageDetail);
		List<Object[]> objStorePro = this
				.storeProcPvu(Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.EMP_SUS_EOL_TRN_EVNT)), map);
		List<PVUEmpTrnEventTabView> empyeeSevenPayEventView = NativeQueryResultsMapper.map(objStorePro,
				PVUEmpTrnEventTabView.class);

		int totalPages = objStorePro.size();
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, empyeeSevenPayEventView);

	}

	/**
	 * Gets the emp trn event.
	 *
	 * @param pageDetail the page detail
	 * @return the emp trn event
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmpTrnEventTabView> getEmpTrnEvent(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = getEventTabSpParam(pageDetail);
		List<Object[]> objStorePro = this
				.storeProcPvu(Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.EMP_TRN_EVNT)), map);
		List<PVUEmpTrnEventTabView> empyeeSevenPayEventView = NativeQueryResultsMapper.map(objStorePro,
				PVUEmpTrnEventTabView.class);

		int totalPages = objStorePro.size();
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, empyeeSevenPayEventView);
	}

	/**
	 * Gets the event tab sp param.
	 *
	 * @param pageDetail the page detail
	 * @return the event tab sp param
	 */
	private Map<String, Object> getEventTabSpParam(PageDetails pageDetail) {
		Map<String, Object> map = PvuConstant.buildPageInMapPageIndexAndSize(pageDetail);
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put((Constant.IN_EMP_ID), search.getValue()));
		}
		return map;
	}

	private void setFullEmployeeName(PVUEmployeEntity emp, PVUCommonApiDto response) {
		StringBuilder sb = new StringBuilder();
		if (emp.getSalutation() != null) {
			sb.append(getSalutationName(emp.getSalutation().getLookUpInfoId()));
			sb.append(" ");
		}
		sb.append(emp.getEmployeeName());
		if (!(emp.getEmployeeMiddleName() == null || emp.getEmployeeMiddleName().isEmpty())) {
			sb.append(" ");
			sb.append(emp.getEmployeeMiddleName());
		}
		if (!(emp.getEmployeeSurname() == null || emp.getEmployeeSurname().isEmpty())) {
			sb.append(" ");
			sb.append(emp.getEmployeeSurname());
		}
		response.setEmployeeName(sb.toString());
	}

	private String getSalutationName(Long lkInfoId) {
		EDPLuLookUpInfoEntity saluationLKEntity = lookUpInfoRepository.findBylookUpInfoId(lkInfoId);
		return saluationLKEntity != null ? saluationLKEntity.getLookUpInfoName() : "";
	}

	@Override
	public PVUEmployeEventsEntity findLatestEvent(Long employeeId) {
		return repository.findFirstByEmpIdOrderByEmpEventIdDesc(employeeId);
	}

	@Override
	public PagebleDTO<PVUEmployeSusEolView> getSusEolDetails(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = getEventTabSpParam(pageDetail);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.EMP_SUS_EOL_EVENT_TAB));
		List<Object[]> objStorePro = this.storeProcPvu(procName, map);
		List<PVUEmployeSusEolView> employeeSixPayEventView = NativeQueryResultsMapper.map(objStorePro,
				PVUEmployeSusEolView.class);
		int totalPages = objStorePro.size();
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, employeeSixPayEventView);
	}

	public Long getLatestRevisionNo(Long empId, Long payCommId) throws CustomException {
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_CHECK_REVISION_NO));
		Map<String, Object> map = new HashMap<>();
		map.put("IN_PAY_COMM", payCommId);
		map.put("IN_EMP_ID", empId);
		List<Object[]> nextSequanceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequanceNumber)) {
			return new BigInteger(nextSequanceNumber.get(0)[0].toString()).longValue();
		} else {
			return 0l;
		}
	}

	@Override
	public List<PVUEmployeEventsEntity> findAllByEmpIdAndEventNameAndActiveStatus(Long employeeId, String eventName) {
		return repository.findAllByEmpIdAndEventNameAndActiveStatus(employeeId, eventName, Constant.ACTIVE_STATUS);

	}

	/**
	 * Gets the emp event tab revised.
	 *
	 * @param pageDetail the page detail
	 * @return the emp event tab revised
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmpEventsRevisedRegularTab getEmpEventTabRevised(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, String> collect = this.getEventTabREvisedParam().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_REVISED_EVENT_TAB));

			List<Object[]> objStorePro = this.storeProcPvu(procName, stringObjectMap);
			List<PVUEmpEventsRevisedRegularTabView> employeeEventsView = NativeQueryResultsMapper.map(objStorePro,
					PVUEmpEventsRevisedRegularTabView.class);
			PVUEmpEventsRevisedRegularTab revisedEventTab = new PVUEmpEventsRevisedRegularTab();
			List<PVUEmpEventsRevision> revisionList = new ArrayList<>();
			if (stringObjectMap.get(PVUSearchEnum.PVU_SEARCH_FIELD_IN_REG_REV_TYPE.getValue()).equals("0")) {

				populateRegularEventTab(employeeEventsView, revisionList);
				revisedEventTab.setEmpEventsRevision(revisionList);
			} else {
				populateRevisedEventTab(employeeEventsView, revisionList);
				revisedEventTab.setEmpEventsRevision(revisionList);
			}
			return revisedEventTab;
		} catch (CustomException ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private void populateRevisedEventTab(List<PVUEmpEventsRevisedRegularTabView> employeeEventsView,
			List<PVUEmpEventsRevision> revisionList) {
		List<String> list = employeeEventsView.stream().map(p -> p.getRevised()).distinct()
				.collect(Collectors.toList());
		for (String revNo : list) {
			PVUEmpEventsRevision reversion = new PVUEmpEventsRevision();
			List<PVUEmpEventsRevisedRegularTabView> filteredByReversion = employeeEventsView.stream()
					.filter(p -> p.getRevised().equals(revNo)).collect(Collectors.toList());
			reversion.setRevised(Integer.parseInt(revNo));
			reversion.setTabDetails(filteredByReversion);
			revisionList.add(reversion);
		}
	}

	private void populateRegularEventTab(List<PVUEmpEventsRevisedRegularTabView> employeeEventsView,
			List<PVUEmpEventsRevision> revisionList) {
		PVUEmpEventsRevision reversion = new PVUEmpEventsRevision();
		reversion.setTabDetails(employeeEventsView);
		reversion.setRevised(0);
		revisionList.add(reversion);
	}

	private List<PVUSearchEnum> getEventTabREvisedParam() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM, PVUSearchEnum.PVU_SEARCH_FIELD_IN_REG_REV_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_EMP_ID

		);
	}

	/**
	 * Gets the event ID by event code and trn no.
	 *
	 * @param eventCode the event code
	 * @param trnNo     the trn no
	 * @return the event ID by event code and trn no
	 * @throws CustomException the custom exception
	 */
	public PVUEmpEventsResponse getEventIdByEventCodeAndTrnNo(String eventCode, String trnNo) throws CustomException {
		PVUEmpEventsResponse response = new PVUEmpEventsResponse();
		try {
			if ((trnNo == null || trnNo.isEmpty()) || eventCode == null || eventCode.isEmpty()) {
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
			}
			switch (eventCode) {
			case PvuConstant.EVENT_CODE_SHETTY_PAY:
			case PvuConstant.EVENT_CODE_ACP:
			case PvuConstant.EVENT_CODE_SELECTION_GRAD:
			case PvuConstant.EVENT_CODE_CAREER_ADVANCE:
			case PvuConstant.PVU_HIGHER_PAY_EVENT_CODE:
			case PvuConstant.EVENT_CODE_STEPPIN_UP:
			case PvuConstant.EVENT_CODE_CHANGE_OF_SCALE_PVU:
			case PvuConstant.PVU_SS_PVU_EVENT_CODE:
			case PvuConstant.EVENT_CODE_TIKU:
				return getEventIdFor9Number(eventCode, trnNo);
			case PvuConstant.EVENT_CODE_CHANGE_OF_SCALE:
			case PvuConstant.PVU_SS_EVENT_CODE:
			case PvuConstant.EVENT_CODE_DEEMED_DATE:
			case PvuConstant.EVENT_CODE_PROMOTION:
			case PvuConstant.EVENT_CODE_FORGO:
			case PvuConstant.EVENT_CODE_REVERSION:
				return getEventIdFor8Number(eventCode, trnNo);
			case PvuConstant.EVENT_CODE_SUSPENSION:
				response.setEventId(suspensionRepo.findByTrnNo(trnNo).getId());
				response.setMenuLinkId(PvuConstant.LINK_MENU_ID_SUSP_SCREEN);
				return response;
			case PvuConstant.EVENT_CODE_INCREMENT:
			case PvuConstant.EVENT_CODE_NOTIONAL_INCREMENT:	
			case PvuConstant.EVENT_CODE_EOL:
			case PvuConstant.EVENT_CODE_TRANSFER:
				return getEventIdForOther(eventCode, trnNo);
				case PvuConstant.FIXPAY_TO_REGULAR:
				case PvuConstant.FIXPAY_TO_REGULAR_EVENT_NAME:
					response.setEventId(pvuFixToRegularPayConRepository.findByTrnNo(trnNo).getFixRegDsId());
					response.setMenuLinkId(PvuConstant.FIXPAY_TO_REGULAR_MENU_ID);
					return response;
				case PvuConstant.ADHOC_TO_REGULAR:
				case PvuConstant.PROBATIONAL_TO_REGULAR:
				case PvuConstant.PROBATIONARY_TO_REGULAR:
					response.setEventId(pvuEmployeTypeChangeSDRepository.findByTransNo(trnNo).getTpvuRegPrboSdId());
					response.setMenuLinkId(PvuConstant.PROBATIONAL_ADHOC_TO_REGULAR_MENU_ID);
					return response;
			default:
				if (trnNo.contains(PvuConstant.PVU_EMP_ROP_TRN_NO)) {
					response.setEventId(ropRepo.findByTrnNo(trnNo).getId());
					response.setMenuLinkId(PvuConstant.LINK_MENU_ID_ROP_SCREEN);
				}
			}
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return response;
	}

	private PVUEmpEventsResponse getEventIdFor9Number(String eventCode, String trnNo) {
		PVUEmpEventsResponse response = new PVUEmpEventsResponse();
		switch (eventCode) {
		case PvuConstant.EVENT_CODE_SHETTY_PAY:
			response.setEventId(employeShettyPayRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.EVENT_CODE_ACP:
			response.setEventId(employeACPRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.EVENT_CODE_SELECTION_GRAD:
			response.setEventId(empSelectionGradeRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.EVENT_CODE_CAREER_ADVANCE:
			response.setEventId(empCASRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.PVU_HIGHER_PAY_EVENT_CODE:
			response.setEventId(hpsEventRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.EVENT_CODE_STEPPIN_UP:
			response.setEventId(stepupRepo.findByTrnNo(trnNo).getStEventId());
			break;
		case PvuConstant.EVENT_CODE_CHANGE_OF_SCALE_PVU:
			response.setEventId(scEventRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.PVU_SS_PVU_EVENT_CODE:
			response.setEventId(ssEventRepo.findByTrnNo(trnNo).getId());
			break;
		default:
			response.setEventId(tikuRepo.findByTrnNo(trnNo).getId());
		}
		response.setMenuLinkId(PvuConstant.LINK_MENU_ID_9_NUM_SCREEN);
		return response;
	}

	private PVUEmpEventsResponse getEventIdFor8Number(String eventCode, String trnNo) {
		PVUEmpEventsResponse response = new PVUEmpEventsResponse();
		switch (eventCode) {
		case PvuConstant.EVENT_CODE_CHANGE_OF_SCALE:
			response.setEventId(scEventRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.PVU_SS_EVENT_CODE:
			response.setEventId(ssEventRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.EVENT_CODE_DEEMED_DATE:
			response.setEventId(deemedRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.EVENT_CODE_PROMOTION:
			response.setEventId(promotionRepo.findByTrnNo(trnNo).getId());
			break;
		case PvuConstant.EVENT_CODE_FORGO:
			response.setEventId(forgoRepo.findByTrnNo(trnNo).getId());
			break;
		default:
			response.setEventId(reversionRepo.findByTrnNo(trnNo).getId());

		}
		response.setMenuLinkId(PvuConstant.LINK_MENU_ID_8_NUM_SCREEN);

		return response;
	}

	private PVUEmpEventsResponse getEventIdForOther(String eventCode, String trnNo) {
		PVUEmpEventsResponse response = new PVUEmpEventsResponse();

		switch (eventCode) {
		case PvuConstant.EVENT_CODE_INCREMENT:
		case PvuConstant.EVENT_CODE_NOTIONAL_INCREMENT:
			response.setEventId(incrementRepo.findByTrnNo(trnNo).getInEventId());
			break;
		case PvuConstant.EVENT_CODE_EOL:
			response.setEventId(eolRepo.findByTransNo(trnNo).getEmpEolId());
			break;
		default:
			response.setEventId(transferRepo.findByTrnNo(trnNo).getId());
		}
		response.setMenuLinkId(0l);

		return response;
	}

}
