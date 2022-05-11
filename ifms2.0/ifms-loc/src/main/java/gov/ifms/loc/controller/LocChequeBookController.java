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

import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.loc.dto.LocChequeBookHdrDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocChqDtlDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.service.LocChequeBookService;
import gov.ifms.loc.util.LocBaseConstant;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocURLConstant;

/**
 * The Class LocChequeBookController.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC_CHEQUE_BOOK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocChequeBookController extends LocBaseConstant {

	/**
	 * The service.
	 */
	@Autowired
	private LocChequeBookService service;

	/**
	 * Save draft.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_SAVE_AS_DRAFT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHQ_ACT_INACT
			+ "')")
	public ResponseEntity<ApiResponse> saveDraft(@RequestBody LocChequeBookHdrDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE, service.saveDraft(dto));
	}

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_ACT_INACT_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getSearchParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getSearchParam());
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHQ_ACT_INACT
			+ "')")
	public ResponseEntity<ApiResponse> submitData(@RequestBody LocSubmitWfDto submitWfDto) throws CustomException {
		try {
			service.submitData(submitWfDto);
			return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Gets the cheque book data.
	 *
	 * @param dto the dto
	 * @return the cheque book data
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_CHEQUE_BOOK_DATA)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_ACT_INACT
			+ "')")
	public ResponseEntity<ApiResponse> getChequeBookData(@RequestBody LocChqDtlDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getChequeBookData(dto));
	}

	/**
	 * Gets the cheque book list.
	 *
	 * @param dto the dto
	 * @return the cheque book list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_CHEQUE_BOOK_LIST)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_ACT_INACT
			+ "')")
	public ResponseEntity<ApiResponse> getChequeBookList(@RequestBody LocChqDtlDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getChequeBookList(dto));
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_ACT_INACT
			+ "')")
	public ResponseEntity<ApiResponse> getEditView(@RequestBody LocChqBookEditViewDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getEditView(dto));
	}

	/**
	 * Gets the listing data.
	 *
	 * @param pageDetails the page details
	 * @return the listing data
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_ACT_INACT_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getListingData(@RequestBody PageDetails pageDetails) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getListingData(pageDetails));
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHQ_ACT_INACT
			+ "')")
	public ResponseEntity<ApiResponse> getHeaderInfo(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getHeaderInfo(dto));
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHQ_ACT_INACT
			+ "')")
	public ResponseEntity<ApiResponse> deleteById(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE, service.deleteById(dto));
	}
}
