package gov.ifms.doi.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.ac.entity.TdoiAcCashbookReceiptEntity;

public interface TdoiAcCashbookReceiptRepository extends JpaRepository<TdoiAcCashbookReceiptEntity, Long>,
		JpaSpecificationExecutor<TdoiAcCashbookReceiptEntity> {
	@Query("select entity from TdoiAcCashbookReceiptEntity entity where entity.activeStatus = 1")
	List<TdoiAcCashbookReceiptEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcCashbookReceiptEntity entity SET entity.activeStatus = 0 where entity.cbReceiptId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcCashbookReceiptEntity entity where entity.activeStatus = 1 and entity.cbReceiptId = :id")
	List<TdoiAcCashbookReceiptEntity> findAllActiveById(@Param("id") Long id);
}
