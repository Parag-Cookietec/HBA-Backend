package gov.ifms.dmo.controller;

import java.util.List;
import java.util.Optional;

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
import gov.ifms.dmo.dto.DMOGRFCRFAccruedInterestPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationSearchPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFInvestmentPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalesBasePostDto;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.service.DMOGRFCRFAccruedInterestService;
import gov.ifms.dmo.service.DMOGRFCRFIntimationService;
import gov.ifms.dmo.service.DMOGRFCRFInvestmentService;
import gov.ifms.dmo.service.DMOGRFCRFLuLookUpService;
import gov.ifms.dmo.service.DMOGRFCRFSecuritySaleService;
import gov.ifms.dmo.service.DMOSecurityMasterService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.GRF_CRF_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOGRFCRFController {

	@Autowired
	DMOGRFCRFIntimationService intimationService;

	@Autowired
	DMOGRFCRFAccruedInterestService accruedInterestService;

	@Autowired
	DMOGRFCRFInvestmentService investmentService;

	@Autowired
	DMOSecurityMasterService securityMasterService;

	@Autowired
	DMOGRFCRFSecuritySaleService securitySaleService;

	@Autowired
	DMOGRFCRFLuLookUpService lookupService;

	@Trace
	@PostMapping(DMOURLConstant.GRFCRF_INTIMATION_POST_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateGRFCRFLoanIntimationReceived(
			@RequestBody @Valid DMOGRFCRFIntimationPostDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_INTIMATION_RECEIVED_MSG_CREATE,
				intimationService.saveOrUpdateGRFCRFLoanIntimationReceived(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.GRFCRF_INTIMN_NO_SEARCH_URL)
	public ResponseEntity<ApiResponse> searchGRFCRFIntimationPurchaseSales(
			@RequestBody DMOGRFCRFIntimationSearchPostDto dto) throws CustomException {
		Optional<DMOGRFCRFIntimationPostDto> resp = Optional
				.ofNullable(intimationService.searchIntimationPurchaseSales(dto));
		if (resp.isPresent()) {
			DMOGRFCRFIntimationPostDto responsePayload = resp.get();
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_INTIMN_SEARCH, responsePayload);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_INTIMN_NOT_SEARCH, dto);
	}

	@Trace
	@PostMapping(DMOURLConstant.GRFCRF_INTIMATION_TRXN_TYPES_URL)
	public ResponseEntity<ApiResponse> getLookUpList(@RequestBody DMOLookUpDto lookUpDto) throws CustomException {
		List<DMOLookUpDto> list = lookupService.fetchLookUpData(lookUpDto);
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_NOT_FETCH_DROP_DOWN_LIST, list);
	}

	@Trace
	@PostMapping(DMOURLConstant.GRFCRF_SECURITY_NAMES_GET_URL)
	public ResponseEntity<ApiResponse> getSecuritNames(@RequestBody DMOLookUpDto lookUpDto) throws CustomException {
		List<DMOLookUpDto> list = securityMasterService.fetchSecurityNames(lookUpDto);
		if (list.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, list);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_NOT_FETCH_DROP_DOWN_LIST, list);
	}

	@Trace
	@PostMapping(DMOURLConstant.GRFCRF_ACCRUED_INTEREST_POST_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateGRFCRFAccruedInterestReceived(
			@Valid @RequestBody DMOGRFCRFAccruedInterestPostDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_INTIMATION_RECEIVED_MSG_CREATE,
				accruedInterestService.saveOrUpdateGRFCRFAccruedInterestReceived(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.GRFCRF_ADVICE_INVESTMENT_POST_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateGRFCRFAdviceInvestmentReceived(
			@Valid @RequestBody DMOGRFCRFInvestmentPostDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_INTIMATION_RECEIVED_MSG_CREATE,
				investmentService.saveOrUpdateGRFCRFAdviceInvestmentReceived(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.GRFCRF_SEC_DTL_POST_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateGRFCRFSecuritySaleReceived(
			@Valid @RequestBody DMOGRFCRFSecuritySalesBasePostDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_INTIMATION_RECEIVED_MSG_CREATE,
				securitySaleService.saveOrUpdateGRFCRFSecuritySaleReceived(dto));
	}
	
	@Trace
	@PostMapping(DMOURLConstant.DMO_TILL_DT_PROG_PRI_CONTRI_URL)
	public ResponseEntity<ApiResponse> getTillDtProgPrinContri() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_INTIMN_SEARCH,
				intimationService.getTillDtProgPrinContri());
	}
}
