package gov.ifms.doi.ac.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.ac.entity.TdoiAcTransferEntryEntity;

public interface TdoiAcTransferEntryRepository
		extends JpaRepository<TdoiAcTransferEntryEntity, Long>, JpaSpecificationExecutor<TdoiAcTransferEntryEntity> {
	@Query("select entity from TdoiAcTransferEntryEntity entity where entity.activeStatus = 1")
	List<TdoiAcTransferEntryEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiAcTransferEntryEntity entity SET entity.activeStatus = 0 where entity.transferEntryId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiAcTransferEntryEntity entity where entity.activeStatus = 1 and entity.transferEntryId = :id")
	List<TdoiAcTransferEntryEntity> findAllActiveById(@Param("id") Long id);
}
