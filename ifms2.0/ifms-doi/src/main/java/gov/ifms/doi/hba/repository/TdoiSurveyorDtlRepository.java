package gov.ifms.doi.hba.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.ifms.doi.hba.entity.TdoiSurveyorDtlEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TdoiSurveyorDtlRepository
		extends JpaRepository<TdoiSurveyorDtlEntity, Long>, JpaSpecificationExecutor<TdoiSurveyorDtlEntity> {
	@Query("select entity from TdoiSurveyorDtlEntity entity where entity.activeStatus = 1")
	List<TdoiSurveyorDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiSurveyorDtlEntity entity SET entity.activeStatus = 0 where entity.surveyorId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiSurveyorDtlEntity entity where entity.activeStatus = 1 and entity.surveyorId = :id")
	List<TdoiSurveyorDtlEntity> findAllActiveById(@Param("id") Long id);
}
