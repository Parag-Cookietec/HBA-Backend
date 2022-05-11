package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOLookUpDto;

public interface DMOSecurityMasterService {

	List<DMOLookUpDto> fetchSecurityNames(DMOLookUpDto lookUpDto) throws CustomException;

}
