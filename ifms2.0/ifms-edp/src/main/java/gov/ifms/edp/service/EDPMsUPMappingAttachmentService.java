package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsAttEntity;
	
/**
 * The Interface EDPMsUPMappingAttachmentService.
 */
public interface EDPMsUPMappingAttachmentService {

	/**
	 * Find attachment by attachment type.
	 *
	 * @param attechemntId the attechemnt id
	 * @return the EDP trn upd dsgn attachment entity
	 * @throws CustomException the custom exception
	 */
	List<EDPUsrPoTrnsAttEntity> findAttachmentByAttachmentType(Long attechemntId,Long tedpUptId) throws CustomException;

	/**
	 * Find attachment by user post transfer id.
	 *
	 * @param id the id
	 * @return the list
	 */
	List<EDPUsrPoTrnsAttEntity> findAttachmentByUserPostTransferId(Long id);

	/**
	 * Creates the UP mapping attachment.
	 *
	 * @param entity the entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	List<EDPUsrPoTrnsAttEntity> createUPMappingAttachment(List<EDPUsrPoTrnsAttEntity> entity)
			throws CustomException;

	/**
	 * Delete UP mapping attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	void deleteUPMappingAttachment(Long id) throws CustomException;
	
	/**
	 * Downloadcreate UP mapping attachment files.
	 *
	 * @param id the id
	 * @return the clue dto
	 * @throws CustomException the custom exception
	 */
	ClueDto downloadcreateUPMappingAttachmentFiles(Long id) throws CustomException;

	/**
	 * Gets the all attechments for post transfer.
	 *
	 * @return the all attechments for post transfer
	 */
	List<EDPMsAttachmentEntity> getAllAttechmentsForPostTransfer();


}
