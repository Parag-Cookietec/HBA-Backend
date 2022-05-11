package gov.ifms.pvu.controller;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.common.BasePVUAttachmentController;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUPromotionConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUPromotionAttDto;
import gov.ifms.pvu.dto.PVUPromotionDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.request.PromotionValidationRequest;
import gov.ifms.pvu.entity.PVUPromotionAttEntity;
import gov.ifms.pvu.entity.PVUPromotionEntity;
import gov.ifms.pvu.service.PVUPromotionAttService;
import gov.ifms.pvu.service.PVUPromotionService;
import gov.ifms.pvu.util.PvuConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * The Class PVUPromotionController.
 */
@RestController
@RequestMapping(PvuConstant.URL_PVU_PROMOTION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUPromotionController extends BasePVUAttachmentController<PVUPromotionAttEntity, PVUPromotionAttDto> {

    /**
     * The logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PVUPromotionController.class.getName());

    @Autowired
    private PVUPromotionAttService promotionAttService;

    @Override
    public BasePVUAttachmentService<PVUPromotionAttEntity, PVUPromotionAttDto> getAttachmentService() {
        return promotionAttService;
    }


    /**
     * The service.
     */
    @Autowired
    private PVUPromotionService service;

    /**
     * The converter.
     */
    @Autowired
    private PVUPromotionConverter converter;

    /**
     * Fetch PVUPromotions by given PVUPromotions id
     *
     * @param id only id
     * @return dto pvu promotion
     */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
    public ResponseEntity<ApiResponse> getPVUPromotion(@RequestBody IdDto id) {
        PVUPromotionEntity entity = service.getPVUPromotion(id.getId());
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
    }

    /**
     * creates a new PVUPromotions
     *
     * @param dto dto
     * @return newly created entity in dto type
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(URLConstant.URL_POST)
    public ResponseEntity<ApiResponse> createPVUPromotion(@RequestBody PVUPromotionDto dto) throws CustomException {
        if (dto.isSubmit() && dto.getStatusId() != 327L) {
            dto.draftFieldValidate();
            this.service.setComparerDetails(dto);
            dto.validateAll();
            service.validatePromotion(new PromotionValidationRequest(dto.getEmployeeId(), dto.getEventEffectiveDate(), dto.getEmployeeClassId()));
        } else if (dto.getStatusId() == 327L) {
            throw new CustomException(HttpStatus.CONFLICT,
                    String.format(MsgConstant.PVU_PROMOTION_ALREADY_APPROVED, dto.getTrnNo()));
        } else {
            dto.draftFieldValidate();
        }

        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
                service.saveOrUpdatePVUPromotion(dto));
    }

    /**
     * Update the PVUPromotions
     *
     * @param dto dto
     * @return the updated entity in dto type
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(URLConstant.URL_PUT_BY_ID)
    public ResponseEntity<ApiResponse> updatePVUPromotion(@RequestBody PVUPromotionDto dto) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
                    service.saveOrUpdatePVUPromotion(dto));
        } catch (CustomException e) {
            LOGGER.error(e.toString(), e);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * delete the PVUPromotions
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

    /**
     * Gets all lu look up info as map.
     *
     * @return the all lu look up info as map
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_ALL_LOOKUP_INFO)
    public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
        try {
            Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
        } catch (CustomException e) {
            LOGGER.error(e.toString(), e);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
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
        PVUPromotionDto dto = service.insertInITR(wrapperDto);
        return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()), dto);
    }

    /**
     * Check eligible if exists promotion forgo.
     *
     * @param request the request
     * @return the response entity
     */
    @Trace
    @PostMapping(PvuConstant.PROMOTION_VALIDATION)
    public ResponseEntity<ApiResponse> validatePromotion(@RequestBody @Valid PromotionValidationRequest request) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.validatePromotion(request));
    }
    
    @Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)  
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody IdDto dto) throws CustomException {
		
        try {
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generatePrintEndorsement(dto));
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(),e);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
	}
}
