package gov.ifms.edp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
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
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPOfficeItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPOfficeItrDto;
import gov.ifms.edp.dto.EDPOfficeItrView;
import gov.ifms.edp.dto.EDPOfficeSummaryDDODto;
import gov.ifms.edp.dto.EDPOfficeSummaryDto;
import gov.ifms.edp.entity.EDPOfficeItrEntity;
import gov.ifms.edp.service.EDPOfficeItrService;

/**
 * The Class EDPOfficeItrController.
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_EDPOFFICEITR)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Validated
public class EDPOfficeItrController {

	/** The service. */
	@Autowired
	private EDPOfficeItrService service;

	/** The converter. */
	@Autowired
	private EDPOfficeItrConverter converter;

	/**
	 * Fetch EdpOfficeItrs by given EdpOfficeItrs id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEdpOfficeItr(@RequestBody IdDto id) {
		EDPOfficeItrEntity entity = service.getEdpOfficeItr(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new EdpOfficeItrs.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEdpOfficeItr(@Valid @RequestBody EDPOfficeItrDto dto)
			throws CustomException {
		try {
			EDPOfficeItrEntity entity = converter.toEntity(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
					converter.toDTO(service.saveOrUpdateEdpOfficeItr(entity)));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Update the EdpOfficeItrs.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEdpOfficeItr(@RequestBody EDPOfficeItrDto dto) throws CustomException {
		try {
			EDPOfficeItrEntity entity = converter.toEntity(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
					converter.toDTO(service.saveOrUpdateEdpOfficeItr(entity)));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Deletes the EdpOfficeItrs for the given id.
	 *
	 * @param trnNumber the trn number
	 * @return the api response
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteEdpOfficeItr(@RequestBody String trnNumber) throws CustomException {
		service.deleteEdpOfficeItr(trnNumber);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the EdpOfficeItrs items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPEdpOfficeItrDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getEdpOfficeItrs(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPOfficeItrDto> data = service.getEdpOfficeItrs(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, data);
	}

	/**
	 * List edp offices.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_FIELDS)
	public ResponseEntity<ApiResponse> listEdpOffices(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPOfficeItrView> data = service.listEdpOffices(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * List edp update offices.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_UO_WF)
	public ResponseEntity<ApiResponse> listEdpUpdateOffices(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPOfficeItrView> data = service.listEdpUpdateOffices(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Summary list edp office.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFC_UPDATE_LIST_EDP)
	public ResponseEntity<ApiResponse> summaryListEdpOffice(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPOfficeSummaryDto> data = service.summaryListEdpOffice(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Summary list DDO office.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFC_UPDATE_LIST_DDO)
	public ResponseEntity<ApiResponse> searchSummaryListDDOOffice(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPOfficeSummaryDDODto> data = service.searchSummaryListDDOOffice(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Summary list DDO office.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFFICE_DETAIL_SUMMARY_DDO)
	public ResponseEntity<ApiResponse> searchSummaryListDDOOfficeDetail(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPOfficeSummaryDDODto> data = service.searchSummaryListDDOOfficeDetail(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Fetch EdpOfficeItrs by given EdpOfficeItrs id.
	 *
	 * @param dto the dto
	 * @return dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_OFFICEITR_BY_TRNNO)
	public ResponseEntity<ApiResponse> getEdpOfficeItrByTrnNo(@RequestBody ClueDto dto) throws CustomException {
		if (!StringUtils.isEmpty(dto.getTrnNo()))
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getEdpOfficeItr(dto.getTrnNo()));
		else
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
	}
}
