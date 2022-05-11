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
import gov.ifms.dmo.dto.DMODPSheetT91BILLInvestPostDTO;
import gov.ifms.dmo.service.DMODPSheetT91BILLService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.DMO_DPSHEET_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMODPSheetT91BILLController {
	@Autowired
	private DMODPSheetT91BILLService t91BILLService;

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_T91BILL_INVEST_SUBMIT)
	public ResponseEntity<ApiResponse> saveDpSheetT91BILLInvest(@RequestBody DMODPSheetT91BILLInvestPostDTO dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				t91BILLService.saveDpSheetT91BILLInvest(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_T91BILL_MATURE_SUBMIT)
	public ResponseEntity<ApiResponse> saveDpSheetT91BILLMaturity(@RequestBody DMODPSheetT91BILLInvestPostDTO dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				t91BILLService.saveDpSheetT91BILLMaturity(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_T91BILL_REDISC_SUBMIT)
	public ResponseEntity<ApiResponse> saveDpSheetT91BILLReDisc(@RequestBody DMODPSheetT91BILLInvestPostDTO dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				t91BILLService.saveDpSheetT91BILLReDisc(dto));
	}
}
