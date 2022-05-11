package gov.ifms.loc.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.loc.dto.LocActiveDeductionEditViewDto;
import gov.ifms.loc.dto.LocAdvcPrepCheqPaySdDto;
import gov.ifms.loc.dto.LocAdviceAmountDto;
import gov.ifms.loc.dto.LocAdviceAuthorizationListingDto;
import gov.ifms.loc.dto.LocAdviceCardexVerificationListingDto;
import gov.ifms.loc.dto.LocAdviceChqEpayList;
import gov.ifms.loc.dto.LocAdviceChqTypeListDto;
import gov.ifms.loc.dto.LocAdviceChqTypeSrchList;
import gov.ifms.loc.dto.LocAdviceDeductionDto;
import gov.ifms.loc.dto.LocAdviceDeductionSdDto;
import gov.ifms.loc.dto.LocAdviceDtlDataDto;
import gov.ifms.loc.dto.LocAdviceDtlEditViewDto;
import gov.ifms.loc.dto.LocAdviceEpayChqDtlDto;
import gov.ifms.loc.dto.LocAdviceHdrInfoDto;
import gov.ifms.loc.dto.LocAdviceInwardListingDto;
import gov.ifms.loc.dto.LocAdviceMapEpymntEditViewDto;
import gov.ifms.loc.dto.LocAdvicePartHeadwisedetaisSdDto;
import gov.ifms.loc.dto.LocAdvicePaymntLCSearchDto;
import gov.ifms.loc.dto.LocAdvicePostingDtlsEditViewDto;
import gov.ifms.loc.dto.LocAdvicePostingHeadwisedetaisDto;
import gov.ifms.loc.dto.LocAdvicePrepHdrDto;
import gov.ifms.loc.dto.LocAdvicePrepListingDto;
import gov.ifms.loc.dto.LocAdvicePrepMultipleDto;
import gov.ifms.loc.dto.LocAdvicePreparationPaymentDtlsDto;
import gov.ifms.loc.dto.LocAdviceReqParamDto;
import gov.ifms.loc.dto.LocAdviceSrchParamDto;
import gov.ifms.loc.dto.LocAdviceVerificationListingDto;
import gov.ifms.loc.dto.LocAdviceVerifyAuthSearchParam;
import gov.ifms.loc.dto.LocCheckPayEditViewDto;
import gov.ifms.loc.dto.LocCheckPayPaymentDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocIdNameDto;
import gov.ifms.loc.dto.LocInwardCardexSrchParamDto;
import gov.ifms.loc.dto.LocMsAdviceDtlDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.workflow.dto.LocPaymentDtlsDto;

/**
 * The Interface LocAdvicePrepService.
 */
public interface LocAdvicePrepService {

