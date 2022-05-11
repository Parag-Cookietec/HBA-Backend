package gov.ifms.doi.jpa.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_CONFIG_SCHEME_POLICY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.service.ConfigService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@RestController
public class ConfigController {
	
	@Autowired
	ConfigService configService;
	
	@Trace
	@GetMapping(value = JPA_CONFIG_SCHEME_POLICY, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getSchemePolicyList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, configService.getSchemePolicyList());
	}
}
