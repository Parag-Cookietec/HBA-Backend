package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbProposalEntity;

public interface TdoiDbProposalRepository
		extends JpaRepository<TdoiDbProposalEntity, Long>, JpaSpecificationExecutor<TdoiDbProposalEntity> {
	@Query("select entity from TdoiDbProposalEntity entity where entity.activeStatus = 1")
	List<TdoiDbProposalEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbProposalEntity entity SET entity.activeStatus = 0 where entity.dbProposalId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbProposalEntity entity where entity.activeStatus = 1 and entity.dbProposalId = :id")
	List<TdoiDbProposalEntity> findAllActiveById(@Param("id") Long id);
}
