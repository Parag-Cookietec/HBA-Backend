package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.dto.PVUEmployeeTypeDto;
import gov.ifms.pvu.entity.PVUFixToRegularPayConEntity;

/**
 * The Class PVUFixToRegularPayConRepository.
 * 
 * @version 1.0
 * @created 2021/04/11 14:05:32
 */

@Repository
@Transactional
public interface PVUFixToRegularPayConRepository extends JpaRepository<PVUFixToRegularPayConEntity, Long>,
		JpaSpecificationExecutor<PVUFixToRegularPayConEntity>, GenericDao {

	PVUFixToRegularPayConEntity findByFixRegDsIdAndActiveStatus(Long id, int activeStatus);

	@Modifying
	@Query(value = "update PVUFixToRegularPayConEntity set  activeStatus=0  where fixRegDsId = :fixRegDsId")
	public void deleteFixToRegularPayCon(@Param("fixRegDsId") Long fixRegDsId);

	List<PVUFixToRegularPayConEntity> findByEmpIdAndCreatedByAndStatusIdAndActiveStatus(Long empId, Long createdBy,
			Long statusId, int activestatus);

	PVUFixToRegularPayConEntity findByTrnNo(@Param("trnNo") String trnNo);

	@Query(value = "SELECT EOL AS EOL,SUSPENSION AS suspension,TRANSFER AS transfer,\"INCREMENT\" AS incremnt,TRN_ID AS transNo FROM PVU.T_EMP_EVNT_STATUS tees WHERE EMP_ID =?1", nativeQuery = true)
	PVUEmployeeTypeDto validateFtr(Long empId);
}
