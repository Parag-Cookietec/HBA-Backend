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
import gov.ifms.loc.dto.LocChequeToChequeEditViewDto;
import gov.ifms.loc.dto.LocChequeToChequeHDRDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.service.LocChequeToChequeService;
import gov.ifms.loc.util.LocBaseConstant;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocURLConstant;

/**
 * The Class LocChequeToChequeController.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC_CHEQUE_TO_CHEQUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocChequeToChequeController extends LocBaseConstant {

	/** The service. */
	@Autowired
	private LocChequeToChequeService service;

	/**
	 * Save as draft.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_CHEQUE_DETAILS)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHEQUE_TO_CHEQUE
			+ "')")
	public ResponseEntity<ApiResponse> getChequeData(@RequestBody LocChequeToChequeHDRDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE, service.getChequeData(dto));
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHEQUE_TO_CHEQUE
			+ "')")
	public ResponseEntity<ApiResponse> saveAsDraft(@RequestBody LocChequeToChequeHDRDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE, service.saveAsDraft(dto));
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHEQUE_TO_CHEQUE
			+ "')")
	public ResponseEntity<ApiResponse> getCheckToCheckHeaderInfo(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getCheckToCheckHeaderInfo(dto));

	}

	/**
	 * Gets the Cheque Cancel listing.
	 *
	 * @param pageDetail the page detail
	 * @return the advice prep listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_CHEQUE_TO_CHEQUE_LISTING)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','"
			+ LocConstant.MENUID_CHEQUE_TO_CHEQUE_LIST + "')")
	public ResponseEntity<ApiResponse> getChequeToChequeListing(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getChequeToChequeListing(pageDetail));
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_CHEQUE_TO_CHEQUE
			+ "')")
	public ResponseEntity<ApiResponse> getEditView(@RequestBody LocChequeToChequeEditViewDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getEditView(dto));
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHEQUE_TO_CHEQUE
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
	 * Delete by id.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_DELETE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHEQUE_TO_CHEQUE
			+ "')")
	public ResponseEntity<ApiResponse> deleteById(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE, service.deleteById(dto));
	}

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','"
			+ LocConstant.MENUID_CHEQUE_TO_CHEQUE_LIST + "')")
	public ResponseEntity<ApiResponse> getSearchParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getSearchParam());
	}

	/**
	 * Gets the search param.
	 *
	 * @param dto the dto
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_DELETE_CHEQUE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_CHEQUE_TO_CHEQUE
			+ "')")
	public ResponseEntity<ApiResponse> deleteCheque(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE, service.deleteCheque(dto));
	}

}
