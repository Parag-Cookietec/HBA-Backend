package gov.ifms.pvu.controller;


import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVURopPrintEndorsementConverter;
import gov.ifms.pvu.dto.AnnexureDto;
import gov.ifms.pvu.dto.PVUEmployeDetailsDto;
import gov.ifms.pvu.dto.PVURopPrintEndorsementDto;
import gov.ifms.pvu.dto.PVURopPrintEndorsementView;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PrintPdfResponseDto;
import gov.ifms.pvu.dto.PrintStickerReportDto;
import gov.ifms.pvu.entity.PVURopPrintEndorsementEntity;
import gov.ifms.pvu.service.PVURopPrintEndorsementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The Class PVURopPrintEndorsementController.
 * 
 * @version v 1.0.
 * @created 2020/04/06 16:00:01.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_ROPPRINTENDORSEMENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVURopPrintEndorsementController {

	/** The service. */
	@Autowired
	private PVURopPrintEndorsementService service;

	/** The converter. */
	@Autowired
	private PVURopPrintEndorsementConverter converter;

	/**
	 * Fetch RopPrintEndorsements by given RopPrintEndorsements id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getRopPrintEndorsement(@RequestBody IdDto id) {
		PVURopPrintEndorsementEntity entity = service.getRopPrintEndorsement(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new RopPrintEndorsements
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createRopPrintEndorsement(@RequestBody PVURopPrintEndorsementDto dto) {
		PVURopPrintEndorsementEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateRopPrintEndorsement(entity)));
	}

	/**
	 * Update the RopPrintEndorsements
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateRopPrintEndorsement(@RequestBody PVURopPrintEndorsementDto dto) {
		PVURopPrintEndorsementEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateRopPrintEndorsement(entity)));
	}

	/**
	 * Deletes the RopPrintEndorsements for the given id
	 * 
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getRopPrintEndorsements(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVURopPrintEndorsementView> data = service.getRopPrintEndorsements(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PE_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getPELuLookUpDetails() throws CustomException {
		PVUEmployeDetailsDto lstLuLookUp = service.getPELuLookUpDetails();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}
	
	/**
	 * Submit print endorsement.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_ROP_SUMIT_PRINTENDORSEMENT)
	public ResponseEntity<ApiResponse> submitPrintEndorsement(@RequestBody PrintStickerReportDto dto) throws CustomException {
		PVURopPrintEndorsementDto result = service.submitPrintEndorsement(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, result);
	}

	/**
	 * Generate print endorsement.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_ROP_GENERATE_PRINTENDORSEMENT)
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PrintStickerReportDto dto) throws CustomException {
		String result = service.generatePrintEndorsement(dto);
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.IFMS_MSG_SUBMITTED , result);
	}
	
	/**
	 * Generate Annexure.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_ROP_GENERATE_ANNEXURE)
	public ResponseEntity<ApiResponse> generateAnnexure(@RequestBody AnnexureDto dto) throws CustomException {
		PrintPdfResponseDto dto2 = new PrintPdfResponseDto();
		String result = service.generateAnnexure(dto);
		if(result!=null) {
			dto2.setResult(result);
		}
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.IFMS_MSG_SUBMITTED , result);
	}


	@Trace
	@PostMapping(URLConstant.URL_PVU_PRINTENDORSEMENT_REMARK)
	public ResponseEntity<ApiResponse> getReprintEndorsementRemarks(@RequestBody IdDto dto) throws CustomException {
		List<PrintEndorsementRemarkHistoryDto> result = service.getRopPrintEndorsementHistory(dto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.IFMS_MSG_FETCH_LIST,result);
	}
	
	@Trace
	@PostMapping(URLConstant.URL_PVU_ROP_GENERATE_PRINTENDORSEMENT_LIST)
	public PrintPdfResponseDto generatePrintEndorsementList(@RequestBody List<PrintStickerReportDto> dto) throws CustomException  {
		PrintPdfResponseDto dto2 = new PrintPdfResponseDto();
		String result = service.generatePrintEndorsementList(dto);
		if(result!=null) {
			dto2.setResult(result);
		}
		return dto2;
	}


}
