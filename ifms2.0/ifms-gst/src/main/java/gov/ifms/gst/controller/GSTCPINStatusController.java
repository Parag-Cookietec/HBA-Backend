package gov.ifms.gst.controller;

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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.GSTCPINStatusDto;
import gov.ifms.gst.dto.GetStatusDto;
import gov.ifms.gst.service.impl.GSTCPINStatusServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_CPIN_STATUS_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GSTCPINStatusController {
	@Autowired
	private GSTCPINStatusServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> create(@RequestBody GSTCPINStatusDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.create(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<GSTCPINStatusDto> data = service.getAll(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_CPIN_STATUS)
	public ResponseEntity<ApiResponse> getCpinStatus(@RequestBody GSTCPINStatusDto dtos) {
		GetStatusDto dto = service.getCpinStatus(dtos);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

	@Trace
	@PostMapping(URLConstant.URL_SEARCH)
	public ResponseEntity<ApiResponse> getStatus(@RequestBody GSTCPINStatusDto dtos) {
		GSTCPINStatusDto dto = service.getStatus(dtos);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

}
