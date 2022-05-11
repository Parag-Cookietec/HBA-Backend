package gov.ifms.loc.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.loc.dto.LocCheckCancelHdrInfoDto;
import gov.ifms.loc.dto.LocChequeCancelDivListingDto;
import gov.ifms.loc.dto.LocChequeCancelEditViewDto;
import gov.ifms.loc.dto.LocChequeCancelHdrDto;
import gov.ifms.loc.dto.LocChequeCancelListDto;
import gov.ifms.loc.dto.LocChequeCancelListingDto;
import gov.ifms.loc.dto.LocChequeCancelSearchParamDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;

/**
 * The Class LocChequeCancelHdrController.
 *
 * @version v 1.0
 * @created 2021/03/05 17:12:26
 */
public interface LocChequeCancelService {

	/**
	 * Gets the cheque search details.
	 *
	 * @param dto the dto
	 * @return the cheque search details
	 * @throws CustomException the custom exception
	 */
	public LocChequeCancelListDto getChequeSearchDetails(LocChequeCancelListDto dto) throws CustomException;

	/**
	 * Gets the check cancel header info.
	 *
	 * @param dto the dto
	 * @return the check cancel header info
	 * @throws CustomException the custom exception
	 */
	public LocCheckCancelHdrInfoDto getCheckCancelHeaderInfo(IdDto dto) throws CustomException;

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	public LocChequeCancelSearchParamDto getSearchParam() throws CustomException;

	/**
	 * Save as draft.
	 *
	 * @param dto the dto
	 * @return the loc cheque cancel hdr dto
	 * @throws CustomException the custom exception
	 */
	LocChequeCancelHdrDto saveAsDraft(LocChequeCancelHdrDto dto) throws CustomException;

	/**
	 * Gets the edits the view data.
	 *
	 * @param dto the dto
	 * @return the edits the view data
	 * @throws CustomException the custom exception
	 */
	LocChequeCancelEditViewDto getEditViewData(LocChqBookEditViewDto dto) throws CustomException;

	/**
	 * Submit data.
	 *
	 * @param submitWfDto the submit wf dto
	 * @throws CustomException the custom exception
	 */
	public void submitData(LocSubmitWfDto submitWfDto) throws CustomException;

	/**
	 * Delete by id.
	 *
	 * @param dto the dto
	 * @return the id dto
	 * @throws CustomException the custom exception
	 */
	public IdDto deleteById(IdDto dto) throws CustomException;

	/**
	 * Gets the cheque cancel listing.
	 *
	 * @param pageDetail the page detail
	 * @return the cheque cancel listing
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocChequeCancelListingDto> getChequeCancelListing(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the cheque cancel div listing.
	 *
	 * @param pageDetail the page detail
	 * @return the cheque cancel div listing
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocChequeCancelDivListingDto> getChequeCancelDivListing(PageDetails pageDetail)
			throws CustomException;

}
