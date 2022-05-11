package gov.ifms.pvu.controller;

import com.itextpdf.text.DocumentException;
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
import gov.ifms.common.util.Utils;
import gov.ifms.pvu.common.BasePVUAttachmentController;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUSeniorScaleConverter;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.entity.PVUSeniorScaleAttEntity;
import gov.ifms.pvu.entity.PVUSeniorScaleEntity;
import gov.ifms.pvu.service.PVUSeniorScaleAttService;
import gov.ifms.pvu.service.PVUSeniorScaleService;
import gov.ifms.pvu.util.PvuConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;


/**
 * The Class PVUSeniorScaleController.
 */
@RestController
@RequestMapping(PvuConstant.URL_PVU_SENIOR_SCALE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUSeniorScaleController extends BasePVUAttachmentController<PVUSeniorScaleAttEntity, PVUSeniorScaleAttDto> {

    /**
     * The logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PVUSeniorScaleController.class.getName());


    /**
     * The service.
     */
    @Autowired
    private PVUSeniorScaleService service;

    /**
     * The converter.
     */
    @Autowired
    private PVUSeniorScaleConverter converter;

    /**
     * The converter.
     */
    @Autowired
    private PVUSeniorScaleAttService attService;

    @Override
    public BasePVUAttachmentService<PVUSeniorScaleAttEntity, PVUSeniorScaleAttDto> getAttachmentService() {
        return attService;
    }

    /**
     * Fetch PVUSeniorScales by given PVUSeniorScales id
     *
     * @param id id
     * @return dto
     */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
    public ResponseEntity<ApiResponse> getPVUSeniorScale(@RequestBody IdDto id) {
        PVUSeniorScaleEntity entity = service.getPVUSeniorScale(id.getId());
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
    }


    /**
     * Update the PVUSeniorScales
     *
     * @param dto dto
     * @return the updated entity in dto type
     */
    @Trace
    @PostMapping(URLConstant.URL_PUT_BY_ID)
    public ResponseEntity<ApiResponse> updatePVUSeniorScale(@RequestBody PVUSeniorScaleDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
                service.saveOrUpdatePVUSeniorScale(dto));
    }

    /**
     * creates a new PVUSeniorScales
     *
     * @param dto dto
     * @return newly created entity in dto type
     */
    @Trace
    @PostMapping(URLConstant.URL_POST)
    public ResponseEntity<ApiResponse> createPVUSeniorScale(@RequestBody PVUSeniorScaleDto dto) throws CustomException {
        if (dto.isSubmit()) {
            dto.validateAll();
        } else {
            dto.draftFieldValidate();
        }

        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
                service.saveOrUpdatePVUSeniorScale(dto));

    }

    /**
     * Fetch all the PVUSeniorScales items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<PVUSeniorScaleDto>
     */
    @Trace
    @PostMapping(URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getPVUSeniorScales(@RequestBody PageDetails pageDetail) {
        PagebleDTO<PVUSeniorScaleDto> data = service.getPVUSeniorScales(pageDetail);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
    }

    /**
     * Insert in itr response entity.
     *
     * @param wrapperDto the wrapper dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_ITR_INSERT + "/201")
    public ResponseEntity<ApiResponse> insertInITR(@RequestBody PvuWFWrapperDto wrapperDto) throws CustomException {
        PVUSeniorScaleDto dto = service.insertInITR(wrapperDto);
        return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()), dto);
    }

    /**
     * Use for ddo office Senior scale PVU.
     *
     * @param pageDetails page details
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.DDO_WF_LISTING)
    public ResponseEntity<ApiResponse> ddoWFListing(@RequestBody PageDetails pageDetails) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.ddoWFListing(pageDetails));
    }


    /**
     * Gets the trn edp wf.
     *
     * @param id the id
     * @return the trn edp wf
     */
    @Trace
    @PostMapping(URLConstant.URL_WF_RL_CD_SSP_TRN_ID)
    public ResponseEntity<ApiResponse> getWfRoleCodeByTrnId(@RequestBody IdDto id) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH, service.getWfRlCdBySSPTrnId(id.getId()));
    }

    /**
     * SSP :: get PVU Office details.
     *
     * @param idDto the id dto
     * @return the response entity
     */
    @Trace
    @PostMapping(PvuConstant.URL_EVENT_GET_PVU_OFFICE)
    public ResponseEntity<ApiResponse> getEmployeeSSPOfficeDetails(@RequestBody IdDto idDto) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUOfficeName(idDto));
    }

    /**
     * Gets the SSP inwards List.
     *
     * @param pageDetail the page detail
     * @return the ssp inwards
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping("/ssp-inward/" + URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getSSPInwardList(@RequestBody PageDetails pageDetail) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getSSPInwardList(pageDetail));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }

    }

    /**
     * Gets the SSP outward List.
     *
     * @param pageDetail the page detail
     * @return the out ward
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping("/ssp-outward/" + URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getSSPOutWardList(@RequestBody PageDetails pageDetail) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getSSPOutWardList(pageDetail));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }

    }

    /**
     * Gets the SSP outward List.
     *
     * @param pageDetail the page detail
     * @return the out ward
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping("/ssp-print-endorsement-list")
    public ResponseEntity<ApiResponse> getSSPPrintEndorsementList(@RequestBody PageDetails pageDetail) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getSSPPrintEndorsementList(pageDetail));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }

    }

    /**
     * Generate inward number.
     *
     * @param dto the dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_GENERATE_INWARD_NUMBER)
    public ResponseEntity<ApiResponse> generateInwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.generateInwardNumber(dto));
    }

    /**
     * Generate outward number.
     *
     * @param dto the dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_GENERATE_OUTWARD_NUMBER)
    public ResponseEntity<ApiResponse> generateOutWardNumber(@RequestBody List<IdDto> dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.generateOutWardNumber(dto));
    }

    /**
     * Submit SSP event.
     *
     * @param wrapperDto the wrapper dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_POST_INWARD_SUBMIT)
    public ResponseEntity<ApiResponse> submitSSPInward(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_EVENT_FORWARD_DISTRIBUTOR, service.submitSSPInward(wrapperDto));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
        }
    }

    /**
     * Submit SSP distributor.
     *
     * @param wrapperDto the wrapper dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_POST_DISTRIBUTOR_SUBMIT)
    public ResponseEntity<ApiResponse> submitSSPDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_EVENT_FORWARD_AUDITOR, service.submitSSPDistributor(wrapperDto));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
        }

    }

    /**
     * Submit SSP distributor.
     *
     * @param wrapperDto the wrapper dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping("/submit-outward")
    public ResponseEntity<ApiResponse> submitSSPOutWard(@RequestBody List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_OUTWARDED, service.submitSSPOutWard(wrapperDto));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
        }

    }

    /**
     * Pvu office SSP employee search.
     *
     * @param pageDetail the page detail
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_PVU_EVENT_EMPLOYEE_SEARCH)
    public ResponseEntity<ApiResponse> pvuOfficeSSPEmployeeSearch(@RequestBody PageDetails pageDetail)
            throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUOfficeSSPEmployeeSearch(pageDetail));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }

    }

    /**
     * Pvu office SSP reasons.
     *
     * @return the response entity
     */
    @Trace
    @PostMapping(PvuConstant.URL_PVU_REASONS)
    public ResponseEntity<ApiResponse> pvuOfficeSSPReasonCode() {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPvuOfficeSSPReasonCode());
    }

    /**
     * Pvu office SSP reasons.
     *
     * @return the response entity
     */
    @Trace
    @PostMapping(PvuConstant.URL_PVU_RESPONSE)
    public ResponseEntity<ApiResponse> getPVUResponse(@RequestBody IdDto dto) throws CustomException {
        if (dto.getId() == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
        }
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUResponse(dto));
    }

    /**
     * Update remarks.
     *
     * @param dto the dto
     * @return the response entity
     */
    @Trace
    @PostMapping(PvuConstant.URL_UPDATE_REMARKS)
    public ResponseEntity<ApiResponse> saveOrUpdateRemarks(@RequestBody PVUSSPRemarkRequest dto) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE, service.saveOrUpdateRemarks(dto));
    }

    /**
     * Get Return remarks.
     *
     * @param dto the dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_GET_RETURN_REMARKS)
    public ResponseEntity<ApiResponse> getReturnRemarks(@RequestBody IdDto dto) throws CustomException {
        if (Utils.isNonEmpty(dto) && Utils.isNonEmpty(dto.getId())) {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.getReturnRemarks(dto.getId()));
        }
        throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
    }

    @Trace
    @PostMapping(value = "test")
    public String test(@RequestBody IdDto dto) throws CustomException {
        service.test(dto);
        return null;
    }

    @Trace
    @PostMapping(PvuConstant.URL_PVU_GENERATE_PRINT_ORDER)
    public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PvuPrintStickerReportDto dto)
            throws CustomException, IOException, DocumentException {
        String result = service.generatePrintOrder(dto);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, result);
    }

    @Trace
    @PostMapping(URLConstant.URL_PVU_PRINTENDORSEMENT_REMARK)
    public ResponseEntity<ApiResponse> getReprintEndorsementRemarks(@RequestBody IdDto dto) throws CustomException {
        List<PrintEndorsementRemarkHistoryDto> result = service.getReprintEndorsementRemarks(dto.getId());
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, result);
    }

    @Trace
    @PostMapping(PvuConstant.URL_PVU_GENERATE_PRINT_ORDERS)
    public ResponseEntity<ApiResponse> generatePrintEndorsementList(@RequestBody List<PvuPrintStickerReportDto> dto)
            throws CustomException, IOException, DocumentException {
        String result = service.generatePrintOrders(dto);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, result);
    }

    /**
     * delete the PVUSeniorScale
     *
     * @param dto dto
     * @return the delete by id
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(URLConstant.URL_DELETE_BY_ID)
    public ResponseEntity<ApiResponse> deleteById(@RequestBody IdDto dto) throws CustomException {
        service.deleteById(dto);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
    }
    
    
    @Trace  // For 8 No.
	@PostMapping("/payfixation/" +URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)  
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody IdDto dto) throws CustomException, IOException {
		
        try {
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generatePrintEndorsement(dto));
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(),e);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
	}
    
    
    
    
    
    
    
}
