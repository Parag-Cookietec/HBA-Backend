package gov.ifms.dmo.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMODPSheetT14BILLInvestPostDTO;

public interface DMODPSheetT14BILLService {

	DMODPSheetT14BILLInvestPostDTO saveDpSheetT14BILLInvest(DMODPSheetT14BILLInvestPostDTO dto) throws CustomException;

	DMODPSheetT14BILLInvestPostDTO saveDpSheetT14BILLMaturity(DMODPSheetT14BILLInvestPostDTO dto)
			throws CustomException;

	DMODPSheetT14BILLInvestPostDTO saveDpSheetT14BILLReDiscount(DMODPSheetT14BILLInvestPostDTO dto)
			throws CustomException;
}
