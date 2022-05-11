package gov.ifms.dmo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMODPSheetT14BILLInvestConverter;
import gov.ifms.dmo.converter.DMODPSheetT14BILLMatureConverter;
import gov.ifms.dmo.converter.DMODPSheetT14BILLReDiscConverter;
import gov.ifms.dmo.dto.DMODPSheetT14BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT14BILLInvestEntity;
import gov.ifms.dmo.entity.DMODPSheetT14BILLMatureEntity;
import gov.ifms.dmo.entity.DMODPSheetT14BILLRediscEntity;
import gov.ifms.dmo.repository.DMODPSheetT14BILLInvestRepository;
import gov.ifms.dmo.repository.DMODPSheetT14BILLMatureRepository;
import gov.ifms.dmo.repository.DMODPSheetT14BILLRediscRepository;
import gov.ifms.dmo.service.DMODPSheetT14BILLService;

@Service
public class DMODPSheetT14BILLServiceImpl implements DMODPSheetT14BILLService {

	@Autowired
	private DMODPSheetT14BILLInvestConverter t14BillinvestConverter;

	@Autowired
	private DMODPSheetT14BILLMatureConverter t14BillMatureConverter;

	@Autowired
	private DMODPSheetT14BILLReDiscConverter t14BillRediscConverter;

	@Autowired
	private DMODPSheetT14BILLInvestRepository t14billInvestRepository;

	@Autowired
	private DMODPSheetT14BILLMatureRepository t14billMatureRepository;

	@Autowired
	private DMODPSheetT14BILLRediscRepository t14billRediscRepository;

	@Override
	public DMODPSheetT14BILLInvestPostDTO saveDpSheetT14BILLInvest(DMODPSheetT14BILLInvestPostDTO dto)
			throws CustomException {
		try {
			DMODPSheetT14BILLInvestEntity entity = t14BillinvestConverter.toEntity(dto);
			return t14BillinvestConverter.toDTO(t14billInvestRepository.save(entity));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}

	}

	@Override
	public DMODPSheetT14BILLInvestPostDTO saveDpSheetT14BILLMaturity(DMODPSheetT14BILLInvestPostDTO dto)
			throws CustomException {
		try {
			DMODPSheetT14BILLInvestPostDTO postDTO = new DMODPSheetT14BILLInvestPostDTO();
			List<DMODPSheetT14BILLMatureEntity> entities = t14BillMatureConverter.toEntity(dto.getData());
			postDTO.setData(t14BillMatureConverter.toDTO(t14billMatureRepository.saveAll(entities)));
			return postDTO;

		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}

	}

	@Override
	public DMODPSheetT14BILLInvestPostDTO saveDpSheetT14BILLReDiscount(DMODPSheetT14BILLInvestPostDTO dto)
			throws CustomException {
		try {
			DMODPSheetT14BILLInvestPostDTO postDTO = new DMODPSheetT14BILLInvestPostDTO();
			List<DMODPSheetT14BILLRediscEntity> entities = t14BillRediscConverter.toEntity(dto.getData());
			postDTO.setData(t14BillRediscConverter.toDTO(t14billRediscRepository.saveAll(entities)));
			return postDTO;

		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}

	}

}
