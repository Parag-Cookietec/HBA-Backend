package gov.ifms.dmo.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOGRFCRFAccruedInterestPostDto;

public interface DMOGRFCRFAccruedInterestService {

	DMOGRFCRFAccruedInterestPostDto saveOrUpdateGRFCRFAccruedInterestReceived(DMOGRFCRFAccruedInterestPostDto dto)
			throws CustomException;

}
