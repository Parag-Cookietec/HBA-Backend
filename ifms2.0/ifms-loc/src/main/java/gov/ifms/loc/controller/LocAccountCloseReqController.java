package gov.ifms.loc.controller;

import javax.validation.Valid;

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
import gov.ifms.loc.dto.LocAccCloseReqHdrDto;
import gov.ifms.loc.dto.LocAccountCloseReqHdrDto;
import gov.ifms.loc.dto.LocAccountCloseReqParamDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.service.LocAccountCloseReqService;
import gov.ifms.loc.util.LocBaseConstant;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocURLConstant;

/**
 * The Class LocAccountCloseReqController.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC_ACCOUNTCLOSEREQ)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocAccountCloseReqController extends LocBaseConstant {

	/**
	 * The service.
	 */
	@Autowired
	private LocAccountCloseReqService service;

	/**
	 * Fetch AccountClseReqHdrs by given id.
	 *
	 * @param locAccountCloseReqParamDto the loc account close req param dto
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_ACT_CLOSE_REQ_DTL_BY_ID)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_CLOSING
			+ "')")
	public ResponseEntity<ApiResponse> getAccountOpenReqDtl(
			@RequestBody LocAccountCloseReqParamDto locAccountCloseReqParamDto) throws CustomException {
		LocAccCloseReqHdrDto dto = service.getAccountCloseReqDtl(locAccountCloseReqParamDto.getOfficeId(),
				locAccountCloseReqParamDto.getDepartmentId(), locAccountCloseReqParamDto.getCardexNo(),
				locAccountCloseReqParamDto.getDdoNo(), locAccountCloseReqParamDto.getDistrictId());
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, dto);
	}

	/**
	 * creates a new AccountCloseReqSds.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_POST_ACT_CLOSE_REQ_HDR)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_CLOSING
			+ "')")
	public ResponseEntity<ApiResponse> createAccountCloseReqHdr(@Valid @RequestBody LocAccountCloseReqHdrDto dto)
			throws CustomException {
		LocAccountCloseReqHdrDto data = service.createLocAccCloseReqHdr(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE, data);
	}

	/**
	 * Gets the open listing data. 
	 *
	 * @param dto the dto
	 * @return the open listing data
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_EDIT_VIEW_CLOSE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_CLOSING
			+ "')")
	public ResponseEntity<ApiResponse> getEditViewData(@RequestBody LocChqBookEditViewDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getAccountCloseEditDtl(dto));

	}

	/**
	 * Gets the close listing data.
	 *
	 * @param pageDetail the page detail
	 * @return the open listing data
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_CLOSE_LISITNG)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','"
			+ LocConstant.MENUID_ACCOUNT_CLOSING_LIST + "')")
	public ResponseEntity<ApiResponse> getOpenListingData(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getClosingListingData(pageDetail));
	}

	/**
	 * Gets the details from rec est header.
	 *
	 * @param submitWfDto the submit wf dto
	 * @return the details from rec est header
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_SUBMIT_CLOSE_REQ)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_CLOSING
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
	 * Gets the srch param.
	 *
	 * @return the srch param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','"
			+ LocConstant.MENUID_ACCOUNT_CLOSING_LIST + "')")
	public ResponseEntity<ApiResponse> getSrchParam() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getSrchParam());
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_ACCOUNT_CLOSING
			+ "')")
	public ResponseEntity<ApiResponse> deleteById(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_DELETE, service.deleteById(dto));
	}

	/**
	 * Gets the closing request view.
	 *
	 * @param dto the dto
	 * @return the closing request view
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_CLOSING_REQ_VIEW)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_ACCOUNT_CLOSING
			+ "')")
	public ResponseEntity<ApiResponse> getclosingRequestView(@RequestBody PageDetails dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getclosingRequestView(dto));
	}

}
