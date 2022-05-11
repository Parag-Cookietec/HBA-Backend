package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMOGuaranteeEntryConverter;
import gov.ifms.dmo.dto.DMOGuaranteeEntryBasePostDto;
import gov.ifms.dmo.dto.DMOGuaranteeEntryPostDto;
import gov.ifms.dmo.entity.DMOGuaranteeEntryEntity;
import gov.ifms.dmo.repository.DMOGuaranteeEntryRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMOGuaranteeEntryService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;

@Service
public class DMOGuaranteeEntryServiceImpl implements DMOGuaranteeEntryService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOGuaranteeEntryConverter dmoGuaranteeEntryConverter;

	@Autowired
	DMOGuaranteeEntryRepository dmoGuaranteeEntryRepository;

	@Autowired
	DMONSSFLoanRepository nssfLoanRepository;
	private String generateTrnNo(String menuCode) {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, menuCode);
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> responseList = nssfLoanRepository.callStoredProcedure(procName, argMap);
		return DMOUtility.convertObjectToString(responseList.get(0)[0]);
	}

	@Override
	public DMOGuaranteeEntryBasePostDto saveOrUpdateGuaranteeEntryReceived(DMOGuaranteeEntryBasePostDto dto)
			throws CustomException {
		try {
			List<DMOGuaranteeEntryPostDto> guaranteeList = dto.getGuaranteeList().stream().map(gurantee -> {
				DMOGuaranteeEntryEntity gurEntryEntity = dmoGuaranteeEntryConverter.toEntity(gurantee);
				DMOGuaranteeEntryEntity saveGurEntryEntity = dmoGuaranteeEntryRepository.save(gurEntryEntity);
				DMOGuaranteeEntryPostDto respDto = dmoGuaranteeEntryConverter.toDTO(saveGurEntryEntity);
				respDto.setReferenceDt(LocalDateTime.now());
				respDto.setReferenceNo(generateTrnNo(DMOConstant.GE_TRN_SCREEN));
				return respDto;
			}).collect(Collectors.toList());
			DMOGuaranteeEntryBasePostDto basePostDto = new DMOGuaranteeEntryBasePostDto();
			basePostDto.setGuaranteeList(guaranteeList);
			return basePostDto;
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

}
