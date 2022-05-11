package gov.ifms.dmo.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMODPSheetWMAPostDTO;

public interface DMODPSheetWmaService {

	DMODPSheetWMAPostDTO saveDpSheetWmaAdv(DMODPSheetWMAPostDTO dto) throws CustomException;

	DMODPSheetWMAPostDTO saveDpSheetWmaInterest(DMODPSheetWMAPostDTO dto) throws CustomException;

	DMODPSheetWMAPostDTO saveDpSheetWmaPrincipal(DMODPSheetWMAPostDTO dto) throws CustomException;

}
