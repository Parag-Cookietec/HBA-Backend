package gov.ifms.pvu.service;

import java.text.MessageFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.converter.PVUEmpBankDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeFivePayDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeFixPayDetailsConverter;
import gov.ifms.pvu.converter.PVUEmployeFourthPayDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeSevenPayDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeSixPayDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeeJoiningPayConverter;
import gov.ifms.pvu.converter.PVUMsPayCellConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeFivePayDetailDto;
import gov.ifms.pvu.dto.PVUEmployePayDetailDtos;
import gov.ifms.pvu.dto.PVUEmployeSixPayDetailDto;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.entity.PVUEmpBankDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeFivePayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeFixPayDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeFourthPayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeSevenPayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeSixPayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeeJoiningPayEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.repository.PVUEmpBankDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeFivePayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeFixPayDetailsRepository;
import gov.ifms.pvu.repository.PVUEmployeFourthPayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeSevenPayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeSixPayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeeJoiningPayRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployePayDetailServiceImpl.
 *
 * @version v 1.0
 * @created 2019/11/26 12:51:22
 */
@Service
public class PVUEmployePayDetailServiceImpl implements PVUEmployePayDetailService {

	/**
	 * The logger.
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * The PVUEmployeSevenPayDetailConverter pvuemployeSevenPaydetailconverter.
	 */
	@Autowired
	private PVUEmployeSevenPayDetailConverter pvuemployeSevenPaydetailconverter;

	/**
	 * The PVUEmploye6PayDetailAsMethodName repository.
	 */
	@Autowired
	private PVUEmployeSixPayDetailRepository repository;

	/**
	 * The PVUMsPayCellRepository payCellRepository.
	 */
	@Autowired
	private PVUMsPayCellRepository payCellRepository;

	/**
	 * The PVUMsPayCellConverter payCellConverter.
	 */
	@Autowired
	private PVUMsPayCellConverter payCellConverter;

	/**
	 * The PVUEmployeSixPayDetailConverter helper.
	 */
	@Autowired
	private PVUEmployeSixPayDetailConverter converter;

	/**
	 * The PVUEmployeSevenPayDetailRepository pvuEmployeSevenPayDetailRepositary.
	 */
	@Autowired
	private PVUEmployeSevenPayDetailRepository pvuEmployeSevenPayDetailRepositary;

	/**
	 * The PVUEmployeFivePayDetailRepository pvuEmployeFivePayDetailRepositary.
	 */
	@Autowired
	private PVUEmployeFivePayDetailRepository pvuEmployeFivePayDetailRepositary;

	/**
	 * The PVUEmployeFourthPayDetailRepository pvuEmployeFourthPayDetailRepositary.
	 */
	@Autowired
	private PVUEmployeFourthPayDetailRepository pvuEmployeFourthPayDetailRepositary;

	/**
	 * The PVUEmployeFivePayDetailConverter pvuEmployeFivePayDetailConverter.
	 */
	@Autowired
	private PVUEmployeFivePayDetailConverter pvuEmployeFivePayDetailConverter;

	/**
	 * The PVUEmployeFourthPayDetailConverter pvuEmployeFourthPayDetailConverter.
	 */
	@Autowired
	private PVUEmployeFourthPayDetailConverter pvuEmployeFourthPayDetailConverter;

	/** The pvu employe fix pay details repository. */
	@Autowired
	private PVUEmployeFixPayDetailsRepository pvuEmployeFixPayDetailsRepository;

	/** The pvu employe fix pay details converter. */
	@Autowired
	private PVUEmployeFixPayDetailsConverter pvuEmployeFixPayDetailsConverter;

	/** The pvu employee joining pay repository. */
	@Autowired
	private PVUEmployeeJoiningPayRepository pvuEmployeeJoiningPayRepository;

	/** The pvu employee joining pay converter. */
	@Autowired
	private PVUEmployeeJoiningPayConverter pvuEmployeeJoiningPayConverter;

