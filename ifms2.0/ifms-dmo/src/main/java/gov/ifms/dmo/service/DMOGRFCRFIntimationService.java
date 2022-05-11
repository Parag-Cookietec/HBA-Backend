package gov.ifms.dmo.service;

import java.util.Map;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationSearchPostDto;

public interface DMOGRFCRFIntimationService {

	DMOGRFCRFIntimationPostDto saveOrUpdateGRFCRFLoanIntimationReceived(DMOGRFCRFIntimationPostDto dto) throws CustomException;

	DMOGRFCRFIntimationPostDto searchIntimationPurchaseSales(DMOGRFCRFIntimationSearchPostDto dto) throws CustomException;
	Map<String, Double> getTillDtProgPrinContri();
}
