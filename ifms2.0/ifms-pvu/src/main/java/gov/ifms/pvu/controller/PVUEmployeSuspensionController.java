package gov.ifms.pvu.controller;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.BasePVUAttachmentController;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUEmployeSuspensionConverter;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.entity.PVUSuspensionAttachmentEntity;
import gov.ifms.pvu.service.PVUEmployeSuspensionService;
import gov.ifms.pvu.service.PVUSuspensionAttachmentService;
import gov.ifms.pvu.util.PvuConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
/**
 * The Class PVUEmployeSuspensionController.
 *
 * @version 1.0.
 * @created 2019/12/12 15:52:48.
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYEE_SUSPENSION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeSuspensionController extends BasePVUAttachmentController<PVUSuspensionAttachmentEntity, PVUSuspensionAttachmentDto> {

    /**
     * The service.
     */
    @Autowired
    private PVUEmployeSuspensionService service;

    /**
     * The converter.
     */
    @Autowired
    private PVUEmployeSuspensionConverter converter;

    @Autowired
    private EDPLuLookUpInfoRepository lookupinforepository;

    /**
     * The converter.
     */
    @Autowired
    private PVUSuspensionAttachmentService suspensionAttachmentService;

    @Override
    public BasePVUAttachmentService<PVUSuspensionAttachmentEntity, PVUSuspensionAttachmentDto> getAttachmentService() {
        return suspensionAttachmentService;
    }

    /**
     * Fetch PVUEmployeSuspensions by given PVUEmployeSuspensions id
     *
     * @param id
     * @return dto
     * @throws CustomException
     */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
    public ResponseEntity<ApiResponse> getPVUEmployeSuspension(@RequestBody IdDto id) throws CustomException {
        PVUEmployeSuspensionEntity entity = service.getPVUEmployeSuspension(id.getId());
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
    }

    /**
     * creates a new PVUEmployeSuspensions
     *
     * @param dto
     * @return newly created entity in dto type
     * @throws CustomException
     */
    @Trace
    @PostMapping(URLConstant.URL_POST)
    public ResponseEntity<ApiResponse> createPVUEmployeSuspension(@RequestBody PVUEmployeSuspensionDto dto)
            throws CustomException {
        PVUEmployeSuspensionEntity entity = converter.toEntity(dto);
        if(dto.getStatusId() > 0 ) {
            entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
        }
        else {
            entity.setStatus(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
        }

        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
                converter.toDTO(service.saveOrUpdatePVUEmployeSuspension(entity)));

    }


    /**
     * Update the PVUEmployeSuspensions
     *
     * @param dto
     * @return the updated entity in dto type
     * @throws CustomException
     */
    @Trace
    @PostMapping(URLConstant.URL_PUT_BY_ID)
    public ResponseEntity<ApiResponse> updatePVUEmployeSuspension(@RequestBody PVUEmployeSuspensionDto dto)
            throws CustomException {
        PVUEmployeSuspensionEntity entity = converter.toEntity(dto);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
                converter.toDTO(service.saveOrUpdatePVUEmployeSuspension(entity)));
    }

    /**
     * Fetch all the PVUEmployeSuspensions items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<PVUEmployeSuspensionDto>
     */
    @Trace
    @PostMapping(URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getPVUEmployeSuspensions(@RequestBody PageDetails pageDetail)
            throws CustomException {
        PagebleDTO<PVUEmployeSuspensionView> data = service.getPVUEmployeSuspensions(pageDetail);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
    }

    @Trace
    @PostMapping(URLConstant.URL_ALL_LOOKUP_INFO)
    public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
        Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
    }

    /*
     * Gets the all lu look up info as map.
     *
     * @return the all lu look up info as map
     *
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_ITR_SUSPESION_INSERT)
    public ResponseEntity<ApiResponse> insertInITR(@RequestBody PvuWFWrapperDto wrapperDto) throws CustomException {
        PVUEmployeSuspensionDto dto = null;
        dto = service.insertInITR(wrapperDto);
        return ResponseUtil.getResponse(HttpStatus.OK,  MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()), dto);

    }

    @Trace
    @PostMapping(URLConstant.URL_DELETE_BY_ID)
    public ResponseEntity<ApiResponse> deletePayDetails(@RequestBody IdDto id) {
        service.deletePayDetail(id.getId());
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
    }

    @Trace
    @PostMapping(URLConstant.URL_DELETE_BY_SUS_ID)
    public ResponseEntity<ApiResponse> deleteStEventsDetails(@RequestBody StatusDto statusDto) throws CustomException {
        service.deleteSusEventsDetails(statusDto.getId(), Constant.INACTIVE_STATUS);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
    }
    
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody IdDto dto)
			throws CustomException, IOException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED,
					service.generatePrintEndorsement(dto));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
	}


}
