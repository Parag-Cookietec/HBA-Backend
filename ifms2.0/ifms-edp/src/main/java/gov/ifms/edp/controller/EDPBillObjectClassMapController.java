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
import gov.ifms.edp.converter.EDPBillObjectClassMapConverter;
import gov.ifms.edp.dto.EDPBillObjectClassMapDto;
import gov.ifms.edp.entity.EDPBillObjectClassMapEntity;
import gov.ifms.edp.service.EDPBillObjectClassMapService;

/**
 * The Class EDPBillObjectClassMapController.
 * 
 * @version 1.0.
 * @created 2020/01/02 11:05:49.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_BILLOBJECTCLASSMAP)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPBillObjectClassMapController {

	/** The service. */
	@Autowired
	private EDPBillObjectClassMapService service;

	/** The converter. */
	@Autowired
	private EDPBillObjectClassMapConverter converter;

	/**
	 * Fetch BillObjectClassMaps by given BillObjectClassMaps id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getBillObjectClassMap(@RequestBody IdDto id) {
		EDPBillObjectClassMapEntity entity = service.getBillObjectClassMap(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new BillObjectClassMaps.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createBillObjectClassMap(@RequestBody EDPBillObjectClassMapDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,service.saveOrUpdateBillObjectClassMap(dto));
	}

	/**
	 * Update the BillObjectClassMaps.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateBillObjectClassMap(@RequestBody EDPBillObjectClassMapDto dto) {
		EDPBillObjectClassMapEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateBillObjectClassMap(entity)));
	}

	/**
	 * Deletes the BillObjectClassMaps for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteBillObjectClassMap(@RequestBody StatusDto statusDto) {
		service.deleteBillObjectClassMap(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the BillObjectClassMaps items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPBillObjectClassMapDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getBillObjectClassMaps(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPBillObjectClassMapDto> data = service.getBillObjectClassMaps(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}
	
	
	
	/**
	 * Ge bill object class type details.
	 *
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BILL_OBJECT_TYPE_DETAILS)
	public ResponseEntity<ApiResponse> geBillObjectClassTypeDetails()  {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, service.geBillObjectClassTypeDetails());
	}
	
	
	/**
	 * Gets the object class type.
	 *
	 * @param idDto the id dto
	 * @return the object class type
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_OBJECT_TYPE_DETAILS)
	public ResponseEntity<ApiResponse> getObjectClassType(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,service.getObjectClass(idDto.getId()));
	}

}
