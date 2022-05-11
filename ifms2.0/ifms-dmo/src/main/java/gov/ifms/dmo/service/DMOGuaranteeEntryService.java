package gov.ifms.dmo.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOGuaranteeEntryBasePostDto;

public interface DMOGuaranteeEntryService {

	DMOGuaranteeEntryBasePostDto saveOrUpdateGuaranteeEntryReceived(DMOGuaranteeEntryBasePostDto dto) throws CustomException;

}
