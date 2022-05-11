package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;

/**
 * The Class PVUGradePayRepository.
 * 
 * @version v 1.0
 * @created 2019/12/23 11:25:42
 */

@Repository
@Transactional
public interface PVUMsGradePayRepository extends JpaRepository<PVUMsGradePayEntity,Long> ,
                  JpaSpecificationExecutor<PVUMsGradePayEntity> {

    List<PVUMsGradePayEntity> findAllByIdIn(List<Long> ids, Sort sort);

    @Query(value = "select distinct GRADE_PAY_ID from MASTER_V1.MS_PAY_CONVERSION where DEPT_ID = :deptId AND GRADE_PAY_ID IS NOT NULL",nativeQuery = true)
    List<Long> getIdByDepartmentCategory(@Param("deptId") Long deptId);

    @Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.id,e.gradePayValue) from PVUMsGradePayEntity e where e.id = :id")
    IdNameDto getOnlyIdAndName(@Param("id") Long id);
    

    
    @Query(value = "SELECT PAY_BAND_ID FROM MASTER_V1.MS_PAY_CONVERSION mpb WHERE PAY_SCALE_ORDER BETWEEN\r\n" + 
    		"(SELECT conv.PAY_SCALE_ORDER FROM MASTER_V1.MS_PAY_CONVERSION conv, PVU.T_EMP_EVENTS tee WHERE\r\n" + 
    		"tee.EMP_ID = :employeeId AND tee.EVENT_ID = 1 AND (tee.PAY_SCALE = conv.PAY_SCAL_ID OR  tee.EMP_GRD_PAY = conv.GRADE_PAY_ID OR tee.EMP_PAY_LEVEL = conv.PAY_LVL_ID ) AND conv.DEPT_ID = :deptId\r\n"
    		+ "AND tee.PAY_COMMISSION = (SELECT JOIN_PAY_COMM_ID FROM PVU.T_EMP_JOIN_PAY_DTL WHERE EMP_ID = :employeeId))\r\n" + 
    		"AND\r\n" + 
    		"(SELECT conv.PAY_SCALE_ORDER FROM MASTER_V1.MS_PAY_CONVERSION conv, PVU.T_EMP_EVENTS tee WHERE\r\n" + 
    		"tee.EMP_ID = :employeeId AND tee.EVENT_ID NOT IN (5,7,8) AND tee.EVNT_DATE <= TO_DATE( :effectiveDate,'yyyy-mm-dd')\r\n" + 
    		"AND ( tee.EMP_GRD_PAY = conv.GRADE_PAY_ID  OR tee.PAY_SCALE = conv.PAY_SCAL_ID OR tee.EMP_PAY_LEVEL = conv.PAY_LVL_ID ) AND conv.DEPT_ID = :deptId ORDER BY  tee.UPDATED_DATE desc LIMIT 1)\r\n" + 
    		"ORDER BY PAY_SCALE_ORDER ASC",nativeQuery = true)
    List<Long> getIdByPayBand(@Param("deptId") Long deptId, @Param("employeeId") Long employeeId, @Param("effectiveDate") String effectiveDate );    
    
    @Query(value = "SELECT  DISTINCT(mpc.GRADE_PAY_ID),mpc.PAY_BAND_DISP_VAL,mpc.PAY_BAND_ID, mpc.GRADE_PAY_DISP_VAL, mpb.STARTING_VALUE, mpb.ENDING_VALUE FROM MASTER_V1.MS_PAY_CONVERSION mpc, MASTER_V1.MS_PAY_BAND mpb \r\n" + 
    		     " WHERE mpc.GRADE_PAY_ID IN (:gradePayId) and mpc.DEPT_ID = :departmentCategoryId AND mpc.PAY_BAND_ID = mpb.PAY_BAND_ID",nativeQuery = true)
    List<Object[]> getSixPayCommission(@Param("gradePayId")  List<Long>  gradePayId, @Param("departmentCategoryId") Long departmentCategoryId );
    
    
    
    
    
    

    List<PVUMsGradePayEntity> findAllByPayBandIdIn(Long payBandId);
   

}
