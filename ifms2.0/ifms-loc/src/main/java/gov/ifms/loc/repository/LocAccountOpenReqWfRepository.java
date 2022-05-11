package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAccountOpenReqWfEntity;


/**
 * The Class BudgetSubHeadWrkflwController.
 * 
 * @version 1.0
 * @created 2020/09/09 09:21:24
 */
@Repository
@Transactional
public interface LocAccountOpenReqWfRepository
		extends JpaRepository<LocAccountOpenReqWfEntity, Long>, JpaSpecificationExecutor<LocAccountOpenReqWfEntity> {

	/**
	 * Find by trn id lc open req hdr id and active status.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 * @param activeStatus the active status
	 * @return the loc account open req wf entity
	 */
	LocAccountOpenReqWfEntity findByTrnIdLcOpenReqHdrIdAndActiveStatus(Long lcOpenReqHdrId, int activeStatus);

}
