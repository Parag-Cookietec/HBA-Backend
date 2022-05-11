package gov.ifms.pvu.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;

@Repository
@Transactional
public interface PVUPrintEndorsementItrRepository extends JpaRepository<PVUPrintEndorsementItrEntity, Long>,
		JpaSpecificationExecutor<PVUPrintEndorsementItrEntity> {

	@Modifying(clearAutomatically = true)
	@Query("update PVUPrintEndorsementItrEntity entity set entity.activeStatus = :activeStatus ,entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id and entity.printCnt = :printCnt and entity.activeStatus = 1 ")
	void deleteReprintByPrintCount(@Param("activeStatus") Integer activeStatus, @Param("id") long id,
			@Param("printCnt") Long printCnt, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);
}
