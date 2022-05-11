package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.MdoiDbPartyBankDtlEntity;

public interface MdoiDbPartyBankDtlRepository
		extends JpaRepository<MdoiDbPartyBankDtlEntity, Long>, JpaSpecificationExecutor<MdoiDbPartyBankDtlEntity> {
	@Query("select entity from MdoiDbPartyBankDtlEntity entity where entity.activeStatus = 1")
	List<MdoiDbPartyBankDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update MdoiDbPartyBankDtlEntity entity SET entity.activeStatus = 0 where entity.dbPartyBankId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from MdoiDbPartyBankDtlEntity entity where entity.activeStatus = 1 and entity.dbPartyBankId = :id")
	List<MdoiDbPartyBankDtlEntity> findAllActiveById(@Param("id") Long id);
}
