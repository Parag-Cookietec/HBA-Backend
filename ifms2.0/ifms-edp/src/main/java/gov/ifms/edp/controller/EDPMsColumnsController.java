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
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsColumnsConverter;
import gov.ifms.edp.dto.EDPMsColumnsDto;
import gov.ifms.edp.entity.EDPMsColumnsEntity;
import gov.ifms.edp.service.EDPMsColumnsService;

/**
 * The Class EDPMsColumnsController.
 * 
 * @version 1.0.
 * @created 2019/08/29 18:39:10.
 *
 */

@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_COLUMNS)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsColumnsController {

	/** The service. */
	@Autowired
	private EDPMsColumnsService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPMsColumnsConverter converter;

	/**
	 * Fetch MsColumnss by given MsColumnss id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsColumns(@RequestBody IdDto id) {
		EDPMsColumnsEntity entity = service.getMsColumns(id.getId());
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));

	}

	/**
	 * creates a new MsColumnss
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsColumns(@RequestBody EDPMsColumnsDto dto) {

		EDPMsColumnsEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsColumns(entity)));

	}

	/**
	 * Update the MsColumnss
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsColumns(@RequestBody EDPMsColumnsDto dto) {

		EDPMsColumnsEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsColumns(entity)));
	}

	

	/**
	 * Fetch all the MsColumnss items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsColumnsDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsColumns(@RequestBody PageDetails pageDetail) {
		PagebleDTO<EDPMsColumnsDto> data = service.edpMsColumnsAsMethodNameSearch(pageDetail);
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,data);
	}

}
