package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.MdoiDbFireSumInsrMstEntity;

public interface MdoiDbFireSumInsrMstRepository
		extends JpaRepository<MdoiDbFireSumInsrMstEntity, Long>, JpaSpecificationExecutor<MdoiDbFireSumInsrMstEntity> {
	@Query("select entity from MdoiDbFireSumInsrMstEntity entity where entity.activeStatus = 1")
	List<MdoiDbFireSumInsrMstEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update MdoiDbFireSumInsrMstEntity entity SET entity.activeStatus = 0 where entity.riskCoverId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from MdoiDbFireSumInsrMstEntity entity where entity.activeStatus = 1 and entity.riskCoverId = :id")
	List<MdoiDbFireSumInsrMstEntity> findAllActiveById(@Param("id") Long id);
}
