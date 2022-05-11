package gov.ifms.pvu.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeTikuPayEntity;

@Repository
@Transactional
public interface PVUEmployeTikuPayRepository extends JpaRepository<PVUEmployeTikuPayEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeTikuPayEntity>, GenericDao {

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeTikuPayEntity entity set entity.status.lookUpInfoId = :statusId, updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeTikuPayEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void deleteTikuPayEventIdBy(@Param("activeStatus") Integer activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeTikuPayEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate  , authorizeDate =:authorizeDate  where entity.id = :id")
	void updateAutorizedDate(@Param("activeStatus") int activeStatus, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate, @Param("authorizeDate") Date authorizeDate, @Param("id") long id);

	List<PVUEmployeTikuPayEntity> findByEmployeeIdEmpIdAndActiveStatusAndStatusLookUpInfoId(
			@Param("employeeId") Long empId, @Param("activeStatus") Integer activeStatus, @Param("status") long status);

	@Modifying
	@Query("update PVUEmployeTikuPayEntity entity set entity.activeStatus = :activeStatus , entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate  , "
			+ "entity.isPrintAble.lookUpInfoId= :isPrintAble, " + "entity.status.lookUpInfoId = :approve , "
			+ " entity.approveDate =:approveDate  where entity.id = :id")
	void updatePrintStatusAndApproveDate(@Param("approve") Long approve, @Param("activeStatus") int activeStatus,
			@Param("id") long id, @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("isPrintAble") long isPrintAble, @Param("approveDate") LocalDateTime approveDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeTikuPayEntity entity set entity.status.lookUpInfoId = :statusId, entity.updatedBy= :updatedBy ,entity.updatedDate= :updatedDate ,entity.authorizeDate = :authDate where entity.id = :id")
	void updateStatusIdAndAuthDate(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate);

	@Modifying
	@Query("update PVUEmployeTikuPayEntity entity set entity.status.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate, entity.authorizeBy =:authorizeBy, entity.authorizerRemark = :authorizerRemark"
			+ " where entity.id = :id")
	void updateStatusIdAndAuthorizer(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate, @Param("authorizeBy") long authorizeBy,
			@Param("authorizerRemark") String authorizerRemark);

	PVUEmployeTikuPayEntity findByTrnNo(@Param("trnNo") String trnNo);
}
