package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPTrnUpdDsgnItrEntity;

/**
 * The Interface EDPTrnUpdDsgnItrRepository.
 */
@Repository
@Transactional
public interface EDPTrnUpdDsgnItrRepository
		extends JpaRepository<EDPTrnUpdDsgnItrEntity, Long>, JpaSpecificationExecutor<EDPTrnUpdDsgnItrEntity> {

	/**
	 * Find by trn no and designation id designation id.
	 *
	 * @param trnNo the trn no
	 * @param designationId the designation id
	 * @return the list
	 */
	List<EDPTrnUpdDsgnItrEntity> findByTrnNoAndDesignationIdDesignationId(String trnNo, Long designationId);

	/**
	 * Find by trn no and designation id designation id and office id office id.
	 *
	 * @param trnNo the trn no
	 * @param designationId the designation id
	 * @param officeId the office id
	 * @return the list
	 */
	List<EDPTrnUpdDsgnItrEntity> findByTrnNoAndDesignationIdDesignationIdAndOfficeIdOfficeId(String trnNo, Long designationId,Long officeId);
}
