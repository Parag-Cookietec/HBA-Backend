/*
 * 
 */
package gov.ifms.loc.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.loc.dto.LocChequeBookHdrDto;
import gov.ifms.loc.dto.LocChequeBookHdrInfoDto;
import gov.ifms.loc.dto.LocChqBookData;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocChqBookList;
import gov.ifms.loc.dto.LocChqBookListingDto;
import gov.ifms.loc.dto.LocChqBookSrchPrmDto;
import gov.ifms.loc.dto.LocChqDtlDto;
import gov.ifms.loc.dto.LocSubmitWfDto;

/**
 * The Interface LocChqDtlService.
 */
public interface LocChequeBookService {

	/**
	 * Save draft.
	 *
	 * @param dto the dto
	 * @return the loc cheque book hdr dto
	 * @throws CustomException the custom exception
	 */
	public LocChequeBookHdrDto saveDraft(LocChequeBookHdrDto dto) throws CustomException;

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	public LocChqBookSrchPrmDto getSearchParam() throws CustomException;

	/**
	 * Submit data.
	 *
	 * @param submitWfDto the submit wf dto
	 * @throws CustomException the custom exception
	 */
	public void submitData(LocSubmitWfDto submitWfDto) throws CustomException;

	/**
	 * Gets the cheque book data.
	 *
	 * @param dto the dto
	 * @return the cheque book data
	 * @throws CustomException the custom exception
	 */
	public LocChqBookData getChequeBookData(LocChqDtlDto dto) throws CustomException;

	/**
	 * Gets the cheque book list.
	 *
	 * @param dto the dto
	 * @return the cheque book list
	 * @throws CustomException the custom exception
	 */
	public LocChqBookList getChequeBookList(LocChqDtlDto dto) throws CustomException;

	/**
	 * Gets the edits the view.
	 *
	 * @param dto the dto
	 * @return the edits the view
	 * @throws CustomException the custom exception
	 */
	public LocChequeBookHdrDto getEditView(LocChqBookEditViewDto dto) throws CustomException;

	/**
	 * Gets the listing data.
	 *
	 * @param pageDetails the page details
	 * @return the listing data
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocChqBookListingDto> getListingData(PageDetails pageDetails) throws CustomException;

	/**
	 * Gets the header info.
	 *
	 * @param dto the dto
	 * @return the header info
	 * @throws CustomException the custom exception
	 */
	public LocChequeBookHdrInfoDto getHeaderInfo(IdDto dto) throws CustomException;

	/**
	 * Url delete.
	 *
	 * @param dto the dto
	 * @return the id dto
	 * @throws CustomException the custom exception
	 */
	public IdDto deleteById(IdDto dto) throws CustomException;

}
