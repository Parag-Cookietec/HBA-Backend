package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAccountOpenReqAgItrEntity;

/**
 * The Class LocAccountOpenReqAgDtlController.
 * 
 * @version 1.0
 * @created 2021/01/01 21:17:12
 */
@Repository
@Transactional
public interface LocAccountOpenReqAgItrRepository extends JpaRepository<LocAccountOpenReqAgItrEntity, Long>,
		JpaSpecificationExecutor<LocAccountOpenReqAgItrEntity> {

}
