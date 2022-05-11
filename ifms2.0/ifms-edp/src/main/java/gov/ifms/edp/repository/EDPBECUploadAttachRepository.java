package gov.ifms.edp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPBECUploadAttachEntity;

@Repository
@Transactional
public interface EDPBECUploadAttachRepository extends BaseEDPAttachmentRepository<EDPBECUploadAttachEntity> {

	/**
	 * Find by trn id and active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the list
	 */
	public EDPBECUploadAttachEntity findByTrnIdAndActiveStatus(Long id, int activeStatus);

}
