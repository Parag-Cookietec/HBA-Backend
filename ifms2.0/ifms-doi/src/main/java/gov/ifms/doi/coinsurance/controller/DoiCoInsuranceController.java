/**
 * 
 */
package gov.ifms.doi.coinsurance.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_CHEQUE_REGISTER_LISTING_URL;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_CHEQUE_REGISTER_URL;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_CLAIM_ENTRY_URL;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_CLAIM_LISTING_URL;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_POLICY_ENTRY_LISTING_URL;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_POLICY_ENTRY_URL;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_PREMIUM_REFUND_ENTRY_LISTING_URL;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_PREMIUM_REFUND_ENTRY_URL;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_PREMIUM_REGISTER_URL;

import java.util.ArrayList;
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

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.coinsurance.dto.DoiCoinsChequeRegisterDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsClaimHdrDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsClaimRiDtlDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPolicyHdrDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPolicyRiDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPremiumRefundDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPremiumRegisterDTO;
import gov.ifms.doi.coinsurance.service.DoiCoInsuranceService;
import gov.ifms.doi.jpa.constant.DoiJPAUrlConstants;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.workflow.dto.DoiCoinsClaimHdrWfDTO;
import gov.ifms.doi.workflow.dto.DoiCoinsPolicyHdrWfDTO;

/**
 * @author Rudra
 *
 */
@RestController
@RequestMapping(DoiJPAUrlConstants.COINS_BASE_URL) 
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoiCoInsuranceController {
	
	@Autowired
	DoiCoInsuranceService service;
	
	@Trace
	@PostMapping(COINS_CHEQUE_REGISTER_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateCoinsChequeRegister(@RequestBody DoiCoinsChequeRegisterDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdateCoinsChequeRegister(dto));
	}
	
	@Trace
	@PostMapping(COINS_CHEQUE_REGISTER_LISTING_URL)
	public ResponseEntity<ApiResponse> getCoinsChequeRegisterListing(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getCoinsChequeRegisterListing(pageDetail));
	}
	
	@Trace
	@GetMapping("/test") 
	public ResponseEntity<ApiResponse> test() {
		DoiCoinsClaimHdrDTO dto = new DoiCoinsClaimHdrDTO();
		List<DoiCoinsClaimHdrWfDTO> doiCoinsClaimHdrWf = new ArrayList<DoiCoinsClaimHdrWfDTO>();
		doiCoinsClaimHdrWf.add(new DoiCoinsClaimHdrWfDTO());
		List<DoiCoinsClaimRiDtlDTO> doiCoinsClaimRiDtl = new ArrayList<DoiCoinsClaimRiDtlDTO>();  
		doiCoinsClaimRiDtl.add(new DoiCoinsClaimRiDtlDTO());
		dto.setDoiCoinsClaimRiDtl(doiCoinsClaimRiDtl);
		dto.setDoiCoinsClaimHdrWf(doiCoinsClaimHdrWf);
		
		DoiCoinsPolicyHdrDTO dto1 = new DoiCoinsPolicyHdrDTO();
		List<DoiCoinsPolicyHdrWfDTO> doiCoinsPolicyHdrWfDTO = new ArrayList<DoiCoinsPolicyHdrWfDTO>();
		doiCoinsPolicyHdrWfDTO.add(new DoiCoinsPolicyHdrWfDTO());
		List<DoiCoinsPolicyRiDTO> dDoiCoinsPolicyRiDTO = new ArrayList<DoiCoinsPolicyRiDTO>();  
		dDoiCoinsPolicyRiDTO.add(new DoiCoinsPolicyRiDTO());
		dto1.setDoiCoinsPolicyRi(dDoiCoinsPolicyRiDTO);
		dto1.setDoiCoinsPolicyHdrWf(doiCoinsPolicyHdrWfDTO);
		
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, dto1);
	}
	
	@Trace
	@PostMapping(COINS_PREMIUM_REGISTER_URL)
	public ResponseEntity<ApiResponse> getAndSaveCoinsPremiumRegister(@RequestBody DoiCoinsPremiumRegisterDTO dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getAndSaveCoinsPremiumRegister(dto));
	}
	
	@Trace
	@PostMapping(COINS_POLICY_ENTRY_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateCoinsPolicyMaster(@RequestBody List<DoiCoinsPolicyHdrDTO> dtos) {
		for(DoiCoinsPolicyHdrDTO d: dtos){
			service.saveOrUpdateCoinsPolicyMaster(d);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, "Records added Successfully", "Records added Successfully");
	}
	
	@Trace
	@PostMapping(COINS_POLICY_ENTRY_LISTING_URL)
	public ResponseEntity<ApiResponse> getCoinsPolicyListing(@RequestBody PageDetails pageDetail) throws CustomException {


		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getCoinsPolicyListing(pageDetail));
	}
	
	@Trace
	@PostMapping(COINS_PREMIUM_REFUND_ENTRY_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateCoinsPremiumRefundEntry(@RequestBody List<DoiCoinsPremiumRefundDTO> dtos) throws CustomException {
		for(DoiCoinsPremiumRefundDTO dto: dtos){
			service.saveOrUpdateCoinsPremiumRefundEntry(dto);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, "Records added Successfully", "Records added Successfully");
	}
	
	@Trace
	@PostMapping(COINS_PREMIUM_REFUND_ENTRY_LISTING_URL)
	public ResponseEntity<ApiResponse> getCoinsPremiumRefundListing(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getCoinsPremiumRefundListing(pageDetail));
	}
	
	@Trace
	@PostMapping(COINS_CLAIM_ENTRY_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateCoinsClaimEntry(@RequestBody DoiCoinsClaimHdrDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdateCoinsClaimEntry(dto));
	}
	
	@Trace
	@PostMapping(COINS_CLAIM_LISTING_URL)
	public ResponseEntity<ApiResponse> getCoinsClaimEntryListing(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getCoinsClaimEntryListing(pageDetail));
	}
	
	@Trace
	@GetMapping("/Claim-details")
	public ResponseEntity<ApiResponse> getClaimDetials() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.findAllClaimDetails());
	}
}
