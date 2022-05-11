package gov.ifms.doi.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.jpa.entity.DoiJPAClaimEntryEntity;

/**
 * 
 * @author Sagar Patil
 *
 */
@Repository
@Transactional
public interface DoiJPAClaimEntryRepository extends JpaRepository<DoiJPAClaimEntryEntity, Long>{

	@Query("select entity from DoiJPAClaimEntryEntity entity where entity.claimStatus = :status")
	List<DoiJPAClaimEntryEntity> findAllByClaimStatus(@Param("status") String status); 
}
