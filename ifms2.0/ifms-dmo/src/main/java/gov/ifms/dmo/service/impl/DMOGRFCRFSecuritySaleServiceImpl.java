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
import gov.ifms.dmo.converter.DMOGRFCRFSecurityDtlConverter;
import gov.ifms.dmo.converter.DMOGRFCRFSecuritySaleConverter;
import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalePostDto;
import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalesBasePostDto;
import gov.ifms.dmo.entity.DMOGRFCRFSecurityDtlEntity;
import gov.ifms.dmo.entity.DMOGRFCRFSecuritySaleEntity;
import gov.ifms.dmo.repository.DMOGRFCRFSecurityDtlRespository;
import gov.ifms.dmo.repository.DMOGRFCRFSecuritySaleRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMOGRFCRFSecuritySaleService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;

@Service
public class DMOGRFCRFSecuritySaleServiceImpl implements DMOGRFCRFSecuritySaleService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOGRFCRFSecuritySaleRepository securitySaleRepository;

	@Autowired
	DMOGRFCRFSecurityDtlRespository securityDtlRespository;

	@Autowired
	DMOGRFCRFSecuritySaleConverter securitySaleConverter;

	@Autowired
	DMOGRFCRFSecurityDtlConverter securityDtlConverter;

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
	public DMOGRFCRFSecuritySalesBasePostDto saveOrUpdateGRFCRFSecuritySaleReceived(
			DMOGRFCRFSecuritySalesBasePostDto dto) throws CustomException {
		try {
			List<DMOGRFCRFSecuritySalePostDto> secSalesList = dto.getSalesSec().stream().map(saleSec -> {
				DMOGRFCRFSecuritySaleEntity securitySaleEntity = securitySaleConverter.toEntity(saleSec);
				DMOGRFCRFSecurityDtlEntity securitySaleDtlEntity = securityDtlConverter.toEntity(saleSec);
				DMOGRFCRFSecuritySaleEntity saveSecuritySaleEntity = securitySaleRepository.save(securitySaleEntity);
				securitySaleDtlEntity.setGrfCrfSecSaleId(saveSecuritySaleEntity.getId());
				DMOGRFCRFSecurityDtlEntity saveSecuritySaleDtlEntity = securityDtlRespository
						.save(securitySaleDtlEntity);
				DMOGRFCRFSecuritySalePostDto respDto = securitySaleConverter.toDTO(saveSecuritySaleEntity);
				respDto = securityDtlConverter.toDTO(saveSecuritySaleDtlEntity);
				respDto.setReferenceDt(LocalDateTime.now());
				respDto.setReferenceNo(generateTrnNo(DMOConstant.MLA_TRN_SCREEN));
				return respDto;
			}).collect(Collectors.toList());
			DMOGRFCRFSecuritySalesBasePostDto basePostDto = new DMOGRFCRFSecuritySalesBasePostDto();
			basePostDto.setSalesSec(secSalesList);
			return basePostDto;
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}

	}
}
