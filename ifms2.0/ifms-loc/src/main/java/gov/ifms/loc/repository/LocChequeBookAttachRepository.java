package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocChequeBookAttachEntity;

/**
 * The Class LOCChequeBookAttachController.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:08:08
 */
@Repository
@Transactional
public interface LocChequeBookAttachRepository
		extends JpaRepository<LocChequeBookAttachEntity, Long>, JpaSpecificationExecutor<LocChequeBookAttachEntity> {

}