	/** The pvu emp bank detail repository. */
	@Autowired
	private PVUEmpBankDetailRepository pvuEmpBankDetailRepository;

	/** The pvu emp bank detail converter. */
	@Autowired
	private PVUEmpBankDetailConverter pvuEmpBankDetailConverter;

	@Autowired
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	@Autowired
	private PVUEmployeEventsRepository pvuEmployeEventsRepository;

	/**
	 * Retrieves an PVUEmploye6PayDetailEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmploye6PayDetailEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeSixPayDetailEntity getEmployeSixPayDetail(Long id) {
		return repository.findOneBySixpayId(id);
	}

	/**
	 * Gets the employepay details.
	 *
	 * @param id the id
	 * @return the employepay details
	 * @throws CustomException the custom exception
	 */
	public PVUEmployePayDetailDtos getEmployepayDetails(Long id) throws CustomException {
		PVUEmployePayDetailDtos dtos = new PVUEmployePayDetailDtos();
		try {
			pvuEmployeFourthPayDetailRepositary.findPVUEmployeFourthPayDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(id,Constant.ACTIVE_STATUS)
					.ifPresent(e -> dtos.setPvuEmployefourthPayDetailDto(pvuEmployeFourthPayDetailConverter.toDTO(e)));

			pvuEmployeFivePayDetailRepositary.findOneByPvuEmployeEntityEmpIdAndActiveStatus(id,Constant.ACTIVE_STATUS)
					.ifPresent(e -> dtos.setPvuEmployefivePayDetailDto(pvuEmployeFivePayDetailConverter.toDTO(e)));

			repository.findOneByPvuEmployeEntityEmpIdAndActiveStatus(id,Constant.ACTIVE_STATUS)
					.ifPresent(e -> dtos.setPvuEmployeSixPayDetailDto(converter.toDTO(e)));

			pvuEmployeSevenPayDetailRepositary.findOneByPvuEmployeEntityEmpIdAndActiveStatus(id,Constant.ACTIVE_STATUS)
					.ifPresent(e -> dtos.setPvuEmployeSevenPayDetailDto(pvuemployeSevenPaydetailconverter.toDTO(e)));

			pvuEmployeFixPayDetailsRepository.findOneByEmpIdEmpId(id)
					.ifPresent(e -> dtos.setPvuEmployeFixPayDetailsDto(pvuEmployeFixPayDetailsConverter.toDTO(e)));

			pvuEmployeeJoiningPayRepository.findOneByPvuEmployeEntityEmpId(id)
					.ifPresent(e -> dtos.setPvuEmployeeJoiningPayDto(pvuEmployeeJoiningPayConverter.toDTO(e)));

			pvuEmpBankDetailRepository.findOneByPvuEmployeEntityEmpId(id)
					.ifPresent(e -> dtos.setPvuEmpBankDetailDto(pvuEmpBankDetailConverter.toDTO(e)));
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return dtos;
	}

	/**
	 * Gets the employe 6 pay details.
	 *
	 * @param pageDetail the page detail
	 * @return the employe 6 pay details
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeSixPayDetailDto> getEmploye6PayDetails(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeSixPayDetailEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUEmployeSixPayDetailEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUEmployeSixPayDetailEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Save or update employe six pay detail.
	 *
	 * @param dto the dto
	 * @return the PVU employe pay detail dtos
	 * @throws CustomException the custom exception
	 */
	@Override
	@ExceptionHandler
	@Transactional
	public PVUEmployePayDetailDtos saveOrUpdateEmployePayDetail(PVUEmployePayDetailDtos dto) throws CustomException {
		PVUEmployePayDetailDtos dtos = new PVUEmployePayDetailDtos();
		try {
			/* Save 4th pay details */
			if (!Utils.isEmpty(dto.getPvuEmployefourthPayDetailDto())) {
				saveUpdateFourthEmpPay(dto, dtos);
			}
			/* Save 5th pay details */
			if (!Utils.isEmpty(dto.getPvuEmployefivePayDetailDto())) {
				saveUpdateEmpFivePay(dto, dtos);
			}
			/* Save 6th pay details */
			if (!Utils.isEmpty(dto.getPvuEmployeSixPayDetailDto())) {
				saveUpdateEmpSixPay(dto, dtos);
			}
			/* Save 7th pay details */
			if (!Utils.isEmpty(dto.getPvuEmployeSevenPayDetailDto())) {
				saveUpdateEmpSevenPay(dto, dtos);
			}
			/* Save fix pay details */
			if (!Utils.isEmpty(dto.getPvuEmployeFixPayDetailsDto())) {
				saveUpdateEmpFixPay(dto, dtos);
			}
			/* Save joining pay details */
			if (!Utils.isEmpty(dto.getPvuEmployeeJoiningPayDto())) {
				saveUpdateEmpJoiningPay(dto, dtos);
				alreadyExitEmpOfFivePayDetailDisableByEmpId(dto);
			}
			if (!Utils.isEmpty(dto.getPvuEmpBankDetailDto())) {
				saveUpdateEmpBankDetail(dto, dtos);
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
		return dtos;
	}

	/**
	 * Save update emp bank detail.
	 *
	 * @param dto  the dto
	 * @param dtos the dtos
	 */
	private void saveUpdateEmpBankDetail(PVUEmployePayDetailDtos dto, PVUEmployePayDetailDtos dtos) {
		pvuEmpBankDetailRepository
				.findOneByPvuEmployeEntityEmpIdAndActiveStatus(dto.getPvuEmpBankDetailDto().getEmpId(),
						Constant.ACTIVE_STATUS)
				.ifPresent(e -> dto.getPvuEmpBankDetailDto().setId(e.getId()));

		PVUEmpBankDetailEntity pvuEmpBankDetailEntity = pvuEmpBankDetailRepository
				.save(pvuEmpBankDetailConverter.toEntity(dto.getPvuEmpBankDetailDto()));
		dtos.setPvuEmpBankDetailDto(pvuEmpBankDetailConverter.toDTO(pvuEmpBankDetailEntity));
	}

	/**
	 * Gets the seven basic.
	 *
	 * @param pvuRequest the pvu request
	 * @return the seven basic
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUMsPayCellDto getSevenBasic(PvuCommonRequest pvuRequest) throws CustomException {
		Map<String, Long> request = pvuRequest.getRequest();
		Long cellId = request.get(PvuConstant.CELL_ID);
		Long payLevelId = request.get(PvuConstant.PAY_LEVEL_ID);
		Optional<PVUMsPayCellEntity> optCell = this.payCellRepository.findOneByPayLevelIdAndCellId(payLevelId,
				cellId.intValue());
		return optCell.map(pvuMsPayCellEntity -> this.payCellConverter.toDTO(pvuMsPayCellEntity))
				.orElseThrow(() -> new CustomException(200,
						String.format("Not Found Basic Pay For PayLevel %s and CellId %s ", payLevelId, cellId)));
	}

	/**
	 * Gets the basic.
	 *
	 * @param payScale the pay scale
	 * @param empid    the empid
	 * @return the basic
	 */
	@Override
	public PVUEmployeFivePayDetailDto getBasic(Long payScale, long empid) {
		return pvuEmployeFivePayDetailConverter.toDTO(
				pvuEmployeFivePayDetailRepositary.findOneByPayScalePayScaleIdAndPvuEmployeEntityEmpId(payScale, 206));
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
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_FIX_PAY_VAL_LP_LS_SP));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeHigherPaySp(procName);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup employee reversion sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupEmployeeHigherPaySp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the seven basic.
	 *
	 * @param pvuRequest the pvu request
	 * @return the seven basic
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUMsPayCellDto getSevenBasicByPlevelAndPk(PvuCommonRequest pvuRequest) throws CustomException {
		Map<String, Long> request = pvuRequest.getRequest();
		Long cellId = request.get(PvuConstant.CELL_ID);
		Long payLevelId = request.get(PvuConstant.PAY_LEVEL_ID);
		Optional<PVUMsPayCellEntity> optCell = this.payCellRepository.findOneByPayLevelIdAndId(payLevelId, cellId);
		return optCell.map(pvuMsPayCellEntity -> this.payCellConverter.toDTO(pvuMsPayCellEntity))
				.orElseThrow(() -> new CustomException(200,
						String.format("Not Found Basic Pay For PayLevel %s and CellId %s ", payLevelId, cellId)));
	}

	/**
	 * Save update emp joining pay.
	 *
	 * @param dto  the dto
	 * @param dtos the dtos
	 */
	private void saveUpdateEmpJoiningPay(PVUEmployePayDetailDtos dto, PVUEmployePayDetailDtos dtos) {
		pvuEmployeeJoiningPayRepository.findOneByPvuEmployeEntityEmpId(dto.getPvuEmployeeJoiningPayDto().getEmpId())
				.ifPresent(e -> dto.getPvuEmployeeJoiningPayDto().setJoiningPayId(e.getJoiningPayId()));

		PVUEmployeeJoiningPayEntity pvuEmployeeJoiningPayEntity = pvuEmployeeJoiningPayRepository
				.save(pvuEmployeeJoiningPayConverter.toEntity(dto.getPvuEmployeeJoiningPayDto()));
		dtos.setPvuEmployeeJoiningPayDto(pvuEmployeeJoiningPayConverter.toDTO(pvuEmployeeJoiningPayEntity));
	}

	/**
	 * Save update emp fix pay.
	 *
	 * @param dto  the dto
	 * @param dtos the dtos
	 */
	private void saveUpdateEmpFixPay(PVUEmployePayDetailDtos dto, PVUEmployePayDetailDtos dtos) {
		pvuEmployeFixPayDetailsRepository.findOneByEmpIdEmpId(dto.getPvuEmployeFixPayDetailsDto().getEmpId())
				.ifPresent(e -> dto.getPvuEmployeFixPayDetailsDto().setFixPayId(e.getFixPayId()));

		PVUEmployeFixPayDetailsEntity pvuEmployeFixPayDetailsEntity = pvuEmployeFixPayDetailsRepository
				.save(pvuEmployeFixPayDetailsConverter.toEntity(dto.getPvuEmployeFixPayDetailsDto()));
		dtos.setPvuEmployeFixPayDetailsDto(pvuEmployeFixPayDetailsConverter.toDTO(pvuEmployeFixPayDetailsEntity));
	}

	/**
	 * Save update emp seven pay.
	 *
	 * @param dto  the dto
	 * @param dtos the dtos
	 */
	private void saveUpdateEmpSevenPay(PVUEmployePayDetailDtos dto, PVUEmployePayDetailDtos dtos) {
		pvuEmployeSevenPayDetailRepositary
				.findOneByPvuEmployeEntityEmpIdAndActiveStatus(dto.getPvuEmployeSevenPayDetailDto().getEmpId(),Constant.ACTIVE_STATUS)
				.ifPresent(e -> dto.getPvuEmployeSevenPayDetailDto().setSevenPayId(e.getSevenPayId()));

		PVUEmployeSevenPayDetailEntity pvuemploye7paydetailentity = pvuEmployeSevenPayDetailRepositary
				.save(pvuemployeSevenPaydetailconverter.toEntity(dto.getPvuEmployeSevenPayDetailDto()));
		dtos.setPvuEmployeSevenPayDetailDto(pvuemployeSevenPaydetailconverter.toDTO(pvuemploye7paydetailentity));
	}

	/**
	 * Save update emp six pay.
	 *
	 * @param dto  the dto
	 * @param dtos the dtos
	 */
	private void saveUpdateEmpSixPay(PVUEmployePayDetailDtos dto, PVUEmployePayDetailDtos dtos) {
		repository.findOneByPvuEmployeEntityEmpId(dto.getPvuEmployeSixPayDetailDto().getEmpId())
				.ifPresent(e -> dto.getPvuEmployeSixPayDetailDto().setSixpayId(e.getSixpayId()));

		PVUEmployeSixPayDetailEntity entity = repository.save(converter.toEntity(dto.getPvuEmployeSixPayDetailDto()));
		dtos.setPvuEmployeSixPayDetailDto(converter.toDTO(entity));
	}

	/**
	 * Save update emp five pay.
	 *
	 * @param dto  the dto
	 * @param dtos the dtos
	 */
	private void saveUpdateEmpFivePay(PVUEmployePayDetailDtos dto, PVUEmployePayDetailDtos dtos) {
		pvuEmployeFivePayDetailRepositary.findOneByPvuEmployeEntityEmpIdAndActiveStatus(dto.getPvuEmployefivePayDetailDto().getEmpId(),Constant.ACTIVE_STATUS)
				.ifPresent(e -> dto.getPvuEmployefivePayDetailDto().setFifthPayId(e.getFifthPayId()));

		PVUEmployeFivePayDetailEntity entityfive = pvuEmployeFivePayDetailRepositary
				.save(pvuEmployeFivePayDetailConverter.toEntity(dto.getPvuEmployefivePayDetailDto()));
		dtos.setPvuEmployefivePayDetailDto(pvuEmployeFivePayDetailConverter.toDTO(entityfive));
	}

	/**
	 * Save update fourth emp pay.
	 *
	 * @param dto  the dto
	 * @param dtos the dtos
	 */
	private void saveUpdateFourthEmpPay(PVUEmployePayDetailDtos dto, PVUEmployePayDetailDtos dtos) {
		Optional<PVUEmployeFourthPayDetailEntity> forthPayDetails = pvuEmployeFourthPayDetailRepositary
				.findPVUEmployeFourthPayDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(
						dto.getPvuEmployefourthPayDetailDto().getEmpId(),Constant.ACTIVE_STATUS);
		if (forthPayDetails.isPresent()) {
			dto.getPvuEmployefourthPayDetailDto().setFourthPayId(forthPayDetails.get().getFourthPayId());
		}

		PVUEmployeFourthPayDetailEntity entityfourth = pvuEmployeFourthPayDetailRepositary
				.save(pvuEmployeFourthPayDetailConverter.toEntity(dto.getPvuEmployefourthPayDetailDto()));
		dtos.setPvuEmployefourthPayDetailDto(pvuEmployeFourthPayDetailConverter.toDTO(entityfourth));
	}

	/**
	 * Gets the sixth pay entity.
	 *
	 * @param empId the emp id
	 * @return the sixth pay entity
	 */
	private PVUEmployeEventsEntity getEmpEventByEventId(Long empId, Long payCommId) {
		List<Long> eventId = getPayCommIdList(payCommId);
		List<PVUEmployeEventsEntity> list = pvuEmployeEventsRepository
				.findFirstByPVUEmployeEventsEntityByEmpIdAndEventIdAndActiveStatusAndPayCommission(empId, eventId,
						payCommId, Constant.ACTIVE_STATUS);

		if (!list.isEmpty()) {
			return list.stream().max(Comparator.comparingLong(PVUEmployeEventsEntity::getEmpEventId)).get();
		}
		return null;
	}

	/**
	 * Gets the pay comm dateby effective date.
	 *
	 * @param sixthEntity        the sixth entity
	 * @param seventhEntity      the seventh entity
	 * @param eventEffectiveDate the event effective date
	 * @param comm               the comm
	 * @return the pay comm dateby effective date
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	private void getPayCommDatebyEffectiveDate(PVUEmployeEventsEntity sixthEntity, PVUEmployeEventsEntity seventhEntity,
			Date eventEffectiveDate, Long comm) throws CustomException, ParseException {
		if (isSeventhPayValidBefore(seventhEntity, eventEffectiveDate)
				&& isSixthPayValidAfter(sixthEntity, eventEffectiveDate)) {
			if (comm.equals(PvuConstant.FIFTH_COMMISSION_ID)) {
				throw new CustomException(HttpStatus.CONFLICT, MsgConstant.COMMON_PAYCOMM_CHANGEPAYCOMM);
			} else if (comm.equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
				throw new CustomException(HttpStatus.CONFLICT,
						MessageFormat.format(MsgConstant.COMMON_PAYCOMM_INVALID, getCommisionName(comm)));
			}
		} else if (isSeventhPayValidBefore(seventhEntity, eventEffectiveDate)
				&& isSixthPayValidBefore(sixthEntity, eventEffectiveDate)
				&& !comm.equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.COMMON_PAYCOMM_INVALID, getCommisionName(comm)));
		}
	}

	/**
	 * Checks if is seventh pay valid before.
	 *
	 * @param seventhEntity      the seventh entity
	 * @param eventEffectiveDate the event effective date
	 * @return true, if is seventh pay valid before
	 * @throws ParseException the parse exception
	 */
	private boolean isSeventhPayValidBefore(PVUEmployeEventsEntity seventhEntity, Date eventEffectiveDate)
			throws ParseException {
		return (seventhEntity == null || seventhEntity.getEventDate() == null || PvuUtils.isBefter(eventEffectiveDate,
				PvuUtils.changeDateFormat(PvuUtils.convertLocalDateTimeToDate(seventhEntity.getEventDate()))));
	}

	/**
	 * Checks if is seventh pay valid after.
	 *
	 * @param seventhEntity      the seventh entity
	 * @param eventEffectiveDate the event effective date
	 * @return true, if is seventh pay valid after
	 * @throws ParseException the parse exception
	 */
	private boolean isSeventhPayValidAfter(PVUEmployeEventsEntity seventhEntity, Date eventEffectiveDate)
			throws ParseException {
		return (seventhEntity != null && seventhEntity.getEventDate() != null
				&& PvuUtils.isBefterOrEqual(
						PvuUtils.changeDateFormat(PvuUtils.convertLocalDateTimeToDate(seventhEntity.getEventDate())),
						eventEffectiveDate));
	}

	/**
	 * Checks if is sixth pay valid before.
	 *
	 * @param sixthEntity        the sixth entity
	 * @param eventEffectiveDate the event effective date
	 * @return true, if is sixth pay valid before
	 * @throws ParseException the parse exception
	 */
	private boolean isSixthPayValidBefore(PVUEmployeEventsEntity sixthEntity, Date eventEffectiveDate)
			throws ParseException {
		return (sixthEntity == null || sixthEntity.getEventDate() == null || PvuUtils.isBefter(eventEffectiveDate,
				PvuUtils.changeDateFormat(PvuUtils.convertLocalDateTimeToDate(sixthEntity.getEventDate()))));
	}

	/**
	 * Checks if is sixth pay valid after.
	 *
	 * @param sixthEntity        the sixth entity
	 * @param eventEffectiveDate the event effective date
	 * @return true, if is sixth pay valid after
	 * @throws ParseException the parse exception
	 */
	private boolean isSixthPayValidAfter(PVUEmployeEventsEntity sixthEntity, Date eventEffectiveDate)
			throws ParseException {
		return (sixthEntity != null && sixthEntity.getEventDate() != null
				&& PvuUtils.isBefterOrEqual(
						PvuUtils.changeDateFormat(PvuUtils.convertLocalDateTimeToDate(sixthEntity.getEventDate())),
						eventEffectiveDate));
	}

	/**
	 * Gets the commision name.
	 *
	 * @param payCommId the pay comm id
	 * @return the commision name
	 */
	private String getCommisionName(Long payCommId) {
		return eDPLuLookUpInfoRepository.findBylookUpInfoId(payCommId).getLookUpInfoName();
	}

	public static Date convertToDate(LocalDate dateToConvert) {
		return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Checks if is valid fifth before.
	 *
	 * @param fifthEntity        the fifth entity
	 * @param eventEffectiveDate the event effective date
	 * @return true, if is valid fifth before
	 * @throws ParseException the parse exception
	 */
	private boolean isValidFifthBefore(PVUEmployeEventsEntity fifthEntity, Date eventEffectiveDate)
			throws ParseException {
		return (fifthEntity != null && PvuUtils.isBefter(eventEffectiveDate,
				PvuUtils.changeDateFormat(PvuUtils.convertLocalDateTimeToDate(fifthEntity.getEventDate()))));
	}

	public void validatePayCommision(Long empId, Date eventEffectiveDate, Long comm, Date doj)
			throws CustomException, ParseException {

		if (comm == null || comm.equals(0l)) {
			return;
		}
		PVUEmployeEventsEntity fifthEntity = getEmpEventByEventId(empId, PvuConstant.FIFTH_COMMISSION_ID);
		PVUEmployeEventsEntity sixthEntity = getEmpEventByEventId(empId, PvuConstant.SIXTH_COMMISSION_ID);
		PVUEmployeEventsEntity seventhEntity = getEmpEventByEventId(empId, PvuConstant.SEVENTH_COMMISSION_ID);
		if (PvuUtils.isBefter(eventEffectiveDate, PvuUtils.changeDateFormat(doj))) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.COMMON_PAYCOMM_DOJ);
		}
		if (isValidFifthBefore(fifthEntity, eventEffectiveDate) && comm.equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.COMMON_PAYCOMM_INVALID, PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME));
		} else if (isSeventhPayValidAfter(seventhEntity, eventEffectiveDate)
				&& comm.equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.COMMON_PAYCOMM_CHANGEPAYCOMM);
		}
		getPayCommDatebyEffectiveDate(sixthEntity, seventhEntity, eventEffectiveDate, comm);
	}

	List<Long> getPayCommIdList(Long payCommId) {

		if (payCommId.equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			return Stream.of(PvuConstant.EMP_CREATION_EVENT_ID, PvuConstant.ROP_6PAY_EVENT_ID,
					PvuConstant.FIXPAY_TO_REGULAR_EVENT_ID, PvuConstant.ADHOC_TO_REGULAR_EVENT_ID,
					PvuConstant.PROBATIONARY_TO_REGULAR_EVENT_ID).collect(Collectors.toList());
		} else if (payCommId.equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			return Stream.of(PvuConstant.EMP_CREATION_EVENT_ID, PvuConstant.ROP_7PAY_EVENT_ID,
					PvuConstant.FIXPAY_TO_REGULAR_EVENT_ID, PvuConstant.ADHOC_TO_REGULAR_EVENT_ID,
					PvuConstant.PROBATIONARY_TO_REGULAR_EVENT_ID).collect(Collectors.toList());
		} else {
			return Stream.of(PvuConstant.EMP_CREATION_EVENT_ID, PvuConstant.FIXPAY_TO_REGULAR_EVENT_ID,
							PvuConstant.PROBATIONARY_TO_REGULAR_EVENT_ID, PvuConstant.ADHOC_TO_REGULAR_EVENT_ID)
					.collect(Collectors.toList());
		}
	}

	private void alreadyExitEmpOfFivePayDetailDisableByEmpId(PVUEmployePayDetailDtos dto) {

		if(dto.getPvuEmployeeJoiningPayDto().getJoinPayCommId() != null &&
				PvuConstant.FIFTH_COMMISSION_ID < dto.getPvuEmployeeJoiningPayDto().getJoinPayCommId()){
			Optional<PVUEmployeFivePayDetailEntity> optionEmp = pvuEmployeFivePayDetailRepositary
					.findOneByPvuEmployeEntityEmpIdAndActiveStatus(dto.getPvuEmployeeJoiningPayDto().getEmpId(),Constant.ACTIVE_STATUS);
			if(optionEmp.isPresent()) {
				PVUEmployeFivePayDetailEntity entity = optionEmp.get();
				entity.setActiveStatus(Constant.IN_ACTIVE_STATUS);
				pvuEmployeFivePayDetailRepositary.save(entity);
			}
		}
	}

}
