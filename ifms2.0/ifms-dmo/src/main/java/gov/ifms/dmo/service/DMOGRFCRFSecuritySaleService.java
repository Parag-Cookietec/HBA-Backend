package gov.ifms.dmo.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalesBasePostDto;

public interface DMOGRFCRFSecuritySaleService {

	DMOGRFCRFSecuritySalesBasePostDto saveOrUpdateGRFCRFSecuritySaleReceived(DMOGRFCRFSecuritySalesBasePostDto dto)
			throws CustomException;

}
