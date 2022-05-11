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
import gov.ifms.edp.converter.EDPMsSubTreasuryConverter;
import gov.ifms.edp.dto.EDPMsSubTreasuryDto;
import gov.ifms.edp.entity.EDPMsSubTreasuryEntity;
import gov.ifms.edp.service.EDPMsSubTreasuryService;

/**
 * The Class EDPMsSubTreasuryController.
 * 
 * @version 1.0.
 * @created 2020/01/20 10:59:54.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MSSUBTREASURY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsSubTreasuryController {

	/** The service. */
	@Autowired
	private EDPMsSubTreasuryService service;

	/** The converter. */
	@Autowired
	private EDPMsSubTreasuryConverter converter;

	/**
	 * Fetch MsSubTreasurys by given MsSubTreasurys id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsSubTreasury(@RequestBody IdDto id) {
		EDPMsSubTreasuryEntity entity = service.getMsSubTreasury(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new MsSubTreasurys.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsSubTreasury(@RequestBody EDPMsSubTreasuryDto dto) {
		EDPMsSubTreasuryEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsSubTreasury(entity)));
	}

	/**
	 * Update the MsSubTreasurys.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsSubTreasury(@RequestBody EDPMsSubTreasuryDto dto) {
		EDPMsSubTreasuryEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsSubTreasury(entity)));
	}

	/**
	 * Deletes the MsSubTreasurys for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteMsSubTreasury(@RequestBody StatusDto statusDto) {
		service.deleteMsSubTreasury(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the MsSubTreasurys items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsSubTreasuryDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsSubTreasurys(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPMsSubTreasuryDto> data = service.getMsSubTreasurys(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

}
