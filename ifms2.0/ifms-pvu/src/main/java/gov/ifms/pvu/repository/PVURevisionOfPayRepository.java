package gov.ifms.pvu.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVURevisionOfPayEntity;

/**
 * The Class PVURevisionOfPayController.
 * 
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */

@Repository
@Transactional
public interface PVURevisionOfPayRepository extends JpaRepository<PVURevisionOfPayEntity, Long>,
		JpaSpecificationExecutor<PVURevisionOfPayEntity>, GenericDao {

	@Modifying(clearAutomatically = true)
	@Query("update PVURevisionOfPayEntity entity set entity.statusId.lookUpInfoId = :statusId ,updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVURevisionOfPayEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void deleteRopEventIdBy(@Param("activeStatus") Integer activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVURevisionOfPayEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate  , isPrintAble.lookUpInfoId= :isPrintAble , approveDate =:approveDate  where entity.id = :id")
	void updatePrintStatusAndApproveDate(@Param("activeStatus") int activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("isPrintAble") long isPrintAble, @Param("approveDate") Date approveDate);

	@Modifying(clearAutomatically = true)
	@Query("update PVURevisionOfPayEntity entity set entity.activeStatus = :activeStatus ,updatedBy= :updatedBy , updatedDate= :updatedDate  , authorizeDate =:authorizeDate  where entity.id = :id")
	void updateAutorizedDate(@Param("activeStatus") int activeStatus, @Param("id") long id,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("authorizeDate") Date authorizeDate);

	PVURevisionOfPayEntity findByTrnNo(@Param("trnNo") String trnNo);

	@Query(value = "SELECT REGULAR_CONV_DATE FROM PVU.T_EMP_DPT_DTL tedd  WHERE EMP_ID =? ",nativeQuery = true)
	String findRegularConverstionDate(String employeeId);
}
