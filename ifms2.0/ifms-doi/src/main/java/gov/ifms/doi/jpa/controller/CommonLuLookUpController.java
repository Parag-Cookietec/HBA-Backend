package gov.ifms.doi.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.dto.LuLookUpDTO;
import gov.ifms.doi.jpa.service.CommonLuLookUpService;

@RestController
@RequestMapping(URLConstant.URL_DOI_LOOKUP_INFO)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommonLuLookUpController {

	@Autowired
	private CommonLuLookUpService lookUpService;

	/**
	 * This method is used to find look up info by object type.
	 *
	 * @return List of ClueDto
	 */
	@Trace
	@PostMapping(URLConstant.GET_REVENUE_CAPITAL)
	public ResponseEntity<ApiResponse> getRevenueCapitalByDemandId(@RequestBody LuLookUpDTO lookUpDTO) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DOI_FETCH, lookUpService.findByLookUpId(lookUpDTO));
	}
}
