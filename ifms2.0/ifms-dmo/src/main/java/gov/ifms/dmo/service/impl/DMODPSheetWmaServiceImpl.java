package gov.ifms.dmo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMODPSheetWMAAdvanceConverter;
import gov.ifms.dmo.converter.DMODPSheetWMAInterestConverter;
import gov.ifms.dmo.converter.DMODPSheetWMAPrincipalConverter;
import gov.ifms.dmo.dto.DMODPSheetWMAPostDTO;
import gov.ifms.dmo.entity.DMODPSheetWMAAdvanceEntity;
import gov.ifms.dmo.entity.DMODPSheetWMAInterestEntity;
import gov.ifms.dmo.entity.DMODPSheetWMAPrincipalEntity;
import gov.ifms.dmo.repository.DMODPSheetWMAAdvanceRepository;
import gov.ifms.dmo.repository.DMODPSheetWMAInterestRepository;
import gov.ifms.dmo.repository.DMODPSheetWMAPrincipalRepository;
import gov.ifms.dmo.service.DMODPSheetWmaService;

@Service
public class DMODPSheetWmaServiceImpl implements DMODPSheetWmaService {

	@Autowired
	private DMODPSheetWMAAdvanceRepository wmaAdvanceRepository;
	@Autowired
	private DMODPSheetWMAInterestRepository wmaInterestRepository;
	@Autowired
	private DMODPSheetWMAPrincipalRepository wmaPrincipalRepository;
	@Autowired
	private DMODPSheetWMAAdvanceConverter wmaAdvanceConverter;
	@Autowired
	private DMODPSheetWMAPrincipalConverter wmaPrincipalConverter;
	@Autowired
	private DMODPSheetWMAInterestConverter wmaInterestConverter;

	@Override
	public DMODPSheetWMAPostDTO saveDpSheetWmaAdv(DMODPSheetWMAPostDTO dto) throws CustomException {
		try {
			DMODPSheetWMAAdvanceEntity entity = wmaAdvanceConverter.toEntity(dto);
			return wmaAdvanceConverter.toDTO(wmaAdvanceRepository.save(entity));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public DMODPSheetWMAPostDTO saveDpSheetWmaInterest(DMODPSheetWMAPostDTO dto) throws CustomException {
		try {
			DMODPSheetWMAInterestEntity entity = wmaInterestConverter.toEntity(dto);
			return wmaInterestConverter.toDTO(wmaInterestRepository.save(entity));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public DMODPSheetWMAPostDTO saveDpSheetWmaPrincipal(DMODPSheetWMAPostDTO dto) throws CustomException {
		try {
			DMODPSheetWMAPrincipalEntity entity = wmaPrincipalConverter.toEntity(dto);
			return wmaPrincipalConverter.toDTO(wmaPrincipalRepository.save(entity));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

}
