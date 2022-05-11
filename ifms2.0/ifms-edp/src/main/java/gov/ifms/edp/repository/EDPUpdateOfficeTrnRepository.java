package gov.ifms.edp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;

/**
 * The Class UpdateOfficeTrnController.
 * 
 * @version 1.0
 * @created 2020/09/21 16:41:54
 */
@Repository
public interface EDPUpdateOfficeTrnRepository
		extends JpaRepository<EDPUpdateOfficeTrnEntity, Long>, JpaSpecificationExecutor<EDPUpdateOfficeTrnEntity> {

	/**
	 * Find by EDP ms office entity office id and active status.
	 *
	 * @param officeId     the office id
	 * @param activeStatus the active status
	 * @return the optional
	 */
	@Query("SELECT trn FROM EDPUpdateOfficeTrnEntity trn WHERE trn.msOfficeEntity.officeId = :officeId AND trn.activeStatus = :activeStatus ORDER BY trn.updOffcTrnId DESC")
	Optional<EDPUpdateOfficeTrnEntity> findByOfficeIdAndActiveStatus(@Param("officeId") Long officeId, @Param("activeStatus") int activeStatus);
}
