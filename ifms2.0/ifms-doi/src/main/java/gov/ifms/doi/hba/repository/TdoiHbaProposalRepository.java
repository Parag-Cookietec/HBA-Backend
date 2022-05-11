package gov.ifms.doi.hba.repository;

import java.util.List;

import gov.ifms.common.dao.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiHbaProposalEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiHbaProposalRepository
		extends JpaRepository<TdoiHbaProposalEntity, Long>, JpaSpecificationExecutor<TdoiHbaProposalEntity>, GenericDao {
	@Query("select entity from TdoiHbaProposalEntity entity where entity.activeStatus = 1")
	List<TdoiHbaProposalEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiHbaProposalEntity entity SET entity.activeStatus = 0 where entity.hbaProposalId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiHbaProposalEntity entity where entity.activeStatus = 1 and entity.hbaProposalId = :id")
	List<TdoiHbaProposalEntity> findAllActiveById(@Param("id") Long id);
}
