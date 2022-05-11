package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPolEquipDtlEntity;

public interface TdoiDbPolEquipDtlRepository
		extends JpaRepository<TdoiDbPolEquipDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbPolEquipDtlEntity> {
	@Query("select entity from TdoiDbPolEquipDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolEquipDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolEquipDtlEntity entity SET entity.activeStatus = 0 where entity.equipDtlsId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolEquipDtlEntity entity where entity.activeStatus = 1 and entity.equipDtlsId = :id")
	List<TdoiDbPolEquipDtlEntity> findAllActiveById(@Param("id") Long id);
}
