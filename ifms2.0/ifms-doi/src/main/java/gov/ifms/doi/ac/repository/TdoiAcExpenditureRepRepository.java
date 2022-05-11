package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcExpenditureRepEntity;

public interface TdoiAcExpenditureRepRepository
		extends JpaRepository<TdoiAcExpenditureRepEntity, Long>, JpaSpecificationExecutor<TdoiAcExpenditureRepEntity> {
	@Query("select entity from TdoiAcExpenditureRepEntity entity where entity.activeStatus = 1")
	List<TdoiAcExpenditureRepEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcExpenditureRepEntity entity SET entity.activeStatus = 0 where entity.expendRepId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcExpenditureRepEntity entity where entity.activeStatus = 1 and entity.expendRepId = :id")
	List<TdoiAcExpenditureRepEntity> findAllActiveById(@Param("id") Long id);
}
