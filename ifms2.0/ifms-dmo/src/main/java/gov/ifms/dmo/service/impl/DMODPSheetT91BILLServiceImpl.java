package gov.ifms.dmo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMODPSheetT91BILLInvestConverter;
import gov.ifms.dmo.converter.DMODPSheetT91BILLMatureConverter;
import gov.ifms.dmo.converter.DMODPSheetT91BILLRediscConverter;
import gov.ifms.dmo.dto.DMODPSheetT91BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT91BILLInvestEntity;
import gov.ifms.dmo.entity.DMODPSheetT91BILLMatureEntity;
import gov.ifms.dmo.entity.DMODPSheetT91BILLRediscEntity;
import gov.ifms.dmo.repository.DMODPSheetT91BILLInvestRepository;
import gov.ifms.dmo.repository.DMODPSheetT91BILLMatureRepository;
import gov.ifms.dmo.repository.DMODPSheetT91BILLRediscRepository;
import gov.ifms.dmo.service.DMODPSheetT91BILLService;

@Service
public class DMODPSheetT91BILLServiceImpl implements DMODPSheetT91BILLService {

	@Autowired
	private DMODPSheetT91BILLInvestConverter t91InvestConverter;

	@Autowired
	private DMODPSheetT91BILLMatureConverter t91MatureConverter;

	@Autowired
	private DMODPSheetT91BILLRediscConverter t91RediscConverter;

	@Autowired
	private DMODPSheetT91BILLInvestRepository t91InvestRepository;

	@Autowired
	private DMODPSheetT91BILLMatureRepository t91MatureRepository;

	@Autowired
	private DMODPSheetT91BILLRediscRepository t91RediscRepository;

	@Override
	public DMODPSheetT91BILLInvestPostDTO saveDpSheetT91BILLInvest(DMODPSheetT91BILLInvestPostDTO dto)
			throws CustomException {
		try {
			DMODPSheetT91BILLInvestEntity entity = t91InvestConverter.toEntity(dto);
			return t91InvestConverter.toDTO(t91InvestRepository.save(entity));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public DMODPSheetT91BILLInvestPostDTO saveDpSheetT91BILLMaturity(DMODPSheetT91BILLInvestPostDTO dto)
			throws CustomException {
		try {
			DMODPSheetT91BILLInvestPostDTO postDTO = new DMODPSheetT91BILLInvestPostDTO();
			List<DMODPSheetT91BILLMatureEntity> entities = t91MatureConverter.toEntity(dto.getData());
			postDTO.setData(t91MatureConverter.toDTO(t91MatureRepository.saveAll(entities)));
			return postDTO;
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public DMODPSheetT91BILLInvestPostDTO saveDpSheetT91BILLReDisc(DMODPSheetT91BILLInvestPostDTO dto)
			throws CustomException {
		try {
			DMODPSheetT91BILLInvestPostDTO postDTO = new DMODPSheetT91BILLInvestPostDTO();
			List<DMODPSheetT91BILLRediscEntity> entities = t91RediscConverter.toEntity(dto.getData());
			postDTO.setData(t91RediscConverter.toDTO(t91RediscRepository.saveAll(entities)));
			return postDTO;
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

}
