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
import gov.ifms.edp.converter.EDPLkPuoDeptBncHodConverter;
import gov.ifms.edp.dto.EDPLkPuoDeptBncHodDto;
import gov.ifms.edp.entity.EDPLkPuoDeptBncHodEntity;
import gov.ifms.edp.service.EDPLkPuoDeptBncHodService;


/**
 * The Class EDPLkPuoDeptBncHodController.
 * 
 * @version 1.0.
 * @created 2019/12/19 12:31:18.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_LKPUODEPTBNCHOD)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPLkPuoDeptBncHodController {
	
	/** The service. */
	@Autowired
	private EDPLkPuoDeptBncHodService service;
	
	/** The  converter. */
	@Autowired
	private EDPLkPuoDeptBncHodConverter converter;
	
	/**
	 * Fetch LkPuoDeptBncHods by given LkPuoDeptBncHods id .
	 *
	 * @param id the id
	 * @return  dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getLkPuoDeptBncHod(@RequestBody IdDto id) {
        EDPLkPuoDeptBncHodEntity entity = service.getLkPuoDeptBncHod(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
    }
	
	
	/**
	 * creates a new LkPuoDeptBncHods.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createLkPuoDeptBncHod( @RequestBody EDPLkPuoDeptBncHodDto dto) {
        EDPLkPuoDeptBncHodEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateLkPuoDeptBncHod(entity)));
    }
	
	/**
	 * Update the LkPuoDeptBncHods.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateLkPuoDeptBncHod(@RequestBody EDPLkPuoDeptBncHodDto dto) {
        EDPLkPuoDeptBncHodEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateLkPuoDeptBncHod(entity)));
	}
	
	/**
	 * Deletes the LkPuoDeptBncHods for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteLkPuoDeptBncHod(@RequestBody StatusDto statusDto) {
		service.deleteLkPuoDeptBncHod(statusDto.getId() ,statusDto.getActiveStatus());	
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE,null);
	}
	
	/**
	 * Fetch all the LkPuoDeptBncHods items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPuoDeptBncHodDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getLkPuoDeptBncHods(@RequestBody PageDetails pageDetail)throws CustomException {
		PagebleDTO<EDPLkPuoDeptBncHodDto> data = service.getLkPuoDeptBncHods(pageDetail);
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
	public ResponseEntity<ApiResponse> getHodByDepartmentId(@RequestBody IdDto id)throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,service.getHodByDepartmentId(id.getId()));
	}
	
}
