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
import gov.ifms.edp.converter.EDPLkPuoMenuRLWFConverter;
import gov.ifms.edp.dto.EDPLkPuoMenuRLWFDto;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.edp.service.EDPLkPuoMenuRLWFService;

/**
 * The Class EDPLkPuoMenuRLWFController.
 * 
 * @version 1.0.
 * @created 2019/11/28 12:49:10.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_LKPUOMENURLWF)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPLkPuoMenuRLWFController {

	/** The service. */
	@Autowired
	private EDPLkPuoMenuRLWFService service;

	/** The converter. */
	@Autowired
	private EDPLkPuoMenuRLWFConverter converter;

	/**
	 * Fetch LkPuoMenuRLWFs by given LkPuoMenuRLWFs id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getLkPuoMenuRLWF(@RequestBody IdDto id) {
		EDPTrnUsrMnuWfRole entity = service.getLkPuoMenuRLWF(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new LkPuoMenuRLWFs.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createLkPuoMenuRLWF(@RequestBody EDPLkPuoMenuRLWFDto dto) {
		EDPTrnUsrMnuWfRole entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateLkPuoMenuRLWF(entity)));
	}

	/**
	 * Update the LkPuoMenuRLWFs.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateLkPuoMenuRLWF(@RequestBody EDPLkPuoMenuRLWFDto dto) {
		EDPTrnUsrMnuWfRole entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateLkPuoMenuRLWF(entity)));
	}

	/**
	 * Deletes the LkPuoMenuRLWFs for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteLkPuoMenuRLWF(@RequestBody StatusDto statusDto) {
		service.deleteLkPuoMenuRLWF(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the LkPuoMenuRLWFs items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPuoMenuRLWFDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getLkPuoMenuRLWFs(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPLkPuoMenuRLWFDto> data = service.getLkPuoMenuRLWFs(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

}
