package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOLookUpDto;

public interface EDPDepartmentMstService {

	List<DMOLookUpDto> getAllDepartment() throws CustomException;

	List<DMOLookUpDto> getAllHODByDepartment(DMOLookUpDto dto) throws CustomException;

}
