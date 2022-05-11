package gov.ifms.edp.controller;

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
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.dto.EDPMsDistrictDto;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.service.EDPMsDistrictService;

/**
 * The Class EDPMsDistrictController.
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_DISTRICT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsDistrictController {

	/** The service. */
	@Autowired
	private EDPMsDistrictService service;

	/** The converter. */
	@Autowired
	private EDPMsDistrictConverter converter;

	/**
	 * Fetch DistrictNames by given DistrictNames id .
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getDistrictName(@RequestBody IdDto id) {
		EDPMsDistrictEntity entity = service.getDistrictName(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new DistrictNames.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createDistrictName(@RequestBody EDPMsDistrictDto dto) {
		EDPMsDistrictEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateDistrictName(entity)));
	}

	/**
	 * Update the DistrictNames.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateDistrictName(@RequestBody EDPMsDistrictDto dto) {
		EDPMsDistrictEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateDistrictName(entity)));
	}

	/**
	 * Fetch all the DistrictNames items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPDistrictNameDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getDistrictNames(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPMsDistrictDto> data = service.getDistrictNames(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, data);
	}

	/**
	 * Gets the all district.
	 *
	 * @return the all district
	 */
	@Trace
	@PostMapping(URLConstant.GET_ALL)
	public ResponseEntity<ApiResponse> getAllDistrict() {
		List<EDPMsDistrictEntity> allDistrict = service.getAllDistrict();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				this.converter.toDTO(allDistrict));
	}
}
