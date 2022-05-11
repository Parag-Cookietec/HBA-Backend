package gov.ifms.pvu.repository;

import java.time.LocalDate;
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
import gov.ifms.pvu.entity.PVUEmployeShettyPayEntity;

/**
 * The Class PVUEmployeShettyPayController.
 * 
 * @version v 1.0
 * @created 2020/01/06 12:53:37
 */

@Repository
@Transactional
public interface PVUEmployeShettyPayRepository extends JpaRepository<PVUEmployeShettyPayEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeShettyPayEntity>, GenericDao {

	PVUEmployeShettyPayEntity findByEmpIdEmpIdAndEventEffectiveDate(@Param("empId") Long empId,
			@Param("eventEffectiveDate") LocalDate eventEffectiveDate);

	List<PVUEmployeShettyPayEntity> findByEmpIdEmpIdAndActiveStatus(@Param("empId") Long empId,
			@Param("activeStatus") Integer activeStatus);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeShettyPayEntity entity set entity.statusId.lookUpInfoId = :statusId, updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeShettyPayEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void deleteShettyPayByEventId(@Param("activeStatus") Integer activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeShettyPayEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate  , authorizeDate =:authorizeDate  where entity.id = :id")
	void updateAutorizedDate(@Param("activeStatus") int activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authorizeDate") LocalDateTime authorizeDate);

	@Modifying
	@Query("update PVUEmployeShettyPayEntity entity set entity.activeStatus = :activeStatus ,entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate  , "
			+ "entity.isPrintAble.lookUpInfoId= :isPrintAble , " + "entity.statusId.lookUpInfoId= :approve , "
			+ " entity.approveDate =:approveDate  where entity.id = :id")
	void updatePrintStatusAndApproveDate(@Param("approve") Long approve, @Param("activeStatus") int activeStatus,
			@Param("id") long id, @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("isPrintAble") long isPrintAble, @Param("approveDate") LocalDateTime approveDate);

	@Modifying
	@Query("update PVUEmployeShettyPayEntity entity set entity.statusId.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, "
			+ " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate, entity.authorizeBy =:authorizeBy, entity.authorizerRemark = :authorizerRemark, "
			+ " entity.payBandValue= :payBandValue where entity.id = :id")
	void updateStatusIdAndAuthorizer(@Param("statusId") long statusId, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authDate") LocalDateTime authDate, @Param("authorizeBy") long authorizeBy,
			@Param("authorizerRemark") String authorizerRemark, @Param("payBandValue") long payBandValue);

	PVUEmployeShettyPayEntity findByTrnNo(@Param("trnNo") String trnNo);

}
