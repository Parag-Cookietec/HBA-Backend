package gov.ifms.doi.hba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiHbaProposlWfEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiHbaProposlWfRepository
		extends JpaRepository<TdoiHbaProposlWfEntity, Long>, JpaSpecificationExecutor<TdoiHbaProposlWfEntity> {
	@Query("select entity from TdoiHbaProposlWfEntity entity where entity.activeStatus = 1")
	List<TdoiHbaProposlWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiHbaProposlWfEntity entity SET entity.activeStatus = 0 where entity.hbaProposlWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiHbaProposlWfEntity entity where entity.activeStatus = 1 and entity.hbaProposlWfId = :id")
	List<TdoiHbaProposlWfEntity> findAllActiveById(@Param("id") Long id);
}
