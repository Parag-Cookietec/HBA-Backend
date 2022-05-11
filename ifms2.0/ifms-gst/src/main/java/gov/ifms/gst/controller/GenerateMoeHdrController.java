package gov.ifms.gst.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import gov.ifms.gst.workflow.dto.WfActionConfigSubmitTrnResDto;
import gov.ifms.gst.workflow.dto.WfActionSubmitDto;
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
import gov.ifms.gst.dto.GSTMoeListingDTO;
import gov.ifms.gst.dto.GenerateMoeHdrDto;
import gov.ifms.gst.service.impl.GenerateMoeHdrServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_GENERATEMOE_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GenerateMoeHdrController {

	@Autowired
	private GenerateMoeHdrServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getById(@RequestBody IdDto idDto) {
		GenerateMoeHdrDto dto = service.getById(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> create(@RequestBody GenerateMoeHdrDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.create(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> update(@RequestBody List<GenerateMoeHdrDto> dtos) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_UPDATE, service.update(dtos));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<GenerateMoeHdrDto> data = service.getAll(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}
	
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL+URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMoeListing(@RequestBody PageDetails pageDetail) throws CustomException, ParseException {
		PagebleDTO<GSTMoeListingDTO> data = service.getMoeListing(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_WF_TRN_SUBMIT)
	public ResponseEntity<ApiResponse> submitMoeWF(@RequestBody WfActionSubmitDto wfActionSubmitDto) throws CustomException, ParseException, SQLException {
		List<WfActionConfigSubmitTrnResDto> data = service.submitMOEWFAction(wfActionSubmitDto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}
	
}
