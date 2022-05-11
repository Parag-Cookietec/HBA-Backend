package gov.ifms.gst.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.dto.GSTBankWisePenalInterestDto;
import gov.ifms.gst.dto.PenalInterestLstResDto;
import gov.ifms.gst.dto.PenalIntrestEntryDto;

import java.util.List;

public interface GSTPenalInterestService {

	/**
	 * Fetch Bank wise Monthly Penal interest and remaining amount using Month and Year
	 * 
	 * @param bankId
	 * @param month
	 * @param year 
	 * @return dto
	 */
	GSTBankWisePenalInterestDto getBankwisePenalInterestUsingMonthAndYear(Long bankId, Long month, Long year);

    PagebleDTO<PenalIntrestEntryDto> listingPenalInterest(PageDetails pageDetail) throws CustomException;

    /**
	 * Save Penal interest data
	 *
	 */
	PenalIntrestEntryDto savePenalInterest(PenalIntrestEntryDto dto) throws CustomException;


	PenalIntrestEntryDto getById(Long id);

    void deleteById(Long id);

	PagebleDTO<PenalInterestLstResDto> getPenalInterestWfList(PageDetails pageDetail) throws CustomException;
}
