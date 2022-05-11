package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropElecRiDtlEntity;

public interface TdoiDbPropElecRiDtlRepository
		extends JpaRepository<TdoiDbPropElecRiDtlEntity, Long>, JpaSpecificationExecutor<TdoiDbPropElecRiDtlEntity> {
	@Query("select entity from TdoiDbPropElecRiDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropElecRiDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropElecRiDtlEntity entity SET entity.activeStatus = 0 where entity.elecRiDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropElecRiDtlEntity entity where entity.activeStatus = 1 and entity.elecRiDtlId = :id")
	List<TdoiDbPropElecRiDtlEntity> findAllActiveById(@Param("id") Long id);
}
