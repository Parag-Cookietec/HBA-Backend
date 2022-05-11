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
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVUEmployeEventsConverter;
import gov.ifms.pvu.dto.PVUEmpEventsResponse;
import gov.ifms.pvu.dto.PVUEmpEventsRevisedRegularTab;
import gov.ifms.pvu.dto.PVUEmpTrnEventTabView;
import gov.ifms.pvu.dto.PVUEmployeEventView;
import gov.ifms.pvu.dto.PVUEmployeEventsDto;
import gov.ifms.pvu.dto.PVUEmployeFifthPayEventView;
import gov.ifms.pvu.dto.PVUEmployeJoinPayEventView;
import gov.ifms.pvu.dto.PVUEmployeSixPayEventView;
import gov.ifms.pvu.dto.PVUEmployeSusEolView;
import gov.ifms.pvu.dto.PVUEmployeeSevenPayEventView;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployeEventsController.
 * 
 * @version v 1.0.
 * @created 2019/12/03 03:14:53.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYEEVENTS)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeEventsController {

	/** The service. */
	@Autowired
	private PVUEmployeEventsService service;

	/** The converter. */
	@Autowired
	private PVUEmployeEventsConverter converter;

	/**
	 * Fetch EmployeEventss by given EmployeEventss id.
	 *
	 * @param id the id
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeEvents(@RequestBody IdDto id) throws CustomException {
		List<Object> entity = null;
		entity = service.getEmployeeCheckPayLevelByEmpId(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, entity);
	}

	/**
	 * creates a new EmployeEventss.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployeEvents(@RequestBody PVUEmployeEventsDto dto) {
		PVUEmployeEventsEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateEmployeEvents(entity)));
	}

	/**
	 * Update the EmployeEventss.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEmployeEvents(@RequestBody PVUEmployeEventsDto dto) {
		PVUEmployeEventsEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateEmployeEvents(entity)));
	}

	/**
	 * Gets the employe eventss.
	 *
	 * @param pageDetail the page detail
	 * @return the employe eventss
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getEmployeEventss(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUEmployeEventView> data = service.getEmployeEventss(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Gets the employe joining pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe joining pay events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_EMP_JOIN_PAY)
	public ResponseEntity<ApiResponse> getEmployeJoiningPayEvents(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeJoinPayEventView> data = service.getEmployeJoinPayEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Gets the employe fifth pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe fifth pay events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_EMP_FIFTH_PAY)
	public ResponseEntity<ApiResponse> getEmployeFifthPayEvents(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeFifthPayEventView> data = service.getEmployeFifthPayEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Gets the employe six pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe six pay events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_EMP_SIX_PAY)
	public ResponseEntity<ApiResponse> getEmployeSixPayEvents(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeSixPayEventView> data = service.getEmployeeSixPayEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Gets the employe seven pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the employe seven pay events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_EMP_SEVEN_PAY)
	public ResponseEntity<ApiResponse> getEmployeSevenPayEvents(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeeSevenPayEventView> data = service.getEmployeSevenPayEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Gets the emp sus eol trn event.
	 *
	 * @param pageDetail the page detail
	 * @return the emp sus eol trn event
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_EMP_SUS_EOL)
	public ResponseEntity<ApiResponse> getEmpSusEolTrnEvent(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeSusEolView> data = service.getSusEolDetails(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Gets the emp trn event.
	 *
	 * @param pageDetail the page detail
	 * @return the emp trn event
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_EMP_TRN)
	public ResponseEntity<ApiResponse> getEmpTrnEvent(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUEmpTrnEventTabView> data = service.getEmpTrnEvent(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_EMPEVENTS_REG_REV_TAB)
	public ResponseEntity<ApiResponse> getEmpEventTabRevised(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PVUEmpEventsRevisedRegularTab data = service.getEmpEventTabRevised(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Gets the emp event id by event details.
	 *
	 * @param json the json
	 * @return the emp event id by event details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_EMPEVENTS_ID_BYEVNTDETAILS)
	public ResponseEntity<ApiResponse> getEmpEventIdByEventDetails(@RequestBody Map<String, String> json)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getEventIdByEventCodeAndTrnNo(json.get(PvuConstant.PVU_EMP_REQ_PARAM_EVNTCD),
						json.get(PvuConstant.PVU_EMP_REQ_PARAM_TRNNO)));
	}

}
