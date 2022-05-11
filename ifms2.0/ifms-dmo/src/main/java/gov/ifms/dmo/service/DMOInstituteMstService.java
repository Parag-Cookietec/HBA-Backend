package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOLookUpDto;

public interface DMOInstituteMstService {

	List<DMOLookUpDto> getAllInstitute() throws CustomException;

	List<DMOLookUpDto> getAllDesignation() throws CustomException;

	List<DMOLookUpDto> getAllPurpose() throws CustomException;

	List<DMOLookUpDto> getAllTreasury() throws CustomException;

	List<DMOLookUpDto> getAllFinancial() throws CustomException;

}
