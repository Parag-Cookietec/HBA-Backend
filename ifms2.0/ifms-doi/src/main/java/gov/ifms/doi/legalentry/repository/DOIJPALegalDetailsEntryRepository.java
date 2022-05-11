package gov.ifms.doi.legalentry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.legalentry.entity.DOIJPALegalDetailEntryEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional
public interface DOIJPALegalDetailsEntryRepository extends JpaRepository<DOIJPALegalDetailEntryEntity, Long>, JpaSpecificationExecutor<DOIJPALegalDetailEntryEntity>{

	DOIJPALegalDetailEntryEntity findByLegalEntryId(long legalEntryId);
	
	@Modifying(clearAutomatically = true)
	@Query("update DOIJPALegalDetailEntryEntity entity SET entity.activeStatus = 0 where entity.legalEntryId = :legalEntryId")
	void softDeleteById(@Param("legalEntryId") Long legalEntryId);
}