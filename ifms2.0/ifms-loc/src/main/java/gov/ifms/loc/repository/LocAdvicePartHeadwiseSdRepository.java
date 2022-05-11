package gov.ifms.loc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAdvicePartHeadwiseSdEntity;

/**
 * The Class LocAdvicePartHeadwisedetaisController.
 *
 * @version v 1.0
 * @created 2021/02/23 12:51:19
 */

@Repository
@Transactional
public interface LocAdvicePartHeadwiseSdRepository extends JpaRepository<LocAdvicePartHeadwiseSdEntity, Long>,
		JpaSpecificationExecutor<LocAdvicePartHeadwiseSdEntity> {

	/**
	 * @param hdrId
	 * @param activeStatus
	 * @return
	 */
	@Query("select sd from LocAdvicePartHeadwiseSdEntity sd where sd.lcAdviceHdrId=:lcAdviceHdrId and sd.activeStatus=:activeStatus")
	List<LocAdvicePartHeadwiseSdEntity> findbyHdrIdActiveStatus(Long lcAdviceHdrId, int activeStatus);

}
