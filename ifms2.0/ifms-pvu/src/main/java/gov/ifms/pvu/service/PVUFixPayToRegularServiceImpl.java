package gov.ifms.pvu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.dto.EDPLuLookUpInfoDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.pvu.converter.PVUFixToRegularPayConConverter;
import gov.ifms.pvu.dto.FixpayToRegularRequestDto;
import gov.ifms.pvu.dto.IdAndValueDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeDto;
import gov.ifms.pvu.dto.PVUFixToRegularPayConDto;
import gov.ifms.pvu.dto.PVUFixToRegularPayListView;
import gov.ifms.pvu.dto.PayBandIdAndEnteryPayValueDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUFixToRegularPayConEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUFixToRegularPayConRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayBandRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.util.PvuConstant;

@Service
public class PVUFixPayToRegularServiceImpl implements PVUFixPayToRegularService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private PVUFixToRegularPayConRepository repository;

	@Autowired
	private PVUMsPayScaleRepository payScaleRepository;

	@Autowired
	private PVUMsPayBandRepository payBandRepository;

	@Autowired
	private PVUMsGradePayRepository gradePayRepository;

	@Autowired
	private PVUMsPayLevelRepository payLevelRepository;

	@Autowired
	private PVUMsPayCellRepository payCellRepository;

	@Autowired
	private EDPMsFinancialYearRepository edpMsFinancialYearRepository;

	@Autowired
	private PVUFixToRegularPayConConverter converter;

	@Autowired
	private PVUEmployeRepository employeRepository;

	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Autowired
	private EDPLuLookUpInfoConverter lookupinfoconverter;

	/**
	 * fetch data for listing.
	 *
	 * @param pageDetail the page detail
	 * @return the EMD list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUFixToRegularPayListView> getFixToRegPayList(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = buildPageInMap(pageDetail, getSearchFields());
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_FIX_REG_PROC).toString();
		try {
			List<PVUFixToRegularPayListView> objStorePro = this.pvuProcedure(procName, map);
			int totalPages = objStorePro.size();
			Long totalRecord = !objStorePro.isEmpty() ? objStorePro.get(0).getRecordCount() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), totalPages, totalRecord, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Builds the page in map.
	 *
	 * @param pageDetail     the page detail
	 * @param listSearchEnum the list search enum
	 * @return the map
	 */

	public Map<String, Object> buildPageInMap(PageDetails pageDetail, List<PVUSearchEnum> listSearchEnum) {
		StringBuilder stringBuilder = new StringBuilder();
		Map<String, String> collect = listSearchEnum.stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(stringBuilder, pageDetail, collect);
	}

	/**
	 * Gets the budget search fields.
	 *
	 * @return the budget search fields
	 */
	public List<PVUSearchEnum> getSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IN_REF_NO, PVUSearchEnum.PVU_SEARCH_FIELD_IN_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_IN_DESG_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME_P, PVUSearchEnum.PVU_SEARCH_FIELD_IN_STATUS_ID_P,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_IN_LK_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_IN_CREATED_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_CREATED_TO_DATE);
	}

	/**
	 * Store proc budget.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<PVUFixToRegularPayListView> pvuProcedure(String procName, Map<String, Object> map)
			throws CustomException {
		List<Object[]> objectbudgetSp = repository.callStoredProcedure(procName, map);
		return !objectbudgetSp.isEmpty()
				? NativeQueryResultsMapper.map(objectbudgetSp, PVUFixToRegularPayListView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the pay scale for fifth pay comm
	 *
	 * @return the PVUMsPayScaleEntity
	 */
	@Override
	public List<PVUMsPayScaleEntity> getFifthPayScale(FixpayToRegularRequestDto dto) {
		List<Long> scalIds;
		scalIds = payScaleRepository.getPayScaleIdByDepartmentCategoryAndFixPay(dto.getDeptCatId(),
				Constant.ACTIVE_STATUS, dto.getFixPay());
		if (scalIds.isEmpty()) {
			scalIds = payScaleRepository.getPayScaleIdByDepartmentCategoryByRange(dto.getDeptCatId(),
					Constant.ACTIVE_STATUS);
		}
		return payScaleRepository.findAllByPayScaleIdIn(scalIds, Sort.by("scaleValue"));
	}

	/**
	 * Gets the pay Band for Sixth pay comm
	 *
	 * @return the PVUMsPayBandEntity
	 */
	@Override
	public List<PVUMsPayBandEntity> getSixthPayBandValue(FixpayToRegularRequestDto dto) {
		List<Long> bandIds;
		if (dto.getPayLevel() == 0) {
			bandIds = payBandRepository.getPayBandIdByDepartmentCategoryAndFixPay(dto.getDeptCatId(),
					Constant.ACTIVE_STATUS, dto.getFixPay());
			if (bandIds.isEmpty()) {
				bandIds = payBandRepository.getPayBandIdByDepartmentCategory(dto.getDeptCatId(),
						Constant.ACTIVE_STATUS);
			}
		} else {
			bandIds = payBandRepository.getPayBandIdByDepartmentCategoryAndFixPayAndPayLevelId(dto.getDeptCatId(),
					Constant.ACTIVE_STATUS, dto.getFixPay(), dto.getPayLevel());
			if (bandIds.isEmpty()) {
				bandIds = payBandRepository.getPayBandIdByDepartmentCategoryAndPayLevelId(dto.getDeptCatId(),
						Constant.ACTIVE_STATUS, dto.getPayLevel());
			}
		}
		return payBandRepository.findAllByIdIn(bandIds, Sort.by("payBandDispVal"));
	}

	/**
	 * Gets the grade pay and entery pay value
	 *
	 * @return the PVUMsPayBandEntity
	 */
	public Map<String, Object> getSixthGradePayValueAndEnterypayValue(FixpayToRegularRequestDto dto) {
		Map<String, Object> map = new HashMap<>();
		List<Long> gradePayId;
		gradePayId = dto.getPayLevel() == 0
				? payBandRepository.getGradePayIdByDepartmentCategoryAndFixPay(dto.getDeptCatId(),
						Constant.ACTIVE_STATUS, dto.getFixPay(), dto.getPayBandId())
				: payBandRepository.getGradePayIdByDepartmentCategoryAndFixPayAndPaylvl(dto.getDeptCatId(),
						Constant.ACTIVE_STATUS, dto.getFixPay(), dto.getPayBandId(), dto.getPayLevel());
		if (gradePayId.isEmpty()) {
			gradePayId = dto.getPayLevel() == 0
					? payBandRepository.getGradePayIdByDepartmentCategory(dto.getDeptCatId(), Constant.ACTIVE_STATUS,
							dto.getPayBandId())
					: payBandRepository.getGradePayIdByDepartmentCategoryAndPaylvl(dto.getDeptCatId(),
							Constant.ACTIVE_STATUS, dto.getPayBandId(), dto.getPayLevel());
		}
		if (!gradePayId.isEmpty()) {
			List<IdAndValueDto> idDto = new ArrayList<>();
			List<PVUMsGradePayEntity> gradePayList = gradePayRepository.findAllByIdIn(gradePayId,
					Sort.by("gradePayValue"));
			for (PVUMsGradePayEntity entity : gradePayList) {
				idDto.add(new IdAndValueDto(entity.getId(), entity.getGradePayValue()));
			}
			map.put("gradepay", idDto);
			List<Object[]> list = dto.getPayLevel() == 0
					? payScaleRepository.getEnteryPay(dto.getDeptCatId(), dto.getPayBandId(), gradePayId)
					: payScaleRepository.getEnteryPayAndPayLvl(dto.getDeptCatId(), dto.getPayBandId(), gradePayId,
							dto.getPayLevel());
			List<PayBandIdAndEnteryPayValueDto> enteryPayList = new ArrayList<>();
			for (Object[] obj : list) {
				enteryPayList.add(new PayBandIdAndEnteryPayValueDto(obj[0].toString(), obj[1].toString(),
						obj[2].toString(), obj[3].toString()));
			}
			map.put("payBandValue", enteryPayList);
		}
		return map;
	}

	public List<IdAndValueDto> getSevenPayLevel(FixpayToRegularRequestDto dto) {
		List<IdAndValueDto> idDto = new ArrayList<>();
		List<Object[]> list = payLevelRepository.getPayLevelByDepartmentCategoryAndFixpay(dto.getDeptCatId(),
				Constant.ACTIVE_STATUS, dto.getFixPay());
		if (list.isEmpty()) {
			list = payLevelRepository.getPayLevelByDepartmentCategoryByRange(dto.getDeptCatId(),
					Constant.ACTIVE_STATUS);
		}
		for (Object[] obj : list) {
			idDto.add(new IdAndValueDto(Long.parseLong(obj[0].toString()), obj[1].toString()));
		}
		return idDto;
	}

	public List<IdAndValueDto> getPayCellValue(FixpayToRegularRequestDto dto) {
		List<IdAndValueDto> idDto = new ArrayList<>();
		List<PVUMsPayCellEntity> list = payCellRepository.findAllByPayLevelId(dto.getPayLevel());
		if (!list.isEmpty()) {
			for (PVUMsPayCellEntity entity : list) {
				idDto.add(new IdAndValueDto(Long.parseLong(String.valueOf(entity.getCellId())),
						String.valueOf(entity.getCellValue()), Long.parseLong((String.valueOf(entity.getId())))));
			}
		}
		return idDto;
	}

	/**
	 * Saves a given PVUFixToRegularPayConEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUFixToRegularPayConEntity
	 * @throws CustomException
	 */
	@Transactional(rollbackOn = CustomException.class)
	@Override
	public PVUFixToRegularPayConEntity saveOrUpdateFixToRegularPayCon(PVUFixToRegularPayConEntity entity, String action)
			throws CustomException {
		EDPMsFinancialYearEntity currentYear = edpMsFinancialYearRepository
				.findByIsCurrentYearLookUpInfoName(Constant.LOOKUP_YES);
		entity.setFyId(currentYear.getFinancialYearId());
		if (Status.DRAFT.toString().equalsIgnoreCase(action)) {
			return savedAsDraft(entity);
		}
		if (Status.SUBMITTED.toString().equalsIgnoreCase(action)) {
			PVUEmployeeTypeDto empdto = repository.validateFtr(entity.getEmpId());
			if (Objects.nonNull(empdto)) {
				long count = empdto.getEOL() + empdto.getIncremnt() + empdto.getTransfer() + empdto.getSuspension();
				if (count > 0)
					this.validateEmployee(empdto);
			}

			PVUFixToRegularPayConEntity sEntity = repository.save(entity);
			sEntity.setTrnNo(this.generateRefNo());
			sEntity.setRefDate(new Date());
			return submitFixToRegularPay(sEntity);
		} else {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_CREATE);
		}
	}

	private void validateEmployee(PVUEmployeeTypeDto empdto) throws CustomException {
		String trnNo = empdto.getTransNo();
		if(trnNo==null) {
			trnNo = "N/A";
		}
		if (empdto.getEOL() == 1)
			throw new CustomException(HttpStatus.CONFLICT, "Employee is in EOL with " + trnNo);
		else if (empdto.getSuspension() == 1)
			throw new CustomException(HttpStatus.CONFLICT, "Employee is in Suspension with " + trnNo);
		else if (empdto.getTransfer() == 1)
			throw new CustomException(HttpStatus.CONFLICT, "Employee is in Transfer with " + trnNo);
		else if (empdto.getIncremnt() == 1)
			throw new CustomException(HttpStatus.CONFLICT, "Employee is in Increment with " + trnNo);
	}

	/**
	 * generate reference number
	 * 
	 * @param entity
	 * @param fyShort
	 * @return
	 * @throws CustomException
	 */
	private String generateRefNo() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, PvuConstant.FIX_TO_REG_PAY_TRN_NO);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> nextSequanceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequanceNumber)) {
			return (String) nextSequanceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.TRN_GENERATION_FAILED);
		}
	}

	/**
	 * saved as draft the entity
	 * 
	 * @param entity
	 * @return
	 */
	private PVUFixToRegularPayConEntity savedAsDraft(PVUFixToRegularPayConEntity entity) {
		return repository.save(entity);
	}

	/**
	 * perform submit operation
	 * 
	 * @param entity
	 * @return
	 * @throws CustomException
	 */
	private PVUFixToRegularPayConEntity submitFixToRegularPay(PVUFixToRegularPayConEntity entity) {
		PVUFixToRegularPayConEntity savedEntity = repository.saveAndFlush(entity);
		Map<String, Object> map = getParams(savedEntity);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.SP_FIX_TO_REG_SUBMIT).toString();
		repository.callStoredProcedure(procName, map);
		return savedEntity;
	}

	private Map<String, Object> getParams(PVUFixToRegularPayConEntity entity) {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.IN_HDR_ID, entity.getFixRegDsId());
		map.put(PvuConstant.IN_PAY_COMM_ID, entity.getPayComm());
		map.put(PvuConstant.IN_EMP_ID, entity.getEmpId());
		map.put(PvuConstant.IN_LK_POU_ID, OAuthUtility.getCurrentUserLkPOUId());
		return map;
	}

	/**
	 * Retrieves an PVUFixToRegularPayConEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUFixToRegularPayConEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUFixToRegularPayConDto getFixToRegularPayCon(Long id) {
		PVUFixToRegularPayConEntity entity = repository.findByFixRegDsIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
		PVUEmployeEntity employeeEntity = employeRepository.getOne(entity.getEmpId());
		return this.converter.toCustomDTO(entity, employeeEntity.getEmployeeCode());
	}

	/**
	 * Deletes the PVUFixToRegularPayConEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteFixToRegularPayCon(long id) {
		repository.deleteFixToRegularPayCon(id);
	}

	public void checkEmployeeAlreadyinitiated(Long empId) throws CustomException {
		List<PVUFixToRegularPayConEntity> list = repository.findByEmpIdAndCreatedByAndStatusIdAndActiveStatus(empId,
				OAuthUtility.getCurrentUserUserId(), Constant.SAVE_AS_DRAFT_STATUS_ID, Constant.ACTIVE_STATUS);
		if (!list.isEmpty()) {
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, MsgConstant.ERROR_EMPLOYEE_ONLY_FIX);
		}
	}

	@Cacheable(value = "statusCache")
	@Override
	public List<EDPLuLookUpInfoDto> getStatus() {
		Set<Long> statusNameList = new HashSet<>();
		statusNameList.add(EDPConstant.OFFICE_STATUS_DRAFT_ID);
		statusNameList.add(EDPConstant.STATUS_APPROVED_ID_LONG);
		List<EDPLuLookUpInfoEntity> approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoIdInAndEdpLuLookUpEntityLookUpId(statusNameList, EDPConstant.STATUS_PARENT_LOOKUP_ID);
		return lookupinfoconverter.toDTO(approveLookUpInfo);

	}

}
