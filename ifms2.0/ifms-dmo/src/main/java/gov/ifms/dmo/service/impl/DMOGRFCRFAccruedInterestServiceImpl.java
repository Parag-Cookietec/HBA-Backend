package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMOGRFCRFAccruedInterestConverter;
import gov.ifms.dmo.dto.DMOGRFCRFAccruedInterestPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFAccruedInterestEntity;
import gov.ifms.dmo.repository.DMOGRFCRFAccruedInterestRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMOGRFCRFAccruedInterestService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;

@Service
public class DMOGRFCRFAccruedInterestServiceImpl implements DMOGRFCRFAccruedInterestService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOGRFCRFAccruedInterestRepository accruedInterestRepository;

	@Autowired
	DMONSSFLoanRepository nssfLoanRepository;

	@Autowired
	DMOGRFCRFAccruedInterestConverter accruedInterestConverter;

	@Override
	public DMOGRFCRFAccruedInterestPostDto saveOrUpdateGRFCRFAccruedInterestReceived(
			DMOGRFCRFAccruedInterestPostDto dto) throws CustomException {
		try {
			DMOGRFCRFAccruedInterestEntity accruedInterestEntity = accruedInterestConverter.toEntity(dto);
			DMOGRFCRFAccruedInterestEntity saveAccruedInterestEntity = accruedInterestRepository
					.save(accruedInterestEntity);
			DMOGRFCRFAccruedInterestPostDto respDto = accruedInterestConverter.toDTO(saveAccruedInterestEntity);
			respDto.setReferenceDt(LocalDateTime.now());
			respDto.setReferenceNo(generateTrnNo(DMOConstant.RAMI_TRN_SCREEN));
			return respDto;
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	private String generateTrnNo(String menuCode) {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, menuCode);
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> responseList = nssfLoanRepository.callStoredProcedure(procName, argMap);
		return DMOUtility.convertObjectToString(responseList.get(0)[0]);
	}
}
