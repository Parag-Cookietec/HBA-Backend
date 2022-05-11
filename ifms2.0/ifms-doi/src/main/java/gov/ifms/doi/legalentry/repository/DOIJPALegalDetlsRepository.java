package gov.ifms.doi.legalentry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.legalentry.entity.DOIJpaLegalDtlEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional
public interface DOIJPALegalDetlsRepository extends JpaRepository<DOIJpaLegalDtlEntity, Long>, JpaSpecificationExecutor<DOIJpaLegalDtlEntity>{

	@Modifying(clearAutomatically = true)
	@Query("update DOIJpaLegalDtlEntity entity SET entity.activeStatus = 0 where entity.legalDtlsId = :legalDtlsId")
	void softDeleteById(@Param("legalDtlsId") Long legalDtlsId);

}