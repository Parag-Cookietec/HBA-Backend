package gov.ifms.dmo.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.service.DMOGRFCRFLuLookUpService;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPLuLookUpRepository;

@Service
public class DMOGRFCRFLuLookUpServiceImpl implements DMOGRFCRFLuLookUpService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	EDPLuLookUpRepository edpLuLookUpRepository;

	@Autowired
	EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Override
	public List<DMOLookUpDto> fetchLookUpData(DMOLookUpDto lookUpDto) throws CustomException {
		try {
			Optional<EDPLuLookUpEntity> edpLuLookUpEntityOptional = Optional
					.ofNullable(edpLuLookUpRepository.findByLookUpName(lookUpDto.getName()));
			if (edpLuLookUpEntityOptional.isPresent()) {
				EDPLuLookUpEntity edpLuLookUpEntity = edpLuLookUpEntityOptional.get();
				List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = edpLuLookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(edpLuLookUpEntity.getLookUpId(),
								Constant.ACTIVE_STATUS);
				return eDPLuLookUpInfoEntities.stream().map(eDPLuLookUpInfoEntity -> {
					DMOLookUpDto lookUpData = new DMOLookUpDto();
					lookUpData.setId(eDPLuLookUpInfoEntity.getLookUpInfoId());
					lookUpData.setName(eDPLuLookUpInfoEntity.getLookUpInfoName());
					return lookUpData;
				}).collect(Collectors.toList());
			}
			return Collections.emptyList();
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
