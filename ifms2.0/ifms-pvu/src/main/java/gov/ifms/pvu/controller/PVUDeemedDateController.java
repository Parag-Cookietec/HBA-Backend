package gov.ifms.pvu.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.common.BasePVUAttachmentController;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUDeemedDateConverter;
import gov.ifms.pvu.dto.PVUDeemedDateAttDto;
import gov.ifms.pvu.dto.PVUDeemedDateDto;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUDeemedDateAttEntity;
import gov.ifms.pvu.entity.PVUDeemedDateEntity;
import gov.ifms.pvu.service.PVUDeemedDateAttService;
import gov.ifms.pvu.service.PVUDeemedDateService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUDeemedDateController.
 */
@RestController
@RequestMapping(PvuConstant.URL_PVU_DEEMED_DATE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUDeemedDateController extends BasePVUAttachmentController<PVUDeemedDateAttEntity, PVUDeemedDateAttDto> {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PVUDeemedDateController.class.getName());

	/**
	 * The service.
	 */
	@Autowired
	private PVUDeemedDateService service;

	/**
	 * The converter.
	 */
	@Autowired
	private PVUDeemedDateConverter converter;

	@Autowired
	private PVUDeemedDateAttService pvuDeemedDateAttService;

	@Override
	public BasePVUAttachmentService<PVUDeemedDateAttEntity, PVUDeemedDateAttDto> getAttachmentService() {
		return pvuDeemedDateAttService;
	}

	/**
	 * Fetch PVUDeemedDates by given PVUDeemedDates id
	 *
	 * @param id id dto
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getPVUDeemedDate(@RequestBody IdDto id) {
		PVUDeemedDateEntity entity = service.getPVUDeemedDate(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new PVUDeemedDates
	 *
	 * @param dto id
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createPVUDeemedDate(@RequestBody PVUDeemedDateDto dto) throws CustomException {
		if (dto.getFormAction() == Status.DRAFT) {
			dto.draftFieldValidate();
		}
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdatePVUDeemedDate(dto));
	}

	/**
	 * Update the PVUDeemedDates
	 *
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updatePVUDeemedDate(@RequestBody PVUDeemedDateDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				service.saveOrUpdatePVUDeemedDate(dto));
	}

	/**
	 * Fetch all the PVUDeemedDates items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUDeemedDateDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getPVUDeemedDates(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUDeemedDateDto> data = service.getPVUDeemedDates(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/*
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 *
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_ALL_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	/**
	 * @param pvuWFWrapperDto
	 * @return
	 * @throws CustomException
	 */

	@Trace
	@PostMapping(PvuConstant.URL_ITR_INSERT + "/201")
	public ResponseEntity<ApiResponse> insertDeemedItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()),
					service.insertDeemedItr(pvuWFWrapperDto));
		} catch (CustomException e) {

			throw new CustomException(e.getErrorCode(), e.getErrorMsg());
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Trace // Delete from DDO Listing API
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteDeemeddateEventById(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE,
				service.deleteDeemedDateEventById(idDto));
	}


    /**
     * Generate Print Endorsement
     *
     * @return the response entity
     * @throws CustomException the custom exception
     * @throws IOException
     */
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody IdDto dto) throws CustomException, IOException {
        try {
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generatePrintEndorsement(dto));
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(),e);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_COMPARISION_REPORT)
	public ResponseEntity<ApiResponse> generateComparisionReport(@RequestBody IdDto dto) throws CustomException, IOException {
        try {
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generateComparisionReport(dto));
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(),e);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
	}

}
