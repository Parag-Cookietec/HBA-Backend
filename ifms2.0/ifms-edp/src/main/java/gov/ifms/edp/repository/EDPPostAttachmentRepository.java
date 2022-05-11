package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.EDPPostAttachmentDto;
import gov.ifms.edp.entity.EDPPostAttachmentEntity;

/**
 * The Interface EDPPostAttachmentRepository.
 *
 * @author Admin
 */
@Repository
@Transactional
public interface EDPPostAttachmentRepository extends JpaRepository<EDPPostAttachmentEntity, Long>,
		JpaSpecificationExecutor<EDPPostAttachmentEntity>, GenericDao {


	/**
	 * Find by post id post id and active status.
	 *
	 * @param postId the post id
	 * @param activeStatus the active status
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPPostAttachmentEntity> findByPostIdPostIdAndActiveStatus(long postId, int activeStatus) throws CustomException;

	/**
	 * Gets the attachment by post id and att type query.
	 *
	 * @param postId the post id
	 * @param attahcmentType the attahcment type
	 * @return the attachment by post id and att type query
	 */
	@Query(value = "SELECT  att.attachmentName, oa.fileName,oa.uploadedFileName,oa.postAttactmentId,oa.postId,  "
			+ "oa.createdBy,oa.createdByPost,oa.createdDate,oa.updatedBy,oa.updatedByPost,oa.updatedDate,"
			+ "  oa.versionId,oa.uploadedFilePath,oa.attachmentId FROM  "
			+ " EDPMsAttachmentEntity att LEFT OUTER JOIN 	 EDPPostAttachmentEntity oa "
			+ " ON att.attachmentId=oa.attachmentId AND oa.postId.postId = ?1 WHERE  att.attahcmentType = ?2")
	public List<EDPPostAttachmentDto> getAttachmentByPostIdAndAttTypeQuery(long postId, long attahcmentType);
}
