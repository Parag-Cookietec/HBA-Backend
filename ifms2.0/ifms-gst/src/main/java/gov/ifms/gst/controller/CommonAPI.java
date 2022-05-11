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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.CommonDtos;
import gov.ifms.gst.service.impl.CommonServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_COMMON_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommonAPI {

	@Autowired
	private CommonServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_COMMON)
	public ResponseEntity<ApiResponse> getTransactionNo(@RequestBody CommonDtos dto) {
		String referenceNo = "";
		try {
			referenceNo = service.getTransactionNo(dto);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, referenceNo);
	}

}
