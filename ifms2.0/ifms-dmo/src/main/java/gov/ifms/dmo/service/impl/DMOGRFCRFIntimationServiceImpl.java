package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMOGRFCRFAccountConverter;
import gov.ifms.dmo.converter.DMOGRFCRFIntimationConverter;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationSearchPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFIntimationEntity;
import gov.ifms.dmo.repository.DMOGRFCRFAccountRepository;
import gov.ifms.dmo.repository.DMOGRFCRFIntimationRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMOGRFCRFIntimationService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;

@Service
public class DMOGRFCRFIntimationServiceImpl implements DMOGRFCRFIntimationService {
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOGRFCRFIntimationRepository intimationRepository;

	@Autowired
	DMOGRFCRFAccountRepository accountRepository;

	@Autowired
	DMONSSFLoanRepository nssfLoanRepository;

	@Autowired
	DMOGRFCRFIntimationConverter intimationConverter;

	@Autowired
	DMOGRFCRFAccountConverter accountConverter;

	@Override
	public DMOGRFCRFIntimationPostDto saveOrUpdateGRFCRFLoanIntimationReceived(DMOGRFCRFIntimationPostDto dto)
			throws CustomException {
		try {

			if (StringUtils.isNotBlank(dto.getIntimationNo())) {
				String intimationNo = dto.getIntimationNo().trim();
				Optional<DMOGRFCRFIntimationEntity> intimationEntityOptional = Optional
						.ofNullable(intimationRepository.findByIntimationNo(intimationNo));
				if (intimationEntityOptional.isPresent()) {
					DMOGRFCRFIntimationEntity intimationEntity = intimationEntityOptional.get();
					intimationEntity.setAccountTypeId(dto.getAccountTypeId());
					intimationEntity.setAftThisProgPncpl(dto.getAftThisProgPncpl());
					intimationEntity.setIntimatedAmt(dto.getIntimatedAmt());
					intimationEntity.setIntimationDt(dto.getIntimationDt());
					intimationEntity.setTillDtProgPncpl(dto.getTillDtProgPncpl());
					intimationEntity.setTransactionDt(dto.getTransactionDt());
					intimationEntity.setTransactTypeId(dto.getTransactTypeId());

					DMOGRFCRFIntimationEntity saveIntimationEntity = intimationRepository.save(intimationEntity);
					return intimationConverter.toDTO(saveIntimationEntity);
				} else {
					DMOGRFCRFIntimationEntity intimationEntity = intimationConverter.toEntity(dto);
					intimationEntity.setReferenceDt(LocalDateTime.now());
					intimationEntity.setReferenceNo(generateTrnNo(DMOConstant.IPS_TRN_SCREEN));
					DMOGRFCRFIntimationEntity saveIntimationEntity = intimationRepository.save(intimationEntity);
					return intimationConverter.toDTO(saveIntimationEntity);
				}
			}
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
		return null;
	}

	private String generateTrnNo(String menuCode) {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, menuCode);
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> responseList = nssfLoanRepository.callStoredProcedure(procName, argMap);
		return DMOUtility.convertObjectToString(responseList.get(0)[0]);
	}

	@Override
	public DMOGRFCRFIntimationPostDto searchIntimationPurchaseSales(DMOGRFCRFIntimationSearchPostDto dto)
			throws CustomException {
		try {
			if (StringUtils.isNotBlank(dto.getIntimationNo())) {
				String intimationNo = dto.getIntimationNo().trim();
				Optional<DMOGRFCRFIntimationEntity> intimationEntityOptional = Optional
						.ofNullable(intimationRepository.findByIntimationNo(intimationNo));
				if (intimationEntityOptional.isPresent()) {
					DMOGRFCRFIntimationEntity intimationEntity = intimationEntityOptional.get();
					return intimationConverter.toDTO(intimationEntity);
				}
			}

		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return null;
	}

	@Override
	public Map<String, Double> getTillDtProgPrinContri() {
		Map<String, Double> porgPriContriMap = new HashMap<>();
		Optional<DMOGRFCRFIntimationEntity> intimationEntityOptional = Optional
				.ofNullable(intimationRepository.findOneByActiveStatusOrderByIdDesc());
		if (intimationEntityOptional.isPresent()) {
			DMOGRFCRFIntimationEntity intimationEntity = intimationEntityOptional.get();
			porgPriContriMap.put("progPriContriTillDt", intimationEntity.getTillDtProgPncpl());
		}
		return porgPriContriMap;
	}

}
