package gov.ifms.pvu.common;

import gov.ifms.common.attachment.dto.FileUploadResponseDto;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.util.PvuConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class BasePVUAttachmentController<E extends BasePVUAttachmentEntity, D extends BasePVUAttachmentDto> {

    private static final Logger logger = LoggerFactory.getLogger(BasePVUAttachmentController.class);

    public abstract BasePVUAttachmentService<E, D> getAttachmentService();

    @Trace
    @PostMapping(PvuConstant.FILE_UPLOAD)
    public ResponseEntity<ApiResponse> upload(@ModelAttribute final BasePVUAttachmentDtoList<D> uploadDto) throws CustomException {
        List<FileUploadResponseDto> fileUploadResponseDto;
        try {
            fileUploadResponseDto = getAttachmentService().upload(uploadDto.getObjList());
        } catch (DataIntegrityViolationException ex) {
            logger.error(ex.getMessage(), ex);
            return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
        }
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD, fileUploadResponseDto);
    }

    @Trace
    @PostMapping(PvuConstant.GET_ALL_UPLOADED_FILES)
    public ResponseEntity<ApiResponse> getAllAttachmentById(@RequestBody final IdDto idDto) throws CustomException {
        List<D> fileUploadResponseDto;
        try {
            fileUploadResponseDto = getAttachmentService().getAllAttachmentById(idDto);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_FETCH, fileUploadResponseDto);
    }

    @Trace
    @PostMapping(PvuConstant.DELETE_ATTACHMENT)
    public ResponseEntity<ApiResponse> deleteAttachmentById(@RequestBody final IdDto idDto) {
        getAttachmentService().updateStatusAsDelete(idDto);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE, null);
    }

}
