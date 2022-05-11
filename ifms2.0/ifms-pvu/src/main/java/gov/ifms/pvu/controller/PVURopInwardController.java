package gov.ifms.pvu.controller;

import java.util.List;

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
import gov.ifms.pvu.converter.PVURopInwardConverter;
import gov.ifms.pvu.dto.PVUEmployeDetailsDto;
import gov.ifms.pvu.dto.PVURopInwardDto;
import gov.ifms.pvu.dto.PVURopInwardView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVURopInwardEntity;
import gov.ifms.pvu.service.PVURopInwardService;

/**
 * The Class PVURopInwardController.
 * 
 * @version v 1.0.
 * @created 2020/03/12 14:42:25.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_ROPINWARD)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVURopInwardController {

	/** The service. */
	@Autowired
	private PVURopInwardService service;

	/** The converter. */
	@Autowired
	private PVURopInwardConverter converter;

	/**
	 * Fetch RopInwards by given RopInwards id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getRopInward(@RequestBody IdDto id) {
		PVURopInwardEntity entity = service.getRopInward(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new RopInwards.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createRopInward(@RequestBody PVURopInwardDto dto) {
		PVURopInwardEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateRopInward(entity)));
	}

	/**
	 * Update the RopInwards.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateRopInward(@RequestBody PVURopInwardDto dto) {
		PVURopInwardEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateRopInward(entity)));
	}

	/**
	 * Gets the rop inwards.
	 *
	 * @param pageDetail the page detail
	 * @return the rop inwards
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getRopInwards(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVURopInwardView> data = service.getRopInwards(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_INWARD_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getInwardLuLookUpInfo() throws CustomException {
		PVUEmployeDetailsDto lstLuLookUp = service.getInwardLuLookUpInfo();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}
	
	/**
	 * Generate inward number.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GENERATE_INWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateInwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.generateInwardNumber(dto));
	}
	
	/**
	 * Submit rop event.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_INWARD_SUBMIT)
	public ResponseEntity<ApiResponse> submitRopInward(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_DISTRIBUTOR,service.submitRopInward(wrapperDto));
	}
	
	/**
	 * Submit rop distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_DISTRIBUTOR_SUBMIT)
	public ResponseEntity<ApiResponse> submitRopDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_AUDITOR,service.submitRopDistributor(wrapperDto));
	}
}
