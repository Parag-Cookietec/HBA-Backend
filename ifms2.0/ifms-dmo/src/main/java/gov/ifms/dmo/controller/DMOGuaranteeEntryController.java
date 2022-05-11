package gov.ifms.dmo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOGuaranteeEntryBasePostDto;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.service.DMOGuaranteeEntryService;
import gov.ifms.dmo.service.DMOInstituteMstService;
import gov.ifms.dmo.service.EDPDepartmentMstService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.DMO_GUARANTEE_ENTRY_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOGuaranteeEntryController {

	@Autowired
	DMOGuaranteeEntryService dmoGuaranteeEntryService;

	@Autowired
	EDPDepartmentMstService edpDepartmentMstService;
	@Autowired
	DMOInstituteMstService dmoInstituteMstService;

	@Trace
	@PostMapping(DMOURLConstant.DMO_GUARANTEE_ENTRY_POST_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateGuaranteeEntryReceived(
			@Valid @RequestBody DMOGuaranteeEntryBasePostDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_INTIMATION_RECEIVED_MSG_CREATE,
				dmoGuaranteeEntryService.saveOrUpdateGuaranteeEntryReceived(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.DMO_GET_ALL_DEPT_MST_POST_URL)
	public ResponseEntity<ApiResponse> getAllDepartment() throws CustomException {
		List<DMOLookUpDto> list = edpDepartmentMstService.getAllDepartment();
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_NOT_FETCH_DROP_DOWN_LIST, list);
	}

	@Trace
	@PostMapping(DMOURLConstant.DMO_GET_ALL_HOD_BY_DEPT_POST_URL)
	public ResponseEntity<ApiResponse> getAllHODByDepartment(@RequestBody DMOLookUpDto dto) throws CustomException {
		List<DMOLookUpDto> list = edpDepartmentMstService.getAllHODByDepartment(dto);
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_NOT_FETCH_DROP_DOWN_LIST, list);
	}

	@Trace
	@PostMapping(DMOURLConstant.DMO_GET_ALL_INSTITUTE_POST_URL)
	public ResponseEntity<ApiResponse> getAllInstitute() throws CustomException {
		List<DMOLookUpDto> list = dmoInstituteMstService.getAllInstitute();
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_NOT_FETCH_DROP_DOWN_LIST, list);
	}

	@Trace
	@PostMapping(DMOURLConstant.DMO_GET_ALL_DESIGNATION_POST_URL)
	public ResponseEntity<ApiResponse> getAllDesignation() throws CustomException {
		List<DMOLookUpDto> list = dmoInstituteMstService.getAllDesignation();
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_NOT_FETCH_DROP_DOWN_LIST, list);
	}

	@Trace
	@PostMapping(DMOURLConstant.DMO_GET_ALL_PURPOSE_POST_URL)
	public ResponseEntity<ApiResponse> getAllPurpose() throws CustomException {
		List<DMOLookUpDto> list = dmoInstituteMstService.getAllPurpose();
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_NOT_FETCH_DROP_DOWN_LIST, list);
	}
	@Trace
	@PostMapping(DMOURLConstant.DMO_GET_ALL_TREASURY_POST_URL)
	public ResponseEntity<ApiResponse> getAllTreasury() throws CustomException {
		List<DMOLookUpDto> list = dmoInstituteMstService.getAllTreasury();
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_NOT_FETCH_DROP_DOWN_LIST, list);
	}
	@Trace
	@PostMapping(DMOURLConstant.DMO_GET_ALL_FINANCIAL_POST_URL)
	public ResponseEntity<ApiResponse> getAllFinancial() throws CustomException {
		List<DMOLookUpDto> list = dmoInstituteMstService.getAllFinancial();
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_NOT_FETCH_DROP_DOWN_LIST, list);
	}
}
