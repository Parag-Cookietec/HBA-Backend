package gov.ifms.gst.controller;

import gov.ifms.gst.dto.GSTBankRateMasterListingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.GSTBankRateMasterDto;
import gov.ifms.gst.service.GSTBankRateMasterService;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

import java.text.ParseException;

/**
 * The Class GSTBankRateMasterController.
 * 
 * @version v 1.0.
 * @created 2021/07/14 11:40:45.
 *
 */
@RestController
@RequestMapping(GstURLConstant.URL_BANKRATE_MASTER_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GSTBankRateMasterController {
	
	/** The service. */
	@Autowired
	private GSTBankRateMasterService service;


	/**
	 * Fetch Bank Rate GST Master by given  id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getBankRateMaster(@RequestBody IdDto idDto) {
		GSTBankRateMasterDto dto = service.getBankRateMaster(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

	/**
	 * creates a new Bank Rate GST Master
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createBankRateMaster(@RequestBody GSTBankRateMasterDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.createBankRateMaster(dto));
	}

	/**
	 * Update the new Bank Rate GST Master
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateBankRateMaster(@RequestBody GSTBankRateMasterDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_UPDATE, service.updateBankRateMaster(dto));
	}
	
	/**
	 * Gets the Bank Rate GST Master.
	 *
	 * @param pageDetail the page detail
	 * @return the Bank Rate GST Masters
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getBankRateMaster(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<GSTBankRateMasterDto> data = service.getBankRateMasters(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL+URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getBankRateMasterListing(@RequestBody PageDetails pageDetail) throws CustomException, ParseException {
		PagebleDTO<GSTBankRateMasterListingDto> data = service.getBankRateMasterListing(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}
	
}
