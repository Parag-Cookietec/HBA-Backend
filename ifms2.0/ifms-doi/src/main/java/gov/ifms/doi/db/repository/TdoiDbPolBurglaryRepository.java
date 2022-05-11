package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolBurglaryEntity;

public interface TdoiDbPolBurglaryRepository
		extends JpaRepository<TdoiDbPolBurglaryEntity, Long>, JpaSpecificationExecutor<TdoiDbPolBurglaryEntity> {
	@Query("select entity from TdoiDbPolBurglaryEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolBurglaryEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolBurglaryEntity entity SET entity.activeStatus = 0 where entity.dbBurglaryId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolBurglaryEntity entity where entity.activeStatus = 1 and entity.dbBurglaryId = :id")
	List<TdoiDbPolBurglaryEntity> findAllActiveById(@Param("id") Long id);
}
