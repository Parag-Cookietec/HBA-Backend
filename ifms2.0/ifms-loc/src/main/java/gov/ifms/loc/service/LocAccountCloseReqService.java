package gov.ifms.loc.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.loc.dto.LocAccCloseReqHdrDto;
import gov.ifms.loc.dto.LocAccountCloseReqHdrDto;
import gov.ifms.loc.dto.LocAccountCloseViewDto;
import gov.ifms.loc.dto.LocAcctClsSrchPrmDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocCloseReqListDto;
import gov.ifms.loc.dto.LocCloseRequestEditViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;

/**
 * The Interface LocAccountCloseReqService.
 */
public interface LocAccountCloseReqService {

	/**
	 * Gets the account close req dtl.
	 *
	 * @param officeId     the office id
	 * @param departmentId the department id
	 * @param cardexNo     the cardex no
	 * @param ddoNo        the ddo no
	 * @return the account close req dtl
	 */
	LocAccCloseReqHdrDto getAccountCloseReqDtl(Long officeId, Long departmentId, Long cardexNo, Long ddoNo ,Long districtId) throws CustomException;

	/**
	 * Creates the loc acc close req hdr.
	 *
	 * @param dto the dto
	 * @return the loc account close req hdr dto
	 * @throws CustomException the custom exception
	 */
	LocAccountCloseReqHdrDto createLocAccCloseReqHdr(LocAccountCloseReqHdrDto dto) throws CustomException;

	/**
	 * Gets the account close edit dtl. 
	 *
	 * @param dto the dto
	 * @return the account close edit dtl
	 * @throws CustomException the custom exception
	 */
	LocCloseRequestEditViewDto getAccountCloseEditDtl(LocChqBookEditViewDto dto) throws CustomException;

	/**
	 * Gets the open listing data.
	 *
	 * @param dto the dto
	 * @return the open listing data
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<LocCloseReqListDto> getClosingListingData(PageDetails dto) throws CustomException;

	/**
	 * Submit data.
	 *
	 * @param submitWfDto the submit wf dto
	 * @throws CustomException the custom exception
	 */
	void submitData(LocSubmitWfDto submitWfDto) throws CustomException;

	/**
	 * Gets the srch param.
	 *
	 * @return the srch param
	 * @throws CustomException the custom exception
	 */
	LocAcctClsSrchPrmDto getSrchParam() throws CustomException;

	/**
	 * Delete by id.
	 *
	 * @param dto the dto
	 * @return the id dto
	 * @throws CustomException the custom exception
	 */
	IdDto deleteById(IdDto dto) throws CustomException;

	/**
	 * Gets the closing request view.
	 *
	 * @param dto the dto
	 * @return the closing request view
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<LocAccountCloseViewDto> getclosingRequestView(PageDetails dto) throws CustomException;

}
