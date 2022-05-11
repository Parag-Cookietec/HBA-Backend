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
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPSubOfficeItrConverter;
import gov.ifms.edp.dto.EDPMsSubOfficeDto;
import gov.ifms.edp.dto.EDPSubOfficeItrDto;
import gov.ifms.edp.entity.EDPSubOfficeItrEntity;
import gov.ifms.edp.service.EDPSubOfficeItrService;


/**
 * The Class EDPSubOfficeItrController.
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_SUBOFFICEITR)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPSubOfficeItrController {
	
	
	/** The service. */
	@Autowired
	private EDPSubOfficeItrService service;
	
	/** The  converter. */
	@Autowired
	private EDPSubOfficeItrConverter converter;
	
	/**
	 * Fetch subOfficeItrs by given subOfficeItrs id .
	 *
	 * @param id the id
	 * @return  dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getsubOfficeItr(@RequestBody IdDto id) {
        EDPSubOfficeItrEntity entity = service.getsubOfficeItr(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
    }
	
	
	/**
	 * creates a new subOfficeItrs.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createsubOfficeItr( @RequestBody EDPSubOfficeItrDto dto) throws CustomException {
		try {
			EDPSubOfficeItrEntity entity = converter.toEntity(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
					converter.toDTO(service.saveOrUpdatesubOfficeItr(entity)));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
    }
	
	/**
	 * Update the subOfficeItrs.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updatesubOfficeItr(@RequestBody EDPSubOfficeItrDto dto) throws CustomException {
		try {
			EDPSubOfficeItrEntity entity = converter.toEntity(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
					converter.toDTO(service.saveOrUpdatesubOfficeItr(entity)));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}
	
	/**
	 * Deletes the subOfficeItrs for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 * @throws CustomException 
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deletesubOfficeItr(@RequestBody StatusDto statusDto) throws CustomException {
		service.deletesubOfficeItr(statusDto.getId() ,statusDto.getActiveStatus());	
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE,null);
	}
	
	/**
	 * Fetch all the subOfficeItrs items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPsubOfficeItrDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getsubOfficeItrs(@RequestBody PageDetails pageDetail)throws CustomException {
		PagebleDTO<EDPMsSubOfficeDto> data = service.getsubOfficeItrs(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, data);
	}
	
}
