package gov.ifms.edp.controller;

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
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsHodConverter;
import gov.ifms.edp.dto.EDPMsHodDto;
import gov.ifms.edp.entity.EDPMsHodEntity;
import gov.ifms.edp.service.EDPMsHodService;

/**
 * The Class EDPMsHodController.
 * 
 * @version 1.0.
 * @created 2020/01/16 15:36:07.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MSHOD)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsHodController {

	/** The service. */
	@Autowired
	private EDPMsHodService service;

	/** The converter. */
	@Autowired
	private EDPMsHodConverter converter;

	/**
	 * Fetch MsHods by given MsHods id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsHod(@RequestBody IdDto id) {
		EDPMsHodEntity entity = service.getMsHod(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new MsHods.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsHod(@RequestBody EDPMsHodDto dto) {
		EDPMsHodEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsHod(entity)));
	}

	/**
	 * Update the MsHods.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsHod(@RequestBody EDPMsHodDto dto) {
		EDPMsHodEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsHod(entity)));
	}

	/**
	 * Deletes the MsHods for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteMsHod(@RequestBody StatusDto statusDto) {
		service.deleteMsHod(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the MsHods items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsHodDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsHods(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPMsHodDto> data = service.getMsHods(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the hod by department id.
	 *
	 * @param id the id
	 * @return the hod by department id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_HOD_GET_BY_DEPARTMENT_ID)
	public ResponseEntity<ApiResponse> getHodByDepartmentId(@RequestBody IdDto id) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.getHodByDepartmentId(id.getId()));
	}

}
