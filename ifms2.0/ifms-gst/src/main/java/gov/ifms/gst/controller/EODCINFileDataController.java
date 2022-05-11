package gov.ifms.gst.controller;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.accounting.dto.EodDataCinFile;
import gov.ifms.gst.dto.EODCINFileDataDto;
import gov.ifms.gst.dto.EODCINFileReportDto;
import gov.ifms.gst.dto.VoucherDto;
import gov.ifms.gst.service.impl.EODCINFileDataServiceImpl;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GstURLConstant.URL_CIN_FILE_DATA_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EODCINFileDataController {
	@Autowired
	private EODCINFileDataServiceImpl service;

	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getById(@RequestBody IdDto idDto) {
		EODCINFileDataDto dto = service.getById(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> create(@RequestBody EODCINFileDataDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.create(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> update(@RequestBody EODCINFileDataDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_UPDATE, service.update(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EODCINFileDataDto> data = service.getAll(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_VALIDATION)
	public ResponseEntity<ApiResponse> voucherCreate(@RequestBody VoucherDto dto) throws CustomException {
		VoucherDto savedVoucherDto = service.voucherCreate(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, savedVoucherDto.getMessage(),
				savedVoucherDto);

	}

	@Trace
	@PostMapping(URLConstant.URL_SEARCH_FILEDATE)
	public ResponseEntity<ApiResponse> searchByfileDate(@RequestBody EODCINFileDataDto dto) {
		List<EODCINFileReportDto> dtos = service.searchByfileDate(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);

	}

	@Trace
	@PostMapping(value = "/json/upload")
	public ResponseEntity<ApiResponse> jsonUpload(@RequestBody EodDataCinFile dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
				service.loadEodCinData(dto));
	}
}
