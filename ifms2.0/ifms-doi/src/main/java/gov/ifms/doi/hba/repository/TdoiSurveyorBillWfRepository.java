package gov.ifms.doi.hba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiSurveyorBillWfEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiSurveyorBillWfRepository
		extends JpaRepository<TdoiSurveyorBillWfEntity, Long>, JpaSpecificationExecutor<TdoiSurveyorBillWfEntity> {
	@Query("select entity from TdoiSurveyorBillWfEntity entity where entity.activeStatus = 1")
	List<TdoiSurveyorBillWfEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiSurveyorBillWfEntity entity SET entity.activeStatus = 0 where entity.surveyorBillWfId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiSurveyorBillWfEntity entity where entity.activeStatus = 1 and entity.surveyorBillWfId = :id")
	List<TdoiSurveyorBillWfEntity> findAllActiveById(@Param("id") Long id);
}
