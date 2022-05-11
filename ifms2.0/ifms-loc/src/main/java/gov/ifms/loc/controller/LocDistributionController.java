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
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.loc.dto.LocDistributionSubmitDto;
import gov.ifms.loc.service.LocDistributionService;
import gov.ifms.loc.util.LocBaseConstant;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocURLConstant;

/**
 * The Class LocAccountOpenReqController.
 *
 * @version 1.0.
 * @created 2021/02/05.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC_DISTRIBUTION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocDistributionController extends LocBaseConstant {

	/**
	 * The service.
	 */
	@Autowired
	LocDistributionService service;

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_GET_SRCH_PARAM)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_DISTRIBUTION_LIST
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_CREATE + "," + ACCESS_EDIT + "','" + LocConstant.MENUID_DISTRIBUTION
			+ "')")
	public ResponseEntity<ApiResponse> submit(@RequestBody LocDistributionSubmitDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_CREATE, service.submit(dto));
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
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_DISTRIBUTION_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getListingData(@RequestBody PageDetails pageDetails) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.getListingData(pageDetails));
	}

	/**
	 * Gets the edits the view.
	 *
	 * @param dto the dto
	 * @return the edits the view
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_EDIT_VIEW_CLOSE)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_DISTRIBUTION
			+ "')")
	public ResponseEntity<ApiResponse> getEditView(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH, service.getEditView(dto));
	}
	
	/**
	 * Gets the prints the form B data.
	 *
	 * @param dto the dto
	 * @return the prints the form B data
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_FORMB_PRINT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_DISTRIBUTION_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getPrintFormBData(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.printFormB(dto));
	}
	
	/**
	 * Gets the prints the form B data.
	 *
	 * @param dto the dto
	 * @return the prints the form B data
	 * @throws CustomException the custom exception
	 */
	@PostMapping(LocURLConstant.URL_FORMA_PRINT)
	@PreAuthorize("@auth.hasAccess('" + ACCESS_EDIT + "," + ACCESS_VIEW + "','" + LocConstant.MENUID_DISTRIBUTION_LIST
			+ "')")
	public ResponseEntity<ApiResponse> getPrintFormAData(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, LocMessageConstant.LOC_MSG_FETCH,
				service.printFormA(dto));
	}

}
