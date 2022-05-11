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
import gov.ifms.edp.converter.EDPMsTalukaConverter;
import gov.ifms.edp.dto.EDPMsTalukaDto;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.edp.service.EDPMsTalukaService;

/**
 * The Class EDPMsTalukaController.
 * 
 * @version 1.0.
 * @created 2019/12/11 11:50:41.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MSTALUKA)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsTalukaController {

	/** The service. */
	@Autowired
	private EDPMsTalukaService service;

	/** The converter. */
	@Autowired
	private EDPMsTalukaConverter converter;

	/**
	 * Fetch MsTalukas by given MsTalukas id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsTaluka(@RequestBody IdDto id) {
		EDPMsTalukaEntity entity = service.getMsTaluka(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new MsTalukas.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsTaluka(@RequestBody EDPMsTalukaDto dto) {
		EDPMsTalukaEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsTaluka(entity)));
	}

	/**
	 * Update the MsTalukas.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsTaluka(@RequestBody EDPMsTalukaDto dto) {
		EDPMsTalukaEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsTaluka(entity)));
	}

	/**
	 * Deletes the MsTalukas for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteMsTaluka(@RequestBody StatusDto statusDto) {
		service.deleteMsTaluka(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the MsTalukas items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsTalukaDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsTalukas(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPMsTalukaDto> data = service.getMsTalukas(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

}
