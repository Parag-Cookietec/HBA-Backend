package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.entity.EDPAddDesAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentEntity;

/**
 * The Interface EDPMsDesignationAttachmentService.
 */
public interface EDPMsDesignationAttachmentService {

	/**
	 * Find update dsg attachment by id.
	 *
	 * @param attechemntId the attechemnt id
	 * @return the EDP trn upd dsgn attachment entity
	 * @throws CustomException the custom exception
	 */
	EDPTrnUpdDsgnAttachmentEntity findUpdateDsgAttachmentById(Long attechemntId) throws CustomException;

	/**
	 * Find by tedp upd dsgn id and active status.
	 *
	 * @param id the id
	 * @return the list
	 */
	List<EDPTrnUpdDsgnAttachmentEntity> findByTedpUpdDsgnIdAndActiveStatus(Long id);

	/**
	 * Creates the post attachment.
	 *
	 * @param entity the entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	List<EDPTrnUpdDsgnAttachmentEntity> createUpdDsgnAttachment(List<EDPTrnUpdDsgnAttachmentEntity> entity)
			throws CustomException;

	/**
	 * Delete upd dsgn attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	void deleteUpdDsgnAttachment(Long id) throws CustomException;

	/**
	 * Download add designation files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	ClueDto downloadAddDesignationFiles(Long id) throws CustomException;

	/**
	 * Delete add designation attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	void deleteAddDesignationAttachment(Long id) throws CustomException;

	/**
	 * Creates the add designation attachment.
	 *
	 * @param edpAddDesAttachmentEntity the edp add des attachment entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	List<EDPAddDesAttachmentEntity> createAddDesignationAttachment(
			List<EDPAddDesAttachmentEntity> edpAddDesAttachmentEntity) throws CustomException;

	/**
	 * Download upd dsgn files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	ClueDto downloadUpdDsgnFiles(Long id) throws CustomException;

	/**
	 * Gets the attachment list by designation id.
	 *
	 * @param designationId the designation id
	 * @return the attachment list by designation id
	 * @throws CustomException the custom exception
	 */
	List<EDPAddDesAttachmentEntity> getAttachmentListByDesignationId(Long designationId) throws CustomException;
}
