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
import gov.ifms.gst.dto.FileAccountingProcessedDto;
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.dto.LoadBalancerAODto;
import gov.ifms.gst.service.impl.LoadBalancerAOServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_LOAD_AO_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoadBalancerAOController {
	private static final String PAGE_SIZE = "5";
	@Autowired
	private LoadBalancerAOServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<LoadBalancerAODto> data = service.getAll(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_CPIN_STATUS)
	public ResponseEntity<ApiResponse> getSearch(
			@RequestParam(name = "pageNumber", defaultValue = "0") String pageNumber,
			@RequestParam(name = "pageSize", defaultValue = PAGE_SIZE) String pageSize,
			@RequestBody LoadBalancerAODto dto) {
		ListingDto dtos = service.getSearch(Integer.valueOf(pageNumber), Integer.valueOf(pageSize), dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dtos);
	}

	@Trace
	@PostMapping(URLConstant.URL_DISTRIBUTE_AO)
	public ResponseEntity<ApiResponse> doDistributeHa(@RequestBody List<LoadBalancerAODto> dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, service.doDistributeAO(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_LOAD_BALANCER_AO)
	public ResponseEntity<ApiResponse> searchChallan(@RequestBody LoadBalancerAODto dto) {
		ScrollDto dtos = service.searchChallan(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}
}
