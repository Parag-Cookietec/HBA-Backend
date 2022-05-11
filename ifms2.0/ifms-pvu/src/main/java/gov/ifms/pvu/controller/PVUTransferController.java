package gov.ifms.pvu.controller;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
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
import gov.ifms.pvu.converter.PVUTransferConverter;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.entity.PVUTransferEntity;
import gov.ifms.pvu.service.PVUTransferService;
import gov.ifms.pvu.util.PvuConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;


/**
 * The Class PVUTransferController.
 *
 * @version v 1.0.
 * @created 2019/12/21 22:53:07.
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_TRANSFER)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUTransferController {

    /**
     * The service.
     */
    @Autowired
    private PVUTransferService service;

    /**
     * The  converter.
     */
    @Autowired
    private PVUTransferConverter converter;

    /**
     * Fetch Transfers by given Transfers id .
     *
     * @param id the id
     * @return dto
     */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
    public ResponseEntity<ApiResponse> getTransfer(@RequestBody IdDto id) {
        PVUTransferEntity entity = service.getTransferById(id.getId());
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
    }


    /**
     * creates a new Transfers.
     *
     * @param dto the dto
     * @return newly created entity in dto type
     */
    @Trace
    @PostMapping(URLConstant.URL_POST)
    public ResponseEntity<ApiResponse> createTransfer(@RequestBody PVUTransferDto dto) throws CustomException {
        if (dto.getFormAction() == Status.SUBMITTED) {
            dto.validateAll();
        }
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED,
                service.saveOrUpdateTransfer(dto));
    }

    /**
     * Update the Transfers.
     *
     * @param dto the dto
     * @return the updated entity in dto type
     */
    @Trace
    @PostMapping(URLConstant.URL_PUT_BY_ID)
    public ResponseEntity<ApiResponse> updateTransfer(@RequestBody PVUTransferDto dto) throws CustomException {
           return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
                service.saveOrUpdateTransfer(dto));
    }

    @Trace
    @PostMapping(PvuConstant.URL_JOINING_TRANSFER_LIST)
    public ResponseEntity<ApiResponse> getJoiningTransferList(@RequestBody PageDetails pageDetail) throws CustomException {
        PagebleDTO<PVUTransferEmployeeView> data = service.getJoiningTransferList(pageDetail);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
    }

    @Trace
    @PostMapping(PvuConstant.URL_TRANSFER_LIST)
    public ResponseEntity<ApiResponse> getTransferList(@RequestBody PageDetails pageDetail) throws CustomException {
        PagebleDTO<PVUTransferEmployeeView> data = service.getTransferList(pageDetail);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
    }

    @Trace
    @PostMapping(URLConstant.URL_ALL_LOOKUP_INFO)
    public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
        Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
    }

    @Trace
    @PostMapping(URLConstant.URL_GET_OFFICE_BY_DISTRICT_ID)
    public ResponseEntity<ApiResponse> getOfficeByDistrict(@RequestBody IdDto id) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getOfficeByDistrict(id.getId()));
    }

    /**
     * Gets the employe details.
     *
     * @return the employe details
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(URLConstant.URL_LOOKUP_DETAILS)
    public ResponseEntity<ApiResponse> getLookupDetails() throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getLookupDetails());
        } catch (DataIntegrityViolationException ex) {
            return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
        } catch (Exception exception) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
        }
    }
    @Trace
    @PostMapping(PvuConstant.URL_ITR_INSERT + "/201")
    public ResponseEntity<ApiResponse> insertInITR(@RequestBody PvuWFWrapperDto wrapperDto) throws CustomException {
        try {
            PVUTransferDto dto = service.insertInITR(wrapperDto);
            return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()), dto);
        } catch (CustomException e) {
            throw new CustomException(e.getErrorCode(), e.getMessage());
        }
    }

    @Trace
    @PostMapping(URLConstant.URL_DELETE_BY_ID)
    public ResponseEntity<ApiResponse> deleteByTransferId(@RequestBody StatusDto statusDto) throws CustomException {
        service.deleteTransferById(statusDto.getId(), Constant.INACTIVE_STATUS);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
    }
}
