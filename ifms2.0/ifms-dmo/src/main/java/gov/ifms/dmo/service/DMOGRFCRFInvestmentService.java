package gov.ifms.dmo.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOGRFCRFInvestmentPostDto;

public interface DMOGRFCRFInvestmentService {

	DMOGRFCRFInvestmentPostDto saveOrUpdateGRFCRFAdviceInvestmentReceived(DMOGRFCRFInvestmentPostDto dto) throws CustomException;

}
