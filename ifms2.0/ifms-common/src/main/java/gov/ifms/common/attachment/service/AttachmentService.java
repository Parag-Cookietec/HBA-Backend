/**
 * 
 */
package gov.ifms.common.attachment.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import gov.ifms.common.attachment.dto.AttachmentCommonDto;
import gov.ifms.common.attachment.dto.MasterAttachmentDto;
import org.springframework.core.io.Resource;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.attachment.dto.AttachmentDownloadDto;
import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.attachment.dto.FileUploadResponseDto;

/**
 * The Class AttachmentService.
 * 
 * @version 1.0
 * @created 2019/12/05 10:59:32
 *
 */
/**
 * @author Admin
 *
 */
public interface AttachmentService {
	
	
	/**
	 * Create attachment.
	 *
	 * @throws CustomException the custom exception
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	List<FileUploadResponseDto> createPostAttachment(AttachmentMasterDto attachmentMasterDto)throws CustomException;
 
    List<FileUploadResponseDto> uploadAttachment(AttachmentMasterDto attachmentMasterDto) throws CustomException;

    Resource downloadFiles(AttachmentDownloadDto downloadDto) throws CustomException;

	List<AttachmentCommonDto> insertAttachment(List<AttachmentCommonDto> commonDtos) throws SQLException;

	List<AttachmentCommonDto> uploadCommonAttachment(List<AttachmentCommonDto> attachmentCommonDtoList) throws CustomException, SQLException;

    boolean deleteAttachment(MasterAttachmentDto masterAttachmentDto) throws CustomException;

	Object[] getTableData(Long menuId, Long eventId) throws CustomException;
}
