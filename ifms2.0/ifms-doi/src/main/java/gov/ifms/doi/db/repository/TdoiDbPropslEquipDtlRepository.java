package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropslEquipDtlEntity;

public interface TdoiDbPropslEquipDtlRepository
		extends JpaRepository<TdoiDbPropslEquipDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbPropslEquipDtlEntity> {
	@Query("select entity from TdoiDbPropslEquipDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropslEquipDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropslEquipDtlEntity entity SET entity.activeStatus = 0 where entity.equipDtlsId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropslEquipDtlEntity entity where entity.activeStatus = 1 and entity.equipDtlsId = :id")
	List<TdoiDbPropslEquipDtlEntity> findAllActiveById(@Param("id") Long id);
}
