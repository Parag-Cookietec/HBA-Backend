package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAdviceHeadwiseDetailEntity;


/**
 * The Class locLocAdviceHeadwiseDetailController.
 * 
 * @version v 1.0
 * @created 2021/02/23 12:29:53
 */

@Repository
@Transactional
public interface LocAdviceHeadwiseDetailRepository extends JpaRepository<LocAdviceHeadwiseDetailEntity, Long>,
		JpaSpecificationExecutor<LocAdviceHeadwiseDetailEntity> {

	/**
	 * Find by active status and id.
	 *
	 * @param activeStatus the active status
	 * @param Id the id
	 * @return the loc advice headwise detail entity
	 */
	LocAdviceHeadwiseDetailEntity findByActiveStatusAndId(int activeStatus, Long Id);

	/**
	 * Find by active status and lc advice id.
	 *
	 * @param activeStatus the active status
	 * @param hdrId the hdr id
	 * @return the list
	 */
	List<LocAdviceHeadwiseDetailEntity> findByActiveStatusAndLcAdvice(int activeStatus, Long hdrId);


}
