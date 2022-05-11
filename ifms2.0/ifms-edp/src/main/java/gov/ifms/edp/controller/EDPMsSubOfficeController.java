package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsSubOfficeConverter;
import gov.ifms.edp.converter.EDPSubOfficeItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsSubOfficeDto;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.service.EDPMsSubOfficeService;
import gov.ifms.edp.service.EDPSubOfficeItrService;

/**
 * The Class EDPMsSubOfficeController.
 * 
 * @version 1.0.
 * @created 2019/12/05 12:35:58.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MSSUBOFFICE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsSubOfficeController {

	/** The service. */
	@Autowired
	private EDPMsSubOfficeService service;

	/** The converter. */
	@Autowired
	private EDPMsSubOfficeConverter converter;

	@Autowired
	private EDPSubOfficeItrService subOfficeItrService;

	@Autowired
	private EDPSubOfficeItrConverter officeItrConveter;

	/**
	 * Fetch MsSubOffices by given MsSubOffices id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsSubOffice(@RequestBody ClueDto id) {
		EDPMsSubOfficeEntity entity = null;
		if (id.getFlag()) {
			entity = officeItrConveter.toItrEntity(subOfficeItrService.getsubOfficeItr(id.getId()));
		} else {
			entity = service.getMsSubOffice(id.getId());
		}

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new MsSubOffices.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsSubOffice(@RequestBody EDPMsSubOfficeDto dto) throws CustomException {
		try {
			EDPMsSubOfficeEntity entity = converter.toEntity(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
					converter.toDTO(service.saveOrUpdateMsSubOffice(entity, dto)));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Update the MsSubOffices.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsSubOffice(@RequestBody EDPMsSubOfficeDto dto) throws CustomException {
		try {
			EDPMsSubOfficeEntity entity = converter.toEntity(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
					converter.toDTO(service.saveOrUpdateMsSubOffice(entity, dto)));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Deletes the MsSubOffices for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteMsSubOffice(@RequestBody ClueDto statusDto) throws CustomException {
		if (statusDto.getFlag()) {
			subOfficeItrService.deletesubOfficeItr(statusDto.getId(), statusDto.getActiveStatus());
		} else if(statusDto.getIsUpdate()!=null && statusDto.getIsUpdate() && !statusDto.getFlag()){
			service.updateSubOfficeItr(statusDto.getId(), statusDto.getActiveStatus());
		} else {
			service.deleteMsSubOffice(statusDto.getId(), statusDto.getActiveStatus());
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the MsSubOffices items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsSubOfficeDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsSubOffices(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPMsSubOfficeDto> data = service.getMsSubOffices(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

}
