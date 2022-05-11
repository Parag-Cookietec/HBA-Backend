package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.MdoiDbPartyOfficeDtlEntity;

public interface MdoiDbPartyOfficeDtlRepository
		extends JpaRepository<MdoiDbPartyOfficeDtlEntity, Long>, JpaSpecificationExecutor<MdoiDbPartyOfficeDtlEntity> {
	@Query("select entity from MdoiDbPartyOfficeDtlEntity entity where entity.activeStatus = 1")
	List<MdoiDbPartyOfficeDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update MdoiDbPartyOfficeDtlEntity entity SET entity.activeStatus = 0 where entity.dbPartyOffcId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from MdoiDbPartyOfficeDtlEntity entity where entity.activeStatus = 1 and entity.dbPartyOffcId = :id")
	List<MdoiDbPartyOfficeDtlEntity> findAllActiveById(@Param("id") Long id);
}
