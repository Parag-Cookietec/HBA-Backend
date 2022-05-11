package gov.ifms.gst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.HeadDto;
import gov.ifms.gst.dto.HeadwiseDetailDto;
import gov.ifms.gst.dto.ManualEntryDto;
import gov.ifms.gst.dto.ManualEntryLstResDto;
import gov.ifms.gst.dto.ManualEntryTypeDto;
import gov.ifms.gst.service.ManualEntryService;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_MANUAL_ENTRY_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ManualEntryController {

	@Autowired
	private ManualEntryService service;

	@Trace
	@GetMapping(GstURLConstant.URL_MANUAL_ENTRY_TYPE_LIST)
	public ResponseEntity<ApiResponse> getTypeList() {
		List<ManualEntryTypeDto> dtos = service.getTypeList();
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}

	@Trace
	@PostMapping(GstURLConstant.URL_MAJOR_HEAD_LIST)
	public ResponseEntity<ApiResponse> getMajorHeadList() {
		List<HeadDto> dtos = service.getMajorHeadList();
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}

	@Trace
	@PostMapping(GstURLConstant.URL_SUB_MAJOR_HEAD_LIST)
	public ResponseEntity<ApiResponse> getSubMajorHeadList(@RequestBody HeadwiseDetailDto headwiseDetailDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
				service.getSubMajorHeadList(headwiseDetailDto));
	}

	@Trace
	@PostMapping(GstURLConstant.URL_MINOR_HEAD_LIST)
	public ResponseEntity<ApiResponse> getMinorHeadList(@RequestBody HeadwiseDetailDto headwiseDetailDto) {
		List<HeadDto> dtos = service.getMinorHeadList(headwiseDetailDto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}

	@Trace
	@PostMapping(GstURLConstant.URL_SUB_HEAD_LIST)
	public ResponseEntity<ApiResponse> getSubHeadList(@RequestBody HeadwiseDetailDto headwiseDetailDto) {
		List<HeadDto> dtos = service.getSubHeadList(headwiseDetailDto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}

	@Trace
	@PostMapping(GstURLConstant.URL_DETAILS_HEAD_LIST)
	public ResponseEntity<ApiResponse> getDetailsHeadList(@RequestBody HeadwiseDetailDto headwiseDetailDto) {
		List<HeadDto> dtos = service.getDetailsHeadList(headwiseDetailDto);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}

	@Trace
	@PostMapping(GstURLConstant.URL_OBJECT_HEAD_LIST)
	public ResponseEntity<ApiResponse> getObjectHeadList() {
		List<HeadDto> dtos = service.getObjectHeadList();
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, dtos);
	}

	@Trace
	@PostMapping(GstURLConstant.URL_POST_SUBMIT)
	public ResponseEntity<ApiResponse> submitManualEntry(@RequestBody ManualEntryDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.saveOrUpdate(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getManualEntryList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
				service.getManualEntryList(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getById(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH,
				service.getById(idDto.getId()));
	}

	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteById(@RequestBody IdDto idDto) {
		service.deleteById(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_LIST + URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> searchList(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<ManualEntryLstResDto> data = service.getManualEntryWfList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}
}
