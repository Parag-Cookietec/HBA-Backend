package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOLookUpDto;

public interface DMOGRFCRFLuLookUpService {

	List<DMOLookUpDto> fetchLookUpData(DMOLookUpDto lookUpDto) throws CustomException;

}
