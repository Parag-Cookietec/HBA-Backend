package gov.ifms.gst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.accounting.dto.EodBCpinData;
import gov.ifms.gst.dto.EodCPINFileDataDto;
import gov.ifms.gst.dto.JsonCPINDTO;
import gov.ifms.gst.service.impl.EodCpinFileDataServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_CPIN_FILE_DATA_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EodCpinFileDataController {
	@Autowired
	private EodCpinFileDataServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> create(@RequestBody EodCPINFileDataDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.create(dto));
	}

	@Trace
	@PostMapping(value = "/json")
	public ResponseEntity<ApiResponse> jsonDto(@RequestBody JsonCPINDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, service.jsonDto(dto));
	}

	@Trace
	@PostMapping(value = "/json/upload")
	public ResponseEntity<ApiResponse> jsonUpload(@RequestBody EodBCpinData dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
				service.loadEodBCpinData(dto));
	}
}
