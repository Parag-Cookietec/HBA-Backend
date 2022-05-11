package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.MdoiDbPartyMstEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MdoiDbPartyMstRepository
		extends JpaRepository<MdoiDbPartyMstEntity, Long>, JpaSpecificationExecutor<MdoiDbPartyMstEntity> {
	@Query("select entity from MdoiDbPartyMstEntity entity where entity.activeStatus = 1")
	List<MdoiDbPartyMstEntity> findAllByStatus();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update MdoiDbPartyMstEntity entity SET entity.activeStatus = 0 where entity.dbPartyId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from MdoiDbPartyMstEntity entity where entity.activeStatus = 1 and entity.dbPartyId = :id")
	List<MdoiDbPartyMstEntity> findAllActiveById(@Param("id") Long id);
}
