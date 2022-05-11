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
import gov.ifms.dmo.converter.DMOGRFCRFInvestmentConverter;
import gov.ifms.dmo.dto.DMOGRFCRFInvestmentPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFInvestmentEntity;
import gov.ifms.dmo.repository.DMOGRFCRFInvestmentRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMOGRFCRFInvestmentService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;

@Service
public class DMOGRFCRFInvestmentServiceImpl implements DMOGRFCRFInvestmentService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOGRFCRFInvestmentRepository investmentRepository;

	@Autowired
	DMOGRFCRFInvestmentConverter investmentConverter;

	@Autowired
	DMONSSFLoanRepository nssfLoanRepository;

	@Override
	public DMOGRFCRFInvestmentPostDto saveOrUpdateGRFCRFAdviceInvestmentReceived(DMOGRFCRFInvestmentPostDto dto)
			throws CustomException {
		try {
			DMOGRFCRFInvestmentEntity investmentEntity = investmentConverter.toEntity(dto);
			investmentEntity.setReferenceDt(LocalDateTime.now());
			investmentEntity.setReferenceNo(generateTrnNo(DMOConstant.RAFI_TRN_SCREEN));
			DMOGRFCRFInvestmentEntity saveInvestmentEntityEntity = investmentRepository.save(investmentEntity);
			return investmentConverter.toDTO(saveInvestmentEntityEntity);
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
