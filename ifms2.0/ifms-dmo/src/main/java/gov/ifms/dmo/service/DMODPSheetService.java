package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMODPSheetHDREntryPostDto;
import gov.ifms.dmo.dto.DMODPSheetHDRPostDto;
import gov.ifms.dmo.dto.DMOLookUpDto;

public interface DMODPSheetService {

	DMODPSheetHDREntryPostDto getLatestDPSheet() throws CustomException;

	Object deleteDpSheetDtl(IdDto idDto) throws CustomException;

	DMODPSheetHDREntryPostDto saveAsDraftDPSheet(DMODPSheetHDREntryPostDto dto) throws CustomException;

	PagebleDTO<DMODPSheetHDREntryPostDto> getDPSheetByCodeAndDateAndRcvdDt(DMODPSheetHDRPostDto dto)
			throws CustomException;

	List<DMOLookUpDto> fyDropDown();

}
