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
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.DTO;
import gov.ifms.gst.dto.GSTBlockCPINDto;
import gov.ifms.gst.dto.GSTBlockCpinListingDto;
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.entity.GSTBlockCPIN;
import gov.ifms.gst.service.impl.GSTBlockCPINServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_BLOCK_CPIN_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GSTBlockCPINController {
	private static final String PAGE_SIZE = "5";

	@Autowired
	private GSTBlockCPINServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getById(@RequestBody IdDto idDto) {
		GSTBlockCPINDto dto = service.getById(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> create(@RequestBody GSTBlockCPIN dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.create(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<GSTBlockCPINDto> data = service.getAll(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_BLOCKCPINCLIST)
	public ResponseEntity<ApiResponse> getCpinStatus(@RequestBody GSTBlockCPINDto dtos) {
		DTO dto = service.getCpinStatus(dtos);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_LIST)
	public ResponseEntity<ApiResponse> list(@RequestParam(name = "pageNumber", defaultValue = "0") String pageNumber,
			@RequestParam(name = "pageSize", defaultValue = PAGE_SIZE) String pageSize,@RequestBody GSTBlockCPINDto dtos) {
		ListingDto dto = service.list(Integer.valueOf(pageNumber),Integer.valueOf(pageSize),dtos);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_LIST + URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> searchList(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<GSTBlockCpinListingDto> data = service.getBlockCPINListing(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}
}
