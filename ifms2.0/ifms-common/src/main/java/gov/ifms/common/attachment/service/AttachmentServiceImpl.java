/**
 *
 */
package gov.ifms.common.attachment.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.ifms.common.attachment.dto.AttachmentCommonDto;

import gov.ifms.common.attachment.dto.MasterAttachmentDto;
import gov.ifms.common.attachment.repository.AttachmentMasterRepository;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.common.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.attachment.dto.AttachmentDownloadDto;
import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.attachment.dto.FileUploadResponseDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.FilenetUtility;

/**
 * @author Admin
 *
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    @Autowired
    private AttachmentMasterRepository attachmentMasterRepository;

    @Autowired
    private EncryptDecryptUtil encryptDecryptUtill;

    /**
     * Upload attachment on Filenet.
     *
     * @param AttachmentMasterDto attachmentMasterDto
     * @return the uploaded file Details response
     * @throws IOException
     * @throws IllegalStateException
     */
    @Override
    public List<FileUploadResponseDto> createPostAttachment(AttachmentMasterDto attachmentMasterDto)
            throws CustomException {
        final StringBuilder uploadLocation = new StringBuilder();
        try {
            uploadLocation.append(Constant.BACK_SLASH);
            uploadLocation.append(attachmentMasterDto.getUploadDirectoryPath());
            uploadLocation.append(Constant.BACK_SLASH);
            uploadLocation.append(attachmentMasterDto.getMenuId());
            uploadLocation.append(Constant.BACK_SLASH);
            uploadLocation.append(attachmentMasterDto.getTransactionId());
            return FilenetUtility.uploadDocs(attachmentMasterDto.getAttachment(), uploadLocation.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
        }

    }

    /**
     * Upload attachment on the Drive.
     *
     * @param AttachmentMasterDto attachmentMasterDto
     * @return the uploaded file response
     */
    @Override
    public List<FileUploadResponseDto> uploadAttachment(AttachmentMasterDto attachmentMasterDto)
            throws CustomException {
        List<FileUploadResponseDto> uploadResponseDtos = new ArrayList<>();
        try {
            for (MultipartFile attachment : attachmentMasterDto.getAttachment()) {
                FileUploadResponseDto fileUploadResponseDto = new FileUploadResponseDto();
                final StringBuilder uploadedPathBuilder = new StringBuilder(Constant.UPLOAD_DIR);
                uploadedPathBuilder.append(File.separator);
                uploadedPathBuilder.append(attachmentMasterDto.getUploadDirectoryPath());
                uploadedPathBuilder.append(File.separator);
                uploadedPathBuilder.append(attachmentMasterDto.getMenuId());
                uploadedPathBuilder.append(File.separator);
                uploadedPathBuilder.append(attachmentMasterDto.getTransactionId());
                uploadedPathBuilder.append(File.separator);
                Map<String, String> uploadedFilePath = getUploadedFilePath(attachment.getOriginalFilename(),
                        uploadedPathBuilder);
                Files.createDirectories(Paths.get(uploadedFilePath.get(Constant.DIR_PATH)));
                writeFile(uploadedFilePath, attachment);
                fileUploadResponseDto.setFilename(attachment.getOriginalFilename());

                fileUploadResponseDto.setUploadDirPath(uploadedFilePath.get(Constant.FILE_PATH));
                uploadResponseDtos.add(fileUploadResponseDto);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
        }
        return uploadResponseDtos;
    }

    /**
     * Gets the uploaded file path.
     *
     * @param headerId       the header id
     * @param actualFileName the actual file name
     * @return the uploaded file path
     */
    private Map<String, String> getUploadedFilePath(final String actualFileName,
                                                    final StringBuilder uploadedPathBuilder) {
        Map<String, String> path = new HashMap<>();
        path.put(Constant.DIR_PATH, uploadedPathBuilder.toString());

        final int lastDotIndex = StringUtils.lastIndexOf(actualFileName, Constant.DOT);
        if (lastDotIndex > 0) {
            uploadedPathBuilder.append(actualFileName.substring(0, lastDotIndex));
            uploadedPathBuilder.append(Constant.FILE_NAME_SEPARATOR);
            uploadedPathBuilder.append(new Date().getTime());
            uploadedPathBuilder.append(actualFileName.substring(lastDotIndex));
            path.put(Constant.FILE_PATH, uploadedPathBuilder.toString());
        }

        return path;
    }

    /**
     * Write file.
     *
     * @param uploadedFilePath the uploaded file path
     * @param multipartFile    the multipart file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void writeFile(Map<String, String> uploadedFilePath, MultipartFile multipartFile) throws IOException {
        try (BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(new File(uploadedFilePath.get(Constant.FILE_PATH))))) {
            stream.write(multipartFile.getBytes());
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
            throw new IOException();
        }
    }

    /**
     * Download files.
     *
     * @param id the id
     * @return the resource
     * @throws CustomException the custom exception
     */
    @Override
    public Resource downloadFiles(AttachmentDownloadDto dto) throws CustomException {
        try {
            final Path filePath = Paths.get(dto.getDocumentDataKey());
            if (filePath != null) {
                final Resource resource = new UrlResource(filePath.toUri());
                if (resource.exists()) {
                    return resource;
                }
            }
        } catch (MalformedURLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.INVALID_URL_FOUND);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
        }
        return null;
    }


    /**
     * Upload Multiple attachment
     * @param dtos
     * @return
     * @throws SQLException
     */
    @Override
    public List<AttachmentCommonDto> uploadCommonAttachment(List<AttachmentCommonDto> dtos) throws SQLException {
        List<AttachmentCommonDto> returnDtos = new ArrayList<>();
        final StringBuilder uploadLocation = new StringBuilder();
        try {
            for (AttachmentCommonDto attachment : dtos) {
                uploadLocation.append(Constant.BACK_SLASH);
                uploadLocation.append(attachment.getUploadDirectoryPath());
                uploadLocation.append(Constant.BACK_SLASH);
                uploadLocation.append(attachment.getMenuId());
                uploadLocation.append(Constant.BACK_SLASH);
                uploadLocation.append(attachment.getTrnId());
                FilenetUtility.uploadSINGLEDocs(attachment.getAttachment(), uploadLocation.toString(), attachment);
                attachment.setUploadedFileSize(getFileSizeinKB(attachment.getAttachment()));
                attachment.setUploadedFileName(attachment.getAttachment().getOriginalFilename());
                returnDtos.add(attachment);
                uploadLocation.setLength(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        insertAttachment(returnDtos);
        return returnDtos;
    }

    @Override
    public List<AttachmentCommonDto> insertAttachment(List<AttachmentCommonDto> commonDtos){
        Long userId = (commonDtos.get(0).getUserId() == null) ? null : Long.parseLong(encryptDecryptUtill.decrypt(commonDtos.get(0).getUserId()));
        List<AttachmentCommonDto> returnDtos = new ArrayList<>();
        commonDtos.forEach(dto -> {
            returnDtos.add(insertSingleAttachment(dto, userId));
        });
        return returnDtos;
    }

    public static final double getFileSizeinKB(MultipartFile file) {
        BigDecimal bDecimal = new BigDecimal(file.getSize());
        return bDecimal.divide(new BigDecimal(1024L)).setScale(4, RoundingMode.FLOOR).doubleValue();
    }

    private AttachmentCommonDto insertSingleAttachment(AttachmentCommonDto dto, Long userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("IN_TRN_ID", dto.getTrnId());
        map.put("IN_MENU_ID", dto.getMenuId());
        map.put("IN_EVENT_ID", dto.getEventId());
        map.put("ATTACHMENT_TYPE_ID", dto.getAttachmentTypeId());
        map.put("FILE_NAME", dto.getFileName());
        map.put("UPLOADED_FILE_PATH", dto.getUploadDirectoryPath());
        map.put("UPLOADED_FILE_NAME", dto.getUploadedFileName());
        map.put("UPLOADED_FILE_SIZE", dto.getUploadedFileSize());
        map.put("UPLOADED_BY", userId);
        map.put("DOCUMENT_ID", dto.getDocumentId());
        map.put("CATEGORY", dto.getCategoryId());
        map.put("CREATED_BY", userId);
        map.put("CREATED_BY_POU_ID", dto.getLkPOUId());
        map.put("UPDATED_BY", userId);
        map.put("UPDATED_BY_POU_ID", dto.getLkPOUId());
        map.put("ACTIVE_STATUS", Constant.ACTIVE_STATUS);
        Long attachmentId = attachmentMasterRepository.callSPLong(Constant.WORKFLOW_SCHEMA.concat(Constant.DOT.concat(Constant.SP_INS_TRN_ATTACH)), map);
        dto.setAttachmentId(attachmentId);
        dto.setAttachment(null);
        return dto;
    }

    @Override
    @Transactional
    public boolean deleteAttachment(MasterAttachmentDto dto) throws CustomException {
        Object[] obj = this.getTableData(dto.getMenuId(), dto.getEventId());
        StringBuilder sb = new StringBuilder();
        sb.append("update ").append(obj[0].toString()).append(".").append(obj[2].toString());
        sb.append(" set active_status = 0 where TRN_ATTACH_ID= :attachmentId");
        Map<String, Object> updateAttachment = new HashMap<>();
        updateAttachment.put("attachmentId", dto.getAttachmentId());
        int i = attachmentMasterRepository.updateDeleteSQLQuery(sb.toString(), updateAttachment);
        return i > 0;
    }

    @Override
    public Object[] getTableData(Long menuId, Long eventId) throws CustomException {
        Map<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SCHEMA_NAME as c0, TRN_WF_TBL_NAME as c1, LK_WF_ATT_TBL_NAME as c2  FROM ");
        sb.append(Constant.EDP_MASTER_SCHEMA).append(".").append("LK_MENU_TBL_INFO where MENU_ID =:menuId and active_status= 1 ");
        map.put("menuId", menuId);
        if (eventId != null) {
            sb.append(" and EVENT_ID=:eventId");
            map.put("eventId", eventId);
        }
        List<Object[]> objects = attachmentMasterRepository.executeSQLQuery(sb.toString(), map);
        if(!Utils.isEmpty(objects)){
            return  objects.get(0);
        }
        throw new CustomException(ErrorResponse.MENU_ID_EMPTY);
    }

}
