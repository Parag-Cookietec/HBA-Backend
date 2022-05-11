package gov.ifms.pvu.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;

/**
 * The Class PVUEmployeeEventStatusController.
 * 
 * @version v 1.0
 * @created 2020/02/15 14:20:18
 */

@Repository
@Transactional
public interface PVUEmployeeEventStatusRepository extends JpaRepository<PVUEmployeeEventStatusEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeeEventStatusEntity> {

	/**
	 * Find by emp id emp id.
	 *
	 * @param empId the emp id
	 * @return the PVU employee event status entity
	 */
	public Optional<PVUEmployeeEventStatusEntity> findByEmpIdEmpId(long empId);

	/**
	 * Reset inc employee event status.
	 *
	 * @param trnId the trn id
	 */
	@Modifying
	@Query(value = "UPDATE PVU.T_EMP_EVNT_STATUS s "
			+ " SET s.INCREMENT = 0, s.TRN_ID = NULL, s.UPDATED_DATE = :updatedDate,"
			+ "  s.UPDATED_BY = :updatedBy,  s.UPDATED_BY_POST = :updatedByPost " + " WHERE " + "	EXISTS ("
			+ "		SELECT 1 " + "	FROM " + "		pvu.T_PVU_IN_EVNT e, " + "		pvu.T_PVU_IN_EMP r " + "	WHERE "
			+ "		e.T_PVU_IN_EVNT_ID = r.T_PVU_IN_EVNT_ID " + "		AND e.T_PVU_IN_EVNT_ID = :trnId "
			+ "		AND r.EMP_ID = s.EMP_ID" + "		AND r.REASON_FOR_EXCLUDE is NULL) ", nativeQuery = true)
	public void resetIncEmployeeEventStatus(@Param("trnId") Long trnId, @Param("updatedDate") Date updatedDate,
			@Param("updatedBy") long updatedBy, @Param("updatedByPost") long updatedByPost);

	/**
	 * Find employee in progress.
	 *
	 * @param lstEmpIncludeList the lst emp include list
	 * @return the list
	 */
	@Query(value = "SELECT new gov.ifms.pvu.dto.PVUEmployeeEventStatusDto(eese.eventStatusId, eese.empId.empId,"
			+ " eese.empId.employeeCode, eese.transId, true) FROM "
			+ " PVUEmployeeEventStatusEntity eese WHERE eese.empId.empId in (:empIds) "
			+ " AND (eese.empCreation = 1 OR eese.eol = 1 OR eese.suspension = 1 OR " + 
			"	eese.increment = 1 OR eese.highPayScale = 1 OR eese.promotion = 1 OR " + 
			"	eese.reversion = 1 OR eese.rop = 1 OR eese.assuredCareerProg = 1 OR " + 
			"	eese.careerAdvancement = 1 OR eese.tikuPay = 1 OR eese.shettyPay = 1 OR " + 
			"	eese.seniorScale = 1 OR eese.seniorScalePvu = 1 OR eese.selectionGrade = 1 OR " + 
			"	eese.steppingUp = 1 OR eese.changeScale = 1 OR eese.deemedDate = 1 OR " + 
			"	eese.promotionForgo = 1 OR eese.changeScaleR13 = 1 OR eese.transfer = 1) ")
	public List<PVUEmployeeEventStatusDto> findEmployeeInProgress(
			@Param("empIds") List<Long> empIds);

	/**
	 * Update employee inc event status.
	 *
	 * @param trnNo             the trn no
	 * @param lstEmpIncludeList the lst emp include list
	 */
	@Modifying
	@Query(value = "UPDATE PVU.T_EMP_EVNT_STATUS s "
			+ " SET s.INCREMENT = 1, s.TRN_ID = :trnNo, s.UPDATED_DATE = CURRENT_TIMESTAMP, s.UPDATED_BY = :updatedBy,  s.UPDATED_BY_POST = :updatedByPost"
			+ " WHERE s.EMP_ID IN (:empIds) ", nativeQuery = true)
	public void updateEmployeeIncEventStatus(@Param("trnNo") String trnNo,
			@Param("empIds") List<Long> empIds, @Param("updatedBy") long updatedBy, @Param("updatedByPost") long updatedByPost);

	/**
	 * Reset in progress employee event status.
	 *
	 * @param empId        the emp id
	 * @param updateByPost the update by post
	 */
	@Modifying
	@Query(value = "UPDATE PVU.T_EMP_EVNT_STATUS s "
			+ "SET s.EMP_CREATION = 0,	s.EOL = 0,	s.SUSPENSION = 0, s.\"INCREMENT\" = 0, s.HIGH_PAY_SCALE = 0,s.PROMOTION = 0,s.REVERSION = 0, s.ROP = 0,"
			+ " s.ASURD_CARR_PROG = 0,	s.CARR_ADVAN_SCHM = 0, s.TIKU_PAY = 0,	s.SHETTY_PAY = 0,	s.SENIOR_SCALE = 0,s.SENIOR_SCALE_PVU = 0,	s.SELECTION_GRADE = 0,"
			+ " s.STEPPING_UP = 0, s.CHNG_SCALE_PVU = 0, s.DEEMED_DATE = 0, s.PROMO_FOR_GO = 0, s.CHNG_SCALE_R13 = 0, s.TRANSFER = 0, s.TRN_ID = NULL , "
			+ " s.UPDATED_DATE = CURRENT_TIMESTAMP, " + " s.UPDATED_BY_POST = :updateByPost"
			+ " WHERE s.EMP_ID = :empId ", nativeQuery = true)
	public void resetInProgressEmployeeEventStatus(@Param("empId") Long empId,
			@Param("updateByPost") Long updateByPost);

