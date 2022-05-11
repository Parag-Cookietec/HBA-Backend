package gov.ifms.edp.repository;

import java.util.Date;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPOfficeItrEntity;

/**
 * The Interface EDPOfficeItrRepository.
 */
@Repository
@Transactional
public interface EDPOfficeItrRepository
		extends JpaRepository<EDPOfficeItrEntity, Long>, JpaSpecificationExecutor<EDPOfficeItrEntity>, GenericDao {
	
	/**
	 * Update active status by transaction no.
	 *
	 * @param transactionNo the transaction no
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPOfficeItrEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where transactionNo = :transactionNo")
	public int updateActiveStatusByTransactionNo(@Param("transactionNo") String transactionNo, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	
	/**
	 * Find first by transaction no asc.
	 *
	 * @param trnNo the trn no
	 * @param sort the sort
	 * @return the EDP office itr entity
	 */
	public EDPOfficeItrEntity  findTopByTransactionNo(String trnNo,Sort sort);
	
	@Query(value = "SELECT ofc.officeStatus FROM EDPOfficeItrEntity ofc WHERE (ofc.officeId,ofc.officeItrId,ofc.updatedDate) IN (SELECT toi.officeId,MAX(toi.officeItrId),MAX(toi.updatedDate) FROM EDPOfficeItrEntity toi WHERE statusId = 327 GROUP BY toi.officeId) AND ofc.officeId = :officeId")
	public Long findLastApprovedOfficeStatus(@Param("officeId") Long officeId);
	
	//SELECT MAX(CAST(RIGHT(TRN_NO, 5) AS BIGINT)) AS sss FROM MASTER_V1.T_OFF_ITR WHERE trn_no LIKE '%UO%'
	@Query(value = "SELECT MAX(CAST(RIGHT(TRN_NO, 5) AS BIGINT)) AS sss FROM "+Constant.EDP_MASTER_SCHEMA+".T_OFF_ITR WHERE TRN_NO LIKE '%'||?||'%' ", nativeQuery=true)
	public Long findLastTransactionNumber(String trnNumber);

	
}
