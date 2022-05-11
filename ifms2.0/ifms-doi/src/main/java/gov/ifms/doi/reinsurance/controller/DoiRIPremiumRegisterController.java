/**
 * 
 */
package gov.ifms.doi.reinsurance.controller;

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
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.constant.DoiJPAUrlConstants;
import gov.ifms.doi.reinsurance.dto.DoiRiClaimDtlDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiClaimHdrDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiPolicyHdrDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiPremiumRegisterDTO;
import gov.ifms.doi.reinsurance.service.DoiRIPremiumRegisterService;


/**
 * @author Rudra
 *
 */
@RestController
@RequestMapping(DoiJPAUrlConstants.RI_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoiRIPremiumRegisterController {
	
	@Autowired
	DoiRIPremiumRegisterService service;
	
	@Trace
	@PostMapping(DoiJPAUrlConstants.RI_PREMIUM_REGISTER_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateRIPremiumRegister(@RequestBody DoiRiPremiumRegisterDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdateRIPremiumRegister(dto));
	}
	
	@Trace
	@PostMapping(DoiJPAUrlConstants.RI_CLAIM_RECOVERY_ENTRY_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateRIClaimRecoveryEntry(@RequestBody DoiRiClaimHdrDTO dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdateRIClaimRecoveryEntry(dto));
	}
	
	@Trace
	@PostMapping(DoiJPAUrlConstants.RI_POLICY_MASTER_URL)
	public ResponseEntity<ApiResponse> saveOrUpdateRIPolicyMaster(@RequestBody DoiRiPolicyHdrDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdateRIPolicyMaster(dto));
	}
	
	@Trace
	@GetMapping("/test")
	public ResponseEntity<ApiResponse> saveOrUpdateRIPremiumRegisterTest() {
		
		DoiRiClaimDtlDTO dto = new DoiRiClaimDtlDTO();
		DoiRiClaimHdrDTO doiRiClaimHdrDto = new DoiRiClaimHdrDTO();
		List<DoiRiClaimDtlDTO> doiRiClaimDtl = new ArrayList<>();
		doiRiClaimDtl.add(dto);
		doiRiClaimHdrDto.setDoiRiClaimDtl(doiRiClaimDtl );
		
		
		/*
		DoiRiPolicyHdrDTO doiRiPolicyHdr = new DoiRiPolicyHdrDTO();
		List<DoiRiPolicyDtlDTO> doiRiPolicyDtl = new ArrayList<DoiRiPolicyDtlDTO>();
		DoiRiPolicyDtlDTO dto = new DoiRiPolicyDtlDTO();
		doiRiPolicyDtl.add(dto);
		doiRiPolicyHdr.setDoiRiPolicyDtl(doiRiPolicyDtl );
		*/
		
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, doiRiClaimHdrDto);
	}
	
	@Trace
	@GetMapping(DoiJPAUrlConstants.RI_GET_POLICY_CLAIM_URL)
	public ResponseEntity<ApiResponse> getAllPolicyDtl() {
		
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.findAllPolicyDtl());
	}



}
