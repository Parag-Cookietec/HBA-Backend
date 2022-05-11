package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcBtr5Entity;

public interface TdoiAcBtr5Repository
		extends JpaRepository<TdoiAcBtr5Entity, Long>, JpaSpecificationExecutor<TdoiAcBtr5Entity> {
	@Query("select entity from TdoiAcBtr5Entity entity where entity.activeStatus = 1")
	List<TdoiAcBtr5Entity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcBtr5Entity entity SET entity.activeStatus = 0 where entity.btr5RegId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcBtr5Entity entity where entity.activeStatus = 1 and entity.btr5RegId = :id")
	List<TdoiAcBtr5Entity> findAllActiveById(@Param("id") Long id);
}
