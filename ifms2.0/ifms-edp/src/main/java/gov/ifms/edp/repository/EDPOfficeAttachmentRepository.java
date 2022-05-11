package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.entity.EDPOfficeAttachmentEntity;

/**
 * The Interface EDPOfficeAttachmentRepository.
 *
 * @author Admin
 */
@Repository
@Transactional
public interface EDPOfficeAttachmentRepository extends JpaRepository<EDPOfficeAttachmentEntity, Long>,
		JpaSpecificationExecutor<EDPOfficeAttachmentEntity>,GenericDao{

	/**
	 * Find by office id and active status.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPOfficeAttachmentEntity> findByOfficeIdAndActiveStatus(long officeId, int activeStatus)
			throws CustomException;

	/**
	 * Gets the office attachments by office id and active status and created by.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @param createdBy the created by
	 * @return the office attachments by office id and active status and created by
	 */
	public List<EDPOfficeAttachmentEntity> getOfficeAttachmentsByOfficeIdAndActiveStatus(Long officeId,Integer activeStatus);

	/**
	 * Find by file name and office id.
	 *
	 * @param fileName the file name
	 * @param officeId the office id
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPOfficeAttachmentEntity> findByFileNameAndOfficeId(String fileName,Long officeId) throws CustomException;

}
