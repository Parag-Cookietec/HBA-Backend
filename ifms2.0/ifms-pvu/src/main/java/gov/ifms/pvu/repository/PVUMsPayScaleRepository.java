package gov.ifms.pvu.repository;

import java.util.List;

import gov.ifms.edp.dto.IdNameDto;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUMsPayScaleEntity;

/**
 * The Class PVUMsPayScaleController.
 */

@Repository
@Transactional
public interface PVUMsPayScaleRepository extends JpaRepository<PVUMsPayScaleEntity, Long>,
        JpaSpecificationExecutor<PVUMsPayScaleEntity> {

    /**
     * Find all by pay commission in.
     *
     * @param asList the as list
     * @return the list
     */
    List<PVUMsPayScaleEntity> findAllByPayCommissionIn(List<Integer> asList);

    /**
     * Gets the pay scale id by department category.
     *
     * @param departmentCategoryId the department category id
     * @param activeStatus the active status
     * @return the pay scale id by department category
     */
    @Query(value = "SELECT PAY_SCAL_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus ",nativeQuery = true)
    List<Long> getPayScaleIdByDepartmentCategory(Long departmentCategoryId, int activeStatus);

    /**
     * Find all by pay scale id in.
     *
     * @param payScalesIds the pay scales ids
     * @return the list
     */
    List<PVUMsPayScaleEntity> findAllByPayScaleIdIn(List<Long> payScalesIds);

    @Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.payScaleId,e.payScaleDispVal) from PVUMsPayScaleEntity e where e.payScaleId = :id")
    IdNameDto getOnlyIdAndName(@Param("id") Long id);
    
    
    @Query(value = "SELECT PAY_SCAL_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus AND FIX_PAY_VALUE=:fixPayValue ",nativeQuery = true)
    List<Long> getPayScaleIdByDepartmentCategoryAndFixPay(Long departmentCategoryId, int activeStatus, Long fixPayValue);
    
    @Query(value = "SELECT  DISTINCT nvl(mpc.ENTRY_PAY_6TH,0),mpc.GRADE_PAY_ID, mpc.PAY_BAND_ID , mpc.DEPT_ID  FROM MASTER_V1.MS_PAY_CONVERSION mpc  WHERE mpc.DEPT_ID =:deptId AND PAY_BAND_ID =:payBandId AND GRADE_PAY_ID  IN (:gradePayIds)  ",nativeQuery = true)
    List<Object[]> getEnteryPay(Long deptId,Long payBandId,List<Long> gradePayIds);
    
    @Query(value = "SELECT PAY_SCAL_ID FROM MASTER_V1.MS_PAY_CONVERSION mpc WHERE mpc.DEPT_ID =:departmentCategoryId AND ACTIVE_STATUS  =:activeStatus  and GRADE_PAY_DISP_VAL between 1300 and 4400",nativeQuery = true)
    List<Long> getPayScaleIdByDepartmentCategoryByRange(Long departmentCategoryId, int activeStatus);
    
    List<PVUMsPayScaleEntity> findAllByPayScaleIdIn(List<Long> payScalesIds,Sort sort);
    
    @Query(value = "SELECT  DISTINCT nvl(mpc.ENTRY_PAY_6TH,0),mpc.GRADE_PAY_ID, mpc.PAY_BAND_ID , mpc.DEPT_ID  FROM MASTER_V1.MS_PAY_CONVERSION mpc  WHERE mpc.DEPT_ID =:deptId AND PAY_BAND_ID =:payBandId AND GRADE_PAY_ID  IN (:gradePayIds) and PAY_LVL_ID=:payLvl ",nativeQuery = true)
    List<Object[]> getEnteryPayAndPayLvl(Long deptId,Long payBandId,List<Long> gradePayIds,Long payLvl);

   
    
}
