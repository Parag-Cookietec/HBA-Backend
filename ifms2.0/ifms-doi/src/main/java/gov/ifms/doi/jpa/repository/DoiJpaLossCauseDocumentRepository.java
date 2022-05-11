package gov.ifms.doi.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.jpa.entity.DoiJpaLossCauseDocumentEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional
public interface DoiJpaLossCauseDocumentRepository extends JpaRepository<DoiJpaLossCauseDocumentEntity, Long>, JpaSpecificationExecutor<DoiJpaLossCauseDocumentEntity>{

	@Query("select entity from DoiJpaLossCauseDocumentEntity entity where entity.activeStatus = 1")
	List<DoiJpaLossCauseDocumentEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update DoiJpaLossCauseDocumentEntity entity SET entity.activeStatus = 0 where entity.id = :lossCauseDocID")
	void softDeleteById(@Param("lossCauseDocID") Long lossCauseDocID);
	
	@Query("select entity from DoiJpaLossCauseDocumentEntity entity where entity.activeStatus = 1 and entity.causeOfLoss = :causeOfLoss")
	List<DoiJpaLossCauseDocumentEntity> findAllActiveByCauseTypeId(@Param("causeOfLoss") Long causeOfLoss);
	
}