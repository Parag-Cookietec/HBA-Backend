package gov.ifms.gst.controller;

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
import gov.ifms.gst.dto.VoucherDto;
import gov.ifms.gst.entity.FileAccountingProcessed;
import gov.ifms.gst.service.impl.FileAccountingProcessedServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_FILEPROCESSED_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileAccountingProcessedController {
	private static final String PAGE_SIZE = "5";
	@Autowired
	private FileAccountingProcessedServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> update(@RequestBody FileAccountingProcessedDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_UPDATE, service.update(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<FileAccountingProcessedDto> data = service.getAll(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_CPIN_STATUS)
	public ResponseEntity<ApiResponse> getSearch(
			@RequestParam(name = "pageNumber", defaultValue = "0") String pageNumber,
			@RequestParam(name = "pageSize", defaultValue = PAGE_SIZE) String pageSize,
			@RequestBody FileAccountingProcessedDto dto) {
		ListingDto dtos = service.getSearch(Integer.valueOf(pageNumber), Integer.valueOf(pageSize), dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dtos);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_LIST)
	public ResponseEntity<ApiResponse> getList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH,
				service.getPenalInterestWfList(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_VOUCHERNO)
	public ResponseEntity<ApiResponse> search(@RequestBody FileAccountingProcessed dto) {
		VoucherDto dtos = service.search(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dtos);
	}
}
