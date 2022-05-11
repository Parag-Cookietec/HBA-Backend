package gov.ifms.loc.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import gov.ifms.common.dto.ConditionDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.service.EDPMsOfficeService;
import gov.ifms.loc.entity.LocAccountCloseReqHdrEntity;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.entity.LocChequeBookHdrEntity;
import gov.ifms.loc.repository.LocAccountCloseReqHdrRepository;
import gov.ifms.loc.repository.LocAccountOpenReqHdrRepository;
import gov.ifms.loc.repository.LocChequeBookHdrRepository;
import gov.ifms.loc.service.LocWfConditionService;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocMessageConstant;

@Service
public class LocWfConditionServiceImpl implements LocWfConditionService {

	/**
	 * The Constant logger.
	 */
	private static final Logger log = LoggerFactory.getLogger(LocWfConditionServiceImpl.class);

	@Autowired
	private EDPMsOfficeService msOfficeService;

	/**
	 * The hdr repo.
	 */
	@Autowired
	private LocAccountOpenReqHdrRepository hdrRepo;

	/**
	 * The close hdr reo.
	 */
	@Autowired
	private LocAccountCloseReqHdrRepository closeHdrRepo;

	/**
	 * The close hdr reo.
	 */
	@Autowired
	private LocChequeBookHdrRepository chqBookRepo;

	@Override
	public String getLocOpenReqCondition(ConditionDto conditionDto) throws CustomException {
		List<String> condition = conditionDto.getCondition().stream().filter(str -> StringUtils.hasLength(str))
				.collect(Collectors.toList());
		LocAccountOpenReqHdrEntity lcHdr = hdrRepo.getOne(conditionDto.getTrnId());

		EDPMsOfficeDto parentOffice = msOfficeService.getParentOffice(lcHdr.getOfficeNameId().getOfficeId());
		for (String checkCondition : condition) {
			if (parentOffice.getIsCo().equals(Constant.LONG_TWO_VALUE)
					&& parentOffice.getIsHod().equals(Constant.LONG_TWO_VALUE)
					&& checkCondition.equalsIgnoreCase(Constant.BUDGET_NW_CON_IS_PARENT_CO)) {
				return Constant.BUDGET_NW_CON_IS_PARENT_CO;

			}
			if (checkCondition.equalsIgnoreCase(Constant.BUDGET_NW_CON_IS_PARENT_CO)
					&& parentOffice.getIsCo().equals(Constant.LONG_TWO_VALUE)) {
				return checkCondition;

			}
		}
		log.debug(conditionDto.getDefaultCondition());
		return conditionDto.getDefaultCondition();
	}

	@Override
	public String getLocCloseReqCondition(ConditionDto conditionDto) throws CustomException {
		List<String> condition = conditionDto.getCondition().stream().filter(str -> StringUtils.hasLength(str))
				.collect(Collectors.toList());
		LocAccountCloseReqHdrEntity lcHdr = closeHdrRepo.getOne(conditionDto.getTrnId());
		Long divId = closeHdrRepo.getDivId(lcHdr.getOfficeId().getOfficeId());
		EDPMsOfficeDto parentOffice = msOfficeService.getParentOffice(lcHdr.getOfficeId().getOfficeId());
		for (String checkCondition : condition) {
			if (checkCondition.equalsIgnoreCase(LocConstant.DIVISION_CHECK) && divId != null) {
				if (null != closeHdrRepo.checkDivChqActiveInactive(divId)) {
					customExpThrow();
				}
				if (null != closeHdrRepo.checkDivDistribution(divId)) {
					customExpThrow();
				}
				if (null != closeHdrRepo.checkDivAdvicePrep(divId)) {
					customExpThrow();
				}
			}
			if (parentOffice.getIsCo().equals(Constant.LONG_TWO_VALUE)
					&& parentOffice.getIsHod().equals(Constant.LONG_TWO_VALUE)
					&& checkCondition.equalsIgnoreCase(Constant.BUDGET_NW_CON_IS_PARENT_CO)) {
				return Constant.BUDGET_NW_CON_IS_PARENT_CO;

			}
			if (checkCondition.equalsIgnoreCase(Constant.BUDGET_NW_CON_IS_PARENT_CO)
					&& parentOffice.getIsCo().equals(Constant.LONG_TWO_VALUE)) {
				return checkCondition;

			}

		}
		return conditionDto.getDefaultCondition();
	}

	/**
	 * Custom exp throw.
	 *
	 * @throws CustomException the custom exception
	 */
	private void customExpThrow() throws CustomException {
		throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_UNDER_TRANSACTION);

	}

	@Override
	public String getLocChequebookActInactCondition(ConditionDto conditionDto) throws CustomException {
		List<String> condition = conditionDto.getCondition().stream().filter(str -> StringUtils.hasLength(str))
				.collect(Collectors.toList());
		for (String checkCondition : condition) {
			if (checkCondition.equalsIgnoreCase(LocConstant.DIVISION_CHECK)) {
				this.divisionValidation(
						chqBookRepo.findByActiveStatusAndId(Constant.ACTIVE_STATUS, conditionDto.getTrnId()));
			}
		}
		return conditionDto.getDefaultCondition();
	}

	/**
	 * Division validation.
	 *
	 * @param hdrEntity the hdr entity
	 * @throws CustomException the custom exception
	 */
	private void divisionValidation(LocChequeBookHdrEntity hdrEntity) throws CustomException {
		List<String> startChqSer = chqBookRepo.getChequeStartSer(hdrEntity.getId());
		List<Long> strtChqSer = startChqSer.stream().map(e -> {
			return new Long(e.split("-")[1]);
		}).collect(Collectors.toList());

		List<String> endSeries = chqBookRepo.getLowSeries(hdrEntity.getId(), hdrEntity.getDivId().getDivisonId());
		List<Long> endSer = endSeries.stream().map(e -> {
			return new Long(e.split("-")[1]);
		}).collect(Collectors.toList());

		for (Long chqSer : strtChqSer) {
			for (Long endSr : endSer) {
				if (chqSer < endSr) {

					throw new CustomException(HttpStatus.CONFLICT,
							LocMessageConstant.LOC_CHEQUEBOOK_ONGOING_LOWER_CHEQUE_SERIES);

				}
			}
		}
	}

}