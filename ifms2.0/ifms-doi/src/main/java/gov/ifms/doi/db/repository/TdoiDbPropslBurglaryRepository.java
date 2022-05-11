package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslBurglaryEntity;

public interface TdoiDbPropslBurglaryRepository
		extends JpaRepository<TdoiDbPropslBurglaryEntity, Long>, JpaSpecificationExecutor<TdoiDbPropslBurglaryEntity> {
	@Query("select entity from TdoiDbPropslBurglaryEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslBurglaryEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslBurglaryEntity entity SET entity.activeStatus = 0 where entity.dbBurglaryId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslBurglaryEntity entity where entity.activeStatus = 1 and entity.dbBurglaryId = :id")
	List<TdoiDbPropslBurglaryEntity> findAllActiveById(@Param("id") Long id);
}