	/**
	 * Gets the posting dtls search lc.
	 *
	 * @param dto the dto
	 * @return the posting dtls search lc
	 * @throws CustomException the custom exception
	 */
	public List<LocAdvicePaymntLCSearchDto> getPostingDtlsSearchLc(LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException;

	/**
	 * Gets the posting dtl map epymt.
	 *
	 * @param dto the dto
	 * @return the posting dtl map epymt
	 * @throws CustomException the custom exception
	 */
	public List<LocAdviceMapEpymntEditViewDto> getPostingDtlMapEpymt(LocChqBookEditViewDto dto) throws CustomException;

	/**
	 * Gets the posting dtl updt epymnt amnt.
	 *
	 * @param dtoList the dto list
	 * @return the posting dtl updt epymnt amnt
	 * @throws CustomException the custom exception
	 */
	public List<LocAdvcPrepCheqPaySdDto> getPostingDtlUpdtEpymntAmnt(List<LocAdvcPrepCheqPaySdDto> dtoList)
			throws CustomException;

	/**
	 * Gets the advice prep listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice prep listing
	 * @throws CustomException the custom exception
	 * @throws ParseException 
	 */
	public PagebleDTO<LocAdvicePrepListingDto> getAdvicePrepListing(PageDetails pageDetail) throws CustomException, ParseException;

	/**
	 * Gets the all demand list.
	 *
	 * @param dto the dto
	 * @return the all demand list
	 * @throws CustomException the custom exception
	 */
	public List<LocPaymentDtlsDto> getAllDemandList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;

	/**
	 * Gets the major head list.
	 *
	 * @param dto the dto
	 * @return the major head list
	 * @throws CustomException the custom exception
	 */
	public List<LocPaymentDtlsDto> getMajorHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;

	/**
	 * Gets the sub major head list.
	 *
	 * @param dto the dto
	 * @return the sub major head list
	 * @throws CustomException the custom exception
	 */
	public List<LocPaymentDtlsDto> getSubMajorHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;

	/**
	 * Deduction detailand update.
	 *
	 * @param dto the dto
	 * @return the loc advicededuction sd dto
	 * @throws CustomException the custom exception
	 */
	public LocAdviceDeductionSdDto deductionDetailandUpdate(LocAdviceDeductionDto dto) throws CustomException;

	/**
	 * Gets the advice dtl.
	 *
	 * @param dto the dto
	 * @return the advice dtl
	 * @throws CustomException the custom exception
	 */
	public LocAdviceDtlDataDto getAdviceDtl(LocAdviceReqParamDto dto) throws CustomException;

	/**
	 * Advice dtl save.
	 *
	 * @param dto the dto
	 * @return the loc advice prep hdr dto
	 * @throws CustomException the custom exception
	 */
	public LocAdvicePrepHdrDto adviceDtlSave(LocAdvicePrepHdrDto dto) throws CustomException;

	/**
	 * Gets the advice dtl edit view.
	 *
	 * @param dto the dto
	 * @return the advice dtl edit view
	 * @throws CustomException the custom exception
	 */
	public LocAdviceDtlEditViewDto getAdviceDtlEditView(LocChqBookEditViewDto dto) throws CustomException;

	/**
	 * Delete.
	 *
	 * @param dto the dto
	 * @return the id dto
	 * @throws CustomException the custom exception
	 */
	public IdDto delete(IdDto dto) throws CustomException;

	/**
	 * Gets the advice cheque list type.
	 *
	 * @return the advice cheque list type
	 * @throws CustomException the custom exception
	 */
	public List<LocIdNameDto> getAdviceChequeListType() throws CustomException;

	/**
	 * Gets the posting dtl advice type.
	 *
	 * @return the posting dtl advice type
	 * @throws CustomException the custom exception
	 */
	public List<LocMsAdviceDtlDto> getPostingDtlAdviceType() throws CustomException;

	/**
	 * Gets the posting dtls.
	 *
	 * @param dto the dto
	 * @return the posting dtls
	 * @throws CustomException the custom exception
	 */
	public List<LocAdvicePreparationPaymentDtlsDto> getPostingDtls(LocAdviceReqParamDto dto) throws CustomException;

	/**
	 * Gets the posting dtls saveas draft.
	 *
	 * @param postingDtlsList the posting dtls list
	 * @return the posting dtls saveas draft
	 * @throws CustomException the custom exception
	 */
	public List<LocAdvicePostingDtlsEditViewDto> postingDtlsSave(List<LocAdvicePartHeadwisedetaisSdDto> postingDtlsList)
			throws CustomException;

	/**
	 * Gets the posting dtl edit view.
	 *
	 * @param dto the dto
	 * @return the posting dtl edit view
	 * @throws CustomException the custom exception
	 */
	public List<LocAdvicePostingDtlsEditViewDto> getPostingDtlEditView(LocChqBookEditViewDto dto)
			throws CustomException;

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	public LocAdviceVerifyAuthSearchParam getAdviceVerifyAuthSearchParam() throws CustomException;

	/**
	 * Submit.
	 *
	 * @param dto the dto
	 * @throws CustomException the custom exception
	 */
	void submit(LocSubmitWfDto dto) throws CustomException;

	/**
	 * Gets the advice deduction edit view..
	 *
	 * @param dto the dto
	 * @return the posting dtls search lc
	 * @throws CustomException the custom exception
	 */
	public LocAdviceDeductionSdDto getDeductionDtleditview(LocActiveDeductionEditViewDto dto) throws CustomException;

	/**
	 * Gets the fund type.
	 *
	 * @return the fund type
	 * @throws CustomException the custom exception
	 */
	public List<LocIdNameDto> getFundType() throws CustomException;

	/**
	 * Gets the charged voted.
	 *
	 * @return the charged voted
	 * @throws CustomException the custom exception
	 */
	public List<LocIdNameDto> getChargedVoted() throws CustomException;

	/**
	 * Gets the budget type.
	 *
	 * @return the budget type
	 * @throws CustomException the custom exception
	 */
	public List<LocIdNameDto> getBudgetType() throws CustomException;

	/**
	 * Gets the minor head list.
	 *
	 * @param dto the dto
	 * @return the minor head list
	 * @throws CustomException the custom exception
	 */
	public List<LocPaymentDtlsDto> getMinorHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;

	/**
	 * Gets the sub head list.
	 *
	 * @param dto the dto
	 * @return the sub head list
	 * @throws CustomException the custom exception
	 */
	public List<LocPaymentDtlsDto> getSubHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;

	/**
	 * Gets the detail head list.
	 *
	 * @param dto the dto
	 * @return the detail head list
	 * @throws CustomException the custom exception
	 */

	public List<LocPaymentDtlsDto> getDetailHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;

	/**
	 * Gets the item name list.
	 *
	 * @param dto the dto
	 * @return the item name list
	 * @throws CustomException the custom exception
	 */
	public List<LocPaymentDtlsDto> getItemNameList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;

	/**
	 * Gets the budget estimate type list.
	 *
	 * @param dto the dto
	 * @return the budget estimate type list
	 * @throws CustomException the custom exception
	 */
	public List<LocIdNameDto> getBudgetEstimateTypeList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;

	/**
	 * Gets the object class.
	 *
	 * @param dto the dto
	 * @return the object class
	 * @throws CustomException the custom exception
	 */
	public List<LocPaymentDtlsDto> getObjectClass(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;

	/**
	 * Gets the cheque type lisiting.
	 *
	 * @param dto the dto
	 * @return the cheque type lisiting
	 * @throws CustomException the custom exception
	 */
	LocAdviceChqEpayList getChequeTypeLisiting(LocAdviceChqTypeListDto dto) throws CustomException;

	/**
	 * Gets the cheque type search data.
	 *
	 * @param dto the dto
	 * @return the cheque type search data
	 * @throws CustomException the custom exception
	 */
	LocAdviceChqTypeSrchList getChequeTypeSearchData(LocAdviceChqTypeListDto dto) throws CustomException;

	/**
	 * Cheque epay save.
	 *
	 * @param dtoList the dto list
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	List<LocAdvcPrepCheqPaySdDto> chequeEpaySave(List<LocAdvcPrepCheqPaySdDto> dtoList) throws CustomException;

	/**
	 * Delete.
	 *
	 * @param dto the dto
	 * @return the id dto
	 * @throws CustomException the custom exception
	 */
	public IdDto checkPayDelete(IdDto dto) throws CustomException;

	/**
	 * Gets the check pay edit view.
	 *
	 * @param dto the dto
	 * @return the check pay edit view
	 * @throws CustomException the custom exception
	 */
	public List<LocCheckPayPaymentDto> getCheckPayEditView(LocCheckPayEditViewDto dto) throws CustomException;

	/**
	 * Gets the cheque book data.
	 *
	 * @param dto the dto
	 * @return the cheque book data
	 * @throws CustomException the custom exception
	 */
	LocAdviceEpayChqDtlDto getChequeBookData(LocAdviceReqParamDto dto) throws CustomException;

	/**
	 * Gets the header info.
	 *
	 * @param dto the dto
	 * @return the header info
	 * @throws CustomException the custom exception
	 */
	public LocAdviceHdrInfoDto getHeaderInfo(IdDto dto) throws CustomException;

	/**
	 * Posting dtls add.
	 *
	 * @param pageDetails the page details
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocAdvicePostingDtlsEditViewDto> postingDtlsAdd(PageDetails pageDetails) throws CustomException;

	/**
	 * Posting dtls delete.
	 *
	 * @param dto the dto
	 * @return the id dto
	 * @throws CustomException the custom exception
	 */
	public IdDto postingDtlsDelete(IdDto dto) throws CustomException;

	/**
	 * Gets the opening new balance.
	 *
	 * @param dto the dto
	 * @return the opening new balance
	 * @throws CustomException the custom exception
	 */
	public Object getOpeningNewBalance(LocAdviceReqParamDto dto) throws CustomException;

	/**
	 * Generates the token No.
	 *
	 * @param dtoList the dto list
	 * @return the token No
	 */
	public List<LocAdviceReqParamDto> generateTokenNo(List<LocAdviceReqParamDto> dtoList);

	/**
	 * saves the token No in Hdr.
	 *
	 * @param dtoList the dto list
	 * @return the dto
	 */
	public List<LocAdviceReqParamDto> onReceive(List<LocAdviceReqParamDto> dtoList);

	/**
	 * Lc advice statement pdf.
	 *
	 * @param id the id
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	public Map<String, Object> lcAdviceStatementPdf(IdDto id) throws CustomException;

	/**
	 * Gets the multiple.
	 *
	 * @param dto the dto
	 * @return the multiple
	 * @throws CustomException the custom exception
	 */
	public LocAdvicePrepMultipleDto getMultiple(IdDto dto) throws CustomException;

	/**
	 * Gets the advice inward listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice inward listing
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocAdviceInwardListingDto> getAdviceInwardListing(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the advice cardex verification listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice cardex verification listing
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocAdviceCardexVerificationListingDto> getAdviceCardexVerificationListing(PageDetails pageDetail)
			throws CustomException;

	/**
	 * Gets the advice verification listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice verification listing
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocAdviceVerificationListingDto> getAdviceVerficationListing(PageDetails pageDetail)
			throws CustomException;

	/**
	 * Gets the advice verification listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice verification listing
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocAdviceAuthorizationListingDto> getAdviceAuthorizationListing(PageDetails pageDetail)
			throws CustomException;

	/**
	 * Gets the inward cardex search param.
	 *
	 * @return the inward cardex search param
	 * @throws CustomException the custom exception
	 */
	public LocInwardCardexSrchParamDto getInwardCardexSearchParam() throws CustomException;

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	public LocAdviceSrchParamDto getSearchParam() throws CustomException;

	/**
	 * Gen auth letter.
	 *
	 * @param dto the dto
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	public Map<String,Object> genAuthLetter(IdDto dto) throws CustomException;

	/**
	 * Sends Notification.
	 *
	 * @param LocSubmitWfDto the dto
	 * @return the true or false
	 * @throws CustomException the custom exception
	 */
	public Boolean sendNotification(LocSubmitWfDto dto)  throws CustomException;

	
	/**
	 * Gets the posting dtls search lc Advice Amounts.
	 *
	 * @param dto the dto
	 * @return the posting dtls search lc Amounts
	 * @throws CustomException the custom exception
	 */
	public List<LocAdviceAmountDto> getPostingDtlsSearchLCAdvAmnts(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException;
}
