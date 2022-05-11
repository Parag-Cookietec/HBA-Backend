package gov.ifms.loc.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.loc.dto.LocCheckToCheckHdrInfoDto;
import gov.ifms.loc.dto.LocChequeToChequeEditViewDto;
import gov.ifms.loc.dto.LocChequeToChequeHDRDto;
import gov.ifms.loc.dto.LocChequeToChequeListingDto;
import gov.ifms.loc.dto.LocChequeToChequeSearchDto;
import gov.ifms.loc.dto.LocChequeToChequeSrchData;
import gov.ifms.loc.dto.LocChqToChqDto;
import gov.ifms.loc.dto.LocSubmitWfDto;

/**
 * The Interface LocChequeToCheque.
 */
public interface LocChequeToChequeService {

	/**
	 * Save as draft.
	 *
	 * @param dto the dto
	 * @return the loccheque To cheque hdr dto
	 * @throws CustomException the custom exception
	 */
	LocChequeToChequeHDRDto saveAsDraft(LocChequeToChequeHDRDto dto) throws CustomException;

	/**
	 * Gets the cheque To cheque header info.
	 *
	 * @param dto the dto
	 * @return the cheque To cheque header info
	 * @throws CustomException the custom exception
	 */
	public LocCheckToCheckHdrInfoDto getCheckToCheckHeaderInfo(IdDto dto) throws CustomException;

	/**
	 * Gets the cheque To cheque listing.
	 *
	 * @param pageDetail the page detail
	 * @return the cheque To cheque listing
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocChequeToChequeListingDto> getChequeToChequeListing(PageDetails pageDetail)
			throws CustomException;

	/**
	 * Gets the cheque data.
	 *
	 * @param dto the dto
	 * @return the cheque data
	 * @throws CustomException the custom exception
	 */
	public LocChequeToChequeSrchData getChequeData(LocChequeToChequeHDRDto dto) throws CustomException;

	/**
	 * Gets the edits the view.
	 *
	 * @param dto the dto
	 * @return the edits the view
	 * @throws CustomException the custom exception
	 */
	public LocChqToChqDto getEditView(LocChequeToChequeEditViewDto dto) throws CustomException;

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
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */

	public LocChequeToChequeSearchDto getSearchParam() throws CustomException;

	/**
	 * Delete cheque.
	 *
	 * @param dto the dto
	 * @return the id dto
	 * @throws CustomException the custom exception
	 */
	public IdDto deleteCheque(IdDto dto) throws CustomException;
}
