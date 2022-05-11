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
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.dto.ScrollAccountDto;
import gov.ifms.gst.dto.ScrollDistributeDto;
import gov.ifms.gst.service.impl.ScrollDistributionServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_SCROLLDISTRIBUTE_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScrollDistributionController {
	private static final String PAGE_SIZE = "5";

	@Autowired
	private ScrollDistributionServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> create(@RequestBody List<ScrollDistributeDto> dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.create(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<ScrollDistributeDto> data = service.getAll(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_SEARCH)
	public ResponseEntity<ApiResponse> search(@RequestParam(name = "pageNumber", defaultValue = "0") String pageNumber,@RequestParam(name = "pageSize", defaultValue = PAGE_SIZE) String pageSize, @RequestBody ScrollDistributeDto dto) {
		ListingDto data = service.search(Integer.valueOf(pageNumber),Integer.valueOf(pageSize),dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_SEARCH_DATE)
	public ResponseEntity<ApiResponse> searchScroll(@RequestBody ScrollDistributeDto dto) {
		List<ScrollDistributeDto> data = service.searchScroll(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_SCROLL_REPORT)
	public ResponseEntity<ApiResponse> scrollReport(@RequestBody ScrollDistributeDto dto) {
		List<ScrollAccountDto> data = service.scrollReport(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_SCROLL_VERIFY)
	public ResponseEntity<ApiResponse> scrollVerify(@RequestBody ScrollDistributeDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
				service.scrollVerify(dto));

	}

}