	/**
	 * Find PVU employee status dto.
	 *
	 * @param empId the emp id
	 * @return the PVU employee event status dto
	 */
	@Query(value = "SELECT new gov.ifms.pvu.dto.PVUEmployeeEventStatusDto(eese.eventStatusId, eese.empId.empId,"
			+ " eese.empId.employeeCode, eese.transId, "
			+ " SUM(eese.eol + eese.suspension + eese.increment + eese.highPayScale + "
			+ " eese.promotion + eese.reversion + eese.rop + eese.assuredCareerProg + eese.promotionForgo + "
			+ " eese.careerAdvancement + eese.tikuPay + eese.shettyPay + eese.seniorScale + eese.selectionGrade + "
			+ " eese.steppingUp + eese.changeScale + eese.deemedDate + eese.promotionForgo + "
			+ " eese.changeScaleR13 + eese.transfer)) " + " FROM "
			+ " PVUEmployeeEventStatusEntity eese WHERE eese.empId.empId = :empId "
			+ " GROUP BY eese.eventStatusId, eese.empId.empId, eese.empId.employeeCode, eese.transId")
	public PVUEmployeeEventStatusDto findPVUEmployeeStatusDto(@Param("empId") Long empId);

	/**
	 * Reset in progress event status by trans no.
	 *
	 * @param trnNo     the trn no
	 * @param updatedBy the updated by
	 */
	@Modifying
	@Query(value = "UPDATE PVU.T_EMP_EVNT_STATUS s "
			+ "SET s.EMP_CREATION = 0,	s.EOL = 0,	s.SUSPENSION = 0, s.\"INCREMENT\" = 0, s.HIGH_PAY_SCALE = 0, s.PROMOTION = 0,s.REVERSION = 0, s.ROP = 0,"
			+ " s.ASURD_CARR_PROG = 0, s.CARR_ADVAN_SCHM = 0, s.TIKU_PAY = 0,	s.SHETTY_PAY = 0,	s.SENIOR_SCALE = 0,	s.SENIOR_SCALE_PVU = 0,	s.SELECTION_GRADE = 0,"
			+ " s.STEPPING_UP = 0, s.CHNG_SCALE_PVU = 0, s.DEEMED_DATE = 0, s.PROMO_FOR_GO = 0, s.CHNG_SCALE_R13 = 0, s.TRANSFER = 0, s.TRN_ID = NULL , "
			+ " s.UPDATED_DATE = CURRENT_TIMESTAMP, " + " s.UPDATED_BY = :updatedBy "
			+ " WHERE s.TRN_ID = :trnNo ", nativeQuery = true)
	public void resetInProgressEventStatusByTransNo(@Param("trnNo") String trnNo, @Param("updatedBy") long updatedBy);

	@Query(value = "SELECT new gov.ifms.pvu.dto.PVUEmployeeEventStatusDto(eese.eventStatusId, eese.empId.empId,"
			+ " eese.empId.employeeCode, eese.transId, true) FROM "
			+ " PVUEmployeeEventStatusEntity eese WHERE eese.empId.empId in (:empIds) "
			+ " AND (eese.empCreation = 1 OR eese.eol = 1 OR eese.suspension = 1 OR " + 
			"	eese.increment = 1 OR eese.highPayScale = 1 OR eese.promotion = 1 OR " + 
			"	eese.reversion = 1 OR eese.rop = 1 OR eese.assuredCareerProg = 1 OR " + 
			"	eese.careerAdvancement = 1 OR eese.tikuPay = 1 OR eese.shettyPay = 1 OR " + 
			"	eese.seniorScale = 1 OR eese.seniorScalePvu = 1 OR eese.selectionGrade = 1 OR " + 
			"	eese.steppingUp = 1 OR eese.changeScale = 1 OR eese.deemedDate = 1 OR " + 
			"	eese.promotionForgo = 1 OR eese.changeScaleR13 = 1 OR eese.transfer = 1) "
			+ " AND eese.transId != :trnNo ")
	public List<PVUEmployeeEventStatusDto> findEmployeeInProgress(@Param("empIds") List<Long> empIds, @Param("trnNo") String trnNo);

	@Modifying
	@Query(value = "UPDATE PVU.T_EMP_EVNT_STATUS s "
			+ "SET s.EMP_CREATION = 0,	s.EOL = 0,	s.SUSPENSION = 0, s.\"INCREMENT\" = 0, s.HIGH_PAY_SCALE = 0, s.PROMOTION = 0,s.REVERSION = 0, s.ROP = 0,"
			+ " s.ASURD_CARR_PROG = 0, s.CARR_ADVAN_SCHM = 0, s.TIKU_PAY = 0,	s.SHETTY_PAY = 0,	s.SENIOR_SCALE = 0,	s.SENIOR_SCALE_PVU = 0,	s.SELECTION_GRADE = 0,"
			+ " s.STEPPING_UP = 0, s.CHNG_SCALE_PVU = 0, s.DEEMED_DATE = 0, s.PROMO_FOR_GO = 0, s.CHNG_SCALE_R13 = 0, s.TRANSFER = 0, s.TRN_ID = NULL , "
			+ " s.UPDATED_DATE = CURRENT_TIMESTAMP, s.UPDATED_BY = :updatedBy,  s.UPDATED_BY_POST = :updatedByPost "
			+ " WHERE s.TRN_ID = :trnNo AND s.EMP_ID in (:empIds)", nativeQuery = true)
	public void resetInProgressEventStatusByTransNo(@Param("empIds") List<Long> empIds, @Param("trnNo") String trnNo,
			@Param("updatedBy") long updatedBy, @Param("updatedByPost") long updatedByPost);
}
