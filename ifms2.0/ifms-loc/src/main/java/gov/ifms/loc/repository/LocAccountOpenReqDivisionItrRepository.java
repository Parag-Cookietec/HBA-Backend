package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAccountOpenReqDivisionItrEntity;

/**
 * The Class LocAccountOpenReqDivisionItrController.
 * 
 * @version 1.0
 * @created 2021/01/01 20:37:23
 */
@Repository
@Transactional
public interface LocAccountOpenReqDivisionItrRepository extends JpaRepository<LocAccountOpenReqDivisionItrEntity, Long>,
		JpaSpecificationExecutor<LocAccountOpenReqDivisionItrEntity> {

}
