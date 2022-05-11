package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPTrnUserMpAttItrDto;
import gov.ifms.edp.entity.EDPTrnUserMpAttItrEntity;

/**
 * The Interface EDPUserRoleMappingAttachmentItrService.
 */
public interface EDPUserRoleMappingAttachmentItrService {
	/**
	 * Retrieves an EDPPostAttachmentItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPPostAttachmentItrEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPTrnUserMpAttItrEntity getUserRoleMappingAttachmentItr(Long id);

	/**
	 * Saves a given EDPPostAttachmentItrEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPPostAttachmentItrEntity
	 */
	public EDPTrnUserMpAttItrEntity saveOrUpdateUserRoleMappingAttachmentItr(EDPTrnUserMpAttItrEntity entity);

	/**
	 * Saves all given EDPPostAttachmentItrEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteUserRoleMappingAttachmentItr(long id,int isDelete);
	
	/**
	 * Fetch all the EDPPostAttachmentItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPPostAttachmentItrDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPTrnUserMpAttItrDto> getUserRoleMappingAttachmentItrs(PageDetails pageDetail) throws CustomException;
}
