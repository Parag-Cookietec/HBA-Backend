package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcTeExpenditureDtlEntity;

public interface TdoiAcTeExpenditureDtlRepository extends JpaRepository<TdoiAcTeExpenditureDtlEntity, Long>,
		JpaSpecificationExecutor<TdoiAcTeExpenditureDtlEntity> {
	@Query("select entity from TdoiAcTeExpenditureDtlEntity entity where entity.activeStatus = 1")
	List<TdoiAcTeExpenditureDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcTeExpenditureDtlEntity entity SET entity.activeStatus = 0 where entity.teExpenDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcTeExpenditureDtlEntity entity where entity.activeStatus = 1 and entity.teExpenDtlId = :id")
	List<TdoiAcTeExpenditureDtlEntity> findAllActiveById(@Param("id") Long id);
}
