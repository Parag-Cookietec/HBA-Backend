package gov.ifms.pvu.repository;

import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class PVUMsPayLevelRepository.
 *
 * @version v 1.0
 * @created 2019/12/23 17:19:51
 */

@Repository
@Transactional
public interface PVUMsPayLevelRepository extends JpaRepository<PVUMsPayLevelEntity, Long>,
        JpaSpecificationExecutor<PVUMsPayLevelEntity> {

    @Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.id,e.payLevelValue) from PVUMsPayLevelEntity e where e.id = :id")
    IdNameDto getOnlyIdAndName(@Param("id") Long id);
    
    @Query(value = "SELECT distinct  PAY_LVL_ID,PAY_LVL_DISP_VAL FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus AND FIX_PAY_VALUE=:fixPayValue and PAY_LVL_ID  is not NULL order by PAY_LVL_ID asc ",nativeQuery = true)
    List<Object[]> getPayLevelByDepartmentCategoryAndFixpay(Long departmentCategoryId, int activeStatus, Long fixPayValue);
    
    @Query(value = "SELECT PAY_LVL_ID,PAY_LVL_DISP_VAL FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus and PAY_LVL_ID  is not NULL  ",nativeQuery = true)
    List<Object[]> getPayLevelByDepartmentCategory(Long departmentCategoryId, int activeStatus);

    @Query(value ="SELECT PAY_LVL_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE PAY_SCALE_ORDER BETWEEN\r\n" + 
    		"(SELECT conv.PAY_SCALE_ORDER FROM MASTER_V1.MS_PAY_CONVERSION conv, PVU.T_EMP_EVENTS tee WHERE \r\n" + 
    		"tee.EMP_ID = :employeeId AND tee.EVENT_ID = 1 AND (tee.PAY_SCALE = conv.PAY_SCAL_ID OR  tee.EMP_GRD_PAY = conv.GRADE_PAY_ID   OR TEE.EMP_PAY_LEVEL = CONV.PAY_LVL_ID ) AND conv.DEPT_ID = :deptId AND TEE.ACTIVE_STATUS = 1\r\n"
    		+ "AND tee.PAY_COMMISSION = (SELECT JOIN_PAY_COMM_ID FROM PVU.T_EMP_JOIN_PAY_DTL WHERE EMP_ID = :employeeId))\r\n" + 
    		"AND \r\n" + 
    		"(SELECT conv.PAY_SCALE_ORDER FROM MASTER_V1.MS_PAY_CONVERSION conv, PVU.T_EMP_EVENTS tee WHERE \r\n" + 
    		"tee.EMP_ID = :employeeId AND tee.EVENT_ID NOT IN (5,7,8) AND tee.EVNT_DATE <= TO_DATE( :effectiveDate,'yyyy-mm-dd')\r\n" + 
    		"AND (TEE.EMP_PAY_LEVEL = CONV.PAY_LVL_ID OR tee.PAY_SCALE = conv.PAY_SCAL_ID OR  tee.EMP_GRD_PAY = conv.GRADE_PAY_ID)  AND conv.DEPT_ID = :deptId AND TEE.ACTIVE_STATUS = 1 ORDER BY tee.UPDATED_DATE desc LIMIT 1)\r\n" + 
    		"ORDER BY PAY_SCALE_ORDER ASC ",nativeQuery = true)
    List<Long> getPayLevelByDepartmentCategoryForEmp(@Param("deptId") Long deptId, @Param("employeeId") Long employeeId, @Param("effectiveDate") String effectiveDate);
    
    @Query(value = "SELECT distinct PAY_LVL_ID,PAY_LVL_DISP_VAL FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus and PAY_LVL_ID  is not NULL and GRADE_PAY_DISP_VAL between 1300 and 4400 order by PAY_LVL_ID asc  ",nativeQuery = true)
    List<Object[]> getPayLevelByDepartmentCategoryByRange(Long departmentCategoryId, int activeStatus);
}
