package gov.ifms.common.attachment.service;

import java.util.List;

import gov.ifms.common.attachment.dto.AttachmentCommonDto;
import gov.ifms.common.attachment.dto.MasterAttachmentDto;
import gov.ifms.common.attachment.entity.AttachmentMasterEntity;
import gov.ifms.common.exception.CustomException;

/**
 * The Class AttachmentMasterService.
 * 
 * @version v 1.0
 * @created 2019/12/07 14:21:42
 *
 */
public interface AttachmentMasterService {
	
	/**
	 * Retrieves an AttachmentMasterEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the AttachmentMasterEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public AttachmentMasterEntity getAttachmentMaster(Long id);
	
	/**
	 * Retrieves an AttachmentMasterEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the AttachmentMasterEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public List<AttachmentMasterEntity> getAttachmentMasterByMenuId(Long id);

	/**
	 * Saves a given AttachmentMasterEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved AttachmentMasterEntity
	 */
	public AttachmentMasterEntity saveOrUpdateAttachmentMaster(AttachmentMasterEntity entity);

    List<AttachmentMasterEntity> getAttachmentMasterByMenuIdAndCategory(MasterAttachmentDto masterAttachmentDto) throws CustomException;


    List<AttachmentCommonDto> getAllAttachmentByMenuIdAndTrnIdAndCategory(MasterAttachmentDto masterAttachmentDto) throws CustomException;

    Object getAttachmentCategory(String categoryName) throws CustomException;
}
