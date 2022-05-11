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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMODPSheetWMAPostDTO;
import gov.ifms.dmo.service.DMODPSheetWmaService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.DMO_DPSHEET_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMODPSheetWmaController {

	@Autowired
	private DMODPSheetWmaService wmaService;

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_WMA_ADV_SUBMIT)
	public ResponseEntity<ApiResponse> saveDpSheetWmaAdv(@RequestBody DMODPSheetWMAPostDTO dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				wmaService.saveDpSheetWmaAdv(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_WMA_INTRST_SUBMIT)
	public ResponseEntity<ApiResponse> saveDpSheetWmaInterest(@RequestBody DMODPSheetWMAPostDTO dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				wmaService.saveDpSheetWmaInterest(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_WMA_PRINCIPAL_SUBMIT)
	public ResponseEntity<ApiResponse> saveDpSheetWmaPrincipal(@RequestBody DMODPSheetWMAPostDTO dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				wmaService.saveDpSheetWmaPrincipal(dto));
	}

}
