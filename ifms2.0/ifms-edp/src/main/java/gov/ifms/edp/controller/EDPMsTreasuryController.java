package gov.ifms.edp.controller;

import java.text.MessageFormat;
import java.util.List;

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
import gov.ifms.edp.converter.EDPMsTreasuryConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsTreasuryDto;
import gov.ifms.edp.entity.EDPMsTreasuryEntity;
import gov.ifms.edp.service.EDPMsTreasuryService;

/**
 * The Class EDPMsTreasuryController.
 * 
 * @version 1.0.
 * @created 2019/12/11 14:53:04.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MSTREASURY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsTreasuryController {

	/** The service. */
	@Autowired
	private EDPMsTreasuryService service;

	/** The converter. */
	@Autowired
	private EDPMsTreasuryConverter converter;

	/**
	 * Fetch MsTreasurys by given MsTreasurys id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsTreasury(@RequestBody IdDto id) {
		EDPMsTreasuryEntity entity = service.getMsTreasury(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new MsTreasurys.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsTreasury(@RequestBody EDPMsTreasuryDto dto) {
		EDPMsTreasuryEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsTreasury(entity)));
	}

	/**
	 * Update the MsTreasurys.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsTreasury(@RequestBody EDPMsTreasuryDto dto) {
		EDPMsTreasuryEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsTreasury(entity)));
	}

	/**
	 * Deletes the MsTreasurys for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteMsTreasury(@RequestBody StatusDto statusDto) {
		service.deleteMsTreasury(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the MsTreasurys items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsTreasuryDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsTreasurys(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPMsTreasuryDto> data = service.getMsTreasurys(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Fetch MsTreasurys by given MsTreasurys id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_TREASURY_BY_DIST_ID)
	public ResponseEntity<ApiResponse> getMsTreasuryByDistId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.getMsTreasurysByDistrictId(id.getId()));
	}

	/**
	 * Fetch MsTreasurys by given district id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_CHECK_TREASURY_BY_DIST_ID)
	public ResponseEntity<ApiResponse> checkToNameByDistrictId(@RequestBody ClueDto clueDto) {
		List<EDPMsTreasuryEntity> entities = service.checkToNameByDistrictId(clueDto);
		if (!entities.isEmpty())
			return ResponseUtil.getResponse(HttpStatus.OK,
					MessageFormat.format(MsgConstant.EDP_TO_OFFICE_ALREADY_EXISTS_CNO, clueDto.getOfficeName()), Boolean.TRUE);
		return ResponseUtil.getResponse(HttpStatus.OK, null, null);
	}

}
