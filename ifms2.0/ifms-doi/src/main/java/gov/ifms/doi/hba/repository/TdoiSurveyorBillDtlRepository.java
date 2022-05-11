package gov.ifms.doi.hba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiSurveyorBillDtlEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiSurveyorBillDtlRepository
		extends JpaRepository<TdoiSurveyorBillDtlEntity, Long>, JpaSpecificationExecutor<TdoiSurveyorBillDtlEntity> {
	@Query("select entity from TdoiSurveyorBillDtlEntity entity where entity.activeStatus = 1")
	List<TdoiSurveyorBillDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiSurveyorBillDtlEntity entity SET entity.activeStatus = 0 where entity.surveyorBillId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiSurveyorBillDtlEntity entity where entity.activeStatus = 1 and entity.surveyorBillId = :id")
	List<TdoiSurveyorBillDtlEntity> findAllActiveById(@Param("id") Long id);
}
