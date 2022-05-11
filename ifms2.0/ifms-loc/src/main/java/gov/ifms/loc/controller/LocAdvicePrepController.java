package gov.ifms.loc.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.loc.dto.LocActiveDeductionEditViewDto;
import gov.ifms.loc.dto.LocAdvcPrepCheqPaySdDto;
import gov.ifms.loc.dto.LocAdviceChqTypeListDto;
import gov.ifms.loc.dto.LocAdviceDeductionDto;
import gov.ifms.loc.dto.LocAdvicePartHeadwisedetaisSdDto;
import gov.ifms.loc.dto.LocAdvicePostingHeadwisedetaisDto;
import gov.ifms.loc.dto.LocAdvicePrepHdrDto;
import gov.ifms.loc.dto.LocAdviceReqParamDto;
import gov.ifms.loc.dto.LocCheckPayEditViewDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.service.LocAdvicePrepService;
import gov.ifms.loc.util.LocBaseConstant;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocURLConstant;

/**
 * The Class LocAdvicePrepController.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC_ADVICE_PREP)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocAdvicePrepController extends LocBaseConstant {

	/** The Constant logg. */
	private static final Logger logg = LoggerFactory.getLogger(LocAdvicePrepController.class);

	/**
	 * The service.
	 */
	@Autowired
	private LocAdvicePrepService service;
	


	/**
	 * Gets the advice dtl.
	 *
	 * @param dto the dto
	 * @return the advice dtl
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_GET_DTL)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" +  LocConstant.MENUID_ADVICE_PRE + "," + LocConstant.MENUID_INWARD_ADVICE_LIST+ "," + LocConstant.MENUID_CARDEX_VERIFICATION_LIST+ "," + LocConstant.MENUID_ADVICE_VERFYLIST+ "," + LocConstant.MENUID_ADVICE_AUTHO_LIST + "')")
	public ResponseEntity<ApiResponse> getAdviceDtl(@RequestBody LocAdviceReqParamDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getAdviceDtl(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Advice dtl save.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_SAVE_DRAFT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ADVICE_PRE + ","  + LocConstant.MENUID_ADVICE_VERFYLIST+ "," + LocConstant.MENUID_ADVICE_AUTHO_LIST
			+ "')")
	public ResponseEntity<ApiResponse> adviceDtlSave(@RequestBody LocAdvicePrepHdrDto dto) throws CustomException {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE,
					service.adviceDtlSave(dto));
	}

	/**
	 * Deduction detailand update.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_DEDUCTION_D)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ADVICE_PRE
			+ "')")
	public ResponseEntity<ApiResponse> deductionDetailandUpdate(@RequestBody LocAdviceDeductionDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE,
				service.deductionDetailandUpdate(dto));
	}

	/**
	 * Gets the advice deduction edit view.
	 *
	 * @param dto the dto
	 * @return the advice dtl edit view
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_DED_EDIT_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "," + LocConstant.MENUID_INWARD_ADVICE_LIST+ "," + LocConstant.MENUID_CARDEX_VERIFICATION_LIST+ "," + LocConstant.MENUID_ADVICE_VERFYLIST+ "," + LocConstant.MENUID_ADVICE_AUTHO_LIST + "')")
	public ResponseEntity<ApiResponse> getAdviceDedEditView(@RequestBody LocActiveDeductionEditViewDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getDeductionDtleditview(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	
	
	/**
	 * Gets the advice dtl edit view.
	 *
	 * @param dto the dto
	 * @return the advice dtl edit view
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_DTL_EDIT_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" +  LocConstant.MENUID_ADVICE_PRE + "," + LocConstant.MENUID_INWARD_ADVICE_LIST+ "," + LocConstant.MENUID_CARDEX_VERIFICATION_LIST+ "," + LocConstant.MENUID_ADVICE_VERFYLIST+ "," + LocConstant.MENUID_ADVICE_AUTHO_LIST+ "')")
	public ResponseEntity<ApiResponse> getAdviceDtlEditView(@RequestBody LocChqBookEditViewDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getAdviceDtlEditView(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Delete.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_DELETE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ADVICE_PRE
			+ "')")
	public ResponseEntity<ApiResponse> delete(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE, service.delete(dto));

	}

	/**
	 * Gets the advice cheque list type.
	 *
	 * @return the advice cheque list type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_DTL_CHEQUE_LIST)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getAdviceChequeListType() throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getAdviceChequeListType());
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the posting dtl advice type.
	 *
	 * @return the posting dtl advice type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTL_ADVICE_TYPE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getPostingDtlAdviceType() throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getPostingDtlAdviceType());
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Gets the posting dtls.
	 *
	 * @param dto the dto
	 * @return the posting dtls
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTL_TABLE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getPostingDtls(@RequestBody LocAdviceReqParamDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getPostingDtls(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the posting dtls search LC.
	 *
	 * @param dto the dto
	 * @return the posting dtls search LC
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTL_SEARCH_LC)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getPostingDtlsSearchLC(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getPostingDtlsSearchLc(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the posting dtls Amounts from Advice.
	 *
	 * @param dto the dto
	 * @return the posting dtls search Amounts from Advice
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTL_SEARCH_ADV_AMOUNTS)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getPostingDtlsSearchLCAdvAmnts(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getPostingDtlsSearchLCAdvAmnts(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}	
	/**
	 * Gets the posting dtls save.
	 *
	 * @param paymentDtlsList the payment dtls list
	 * @return the posting dtls
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTL_SAVE_AS_DRAFT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ADVICE_PRE
			+ "')")
	public ResponseEntity<ApiResponse> getPostingDtlsSaveasDraft(
			@RequestBody List<LocAdvicePartHeadwisedetaisSdDto> paymentDtlsList) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.postingDtlsSave(paymentDtlsList));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Gets the posting dtls Edit/View.
	 *
	 * @param dto the dto
	 * @return the posting dtls edit view
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTL_EDIT_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "," + LocConstant.MENUID_INWARD_ADVICE_LIST+ "," + LocConstant.MENUID_CARDEX_VERIFICATION_LIST+ "," + LocConstant.MENUID_ADVICE_VERFYLIST+ "," + LocConstant.MENUID_ADVICE_AUTHO_LIST + "')")
	public ResponseEntity<ApiResponse> getPostingDtlEditView(@RequestBody LocChqBookEditViewDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getPostingDtlEditView(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the posting dtls Map Epayment Popup on Edit/View.
	 *
	 * @param dto the dto
	 * @return the Map Epayment Popup values
	 * @throws CustomException the custom exception
	 */

	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTL_MAP_EPAYMENT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getPostingDtlMapEpymt(@RequestBody LocChqBookEditViewDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getPostingDtlMapEpymt(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the posting dtls Map Epayment Popup Update Action.
	 *
	 * @param dtoList the dto
	 * @return updates epayment updates
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTL_UPDT_EPAYMNT_AMNT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ADVICE_PRE
			+ "')")
	public ResponseEntity<ApiResponse> getPostingDtlUpdtEpymntAmnt(@RequestBody List<LocAdvcPrepCheqPaySdDto> dtoList)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getPostingDtlUpdtEpymntAmnt(dtoList));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getSearchParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getSearchParam());

	}

	/**
	 * Submit.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_SUBMIT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ADVICE_PRE
			+ "')")
	public ResponseEntity<ApiResponse> submit(@RequestBody LocSubmitWfDto dto) throws CustomException {
		service.submit(dto);
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH);
		} catch (Exception e) {
			logg.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CALL_SP);
		}
	}

	/**
	 * Gets the advice prep listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice prep listing
	 * @throws CustomException the custom exception
	 * @throws ParseException 
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_PREP_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getAdvicePrepListing(@RequestBody PageDetails pageDetail)
			throws CustomException, ParseException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getAdvicePrepListing(pageDetail));
	}

	/**
	 * Gets the all demand.
	 *
	 * @param dto the dto
	 * @return the all demand
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_DEMAND)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getAllDemand(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getAllDemandList(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the major head list.
	 *
	 * @param dto the dto
	 * @return the major head list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_MAJOR_HEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getMajorHeadList(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getMajorHeadList(dto));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the sub major head list.
	 *
	 * @param dto the dto
	 * @return the sub major head list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_SUB_MAJOR_HEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getSubMajorHeadList(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getSubMajorHeadList(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the minor head list.
	 *
	 * @param dto the dto
	 * @return the minor head list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_MINOR_HEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getMinorHeadList(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getMinorHeadList(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the sub head list.
	 *
	 * @param dto the dto
	 * @return the sub head list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_SUB_HEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getSubHeadList(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getSubHeadList(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the detail head list.
	 *
	 * @param dto the dto
	 * @return the detail head list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_DETAIL_HEAD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getDetailHeadList(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getDetailHeadList(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the item name list.
	 *
	 * @param dto the dto
	 * @return the item name list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_ITEM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getItemNameList(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getItemNameList(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the object class.
	 *
	 * @param dto the dto
	 * @return the object class
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_OBJECT_CLASS)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getObjectClass(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getObjectClass(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the budget estimate list.
	 *
	 * @param dto the dto
	 * @return the budget estimate list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_BUDGET_ESTIMATE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getBudgetEstimateList(@RequestBody LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getBudgetEstimateTypeList(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the fund type.
	 *
	 * @return the fund type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_FUND_TYPE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getFundType() throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getFundType());
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the charged voted.
	 *
	 * @return the charged voted
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_CHARGED_VOTED)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getChargedVoted() throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getChargedVoted());
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the budget type.
	 *
	 * @return the budget type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_GET_BUDGET_TYPE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getBudgetType() throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getBudgetType());
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the cheque type lisiting.
	 *
	 * @param dto the dto
	 * @return the cheque type lisiting
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_CHQ_TYPE_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getChequeTypeLisiting(@RequestBody LocAdviceChqTypeListDto dto)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getChequeTypeLisiting(dto));
	}

	/**
	 * Gets the cheque type search data.
	 *
	 * @param dto the dto
	 * @return the cheque type search data
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_CHQ_SRCH_DATA)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getChequeTypeSearchData(@RequestBody LocAdviceChqTypeListDto dto)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getChequeTypeSearchData(dto));
	}

	/**
	 * Cheque epay save.
	 *
	 * @param dtoList the dto list
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_CHQ_E_PAY_SAVE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> chequeEpaySave(@RequestBody List<LocAdvcPrepCheqPaySdDto> dtoList)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE,
				service.chequeEpaySave(dtoList));
	}

	/**
	 * Gets the Check Pay delete.
	 *
	 * @param dto the dto
	 * @return the advice prep listing
	 * @throws CustomException the custom exception
	 */

	@Trace
	@PostMapping(LocURLConstant.URL_CHECK_PAY_DELETE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ADVICE_PRE
			+ "')")
	public ResponseEntity<ApiResponse> checkPayDelete(@RequestBody IdDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE,
					service.checkPayDelete(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}
	}

	/**
	 * Gets the Check Pay edit view.
	 *
	 * @param dto the dto
	 * @return the advice dtl edit view
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_CHECK_PAY_EDIT_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "," + LocConstant.MENUID_INWARD_ADVICE_LIST+ "," + LocConstant.MENUID_CARDEX_VERIFICATION_LIST+ "," + LocConstant.MENUID_ADVICE_VERFYLIST+ "," + LocConstant.MENUID_ADVICE_AUTHO_LIST + "')")
	public ResponseEntity<ApiResponse> getCheckPayEditView(@RequestBody LocCheckPayEditViewDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
					service.getCheckPayEditView(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Gets the header info.
	 *
	 * @param dto the dto
	 * @return the header info
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_HEADER_INFO)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" 
	+ LocConstant.MENUID_ADVICE_PRE + "," + LocConstant.MENUID_INWARD_ADVICE_LIST+ "," + LocConstant.MENUID_CARDEX_VERIFICATION_LIST+ "," + LocConstant.MENUID_ADVICE_VERFYLIST+ "," + LocConstant.MENUID_ADVICE_AUTHO_LIST+ "')")
	public ResponseEntity<ApiResponse> getHeaderInfo(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getHeaderInfo(dto));

	}
	
		
	/**
	 * Gets the cheque book data.
	 *
	 * @param dto the dto
	 * @return the cheque book data
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_CHECK_BOOK_DATA)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getChequeBookData(@RequestBody LocAdviceReqParamDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getChequeBookData(dto));

	}

	/**
	 * Posting dtls add.
	 *
	 * @param pageDetails the page details
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_ADD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ADVICE_PRE
			+ "')")
	public ResponseEntity<ApiResponse> postingDtlsAdd(@RequestBody PageDetails pageDetails) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE,
					service.postingDtlsAdd(pageDetails));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Posting dtls delete.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_POSTING_DTLS_DELETE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ADVICE_PRE
			+ "')")
	public ResponseEntity<ApiResponse> postingDtlsDelete(@RequestBody IdDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE,
					service.postingDtlsDelete(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}
	}

	/**
	 * Gets the opening new balance.
	 *
	 * @param dto the dto
	 * @return the opening new balance
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_DTL_OPENING_NEW_BALANCE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_PRE + "')")
	public ResponseEntity<ApiResponse> getOpeningNewBalance(@RequestBody LocAdviceReqParamDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE,
					service.getOpeningNewBalance(dto));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Generates the token No.
	 * 
	 * 
	 *
	 * @param dtoList the dto 
	 * @return the token No
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_INWARD_GENERATE_TOKEN_NO)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_INWARD_ADVICE_LIST
			+ "')")
	public ResponseEntity<ApiResponse> generateTokenNo(@RequestBody List<LocAdviceReqParamDto> dtoList)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE,
					service.generateTokenNo(dtoList));
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * saves the token No in Hdr.
	 *
	 * @param dtoList the dto
	 * @return the dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_INWARD_RECEIVE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_INWARD_ADVICE_LIST
			+ "')")
	public ResponseEntity<ApiResponse> onReceive(@RequestBody List<LocAdviceReqParamDto> dtoList)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE,
					service.onReceive(dtoList));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the advice prep listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice prep listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_INWARD_ADVICE_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_INWARD_ADVICE_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getInwardAdviceListing(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getAdviceInwardListing(pageDetail));
	}

	/**
	 * Gets the advice prep listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice prep listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_CARDEX_VERIFICATION_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','"
			+ LocConstant.MENUID_CARDEX_VERIFICATION_LIST + "')")
	public ResponseEntity<ApiResponse> getCardexVerificationListing(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getAdviceCardexVerificationListing(pageDetail));
	}

	/**
	 * Gets the advice prep listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice prep listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_VERIFICATION_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_VERFYLIST
			+ "')")
	public ResponseEntity<ApiResponse> getAdviceVerficationListing(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getAdviceVerficationListing(pageDetail));
	}

	/**
	 * Gets the advice prep listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice prep listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_AUTHORIZATION_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_AUTHO_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getAdviceAuthorizationListing(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getAdviceAuthorizationListing(pageDetail));
	}

	/**
	 * Gets the advice statement pdf.
	 *
	 * @param dto the dto
	 * @return the advice statement pdf
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_STATEMENT_PDF)
	public ResponseEntity<ApiResponse> getAdviceStatementPdf(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.lcAdviceStatementPdf(dto));
	}


	/**
	 * Gets the multiple inward.
	 *
	 * @param dto the dto
	 * @return the multiple inward
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_GET_MULTIPLE_INWARD)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_INWARD_ADVICE_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getMultipleInward(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getMultiple(dto));
	}

	/**
	 * Gets the multiple cardex.
	 *
	 * @param dto the dto
	 * @return the multiple cardex
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_GET_MULTIPLE_CARDEX_VERIFY)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','"
			+ LocConstant.MENUID_CARDEX_VERIFICATION_LIST + "')")
	public ResponseEntity<ApiResponse> getMultipleCardex(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getMultiple(dto));

	}

	/**
	 * Gets the inward search param.
	 *
	 * @return the inward search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_INWARD_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_INWARD_ADVICE_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getInwardSearchParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getInwardCardexSearchParam());

	}

	/**
	 * Gets the cardex verify search param.
	 *
	 * @return the cardex verify search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_CARDEX_VERIFY_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','"
			+ LocConstant.MENUID_CARDEX_VERIFICATION_LIST + "')")
	public ResponseEntity<ApiResponse> getCardexVerifySearchParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getInwardCardexSearchParam());

	}

	/**
	 * Gets the advice verify search param.
	 *
	 * @return the advice verify search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_VERIFY_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_VERFYLIST
			+ "')")
	public ResponseEntity<ApiResponse> getAdviceVerifySearchParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getAdviceVerifyAuthSearchParam());

	}

	/**
	 * Gets the advice auth search param.
	 *
	 * @return the advice auth search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ADVICE_AUTH_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_AUTHO_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getAdviceAuthSearchParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getAdviceVerifyAuthSearchParam());

	}
	

	/**
	 * Gets the auth letter.
	 *
	 * @param dto the dto
	 * @return the auth letter
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_ADVICE_LETTER_PRINT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_OPEN
			+ "')")
	public ResponseEntity<ApiResponse> getAuthLetter(@RequestBody IdDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.genAuthLetter(dto));
	}
	
	/**
	 * Sends Notification.
	 *
	 * @param dto the dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_ADVICE_AUTH_SEND_NOTIFICATION)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ADVICE_AUTHO_LIST
			+ "')")
	public ResponseEntity<ApiResponse> sendNotification(@RequestBody LocSubmitWfDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.sendNotification(dto));
	}

}