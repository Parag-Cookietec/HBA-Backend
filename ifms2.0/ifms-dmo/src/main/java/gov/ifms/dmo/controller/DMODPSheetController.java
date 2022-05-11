package gov.ifms.dmo.controller;

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
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMODPSheetHDREntryPostDto;
import gov.ifms.dmo.dto.DMODPSheetHDRPostDto;
import gov.ifms.dmo.service.DMODPSheetService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.DMO_DPSHEET_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMODPSheetController {

	@Autowired
	private DMODPSheetService dpSheetService;

	@Trace
	@PostMapping(DMOURLConstant.URL_GET_DPSHEET_DETAILS)
	public ResponseEntity<ApiResponse> getDetailsOfDPSheet(@RequestBody DMODPSheetHDRPostDto pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST,
				dpSheetService.getDPSheetByCodeAndDateAndRcvdDt(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_GET_LATEST_DPSHEET)
	public ResponseEntity<ApiResponse> getLatestDPSheet() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST,
				dpSheetService.getLatestDPSheet());
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DEL_DPSHEET_DTL)
	public ResponseEntity<ApiResponse> deleteDpSheetDetails(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_UPDATE_MSG,
				dpSheetService.deleteDpSheetDtl(idDto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_SAVE_AS_DRAFT)
	public ResponseEntity<ApiResponse> saveAsDraft(@RequestBody DMODPSheetHDREntryPostDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				dpSheetService.saveAsDraftDPSheet(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_FY)
	public ResponseEntity<ApiResponse> fyDropDown() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, dpSheetService.fyDropDown());
	}

}
