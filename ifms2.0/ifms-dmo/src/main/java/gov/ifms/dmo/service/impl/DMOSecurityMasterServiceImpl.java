package gov.ifms.dmo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.entity.DMOSecurityMasterEntity;
import gov.ifms.dmo.repository.DMOSecurityMasterRepository;
import gov.ifms.dmo.service.DMOSecurityMasterService;

@Service
public class DMOSecurityMasterServiceImpl implements DMOSecurityMasterService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOSecurityMasterRepository securityMasterRepository;

	@Override
	public List<DMOLookUpDto> fetchSecurityNames(DMOLookUpDto lookUpDto) throws CustomException {
		try {
			List<DMOSecurityMasterEntity> secrityNames = securityMasterRepository
					.findAllByActiveStatus(Constant.ACTIVE_STATUS);
			return secrityNames.stream().map(secMstEntity -> {
				DMOLookUpDto lookUpData = new DMOLookUpDto();
				lookUpData.setId(secMstEntity.getId());
				lookUpData.setName(secMstEntity.getSecurityName());
				return lookUpData;
			}).collect(Collectors.toList());
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
