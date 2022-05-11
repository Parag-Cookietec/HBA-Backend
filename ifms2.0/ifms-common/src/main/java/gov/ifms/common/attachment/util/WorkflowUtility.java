package gov.ifms.common.attachment.util;

import java.util.List;
import java.util.Objects;

import gov.ifms.common.attachment.dto.AttachmentCommonDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.constant.CommonConstant;

/**
 * The WorkflowUtility class.
 */
public class WorkflowUtility {

	/**
	 * Instantiates a new Workflow utility.
	 */
	private WorkflowUtility() {
	}


	/**
	 * Validate file extension.
	 *
	 * @param list the list
	 * @return the boolean
	 */
	public static final boolean validateFileExtensionPost(AttachmentMasterDto masterDto) {
		Boolean result = Boolean.TRUE;
		if(Objects.isNull(masterDto.getMenuId()) || Objects.isNull(masterDto.getTransactionId()) || ObjectUtils.isEmpty(masterDto.getAttachment())){
			return Boolean.FALSE;
		}
		for(MultipartFile file:masterDto.getAttachment()) {
			// Get length of file in bytes
			Long filesize = masterDto.getFileSize().longValue()*1024*1024;
			long fileSizeInBytes = file.getSize();
			String[] fileNames = file.getOriginalFilename().split("\\.");
			if (!masterDto.getFormat().contains(fileNames[fileNames.length - 1])
					|| fileSizeInBytes >= filesize) {
				result = Boolean.FALSE;
				break;
			}
		}
		return result;
	}

	public static boolean validateFileMultipleExtensionPost(List<AttachmentCommonDto> attachmentCommonDtoList) throws CustomException {for (AttachmentCommonDto attachmentCommonDto : attachmentCommonDtoList) {
        if (Objects.isNull(attachmentCommonDto.getMenuId()) || Objects.isNull(attachmentCommonDto.getTrnId())
                || ObjectUtils.isEmpty(attachmentCommonDto.getAttachment())) {
            throw new CustomException(ErrorResponse.MENU_ID_EMPTY);
        }
        if (StringUtils.isEmpty(attachmentCommonDto.getFormat())) {
            throw new CustomException(ErrorResponse.VALIDATIONS_FAILED);
        }
        Long filesize = attachmentCommonDto.getFileSize().longValue() * 1024 * 1024;
        long fileSizeInBytes = attachmentCommonDto.getAttachment().getSize();
        String[] fileNames = attachmentCommonDto.getAttachment().getOriginalFilename().split("\\.");



        String ext = fileNames[fileNames.length - 1].toLowerCase();
        if (ext.contains(CommonConstant.JPG)) {
            ext = CommonConstant.JPEG;
        }
        if (!attachmentCommonDto.getFormat().toLowerCase().contains(fileNames[fileNames.length - 1].toLowerCase())
                && !attachmentCommonDto.getFormat().toLowerCase().contains(ext)
                || fileSizeInBytes >= filesize) {
            return Boolean.FALSE;
        }
    }
     return Boolean.TRUE;}
}
