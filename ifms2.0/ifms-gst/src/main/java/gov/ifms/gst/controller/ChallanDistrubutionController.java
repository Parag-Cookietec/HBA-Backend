package gov.ifms.gst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.ChallanDistributionSADADto;
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.dto.LoadBalancerHADto;
import gov.ifms.gst.service.impl.ChallanDistrubutionServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_CHALLAN_DISTRUBUTION_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChallanDistrubutionController {
	private static final String PAGE_SIZE = "5";

	@Autowired
	private ChallanDistrubutionServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<ChallanDistributionSADADto> data = service.getAll(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_SEARCH)
	public ResponseEntity<ApiResponse> search(@RequestParam(name = "pageNumber", defaultValue = "0") String pageNumber,
			@RequestParam(name = "pageSize", defaultValue = PAGE_SIZE) String pageSize,
			@RequestBody ChallanDistributionSADADto dto) {
		ListingDto data = service.search(Integer.valueOf(pageNumber), Integer.valueOf(pageSize), dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_SCROLL)
	public ResponseEntity<ApiResponse> searchScroll(@RequestBody ChallanDistributionSADADto dto) {
		ScrollDto dtos = service.searchsScroll(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}

	@Trace
	@PostMapping(URLConstant.URL_DISTRIBUTE)
	public ResponseEntity<ApiResponse> distribute(@RequestBody List<ChallanDistributionSADADto> dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, service.doDistribute(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_LOAD_BALANCER_HA)
	public ResponseEntity<ApiResponse> searchsScroll(@RequestBody LoadBalancerHADto dto) {
		ScrollDto dtos = service.searchScroll(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}

	@Trace
	@PostMapping(URLConstant.URL_BANK_LIST)
	public ResponseEntity<ApiResponse> bankList(@RequestBody ChallanDistributionSADADto dto) {
		ScrollDto dtos = service.bankList(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}
}
