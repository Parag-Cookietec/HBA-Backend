package gov.ifms.dmo.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMODPSheetT91BILLInvestPostDTO;

public interface DMODPSheetT91BILLService {

	DMODPSheetT91BILLInvestPostDTO saveDpSheetT91BILLInvest(DMODPSheetT91BILLInvestPostDTO dto) throws CustomException;

	DMODPSheetT91BILLInvestPostDTO saveDpSheetT91BILLMaturity(DMODPSheetT91BILLInvestPostDTO dto)
			throws CustomException;

	DMODPSheetT91BILLInvestPostDTO saveDpSheetT91BILLReDisc(DMODPSheetT91BILLInvestPostDTO dto) throws CustomException;

}
