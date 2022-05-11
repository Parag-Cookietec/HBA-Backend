package gov.ifms.pvu.repository;


import gov.ifms.pvu.dto.response.PVUCASPrintDto;
import gov.ifms.pvu.dto.response.PVUSSPPrintDto;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;

@Repository
@Transactional
public interface PVUPrintEndorsementRepository extends JpaRepository<PVUPrintEndorsementEntity,Long> ,
		JpaSpecificationExecutor<PVUPrintEndorsementEntity>, GenericDao{

	PVUPrintEndorsementEntity findByIdAndActiveStatus(Long id ,int activeStatus);

	PVUPrintEndorsementEntity findOneByTrnIdAndEventIdAndActiveStatus(Long trnId ,Long eventId ,int activeStatus);

	@Query("select new gov.ifms.pvu.dto.response.PVUSSPPrintDto(e.printDate,e.reprintDate,e.printCnt) from PVUPrintEndorsementEntity e where e.trnId = :trnId and e.eventId =:eventId and e.activeStatus =:activeStatus ")
	PVUSSPPrintDto getPrintDateReprintDatePrintCount(@Param("trnId") Long trnId , @Param("eventId") Long eventId , @Param("activeStatus") int activeStatus);

	@Query("select new gov.ifms.pvu.dto.response.PVUCASPrintDto(e.printDate,e.reprintDate,e.printCnt) from PVUPrintEndorsementEntity e where e.trnId = :trnId and e.eventId =:eventId and e.activeStatus =:activeStatus ")
	PVUCASPrintDto getPrintDateReprintDatePrintCountData(@Param("trnId") Long trnId , @Param("eventId") Long eventId , @Param("activeStatus") int activeStatus);
	
	@Modifying(clearAutomatically = true)
	@Query("update PVUPrintEndorsementEntity entity set entity.printCnt = :printCnt, updatedBy= :updatedBy , updatedDate= :updatedDate where entity.eventId = :eventId and entity.trnId = :trnId and entity.activeStatus = 1")
	void updateReprintCount(@Param("printCnt") Long printCnt, @Param("eventId") Long eventId,@Param("trnId") Long trnId, @Param("updatedBy") Long updatedBy,
			@Param("updatedDate") Date updatedDate);
	
	PVUPrintEndorsementEntity findByEventIdAndTrnId( @Param("eventId") Long eventId,@Param("trnId") Long trnId);

}
