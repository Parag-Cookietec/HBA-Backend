package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocChequeBookWfMoveEntity;

/**
 * The Interface LocChequeBookWfMoveRepository.
 */
@Repository
@Transactional
public interface LocChequeBookWfMoveRepository
		extends JpaRepository<LocChequeBookWfMoveEntity, Long>, JpaSpecificationExecutor<LocChequeBookWfMoveEntity> {

}
