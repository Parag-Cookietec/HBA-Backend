package gov.ifms.edp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.entity.EDPAddDesAttachmentEntity;

/**
 * The Interface EDPAddDesigAttachmentRepository.
 *
 * @author Admin
 */
@Transactional
@Repository
public interface EDPAddDesigAttachmentRepository extends JpaRepository<EDPAddDesAttachmentEntity, Long>,
		JpaSpecificationExecutor<EDPAddDesAttachmentEntity>, GenericDao {

	/**
	 * Find all by designation id and active status.
	 *
	 * @param designationId the designation id
	 * @param activeStatus the active status
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	List<EDPAddDesAttachmentEntity> findAllByDesignationIdAndActiveStatus(Long designationId,int activeStatus) throws CustomException;
}
