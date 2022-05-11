package gov.ifms.pvu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeFivePayDetailDto;
import gov.ifms.pvu.dto.PVUEmployePayDetailDtos;
import gov.ifms.pvu.dto.PVUEmployeSixPayDetailDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.service.PVUEmployePayDetailService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployePayDetailController.
 *
 * @version v 1.0.
 * @created 2019/11/26 12:51:22.
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYE6PAYDETAIL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployePayDetailController {

	/**
	 * The service.
	 */
	@Autowired
	private PVUEmployePayDetailService service;

	/**
	 * Fetch Employe6PayDetails by given Employe6PayDetails id.
	 *
	 * @param id the id
	 * @return dto
	 * @throws CustomException 
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployePayDetail(@RequestBody IdDto id) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getEmployepayDetails(id.getId()));
	}

	/**
	 * creates a new EmployePayDetails.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployPayDetail(@RequestBody PVUEmployePayDetailDtos dto) throws CustomException {
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdateEmployePayDetail(dto));
	}

	/**
	 * Gets the employe pay details.
	 *
	 * @param pageDetail the page detail
	 * @return the employe pay details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getEmployePayDetails(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeSixPayDetailDto> data = service.getEmploye6PayDetails(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, data);
	}

	/**
	 * Gets the basic pay detail.
	 *
	 * @param request the request
	 * @return the basic pay detail
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_GET_SEVEN_PAY_BASIC_PAY)
	public ResponseEntity<ApiResponse> getBasicPayDetail(@RequestBody PvuCommonRequest request) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getSevenBasic(request));
	}

	/**
	 * Update the MsPayScales.
	 *
	 * @param id the id
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> getCurrentBasicPay(@RequestBody List<IdDto> id) {
		PVUEmployeFivePayDetailDto entity = service.getBasic(id.get(0).getId(), id.get(1).getId());
		long revisedBasicPay = entity.getBasicPay() + (entity.getBasicPay() * 3 / 100);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, revisedBasicPay);
	}

	
	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_ALL_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	/**
	 * Gets the seven basic by plevel and pk.
	 *
	 * @param request the request
	 * @return the seven basic by plevel and pk
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_GET_SEVEN_PAY_BASIC_CELL)
	public ResponseEntity<ApiResponse> getSevenBasicByPlevelAndPk(@RequestBody PvuCommonRequest request) throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getSevenBasicByPlevelAndPk(request));
	}
	
}
