package gov.ifms.doi.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.jpa.entity.DoiJPAClaimEntryEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional

public interface DoiJpaClaimListingRepository extends JpaRepository<DoiJPAClaimEntryEntity, Long>, JpaSpecificationExecutor<DoiJPAClaimEntryEntity>{

}