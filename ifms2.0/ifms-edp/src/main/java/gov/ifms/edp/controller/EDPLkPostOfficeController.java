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
import gov.ifms.edp.converter.EDPLkPostOfficeConverter;
import gov.ifms.edp.dto.EDPLkPostOfficeDto;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.service.EDPLkPostOfficeService;

/**
 * The Class EDPLkPostOfficeController.
 * 
 * @version 1.0.
 * @created 2019/12/26 11:14:39.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_LKPOSTOFFICE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPLkPostOfficeController {

	/** The service. */
	@Autowired
	private EDPLkPostOfficeService service;

	/** The converter. */
	@Autowired
	private EDPLkPostOfficeConverter converter;

	/**
	 * Fetch LkPostOffices by given LkPostOffices id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getLkPostOffice(@RequestBody IdDto id) {
		EDPLkPostOfficeEntity entity = service.getLkPostOffice(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new LkPostOffices.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createLkPostOffice(@RequestBody EDPLkPostOfficeDto dto) {
		EDPLkPostOfficeEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateLkPostOffice(entity)));
	}

	/**
	 * Update the LkPostOffices.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateLkPostOffice(@RequestBody EDPLkPostOfficeDto dto) {
		EDPLkPostOfficeEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateLkPostOffice(entity)));
	}

	/**
	 * Deletes the LkPostOffices for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteLkPostOffice(@RequestBody StatusDto statusDto) {
		service.deleteLkPostOffice(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the LkPostOffices items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPostOfficeDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getLkPostOffices(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPLkPostOfficeDto> data = service.getLkPostOffices(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, data);
	}

}
