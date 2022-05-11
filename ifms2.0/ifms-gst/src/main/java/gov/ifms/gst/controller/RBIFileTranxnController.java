package gov.ifms.gst.controller;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.RBIFileTranxnDto;
import gov.ifms.gst.service.impl.RBIFileTranxnServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GstURLConstant.URL_RBIFILETRAN_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RBIFileTranxnController {

	@Autowired
	private RBIFileTranxnServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_SEARCH_BY_DATE)
	public ResponseEntity<ApiResponse> searchByDate(@RequestBody RBIFileTranxnDto dto){
		List<RBIFileTranxnDto> data = service.searchByDate(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}
}
