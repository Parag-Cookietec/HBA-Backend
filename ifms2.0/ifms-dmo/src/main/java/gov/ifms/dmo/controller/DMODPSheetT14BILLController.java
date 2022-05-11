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
import gov.ifms.dmo.dto.DMODPSheetT14BILLInvestPostDTO;
import gov.ifms.dmo.service.DMODPSheetT14BILLService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.DMO_DPSHEET_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMODPSheetT14BILLController {

	@Autowired
	private DMODPSheetT14BILLService t14BILLService;

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_T14BILL_INVEST_SUBMIT)
	public ResponseEntity<ApiResponse> saveDpSheetT14BILLInvest(@RequestBody DMODPSheetT14BILLInvestPostDTO dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				t14BILLService.saveDpSheetT14BILLInvest(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_T14BILL_MATURE_SUBMIT)
	public ResponseEntity<ApiResponse> saveDpSheetT14BILLMaturity(@RequestBody DMODPSheetT14BILLInvestPostDTO dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				t14BILLService.saveDpSheetT14BILLMaturity(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_POST_DPSHEET_T14BILL_REDISC_SUBMIT)
	public ResponseEntity<ApiResponse> saveDpSheetT14BILLReDisc(@RequestBody DMODPSheetT14BILLInvestPostDTO dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				t14BILLService.saveDpSheetT14BILLReDiscount(dto));
	}
}
