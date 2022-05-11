package gov.ifms.doi.db.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.doi.db.entity.TdoiDbPolElecEquipEntity;

@Transactional
@Repository
public interface TdoiDbPolElecEquipRepository extends JpaRepository<TdoiDbPolElecEquipEntity, Long>, JpaSpecificationExecutor<TdoiDbPolElecEquipEntity> {
	@Query("select entity from TdoiDbPolElecEquipEntity entity where entity.activeStatus = 1")
	List<TdoiDbPolElecEquipEntity> findAllByStatus();
	TdoiDbPolElecEquipEntity findBydbElecEquipId(long dbElecEquipId);  
	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPolElecEquipEntity entity SET entity.activeStatus = 0 where entity.dbElecEquipId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPolElecEquipEntity entity where entity.activeStatus = 1 and entity.dbElecEquipId = :id")
	List<TdoiDbPolElecEquipEntity> findAllActiveById(@Param("id") Long id);
}
