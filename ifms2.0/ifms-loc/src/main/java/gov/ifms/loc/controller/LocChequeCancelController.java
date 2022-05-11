package gov.ifms.loc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.loc.dto.LocChequeCancelHdrDto;
import gov.ifms.loc.dto.LocChequeCancelListDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.service.LocChequeCancelService;
import gov.ifms.loc.util.LocBaseConstant;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocURLConstant;

/**
 * The Class LocChequeCancelHdrController.
 *
 * @version v 1.0.
 * @created 2021/03/05 17:12:26.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC_CHEQUE_CANCEL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocChequeCancelController extends LocBaseConstant{

	
	/**
	 * The service.
	 */
	@Autowired
	private LocChequeCancelService service;

	/**
	 * Fetch ChequeCancelHdrs by given ChequeCancelHdrs id.
	 *
	 * @param dto the dto
	 * @return dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_CHEQUE_DETAILS)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_CANCEL + "')")
	public ResponseEntity<ApiResponse> searchChequeDetail(@RequestBody LocChequeCancelListDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				service.getChequeSearchDetails(dto));
	}

	/**
	 * Gets the Header Info on submit .
	 *
	 * @param dto the dto
	 * @return the search param
	 * @throws CustomException the custom exception
	 */

	@Trace
	@PostMapping(LocURLConstant.URL_GET_HEADER_INFO)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_CANCEL + "')")
	public ResponseEntity<ApiResponse> getCheckCancelHeaderInfo(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getCheckCancelHeaderInfo(dto));

	}

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_CANCEL_LIST + "')")
	public ResponseEntity<ApiResponse> getSearchParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getSearchParam());
	}

	/**
	 * Save as draft.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_SAVE_AS_DRAFT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHQ_CANCEL + "')")
	public ResponseEntity<ApiResponse> saveAsDraft(@RequestBody LocChequeCancelHdrDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE, service.saveAsDraft(dto));
	}

	/**
	 * Submit data.
	 *
	 * @param submitWfDto the submit wf dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_SUBMIT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHQ_CANCEL + "')")
	public ResponseEntity<ApiResponse> submitData(@RequestBody LocSubmitWfDto submitWfDto) throws CustomException {
		try {
			service.submitData(submitWfDto);
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Delete by id.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_DELETE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHQ_CANCEL_LIST + "')")
	public ResponseEntity<ApiResponse> deleteById(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE, service.deleteById(dto));
	}

	/**
	 * Gets the edits the view.
	 *
	 * @param dto the dto
	 * @return the edits the view
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_EDIT_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_CANCEL + "')")
	public ResponseEntity<ApiResponse> getEditView(@RequestBody LocChqBookEditViewDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getEditViewData(dto));
	}

	/**
	 * Gets the Cheque Cancel listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice prep listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_CHEQUE_CANCEL_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_CANCEL_LIST + "')")
	public ResponseEntity<ApiResponse> getChequeCancelListing(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getChequeCancelListing(pageDetail));
	}

	/**
	 * Gets the cheque cancel div listing.
	 *
	 * @param pageDetail the page detail
	 * @return the cheque cancel div listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_CHEQUE_CANCEL_DIV_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_CANCEL_LIST + "')")
	public ResponseEntity<ApiResponse> getChequeCancelDivListing(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getChequeCancelDivListing(pageDetail));
	}
}
