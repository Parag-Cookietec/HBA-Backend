package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.dto.EDPTrnUserMpAttDto;
import gov.ifms.edp.entity.EDPTrnUserMpAttEntity;

/**
 * The Interface EDPTrnUserMpAttRepository.
 */
@Repository
@Transactional
public interface EDPTrnUserMpAttRepository extends JpaRepository<EDPTrnUserMpAttEntity, Long>, JpaSpecificationExecutor<EDPTrnUserMpAttEntity> {

	/**
	 * Find by user rg map id and active status.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPTrnUserMpAttEntity> findByUserRgMapIdTusrRgMapIdAndActiveStatus(Long id, int activeStatus);

	/**
	 * Gets the attachment by user role map id and att type query.
	 *
	 * @param userRoleMapId the user role map id
	 * @param attahcmentType the attahcment type
	 * @return the attachment by user role map id and att type query
	 */
	@Query(value = "SELECT att.attachmentName, oa.fileName, oa.uploadFileName,"
			+ " oa.createdBy, oa.createdByPost, oa.createdDate, oa.updatedBy, oa.updatedByPost, oa.updatedDate,"
			+ " oa.versionId, oa.uploadFilePath, oa.attachmentId FROM"
			+ " EDPMsAttachmentEntity att LEFT OUTER JOIN EDPTrnUserMpAttEntity oa "
			+ " ON att.attachmentId=oa.attachmentId AND oa.rolePrmID.rolePrmId = ?1 WHERE att.attahcmentType = ?2")
	public List<EDPTrnUserMpAttDto> getAttachmentByUserRoleMapIdAndAttTypeQuery(Long userRoleMapId, Long attahcmentType);
	
	/**
	 * Gets the by user rg map id.
	 *
	 * @param userRgMapId the user rg map id
	 * @return the by user rg map id
	 */
	public List<EDPTrnUserMpAttEntity> getByUserRgMapId(Long userRgMapId);

}
