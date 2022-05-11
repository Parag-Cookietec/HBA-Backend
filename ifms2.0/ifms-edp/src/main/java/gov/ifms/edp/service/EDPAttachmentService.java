package gov.ifms.edp.service;

import java.io.IOException;
import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsAttachmentDto;
import gov.ifms.edp.dto.EDPOfficeAttachmentDto;
import gov.ifms.edp.dto.EDPPostAttachmentDto;
import gov.ifms.edp.dto.EDPTrnUserMpAttDto;
import gov.ifms.edp.entity.EDPOfficeAttachmentEntity;
import gov.ifms.edp.entity.EDPPostAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUserMpAttEntity;

/**
 * The Interface EDPAttachmentService.
 */
public interface EDPAttachmentService {

	/**
	 * Createoffice attachment.
	 *
	 * @param ofcAttachmentEntity the ofc attachment entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPOfficeAttachmentEntity> createofficeAttachment(List<EDPOfficeAttachmentEntity> ofcAttachmentEntity)
			throws CustomException;

	/**
	 * Find attachment by id.
	 *
	 * @param id the id
	 * @return the EDP office attachment entity
	 * @throws CustomException the custom exception
	 */
	public EDPOfficeAttachmentEntity findAttachmentById(Long id) throws CustomException;

	/**
	 * Find by office id and active status.
	 *
	 * @param officeId the office id
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPOfficeAttachmentEntity> findByOfficeIdAndActiveStatus(Long officeId) throws CustomException;

	/**
	 * Delete sc attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	public void deleteOfficeAttachment(Long id) throws CustomException;

	/**
	 * Download files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	public ClueDto downloadFiles(Long id) throws CustomException;

	/**
	 * Gets the attachment by ofc id and att type.
	 *
	 * @param officeId       the office id
	 * @param attachmentType the attachment type
	 * @return the attachment by ofc id and att type
	 * @throws CustomException the custom exception
	 */
	public List<Object[]> getAttachmentByOfcIdAndAttType(long officeId,String attchTblName)
			throws CustomException;

	/**
	 * Createoffice attachment.
	 *
	 * @param postAttachmentEntity the post attachment entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPPostAttachmentEntity> createPostAttachment(List<EDPPostAttachmentEntity> postAttachmentEntity)
			throws CustomException;

	/**
	 * Find attachment by id.
	 *
	 * @param id the id
	 * @return the EDP office attachment entity
	 * @throws CustomException the custom exception
	 */
	public EDPPostAttachmentEntity findPostAttachmentById(Long id) throws CustomException;

	/**
	 * Find by office id and active status.
	 *
	 * @param officeId the office id
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPPostAttachmentEntity> findByPostIdAndActiveStatus(Long officeId) throws CustomException;

	/**
	 * Delete sc attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	public void deletePostAttachment(Long id) throws CustomException;

	/**
	 * Download files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	public ClueDto downloadPostFiles(Long id) throws CustomException;

	/**
	 * Gets the attachment by post id and att type.
	 *
	 * @param postId         the post id
	 * @param attachmentType the attachment type
	 * @return the attachment by post id and att type
	 * @throws CustomException the custom exception
	 */
	public List<EDPPostAttachmentDto> getAttachmentByPostIdAndAttType(long postId, long attachmentType)
			throws CustomException;
	
	/**
	 * Gets the attachment by post id and att type.
	 *
	 * @param attachmentType the attachment type
	 * @return the attachment by post id and att type
	 * @throws CustomException the custom exception
	 */
	public List<EDPMsAttachmentDto> getAttachmentByAttType(List<ClueDto> attachmentType) throws CustomException;

	/**
	 * Find by user rg map id and active status.
	 *
	 * @param id the id
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPTrnUserMpAttEntity> findByUserRgMapIdAndActiveStatus(Long id) throws CustomException;

	/**
	 * Creates the user role map attachment.
	 *
	 * @param entity the entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPTrnUserMpAttEntity> createUserRoleMapAttachment(List<EDPTrnUserMpAttEntity> entity)
			throws CustomException;
	
	/**
	 * Delete user role map attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	public void deleteUserRoleMapAttachment(Long id) throws CustomException;
	
	
	/**
	 * Download user role map files.
	 *
	 * @param id the id
	 * @return the clue dto
	 * @throws CustomException the custom exception
	 */
	public ClueDto downloadUserRoleMapFiles(Long id) throws CustomException;
	
	/**
	 * Gets the attachment by user role map id and att type.
	 *
	 * @param postId the post id
	 * @param attachmentType the attachment type
	 * @return the attachment by user role map id and att type
	 * @throws CustomException the custom exception
	 */
	public List<EDPTrnUserMpAttDto> getAttachmentByUserRoleMapIdAndAttType(Long postId, Long attachmentType)
			throws CustomException;
	
	public List<EDPMsAttachmentDto> getAttachmentByAttTypeRightsMapping(List<String> attachmentType) throws CustomException;

	/** Upload update office attachment 
	 * 
	 * @throws IOException
	 */
	public List<EDPOfficeAttachmentEntity> uploadOfficeAttach(List<EDPOfficeAttachmentDto> attachments) throws IOException;

	/**
	 * Get Office Attachment
	 * 
	 * @param officeId
	 * @return list
	 * @throws CustomException 
	 */
	public List<Object[]> getOfficeAttachment(Long officeId) throws CustomException;
}
