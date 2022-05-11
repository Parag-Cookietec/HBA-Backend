package gov.ifms.gst.service.impl;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.repository.LuLookUpInfoRepository;
import gov.ifms.gst.repository.LuLookUpRepository;
import gov.ifms.gst.dto.GSTLULookupDto;
import gov.ifms.gst.service.GSTLULookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GSTLULookupServiceImpl implements GSTLULookupService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	LuLookUpRepository luLookUpRepository;

	@Autowired
	LuLookUpInfoRepository luLookUpInfoRepository;

	@Override
	public List<GSTLULookupDto> fetchLookUpData(GSTLULookupDto lookUpDto) throws CustomException {
		try {
			Optional<EDPLuLookUpEntity> edpLuLookUpEntityOptional = Optional
					.ofNullable(luLookUpRepository.findByLookUpName(lookUpDto.getName()));
			if (edpLuLookUpEntityOptional.isPresent()) {
				EDPLuLookUpEntity edpLuLookUpEntity = edpLuLookUpEntityOptional.get();
				List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = luLookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(edpLuLookUpEntity.getLookUpId(),
								Constant.ACTIVE_STATUS);
				return eDPLuLookUpInfoEntities.stream().map(eDPLuLookUpInfoEntity -> {
					GSTLULookupDto lookUpData = new GSTLULookupDto();
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
