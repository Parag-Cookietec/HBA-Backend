package gov.ifms.loc.repository;

import gov.ifms.loc.entity.LocAdvicePartHeadwisedetaisEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class LocAdvicePartHeadwisedetaisController.
 *
 * @version v 1.0
 * @created 2021/02/23 12:51:19
 */

@Repository
@Transactional
public interface LocAdvicePartHeadwisedetaisRepository extends JpaRepository<LocAdvicePartHeadwisedetaisEntity, Long>,
        JpaSpecificationExecutor<LocAdvicePartHeadwisedetaisEntity> {

	/**
	 * @param hdrId
	 * @param activeStatus
	 * @return
	 */
	@Query("select sd from LocAdvicePartHeadwisedetaisEntity sd where sd.lcAdviceHdrId=:lcAdviceHdrId and sd.activeStatus=:activeStatus")
	List<LocAdvicePartHeadwisedetaisEntity> findbyHdrIdActiveStatus(Long lcAdviceHdrId, int activeStatus);

}
