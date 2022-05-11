package gov.ifms.doi.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.StateDTO;
import gov.ifms.doi.jpa.service.BankBranchService;
import gov.ifms.doi.jpa.service.BankService;
import gov.ifms.doi.jpa.service.DistrictService;
import gov.ifms.doi.jpa.service.DoiCommonLookupInfoService;
import gov.ifms.doi.jpa.service.StateService;
import gov.ifms.doi.jpa.service.TalukaService;
import gov.ifms.doi.jpa.service.VillageService;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.*;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@RestController
public class CommonController {

	@Autowired
	DoiCommonLookupInfoService doiCommonLookupInfoService;

	@Autowired
	StateService stateService;

	@Autowired
	DistrictService districtService;

	@Autowired
	TalukaService talukaService;

	@Autowired
	VillageService villageService;

	@Autowired
	BankService bankService;

	@Autowired
	BankBranchService bankBranchService;

	@Trace
	@GetMapping(value = JPA_COMMON_LOOKUP_CAUSE_OF_LOST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getStatusList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.CAUSE_OF_LOSS_LIST));
	}

	@Trace
	@GetMapping(value = JPA_COMMON_REQUIREMENT_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getRequirementList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.YES_NO_REQUIREMENT_LIST));
	}

	@Trace
	@GetMapping(value = JPA_ACTIVE_INACTIVE_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getActiveInActiveList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_INACTIVE_LIST));
	}

	@Trace
	@GetMapping(value = JPA_POLICY_TYPES_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getPolicyTypeList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_POLICY_TYPES_LIST));
	}

	@Trace
	@GetMapping(value = JPA_POLICY_STATUS_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getPolicyStatusList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_POLICY_STATUS_LIST));
	}

	@Trace
	@GetMapping(value = JPA_YEAR_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getYearList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_YEAR_LIST));
	}

	@Trace
	@GetMapping(value = JPA_MONTH_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getMonthList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_MONTH_LIST));
	}

	@Trace
	@GetMapping(value = JPA_LOOKUP_INFO_BASED_ON_CATEGORY, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getLookupInfo(@RequestParam(name = "pathVariable") String pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_DISTRICT_LIST_GUJRAT, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDistrictListGujrat() {
		StateDTO stateDTO = stateService.getStateByName(DoiJPAConstants.GUJRAT_STATE);
		if (stateDTO != null) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
					districtService.getDistrictByStateId(stateDTO.getStateId()));
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				districtService.getDistrictByStateId(DoiJPAConstants.GUJRAT_STATE_ID));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_DISTRICT_LIST_BY_STATE_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDistrictListByStateId(
			@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				districtService.getDistrictByStateId(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_DISTRICT_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDistrictList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				districtService.getDistrictList());
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_TALUKA_LIST_BY_DISTRICT_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getTalukaListByDistrictId(
			@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				talukaService.getTalukaListByDistrictId(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_VILLAGE_LIST_BY_TALUKA_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getVillageListByTalukaId(
			@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				villageService.getVillageListByTalukaId(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_TALUKA_BY_TALUKA_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getTalukaByTalukaId(@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				talukaService.getTalukaById(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_VILLAGE_BY_VILLAGE_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getVillageByVillageId(@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				villageService.getVillageById(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_STATE_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getStateList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, stateService.getStateList());
	}

	@Trace
	@GetMapping(value = DOI_BANK_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getActiveBankList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, bankService.getActiveBankList());
	}

	@Trace
	@GetMapping(value = DOI_BANK_BRANCH_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getActiveBankBranchListByBankId(
			@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				bankBranchService.getActiveBankBranchListByBankId(pathVariable));
	}

	@Trace
	@GetMapping(value = DOI_DB_PARTY_TYPES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDirectBusinessPartyType() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.DIRECT_BUSINESS_PARTY_TYPE));
	}

	@Trace
	@GetMapping(value = DOI_DB_OFFICE_TYPES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDirectBusinessOfficeTypes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.DIRECT_BUSINESS_OFFICE_TYPE));
	}

	@Trace
	@GetMapping(value = DOI_BANK_BRANCH_TYPES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDoiBankBranchTypes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.DOI_BANK_BRANCH_TYPE));
	}

	@Trace
	@GetMapping(value = DOI_PAYMENT_MODES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDoiPaymentModes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.DOI_PAYMENT_MODE));
	}

}
