package gov.ifms.doi.ac.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.ac.entity.TdoiAcTransferEntryDtlEntity;

public interface TdoiAcTransferEntryDtlRepository extends JpaRepository<TdoiAcTransferEntryDtlEntity, Long>,
		JpaSpecificationExecutor<TdoiAcTransferEntryDtlEntity> {
	@Query("select entity from TdoiAcTransferEntryDtlEntity entity where entity.activeStatus = 1")
	List<TdoiAcTransferEntryDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcTransferEntryDtlEntity entity SET entity.activeStatus = 0 where entity.transfrDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcTransferEntryDtlEntity entity where entity.activeStatus = 1 and entity.transfrDtlId = :id")
	List<TdoiAcTransferEntryDtlEntity> findAllActiveById(@Param("id") Long id);
}
