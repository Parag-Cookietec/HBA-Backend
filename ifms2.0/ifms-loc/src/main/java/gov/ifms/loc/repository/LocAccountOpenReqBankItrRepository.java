package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAccountOpenReqBankItrEntity;

/**
 * The Class LocAccountOpenReqBankSdController.
 * 
 * @version 1.0
 * @created 2021/01/01 16:35:39
 */
@Repository
@Transactional
public interface LocAccountOpenReqBankItrRepository extends JpaRepository<LocAccountOpenReqBankItrEntity, Long>,
		JpaSpecificationExecutor<LocAccountOpenReqBankItrEntity> {

}
