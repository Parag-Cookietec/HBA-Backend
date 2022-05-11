package gov.ifms.common.attachment.repository;

import gov.ifms.common.dao.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.attachment.entity.AttachmentMasterEntity;

import java.util.List;

/**
 * The Class AttachmentMasterRepository.
 * 
 * @version v 1.0
 * @created 2019/12/07 14:21:42
 */

@Repository
@Transactional
public interface AttachmentMasterRepository extends JpaRepository<AttachmentMasterEntity,Long> , JpaSpecificationExecutor<AttachmentMasterEntity> , GenericDao {
	
	List<AttachmentMasterEntity> findByMenuId(Long menuId);

	List<AttachmentMasterEntity> findByMenuIdAndAttCtegryIdAndActiveStatus(Long menuId , Long categoryId , int activeStatus);
}
